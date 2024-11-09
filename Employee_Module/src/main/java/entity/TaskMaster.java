/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "task_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskMaster.findAll", query = "SELECT t FROM TaskMaster t"),
    @NamedQuery(name = "TaskMaster.findByTaskId", query = "SELECT t FROM TaskMaster t WHERE t.taskId = :taskId"),
    @NamedQuery(name = "TaskMaster.findByTaskTitle", query = "SELECT t FROM TaskMaster t WHERE t.taskTitle = :taskTitle"),
    @NamedQuery(name = "TaskMaster.findByDescription", query = "SELECT t FROM TaskMaster t WHERE t.description = :description"),
    @NamedQuery(name = "TaskMaster.findByPriority", query = "SELECT t FROM TaskMaster t WHERE t.priority = :priority"),
    @NamedQuery(name = "TaskMaster.findByDueDate", query = "SELECT t FROM TaskMaster t WHERE t.dueDate = :dueDate"),
    @NamedQuery(name = "TaskMaster.findByTaskStatus", query = "SELECT t FROM TaskMaster t WHERE t.taskStatus = :taskStatus")})
public class TaskMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "task_id")
    private Integer taskId;
    @Size(max = 100)
    @Column(name = "task_title")
    private String taskTitle;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 7)
    @Column(name = "priority")
    private String priority;
    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Size(max = 50)
    @Column(name = "task_status")
    private String taskStatus;
    @OneToMany(mappedBy = "taskId")
    private Collection<TaskDetails> taskDetailsCollection;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne
    private ProjectDetails projectId;

    public TaskMaster() {
    }

    public TaskMaster(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @JsonbTransient
    public Collection<TaskDetails> getTaskDetailsCollection() {
        return taskDetailsCollection;
    }

    public void setTaskDetailsCollection(Collection<TaskDetails> taskDetailsCollection) {
        this.taskDetailsCollection = taskDetailsCollection;
    }

    public ProjectDetails getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectDetails projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taskId != null ? taskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskMaster)) {
            return false;
        }
        TaskMaster other = (TaskMaster) object;
        if ((this.taskId == null && other.taskId != null) || (this.taskId != null && !this.taskId.equals(other.taskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.TaskMaster[ taskId=" + taskId + " ]";
    }
    
}
