package controller;

import infrastructure.common.ApplicationEntity;
import infrastructure.common.Dao;

import java.util.List;

public abstract class Controller<T extends ApplicationEntity> {
    private T item;
    private int itemId;

    public abstract Dao<T> getDao();

    abstract void init();

    public void initItem() {
        item = getDao().findById(itemId);
    }

    public T persist() {
        return getDao().persist(item);
    }

    public boolean delete(int id) {
        return getDao().delete(id);
    }

    public List<T> getAll() {
        return getDao().getAll();
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
