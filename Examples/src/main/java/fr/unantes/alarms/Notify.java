package fr.unantes.alarms;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created on 19/01/2018.
 *
 * @author NaoMod team.
 */
public class Notify implements Serializable {

    public final String message;

    public Notify(String message) {
        this.message = message;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notify notify = (Notify) o;
        return Objects.equals(message, notify.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}
