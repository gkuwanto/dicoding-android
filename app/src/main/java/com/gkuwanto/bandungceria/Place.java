package com.gkuwanto.bandungceria;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Place implements Serializable {
    private String name;
    private String summary;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
