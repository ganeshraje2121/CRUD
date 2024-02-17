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
 * @author TR180124042
 */
@WebServlet(urlPatterns = {"/UpdateGet"})
public class UpdateGet extends HttpServlet {

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
            String data = request.getParameter("data");
            // Fetch City and State data from the database
            String sql = "SELECT * FROM GR_CRUD_PERSON where FIRST_NAME = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, data);
                ResultSet resultSet = preparedStatement.executeQuery();
                String id=null;
                String fname = null;
                String mname = null;
                String lastName = null;
                String addressLine1 = null;
                String addressLine2 = null;
                String pinCode = null;
                String city = null;
                String state = null;
                while (resultSet.next()) {
                    id = resultSet.getString("PERSON_ID");
                   fname  = resultSet.getString("FIRST_NAME");
                   mname = resultSet.getString("MIDDLE_NAME");
                    lastName = resultSet.getString("LAST_NAME");
                    addressLine1 = resultSet.getString("ADDRESS_LINE1");
                    addressLine2 = resultSet.getString("ADDRESS_LINE2");
                    pinCode = resultSet.getString("PIN_CODE");
                    city = resultSet.getString("CITY");
                    state = resultSet.getString("STATE");
                }

                
//                String mname = resultSet.getString("MIDDLE_NAME");
//                String lastName = resultSet.getString("LAST_NAME");
//                String addressLine1 = resultSet.getString("ADDRESS_LINE1");
//                String addressLine2 = resultSet.getString("ADDRESS_LINE2");
//                String pinCode = resultSet.getString("PIN_CODE");
//                String city = resultSet.getString("CITY");
//                String state = resultSet.getString("STATE");

                // Convert data to JSON format
                String jsonData = "{\"fname\": \"" + fname + "\"" + ", \"mname\": \"" + mname + "\"" + ", \"lastName\": \"" + lastName + "\"" + ", \"addressLine1\": \"" + addressLine1 +"\"" +", \"addressLine2\": \"" + addressLine2 + "\"" + 
                 ", \"pinCode\": \"" + pinCode + "\"" + ", \"city\": \"" + city + "\""  +  ", \"state\": \"" + state + "\""+   ", \"id\": \"" + id + "\""+ "}";

                // Send JSON response to the client
                out.write(jsonData);

            } catch (SQLException e) {
                e.printStackTrace();
                out.write("{\"error\": \"Error fetching data\"}");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("{\"error\": \"Error connecting to the database\"}");
        }
    }

//    private String convertListToJsonArray(List<String> list) {
//        StringBuilder jsonArray = new StringBuilder("[");
//        for (int i = 0; i < list.size(); i++) {
//            jsonArray.append("\"").append(list.get(i)).append("\"");
//            if (i < list.size() - 1) {
//                jsonArray.append(",");
//            }
//        }
//        jsonArray.append("]");
//        return jsonArray.toString();
//
//    }

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
