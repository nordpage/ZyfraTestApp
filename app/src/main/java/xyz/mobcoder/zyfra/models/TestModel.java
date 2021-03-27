package xyz.mobcoder.zyfra.models;

import java.io.Serializable;

public class TestModel implements Serializable {
    private String title;
    private int capacity;
    private boolean packed;

    public TestModel(String title, int capacity, boolean packed) {
        this.title = title;
        this.capacity = capacity;
        this.packed = packed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isPacked() {
        return packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "title='" + title + '\'' +
                ", capacity=" + capacity +
                ", packed=" + packed +
                '}';
    }
}
