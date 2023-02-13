<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Impressão de Duplicatas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(12)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_consulta_titulos" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_consulta_titulos=0;
              {
                portalbr.dbobj.view.Jw_consulta_titulos t_jw_consulta_titulos = new portalbr.dbobj.view.Jw_consulta_titulos();
                portalbr.adm.ImpressaoDuplicatasClientesNVActionForm ImpressaoDuplicatasClientesNVActionForm = (portalbr.adm.ImpressaoDuplicatasClientesNVActionForm)session.getAttribute("ImpressaoDuplicatasClientesNVActionForm");
                java.util.Vector res_Jw_consulta_titulos = (java.util.Vector)session.getAttribute("res_Jw_consulta_titulos");
                if (res_Jw_consulta_titulos!=null && res_Jw_consulta_titulos.size()>0) {
                  java.lang.String cliente   =  null;
                  java.lang.String razao     =  null;
                  java.lang.String br        =  null;
                  java.lang.String esc_cgc   =  null;
                  java.lang.String cid_est   =  null;
                  java.lang.Integer esc_seqn =  null;
                  java.lang.Integer cli_cdgo =  null;
                  int i_bl_report_Jw_consulta_titulos = 0;
                  java.lang.String codigo_sucessor       = null;
                  java.lang.String sequencial_sucessor   = null;
                  java.lang.String razao_social_sucessor = null;
                  java.lang.String cid_uf_sucessor       = null;
                  java.lang.String br_sucessor           = null;

                  t_jw_consulta_titulos = (portalbr.dbobj.view.Jw_consulta_titulos)res_Jw_consulta_titulos.elementAt(i_bl_report_Jw_consulta_titulos);
                  cliente  = t_jw_consulta_titulos.getCliente()==null?"":t_jw_consulta_titulos.getCliente();
                  razao    = t_jw_consulta_titulos.getRazao()==null?"":t_jw_consulta_titulos.getRazao();
                  br       = t_jw_consulta_titulos.getBr()==null?"":t_jw_consulta_titulos.getBr();
                  esc_cgc  = t_jw_consulta_titulos.getEsc_cgc()==null?"":t_jw_consulta_titulos.getEsc_cgc();
                  cid_est  = t_jw_consulta_titulos.getCid_est()==null?"":t_jw_consulta_titulos.getCid_est();
                  esc_seqn = t_jw_consulta_titulos.getEsc_seqn();
                  cli_cdgo = t_jw_consulta_titulos.getCli_cdgo();
                  codigo_sucessor       = t_jw_consulta_titulos.getCodigo_sucessor()+"";
                  sequencial_sucessor   = t_jw_consulta_titulos.getSequencial_sucessor()+"";
                  razao_social_sucessor = t_jw_consulta_titulos.getRazao_social_sucessor();
                  cid_uf_sucessor       = t_jw_consulta_titulos.getCid_uf_sucessor();
                  br_sucessor           = t_jw_consulta_titulos.getBr_sucessor();
                  %>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      CGC
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Razão Social
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Bairro
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade - UF
                    </td>
                  </tr>
                  <%
                  while (i_bl_report_Jw_consulta_titulos<res_Jw_consulta_titulos.size()){
                    counterbl_report_Jw_consulta_titulos++;
                    String style="";
                    if (!((i_bl_report_Jw_consulta_titulos%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr class=<%= style %> id='TRbl_report_Jw_consulta_titulos<%=counterbl_report_Jw_consulta_titulos%>' >
                      <td class="reportColumn" style="text-align:left;" title="Títulos do Cliente: <%= razao %>">

                        <%
                        if(codigo_sucessor.equals("null")||codigo_sucessor.equals("")) {
                          %>
                          <a href="../adm/ImpressaoDuplicatasNV_rForm.do?select_action=&esc_seqn=<%= esc_seqn %>&cli_cdgo=<%= cli_cdgo %>&dt_venc=<%= ImpressaoDuplicatasClientesNVActionForm.getDt_venc() %>&situacao=<%= ImpressaoDuplicatasClientesNVActionForm.getSituacao() %>&codigo=<%= cliente %>&nome=<%= razao %>&bairro=<%= br %>&cidade_uf=<%= cid_est %>&emp_empresa=<%= ImpressaoDuplicatasClientesNVActionForm.getEmp_empresa() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= cliente %>
                          </a>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <a href="../adm/ImpressaoDuplicatasNV_rForm.do?select_action=&esc_seqn=<%= esc_seqn %>&cli_cdgo=<%= cli_cdgo %>&dt_venc=<%= ImpressaoDuplicatasClientesNVActionForm.getDt_venc() %>&situacao=<%= ImpressaoDuplicatasClientesNVActionForm.getSituacao() %>&codigo=<%= cliente %>&nome=<%= razao %>&bairro=<%= br %>&cidade_uf=<%= cid_est %>&emp_empresa=<%= ImpressaoDuplicatasClientesNVActionForm.getEmp_empresa() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                                <%= cliente %>
                              </a>
                            </font>


                            /
                          </small>
                          <a href="../adm/ImpressaoDuplicatasNV_rForm.do?select_action=&esc_seqn=<%= sequencial_sucessor %>&cli_cdgo=<%= codigo_sucessor %>&dt_venc=<%= ImpressaoDuplicatasClientesNVActionForm.getDt_venc() %>&situacao=<%= ImpressaoDuplicatasClientesNVActionForm.getSituacao() %>&codigo=<%= codigo_sucessor %>&nome=<%= razao_social_sucessor %>&bairro=<%= br_sucessor %>&cidade_uf=<%= cid_uf_sucessor  %>&emp_empresa=<%= ImpressaoDuplicatasClientesNVActionForm.getEmp_empresa() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= codigo_sucessor %>
                            -
                            <%= sequencial_sucessor %>
                          </a>

                          -
                          <%= razao_social_sucessor %>
                          ( Sucessor )
                          <%
                        }
                        %>

                      </td>


                      <td class="reportColumn" style="text-align:left;">
                        <%= esc_cgc %>
                      </td>


                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(codigo_sucessor.equals("null")||codigo_sucessor.equals("")) {
                          %>
                          <%= razao %>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <s>
                                <%= razao %>
                              </s>
                            </font>
                          </small>
                          <%= razao_social_sucessor %>
                          (Sucessor)
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(codigo_sucessor.equals("null")||codigo_sucessor.equals("")) {
                          %>
                          <%= br%>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <s>
                                <%= br%>
                              </s>
                            </font>
                          </small>
                          <%= br_sucessor %>
                          (Sucessor)
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%
                        if(codigo_sucessor.equals("null")||codigo_sucessor.equals("")) {
                          %>
                          <%= cid_est %>
                          <%
                        } else {
                          %>
                          <small>
                            <font color="red">
                              <s>
                                <%= cid_est %>
                              </s>
                            </font>
                          </small>
                          <%= cid_uf_sucessor %>
                          (Sucessor)
                          <%
                        }
                        %>
                      </td>
                    </tr>
                    <%
                    if (++i_bl_report_Jw_consulta_titulos >= res_Jw_consulta_titulos.size()) {
                      break;
                    }
                    t_jw_consulta_titulos = (portalbr.dbobj.view.Jw_consulta_titulos)res_Jw_consulta_titulos.elementAt(i_bl_report_Jw_consulta_titulos);
                    cliente  = t_jw_consulta_titulos.getCliente()==null?"":t_jw_consulta_titulos.getCliente();
                    razao    = t_jw_consulta_titulos.getRazao()==null?"":t_jw_consulta_titulos.getRazao();
                    br       = t_jw_consulta_titulos.getBr()==null?"":t_jw_consulta_titulos.getBr();
                    esc_cgc  = t_jw_consulta_titulos.getEsc_cgc()==null?"":t_jw_consulta_titulos.getEsc_cgc();
                    cid_est  = t_jw_consulta_titulos.getCid_est()==null?"":t_jw_consulta_titulos.getCid_est();
                    esc_seqn = t_jw_consulta_titulos.getEsc_seqn();
                    cli_cdgo = t_jw_consulta_titulos.getCli_cdgo();
                    codigo_sucessor       = t_jw_consulta_titulos.getCodigo_sucessor()+"";
                    sequencial_sucessor   = t_jw_consulta_titulos.getSequencial_sucessor()+"";
                    razao_social_sucessor = t_jw_consulta_titulos.getRazao_social_sucessor();
                    cid_uf_sucessor       = t_jw_consulta_titulos.getCid_uf_sucessor();
                    br_sucessor           = t_jw_consulta_titulos.getBr_sucessor();
                  }
                }
              }
              %>
            </table>
            <html:form action="adm/ImpressaoDuplicatasClientesNVForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="dt_venc"/>
                <html:hidden property="situacao"/>
                <html:hidden property="emp_empresa"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
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
