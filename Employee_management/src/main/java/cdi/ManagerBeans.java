package cdi;

import client.ManagerClient;
import entity.AssetsMaster;
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
//    private AssetsMaster newAsset; // Declare new Assets

    private final GenericType<Collection<SkillsMaster>> skillsGenericType = new GenericType<Collection<SkillsMaster>>() {
    };
    private final GenericType<Collection<HolidayMaster>> holidaysGenericType = new GenericType<Collection<HolidayMaster>>() {
    };
    private final GenericType<Collection<AssetsMaster>> assetsGenericType = new GenericType<Collection<AssetsMaster>>() {
    };

    public ManagerBeans() {
        managerClient = new ManagerClient();
    }

    @PostConstruct
    public void init() {
        try {
            managerClient = new ManagerClient();
            skillsList = managerClient.getAllSkills(skillsGenericType);
            holidaysList = managerClient.getAllHolidays(holidaysGenericType);
            assetsList = managerClient.getAllAssets(assetsGenericType);

        } catch (ClientErrorException e) {
            e.printStackTrace();
        }
    }

    public Collection<SkillsMaster> getSkillsList() {
        return skillsList;
    }

    public Collection<HolidayMaster> getHolidaysList() {
        return holidaysList;
    }

    public Collection<AssetsMaster> getAssetsList() {
        return assetsList;
    }

    public void closeClient() {
        managerClient.close();
    }
}
