/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.AdminClient;
import entity.SkillsMaster;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Henil
 */
@Named(value = "adminBeans")
@Dependent
public class AdminBeans {

    private AdminClient adminClient;
    private Collection<SkillsMaster> skillsList;
//    private SkillsMaster newSkill;
    // Declare GenericType at the class level
    private final GenericType<Collection<SkillsMaster>> genericType = new GenericType<Collection<SkillsMaster>>() {
    };

    @PostConstruct
    public void init() {
        adminClient = new AdminClient();

        // Use the class-level genericType field in the API call
        skillsList = adminClient.getAllSkills(genericType);

        adminClient.close(); // Close client after use
    }

    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

//    // insert  skills
//    public SkillsMaster getNewSkill() {
//        return newSkill;
//    }
//
//    public void setNewSkill(SkillsMaster newSkill) {
//        this.newSkill = newSkill;
//    }
//
//    public void addSkill() throws IOException {
//
//        try {
//            adminClient.addSkill(newSkill);
//            skillsList = adminClient.getAllSkills(genericType); // Refresh list
//
//            // Reset the new skill instance
//            newSkill = new SkillsMaster();
//
//            // Refresh page by redirecting
//            FacesContext.getCurrentInstance().getExternalContext().redirect("skills.xhtml");
//            // Stay on the same page
//
//        } catch (ExceptionInInitializerError e) {
//            e.getException();
//        }
//}
    //===============================set count ===============================================
//      private int projectCount;
//    private int departmentCount;
//    private int designationCount;
//    private int userCount;
//
//    // Add methods to fetch the counts (e.g., from database or services)
//    public void loadCounts() {
//        // Replace with actual logic to fetch counts
//        userCount = (usersList != null) ? usersList.size() : 0;
//        departmentCount = (departmentList != null) ? departmentList.size() : 0;
//        designationCount = (designationList != null) ? designationList.size() : 0;
//        projectCount = (projectdetailsList != null) ? projectdetailsList.size() : 0;
//    }
//
//    // Getters
//    public int getProjectCount() {
//        return projectCount;
//    }
//
//    public int getDepartmentCount() {
//        return departmentCount;
//    }
//
//    public int getDesignationCount() {
//        return designationCount;
//    }
//
//    public int getUserCount() {
//        return userCount;
//    }
}
