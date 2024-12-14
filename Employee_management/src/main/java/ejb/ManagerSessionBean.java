package ejb;

import entity.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public void addOrUpdateDepartment(Integer deptId, String deptName, String deptDesc, int managerId) {
        UserMaster manager = em.find(UserMaster.class, managerId);

        DepartmentMaster dept;
        if (deptId != null && deptId > 0) {
            // Update existing department
            dept = em.find(DepartmentMaster.class, deptId);
            if (dept != null) {
                dept.setDeptName(deptName);
                dept.setDescription(deptDesc);
                dept.setManagerId(manager);
                em.merge(dept);
            }
        } else {
            // Add new department
            dept = new DepartmentMaster();
            dept.setDeptName(deptName);
            dept.setDescription(deptDesc);
            dept.setManagerId(manager);
            em.persist(dept);
        }
    }

//    @Override
//    public void deleteDepartment(Integer deptid) {
//        DepartmentMaster dept = (DepartmentMaster) em.find(DepartmentMaster.class, deptid);
//        em.remove(dept);
//    } 
    @Override
    public void addAsset(String assetName) {
        AssetsMaster asset = new AssetsMaster();
        asset.setAssetName(assetName);
        em.persist(asset);
    }

    @Override
    public AssetsMaster getAssetById(Integer assetId) {
        try {
            return em.createNamedQuery("AssetsMaster.findByAssetId", AssetsMaster.class)
                    .setParameter("assetId", assetId)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            // Handle the case where no result is found
            return null; // or you could throw an exception or handle it as needed
        }
    }

    @Override
    public SkillsMaster getSkillsById(Integer SkillsId) {
        return em.createNamedQuery("SkillsMaster.findBySkillId", SkillsMaster.class)
                .setParameter("skillId", SkillsId)
                .getSingleResult();
    }

    @Override
    public Collection<DesignationMaster> getAllDesignation() {
        return em.createNamedQuery("DesignationMaster.findAll", DesignationMaster.class).getResultList();
    }

    @Override
    public Collection<AssetsDetails> getAllAssetsDetails() {
        return em.createNamedQuery("AssetsDetails.findAll", AssetsDetails.class).getResultList();
    }

    @Override
    public Collection<AttendanceDetails> getAllAttendanceDetails() {
        return em.createNamedQuery("AttendanceDetails.findAll", AttendanceDetails.class).getResultList();
    }

    @Override
    public Collection<UserMaster> getAllUsers() {
        return em.createNamedQuery("UserMaster.findAll", UserMaster.class).getResultList();
    }

    @Override
    public Collection<DocumentMaster> getAllDocuments() {
        return em.createNamedQuery("DocumentMaster.findAll", DocumentMaster.class).getResultList();
    }

    @Override
    public Collection<DocumentDetails> getAllDocumentDetails() {
        return em.createNamedQuery("DocumentDetails.findAll", DocumentDetails.class).getResultList();
    }

    @Override
    public Collection<GroupMaster> getAllGroups() {
        return em.createNamedQuery("GroupMaster.findAll", GroupMaster.class).getResultList();
    }

    @Override
    public Collection<LeaveMaster> getAllLeaves() {
        return em.createNamedQuery("LeaveMaster.findAll", LeaveMaster.class).getResultList();
    }

    @Override
    public Collection<LeaveDetails> getAllLeaveDetails() {
        return em.createNamedQuery("LeaveDetails.findAll", LeaveDetails.class).getResultList();
    }

    @Override
    public Collection<ProjectDetails> getAllProjectDetails() {
        return em.createNamedQuery("ProjectDetails.findAll", ProjectDetails.class).getResultList();
    }

    @Override
    public void updateProjectStatus(Integer projectId, String newStatus) {
//        ProjectDetails project = em.find(ProjectDetails.class, projectId);
//        if (project != null) {
//            project.setStatus(newStatus);
//            em.merge(project);
//        }
    }

    @Override
    public Collection<TaskMaster> getAllTask() {
        return em.createNamedQuery("TaskMaster.findAll", TaskMaster.class).getResultList();
    }

    @Override
    public Collection<TaskDetails> getAllTaskDetails() {
        return em.createNamedQuery("TaskDetails.findAll", TaskDetails.class).getResultList();
    }

    @Override
    public Collection<PerformanceDetails> getPerformanceDetails() {
        return em.createNamedQuery("PerformanceDetails.findAll", PerformanceDetails.class).getResultList();
    }

    @Override
    public void addDesig(String desginame, String desgirepo, Integer deptid) {
        DepartmentMaster dept_id = (DepartmentMaster) em.find(DepartmentMaster.class, deptid);
        DesignationMaster d = new DesignationMaster();
        d.setDesignation(desginame);
        d.setResponsibility(desgirepo);
        d.setDepartmentId(dept_id);
        em.persist(d);
    }

    @Override
    public void updateDesignation(Integer designationId, String designationName, String responsibility, Integer deptId) {
        // Find the associated DepartmentMaster entity
        DepartmentMaster department = em.find(DepartmentMaster.class, deptId);
        if (designationId != null && designationId > 0) {

            DesignationMaster designation = em.find(DesignationMaster.class, designationId);
            if (designation != null) {
                designation.setDesignation(designationName);
                designation.setResponsibility(responsibility);
                designation.setDepartmentId(department);
                em.merge(designation);
            }
        } else {
            throw new IllegalArgumentException("Invalid Designation ID provided for update.");
        }
    }

    @Override
    public void addUser(UserMaster usermaster) {
        em.persist(usermaster);
    }

    @Override
    public void addAssetsDetails(BigInteger assetNumber, Date assignDate, Date returnDate, Integer assetId, Integer userId) {
        // Find the related AssetsMaster and UserMaster entities
        AssetsMaster asset = em.find(AssetsMaster.class, assetId);
        UserMaster user = em.find(UserMaster.class, userId);

        // Create a new instance of AssetsDetails
        AssetsDetails assetsDetails = new AssetsDetails();

        // Set properties
        assetsDetails.setAssetNumber(assetNumber);
        assetsDetails.setAssignDate(assignDate);
        assetsDetails.setReturnDate(returnDate);
        assetsDetails.setAssetId(asset); // Many-to-one association with AssetsMaster
        assetsDetails.setUserId(user);   // Many-to-one association with UserMaster

        // Persist the new AssetsDetails entity
        em.persist(assetsDetails);
    }

    @Override
    public void addGroups(String gname) {
        GroupMaster group = new GroupMaster();
        group.setGroupName(gname);

        em.persist(group);
    }
//    @Override
//    public void deleteHoliday(Integer holidayInteger) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        HolidayMaster h = em.find(HolidayMaster.class, holidayInteger);
//        em.remove(h);
//        
//    }
//    
//    @Override
//    public void deleteUser(Integer userId) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        UserMaster u = em.find(UserMaster.class, userId);
//        em.remove(u);
//    }
//    
//    @Override
//    public Collection<UserDetails> getAllUsersDetails() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//
//    }
//    
//    @Override
//    public void addUserDetails(Integer userId, Integer grpId, Integer deptid, Integer skillId, Integer designationId, String e) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//    
//    @Override
//    public void deleteUserDetails(Integer userId) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        UserDetails ud = em.find(UserDetails.class, userId);
//        em.remove(ud);
//        
//    }
    @Override
    public void deleteAssetsDetails(Integer assetsDetailsId) {
        AssetsDetails ad = em.find(AssetsDetails.class, assetsDetailsId);
        em.remove(ad);
    }

    @Override
    public void deleteAsset(Integer assetId) {
        // Fetch the AssetsMaster object by its ID
        AssetsMaster asset = em.find(AssetsMaster.class, assetId);

        if (asset != null) {
            // Query AssetsDetails by the AssetsMaster object
            Query query = em.createQuery("SELECT a FROM AssetsDetails a WHERE a.assetId = :assetId");
            query.setParameter("assetId", asset);
            Collection<AssetsDetails> detailsList = query.getResultList();
            for (AssetsDetails detail : detailsList) {
                detail.setAssetId(null); // Set the assetId to null
                em.merge(detail); // Persist changes
            }

            em.remove(asset); // Delete the AssetsMaster object
        }
    }

    @Override
    public void deleteTaskDetails(Integer taskDetatilsId) {
        TaskDetails task = em.find(TaskDetails.class, taskDetatilsId);
        em.remove(task);
    }

    @Override
    public Collection<UserDetails> getAllUsersDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addUserDetails(Integer userId, Integer grpId, Integer deptid, Integer skillId, Integer designationId, String e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addLeaves(Integer leaveTypeId, String leaveType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
