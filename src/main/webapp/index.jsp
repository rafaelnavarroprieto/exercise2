<%@ page import="java.util.List, java.util.ArrayList, java.lang.String" %>
<html>
    <body>
        <h2>Hello World!</h2>
        <a href="./home">Home</a>

        <%! List<String> strings = new ArrayList<String>(); %>
        <%
            strings.add("netflix");
            strings.add("hbo");
            strings.add("canal+");
            strings.add("Otras.....");
        %>
        <ul>
            <% for (String string: strings) { %>
                <li><%= string %></li>
            <% } %>
        </ul>
    </body>
</html>
