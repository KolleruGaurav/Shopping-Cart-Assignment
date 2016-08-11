<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<title><tiles:getAsString name="title" /></title>  

<script src="resources/jquery-1.11.2.min.js"  type="text/javascript"></script>
<script src="resources/jquery-migrate-1.2.1.js"  type="text/javascript"></script>
<!-- <script src="resources/common.js"  type="text/javascript"></script>  -->
</head>  
<body>  
  
<tiles:insertAttribute name="header" /> 
<tiles:insertAttribute name="body" />  
<tiles:insertAttribute name="footer" /> 
  
</body>  
</html>   