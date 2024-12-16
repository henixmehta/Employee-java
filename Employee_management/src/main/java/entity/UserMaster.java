/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Henil
 */
@Entity
@Table(name = "user_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMaster.findAll", query = "SELECT u FROM UserMaster u"),
    @NamedQuery(name = "UserMaster.findByUserId", query = "SELECT u FROM UserMaster u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserMaster.findByUserName", query = "SELECT u FROM UserMaster u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserMaster.findByEmailId", query = "SELECT u FROM UserMaster u WHERE u.emailId = :emailId"),
    @NamedQuery(name = "UserMaster.findByPhoneNo", query = "SELECT u FROM UserMaster u WHERE u.phoneNo = :phoneNo"),
    @NamedQuery(name = "UserMaster.findByDateOfBirth", query = "SELECT u FROM UserMaster u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "UserMaster.findByAge", query = "SELECT u FROM UserMaster u WHERE u.age = :age"),
    @NamedQuery(name = "UserMaster.findByGender", query = "SELECT u FROM UserMaster u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserMaster.findByJoiningDate", query = "SELECT u FROM UserMaster u WHERE u.joiningDate = :joiningDate"),
    @NamedQuery(name = "UserMaster.findByAddress", query = "SELECT u FROM UserMaster u WHERE u.address = :address"),
    @NamedQuery(name = "UserMaster.findByEmergencyContact", query = "SELECT u FROM UserMaster u WHERE u.emergencyContact = :emergencyContact"),
    @NamedQuery(name = "UserMaster.findByProfileImage", query = "SELECT u FROM UserMaster u WHERE u.profileImage = :profileImage"),
    @NamedQuery(name = "UserMaster.findByCompanyEmail", query = "SELECT u FROM UserMaster u WHERE u.companyEmail = :companyEmail"),
    @NamedQuery(name = "UserMaster.findByPassword", query = "SELECT u FROM UserMaster u WHERE u.password = :password"),
    @NamedQuery(name = "UserMaster.findByReportingTo", query = "SELECT u FROM UserMaster u WHERE u.reportingTo = :reportingTo"),
    @NamedQuery(name = "UserMaster.findBySalary", query = "SELECT u FROM UserMaster u WHERE u.salary = :salary"),
    @NamedQuery(name = "UserMaster.findByQualification", query = "SELECT u FROM UserMaster u WHERE u.qualification = :qualification"),
    @NamedQuery(name = "UserMaster.findByCurrentExperience", query = "SELECT u FROM UserMaster u WHERE u.currentExperience = :currentExperience")})
public class UserMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 50)
    @Column(name = "user_name")
    private String userName;
    @Size(max = 50)
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_no")
    private BigInteger phoneNo;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "age")
    private Integer age;
    @Size(max = 50)
    @Column(name = "gender")
    private String gender;
    @Column(name = "joining_date")
    @Temporal(TemporalType.DATE)
    private Date joiningDate;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Column(name = "emergency_contact")
    private BigInteger emergencyContact;
    @Size(max = 100)
    @Column(name = "profile_image")
    private String profileImage;
    @Size(max = 100)
    @Column(name = "company_email")
    private String companyEmail;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Column(name = "reporting_to")
    private Integer reportingTo;
    @Column(name = "salary")
    private BigInteger salary;
    @Size(max = 100)
    @Column(name = "qualification")
    private String qualification;
    @Size(max = 100)
    @Column(name = "current_experience")
    private String currentExperience;
    @OneToMany(mappedBy = "managerId")
    private Collection<DepartmentMaster> departmentMasterCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<DocumentDetails> documentDetailsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<PerformanceDetails> performanceDetailsCollection;
    @OneToMany(mappedBy = "reviewBy")
    private Collection<PerformanceDetails> performanceDetailsCollection1;
    @OneToMany(mappedBy = "userId")
    private Collection<UserDetails> userDetailsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<AttendanceDetails> attendanceDetailsCollection;
    @OneToMany(mappedBy = "assignBy")
    private Collection<TaskDetails> taskDetailsCollection;
    @OneToMany(mappedBy = "assignTo")
    private Collection<TaskDetails> taskDetailsCollection1;
    @OneToMany(mappedBy = "userId")
    private Collection<AssetsDetails> assetsDetailsCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<LeaveDetails> leaveDetailsCollection;

    public UserMaster() {
    }

    private String hashPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());
            return new BigInteger(1, hashedBytes).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserMaster(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public BigInteger getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(BigInteger phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(BigInteger emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = hashPassword(password);
        } else {
            this.password = null;
        }
    }

    public Integer getReportingTo() {
        return reportingTo;
    }

    public void setReportingTo(Integer reportingTo) {
        this.reportingTo = reportingTo;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(String currentExperience) {
        this.currentExperience = currentExperience;
    }

    @JsonbTransient
    public Collection<DepartmentMaster> getDepartmentMasterCollection() {
        return departmentMasterCollection;
    }

    public void setDepartmentMasterCollection(Collection<DepartmentMaster> departmentMasterCollection) {
        this.departmentMasterCollection = departmentMasterCollection;
    }

    @JsonbTransient
    public Collection<DocumentDetails> getDocumentDetailsCollection() {
        return documentDetailsCollection;
    }

    public void setDocumentDetailsCollection(Collection<DocumentDetails> documentDetailsCollection) {
        this.documentDetailsCollection = documentDetailsCollection;
    }

    @JsonbTransient
    public Collection<PerformanceDetails> getPerformanceDetailsCollection() {
        return performanceDetailsCollection;
    }

    public void setPerformanceDetailsCollection(Collection<PerformanceDetails> performanceDetailsCollection) {
        this.performanceDetailsCollection = performanceDetailsCollection;
    }

    @JsonbTransient
    public Collection<PerformanceDetails> getPerformanceDetailsCollection1() {
        return performanceDetailsCollection1;
    }

    public void setPerformanceDetailsCollection1(Collection<PerformanceDetails> performanceDetailsCollection1) {
        this.performanceDetailsCollection1 = performanceDetailsCollection1;
    }

    @JsonbTransient
    public Collection<UserDetails> getUserDetailsCollection() {
        return userDetailsCollection;
    }

    public void setUserDetailsCollection(Collection<UserDetails> userDetailsCollection) {
        this.userDetailsCollection = userDetailsCollection;
    }

    @JsonbTransient
    public Collection<AttendanceDetails> getAttendanceDetailsCollection() {
        return attendanceDetailsCollection;
    }

    public void setAttendanceDetailsCollection(Collection<AttendanceDetails> attendanceDetailsCollection) {
        this.attendanceDetailsCollection = attendanceDetailsCollection;
    }

    @JsonbTransient
    public Collection<TaskDetails> getTaskDetailsCollection() {
        return taskDetailsCollection;
    }

    public void setTaskDetailsCollection(Collection<TaskDetails> taskDetailsCollection) {
        this.taskDetailsCollection = taskDetailsCollection;
    }

    @JsonbTransient
    public Collection<TaskDetails> getTaskDetailsCollection1() {
        return taskDetailsCollection1;
    }

    public void setTaskDetailsCollection1(Collection<TaskDetails> taskDetailsCollection1) {
        this.taskDetailsCollection1 = taskDetailsCollection1;
    }

    @JsonbTransient
    public Collection<AssetsDetails> getAssetsDetailsCollection() {
        return assetsDetailsCollection;
    }

    public void setAssetsDetailsCollection(Collection<AssetsDetails> assetsDetailsCollection) {
        this.assetsDetailsCollection = assetsDetailsCollection;
    }

    @JsonbTransient
    public Collection<LeaveDetails> getLeaveDetailsCollection() {
        return leaveDetailsCollection;
    }

    public void setLeaveDetailsCollection(Collection<LeaveDetails> leaveDetailsCollection) {
        this.leaveDetailsCollection = leaveDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserMaster)) {
            return false;
        }
        UserMaster other = (UserMaster) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserMaster[ userId=" + userId + " ]";
    }

}
