/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
@Table(name = "document_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentMaster.findAll", query = "SELECT d FROM DocumentMaster d"),
    @NamedQuery(name = "DocumentMaster.findByDocId", query = "SELECT d FROM DocumentMaster d WHERE d.docId = :docId"),
    @NamedQuery(name = "DocumentMaster.findByDocName", query = "SELECT d FROM DocumentMaster d WHERE d.docName = :docName")})
public class DocumentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doc_id")
    private Integer docId;
    @Size(max = 50)
    @Column(name = "doc_name")
    private String docName;
    @OneToMany(mappedBy = "docId")
    private Collection<DocumentDetails> documentDetailsCollection;

    public DocumentMaster() {
    }

    public DocumentMaster(Integer docId) {
        this.docId = docId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    @XmlTransient
    public Collection<DocumentDetails> getDocumentDetailsCollection() {
        return documentDetailsCollection;
    }

    public void setDocumentDetailsCollection(Collection<DocumentDetails> documentDetailsCollection) {
        this.documentDetailsCollection = documentDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docId != null ? docId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentMaster)) {
            return false;
        }
        DocumentMaster other = (DocumentMaster) object;
        if ((this.docId == null && other.docId != null) || (this.docId != null && !this.docId.equals(other.docId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.employee_module.DocumentMaster[ docId=" + docId + " ]";
    }
    
}
