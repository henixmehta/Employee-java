package cdi;

import client.ManagerClient;
import entity.AssetsDetails;
import entity.AssetsMaster;
import entity.AttendanceDetails;
import entity.DepartmentMaster;
import entity.DesignationMaster;
import entity.DocumentDetails;
import entity.DocumentMaster;
import entity.GroupMaster;
import entity.HolidayMaster;
import entity.LeaveDetails;
import entity.LeaveMaster;
import entity.PerformanceDetails;
import entity.ProjectDetails;
import entity.SkillsMaster;
import entity.TaskDetails;
import entity.TaskMaster;
import entity.UserMaster;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

@Named(value = "managerBeans")
@SessionScoped
public class ManagerBeans implements Serializable {

    private ManagerClient managerClient;
    private Collection<SkillsMaster> skillsList;
    private Collection<HolidayMaster> holidaysList;
    private Collection<AssetsMaster> assetsList;
    private Collection<DepartmentMaster> departmentList;
    private Collection<DesignationMaster> designationList;
    private Collection<AssetsDetails> assetdetailsList;
    private Collection<AttendanceDetails> attendanceDetailsList;
    private Collection<UserMaster> usersList;
    private Collection<DocumentMaster> documentsList;
    private Collection<DocumentDetails> documentsdetailsList;
    private Collection<GroupMaster> groupsList;
    private Collection<LeaveMaster> leavesList;
    private Collection<LeaveDetails> LeavedetailsList;
    private Collection<PerformanceDetails> performanceList;
    private Collection<ProjectDetails> projectdetailsList;
    private Collection<TaskMaster> tasksList;
    private Collection<TaskDetails> taskdetailsList;

    private String sname; // Skill name
    private String desc; // Skill description
    private String holidayDesc; // Holiday description
    private Date holidayDate; // Holiday date
    private String assetName; // Asset name

    private String designationName;
    private String responsibility;
    private Integer departmentId;

    private String deptName;
    private String deptDesc;
    private int managerId;

    private BigInteger assetNumber;
    private String assignDate;
    private String returnDate;
    private Integer assetId;
    private Integer userId;

    private final GenericType<Collection<SkillsMaster>> skillsGenericType = new GenericType<Collection<SkillsMaster>>() {
    };
    private final GenericType<Collection<HolidayMaster>> holidaysGenericType = new GenericType<Collection<HolidayMaster>>() {
    };
    private final GenericType<Collection<AssetsMaster>> assetsGenericType = new GenericType<Collection<AssetsMaster>>() {
    };
    private final GenericType<Collection<DepartmentMaster>> deptGenericType = new GenericType<Collection<DepartmentMaster>>() {
    };
    private final GenericType<Collection<DesignationMaster>> designationGenericType = new GenericType<Collection<DesignationMaster>>() {
    };
    private final GenericType<Collection<AssetsDetails>> assetdetailsGenericType = new GenericType<Collection<AssetsDetails>>() {
    };
    private final GenericType<Collection<AttendanceDetails>> attendanceDetailsGenericType = new GenericType<Collection<AttendanceDetails>>() {
    };
    private final GenericType<Collection<UserMaster>> usersGenericType = new GenericType<Collection<UserMaster>>() {
    };
    private final GenericType<Collection<DocumentMaster>> documnentmasterGenericType = new GenericType<Collection<DocumentMaster>>() {
    };
    private final GenericType<Collection<DocumentDetails>> documnentdetailsGenericType = new GenericType<Collection<DocumentDetails>>() {
    };
    private final GenericType<Collection<GroupMaster>> groupsGenericType = new GenericType<Collection<GroupMaster>>() {
    };
    private final GenericType<Collection<LeaveMaster>> leavesGenericType = new GenericType<Collection<LeaveMaster>>() {
    };
    private final GenericType<Collection<LeaveDetails>> leavesdetailsGenericType = new GenericType<Collection<LeaveDetails>>() {
    };
    private final GenericType<Collection<PerformanceDetails>> performanceGenericType = new GenericType<Collection<PerformanceDetails>>() {
    };
    private final GenericType<Collection<ProjectDetails>> projectdetailsGenericType = new GenericType<Collection<ProjectDetails>>() {
    };
    private final GenericType<Collection<TaskMaster>> tasksGenericType = new GenericType<Collection<TaskMaster>>() {
    };
    private final GenericType<Collection<TaskDetails>> taskdetailsGenericType = new GenericType<Collection<TaskDetails>>() {
    };

    // Generic types for REST client responses
    public ManagerBeans() {
//        managerClient = new ManagerClient();
    }

    @PostConstruct
    public void init() {
        try {
            managerClient = new ManagerClient();
            skillsList = managerClient.getAllSkills(skillsGenericType);
            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
            assetsList = managerClient.getAllAssets(assetsGenericType);
            departmentList = managerClient.getAllDepartments(deptGenericType);
            designationList = managerClient.getAllDesignation(designationGenericType);
            assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType);
            attendanceDetailsList = managerClient.getAllAttendenceDetails(attendanceDetailsGenericType);
            usersList = managerClient.getAllUsers(usersGenericType);
            documentsList = managerClient.getAllDocuments(documnentmasterGenericType);
            documentsdetailsList = managerClient.getAllDocumentDetails(documnentdetailsGenericType);
            groupsList = managerClient.getAllGroups(groupsGenericType);
            leavesList = managerClient.getAllLeaves(leavesGenericType);
            LeavedetailsList = managerClient.getAllLeaveDetails(leavesdetailsGenericType);
            performanceList = managerClient.getPerformanceDetails(performanceGenericType);
            projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType);
            tasksList = managerClient.getAllTask(tasksGenericType);
            taskdetailsList = managerClient.getAllTaskDetails(taskdetailsGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Skill management methods
    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    public void addSkill() {
        try {
            SkillsMaster newSkill = new SkillsMaster();
            newSkill.setSkillName(sname);
            newSkill.setDescription(desc);

            managerClient.addSkill(newSkill, sname, desc);
            skillsList = managerClient.getAllSkills(skillsGenericType);
            sname = ""; // Clear after adding
            desc = ""; // Clear after adding
        } catch (ClientErrorException e) {
        }
    }

    public void deleteSkill(int skillId) {
        try {
            managerClient.deleteSkills(skillId);
            skillsList = managerClient.getAllSkills(skillsGenericType);
        } catch (ClientErrorException e) {
            // Log the exception if the deletion fails

        }
    }

    public Collection<UserMaster> getUsersList() {
        return usersList;
    }

    public Collection<DepartmentMaster> getDepartmentList() {
        return departmentList;
    }

    public void addDepartment() {
        DepartmentMaster newDept = new DepartmentMaster();
        managerClient.addDepartment(newDept, deptName, deptDesc, managerId);
        departmentList = managerClient.getAllDepartments(deptGenericType);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptDesc() {
        return deptDesc;
    }

    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Collection<DesignationMaster> getDesignationList() {
        return designationList;
    }

    public void addDesignation() {
        try {

            if (responsibility == null || responsibility.trim().isEmpty()) {
                responsibility = null;
            }

            managerClient.addDesignation(designationName, responsibility, departmentId);

            designationList = managerClient.getAllDesignation(designationGenericType);

            designationName = "";
            responsibility = "";
            departmentId = null;
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }
    private UserMaster usermaster = new UserMaster();

    public UserMaster getUsermaster() {
        return usermaster;
    }

    public void setUsermaster(UserMaster usermaster) {
        this.usermaster = usermaster;
    }

    public void addUser() {
        try {

            managerClient.addUser(usermaster);
            usersList = managerClient.getAllUsers(usersGenericType);
            usermaster.setAddress(null);
            usermaster.setAge(null);
            usermaster.setCompanyEmail(null);
            usermaster.setCurrentExperience(null);
            usermaster.setDateOfBirth(null);
            usermaster.setUserName(null);
            usermaster.setProfileImage(null);
            usermaster.setSalary(null);
            usermaster.setReportingTo(null);
            usermaster.setQualification(null);
            usermaster.setGender(null);
            usermaster.setJoiningDate(null);
            usermaster.setPassword(null);
            usermaster.setEmergencyContact(null);
            usermaster.setPhoneNo(null);
            usermaster.setEmailId(null);

        } catch (ClientErrorException e) {
        }
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    // Holiday management methods
    public Collection<HolidayMaster> getHolidaysList() {
        return holidaysList;
    }

    public Collection<AttendanceDetails> getAttendanceDetailsList() {
        return attendanceDetailsList;
    }

    public Collection<DocumentMaster> getDocumentsList() {
        return documentsList;
    }

    public Collection<DocumentDetails> getDocumentDetailsList() {
        return documentsdetailsList;
    }

    public Collection<GroupMaster> getAllGroupsList() {
        return groupsList;
    }

    public Collection<LeaveMaster> getAllLeavesList() {
        return leavesList;
    }

    public Collection<LeaveDetails> getLeaveDetailsList() {
        return LeavedetailsList;
    }

    public Collection<PerformanceDetails> getPerformaneDetailsList() {
        return performanceList;
    }

    public Collection<ProjectDetails> getProjectDetailsList() {
        return projectdetailsList;
    }

    public Collection<TaskMaster> getAllTasksList() {
        return tasksList;
    }

    public Collection<TaskDetails> getTaskDetailsList() {
        return taskdetailsList;
    }

    public void addHoliday() {
        try {
            HolidayMaster newHoliday = new HolidayMaster();
            newHoliday.setDescription(holidayDesc);
            newHoliday.setHolidayDate(holidayDate);
            managerClient.addHoliday(newHoliday, holidayDesc, holidayDate);
            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
            holidayDesc = ""; // Reset after adding
            holidayDate = null; // Reset after adding
        } catch (ClientErrorException e) {
        }
    }

    // Asset management methods
    public Collection<AssetsMaster> getAssetsList() {
        return assetsList;
    }

    public Collection<AssetsDetails> getAssetsDetailsList() {
        return assetdetailsList;
    }

    public void addAssetDetails() {
        try {
            managerClient.addAssetDetails(assetNumber, assignDate, returnDate, assetId, userId);
            assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType); // Refresh list
            assetNumber = null;
            assignDate = null;
            returnDate = null;
            assetId = null;
            userId = null;
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    public void addAsset() {
        try {
            AssetsMaster newAsset = new AssetsMaster();
            newAsset.setAssetName(assetName);

            managerClient.addAssets(newAsset, assetName);
            assetsList = managerClient.getAllAssets(assetsGenericType);
            assetName = ""; // Clear after adding
        } catch (ClientErrorException e) {
        }
    }

    public void deleteAsset(int assetId) {
        try {
            // Call the deleteAsset method from ManagerClient to delete the asset
            managerClient.deleteAsset(assetId);

            // Refresh the asset list after deletion
            assetsList = managerClient.getAllAssets(assetsGenericType);
        } catch (ClientErrorException e) {
            // Log the exception if the deletion fails

        }
    }

    // Getters and setters for skill, holiday, and asset fields
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHolidayDesc() {
        return holidayDesc;
    }

    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigInteger getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(BigInteger assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void closeClient() {
        managerClient.close();
    }
}
