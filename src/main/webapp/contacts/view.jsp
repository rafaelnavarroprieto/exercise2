<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="edu.java.intermediate.exercise2.models.Contact" %>
<html>
    <body>
        <h2>Contactos</h2>
        <a href='#'>Regresar</a>
        <form action='../contacts/form' method='post'>
        <table>
            <tr>
                <td>NOMBRE</td>
                <td><c:out value="${contact.firstName}"/></td>
                <td>APELLIDO</td>
                <td><c:out value="${contact.lastName}"/></td>
                <td>EMAIL</td>
                <td><c:out value="${contact.email}"/></td>
                <td>CREADO EN</td>
                <td><fmt:formatDate value="${contact.createdAt}"/></td>
                <td>MODIFICADO EN</td>
                <td><fmt:formatDate value="${contact.modifiedAt}"/></td>
            </tr>
        </table>
        <input type="hidden" value="<c:out value="${contact.id}"/>" name="id" />
        <input type='submit' value="<c:out value="${contact == null ? 'crear' : 'actualizar'}"/>" />
        </form>
    </body>
</html>