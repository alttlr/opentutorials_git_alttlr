package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TodayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime today = LocalDateTime.now();
		String format = DateTimeFormatter.ofPattern("yyyy/M/dd hh:mm").format(today);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"EUC-KR\">");
		out.println("<title>몇시에요</title>");
		out.println("<link rel = \"stylesheet\" href = \"/introduce/css/today.css\" type = \"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<a href=\"/introduce/index.html\">메인화면</a>");
		out.println("<div class = \"full\">");
		out.println("<h1 class = \"center\">현재시간 : "+format+"</h1>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
