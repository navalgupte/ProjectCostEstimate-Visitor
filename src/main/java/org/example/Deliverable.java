package org.example;

import java.util.ArrayList;

public class Deliverable implements ProjectItem {
    private String name;
    private String description;
    private Contact owner;
    private double materialCost;
    private double productionCost;

    public Deliverable() { }
    public Deliverable(String newName, String newDescription, Contact newOwner,
                       double newMaterialCost, double newProductionCost) {
        name = newName;
        description = newDescription;
        owner = newOwner;
        materialCost = newMaterialCost;
        productionCost = newProductionCost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Contact getOwner() {
        return owner;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public double getProductionCost() {
        return productionCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public void setProductionCost(double productionCost) {
        this.productionCost = productionCost;
    }

    @Override
    public void accept(ProjectVisitor v) {
        v.visitDeliverable(this);
    }

    @Override
    public ArrayList getProjectItems() {
        return null;
    }
}
