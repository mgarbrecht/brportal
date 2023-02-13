<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClientesAtendidosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ClientesAtendidosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_session","");
    hashMapLabel.set("tipo","Tipo");
    hashMapLabel.set("mes","Mês");
    hashMapLabel.set("ano","Ano");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("gre_grupo","Grupo");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("cli_cdgo","Clientes");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("free","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Consulta de clientes atendidos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(326)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesAtendidosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tipo"/>
                    <html:errors property="mes"/>
                    <html:errors property="ano"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Dual"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String representante = null;
                String regional = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")
                ){
                  representante = sessao.getChave();
                }
                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  regional = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos os clientes
                      </html:option>
                      <html:option styleClass="baseOption" value="PG">
                        Clientes Atendidos PG
                      </html:option>
                      <html:option styleClass="baseOption" value="PP">
                        Clientes Atendidos PP
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mês
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="mes" styleId="mes" styleClass="baseField" size="2" maxlength="2"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ano
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ano" styleId="ano" styleClass="baseField" size="5" maxlength="4"/>
                  </td>
                </tr>

                <%
                if(regional == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'ClientesAtendidosActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>


                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="codigo_regional" value="<%= regional %>" />
                  <html:hidden property="nome_regional" />

                  <%
                }
                %>
                <%
                if(representante == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ClientesAtendidosActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="4" maxlength="4"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="50"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="rep_cdgo" value="<%= representante %>"/>
                  <html:hidden property="rep_rzao" />


                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo" styleId="gre_grupo" onblur="fillFields(0,new Array('gre_grupo'),'ClientesAtendidosActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_gre_grupo()"  >
                    <script type="text/javascript">
                      function lov_open_gre_grupo() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Clientes
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleId="cli_cdgo" onblur="fillFields(0,new Array('cli_cdgo'),'ClientesAtendidosActionForm.getCli_rzao_Ajax',new Array('cli_rzao'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_cli_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cli_cdgo() {
                        window.open('..//lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'ClientesAtendidosActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

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
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                      Gerar Relatório
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
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
    document.onkeypress = getKeySite;
</SCRIPT><html:button accesskey="l" onclick="document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
<html:submit accesskey="p" value="Gerar Relatório" styleClass="myhidden" property="select_action"></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
</td> 
</tr>
</table>

</html:form>
</td> 
</tr>
</table>

</body>
</center>
</html>
