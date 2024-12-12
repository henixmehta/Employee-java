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

    void deleteSkill(Integer skillId);

    SkillsMaster getSkillsById(Integer SkillsId);

    //=== All Designation Methods 
    Collection<DesignationMaster> getAllDesignation();

    void addDesig(String desginame, String desgirepo, Integer deptid);

    void deleteDesgination(int designationId);

    public void updateDesignation(Integer designationId, String designationName, String responsibility, Integer deptId);

    //=== All Holidays Methods
    Collection<HolidayMaster> getAllHolidays();

    void addHoliday(String desc, Date holidayDate
    );

    void deleteHoliday(Integer holidayInteger);

    //===  Add Attendance Methods
    Collection<AttendanceDetails> getAllAttendanceDetails();

    //===  All Users Methods
    Collection<UserMaster> getAllUsers();

    void addUser(UserMaster usermaster);

    void deleteUser(Integer userId);

    //=== User Details
    Collection<UserDetails> getAllUsersDetails();

    void addUserDetails(Integer userId, Integer grpId, Integer deptid, Integer skillId, Integer designationId, String e);

    void deleteUserDetails(Integer userId);

    //===  All Assets Methods
    Collection<AssetsMaster> getAllAssets();

    void addAsset(String assetName
    );

    void deleteAsset(Integer assetId
    );

    AssetsMaster getAssetById(Integer assetId
    );

    //===  All Asset Details Methods
    Collection<AssetsDetails> getAllAssetsDetails();

    void addAssetsDetails(BigInteger assetNumber, Date assignDate,
            Date returnDate, Integer assetId,
            Integer userId
    );

    void deleteAssetsDetails(Integer assetsDetailsId);

    //===  Add All Methods
    Collection<DepartmentMaster> getAllDepartments();

    void addOrUpdateDepartment(Integer deptId, String deptName,
            String deptDesc, int managerId
    );

    void deleteDepartment(Integer deptid
    );

    //===  All Documnets Methods
    Collection<DocumentMaster> getAllDocuments();

    void deleteDocument(Integer docid);

    //===  All Document Details Methods
    Collection<DocumentDetails> getAllDocumentDetails();

    void deleteDocumentDetails(Integer DocDetId);

    //===  All Grpups Methods
    Collection<GroupMaster> getAllGroups();

    void deleteGroup(Integer GrpId);

    //===  All Leaves Methods
    Collection<LeaveMaster> getAllLeaves();

    void addLeaves(Integer leaveTypeId, String leaveType);

    void deleteLeaves(Integer LeaveId);

    //===  All Leave Details Methods
    Collection<LeaveDetails> getAllLeaveDetails();

//    void addLeaveDetails(Date fromeDate, Date toDate, String status, String reactReason, Integer userId, Integer leaveTypeId);

    void deleteLeaveDetails(Integer leaveDetailsId);

    //===  All Project Details Methods
    Collection<ProjectDetails> getAllProjectDetails();

    
    public void updateProjectStatus(Integer projectId, String newStatus) ;
    void deleteProjectDetails(Integer proDetailsId);

    //===  All Task Methods
    Collection<TaskMaster> getAllTask();

    void deleteTask(Integer taskId);

    //===  All Task Details Methods
    Collection<TaskDetails> getAllTaskDetails();

    void deleteTaskDetails(Integer taskDeteId);

    //===  All Performance Methods
    Collection<PerformanceDetails> getPerformanceDetails();

    void deletePrform(Integer performnceDetailsId);
}
