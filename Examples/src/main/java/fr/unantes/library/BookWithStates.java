package fr.unantes.library;

/**
 * Created on 23/01/2018.
 *
 * @author NaoMod team.
 */
public class BookWithStates implements Book {

    private BookState state = new Ordered();

    @Override
    public boolean reserve(Reader aReader) {
        return state.reserve(aReader);
    }

    @Override
    public void deliver() {
        state.deliver();
    }

    @Override
    public void borrow() {
        state.borrow();
    }

    @Override
    public void returnBook() {
        state.returnBook();
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public Integer id() {
        return null;
    }
}
