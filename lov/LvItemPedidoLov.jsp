<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body onload="document.forms[0].pedido.value = opener.document.forms[0].pedido.value">
      <table class="mainTable" style='width:600px;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvItemPedidoLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:600px;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    <b>
                      Lista de Valores Item Pedido
                    </b>

                  </td>

                </tr>

              </table>

              <table class="messageTable" style='width:600px;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="linha"/>
                    <html:errors property="referencia"/>
                    <html:errors property="cabedal"/>
                    <html:errors property="cor"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_item_pedido"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:600px;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="linha" styleId="linha" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referencia
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="referencia" styleId="referencia" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cabedal" styleId="cabedal" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor" styleId="cor" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <html:hidden property="pedido"/>
              </table>

              <table class="buttonTable" style='width:600px;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <%
            {
              %>

              <%
              java.util.Vector res_Jw_item_pedido = (java.util.Vector)session.getAttribute("res_Jw_item_pedido");
              %>

              <form  name="bl_report_Jw_item_pedido" id="bl_report_Jw_item_pedido" class="baseForm" method="post" >
                <%
                if (res_Jw_item_pedido!=null && res_Jw_item_pedido.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_item_pedido"  class="reportTable"   style="width:600px; "  >
                    <%
                    int sequencial =  0;
                    int codigo_linha =  0;
                    java.lang.String linha =  null;
                    int codigo_referencia =  0;
                    java.lang.String referencia =  null;
                    int codigo_cabedal =  0;
                    java.lang.String cabedal =  null;
                    int codigo_cor =  0;
                    java.lang.String cor =  null;
                    java.lang.String descricao_item =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Sequencial
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Codigo_linha
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Linha
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Codigo_referencia
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Referencia
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Codigo_cabedal
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cabedal
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Codigo_cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Cor
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descricao_item
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Jw_item_pedido = 0;
                    while (i_bl_report_Jw_item_pedido<res_Jw_item_pedido.size()) {
                      portalbr.dbobj.view.Jw_item_pedido t_jw_item_pedido = (portalbr.dbobj.view.Jw_item_pedido)res_Jw_item_pedido.elementAt(i_bl_report_Jw_item_pedido);
                      sequencial = t_jw_item_pedido.getSequencial();
                      codigo_linha = t_jw_item_pedido.getCodigo_linha();
                      linha = t_jw_item_pedido.getLinha()==null?"":t_jw_item_pedido.getLinha();
                      codigo_referencia = t_jw_item_pedido.getCodigo_referencia();
                      referencia = t_jw_item_pedido.getReferencia()==null?"":t_jw_item_pedido.getReferencia();
                      codigo_cabedal = t_jw_item_pedido.getCodigo_cabedal();
                      cabedal = t_jw_item_pedido.getCabedal()==null?"":t_jw_item_pedido.getCabedal();
                      codigo_cor = t_jw_item_pedido.getCodigo_cor();
                      cor = t_jw_item_pedido.getCor()==null?"":t_jw_item_pedido.getCor();
                      descricao_item = t_jw_item_pedido.getDescricao_item()==null?"":t_jw_item_pedido.getDescricao_item();
                      String style_bl_report_Jw_item_pedido="";
                      if (!((i_bl_report_Jw_item_pedido%2)!=0)) {
                        style_bl_report_Jw_item_pedido="rowColor";
                      } else {
                        style_bl_report_Jw_item_pedido="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_item_pedido %>' id="TRbl_report_Jw_item_pedido<%=i_bl_report_Jw_item_pedido%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= sequencial %>','<%= linha %>','<%= referencia %>','<%= cabedal %>','<%= cor %>')" style="cursor:hand">
                            <%= sequencial %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= codigo_linha %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= sequencial %>','<%= descricao_item %>')">
                            <%= linha %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= codigo_referencia %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= referencia %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= codigo_cabedal %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cabedal %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= codigo_cor %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= cor %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= descricao_item %>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_item_pedido++;
                      if (i_bl_report_Jw_item_pedido<res_Jw_item_pedido.size()) {
                        t_jw_item_pedido = (portalbr.dbobj.view.Jw_item_pedido)res_Jw_item_pedido.elementAt(i_bl_report_Jw_item_pedido);
                        sequencial = t_jw_item_pedido.getSequencial();
                        codigo_linha = t_jw_item_pedido.getCodigo_linha();
                        linha = t_jw_item_pedido.getLinha()==null?"":t_jw_item_pedido.getLinha();
                        codigo_referencia = t_jw_item_pedido.getCodigo_referencia();
                        referencia = t_jw_item_pedido.getReferencia()==null?"":t_jw_item_pedido.getReferencia();
                        codigo_cabedal = t_jw_item_pedido.getCodigo_cabedal();
                        cabedal = t_jw_item_pedido.getCabedal()==null?"":t_jw_item_pedido.getCabedal();
                        codigo_cor = t_jw_item_pedido.getCodigo_cor();
                        cor = t_jw_item_pedido.getCor()==null?"":t_jw_item_pedido.getCor();
                        descricao_item = t_jw_item_pedido.getDescricao_item()==null?"":t_jw_item_pedido.getDescricao_item();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(SEQUENCIAL,LINHA,REFERENCIA,CABEDAL,COR) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      String return1 = null;
                      String return2 = null;
                      String return3 = null;
                      String return4 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                        session.setAttribute("return1",return1);
                        return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                        session.setAttribute("return2",return2);
                        return3 = ((request.getParameter("return3")!=null)?request.getParameter("return3"):null);
                        session.setAttribute("return3",return3);
                        return4 = ((request.getParameter("return4")!=null)?request.getParameter("return4"):null);
                        session.setAttribute("return4",return4);
                        session.setAttribute("ge_LovPage", "LvItemPedidoLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvItemPedidoLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                        return3 = ((session.getAttribute("return3")!=null)?(String)session.getAttribute("return3"):null);
                        return4 = ((session.getAttribute("return4")!=null)?(String)session.getAttribute("return4"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=SEQUENCIAL; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=LINHA; };
                      <%}%>
                      <% if (return2!=null && return2.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=REFERENCIA; };
                      <%}%>
                      <% if (return3!=null && return3.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return3%>!=null) { opener.document.forms[returnBlock].<%= return3 %>.value=CABEDAL; };
                      <%}%>
                      <% if (return4!=null && return4.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return4%>!=null) { opener.document.forms[returnBlock].<%= return4 %>.value=COR; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(SEQUENCIAL,DESCRICAO_ITEM) {
                      <% {
                        String returnBlock = "0";
                        String return0 = null;
                        String return1 = null;
                        if (request.getParameter("returnBlock")!=null) {
                          returnBlock = request.getParameter("returnBlock");
                          session.setAttribute("returnBlock",returnBlock);
                          return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                          session.setAttribute("return0",return0);
                          return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                          session.setAttribute("return1",return1);
                          session.setAttribute("ge_LovPage", "LvItemPedidoLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvItemPedidoLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=SEQUENCIAL; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO_ITEM; };
                        <%}%>
                        window.close();
                      }
                      <% } %>
                    </script>

                  </form>
                  <%
                }
                %>

              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>
