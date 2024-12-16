/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
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
@Table(name = "department_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartmentMaster.findAll", query = "SELECT d FROM DepartmentMaster d"),
    @NamedQuery(name = "DepartmentMaster.findByDeptId", query = "SELECT d FROM DepartmentMaster d WHERE d.deptId = :deptId"),
    @NamedQuery(name = "DepartmentMaster.findByDeptName", query = "SELECT d FROM DepartmentMaster d WHERE d.deptName = :deptName"),
    @NamedQuery(name = "DepartmentMaster.findByDescription", query = "SELECT d FROM DepartmentMaster d WHERE d.description = :description")})
public class DepartmentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dept_id")
    private Integer deptId;
    @Size(max = 50)
    @Column(name = "dept_name")
    private String deptName;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster managerId;
    @OneToMany(mappedBy = "departmentId")
    private Collection<DesignationMaster> designationMasterCollection;

    public DepartmentMaster() {
    }

    public DepartmentMaster(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserMaster getManagerId() {
        return managerId;
    }

    public void setManagerId(UserMaster managerId) {
        this.managerId = managerId;
    }

    @JsonbTransient
    public Collection<DesignationMaster> getDesignationMasterCollection() {
        return designationMasterCollection;
    }

    public void setDesignationMasterCollection(Collection<DesignationMaster> designationMasterCollection) {
        this.designationMasterCollection = designationMasterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartmentMaster)) {
            return false;
        }
        DepartmentMaster other = (DepartmentMaster) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DepartmentMaster[ deptId=" + deptId + " ]";
    }
    
}
