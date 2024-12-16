package cdi;

import client.ManagerClient;
import entity.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import java.time.LocalDate;
import java.time.Period;

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

    private Integer designationId;
    private String designationName;
    private String responsibility;
    private Integer departmentId;

    private Integer deptId;
    private String deptName;
    private String deptDesc;
    private int managerId;

    private Integer selectedDeptId; // edit department

    Integer assetsdetailsId;
    private Integer assetId;
    private BigInteger assetNumber;
    private String assignDate;
    private String returnDate;
    private Integer userId;

    private String groupname;
    private String leavetype;

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
            loadCounts();

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

    //Delete Skill
//    public void deleteSkill(int skillId) {
//        managerClient.deleteSkills(skillId);
//        skillsList = managerClient.getAllSkills(skillsGenericType);
//    }
    // Edit  Skill
    SkillsMaster SelectedKill;

    public void editsKill(SkillsMaster skillMaster) {
        this.SelectedKill = skillMaster;
        this.sname = skillMaster.getSkillName();
        this.desc = skillMaster.getDescription();
    }

    public SkillsMaster getSelectedKill() {
        return SelectedKill;
    }

    public void setSelectedKill(SkillsMaster SelectedKill) {
        this.SelectedKill = SelectedKill;
    }

    //========================================Group Master=======================================================
    public void addGroups() {
        try {
            GroupMaster group = new GroupMaster();
            group.setGroupName(groupname);

            managerClient.addGroups(group, groupname);
            groupsList = managerClient.getAllGroups(groupsGenericType);
            groupname = ""; // Clear after adding
        } catch (ClientErrorException e) {
        }

    }

    //================================================user Master================================================
    public Collection<UserMaster> getUsersList() {
        return usersList;
    }

    public Collection<DepartmentMaster> getDepartmentList() {
        return departmentList;
    }

    //add userMaster
    public void addUser() {
        try {

            managerClient.addUser(usermaster);
            usersList = managerClient.getAllUsers(usersGenericType);
            resetUserMasterFields();
        } catch (ClientErrorException e) {
        }
    }

    public void resetUserMasterFields() {
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
    }

    // delete usermaster  
//    public void deleteUser(Integer userMId) {
//        managerClient.deleteUser(userMId);
//        usersList = managerClient.getAllUsers(usersGenericType);
//        resetUserMasterFields();
//    }
    private DepartmentMaster selectedDept;

    public DepartmentMaster getSelectedDept() {
        return selectedDept;
    }

    public void setSelectedDept(DepartmentMaster selectedDept) {
        this.selectedDept = selectedDept;
    }

    public void editDepartment(DepartmentMaster dept) {
        this.selectedDept = dept;
        this.selectedDeptId = dept.getDeptId();
        this.deptName = dept.getDeptName();
        this.deptDesc = dept.getDescription();
        this.managerId = dept.getManagerId().getUserId();
    }

    public Integer getSelectedDeptId() {
        return selectedDeptId;
    }

    public void setSelectedDeptId(Integer selectedDeptId) {
        this.selectedDeptId = selectedDeptId;
    }

    public void addOrUpdateDepartment() {
        try {
            DepartmentMaster dept = new DepartmentMaster();

            if (selectedDeptId != null && selectedDeptId > 0) {
                dept.setDeptId(selectedDeptId); // Update
            } else {
                dept.setDeptId(null); // Add
            }
            dept.setDeptName(deptName);
            dept.setDescription(deptDesc);
            dept.setManagerId(usersList.stream()
                    .filter(u -> u.getUserId() == managerId)
                    .findFirst()
                    .orElse(null)); // Set manager from users list
            managerClient.addOrUpdateDepartment(dept, selectedDeptId, deptName, deptDesc, managerId);
            departmentList = managerClient.getAllDepartments(deptGenericType);
            resetDepartmentForm();
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

//    public void deleteDepartment() {
//        managerClient.deleteDepartment(deptId);
//        departmentList = managerClient.getAllDepartments(deptGenericType);
//
//    }
    private void resetDepartmentForm() {
        selectedDeptId = null;
        deptName = "";
        deptDesc = "";
        managerId = 0;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
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
            managerClient.addDesignation(designationName, responsibility, deptId);
            designationList = managerClient.getAllDesignation(designationGenericType);
            designationName = "";
            responsibility = "";
            deptId = null;
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    //edit Desgination
    private DesignationMaster selectedDesgination;

    public DesignationMaster getSelectedDesgination() {
        return selectedDesgination;
    }

    public void setSelectedDesgination(DesignationMaster selectedDesgination) {
        this.selectedDesgination = selectedDesgination;
    }

    public void editDesgination(DesignationMaster desg) {
        this.selectedDesgination = desg;
        this.designationId = desg.getDesignationId();
        this.designationName = desg.getDesignation();
        this.responsibility = desg.getResponsibility();
        this.deptId = desg.getDepartmentId().getDeptId();
    }

    public void updateDesignation() {
        try {

            DesignationMaster desgi = new DesignationMaster();
            // Ensure `responsibility` is set to null if it is empty
            if (responsibility == null || responsibility.trim().isEmpty()) {
                responsibility = null;
            }

            // Call the client method to update the designation
            managerClient.updateDesignation(desgi, // RequestEntity is not used in this scenario
                    designationId.toString(),
                    designationName,
                    responsibility,
                    deptId.toString()
            );

            // Refresh the designation list
            designationList = managerClient.getAllDesignation(designationGenericType);

            // Reset fields after update
            resetDesignationForm();
        } catch (ClientErrorException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

// Reset the designation form fields
    private void resetDesignationForm() {
        designationId = null;
        designationName = "";
        responsibility = "";
        deptId = null;
    }

    //delete Desgination
//    public void deleteDesgination() {
//        managerClient.deleteDesgination(designationId);
//        designationList = managerClient.getAllDesignation(designationGenericType);
//    }
    //Display User
    private UserMaster usermaster = new UserMaster();

    public UserMaster getUsermaster() {
        return usermaster;
    }

    public void setUsermaster(UserMaster usermaster) {
        this.usermaster = usermaster;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    //AddAssetsDetails
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

    //edit assets Detail
    AssetsDetails selectedAssetsDetails;

    public void editAsstsDetails(AssetsDetails assetsdetails) {
        this.selectedAssetsDetails = assetsdetails;
        this.assetsdetailsId = assetsdetails.getId();
        this.assetNumber = assetsdetails.getAssetNumber();

        if (assetsdetails.getAssetId() != null) {
            this.assetId = assetsdetails.getAssetId().getAssetId();
        } else {
            this.assetId = null;
        }

    }

    public AssetsDetails getSelectedAssetsDetails() {
        return selectedAssetsDetails;
    }

    public void setSelectedAssetsDetails(AssetsDetails selectedAssetsDetails) {
        this.selectedAssetsDetails = selectedAssetsDetails;
    }

    // delete assets details
    public void deleteAssetsDetails(Integer assetsDetailsid) {

        managerClient.deleteAssetsDetails(assetsDetailsid);
        assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType);

    }

    //addAssets
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

    //edit assets
    AssetsMaster selectedAssests;

    public void editAssts(AssetsMaster assetsMaster) {
        this.selectedAssests = assetsMaster;
        this.assetId = assetsMaster.getAssetId();
        this.assetName = assetsMaster.getAssetName();
    }

    // Task Master 
    public void deleteTask(Integer taskid) {
        managerClient.deleteTask(taskid);
        tasksList = managerClient.getAllTask(tasksGenericType);
    }

    // Task Details
    public void deleteTaskDetails(Integer taskdetailid) {
        managerClient.deleteTaskDetails(taskdetailid);
        taskdetailsList = managerClient.getAllTaskDetails(taskdetailsGenericType);
    }

    // Leave Master 
    //addAssets
    public void addLeaves() {
        try {
            LeaveMaster leave = new LeaveMaster();
            leave.setLeaveType(leavetype);

            managerClient.addLeaves(leave, leavetype);
            leavesList = managerClient.getAllLeaves(leavesGenericType);
            leavetype = ""; // Clear after adding
        } catch (ClientErrorException e) {
        }
    }

    public Collection<TaskMaster> getTasksList() {
        return tasksList;
    }

    public void setTasksList(Collection<TaskMaster> tasksList) {
        this.tasksList = tasksList;
    }

    public Collection<TaskDetails> getTaskdetailsList() {
        return taskdetailsList;
    }

    public void setTaskdetailsList(Collection<TaskDetails> taskdetailsList) {
        this.taskdetailsList = taskdetailsList;
    }

    // GETTER AND SETTER 
    public AssetsMaster getSelectedAssests() {
        return selectedAssests;
    }

    public void setSelectedAssests(AssetsMaster selectedAssests) {
        this.selectedAssests = selectedAssests;
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

    public Integer getAssetsdetailsId() {
        return assetsdetailsId;
    }

    public void setAssetsdetailsId(Integer assetsdetailsId) {
        this.assetsdetailsId = assetsdetailsId;
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

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    //========================================calculate Age========================================
//    private UserMaster usermaster;
    // Getter and setter for usermaster
    public void calculateAge() {
        if (usermaster.getDateOfBirth() != null) {
            LocalDate birthDate = usermaster.getDateOfBirth().toInstant()
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            usermaster.setAge(age);
        }
    }

    private int projectCount;
    private int departmentCount;
    private int designationCount;
    private int userCount;
    private int taskCount;

    // Add methods to fetch the counts (e.g., from database or services)
    public void loadCounts() {
        // Replace with actual logic to fetch counts
        userCount = (usersList != null) ? usersList.size() : 0;
        departmentCount = (departmentList != null) ? departmentList.size() : 0;
        designationCount = (designationList != null) ? designationList.size() : 0;
        projectCount = (projectdetailsList != null) ? projectdetailsList.size() : 0;
        taskCount = (taskdetailsList != null) ? taskdetailsList.size() : 0;
    }
    
    // Getters
    public int getTaskCount() {
        return taskCount;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public int getDesignationCount() {
        return designationCount;
    }

    public int getUserCount() {
        return userCount;
    }

}
