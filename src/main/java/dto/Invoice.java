package dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NamedQuery(name = "Invoice.getAll", query = "SELECT i FROM Invoice i")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Tenant billedTenant;

    @NotNull
    @Min(0)
    private int amount;

    private Date billingDate;
    @NotNull
    private Date dueDate;

    @NotNull
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tenant getBilledTenant() {
        return billedTenant;
    }

    public void setBilledTenant(Tenant billedTenant) {
        this.billedTenant = billedTenant;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
