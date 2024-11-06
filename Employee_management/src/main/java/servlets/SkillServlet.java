package servlets;

import client.ManagerClient;
import entity.SkillsMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ClientErrorException;

/**
 * Servlet to handle adding skills and displaying existing skills.
 */
@WebServlet(name = "SkillServlet", urlPatterns = {"/SkillServlet"})
public class SkillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ManagerClient client = new ManagerClient();
        Collection<SkillsMaster> skills;

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Skill Management</title></head>");
            out.println("<body>");
            out.println("<h1>Skill Management</h1>");

            // Fetch existing skills
            try {
                skills = client.getAllSkills(new javax.ws.rs.core.GenericType<Collection<SkillsMaster>>() {});
                out.println("<h2>Existing Skills</h2>");
                out.println("<table border='1'><tr><th>ID</th><th>Skill Name</th><th>Description</th><th>Action</th></tr>");
                for (SkillsMaster skill : skills) {
                    out.println("<tr>");
                    out.println("<td>" + skill.getSkillId() + "</td>");
                    out.println("<td>" + skill.getSkillName() + "</td>");
                    out.println("<td>" + skill.getDescription() + "</td>");
                    out.println("<td>");
                    out.println("<form method='post' action='SkillServlet'>");
                    out.println("<input type='hidden' name='action' value='delete'>");
                    out.println("<input type='hidden' name='skillId' value='" + skill.getSkillId() + "'>");
                    out.println("<button type='submit'>Delete</button>");
                    out.println("</form>");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (Exception e) {
                out.println("<p>Error retrieving skills.</p>");
            }

            // Form for adding a new skill
            out.println("<h2>Add a New Skill</h2>");
            out.println("<form method='post' action='SkillServlet'>");
            out.println("  <label for='skillName'>Skill Name:</label>");
            out.println("  <input type='text' id='skillName' name='skillName' required><br><br>");
            out.println("  <label for='description'>Description:</label>");
            out.println("  <input type='text' id='description' name='description' required><br><br>");
            out.println("  <button type='submit'>Add Skill</button>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        } finally {
            client.close(); // Ensure client is closed
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        // Redirect flag
        boolean redirect = false;

        if ("delete".equals(action)) {
            // Get skillId as an int
            int skillId;
            try {
                skillId = Integer.parseInt(request.getParameter("skillId"));
                ManagerClient client = new ManagerClient();
                try {
                    client.deleteSkill(skillId); // Ensure deleteSkill is defined to handle the deletion
                    redirect = true; // Set the redirect flag
                } catch (ClientErrorException e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error deleting skill.");
                } finally {
                    client.close();
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid skill ID.");
                return;
            }
        } else {
            // Existing logic for adding a new skill
            String skillName = request.getParameter("skillName");
            String description = request.getParameter("description");

            SkillsMaster newSkill = new SkillsMaster();
            newSkill.setSkillName(skillName);
            newSkill.setDescription(description);

            ManagerClient client = new ManagerClient();
            try {
                client.addSkill(newSkill);
                redirect = true; // Set the redirect flag
            } catch (ClientErrorException e) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding skill.");
            } finally {
                client.close();
            }
        }

        // Only redirect if we set the flag to true
        if (redirect) {
            response.sendRedirect("SkillServlet");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing skills (add, delete, and display)";
    }
}
