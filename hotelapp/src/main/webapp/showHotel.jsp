<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Details</title>
</head>
<body>
<h1>${hotel.name}</h1>
<address>${hotel.address} <br />
${hotel.city}, ${hotel.state}, ${hotel.zip} <br />
${hotel.country}</address>
<p>Rate: ${hotel.price }</p>
<a href="booking.do?id=${hotel.id}">Book this Hotel</a>
</body>
</html>