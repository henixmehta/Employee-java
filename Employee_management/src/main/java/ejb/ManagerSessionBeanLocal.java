/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface ManagerSessionBeanLocal {

    Collection<SkillsMaster> getAllSkill();

     SkillsMaster getSkillById(int skillId);
   
    
    void addSkill(SkillsMaster skill);

    void updateSkill(SkillsMaster skill);

    void deleteskill(int skillId);
}
