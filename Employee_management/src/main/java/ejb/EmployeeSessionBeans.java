/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.AttendanceDetails;
import entity.LeaveDetails;
import entity.UserMaster;
import java.util.Collection;
import java.util.Collections;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Henil
 */
@Stateless
public class EmployeeSessionBeans implements EmployeeSessionBeansLocal {

    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    @Override
    public Collection<UserMaster> getEmployeeDetailsByUserId(int userId) {
        return em.createQuery("SELECT u FROM UserMaster u WHERE u.userId = :userId", UserMaster.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public Collection<AttendanceDetails> getEmployeeAttendence(int userId) {
        try {
            return em.createQuery("SELECT a FROM AttendanceDetails a WHERE a.userId = :userId", AttendanceDetails.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            // Log the exception and return an empty collection
            System.err.println("Error fetching attendance records for user ID: " + userId);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<LeaveDetails> getEmployeeLeaves() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addEmployeeLeave(LeaveDetails leave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addEmployeeAttendence(AttendanceDetails attendance) {
    //     try {
    //         em.persist(attendance); // Persist the attendance record
    //     } catch (Exception e) {
    //         // Log the exception
    //         System.err.println("Error adding attendance record: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }

}
