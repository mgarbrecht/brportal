<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Duplicatas e Impressão de Duplicatas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(83)){
                    //response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/ImpressaoDuplicatas_rForm.do" method="post" styleClass="baseForm">
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

            </html:form>
            <html:form action="adm/ImpressaoDuplicatas_rGrid.do" method="post" styleClass="baseForm">

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
                    <html:errors property="tit_status"/>
                    <html:errors property="nota"/>
                    <html:errors property="serie"/>
                    <html:errors property="desc_sit"/>
                    <html:errors property="tip_codigo1"/>
                    <html:errors property="tit_datvenc1"/>
                    <html:errors property="tit_valor"/>
                    <html:errors property="tit_vlrec"/>
                    <html:errors property="prt_descri"/>
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

                    <td class="columnTdHeader" style="text-align: center">
                      Título
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Status
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Nota Fiscal
                    </td>

                    <td class="columnTdHeader"  style="text-align: center">
                      Situação
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Tipo
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
                      Portador
                    </td>

                  </tr>

                  <%
                  String style="";
                  int i_bl_report_Jw_t_titulos_lista = 0;
                  %>
                  <logic:iterate id="bl_form_Jw_t_titulos_lista_lines" name="ImpressaoDuplicatas_rGridActionForm" property="bl_form_Jw_t_titulos_lista_lines" indexId="indexId">
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

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getTit_codigo() %>
                        <html:hidden property="tit_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getTit_status() %>
                        <html:hidden property="tit_status" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getNota() %>
                        -
                        <%= lista.getSerie() %>
                        <html:hidden property="nota"  name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <html:hidden property="serie" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getDesc_sit() %>
                        <html:hidden  property="desc_sit" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <%= lista.getTip_codigo() %>
                        <html:hidden property="tip_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <%= com.egen.util.text.FormatDate.format(lista.getTit_datvenc(), "dd/MM/yyyy") %>
                        <html:hidden property="tit_datvenc1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: right">
                        <%= lista.getTit_valor() %>
                        <html:hidden property="tit_valor"  name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: right">
                        <%= lista.getTit_vlrec() %>
                        <html:hidden property="tit_vlrec" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <%= lista.getPrt_descri() %>
                        <html:hidden property="prt_descri" name="bl_form_Jw_t_titulos_lista_lines" indexed="true"/>
                      </td>

                      <html:hidden property="tit_numbco" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_numbco"/>
                      <html:hidden property="tit_datrec" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_datrec"/>
                      <html:hidden property="tit_datemi" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_datemi"/>
                      <html:hidden property="tit_dspont" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_dspont"/>
                      <html:hidden property="tit_dsante" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_dsante"/>
                      <html:hidden property="prt_codigo1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="prt_codigo1"/>
                      <html:hidden property="emp_empresa2" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="emp_empresa2"/>
                      <html:hidden property="fil_filial1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="fil_filial1"/>
                      <html:hidden property="ncc" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="ncc"/>
                      <html:hidden property="taxa_juro" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="taxa_juro"/>
                      <html:hidden property="trn_codigo" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="trn_codigo"/>
                      <html:hidden property="mov_data" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="mov_data"/>
                      <html:hidden property="datvenc" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="datvenc"/>
                      <html:hidden property="cobjur" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="cobjur"/>
                      <html:hidden property="tit_abatim" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_abatim"/>
                      <html:hidden property="vnc_cartor" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="vnc_cartor"/>
                      <html:hidden property="dif" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="dif"/>
                      <html:hidden property="condes" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="condes"/>
                      <html:hidden property="rep_codigo" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="rep_codigo"/>
                      <html:hidden property="data_atual" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="data_atual"/>
                      <html:hidden property="ped_nmro" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="ped_nmro"/>
                      <html:hidden property="w_liq1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="w_liq1"/>
                      <html:hidden property="w_saldo_tot1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="w_saldo_tot1"/>
                      <html:hidden property="w_valor_tot1" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="w_valor_tot1"/>
                      <html:hidden property="pedido" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="pedido"/>
                      <html:hidden property="vendor" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="vendor"/>
                      <html:hidden property="tit_datven3" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="tit_datven3"/>
                      <html:hidden property="cnpj" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="cnpj"/>
                      <html:hidden property="cnpj_sem_formato" name="bl_form_Jw_t_titulos_lista_lines" indexed="true" styleId="cnpj_sem_formato"/>

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
                      <html:submit value="Imprimir Duplicatas" styleClass="baseButton" property="update_action">
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
            <html:form action="adm/ImpressaoDuplicatas_rForm.do" method="post" styleClass="baseForm">
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
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
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
