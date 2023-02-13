<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Cli0027ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Cli0027ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("ped_dadg_ini","Data Digitação Inicial");
    hashMapLabel.set("ped_dadg_fim","Data Digitação Final");
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("nome_marca","");
    hashMapLabel.set("codigo_regionali","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("codigo_regionalf","");
    hashMapLabel.set("rep_cdgoi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("rep_cdgof","");
    hashMapLabel.set("categoria","Categoria");
    hashMapLabel.set("rep_situ","Situação do Representante");
    hashMapLabel.set("abrirCategoria","Abrir por Categoria");
    hashMapLabel.set("abrirModelo","Abrir por Modelo");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Vendas Representante X Modelo
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(277)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/Cli0027Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="ped_dadg_ini"/>
                    <html:errors property="ped_dadg_fim"/>
                    <html:errors property="codigo_marca"/>
                    <html:errors property="nome_marca"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="categoria"/>
                    <html:errors property="rep_situ"/>
                    <html:errors property="abrirCategoria"/>
                    <html:errors property="abrirModelo"/>
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
                    <html:text property="ped_dadg_ini" styleId="ped_dadg_ini" style="text-align:center;" styleClass="baseField" size="10" maxlength="10"/>
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
                    <html:text property="ped_dadg_fim" styleId="ped_dadg_fim" style="text-align:center;" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['ped_dadg_fim']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="fillFields(0,new Array('codigo_marca'),'Cli0027ActionForm.getNome_marca_Ajax',new Array('nome_marca'));" style="text-align:right;" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.jsp?returnBlock=0&return0=codigo_marca&return1=nome_marca','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="nome_marca" styleId="nome_marca" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
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
                      <html:text property="codigo_regional" styleId="codigo_regional" onblur="fillFields(0,new Array('codigo_regional'),'Cli0027ActionForm.getNome_regional_Ajax',new Array('nome_regional'));" style="text-align:right;" styleClass="baseField" size="5"/>
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
                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'Cli0027ActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" style="text-align:right;" styleClass="baseField" size="5"/>
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
                      Categoria
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="categoria" styleId="categoria" styleClass="baseField" size="1">
                      <html:options property="categoriaList" labelProperty="categoriaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação do Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="rep_situ" styleId="rep_situ" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T\"selected='selected'">
                        Todas
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativo
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativo
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abrir por Categoria
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abrirCategoria" styleId="abrirCategoria" styleClass="baseField" value="S"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abrir por Modelo
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abrirModelo" styleId="abrirModelo" styleClass="baseField" value="S"/>
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
                    <html:submit styleClass="myhidden" tabindex="-1" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
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
</SCRIPT><html:submit styleClass="myhidden" tabindex="-1" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
<html:button accesskey="r" onclick="resetfull_action" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
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
