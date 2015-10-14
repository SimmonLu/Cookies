package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by simon on 10/13/15.
 */
@WebServlet(name = "Cookies")
public class Cookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("<html>");

        Cookie[] cookies = request.getCookies();


        if (cookies == null) {
            out.println("No cookies found <br/>");
        } else {

            for (Cookie retrievedCookie : cookies) {
                String name = retrievedCookie.getName();
                String value = retrievedCookie.getValue();

                out.println(name + " = " + value + "<br/>");
            }
        }

        Cookie cookie = new Cookie("user", "Vicky");

        cookie.setMaxAge(300);
        response.addCookie(cookie);

        out.println("Cookie set.<br/>");
        out.println("</html>");

    }
}
