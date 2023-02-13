<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Geração de Romaneio
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(15)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/GeracaoRomaneio_rGrid.do" method="post" styleClass="baseForm">

              <%
              if (request.getAttribute("arquivo")!=null){
                %>
                <table style=width:100%;margin-top:10;>
                  <tr>
                    <td class=columHeader style="text-align:center;">
                      <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                        Clique para baixar o arquivo
                        <img src="../img/rar.gif" />
                      </a>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>

              <%
              java.util.Vector res_Jw_geracao_romaneio_filtro = (java.util.Vector)session.getAttribute("res_Jw_geracao_romaneio_filtro");
              %>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="nfs_serie"/>
                    <html:errors property="nfs_dtemis"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_geracao_romaneio_filtro"/>
                  </td>
                </tr>
              </table>

              <%
              if(res_Jw_geracao_romaneio_filtro != null && res_Jw_geracao_romaneio_filtro.size()>0){
                %>

                <table class="itemGridTable" style='width:99%;' border=1>
                  <tr class="reportHeader" >
                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Empresa
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Nota
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Série
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      <span class="spamFormLabel">
                        Data
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: left">
                      <span class="spamFormLabel">
                        Cliente
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: left">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>

                    <td class="columnTdHeader" style="text-align: center">
                      Possui SKU
                    </td>

                    <td class="columnTdHeader" style="text-align: center; display:none">
                      Preço Final
                      <br>
                      líquido
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_geracao_romaneio_filtro = 0;
                  String style;
                  %>
                  <logic:iterate id="bl_form_Jw_geracao_romaneio_filtro_lines" name="GeracaoRomaneio_rGridActionForm" property="bl_form_Jw_geracao_romaneio_filtro_lines" indexId="indexId">

                    <%
                    Jw_geracao_romaneio_filtro Jw_geracao_romaneio_filtro = (portalbr.dbobj.view.Jw_geracao_romaneio_filtro)res_Jw_geracao_romaneio_filtro.elementAt(i_bl_report_Jw_geracao_romaneio_filtro );
                    if (!((i_bl_report_Jw_geracao_romaneio_filtro %2)!=0)) {
                      style="rowColor";
                    } else {
                      style="rowBlank";
                    }
                    i_bl_report_Jw_geracao_romaneio_filtro ++;
                    if(Jw_geracao_romaneio_filtro.getPossui_sku().equals("N")){
                      style="rowRed";
                    }
                    %>
                    <tr class=<%= style %>>
                      <td class="reportColumn" style="text-align: center">
                        <%
                        if(Jw_geracao_romaneio_filtro.getPossui_sku().equals("N")){
                          %>
                          <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="myhidden" value="true" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                          <%
                        } else {
                          %>
                          <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                          <%
                        }
                        %>

                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="emp_empresa" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getEmp_empresa() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="fil_filial" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getFil_filial() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="nfs_nmro" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getNfs_nmro() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="nfs_serie" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getNfs_serie() %>
                      </td>

                      <td class="reportColumn" style="text-align: center">
                        <html:hidden property="nfs_dtemis" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= com.egen.util.text.FormatDate.format( Jw_geracao_romaneio_filtro.getNfs_dtemis(), "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <html:hidden property="cli_cdgo" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getCli_cdgo() %>
                        -
                        <%= Jw_geracao_romaneio_filtro.getEsc_seqn() %>
                        -
                        <%= Jw_geracao_romaneio_filtro.getCli_rzao() %>
                        <html:hidden property="esc_seqn" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <html:hidden property="cli_rzao" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: left">
                        <html:hidden property="rep_cdgo" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getRep_cdgo() %>
                        -
                        <%= Jw_geracao_romaneio_filtro.getRep_rzao() %>
                        <html:hidden property="rep_rzao" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center; width: 150px" >
                        <%= Jw_geracao_romaneio_filtro.getPossui_sku().equals("N")?"Não foi cadastrado o código SKU para todos os itens da nota. Entre em contato com o Comercial":"Sim" %>
                        <html:hidden property="possui_sku" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                      </td>

                      <td class="reportColumn" style="text-align: center; display:none">
                        <html:hidden property="preco_final_liquido" name="bl_form_Jw_geracao_romaneio_filtro_lines" indexed="true"/>
                        <%= Jw_geracao_romaneio_filtro.getPreco_final_liquido() %>
                      </td>

                    </tr>

                  </logic:iterate>

                </table>

                <%
              }
              %>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <%
                    if(res_Jw_geracao_romaneio_filtro != null && res_Jw_geracao_romaneio_filtro.size()>0){
                      %>
                      <html:submit value="Gerar" styleClass="baseButton" property="gerar_action">
                      </html:submit>
                      <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                      </html:submit>
                      <html:submit value="Dermarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                      </html:submit>
                      <%
                    }
                    %>
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
