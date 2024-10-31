/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import entity.SkillsMaster;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
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

    public Response addSkill(SkillsMaster newSkill) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newSkill, MediaType.APPLICATION_JSON));
    }

//    public <T> T addSkill(GenericType<T> responseType) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
//    }
    public <T> T getAllSkills(javax.ws.rs.core.GenericType<T> responseType) throws ClientErrorException {
        return webTarget.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public Response updateSkill(int skillId, Object requestEntity) throws ClientErrorException {
        return webTarget.path(String.valueOf(skillId)) // Append the skillId to the path
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    // Method to get all skills (assuming it returns a collection of skills)
    // Method to delete a skill by ID
    public Response deleteSkill(int skillId) throws ClientErrorException {
        return webTarget.path(String.valueOf(skillId))
                .request()
                .delete();
    }

    public void close() {
        client.close();
    }

}
