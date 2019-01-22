<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Document Registration</h1>

<form action="upload" method="POST" enctype="multipart/form-data">
<pre>
SELECT DOCUMENT <input type="file" name="fileOb" />
                <input type="submit" value="Upload"/>
</pre>
</form>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Data</th>
</tr>
<c:forEach items="${list}" var="ob">
<tr>
<td><c:out value="${ob[0]}"></c:out></td>
<td><c:out value="${ob[1]}"></c:out></td>
<td>
<a href="download?docid=${ob[0]}">
   <img src="../resources/images/filedownload.png" height="20" width="20">
</a>
</td>
</tr>
</c:forEach>
</table>

${message}
</body>
</html>