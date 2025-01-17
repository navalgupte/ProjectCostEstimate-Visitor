package org.example;

public class ProjectCostVisitor implements ProjectVisitor {
    private double totalCost;
    private double hourlyRate;

    public double getTotalCost() {
        return totalCost;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double rate) {
        hourlyRate = rate;
    }

    public void resetTotalCost() {
        totalCost = 0.0;
    }

    public void visitDependentTask(DependentTask p) {
        double taskCost = p.getTimeRequired() * hourlyRate;
        taskCost *= p.getDependencyWeightingFactor();
        totalCost += taskCost;
    }

    public void visitDeliverable(Deliverable p) {
        totalCost += p.getMaterialCost() + p.getProductionCost();
    }

    public void visitTask(Task p) {
        totalCost += p.getTimeRequired() * hourlyRate;
    }

    public void visitProject(Project p) {

    }
}
