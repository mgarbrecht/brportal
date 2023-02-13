<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvPedidosIndenizadosDescontosLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:100%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="ped_nmro1"/>
                    <html:errors property="nota_fiscal"/>
                    <html:errors property="serie"/>
                    <html:errors property="erros"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos_1"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:100%;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedido
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ped_nmro1" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Nota Fiscal
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="nota_fiscal" styleId="nota_fiscal" styleClass="baseField" cols="40" rows="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Série
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="serie" styleId="serie" styleClass="baseField" size="4"/>
                  </td>
                </tr>

                <html:hidden property="cli_cdgo"/>
                <html:hidden property="esc_seqn"/>
                <html:hidden property="pedido"/>
                <%
                if(session.getAttribute("LvPedidosIndenizadosDescontosErros") != null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                      </span>
                    </td>
                    <td class="formField">
                      <html:textarea property="erros" styleId="erros" style="color: white; background-color:#FF0000; font-size:14; padding: 5px; width: 100%; text-align:center;" styleClass="baseField" value="<%= session.getAttribute("LvPedidosIndenizadosDescontosErros") != null ? (String)session.getAttribute("LvPedidosIndenizadosDescontosErros"): "" %>" cols="80" rows="2"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>

                  <tr class="itemTr">
                    <td class="formLabel" >
                      <span class="spamFormLabel">
                      </span>
                    </td>
                    <td class="formField">
                      <div style="width: 800px">
                      </div>
                      <html:hidden property="erros" styleId="erros" />
                    </td>
                  </tr>


                  <%
                }
                %>
              </table>

              <table class="buttonTable" style='width:100%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                    </html:submit>
                    <%
                    java.util.Vector res_Jw_pedidos_indenizados_descontos = (java.util.Vector)session.getAttribute("res_Jw_pedidos_indenizados_descontos");
                    if(res_Jw_pedidos_indenizados_descontos != null && res_Jw_pedidos_indenizados_descontos.size() >0) {
                      %>
                      <html:button accesskey="a" onclick="if(!confirm('Confirma essa Operação?')){return false;}document.forms[1].update_action.click();" styleClass="baseButton" property="update1_action">
                        Salvar Alterações
                      </html:button>
                      <%
                    }
                    %>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["ped_nmro1"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <html:form action="lov/LvPedidosIndenizadosDescontosGrid.do" method="post" styleClass="baseForm">

              <script type="text/javascript">
                function setLov(PED_NMRO) {
                  <% {
                    String returnBlock = "0";
                    String return0 = null;
                    if (request.getParameter("returnBlock")!=null) {
                      returnBlock = request.getParameter("returnBlock");
                      session.setAttribute("returnBlock",returnBlock);
                      return0 = session.getAttribute("return0")!=null?((String)session.getAttribute("return0")):null;
                      session.setAttribute("return0",return0);
                      session.setAttribute("ge_LovPage", "LvPedidosIndenizadosDescontosLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvPedidosIndenizadosDescontosLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                    }
                    return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) {opener.document.forms[returnBlock].<%= return0 %>.value=PED_NMRO; };
                    <%}%>
                    opener.document.forms[returnBlock].update_action.click();
                    window.close();
                  }
                  <% } %>
                </script>

                <%
                double valor = 0d;
                if(session.getAttribute("LvPedidosIndenizadosValorTotalDesconto") != null) {
                  valor =  (Double)session.getAttribute("LvPedidosIndenizadosValorTotalDesconto");
                  session.removeAttribute("LvPedidosIndenizadosValorTotalDesconto");
                  %>
                  <script>
                    javascript:setLov('<%= valor %>');
                  </script>

                  <%
                }
                %>


                <%
                java.util.Vector res_Jw_pedidos_indenizados_descontos = (java.util.Vector)session.getAttribute("res_Jw_pedidos_indenizados_descontos");
                if(res_Jw_pedidos_indenizados_descontos != null && res_Jw_pedidos_indenizados_descontos.size() >0) {
                  %>

                  <!--
                    <table class="messageTable" style='width:100%;'> <tr class="messageTr" > <td class="messageTd"> <bean:message key="div.campos*"/> <html:errors property="gridCheckField"/> <html:errors property="lin_cdgo"/> <html:errors property="ref_cdgo"/> <html:errors property="cab_cdgo"/> <html:errors property="cab_desc"/> <html:errors property="cor_cdgo"/> <html:errors property="cor_desc"/> <html:errors property="quantidade"/> <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_pedidos_indenizados_descontos"/> </td> </tr> </table>
                  -->


                  <table class="reportTable" style='width:100%;'>
                    <tr class="reportTr">
                      <!--
                        <td class="columnTdHeader"> <span class="spamFormLabel"> </span> </td>
                      -->

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Ped./Item
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Linha/Ref.
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Cabedal
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Cor
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Motivo Troca
                        </span>
                      </td>

                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Observação
                        </span>
                      </td>


                      <td class="columnTdHeader" style="text-align: left">
                        <span class="spamFormLabel">
                          Qtd.
                        </span>
                      </td>

                    </tr>

                    <%
                    int contador = 0;
                    int i_bl_report_Jw_pedidos_indenizados_descontos = 0;
                    %>

                    <logic:iterate id="bl_form_Jw_pedidos_indenizados_descontos_lines" name="LvPedidosIndenizadosDescontosGridActionForm" property="bl_form_Jw_pedidos_indenizados_descontos_lines" indexId="indexId">

                      <%
                      portalbr.dbobj.view.Jw_pedidos_indenizados_descontos t_ped = (portalbr.dbobj.view.Jw_pedidos_indenizados_descontos)res_Jw_pedidos_indenizados_descontos.elementAt(contador);
                      %>
                      <%
                      String style_bl_report_Jw_pedidos_indenizados_descontos="";
                      %>
                      <%
                      if (!((i_bl_report_Jw_pedidos_indenizados_descontos%2)!=0)) {
                        style_bl_report_Jw_pedidos_indenizados_descontos="rowColor";
                      } else {
                        style_bl_report_Jw_pedidos_indenizados_descontos="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_pedidos_indenizados_descontos %>'>
                        <!--
                          <td class="reportColumn">
                        -->
                        <html:hidden property="gridCheckField" styleId="gridCheckField" styleClass="baseField" value="true" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                        <!--
                          </td>
                        -->

                        <td class="reportColumn" style="text-align: left">
                          <html:hidden property="ped_nmro" styleId="ped_nmro" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <html:hidden property="ite_seqn" styleId="ite_seqn" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <html:hidden property="ite_prco" styleId="ite_prco" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <html:hidden property="desconto_comercial" styleId="desconto_comercial" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <html:hidden property="desconto_promocional" styleId="desconto_promocional" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <html:hidden property="ite_prco_descontos" styleId="ite_prco_descontos" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>


                          <%= t_ped.getPed_nmro() %>
                          -
                          <%= t_ped.getIte_seqn() %>
                        </td>

                        <td class="reportColumn" style="text-align: left">
                          <html:hidden property="lin_cdgo" styleId="lin_cdgo" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <%= t_ped.getLin_cdgo() %>
                          .
                          <%= t_ped.getRef_cdgo() %>
                        </td>

                        <html:hidden property="ref_cdgo" styleId="ref_cdgo" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>

                        <td class="reportColumn" style="text-align: left">
                          <html:hidden property="cab_cdgo" styleId="cab_cdgo" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <%= t_ped.getCab_cdgo() %>
                          -
                          <%= t_ped.getCab_desc() %>
                        </td>
                        <html:hidden property="cab_desc" styleId="cab_desc" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>

                        <td class="reportColumn" style="text-align: left">
                          <html:hidden property="cor_cdgo" styleId="cor_cdgo" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          <%= t_ped.getCor_cdgo() %>
                          -
                          <%= t_ped.getCor_desc() %>
                        </td>

                        <html:hidden property="cor_desc" styleId="cor_desc" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>

                        <td class="reportColumn" style="text-align: left">
                          <html:select property="codigo_motivo_troca" styleId="codigo_motivo_troca" styleClass="baseField" size="1" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true" style="font-size: 10px">
                            <html:options property="codigo_motivo_trocaList" labelProperty="codigo_motivo_trocaLabelList" styleClass="baseOptions" name="bl_form_Jw_pedidos_indenizados_descontos_lines" labelName="bl_form_Jw_pedidos_indenizados_descontos_lines"/>
                          </html:select>
                        </td>

                        <td class="reportColumn" style="text-align: left">
                          <html:text property="observacao" styleId="observacao" styleClass="baseField" size="25" maxlength="240" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                        </td>

                        <td class="reportColumn" style="text-align: left">
                          <html:text property="quantidade" styleId="quantidade" styleClass="baseField" size="5" maxlength="22" name="bl_form_Jw_pedidos_indenizados_descontos_lines" indexed="true"/>
                          x
                          <%= com.egen.util.text.FormatNumber.format(t_ped.getIte_prco_descontos(), "##,##0.00") %>
                        </td>


                        <!--
                          <td class="reportColumn" style="text-align:left;"> <a href="javascript:setLov('<%= t_ped.getPed_nmro() %>')" style="cursor:hand"> <%= t_ped.getPed_nmro() %> </a> </td>
                        -->

                      </tr>

                      <%
                      i_bl_report_Jw_pedidos_indenizados_descontos++;
                      %>
                      <%
                      contador++;
                      %>

                    </logic:iterate>

                  </table>

                  <table class="buttonTable" style='width:100%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:submit accesskey="s" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <html:submit accesskey="u" styleId="update_action" styleClass="myhidden" property="update_action" >
                          <bean:message bundle="ApplicationResources" key="jsp.update"/>
                        </html:submit>
                        <html:button accesskey="f" onclick="javascript:setLov('<%= (session.getAttribute('LvPedidosIndenizadosValorTotalDesconto')!=null?(Double)session.getAttribute('LvPedidosIndenizadosValorTotalDesconto'):'') %>');" styleClass="myhidden" property="close_action">
                          <bean:message bundle="ApplicationResources" key="jsp.close"/>
                        </html:button>
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
