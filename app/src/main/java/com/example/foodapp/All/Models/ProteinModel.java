package com.example.foodapp.All.Models;

public class ProteinModel {

    String Name,Id;

    public ProteinModel(String name, String id) {
        Name = name;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
