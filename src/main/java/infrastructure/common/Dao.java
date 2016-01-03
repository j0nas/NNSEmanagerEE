package infrastructure.common;

import java.util.List;

public interface Dao<T extends ApplicationEntity> {
    T persist(T item);

    T findById(int id);

    List<T> getAll();

    boolean delete(int id);
}
