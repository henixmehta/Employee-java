/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

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
import entity.UserDetails;
import entity.UserMaster;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface ManagerSessionBeanLocal {

    //=== All SKILL Methods 
    Collection<SkillsMaster> getAllSkill();
    void addSkill(String sname, String desc);
    SkillsMaster getSkillsById(Integer SkillsId);
//    SkillsMaster getSkillsByName(String sname);

    //=== All Designation Methods 
    Collection<DesignationMaster> getAllDesignation();
    void addDesig(String desginame, String desgirepo, Integer deptid);
    public void updateDesignation(Integer designationId, String designationName, String responsibility, Integer deptId);

//    DesignationMaster getDesignationById(Integer designationId);
//    DesignationMaster getDesignationByName(String desginame);
//    DesignationMaster getDesignationByDeptartment(Integer deptid);
//            
    //=== All Holidays Methods
    Collection<HolidayMaster> getAllHolidays();
    void addHoliday(String desc, Date holidayDate
    );

    //===  Add Attendance Methods
    Collection<AttendanceDetails> getAllAttendanceDetails();

    //===  All Users Methods
    Collection<UserMaster> getAllUsers();
    void addUser(UserMaster usermaster);
//    void UpdateUser(Integer userId,String userName,String emailId,BigInteger phoneNo,Date dateOfBirth,
//    Integer age,String gender,Date joiningDate,String address,BigInteger emergencyContact,String profileImage,
//    String companyEmail,String password,Integer reportingTo,BigInteger salary,String qualification,String currentExperience);
    void UpddateUser(UserMaster user);
    
    //=== User Details
    Collection<UserDetails> getAllUsersDetails();
    void addUserDetails(Integer userId, Integer grpId, Integer deptid, Integer skillId, Integer designationId);

    //===  All Assets Methods
    Collection<AssetsMaster> getAllAssets();
    void addAsset(String assetName);
    AssetsMaster getAssetById(Integer assetId);

    //===  All Asset Details Methods
    Collection<AssetsDetails> getAllAssetsDetails();
    void addAssetsDetails(BigInteger assetNumber, Date assignDate,Date returnDate, Integer assetId,Integer userId);

    //===  Add All Methods
    Collection<DepartmentMaster> getAllDepartments();
    void addOrUpdateDepartment(Integer deptId, String deptName,String deptDesc, int managerId);

    //===  All Documnets Methods
    Collection<DocumentMaster> getAllDocuments();

    //===  All Document Details Methods
    Collection<DocumentDetails> getAllDocumentDetails();

    //===  All Grpups Methods
    Collection<GroupMaster> getAllGroups();
    public void addGroups(String gname);

    //===  All Leaves Methods
    Collection<LeaveMaster> getAllLeaves();
    void addLeaves(String leaveType);

    //===  All Leave Details Methods
    Collection<LeaveDetails> getAllLeaveDetails();

//    void addLeaveDetails(Date fromeDate, Date toDate, String status, String reactReason, Integer userId, Integer leaveTypeId);
    //===  All Project Details Methods
    Collection<ProjectDetails> getAllProjectDetails();
    public void updateProjectStatus(Integer projectId, String newStatus);

    //===  All Task Methods
    Collection<TaskMaster> getAllTask();

    //===  All Task Details Methods
    Collection<TaskDetails> getAllTaskDetails();

    //===  All Performance Methods
    Collection<PerformanceDetails> getPerformanceDetails();

    //=========delete alll methods =======================
//    void deletePrform(Integer performnceDetailsId); //optional
//    void deleteTaskDetails(Integer taskDeteId);    
    void deleteSkill(Integer skillId);
//    void deleteDesgination(int designationId);
//    void deleteHoliday(Integer holidayInteger);
//    void deleteUser(Integer userId); ////// status active in active
//    void deleteUserDetails(Integer userId);
      void deleteAsset(Integer assetId);
      void deleteAssetsDetails(Integer assetsDetailsId);  /// status 
//    void deleteTask(Integer taskId);
      void deleteTaskDetails(Integer taskDetatilsId); ////set status
//    void deleteDepartment(Integer deptid
//    );
//    void deleteDocument(Integer docid);
//    void deleteProjectDetails(Integer proDetailsId);
//    void deleteLeaves(Integer LeaveId);
//    void deleteLeaveDetails(Integer leaveDetailsId);    ///approve reacject
//    void deleteGroup(Integer GrpId);
//    void deleteDocumentDetails(Integer DocDetId);
}
