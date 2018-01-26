package fr.unantes.library;

/**
 * Created on 23/01/2018.
 *
 * @author NaoMod team.
 */
public interface Book {
    boolean reserve(Reader aReader);
    void deliver();
    void borrow();
    void returnBook();
    boolean isAvailable();
    Integer id();
    String title();
}
