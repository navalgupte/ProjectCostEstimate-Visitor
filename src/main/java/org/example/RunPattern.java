package org.example;

import java.io.File;
import java.util.Iterator;

public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Visitor Pattern");
        System.out.println("---- ---- ---- ---- ----");
        if(!(new File("data.ser").exists())) {
            DataCreator.serialize("data.ser");
        }

        Project project = (Project) (DataRetriever.deserializeData("data.ser"));
        System.out.println("Creating ProjectCostVisitor to calculate total cost of the Project.");
        ProjectCostVisitor visitor = new ProjectCostVisitor();
        visitor.setHourlyRate(100);
        System.out.println("Moving through the Project, calculating total cost by passing the Visitor to each ProjectItem.");
        visitProjectItems(project, visitor);
        System.out.println("\tTotal Cost for Project: " + visitor.getTotalCost());
        System.out.println("---- ---- ---- ---- ----");
    }

    private static void visitProjectItems(ProjectItem item, ProjectVisitor visitor) {
        item.accept(visitor);
        if(item.getProjectItems() != null) {
            for (Object subItem : item.getProjectItems()) {
                visitProjectItems((ProjectItem) subItem, visitor);
            }
        }
    }
}