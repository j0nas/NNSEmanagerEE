package controller;

import dto.Invoice;
import infrastructure.invoice.InvoiceDao;
import infrastructure.tenant.TenantDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Model
public class InvoiceController {
    private Invoice item;
    private int itemId;

    @Inject
    private InvoiceDao dao;

    @Inject
    private TenantDao tenantDao;

    private int tenantId;
    private Date dueDate;
    private Date billingDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @PostConstruct
    void init() {
        setItem(new Invoice());
    }

    public void initItem() {
        item = getDao().findById(itemId);
    }

    public TenantDao getTenantDao() {
        return tenantDao;
    }

    public Invoice persist() {
        item.setBilledTenant(getTenantDao().findById(getTenantId()));
        item.setDueDate(dueDate);
        item.setBillingDate(billingDate);
        return getDao().persist(item);
    }

    public boolean delete(int id) {
        return getDao().delete(id);
    }

    public InvoiceDao getDao() {
        return dao;
    }

    public Invoice getItem() {
        return item;
    }

    public void setItem(Invoice item) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public List<Invoice> getAll() {
        return dao.getAll();
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
}
