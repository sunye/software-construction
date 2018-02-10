package fr.unantes.time;


public class Interval<T extends Comparable> {

    private final T begin;
    private final T end;

    protected Interval(T begin, T end) {
        this.begin = begin;
        this.end = end;
    }

    public boolean includes(T i) {
        return i.compareTo(begin) >= 0 && i.compareTo(end) <= 0;
    }
}

