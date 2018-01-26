package fr.unantes.library;

import org.apache.commons.lang3.Validate;

import java.util.*;

/**
 * Created on 25/01/2018.
 *
 * @author sunye.
 */
public class Library {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private List<Borrowing> borrowings = new ArrayList<>();

    public boolean borrow(Integer memberId, Integer bookId) {
        Member member;
        if (!books.containsKey(bookId)) {return false;}

        Book book = books.get(bookId);
        if (!book.isAvailable()) { return false;}
        if (!members.containsKey(memberId)) {
            member = this.registerMember(memberId);
        } else {
            member = members.get(memberId);
            if (member.isMaxQuotaExceed()) {
                return false;
            }
        }
        Borrowing borrowing = new Borrowing(member, book);
        this.borrowings.add(borrowing);
        return true;
    }

    public Member registerMember(Integer newMemberId) {
        return new Member();
    }

    public void returnBook(Integer bookId) {
        Validate.isTrue(bookId > 0);

        Borrowing borrowing = borrowings.stream()
                .filter(each -> each.book().id() == bookId)
                .findFirst()
                .get();
        borrowing.book().returnBook();
        borrowing.member().borrowed().remove(borrowing.book());
    }

    public void reserve(String title, Integer memberId, Calendar date) {

    }

    public void createMember(Integer id, String name) {}
    public void createBook(Integer id, String title) {}

    public List<Reservation> reservations () {
        return new ArrayList<>();
    }
}
