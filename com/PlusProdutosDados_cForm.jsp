<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      PLUS Produtos - Dados do Produto - Cabedais e Cores
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(81)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            int counterbl_report_Jw_linha_ref_cab_cor=0;
            {
              portalbr.dbobj.view.Jw_linha_ref_cab_cor t_jw_linha_ref_cab_cor = new portalbr.dbobj.view.Jw_linha_ref_cab_cor();
              java.util.Vector res_Jw_linha_ref_cab_cor = (java.util.Vector)session.getAttribute("res_Jw_linha_ref_cab_cor");
              if (res_Jw_linha_ref_cab_cor!=null && res_Jw_linha_ref_cab_cor.size()>0) {
                java.lang.String cab_cdgo =  null;
                java.lang.String cab_desc =  null;
                java.lang.String status   =  null;
                java.lang.String cor_cdgo =  null;
                java.lang.String cor_desc =  null;
                int i_bl_report_Jw_linha_ref_cab_cor = 0;
                t_jw_linha_ref_cab_cor = (portalbr.dbobj.view.Jw_linha_ref_cab_cor)res_Jw_linha_ref_cab_cor.elementAt(i_bl_report_Jw_linha_ref_cab_cor);
                cab_cdgo = t_jw_linha_ref_cab_cor.getCab_cdgo()==null?"":t_jw_linha_ref_cab_cor.getCab_cdgo();
                cab_desc = t_jw_linha_ref_cab_cor.getCab_desc()==null?"":t_jw_linha_ref_cab_cor.getCab_desc();
                status   = t_jw_linha_ref_cab_cor.getStatus()==null?"":t_jw_linha_ref_cab_cor.getStatus();
                cor_cdgo = t_jw_linha_ref_cab_cor.getCor_cdgo()==null?"":t_jw_linha_ref_cab_cor.getCor_cdgo();
                cor_desc = t_jw_linha_ref_cab_cor.getCor_desc()==null?"":t_jw_linha_ref_cab_cor.getCor_desc();
                java.lang.String b0_cab_cdgo =  null;
                while (i_bl_report_Jw_linha_ref_cab_cor<res_Jw_linha_ref_cab_cor.size()){
                  counterbl_report_Jw_linha_ref_cab_cor++;
                  %>
                  <table id="TRbl_report_Jw_linha_ref_cab_cor" class="reportTable" style=width:99%;  border=1  frame=box>
                    <tr class="reportHeader2" >
                      <td colspan=3>
                        Cabedal :
                        <%= cab_cdgo %>
                        -
                        <%= cab_desc %>
                      </td>
                    </tr>
                    <%
                    b0_cab_cdgo = cab_cdgo;
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:left;" width="80%">
                        Cor
                      </td>
                      <td class="columnTdHeader" style="text-align:left;" width="20%">
                        Status
                      </td>

                    </tr>
                    <%
                    while (i_bl_report_Jw_linha_ref_cab_cor<res_Jw_linha_ref_cab_cor.size() &&  (b0_cab_cdgo==null?"":b0_cab_cdgo).equals((cab_cdgo==null?"":cab_cdgo))){
                      counterbl_report_Jw_linha_ref_cab_cor++;
                      String style="";
                      if (!((i_bl_report_Jw_linha_ref_cab_cor%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <tr <%= style %> id='TRbl_report_Jw_linha_ref_cab_cor<%=counterbl_report_Jw_linha_ref_cab_cor%>' >
                        <td class="reportColumn" style="text-align:left;">
                          <%= cor_cdgo %>
                          -
                          <%= cor_desc %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= status %>
                        </td>

                      </tr>
                      <%
                      if (++i_bl_report_Jw_linha_ref_cab_cor >= res_Jw_linha_ref_cab_cor.size()) {
                        break;
                      }
                      t_jw_linha_ref_cab_cor = (portalbr.dbobj.view.Jw_linha_ref_cab_cor)res_Jw_linha_ref_cab_cor.elementAt(i_bl_report_Jw_linha_ref_cab_cor);
                      cab_cdgo = t_jw_linha_ref_cab_cor.getCab_cdgo()==null?"":t_jw_linha_ref_cab_cor.getCab_cdgo();
                      cab_desc = t_jw_linha_ref_cab_cor.getCab_desc()==null?"":t_jw_linha_ref_cab_cor.getCab_desc();
                      status   = t_jw_linha_ref_cab_cor.getStatus()==null?"":t_jw_linha_ref_cab_cor.getStatus();
                      cor_cdgo = t_jw_linha_ref_cab_cor.getCor_cdgo()==null?"":t_jw_linha_ref_cab_cor.getCor_cdgo();
                      cor_desc = t_jw_linha_ref_cab_cor.getCor_desc()==null?"":t_jw_linha_ref_cab_cor.getCor_desc();
                    }
                  }
                }
              }
              %>
            </table>
            <html:form action="com/PlusProdutosDados_cForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="lin_cdgo"/>
                <html:hidden property="ref_cdgo"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:button>
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
