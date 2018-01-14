package fr.unantes.event;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created on 13/01/2018.
 *
 * @author AtlanMod team.
 */
public class MultivaluedAttribute<T> {
    private Collection<T> values;
    private int max;

    public MultivaluedAttribute(int i) {
        max = i;
        values = new ArrayList<T>(max);
    }

    public void add(T value) {
        Validate.isTrue(values.size() < max);

        this.values.add(value);
    }

    public void remove(T value) {
        this.values.remove(value);
    }

    public T[] values() {
        return (T[])this.values.toArray();
    }

}
