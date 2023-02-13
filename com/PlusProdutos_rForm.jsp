<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      PLUS Produtos - Dados do Produto
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
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_linha" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_linha=0;
              {
                portalbr.dbobj.view.Jw_linha t_jw_linha = new portalbr.dbobj.view.Jw_linha();
                java.util.Vector res_Jw_linha = (java.util.Vector)session.getAttribute("res_Jw_linha");
                if (res_Jw_linha!=null && res_Jw_linha.size()>0) {
                  java.lang.String lin_cdgo =  null;
                  java.lang.String lin_nome =  null;
                  java.lang.String status =  null;
                  java.lang.String cod_filial =  null;
                  int i_bl_report_Jw_linha = 0;
                  t_jw_linha = (portalbr.dbobj.view.Jw_linha)res_Jw_linha.elementAt(i_bl_report_Jw_linha);
                  lin_cdgo = t_jw_linha.getLin_cdgo()==null?"":t_jw_linha.getLin_cdgo();
                  lin_nome = t_jw_linha.getLin_nome()==null?"":t_jw_linha.getLin_nome();
                  status = t_jw_linha.getStatus()==null?"":t_jw_linha.getStatus();
                  cod_filial = t_jw_linha.getCod_filial()==null?"":t_jw_linha.getCod_filial();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Linha
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Descrição
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Status
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Filial
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_linha<res_Jw_linha.size()){
                    counterbl_report_Jw_linha++;
                    String style="";
                    if (!((i_bl_report_Jw_linha%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_linha<%=counterbl_report_Jw_linha%>'>
                      <td class="reportColumn" style="text-align:left;">
                        <a href="../com/PlusProdutos_refForm.do?select_action=&lin_cdgo=<%= lin_cdgo %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                          <%= lin_cdgo %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= lin_nome %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= status %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cod_filial %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_linha >= res_Jw_linha.size()) {
                      break;
                    }
                    t_jw_linha = (portalbr.dbobj.view.Jw_linha)res_Jw_linha.elementAt(i_bl_report_Jw_linha);
                    lin_cdgo = t_jw_linha.getLin_cdgo()==null?"":t_jw_linha.getLin_cdgo();
                    lin_nome = t_jw_linha.getLin_nome()==null?"":t_jw_linha.getLin_nome();
                    status = t_jw_linha.getStatus()==null?"":t_jw_linha.getStatus();
                    cod_filial = t_jw_linha.getCod_filial()==null?"":t_jw_linha.getCod_filial();
                  }
                }
              }
              %>
            </table>
            <html:form action="com/PlusProdutos_rForm.do" method="post" styleClass="baseForm">
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
