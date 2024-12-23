/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.EmployeeSessionBeansLocal;
import entity.AttendanceDetails;
import entity.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
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

    public Collection<UserMaster> getEmployeeDetails() {
        if (employeeDetails == null) {
            employeeDetails = employeeSessionBeans.getEmployeeDetailsByUserId(userId);
        }
        System.out.println("cdi.EmployeeBeans.getEmployeeDetails()" + employeeDetails);
        return employeeDetails;
    }

    public void setEmployeeDetails(Collection<UserMaster> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    public Collection<AttendanceDetails> getAttendanceDetails() {
        if (attendanceDetails == null) {
            attendanceDetails = employeeSessionBeans.getEmployeeAttendence(userId);
        }
        return attendanceDetails;
    }

    public void setAttendanceDetails(Collection<AttendanceDetails> attendanceDetails) {
        this.attendanceDetails = attendanceDetails;
    }

    public int getUserId() {
        return userId;
    }
}
