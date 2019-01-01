<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red;text-align:center;">Order Method</h1>

<form action="insert" method="POST">
<pre>
Order Mode : <input type="radio" name="ordermode" value="SALE"/>sale
             <input type="radio" name="ordermode" value="PURCHASE"/>purchase
             
Order Code : <input type="text" name="ordercode"/>

Execute Type : <select name="executetype">
                <option value="">--select--</option>
                <option value="FIFO">FIFO</option>
                <option value="LIFO">LIFO</option>
                <option value="FCFO">FCFO</option>
                <option value="FEFO">FEFO</option>
               </select>

Order Accept :<input type="checkbox" name="orderaccept" value="MULTI-MODEL"/>Multi-Model
              <input type="checkbox" name="orderaccept" value="ACCEPT-RETURN"/>Accept-Return
              <input type="checkbox" name="orderaccept" value="SERVICE EXTEND"/>Service Extend

Description : <textarea name="desc"></textarea>              

<input type="submit" value="Create Order Method">

</pre>
</form>
<br>
${message}<br><br>

<a href="all">View all Order method</a>
</body>
</html>