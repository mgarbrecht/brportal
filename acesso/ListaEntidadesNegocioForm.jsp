<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Entidades de Negócio
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            int counterbl_report_Entidades_negocio=0;
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              portalbr.dbobj.view.Jw_ent_neg_usuarios t_entidades_negocio = new portalbr.dbobj.view.Jw_ent_neg_usuarios();
              java.util.Vector res_Entidades_negocio = (java.util.Vector)session.getAttribute("res_Entidades_negocio");
              if (res_Entidades_negocio!=null && res_Entidades_negocio.size()>0) {
                java.lang.Integer enne_id =  null;
                java.lang.String enne_descricao =  null;
                java.lang.Integer enne_tien_id =  null;
                java.lang.String tien_tipo =  null;
                java.lang.String enne_chave =  null;
                java.lang.String total =  "";
                int i_bl_report_Entidades_negocio = 0;
                t_entidades_negocio = (portalbr.dbobj.view.Jw_ent_neg_usuarios)res_Entidades_negocio.elementAt(i_bl_report_Entidades_negocio);
                enne_id = t_entidades_negocio.getEnne_id();
                enne_descricao = t_entidades_negocio.getEnne_descricao()==null?"":t_entidades_negocio.getEnne_descricao();
                enne_tien_id = t_entidades_negocio.getEnne_tien_id();
                total = t_entidades_negocio.getUsuarios()==null?"":t_entidades_negocio.getUsuarios();
                enne_chave = t_entidades_negocio.getEnne_chave()==null?"":t_entidades_negocio.getEnne_chave();
                tien_tipo = "";
                {
                  if(enne_tien_id!=null) {
                    portalbr.dbobj.table.Tipos_entidade_negocio cr_db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
                    Object[][] where = {
                    {"tien_id","=",enne_tien_id}
                    };
                    java.util.Vector results = j.select(cr_db_object, where, null);
                    if (results!=null && results.size()>0) {
                      cr_db_object = (portalbr.dbobj.table.Tipos_entidade_negocio)results.elementAt(0);
                      tien_tipo = ((cr_db_object.getTien_tipo()!=null)?cr_db_object.getTien_tipo()+"":"");
                    }
                  }
                  };

                  java.lang.String b0_tien_tipo =  null;
                  while (i_bl_report_Entidades_negocio<res_Entidades_negocio.size()){
                    counterbl_report_Entidades_negocio++;
                    %>
                    <table id="TRbl_report_Entidades_negocio" class="reportTable" style=width:99%;  border=1  frame=box>
                      <tr class="reportHeader2" >
                        <td colspan=3>
                          <big>
                            Tipo :
                            <%= tien_tipo %>
                          </big>
                        </td>
                      </tr>
                      <%
                      b0_tien_tipo = tien_tipo;
                      %>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;" width="80%">
                          Descrição
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="10%">
                          Chave
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="10%">
                          Total
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Entidades_negocio<res_Entidades_negocio.size() &&  (b0_tien_tipo==null?"":b0_tien_tipo).equals((tien_tipo==null?"":tien_tipo))){
                        counterbl_report_Entidades_negocio++;
                        String style="";
                        if (!((i_bl_report_Entidades_negocio%2)!=0)) {
                          style="rowColor";
                        } else {
                          style="rowBlank";
                        }
                        %>
                        <tr class=<%= style %> id='TRbl_report_Entidades_negocio<%=counterbl_report_Entidades_negocio%>' >
                          <td class="reportColumn" style="text-align:left;" width="80%">
                            <%= enne_descricao %>
                          </td>
                          <td class="reportColumn" style="text-align:center;" width="10%">
                            <%= enne_chave %>
                          </td>
                          <td class="reportColumn" style="text-align:center;" width="10%">
                            <%
                            if(!total.equals("")){
                              %>
                              <a href="../acesso/ListaUsuariosEntidadesForm.do?select_action=&enne_id=<%= enne_id %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                <%= total %>
                              </a>
                              <%
                            } else {
                              %>
                              <font color="gray">
                                0
                              </font>
                              <%
                            }
                            %>

                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Entidades_negocio >= res_Entidades_negocio.size()) {
                          break;
                        }
                        t_entidades_negocio = (portalbr.dbobj.view.Jw_ent_neg_usuarios)res_Entidades_negocio.elementAt(i_bl_report_Entidades_negocio);
                        enne_id = t_entidades_negocio.getEnne_id();
                        enne_descricao = t_entidades_negocio.getEnne_descricao()==null?"":t_entidades_negocio.getEnne_descricao();
                        enne_tien_id = t_entidades_negocio.getEnne_tien_id();
                        enne_chave = t_entidades_negocio.getEnne_chave()==null?"":t_entidades_negocio.getEnne_chave();
                        total = t_entidades_negocio.getUsuarios()==null?"":t_entidades_negocio.getUsuarios();
                        tien_tipo = "";
                        {
                          if(enne_tien_id!=null) {
                            portalbr.dbobj.table.Tipos_entidade_negocio cr_db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
                            Object[][] where = {
                            {"tien_id","=",enne_tien_id}
                            };
                            java.util.Vector results = j.select(cr_db_object, where, null);
                            if (results!=null && results.size()>0) {
                              cr_db_object = (portalbr.dbobj.table.Tipos_entidade_negocio)results.elementAt(0);
                              tien_tipo = ((cr_db_object.getTien_tipo()!=null)?cr_db_object.getTien_tipo()+"":"");
                            }
                          }
                          };
                        }
                        %>
                      </table>
                      <br>
                      <%
                    }
                  }
                } catch (Exception e) {
                } finally {
                  if(j!=null) {
                    j.close();
                    j = null;
                  }
                }
                %>
              </table>
              <html:form action="acesso/ListaEntidadesNegocioForm.do" method="post" styleClass="baseForm">
                <table class="buttonTable" style='width:;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                      <html:button value="Gerar Usuários" onclick="if(confirm('Confirma essa Operação?')){this.disabled=true;gerar_usuarios_action.click();}" styleClass="baseButton" property="gerar_action">
                      </html:button>
                      <html:submit value="Gerar Usuários" styleClass="myhidden" property="gerar_usuarios_action">
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
