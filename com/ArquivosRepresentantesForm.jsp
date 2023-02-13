<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Arquivos de Representantes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(143)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            int counterbl_report_Links_dinamicos=0;
            com.egen.util.jdbc.JdbcUtil j = null;
            java.util.Vector res_Links_dinamicos = null;
            //portalbr.com.AgendaVisitasActionForm AgendaVisitasActionForm = (portalbr.com.AgendaVisitasActionForm)session.getAttribute("AgendaVisitasActionForm");
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();

              String codigo_representante= "null";
              String tipo="";
              acesso.Usuario u = new acesso.Usuario();
              u = (acesso.Usuario)session.getAttribute("User");
              acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
              acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

              if(!(u.getEntidadeNegocio()==null)){
                ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                tipo = tipoent.getTipo()+"";
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  codigo_representante = "'"+ent.getChave()+"'";
                }

              }


              StringBuilder sb = new StringBuilder();
              sb.append(" SELECT lidi_id ");
              sb.append("      , lidi_titulo ");
              sb.append("      , lidi_descricao ");
              sb.append("      , lidi_caminho ");
              sb.append("      , lidi_marca ");
              sb.append("      , lidi_tipo ");
              sb.append("   FROM links_dinamicos ");
              sb.append("  WHERE lidi_tipo = 'R' ");
              sb.append("    AND lidi_marca in (SELECT DISTINCT ");
              sb.append("                              marca_produto ");
              sb.append("                         FROM representante_marca rm ");
              sb.append("                        WHERE rm.situacao = 'A' ");
              sb.append("                          AND codigo_representante = nvl(").append(codigo_representante).append(",codigo_representante) ) ");
              sb.append("  ORDER BY lidi_marca ");
              sb.append("         , lidi_titulo ");

              res_Links_dinamicos = j.select(t_links_dinamicos,
              sb.toString(),
              null);




              if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                java.lang.String lidi_titulo     =  null;
                java.lang.String lidi_descricao  =  null;
                java.lang.String lidi_caminho    =  null;
                java.lang.String descricao_marca =  null;
                int lidi_id                      =  0;
                int lidi_marca                   =  0;
                int i_bl_report_Links_dinamicos  =  0;
                t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                lidi_id        = t_links_dinamicos.getLidi_id();
                lidi_titulo    = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                lidi_caminho   = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                lidi_marca     = t_links_dinamicos.getLidi_marca();
                descricao_marca = "";
                {
                  portalbr.dbobj.table.Marcas_produtos cr_db_object = new portalbr.dbobj.table.Marcas_produtos();
                  Object[][] where = {
                  {"codigo_marca","=",new Integer(lidi_marca)}
                  };
                  java.util.Vector results = j.select(cr_db_object, where, null);
                  if (results!=null && results.size()>0) {
                    cr_db_object = (portalbr.dbobj.table.Marcas_produtos)results.elementAt(0);
                    descricao_marca = cr_db_object.getDescricao_marca() + "";
                  }
                  };
                  int b0_lidi_marca =  0;
                  while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()){
                    counterbl_report_Links_dinamicos++;
                    %>
                    <div align="center">
                      <table id="TRbl_report_Links_dinamicos" class="reportTable" style=width:50%;  border=1  frame=box>
                        <tr class="reportHeader2" >
                          <td colspan=1>
                            <big>
                              <bean:message bundle="ComercialResources" key="NormasVenda_c.marca"/>
                              <%= lidi_marca %>
                              -
                              <%= descricao_marca %>
                            </big>
                          </td>
                        </tr>
                        <%
                        b0_lidi_marca = lidi_marca;
                        %>
                        <tr class="reportHeader" >
                          <td class="columnTdHeader" style="text-align:left;">
                            <bean:message bundle="ComercialResources" key="NormasVenda_c.titulo_desc"/>
                          </td>
                        </tr>
                        <%
                        while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size() &&  b0_lidi_marca==lidi_marca){
                          counterbl_report_Links_dinamicos++;
                          String style="";
                          if (!((i_bl_report_Links_dinamicos%2)!=0)) {
                            style="rowColor";
                          } else {
                            style="rowBlank";
                          }
                          %>
                          <tr class=<%= style %> id='TRbl_report_Links_dinamicos<%=counterbl_report_Links_dinamicos%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <a href="..<%= lidi_caminho %>" target="_blank" STYLE="cursor:hand">
                                <%= lidi_titulo %>
                              </a>
                            </td>
                          </tr>
                          <%
                          if (++i_bl_report_Links_dinamicos >= res_Links_dinamicos.size()) {
                            break;
                          }
                          t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                          lidi_id         = t_links_dinamicos.getLidi_id();
                          lidi_titulo     = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                          lidi_descricao  = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                          lidi_caminho    = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                          lidi_marca      = t_links_dinamicos.getLidi_marca();
                          descricao_marca = "";
                          {
                            portalbr.dbobj.table.Marcas_produtos cr_db_object = new portalbr.dbobj.table.Marcas_produtos();
                            Object[][] where = {
                            {"codigo_marca","=",new Integer(lidi_marca)}
                            };
                            java.util.Vector results = j.select(cr_db_object, where, null);
                            if (results!=null && results.size()>0) {
                              cr_db_object = (portalbr.dbobj.table.Marcas_produtos)results.elementAt(0);
                              descricao_marca = cr_db_object.getDescricao_marca() + "";
                            }
                            };
                          }
                        }
                      }
                    } catch (Exception e) {
                      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    } finally {
                      if(j!=null){
                        j.close();
                        j=null;
                      }
                    }
                    %>
                  </table>
                </div>
                <html:form action="com/ArquivosRepresentantesForm.do" method="post" styleClass="baseForm">
                  <table class="itemTable"  style=" width:;">
                    <html:hidden property="lidi_marca"/>
                  </html:form>
                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>
