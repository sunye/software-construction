package fr.unantes.library;

/**
 * Created on 23/01/2018.
 *
 * @author NaoMod team.
 */
public interface BookState {
    boolean reserve(Reader aReader);
    void deliver();
    void borrow();
    void returnBook();
}
