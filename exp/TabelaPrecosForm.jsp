<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/TabelaPrecosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = TabelaPrecosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("codigo_livro","Livro");
    hashMapLabel.set("versao","Versão");
    hashMapLabel.set("marca","Marca");
    hashMapLabel.set("tipo_linha","Tipo");
    hashMapLabel.set("dt_inicial","Dt. Emb. Inicial");
    hashMapLabel.set("dt_final","Dt. Emb. Final");
    hashMapLabel.set("cliente","Cliente");
    hashMapLabel.set("pais","País");
    hashMapLabel.set("mix","Mix / Fora mix");
    hashMapLabel.set("abrir_cabedal","Abrir Cabedal");
    hashMapLabel.set("f_novo_item","");
    hashMapLabel.set("f_xls","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <bean:message key="page.scriptcalendar"/>
  <head>
    <title>
      Tabela de Preços - Exportação
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(209)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="exp/TabelaPrecosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="codigo_livro"/>
                    <html:errors property="versao"/>
                    <html:errors property="marca"/>
                    <html:errors property="tipo_linha"/>
                    <html:errors property="dt_inicial"/>
                    <html:errors property="dt_final"/>
                    <html:errors property="cliente"/>
                    <html:errors property="pais"/>
                    <html:errors property="mix"/>
                    <html:errors property="abrir_cabedal"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Tabela_preco_mercado_externo"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Livro
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_livro" styleId="codigo_livro" onblur="fillFields(0,new Array('codigo_livro'),'TabelaPrecosActionForm.getVersao_Ajax',new Array('versao'));" styleClass="baseField" size="4" maxlength="10"/>
                    <input type="button" class="lovButton" tabindex="-1"  value="..."  onclick="javascript:lov_open_codigo_livro()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_livro() {
                        window.open('..//lov/LvTabelaPrecoMercadoExternoLov.do?resetfull_action=&returnBlock=0&return0=codigo_livro&return1=versao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Versão
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="versao" styleId="versao" styleClass="disabled" tabindex="-1" readonly="true"/>
                  </td>
                </tr>

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
                      Tipo
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo_linha" styleId="tipo_linha" styleClass="baseField" size="1">
                      <html:options property="tipo_linhaList" labelProperty="tipo_linhaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Emb. Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_inicial" styleId="dt_inicial" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_inicial']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Dt. Emb. Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="dt_final" styleId="dt_final" styleClass="baseField" size="10"/>
                    &nbsp;
                    <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['dt_final']); cal1.year_scroll = true; cal1.popup();">
                      <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                    </a>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cliente
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="cliente" styleId="cliente" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      País
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pais" styleId="pais" styleClass="baseField"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix / Fora mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleId="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T">
                        Todos
                      </html:option>
                      <html:option styleClass="baseOption" value="M">
                        No Mix
                      </html:option>
                      <html:option styleClass="baseOption" value="F">
                        Fora Mix
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abrir Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="abrir_cabedal" styleId="abrir_cabedal" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        Não
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        Sim
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">

                    <html:button value="Adicionar Itens" styleClass="baseButton" property="button_action" onclick="wopen('../exp/TabelaPrecos_rcForm.jsp','_blank',800,600)">
                    </html:button>
                    <br>
                    <%
                    if (session.getAttribute("listaProdutos")==null){
                      %>
                      Nenhum Item Selecionado
                      <%
                    } else {
                      %>
                      <%= ((java.util.List<Object[][]>)session.getAttribute("listaProdutos")).size() %>
                      Modelo(s) Selecionado(s)
                      <img src="../img/viewmag.png" style="cursor:hand" name="imagem" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" onclick="wopen('../exp/TabelaPrecos_rmForm.jsp','_blank',800,600)">
                      <%
                    }
                    %>
                  </td>
                </tr>
                <%
                if((String)request.getAttribute("abre_automaticamente")=="N"){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                          <bean:message key="report.downloadxls"/>
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
                  <html:submit accesskey="l" styleClass="myhidden" property="refresh_action"><bean:message bundle="ApplicationResources" key="jsp.refresh"/></html:submit>
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
                  var focusControl = document.forms[0].elements["codigo_livro"];
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
