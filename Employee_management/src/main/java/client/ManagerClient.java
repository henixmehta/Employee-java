package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

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

    // Skill management methods
//    public Response addSkill(SkillsMaster newSkill) throws ClientErrorException {
//        return webTarget.request(MediaType.APPLICATION_JSON)
//                .post(Entity.entity(newSkill, MediaType.APPLICATION_JSON));
//    }
    public <T> T getAllSkills(GenericType<T> responseType) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).get(responseType);
    }

//    public Response updateSkill(int skillId, SkillsMaster updatedSkill) throws ClientErrorException {
//        return webTarget.path(String.valueOf(skillId)) // Append the skillId to the path
//                .request(MediaType.APPLICATION_JSON)
//                .put(Entity.entity(updatedSkill, MediaType.APPLICATION_JSON), Response.class);
//    }
//
//    public void deleteSkill(int skillId) throws ClientErrorException {
//        WebTarget target = client.target(BASE_URI).path("skills").path(String.valueOf(skillId));
//        Response response = target.request().delete(); // Make the DELETE request
//
//        if (response.getStatus() != Response.Status.NO_CONTENT.getStatusCode()) {
//            throw new ClientErrorException("Failed to delete skill, response code: " + response.getStatus(), response.getStatus());
//        }
//    }
//
//    // Holiday management methods
//    public Collection<HolidayMaster> getAllHolidays() throws ClientErrorException {
//        return webTarget.path("holidays")
//                .request(MediaType.APPLICATION_JSON)
//                .get(new GenericType<Collection<HolidayMaster>>() {
//                });
//    }
//    public Collection<HolidayMaster> getAllHolidays() {
//        Client client = ClientBuilder.newClient();
//        return client.target(BASE_URI)
//                .request(MediaType.APPLICATION_JSON)
//                .get(new GenericType<Collection<HolidayMaster>>() {
//                });
//    }
    public <T> T getAllHolidays(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("holidays");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);

    }

    public <T> T getAllAssets(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("assets");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

//
//    public Response addHoliday(String desc, Date holidayDate) throws ClientErrorException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = dateFormat.format(holidayDate);
//
//        // Construct the URL for the holiday addition endpoint with `add` subpath
//        return webTarget.path("add")
//                .path(desc)
//                .path(formattedDate)
//                .request()
//                .post(null);  // POST request without a request body
//    }
//
//    public Response updateHoliday(int holidayId, HolidayMaster holiday) throws ClientErrorException {
//        return webTarget.path("holiday").path(String.valueOf(holidayId)) // Append the holidayId
//                .request(MediaType.APPLICATION_JSON)
//                .put(Entity.entity(holiday, MediaType.APPLICATION_JSON));
//    }
//
//    public Response deleteHoliday(int holidayId) throws ClientErrorException {
//        return webTarget.path("holiday").path(String.valueOf(holidayId)) // Append the holidayId
//                .request()
//                .delete();
//    }
    public void close() {
        client.close();
    }
}
