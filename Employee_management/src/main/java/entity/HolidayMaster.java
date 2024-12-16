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
@Table(name = "holiday_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HolidayMaster.findAll", query = "SELECT h FROM HolidayMaster h"),
    @NamedQuery(name = "HolidayMaster.findByHolidayId", query = "SELECT h FROM HolidayMaster h WHERE h.holidayId = :holidayId"),
    @NamedQuery(name = "HolidayMaster.findByDescription", query = "SELECT h FROM HolidayMaster h WHERE h.description = :description"),
    @NamedQuery(name = "HolidayMaster.findByHolidayDate", query = "SELECT h FROM HolidayMaster h WHERE h.holidayDate = :holidayDate")})
public class HolidayMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "holiday_id")
    private Integer holidayId;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @Column(name = "holiday_date")
    @Temporal(TemporalType.DATE)
    private Date holidayDate;

    public HolidayMaster() {
    }

    public HolidayMaster(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public Integer getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Integer holidayId) {
        this.holidayId = holidayId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (holidayId != null ? holidayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HolidayMaster)) {
            return false;
        }
        HolidayMaster other = (HolidayMaster) object;
        if ((this.holidayId == null && other.holidayId != null) || (this.holidayId != null && !this.holidayId.equals(other.holidayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HolidayMaster[ holidayId=" + holidayId + " ]";
    }
    
}
