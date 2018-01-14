package fr.unantes.event;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 13/01/2018.
 *
 * @author AtlanMod team.
 */
public class EventBis {

    private static int nextId = 0;

    private final ReadOnlyMonovaluedAttribute<Integer> id = new ReadOnlyMonovaluedAttribute<>(nextId++);
    private final MonovaluedAttribute<String> name = new MonovaluedAttribute<String>();
    private final MonovaluedAttribute<String> location = new MonovaluedAttribute<String>();
    private final MonovaluedAttribute<Date>  start = new MonovaluedAttribute<Date>();
    private final MonovaluedAttribute<Date> end = new MonovaluedAttribute<Date>();
    private final MultivaluedAttribute<Integer> alarm = new MultivaluedAttribute<>(5);

    public ReadOnlyMonovaluedAttribute<Integer> id() {
        return id;
    }

    public MonovaluedAttribute<String> name() {
        return name;
    }

    public MonovaluedAttribute<String> location() {
        return location;
    }

    protected MonovaluedAttribute<Date> start() {
        return start;
    }

    protected MonovaluedAttribute<Date> end() {
        return end;
    }

    public MultivaluedAttribute<Integer> alarm() {
        return alarm;
    }
}
