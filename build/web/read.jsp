<%-- 
    Document   : read
    Created on : Feb 2, 2024, 5:04:06 PM
    Author     : TR080124006
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Data</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <h2>User Data</h2>
        <div id="readData"></div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        $(document).ready(function() {
            $.ajax({
                url: '/GR_CRUD/ReadServlet',
                type: 'GET',
                dataType: 'json',
                success: function(data) {
                    displayReadData(data);
                    console.log(data);
                },
                error: function(error) {
                    console.error('Error fetching read data:', error);
                }
            });

            function displayReadData(data) {
                var readDataContainer = $('#readData');
                readDataContainer.empty();

                if (data && data.length > 0) {
                    var tableHtml = '<table class="table table-striped"><thead><tr>' +
                                    '<th>First Name</th><th>Middle Name</th><th>Last Name</th>' +
                                    '<th>Address Line 1</th><th>Address Line 2</th><th>Pin Code</th>' +
                                    '<th>City</th><th>State</th></tr></thead><tbody>';

                    $.each(data, function(index, item) {
                        tableHtml += '<tr>' +
                                     '<td>' + item.firstName + '</td>' +
                                     '<td>' + item.middleName + '</td>' +
                                     '<td>' + item.lastName + '</td>' +
                                     '<td>' + item.addressLine1 + '</td>' +
                                     '<td>' + item.addressLine2 + '</td>' +
                                     '<td>' + item.pinCode + '</td>' +
                                     '<td>' + item.city + '</td>' +
                                     '<td>' + item.state + '</td>' +
                                     '</tr>';
                    });

                    tableHtml += '</tbody></table>';
                    readDataContainer.html(tableHtml);
                } else {
                    readDataContainer.html('<p>No data available.</p>');
                }
            }
        });
    </script>

</body>
</html>

