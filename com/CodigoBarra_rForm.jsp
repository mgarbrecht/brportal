<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="CodigoBarra_r.titulo"/>
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
              java.util.Vector res_Jw_cod_barra = (java.util.Vector)session.getAttribute("res_Jw_cod_barra");
              %>

              <%
              if (res_Jw_cod_barra!=null && res_Jw_cod_barra.size()>0) {
                %>

                <table id="TRbl_report_Jw_cod_barra"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String linha_ref =  null;
                  java.lang.String cabedal =  null;
                  java.lang.String cor =  null;
                  java.lang.String grade =  null;
                  java.lang.String cod_barra =  null;
                  java.lang.String status =  null;
                  java.lang.Integer codigo_marca = null;
                  java.lang.Integer cor_cdgo = null;
                  java.lang.Integer cab_cdgo = null;
                  java.lang.String descricao_marca = null;
                  java.lang.String cor_desc = null;
                  java.lang.String cab_desc = null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:center; width:1%" >
                      Marca
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Marca
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.linha_ref"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.cabedal"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cabedal
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.cor"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Descrição Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.grade"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.cod_barra"/>
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      <bean:message bundle="ComercialResources" key="CodigoBarra_r.status"/>
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_cod_barra = 0;
                  while (i_bl_report_Jw_cod_barra<res_Jw_cod_barra.size()) {
                    portalbr.dbobj.view.Jw_cod_barra t_jw_cod_barra = (portalbr.dbobj.view.Jw_cod_barra)res_Jw_cod_barra.elementAt(i_bl_report_Jw_cod_barra);
                    linha_ref = t_jw_cod_barra.getLinha_ref()==null?"":t_jw_cod_barra.getLinha_ref();
                    cabedal = t_jw_cod_barra.getCabedal()==null?"":t_jw_cod_barra.getCabedal();
                    cor = t_jw_cod_barra.getCor()==null?"":t_jw_cod_barra.getCor();
                    grade = t_jw_cod_barra.getGrade()==null?"":t_jw_cod_barra.getGrade();
                    cod_barra = t_jw_cod_barra.getCod_barra()==null?"":t_jw_cod_barra.getCod_barra();
                    status = t_jw_cod_barra.getStatus()==null?"":t_jw_cod_barra.getStatus();
                    codigo_marca = t_jw_cod_barra.getCodigo_marca();
                    cor_cdgo = t_jw_cod_barra.getCor_cdgo();
                    cab_cdgo = t_jw_cod_barra.getCab_cdgo();
                    descricao_marca = t_jw_cod_barra.getDescricao_marca()==null?"":t_jw_cod_barra.getDescricao_marca();
                    cor_desc = t_jw_cod_barra.getCor_desc()==null?"":t_jw_cod_barra.getCor_desc();
                    cab_desc = t_jw_cod_barra.getCab_desc()==null?"":t_jw_cod_barra.getCab_desc();
                    if(status.equals("A")){
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                    } else {
                      status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                    }







                    ;
                    String style_bl_report_Jw_cod_barra="";
                    if (!((i_bl_report_Jw_cod_barra%2)!=0)) {
                      style_bl_report_Jw_cod_barra="rowColor";
                    } else {
                      style_bl_report_Jw_cod_barra="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_cod_barra %>' id="TRbl_report_Jw_cod_barra<%=i_bl_report_Jw_cod_barra%>" >

                      <td class="reportColumn" style="text-align:center;" >
                        <%= codigo_marca %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= descricao_marca %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= linha_ref %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cab_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cab_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cor_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cor_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= grade %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%
                        if(!(request.getParameter("excel")+"").equals("true")){
                          %>
                          <%= cod_barra %>
                          <%
                        } else {
                          %>
                          <%= cod_barra %>
                           
                          <%
                        }
                        %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= status %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_cod_barra++;
                    if (i_bl_report_Jw_cod_barra<res_Jw_cod_barra.size()) {
                      t_jw_cod_barra = (portalbr.dbobj.view.Jw_cod_barra)res_Jw_cod_barra.elementAt(i_bl_report_Jw_cod_barra);
                      linha_ref = t_jw_cod_barra.getLinha_ref()==null?"":t_jw_cod_barra.getLinha_ref();
                      cabedal = t_jw_cod_barra.getCabedal()==null?"":t_jw_cod_barra.getCabedal();
                      cor = t_jw_cod_barra.getCor()==null?"":t_jw_cod_barra.getCor();
                      grade = t_jw_cod_barra.getGrade()==null?"":t_jw_cod_barra.getGrade();
                      cod_barra = t_jw_cod_barra.getCod_barra()==null?"":t_jw_cod_barra.getCod_barra();
                      status = t_jw_cod_barra.getStatus()==null?"":t_jw_cod_barra.getStatus();
                      codigo_marca = t_jw_cod_barra.getCodigo_marca();
                      cor_cdgo = t_jw_cod_barra.getCor_cdgo();
                      cab_cdgo = t_jw_cod_barra.getCab_cdgo();
                      descricao_marca = t_jw_cod_barra.getDescricao_marca()==null?"":t_jw_cod_barra.getDescricao_marca();
                      cor_desc = t_jw_cod_barra.getCor_desc()==null?"":t_jw_cod_barra.getCor_desc();
                      cab_desc = t_jw_cod_barra.getCab_desc()==null?"":t_jw_cod_barra.getCab_desc();
                      if(status.equals("A")){
                        status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.ativas");
                      } else {
                        status = java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.inativas");
                      }







                      ;
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
            <html:form action="com/CodigoBarra_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="a" onclick="history.back(-1);" styleClass="baseButton" property="back_action">
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
