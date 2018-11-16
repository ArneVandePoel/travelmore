package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.GebruikersType;
import be.thomasmore.travelmore.service.GebruikerService;
import be.thomasmore.travelmore.service.GebruikersTypeService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

@ManagedBean
@SessionScoped
public class GebruikerController {

    @Inject
    private GebruikerService gebruikerService;

    @Inject
    private GebruikersTypeService gebruikersTypeService;

    //gebruiker om aan te maken
    private Gebruiker ingelogdeGebruiker = new Gebruiker();
    private Gebruiker newGebruiker = new Gebruiker();

    //variabelen voor passwoord encryptie
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    //string voor melding pagina
    private String melding;

    //getters, setters
    public String getMelding(){
        return this.melding;
    }
    public Gebruiker getIngelogdeGebruiker() {return this.ingelogdeGebruiker;}

    //inloggen
    public String login(String email, String wachtwoord){
        Gebruiker gebruiker = this.gebruikerService.findGebruikerByEmail(email);

        if(gebruiker != null){
            String salt = gebruiker.getSalt();
            System.out.println("Gevonden salt: " + salt);

            //wachtwoord checken
            String passwordToCheck = encryptPassword(wachtwoord, salt);
            String password = gebruiker.getWachtwoord();

            System.out.println(passwordToCheck);
            System.out.println(password);

            if(passwordToCheck.equalsIgnoreCase(password)){
                this.ingelogdeGebruiker = gebruiker;
                this.melding = "U bent ingelogd als: " + ingelogdeGebruiker.getVoornaam() + " " + ingelogdeGebruiker.getNaam();
            }else{
                this.melding = "Fout wachtwoord!";
            }
        }else{
            this.melding = "Deze gebruiker bestaat niet!";
        }

        System.out.println(this.melding);
        return "melding";
    }

    //gebruiker aanmaken
    public String maakGebruiker(String email, String wachtwoord, String naam, String voornaam, String adres, String postcode, String gemeente, String land, String telefoonNummer){
        Gebruiker testGebruiker = this.gebruikerService.findGebruikerByEmail(email);

        if(testGebruiker != null){
            melding = "Deze gebruiker bestaat al!";
        }else{
            newGebruiker.setEmail(email);
            newGebruiker.setNaam(naam);
            newGebruiker.setVoornaam(voornaam);
            newGebruiker.setAdres(adres);
            newGebruiker.setPostcode(postcode);
            newGebruiker.setGemeente(gemeente);
            newGebruiker.setLand(land);
            newGebruiker.setTelefoonNummer(telefoonNummer);

            GebruikersType type = this.gebruikersTypeService.findGebruikersTypeByID(2);
            newGebruiker.setGebruikersType(type);

            String salt = getSalt(30);
            String encryptedWachtwoord = encryptPassword(wachtwoord, salt);
            newGebruiker.setWachtwoord(encryptedWachtwoord);
            newGebruiker.setSalt(salt);
            this.gebruikerService.insert(newGebruiker);

            melding = "Gebruiker " + newGebruiker.getEmail() + " is aangemaakt";
        }

        System.out.println(melding);
        return "melding";
    }

    //Passwoord encypteren
    private String encryptPassword(String passwordToHash, String salt) {
        byte[] securePassword = hash(passwordToHash.toCharArray(), salt.getBytes());
        String wachtwoord = Base64.getEncoder().encodeToString(securePassword);

        System.out.println("aangemaakte salt: " + salt);
        return wachtwoord;
    }

    //encyptie
    private static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    //Add salt
    private static String getSalt(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
