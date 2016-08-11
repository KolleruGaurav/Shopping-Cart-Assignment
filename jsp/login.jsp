<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<html>
<head>
<script src="resources/jquery-1.8.2.min.js" type="text/javascript"></script>
<script>

function submitForm() 
{ 

	$("#loginForm").attr("action", "login.action");
	$("#loginForm").submit();
}

</script>
<style>
.errormsg {
	color: red;
}
.ie8Lbls {
    font-size:10px;
}

</style>
</head>
<body>

    <div>
      <div align="center"><span style="font-size: 40px; font-family: Wide Latin;color: black;"><strong>Shopping Cart</strong></span>
      </div>
      
    </div>
    <form:form id="loginForm" commandName="loginForm"> 
    <div>
      <div>
	<label class="errormsg" >${errorMessage}</label>
	
	<label class="successmsg">${successMessage}</label>	
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="10">
   	<tr>
       <td ><strong>User ID</strong></td>
        <td><form:input id="userId" path="userId" placeholder="Please Enter User ID"/>
            <form:errors path="userId"></form:errors></td></tr>
   
      <tr>
      
       <td ><strong>Password</strong></td>
        <td>
        <form:password id="password" name="password" path="password" placeholder="Please Enter Password" />
            <form:errors path="password"></form:errors>	 </td>
      </tr>
                    
     <tr>
         <td>&nbsp;</td>
      <td> <button class="default" onclick="submitForm()">Login</button></td>
       
     </tr>
      </table>
    </div>
    </form:form>
  

</body>
</html>