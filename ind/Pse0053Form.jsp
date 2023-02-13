<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Pse0053ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Pse0053ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("pro_numero","Processo");
    hashMapLabel.set("pro_nome","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("fil_filial","Filial");
    hashMapLabel.set("fil_razsoc","");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("hora_inicial","Hora Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("hora_final","Hora Final");
    hashMapLabel.set("fornecedor","Fornecedor");
    hashMapLabel.set("fornecedor_desc","");
    hashMapLabel.set("seq_fornec","Seq. Fornec.");
    hashMapLabel.set("resumo","Resumo");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Talões a Enviar/Receber por Fornecedor
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(151)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/Pse0053Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="pro_numero"/>
                    <html:errors property="pro_nome"/>
                    <html:errors property="tipo"/>
                    <html:errors property="fil_filial"/>
                    <html:errors property="fil_razsoc"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="hora_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="hora_final"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="fornecedor_desc"/>
                    <html:errors property="seq_fornec"/>
                    <html:errors property="resumo"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String for_codigo="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("ATELIER")){
                    for_codigo = ent.getChave()+"";
                  }
                }

                com.egen.util.jdbc.JdbcUtil j = null;
                java.sql.Connection conn = null;
                String data_inicial = null;
                String data_final   = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  java.sql.PreparedStatement pstm = j.getConn().prepareStatement(
                  " select to_char(trunc(sysdate),'dd/mm/yyyy'), to_char(trunc(sysdate-30),'dd/mm/yyyy') from dual "
                  );


                  java.sql.ResultSet rset = pstm.executeQuery();
                  if(rset.next()){
                    data_inicial = rset.getString(2);
                    data_final   = rset.getString(1);
                  }
                  rset.close();
                  pstm.close();
                } catch (Exception e) {}
                finally {
                  if (j != null) {
                    j.close();
                    j = null;
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Processo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="pro_numero" styleId="pro_numero" onblur="fillFields(0,new Array('pro_numero'),'Pse0053ActionForm.getPro_nome_Ajax',new Array('pro_nome'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_pro_numero()"  >
                    <script type="text/javascript">
                      function lov_open_pro_numero() {
                        window.open('..//lov/LvProcesso_fabLov.do?resetfull_action=&returnBlock=0&return0=pro_numero&return1=pro_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="pro_nome" styleId="pro_nome" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField">
                      <html:option styleClass="baseOption" value="E">
                        Envio
                      </html:option>
                      <html:option styleClass="baseOption" value="R\"selected='selected'">
                        Retorno
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Filial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fil_filial" styleId="fil_filial" onblur="if(this.value!=''){fillFields(0,new Array('fil_filial'),'Pse0053ActionForm.getFil_razsoc_Ajax',new Array('fil_razsoc'));}else{fil_razsoc.value='';}" styleClass="baseField" size="5" maxlength="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fil_filial()"  >
                    <script type="text/javascript">
                      function lov_open_fil_filial() {
                        window.open('..//lov/LvFilialLov.do?resetfull_action=&returnBlock=0&return0=fil_filial&return1=fil_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fil_razsoc" styleId="fil_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
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
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" value="<%= data_inicial %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
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
                    <html:text property="dt_final" styleId="dt_final" styleClass="baseField" value="<%= data_final %>" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" width="16" height="16" tabindex="9999" border="0" />
                    </a>
                    <span class="spamFormLabel">
                      Hora Final
                    </span>
                    <html:text property="hora_final" styleId="hora_final" styleClass="baseField" size="5"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <%
                    if(for_codigo.equals("")){
                      %>
                      <span class="spamFormLabel">
                        Fornecedor
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                      <%
                    }
                    %>
                  </td>
                  <td class="formField">
                    <%
                    if(!for_codigo.equals("")){
                      %>
                      <html:hidden property="fornecedor" value="<%= for_codigo %>"/>
                      <%
                    } else {
                      %>
                      <html:text property="fornecedor" onblur="if(this.value!=''){fillFields(0,new Array('fornecedor'),'Pse0053ActionForm.getFornecedor_desc_Ajax',new Array('fornecedor_desc'))}{fornecedor_desc.value='';};" styleClass="baseField" value="<%= for_codigo %>" size="9" maxlength="9"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fornecedor()"  >


                      <script type="text/javascript">
                        function lov_open_fornecedor() {
                          window.open('..//lov/LvFornecedorLov.do?resetfull_action=&returnBlock=0&return0=fornecedor&return1=fornecedor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fornecedor_desc" styleId="fornecedor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="47" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Seq. Fornec.
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="seq_fornec" styleId="seq_fornec" styleClass="baseField" size="3"/>
                  </td>
                </tr>

                <%
                if(user.isSuperUsuario()){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Resumo
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="resumo" styleId="resumo" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="N">
                          Não
                        </html:option>
                        <html:option styleClass="baseOption" value="S">
                          Sim
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="resumo" styleId="resumo" value="N" />

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
                        if(eventChooser == 13){ bloqueia();
                      if(document.forms[0].select1_action.disabled==true){return false;}
                      document.forms[0].select1_action.disabled=true;
                      document.forms[0].resetfull1_action.disabled=true;
                      document.forms[0].select_action.click();
                    }
                  }
                </script>
                <SCRIPT>
                  document.onkeypress = getKeySite;
                  </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#dt_inicial").mask("99/99/9999");
                    $("#dt_final").mask("99/99/9999");
                    $("#hora_inicial").mask("99:99");
                    $("#hora_final").mask("99:99");
                    });
                  </script>
                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["fil_filial"];
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
