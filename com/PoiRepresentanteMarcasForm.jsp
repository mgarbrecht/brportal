<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/PoiRepresentanteMarcasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = PoiRepresentanteMarcasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","free");
    hashMapLabel.set("fi_rep","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("ff_rep","");
    hashMapLabel.set("unidade_negocio","Unidade");
    hashMapLabel.set("unn_descri","");
    hashMapLabel.set("mes","Mês/Ano Inicial");
    hashMapLabel.set("ano","/");
    hashMapLabel.set("mes_final","Mês/Ano Final");
    hashMapLabel.set("ano_final","/");
    hashMapLabel.set("situacao_gerente","Situação gerente");
    hashMapLabel.set("f_regional","");
    hashMapLabel.set("f_representante","");
    hashMapLabel.set("reg","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      POI - Representante por Marcas
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].f_representante.value!=''){document.forms[0].unidade_negocio.focus();}else{document.forms[0].rep_cdgo.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(104)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/PoiRepresentanteMarcasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="mes"/>
                    <html:errors property="ano"/>
                    <html:errors property="mes_final"/>
                    <html:errors property="ano_final"/>
                    <html:errors property="situacao_gerente"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                java.util.Date data_atual = new java.util.Date();
                java.text.SimpleDateFormat fDataMes = new java.text.SimpleDateFormat("MM");
                java.text.SimpleDateFormat fDataAno = new java.text.SimpleDateFormat("yyyy");
                String mes = fDataMes.format(data_atual);
                String ano = fDataAno.format(data_atual);
                String codigo_regional="";
                String codigo_representante="";
                String codigo_analista="";
                String tipo="";

                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                  }
                  if(tipo.equals("ANALISTA REGIONAL")){
                    codigo_analista= ent.getChave()+"";
                  }
                }

                if(tipo.equals("ANALISTA REGIONAL")){
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_regional_analista table = new portalbr.dbobj.view.Jw_regional_analista();
                    String[][] select = null;
                    Object[][] where = {{"codigo_gerente","=",codigo_analista} };
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
                %>
                <%
                if(codigo_representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                      <bean:message key="jsp.fieldnotnull"/>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'PoiRepresentanteMarcasActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="42" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <html:hidden property="unidade_negocio"/>
                <html:hidden property="unn_descri"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mês/Ano Inicial
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="mes" styleClass="baseField" value="<%= mes %>" size="2" maxlength="2"/>
                    <span class="spamFormLabel">
                      /
                    </span>
                    <html:text property="ano" styleClass="baseField" value="<%= ano %>" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mês/Ano Final
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="mes_final" styleClass="baseField" value="<%= mes %>" size="2" maxlength="2"/>
                    <span class="spamFormLabel">
                      /
                    </span>
                    <html:text property="ano_final" styleClass="baseField" value="<%= ano %>" size="4" maxlength="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Situação gerente
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_gerente" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
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

                <html:hidden property="f_regional" value="<%= codigo_regional %>"/>
                <html:hidden property="f_representante" value="<%= codigo_representante %>"/>
                <html:hidden property="reg" value="<%= codigo_regional %>"/>
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

</html:form>
</td> 
</tr>
</table>

</body>
</center>
</html>
