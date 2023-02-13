<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
  <bean:message key="page.script"/>
</head>
<center>
  <body onload="document.forms[0].codigo_regional.value=opener.document.forms[0].codigo_regional.value;">
    <table class="mainTable" style='width:500;'>
      <tr class="mainTr">
        <td class="mainTd">
          <table class="headerTable" style="width:500" >
            <tr>

              <td class="td10">
              </td>

            </tr>

          </table>

          <html:form action="lov/LvRepresentanteLov.do" method="post" styleClass="baseForm" target="_self">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Lista de Valores - Representantes
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="rep_cdgo"/>
                  <html:errors property="rep_rzao"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Rep"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <%
              String codigo_regional="";
              String codigo_representante="";
              String tipo="";
              acesso.Usuario u = new acesso.Usuario();
              u = (acesso.Usuario)session.getAttribute("User");
              acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
              acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

              if(!(u.getEntidadeNegocio()==null)){
                ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                tipo = tipoent.getTipo()+"";
                if(tipo.equals("REGIONAL DE VENDA")){
                  codigo_regional = ent.getChave()+"";
                }
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || tipo.equals("REPRESENTANTE EXPORTACAO")){
                  codigo_representante = ent.getChave()+"";
                }

              }
              %>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Código
                  </span>
                </td>
                <td class="formField">
                  <html:text property="rep_cdgo" styleClass="baseField" size="5" maxlength="5"/>
                </td>
              </tr>

              <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Razão Social
                  </span>
                </td>
                <td class="formField">
                  <html:text property="rep_rzao" styleClass="baseField" size="35" maxlength="35"/>
                </td>
              </tr>

              <html:hidden property="codigo_regional" value="<%= codigo_regional %>"/>
            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="p" onclick="resetfull1_action.disabled=true;close_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:button>
                  <script>
                    function getKeySite(keyStroke) {
                      isNetscape=(document.layers);
                      eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                      which = String.fromCharCode(eventChooser).toLowerCase();
                      keyBuffer = which;
                      if(eventChooser == 13){
                      if(document.forms[0].select1_action.disabled==true){return false;}
                      document.forms[0].select1_action.disabled=true;
                      document.forms[0].resetfull1_action.disabled=true;
                      document.forms[0].close_action.disabled=true;
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:button accesskey="f" onclick="javascript:window.close();" styleClass="baseButton" property="close_action"><bean:message bundle="ApplicationResources" key="jsp.close"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form><script type="text/javascript">
                  var focusControl = document.forms[0].elements["rep_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <%
                {
                  %>

                  <%
                  java.util.Vector res_Rep = (java.util.Vector)session.getAttribute("res_Rep");
                  %>

                  <form  name="bl_report_Rep" id="bl_report_Rep" class="baseForm" method="post" >
                    <%
                    if (res_Rep!=null && res_Rep.size()>0) {
                      %>

                      <table id="TRbl_report_Rep"  class="reportTable"   style="width:500; "  >
                        <%
                        java.lang.String rep_cdgo =  null;
                        java.lang.String rep_rzao =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Código
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Razão Social
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Rep = 0;
                        while (i_bl_report_Rep<res_Rep.size()) {
                          portalbr.dbobj.table.Rep t_rep = (portalbr.dbobj.table.Rep)res_Rep.elementAt(i_bl_report_Rep);
                          rep_cdgo = t_rep.getRep_cdgo()==null?"":t_rep.getRep_cdgo();
                          rep_rzao = t_rep.getRep_rzao()==null?"":t_rep.getRep_rzao();
                          String style_bl_report_Rep="";
                          if (!((i_bl_report_Rep%2)!=0)) {
                            style_bl_report_Rep="rowColor";
                          } else {
                            style_bl_report_Rep="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Rep %>' id="TRbl_report_Rep<%=i_bl_report_Rep%>" >
                            <td class="reportColumn" style="text-align:left;" >
                              <%= rep_cdgo %>
                            </td>

                            <td class="reportColumn" style="text-align:left;" >
                              <a href="javascript:setLov('<%= rep_cdgo %>','<%= rep_rzao %>')" style="cursor:hand">
                                <%= rep_rzao %>
                              </a>

                            </td>

                          </tr>

                          <%
                          i_bl_report_Rep++;
                          if (i_bl_report_Rep<res_Rep.size()) {
                            t_rep = (portalbr.dbobj.table.Rep)res_Rep.elementAt(i_bl_report_Rep);
                            rep_cdgo = t_rep.getRep_cdgo()==null?"":t_rep.getRep_cdgo();
                            rep_rzao = t_rep.getRep_rzao()==null?"":t_rep.getRep_rzao();
                          } else {
                          }
                        }
                        %>

                      </table>

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function setLov(REP_CDGO,REP_RZAO) {
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
                            session.setAttribute("ge_LovPage", "LvRepresentanteLov");
                          } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("LvRepresentanteLov")) {
                            returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                            return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                            return1 = ((session.getAttribute("return1")!=null)?(String)session.getAttribute("return1"):null);
                          }
                          %>
                          returnBlock = <%= returnBlock %>;
                          <% if (return0!=null && return0.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=REP_CDGO; };
                          <%}%>
                          <% if (return1!=null && return1.length()>0) {%>
                          if (opener.document.forms[returnBlock].<%= return1%>!=null) { opener.document.forms[returnBlock].<%= return1 %>.value=REP_RZAO; };
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
