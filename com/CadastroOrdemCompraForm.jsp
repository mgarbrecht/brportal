<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/CadastroOrdemCompraActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = CadastroOrdemCompraActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("ordem_compra","O.C");
    hashMapLabel.set("rep_cdgo","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("cliente","Cliente");
    hashMapLabel.set("sequencial","Loja");
    hashMapLabel.set("dsp_cliente","");
    hashMapLabel.set("grupo_economico","Grupo Econômico");
    hashMapLabel.set("dsp_grupo","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("pedido","Pedido<img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Vincular Ordem de Compra ao Pedido
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(210)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/CadastroOrdemCompraForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <div style=font-size:11px;font-weight:normal;>
                      <div class\='div10l'>
                        Um dos campos com
                        <img src='../img/opcional.gif' border\='0' title\='Not Null' style\='cursor\:pointer'>
                        deve ser preenchido.
                      </div>
                    </div>
                    <html:errors property="ordem_compra"/>
                    <html:errors property="rep_cdgo"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="cliente"/>
                    <html:errors property="sequencial"/>
                    <html:errors property="dsp_cliente"/>
                    <html:errors property="grupo_economico"/>
                    <html:errors property="dsp_grupo"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="pedido"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String representante = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
                  representante = sessao.getChave();
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      O.C
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ordem_compra" styleId="ordem_compra" styleClass="baseField" size="12"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Representante
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">

                    <%
                    if(representante.equals("")){
                      %>

                      <html:text property="rep_cdgo" styleId="rep_cdgo" onblur="fillFields(0,new Array('rep_cdgo'),'CadastroOrdemCompraActionForm.getRep_rzao_Ajax',new Array('rep_rzao'));" styleClass="baseField" size="5"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_rep_cdgo()">

                      <%
                    } else {
                      %>

                      <html:text property="rep_cdgo" styleId="rep_cdgo" readonly="true" tabindex="-1" styleClass="disabled" value = "<%= representante %>" size="5"/>
                      <input type="button" class="lovButton"  value="..." disabled="true">

                      <%
                    }
                    %>

                    <script type="text/javascript">
                      function lov_open_rep_cdgo() {
                        window.open('..//lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=rep_cdgo&return1=rep_rzao','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>

                    <%
                    if(representante.equals("")) {
                      %>

                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="35"/>

                      <%
                    } else {
                      %>

                      <html:text property="rep_rzao" styleId="rep_rzao" styleClass="disabled" value="<%= sessao.getDescricao() %>" tabindex="-1" readonly="true" size="40" maxlength="35"/>

                      <%
                    }
                    %>
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" styleId="cliente" onblur="fillFields(0,new Array('cliente'),'CadastroOrdemCompraActionForm.getDsp_cliente_Ajax',new Array('dsp_cliente'));" styleClass="baseField" size="10"/>
                    <span class="spamFormLabel">
                      Loja
                    </span>
                    <html:text property="sequencial" styleId="sequencial" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton"  value="..."  onclick="javascript:lov_open_sequencial()"  >
                    <script type="text/javascript">
                      function lov_open_sequencial() {
                        window.open('..//lov/LvClienteSeqLov.do?resetfull_action=&returnBlock=0&return0=dsp_cliente&return1=sequencial&return2=cliente','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dsp_cliente" styleId="dsp_cliente" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grupo Econômico
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="grupo_economico" styleId="grupo_economico" onblur="fillFields(0,new Array('grupo_economico'),'CadastroOrdemCompraActionForm.getDsp_grupo_Ajax',new Array('dsp_grupo'));" styleClass="baseField" size="5"/>
                    <input type="button" class="lovButton"  value="..." tabindex="-1" onclick="javascript:lov_open_grupo_economico()"  >
                    <script type="text/javascript">
                      function lov_open_grupo_economico() {
                        window.open('..//lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=grupo_economico&return1=dsp_grupo','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="dsp_grupo" styleId="dsp_grupo" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" size="7"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Pedido
                      <img src="../img/opcional.gif" border="0" title="Opcional" style="cursor:pointer"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:textarea property="pedido" styleId="pedido" styleClass="baseField" cols="60" rows="4"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="s" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["ordem_compra"];
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
