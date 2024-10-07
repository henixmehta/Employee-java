/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package repository;

import entity.UserMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henil
 */
@Stateless
public class EmployeeBeans implements EmployeeBeansLocal {

    @PersistenceContext(unitName = "my_per_unit")
    EntityManager em;
    @Override
    public Collection<UserMaster> getAllEmployee() {
        Collection<UserMaster> emp = em.createNamedQuery("UserMaster.findAll").getResultList();
        return emp;
    }
    
    
}
