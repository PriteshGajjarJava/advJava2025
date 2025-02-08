<%
 int a = Integer.parseInt(request.getParameter("num1"));
 int b = Integer.parseInt(request.getParameter("num2"));
%>
<HTML>
    <body>
        <h3> Result is <%= (a+b) %> </h3>
    </body>
</HTML>