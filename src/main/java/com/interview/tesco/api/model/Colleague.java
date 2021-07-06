package com.interview.tesco.api.model;

import java.util.ArrayList;
import java.util.List;

public class Colleague implements Comparable<Colleague> {

    private String name;
    private List<Department> departmentList = new ArrayList<Department>();

    public Colleague(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void addDepartmentList(Department department) {
        this.departmentList.add(department);
    }

    @Override
    public int compareTo(Colleague o) {
        return this.name.compareTo(o.name);
    }
}
