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
 * @author Henil
 */
@Entity
@Table(name = "skills_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsMaster.findAll", query = "SELECT s FROM SkillsMaster s"),
    @NamedQuery(name = "SkillsMaster.findBySkillId", query = "SELECT s FROM SkillsMaster s WHERE s.skillId = :skillId"),
    @NamedQuery(name = "SkillsMaster.findBySkillName", query = "SELECT s FROM SkillsMaster s WHERE s.skillName = :skillName"),
    @NamedQuery(name = "SkillsMaster.findByDescription", query = "SELECT s FROM SkillsMaster s WHERE s.description = :description")})
public class SkillsMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "skill_id")
    private Integer skillId;
    @Size(max = 50)
    @Column(name = "skill_name")
    private String skillName;
    @Size(max = 100)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "skillId")
    private Collection<UserDetails> userDetailsCollection;

    public SkillsMaster() {
    }

    public SkillsMaster(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<UserDetails> getUserDetailsCollection() {
        return userDetailsCollection;
    }

    public void setUserDetailsCollection(Collection<UserDetails> userDetailsCollection) {
        this.userDetailsCollection = userDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillId != null ? skillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsMaster)) {
            return false;
        }
        SkillsMaster other = (SkillsMaster) object;
        if ((this.skillId == null && other.skillId != null) || (this.skillId != null && !this.skillId.equals(other.skillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.SkillsMaster[ skillId=" + skillId + " ]";
    }
    
}
