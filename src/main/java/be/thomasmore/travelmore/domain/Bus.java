package be.thomasmore.travelmore.domain;

import javax.persistence.*;

@Entity
@Table(name="bus")
public class Bus {

    @Id
    private int busID;
    @ManyToOne
    private BusType busType;

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }
}
