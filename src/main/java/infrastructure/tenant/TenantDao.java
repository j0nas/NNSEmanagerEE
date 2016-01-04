package infrastructure.tenant;

import dto.Tenant;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TenantDao {
    @PersistenceContext(unitName = "NNSE")
    private EntityManager entityManager;

    public TenantDao() {
    }

    public TenantDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Tenant persist(Tenant item) {
        entityManager.persist(item);
        return item;
    }

    public Tenant findById(int id) {
        return entityManager.find(Tenant.class, id);
    }

    public List<Tenant> getAll() {
        return entityManager.createNamedQuery("Tenant.getAll", Tenant.class).getResultList();
    }

    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return entityManager.find(Tenant.class, id) == null;
    }
}
