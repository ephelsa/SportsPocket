package com.condorlabstest.ephelsa.sportinformation.Model.Data;

public class LeagueModel {

    // TAG to pass data.
    public static final String ID_LEAGUE = "league";

    private String id;
    private String badge;
    private String name;

    public LeagueModel(String id, String badge, String name) {
        this.id = id;
        this.badge = badge;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
