package fr.unantes.event;

import org.apache.commons.lang3.Validate;

import java.util.*;
import javax.annotation.Nonnull;

/**
 * Created by sunye on 21/11/2016.
 */
public class Event {

    private final Integer id;

    @Nonnull private String name;

    private String location;

    private List<Integer> alarm = new ArrayList<Integer>(5);

    @Nonnull private Date start;

    @Nonnull private Date end;

    public Event(Integer anId, String aName, Date aStart, Date anEnd) {
        Validate.isTrue(end.after(start));

        id = anId;
        name = aName;
        start = aStart;
        end = anEnd;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(@Nonnull String str) {
        name = str;
    }

    public String getLocation() {
        return name;
    }

    public void setLocation(String str) {
        name = str;
    }

    protected Date getStart() {
        return start;
    }

    protected void setStart(@Nonnull Date d) {
        start = d;
    }

    protected Date getEnd() {
        return end;
    }

    protected void setEnd(@Nonnull Date d) {
        end = d;
    }

    public boolean addAlarm(Integer i) {
        return this.alarm.add(i);
    }

    public Integer getAlarm(int i) {
        return this.alarm.get(i);
    }

    public Integer removeAlarm(int i) {
        return this.alarm.remove(i);
    }

}

