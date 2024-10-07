package managebeans;

import entity.SkillsMaster;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ViewMap;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
//import javax.faces.bean.ViewScoped;
import repository.SkillMasterRepositoryLocal;

@ManagedBean
@ViewMap
public class SkillManageBeans {

    @EJB
    private SkillMasterRepositoryLocal skillRepoBeans;

    private Collection<SkillsMaster> skills;

    private SkillsMaster newSkills;

    @PostConstruct
    public void init() {
        skills = skillRepoBeans.getAllSkill();
        newSkills = new SkillsMaster(); // Initialize the new book

    }

    public Collection<SkillsMaster> getSkills() {
        return skills;
    }

    // Method to add a skill
    public void addSkill(SkillsMaster newSkill) {
        skillRepoBeans.addSkill(newSkill);
        skills = skillRepoBeans.getAllSkill(); // Refresh skills
    }

    public SkillsMaster getNewSkill() {
        return newSkills;
    }

    // Setter for newBook
    public void setNewSkill(SkillsMaster newSkills) {
        this.newSkills = newSkills;
    }

    public void addSkill() {
        try {
            if (newSkills != null && newSkills.getSkillName() != null && !newSkills.getSkillName().trim().isEmpty()) {
                skillRepoBeans.addSkill(newSkills); // Persist the new skill
                skills = skillRepoBeans.getAllSkill(); // Refresh the skill list
                newSkills = new SkillsMaster(); // Reset the new skill for the next input
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Skill added successfully!"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Skill name cannot be empty!", null));
            }
        } catch (Exception e) {
            // Log the exception (you can also use a logging framework)
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error while adding skill: " + e.getMessage(), null));
        }
    }
}
