package rest;

import ejb.ManagerSessionBeanLocal;
import entity.AssetsMaster;
import entity.HolidayMaster;
import entity.SkillsMaster;
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

    //==== Skills Management Endpoints ====
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
//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateSkill(@PathParam("id") int id, SkillsMaster skill) {
//        SkillsMaster existingSkill = msbl.getSkillById(id);
//        if (existingSkill != null) {
//            existingSkill.setSkillName(skill.getSkillName());
//            existingSkill.setDescription(skill.getDescription());
//            msbl.updateSkill(existingSkill);
//            return Response.ok(existingSkill).build();  // Respond with updated skill entity
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("Skill not found").build();
//        }
//    }
//
//    @DELETE
//    @Path("/skills/{id}")
//    public Response deleteSkill(@PathParam("id") int id) {
//        SkillsMaster skill = msbl.getSkillById(id);
//        if (skill != null) {
//            msbl.deleteskill(id);  // Double-check this method deletes as expected
//            return Response.status(Response.Status.NO_CONTENT).build(); // Success, no content
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("Skill not found").build();
//        }
//    }
    //==== Holidays Management Endpoints ====

    @GET
    @Path("holidays")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<HolidayMaster> getAllHolidays() {
        return msbl.getAllHolidays();
    }

//    @POST
//    @Path("add/{Desc}/{HolidayDate}")
//    public Response addHoliday(@PathParam("Desc") String Desc, @PathParam("HolidayDate") String HolidayDate) {
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = dateFormat.parse(HolidayDate);
//
//            msbl.addHoliday(Desc, date);
//            return Response.status(Response.Status.CREATED).entity("Holiday added successfully").build();
//        } catch (ParseException e) {
//            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format").build();
//        }
//    }
//
//    @PUT
//    @Path("holiday/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateHoliday(@PathParam("id") int id, HolidayMaster holiday) {
//        HolidayMaster existingHoliday = msbl.getHolidayById(id);
//        if (existingHoliday != null) {
//            existingHoliday.setDescription(holiday.getDescription());
//            existingHoliday.setHolidayDate(holiday.getHolidayDate());
//            msbl.updateHoliday(id, holiday.getDescription(), holiday.getHolidayDate());
//            return Response.ok(existingHoliday).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("Holiday not found").build();
//        }
//    }
//
//    @DELETE
//    @Path("holiday/{id}")
//    public Response deleteHoliday(@PathParam("id") int id) {
//        HolidayMaster holiday = msbl.getHolidayById(id);
//        if (holiday != null) {
//            msbl.removeHoliday(id);
//            return Response.status(Response.Status.NO_CONTENT).build();
//        } else {
//            return Response.status(Response.Status.NOT_FOUND).entity("Holiday not found").build();
//        }
//    }
    @GET
    @Path("assets")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AssetsMaster> getAllAssets() {
        return msbl.getAllAssets();
    }

}
