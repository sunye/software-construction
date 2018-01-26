package fr.unantes.unidirectional.collections;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class PageCollection implements Collection<HTMLPage> {

    private Collection<HTMLPage> pages;

    public PageCollection(Collection<HTMLPage> list) {
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

    public Iterator<HTMLPage> iterator() {
        // TODO: Implement the Iterator!
        return pages.iterator();
    }

    public Object[] toArray() {
        return pages.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return pages.toArray(a);
    }

    public boolean add(HTMLPage htmlPage) {
        return pages.add(htmlPage);
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return pages.containsAll(c);
    }

    public boolean addAll(Collection<? extends HTMLPage> c) {
        return pages.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends HTMLPage> c) {
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

    public HTMLPage get(int index) {
        return get(index);
    }

    public HTMLPage set(int index, HTMLPage element) {
        return set(index, element);
    }

    public boolean remove(int index) {
        return pages.remove(index);
    }


    public int lastIndexOf(Object o) {
        return lastIndexOf(o);
    }

}
