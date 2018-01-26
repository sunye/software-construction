package fr.unantes.bidirectional;

import fr.unantes.unidirectional.collections.HTMLPage;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class FileCollection implements Collection<File> {

    private Collection<File> pages;

    public FileCollection(Collection<File> list) {
        this.pages = list;
    }

    public int size() {
        return pages.size();
    }

    public boolean isEmpty() {
        return pages.isEmpty();
    }

    public boolean contains(Object o) {
        return pages.contains(o);
    }

    public Iterator<File> iterator() {
        // TODO: Implement the Iterator!
        return pages.iterator();
    }

    public Object[] toArray() {
        return pages.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return pages.toArray(a);
    }

    public boolean add(File file) {
        return pages.add(file);
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return pages.containsAll(c);
    }

    public boolean addAll(Collection<? extends File> c) {
        return pages.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends File> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return pages.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return pages.retainAll(c);
    }

    public void clear() {
        pages.clear();
    }

    public File get(int index) {
        return get(index);
    }

    public File set(int index, HTMLPage element) {
        return set(index, element);
    }

    public boolean remove(int index) {
        return pages.remove(index);
    }


    public int lastIndexOf(Object o) {
        return lastIndexOf(o);
    }

}
