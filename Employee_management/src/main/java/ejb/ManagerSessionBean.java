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
    }

    @Override
    public void addSkill(SkillsMaster skill) {
        em.persist(skill);
        em.flush();
    }

    @Override
    public void updateSkill(SkillsMaster skill) {
        em.merge(skill);
    }

    @Override
    public void deleteskill(int skillId) {
        SkillsMaster skill = em.find(SkillsMaster.class, skillId);
        if (skill != null) {
            em.remove(skill); // Delete skill
        }
    }

}
