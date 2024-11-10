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
 * @author ABC
 */
@Entity
@Table(name = "leave_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveDetails.findAll", query = "SELECT l FROM LeaveDetails l"),
    @NamedQuery(name = "LeaveDetails.findById", query = "SELECT l FROM LeaveDetails l WHERE l.id = :id"),
    @NamedQuery(name = "LeaveDetails.findByFromDate", query = "SELECT l FROM LeaveDetails l WHERE l.fromDate = :fromDate"),
    @NamedQuery(name = "LeaveDetails.findByToDate", query = "SELECT l FROM LeaveDetails l WHERE l.toDate = :toDate"),
    @NamedQuery(name = "LeaveDetails.findByReason", query = "SELECT l FROM LeaveDetails l WHERE l.reason = :reason"),
    @NamedQuery(name = "LeaveDetails.findByStatus", query = "SELECT l FROM LeaveDetails l WHERE l.status = :status"),
    @NamedQuery(name = "LeaveDetails.findByRejectReason", query = "SELECT l FROM LeaveDetails l WHERE l.rejectReason = :rejectReason")})
public class LeaveDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @Size(max = 50)
    @Column(name = "reason")
    private String reason;
    @Size(max = 9)
    @Column(name = "status")
    private String status;
    @Size(max = 50)
    @Column(name = "reject_reason")
    private String rejectReason;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "leave_type_id")
    @ManyToOne
    private LeaveMaster leaveTypeId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;

    public LeaveDetails() {
    }

    public LeaveDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public LeaveMaster getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveMaster leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
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
        if (!(object instanceof LeaveDetails)) {
            return false;
        }
        LeaveDetails other = (LeaveDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LeaveDetails[ id=" + id + " ]";
    }
    
}
