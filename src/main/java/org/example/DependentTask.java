package org.example;

import java.util.ArrayList;

/*
    DependentTask Class - Sub-Class of Task Class. Holds a set of other tasks upon which it depends on.
 */

public class DependentTask extends Task {
    private ArrayList dependentTasks = new ArrayList();
    private double dependencyWeightingFactor;

    public DependentTask() { }
    public DependentTask(String name, Contact owner,
                         double timeRequired, double dependencyWeightingFactor) {
        super(name, owner, timeRequired);
        this.dependencyWeightingFactor = dependencyWeightingFactor;
    }

    public ArrayList getDependentTasks() {
        return dependentTasks;
    }

    public double getDependencyWeightingFactor() {
        return dependencyWeightingFactor;
    }

    public void setDependencyWeightingFactor(double dependencyWeightingFactor) {
        this.dependencyWeightingFactor = dependencyWeightingFactor;
    }

    public void addDependentTask(Task element) {
        if(!dependentTasks.contains(element)) {
           dependentTasks.add(element);
        }
    }

    public void removeDependentTask(Task element) {
        dependentTasks.remove(element);
    }

    @Override
    public void accept(ProjectVisitor v) {
        v.visitDependentTask(this);
    }
}
