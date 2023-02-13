<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/VendaEstrategicosActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = VendaEstrategicosActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("marca_cdgo","Marca");
    hashMapLabel.set("marca_desc","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_desc","");
    hashMapLabel.set("ref_cdgo","Ref");
    hashMapLabel.set("ref_desc","");
    hashMapLabel.set("cab_cdgo","Cabedal");
    hashMapLabel.set("cab_desc","");
    hashMapLabel.set("cor_cdgo","Cor");
    hashMapLabel.set("cor_desc","");
    hashMapLabel.set("tipo_estoque","");
    hashMapLabel.set("tipos_estoques","");
    hashMapLabel.set("qtde_ini","Qtde Inicial");
    hashMapLabel.set("qtde_fim","Qtde Final");
    hashMapLabel.set("grade","Grade");
    hashMapLabel.set("mix","Mix / Fora mix");
    hashMapLabel.set("cb_img_prod","Imprimir Imagem Produto");
    hashMapLabel.set("cb_preco","Mostrar Preço");
    hashMapLabel.set("cb_painel","Painel");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Venda de Estratégicos
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(37)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/VendaEstrategicosForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="marca_cdgo"/>
                    <html:errors property="marca_desc"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_desc"/>
                    <html:errors property="ref_cdgo"/>
                    <html:errors property="ref_desc"/>
                    <html:errors property="cab_cdgo"/>
                    <html:errors property="cab_desc"/>
                    <html:errors property="cor_cdgo"/>
                    <html:errors property="cor_desc"/>
                    <html:errors property="tipo_estoque"/>
                    <html:errors property="qtde_ini"/>
                    <html:errors property="qtde_fim"/>
                    <html:errors property="grade"/>
                    <html:errors property="mix"/>
                    <html:errors property="cb_img_prod"/>
                    <html:errors property="cb_preco"/>
                    <html:errors property="cb_painel"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="marca_cdgo" styleId="marca_cdgo" onblur="fillFields(0,new Array('marca_cdgo'),'VendaEstrategicosActionForm.getMarca_desc_Ajax',new Array('marca_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_marca_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_marca_cdgo() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=marca_cdgo&return1=marca_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="marca_desc" styleId="marca_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="fillFields(0,new Array('lin_cdgo'),'VendaEstrategicosActionForm.getLin_desc_Ajax',new Array('lin_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_desc" styleId="lin_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Ref
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="ref_cdgo" styleId="ref_cdgo" onblur="fillFields(0,new Array('lin_cdgo','ref_cdgo'),'VendaEstrategicosActionForm.getRef_desc_Ajax',new Array('ref_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_ref_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_ref_cdgo() {
                        window.open('..//lov/LvRefLov.do?resetfull_action=&returnBlock=0&return0=ref_cdgo&return1=ref_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="ref_desc" styleId="ref_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cabedal
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cab_cdgo" styleId="cab_cdgo" onblur="fillFields(0,new Array('cab_cdgo'),'VendaEstrategicosActionForm.getCab_desc_Ajax',new Array('cab_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_cab_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_cab_cdgo() {
                        window.open('..//lov/LvCabedalLov.do?resetfull_action=&returnBlock=0&return0=cab_cdgo&return1=cab_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cab_desc" styleId="cab_desc" styleClass="disabled" tabindex="-1" readonly="true" size="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Cor
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="cor_cdgo" styleId="cor_cdgo" onblur="fillFields(0,new Array('cor_cdgo'),'VendaEstrategicosActionForm.getCor_desc_Ajax',new Array('cor_desc'));" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex=-1 value="..."  onclick="javascript:lov_open_cor_cdgo()"  >
                    <script type="text/javascript">
                      <script type="text/javascript">
                      function lov_open_cor_cdgo() {
                        window.open('..//lov/LvCorLov.do?resetfull_action=&returnBlock=0&return0=cor_cdgo&return1=cor_desc','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                      }
                    </script>



                    <span class="spamFormLabel">
                    </span>
                    <html:text property="cor_desc" styleId="cor_desc" onblur="fillFields(0,new Array('cor_cdgo','cor_desc'),'VendaEstrategicosActionForm.getCor_cdgo_Ajax',new Array());" styleClass="disabled" tabindex="-1" readonly="true" size="28"/>
                  </td>
                </tr>

                <%
                if(false){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="tipo_estoque" disabled="true" styleId="tipo_estoque" styleClass="myhidden"/>
                      <input type="button" class="lovButton"  value="Tipo de Estoque"  onclick="javascript:lov_open_tipo_estoque()"  >
                      <script type="text/javascript">
                        function lov_open_tipo_estoque() {
                          window.open('..//lov/LvTipoEstoqueGrdGrid.do?select_action','','scrollbars=yes,height=510,width=730,top=0,left=0,');
                        }
                      </script>
                    </td>
                  </tr>

                  <%
                }
                %>
                <%
                if(false){
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                      </span>
                    </td>
                    <td class="formField">
                      <%
                      int counterbl_report_Jw_clientes_enderecos =0;
                      int i_bl_report_Jw_clientes_enderecos =0;
                      java.util.Vector res_Jw_clientes_grupos_economicos = (java.util.Vector)session.getAttribute("tipos_estoque");
                      if (res_Jw_clientes_grupos_economicos!=null && res_Jw_clientes_grupos_economicos.size()>0) {
                        %>
                        <table id="TRbl_report_Jw_clientes_enderecos" class="reportTable" style=width:340px; border=1;  >
                          <tr class="reportHeader" >
                            <td align="center">
                              Tipo Estoque selecionados
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

                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde Inicial
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtde_ini" styleId="qtde_ini" styleClass="baseField" size="6"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Qtde Final
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="qtde_fim" styleId="qtde_fim" styleClass="baseField" size="6"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Grade
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="grade" styleId="grade" styleClass="baseField" size="4"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix / Fora mix
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="T\"selected='selected'">
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
                      Imprimir Imagem Produto
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_img_prod" styleId="cb_img_prod" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mostrar Preço
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_preco" styleId="cb_preco" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Painel
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="cb_painel" styleId="cb_painel" styleClass="baseField" value="checked"/>
                  </td>
                </tr>

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
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button accesskey="s" value="Gerar" onclick="this.disabled=true;bloqueia();document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
                    </html:button>
                    <html:button accesskey="r" onclick="document.forms[0].resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit accesskey="s" value="Gerar Relatório" onclick="bloqueia();" styleClass="myhidden" property="select_action">
                    </html:submit>
                    <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                jQuery(document).ready(function($) {
                  $("#data_inicial").mask("99/99/9999");
                  $("#data_final").mask("99/99/9999");
                  });



                  jQuery("#cb_img_prod").attr('checked', true);
                  jQuery("#cb_preco").attr('checked', true);
                </script>
              </html:form>
              <script type="text/javascript">
                var focusControl = document.forms[0].elements["marca_cdgo"];
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
