<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Note Maker</title>
        <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script>
            const ServletURL = "${pageContext.request.contextPath}/NoteMaker";
            $(document).on("click", "#submitButton", function(event) {
            	event.preventDefault();
            	//if(!$.trim($("#title").val())){
            	$.post(ServletURL,
            			$("#inputForm").serialize(),
            			function(responseText) {
                    document.getElementById("inputForm").reset();
            		$("#leftdiv").html(responseText);
                });//};
            });
        </script>
       <script>
            const ServletURL2 = "${pageContext.request.contextPath}/NoteMaker";
            $(document).ready(function() { 
                $.get(ServletURL2, function(responseText) {
                    $("#leftdiv").html(responseText);           
                });
            });
        </script>
        <script>
        function deleteNote(val){
            const ServletURL3 = "${pageContext.request.contextPath}/NoteDeleter";
        	const id2 = {};
        	const key1 = "id";
        	const value1 = val.parentElement.getAttribute("name");
        	id2[key1] = value1;
        	$.get(ServletURL3, id2 ,function(){});
            val.parentElement.remove();

        }
        </script>

    </head>
    <body>
	    <div style="float:right; width: 25%;" id=rightdiv>
			<b><font size=6><u>Make Note</u></font></b><br>
			<form action="" id="inputForm">
				<label for="title">Title: <br/></label>
				<input type="text" id="title" name="title"/><br>
				<label for="summary">Summary: <br/></label>
				<textarea  id="text" name="summary" rows="6"></textarea><br>
				<input type="submit" value="Submit" id="submitButton">
			</form>
		</div>
	        
    	<div style="float:left; width: 70%;" id="leftdivhead">
			<b><u><font size=6>Current Notes</font></u></b><br>
				<div id="leftdiv">
				
				</div>


		</div>
	</body>
</html>