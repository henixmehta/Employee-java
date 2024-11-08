package ejb;

import entity.AssetsMaster;
import entity.DepartmentMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
import entity.UserMaster;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public Collection<DepartmentMaster> getAllDepartments() {
        return em.createNamedQuery("DepartmentMaster.findAll", DepartmentMaster.class).getResultList();
    }

//    @Override
//    public void addDepartment(String deptname, String deptdesc) {
//        DepartmentMaster dept = new DepartmentMaster();
//        dept.setDeptName(deptname);
//        dept.setDescription(deptdesc);
////        dept.setManagerId(userId);
//        
//        em.persist(dept);
//    }
    @Override
    public void addAsset(String assetName) {
        AssetsMaster asset = new AssetsMaster();
        asset.setAssetName(assetName);
        em.persist(asset);
    }

    @Override
    public void deleteAsset(Integer assetId) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        AssetsMaster asset = em.find(AssetsMaster.class, assetId);
        if (asset != null) {
            em.remove(asset);
        }

    }

    @Override
    public AssetsMaster getAssetById(Integer assetId) {
        return em.createNamedQuery("AssetsMaster.findByAssetId", AssetsMaster.class)
                .setParameter("assetId", assetId)
                .getSingleResult();
    }
}
