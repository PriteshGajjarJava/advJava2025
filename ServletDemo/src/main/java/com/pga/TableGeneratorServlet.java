package com.pga;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/generateTable")
public class TableGeneratorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int n = Integer.parseInt(request.getParameter("num")); // 9
		out.write("<Table border='1'>");
		for (int i=1; i<=10; i++) {
			out.write("<TR><TD>" + (n*i) + "</TD></TR>");
		}
		out.write("</Table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
