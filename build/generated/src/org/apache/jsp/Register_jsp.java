package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/includes/header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\t<meta name=\"viewport\" content=\"witdth=device-width, initial-scale=1.0\">\n");
      out.write("\t<title></title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/9ee78b02b3.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<header class=\"header\">\n");
      out.write("\t\n");
      out.write("\t<div class=\"head2\">\n");
      out.write("\t\t<div class=\"signupAndResgister\">\n");
      out.write("\t\t\t<nav class=\"navbar\">\n");
      out.write("\t\t\t\t<a href=\"#\">Login</a>\n");
      out.write("                <a href=\"#\">Register</a>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"head2\">\n");
      out.write("\t\t\n");
      out.write("\t<nav class=\"navbar\">\n");
      out.write("        <a href=\"#home\">home</a>\n");
      out.write("        <a href=\"#\">services</a>\n");
      out.write("        <a href=\"#\">about</a>\n");
      out.write("        <a href=\"#\">Doctors</a>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("</header>");
      out.write("\n");
      out.write("<section class=\"book\" id=\"book\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"row\">\n");
      out.write("\n");
      out.write("        <div class=\"image\">\n");
      out.write("            <img src=\"images/book-img.svg\" alt=\"\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <form action=\"RegisterServlet\" method=\"POST\">\n");
      out.write("            <h1 class=\"heading\"> Register </h1>  \n");
      out.write("            <div class=\"responsive\">\n");
      out.write("                <label>Full Name:</label> <span><input type=\"text\" name=\"fullName\" required class=\"box\"/></span>\n");
      out.write("                <label>Age:</label><span><input type=\"text\" name=\"age\" required class=\"box\" /></span>\n");
      out.write("                <label>Birthday:</label><span><input  type=\"text\" name=\"dob\" required  class=\"box\"/></span>\n");
      out.write("                <label>Address:</label><span><input type=\"text\" name=\"address\" required class=\"box\"/></span>\n");
      out.write("                <label>Phone number:</label><span><input type=\"text\" name=\"tel\" pattern=\"0[0-9]{3} [0-9]{6}\" required class=\"box\"/></span>\n");
      out.write("                <label>Email:</label><span><input type=\"text\" name=\"email\" required class=\"box\"/></span>\n");
      out.write("                <label>Identity number:</label><span><input type=\"text\" name=\"cccd\" required class=\"box\"/></span>\n");
      out.write("                <label>Career:</label><span><input type=\"text\" name=\"career\" required class=\"box\"/></span>\n");
      out.write("                <label>Health insurance number:</label><span><input type=\"text\" name=\"bhyt\" required class=\"box\"/></span>\n");
      out.write("                <label>Gender:</label>\n");
      out.write("                <label>Male</label><span><input type=\"radio\" name=\"gender\" value=\"male\" id=\"male\" class=\"box\"></span>\n");
      out.write("                <label>Female</label><span><input type=\"radio\" name=\"gender\" value=\"female\" id=\"female\" class=\"box\"></span>     \n");
      out.write("                <label>Password:</label><span><input type=\"password\" name=\"password\" required class=\"box\"/></span>\n");
      out.write("                <label>Confirm password:</label><span><input type=\"repassword\" name=\"repassword\" required class=\"box\"/></span>\n");
      out.write("                <input type=\"submit\" value=\"Register\" class=\"btn\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</section>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
