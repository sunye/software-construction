package fr.unantes.agenda;

/**
 * Created on 13/02/2018.
 *
 * @author sunye.
 */
public class Interval<T extends Comparable> {

    private final T begin;
    private final T end;

    protected Interval(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    public T begin() {
        return begin;
    }

    public T end() {
        return end;
    }

    public boolean includes(T value) {
        return value.compareTo(begin) >= 0 && value.compareTo(end) <= 0;
    }

    public boolean overlapsWith(Interval<T> other) {
        return false;
    }
}

