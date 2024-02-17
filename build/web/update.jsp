<%-- 
    Document   : update
    Created on : Feb 7, 2024, 1:50:47 PM
    Author     : TR180124042
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%
    // Declare and initialize the personID variable
    String personID = request.getParameter("NameFirst");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update user data</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
            <style>

            body {
                padding: 20px;
                background-color: #28da9e;
            }

            .container {
                display: flex;
                width: 700px;
                background-color: #d1dbe5;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                margin-top: 30px;
                flex-wrap: nowrap;
                align-content: center;
                justify-content: center;
                align-items: center;
                flex-direction: column;
            }
            #crudForm{
                display: flex;
                flex-wrap: wrap;
            }


            h2 {
                text-align: center;
                color: #112841;
            }

            .form-group {
                /*                margin-bottom: 20px;*/
                margin: auto;
            }

            button {
                width: 100%;
                margin-top: 20px;
            }
            input:focus{
                border-color: black;
            }


        </style>
    <body>
        <div class="container">
            <h2>Update Data</h2>
            <form id="crudForm">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="Namefirst" maxlength="50" placeholder="Name" value=<%= personID %> required>
                </div>

                <div class="form-group">
                    <label for="middleName">Middle Name:</label>
                    <input type="text" class="form-control" id="Namemiddle" maxlength="50" placeholder="Middle" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" id="Namelast" maxlength="50">
                </div>

                <div class="form-group">
                    <label for="addressLine1">Address Line 1:</label>
                    <input type="text" class="form-control" id="Line1" maxlength="50">
                </div>

                <div class="form-group">
                    <label for="addressLine2">Address Line 2:</label>
                    <input type="text" class="form-control" id="Line2" maxlength="50">
                            </div>

                <div class="form-group">
                    <label for="pinCode">Pin Code:</label>
                    <input type="text" class="form-control" id="Code" pattern="[0-9]{6}">
                </div>

                <div class="form-group">
                    <label for="state">State:</label>
                    <select class="form-control" id="ss" onchange="getCity()">
                        <!-- Options will be added dynamically using AJAX -->
                        <option>select</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="city">City:</label>
                    <select class="form-control" id="cc">
                        <!-- Options will be added dynamically using AJAX -->
                        <option id="">select</option>
                    </select>
                </div>



                <button type="submit" class="btn btn-info">Update</button>
            </form>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
             function populateDropdown(data, dropdownId) {
        var dropdown = $(dropdownId);
        dropdown.empty();
        $.each(data, function (index, item) {
            dropdown.append($('<option></option>').text(item));
        });
    }
       function getCity() {
//                        basicdata();
        var selectedState = document.getElementById("ss").value;
        var formData1 = {
            data: $('#ss').val(),
        };
        $.ajax({
            url: '/GR_CRUD/CityServlet',
            type: 'GET',
            data: formData1,
//                                                        data: JSON.stringify({ data: $('#state').val()}),
//
            dataType: 'json',
            success: function (data) {
                console.log(data);
                populateDropdown(data.cities, '#cc');
                console.log(JSON.stringify({data: $('#ss').val()}))
                // Handle success, e.g., show a success message
                cities = data.cities;
                console.log(data.cities);

            },
            error: function (error) {
                console.error('Error submitting data:', error);
                // Handle error, e.g., show an error message
            }
        });
    }
    
        $(document).ready(function() {
            // Retrieve parameters from the URL
            var urlParams = new URLSearchParams(window.location.search);
            var id = urlParams.get('id');
            var personID = urlParams.get('Name');
            var firstName = urlParams.get('Namemiddle');
            var middleName = urlParams.get('Namelast');
            var lastName = urlParams.get('Line1');
            var addressLine1 = urlParams.get('Line2');
            var addressLine2 = urlParams.get('Code');
            var pinCode = urlParams.get('ss');
            var city = urlParams.get('cc');
           
           console.log(personID)
            // Set the retrieved values to the form fields
            $('#Namefirst').val(personID);
            $('#Namemiddle').val(firstName);
            $('#Namelast').val(middleName);
            $('#Line1').val(lastName);
            $('#Line2').val(addressLine1);
            $('#Code').val(addressLine2);
            $('#ss').val(pinCode);
            $('#cc').val(city);

            // Fetch city and state data using Ajax call
            $.ajax({
            url: '/GR_CRUD/GetCityStateDataServlet',
            type: 'GET',
            dataType: 'json', // Specify that the expected response is JSON
            success: function (data) {
                populateDropdown(data.states, '#ss');
                states = data.states;
//                            cities=data.cities;
//                            getCity();
                console.log(data.states);


            },
            error: function (error) {
                console.error('Error fetching city and state data:', error);
            }
        });

            // Function to populate a dropdown with options and select a specific option
 
 

//             Handle form submission
            $('#crudForm').submit(function(event) {
                event.preventDefault();

                var isValid = true;

                // Validate each form field
                if ($('#Namefirst').val().trim() === '') {
                    isValid = false;
                }


                if ($('#Namelast').val().trim() === '') {
                    isValid = false;
                }

                if ($('#Line1').val().trim() === '') {
                    isValid = false;
                }

                if ($('#Code').val().trim() === '' || !/^[0-9]{6}$/.test($('#Code').val())) {
                    isValid = false;
                }

                if ($('#cc').val() === '') {
                    isValid = false;
                }

                if ($('#ss').val() === '') {
                    isValid = false;
                    alert('Please select a state.');
                }

                if (isValid) {
                    // Collect updated data from the form
                    var updatedData = {
                        personID: id,
                        firstName: $('#Namefirst').val(),
                        middleName: $('#Namemiddle').val(),
                        lastName: $('#Namelast').val(),
                        addressLine1: $('#Line1').val(),
                        addressLine2: $('#Line2').val(),
                        pinCode: $('#Code').val(),
                        city: $('#cc').val(),
                        state: $('#ss').val()
                    };
                    console.log(updatedData);

                    // Perform an AJAX call to update the user data in the database
                    $.ajax({
                        url: '/GR_CRUD/UpdateServlet', 
                        type: 'POST',
                        data: updatedData,
//                        dataType:'json'
                        success: function(response) {
                            console.log('Data updated successfully:', response);
                            alert('Data updated successfully');
                            window.location.href = 'read.jsp';
                            // Handle success, e.g., show a success message
                        },
                        error: function(error) {
                            console.error('Error updating data:', error);
                            alert('Error updating data. Please try again.');
                            // Handle error, e.g., show an error message
                        }
                    });
                }
            });
        });
    </script>

</html>
