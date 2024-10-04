/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "project_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectDetails.findAll", query = "SELECT p FROM ProjectDetails p"),
    @NamedQuery(name = "ProjectDetails.findByProjectId", query = "SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId"),
    @NamedQuery(name = "ProjectDetails.findByProjectName", query = "SELECT p FROM ProjectDetails p WHERE p.projectName = :projectName"),
    @NamedQuery(name = "ProjectDetails.findByDescription", query = "SELECT p FROM ProjectDetails p WHERE p.description = :description"),
    @NamedQuery(name = "ProjectDetails.findByDueDate", query = "SELECT p FROM ProjectDetails p WHERE p.dueDate = :dueDate"),
    @NamedQuery(name = "ProjectDetails.findByStartDate", query = "SELECT p FROM ProjectDetails p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "ProjectDetails.findByEndDate", query = "SELECT p FROM ProjectDetails p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "ProjectDetails.findByStatus", query = "SELECT p FROM ProjectDetails p WHERE p.status = :status"),
    @NamedQuery(name = "ProjectDetails.findByOnHoldDays", query = "SELECT p FROM ProjectDetails p WHERE p.onHoldDays = :onHoldDays"),
    @NamedQuery(name = "ProjectDetails.findByOnHoldReason", query = "SELECT p FROM ProjectDetails p WHERE p.onHoldReason = :onHoldReason")})
public class ProjectDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @Size(max = 50)
    @Column(name = "project_name")
    private String projectName;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 11)
    @Column(name = "status")
    private String status;
    @Column(name = "on_hold_days")
    private Integer onHoldDays;
    @Size(max = 50)
    @Column(name = "on_hold_reason")
    private String onHoldReason;
    @OneToMany(mappedBy = "projectId")
    private Collection<TaskMaster> taskMasterCollection;

    public ProjectDetails() {
    }

    public ProjectDetails(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @XmlTransient
    public Collection<TaskMaster> getTaskMasterCollection() {
        return taskMasterCollection;
    }

    public void setTaskMasterCollection(Collection<TaskMaster> taskMasterCollection) {
        this.taskMasterCollection = taskMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetails)) {
            return false;
        }
        ProjectDetails other = (ProjectDetails) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.ProjectDetails[ projectId=" + projectId + " ]";
    }
    
}
