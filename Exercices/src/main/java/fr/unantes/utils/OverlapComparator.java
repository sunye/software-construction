package fr.unantes.utils;

import fr.unantes.agenda.TimeSlot;

import java.util.Comparator;
/**
 * Created on 22/02/2018.
 *
 * @author sunye.
 */
public class OverlapComparator implements Comparator<TimeSlot> {

    @Override
    public int compare(TimeSlot one, TimeSlot other) {
        if (one.overlapsWith(other)) {
            return 0;
        } else {
            return one.start().compareTo(other.start());
        }
    }
}