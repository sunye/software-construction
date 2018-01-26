package fr.unantes.library;


import java.util.Calendar;

/**
 * Created on 25/01/2018.
 *
 * @author sunye.
 */
public class Reservation {

    public Book book() {
        return new SimpleBook();
    }

    public Member member() {
        return new Member();
    }

    public Calendar date() {
        return Calendar.getInstance();
    }
}
