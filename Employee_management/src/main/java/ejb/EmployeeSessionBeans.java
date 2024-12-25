/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.AttendanceDetails;
import entity.LeaveDetails;
import entity.LeaveMaster;
import entity.UserMaster;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

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
        System.out.println("ejb.EmployeeSessionBeans.getEmployeeAttendence() " + userId);
        try {
            UserMaster user = em.find(UserMaster.class, userId);
            return em.createQuery("SELECT a FROM AttendanceDetails a WHERE a.userId = :userId", AttendanceDetails.class)
                    .setParameter("userId", user)
                    .getResultList();
        } catch (Exception e) {
            // Log the exception and return an empty collection
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Collection<LeaveDetails> getEmployeeLeaves(int userId) {
        try {
            return em.createQuery("SELECT l FROM LeaveDetails l WHERE l.userId.userId = :userId", LeaveDetails.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (Exception e) {
            // Log the exception and return an empty collection
            System.err.println("Error fetching leave details for user ID: " + userId);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void addEmployeeLeave(LeaveDetails leave) {
        try {
            em.persist(leave); // Persist the leave record
        } catch (Exception e) {
            System.err.println("Error adding employee leave: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployeeAttendence(AttendanceDetails attendance) {
        try {
            em.persist(attendance); // Persist the attendance record
        } catch (Exception e) {
            // Log the exception
            System.err.println("Error adding attendance record: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Checks if the user has already checked in today.
     *
     * @param userId the ID of the user
     * @return true if the user has checked in today; false otherwise
     */
    public boolean hasCheckedInToday(int userId) {
        Date today = new Date();
        long count = em.createQuery("SELECT COUNT(a) FROM AttendanceDetails a WHERE a.userId.userId = :userId AND a.date = :today", Long.class)
                .setParameter("userId", userId)
                .setParameter("today", today, TemporalType.DATE) // Ensure comparison is by date only
                .getSingleResult();
        return count > 0;
    }

    @Override
    public boolean hasCheckedOutToday(int userId) {
        Date today = new Date();
        long count = em.createQuery("SELECT COUNT(a) FROM AttendanceDetails a WHERE a.userId.userId = :userId AND a.date = :today AND a.checkOut IS NOT NULL", Long.class)
                .setParameter("userId", userId)
                .setParameter("today", today)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public AttendanceDetails getTodayAttendanceByUserId(int userId) {
        Date today = new Date();
        try {
            return em.createQuery("SELECT a FROM AttendanceDetails a WHERE a.userId.userId = :userId AND a.date = :today", AttendanceDetails.class)
                    .setParameter("userId", userId)
                    .setParameter("today", today)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateEmployeeAttendance(AttendanceDetails attendance) {
        em.merge(attendance);
    }

    @Override
    public Collection<LeaveMaster> getLeaveTypes() {
        try {
            return em.createQuery("SELECT l FROM LeaveMaster l", LeaveMaster.class).getResultList();
        } catch (Exception e) {
            System.err.println("Error fetching leave types: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public LeaveMaster getLeaveTypeById(int leaveTypeId) {
        try {
            return em.find(LeaveMaster.class, leaveTypeId);
        } catch (Exception e) {
            System.err.println("Error fetching LeaveMaster by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
