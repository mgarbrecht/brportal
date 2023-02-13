<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ConsultaPedidosForaNormasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ConsultaPedidosForaNormasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("cli_cdgo","Código Cliente");
    hashMapLabel.set("seq","Seq.");
    hashMapLabel.set("esc_cgc","CNPJ do Cliente");
    hashMapLabel.set("representante","representante");
    hashMapLabel.set("regional","regional");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("dt_inicial","Data Inicial");
    hashMapLabel.set("dt_final","Data Final");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("ref_cdgo","Referência");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("free_i","<b>Consulta Direta</b>");
    hashMapLabel.set("free2","");
    hashMapLabel.set("nr_pedido1","Número do Pedido");
    hashMapLabel.set("rep","");
    hashMapLabel.set("reg","");
    hashMapLabel.set("free_f","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Consulta de Pedidos Fora das Normas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(74)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ConsultaPedidosForaNormasForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="seq"/>
                    <html:errors property="esc_cgc"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
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
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" styleClass="baseField" size="10" maxlength="22"/>
                    <span class="spamFormLabel">
                      Seq.
                    </span>
                    <html:text property="seq" styleClass="baseField" size="3" maxlength="3"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      CNPJ do Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="esc_cgc" styleClass="baseField" size="15" maxlength="14"/>
                  </td>
                </tr>

                <html:hidden property="representante" value="<%= codigo_representante %>"/>
                <html:hidden property="regional" value="<%= codigo_regional %>"/>
                <%
                if(codigo_representante.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Representante
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'ConsultaPedidosForaNormasActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()"  >
                      <script type="text/javascript">
                        function lov_open_rep_cdgo() {
                          window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                    </td>
                  </tr>

                  <%
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
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
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
                    <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10" maxlength="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'ConsultaPedidosForaNormasActionForm.getLin_nome_Ajax',new Array('lin_nome'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('../lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Referência
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'ConsultaPedidosForaNormasActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('../lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="28" maxlength="25"/>
                  </td>
                </tr>

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
                  </SCRIPT><html:button accesskey="r" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:button>
                  <html:submit styleClass="myhidden" property="select_action"><bean:message bundle="ApplicationResources" key="jsp.select"/></html:submit>
                  <html:submit onclick="resetfull_action.click();" styleClass="myhidden" property="resetfull_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                  </td>
                  </tr>
                  </table>

                  <script type="text/javascript">
                  jQuery(document).ready(function($) {
                    $("#dt_inicial").mask("99/99/9999");
                    $("#dt_final").mask("99/99/9999");
                    });
                  </script>
                </html:form>
                <script type="text/javascript">
                  var focusControl = document.forms[0].elements["cli_cdgo"];
                  if (focusControl.type != "hidden"){
                    focusControl.focus();
                  }
                </script>

                <html:form action="com/ConsultaPedidosForaNormasForm.do" method="post" styleClass="baseForm">
                  <table class="itemTable"  style=" width:;">
                  </table>
                  <table class="separatorTable">
                    <tr class="separatorTr">
                      <td colspan="2" class="separatorTd">
                        <b>
                          Consulta Direta
                        </b>
                      </td>
                    </tr>
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
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Número do Pedido
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="nr_pedido1" styleClass="baseField"/>
                        <html:button accesskey="p" onclick="this.disabled=true; select3_action.click();" styleClass="baseButton" property="select1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>
                      </td>
                    </tr>

                    <html:hidden property="rep" value="<%= codigo_representante %>"/>
                    <html:hidden property="reg" value="<%= codigo_regional %>"/>
                  </table>
                  <table class="itemTable" style='width:99%;'>

                    <table class="buttonTable" style='width:99%;'>
                      <tr class="buttonTr">
                        <td class="buttonTd">
                          <html:submit accesskey="s" styleClass="myhidden" property="select3_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
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
