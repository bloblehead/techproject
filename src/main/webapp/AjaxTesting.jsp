<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>TESTING</title>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script>
            const yourServletURL = "${pageContext.request.contextPath}/NoteMaker";
            $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
                $.get(yourServletURL, function(responseText) {  // Execute Ajax GET request on your servlet URL and execute the following function with Ajax response text...
                    $("#somediv2").html(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                });
            });
        </script>
    </head>
    <body>
        <button id="somebutton">press here</button>
        <div id="somediv">
        	div1 is here
        	<div id = "somediv2">
        	div2 is here
        	</div>
        </div>
    </body>
</html>