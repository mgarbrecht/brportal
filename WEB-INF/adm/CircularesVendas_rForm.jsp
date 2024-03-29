<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Circulares Beira Rio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(64)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Circulares_vendas" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Circulares_vendas=0;
              {
                portalbr.dbobj.view.Jw_circulares t_circulares_vendas = new portalbr.dbobj.view.Jw_circulares();
                java.util.Vector res_Circulares_vendas = (java.util.Vector)session.getAttribute("res_Circulares_vendas");
                if (res_Circulares_vendas!=null && res_Circulares_vendas.size()>0) {
                  java.lang.String numero       =  null;
                  java.sql.Timestamp datas      =  null;
                  java.lang.String remetente    =  null;
                  java.lang.String destinatario =  null;
                  java.lang.String assunto      =  null;
                  int i_bl_report_Circulares_vendas = 0;

                  t_circulares_vendas = (portalbr.dbobj.view.Jw_circulares)res_Circulares_vendas.elementAt(i_bl_report_Circulares_vendas);
                  numero       = t_circulares_vendas.getNumero()==null?"":t_circulares_vendas.getNumero();
                  datas        = (java.sql.Timestamp)t_circulares_vendas.getData();
                  remetente    = t_circulares_vendas.getRemetente()==null?"":t_circulares_vendas.getRemetente();
                  destinatario = t_circulares_vendas.getDest();
                  assunto      = t_circulares_vendas.getAssunto()==null?"":t_circulares_vendas.getAssunto();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      N�mero
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Remetente
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Destinat�rio
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Assunto
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Excluir
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Circulares_vendas<res_Circulares_vendas.size()){
                    counterbl_report_Circulares_vendas++;
                    String style="";
                    if (!((i_bl_report_Circulares_vendas%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Circulares_vendas<%=counterbl_report_Circulares_vendas%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <a href="../adm/CircularesVendas_dForm.do?select_action=&numero=<%= numero %>" target="_self" STYLE="cursor:hand">
                          <%= numero %>
                        </a>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(datas, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= remetente %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= destinatario %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= assunto %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">

                        <a onclick="if(!(confirm('Confirma Exclus�o?'))){return false;}"  href="../adm/CircularesVendas_rForm.do?update_action=&numero=<%= numero %>&pos=<%=i_bl_report_Circulares_vendas %>" target=_self STYLE=cursor:hand>
                          <img border=0 src="../img/delete.jpg" name="imagem" onmouseover="this.src='../img/delete_s.jpg'" onmouseout="this.src='../img/delete.jpg'">
                        </a>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Circulares_vendas >= res_Circulares_vendas.size()) {
                      break;
                    }
                    t_circulares_vendas = (portalbr.dbobj.view.Jw_circulares)res_Circulares_vendas.elementAt(i_bl_report_Circulares_vendas);
                    numero       = t_circulares_vendas.getNumero()==null?"":t_circulares_vendas.getNumero();
                    datas        = (java.sql.Timestamp)t_circulares_vendas.getData();
                    remetente    = t_circulares_vendas.getRemetente()==null?"":t_circulares_vendas.getRemetente();
                    destinatario = t_circulares_vendas.getDest();
                    assunto      = t_circulares_vendas.getAssunto()==null?"":t_circulares_vendas.getAssunto();

                  }
                }
              }
              %>
            </table>
            <html:form action="adm/CircularesVendas_rForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="numero"/>
                <html:hidden property="pos"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit styleClass="myhidden" property="update_action">
                        <bean:message bundle="ApplicationResources" key="jsp.update"/>
                      </html:submit>
                      <html:submit styleClass="baseButton" property="back_action">
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
