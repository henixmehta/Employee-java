package cdi;

import client.ManagerClient;
import ejb.ManagerSessionBean;
import ejb.ManagerSessionBeanLocal;
import entity.*;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

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
    private Collection<UserDetails> userDetailsList;

    //============== Skill variables ===============
    private String sname;
    private String desc;
    //============== Holiday variables ===============
    private String holidayDesc;
    private Date holidayDate;
    //============== Asset variables ===============
    private String assetName;
    //============== Designation variables ===============
    private Integer designationId;
    private String designationName;
    private String responsibility;
    private Integer departmentId;
    //============== Department variables ===============
    private Integer deptId;
    private String deptName;
    private String deptDesc;
    private int managerId;

    private Integer selectedDeptId;
    //============== Asset Details variables ===============
    Integer assetsdetailsId;
    private Integer assetId;
    private BigInteger assetNumber;
    private String assignDate;
    private String returnDate;
    private Integer userId;
    //============== Group variables ===============
    private String groupname;
    //============== Leave variables ===============
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
    private final GenericType<Collection<UserDetails>> userDetailsGenericType = new GenericType<Collection<UserDetails>>() {
    };

    @Inject
    private ManagerSessionBeanLocal managerSessionBean;

    // Generic types for REST client responses
    public ManagerBeans() {
//        managerClient = new ManagerClient();
//        loadCounts();

    }

    private void safeLoad(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        }
    }

//    @PostConstruct
//    public void init() {
//        try {
//            managerClient = new ManagerClient();
//            projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType);
//            groupsList = managerClient.getAllGroups(groupsGenericType);
//
//            skillsList = managerClient.getAllSkills(skillsGenericType);
//            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
//            assetsList = managerClient.getAllAssets(assetsGenericType);
//            departmentList = managerClient.getAllDepartments(deptGenericType);
//            designationList = managerClient.getAllDesignation(designationGenericType);
//            assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType);
//            attendanceDetailsList = managerClient.getAllAttendenceDetails(attendanceDetailsGenericType);
//            usersList = managerClient.getAllUsers(usersGenericType);
//            userDetailsList = managerClient.getAllUserDetails(userDetailsGenericType);
//            documentsList = managerClient.getAllDocuments(documnentmasterGenericType);
//            documentsdetailsList = managerClient.getAllDocumentDetails(documnentdetailsGenericType);
//            leavesList = managerClient.getAllLeaves(leavesGenericType);
//            LeavedetailsList = managerClient.getAllLeaveDetails(leavesdetailsGenericType);
//            performanceList = managerClient.getPerformanceDetails(performanceGenericType);
//            tasksList = managerClient.getAllTask(tasksGenericType);
//            taskdetailsList = managerClient.getAllTaskDetails(taskdetailsGenericType);
//
//        } catch (ClientErrorException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @PostConstruct
    public void init() {
        managerClient = new ManagerClient();
        ExecutorService executor = Executors.newFixedThreadPool(4); // Use 4 threads, adjust as needed

        List<Runnable> tasks = List.of(
                () -> safeLoad(() -> projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType)),
                () -> safeLoad(() -> groupsList = managerClient.getAllGroups(groupsGenericType)),
                () -> safeLoad(() -> skillsList = managerClient.getAllSkills(skillsGenericType)),
                () -> safeLoad(() -> holidaysList = managerClient.getAllHolidays(holidaysGenericType)),
                () -> safeLoad(() -> assetsList = managerClient.getAllAssets(assetsGenericType)),
                () -> safeLoad(() -> departmentList = managerClient.getAllDepartments(deptGenericType)),
                () -> safeLoad(() -> designationList = managerClient.getAllDesignation(designationGenericType)),
                () -> safeLoad(() -> assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType)),
                () -> safeLoad(() -> attendanceDetailsList = managerClient.getAllAttendenceDetails(attendanceDetailsGenericType)),
                () -> safeLoad(() -> usersList = managerClient.getAllUsers(usersGenericType)),
                //                () -> safeLoad(() -> userDetailsList = managerClient.getAllUserDetails(userDetailsGenericType)),
                () -> safeLoad(() -> documentsList = managerClient.getAllDocuments(documnentmasterGenericType)),
                () -> safeLoad(() -> documentsdetailsList = managerClient.getAllDocumentDetails(documnentdetailsGenericType)),
                () -> safeLoad(() -> leavesList = managerClient.getAllLeaves(leavesGenericType)),
                () -> safeLoad(() -> LeavedetailsList = managerClient.getAllLeaveDetails(leavesdetailsGenericType)),
                () -> safeLoad(() -> performanceList = managerClient.getPerformanceDetails(performanceGenericType)),
                () -> safeLoad(() -> tasksList = managerClient.getAllTask(tasksGenericType)),
                () -> safeLoad(() -> taskdetailsList = managerClient.getAllTaskDetails(taskdetailsGenericType))
        );

        tasks.forEach(executor::submit);

        executor.shutdown();
        try {
            executor.awaitTermination(15, TimeUnit.SECONDS); // Wait up to 5 seconds for tasks to complete
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted state
            e.printStackTrace();
        }
        loadCounts();
    }
    //======================== Skill management methods ==================================================

    public void addSkill() {
        try {
            boolean skillExists = skillsList.stream()
                    .anyMatch(skill -> skill.getSkillName().equalsIgnoreCase(sname));

            if (skillExists) {
                System.out.println("Skill name already exists.");
            }
            SkillsMaster newSkill = new SkillsMaster();
            newSkill.setSkillName(sname);
            newSkill.setDescription(desc);
            managerClient.addSkill(newSkill, sname, desc);
            skillsList = managerClient.getAllSkills(skillsGenericType);
            sname = "";
            desc = "";
        } catch (ClientErrorException e) {
            System.out.println("Failed to add skill.");
        }
    }

    //Delete Skill
    public void deleteSkill(int skillId) {
        managerClient.deleteSkills(skillId);
        skillsList = managerClient.getAllSkills(skillsGenericType);
    }

    // Edit  Skill
    SkillsMaster SelectedKill;

    public void editsKill(SkillsMaster skillMaster) {
        this.SelectedKill = skillMaster;
        this.sname = skillMaster.getSkillName();
        this.desc = skillMaster.getDescription();
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
    //================================================ user Master ================================================
    private UserMaster usermaster = new UserMaster();
    private UserDetails userdetails = new UserDetails();
    private UserRequestWrapper wrapper = new UserRequestWrapper();
    private Integer groupId;
    private Integer skillId;

    //add userMaster
    public String addUser() {
        userdetails.setDeptId(departmentId);
        userdetails.setDesignationId(designationId);
        userdetails.setGroupId(groupId);
        userdetails.setSkillId(skillId);
        wrapper.setUserDetails(userdetails);
        wrapper.setUserMaster(usermaster);
        managerClient.addUser(wrapper);
        usersList = managerClient.getAllUsers(usersGenericType);
        resetUserMasterFields();
        return "ViewUserDetails.xhtml";
    }

    public void handleUserAction() {
        if (this.usermaster != null && this.usermaster.getUserId() != null) {
            UpdateUser();
        } else {
            addUser();
        }
    }

    public String editUser(UserMaster userMaster) {
        this.usermaster = userMaster;
        UserDetails userDetails = managerSessionBean.findUserDetailsByUserId(userMaster.getUserId());
        this.departmentId = userDetails.getDeptId();
        this.designationId = userDetails.getDesignationId();
        this.groupId = userDetails.getGroupId();
        this.skillId = userDetails.getSkillId();

        return "UserRegistration.xhtml?faces-redirect=true";
    }

    public String UpdateUser() {
        userdetails.setDeptId(departmentId);
        userdetails.setDesignationId(designationId);
        userdetails.setGroupId(groupId);
        userdetails.setSkillId(skillId);
        wrapper.setUserDetails(userdetails);
        wrapper.setUserMaster(usermaster);
        managerClient.updateUser(wrapper);
        usersList = managerClient.getAllUsers(usersGenericType);
        resetUserMasterFields();
        return "ViewUserDetails.xhtml";
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
    public void deleteUser(Integer userId) {
        managerClient.deleteUser(userId);
        System.out.println("User ID : " + userId);
        usersList = managerClient.getAllUsers(usersGenericType);

//        resetUserMasterFields();
    }

    //================================================ Department Details ================================================
    public Collection<DepartmentMaster> getDepartmentList() {
        return departmentList;
    }

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
            // Check if the department name already exists
            boolean nameExists = departmentList.stream()
                    .anyMatch(dept -> dept.getDeptName().equalsIgnoreCase(deptName)
                    && !dept.getDeptId().equals(selectedDeptId)); // Exclude the current department being edited

            if (nameExists) {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Department name already exists.");
                return; // Stop further processing
            }

            // Create or update the department
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

            // Call REST client to add or update the department
            managerClient.addOrUpdateDepartment(dept, selectedDeptId, deptName, deptDesc, managerId);

            // Refresh the department list
            departmentList = managerClient.getAllDepartments(deptGenericType);

            // Reset form fields
            resetDepartmentForm();

            addMessage(FacesMessage.SEVERITY_INFO, "Success", "Department saved successfully.");
        } catch (ClientErrorException e) {
            e.printStackTrace();
            addMessage(FacesMessage.SEVERITY_ERROR, "Error", "An unexpected error occurred.");
        }
    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            facesContext.addMessage(null, new FacesMessage(severity, summary, detail));
        } else {
            System.err.println("FacesContext is null. Cannot display message: " + summary + " - " + detail);
        }
    }

    public void deleteDepartment(Integer deptId) {
        managerClient.deleteDepartment(deptId);
        departmentList = managerClient.getAllDepartments(deptGenericType);

    }

    private void resetDepartmentForm() {
        selectedDeptId = null;
        deptName = "";
        deptDesc = "";
        managerId = 0;
    }

    //=============================================== Designation Details ================================================
    public String addDesignation() {
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
        return "success";

    }

    public String saveDesignation() {
        if (selectedDesgination == null) {
            return addDesignation(); // Call the add method
        } else {
            return updateDesignation(); // Call the update method
        }
    }

    private DesignationMaster selectedDesgination;

    public void editDesgination(DesignationMaster desg) {
        this.selectedDesgination = desg;
        this.designationId = desg.getDesignationId();
        this.designationName = desg.getDesignation();
        this.responsibility = desg.getResponsibility();
        this.deptId = desg.getDepartmentId().getDeptId();
    }

    public String updateDesignation() {
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

            designationList = managerClient.getAllDesignation(designationGenericType);
            this.selectedDesgination = null;
            resetDesignationForm();
        } catch (ClientErrorException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
        return "success";
    }

// Reset the designation form fields
    private void resetDesignationForm() {
        designationId = null;
        designationName = "";
        responsibility = "";
        deptId = null;
    }

    //delete Desgination
    public void deleteDesgination(Integer designationId) {
        managerClient.deleteDesgination(designationId);
        designationList = managerClient.getAllDesignation(designationGenericType);
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

    //=================================================== AssetsDetails ===================================
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

    // delete assets details
    public void deleteAssetsDetails(Integer assetsDetailsid) {
        managerClient.deleteAssetsDetails(assetsDetailsid);
        assetdetailsList = managerClient.getAllAssetsDetails(assetdetailsGenericType);
    }

    //=============================================== Assets Master =========================================
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

    //=========================================== Task Details ============================================
    private TaskDetails taskdetails = new TaskDetails();
    private TaskMaster taskmaster = new TaskMaster();
    private UserMaster userMasterAssignBy = new UserMaster();
    private UserMaster userMasterAssignTo = new UserMaster();
    private TaskWrapper task = new TaskWrapper();
    private Integer assignTo; // Example backing bean property
    private Integer assignBy;

    public String addTaskDetails() {
        task.setTaskmaster(taskmaster);
        userMasterAssignBy.setUserId(assignBy);
        taskdetails.setAssignBy(userMasterAssignBy);
        userMasterAssignTo.setUserId(assignTo);
        taskdetails.setAssignTo(userMasterAssignTo);
        task.setTaskDetails(taskdetails);

//        taskdetails.setAssignBy(usermaster);
//        taskdetails.setAssignTo(usermaster);
        managerClient.addTaskDetails(task);
        tasksList = managerClient.getAllTask(tasksGenericType);
        return "DisplayTask.xhtml";
    }

    public Integer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Integer assignTo) {
        this.assignTo = assignTo;
    }

    public Integer getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(Integer assignBy) {
        this.assignBy = assignBy;
    }

    public String deleteTaskDetails(Integer taskdetailid) {
        managerClient.deleteTaskDetails(taskdetailid);
        tasksList = managerClient.getAllTask(tasksGenericType);
        taskdetailsList = managerClient.getAllTaskDetails(taskdetailsGenericType);
        return "DisplayTask.xhtml";
    }

    // ============================= Leave Master ======================================================
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

    public void updateLeaveStatus(LeaveDetails leave) {
        try {

            // Call the client method to update the designation
            managerClient.updateLeaveStatus(leave);

            LeavedetailsList = managerClient.getAllLeaveDetails(leavesdetailsGenericType);
           
        } catch (ClientErrorException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }
    // ========================================== Project Details =========================================
    ProjectDetails project = new ProjectDetails();

    public void addProject() {
        managerClient.addProject(project);
        projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType);
        resetprojectfield();
    }

    public void deleteProject(Integer projectId) {
        managerClient.deleteProjectDetails(projectId);
        projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType);
    }

    public void resetprojectfield() {
        project.setProjectId(null);
        project.setProjectName(null);
        project.setDescription(null);
        project.setEndDate(null);
        project.setStartDate(null);
        project.setDueDate(null);
        project.setOnHoldDays(null);
        project.setOnHoldReason(null);
        project.setStatus(null);
    }
//    ProjectDetails selectedproject = new ProjectDetails();

    public void editProject(ProjectDetails selectedProject) {
        this.project = selectedProject; // Load selected project into the form.
    }

    public void updateProject(ProjectDetails project) {
        try {

            // Call the client method to update the designation
            managerClient.updateProject(project);

            projectdetailsList = managerClient.getAllProjectDetails(projectdetailsGenericType);
            resetprojectfield();
        } catch (ClientErrorException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    public void handleProjectAction() {
        if (project.getProjectId() != null) {
            updateProject(project); // Update if projectId is not null
        } else {
            addProject(); // Add if projectId is null
        }
    }

    // ====================================== GETTER AND SETTER ===============================================
    public Collection<UserDetails> getUserDetailsList() {
        return userDetailsList;
    }

    public void setUserDetailsList(Collection<UserDetails> userDetailsList) {
        this.userDetailsList = userDetailsList;
    }

    public TaskDetails getTaskdetails() {
        return taskdetails;
    }

    public void setTaskdetails(TaskDetails taskdetails) {
        this.taskdetails = taskdetails;
    }

    public TaskMaster getTaskmaster() {
        return taskmaster;
    }

    public void setTaskmaster(TaskMaster taskmaster) {
        this.taskmaster = taskmaster;
    }

    public TaskWrapper getTask() {
        return task;
    }

    public void setTask(TaskWrapper task) {
        this.task = task;
    }

    public ProjectDetails getProject() {
        return project;
    }

    public void setProject(ProjectDetails project) {
        this.project = project;
    }

    public Collection<UserMaster> getUsersList() {
        return usersList;
    }

    public SkillsMaster getSelectedKill() {
        return SelectedKill;
    }

    public void setSelectedKill(SkillsMaster SelectedKill) {
        this.SelectedKill = SelectedKill;
    }

    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    public AssetsDetails getSelectedAssetsDetails() {
        return selectedAssetsDetails;
    }

    public void setSelectedAssetsDetails(AssetsDetails selectedAssetsDetails) {
        this.selectedAssetsDetails = selectedAssetsDetails;
    }

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

    public Collection<TaskMaster> getTasksList() {
        return tasksList;
    }

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

    public Collection<AssetsMaster> getAssetsList() {
        return assetsList;
    }

    public Collection<AssetsDetails> getAssetsDetailsList() {
        return assetdetailsList;
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

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public DesignationMaster getSelectedDesgination() {
        return selectedDesgination;
    }

    public void setSelectedDesgination(DesignationMaster selectedDesgination) {
        this.selectedDesgination = selectedDesgination;
    }

    public ManagerClient getManagerClient() {
        return managerClient;
    }

    public void setManagerClient(ManagerClient managerClient) {
        this.managerClient = managerClient;
    }

    public Collection<AssetsDetails> getAssetdetailsList() {
        return assetdetailsList;
    }

    public void setAssetdetailsList(Collection<AssetsDetails> assetdetailsList) {
        this.assetdetailsList = assetdetailsList;
    }

    public Collection<DocumentDetails> getDocumentsdetailsList() {
        return documentsdetailsList;
    }

    public void setDocumentsdetailsList(Collection<DocumentDetails> documentsdetailsList) {
        this.documentsdetailsList = documentsdetailsList;
    }

    public Collection<GroupMaster> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(Collection<GroupMaster> groupsList) {
        this.groupsList = groupsList;
    }

    public Collection<LeaveMaster> getLeavesList() {
        return leavesList;
    }

    public void setLeavesList(Collection<LeaveMaster> leavesList) {
        this.leavesList = leavesList;
    }

    public Collection<LeaveDetails> getLeavedetailsList() {
        return LeavedetailsList;
    }

    public void setLeavedetailsList(Collection<LeaveDetails> LeavedetailsList) {
        this.LeavedetailsList = LeavedetailsList;
    }

    public Collection<PerformanceDetails> getPerformanceList() {
        return performanceList;
    }

    public void setPerformanceList(Collection<PerformanceDetails> performanceList) {
        this.performanceList = performanceList;
    }

    public Collection<ProjectDetails> getProjectdetailsList() {
        return projectdetailsList;
    }

    public void setProjectdetailsList(Collection<ProjectDetails> projectdetailsList) {
        this.projectdetailsList = projectdetailsList;
    }

    public UserDetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(UserDetails userdetails) {
        this.userdetails = userdetails;
    }

    public UserRequestWrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(UserRequestWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    //======================================== calculate Age ================================================
    //  private UserMaster usermaster;
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
    //======================================== ALL DisplayCount Details =======================================
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

    //  All Count Getters
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

    public ManagerSessionBeanLocal getManagerSessionBean() {
        return managerSessionBean;
    }

    public void setManagerSessionBean(ManagerSessionBeanLocal managerSessionBean) {
        this.managerSessionBean = managerSessionBean;
    }

}
