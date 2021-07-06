package com.interview.tesco.api.model;

public enum Department {
    BAKERY("BAKERY", 8, 10), CHECKOUT("CHECKOUT", 9, 12), CHECKOUT1("CHECKOUT", 12, 13),  DAIRY("DAIRY", 15, 19);

    private String departmentName;
    private int startTime;
    private int endTime;

    Department(String departmentName, int startTime, int endTime) {
        this.departmentName = departmentName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
