<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Baixa de Arquivos AFV
    </title>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="com/BaixaArquivosAFVForm.do" method="POST" styleClass="baseForm">
              <table class="bannerTable" style='width:99%;'>
                <tr>
                  <td class=tableHeader>
                  </td>
                </tr>
                <%
                util.consultas.Parametros parametros = new util.consultas.Parametros();
                String codigo_regional="";
                String carga="";
                String tipo="";
                String arquivo="";
                String programa="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    carga = parametros.retornaParametro("link_arquivos_afv") +"BeiraRio."+ent.getChave()+".zip";
                    arquivo = parametros.retornaParametro("diretorio_arquivos_afv") + "BeiraRio."+ent.getChave()+".zip";
                  }
                }
                programa = parametros.retornaParametro("diretorio_arquivos_afv") + "instalaafv_xp.exe";
                %>
              </table>
              <table class="itemTable" style='width:99%;'>

                <%
                if(!user.isSuperUsuario() && !user.isAutorizado(130)){
                  response.sendRedirect("../system/Error.jsp");
                }
                %>


              </table>
              <div align="center">
                <table class="separatorTable" style='width:50%;'  >
                  <tr class="separatorTr">
                    <td colspan="2" class="separatorTd" align="center">
                      <b>
                        <big>
                          Arquivos Disponíveis
                        </big>
                        <b>
                        </td>
                      </tr>
                      <%
                      java.io.File arq = new java.io.File(arquivo);
                      if(arq.isFile()) {
                        %>
                        <tr>
                          <td class="formField" width="1%";>
                            <a href="<%= carga %>" target="_blank">
                              <img border=0 src="../img/180.jpg" onmouseover = "this.src='../img/180_s.jpg'" onmouseout = "this.src='../img/180.jpg'" />
                            </a>
                          </td>
                          <td>
                            Carga Completa AFV
                          </td>
                        </tr>
                        <%
                      }
                      %>
                      <%
                      java.io.File arq2 = new java.io.File(programa);
                      if(arq2.isFile()) {
                        %>
                        <tr>
                          <td class="formField" width="1%";>
                            <%
                            String link_programa = parametros.retornaParametro("link_arquivos_afv") + "instalaafv_xp.exe";
                            %>
                            <a href="<%= link_programa %>" target="_blank">
                              <img border=0 src="../img/180.jpg" onmouseover = "this.src='../img/180_s.jpg'" onmouseout = "this.src='../img/180.jpg'" />
                            </a>
                          </td>
                          <td>
                            Última Versão do Programa AFV
                          </td>
                        </tr>
                        <%
                      }
                      %>
                    </table>
                    <table class="itemTable" style='width:100%;'>
                    </table>
                  </div>

                </html:form>
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>
