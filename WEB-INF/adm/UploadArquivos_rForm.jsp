<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Manuais e Procedimentos
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(20)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                %>
                <%
                java.util.Vector res_Links_dinamicos = (java.util.Vector)session.getAttribute("res_Links_dinamicos");
                %>

                <form  name="bl_report_Links_dinamicos" id="bl_report_Links_dinamicos" class="baseForm" method="post" >
                  <%
                  if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                    %>

                    <table id="TRbl_report_Links_dinamicos"  class="reportTable"   style="width:99%; "  border="1" >
                      <%
                      java.lang.Integer lidi_tien_id =  null;
                      java.lang.String tien_tipo =  null;
                      int lidi_id =  0;
                      java.lang.String lidi_titulo =  null;
                      java.lang.String lidi_descricao =  null;
                      java.lang.String lidi_caminho =  null;
                      java.lang.Integer lidi_marca =  null;
                      java.lang.String lidi_tipo =  null;
                      java.lang.String excluir =  null;
                      String _b0_control = "__";
                      int i_bl_report_Links_dinamicos = 0;
                      while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                        portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                        lidi_tien_id = t_links_dinamicos.getLidi_tien_id();
                        lidi_id = t_links_dinamicos.getLidi_id();
                        lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                        lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                        lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                        lidi_marca = t_links_dinamicos.getLidi_marca();
                        lidi_tipo = t_links_dinamicos.getLidi_tipo()==null?"":t_links_dinamicos.getLidi_tipo();
                        tien_tipo = "";
                        {
                          if(lidi_tien_id!=null) {
                            Tipos_entidade_negocio cr_db_object = new Tipos_entidade_negocio();
                            String[][] select = null;
                            Object[][] where = {
                            {"tien_id","=",lidi_tien_id}
                            };
                            String[] group = null;
                            String[] having = null;
                            String[] order = null;
                            java.util.Vector results = j.select(cr_db_object, select, where, group, having, order);
                            if (results!=null && results.size()>0) {
                              cr_db_object = (Tipos_entidade_negocio)results.elementAt(0);
                              tien_tipo = ((cr_db_object.getTien_tipo()!=null)?cr_db_object.getTien_tipo()+"":"");
                            }
                          }
                          };
                          String _b0_value = com.egen.util.text.FormatNumber.format(lidi_tien_id);
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="7">
                                Tipo de Usuário :
                                <%= ((lidi_tien_id!=null)?lidi_tien_id.toString():"") %>
                                -
                                <%= tien_tipo %>
                              </td>
                            </tr>
                            <%
                            %>

                            <tr class="reportTr">

                              <td class="columnTdHeader" style="text-align:right;" >
                                ID
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Título
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Descrição
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                                Arquivo
                              </td>

                              <td class="columnTdHeader" style="text-align:left;" >
                              </td>

                            </tr>

                            <%
                          }
                          String style_bl_report_Links_dinamicos="";
                          if (!((i_bl_report_Links_dinamicos%2)!=0)) {
                            style_bl_report_Links_dinamicos="rowColor";
                          } else {
                            style_bl_report_Links_dinamicos="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Links_dinamicos %>' id="TRbl_report_Links_dinamicos<%=i_bl_report_Links_dinamicos%>" >
                            <td class="reportColumn" style="text-align:right;" >
                              <%= lidi_id %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= lidi_titulo %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= lidi_descricao %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <%= lidi_caminho %>
                            </td>

                            <td class="reportColumn" style="font-size:10;text-align:center;">
                              <a onclick="if(!(confirm('Confirma Exclusão?'))){return false;}"  href="../adm/UploadArquivos_rForm.do?delete_action=&pos=<%=i_bl_report_Links_dinamicos %>&lidi_id=<%= lidi_id %>&lidi_caminho=<%= lidi_caminho %>" target=_self STYLE=cursor:hand>
                                <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                              </a>
                            </td>
                          </tr>

                          <%
                          _b0_control = _b0_value;
                          i_bl_report_Links_dinamicos++;
                          if (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                            t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                            lidi_tien_id = t_links_dinamicos.getLidi_tien_id();
                            lidi_id = t_links_dinamicos.getLidi_id();
                            lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                            lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                            lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                            lidi_marca = t_links_dinamicos.getLidi_marca();
                            lidi_tipo = t_links_dinamicos.getLidi_tipo()==null?"":t_links_dinamicos.getLidi_tipo();
                            tien_tipo = "";
                            {
                              if(lidi_tien_id!=null) {
                                Tipos_entidade_negocio cr_db_object = new Tipos_entidade_negocio();
                                String[][] select = null;
                                Object[][] where = {
                                {"tien_id","=",lidi_tien_id}
                                };
                                String[] group = null;
                                String[] having = null;
                                String[] order = null;
                                java.util.Vector results = j.select(cr_db_object, select, where, group, having, order);
                                if (results!=null && results.size()>0) {
                                  cr_db_object = (Tipos_entidade_negocio)results.elementAt(0);
                                  tien_tipo = ((cr_db_object.getTien_tipo()!=null)?cr_db_object.getTien_tipo()+"":"");
                                }
                              }
                              };
                              _b0_value = com.egen.util.text.FormatNumber.format(lidi_tien_id);
                            } else {
                              _b0_control = "__";
                            }
                          }
                          %>

                        </table>

                        <%
                      }
                      %>

                    </form>
                    <%
                  } catch (Exception e) {
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    %>
                    <jsp:forward page="/system/ErrorPage.jsp"/>
                    <%
                  } finally {
                  if(j!=null){j.close(); }
                }
                %>
                <%
              }
              %>

              <html:form action="adm/UploadArquivos_rForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                    </td>
                  </tr>
                </table>

                <table class="itemTable"  style="width:99%;">
                  <html:hidden property="pos"/>
                  <html:hidden property="lidi_caminho"/>
                  <html:hidden property="lidi_id"/>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                      <html:submit accesskey="p" value="Position" styleClass="myhidden" property="pos_action">
                      </html:submit>
                      <html:submit styleClass="myhidden" property="delete_action">
                        <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>

              </html:form>
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>
