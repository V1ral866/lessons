<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
   <title>Simple library app</title>
</head>
<body>
<form:form modelAttribute="bookAttribute" action="addBook" method="post">
   <table>
       <tr>
           <td>
               <form:label path="bookId">id</form:label>
           </td>
           <td>
               <form:input path="bookId"/>
           </td>
       </tr>
       <tr>
           <td>
               <form:label path="bookTitle">Book title</form:label>
           </td>
           <td>
               <form:input path="bookTitle"/>
           </td>
       </tr>
       <tr>
           <td>
               <form:label path="bookAuthor">Book author</form:label>
           </td>
           <td>
               <form:input path="bookAuthor"/>
           </td>
       </tr>
       <tr>
           <td>
               <form:label path="bookHolder">Book holder</form:label>
           </td>
           <td>
               <form:input path="bookHolder"/>
           </td>
       </tr>
   </table>
   <input type="submit" value="Save"/>
</form:form>
</body>
</html>