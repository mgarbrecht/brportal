<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
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
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(12)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/ImpressaoDuplicatasNV_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="nome"/>
                    <html:errors property="bairro"/>
                    <html:errors property="cidade_uf"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <%
              if(session.getAttribute("mostrar_grupo")!=null || ((acesso.Usuario)session.getAttribute("User")).isTipo("CLIENTE MERCADO INTERNO") ){
                %>


                <html:hidden property="codigo"/>
                <html:hidden property="nome"/>
                <html:hidden property="bairro"/>
                <html:hidden property="cidade_uf"/>
                <html:hidden property="emp_empresa"/>

                <%
              } else {
                %>
                <table class="itemTable"  style="width:99%;">
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Código
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo" styleClass="disabled" tabindex="-1" readonly="true"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Nome
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="nome" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Bairro
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="bairro" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cidade-UF
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cidade_uf" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <html:hidden property="emp_empresa"/>
                </table>

                <%
              }
              %>

            </html:form>
            <html:form action="adm/ImpressaoDuplicatasNV_rGrid.do" method="post"  styleClass="baseForm">
              <%
              if(request.getAttribute("erro")!=null) {
                %>
                <script>
                  alert('Não é possível gerar duplicatas de mais de um portador ao mesmo tempo!');
                </script>
                <%
              }
              %>

              <%
              java.util.Vector res_Jw_t_titulos_lista= (java.util.Vector)session.getAttribute("res_Jw_t_titulos_lista");
              %>


              <%
              if((String)request.getAttribute("abre_automaticamente")=="N"){
                %>
                <table style=width:100%;margin-top:10;>
                  <tr>
                    <td class=columHeader style="text-align:center;">
                      <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                        <bean:message key="report.downloadpdf"/>
                      </a>
                      <br>
                      <br>
                      <div style="color: #c40000; font-size: 16px">
                        Atenção: Para sua segurança, verifique se a linha digitável do boleto impresso corresponde a informação que consta na linha digitável da tela.
                      </div>
                      <br>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>


              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="tit_codigo1"/>
                    <html:errors property="tip_codigo1"/>
                    <html:errors property="tit_datvenc1"/>
                    <html:errors property="tit_valor"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_t_titulos_lista"/>
                  </td>
                </tr>
              </table>

              <%
              if(res_Jw_t_titulos_lista !=null && res_Jw_t_titulos_lista.size()>0){
                %>

                <table class="reportTable" style='width:99%;' border="1">
                  <tr class="reportHeader" >
                    <td class="columnTdHeader">
                    </td>

                    <td class="columnTdHeader" style="text-align: center; width: 1%">
                      Portador
                    </td>

                    <td class="columnTdHeader" style="text-align: left">
                      Cliente
                    </td>

                    <%
                    if(((acesso.Usuario)session.getAttribute("User")).isTipo("AREAS") || user.isSuperUsuario()) {
                      %>

                      <td class="columnTdHeader" style="text-align: center">
                        Carteira
                      </td>

                      <td class="columnTdHeader" style="text-align: center">
                        Situação
                      </td>

                      <%
                    }
                    %>


                    <td class="columnTdHeader" style="text-align: center">
                      Título
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Nota Fiscal
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Vencto.
                    </td>

                    <td class="columnTdHeader" style="text-align: right">
                      Saldo
                    </td>

                    <td class="columnTdHeader" style="text-align: right">
                      Valor
                    </td>

                    <td class="columnTdHeader" style="text-align: left">
                      Linha Digitável
                    </td>

                  </tr>

                  <%
                  String style="";
                  int i_bl_report_Jw_t_titulos_lista = 0;
                  %>
                  <logic:iterate id="bl_form_Jw_t_titulos_lista_lines" name="ImpressaoDuplicatasNV_rGridActionForm" property="bl_form_Jw_t_titulos_lista_lines" indexId="indexId">
                    <%
                    Jw_t_titulos_lista lista = (Jw_t_titulos_lista)res_Jw_t_titulos_lista.elementAt(i_bl_report_Jw_t_titulos_lista);

                    if (!((i_bl_report_Jw_t_titulos_lista%2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    %>
                    <tr  class=<%= style %> >
                      <td class="reportColumn" style="text-align: center">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <%
                        if(lista.getPrt_codigo().equalsIgnoreCase("001")){
                          %>
                          <img src="../img/logo-banco-do-brasilp.jpg" />
                          <%
                        }
                        %>
                        <%
                        if(lista.getPrt_codigo().equalsIgnoreCase("033")){
                          %>
                          <img src="../img/logo-santanderp.jpg" />
                          <%
                        }
                        %>
                        <%
                        if(lista.getPrt_codigo().equalsIgnoreCase("237")){
                          %>
                          <img src="../img/logo-bradescop.jpg" />
                          <%
                        }
                        %>
                        <%
                        if(lista.getPrt_codigo().equalsIgnoreCase("041")){
                          %>
                          <img src="../img/logo-banrisulp.jpg" />
                          <%
                        }
                        %>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <%= lista.getCli_codigo()+"-"+lista.getEsc_seqn()+" - " + lista.getCli_rzao() %>
                      </td>

                      <%
                      if(((acesso.Usuario)session.getAttribute("User")).isTipo("AREAS") || user.isSuperUsuario()) {
                        %>

                        <td class="reportColumn" style="text-align: center">
                          <%= lista.getCac_sequencia() %>
                        </td>

                        <td class="reportColumn" style="text-align: center">
                          <%= lista.getDesc_sit() %>
                        </td>

                        <%
                      }
                      %>

                      <td class="reportColumn" style="text-align: center">

                        <%
                        if(((acesso.Usuario)session.getAttribute("User")).isTipo("AREAS") || user.isSuperUsuario()) {
                          %>
                          <a href="../adm/TitulosForm.do?select2_action=&tit_codigo=<%= lista.getTit_codigo() %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= lista.getTit_codigo() %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= lista.getTit_codigo() %>
                          <%
                        }
                        %>

                        <html:hidden property="tit_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getNota() %>
                        -
                        <%= lista.getSerie() %>
                      </td>

                      <html:hidden property="tip_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>

                      <td class="reportColumn" style="text-align: center">
                        <%= com.egen.util.text.FormatDate.format(lista.getTit_datvenc(), "dd/MM/yyyy") %>
                        <html:hidden property="tit_datvenc1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: right">
                        <%= com.egen.util.text.FormatNumber.format(lista.getTit_valor(), "##,##0.00") %>
                        <html:hidden property="tit_valor" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: right">
                        <%= com.egen.util.text.FormatNumber.format(lista.getTit_vlrec(), "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <%= lista.getLinha_digitavel()!=null ? lista.getLinha_digitavel() : "" %>
                      </td>

                      <html:hidden property="prt_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="prt_codigo1"/>
                      <html:hidden property="emp_empresa2" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="emp_empresa2"/>
                      <html:hidden property="fil_filial1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="fil_filial1"/>

                      <%
                      i_bl_report_Jw_t_titulos_lista++;
                      %>
                    </tr>

                  </logic:iterate>

                </table>
                <%
              } else {
                %>
                <table width="100%">
                  <tr>
                    <td style="text-align: center; font-color: red">

                      <big>
                        <b>
                          Nenhuma duplicata encontrada!
                        </b>
                      </big>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>

                    <%
                    if(res_Jw_t_titulos_lista !=null && res_Jw_t_titulos_lista.size()>0){
                      %>
                      <html:submit value="Imprimir Duplicatas" styleClass="baseButton" property="update_action" onclick="bloqueia();">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <%
                    } else {
                      %>
                      <html:submit value="Imprimir Duplicatas" styleClass="myhidden" property="update_action">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="myhidden" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Desmarcar Todos" styleClass="myhidden" property="desmarcar_todos_action">
                      </html:submit>
                      <%
                    }
                    %>
                    <html:submit accesskey="a" styleClass="baseButton" property="back1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <html:form action="adm/ImpressaoDuplicatasNV_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_registros"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <html:hidden property="esc_seqn"/>
                <html:hidden property="situacao"/>
                <html:hidden property="dt_venc"/>
                <html:hidden property="cli_cdgo"/>
                <html:hidden property="w_liq"/>
                <html:hidden property="w_saldo_tot"/>
                <html:hidden property="w_valor_tot"/>
                <html:hidden property="emp_empresa1"/>
                <html:hidden property="fil_filial"/>
                <html:hidden property="tip_codigo"/>
                <html:hidden property="tit_codigo"/>
                <html:hidden property="valor"/>
                <html:hidden property="prt_codigo"/>
                <html:hidden property="tit_datvenc"/>
                <html:hidden property="cac_sequencia"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <%
                    if(!(request.getParameter("excel")+"").equals("true")){
                      %>
                      <html:button accesskey="b" onclick="history.go(-1);" styleClass="myhidden" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:button>
                      <%
                    }
                    %>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key=""/>
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
