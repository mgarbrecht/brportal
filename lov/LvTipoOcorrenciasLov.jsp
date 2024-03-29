<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvTipoOcorrenciasLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    <b>
                      Lista de Valores - Tipo de Ocorrências
                    </b>

                  </td>

                </tr>

              </table>

              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="descricao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tipo_ocorrencia"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo" styleId="codigo" styleClass="baseField" size="10" maxlength="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Descrição
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="descricao" styleId="descricao" styleClass="baseField" size="60" maxlength="255"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:500;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action">
                      <bean:message bundle="ApplicationResources" key="jsp.close"/>
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["codigo"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Tipo_ocorrencia = (java.util.Vector)session.getAttribute("res_Tipo_ocorrencia");
              %>

              <form  name="bl_report_Tipo_ocorrencia" id="bl_report_Tipo_ocorrencia" class="baseForm" method="post" >
                <%
                if (res_Tipo_ocorrencia!=null && res_Tipo_ocorrencia.size()>0) {
                  %>

                  <table id="TRbl_report_Tipo_ocorrencia"  class="reportTable"   style="width:500; "  >
                    <%
                    int cODIGO =  0;
                    java.lang.String dESCRICAO =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Tipo
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Descrição
                      </td>

                    </tr>

                    <%
                    int i_bl_report_Tipo_ocorrencia = 0;
                    while (i_bl_report_Tipo_ocorrencia<res_Tipo_ocorrencia.size()) {
                      portalbr.dbobj.table.Tipo_ocorrencia t_tipo_ocorrencia = (portalbr.dbobj.table.Tipo_ocorrencia)res_Tipo_ocorrencia.elementAt(i_bl_report_Tipo_ocorrencia);
                      cODIGO = t_tipo_ocorrencia.getCodigo();
                      dESCRICAO = t_tipo_ocorrencia.getDescricao()==null?"":t_tipo_ocorrencia.getDescricao();
                      String style_bl_report_Tipo_ocorrencia="";
                      if (!((i_bl_report_Tipo_ocorrencia%2)!=0)) {
                        style_bl_report_Tipo_ocorrencia="rowColor";
                      } else {
                        style_bl_report_Tipo_ocorrencia="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Tipo_ocorrencia %>' id="TRbl_report_Tipo_ocorrencia<%=i_bl_report_Tipo_ocorrencia%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= cODIGO %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= cODIGO %>','<%= dESCRICAO %>')" style="cursor:hand">
                            <%= dESCRICAO %>
                          </a>

                        </td>

                      </tr>

                      <%
                      i_bl_report_Tipo_ocorrencia++;
                      if (i_bl_report_Tipo_ocorrencia<res_Tipo_ocorrencia.size()) {
                        t_tipo_ocorrencia = (portalbr.dbobj.table.Tipo_ocorrencia)res_Tipo_ocorrencia.elementAt(i_bl_report_Tipo_ocorrencia);
                        cODIGO = t_tipo_ocorrencia.getCodigo();
                        dESCRICAO = t_tipo_ocorrencia.getDescricao()==null?"":t_tipo_ocorrencia.getDescricao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(CODIGO,DESCRICAO) {
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
                        session.setAttribute("ge_LovPage", "LvTipoOcorrenciasLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvTipoOcorrenciasLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=CODIGO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=DESCRICAO; };
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
