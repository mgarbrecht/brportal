<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/FotosLinhaActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = FotosLinhaActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    var reportColumns = new Array(new Array("lin_cdgo","ref_cdgo","fit_imagem"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Fotos Por Linha
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(98)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/FotosLinhaForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo'),'FotosLinhaActionForm.getLin_nome_Ajax',new Array('lin_nome'))}else{lin_nome.value=''};" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo','ref_cdgo'),'FotosLinhaActionForm.getRef_desc_Ajax',new Array('ref_desc'))}else{ref_desc.value=''};" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="p" styleClass="baseButton" property="select1_action" onclick="bloqueia();this.disabled=true;resetfull1_action.disabled=true;select_action.click();">
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
                    var focusControl = document.forms[0].elements["lin_cdgo"];
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
                      util.consultas.Parametros parametros = new util.consultas.Parametros();
                      String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
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
                            if(contador>5){
                              contador=1;
                              %>
                            </tr>
                            <tr>
                              <%
                            }
                            imagem = new StringBuilder(diretorio_imagem);
                            imagem.append(fit_imagem);
                            %>
                            <td class="reportTd" style="text-align:center;" valign="top">
                              <div align="center">
                                <table>
                                  <tr>
                                    <td>
                                      <b>
                                        Lin-Ref.:
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
                                      <img src="<%= imagem.toString() %>" height="72" />
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
