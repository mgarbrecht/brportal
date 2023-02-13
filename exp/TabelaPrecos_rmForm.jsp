<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <head>
      <title>
        Tabela de Preços - Itens Selecionados
      </title>
    </head>
    <center>
      <body>
        <table class="mainTable" style='width:99%;'>
          <tr class="mainTr">
            <td class="mainTd">
              <%
              {
                %>

                <%
                java.util.List<Object[][]> res_Jw_ref_cor = (java.util.List<Object[][]>)session.getAttribute("listaProdutos");
                %>

                <form  name="bl_report_Jw_ref_cor" id="bl_report_Jw_ref_cor" class="baseForm" method="post" >

                  <%
                  if (res_Jw_ref_cor!=null && res_Jw_ref_cor.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_ref_cor"  class="reportTable"   style="width:99%; "  >
                      <%
                      java.lang.String lin_cdgo =  null;
                      java.lang.String ref_cdgo =  null;
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:left;" >
                          Linha
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" >
                          Referência
                        </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_ref_cor = 0;
                      for(Object[][] l : res_Jw_ref_cor){
                        lin_cdgo = l[0][0].toString();
                        ref_cdgo = l[0][1].toString();
                        String style_bl_report_Jw_ref_cor="";
                        if (!((i_bl_report_Jw_ref_cor%2)!=0)) {
                          style_bl_report_Jw_ref_cor="rowColor";
                        } else {
                          style_bl_report_Jw_ref_cor="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_ref_cor %>' id="TRbl_report_Jw_ref_cor<%=i_bl_report_Jw_ref_cor%>" >
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                          </td>
                          <td class="reportColumn" style="text-align:left;" >
                            <%= ((ref_cdgo!=null)?ref_cdgo.toString():"") %>
                          </td>
                        </tr>

                        <%
                        i_bl_report_Jw_ref_cor++;
                        if (i_bl_report_Jw_ref_cor<res_Jw_ref_cor.size()) {
                          lin_cdgo = l[0][0].toString();
                          ref_cdgo = l[0][1].toString();
                        } else {
                        }
                      }
                      %>

                    </table>

                    <%
                  }
                  %>

                </form>
                <%
              }
              %>
              <html:form action="exp/TabelaPrecos_rmForm.do" method="post" styleClass="baseForm">
                <table class="messageTable" style='width:99%;'>
                  <tr class="messageTr" >
                    <td class="messageTd">
                      <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                    </td>
                  </tr>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                        <bean:message bundle="ApplicationResources" key="jsp.close"/>
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
