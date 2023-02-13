<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/LimiteCreditoDisponivelActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = LimiteCreditoDisponivelActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("reg","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("limite_inicial","Limite Inicial");
    hashMapLabel.set("limite_final","Limite Final");
    hashMapLabel.set("quantidade","Quantidade");
    hashMapLabel.set("codigo_regional","");
    hashMapLabel.set("codigo_representante","");
    hashMapLabel.set("cb_totalizar_grupo_economico","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Limite de Crédito Disponível
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].codigo_regional.value!=''){document.forms[0].rep_cdgo.focus();}if(document.forms[0].codigo_representante.value!=''){document.forms[0].quantidade.focus();}if(document.forms[0].codigo_regional.value=='' && document.forms[0].codigo_representante.value==''){document.forms[0].reg.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                </td>

              </tr>

            </table>

            <html:form action="adm/LimiteCreditoDisponivelForm.do" method="POST" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr>
                  <td class=noBanner>

                  </td>
                </tr>
              </table>
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr">
                  <td class="messageTd">

                    <%
                    String rep_rzao = "";
                    String codigo_regional1="";
                    String codigo_representante1="";
                    String tipo1="";
                    acesso.Usuario u1 = new acesso.Usuario();
                    u1 = (acesso.Usuario)session.getAttribute("User");
                    acesso.EntidadeNegocio ent1 = new acesso.EntidadeNegocio();
                    acesso.TipoEntidadeNegocio tipoent1 = new acesso.TipoEntidadeNegocio();

                    if(!(u1.getEntidadeNegocio()==null)){
                      ent1 = (acesso.EntidadeNegocio) u1.getEntidadeNegocio();
                      tipoent1 = (acesso.TipoEntidadeNegocio) ent1.getTipoEntidadeNegocio();
                      tipo1 = tipoent1.getTipo()+"";
                      if(tipo1.equals("REGIONAL DE VENDA")){
                        codigo_regional1 = ent1.getChave()+"";
                      }
                      if((tipo1.equals("REPRESENTANTE COMERCIAL")) || (tipo1.equals("REPRESENTANTE EXPORTACAO"))){
                        codigo_representante1 = ent1.getChave()+"";
                      }

                    }

                    String fieldRelationValue = "";
                    com.egen.util.jdbc.JdbcUtil j = null;
                    try {
                      if ((!(codigo_representante1.equals("")))){
                        j = new com.egen.util.jdbc.JdbcUtil();
                        portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
                        Object[][] where = { {"rep_cdgo","like",codigo_representante1} };
                        String[] order = null;
                        java.util.Vector results = j.select(db_object, where, order);
                        if (results != null && results.size() > 0) {
                          db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
                          fieldRelationValue = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
                        }
                      }
                    } catch (Exception e) {
                      fieldRelationValue = "";
                    } finally {
                      if (j != null) {
                        j.close();
                      }
                    }
                    rep_rzao = fieldRelationValue;


                    if(codigo_regional1.equals("") && codigo_representante1.equals("")) {
                      %>
                      <!-- <div class="div10l"> Um dos campos com <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/> deve ser preenchido. </div> -->
                      <%
                    }
                    %>

                    <%
                    if(!user.isSuperUsuario() && !user.isAutorizado(99)){
                      response.sendRedirect("../system/Error.jsp");
                    }
                    %>

                    <html:errors property="reg"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="limite_inicial"/>
                    <html:errors property="limite_final"/>
                    <html:errors property="quantidade"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <%
                String codigo_regional="";
                String codigo_representante="";
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

                }
                %>
                <%
                if((codigo_regional.equals("")) && (codigo_representante.equals(""))) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Regional
                      </span>
                      <!--  <img src="../img/opcional.gif" border="0"  title="Opcional" style="cursor:pointer"/> -->
                    </td>
                    <td class="formField">
                      <html:text property="reg" onblur="if(this.value!=''){fillFields(0,new Array('reg'),'LimiteCreditoDisponivelActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value=''};" styleClass="baseField" size="3" maxlength="3"/>
                      <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=reg&return1=nome_regional','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="40"/>
                    </td>
                  </tr>
                  <%
                }
                %>
                <%
                if((!(codigo_regional.equals("")))
                ||
                ((codigo_regional.equals("")) && (codigo_representante.equals("")))
                ){
                  %>
                  <%
                  if((!(codigo_regional.equals("")))){
                    %>

                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Representante
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="rep_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'LimiteCreditoDisponivelActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" styleClass="baseField" size="5" maxlength="5"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>

                        <%
                      }else{
                        %>

                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Representante
                            </span>
                            <!--  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/> -->
                          </td>
                          <td class="formField">
                            <html:text property="rep_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'LimiteCreditoDisponivelActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" styleClass="baseField" size="5" maxlength="5"/>
                            <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>

                            <%
                          }
                          %>
                          <span class="spamFormLabel" >
                          </span>
                          <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="38" maxlength="35"/>
                        </td>
                      </tr>
                      <%
                    }
                    %>
                    <%
                    if((!(codigo_representante.equals("")))){
                      %>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Representante
                          </span>
                        </td>
                        <td class="formField">
                          <html:text property="rep_cdgo" styleClass="disabled" tabindex="-1" readonly="true" value="<%= codigo_representante %>"  size="3" maxlength="3"/>
                          <input type="button" class="lovButton" disabled="true" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                          <span class="spamFormLabel" >
                          </span>
                          <html:text property="rep_rzao" value="<%= rep_rzao %>" styleClass="disabled" tabindex="-1" readonly="true" size="38" maxlength="35"/>
                        </td>
                      </tr>

                      <%
                    }
                    %>
                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Limite Inicial
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="limite_inicial" styleId="limite_inicial" styleClass="baseField" size="15"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Limite Final
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="limite_final" styleId="limite_final" styleClass="baseField" size="15"/>
                      </td>
                    </tr>


                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Quantidade
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="quantidade" styleClass="baseField" size="6" maxlength="6"/>
                      </td>
                    </tr>


                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Totalizar por Grupo Econômico
                        </span>
                      </td>
                      <td class="formField">
                        <html:checkbox property="cb_totalizar_grupo_economico" styleId="cb_totalizar_grupo_economico" styleClass="baseField" value="1"/>
                      </td>
                    </tr>


                    <html:hidden property="codigo_regional" value="<%= codigo_regional %>"/>
                    <html:hidden property="codigo_representante" value="<%= codigo_representante %>"/>
                  </table>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;select_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                        <script language="javascript">
                          function getKeySite(keyStroke) {
                            isNetscape=(document.layers);
                            eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                            which = String.fromCharCode(eventChooser).toLowerCase();
                            keyBuffer = which;
                            if(eventChooser == 13){

                            if(document.forms[0].select1_action.disabled==true){return false;}
                            document.forms[0].select1_action.disabled=true;
                            document.forms[0].resetfull1_action.disabled=true;
                            bloqueia();
                            document.forms[0].select_action.click();
                          }
                        }
                      </script>
                      <script language="javascript">
                        document.onkeypress = getKeySite;
                      </script>



                      <html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>
                      <html:submit styleClass="myhidden" property="select_action" >
                        <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      <html:submit  styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
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
