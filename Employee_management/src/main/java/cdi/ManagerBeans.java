package cdi;

import client.ManagerClient;
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
    private final GenericType<Collection<SkillsMaster>> skillsGenericType = new GenericType<Collection<SkillsMaster>>() {
    };
    private final GenericType<Collection<HolidayMaster>> holidaysGenericType = new GenericType<Collection<HolidayMaster>>() {
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

    public void closeClient() {
        managerClient.close();
    }
}
