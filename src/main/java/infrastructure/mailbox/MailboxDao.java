package infrastructure.mailbox;

import dto.Mailbox;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MailboxDao {
    @PersistenceContext(unitName = "NNSE")
    private EntityManager entityManager;

    public MailboxDao() {
    }

    public MailboxDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Mailbox persist(Mailbox item) {
        entityManager.persist(item);
        return item;
    }

    public Mailbox findById(int id) {
        return entityManager.find(Mailbox.class, id);
    }

    public List<Mailbox> getAll() {
        return entityManager.createNamedQuery("Mailbox.getAll", Mailbox.class).getResultList();
    }

    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return entityManager.find(Mailbox.class, id) == null;
    }
}
