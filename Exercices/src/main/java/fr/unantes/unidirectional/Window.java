package fr.unantes.unidirectional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sunye on 21/11/2016.
 */
public class Window {
    private Reference<Field> widgets = new Reference<Field>(new ArrayList<Field>());

    public Reference<Field> getWidgets() {
        return widgets;
    }
}

class Reference<T> {
    private final Collection<T> references;

    public Reference(Collection<T> coll) {
        this.references = coll;
    }

    public void add(T ref) {
        this.references.add(ref);
    }

    public void remove(T ref) {
        this.references.remove(ref);
    }
}
