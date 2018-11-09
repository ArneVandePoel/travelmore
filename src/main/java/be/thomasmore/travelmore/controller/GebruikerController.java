package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.domain.GebruikersType;
import be.thomasmore.travelmore.service.GebruikerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@ManagedBean
@ViewScoped
public class GebruikerController {

    @Inject
    private GebruikerService gebruikerService;

    //gebruiker om aan te maken
    private Gebruiker ingelogdeGebruiker = new Gebruiker();
    private Gebruiker newGebruiker = new Gebruiker();

    //inloggen
    public void login(String email, String wachtwoord){
        Gebruiker test = this.gebruikerService.findGebruikerByEmail(email);
        String saltString = test.getSalt();
        byte[] salt = saltString.getBytes();

        //wachtwoord checken
        String passwordToCheck = get_SHA_512_SecurePassword(wachtwoord, salt);
        String password = get_SHA_512_SecurePassword(test.getWachtwoord(), salt);

        if(passwordToCheck == password){
            ingelogdeGebruiker = test;
            System.out.println("successfull login!");
        }
    }

    //gebruiker aanmaken
    public void maakGebruiker(String email, String wachtwoord, String naam, String voornaam, String adres, String postcode, String gemeente, String land, String telefoonNummer) throws NoSuchAlgorithmException{
        newGebruiker.setEmail(email);
        newGebruiker.setNaam(naam);
        newGebruiker.setVoornaam(voornaam);
        newGebruiker.setAdres(adres);
        newGebruiker.setPostcode(postcode);
        newGebruiker.setGemeente(gemeente);
        newGebruiker.setLand(land);
        newGebruiker.setTelefoonNummer(telefoonNummer);
/*
        GebruikersType type = new GebruikersType();
        type.setType("klant");
        newGebruiker.setGebruikersType(type);*/

        encryptPassword(wachtwoord);
        this.gebruikerService.insert(newGebruiker);
    }

    //Passwoord valideren
    public static void checkPassword(String inputPassword, byte[] salt){
        String passwordToCheck = get_SHA_512_SecurePassword(inputPassword, salt);
    }

    //Passwoord encypteren
    public void encryptPassword(String passwordToHash) throws NoSuchAlgorithmException {
        byte[] salt = getSalt();
        String securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
        String saltString = new String(salt);

        newGebruiker.setWachtwoord(securePassword);
        newGebruiker.setSalt(saltString);
        System.out.println(saltString);
    }

    //SHA encyptie
    private static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
}
