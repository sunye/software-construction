package fr.unantes.event;

/**
 * Created on 13/01/2018.
 *
 * @author AtlanMod team.
 */
public class ReadOnlyMonovaluedAttribute<T> {
    private T value;

    public ReadOnlyMonovaluedAttribute(T newValue) {
        this.value = newValue;
    }

    public void set(T newValue) {
        throw new UnsupportedOperationException();
    }

    public T get() {
        return value;
    }
}
