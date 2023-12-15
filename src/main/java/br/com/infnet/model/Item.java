package br.com.infnet.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
    private int id;
    private String name;
    private int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
