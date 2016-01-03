package controller;

import dto.Tenant;
import infrastructure.common.Dao;
import infrastructure.tenant.TenantDao;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class TenantController extends Controller<Tenant> {
    @Inject
    private TenantDao dao;

    @Override
    public Dao<Tenant> getDao() {
        return dao;
    }

    @Override
    @PostConstruct
    void init() {
        setItem(new Tenant());
    }
}
