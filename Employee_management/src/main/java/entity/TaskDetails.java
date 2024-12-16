/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "task_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaskDetails.findAll", query = "SELECT t FROM TaskDetails t"),
    @NamedQuery(name = "TaskDetails.findById", query = "SELECT t FROM TaskDetails t WHERE t.id = :id"),
    @NamedQuery(name = "TaskDetails.findByStartDate", query = "SELECT t FROM TaskDetails t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "TaskDetails.findByEndDate", query = "SELECT t FROM TaskDetails t WHERE t.endDate = :endDate"),
    @NamedQuery(name = "TaskDetails.findByOnHoldDays", query = "SELECT t FROM TaskDetails t WHERE t.onHoldDays = :onHoldDays"),
    @NamedQuery(name = "TaskDetails.findByOnHoldReason", query = "SELECT t FROM TaskDetails t WHERE t.onHoldReason = :onHoldReason")})
public class TaskDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Column(name = "on_hold_days")
    private Integer onHoldDays;
    @Size(max = 50)
    @Column(name = "on_hold_reason")
    private String onHoldReason;
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    @ManyToOne
    private TaskMaster taskId;
    @JoinColumn(name = "assign_by", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster assignBy;
    @JoinColumn(name = "assign_to", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster assignTo;

    public TaskDetails() {
    }

    public TaskDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getOnHoldDays() {
        return onHoldDays;
    }

    public void setOnHoldDays(Integer onHoldDays) {
        this.onHoldDays = onHoldDays;
    }

    public String getOnHoldReason() {
        return onHoldReason;
    }

    public void setOnHoldReason(String onHoldReason) {
        this.onHoldReason = onHoldReason;
    }

    public TaskMaster getTaskId() {
        return taskId;
    }

    public void setTaskId(TaskMaster taskId) {
        this.taskId = taskId;
    }

    public UserMaster getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(UserMaster assignBy) {
        this.assignBy = assignBy;
    }

    public UserMaster getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(UserMaster assignTo) {
        this.assignTo = assignTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaskDetails)) {
            return false;
        }
        TaskDetails other = (TaskDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TaskDetails[ id=" + id + " ]";
    }
    
}
