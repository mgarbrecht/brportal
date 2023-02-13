<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Filial/Linhas
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
                  <%@ include file="../system/header_excel.jsp" %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_filial_linhas = (java.util.Vector)session.getAttribute("res_Jw_filial_linhas");
              %>

              <%
              if (res_Jw_filial_linhas!=null && res_Jw_filial_linhas.size()>0) {
                %>

                <table id="TRbl_report_Jw_filial_linhas"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String lin_codigo =  null;
                  java.lang.String ref_codigo =  null;
                  java.lang.String cod_filial =  null;
                  java.lang.String fil_razsoc =  null;
                  java.lang.String mix =  null;
                  java.lang.String ativa =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Linha
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Referência
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Filial
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Fil. Razão Social
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      MIX
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Ativa
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_filial_linhas = 0;
                  while (i_bl_report_Jw_filial_linhas<res_Jw_filial_linhas.size()) {
                    portalbr.dbobj.view.Jw_filial_linhas t_jw_filial_linhas = (portalbr.dbobj.view.Jw_filial_linhas)res_Jw_filial_linhas.elementAt(i_bl_report_Jw_filial_linhas);
                    lin_codigo = t_jw_filial_linhas.getLin_codigo()==null?"":t_jw_filial_linhas.getLin_codigo();
                    ref_codigo = t_jw_filial_linhas.getRef_codigo()==null?"":t_jw_filial_linhas.getRef_codigo();
                    cod_filial = t_jw_filial_linhas.getCod_filial()==null?"":t_jw_filial_linhas.getCod_filial();
                    fil_razsoc = t_jw_filial_linhas.getFil_razsoc()==null?"":t_jw_filial_linhas.getFil_razsoc();
                    mix = t_jw_filial_linhas.getMix()==null?"":t_jw_filial_linhas.getMix();
                    ativa = t_jw_filial_linhas.getAtiva()==null?"":t_jw_filial_linhas.getAtiva();
                    String style_bl_report_Jw_filial_linhas="";
                    if (!((i_bl_report_Jw_filial_linhas%2)!=0)) {
                      style_bl_report_Jw_filial_linhas="rowColor";
                    } else {
                      style_bl_report_Jw_filial_linhas="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_filial_linhas %>' id="TRbl_report_Jw_filial_linhas<%=i_bl_report_Jw_filial_linhas%>" >
                      <td class="reportColumn" style="text-align:left;width:20%;" >
                        <%= lin_codigo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;width:20%;" >
                        <%= ref_codigo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;width:10%;" >
                        <%= cod_filial %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= fil_razsoc %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" width="5%" >
                        <%
                        if(mix.equals("M")){
                          %>
                          <img src=../img/mark.gif>
                          <%
                        }
                        %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(ativa.equals("S")){
                          %>
                          <img src=../img/mark.gif>
                          <%
                        }
                        %>
                      </td>
                    </tr>

                    <%
                    i_bl_report_Jw_filial_linhas++;
                    if (i_bl_report_Jw_filial_linhas<res_Jw_filial_linhas.size()) {
                      t_jw_filial_linhas = (portalbr.dbobj.view.Jw_filial_linhas)res_Jw_filial_linhas.elementAt(i_bl_report_Jw_filial_linhas);
                      lin_codigo = t_jw_filial_linhas.getLin_codigo()==null?"":t_jw_filial_linhas.getLin_codigo();
                      ref_codigo = t_jw_filial_linhas.getRef_codigo()==null?"":t_jw_filial_linhas.getRef_codigo();
                      cod_filial = t_jw_filial_linhas.getCod_filial()==null?"":t_jw_filial_linhas.getCod_filial();
                      fil_razsoc = t_jw_filial_linhas.getFil_razsoc()==null?"":t_jw_filial_linhas.getFil_razsoc();
                      mix = t_jw_filial_linhas.getMix()==null?"":t_jw_filial_linhas.getMix();
                      ativa = t_jw_filial_linhas.getAtiva()==null?"":t_jw_filial_linhas.getAtiva();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <%
            }
            %>

            <html:form action="ind/FilialLinhas_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>

                    </div>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="a" styleClass="baseButton" property="back_action">
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
