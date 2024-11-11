package client;

import entity.DepartmentMaster;
import entity.UserMaster;
import java.util.Collection;
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

    public Response deleteSkills(int skillid) throws ClientErrorException {
        return webTarget.path("skills/{id}")
                .resolveTemplate("id", skillid)
                .request()
                .delete();

    }

    public <T> T getAllDepartments(GenericType<T> responseType) throws ClientErrorException {

        WebTarget resource = webTarget;
        resource = resource.path("departments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

//    public void addDepartment(Object requestEntity, String deptname, String deptdesc) {
//        webTarget.path(java.text.MessageFormat.format("adddepartment/{0}/{1}", new Object[]{deptname, deptdesc})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
//    }
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
        return webTarget.path("assets/{id}")
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
    public void addUser(Object requestEntity) throws ClientErrorException {
        webTarget.path("addusers").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }
}
