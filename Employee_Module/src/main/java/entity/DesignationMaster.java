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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "designation_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DesignationMaster.findAll", query = "SELECT d FROM DesignationMaster d"),
    @NamedQuery(name = "DesignationMaster.findByDesignationId", query = "SELECT d FROM DesignationMaster d WHERE d.designationId = :designationId"),
    @NamedQuery(name = "DesignationMaster.findByDesignation", query = "SELECT d FROM DesignationMaster d WHERE d.designation = :designation"),
    @NamedQuery(name = "DesignationMaster.findByResponsibility", query = "SELECT d FROM DesignationMaster d WHERE d.responsibility = :responsibility")})
public class DesignationMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "designation_id")
    private Integer designationId;
    @Size(max = 50)
    @Column(name = "Designation")
    private String designation;
    @Size(max = 50)
    @Column(name = "responsibility")
    private String responsibility;
    @JoinColumn(name = "department_id", referencedColumnName = "dept_id")
    @ManyToOne
    private DepartmentMaster departmentId;
    @OneToMany(mappedBy = "designationId")
    private Collection<UserDetails> userDetailsCollection;

    public DesignationMaster() {
    }

    public DesignationMaster(Integer designationId) {
        this.designationId = designationId;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public DepartmentMaster getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentMaster departmentId) {
        this.departmentId = departmentId;
    }

    @JsonbTransient
    public Collection<UserDetails> getUserDetailsCollection() {
        return userDetailsCollection;
    }

    public void setUserDetailsCollection(Collection<UserDetails> userDetailsCollection) {
        this.userDetailsCollection = userDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (designationId != null ? designationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesignationMaster)) {
            return false;
        }
        DesignationMaster other = (DesignationMaster) object;
        if ((this.designationId == null && other.designationId != null) || (this.designationId != null && !this.designationId.equals(other.designationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.DesignationMaster[ designationId=" + designationId + " ]";
    }
    
}
