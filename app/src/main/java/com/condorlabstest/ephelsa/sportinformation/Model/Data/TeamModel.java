package com.condorlabstest.ephelsa.sportinformation.Model.Data;

import java.io.Serializable;

public class TeamModel implements Serializable {

    // TAG to pass data.
    public static final String ID_TEAM = "team";

    private String id;
    private String name;
    private String stadium;
    private String badge;
    private String jersey;
    private String year;
    private String description;
    private String website;
    private String facebook;
    private String twitter;
    private String instagram;


    public TeamModel(String id, String name, String stadium, String badge, String jersey, String year, String description, String website, String facebook, String twitter, String instagram) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.badge = badge;
        this.jersey = jersey;
        this.year = year;
        this.description = description;
        this.website = website;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getJersey() {
        return jersey;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}

