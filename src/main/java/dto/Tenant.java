package dto;

import infrastructure.common.ApplicationEntity;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Tenant.getAll", query = "SELECT t FROM Tenant t")
public class Tenant implements ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private int ssn;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private int phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
