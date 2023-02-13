<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Tipos de entidade de negócio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(48)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Tipos_entidade_negocio" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Tipos_entidade_negocio=0;
              {
                portalbr.dbobj.table.Tipos_entidade_negocio t_tipos_entidade_negocio = new portalbr.dbobj.table.Tipos_entidade_negocio();
                java.util.Vector res_Tipos_entidade_negocio = (java.util.Vector)session.getAttribute("res_Tipos_entidade_negocio");
                if (res_Tipos_entidade_negocio!=null && res_Tipos_entidade_negocio.size()>0) {
                  java.lang.Integer tien_id              =  null;
                  java.lang.String tien_tipo             =  null;
                  java.lang.String tien_tabela           =  null;
                  java.lang.String tien_campos_descr     =  null;
                  java.lang.String tien_campos_chave     =  null;
                  java.lang.String tien_condicional      =  null;
                  int tien_dias_consulta_retroativa      =  0;
                  int i_bl_report_Tipos_entidade_negocio =  0;

                  t_tipos_entidade_negocio = (portalbr.dbobj.table.Tipos_entidade_negocio)res_Tipos_entidade_negocio.elementAt(i_bl_report_Tipos_entidade_negocio);
                  tien_id           = t_tipos_entidade_negocio.getTien_id();
                  tien_tipo         = t_tipos_entidade_negocio.getTien_tipo()==null?"":t_tipos_entidade_negocio.getTien_tipo();
                  tien_tabela       = t_tipos_entidade_negocio.getTien_tabela()==null?"":t_tipos_entidade_negocio.getTien_tabela();
                  tien_campos_descr = t_tipos_entidade_negocio.getTien_campos_descr()==null?"":t_tipos_entidade_negocio.getTien_campos_descr();
                  tien_campos_chave = t_tipos_entidade_negocio.getTien_campos_chave()==null?"":t_tipos_entidade_negocio.getTien_campos_chave();
                  tien_condicional  = t_tipos_entidade_negocio.getTien_condicional()==null?"":t_tipos_entidade_negocio.getTien_condicional();
                  tien_dias_consulta_retroativa = t_tipos_entidade_negocio.getTien_dias_consulta_retroativa();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:center;">
                      ID
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Tipo
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Tabela
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Campos da Descrição
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Dias Consulta Retroativa
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Condição
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Tipos_entidade_negocio<res_Tipos_entidade_negocio.size()){
                    counterbl_report_Tipos_entidade_negocio++;
                    String style="";
                    if (!((i_bl_report_Tipos_entidade_negocio%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Tipos_entidade_negocio<%=counterbl_report_Tipos_entidade_negocio%>' >
                      <td class="reportColumn" style="text-align:center; width: 5%">
                        <%= tien_id %>
                      </td>
                      <td class="reportColumn" style="text-align:left;outline-color:yellow; width: 20%">
                        <a href="../acesso/TiposEntidadeNegocio_aForm.do?pop_action=&pos=<%=i_bl_report_Tipos_entidade_negocio %>&tien_id=<%= tien_id %>&tien_tipo=<%= tien_tipo %>&tien_tabela=<%= tien_tabela %>&tien_campos_descr=<%= tien_campos_descr %>&tien_campos_chave=<%= tien_campos_chave %>&tien_condicional=<%= tien_condicional %>&tien_dias_consulta_retroativa=<%= tien_dias_consulta_retroativa %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                          <%= tien_tipo %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:left; width: 15%">
                        <%= tien_tabela %>
                      </td>
                      <td class="reportColumn" style="text-align:left; width: 20%">
                        <%= tien_campos_descr %>
                      </td>
                      <td class="reportColumn" style="text-align:center; width: 10%">
                        <%= tien_dias_consulta_retroativa %>
                      </td>
                      <td class="reportColumn" style="text-align:left; width: 30%">
                        <%= tien_condicional %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Tipos_entidade_negocio >= res_Tipos_entidade_negocio.size()) {
                      break;
                    }
                    t_tipos_entidade_negocio = (portalbr.dbobj.table.Tipos_entidade_negocio)res_Tipos_entidade_negocio.elementAt(i_bl_report_Tipos_entidade_negocio);
                    tien_id           = t_tipos_entidade_negocio.getTien_id();
                    tien_tipo         = t_tipos_entidade_negocio.getTien_tipo()==null?"":t_tipos_entidade_negocio.getTien_tipo();
                    tien_tabela       = t_tipos_entidade_negocio.getTien_tabela()==null?"":t_tipos_entidade_negocio.getTien_tabela();
                    tien_campos_descr = t_tipos_entidade_negocio.getTien_campos_descr()==null?"":t_tipos_entidade_negocio.getTien_campos_descr();
                    tien_campos_chave = t_tipos_entidade_negocio.getTien_campos_chave()==null?"":t_tipos_entidade_negocio.getTien_campos_chave();
                    tien_condicional  = t_tipos_entidade_negocio.getTien_condicional()==null?"":t_tipos_entidade_negocio.getTien_condicional();
                    tien_dias_consulta_retroativa = t_tipos_entidade_negocio.getTien_dias_consulta_retroativa();
                  }
                }
              }
              %>
            </table>
            <html:form action="acesso/ListaTiposEntidadeNegocioForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="b" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
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
