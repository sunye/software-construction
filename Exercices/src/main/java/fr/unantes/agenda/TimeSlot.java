package fr.unantes.agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created on 21/02/2018.
 *
 * @author sunye.
 */
public class TimeSlot {

    private LocalDateTime start;
    private Duration duration;

    public TimeSlot(LocalDateTime start, Duration duration) {
        this.start = start;
        this.duration = duration;
    }

    public TimeSlot(LocalDateTime begin, LocalDateTime end) {
        this.start = begin;
        this.duration = Duration.between(begin, end);
    }

    public LocalDateTime start() {
        return start;
    }

    public LocalDateTime end() {
        return start.plus(duration);
    }

    public Duration duration() {
        return duration;
    }

    public boolean includes(LocalDateTime dateTime) {
        return dateTime.isAfter(this.start()) && dateTime.isBefore(this.end());
    }

    public boolean overlapsWith(TimeSlot other) {
        return this.includes(other.start()) ||
               this.includes(other.end()) ||
               other.includes(other.start());
    }

    public TimeSlot add(long amountToAdd, ChronoUnit unit) {
        return new TimeSlot(start.plus(amountToAdd,unit), duration);
    }

    public boolean isAfter(TimeSlot other) {
        return this.start().isAfter(other.end());
    }

    public boolean isBefore(TimeSlot other) {
        return other.isAfter(this);
    }

    public boolean isBeforeDate(LocalDate other) {
        return this.start().toLocalDate().isBefore(other);
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
               "start=" + start +
               ", duration=" + duration +
               '}';
    }
}
