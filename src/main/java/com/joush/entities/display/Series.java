package com.joush.entities.display;

import lombok.Data;

import java.util.List;

/**
 * @author Rex Joush
 * @time 2022.12.04
 */
@Data
public class Series {

    private String name;
    private String type;
    private String stack;
    private int[] data;

    public Series() {
    }

    public Series(String name, String type, String stack, int[] data) {
        this.name = name;
        this.type = type;
        this.stack = stack;
        this.data = data;
    }
}
