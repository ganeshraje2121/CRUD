/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TR080124006
 */
@WebServlet(urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");

    // Retrieve updated data from the request parameters
    String personID = request.getParameter("personID");
    String firstName = request.getParameter("firstName");
    String middleName = request.getParameter("middleName");
    String lastName = request.getParameter("lastName");
    String addressLine1 = request.getParameter("addressLine1");
    String addressLine2 = request.getParameter("addressLine2");
    String pinCode = request.getParameter("pinCode");
    String city = request.getParameter("city");
    String state = request.getParameter("state");

    try (Connection connection = DatabaseUtil.getConnection()) {
        // Update the data in the database
        String sql = "UPDATE GR_CRUD_PERSON SET first_name = ?, middle_name = ?, last_name = ?, address_line1 = ?, " +
                     "address_line2 = ?, pin_code = ?, city = ?, state = ? WHERE person_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set parameters for the update statement
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, addressLine1);
            preparedStatement.setString(5, addressLine2);
            preparedStatement.setString(6, pinCode);
            preparedStatement.setString(7, city);
            preparedStatement.setString(8, state);

            // Check if personID is not null before parsing
            if (personID != null && !personID.isEmpty()) {
                int personIdInt = Integer.parseInt(personID);
                preparedStatement.setInt(9, personIdInt);
            } else {
                // Handle the case where personID is null or empty
                response.getWriter().write("Person ID is missing or invalid");
                return;
            }

            // Execute the update statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Send a response indicating the update status
            if (rowsAffected > 0) {
                response.getWriter().write("Data updated successfully");
            } else {
                response.getWriter().write("Failed to update data");
            }
        }
    } catch (SQLException e) {
        response.getWriter().write("Error updating data");
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
