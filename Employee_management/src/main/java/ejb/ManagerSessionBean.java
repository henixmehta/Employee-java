package ejb;

import entity.AssetsMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Stateless session bean implementing ManagerSessionBeanLocal interface.
 */
@Stateless
public class ManagerSessionBean implements ManagerSessionBeanLocal {

    @PersistenceContext(unitName = "my_per_unit")
    private EntityManager em;

    //=== Skills methods implementation
    @Override
    public Collection<SkillsMaster> getAllSkill() {
        return em.createNamedQuery("SkillsMaster.findAll", SkillsMaster.class).getResultList();
    }

//    @Override
//    public SkillsMaster getSkillById(int skillId) {
//        try {
//            return em.createNamedQuery("SkillsMaster.findBySkillId", SkillsMaster.class)
//                    .setParameter("skillid", skillId)
//                    .getSingleResult();
//        } catch (Exception e) {
//            return null;
//        }
//    }
//    @Override
//    public void addSkill(SkillsMaster skill) {
//        em.persist(skill);
//        em.flush();
//    }
//
//    @Override
//    public void updateSkill(SkillsMaster skill) {
//        em.merge(skill);
//    }
//
//    @Override
//    public void deleteskill(int skillId) {
//        SkillsMaster skill = em.find(SkillsMaster.class, skillId);
//        if (skill != null) {
//            em.remove(skill);
//        } else {
//            System.out.println("Skill not found: " + skillId);
//        }
//    }
    //=== Holidays methods implementation
//    @Override
//    public void addHoliday(String desc, Date holidayDate) {
//        HolidayMaster holiday = new HolidayMaster();
//        holiday.setDescription(desc);
//        holiday.setHolidayDate(holidayDate);
//        em.persist(holiday);
//    }
//
//    @Override
//    public void updateHoliday(Integer holidayId, String desc, Date holidayDate) {
//        HolidayMaster holiday = em.find(HolidayMaster.class, holidayId);
//        if (holiday != null) {
//            holiday.setDescription(desc);
//            holiday.setHolidayDate(holidayDate);
//            em.merge(holiday);
//        }
//    }
//    @Override
//    public void removeHoliday(Integer holidayId) {
//        HolidayMaster holiday = em.find(HolidayMaster.class, holidayId);
//        if (holiday != null) {
//            em.remove(holiday);
//        }
//    }
    @Override
    public Collection<HolidayMaster> getAllHolidays() {
        return em.createNamedQuery("HolidayMaster.findAll", HolidayMaster.class).getResultList();
    }

//    @Override
//    public Collection<HolidayMaster> getAllHolidaysByDescription(String description) {
//        TypedQuery<HolidayMaster> query = em.createNamedQuery("HolidayMaster.findByDescription", HolidayMaster.class);
//        query.setParameter("description", description);
//        return query.getResultList();
//    }
//
//    @Override
//    public Collection<HolidayMaster> getAllHolidaysByDate(Date holidayDate) {
//        TypedQuery<HolidayMaster> query = em.createNamedQuery("HolidayMaster.findByDate", HolidayMaster.class);
//        query.setParameter("holidayDate", holidayDate);
//        return query.getResultList();
//    }
//
//    @Override
//    public HolidayMaster getHolidayById(Integer holidayId) {
//        return em.find(HolidayMaster.class, holidayId);
//    }
    @Override
    public Collection<AssetsMaster> getAllAssets() {
        return em.createNamedQuery("AssetsMaster.findAll", AssetsMaster.class).getResultList();
    }
}
