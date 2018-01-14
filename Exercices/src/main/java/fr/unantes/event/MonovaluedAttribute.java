package fr.unantes.event;

/**
 * Created on 13/01/2018.
 *
 * @author AtlanMod team.
 */
public class MonovaluedAttribute<T> {
    private boolean assigned = false;
    private T value;

    public void set(T newValue) {
        value = newValue;
        if (!assigned) {
            assigned = true;}
    }

    public T get() {
        return value;
    }

    public void clear() {
        if (assigned) {
            value = null;
            assigned = false;
        }
    }

    public boolean isSet() {
        return assigned;
    }
}
