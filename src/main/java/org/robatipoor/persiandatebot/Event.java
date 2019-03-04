package org.robatipoor.persiandatebot;

import java.util.Objects;

/**
 * Event
 */
public class Event {
    private boolean isHoliday;
    private String event;

    public Event() {
    }

    public Event(boolean isHoliday, String event) {
        this.isHoliday = isHoliday;
        this.event = event;
    }

    public boolean isIsHoliday() {
        return this.isHoliday;
    }

    public boolean getIsHoliday() {
        return this.isHoliday;
    }

    public void setIsHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Event isHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
        return this;
    }

    public Event event(String event) {
        this.event = event;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return isHoliday == event.isHoliday && Objects.equals(event, event.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHoliday, event);
    }

    @Override
    public String toString() {
        return "{" + " isHoliday='" + isIsHoliday() + "'" + ", event='" + getEvent() + "'" + "}";
    }
}