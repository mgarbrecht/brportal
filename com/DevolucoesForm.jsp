<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/DevolucoesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = DevolucoesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("f_free","");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("unn_codigo","Unid. Negócio");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("abre_automaticamente","Abre o Relatório Automaticamente");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_pdf","");
    hashMapLabel.set("regional","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Relatório de Devoluções
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(140)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/DevolucoesForm.do" method="post" styleClass="baseForm" target="_self">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="marca"/>
                    <html:errors property="unn_codigo"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String codigo_analista="";
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
                  if(tipo.equals("ANALISTA REGIONAL")){
                    codigo_analista = ent.getChave()+"";
                    com.egen.util.jdbc.JdbcUtil j = null;
                    java.sql.PreparedStatement pstm = null;
                    java.sql.ResultSet rset = null;
                    try {
                      j = new com.egen.util.jdbc.JdbcUtil();
                      pstm = j.getConn().prepareStatement("select grv.codigo_regional from gerentes_regionais_vendas grv where grv.codigo_gerente = "+ent.getChave());
                      rset = pstm.executeQuery();
                      while (rset.next()) {
                        codigo_regional = rset.getInt(1)+"";
                      }
                    } catch (Exception e) {
                    } finally {
                      if(rset != null) {
                        rset.close();
                      }
                      if(pstm != null) {
                        pstm.close();
                      }
                      if (j != null) {
                        j.close();
                        j = null;
                      }
                    }
                  }

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
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="marca" styleId="marca" styleClass="baseField" size="1">
                      <html:options property="marcaList" labelProperty="marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Unid. Negócio
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="unn_codigo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="">
                        TODAS
                      </html:option>
                      <html:option styleClass="baseOption" value="01">
                        MANUFATURADOS
                      </html:option>
                      <html:option styleClass="baseOption" value="02">
                        ASSANDALIADOS
                      </html:option>
                      <html:option styleClass="baseOption" value="03">
                        INJECAO DIRETA
                      </html:option>
                    </html:select>
                  </td>
                </tr>

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
                      <html:text property="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'DevolucoesActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5" maxlength="5"/>
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
                } else {
                  %>

                  <html:hidden property="rep_cdgo" value="<%=codigo_representante %>" />
                  <html:hidden property="rep_rzao" value="" />

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" tabindex="-1" readonly="true" size="70" maxlength="70"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
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
                    <html:hidden property="regional" value="<%= codigo_regional %>"/>
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
                      </td>
                      </tr>
                      </table>

                      </html:form>
                      <script type="text/javascript">
                      var focusControl = document.forms[0].elements["rep_cdgo"];
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
