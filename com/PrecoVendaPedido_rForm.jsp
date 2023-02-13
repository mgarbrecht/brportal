<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Alterar Preço de Venda no Pedido
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(265)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PrecoVendaPedido_rGrid.do" method="post" styleClass="baseForm">
              <%
              String styleControle;
              java.util.Vector res_Jw_preco_venda_pedido = (java.util.Vector)session.getAttribute("res_Jw_preco_venda_pedido");
              int i = 0;
              %>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="gridCheckField"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="esc_seqn"/>
                    <html:errors property="ped_daem"/>
                    <html:errors property="ite_seqn"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="ped_ped_cliente"/>
                    <html:errors property="ite_preco_venda"/>
                    <html:errors property="ite_preco_venda_novo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_preco_venda_pedido"/>
                  </td>
                </tr>
              </table>

              <%
              if(res_Jw_preco_venda_pedido!=null && res_Jw_preco_venda_pedido.size()>0){
                %>

                <table class="reportTable" style='width:99%;' border=1>
                  <tr class="reportTr">

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Pedido
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Cliente
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Seq.
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Dt. Emissão
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Item
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Linha
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Ref.
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Cabedal
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Cor
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        OC
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Preço Venda
                      </span>
                    </td>

                    <td class="columnTdHeader">
                      <span class="spamFormLabel">
                        Preço Venda Novo
                      </span>
                    </td>

                  </tr>


                  <logic:iterate id="bl_form_Jw_preco_venda_pedido_lines" name="PrecoVendaPedido_rGridActionForm" property="bl_form_Jw_preco_venda_pedido_lines" indexId="indexId">

                    <%
                    Jw_preco_venda_pedido controle = (Jw_preco_venda_pedido)res_Jw_preco_venda_pedido.elementAt(i);
                    if (!((i%2)!=0)) {
                      styleControle="rowColor";
                    } else {
                      styleControle="rowBlank";
                    }
                    %>


                    <tr class="<%= styleControle %>">

                      <td class="reportColumn">
                        <html:hidden property="ped_nmro" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ped_nmro"/>
                        <%= controle.getPed_nmro() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="cli_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="cli_cdgo"/>
                        <%= controle.getCli_cdgo() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="esc_seqn" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="esc_seqn"/>
                        <%= controle.getEsc_seqn() %>
                      </td>

                      <html:hidden property="cli_rzao" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="cli_rzao"/>
                      <td class="reportColumn">
                        <html:hidden property="ped_daem" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ped_daem"/>
                        <%= com.egen.util.text.FormatDate.format(controle.getPed_daem(), "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="ite_seqn" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ite_seqn"/>
                        <%= controle.getIte_seqn() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="lin_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="lin_cdgo"/>
                        <%= controle.getLin_cdgo() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="ref_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ref_cdgo"/>
                        <%= controle.getRef_cdgo() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="cab_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="cab_cdgo"/>
                        <%= controle.getCab_cdgo() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="cor_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="cor_cdgo"/>
                        <%= controle.getCor_cdgo() %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="ped_ped_cliente" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ped_ped_cliente"/>
                        <%= controle.getPed_ped_cliente()!=null?controle.getPed_ped_cliente():"" %>
                      </td>

                      <td class="reportColumn">
                        <html:hidden property="ite_preco_venda" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="ite_preco_venda"/>
                        <%= com.egen.util.text.FormatNumber.format(controle.getIte_preco_venda(), "##,##0.00") %>
                      </td>

                      <td class="reportColumn">
                        <html:text property="ite_preco_venda_novo" styleId="ite_preco_venda_novo" styleClass="baseField" size="12" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true"/>
                      </td>

                      <html:hidden property="rep_cdgo" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="rep_cdgo"/>
                      <html:hidden property="codigo_regional" name="bl_form_Jw_preco_venda_pedido_lines" indexed="true" styleId="codigo_regional"/>
                    </tr>
                    <%
                    i++;
                    %>

                  </logic:iterate>

                </table>


                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit accesskey="a" value="Alterar Preços" onclick="return confirmSubmit('');" styleClass="baseButton" property="update_action">
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>


                <%
              } else {
                %>




                <table width="100%">
                  <tr>
                    <td style="text-align: center; color: red">

                      <big>
                        <b>
                          Nenhum registro foi encontrado!
                        </b>
                      </big>
                    </td>
                  </tr>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit accesskey="a" value="Alterar Preços" styleClass="myhidden" property="update_action">
                      </html:submit>
                      <html:submit accesskey="a" styleClass="baseButton" property="back_action">
                        <bean:message bundle="ApplicationResources" key="jsp.back"/>
                      </html:submit>
                    </td>
                  </tr>
                </table>

                <%
              }
              %>



            </html:form>


          </td>
        </tr>
      </table>

    </body>
  </center>
</html>
