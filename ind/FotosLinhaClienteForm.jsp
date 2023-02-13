<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      <bean:message bundle="IndustrialResources" key="FotosLinhaCliente.titulo"/>
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(97)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/FotosLinhaClienteForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="linha"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="IndustrialResources" key="FotosLinhaCliente.linha"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="linha" style="text-align:right;" styleClass="baseField" size="1">
                      <html:options property="linhaList" labelProperty="linhaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:button>
                    <script>
                      function getKeySite(keyStroke) {
                        isNetscape=(document.layers);
                        eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                        which = String.fromCharCode(eventChooser).toLowerCase();
                        keyBuffer = which;
                        if(eventChooser == 13){ bloqueia();
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT>





                    <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit styleClass="myhidden" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    </td>
                    </tr>
                    </table>

                    </html:form>
                    <script type="text/javascript">
                    var focusControl = document.forms[0].elements["linha"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <table id="TRbl_report_Ficha_tec" class="reportTable" style=width:99%; border=2;>
                    <%
                    int counterbl_report_Ficha_tec=0;
                    {
                      portalbr.dbobj.view.Jw_ficha_tec_imagem t_ficha_tec = new portalbr.dbobj.view.Jw_ficha_tec_imagem();
                      java.util.Vector res_Ficha_tec = (java.util.Vector)session.getAttribute("res_Jw_ficha_tec_imagem");
                      if (res_Ficha_tec!=null && res_Ficha_tec.size()>0) {
                        int lin_cdgo  =  0;
                        int ref_cdgo  =  0;
                        int contador  =  0;
                        StringBuilder imagem = new StringBuilder();
                        java.lang.String fit_imagem =  null;
                        int i_bl_report_Ficha_tec   =  0;
                        t_ficha_tec = (portalbr.dbobj.view.Jw_ficha_tec_imagem)res_Ficha_tec.elementAt(i_bl_report_Ficha_tec);
                        lin_cdgo    = t_ficha_tec.getLin_cdgo();
                        ref_cdgo    = t_ficha_tec.getRef_cdgo();
                        fit_imagem  = t_ficha_tec.getFit_imagem()==null?"":t_ficha_tec.getFit_imagem();
                        %>
                        <tr>
                          <%
                          while (i_bl_report_Ficha_tec<res_Ficha_tec.size()){
                            counterbl_report_Ficha_tec++;
                            contador+=1;
                            if(contador>1){
                              contador=1;
                              %>
                            </tr>
                            <tr>
                              <%
                            }
                            imagem = new StringBuilder("../imagens/grandes/");
                            imagem.append(fit_imagem);
                            %>
                            <td class="reportTd" style="text-align:center;" valign="top">
                              <div align="center">
                                <table>
                                  <tr>
                                    <td>
                                      <b>
                                        <bean:message bundle="IndustrialResources" key="FotosLinhaCliente.lin_ref"/>
                                      </b>
                                      <%=lin_cdgo%>
                                      <b>
                                        -
                                      </b>
                                      <%=ref_cdgo %>
                                      <br>
                                    </td>
                                  </tr>
                                </table>
                                <table>
                                  <tr align="bottom">
                                    <td align="bottom">
                                      <img src="<%= imagem %>"/>
                                    </td>
                                  </tr>
                                </table>
                              </div>
                            </td>

                            <%
                            if (++i_bl_report_Ficha_tec >= res_Ficha_tec.size()) {
                              break;
                            }
                            t_ficha_tec = (portalbr.dbobj.view.Jw_ficha_tec_imagem)res_Ficha_tec.elementAt(i_bl_report_Ficha_tec);
                            lin_cdgo   = t_ficha_tec.getLin_cdgo();
                            ref_cdgo   = t_ficha_tec.getRef_cdgo();
                            fit_imagem = t_ficha_tec.getFit_imagem()==null?"":t_ficha_tec.getFit_imagem();
                          }
                        }
                      }
                      %>
                    </table>

                  </td>
                </tr>
              </table>

            </body>
          </center>
        </html>
