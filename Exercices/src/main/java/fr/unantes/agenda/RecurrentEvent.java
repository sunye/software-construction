package fr.unantes.agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Created on 20/02/2018.
 *
 * @author sunye.
 */
public class RecurrentEvent extends AbstractEvent implements Event {

    private Frequency frequency;
    private LocalDate reccurrenceEnd;

    public RecurrentEvent(String id, TimeSlot slot, Frequency frequency, LocalDate reccurrenceEnd) {
        super(id, slot);
        this.frequency = frequency;
        this.reccurrenceEnd = reccurrenceEnd;
    }

    public boolean conflictsWith(Event other) {
        return other.conflictsWithRecurrentEvent(this);
    }

    @Override
    public boolean conflictsWithSingleEvent(SingleEvent other) {

        return false;
    }

    @Override
    public boolean conflictsWithRecurrentEvent(RecurrentEvent other) {
        return false;
    }


    public Collection<TimeSlot> occurrences() {
        Collection<TimeSlot> calculatedOccurrences = new LinkedList<>();
        for (TimeSlot i = this.slot(); i.isBeforeDate(reccurrenceEnd) ; i = i.add(1, frequency.unit())) {
            calculatedOccurrences.add(i);
        }

        return calculatedOccurrences;
    }

    public static void main(String[] args) {
        LocalDateTime begin = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        LocalDate end = LocalDate.now();

        RecurrentEvent re = new RecurrentEvent("id1", new TimeSlot(begin, Duration.ofHours(1)), Frequency.DAILY, end);

        re.occurrences().stream().forEach(System.out::println);

    }

}
