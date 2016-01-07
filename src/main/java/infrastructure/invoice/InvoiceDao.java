package infrastructure.invoice;

import dto.Invoice;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class InvoiceDao {
    @PersistenceContext(unitName = "NNSE")
    private EntityManager entityManager;

    public InvoiceDao() {
    }

    public InvoiceDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Invoice persist(Invoice item) {
        entityManager.persist(item);
        return item;
    }

    public Invoice findById(int id) {
        return entityManager.find(Invoice.class, id);
    }

    public List<Invoice> getAll() {
        return entityManager.createNamedQuery("Invoice.getAll", Invoice.class).getResultList();
    }

    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return entityManager.find(Invoice.class, id) == null;
    }
}
