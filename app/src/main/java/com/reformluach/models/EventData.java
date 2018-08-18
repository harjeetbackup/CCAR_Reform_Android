package com.reformluach.models;

public class EventData {

  String category ="parashat";
  ParshiyotEventModel parshiyotEventModel;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ParshiyotEventModel getParshiyotEventModel() {
        return parshiyotEventModel;
    }

    public void setParshiyotEventModel(ParshiyotEventModel parshiyotEventModel) {
        this.parshiyotEventModel = parshiyotEventModel;
    }
}
