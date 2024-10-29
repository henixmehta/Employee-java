/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

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
public class ManagerSessionBean implements ManagerSessionBeanLocal {

    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    @Override
    public Collection<SkillsMaster> getAllSkill() {
        return em.createNamedQuery("SkillsMaster.findAll").getResultList();
    }

    @Override
    public SkillsMaster getSkillById(int skillId) {
        try {
            return em.createNamedQuery("SkillsMaster.findBySkillId", SkillsMaster.class)
                    .setParameter("skillid", skillId)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSkill(SkillsMaster skill) {
        em.persist(skill); // Persist the new skill
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void updateSkill(SkillsMaster skill) {
        em.merge(skill);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteskill(int skillId) {
        SkillsMaster skill = em.find(SkillsMaster.class, skillId);
        if (skill != null) {
            em.remove(skill);
        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
