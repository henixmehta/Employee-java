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

    @Override
    public void addSkill(String sname, String desc) {
        SkillsMaster skill = new SkillsMaster();
        skill.setSkillName(sname);
        skill.setDescription(desc);
        em.persist(skill);
    }

    @Override
    public Collection<HolidayMaster> getAllHolidays() {
        return em.createNamedQuery("HolidayMaster.findAll", HolidayMaster.class).getResultList();
    }

    @Override
    public void addHoliday(String desc, Date holidayDate) {
        HolidayMaster h = new HolidayMaster();
        h.setDescription(desc);
        h.setHolidayDate(holidayDate);
        em.persist(h);
    }
    @Override
    public Collection<AssetsMaster> getAllAssets() {
        return em.createNamedQuery("AssetsMaster.findAll", AssetsMaster.class).getResultList();
    }

    @Override
    public void addAsset(String assetName) {
        AssetsMaster asset = new AssetsMaster();
        asset.setAssetName(assetName);
        em.persist(asset);
    }
}
