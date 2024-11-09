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
import entity.HolidayMaster;
import entity.SkillsMaster;
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
    
    /**
     *
     * @return
     */
    Collection<AssetsMaster> getAllAssets();
    Collection<AssetsDetails> getAllAssetsDetails();
    Collection<DepartmentMaster> getAllDepartments();
//    void addDepartment(String deptname, String description); 
//    SkillsMaster getSkillById(int skillId);

//    void updateSkill(SkillsMaster skill);
//    void deleteskill(int skillId);
    //===  Holidays
    void addHoliday(String desc, Date holidayDate);
//    void updateHoliday(Integer holidayId, String desc, Date holidayDate);
//    void removeHoliday(Integer holidayId);
//    Collection<HolidayMaster> getAllHolidaysByDescription(String description);
//    Collection<HolidayMaster> getAllHolidaysByDate(Date holidayDate);
//    HolidayMaster getHolidayById(Integer holidayId);
//===  Assets

    void addAsset(String assetName);
    void deleteAsset(Integer assetId);

    AssetsMaster getAssetById(Integer assetId);
    SkillsMaster getSkillsById(Integer SkillsId);
 }
