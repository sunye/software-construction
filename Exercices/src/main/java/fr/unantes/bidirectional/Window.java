package fr.unantes.bidirectional;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunye on 21/11/2016.
 */
public class Window {
    private ReferenceToField widgets = new ReferenceToField(this);

    public ReferenceToField getWidgets() {
        return widgets;
    }
}

class ReferenceToField {
    private final Window container;
    private List<Field> widgets = new ArrayList<Field>();

    public ReferenceToField(Window w) {
        container = w;
    }

    public void add(Field f) {
        f.getWindow().set(container);
    }

    public void basicAdd(Field f) {
        this.widgets.add(f);
    }

    public void remove(Field f) {
        f.getWindow().basicSet(null);
        this.basicRemove(f);
    }

    public void basicRemove(Field f) {
        this.widgets.remove(f);
    }

    public boolean contains(Field f) {
        return widgets.contains(f);
    }
}
