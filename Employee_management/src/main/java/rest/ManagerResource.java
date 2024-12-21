package rest;

import ejb.ManagerSessionBeanLocal;
import entity.*;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("manager")
@RequestScoped
public class ManagerResource {

    @EJB
    ManagerSessionBeanLocal msbl;

    //======================= Skills Master Methods ============================
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SkillsMaster> getAllSkills() {
        return msbl.getAllSkill();
    }

    @POST
    @Path("addskill/{sname}/{desc}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSkill(@PathParam("sname") String sname, @PathParam("desc") String desc) {
        msbl.addSkill(sname, desc);
    }

    @DELETE
    @Path("deleteskills/{id}")
    public Response deleteSkills(@PathParam("id") int id) {
        SkillsMaster skill = msbl.getSkillsById(id);
        if (skill != null) {
            msbl.deleteSkill(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Skill not found").build();
        }
    }

    //========================= Department Details =============================
    @GET
    @Path("departments")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DepartmentMaster> getAllDepartments() {
        return msbl.getAllDepartments();
    }

    @POST
    @Path("addOrUpdateDept/{deptId}/{deptName}/{deptDesc}/{managerId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOrUpdateDepartment(@PathParam("deptId") Integer deptId, @PathParam("deptName") String deptName, @PathParam("deptDesc") String deptDesc, @PathParam("managerId") int managerId) {
        msbl.addOrUpdateDepartment(deptId, deptName, deptDesc, managerId);
    }

    @DELETE
    @Path("deleteDepartment/{deptid}")
    public void deleteDepartment(@PathParam("deptid") Integer deptid) {
        msbl.deleteDepartment(deptid);
    }

    //========================= Holiday Details ================================
    @GET
    @Path("holidays")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<HolidayMaster> getAllHolidays() {
        return msbl.getAllHolidays();
    }

    @POST
    @Path("addholiday/{Desc}/{HolidayDate}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHoliday(@PathParam("Desc") String Desc, @PathParam("HolidayDate") String HolidayDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(HolidayDate);
            msbl.addHoliday(Desc, date);
            return Response.status(Response.Status.CREATED).entity("Holiday added successfully").build();
        } catch (ParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format. Please use yyyy-MM-dd").build();
        }
    }
    //=========================== Assets Masters ===============================

    @GET
    @Path("assets")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AssetsMaster> getAllAssets() {
        return msbl.getAllAssets();
    }

    @POST
    @Path("addassets/{assetName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAsset(@PathParam("assetName") String assetName) {
        msbl.addAsset(assetName);
    }

    @DELETE
    @Path("deleteassets/{id}")
    public Response deleteAsset(@PathParam("id") int id) {
        AssetsMaster asset = msbl.getAssetById(id);
        if (asset != null) {
            msbl.deleteAsset(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Asset not found").build();
        }
    }

    //======================= Assets Details ===================================
    @GET
    @Path("assetsdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AssetsDetails> getAllAssetsDetails() {
        return msbl.getAllAssetsDetails();
    }

    @POST
    @Path("addassetsdetails/{assetNumber}/{assignDate}/{returnDate}/{assetId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAssetDetails(
            @PathParam("assetNumber") BigInteger assetNumber,
            @PathParam("assignDate") String assignDate,
            @PathParam("returnDate") String returnDate,
            @PathParam("assetId") Integer assetId,
            @PathParam("userId") Integer userId
    ) {
        try {
            Date assignDateParsed = javax.xml.bind.DatatypeConverter.parseDateTime(assignDate).getTime();
            Date returnDateParsed = javax.xml.bind.DatatypeConverter.parseDateTime(returnDate).getTime();

            // Call the session bean method
            msbl.addAssetsDetails(assetNumber, assignDateParsed, returnDateParsed, assetId, userId);
            return Response.ok("Asset details added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error adding asset details: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("deleteAssetsDetails/{assetsDetailsId}")
    public void deleteAssetsDetails(@PathParam("assetsDetailsId") Integer assetsDetailsId) {
        msbl.deleteAssetsDetails(assetsDetailsId);
    }

    //======================= Attendence Details ===============================
    @GET
    @Path("attendencedetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AttendanceDetails> getAllAttendanceDetails() {
        return msbl.getAllAttendanceDetails();
    }

    //============== User Master Methods========================================
    @GET
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserMaster> getAllUsers() {
        return msbl.getAllUsers();
    }

    @POST
    @Path("addusers")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(UserRequestWrapper wrapper) {
        UserMaster user = wrapper.getUserMaster();
        UserDetails userdetails = wrapper.getUserDetails();
        msbl.addUser(user, userdetails);
    }

    @DELETE
    @Path("deleteUser/{userId}")
    public void deleteUser(@PathParam("userId") int userId) {
        msbl.deleteUser(userId);
        System.out.println("User ID Resource : " + userId);
    }
    //====================== Document Details ==================================

    @GET
    @Path("documents")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DocumentMaster> getAllDocuments() {
        return msbl.getAllDocuments();
    }

    @GET
    @Path("documentdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DocumentDetails> getAllDocumentDetails() {
        return msbl.getAllDocumentDetails();
    }

    //========================== Group Details =================================
    @GET
    @Path("groupdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<GroupMaster> getAllGroups() {
        return msbl.getAllGroups();
    }

    @POST
    @Path("addgroups/{gname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addGroups(@PathParam("gname") String gname) {
        msbl.addGroups(gname);
    }

    //======================= Leave Master Methods =============================
    @GET
    @Path("leaves")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<LeaveMaster> getAllLeaves() {
        return msbl.getAllLeaves();
    }

    @POST
    @Path("addleaves/{leavetype}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLeaves(@PathParam("leavetype") String leavetype) {
        msbl.addLeaves(leavetype);
    }

    //========================= Leave Details Methods ==========================
    @GET
    @Path("leavedetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<LeaveDetails> getAllLeaveDetails() {
        return msbl.getAllLeaveDetails();
    }

    //=======================  Project Details Methods =========================
    @POST
    @Path("addproject")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProject(ProjectDetails project) {
        msbl.addProject(project);
    }

    @POST
    @Path("updateproject")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProject(ProjectDetails project) {
        msbl.updateProject(project);
    }

    @GET
    @Path("projectdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<ProjectDetails> getAllProjectDetails() {
        return msbl.getAllProjectDetails();
    }

    @DELETE
    @Path("deleteProjectDetails/{proDetailsId}")
    public void deleteProjectDetails(@PathParam("proDetailsId") Integer proDetailsId) {
        msbl.deleteProjectDetails(proDetailsId);
    }

    //================== Task & Task Details Methods ===========================
    @GET
    @Path("task")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TaskMaster> getAllTask() {
        return msbl.getAllTask();
    }

    @GET
    @Path("taskdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TaskDetails> getAllTaskDetails() {
        return msbl.getAllTaskDetails();
    }

    @POST
    @Path("addtask")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTaskDetails(TaskWrapper task) {
        TaskMaster taskmaster = task.getTaskmaster();
        TaskDetails taskdetails = task.getTaskDetails();
//       UserMaster users = task.getUsers();
        msbl.addTask(taskmaster, taskdetails);
    }

    @DELETE
    @Path("deleteTaskDetails/{taskDetailsId}")
    public void deleteTaskDetails(@PathParam("taskDetailsId") Integer taskDetailsId) {
        msbl.deleteTaskDetails(taskDetailsId);
    }

    //===================== Performance Details Methods ========================
    @GET
    @Path("performancedetails")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<PerformanceDetails> getPerformanceDetails() {
        return msbl.getPerformanceDetails();
    }

    //====================== Designation Details Methods =======================
    @GET
    @Path("designation")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<DesignationMaster> getAllDesignation() {
        return msbl.getAllDesignation();
    }

    @POST
    @Path("adddesignation/{designationName}/{responsibility}/{departmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDesignation(@PathParam("designationName") String designationName,
            @PathParam("responsibility") String responsibility,
            @PathParam("departmentId") Integer departmentId) {
        try {
            msbl.addDesig(designationName, responsibility, departmentId);
            return Response.status(Response.Status.CREATED).entity("Designation added successfully").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error adding designation: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("deleteDesgination/{designationId}")
    public void deleteDesgination(@PathParam("designationId") Integer designationId) {
        msbl.deleteDesiination(designationId);
    }

    @PUT
    @Path("updateDesignation/{designationId}/{designationName}/{responsibility}/{deptId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDesignation(@PathParam("designationId") Integer designationId,
            @PathParam("designationName") String designationName,
            @PathParam("responsibility") String responsibility,
            @PathParam("deptId") Integer deptId) {
        msbl.updateDesignation(designationId, designationName, responsibility, deptId);
    }

//    @PUT
//    @Path("UpdateUser/{userId}/{userName}/{address}/{age}/{emailId}/{emergencyContact}/{currentExperience}/"
//            + "{dateOfBirth}/{gender}/{joiningDate}/{password}/{profileImage}/{salary}/{phoneNo}/{reportingTo}/{qualification}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void updateUser(@PathParam("userId") Integer userId, @PathParam("userName") String userName,
//        @PathParam("address") String address, @PathParam("age") Integer age, @PathParam("emailId") String emailId,
//        @PathParam("emergencyContact") BigInteger emergencyContact, @PathParam("currentExperience") String currentExperience,
//        @PathParam("dateOfBirth") Date dateOfBirth, @PathParam("gender") String gender, @PathParam("joiningDate") Date joiningDate,
//        @PathParam("password") String password, @PathParam("profileImage") String profileImage, @PathParam("salary") Integer salary,
//        @PathParam("phoneNo") BigInteger phoneNo, @PathParam("reportingTo") Integer reportingTo, @PathParam("qualification") String qualification) {
//       msbl.UpdateUser(userId, userName, emailId, phoneNo, dateOfBirth, age, gender, joiningDate, address, emergencyContact, profileImage, emailId, password, reportingTo, phoneNo, qualification, currentExperience);
//    }
//    @DELETE
//    @Path("deletetask/{taskid}")
//    public void deleteTask(@PathParam("taskid") Integer taskid) {
//        msbl.deleteTask(taskid);
//    }
//    @DELETE
//    @Path("deleteUserDetails/{userId}")
//    public void deleteUserDetails(@PathParam("userId") Integer userId) {
//        msbl.deleteUserDetails(userId);
//    }
}
