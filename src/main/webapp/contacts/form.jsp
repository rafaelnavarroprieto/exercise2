<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="edu.java.intermediate.exercise2.models.Contact" %>
<html>
    <body>
        <h2>Contactos</h2>
        <a href='#'>Regresar</a>
        <form action='../contacts/save' method='post'>
        <table>
            <tr>
                <td>NOMBRE</td>
                <td><input type='text' name='firstName' value='<c:out value="${contact.firstName}"/>'/></td>
                <td>APELLIDO</td>
                <td><input type='text' name='lastName' value='<c:out value="${contact.lastName}"/>'/></td>
                <td>EMAIL</td>
                <td><input type='text' name='email' value='<c:out value="${contact.email}"/>'/></td>
            </tr>
        </table>
        <input type="hidden" value="<c:out value="${contact.id}"/>" name="id" />
        <input type='submit' value="<c:out value="${contact == null ? 'crear' : 'actualizar'}"/>" />
        </form>
    </body>
</html>