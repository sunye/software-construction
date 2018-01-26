package fr.unantes.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 25/01/2018.
 *
 * @author sunye.
 */
public class Member {

    public boolean isMaxQuotaExceed() {
        return false;
    }

    public List<Book> borrowed() {
        return new ArrayList<>();
    }

    public Integer id() {
        return  Integer.valueOf(11);
    }
}
