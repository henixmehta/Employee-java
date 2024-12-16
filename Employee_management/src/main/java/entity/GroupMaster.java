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
@Table(name = "group_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupMaster.findAll", query = "SELECT g FROM GroupMaster g"),
    @NamedQuery(name = "GroupMaster.findByGroupId", query = "SELECT g FROM GroupMaster g WHERE g.groupId = :groupId"),
    @NamedQuery(name = "GroupMaster.findByGroupName", query = "SELECT g FROM GroupMaster g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "GroupMaster.findByUserId", query = "SELECT g FROM GroupMaster g WHERE g.userId = :userId")})
public class GroupMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Size(max = 50)
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "user_id")
    private Integer userId;
    @OneToMany(mappedBy = "groupId")
    private Collection<UserDetails> userDetailsCollection;

    public GroupMaster() {
    }

    public GroupMaster(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupMaster)) {
            return false;
        }
        GroupMaster other = (GroupMaster) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.GroupMaster[ groupId=" + groupId + " ]";
    }
    
}
