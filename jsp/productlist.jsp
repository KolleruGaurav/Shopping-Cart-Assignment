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

function AddCart(id) 
{ 
 var i= id;
 //var name =document.getElementById(id).value;
 //sessionStorage.setItem(name,i);
 //alert(sessionStorage.setItem(name,i));
 //alert(name);
 alert(i);
 
 
}

function showvalue(pro){
	alert(pro);
	//alert($("#pro").text());
}

</script>
</head>
<body>
<label>${errorMessage}</label>
<form:form id="product" commandName="product" action="cartlist.action">
<div>
<table width="100%">

    <tr>
       <th width="20%">Product Name</th>
       <th width="20%">Product Details</th>
       <th width="20%">Product Cost</th>
       <th width="20%">Select Quantity</th>
       <th width="20%">Select Item</th>
    </tr>
     <c:forEach var="itemList"  items="${productList}" >
			<tr>
               <td align="center">${itemList.productName}</td> 
               <td align="center">${itemList.productDetails}</td>
               <td align="center">${itemList.productCost}/-</td>
               <td align="center">
               <form:select path="selectedQuantity" id="selectedQuantity" multiple="false">
                     <form:option value="-1">Select</form:option> 
                    <c:forEach var="i" begin="1" end="${itemList.productQuantity}">
                        <form:option value="${i}" id="${i}"></form:option>
                   </c:forEach>            
                  </form:select>   
               </td>
               
               <%-- <td align="center"><button class="default" onclick="AddCart(${itemList.productId})">Add to cart</button></td> --%>
               <td align="center"><form:checkbox value="${itemList.productId}" path="selectedProduct"></form:checkbox></td>
           </tr>							
									
      </c:forEach> 
    
    
    

</table>
<button class="default" type="submit" align="right">Add to cart</button>
</div>
</form:form>
</body>
</html>