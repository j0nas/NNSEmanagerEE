package controller;

import dto.Room;
import dto.Tenant;
import infrastructure.room.RoomDao;
import infrastructure.tenant.TenantDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Model
public class RoomController {
    private Room item;
    private int itemId;
    @Inject
    private TenantDao tenantDao;
    private int primaryTenantId;
    @Inject
    private RoomDao dao;

    public int getPrimaryTenantId() {
        return primaryTenantId;
    }

    public void setPrimaryTenantId(int primaryTenantId) {
        this.primaryTenantId = primaryTenantId;
    }

    @PostConstruct
    void init() {
        setItem(new Room());
    }

    public void initItem() {
        item = getDao().findById(itemId);
    }

    public Room persist() {
        final Tenant tenant = tenantDao.findById(primaryTenantId);
        item.setPrimaryLeaser(tenant);
        return getDao().persist(item);
    }

    public boolean delete(int id) {
        return getDao().delete(id);
    }

    public RoomDao getDao() {
        return dao;
    }

    public Room getItem() {
        return item;
    }

    public void setItem(Room item) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public List<Room> getAll() {
        return dao.getAll();
    }

    public List<SelectItem> getRooms() {
        return dao.getAll().stream().map(room ->
                new SelectItem(room.getId(), String.valueOf(room.getNumber()))).collect(Collectors.toList());
    }
}
