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
@Table(name = "performance_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerformanceDetails.findAll", query = "SELECT p FROM PerformanceDetails p"),
    @NamedQuery(name = "PerformanceDetails.findByPerformanceId", query = "SELECT p FROM PerformanceDetails p WHERE p.performanceId = :performanceId"),
    @NamedQuery(name = "PerformanceDetails.findByReviewDate", query = "SELECT p FROM PerformanceDetails p WHERE p.reviewDate = :reviewDate"),
    @NamedQuery(name = "PerformanceDetails.findByRating", query = "SELECT p FROM PerformanceDetails p WHERE p.rating = :rating")})
public class PerformanceDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "performance_id")
    private Integer performanceId;
    @Column(name = "review_date")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;
    @Column(name = "rating")
    private Integer rating;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;
    @JoinColumn(name = "review_by", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster reviewBy;

    public PerformanceDetails() {
    }

    public PerformanceDetails(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public Integer getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Integer performanceId) {
        this.performanceId = performanceId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public UserMaster getUserId() {
        return userId;
    }

    public void setUserId(UserMaster userId) {
        this.userId = userId;
    }

    public UserMaster getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(UserMaster reviewBy) {
        this.reviewBy = reviewBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (performanceId != null ? performanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerformanceDetails)) {
            return false;
        }
        PerformanceDetails other = (PerformanceDetails) object;
        if ((this.performanceId == null && other.performanceId != null) || (this.performanceId != null && !this.performanceId.equals(other.performanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PerformanceDetails[ performanceId=" + performanceId + " ]";
    }
    
}
