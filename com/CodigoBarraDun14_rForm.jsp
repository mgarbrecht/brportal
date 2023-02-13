<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.titulo"/>
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
              java.util.Vector res_Jw_cod_barra_dum14 = (java.util.Vector)session.getAttribute("res_Jw_cod_barra_dum14");
              %>

              <%
              if (res_Jw_cod_barra_dum14!=null && res_Jw_cod_barra_dum14.size()>0) {
                %>

                <table id="TRbl_report_Jw_cod_barra_dum14"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String linha_ref =  null;
                  java.lang.Integer cab_cdgo =  null;
                  java.lang.String cabedal =  null;
                  java.lang.Integer cor_cdgo =  null;
                  java.lang.String cor =  null;
                  java.lang.String gde_cdgo =  null;
                  java.lang.Integer qtd_pares =  null;
                  java.lang.String cod_dum14 =  null;
                  java.lang.String status =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.linha_ref"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.cabedal"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cabedal
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.gde_cdgo"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.qtd_pares"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.cod_dum14"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarraDun14_r.status"/>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_cod_barra_dum14 = 0;
                  while (i_bl_report_Jw_cod_barra_dum14<res_Jw_cod_barra_dum14.size()) {
                    portalbr.dbobj.view.Jw_cod_barra_dum14 t_jw_cod_barra_dum14 = (portalbr.dbobj.view.Jw_cod_barra_dum14)res_Jw_cod_barra_dum14.elementAt(i_bl_report_Jw_cod_barra_dum14);
                    linha_ref = t_jw_cod_barra_dum14.getLinha_ref()==null?"":t_jw_cod_barra_dum14.getLinha_ref();
                    cab_cdgo = t_jw_cod_barra_dum14.getCab_cdgo();
                    cabedal = t_jw_cod_barra_dum14.getCabedal()==null?"":t_jw_cod_barra_dum14.getCabedal();
                    cor_cdgo = t_jw_cod_barra_dum14.getCor_cdgo();
                    cor = t_jw_cod_barra_dum14.getCor()==null?"":t_jw_cod_barra_dum14.getCor();
                    gde_cdgo = t_jw_cod_barra_dum14.getGde_cdgo()==null?"":t_jw_cod_barra_dum14.getGde_cdgo();
                    qtd_pares = t_jw_cod_barra_dum14.getQtd_pares();
                    cod_dum14 = t_jw_cod_barra_dum14.getCod_dum14()==null?"":t_jw_cod_barra_dum14.getCod_dum14();
                    status = t_jw_cod_barra_dum14.getStatus()==null?"":t_jw_cod_barra_dum14.getStatus();

                    if(status.equals("A")){
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                    } else {
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                      };
                      String style_bl_report_Jw_cod_barra_dum14="";
                      if (!((i_bl_report_Jw_cod_barra_dum14%2)!=0)) {
                        style_bl_report_Jw_cod_barra_dum14="rowColor";
                      } else {
                        style_bl_report_Jw_cod_barra_dum14="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_cod_barra_dum14 %>' id="TRbl_report_Jw_cod_barra_dum14<%=i_bl_report_Jw_cod_barra_dum14%>" >
                        <td class="reportColumn" style="text-align:center;" >
                          <%= linha_ref %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((cab_cdgo!=null)?cab_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cabedal %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= ((cor_cdgo!=null)?cor_cdgo.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= gde_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= ((qtd_pares!=null)?qtd_pares.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%
                          if(!(request.getParameter("excel")+"").equals("true")){
                            %>
                            <%= cod_dum14 %>
                            <%
                          } else {
                            %>
                            <%= Long.parseLong(cod_dum14) %>
                            &nbsp
                            <%
                          }
                          %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= status %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_cod_barra_dum14++;
                      if (i_bl_report_Jw_cod_barra_dum14<res_Jw_cod_barra_dum14.size()) {
                        t_jw_cod_barra_dum14 = (portalbr.dbobj.view.Jw_cod_barra_dum14)res_Jw_cod_barra_dum14.elementAt(i_bl_report_Jw_cod_barra_dum14);
                        linha_ref = t_jw_cod_barra_dum14.getLinha_ref()==null?"":t_jw_cod_barra_dum14.getLinha_ref();
                        cab_cdgo = t_jw_cod_barra_dum14.getCab_cdgo();
                        cabedal = t_jw_cod_barra_dum14.getCabedal()==null?"":t_jw_cod_barra_dum14.getCabedal();
                        cor_cdgo = t_jw_cod_barra_dum14.getCor_cdgo();
                        cor = t_jw_cod_barra_dum14.getCor()==null?"":t_jw_cod_barra_dum14.getCor();
                        gde_cdgo = t_jw_cod_barra_dum14.getGde_cdgo()==null?"":t_jw_cod_barra_dum14.getGde_cdgo();
                        qtd_pares = t_jw_cod_barra_dum14.getQtd_pares();
                        cod_dum14 = t_jw_cod_barra_dum14.getCod_dum14()==null?"":t_jw_cod_barra_dum14.getCod_dum14();
                        status = t_jw_cod_barra_dum14.getStatus()==null?"":t_jw_cod_barra_dum14.getStatus();

                        if(status.equals("A")){
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                        } else {
                          status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                          };
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

                <html:form action="com/CodigoBarraDun14_rForm.do" method="post" styleClass="baseForm">
                  <table class="buttonTable" style='width:;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <html:submit styleClass="baseButton" property="back_action">
                            <bean:message bundle="ApplicationResources" key="jsp.back"/>
                          </html:submit>
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
