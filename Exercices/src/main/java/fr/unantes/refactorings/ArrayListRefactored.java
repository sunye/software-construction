package fr.unantes.refactorings;

public class ArrayListRefactored {
    public static final int GROWTH_INCREMENT = 10;
    private Object[] elements = new Object[10];
    private boolean readOnly;
    private int size = 0;

    public void add(Object child) {
        if (readOnly) {
            return;
        }
        if (atCapacity()) {
            grow();
        }
        addElement(child);
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private boolean atCapacity() {
        return size + 1 > elements.length;
    }

    private void addElement(Object child) {
        elements[size] = child;
        size++;
    }

    public void set(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean get() {
        return readOnly;
    }
}
