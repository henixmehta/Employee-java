package cdi;

import client.ManagerClient;
import entity.AssetsMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

@Named(value = "managerBeans")
@SessionScoped
public class ManagerBeans implements Serializable {

    private final ManagerClient managerClient;
    private Collection<SkillsMaster> skillsList;
    private Collection<HolidayMaster> holidaysList;
    private Collection<AssetsMaster> assetsList;

    private String sname; // Skill name
    private String desc; // Skill description

    private String holidayDesc; // Holiday description
    private Date holidayDate; // Holiday date

    private String assetName; // Asset name

    // Generic types for REST client responses
    private final GenericType<Collection<SkillsMaster>> skillsGenericType = new GenericType<Collection<SkillsMaster>>() {};
    private final GenericType<Collection<HolidayMaster>> holidaysGenericType = new GenericType<Collection<HolidayMaster>>() {};
    private final GenericType<Collection<AssetsMaster>> assetsGenericType = new GenericType<Collection<AssetsMaster>>() {};

    public ManagerBeans() {
        managerClient = new ManagerClient();
    }

    @PostConstruct
    public void init() {
        try {
            skillsList = managerClient.getAllSkills(skillsGenericType);
            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
            assetsList = managerClient.getAllAssets(assetsGenericType);
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    // Skill management methods
    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    public void addSkill() {
        try {
            SkillsMaster newSkill = new SkillsMaster();
            newSkill.setSkillName(sname);
            newSkill.setDescription(desc);

            managerClient.addSkill(newSkill, sname, desc);
            skillsList = managerClient.getAllSkills(skillsGenericType);
            sname = ""; // Clear after adding
            desc = ""; // Clear after adding
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    // Holiday management methods
    public Collection<HolidayMaster> getHolidaysList() {
        return holidaysList;
    }

    public void addHoliday() {
        try {
        HolidayMaster newHoliday = new HolidayMaster();
        newHoliday.setDescription(holidayDesc);
        newHoliday.setHolidayDate(holidayDate);
        managerClient.addHoliday(newHoliday, holidayDesc, holidayDate);
        holidaysList = managerClient.getAllHolidays(holidaysGenericType);
        holidayDesc = ""; // Reset after adding
        holidayDate = null; // Reset after adding
    } catch (ClientErrorException e) {
        e.printStackTrace();
    }
    }

    // Asset management methods
    public Collection<AssetsMaster> getAssetsList() {
        return assetsList;
    }

    public void addAsset() {
        try {
            AssetsMaster newAsset = new AssetsMaster();
            newAsset.setAssetName(assetName);

            managerClient.addAssets(newAsset, assetName);
            assetsList = managerClient.getAllAssets(assetsGenericType);
            assetName = ""; // Clear after adding
        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters for skill, holiday, and asset fields
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

    public String getHolidayDesc() {
        return holidayDesc;
    }

    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate(Date holidayDate) {
        this.holidayDate = holidayDate;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public void closeClient() {
        managerClient.close();
    }
}
