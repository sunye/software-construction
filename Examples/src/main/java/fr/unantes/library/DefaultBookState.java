package fr.unantes.library;


/**
 * Created on 23/01/2018.
 *
 * @author NaoMod team.
 */
public class DefaultBookState implements BookState {

    @Override
    public boolean reserve(Reader aReader) {
        throw new IllegalStateException();
    }

    @Override
    public void deliver() {
        throw new IllegalStateException();
    }

    @Override
    public void borrow() {
        throw new IllegalStateException();
    }

    @Override
    public void returnBook() {
        throw new IllegalStateException();
    }
}
