/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.ManagerSessionBeanLocal;
import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Henil
 */
@Path("manager")
@RequestScoped
public class ManagerResource {

    @EJB
    ManagerSessionBeanLocal msbl;
//
//    @Context
//    private UriInfo context;

    /**
     * Creates a new instance of ManagerResource
     */
    public ManagerResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SkillsMaster> getAllSkills() {
        return msbl.getAllSkill();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSkill(SkillsMaster skill) {
        msbl.addSkill(skill);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSkill(@PathParam("id") int id, SkillsMaster skill) {
        SkillsMaster existingSkill = msbl.getSkillById(id);
        if (existingSkill != null) {
            existingSkill.setSkillName(skill.getSkillName());
            existingSkill.setDescription(skill.getDescription());
            msbl.updateSkill(existingSkill);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    // 5. DELETE a skill by ID
    @DELETE
    @Path("{id}")
    public Response deleteSkill(@PathParam("id") int id) {
        SkillsMaster skill = msbl.getSkillById(id);
        if (skill != null) {
            msbl.deleteskill(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    /**
     * Retrieves representation of an instance of rest.ManagerResource
     *
     * @return an instance of java.lang.String
     */
    /**
     * PUT method for updating or creating an instance of ManagerResource
     *
     * @param content representation for the resource
     */
}
