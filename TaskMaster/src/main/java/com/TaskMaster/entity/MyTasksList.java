package com.TaskMaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="MyTasks")
public class MyTasksList {
    
    @Id
    private int id;
    private String name;
    private String description; 
    private String startDate; 
    private String endDate;
    private String category; 

    public MyTasksList() {
        super();
    }

    public MyTasksList(int id, String name, String description, String startDate, String endDate, String category) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.trim(); 
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate.trim(); 
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate.trim(); 
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category.trim(); 
    }
}
