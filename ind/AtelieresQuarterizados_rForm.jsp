<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Cadastro de Atelieres - Listagem
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(87)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              %>

              <%
              java.util.Vector res_For_endere_quarterizado = (java.util.Vector)session.getAttribute("res_For_endere_quarterizado");
              %>

              <form  name="bl_report_For_endere_quarterizado" id="bl_report_For_endere_quarterizado" class="baseForm" method="post" >
                <%
                if (res_For_endere_quarterizado!=null && res_For_endere_quarterizado.size()>0) {
                  if ( ((String)request.getParameter("_ordered"))!=null && ((String)request.getParameter("_ordered")).length()>0 ) {
                    boolean reverse = false;
                    if ( ((String)request.getParameter("_reverse"))!=null && ((String)request.getParameter("_reverse")).equals("true") ){
                      reverse = true;
                    }
                    try {
                      res_For_endere_quarterizado = com.egen.util.text.Sort.execute(res_For_endere_quarterizado,((String)request.getParameter("_ordered")),reverse);
                      session.setAttribute("res_For_endere_quarterizado", res_For_endere_quarterizado);
                    } catch (Exception e) {}
                  }
                  %>

                  <table id="TRbl_report_For_endere_quarterizado"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer for_codigo =  null;
                    java.lang.Integer for_codigo_quarterizado =  null;
                    java.lang.Integer fen_seq_quarterizado =  null;
                    java.lang.String for_razsoc =  null;
                    java.lang.Double fen_cgc_quarterizado =  null;
                    java.lang.String fen_rua_quarterizado =  null;
                    java.lang.String fen_nro_quarterizado =  null;
                    java.lang.String fen_compto_quarterizado =  null;
                    java.lang.String fen_bairro_quarterizado =  null;
                    java.lang.String fen_cidade_quarterizado =  null;
                    java.lang.String est_unifed_quarterizado =  null;
                    java.lang.Integer fen_cep_quarterizado =  null;
                    java.lang.String fen_insmun_quarterizado =  null;
                    java.lang.String fen_insest_quarterizado =  null;
                    java.lang.String fen_ativo_quarterizado =  null;
                    java.lang.String fen_email_quarterizado =  null;
                    java.lang.String fen_gln_quarterizado =  null;
                    java.lang.String tipo_log_quarterizado =  null;
                    java.lang.String fen_observacao_quarterizado =  null;
                    java.sql.Timestamp dthr_inclusao =  null;
                    java.sql.Timestamp dthr_alteracao =  null;
                    java.lang.String usuario_inclusao =  null;
                    java.lang.String usuario_alteracao =  null;
                    java.lang.String editar =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Fornecedor Quarterizado
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","for_codigo_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","for_codigo_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq.
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fen_seq_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fen_seq_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","for_razsoc")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","for_razsoc")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        CGC
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fen_cgc_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fen_cgc_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cidade
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","fen_cidade_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","fen_cidade_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        UF
                        <%
                        if ( (request.getParameter("_reverse")==null || ((String)request.getParameter("_reverse")).equals("true")) || request.getParameter("_ordered")==null ){
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","false","_ordered","est_unifed_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.orderedasc"/>
                          </a>
                          <%
                        } else {
                          %>
                          <a href='AtelieresQuarterizados_rForm.jsp<%=com.egen.util.servlet.Parameter.reWriteUrl(request,"_reverse","true","_ordered","est_unifed_quarterizado")%>' class="reportOrder">
                            <bean:message key="report.ordereddesc"/>
                          </a>
                          <%
                        }
                        %>
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Editar
                      </td>

                    </tr>

                    <%
                    int i_bl_report_For_endere_quarterizado = 0;
                    while (i_bl_report_For_endere_quarterizado<res_For_endere_quarterizado.size()) {
                      portalbr.dbobj.table.For_endere_quarterizado t_for_endere_quarterizado = (portalbr.dbobj.table.For_endere_quarterizado)res_For_endere_quarterizado.elementAt(i_bl_report_For_endere_quarterizado);
                      for_codigo = t_for_endere_quarterizado.getFor_codigo();
                      for_codigo_quarterizado = t_for_endere_quarterizado.getFor_codigo_quarterizado();
                      fen_seq_quarterizado = t_for_endere_quarterizado.getFen_seq_quarterizado();
                      for_razsoc = t_for_endere_quarterizado.getFor_razsoc()==null?"":t_for_endere_quarterizado.getFor_razsoc();
                      fen_cgc_quarterizado = t_for_endere_quarterizado.getFen_cgc_quarterizado();
                      fen_rua_quarterizado = t_for_endere_quarterizado.getFen_rua_quarterizado()==null?"":t_for_endere_quarterizado.getFen_rua_quarterizado();
                      fen_nro_quarterizado = t_for_endere_quarterizado.getFen_nro_quarterizado()==null?"":t_for_endere_quarterizado.getFen_nro_quarterizado();
                      fen_compto_quarterizado = t_for_endere_quarterizado.getFen_compto_quarterizado()==null?"":t_for_endere_quarterizado.getFen_compto_quarterizado();
                      fen_bairro_quarterizado = t_for_endere_quarterizado.getFen_bairro_quarterizado()==null?"":t_for_endere_quarterizado.getFen_bairro_quarterizado();
                      fen_cidade_quarterizado = t_for_endere_quarterizado.getFen_cidade_quarterizado()==null?"":t_for_endere_quarterizado.getFen_cidade_quarterizado();
                      est_unifed_quarterizado = t_for_endere_quarterizado.getEst_unifed_quarterizado()==null?"":t_for_endere_quarterizado.getEst_unifed_quarterizado();
                      fen_cep_quarterizado = t_for_endere_quarterizado.getFen_cep_quarterizado();
                      fen_insmun_quarterizado = t_for_endere_quarterizado.getFen_insmun_quarterizado()==null?"":t_for_endere_quarterizado.getFen_insmun_quarterizado();
                      fen_insest_quarterizado = t_for_endere_quarterizado.getFen_insest_quarterizado()==null?"":t_for_endere_quarterizado.getFen_insest_quarterizado();
                      fen_ativo_quarterizado = t_for_endere_quarterizado.getFen_ativo_quarterizado()==null?"":t_for_endere_quarterizado.getFen_ativo_quarterizado();
                      fen_email_quarterizado = t_for_endere_quarterizado.getFen_email_quarterizado()==null?"":t_for_endere_quarterizado.getFen_email_quarterizado();
                      fen_gln_quarterizado = t_for_endere_quarterizado.getFen_gln_quarterizado()==null?"":t_for_endere_quarterizado.getFen_gln_quarterizado();
                      tipo_log_quarterizado = t_for_endere_quarterizado.getTipo_log_quarterizado()==null?"":t_for_endere_quarterizado.getTipo_log_quarterizado();
                      fen_observacao_quarterizado = t_for_endere_quarterizado.getFen_observacao_quarterizado()==null?"":t_for_endere_quarterizado.getFen_observacao_quarterizado();
                      dthr_inclusao = (java.sql.Timestamp)t_for_endere_quarterizado.getDthr_inclusao();
                      dthr_alteracao = (java.sql.Timestamp)t_for_endere_quarterizado.getDthr_alteracao();
                      usuario_inclusao = t_for_endere_quarterizado.getUsuario_inclusao()==null?"":t_for_endere_quarterizado.getUsuario_inclusao();
                      usuario_alteracao = t_for_endere_quarterizado.getUsuario_alteracao()==null?"":t_for_endere_quarterizado.getUsuario_alteracao();
                      String style_bl_report_For_endere_quarterizado="";
                      if (!((i_bl_report_For_endere_quarterizado%2)!=0)) {
                        style_bl_report_For_endere_quarterizado="rowColor";
                      } else {
                        style_bl_report_For_endere_quarterizado="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_For_endere_quarterizado %>' id="TRbl_report_For_endere_quarterizado<%=i_bl_report_For_endere_quarterizado%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((for_codigo_quarterizado!=null)?for_codigo_quarterizado.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((fen_seq_quarterizado!=null)?fen_seq_quarterizado.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="../ind/AtelieresQuarterizados_mForm.do?select_action=&for_codigo=<%= for_codigo %>&for_codigo_quarterizado=<%= for_codigo_quarterizado %>&fen_seq_quarterizado=<%= fen_seq_quarterizado %>" style="cursor:hand">
                            <%= for_razsoc %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= com.egen.util.text.FormatNumber.format(fen_cgc_quarterizado, "0") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= fen_cidade_quarterizado %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= est_unifed_quarterizado %>
                        </td>

                        <td class="reportColumn" style="text-align: center;" >
                          <a href="../ind/AtelieresQuarterizados_mForm.do?select_action=&for_codigo=<%= for_codigo %>&for_codigo_quarterizado=<%= for_codigo_quarterizado %>&fen_seq_quarterizado=<%= fen_seq_quarterizado %>" style="cursor:hand">
                            <input type="button" value="Editar" />
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_For_endere_quarterizado++;
                      if (i_bl_report_For_endere_quarterizado<res_For_endere_quarterizado.size()) {
                        t_for_endere_quarterizado = (portalbr.dbobj.table.For_endere_quarterizado)res_For_endere_quarterizado.elementAt(i_bl_report_For_endere_quarterizado);
                        for_codigo = t_for_endere_quarterizado.getFor_codigo();
                        for_codigo_quarterizado = t_for_endere_quarterizado.getFor_codigo_quarterizado();
                        fen_seq_quarterizado = t_for_endere_quarterizado.getFen_seq_quarterizado();
                        for_razsoc = t_for_endere_quarterizado.getFor_razsoc()==null?"":t_for_endere_quarterizado.getFor_razsoc();
                        fen_cgc_quarterizado = t_for_endere_quarterizado.getFen_cgc_quarterizado();
                        fen_rua_quarterizado = t_for_endere_quarterizado.getFen_rua_quarterizado()==null?"":t_for_endere_quarterizado.getFen_rua_quarterizado();
                        fen_nro_quarterizado = t_for_endere_quarterizado.getFen_nro_quarterizado()==null?"":t_for_endere_quarterizado.getFen_nro_quarterizado();
                        fen_compto_quarterizado = t_for_endere_quarterizado.getFen_compto_quarterizado()==null?"":t_for_endere_quarterizado.getFen_compto_quarterizado();
                        fen_bairro_quarterizado = t_for_endere_quarterizado.getFen_bairro_quarterizado()==null?"":t_for_endere_quarterizado.getFen_bairro_quarterizado();
                        fen_cidade_quarterizado = t_for_endere_quarterizado.getFen_cidade_quarterizado()==null?"":t_for_endere_quarterizado.getFen_cidade_quarterizado();
                        est_unifed_quarterizado = t_for_endere_quarterizado.getEst_unifed_quarterizado()==null?"":t_for_endere_quarterizado.getEst_unifed_quarterizado();
                        fen_cep_quarterizado = t_for_endere_quarterizado.getFen_cep_quarterizado();
                        fen_insmun_quarterizado = t_for_endere_quarterizado.getFen_insmun_quarterizado()==null?"":t_for_endere_quarterizado.getFen_insmun_quarterizado();
                        fen_insest_quarterizado = t_for_endere_quarterizado.getFen_insest_quarterizado()==null?"":t_for_endere_quarterizado.getFen_insest_quarterizado();
                        fen_ativo_quarterizado = t_for_endere_quarterizado.getFen_ativo_quarterizado()==null?"":t_for_endere_quarterizado.getFen_ativo_quarterizado();
                        fen_email_quarterizado = t_for_endere_quarterizado.getFen_email_quarterizado()==null?"":t_for_endere_quarterizado.getFen_email_quarterizado();
                        fen_gln_quarterizado = t_for_endere_quarterizado.getFen_gln_quarterizado()==null?"":t_for_endere_quarterizado.getFen_gln_quarterizado();
                        tipo_log_quarterizado = t_for_endere_quarterizado.getTipo_log_quarterizado()==null?"":t_for_endere_quarterizado.getTipo_log_quarterizado();
                        fen_observacao_quarterizado = t_for_endere_quarterizado.getFen_observacao_quarterizado()==null?"":t_for_endere_quarterizado.getFen_observacao_quarterizado();
                        dthr_inclusao = (java.sql.Timestamp)t_for_endere_quarterizado.getDthr_inclusao();
                        dthr_alteracao = (java.sql.Timestamp)t_for_endere_quarterizado.getDthr_alteracao();
                        usuario_inclusao = t_for_endere_quarterizado.getUsuario_inclusao()==null?"":t_for_endere_quarterizado.getUsuario_inclusao();
                        usuario_alteracao = t_for_endere_quarterizado.getUsuario_alteracao()==null?"":t_for_endere_quarterizado.getUsuario_alteracao();
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

            <html:form action="ind/AtelieresQuarterizados_rForm.do" method="post" styleClass="baseForm">
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
