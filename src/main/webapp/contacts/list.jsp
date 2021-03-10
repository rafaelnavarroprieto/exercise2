<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List, edu.java.intermediate.exercise2.models.Contact" %>
<html>
    <body>
        <h2>Contactos</h2>
        <a href='./contacts/form'>NUEVO CONTACTO</a>
        <table>
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>APELLIDO</th>
                <th>EMAIL</th>
                <th>CREADO EN</th>
                <th>MODIFICADO EN</th>
            </tr>
            <c:forEach var='contact' items='${contacts}'>
            <tr>
                <td><a href='./contacts/view?id=<c:out value="${contact.id}" />'><c:out value='${contact.id}' /></a></td>
                <td><c:out value='${contact.firstName}'/></td>
                <td><c:out value='${contact.lastName}'/></td>
                <td><c:out value='${contact.email}'/></td>
                <td><fmt:formatDate type='date' value='${contact.createdAt}' /></td>
                <td><fmt:formatDate type='date' value='${contact.modifiedAt}' /></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>