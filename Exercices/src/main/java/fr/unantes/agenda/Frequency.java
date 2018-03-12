package fr.unantes.agenda;

import java.time.temporal.ChronoUnit;

/**
 * Created on 20/02/2018.
 *
 * @author sunye.
 */
public enum Frequency {

    DAILY(ChronoUnit.DAYS),
    WEEKLY(ChronoUnit.WEEKS),
    MONTHLY(ChronoUnit.MONTHS),
    YEARLY (ChronoUnit.YEARS);

    private ChronoUnit unit;

    Frequency(ChronoUnit unit) {
        this.unit = unit;
    }

    public ChronoUnit unit() {
        return unit;
    }
}
