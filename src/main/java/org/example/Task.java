package org.example;

import java.util.ArrayList;

public class Task implements ProjectItem {
    private String name;
    private ArrayList projectItems = new ArrayList();
    private Contact owner;
    private double timeRequired;

    public Task() { }
    public Task(String name, Contact owner, double timeRequired) {
        this.name = name;
        this.owner = owner;
        this.timeRequired = timeRequired;
    }

    public String getName() {
        return name;
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }

    public Contact getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTimeRequired() {
        return timeRequired;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public void setTimeRequired(double timeRequired) {
        this.timeRequired = timeRequired;
    }

    public void addProjectItem(ProjectItem element) {
        if(!projectItems.contains(element)) {
            projectItems.add(element);
        }
    }

    public void removeProjectItem(ProjectItem element) {
        projectItems.remove(element);
    }

    @Override
    public void accept(ProjectVisitor v) {
        v.visitTask(this);
    }
}
