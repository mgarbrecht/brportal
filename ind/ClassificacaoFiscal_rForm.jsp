<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Classificação Fiscal
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
              java.util.Vector res_Jw_ncm = (java.util.Vector)session.getAttribute("res_Jw_ncm");
              %>

              <%
              if (res_Jw_ncm!=null && res_Jw_ncm.size()>0) {
                %>

                <table id="TRbl_report_Jw_ncm"  class="reportTable"   style="width:99%; "  border="1"  frame="box">
                  <%
                  java.lang.String marca_nome =  null;
                  java.lang.String lin_cdgo =  null;
                  java.lang.String ref_cdgo =  null;
                  java.lang.String cab_cdgo =  null;
                  java.lang.String descricao =  null;
                  java.lang.String ncm =  null;
                  java.lang.String rfb_status =  null;
                  String _b0_control = "__";
                  int i_bl_report_Jw_ncm = 0;
                  while (i_bl_report_Jw_ncm<res_Jw_ncm.size()) {
                    portalbr.dbobj.view.Jw_ncm t_jw_ncm = (portalbr.dbobj.view.Jw_ncm)res_Jw_ncm.elementAt(i_bl_report_Jw_ncm);
                    lin_cdgo = t_jw_ncm.getLin_cdgo()==null?"":t_jw_ncm.getLin_cdgo();
                    ref_cdgo = t_jw_ncm.getRef_cdgo()==null?"":t_jw_ncm.getRef_cdgo();
                    cab_cdgo = t_jw_ncm.getCab_cdgo()==null?"":t_jw_ncm.getCab_cdgo();
                    descricao = t_jw_ncm.getDescricao()==null?"":t_jw_ncm.getDescricao();
                    ncm = t_jw_ncm.getNcm()==null?"":t_jw_ncm.getNcm();
                    marca_nome = t_jw_ncm.getMarca_nome()==null?"":t_jw_ncm.getMarca_nome();
                    rfb_status = t_jw_ncm.getRfb_status()==null?"":(t_jw_ncm.getRfb_status().equals("I")?"Inativo":"Ativo");
                    String _b0_value = (marca_nome==null?"":marca_nome);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      %>
                      <tr class="reportHeader">
                        <td colspan="6">
                          <span class="columnTdHeader" style="text-align:left;" >
                            Marca
                          </span>
                          <span class="reportColumn" style="text-align:left; color:#FFFFFF;" >
                            <%= marca_nome %>
                          </span>
                        </td>
                      </tr>
                      <%
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:left;" >
                          Linha
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Ref.
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Cabedal
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Descrição
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          NCM
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Situação
                        </td>

                      </tr>

                      <%
                    }
                    String style_bl_report_Jw_ncm="";
                    if (!((i_bl_report_Jw_ncm%2)!=0)) {
                      style_bl_report_Jw_ncm="rowColor";
                    } else {
                      style_bl_report_Jw_ncm="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_ncm %>' id="TRbl_report_Jw_ncm<%=i_bl_report_Jw_ncm%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= lin_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ref_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cab_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= descricao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ncm %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= rfb_status %>
                      </td>

                    </tr>

                    <%
                    _b0_control = _b0_value;
                    i_bl_report_Jw_ncm++;
                    if (i_bl_report_Jw_ncm<res_Jw_ncm.size()) {
                      t_jw_ncm = (portalbr.dbobj.view.Jw_ncm)res_Jw_ncm.elementAt(i_bl_report_Jw_ncm);
                      lin_cdgo = t_jw_ncm.getLin_cdgo()==null?"":t_jw_ncm.getLin_cdgo();
                      ref_cdgo = t_jw_ncm.getRef_cdgo()==null?"":t_jw_ncm.getRef_cdgo();
                      cab_cdgo = t_jw_ncm.getCab_cdgo()==null?"":t_jw_ncm.getCab_cdgo();
                      descricao = t_jw_ncm.getDescricao()==null?"":t_jw_ncm.getDescricao();
                      ncm = t_jw_ncm.getNcm()==null?"":t_jw_ncm.getNcm();
                      marca_nome = t_jw_ncm.getMarca_nome()==null?"":t_jw_ncm.getMarca_nome();
                      rfb_status = t_jw_ncm.getRfb_status()==null?"":(t_jw_ncm.getRfb_status().equals("I")?"Inativo":"Ativo");
                      _b0_value = (marca_nome==null?"":marca_nome);
                    } else {
                      _b0_control = "__";
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

            <html:form action="ind/ClassificacaoFiscal_rForm.do" method="post" styleClass="baseForm">
              <table class="buttonTable" style='width:;'>
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
