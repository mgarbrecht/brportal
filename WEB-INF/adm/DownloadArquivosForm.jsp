<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Download de Arquivos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(21)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              acesso.Sessao sessao = new acesso.Sessao(session);
              String tipoEntidadeNegocio = "";
              String entNegocio = "";
              if((sessao.getTipoEntidadeNegocioId()!=null && sessao.getTipoEntidadeNegocioId()==2047)){
                entNegocio = sessao.getEntidadeNegocioId()+"";
              }
              if((sessao.getTipoEntidadeNegocioId()!=null && sessao.getTipoEntidadeNegocioId()!=2047)){
                tipoEntidadeNegocio = sessao.getTipoEntidadeNegocioId()+"";
              }
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                java.util.Vector res_Links_dinamicos = null;
                try {
                  portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                  String[][] select = null;
                  Object[][] where = null;
                where = new Object[][]{{"lidi_tien_id","=", tipoEntidadeNegocio}, {"lidi_enne_id","=", entNegocio },{"lidi_marca","=","0"}}
                ;
                String[] groupby =  null;
                String[] having =  null;
                String[] order = {"lidi_tien_id"};
                res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              }
              %>

              <form  name="bl_report_Links_dinamicos" id="bl_report_Links_dinamicos" class="baseForm" method="post" >
                <%
                if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                  %>

                  <table id="TRbl_report_Links_dinamicos"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.String free =  null;
                    java.lang.Integer lidi_tien_id =  null;
                    java.lang.Integer lidi_enne_id =  null;
                    java.lang.String tien_tipo =  null;

                    int lidi_id =  0;
                    java.lang.String lidi_titulo =  null;
                    java.lang.String lidi_descricao =  null;
                    java.lang.String lidi_caminho =  null;
                    String _b0_control = "__";
                    int i_bl_report_Links_dinamicos = 0;
                    while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                      portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                      lidi_tien_id = t_links_dinamicos.getLidi_tien_id();
                      lidi_enne_id = t_links_dinamicos.getLidi_enne_id();
                      lidi_id = t_links_dinamicos.getLidi_id();
                      lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                      lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                      lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                      tien_tipo = "";
                      {
                        if(lidi_tien_id!=null) {

                          Tipos_entidade_negocio cr_db_object = new Tipos_entidade_negocio();
                          String[][] select = null;
                          Object[][] where = {{"tien_id","=",lidi_tien_id}};
                          java.util.Vector results = j.select(cr_db_object, select, where, null, null, null);
                          if (results!=null && results.size()>0) {
                            cr_db_object = (Tipos_entidade_negocio)results.elementAt(0);
                            tien_tipo = ((cr_db_object.getTien_tipo()!=null)?cr_db_object.getTien_tipo()+"":"");
                          }
                        }
                        };
                        {
                          if(lidi_enne_id!=null) {

                            Entidades_negocio cr_db_object2 = new Entidades_negocio();
                            String[][] select2 = null;
                            Object[][] where2 = {{"enne_id","=",lidi_enne_id}};
                            java.util.Vector results2 = j.select(cr_db_object2, select2, where2, null, null, null);
                            if (results2!=null && results2.size()>0) {
                              cr_db_object2 = (Entidades_negocio)results2.elementAt(0);
                              tien_tipo = ((cr_db_object2.getEnne_descricao()!=null)?cr_db_object2.getEnne_descricao()+"":"");
                            }
                          }
                          };
                          String _b0_value = com.egen.util.text.FormatNumber.format(lidi_tien_id);
                          if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                            %>
                            <tr class="reportHeader2">
                              <td colspan="4">
                                Tipo Usuário :
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
                              <a href="../arquivos/manuais/<%= lidi_caminho %>" >
                                <%= lidi_caminho %>
                              </a>
                            </td>

                          </tr>

                          <%
                          _b0_control = _b0_value;
                          i_bl_report_Links_dinamicos++;
                          if (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                            t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                            lidi_tien_id = t_links_dinamicos.getLidi_tien_id();
                            lidi_enne_id = t_links_dinamicos.getLidi_enne_id();
                            lidi_id = t_links_dinamicos.getLidi_id();
                            lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                            lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                            lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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
            </td>
          </tr>
        </table>

      </body>
    </center>
  </html>
