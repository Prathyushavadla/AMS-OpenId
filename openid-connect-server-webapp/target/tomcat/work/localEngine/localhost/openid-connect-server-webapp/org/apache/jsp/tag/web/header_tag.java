package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.gson.Gson;

public final class header_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.lang.String title;

  public java.lang.String getTitle() {
    return this.title;
  }

  public void setTitle(java.lang.String title) {
    this.title = title;
    jspContext.setAttribute("title", title);
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  private void _jspInit(ServletConfig config) {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(config.getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) config.getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    _jspInit(config);
    jspContext.getELContext().putContext(JspContext.class,jspContext);
    if( getTitle() != null ) 
      _jspx_page_context.setAttribute("title", getTitle());

    try {
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.response.locale}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <base href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.issuer}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.topbarTitle}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${title}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("</title>\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <!-- stylesheets -->\r\n");
      out.write("    <link href=\"resources/bootstrap2/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/css/bootstrap-sheet.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/css/mitreid-connect.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/css/mitreid-connect-local.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/bootstrap2/css/bootstrap-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/css/mitreid-connect-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"resources/css/mitreid-connect-responsive-local.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"resources/js/lib/html5.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!-- favico -->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"resources/images/mitreid-connect.ico\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Load jQuery up here so that we can use in-page functions -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"resources/js/lib/jquery.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" charset=\"UTF-8\" src=\"resources/js/lib/moment-with-locales.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"resources/js/lib/i18next.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $.i18n.init({\r\n");
      out.write("            fallbackLng: \"en\",\r\n");
      out.write("            lng: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.locale}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\",\r\n");
      out.write("            resGetPath: \"resources/js/locale/__lng__/__ns__.json\",\r\n");
      out.write("            ns: {\r\n");
      out.write("            \tnamespaces: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.languageNamespacesString}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(",\r\n");
      out.write("            \tdefaultNs: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.defaultLanguageNamespace}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("'\r\n");
      out.write("            },\r\n");
      out.write("            fallbackNS: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.languageNamespacesString}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("        moment.locale(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.locale}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write("\");\r\n");
      out.write("    \t// safely set the title of the application\r\n");
      out.write("    \tfunction setPageTitle(title) {\r\n");
      out.write("    \t\tdocument.title = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.topbarTitle}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(" - \" + title;\r\n");
      out.write("    \t}\r\n");
      out.write("    \t\r\n");
      out.write("\t\t// get the info of the current user, if available (null otherwise)\r\n");
      out.write("    \tfunction getUserInfo() {\r\n");
      out.write("    \t\treturn ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userInfoJson}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(";\r\n");
      out.write("    \t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// get the authorities of the current user, if available (null otherwise)\r\n");
      out.write("\t\tfunction getUserAuthorities() {\r\n");
      out.write("\t\t\treturn ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userAuthorities}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// is the current user an admin?\r\n");
      out.write("\t\t// NOTE: this is just for  \r\n");
      out.write("\t\tfunction isAdmin() {\r\n");
      out.write("\t\t\tvar auth = getUserAuthorities();\r\n");
      out.write("\t\t\tif (auth && _.contains(auth, \"ROLE_ADMIN\")) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar heartMode = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${config.heartMode}", java.lang.String.class, (PageContext)this.getJspContext(), null, false));
      out.write(";\r\n");
      out.write("\t\t\r\n");
      out.write("    </script>    \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"wrap\">\r\n");
      out.write("\r\n");
      out.write("<!-- Start body -->");
    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      jspContext.getELContext().putContext(JspContext.class,super.getJspContext());
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
