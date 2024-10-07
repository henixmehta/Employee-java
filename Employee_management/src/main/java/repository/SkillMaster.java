/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package repository;

import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henil
 */
@Stateless
public class SkillMaster implements SkillMasterLocal {

    @PersistenceContext(unitName = "my_per_unit")
    EntityManager em;
     

    @Override
    public Collection<SkillsMaster> getAllSkill() {
        //        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        Collection<SkillsMaster>  Skills = em.createNamedQuery("SkillsMaster.findAll").getResultList();
        return Skills;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
