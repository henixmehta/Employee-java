package client;

import java.math.BigInteger;
import java.util.Date;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ManagerResource [manager]<br>
 * USAGE:
 * <pre>
 *        ManagerClient client = new ManagerClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Henil
 */
public class ManagerClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Employee_management/resources";

    public ManagerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("manager");
    }

    public <T> T getAllSkills(GenericType<T> responseType) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addSkill(Object requestEntity, String sname, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addskill/{0}/{1}", new Object[]{sname, desc})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllDepartments(GenericType<T> responseType) throws ClientErrorException {

        WebTarget resource = webTarget;
        resource = resource.path("departments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//    public void addOrUpdateDepartment(Object requestEntity, String deptId, String deptName, String deptDesc, String managerId) throws ClientErrorException {
//        webTarget.path(java.text.MessageFormat.format("addOrUpdateDept/{0}/{1}/{2}/{3}", new Object[]{deptId, deptName, deptDesc, managerId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
    public void addOrUpdateDepartment(Object requestEntity, Integer deptId, String deptName, String deptDesc, int managerId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addOrUpdateDept/{0}/{1}/{2}/{3}",
                new Object[]{deptId != null ? deptId : 0, deptName, deptDesc, managerId}))
                .request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllHolidays(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("holidays");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

    }

    public Response addHoliday(Object requestEntity, String Desc, Date HolidayDate) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addholiday/{0}/{1}", new Object[]{Desc, HolidayDate})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public <T> T getAllAssets(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("assets");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAssets(Object requestEntity, String assetName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addassets/{0}", new Object[]{assetName})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Response deleteAsset(int assetId) throws ClientErrorException {
        return webTarget.path("deleteassets/{id}")
                .resolveTemplate("id", assetId)
                .request()
                .delete();
    }

    public <T> T getAllDesignation(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("designation");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAssetsDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("assetsdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAttendenceDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("attendencedetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUsers(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("users");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllDocuments(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("documents");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllDocumentDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("documentdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllProjectDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("projectdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteProjectDetails(Integer proDetailsId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteProjectDetails/{0}", new Object[]{proDetailsId})).request().delete();
    }

    public <T> T getAllGroups(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("groupdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllLeaveDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("leavedetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllLeaves(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("leaves");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTask(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("task");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTaskDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("taskdetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPerformanceDetails(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("performancedetails");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response addDesignation(String designationName, String responsibility, Integer departmentId) throws ClientErrorException {
        return webTarget
                .path(java.text.MessageFormat.format("adddesignation/{0}/{1}/{2}",
                        new Object[]{designationName, responsibility, departmentId}))
                .request(MediaType.APPLICATION_JSON)
                .post(null, Response.class);
    }

    public Response addAssetDetails(BigInteger assetNumber, String assignDate, String returnDate, Integer assetId, Integer userId
    ) throws ClientErrorException {
        return webTarget
                .path(java.text.MessageFormat.format(
                        "addassetsdetails/{0}/{1}/{2}/{3}/{4}",
                        new Object[]{assetNumber, assignDate, returnDate, assetId, userId}
                ))
                .request(MediaType.APPLICATION_JSON)
                .post(null, Response.class);
    }

    public void deleteDepartment(Integer deptid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteDepartment/{0}", new Object[]{deptid})).request().delete();
    }

    public void deleteDesgination(Integer designationId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteDesgination/{0}", new Object[]{designationId})).request().delete();
    }

    public void updateDesignation(Object requestEntity, String designationId, String designationName, String responsibility, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDesignation/{0}/{1}/{2}/{3}", new Object[]{designationId, designationName, responsibility, deptId})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public Response deleteSkills(int skillid) throws ClientErrorException {
        return webTarget.path("deleteskills/{id}")
                .resolveTemplate("id", skillid)
                .request()
                .delete();

    }

    public void deleteUserDetails(Integer userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUserDetails/{0}", new Object[]{userId})).request().delete();
    }

    public void deleteAssetsDetails(Integer assetsDetailsId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteAssetsDetails/{0}", new Object[]{assetsDetailsId})).request().delete();
    }

    public void deleteTaskDetails(Integer taskDetailsId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTaskDetails/{0}", new Object[]{taskDetailsId})).request().delete();
    }

    public void deleteTask(Integer taskid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletetask/{0}", new Object[]{taskid})).request().delete();
    }

    public void addGroups(Object requestEntity, String gname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addgroups/{0}", new Object[]{gname})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addLeaves(Object requestEntity, String leavetype) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addleaves/{0}", new Object[]{leavetype})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addProject(Object requestEntity) throws ClientErrorException {
        webTarget.path("addproject").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateProject(Object requestEntity) throws ClientErrorException {
        webTarget.path("updateproject").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addUser(Object requestEntity) throws ClientErrorException {
        webTarget.path("addusers").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void deleteUser(Integer userId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{userId})).request().delete();
        System.out.println("Client : " + userId);
    }

    public void addTaskDetails(Object requestEntity) throws ClientErrorException {
        webTarget.path("addtask").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
}
