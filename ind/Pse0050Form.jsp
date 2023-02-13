<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>


  <script type="text/javascript" src="../script/util.js"></script> 
  <script type="text/javascript" src="../script/jquery-1.7.2.min.js"></script>  
  <script type="text/javascript" src="../script/jquery.noty.packaged.min.js"></script>  
  <script>$.noConflict();</script>



  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/Pse0050ActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = Pse0050ActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("tipo","Tipo de Leitura");
    hashMapLabel.set("fornecedor","Fornecedor");
    hashMapLabel.set("fornecedor_desc","");
    hashMapLabel.set("pro_codigo","Processo");
    hashMapLabel.set("pro_nome","");
    hashMapLabel.set("f_i","");
    hashMapLabel.set("codigo_barra","Código de Barras");
    hashMapLabel.set("lido","");
    hashMapLabel.set("mensagem","");
    hashMapLabel.set("f_f","");
    var reportColumns = new Array(new Array("for_codigo"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Atelier Pré-Envio - Coletor
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("codigobarra") %>' != 'null'){document.forms[0].codigo_barra.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(150)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/Pse0050Form.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="tipo"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="fornecedor_desc"/>
                    <html:errors property="pro_codigo"/>
                    <html:errors property="pro_nome"/>
                    <html:errors property="codigo_barra"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String for_codigo="";
                String tipo="";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("ATELIER")){
                    for_codigo = ent.getChave()+"";
                  }
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Leitura
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="disabled" tabindex="-1" size="1">
                      <html:option styleClass="baseOption" value="R">
                        Retorno
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <%
                      if(for_codigo.equals("")){
                        %>
                        Fornecedor
                        <%
                      }
                      %>

                    </span>
                  </td>
                  <td class="formField">
                    <%
                    if(!for_codigo.equals("")){
                      %>
                      <html:hidden property="fornecedor" value="<%= for_codigo %>"/>
                      <%
                    } else {
                      %>
                      <html:text property="fornecedor" onblur="fillFields(0,new Array('fornecedor'),'Pse0050ActionForm.getFornecedor_desc_Ajax',new Array('fornecedor_desc'));" styleClass="baseField" size="9" maxlength="9"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fornecedor()"  >


                      <script type="text/javascript">
                        function lov_open_fornecedor() {
                          window.open('..//lov/LvFornecedorAtelierLov.do?resetfull_action=&returnBlock=0&return0=fornecedor&return1=fornecedor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fornecedor_desc" styleId="fornecedor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Processo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pro_codigo" styleId="pro_codigo" onblur="fillFields(0,new Array('pro_codigo'),'Pse0050ActionForm.getPro_nome_Ajax',new Array('pro_nome'));" styleClass="baseField" size="3" maxlength="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_pro_codigo()"  >
                    <script type="text/javascript">
                      function lov_open_pro_codigo() {
                        window.open('..//lov/LvProcesso_fabLov.do?resetfull_action=&returnBlock=0&return0=pro_codigo&return1=pro_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="pro_nome" styleId="pro_nome" styleClass="disabled" tabindex="-1" size="45" maxlength="40"/>
                  </td>
                </tr>

              </table>
              <table class="separatorTable">
                <tr >
                  <td colspan="2" class="separatorTd">
                  </td>
                </tr>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código de Barras
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_barra" styleId="codigo_barra" onblur="if(this.value!=''){document.forms[0].lido.value='S';processa_action.click();}" styleClass="baseField"/>
                  </td>
                </tr>

                <html:hidden property="lido"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                    </span>
                  </td>
                  <td class="formField">
                    <%
                    portalbr.ind.Pse0050ActionForm Pse0050ActionForm = (portalbr.ind.Pse0050ActionForm)session.getAttribute("Pse0050ActionForm");
                    if(!(request.getAttribute("codigobarra")+"").equals("null")){
                      if((Pse0050ActionForm.getMensagem()+"").indexOf("ok")==-1){
                        %>
                        <html:text property="mensagem" styleId="mensagem" style="font-size:13; background-color:#FFA07A; border-color:gray; cursor:default; font-weight:bold;text-align:center;" styleClass="baseField" tabindex="-1" readonly="true" size="120" maxlength="120"/>
                        <%
                      } else {
                        %>
                        <html:text property="mensagem" styleId="mensagem" style="font-size:13; background-color:#B0C4DE; border-color:gray; cursor:default; font-weight:bold;text-align:center;" styleClass="baseField" tabindex="-1" readonly="true" size="120" maxlength="120"/>
                        <%
                      } }
                      %>

                    </td>
                  </tr>


                </table>
                <table class="itemTable" style='width:99%;'>
                </table>

                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="p" value="processa" styleClass="myhidden" property="processa_action">
                      </html:submit>
                      <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:submit styleClass="myhidden" property="resetfull_talao_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:submit>
                      <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                        <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                      </html:button>



                      <script>
                        function getKeySite(keyStroke) {
                          isNetscape=(document.layers);
                          eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                          which = String.fromCharCode(eventChooser).toLowerCase();
                          keyBuffer = which;
                          if(eventChooser == 13){
                            document.forms[0].processa_action.click();
                          }
                        }
                      </script>
                      <SCRIPT>
                        document.onkeypress = getKeySite;
                        </SCRIPT><html:button accesskey="l" value="Limpar Talões Lidos" onclick="resetfull_talao_action.click();" styleClass="baseButton" property="resetfull_talao1_action"></html:button>
                        <html:submit styleClass="myhidden" property="resetfull2_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                        </td>
                        </tr>
                        </table>

                        </html:form><script type="text/javascript">
                        var focusControl = document.forms[0].elements["pro_codigo"];
                        if (focusControl.type != "hidden"){
                          focusControl.focus();
                        }
                      </script>

                      <%
                      {
                        %>

                        <%
                        java.util.Vector<String> res_Atelier_pre_envio = (java.util.Vector<String>)session.getAttribute("v_atelier");
                        if(session.getAttribute("atelier_cor")==null){
                          session.setAttribute("atelier_cor","c");
                        }
                        %>

                        <form  name="bl_report_Atelier_pre_envio" id="bl_report_Atelier_pre_envio" class="baseForm" method="post" >
                          <%
                          if (res_Atelier_pre_envio!=null && res_Atelier_pre_envio.size()>0) {
                            %>

                            <table id="TRbl_report_Atelier_pre_envio"  class="reportTable"   style="width:99%;" border=1;  >

                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:left;" >
                                  <b>
                                    Talões lidos
                                  </b>
                                </td>
                              </tr>
                              <%
                              int i_bl_report_Atelier_pre_envio = 0;
                              for(int x=res_Atelier_pre_envio.size()-1;x>=0;x--){
                                String style_bl_report_Atelier_pre_envio="";
                                if (res_Atelier_pre_envio.elementAt(x).substring(0,1).equals("c")) {
                                  style_bl_report_Atelier_pre_envio="rowColor";
                                } else {
                                  style_bl_report_Atelier_pre_envio="rowBlank";
                                }
                                %>
                                <tr class='<%= style_bl_report_Atelier_pre_envio %>' id="TRbl_report_Atelier_pre_envio<%=i_bl_report_Atelier_pre_envio%>" >
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= res_Atelier_pre_envio.elementAt(x).substring(1,res_Atelier_pre_envio.elementAt(x).length()) %>
                                  </td>
                                </tr>
                                <%
                                i_bl_report_Atelier_pre_envio++;
                              }
                              %>

                            </table>

                            <%
                          }
                          %>

                        </form>
                        <%
                      }
                      %>

                    </td>
                  </tr>
                </table>

              </body>


<% if(session.getAttribute("ultimoTalaoRemessa")!=null) { %>

<script type="text/javascript">
    function generate(type) {
        var n = noty({
            text        : type,
            type        : type,
            dismissQueue: false,
            layout      : 'topCenter',
            theme       : 'relax'
        });
        return n;
    }

    jQuery(document).ready(function () {
        var information = generate('information');
         setTimeout(function () {
            jQuery.noty.setText(information.options.id, '<%= session.getAttribute("ultimoTalaoRemessa") %>');
        }, 0);

        setTimeout(function () {
            jQuery.noty.closeAll();
        }, 4000);

    });

</script>

<%
 }
 session.removeAttribute("ultimoTalaoRemessa"); 
%>


            </center>
          </html>