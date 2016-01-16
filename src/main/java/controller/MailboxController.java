package controller;

import dto.Mailbox;
import dto.Tenant;
import infrastructure.mailbox.MailboxDao;
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
public class MailboxController {
    private Mailbox item;
    private int itemId;
    @Inject
    private MailboxDao dao;
    @Inject
    private TenantDao tenantDao;
    private int primaryTenantId;

    @PostConstruct
    void init() {
        setItem(new Mailbox());
    }

    public void initItem() {
        item = getDao().findById(itemId);
    }

    public void persist() {
        final Tenant tenant = tenantDao.findById(primaryTenantId);
        item.setPrimaryLeaser(tenant);
        getDao().persist(item);

        FacesContext.getCurrentInstance().addMessage("persistSuccess",
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Suksess", "Lagring av postboks vellykket."));
    }

    public boolean delete(int id) {
        return getDao().delete(id);
    }

    public MailboxDao getDao() {
        return dao;
    }

    public Mailbox getItem() {
        return item;
    }

    public void setItem(Mailbox item) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public List<Mailbox> getAll() {
        return dao.getAll();
    }

    public List<SelectItem> getRooms() {
        return dao.getAll().stream().map(mailbox ->
                new SelectItem(mailbox.getId(), String.valueOf(mailbox.getNumber()))).collect(Collectors.toList());
    }

    public int getPrimaryTenantId() {
        return primaryTenantId;
    }

    public void setPrimaryTenantId(int primaryTenantId) {
        this.primaryTenantId = primaryTenantId;
    }
}
