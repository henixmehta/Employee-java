/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ABC
 */
@Entity
@Table(name = "leave_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveMaster.findAll", query = "SELECT l FROM LeaveMaster l"),
    @NamedQuery(name = "LeaveMaster.findByLeaveTypeId", query = "SELECT l FROM LeaveMaster l WHERE l.leaveTypeId = :leaveTypeId"),
    @NamedQuery(name = "LeaveMaster.findByLeaveType", query = "SELECT l FROM LeaveMaster l WHERE l.leaveType = :leaveType")})
public class LeaveMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "leave_type_id")
    private Integer leaveTypeId;
    @Size(max = 50)
    @Column(name = "leave_type")
    private String leaveType;
    @OneToMany(mappedBy = "leaveTypeId")
    private Collection<LeaveDetails> leaveDetailsCollection;

    public LeaveMaster() {
    }

    public LeaveMaster(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public Integer getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Integer leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    @JsonbTransient
    public Collection<LeaveDetails> getLeaveDetailsCollection() {
        return leaveDetailsCollection;
    }

    public void setLeaveDetailsCollection(Collection<LeaveDetails> leaveDetailsCollection) {
        this.leaveDetailsCollection = leaveDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leaveTypeId != null ? leaveTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveMaster)) {
            return false;
        }
        LeaveMaster other = (LeaveMaster) object;
        if ((this.leaveTypeId == null && other.leaveTypeId != null) || (this.leaveTypeId != null && !this.leaveTypeId.equals(other.leaveTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LeaveMaster[ leaveTypeId=" + leaveTypeId + " ]";
    }
    
}
