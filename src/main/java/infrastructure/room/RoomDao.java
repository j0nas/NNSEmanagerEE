package infrastructure.room;

import dto.Room;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoomDao {
    @PersistenceContext(unitName = "NNSE")
    private EntityManager entityManager;

    public RoomDao() {
    }

    public RoomDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Room persist(Room item) {
        entityManager.persist(item);
        return item;
    }

    public Room findById(int id) {
        return entityManager.find(Room.class, id);
    }

    public List<Room> getAll() {
        return entityManager.createNamedQuery("Room.getAll", Room.class).getResultList();
    }

    public boolean delete(int id) {
        entityManager.remove(findById(id));
        return entityManager.find(Room.class, id) == null;
    }
}
