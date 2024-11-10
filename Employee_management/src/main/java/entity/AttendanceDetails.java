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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ABC
 */
@Entity
@Table(name = "attendance_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttendanceDetails.findAll", query = "SELECT a FROM AttendanceDetails a"),
    @NamedQuery(name = "AttendanceDetails.findByAttendanceId", query = "SELECT a FROM AttendanceDetails a WHERE a.attendanceId = :attendanceId"),
    @NamedQuery(name = "AttendanceDetails.findByDate", query = "SELECT a FROM AttendanceDetails a WHERE a.date = :date"),
    @NamedQuery(name = "AttendanceDetails.findByCheckIn", query = "SELECT a FROM AttendanceDetails a WHERE a.checkIn = :checkIn"),
    @NamedQuery(name = "AttendanceDetails.findByCheckOut", query = "SELECT a FROM AttendanceDetails a WHERE a.checkOut = :checkOut")})
public class AttendanceDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attendance_id")
    private Integer attendanceId;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "check_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkIn;
    @Column(name = "check_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOut;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;

    public AttendanceDetails() {
    }

    public AttendanceDetails(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
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
        hash += (attendanceId != null ? attendanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AttendanceDetails)) {
            return false;
        }
        AttendanceDetails other = (AttendanceDetails) object;
        if ((this.attendanceId == null && other.attendanceId != null) || (this.attendanceId != null && !this.attendanceId.equals(other.attendanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AttendanceDetails[ attendanceId=" + attendanceId + " ]";
    }
    
}
