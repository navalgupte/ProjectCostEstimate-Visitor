package org.example;

import java.util.ArrayList;

public class Project implements ProjectItem {
    private String name;
    private String description;
    private ArrayList projectItems = new ArrayList();

    public Project() { }
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public ArrayList getProjectItems() {
        return projectItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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
        v.visitProject(this);
    }
}
