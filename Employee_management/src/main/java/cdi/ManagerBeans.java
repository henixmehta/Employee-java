/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import client.ManagerClient;
import entity.SkillsMaster;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Henil
 */
@Named(value = "managerBeans")
@ViewScoped
public class ManagerBeans implements Serializable {

    private ManagerClient managerClient;
    private Collection<SkillsMaster> skillsList;
    private SkillsMaster newSkill; // Declare newSkill
    private Long selectedSkillId; // To hold the ID of the skill to update

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
    }
//    display skills

    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

//    insert skill
    public SkillsMaster getNewSkill() {
        return newSkill;
    }

    public void setNewSkill(SkillsMaster newSkill) {
        this.newSkill = newSkill;
    }

    public void addSkill() throws IOException {
        try {
            managerClient.addSkill(newSkill);
            skillsList = managerClient.getAllSkills(genericType); // Refresh list
            newSkill = new SkillsMaster(); // Reset form
            FacesContext.getCurrentInstance().getExternalContext().redirect("skill.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            managerClient.close();
        }
    }

//    public Long getSelectedSkillId() {
//        return selectedSkillId;
//    }
//
//    public void setSelectedSkillId(Long selectedSkillId) {
//        this.selectedSkillId = selectedSkillId;
//        fetchSkillDetails(selectedSkillId);
//    }
//
//    public void updateSkill() {
//        if (newSkill != null && newSkill.getSkillId() != null) {
//            skillService.updateSkill(newSkill);
//            skillsList = skillService.getAllSkills(); // Refresh the list
//            newSkill = new SkillsMaster(); // Reset
//        }
//    }
//
//    public void deleteSkill(Long skillId) {
//        skillService.deleteSkill(skillId.intValue());
//        skillsList = skillService.getAllSkills(); // Refresh the list
//    }
//
//    private void fetchSkillDetails(Long skillId) {
//        newSkill = skillService.getSkillById(skillId.intValue());
//    }
}
