package dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Room.getAll", query = "SELECT r FROM Room r")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Min(0)
    private int number;

    @NotNull
    @Min(0)
    private float pricePerMonth;

    @OneToOne
    private Tenant primaryLeaser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(float pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public Tenant getPrimaryLeaser() {
        return primaryLeaser;
    }

    public void setPrimaryLeaser(Tenant primaryLeaser) {
        this.primaryLeaser = primaryLeaser;
    }
}
