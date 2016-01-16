package controller;

import dto.Tenant;
import infrastructure.tenant.TenantDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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

    public void persist() {
        getDao().persist(item);
        FacesContext.getCurrentInstance().addMessage("persistSuccess",
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Suksess", "Lagring av leietaker vellykket."));
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

    public List<Tenant> getAll() {
        return dao.getAll();
    }

    public List<SelectItem> getTenants() {
        return dao.getAll().stream().map(tenant -> new SelectItem(tenant.getId(),
                tenant.getFirstName() + " " + tenant.getLastName())).collect(Collectors.toList());
    }
}
