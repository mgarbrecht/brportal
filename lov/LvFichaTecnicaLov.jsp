<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <link href="../css/stylelov.css" rel="stylesheet" type="text/css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:780;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="lov/LvFichaTecnicaLov.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:780;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Lista de Valores - Imagens
                  </td>
                </tr>
              </table>

              <table class="messageTable" style='width:780;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_ficha_tec_imagem"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:780;">
                <html:hidden property="return0" value="<%= request.getParameter("return0") %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:780;'>
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
