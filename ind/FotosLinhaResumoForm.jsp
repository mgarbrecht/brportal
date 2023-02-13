<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/FotosLinhaResumoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = FotosLinhaResumoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("ref_cdgo","ReferÍncia");
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
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Ficha_tec" class="reportTable" style=width:99%; border=2;>
              <%
              int counterbl_report_Ficha_tec=0;
              {
                portalbr.dbobj.view.Jw_ficha_tec_imagem t_ficha_tec = new portalbr.dbobj.view.Jw_ficha_tec_imagem();
                java.util.Vector res_Ficha_tec = (java.util.Vector)session.getAttribute("res_Jw_ficha_tec_imagem");
                util.consultas.Parametros parametros = new util.consultas.Parametros();
                String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
                //  String diretorio_imagem = "https://s3.sa-east-1.amazonaws.com/imagens.catalogobeirario.com.br/pequenas/";
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
              <html:form action="ind/FotosLinhaResumoForm.do" method="post" styleClass="baseForm" target="_self">

                <table class="itemTable"  style="width:99%;">
                  <html:hidden property="lin_cdgo"/>
                  <html:hidden property="ref_cdgo"/>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:button accesskey="p" styleClass="myhidden" property="select1_action" onclick="bloqueia();this.disabled=true;resetfull1_action.disabled=true;select_action.click();">
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

                      <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="myhidden" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_action">
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
                      var focusControl = document.forms[1].elements["lin_cdgo"];
                      if (focusControl.type != "hidden"){
                        focusControl.focus();
                      }
                    </script>

                  </td>
                </tr>
              </table>

            </body>
          </center>
        </html>
