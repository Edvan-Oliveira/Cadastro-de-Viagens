/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.94
 * Generated at: 2019-11-29 06:33:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.passageiro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.atc.jdbc.modelo.Passageiro;
import br.com.atc.jdbc.dao.PassageiroDao;

public final class editar_002dpassageiro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String textId = request.getParameter("id");
	Integer id = Integer.parseInt(textId);
	
	PassageiroDao dao = new PassageiroDao();
	Passageiro passageiro = new PassageiroDao().pesquisa(id);
	

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Atualizar Passageiro</title>\r\n");
      out.write("<link href=\"../css/estilo.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div id=\"marca\">\r\n");
      out.write("\t\t\t\t<img src=\"../imagens/logoCarro.png\" height=\"80px;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"menu\">\r\n");
      out.write("\t\t\t\t<a href=\"../viagem/lista-viagem.jsp\">Viagem</a>\r\n");
      out.write("\t\t\t\t<a href=\"../motorista/lista-motorista.jsp\">Motorista</a>\r\n");
      out.write("\t\t\t\t<a href=\"lista-passageiro.jsp\">Passageiro</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<h1>Editar os Dados do Passageiro</h1>\r\n");
      out.write("\t\t<form action=\"altera-passageiro.jsp\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"esquerda\">\r\n");
      out.write("\t\t\t\t<label for=\"nome\">Nome: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"nome\" id=\"nome\" value=\"");
      out.print(passageiro.getNome());
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label for=\"sobreNome\">Sobre Nome: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"sobreNome\" id=\"sobreNome\" value=\"");
      out.print(passageiro.getSobreNome());
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label for=\"telefone\">Telefone: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"telefone\" id=\"telefone\" value=\"");
      out.print(passageiro.getTelefone());
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"direita\">\r\n");
      out.write("\t\t\t\t<label for=\"email\">E-mail: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"email\" id=\"email\" value=\"");
      out.print(passageiro.getEmail());
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label for=\"cpf\">CPF: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"cpf\" id=\"cpf\" value=\"");
      out.print(passageiro.getCpf());
      out.write("\"><br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label for=\"senha\">Criar Senha: </label><br>\r\n");
      out.write("\t\t\t\t<input type=\"password\" name=\"senha\" id=\"senha\" value=\"");
      out.print(passageiro.getSenha());
      out.write("\"><br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(passageiro.getId());
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div id=\"clear\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"Atualizar\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t\tDesenvolvido Por Edvan Oliveira\r\n");
      out.write("\t</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
