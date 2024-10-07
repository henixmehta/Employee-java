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
@Table(name = "assets_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssetsMaster.findAll", query = "SELECT a FROM AssetsMaster a"),
    @NamedQuery(name = "AssetsMaster.findByAssetId", query = "SELECT a FROM AssetsMaster a WHERE a.assetId = :assetId"),
    @NamedQuery(name = "AssetsMaster.findByAssetName", query = "SELECT a FROM AssetsMaster a WHERE a.assetName = :assetName")})
public class AssetsMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asset_id")
    private Integer assetId;
    @Size(max = 50)
    @Column(name = "asset_name")
    private String assetName;
    @OneToMany(mappedBy = "assetId")
    private Collection<AssetsDetails> assetsDetailsCollection;

    public AssetsMaster() {
    }

    public AssetsMaster(Integer assetId) {
        this.assetId = assetId;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @XmlTransient
    public Collection<AssetsDetails> getAssetsDetailsCollection() {
        return assetsDetailsCollection;
    }

    public void setAssetsDetailsCollection(Collection<AssetsDetails> assetsDetailsCollection) {
        this.assetsDetailsCollection = assetsDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetId != null ? assetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssetsMaster)) {
            return false;
        }
        AssetsMaster other = (AssetsMaster) object;
        if ((this.assetId == null && other.assetId != null) || (this.assetId != null && !this.assetId.equals(other.assetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.AssetsMaster[ assetId=" + assetId + " ]";
    }
    
}
