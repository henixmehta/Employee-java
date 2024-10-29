/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.ManagerClient;
import entity.SkillsMaster;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Henil
 */
@Named(value = "managerBeans")
@Dependent
public class ManagerBeans {

    private ManagerClient managerClient;
    private Collection<SkillsMaster> skillsList;
    private SkillsMaster newSkill; // Declare newSkill
    private final GenericType<Collection<SkillsMaster>> genericType = new GenericType<Collection<SkillsMaster>>() {
    };

    public ManagerBeans() {
        // Initialize newSkill in the constructor
        newSkill = new SkillsMaster(); // Initialize newSkill here
    }

    @PostConstruct
    public void init() {
        managerClient = new ManagerClient();
        skillsList = managerClient.getAllSkills(genericType); // Load skills list on initialization
        managerClient.close(); // Close client after fetching data
    }

    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    public SkillsMaster getNewSkill() {
        return newSkill;
    }

    public void setNewSkill(SkillsMaster newSkill) {
        this.newSkill = newSkill;
    }

    public void addSkill() throws IOException {
        try {
            managerClient.addSkill(newSkill); // Call addSkill API
            skillsList = managerClient.getAllSkills(genericType); // Refresh skills list

            // Reset the new skill instance
            newSkill = new SkillsMaster(); // Re-initialize newSkills after adding

            // Refresh page by redirecting
            FacesContext.getCurrentInstance().getExternalContext().redirect("skills.xhtml");

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
        } finally {
            managerClient.close(); // Ensure client is closed
        }
    }

}
