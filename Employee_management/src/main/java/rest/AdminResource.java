/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.AdminSessionBeanLocal;
import entity.SkillsMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Henil
 */
@Path("Admin")
@RequestScoped
public class AdminResource {

    @EJB
    AdminSessionBeanLocal asbl;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<SkillsMaster> getAllSkills() {
        return asbl.getAllSkill();
    }

    /**
     * Retrieves representation of an instance of rest.AdminResource
     *
     * @return an instance of java.lang.String
     */
}
