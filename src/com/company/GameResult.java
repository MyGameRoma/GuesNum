package com.company;

public class GameResult {
    private String name;
    private int trisCount;
    private Long time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrisCount() {
        return trisCount;
    }

    public void setTrisCount(int trisCount) {
        this.trisCount = trisCount;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
