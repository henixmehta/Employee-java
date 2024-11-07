/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.AssetsMaster;
import entity.DepartmentMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface ManagerSessionBeanLocal {

    //===  Skills
    Collection<SkillsMaster> getAllSkill();
<<<<<<< HEAD
    void addSkill(String sname, String desc);
   
    Collection<HolidayMaster> getAllHolidays();
   
    Collection<AssetsMaster> getAllAssets();
    
    Collection<DepartmentMaster> getAllDepartments();
//    void addDepartment(String deptname, String description); 
=======
//    SkillsMaster getSkillById(int skillId);

    void addSkill(String sname, String desc);
//    void updateSkill(SkillsMaster skill);
//    void deleteskill(int skillId);

    //===  Holidays
    Collection<HolidayMaster> getAllHolidays();

    void addHoliday(String desc, Date holidayDate);
//    void updateHoliday(Integer holidayId, String desc, Date holidayDate);
//    void removeHoliday(Integer holidayId);
//    Collection<HolidayMaster> getAllHolidaysByDescription(String description);
//    Collection<HolidayMaster> getAllHolidaysByDate(Date holidayDate);
//    HolidayMaster getHolidayById(Integer holidayId);
//===  Assets
    Collection<AssetsMaster> getAllAssets();

    void addAsset(String assetName);

>>>>>>> 67364a8e6a81643c95e278c3bf07b4ae69e0c903
}
