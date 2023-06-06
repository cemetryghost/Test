package com.example.onlineauction.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Category {
    private int id;
    private StringProperty name;

    public Category(int id, String name) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
