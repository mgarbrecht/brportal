<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/LimiteCreditoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = LimiteCreditoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("free_regional_i","");
    hashMapLabel.set("codigo_regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("free_regional_f","");
    hashMapLabel.set("free_representante_i","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("free_representante_f","");
    hashMapLabel.set("situacao","Situação");
    hashMapLabel.set("rep","");
    hashMapLabel.set("reg","");
    hashMapLabel.set("situacao_cr","Situação Cliente/Representante");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Limite de Crédito
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].reg.value=='' && document.forms[0].rep.value==''){document.forms[0].codigo_regional.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(100)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/LimiteCreditoForm.do" method="POST" styleClass="baseForm" target="_self">
              <%
              String regional="";
              String representante="";
              String representante_nome="";
              String regional_nome="";
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
                  regional = ent.getChave()+"";
                  //-------------------------------------------
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.table.Regionais_vendas db_object = new portalbr.dbobj.table.Regionais_vendas();
                    Object[][] where = {
                    {"codigo_regional","like",regional}
                    };
                    String[] order = null;
                    java.util.Vector results = j.select(db_object, where, order);
                    if (results!=null && results.size()>0) {
                      db_object = (portalbr.dbobj.table.Regionais_vendas)results.elementAt(0);
                      regional_nome = (db_object.getNome_regional()!=null)?db_object.getNome_regional()+"":"";
                    }

                  } catch (Exception e) {
                    representante_nome = "";
                  } finally {
                  if (j!=null) { j.close(); }
                }
                //-------------------------------------------
              }
              if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                representante = ent.getChave()+"";
                //-------------------------------------------
                com.egen.util.jdbc.JdbcUtil j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
                  Object[][] where = {
                  {"rep_cdgo","like",representante}
                  };
                  String[] order = null;
                  java.util.Vector results = j.select(db_object, where, order);
                  if (results!=null && results.size()>0) {
                    db_object = (portalbr.dbobj.table.Rep)results.elementAt(0);
                    representante_nome = (db_object.getRep_rzao()!=null)?db_object.getRep_rzao()+"":"";
                  }

                } catch (Exception e) {
                  representante_nome = "";
                } finally {
                if (j!=null) { j.close(); }
              }
              //-------------------------------------------
            }

          }

          if(regional ==""){
            %>
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr">
                <td class="messageTd">
                  <div style=font-size:11px;font-weight:normal;>
                    <div class\='div10l'>
                      Um dos campos com
                      <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                      deve ser preenchido.
                    </div>
                  </div>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito"/>
                </td>
              </tr>
            </table>
            <%
          }
          %>

          <%
          if(!user.isSuperUsuario() && !user.isAutorizado(100)){
            response.sendRedirect("../system/Error.jsp");
          }
          %>

          <table class="itemTable" style='width:99%;'>

            <%
            if( (regional== "")&&(representante=="")){
              %>

              <tr>
                <td class="formLabel">
                  <span class="spamFormLabel" >
                    Regional
                  </span>
                  <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                </td>
                <td class="formField">
                  <html:text property="codigo_regional" onblur="if(this.value!=''){fillFields(0,new Array('codigo_regional'),'LimiteCreditoActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value=''};" styleClass="baseField" size="3" maxlength="3"/>
                  <input type="button" class="lovButton" tabindex="-1" value="..." onclick="window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=codigo_regional&return1=nome_regional','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                  <span class="spamFormLabel" >
                  </span>
                  <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="40"/>
                </td>
              </tr>
              <%
            }

            if(regional!="") {
              %>

              <html:hidden property="codigo_regional" value="<%= regional %>"/>
              <html:hidden property="nome_regional"/>


              <%
            }
            %>
            <%
            if((representante== "")){
              %>

              <%
              if(regional == ""){
                %>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Represent.
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="rep_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'LimiteCreditoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" styleClass="baseField" size="5" maxlength="5"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <%
                  }else {
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Represent.
                        </span>
                      </td>

                      <td class="formField">
                        <html:text property="rep_cdgo" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'LimiteCreditoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" size="5" maxlength="5"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <%
                      }
                      %>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="38" maxlength="35"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Representante
                      </span>
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" readonly="true" styleClass="disabled" onblur="if(this.value!=''){fillFields(0,new Array('rep_cdgo'),'LimiteCreditoActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" size="5" maxlength="5" value="<%= representante %>"/>
                      <input type="button" disabled="true" class="lovButton" tabindex="-1" value="..." onclick="window.open('../lov/LvRepresentanteLov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                      <span class="spamFormLabel" >
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" value="<%= representante_nome %>" size="38" maxlength="35"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Situação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Suspensos
                      </html:option>
                    </html:select>
                  </td>
                </tr>
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Situação Cliente/ Representante
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="situacao_cr" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="A">
                        Ativos
                      </html:option>
                      <html:option styleClass="baseOption" value="I">
                        Inativos
                      </html:option>
                    </html:select>
                  </td>
                </tr>





                <html:hidden property="rep" value="<%= representante %>"/>
                <html:hidden property="reg" value="<%= regional %>"/>
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
                        if(document.forms[0].select1_action.disabled==true){return false;}
                        document.forms[0].select1_action.disabled=true;
                        document.forms[0].resetfull1_action.disabled=true;
                        bloqueia();
                        document.forms[0].select_action.click();
                      }
                    }
                  </script>
                  <SCRIPT>
                    document.onkeypress = getKeySite;
                    </SCRIPT><html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                    <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                    <html:submit styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                    </td></tr></table>
                    </html:form>
                    <script type="text/javascript" language="JavaScript">
                    <!--
                    var focusControl = document.forms[0].elements["rep_cdgo"];
                    if (focusControl.type != "hidden") {
                      focusControl.focus();
                    }
                  // -->
                  </script>



                </td>
              </tr>
            </table>

          </body>
        </center>
      </html>
