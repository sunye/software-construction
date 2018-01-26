package fr.unantes.library;

import org.junit.jupiter.api.Assertions;

import java.util.Calendar;

/**
 * Created on 25/01/2018.
 *
 * @author sunye.
 */
class LibraryTest {

    private Library lib = new Library();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        lib.createMember(42, "Philippe");
        lib.createBook(1, "Baudolino");
    }

    @org.junit.jupiter.api.Test
    void reserve() {
        Calendar date = Calendar.getInstance();
        date.set(2017, 2, 1);
        lib.reserve("Baudolino", 42, date);

        Assertions.assertTrue(lib.reservations()
                                 .stream()
                                 .anyMatch(each -> each.member().id() == 42 &&
                                                   each.book().title().equals("Baudolino") &&
                                                   each.date().equals(date))
        );
    }
}