package dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Mailbox.getAll", query = "SELECT mb FROM Mailbox mb")
public class Mailbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Min(0)
    private int number;

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

    public Tenant getPrimaryLeaser() {
        return primaryLeaser;
    }

    public void setPrimaryLeaser(Tenant primaryLeaser) {
        this.primaryLeaser = primaryLeaser;
    }
}
