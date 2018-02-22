package fr.unantes.agenda;

/**
 * Created on 20/02/2018.
 *
 * @author sunye.
 */
public class SingleEvent extends AbstractEvent implements Event {

    public SingleEvent(String id, TimeSlot slot) {
        super(id, slot);
    }

    @Override
    public boolean conflictsWith(Event other) {
        return other.conflictsWithSingleEvent(this);
    }

    @Override
    public boolean conflictsWithSingleEvent(SingleEvent other) {
            return this.slot.overlapsWith(other.slot);
    }

    @Override
    public boolean conflictsWithRecurrentEvent(RecurrentEvent other) {
        return other.conflictsWithSingleEvent(this);
    }

}
