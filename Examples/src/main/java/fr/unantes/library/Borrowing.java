package fr.unantes.library;

/**
 * Created on 25/01/2018.
 *
 * @author sunye.
 */
public class Borrowing {

    private Book book;
    private Member member;

    public Borrowing(Member member, Book book) {
        this.book = book;
        this.member = member;
    }

    public Book book() {
        return book;
    }

    public Member member() {
        return member;
    }
}
