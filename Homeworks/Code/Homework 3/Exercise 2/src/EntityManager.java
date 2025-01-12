// Datei: EntityManager.java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EntityManager<T> {
    private List<T> entities;

    public EntityManager() {
        this.entities = new ArrayList<>();
    }

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public T getEntityBy(Predicate<T> predicate) {
        return entities.stream().filter(predicate).findFirst().orElse(null);
    }

    public List<T> getAllEntities() {
        return entities;
    }
}
