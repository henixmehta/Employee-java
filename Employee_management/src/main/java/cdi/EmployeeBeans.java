/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.EmployeeSessionBeansLocal;
import entity.AttendanceDetails;
import entity.LeaveDetails;
import entity.LeaveMaster;
import entity.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Henil
 */
@Named(value = "employeeBeans")
@SessionScoped
public class EmployeeBeans implements Serializable {

    private Collection<UserMaster> employeeDetails;
    private Collection<AttendanceDetails> attendanceDetails;
    private int userId;
    private boolean hasCheckedInToday;  // Tracks if user has checked in today
    private boolean hasCheckedOutToday; // Tracks if user has checked out today
    private Collection<LeaveDetails> leaveDetails; // Collection to store leave details
    private Collection<LeaveMaster> leaveTypes;    // Collection of leave types
    private int leaveTypeId;                       // To store selected leave type ID
    private Date leaveStartDate;
    private Date leaveEndDate;
    private String leaveReason;
    private String leavestatus;

    public String getStatus() {
        return leavestatus;
    }

    public void setStatus(String leavestatus) {
        this.leavestatus = leavestatus;
    }

    @Inject
    private EmployeeSessionBeansLocal employeeSessionBeans;

    public EmployeeBeans() {
        // Retrieve the userId from the session during initialization
        FacesContext context = FacesContext.getCurrentInstance();
        Integer sessionUserId = (Integer) context.getExternalContext().getSessionMap().get("userId");
        if (sessionUserId != null) {
            userId = sessionUserId;
        }
    }

    @PostConstruct
    public void init() {
        // Check if the user has already checked in and checked out today
        hasCheckedInToday = employeeSessionBeans.hasCheckedInToday(userId);
        hasCheckedOutToday = employeeSessionBeans.hasCheckedOutToday(userId);
    }

    //========================================================================== Employee Details
    public Collection<UserMaster> getEmployeeDetails() {
        if (employeeDetails == null) {
            employeeDetails = employeeSessionBeans.getEmployeeDetailsByUserId(userId);
        }
        return employeeDetails;
    }

    public void setEmployeeDetails(Collection<UserMaster> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    //========================================================================== Leave Management
    public Collection<LeaveDetails> getLeaveDetails() {
        if (leaveDetails == null) {
            leaveDetails = employeeSessionBeans.getEmployeeLeaves(userId);
        }
        return leaveDetails;
    }

    public void setLeaveDetails(Collection<LeaveDetails> leaveDetails) {
        this.leaveDetails = leaveDetails;
    }

    public Collection<LeaveMaster> getLeaveTypes() {
        if (leaveTypes == null) {
            leaveTypes = employeeSessionBeans.getLeaveTypes();
        }
        return leaveTypes;
    }

    public void applyForStatus() {
        try {
            
            LeaveDetails leave = new LeaveDetails();
            leave.setStatus(leavestatus);

            UserMaster user = new UserMaster();
            user.setUserId(userId);
            leave.setUserId(user);

            employeeSessionBeans.updateEmployeeStatus(leave);
            employeeSessionBeans.getEmployeeLeaves(userId);
        } catch (Exception e) {
            System.err.println("Error applying for leave Status: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getLeavestatus() {
        return leavestatus;
    }

    public void setLeavestatus(String leavestatus) {
        this.leavestatus = leavestatus;
    }

    public void applyForLeave() {
        try {
            LeaveMaster leaveType = employeeSessionBeans.getLeaveTypeById(leaveTypeId); // Fetch LeaveMaster by ID
            if (leaveType == null) {
                System.out.println("Invalid leave type ID");
                return;
            }

            LeaveDetails leave = new LeaveDetails();
            leave.setLeaveTypeId(leaveType);
            leave.setFromDate(leaveStartDate);
            leave.setToDate(leaveEndDate);
            leave.setReason(leaveReason);
            leave.setStatus("Requested");

            UserMaster user = new UserMaster();
            user.setUserId(userId);
            leave.setUserId(user);

            employeeSessionBeans.addEmployeeLeave(leave);
            leaveDetails = employeeSessionBeans.getEmployeeLeaves(userId);

            System.out.println("Leave applied successfully!");
        } catch (Exception e) {
            System.err.println("Error applying for leave: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    //========================================================================== Attendance Management
    public Collection<AttendanceDetails> getAttendanceDetails() {
        if (attendanceDetails == null) {
            attendanceDetails = employeeSessionBeans.getEmployeeAttendence(userId);
        }
        return attendanceDetails;
    }

    public void setAttendanceDetails(Collection<AttendanceDetails> attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }

    public void checkIn() {
        if (hasCheckedInToday) {
            System.out.println("User has already checked in today!");
            return;
        }

        try {
            AttendanceDetails attendance = new AttendanceDetails();
            attendance.setDate(new Date());
            attendance.setCheckIn(new Date());

            UserMaster user = new UserMaster();
            user.setUserId(userId);
            attendance.setUserId(user);

            employeeSessionBeans.addEmployeeAttendence(attendance);

            System.out.println("Check-in recorded successfully for user ID: " + userId);
            hasCheckedInToday = true; // Update the flag after a successful check-in
        } catch (Exception e) {
            System.err.println("Error during check-in: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void checkOut() {
        if (!hasCheckedInToday) {
            System.out.println("User has not checked in today. Cannot check out.");
            return;
        }

        if (hasCheckedOutToday) {
            System.out.println("User has already checked out today!");
            return;
        }

        try {
            AttendanceDetails attendance = employeeSessionBeans.getTodayAttendanceByUserId(userId);

            if (attendance != null) {
                attendance.setCheckOut(new Date());
                employeeSessionBeans.updateEmployeeAttendance(attendance); // Assuming this method updates attendance
                System.out.println("Check-out recorded successfully for user ID: " + userId);
                hasCheckedOutToday = true; // Update the flag after a successful check-out
            } else {
                System.out.println("Attendance record not found for user ID: " + userId);
            }
        } catch (Exception e) {
            System.err.println("Error during check-out: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean isHasCheckedInToday() {
        return hasCheckedInToday;
    }

    public boolean isHasCheckedOutToday() {
        return hasCheckedOutToday;
    }

    public int getUserId() {
        return userId;
    }
}
