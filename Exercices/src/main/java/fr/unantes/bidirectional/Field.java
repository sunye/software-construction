package fr.unantes.bidirectional;

/**
 * Created by sunye on 21/11/2016.
 */
public class Field {
    private ReferenceToWindow window = new ReferenceToWindow(this);

    public ReferenceToWindow getWindow() {
        return window;
    }
}

class ReferenceToWindow {
    private final Field container;
    private Window window;

    public ReferenceToWindow(Field f) {
        container = f;
    }

    public Window get() {
        return window;
    }

    public void set(Window w) {
        if (window != null) {
            window.getWidgets().basicRemove(container);
        }
        w.getWidgets().basicAdd(container);
        this.basicSet(w);
    }

    public void unSet() {
        if (window != null) {
            window.getWidgets().basicRemove(container);
        }
        this.window = null;
    }

    public void basicSet(Window w) {
        this.window = w;
    }

}