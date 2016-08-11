<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

</script>
</head>
<body>
<label class="errormsg" >${errorMessage}</label>
<form:form id="cartProduct" commandName="cartProduct" action="productlist.action">
<div>
<table width="100%">
    <tr><th>Hello:  ${userName} </th></tr>
    <tr>
       <th width="20%">Product Name</th>
       <th width="20%">Product Details</th>
       <th width="20%">Product Cost</th>
       <th width="20%">Selected Quantity</th>
       
    </tr>
     <c:forEach var="itemList"  items="${cartList}" >
			<tr>
               <td align="center">${itemList.productName}</td> 
               <td align="center">${itemList.productDetails}</td>
               <td align="center">${itemList.productTotalCost}</td>
               <td align="center">${itemList.quantity}</td> 
                             
           </tr>							
									
      </c:forEach>
     <tr><th width="20%">Total Bill</th><th>${grandtotal}</th></tr>
    </table>
          <button class="default" type="submit" align="right">Continue Shopping</button>
     </div>
</form:form>
</body>
</html>