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
public class AdminSessionBean implements AdminSessionBeanLocal {
    
    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;
    
    @Override
    public Collection<SkillsMaster> getAllSkill() {
        return em.createNamedQuery("SkillsMaster.findAll").getResultList();
    }
    
  
}
