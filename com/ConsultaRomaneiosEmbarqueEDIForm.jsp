<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaRomaneiosEmbarqueEDIActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaRomaneiosEmbarqueEDIActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_trai","");
    hashMapLabel.set("tra_cdgo","Transp.");
    hashMapLabel.set("tra_nome","");
    hashMapLabel.set("f_traf","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("data_emissao","Dt. Romaneio");
    hashMapLabel.set("data_emissao_final","");
    hashMapLabel.set("romaneio","Nº Romaneio");
    hashMapLabel.set("nfs_nmro","Nº Nota Fiscal");
    hashMapLabel.set("f_tra","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta Romaneios Embarque / EDI
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].f_tra.value!=''){document.forms[0].data_emissao.focus();}else{document.forms[0].tra_cdgo.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(133)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaRomaneiosEmbarqueEDIForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                        <br>
                      </div>
                    </div>
                    <html:errors property="tra_cdgo"/>
                    <html:errors property="tra_nome"/>
                    <html:errors property="data_emissao"/>
                    <html:errors property="romaneio"/>
                    <html:errors property="nfs_nmro"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_romaneios_embarque"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String transportadora="";
                String tipo = "";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("TRANSPORTADORA")){
                    transportadora = ent.getChave()+"";
                  }
                }
                %>
                <%
                if(transportadora.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Transp.
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="tra_cdgo" onblur="fillFields(0,new Array('tra_cdgo'),'ConsultaRomaneiosEmbarqueEDIActionForm.getTra_nome_Ajax',new Array('tra_nome'));" styleClass="baseField" size="4" maxlength="4"/>
                      <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_tra_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_tra_cdgo() {
                          window.open('../lov/LvTransportadoraLov.do?resetfull_action=&returnBlock=0&return0=tra_cdgo&return1=tra_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="tra_nome" styleId="tra_nome" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <!--<html:hidden property="tra_cdgo" value="<%= transportadora %>"/>-->
                  <tr>
                    <td class="formField">
                      <html:text property="tra_cdgo" value="<%= transportadora %>" styleClass="myhidden" size="3" maxlength="3"/>
                      <%
                    }
                    %>


                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Filial
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ConsultaRomaneiosEmbarqueEDIActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                        <script type="text/javascript">
                          function lov_open_fil_filial() {
                            window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                      </td>
                    </tr>


                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Dt. Romaneio
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="data_emissao" styleId="data_emissao" styleClass="baseField" size="10" maxlength="10"/>
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_emissao']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>
                        até
                        <html:text property="data_emissao_final" styleId="data_emissao_final" styleClass="baseField" size="10" maxlength="10"/>
                        <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_emissao_final']); cal1.year_scroll = true; cal1.popup();">
                          <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                        </a>

                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Nº Romaneio
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="romaneio" styleId="romaneio" styleClass="baseField" size="10"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Nº Nota Fiscal
                        </span>
                        <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                      </td>
                      <td class="formField">
                        <html:text property="nfs_nmro" styleId="nfs_nmro" styleClass="baseField" size="10"/>
                      </td>
                    </tr>

                    <html:hidden property="f_tra" value="<%= transportadora %>"/>
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
                            if(eventChooser == 13){
                              bloqueia();
                            if(document.forms[0].select1_action.disabled==true){return false;}
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

                        <script>
                        jQuery(document).ready(function($) {
                          $("#data_emissao").mask("99/99/9999");
                          $("#data_emissao_final").mask("99/99/9999");
                          });
                        </script>


                      </html:form>
                    </td>
                  </tr>
                </table>

              </body>
            </center>
          </html>
