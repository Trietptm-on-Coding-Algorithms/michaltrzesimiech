<%@page import="json.FetchPrice"%>
<%@ page import="java.util.Date,java.util.List,java.io.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>CryptocalcWeb</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
body {
	background-color: #777E8B;
	color: #414C5F;
	font-family: "Arial", serif;
}

lowqty {
	color: red;
}

h2 {
	background-color: 'lightgrey';
}
</style>

<script type="text/javascript"
	src="resources/jsFiles/jquery-1.10.1.min.js"></script>

<script>
	$('.qty').each(function() {
		if (parseInt($(this).text()) < 0) {
			$(this).addClass('lowqty');
		}
	});
</script>

</head>

<body>

	<c:set var="name" value="CryptocalcWeb" />
	<c:set var="now" value="<%=new java.util.Date()%>" />

	<br>
	<div style="text-align: center">

		<h2>
			<c:out value="${ name }" />
		</h2>
		<h3>
			<a href="jsp/about.jsp"> <c:out value="About" /></a> |
			<c:out value="${ now }" />
		</h3>
	</div>

	<%
		FetchPrice fetch = new FetchPrice();
		double price = FetchPrice.FetchPrice();
		String price_ = String.valueOf(price);
		pageContext.setAttribute("price", price);
	%>

	<div id="Current_portfolio">

		<c:set var="ownedEther" value="38.34702" />
		<c:set var="initInvestment" value="1516.85" />
		<c:set var="price" value="${ price }" />
		<c:set var="portfolioEur" value="${ ownedEther * price }" />
		<c:set var="portfolioPln" value="${ portfolioEur * 4.24 }" />
		<c:set var="PNL" value="${ (portfolioPln - initInvestment) }" />

		<h3>Current portfolio</h3>
		<h5>
			<a href="https://www.cryptonator.com/api/ticker/eth-eur"
				target="_blank">Look up prices</a>
		</h5>

		<table style="width: 50%">
			<tr>
				<td>Owned Ether:</td>
				<td><c:out value="${ ownedEther }" /></td>
			</tr>
			<tr>
				<td>Current price - EUR:</td>
				<td><c:out value="${ price }" /></td>
			</tr>
			<tr>
				<td>Profit and loss - PLN:</td>
				<td class="qty"><c:out value="${ PNL }" /></td>
			</tr>
		</table>
		<br> <br>
	</div>

	<div id="Custom_portfolio">
		<h3>Custom portfolio</h3>

<%-- 
		<form action="index.jsp" method="get">

			Owned Ether: <input name="owned_custom" type="text" value=<c:out value="${ ownedEther }" />> <br> 
			Initial investment: <input name="investment_custom" type="text" value="" />> <br> 
			Price: <input name="price_custom" type="text" value=<c:out value="" />> <br> 
			
			<%
				String owned_custom = request.getParameter("owned_custom");
				pageContext.setAttribute("owned_custom", owned_custom);
				
				String investment_custom = request.getParameter("investment_custom");
				pageContext.setAttribute("investment_custom", investment_custom);
				
				String price_custom =   request.getParameter("price_custom");
				pageContext.setAttribute("price_custom", price_custom);					
			%>

			<input type="submit" value="Submit">
		</form>
--%>

<script>
function myfunction() { 
var owned_custom = document.getElementById("owned_custom").value;
var price_custom = document.getElementById("price_custom").value; 
var investment_custom = document.getElementById("investment_custom").value; 
var answer = (parseFloat(owned_custom)*parseFloat(price_custom))-parseFloat(investment_custom);
var textbox3 = document.getElementById('PNL_custom');
PNL_custom.value=answer;
 } 
</script>


		<table style="width: 50%">
			<tr>
				<td>Owned Ether:</td>
				<td><input type="text" name="owned_custom" id="owned_custom" /></td>
			</tr>
			<tr>
				<td>Current price - custom:</td>
				<td><input type="text" name="price_custom" id="price_custom" /></td>
			</tr>
			<tr>
				<td>Initial investment - custom:</td>
				<td><input type="text" name="investment_custom" id="investment_custom" /></td>
			</tr>
			<tr>
				<td>Profit and loss - custom:</td>
				<td class="qty"><input type="text" name="PNL_custom" id="PNL_custom" readonly="true" /></td>
			</tr>
		</table>
		
<br>
<input type="submit" name="button" id="button1" onclick="myfunction()" value="Submit" />

	</div>

	<script>
		$.cookie("test", 1, {
			expires : 5
		});
	</script>

</body>

<%-- Elements of a .jsp page:
directives: comprehensive information on the page
statements: to declare methods and attributes
scriptlets: Java code that will be translated into code in the service() method
expressions: to easily send dynamically created string to the browser --%>

<%--
TODO: fetching live data onclick for "Look up prices" (json>db>site) or json dataloader
TODO: test conditional formatting
 --%>

</html>