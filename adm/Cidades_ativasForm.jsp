<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cidades Ativas
      <%= (String)(request.getParameter("cab_cidade")+"").replace('*','&') %>
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
                  <%@ include file="../system/header_data.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(58)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_cid_atend_reg" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_cid_atend_reg=0;
              {
                portalbr.dbobj.view.Jw_cid_atend_reg t_jw_cid_atend_reg = new portalbr.dbobj.view.Jw_cid_atend_reg();
                java.util.Vector res_Jw_cid_atend_reg = (java.util.Vector)session.getAttribute("res_Jw_cid_atend_reg");
                if (res_Jw_cid_atend_reg!=null && res_Jw_cid_atend_reg.size()>0) {
                  java.lang.String cidade =  null;
                  int i_bl_report_Jw_cid_atend_reg = 0;
                  t_jw_cid_atend_reg = (portalbr.dbobj.view.Jw_cid_atend_reg)res_Jw_cid_atend_reg.elementAt(i_bl_report_Jw_cid_atend_reg);
                  cidade = t_jw_cid_atend_reg.getCidade()==null?"":t_jw_cid_atend_reg.getCidade();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_cid_atend_reg<res_Jw_cid_atend_reg.size()){
                    counterbl_report_Jw_cid_atend_reg++;
                    String style="";
                    if (!((i_bl_report_Jw_cid_atend_reg%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>
                    <tr <%= style %> id='TRbl_report_Jw_cid_atend_reg<%=counterbl_report_Jw_cid_atend_reg%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= cidade %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_cid_atend_reg >= res_Jw_cid_atend_reg.size()) {
                      break;
                    }
                    t_jw_cid_atend_reg = (portalbr.dbobj.view.Jw_cid_atend_reg)res_Jw_cid_atend_reg.elementAt(i_bl_report_Jw_cid_atend_reg);
                    cidade = t_jw_cid_atend_reg.getCidade()==null?"":t_jw_cid_atend_reg.getCidade();
                  }
                }
              }
              %>
            </table>
            <html:form action="adm/Cidades_ativasForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="codigo_regional"/>
                <html:hidden property="cidade"/>
                <html:hidden property="rep_cdgo"/>
                <html:hidden property="chamador"/>
                <html:hidden property="codigo_marca"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit styleClass="myhidden" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:button accesskey="b" onclick="history.back(-1);" styleClass="baseButton" property="blank_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:button>
                        <%
                      }
                      %>
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
