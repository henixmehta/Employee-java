/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.AttendanceDetails;
import entity.LeaveDetails;
import entity.UserMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Henil
 */
@Local
public interface EmployeeSessionBeansLocal {

    public Collection<UserMaster> getEmployeeDetailsByUserId(int userId);

    public Collection<AttendanceDetails> getEmployeeAttendence(int userId);

    Collection<LeaveDetails> getEmployeeLeaves();

    void addEmployeeLeave(LeaveDetails leave);

    void addEmployeeAttendence(AttendanceDetails attendence);

    public boolean hasCheckedInToday(int userId);

    boolean hasCheckedOutToday(int userId);

    AttendanceDetails getTodayAttendanceByUserId(int userId);

    void updateEmployeeAttendance(AttendanceDetails attendance);

}
