package controller;

import dto.Tenant;
import tenant.tenant.TenantDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class TenantController {
    private Tenant item;
    private int itemId;

    @Inject
    private TenantDao dao;

    @PostConstruct
    void init() {
        setItem(new Tenant());
    }

    public void initItem() {
        item = getDao().findById(itemId);
    }

    public Tenant persist() {
        return getDao().persist(item);
    }

    public boolean delete(int id) {
        return getDao().delete(id);
    }

    public TenantDao getDao() {
        return dao;
    }

    public Tenant getItem() {
        return item;
    }

    public void setItem(Tenant item) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
