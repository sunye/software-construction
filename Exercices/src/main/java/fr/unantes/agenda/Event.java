package fr.unantes.agenda;

/**
 * Created on 20/02/2018.
 *
 * @author sunye.
 */
public interface Event {
    boolean conflictsWith(Event other);
    boolean conflictsWithSingleEvent(SingleEvent other);
    boolean conflictsWithRecurrentEvent(RecurrentEvent other);
}
