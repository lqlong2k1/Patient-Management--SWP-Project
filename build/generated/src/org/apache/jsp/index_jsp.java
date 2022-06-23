package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t\t\t<a href=\"LoginServlet\">Login</a>\n");
      out.write("                <a href=\"RegisterServlet\">Register</a>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"head2\">\n");
      out.write("\t\t\n");
      out.write("\t<nav class=\"navbar\">\n");
      out.write("        <a href=\"#home\">home</a>\n");
      out.write("        <a href=\"/PatientMAnagement2/ViewServiceServlet?action=viewservices\">services</a>\n");
      out.write("        <a href=\"#about\">about</a>\n");
      out.write("        <a href=\"/PatientMAnagement2/ViewDoctorServlet?action=viewdoctors\">Doctors</a>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("</header>");
      out.write("\n");
      out.write("<section class=\"home\" id=\"home\">\n");
      out.write("    <div class=\"image\">\n");
      out.write("        <img src=\"images/home-img.svg\" alt=\"\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <h4 style=\"font-size: 3rem;color: #16a085\">Welcome to</h4> \n");
      out.write("        <h3>PATIENT MANAGEMENT SYSTEM</h3>\n");
      out.write("    </div>\n");
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
