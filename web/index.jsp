<%-- 
    Document   : index
    Created on : Feb 2, 2024, 11:21:26 AM
    Author     : TR080124042
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@include file="script.jsp"%>--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CRUD Ganesh Raje @copyrights claimed</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
    </head>
    <body>

        <div class="container">
            <h2>CRUD Form Demo</h2>
            <form id="crudForm">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" id="firstName" maxlength="50" placeholder="Name" required >
                </div>

                <div class="form-group">
                    <label for="middleName">Middle Name:</label>
                    <input type="text" class="form-control" id="middleName" maxlength="50" placeholder="Middle" required>
                </div>

                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" id="lastName" maxlength="50">
                </div>

                <div class="form-group">
                    <label for="addressLine1">Address Line 1:</label>
                    <input type="text" class="form-control" id="addressLine1" maxlength="50">
                </div>

                <div class="form-group">
                    <label for="addressLine2">Address Line 2:</label>
                    <input type="text" class="form-control" id="addressLine2" maxlength="50">
                </div>

                <div class="form-group">
                    <label for="pinCode">Pin Code:</label>
                    <input type="text" class="form-control" id="pinCode" pattern="[0-9]{6}" >
                </div>

                <div class="form-group">
                    <label for="state">State:</label>
                    <select class="form-control" id="state" onchange="getCity()">
                        <!-- Options will be added dynamically using AJAX -->

                    </select>
                </div>

                <div class="form-group">
                    <label for="city">City:</label>
                    <select class="form-control" id="city">
                        <!-- Options will be added dynamically using AJAX -->
                        <option >select</option>
                    </select>
                </div>



                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <!-- Add this section in the body of your HTML to display the read data -->
        <div class="container mt-5">
            <h2>Read Data</h2>
            <button type="button" class="btn btn-secondary" onclick="window.location.href = 'read.jsp'">View All User Data</button>
        </div>
        <div class="container mt-5">
            <h2>Update Data</h2>
            <label for="Name">First Name:</label>
            <input type="text" class="form-control" id="Name" maxlength="50">
            <button type="button" class="btn btn-secondary" onclick="updateGet()">Update User Data</button>
        </div>

        <div class="container mt-6">
            <h2>Delete Data With Fname</h2>
            <label for="fName">First Name:</label>
            <input type="text" class="form-control" id="fName" maxlength="50">
            <button type="button" class="btn btn-secondary" onclick="del()">Delete</button>
        </div>
        <footer>
            <p>&copy; 2024 Your Website Name. All rights reserved. | Designed by <a href="https://www.example.com">@ganeshraje</a></p>
        </footer>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script>
                var states;
                var cities;
                function validateFirstName() {
    var firstNameInput = document.getElementById("firstName");
    var firstNameValue = firstNameInput.value.trim(); // Remove leading/trailing whitespace

    // Check if the first name field is empty
    if (firstNameValue === "") {
        alert("Please enter your first name.");
        firstNameInput.focus(); // Set focus back to the first name input field
    }
}

                //                    function getCity() {
                //                        
                //                        var selectedState = document.getElementById("state").value;
                //                        var filteredCities = [];
                //
                //                        for (var i = 0; i < states.length; i++) {
                //                            if (states[i] === selectedState) {
                //                                filteredCities.push(cities[i]);
                //                            }
                //                        }
                //
                //                        populateDropdown(filteredCities, '#city');
                //                    }
                function getCity() {
                    //                        basicdata();
                    var selectedState = document.getElementById("state").value;
                    var formData1 = {
                        data: $('#state').val(),
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
                            populateDropdown(data.cities, '#city');
                            console.log(JSON.stringify({data: $('#state').val()}))
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
                function populateDropdown(data, dropdownId) {
                    var dropdown = $(dropdownId);
                    dropdown.empty();
                    $.each(data, function (index, item) {
                        dropdown.append($('<option></option>').text(item));
                    });
                }
                $(document).ready(function () {
                    // Populate City and State dropdowns using AJAX
                    $.ajax({
                        url: '/GR_CRUD/GetCityStateDataServlet',
                        type: 'GET',
                        dataType: 'json', // Specify that the expected response is JSON
                        success: function (data) {
                            populateDropdown(data.states, '#state');
                            states = data.states;
                            //                            cities=data.cities;
                            //                            getCity();
                            console.log(data.states);


                        },
                        error: function (error) {
                            console.error('Error fetching city and state data:', error);
                        }
                    });

                    // Handle form submission
                    $('#crudForm').submit(function (event) {
                        event.preventDefault();
                        var flag = basicdata();
                        if (flag) {

                            var formData = {
                                firstName: $('#firstName').val(),
                                middleName: $('#middleName').val(),
                                lastName: $('#lastName').val(),
                                addressLine1: $('#addressLine1').val(),
                                addressLine2: $('#addressLine2').val(),
                                pinCode: $('#pinCode').val(),
                                city: $('#city').val(),
                                state: $('#state').val()
                            };

                            $.ajax({
                                url: '/GR_CRUD/CRUDServlet',
                                type: 'POST',
                                data: formData,
                                success: function (response) {
                                    console.log('Data submitted successfully:', response);
                                    alert("Data submitted");
                                    $('#crudForm')[0].reset();

                                    // Handle success, e.g., show a success message
                                },
                                error: function (error) {
                                    console.error('Error submitting data:', error);
                                    // Handle error, e.g., show an error message
                                }
                            });
                        }
                    }
                    );




                    // Function to populate dropdown

                }
                );
                function basicdata() {
                    /////////////////////////////////////////////////Validation Starts/////////////////////////////////
                    //alert("basicdata starts");

                    var nam = document.getElementById("firstName").value;
                    if (nam.length < 1) {
                        alert("First name can't be empty");
                        return false;
                    }

                    var mnam = document.getElementById("middleName").value;
                    //alert("basicdata lnam "+ lnam);
                    if (mnam.length < 1) {
                        alert("Middle name can't be empty");
                        return false;
                    }
                    var lnam = document.getElementById("lastName").value;
                    //alert("basicdata lnam "+ lnam);
                    if (lnam.length < 1) {
                        alert("Last name can't be empty");
                        return false;
                    }
                    if ($('#addressLine1').val().trim() === '') {
                        alert("Enter Address");
                        return false;
                    }

//                    if ($('#Code').val().trim() === '' || !/^[0-9]{6}$/.test($('#Code').val())) {
//                        isValid = false;
//                    }

                    if ($('#state').val() === '') {
                        alert('Please select a state.');
                        return false;
                    }

                    if ($('#city').val() === '') {
                        return false;
                        alert('Please select a city.');
                    }

                    return true;
                }
                function del() {

                    var selectName = document.getElementById("fName").value;
                    var formData1 = {
                        data: $('#fName').val(),
                    };
                    $.ajax({
                        url: '/GR_CRUD/DeleteServlet',
                        type: 'POST',
                        data: formData1,

                        success: function (response) {
                            //                                console.log(data);
                            alert(selectName + " Deleted");
                            $('#fName').val('');
                            // Handle success, e.g., show a success message

                        },
                        error: function (error) {
                            console.error('Error submitting data:', error);
                            // Handle error, e.g., show an error message
                        }
                    });
                }
                window.updateGet = function () {
                    var dat;
                    var selectedName = document.getElementById("Name").value;
                    var formData1 = {
                        data: $('#Name').val(),
                    };
                    console.log(formData1);
                    $.ajax({
                        url: '/GR_CRUD/UpdateGet',
                        type: 'POST',
                        data: formData1,
                        dataType: 'json',
                        //                                                        data: JSON.stringify({ data: $('#state').val()}),
                        //
                        //            dataType: 'json',
                        success: function (data) {
                            //                JSON.parse(data);
                            console.log(data);
                            alert("Got the data");
                            console.log(data.fname);

                            window.location.href = 'update.jsp?id=' + data.id +
                                    '&Name=' + data.fname +
                                    '&Namemiddle=' + data.mname +
                                    '&Namelast=' + data.lastName +
                                    '&Line1=' + data.addressLine1 +
                                    '&Line2=' + data.addressLine2 +
                                    '&Code=' + data.pinCode +
                                    '&ss=' + data.city +
                                    '&cc=' + data.state;

                            //                ffill(data);


                            // Handle success, e.g., show a success message


                        },
                        error: function (error) {
                            console.error('Error submitting data:', error);
                            // Handle error, e.g., show an error message
                        }
                    });

                }
                function ffill(data) {
                    console.log(data);
                    $('#Namefirst').val(data.fname);
                    $('#Namemiddle').val(data.mname);
                    $('#Namelast').val(data.lastName);
                    $('#Line1').val(data.addressLine1);
                    $('#Line2').val(data.addressLine2);
                    $('#Code').val(data.pinCode);
                    $('#ss').val(data.city);
                    $('#cc').val(data.state);
                }
        </script>
    </body>
</html>
