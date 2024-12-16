/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u"),
    @NamedQuery(name = "UserDetails.findById", query = "SELECT u FROM UserDetails u WHERE u.id = :id"),
    @NamedQuery(name = "UserDetails.findByActive", query = "SELECT u FROM UserDetails u WHERE u.active = :active")})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 3)
    @Column(name = "active")
    private String active;
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    @ManyToOne
    private DepartmentMaster deptId;
    @JoinColumn(name = "designation_id", referencedColumnName = "designation_id")
    @ManyToOne
    private DesignationMaster designationId;
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne
    private GroupMaster groupId;
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
    @ManyToOne
    private SkillsMaster skillId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;

    public UserDetails() {
    }

    public UserDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public DepartmentMaster getDeptId() {
        return deptId;
    }

    public void setDeptId(DepartmentMaster deptId) {
        this.deptId = deptId;
    }

    public DesignationMaster getDesignationId() {
        return designationId;
    }

    public void setDesignationId(DesignationMaster designationId) {
        this.designationId = designationId;
    }

    public GroupMaster getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupMaster groupId) {
        this.groupId = groupId;
    }

    public SkillsMaster getSkillId() {
        return skillId;
    }

    public void setSkillId(SkillsMaster skillId) {
        this.skillId = skillId;
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
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserDetails[ id=" + id + " ]";
    }
    
}
