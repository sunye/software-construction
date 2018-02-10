package fr.unantes.library;

/**
 * Created on 19/01/2018.
 *
 * @author NaoMod team.
 */
public class SimpleBook implements Book {

    private State state = State.ordered;

    public boolean reserve(Reader aReader) {
        if (state == State.available) throw new IllegalStateException();
        // TODO

        return false;
    }

    public void deliver() {
        if (state != State.ordered) throw new IllegalStateException();

        // TODO

        if (state != State.available && state != State.reserved) throw new IllegalStateException();
    }

    public void borrow() {
        if (state != State.available && state != State.reserved) throw new IllegalStateException();

        // TODO

        if (state != State.borrowed) throw new IllegalStateException();

    }

    public void returnBook() {
        if (state != State.borrowed) throw new IllegalStateException();

        // TODO

        if(state != State.available && state != State.reserved) throw new IllegalStateException();
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public Integer id() {
        return null;
    }

    @Override
    public String title() {
        return null;
    }
}
