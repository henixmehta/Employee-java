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
@Table(name = "assets_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssetsDetails.findAll", query = "SELECT a FROM AssetsDetails a"),
    @NamedQuery(name = "AssetsDetails.findById", query = "SELECT a FROM AssetsDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AssetsDetails.findByAssetNumber", query = "SELECT a FROM AssetsDetails a WHERE a.assetNumber = :assetNumber"),
    @NamedQuery(name = "AssetsDetails.findByAssignDate", query = "SELECT a FROM AssetsDetails a WHERE a.assignDate = :assignDate"),
    @NamedQuery(name = "AssetsDetails.findByReturnDate", query = "SELECT a FROM AssetsDetails a WHERE a.returnDate = :returnDate")})
public class AssetsDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "asset_number")
    private Integer assetNumber;
    @Column(name = "assign_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
    @JoinColumn(name = "asset_id", referencedColumnName = "asset_id")
    @ManyToOne
    private AssetsMaster assetId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;

    public AssetsDetails() {
    }

    public AssetsDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(Integer assetNumber) {
        this.assetNumber = assetNumber;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public AssetsMaster getAssetId() {
        return assetId;
    }

    public void setAssetId(AssetsMaster assetId) {
        this.assetId = assetId;
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
        if (!(object instanceof AssetsDetails)) {
            return false;
        }
        AssetsDetails other = (AssetsDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AssetsDetails[ id=" + id + " ]";
    }
    
}
