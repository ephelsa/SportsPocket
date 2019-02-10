package com.condorlabstest.ephelsa.sportinformation.Model.Data;

public class EventModel {

    private String event;
    private String date;
    private String time;

    public EventModel(String event, String date, String time) {
        this.event = event;
        this.date = date;
        this.time = time;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
