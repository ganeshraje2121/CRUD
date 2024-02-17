/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TR080124006
 */
@WebServlet(urlPatterns = {"/ReadServlet"})
public class ReadServlet extends HttpServlet {

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
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter();
             Connection connection = DatabaseUtil.getConnection()) {

            // Fetch all data from the Person table
            String sql = "SELECT * FROM GR_CRUD_PERSON";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                List<PersonData> personDataList = new ArrayList<>();

                while (resultSet.next()) {
                    PersonData personData = new PersonData();
                    personData.setFirstName(resultSet.getString("first_name"));
                    personData.setMiddleName(resultSet.getString("middle_name"));
                    personData.setLastName(resultSet.getString("last_name"));
                    personData.setAddressLine1(resultSet.getString("address_line1"));
                    personData.setAddressLine2(resultSet.getString("address_line2"));
                    personData.setPinCode(resultSet.getString("pin_code"));
                    personData.setCity(resultSet.getString("city"));
                    personData.setState(resultSet.getString("state"));

                    personDataList.add(personData);
                }

                // Send JSON response to the client
                out.write(convertListToJsonArray(personDataList));

            } catch (SQLException e) {
                e.printStackTrace();
                out.write("{\"error\": \"Error fetching data\"}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("{\"error\": \"Error connecting to the database\"}");
        }
    }

    private String convertListToJsonArray(List<PersonData> personDataList) {
        StringBuilder jsonArray = new StringBuilder("[");
        for (int i = 0; i < personDataList.size(); i++) {
            PersonData personData = personDataList.get(i);
            jsonArray.append("{");
            jsonArray.append("\"firstName\":\"").append(personData.getFirstName()).append("\",");
            jsonArray.append("\"middleName\":\"").append(personData.getMiddleName()).append("\",");
            jsonArray.append("\"lastName\":\"").append(personData.getLastName()).append("\",");
            jsonArray.append("\"addressLine1\":\"").append(personData.getAddressLine1()).append("\",");
            jsonArray.append("\"addressLine2\":\"").append(personData.getAddressLine2()).append("\",");
            jsonArray.append("\"pinCode\":\"").append(personData.getPinCode()).append("\",");
            jsonArray.append("\"city\":\"").append(personData.getCity()).append("\",");
            jsonArray.append("\"state\":\"").append(personData.getState()).append("\"");
            jsonArray.append("}");

            if (i < personDataList.size() - 1) {
                jsonArray.append(",");
            }
        }
        jsonArray.append("]");
        return jsonArray.toString();
        
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
