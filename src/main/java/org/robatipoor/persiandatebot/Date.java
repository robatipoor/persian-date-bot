package org.robatipoor.persiandatebot;
import java.io.IOException;
import java.util.Objects;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Date
 */
public class Date {

    private Event[] events;
    private boolean isHoliday;
    private String date;
    private String gdate;

    public Date() {
    }

    public Date(Event[] events, boolean isHoliday, String date, String gdate) {
        this.events = events;
        this.isHoliday = isHoliday;
        this.date = date;
        this.gdate = gdate;
    }

    public static Date getDate(String fmt) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://pholiday.herokuapp.com/" + fmt).build();
        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            Date date = gson.fromJson(response.body().string(), Date.class);
            return date;
        }
    }

    public Event[] getEvents() {
        return this.events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGdate() {
        return this.gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public Date events(Event[] events) {
        this.events = events;
        return this;
    }

    public Date isHoliday(boolean isHoliday) {
        this.isHoliday = isHoliday;
        return this;
    }

    public Date date(String date) {
        this.date = date;
        return this;
    }

    public Date gdate(String gdate) {
        this.gdate = gdate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Date)) {
            return false;
        }
        Date date = (Date) o;
        return Objects.equals(events, date.events) && isHoliday == date.isHoliday && Objects.equals(date, date.date)
                && Objects.equals(gdate, date.gdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(events, isHoliday, date, gdate);
    }

    @Override
    public String toString() {
        return "{" + " events='" + getEvents() + "'" + ", isHoliday='" + isIsHoliday() + "'" + ", date='" + getDate()
                + "'" + ", gdate='" + getGdate() + "'" + "}";
    }

}