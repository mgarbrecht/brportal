<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Pedidos Indenizados / Descontos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(184)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>


                </td>

              </tr>

            </table>

            <%
            acesso.Sessao sessao = new acesso.Sessao(session);
            util.consultas.com.PedidosIndenizadosDescontos pedidosIndenizadosDescontos = new util.consultas.com.PedidosIndenizadosDescontos();
            %>
            <html:form action="com/PedidosIndenizadosDescontosGrid.do" method="post" styleClass="baseForm">
              <%
              int contador = 0;
              %>
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>

                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        são obrigatórios.
                      </div>

                      <div class\='div10l'>
                        Os pedidos marcados com
                        <img src='../img/mark.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        não podem receber descontos, pois contém condição de pagamento Cartão de Crédito ou à vista.
                      </div>

                      <div class\='div10l'>
                        Os pedidos marcados com
                        <img src='../img/aviso.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        possuem modelos que não aceitam descontos.
                      </div>

                    </div>
                    <html:errors property="gridCheckField"/>
                    <html:errors property="ped_nmro"/>
                    <html:errors property="tipo_desconto"/>
                    <html:errors property="ped_obse"/>
                    <html:errors property="valor_desconto"/>
                    <html:errors property="percentual_desc"/>
                    <html:errors property="prazo_adicional"/>
                    <html:errors property="cnd_cdgo"/>
                    <html:errors property="cnd_desc"/>
                    <html:errors property="situacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao"/>
                  </td>
                </tr>
              </table>

              <table class="itemGridTable" style='width:99%;' border='1'>
                <tr class="reportTr">

                  <%
                  if(pedidosIndenizadosDescontos.usuarioLiberado(session)) {
                    %>
                    <td class="columnTdHeader" style="text-align: center">
                    </td>
                    <%
                  }
                  %>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Pedido
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Pedido Afv
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Regional
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: center">
                    <span class="spamFormLabel">
                      Tipo Desconto
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Observação
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: center">
                    <span class="spamFormLabel">
                      Valor
                      <br>
                      Desconto
                    </span>
                    <img src="../img/required.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>

                  <td class="columnTdHeader" style="text-align: left">
                    <span class="spamFormLabel">
                      Condição de Pagamento
                    </span>
                  </td>


                  <td class="columnTdHeader" style="text-align: center">
                    <span class="spamFormLabel">
                      Situação
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: center">
                    <span class="spamFormLabel">
                      Status
                    </span>
                  </td>

                  <td class="columnTdHeader" style="text-align: right">
                    <span class="spamFormLabel">
                      Valor Pedido
                    </span>
                  </td>



                </tr>

                <%
                java.util.Vector res_Pedidos = (java.util.Vector)session.getAttribute("res_Ped_desconto_indenizacao");
                String style="";
                %>
                <logic:iterate id="bl_form_Ped_desconto_indenizacao_lines" name="PedidosIndenizadosDescontosGridActionForm" property="bl_form_Ped_desconto_indenizacao_lines" indexId="indexId">


                  <%
                  if (!((contador%2)!=0)) {
                    style="rowColor";
                  } else {
                    style="rowBlank";
                  }
                  %>
                  <tr class="<%= style %>">

                    <html:hidden property="esc_seqn" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                    <html:hidden property="codigo_marca" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                    <html:hidden property="cli_cdgo" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                    <html:hidden property="banco" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true" styleId="banco"/>
                    <html:hidden property="alterado" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true" styleId="alterado"/>


                    <%
                    portalbr.dbobj.view.Jw_ped_desconto_indenizacao t_ped = (portalbr.dbobj.view.Jw_ped_desconto_indenizacao)res_Pedidos.elementAt(contador);
                    %>




                    <%
                    if(pedidosIndenizadosDescontos.usuarioLiberado(session)) {
                      %>
                      <td class="tdGridField">
                        <html:checkbox property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      </td>
                      <%
                    } else {
                      %>

                      <html:hidden property="gridCheckField" value="false" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>


                      <%
                    }
                    %>



                    <td class="tdGridField" style="width: 100px">
                      <html:hidden property="ped_nmro" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>

                      <%
                      if(t_ped.getAceita_desconto().equalsIgnoreCase("N")){
                        %>
                        <a href="#" onclick="wopen('../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= t_ped.getPed_nmro() %>&noheader&descontos','_blank',1000,500)">
                          <%= t_ped.getPed_nmro() %>
                        </a>
                        <%
                      } else {
                        %>
                        <a href="#" onclick="wopen('../com/ConsultaPedidos_iForm.do?select_action=&pedido_beira_rio=<%= t_ped.getPed_nmro() %>&noheader','_blank',1000,500)">
                          <%= t_ped.getPed_nmro() %>
                        </a>
                        <%
                      }
                      %>

                      <%
                      if(((t_ped.getCnd_cdgo()+"").equals("100"))||((t_ped.getCnd_cdgo()+"").equals("101"))||((t_ped.getCnd_cdgo()+"").equals("102"))||((t_ped.getCnd_cdgo()+"").equals("29"))){
                        %>
                        <img src='../img/mark.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        <%
                      }
                      %>
                      <%
                      if(t_ped.getAceita_desconto().equalsIgnoreCase("N")){
                        %>
                        <img src='../img/aviso.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        <%
                      }
                      %>
                    </td>

                    <td class="tdGridField">
                      <html:hidden property="ped_afv" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      <%= t_ped.getPed_sequencial_maquina()!=null?t_ped.getPed_sequencial_maquina():"" %>
                    </td>

                    <td class="tdGridField">
                      <html:hidden property="codigo_regional" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      <html:hidden property="nome_regional" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      <%= t_ped.getCodigo_regional()!=null?(t_ped.getCodigo_regional()+"-"+t_ped.getNome_regional()):"" %>
                    </td>

                    <td class="tdGridField">
                      <html:hidden property="cliente" styleId="cliente" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      <%= t_ped.getCliente()!=null?t_ped.getCliente():"" %>
                    </td>
                    <%
                    if((t_ped.getAceita_desconto().equalsIgnoreCase("N"))||(t_ped.getSituacao().equals("F"))||((t_ped.getPed_especie_pedido().equals("R"))&& !(pedidosIndenizadosDescontos.usuarioLiberado(session)))||(t_ped.getPed_stat().equals("L"))||(t_ped.getPed_stat().equals("F"))||(t_ped.getPed_stat().equals("C"))||((t_ped.getCnd_cdgo()+"").equals("100"))||((t_ped.getCnd_cdgo()+"").equals("101"))||((t_ped.getCnd_cdgo()+"").equals("102"))||((t_ped.getCnd_cdgo()+"").equals("29"))){
                      %>
                      <td class="tdGridField" style="text-align: center">
                        <html:select property="tipo_desconto" styleId="tipo_desconto" disabled="true" styleClass="disabled" size="1" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true">
                          <html:options property="tipo_descontoList" labelProperty="tipo_descontoLabelList" styleClass="baseOptions" name="bl_form_Ped_desconto_indenizacao_lines" labelName="bl_form_Ped_desconto_indenizacao_lines"/>
                        </html:select>
                      </td>
                      <%
                    } else {
                      %>
                      <td class="tdGridField" style="text-align: center">
                        <html:select property="tipo_desconto" onchange="setarAlterado(this.name);" styleId="tipo_desconto" styleClass="baseField" size="1" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true">
                          <html:options property="tipo_descontoList" labelProperty="tipo_descontoLabelList" styleClass="baseOptions" name="bl_form_Ped_desconto_indenizacao_lines" labelName="bl_form_Ped_desconto_indenizacao_lines"/>
                        </html:select>
                      </td>
                      <%
                    }
                    %>

                    <%
                    if((t_ped.getAceita_desconto().equalsIgnoreCase("N"))||(t_ped.getSituacao().equals("F"))||((t_ped.getPed_especie_pedido().equals("R"))&& !(pedidosIndenizadosDescontos.usuarioLiberado(session)))||(t_ped.getPed_stat().equals("L"))||(t_ped.getPed_stat().equals("F"))||(t_ped.getPed_stat().equals("C"))||((t_ped.getCnd_cdgo()+"").equals("100"))||((t_ped.getCnd_cdgo()+"").equals("101"))||((t_ped.getCnd_cdgo()+"").equals("102"))||((t_ped.getCnd_cdgo()+"").equals("29"))){
                      %>
                      <td class="tdGridField">
                        <html:text property="ped_obse" styleId="ped_obse" readonly="true" styleClass="disabled" size="40" maxlength="800" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      </td>
                      <%
                    } else {
                      %>
                      <td class="tdGridField">
                        <html:text property="ped_obse" styleId="ped_obse" onchange="setarAlterado(this.name);" styleClass="baseField" size="40" maxlength="800" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      </td>
                      <%
                    }
                    %>


                    <%
                    if((t_ped.getAceita_desconto().equalsIgnoreCase("N"))||(t_ped.getSituacao().equals("F"))||((t_ped.getPed_especie_pedido().equals("R"))&& !(pedidosIndenizadosDescontos.usuarioLiberado(session)))||(t_ped.getPed_stat().equals("L"))||(t_ped.getPed_stat().equals("F"))||(t_ped.getPed_stat().equals("C"))||((t_ped.getCnd_cdgo()+"").equals("100"))||((t_ped.getCnd_cdgo()+"").equals("101"))||((t_ped.getCnd_cdgo()+"").equals("102"))||((t_ped.getCnd_cdgo()+"").equals("29"))){
                      %>
                      <td class="tdGridField" style="text-align: center">
                        <html:text property="valor_desconto" styleClass="disabled" readonly="true" size="10" maxlength="22" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      </td>
                      <%
                    } else {
                      %>
                      <td class="tdGridField" style="text-align: center">
                        <html:text property="valor_desconto" styleId="valor_desconto" onchange="setarAlterado(this.name);" styleClass="baseField" size="10" maxlength="22" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                      </td>
                      <%
                    }
                    %>



                    <td class="tdGridField" style="text-align: left">
                      <%= t_ped.getCnd_cdgo()!=null?t_ped.getCnd_cdgo():"" %>
                      -
                      <%= t_ped.getCnd_desc()!=null?t_ped.getCnd_desc():"" %>
                    </td>



                    <td class="tdGridField" style="text-align: center">
                      <html:hidden property="situacao_banco" styleId="situacao_banco" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>


                      <html:hidden property="situacao" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true" />
                      <%
                      if(t_ped.getSituacao().equals("N")){
                        %>
                        Não Indenizado
                        <%
                      }
                      if(t_ped.getSituacao().equals("A")){
                        %>
                        Indenizado
                        <%
                      }
                      if(t_ped.getSituacao().equals("C")){
                        %>
                        Cancelado
                        <%
                      }
                      if(t_ped.getSituacao().equals("F")){
                        %>
                        Confirmado
                        <%
                      }
                      %>

                      <%
                      if(!((t_ped.getPed_stat().equals("F"))||(t_ped.getPed_stat().equals("L")))){
                        %>
                        <%
                        if(t_ped.getSituacao().equals("C")) {
                          %>
                          <input type="button" value="Abrir Solicitação"  onclick="if(confirm('Confirma a operação? (OBS: Todas as alterações não salvas serão perdidas!)')){top.location='../com/PedidosIndenizadosDescontosForm.do?update_pedido2_action=&ped_nmro1=<%= t_ped.getPed_nmro() %>'}">
                          <%
                        }}
                        %>

                      </td>



                      <td class="tdGridField" style="text-align: center">
                        <html:hidden property="status" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                        <%= t_ped.getPed_stat()!=null?t_ped.getPed_stat():"" %>
                      </td>



                      <td class="tdGridField" style="text-align: right">
                        <html:hidden property="valor_pedido" name="bl_form_Ped_desconto_indenizacao_lines" indexed="true"/>
                        <%= com.egen.util.text.FormatNumber.format(t_ped.getValor(), "##,##0.00") %>
                      </td>

                    </tr>

                    <%
                    contador ++;
                    %>
                  </logic:iterate>

                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(pedidosIndenizadosDescontos.usuarioLiberado(session)) {
                        %>
                        <html:submit value="Marcar Todos" styleClass="baseButton" property="marcar_todos_action">
                        </html:submit>
                        <html:submit value="Desmarcar Todos" styleClass="baseButton" property="desmarcar_todos_action">
                        </html:submit>
                        <%
                      }
                      %>

                      <html:submit styleClass="myhidden" property="select_action">
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit accesskey="a" value="Salvar Alterações" styleClass="baseButton" property="update_action">
                      </html:submit>

                      <%
                      if(pedidosIndenizadosDescontos.usuarioLiberado(session)) {
                        %>

                        <html:submit accesskey="j" value="Ajustar Pedidos" onclick="return(confirm('Confirma a operação? (OBS: Todas as alterações não salvas serão perdidas!)'))" styleClass="baseButton" property="ajustar_pedidos_action">
                        </html:submit>
                        <html:submit accesskey="c" value="Cancelar" onclick="return(confirm('Confirma a operação? (OBS: Todas as alterações não salvas serão perdidas!)'))" styleClass="baseButton" property="cancelar_action">
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

              <%
              if(session.getAttribute("ok")!=null) {
                %>
                <script>
                  alert('Registros salvos com sucesso!');
                </script>
                <%
                session.removeAttribute("ok");
              }
              %>


              <%
              if(session.getAttribute("mensagem")!=null) {
                %>
                <script>
                  alert('<%= (String)session.getAttribute("mensagem") %>');
                </script>
                <%
                session.removeAttribute("mensagem");
              }
              %>

              <script>
                function setarAlterado(nome){
                  indice = nome.substring(nome.indexOf('[')+1,nome.indexOf(']'));
                  <% if(((String)session.getAttribute("qtd_itens")).equals("1")){ %>
                  document.forms[0].alterado.value='S';
                  <% } else { %>
                  document.forms[0].alterado[indice].value='S';
                  <% } %>
                }
              </script>
              <html:form action="com/PedidosIndenizadosDescontosForm.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="ped_nmro1"/>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit styleClass="myhidden" property="update_pedido_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit accesskey="u" styleClass="myhidden" property="update_pedido1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:submit styleClass="myhidden" property="update_pedido2_action">
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
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
