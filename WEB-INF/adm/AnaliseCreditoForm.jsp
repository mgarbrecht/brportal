<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AnaliseCreditoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AnaliseCreditoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("gre_grupo","Grupo");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("clientes_selecionados","");
    hashMapLabel.set("cli_cdgo","Cliente");
    hashMapLabel.set("cli_rzao","");
    hashMapLabel.set("emp_empresa","Empresa");
    hashMapLabel.set("emp_razsoc","");
    hashMapLabel.set("free","");
    hashMapLabel.set("meses","Meses Atrás");
    hashMapLabel.set("clientes","cliente");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Análise de Crédito
    </title>
  </head>
  <center>
    <body >
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(61)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/AnaliseCreditoForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                      <div class\='div10l'>
                        Todos os campos com
                        <img src='../img/required.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        devem ser preenchidos.
                      </div>
                    </div>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="cli_cdgo"/>
                    <html:errors property="cli_rzao"/>
                    <html:errors property="emp_empresa"/>
                    <html:errors property="emp_razsoc"/>
                    <html:errors property="meses"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Grupo
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="gre_grupo"  tabindex="1" styleClass="baseField" onblur="fillFields(0,new Array('gre_grupo'),'AnaliseCreditoActionForm.getGre_descricao_Ajax',new Array('gre_descricao'));" size="6" maxlength="6"/>
                    <input type="button" class="lovButton" value="..." tabindex=-1 onclick="window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <span class="spamFormLabel" >
                    </span>
                    <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                    <html:button value="Clientes" styleClass="baseButton" property="select1_action" tabindex="-1" onclick="if(document.forms[0].gre_grupo.value==''){alert('Informe o Grupo!');return false;};window.open('../lov/ClientesGruposGrid.do?select_action=&gre_grupo='+document.forms[0].gre_grupo.value,'','scrollbars,height=400,width=500,top=0,left=0,')">

                    </html:button>


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
                    java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("clientes_grupo");
                    if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                      %>
                      <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:40%; border=1;  >
                        <tr class="reportHeader" >
                          <td align="center">
                            Clientes Selecionados
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


                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Cliente
                    </span>
                    <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                  </td>
                  <td class="formField">
                    <html:text property="cli_cdgo" tabindex="2" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('cli_cdgo'),'AnaliseCreditoActionForm.getCli_rzao_Ajax',new Array('cli_rzao'))}else{cli_rzao.value=''};" size="10" maxlength="22"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvClienteLov.do?resetfull_action=&returnBlock=0&return0=cli_cdgo&return1=cli_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cli_rzao" styleId="cli_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>
                  </td>
                </tr>

                <tr>
                  <td class="formLabel">
                    <span class="spamFormLabel" >
                      Empresa
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="emp_empresa" value="01"  styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvEmpresaLov.do?resetfull_action=&returnBlock=0&return0=emp_empresa&return1=emp_razsoc','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="emp_razsoc" styleId="emp_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="55" maxlength="50"/>
                  </td>
                </tr>

                <%
                com.egen.util.jdbc.JdbcUtil j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  portalbr.adm.AnaliseCreditoActionForm f = (portalbr.adm.AnaliseCreditoActionForm) session.getAttribute("AnaliseCreditoActionForm");

                  if((((f.getCli_cdgo()+"")!="") && (!((f.getCli_cdgo()+"").equals("null"))))){
                    if((((f.getGre_grupo()+"").equals("")) && (!((f.getGre_grupo()+"").equals("null"))))){
                      portalbr.dbobj.view.Jw_clientes_grupos_economicos table = new portalbr.dbobj.view.Jw_clientes_grupos_economicos();
                      String[][] select = null;
                      Object[][] where = { {"Cli_cdgo","like", f.getCli_cdgo()}};
                      Vector res_Jw_clientes_grupos_economicos_2 = j.select(table, select, where, null, null, null);
                      if (res_Jw_clientes_grupos_economicos_2 != null && res_Jw_clientes_grupos_economicos_2.size() > 0) {
                        portalbr.dbobj.view.Jw_clientes_grupos_economicos r = (portalbr.dbobj.view.Jw_clientes_grupos_economicos) res_Jw_clientes_grupos_economicos_2.elementAt(0);
                        f.setGre_grupo((r.getGre_grupo() != null) ? r.getGre_grupo() + "":"");
                        f.setGre_descricao((r.getGre_descricao() != null) ? r.getGre_descricao() + "":"");
                      }
                    }
                  }

                } finally {
                  if(j!=null){
                    j.close();
                    j = null;
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Meses Atrás
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="meses" styleClass="baseField" size="6"/>
                  </td>
                </tr>

                <html:hidden property="clientes"/>
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
                      if(eventChooser == 13){ bloqueia();if(document.forms[0].select1_action.disabled==true){return false;}
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
                  <html:submit accesskey="p" value="pop" styleClass="myhidden" property="pop_action">
                  </html:submit>
                  </td>
                  </tr>
                  </table>

                  </html:form>
                  <script type="text/javascript">
                  var focusControl = document.forms[0].elements["gre_grupo"];
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
