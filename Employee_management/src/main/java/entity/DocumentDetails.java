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
@Table(name = "document_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentDetails.findAll", query = "SELECT d FROM DocumentDetails d"),
    @NamedQuery(name = "DocumentDetails.findById", query = "SELECT d FROM DocumentDetails d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentDetails.findByDocumentNumber", query = "SELECT d FROM DocumentDetails d WHERE d.documentNumber = :documentNumber"),
    @NamedQuery(name = "DocumentDetails.findByDocumentPath", query = "SELECT d FROM DocumentDetails d WHERE d.documentPath = :documentPath")})
public class DocumentDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "document_number")
    private String documentNumber;
    @Size(max = 50)
    @Column(name = "document_path")
    private String documentPath;
    @JoinColumn(name = "doc_id", referencedColumnName = "doc_id")
    @ManyToOne
    private DocumentMaster docId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private UserMaster userId;

    public DocumentDetails() {
    }

    public DocumentDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public DocumentMaster getDocId() {
        return docId;
    }

    public void setDocId(DocumentMaster docId) {
        this.docId = docId;
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
        if (!(object instanceof DocumentDetails)) {
            return false;
        }
        DocumentDetails other = (DocumentDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DocumentDetails[ id=" + id + " ]";
    }
    
}
