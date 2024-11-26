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

    //=== All Holidays Methods
    Collection<HolidayMaster> getAllHolidays();

    void addHoliday(String desc, Date holidayDate);

    //===  Add Attendance Methods
    Collection<AttendanceDetails> getAllAttendanceDetails();

    //===  All Users Methods
    Collection<UserMaster> getAllUsers();

    void addUser(UserMaster usermaster);

    //===  All Assets Methods
    Collection<AssetsMaster> getAllAssets();

    void addAsset(String assetName);

    void deleteAsset(Integer assetId);

    AssetsMaster getAssetById(Integer assetId);

    //===  All Asset Details Methods
    Collection<AssetsDetails> getAllAssetsDetails();

    void addAssetsDetails(BigInteger assetNumber, Date assignDate, Date returnDate, Integer assetId, Integer userId);

    //===  Add All Methods
    Collection<DepartmentMaster> getAllDepartments();
    
    void addDepartment(String deptName , String deptDesc , int managerId);

    //===  All Documnets Methods
    Collection<DocumentMaster> getAllDocuments();

    //===  All Document Details Methods
    Collection<DocumentDetails> getAllDocumentDetails();

    //===  All Grpups Methods
    Collection<GroupMaster> getAllGroups();

    //===  All Leaves Methods
    Collection<LeaveMaster> getAllLeaves();

    //===  All Leave Details Methods
    Collection<LeaveDetails> getAllLeaveDetails();

    //===  All Project Details Methods
    Collection<ProjectDetails> getAllProjectDetails();

    //===  All Task Methods
    Collection<TaskMaster> getAllTask();

    //===  All Task Details Methods
    Collection<TaskDetails> getAllTaskDetails();

    //===  All Performance Methods
    Collection<PerformanceDetails> getPerformanceDetails();

}
