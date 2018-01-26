package fr.unantes.unidirectional.cursors;


import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class FileCursor implements Cursor<File>, File {

    Collection<File> files;
    Optional<File> current;

    public FileCursor(Collection<File> aCollection) {
        files = aCollection;
    }

    @Override
    public Integer getSize() {
        if (current.isPresent()) {
            return current.get().getSize();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void setSize(Integer aSize) {
        if(!current.isPresent()) {
            throw new IllegalStateException();
        }
        current.get().setSize(aSize);
    }

    @Override
    public String getName() {
        if (current.isPresent()) {
            return current.get().getName();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void setName(String aName) {
        if(!current.isPresent()) {
            throw new IllegalStateException();
        }
        current.get().setName(aName);
    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public void next() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void insert(File file) {

    }
}
