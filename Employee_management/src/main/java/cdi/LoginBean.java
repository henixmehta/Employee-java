/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import com.myproject.jwt.JWTUtil;
import ejb.LoginSessionBeanLocal;
import entity.GroupMaster;
import entity.UserDetails;
import entity.UserMaster;
import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.servlet.jsp.PageContext;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String companyEmail;
    private String password;
    private String jwtToken;
    private boolean rememberMe;

    @Inject
    private LoginSessionBeanLocal loginSessionBean; // Injecting the LoginSessionBeanLocal

    public LoginBean() {
    }

    // Getters and setters for the fields...
    public String login() {
        // Authenticate user by email and password
        UserMaster user = loginSessionBean.authenticate(companyEmail, password);
        if (user != null) {
            // Find UserDetails using userId from UserMaster
            UserDetails userDetails = loginSessionBean.findUserDetailsByUserId(user.getUserId());

            if (userDetails != null) {
                // Find GroupMaster using groupId from UserDetails
                GroupMaster group = loginSessionBean.findGroupById(userDetails.getGroupId());
//                System.out.print(" cdilogin groupid" + group);

                // You can now use the group data (e.g., group.getGroupName())
                jwtToken = JWTUtil.generateToken(user.getCompanyEmail(), group.getGroupName());
                System.out.print(" Generated token " + jwtToken);

                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userId", user.getUserId());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userName", user.getUserName());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("jwtToken", jwtToken);

                System.out.println("Role :" + group.getGroupName());
                System.out.println("User Name : " + user.getUserName());
                // Redirect to the appropriate dashboard based on user role

                if (group.getGroupName().equals("admin")) {
//                        return "admin/adminDashboard.xhtml?faces-redirect=true";
                    return "admin/adminDashboard.xhtml?faces-redirect=true";

                } else if (group.getGroupName().equals("manager")) {
                    return "manager/managerDashboard.xhtml?faces-redirect=true";

                } else {
                    return "employee/employeeDashboard.xhtml?faces-redirect=true";
                }
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", ""));
        return null;
    }

    // Getters and setters for the fields...
    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public LoginSessionBeanLocal getLoginSessionBean() {
        return loginSessionBean;
    }

    public void setLoginSessionBean(LoginSessionBeanLocal loginSessionBean) {
        this.loginSessionBean = loginSessionBean;
    }

    public String logout() {
        // Invalidate the session to remove all attributes
//        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession(); // Invalidate the session
        // Optionally, you can also remove individual session attributes if you don't want to invalidate the whole session
//         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userId");
//         FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("userName");
//         Redirect to the login page after logging out
        return "/index.xhtml?faces-redirect=true"; // Adjust the path based on your login page
    }

}
