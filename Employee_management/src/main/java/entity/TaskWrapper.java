/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ABC
 */
public class TaskWrapper {
    
    private TaskMaster taskmaster;
    private TaskDetails taskDetails;

    // Getters and setters

    public TaskMaster getTaskmaster() {
        return taskmaster;
    }

    public void setTaskmaster(TaskMaster taskmaster) {
        this.taskmaster = taskmaster;
    }

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(TaskDetails taskDetails) {
        this.taskDetails = taskDetails;
    }
}
