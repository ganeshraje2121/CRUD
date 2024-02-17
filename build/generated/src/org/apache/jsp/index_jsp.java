package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>CRUD Demo</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                padding: 20px;\n");
      out.write("                background-color: #28da9e;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                display: flex;\n");
      out.write("                width: 700px;\n");
      out.write("                background-color: #d1dbe5;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("                padding: 20px;\n");
      out.write("                margin-top: 30px;\n");
      out.write("                flex-wrap: nowrap;\n");
      out.write("                align-content: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                align-items: center;\n");
      out.write("                flex-direction: column;\n");
      out.write("            }\n");
      out.write("            #crudForm{\n");
      out.write("                display: flex;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            h2 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #112841;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .form-group {\n");
      out.write("                /*                margin-bottom: 20px;*/\n");
      out.write("                margin: auto;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            button {\n");
      out.write("                width: 100%;\n");
      out.write("                margin-top: 20px;\n");
      out.write("            }\n");
      out.write("            input:focus{\n");
      out.write("                border-color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2>CRUD Form Demo</h2>\n");
      out.write("            <form id=\"crudForm\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"firstName\">First Name:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"firstName\" maxlength=\"50\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"middleName\">Middle Name:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"middleName\" maxlength=\"50\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"lastName\">Last Name:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"lastName\" maxlength=\"50\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"addressLine1\">Address Line 1:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"addressLine1\" maxlength=\"50\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"addressLine2\">Address Line 2:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"addressLine2\" maxlength=\"50\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"pinCode\">Pin Code:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"pinCode\" pattern=\"[0-9]{6}\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"state\">State:</label>\n");
      out.write("                    <select class=\"form-control\" id=\"state\" onchange=\"getCity()\">\n");
      out.write("                        <!-- Options will be added dynamically using AJAX -->\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"city\">City:</label>\n");
      out.write("                    <select class=\"form-control\" id=\"city\">\n");
      out.write("                        <!-- Options will be added dynamically using AJAX -->\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Add this section in the body of your HTML to display the read data -->\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <h2>Read Data</h2>\n");
      out.write("            <button type=\"button\" class=\"btn btn-secondary\" onclick=\"window.location.href = 'read.jsp'\">View All User Data</button>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.6.4.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var states;\n");
      out.write("            var cities;\n");
      out.write("            var selectedState = document.getElementById(\"state\").value;\n");
      out.write("            console.log(selectedState);\n");
      out.write("//                    function getCity() {\n");
      out.write("//                        \n");
      out.write("//                        var selectedState = document.getElementById(\"state\").value;\n");
      out.write("//                        var filteredCities = [];\n");
      out.write("//\n");
      out.write("//                        for (var i = 0; i < states.length; i++) {\n");
      out.write("//                            if (states[i] === selectedState) {\n");
      out.write("//                                filteredCities.push(cities[i]);\n");
      out.write("//                            }\n");
      out.write("//                        }\n");
      out.write("//\n");
      out.write("//                        populateDropdown(filteredCities, '#city');\n");
      out.write("//                    }\n");
      out.write("                    function getCity(){\n");
      out.write("                        $.ajax({Y-\n");
      out.write("                            url: '/GR_CRUD/CityServlet',\n");
      out.write("                            type: 'GET',\n");
      out.write("                            data: JSON.stringify({ data: selectedState }),\n");
      out.write("                            dataType: 'json',\n");
      out.write("                            success: function (data) {\n");
      out.write("                                populateDropdown(data.cities, '#city');\n");
      out.write("                                console.log(selectedState);\n");
      out.write("                                // Handle success, e.g., show a success message\n");
      out.write("                                cities=data.cities;\n");
      out.write("                                console.log(data.cities + data);\n");
      out.write("                                \n");
      out.write("                            },\n");
      out.write("                            error: function (error) {\n");
      out.write("                                console.error('Error submitting data:', error);\n");
      out.write("                                // Handle error, e.g., show an error message\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                    function populateDropdown(data, dropdownId) {\n");
      out.write("                        var dropdown = $(dropdownId);\n");
      out.write("                        dropdown.empty();\n");
      out.write("                        $.each(data, function (index, item) {\n");
      out.write("                            dropdown.append($('<option></option>').text(item));\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    // Populate City and State dropdowns using AJAX\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: '/GR_CRUD/GetCityStateDataServlet',\n");
      out.write("                        type: 'GET',\n");
      out.write("                        dataType: 'json', // Specify that the expected response is JSON\n");
      out.write("                        success: function (data) {\n");
      out.write("                            populateDropdown(data.states, '#state');\n");
      out.write("                            states=data.states;\n");
      out.write("//                            cities=data.cities;\n");
      out.write("//                            getCity();\n");
      out.write("                            console.log(data.states);\n");
      out.write("                            \n");
      out.write("                        },\n");
      out.write("                        error: function (error) {\n");
      out.write("                            console.error('Error fetching city and state data:', error);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("                    // Handle form submission\n");
      out.write("                    $('#crudForm').submit(function (event) {\n");
      out.write("                        event.preventDefault();\n");
      out.write("\n");
      out.write("                        var formData = {\n");
      out.write("                            firstName: $('#firstName').val(),\n");
      out.write("                            middleName: $('#middleName').val(),\n");
      out.write("                            lastName: $('#lastName').val(),\n");
      out.write("                            addressLine1: $('#addressLine1').val(),\n");
      out.write("                            addressLine2: $('#addressLine2').val(),\n");
      out.write("                            pinCode: $('#pinCode').val(),\n");
      out.write("                            city: $('#city').val(),\n");
      out.write("                            state: $('#state').val()\n");
      out.write("                        };\n");
      out.write("\n");
      out.write("                        $.ajax({\n");
      out.write("                            url: '/GR_CRUD/CRUDServlet',\n");
      out.write("                            type: 'POST',\n");
      out.write("                            data: formData,\n");
      out.write("                            success: function (response) {\n");
      out.write("                                console.log('Data submitted successfully:', response);\n");
      out.write("                                // Handle success, e.g., show a success message\n");
      out.write("                            },\n");
      out.write("                            error: function (error) {\n");
      out.write("                                console.error('Error submitting data:', error);\n");
      out.write("                                // Handle error, e.g., show an error message\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("\n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("                    // Function to populate dropdown\n");
      out.write("                    \n");
      out.write("                });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}