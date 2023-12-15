package br.com.infnet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private String height;
    private String weight;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

}
