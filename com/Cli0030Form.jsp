<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Cli0030ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Cli0030ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("ped_dadg_ini","Data Digitação Inicial");
    hashMapLabel.set("ped_dadg_fim","Data Digitação Final");
    hashMapLabel.set("codigo_regionali","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("codigo_regionalf","");
    hashMapLabel.set("rep_cdgoi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("rep_cdgof","");
    hashMapLabel.set("reg_cdgo","Região");
    hashMapLabel.set("reg_nome","");
    hashMapLabel.set("estado","Estado");
    hashMapLabel.set("estado_descricao","");
    hashMapLabel.set("municipio","Município");
    hashMapLabel.set("clientes","Clientes");
    hashMapLabel.set("grupos","Grupos");
    hashMapLabel.set("adimplente","Somente Clientes Adimplentes");
    hashMapLabel.set("agrupamento","Mostrar Grupos Econômicos");
    hashMapLabel.set("codigo_municipio","");
    hashMapLabel.set("codigo_ibge","");
    hashMapLabel.set("cb_nao_abrir_municipios","Não abrir municipios");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Vendas Grupo/Cliente X Marca
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(274)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Cli0030Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ped_dadg_ini"/>
                    <html:errors property="ped_dadg_fim"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="reg_cdgo"/>
                    <html:errors property="reg_nome"/>
                    <html:errors property="estado"/>
                    <html:errors property="estado_descricao"/>
                    <html:errors property="municipio"/>
                    <html:errors property="clientes"/>
                    <html:errors property="grupos"/>
                    <html:errors property="adimplente"/>
                    <html:errors property="agrupamento"/>
                    <html:errors property="codigo_municipio"/>
                    <html:errors property="codigo_ibge"/>
                    <html:errors property="cb_nao_abrir_municipios"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_analista      = "";
                String codigo_regional      = "";
                String codigo_representante = "";
                acesso.Sessao se = new acesso.Sessao(session);
                String tipo = se.getTipoEntidadeNegocio();

                if(tipo.equals("REGIONAL DE VENDA")){
                  codigo_regional = se.getChave();
                }
                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  codigo_representante = se.getChave();
                }
                if(tipo.equals("ANALISTA REGIONAL")){
                  codigo_analista = se.getChave();
                }


                if(tipo.equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {
                    {"codigo_gerente","=",codigo_analista}
                    };
                    Vector res_Jw_regional_analista = j.select(table, select, where, null, null, null);
                    if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
                      portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
                      codigo_regional = r.getCodigo_regional();
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }


                if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try{
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.table.Rep table = new portalbr.dbobj.table.Rep();
                    String[][] select = null;
                    Object[][] where  = {
                    {"rep_cdgo","=",codigo_representante}
                    };
                    Vector res_Rep = j.select(table, select, where, null, null, null);
                    if (res_Rep != null && res_Rep.size() > 0) {
                      portalbr.dbobj.table.Rep r = (portalbr.dbobj.table.Rep) res_Rep.elementAt(0);
                      codigo_regional = r.getCodigo_regional()+"";
                    }
                  } finally {
                    if(j!=null) {
                      j.close();
                      j = null;
                    }
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Digitação Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="ped_dadg_ini" styleId="ped_dadg_ini" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_ini']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Data Digitação Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="ped_dadg_fim" styleId="ped_dadg_fim" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <%
                if(!(tipo.equals("REGIONAL DE VENDA") || tipo.equals("REPRESENTANTE COMERCIAL") || tipo.equals("REPRESENTANTE EXPORTACAO") || tipo.equals("ANALISTA REGIONAL"))){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'Cli0030ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_codigo_regional()"  >
                      <script type="text/javascript">
                        function lov_open_codigo_regional() {
                          window.open('..//lov/LvRegionalLov.jsp?returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <%
                if(!(tipo.equals("REPRESENTANTE COMERCIAL") || tipo.equals("REPRESENTANTE EXPORTACAO"))){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Cli0030ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('..//lov/LvRepresentanteLov.jsp?returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Região
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="reg_cdgo" styleId="reg_cdgo" onblur="fillFields(0,new Array('reg_cdgo'),'Cli0030ActionForm.getReg_nome_Ajax',new Array('reg_nome'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_reg_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_reg_cdgo() {
                        window.open('..//lov/LvRegiaoLov.jsp?returnBlock=0&return0=reg_cdgo&return1=reg_nome','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="reg_nome" styleId="reg_nome" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Estado
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="estado" styleId="estado" onblur="fillFields(0,new Array('estado'),'Cli0030ActionForm.getEstado_descricao_Ajax',new Array('estado_descricao'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_estado()"  >
                    <script type="text/javascript">
                      function lov_open_estado() {
                        window.open('..//lov/LvEstadosLov.jsp?returnBlock=0&return0=estado&return1=estado_descricao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="estado_descricao" styleId="estado_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Município
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="municipio" styleId="municipio" styleClass="baseField"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_municipio()"  >
                    <script type="text/javascript">
                      function lov_open_municipio() {
                        window.open('..//lov/LvMunicipiosLov.jsp?returnBlock=0&return0=codigo_municipio&return1=municipio&return2=codigo_ibge&return3=estado','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Clientes
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="clientes" styleId="clientes" styleClass="baseField" cols="50" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupos
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="grupos" styleId="grupos" styleClass="baseField" cols="50" rows="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Somente Clientes Adimplentes
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="adimplente" styleId="adimplente" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mostrar Grupos Econômicos
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="agrupamento" styleId="agrupamento" styleClass="baseField" value="G"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_municipio" styleId="codigo_municipio" styleClass="myhidden"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="codigo_ibge" styleId="codigo_ibge" styleClass="myhidden" tabindex="-1"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Não abrir municipios
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_nao_abrir_municipios" styleId="cb_nao_abrir_municipios" styleClass="baseField" value="1"/>
                  </td>
                </tr>

                <%
                if(request.getAttribute("arquivo")!=null){
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
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
    document.onkeypress = getKeySite;
</SCRIPT><html:button accesskey="l" onclick="resetfull_action" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
<html:submit accesskey="s" styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
<html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
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
