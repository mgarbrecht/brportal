<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaApontamentoProducaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaApontamentoProducaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("data_inicial","Data Inicial");
    hashMapLabel.set("hora_inicial","Hora Inicial");
    hashMapLabel.set("data_final","Data Final");
    hashMapLabel.set("hora_final","Hora Final");
    hashMapLabel.set("f_filial_i","");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("f_filial_f","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("codigo_mini_fabrica","Mini-Fábrica");
    hashMapLabel.set("descricao_mini_fabrica","");
    hashMapLabel.set("remessa","Remessa");
    hashMapLabel.set("setor","Setor");
    hashMapLabel.set("abrir_remessa","Abrir");
    hashMapLabel.set("tipo","Tipo de Relatório");
    hashMapLabel.set("f_xls","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Apontamento de Produção
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(34)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/ConsultaApontamentoProducaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="data_inicial"/>
                    <html:errors property="hora_inicial"/>
                    <html:errors property="data_final"/>
                    <html:errors property="hora_final"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="codigo_mini_fabrica"/>
                    <html:errors property="descricao_mini_fabrica"/>
                    <html:errors property="remessa"/>
                    <html:errors property="setor"/>
                    <html:errors property="abrir_remessa"/>
                    <html:errors property="tipo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Apont_prod"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String atelier = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  atelier = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="data_inicial" styleId="data_inicial" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      Hora Inicial
                    </span>
                    <html:text property="hora_inicial" styleId="hora_inicial" styleClass="baseField" size="5"/>
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
                    <html:text property="data_final" styleId="data_final" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      Hora Final
                    </span>
                    <html:text property="hora_final" styleId="hora_final" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <%
                if(atelier == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Filial
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="fil_filial" styleId="fil_filial" onblur="fillFields(0,new Array('fil_filial'),'ConsultaApontamentoProducaoActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));" styleClass="baseField" size="4"/>
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

                  <%
                } else {
                  %>

                  <html:hidden property="fil_filial" />
                  <html:hidden property="fil_razsoc" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ConsultaApontamentoProducaoActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mini-Fábrica
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_mini_fabrica" styleId="codigo_mini_fabrica" onblur="fillFields(0,new Array('codigo_mini_fabrica'),'ConsultaApontamentoProducaoActionForm.getFil_razsoc_Ajax',new Array('descricao_mini_fabrica'));" styleClass="baseField" size="2"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_mini_fabrica()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_mini_fabrica() {
                        window.open('..//lov/LvMiniFabricaLov.do?resetfull_action=&returnBlock=0&return0=codigo_mini_fabrica&return1=descricao_mini_fabrica','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_mini_fabrica" styleId="descricao_mini_fabrica" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Remessa
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="remessa" styleId="remessa" styleClass="baseField" size="10"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Setor
                    </span>
                  </td>
                  <td class="formField">

                    <html:text property="setor" styleId="setor" styleClass="myhidden"/>
                    <input type="button" class="lovButton"  value="Selecionar Setores" onclick="javascript:lov_open_setores()"  >
                    <script type="text/javascript">
                      function lov_open_setores() {
                        window.open('..//lov/LvSetorMRGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>


                    <%
                    if(session.getAttribute("listaSetores")!=null) {
                      %>
                      <table width="200px" border="1">
                        <tr>
                          <td style="text-align:center; background-color: #CC2E2B; color:white">
                            <b>
                              Setores Selecionados
                            </b>
                          </td>
                        </tr>
                        <%
                        for(String s : (java.util.List<String>)session.getAttribute("listaSetores")){
                          %>
                          <tr>
                            <td style="background-color: #d0e1f4">
                              <%= s %>
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
                      Abrir
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="abrir_remessa" styleId="abrir_remessa" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Referência
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Remessa/Talão
                      </html:option>
                      <html:option styleClass="baseOption" value="R">
                        Remessa
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        Modelo
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Relatório
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="xls">
                        XLS
                      </html:option>
                      <html:option styleClass="baseOption" value="Pdf">
                        PDF
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <%
                if((String)request.getAttribute("abre_automaticamenteXLS")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadxls"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>

                <%
                if((String)request.getAttribute("abre_automaticamentePDF")=="N"){
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
                    <html:submit accesskey="p" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_inicial").mask("99/99/9999");
                  $("#data_final").mask("99/99/9999");
                  $("#hora_inicial").mask("99:99");
                  $("#hora_final").mask("99:99");
                  });
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["data_inicial"];
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
