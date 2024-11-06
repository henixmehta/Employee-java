package servlets;

import client.ManagerClient;
import entity.HolidayMaster;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ClientErrorException;

/**
 * Servlet to handle adding holidays and displaying existing holidays.
 */
@WebServlet(name = "HolidayServlet", urlPatterns = {"/HolidayServlet"})
public class HolidayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ManagerClient client = new ManagerClient();
        Collection<HolidayMaster> holidays;

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Holiday Management</title></head>");
            out.println("<body>");
            out.println("<h1>Holiday Management</h1>");

            // Fetch existing holidays
            try {
                holidays = client.getAllHolidays();
                out.println("<h2>Existing Holidays</h2>");
                out.println("<table border='1'><tr><th>ID</th><th>Description</th><th>Date</th></tr>");
                for (HolidayMaster holiday : holidays) {
                    out.println("<tr>");
                    out.println("<td>" + holiday.getHolidayId() + "</td>");
                    out.println("<td>" + holiday.getDescription() + "</td>");
                    out.println("<td>" + holiday.getHolidayDate() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (Exception e) {
                out.println("<p>Error retrieving holidays.</p>");
            }

            // Form for adding a new holiday
            out.println("<h2>Add a New Holiday</h2>");
            out.println("<form method='post' action='HolidayServlet'>");
            out.println("  <label for='description'>Description:</label>");
            out.println("  <input type='text' id='description' name='description' required><br><br>");
            out.println("  <label for='holidayDate'>Holiday Date:</label>");
            out.println("  <input type='date' id='holidayDate' name='holidayDate' required><br><br>");
            out.println("  <button type='submit'>Add Holiday</button>");
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

        String description = request.getParameter("description");
        String holidayDateStr = request.getParameter("holidayDate");

        Date holidayDate;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            holidayDate = dateFormat.parse(holidayDateStr);
        } catch (ParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format.");
            return;
        }

        ManagerClient client = new ManagerClient();
        try {
            // Add the new holiday
            client.addHoliday(description, holidayDate);

            // Redirect to the same servlet to display updated holidays and the form
            response.sendRedirect("HolidayServlet");
        } catch (ClientErrorException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding holiday.");
        } finally {
            client.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing holidays (add and display)";
    }
}
