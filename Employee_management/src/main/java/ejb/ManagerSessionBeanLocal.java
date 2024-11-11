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
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface ManagerSessionBeanLocal {

    //===  Skills
    Collection<SkillsMaster> getAllSkill();

    Collection<DesignationMaster> getAllDesignation();

    void addSkill(String sname, String desc);

    void deleteSkill(Integer skillId);

    Collection<HolidayMaster> getAllHolidays();

    Collection<AttendanceDetails> getAllAttendanceDetails();

    Collection<UserMaster> getAllUsers();

    /**
     *
     * @return
     */
    Collection<AssetsMaster> getAllAssets();

    Collection<AssetsDetails> getAllAssetsDetails();

    Collection<DepartmentMaster> getAllDepartments();

    Collection<DocumentMaster> getAllDocuments();

    Collection<DocumentDetails> getAllDocumentDetails();

    Collection<GroupMaster> getAllGroups();

    Collection<LeaveMaster> getAllLeaves();

    Collection<LeaveDetails> getAllLeaveDetails();

    Collection<ProjectDetails> getAllProjectDetails();

    Collection<TaskMaster> getAllTask();

    Collection<TaskDetails> getAllTaskDetails();

    Collection<PerformanceDetails> getPerformanceDetails();

    //===  Holidays
    void addHoliday(String desc, Date holidayDate);

    //===  Assets
    void addAsset(String assetName);

    void deleteAsset(Integer assetId);

    void addDesig(String desginame, String desgirepo, Integer deptid);

    void addUser(UserMaster usermaster);

    AssetsMaster getAssetById(Integer assetId);

    SkillsMaster getSkillsById(Integer SkillsId);
}
