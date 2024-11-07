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
    void addSkill(String sname, String desc);
   
    Collection<HolidayMaster> getAllHolidays();
   
    Collection<AssetsMaster> getAllAssets();
    
    Collection<DepartmentMaster> getAllDepartments();
//    void addDepartment(String deptname, String description); 
}
