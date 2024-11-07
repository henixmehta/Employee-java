package cdi;

import client.ManagerClient;
import entity.AssetsMaster;
import entity.DepartmentMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

@Named(value = "managerBeans")
@SessionScoped
public class ManagerBeans implements Serializable {

    private ManagerClient managerClient;
    private Collection<SkillsMaster> skillsList;
    private Collection<HolidayMaster> holidaysList;
    private Collection<AssetsMaster> assetsList;
    private Collection<DepartmentMaster> departmentList;

    private String sname;
    private String desc;

    private final GenericType<Collection<SkillsMaster>> skillsGenericType = new GenericType<Collection<SkillsMaster>>() {
    };
    private final GenericType<Collection<HolidayMaster>> holidaysGenericType = new GenericType<Collection<HolidayMaster>>() {
    };
    private final GenericType<Collection<AssetsMaster>> assetsGenericType = new GenericType<Collection<AssetsMaster>>() {
    };
    private final GenericType<Collection<DepartmentMaster>> deptGenericType = new GenericType<Collection<DepartmentMaster>>() {
    };

    public ManagerBeans() {
//        managerClient = new ManagerClient();
    }

    @PostConstruct
    public void init() {
        try {
            managerClient = new ManagerClient();
            skillsList = managerClient.getAllSkills(skillsGenericType);
            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
            assetsList = managerClient.getAllAssets(assetsGenericType);
            departmentList = managerClient.getAllDepartments(deptGenericType);
        } catch (ClientErrorException e) {
            e.printStackTrace(); // Log the exception to understand the issue
        } catch (Exception e) {
            e.printStackTrace(); // Catch any other exceptions that may occur
        }
    }

    // Method to get the current skills list
    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    // Add skill to the list
    public void addSkill() {
        try {
            // Create the SkillsMaster object from the user input values
            SkillsMaster newSkill = new SkillsMaster();
            newSkill.setSkillName(sname);
            newSkill.setDescription(desc);

            // Call the managerClient to send the newSkill object to the REST API
            managerClient.addSkill(newSkill, sname, desc);

            // Refresh the skills list after adding the new skill
            skillsList = managerClient.getAllSkills(skillsGenericType);

            sname = "";
            desc = "";
        } catch (ClientErrorException e) {
        }
    }

    public Collection<DepartmentMaster> getDepartmentList() {
        return departmentList;
    }

    public Collection<HolidayMaster> getHolidaysList() {
        return holidaysList;
    }

    public Collection<AssetsMaster> getAssetsList() {
        return assetsList;
    }

    // Add skill to the list
//    public void addDepartment() {
//        try {
//            DepartmentMaster newdept = new DepartmentMaster();
//            newdept.setDeptName(deptname);
//            newdept.setDescription(deptdesc);
////            newdept.setManagerId(userId);
//
//            // Call the managerClient to send the newSkill object to the REST API
//            managerClient.addDepartment(newdept, deptname, deptdesc);
//
//            // Refresh the skills list after adding the new skill
//            deptList = managerClient.getAllDepartments(deptGenericType);
//            deptname = "";
//            deptdesc = "";
//        } catch (ClientErrorException e) {
//        }
//    }
//
//    // Getters and Setters for sname and desc (used by JSF to bind form input)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void closeClient() {
        managerClient.close();
    }
}
