<!--
<TOMCAT_Folder>/webapps/demo/table.jsp
-->

<%
    int n = Integer.parseInt(request.getParameter("num"));
%>
<html>
    <body>
        <table border="1">
            <%
                for (int i=1; i <=10; i++) {
            %>
                 <TR> <TD> <%= (n * i) %> </TD></TR>
            <%
                }
            %>
        </table>
    </body>
</html>
