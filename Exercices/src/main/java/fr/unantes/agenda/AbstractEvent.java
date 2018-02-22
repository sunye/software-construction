package fr.unantes.agenda;

/**
 * Created on 20/02/2018.
 *
 * @author sunye.
 */
public class AbstractEvent {
    protected String id;
    protected TimeSlot slot;

    public AbstractEvent(String id, TimeSlot slot) {
        this.id = id;
        this.slot = slot;
    }

    public TimeSlot slot() {
        return slot;
    }
}
