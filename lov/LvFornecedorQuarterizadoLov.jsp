<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvFornecedorQuarterizadoLov.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:500;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="fo_codigo_quarterizado"/>
                    <html:errors property="fen_seq_quarterizado"/>
                    <html:errors property="fo_razsoc"/>
                    <html:errors property="fen_cgc_quarterizado"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_For_endere_quarterizado"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:500;">
                <%
                String atelier = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  atelier = sessao.getChave();
                }
                %>
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <html:hidden property="fo_codigo" value="<%= atelier %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fornecedor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_codigo_quarterizado" styleId="fo_codigo_quarterizado" styleClass="baseField" size="9" maxlength="9"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Seq.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_seq_quarterizado" styleId="fen_seq_quarterizado" styleClass="baseField" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Razão Social
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fo_razsoc" styleId="fo_razsoc" onblur="javascript:toUpperCase(this);" styleClass="baseField" size="40" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CGC
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="fen_cgc_quarterizado" styleId="fen_cgc_quarterizado" styleClass="baseField" size="15" maxlength="14"/>
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
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["fo_codigo_quarterizado"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_For_endere_quarterizado = (java.util.Vector)session.getAttribute("res_For_endere_quarterizado");
              %>

              <form  name="bl_report_For_endere_quarterizado" id="bl_report_For_endere_quarterizado" class="baseForm" method="post" >
                <%
                if (res_For_endere_quarterizado!=null && res_For_endere_quarterizado.size()>0) {
                  %>

                  <table id="TRbl_report_For_endere_quarterizado"  class="reportTable"   style="width:500; "  >
                    <%
                    java.lang.Integer for_codigo =  null;
                    java.lang.Integer for_codigo_quarterizado =  null;
                    java.lang.Integer fen_seq_quarterizado =  null;
                    java.lang.Double fen_cgc_quarterizado =  null;
                    java.lang.String for_razsoc =  null;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Fornecedor
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq.
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        CGC
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Razão Social
                      </td>

                    </tr>

                    <%
                    int i_bl_report_For_endere_quarterizado = 0;
                    while (i_bl_report_For_endere_quarterizado<res_For_endere_quarterizado.size()) {
                      portalbr.dbobj.table.For_endere_quarterizado t_for_endere_quarterizado = (portalbr.dbobj.table.For_endere_quarterizado)res_For_endere_quarterizado.elementAt(i_bl_report_For_endere_quarterizado);
                      for_codigo = t_for_endere_quarterizado.getFor_codigo();
                      for_codigo_quarterizado = t_for_endere_quarterizado.getFor_codigo_quarterizado();
                      fen_seq_quarterizado = t_for_endere_quarterizado.getFen_seq_quarterizado();
                      fen_cgc_quarterizado = t_for_endere_quarterizado.getFen_cgc_quarterizado();
                      for_razsoc = t_for_endere_quarterizado.getFor_razsoc()==null?"":t_for_endere_quarterizado.getFor_razsoc();
                      String style_bl_report_For_endere_quarterizado="";
                      if (!((i_bl_report_For_endere_quarterizado%2)!=0)) {
                        style_bl_report_For_endere_quarterizado="rowColor";
                      } else {
                        style_bl_report_For_endere_quarterizado="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_For_endere_quarterizado %>' id="TRbl_report_For_endere_quarterizado<%=i_bl_report_For_endere_quarterizado%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= for_codigo_quarterizado %>','<%= fen_seq_quarterizado %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= ((for_codigo_quarterizado!=null)?for_codigo_quarterizado.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= for_codigo_quarterizado %>','<%= fen_seq_quarterizado %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= ((fen_seq_quarterizado!=null)?fen_seq_quarterizado.toString():"") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <a href="javascript:setLov('<%= for_codigo_quarterizado %>','<%= fen_seq_quarterizado %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= com.egen.util.text.FormatNumber.format(fen_cgc_quarterizado, "0") %>
                          </a>

                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <a href="javascript:setLov('<%= for_codigo_quarterizado %>','<%= fen_seq_quarterizado %>','<%= for_razsoc %>')" style="cursor:hand">
                            <%= for_razsoc %>
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
                        fen_cgc_quarterizado = t_for_endere_quarterizado.getFen_cgc_quarterizado();
                        for_razsoc = t_for_endere_quarterizado.getFor_razsoc()==null?"":t_for_endere_quarterizado.getFor_razsoc();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

                <script type="text/javascript">
                  function setLov(FOR_CODIGO_QUARTERIZADO,FEN_SEQ_QUARTERIZADO,FOR_RAZSOC) {
                    <% {
                      String returnBlock = "0";
                      String return0 = null;
                      String return1 = null;
                      String return2 = null;
                      if (request.getParameter("returnBlock")!=null) {
                        returnBlock = request.getParameter("returnBlock");
                        session.setAttribute("returnBlock",returnBlock);
                        return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                        session.setAttribute("return0",return0);
                        return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                        session.setAttribute("return1",return1);
                        return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                        session.setAttribute("return2",return2);
                        session.setAttribute("ge_LovPage", "LvFornecedorQuarterizadoLov");
                      } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFornecedorQuarterizadoLov")) {
                        returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                        return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                        return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                        return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                      }
                      %>
                      returnBlock = <%= returnBlock %>;
                      <% if (return0!=null && return0.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO_QUARTERIZADO; };
                      <%}%>
                      <% if (return1!=null && return1.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FEN_SEQ_QUARTERIZADO; };
                      <%}%>
                      <% if (return2!=null && return2.length()>0) {%>
                      if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=FOR_RAZSOC; };
                      <%}%>
                      window.close();
                    }
                    <% } %>

                    function setLov(FOR_CODIGO_QUARTERIZADO,FEN_SEQ_QUARTERIZADO,FOR_RAZSOC) {
                      <% {
                        String returnBlock = "0";
                        String return0 = null;
                        String return1 = null;
                        String return2 = null;
                        if (request.getParameter("returnBlock")!=null) {
                          returnBlock = request.getParameter("returnBlock");
                          session.setAttribute("returnBlock",returnBlock);
                          return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                          session.setAttribute("return0",return0);
                          return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                          session.setAttribute("return1",return1);
                          return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                          session.setAttribute("return2",return2);
                          session.setAttribute("ge_LovPage", "LvFornecedorQuarterizadoLov");
                        } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFornecedorQuarterizadoLov")) {
                          returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                          return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                          return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                        }
                        %>
                        returnBlock = <%= returnBlock %>;
                        <% if (return0!=null && return0.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO_QUARTERIZADO; };
                        <%}%>
                        <% if (return1!=null && return1.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FEN_SEQ_QUARTERIZADO; };
                        <%}%>
                        <% if (return2!=null && return2.length()>0) {%>
                        if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=FOR_RAZSOC; };
                        <%}%>
                        window.close();
                      }
                      <% } %>

                      function setLov(FOR_CODIGO_QUARTERIZADO,FEN_SEQ_QUARTERIZADO,FOR_RAZSOC) {
                        <% {
                          String returnBlock = "0";
                          String return0 = null;
                          String return1 = null;
                          String return2 = null;
                          if (request.getParameter("returnBlock")!=null) {
                            returnBlock = request.getParameter("returnBlock");
                            session.setAttribute("returnBlock",returnBlock);
                            return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                            session.setAttribute("return0",return0);
                            return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                            session.setAttribute("return1",return1);
                            return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                            session.setAttribute("return2",return2);
                            session.setAttribute("ge_LovPage", "LvFornecedorQuarterizadoLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFornecedorQuarterizadoLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                            return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO_QUARTERIZADO; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FEN_SEQ_QUARTERIZADO; };
                          <%}%>
                          <% if (return2!=null && return2.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=FOR_RAZSOC; };
                          <%}%>
                          window.close();
                        }
                        <% } %>

                        function setLov(FOR_CODIGO_QUARTERIZADO,FEN_SEQ_QUARTERIZADO,FOR_RAZSOC) {
                          <% {
                            String returnBlock = "0";
                            String return0 = null;
                            String return1 = null;
                            String return2 = null;
                            if (request.getParameter("returnBlock")!=null) {
                              returnBlock = request.getParameter("returnBlock");
                              session.setAttribute("returnBlock",returnBlock);
                              return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                              session.setAttribute("return0",return0);
                              return1 = ((request.getParameter("return1")!=null)?request.getParameter("return1"):null);
                              session.setAttribute("return1",return1);
                              return2 = ((request.getParameter("return2")!=null)?request.getParameter("return2"):null);
                              session.setAttribute("return2",return2);
                              session.setAttribute("ge_LovPage", "LvFornecedorQuarterizadoLov");
                            } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvFornecedorQuarterizadoLov")) {
                              returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                              return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                              return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                              return2 = ((session.getAttribute("return2")!=null)?(String)session.getAttribute("return2"):null);
                            }
                            %>
                            returnBlock = <%= returnBlock %>;
                            <% if (return0!=null && return0.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=FOR_CODIGO_QUARTERIZADO; };
                            <%}%>
                            <% if (return1!=null && return1.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=FEN_SEQ_QUARTERIZADO; };
                            <%}%>
                            <% if (return2!=null && return2.length()>0) {%>
                            if (opener.document.forms[returnBlock].<%= return2%>!=null) { opener.document.forms[returnBlock].<%= return2 %>.value=FOR_RAZSOC; };
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
