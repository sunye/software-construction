package fr.unantes.unidirectional.cursors;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public interface Cursor<T> {
    boolean valid();
    void next();
    void remove();
    void insert(T t);
}
