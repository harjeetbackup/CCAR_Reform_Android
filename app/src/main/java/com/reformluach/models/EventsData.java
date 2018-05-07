package com.reformluach.models;

/**
 * Created by Naveen Mishra on 12/7/2017.
 */
public class EventsData {
    private String name, age, interests;

    public EventsData() {
    }

    public EventsData(String name, String age, String interests) {
        this.name = name;
        this.age = age;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
