<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Sbr0377ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Sbr0377ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_data","");
    hashMapLabel.set("f_tipo_relatorio_i","");
    hashMapLabel.set("tipo_relatorio","Tipo de Relatório");
    hashMapLabel.set("f_tipo_relatorio_f","");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("data_inicial","Data Inicial");
    hashMapLabel.set("data_final","Data Final");
    hashMapLabel.set("ck_pedidos_programados","Apenas Pedidos Programados");
    hashMapLabel.set("f_filial_i","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("filiais","");
    hashMapLabel.set("filiais_selecionadas","");
    hashMapLabel.set("f_filial_f","");
    hashMapLabel.set("linhas","Linhas");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("linhas_selecionadas","");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente ");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Relatório Realizado de Vendas
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(139)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Sbr0377Form.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tipo_relatorio"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_razsoc"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="ck_pedidos_programados"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="filiais"/>
                    <html:errors property="linhas"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                java.util.Date data = new java.util.Date();
                java.text.SimpleDateFormat fData = new java.text.SimpleDateFormat("dd/MM/yyyy");
                String dia_inicial = ""+fData.format(data);
                String dia_final   = ""+fData.format(data);

                acesso.Usuario us = new acesso.Usuario();
                us = (acesso.Usuario)session.getAttribute("User");
                if(us.getUsuario().equalsIgnoreCase("JORGE")){
                  dia_inicial = "";
                }
                %>
                <%
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                if((!(u.getUsuario().equalsIgnoreCase("JORGE")))) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Tipo de Relatório
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="tipo_relatorio" style="border=0;text-align:start;" styleClass="baseField">
                        <html:option styleClass="baseOption" value="m">
                          Por Material
                        </html:option>
                        <html:option styleClass="baseOption" value="f">
                          Por Filial
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="tipo_relatorio" value="m"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Empresa
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" onblur="if(this.value!=''){fillFields(0,new Array('emp_empresa'),'Sbr0377ActionForm.getEmp_razsoc_Ajax',new Array('emp_razsoc'))}else{emp_razsoc.value=''};" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_emp_empresa()"  >
                    <script type="text/javascript">
                      function lov_open_emp_empresa() {
                        window.open('../lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" value="CALCADOS BEIRA RIO S/A" size="55" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" value="<%= dia_inicial %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" value="<%= dia_final %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                  </td>
                  <td class="formField">
                    <html:checkbox property="ck_pedidos_programados" style="border=0;text-align:start;" styleClass="baseField" value="S"/>
                    <span class="spamFormLabel">
                      Apenas Pedidos Programados
                    </span>
                  </td>
                </tr>

                <%
                //  acesso.Usuario u = new acesso.Usuario();
                //  u = (acesso.Usuario)session.getAttribute("User");
                if((!(u.getUsuario().equalsIgnoreCase("JORGE")))) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="fil_filial" onblur="if(this.value!=''){fillFields(0,new Array('emp_empresa','fil_filial'),'Sbr0377ActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'))}else{fil_razsoc.value=''};" styleClass="baseField" size="4" maxlength="4"/>
                      <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_fil_filial()"  >
                      <script type="text/javascript">
                        function lov_open_fil_filial() {
                          window.open('../lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                      <html:button value="Selecionar Filiais" styleClass="baseButton" property="select1_action" tabindex="-1" onclick="window.open('../lov/LvFiliaisLov.jsp','','scrollbars,height=450,width=520,top=0,left=0,')">
                      </html:button>
                    </td>
                  </tr>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="filiais" styleClass="myhidden"/>
                    </td>
                  </tr>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                      </span>
                    </td>
                    <td class="formField">
                      <%
                      int counterbl_report_Jw_clientes_enderecos =0;
                      int i_bl_report_Jw_clientes_enderecos =0;
                      java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("filiais_selecionadas");
                      if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                        %>
                        <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:40%; border=1;  >
                          <tr class="reportHeader" >
                            <td align="center">
                              Filiais Selecionadas
                            </td>
                          </tr>
                          <%
                          for (int x=0;x<res_Jw_clientes_grupos_economicos.size(); x++){
                            counterbl_report_Jw_clientes_enderecos++;
                            String style="";
                            if (!((i_bl_report_Jw_clientes_enderecos%2)!=0)) {
                              style="class=rowColor";
                            } else {
                              style="class=rowBlank";
                            }
                            %>
                            <tr <%= style %> id='TRbl_report_Jw_clientes_enderecos<%=counterbl_report_Jw_clientes_enderecos%>' >
                              <td class="reportColumn" style="text-align:left;">
                                <%= res_Jw_clientes_grupos_economicos.elementAt(x) %>
                              </td>
                            </tr>
                            <%
                          }
                          %>
                        </table>
                        <%
                      }
                      %>



                    </td>
                  </tr>


                  <%
                } else {
                  %>
                  <html:hidden property="fil_filial" />
                  <html:hidden property="filiais" />
                  <%
                }
                %>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="linhas" styleClass="myhidden"/>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo'),'Sbr0377ActionForm.getLin_nome_Ajax',new Array('lin_nome'))}else{lin_nome.value=''};" styleClass="baseField" size="6" maxlength="6"/>
                    <input type="button" tabindex="-1" class="lovButton"  value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                    <!--
                      <html:button value="Selecionar Linhas" styleId="lin_nome" styleClass="baseButton" property="select1_action" tabindex="-1" onclick="window.open('../lov/LvLinhasLov.jsp','','scrollbars,height=450,width=520,top=0,left=0,')"> </html:button>
                    -->
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    int counterbl_report_Jw_linhas_selecionadas =0;
                    int i_bl_report_linhas_selecionadas =0;
                    java.util.Vector res_linhas_selecionadas = (java.util.Vector)session.getAttribute("linhas_selecionadas");
                    if (res_linhas_selecionadas!=null && res_linhas_selecionadas.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:40%; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Linhas / Ref. Selecionadas
                          </td>
                        </tr>
                        <%
                        for (int x=0;x<res_linhas_selecionadas.size(); x++){
                          counterbl_report_Jw_linhas_selecionadas++;
                          String style="";
                          if (!((i_bl_report_linhas_selecionadas%2)!=0)) {
                            style="class=rowColor";
                          } else {
                            style="class=rowBlank";
                          }
                          %>
                          <tr <%= style %> id='TRbl_report_Jw_clientes_enderecos<%=counterbl_report_Jw_linhas_selecionadas%>' >
                            <td class="reportColumn" style="text-align:left;">
                              <%= res_linhas_selecionadas.elementAt(x) %>
                            </td>
                          </tr>
                          <%
                        }
                        %>
                      </table>
                      <%
                    }
                    %>



                  </td>
                </tr>


                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" style="border=0;text-align:start;" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" size="90" maxlength="90"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if((String)request.getAttribute("abre_automaticamente")=="N"){
                      %>
                      <table style=width:100%;margin-top:10;>
                        <tr>
                          <td class=columHeader style="text-align:center;">
                            <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                              <bean:message key="report.downloadpdf"/>
                            </a>
                          </td>
                        </tr>
                      </table>
                      <%
                    }
                    %>
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
                        <html:submit styleClass="myhidden" property="refresh_action">
                        <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                        </html:submit>
                        </td>
                        </tr>
                        </table>

                        <script type="text/javascript">
                        jQuery(document).ready(function($) {
                          $("#data_inicial").mask("99/99/9999");
                          $("#data_final").mask("99/99/9999");
                          });
                        </script>
                      </html:form>
                      <script type="text/javascript">
                        var focusControl = document.forms[0].elements["emp_empresa"];
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
