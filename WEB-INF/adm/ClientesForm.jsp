<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ClientesActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ClientesActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("ecl_cdad","Cidade do Cliente");
    hashMapLabel.set("cli_nome","Nome Fantasia");
    hashMapLabel.set("f_repi","");
    hashMapLabel.set("representante","Representante");
    hashMapLabel.set("rep_rzao","");
    hashMapLabel.set("f_repf","");
    hashMapLabel.set("f_regi","");
    hashMapLabel.set("regional","Regional");
    hashMapLabel.set("nome_regional","");
    hashMapLabel.set("f_regf","");
    hashMapLabel.set("rep","rep");
    hashMapLabel.set("reg","reg");
    hashMapLabel.set("est_unifed","Estado");
    hashMapLabel.set("est_descri","");
    hashMapLabel.set("gre_grupo","Grupo");
    hashMapLabel.set("gre_descricao","");
    hashMapLabel.set("tra_consig","Consignatário");
    hashMapLabel.set("tra_rzao","");
    hashMapLabel.set("excluir_segmentos","Excluir Segmentos");
    hashMapLabel.set("f_mri","");
    hashMapLabel.set("mostrar_representantes","Mostrar Representantes");
    hashMapLabel.set("f_mrf","");
    hashMapLabel.set("f_pi","");
    hashMapLabel.set("ordenacao","Ordenação");
    hashMapLabel.set("pagamento","Pagamento");
    hashMapLabel.set("situacao","Situação<br>Cliente");
    hashMapLabel.set("situacao_cliente_representante","Situação<br>Cliente/Repres.");
    hashMapLabel.set("f_pf","");
    hashMapLabel.set("somente_email","");
    hashMapLabel.set("tipo_arquivo","Tipo de Arquivo");
    var reportColumns = new Array();
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Listagem de Clientes
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(65)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/ClientesForm.do" method="POST" styleClass="baseForm" target="_self">
              <%
              String codigo_regional="";
              String codigo_representante="";
              String tipo="";
              boolean mostrar_representantes = false;
              acesso.Usuario u = new acesso.Usuario();
              u = (acesso.Usuario)session.getAttribute("User");
              acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
              acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
              if(user.isSuperUsuario()){
                mostrar_representantes = true;
              }
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
                if(tipo.equals("AREAS")){
                  mostrar_representantes = true;
                }
                if(tipo.equals("ANALISTA REGIONAL")){
                  mostrar_representantes = true;
                }
                if(tipo.equals("REGIONAL DE VENDA")){
                  mostrar_representantes = true;
                }
              }
              %>

              <%
              if(!user.isSuperUsuario() && !user.isAutorizado(65)){
                response.sendRedirect("../system/Error.jsp");
              }
              %>

              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr">
                  <td class="messageTd">
                    <%
                    if(codigo_representante.equals("") && codigo_regional.equals("")){
                      %>
                      <div style=font-size:11px;font-weight:normal;>
                        <div class\='div10l'>
                          Um dos campos com
                          <img src='../img/opcional.gif' border\='0' title\='Opcional' style\='cursor\:pointer'>
                          deve ser preenchido.
                        </div>
                      </div>
                      <%
                    }
                    %>
                    <html:errors property="ecl_cdad"/>
                    <html:errors property="representante"/>
                    <html:errors property="rep_rzao"/>
                    <html:errors property="regional"/>
                    <html:errors property="nome_regional"/>
                    <html:errors property="est_unifed"/>
                    <html:errors property="est_descri"/>
                    <html:errors property="gre_grupo"/>
                    <html:errors property="gre_descricao"/>
                    <html:errors property="excluir_segmentos"/>
                    <html:errors property="ordenacao"/>
                    <html:errors property="pagamento"/>
                    <html:errors property="situacao"/>
                    <html:errors property="situacao_cliente_representante"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes"/>
                  </td>
                </tr>
              </table>
              <table class="itemTable" style='width:99%;'>
                <%
                if(codigo_regional.equals("") && codigo_representante.equals("")) {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Cidade do Cliente
                      </span>
                      <img src="../img/opcional.gif" border="0"/>
                    </td>
                    <td class="formField">
                      <html:text property="ecl_cdad" styleClass="baseField" size="60" maxlength="60"/>
                    </td>
                  </tr>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Nome Fantasia
                      </span>
                      <img src="../img/opcional.gif" border="0"/>
                    </td>
                    <td class="formField">
                      <html:text property="cli_nome" styleClass="baseField" size="60" maxlength="60"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Cidade do Cliente
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="ecl_cdad" styleClass="baseField" size="60" maxlength="60"/>
                    </td>
                  </tr>

                  <tr>
                    <td class="formLabel">
                      <span class="spamFormLabel" >
                        Nome Fantasia
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cli_nome" styleClass="baseField" size="60" maxlength="60"/>
                    </td>
                  </tr>

                  <%
                }
                %>
                <%
                if(codigo_representante.equals("")){
                  %>
                  <%
                  if(codigo_regional.equals("") && codigo_representante.equals("")) {
                    %>
                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Representante
                        </span>
                        <img src="../img/opcional.gif" border="0"/>
                      </td>
                      <td class="formField">
                        <html:text property="representante" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('representante'),'ClientesActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" size="5" maxlength="5"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=representante&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <%
                      }  else {
                        %>
                        <tr>
                          <td class="formLabel">
                            <span class="spamFormLabel" >
                              Representante
                            </span>
                          </td>
                          <td class="formField">
                            <html:text property="representante" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('representante'),'ClientesActionForm.getRep_rzao_Ajax',new Array('rep_rzao'))}else{rep_rzao.value=''};" size="5" maxlength="5"/>
                            <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRepresentante2Lov.do?resetfull_action=&returnBlock=0&return0=representante&return1=rep_rzao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
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
                    if((codigo_regional.equals(""))&&(codigo_representante.equals(""))){
                      %>
                      <tr>
                        <td class="formLabel">
                          <span class="spamFormLabel" >
                            Regional
                          </span>
                          <img src="../img/opcional.gif" border="0"/>
                        </td>
                        <td class="formField">
                          <html:text property="regional" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('regional'),'ClientesActionForm.getNome_regional_Ajax',new Array('nome_regional'))}else{nome_regional.value=''};" size="3" maxlength="3"/>
                          <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvRegionalLov.do?resetfull_action=&returnBlock=0&return0=regional&return1=nome_regional','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                          <span class="spamFormLabel" >
                          </span>
                          <html:text property="nome_regional" styleId="nome_regional" styleClass="disabled" tabindex="-1" readonly="true" size="43" maxlength="40"/>
                        </td>
                      </tr>
                      <%
                    }
                    %>

                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Estado
                        </span>
                        <img src="../img/opcional.gif" border="0"/>
                      </td>
                      <td class="formField">
                        <html:text property="est_unifed" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('est_unifed'),'ClientesActionForm.getEst_descri_Ajax',new Array('est_descri'))}else{est_descri.value=''};" size="2" maxlength="2"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvEstadosLov.do?resetfull_action=&returnBlock=0&return0=est_unifed&return1=est_descri','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <span class="spamFormLabel" >
                        </span>
                        <html:text property="est_descri" styleId="est_descri" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                      </td>
                    </tr>


                    <html:hidden property="rep" value="<%= codigo_representante %>"/>
                    <html:hidden property="reg" value="<%= codigo_regional %>"/>

                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Grupo
                        </span>
                        <%
                        if(codigo_regional.equals("") && codigo_representante.equals("")) {
                          %>
                          <img src="../img/opcional.gif" border="0"/>
                          <%
                        }
                        %>
                      </td>
                      <td class="formField">
                        <html:text property="gre_grupo" styleClass="baseField" onblur="if(this.value!=''){fillFields(0,new Array('gre_grupo'),'ClientesActionForm.getGre_descricao_Ajax',new Array('gre_descricao'))}else{gre_descricao.value=''};" size="6" maxlength="6"/>
                        <input type="button" class="lovButton" value="..." tabindex="-1" onclick="window.open('../lov/LvGrupoEconomicoLov.do?resetfull_action=&returnBlock=0&return0=gre_grupo&return1=gre_descricao','','scrollbars,height=510,width=600,top=0,left=0,')"/>
                        <span class="spamFormLabel" >
                        </span>
                        <html:text property="gre_descricao" styleId="gre_descricao" styleClass="disabled" tabindex="-1" readonly="true" size="35" maxlength="30"/>
                      </td>
                    </tr>

                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Consignatário
                        </span>
                        <img src="../img/opcional.gif" border="0"/>
                      </td>
                      <td class="formField">
                        <html:text property="tra_consig" styleId="tra_consig" onblur="fillFields(0,new Array('tra_consig'),'ClientesActionForm.getTra_rzao_Ajax',new Array('tra_rzao'));" styleClass="baseField" size="6"/>
                        <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_tra_consig()"  >
                        <script type="text/javascript">
                          function lov_open_tra_consig() {
                            window.open('..//lov/LvConsignatarioLov.do?resetfull_action=&returnBlock=0&return0=tra_consig&return1=tra_rzao','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                          }
                        </script>
                        <span class="spamFormLabel">
                        </span>
                        <html:text property="tra_rzao" styleId="tra_rzao" styleClass="disabled" tabindex="-1" readonly="true" size="40" maxlength="45"/>
                      </td>
                    </tr>


                    <tr>
                      <td class="formLabel">
                        <span class="spamFormLabel" >
                          Excluir Segmentos
                        </span>
                      </td>
                      <td class="formField">
                        <html:text property="excluir_segmentos" styleClass="baseField" size="30" />
                        <i>
                          Separados por vírgula
                        </i>
                      </td>
                    </tr>

                    <%
                    if(mostrar_representantes){
                      %>
                      <tr class="itemTr">
                        <td class="formLabel">
                          <span class="spamFormLabel">
                            Mostrar Representantes
                          </span>
                        </td>
                        <td class="formField">
                          <html:checkbox property="mostrar_representantes" styleId="mostrar_representantes" styleClass="baseField" value="1"/>
                        </td>
                      </tr>

                      <%
                    } else {
                      %>
                      <html:hidden property="mostrar_representantes" value="n" />
                      <%
                    }
                    %>



                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Clientes com E-mail
                        </span>
                      </td>
                      <td class="formField">

                        <html:select property="somente_email" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="T">
                            Todos
                          </html:option>
                          <html:option styleClass="baseOption" value="S">
                            Sim
                          </html:option>
                          <html:option styleClass="baseOption" value="N">
                            Não
                          </html:option>
                        </html:select>

                      </td>
                    </tr>







                    <tr class="itemTr">
                      <td class="formLabel">
                        <span class="spamFormLabel">
                          Tipo de Geração
                        </span>
                      </td>
                      <td class="formField">

                        <html:select property="tipo_arquivo" styleClass="baseField" size="1">
                          <html:option styleClass="baseOption" value="t">
                            Tela
                          </html:option>
                          <html:option styleClass="baseOption" value="pdf">
                            PDF
                          </html:option>

                          <html:option styleClass="baseOption" value="xls">
                            Planilha
                          </html:option>

                        </html:select>

                      </td>
                    </tr>



                    <tr class="itemTr">
                      <td class="formLabel">
                      </td>
                      <td class="formField">
                        <table border=1 style="border-color:#f4c5a2">
                          <tr>
                            <td style="text-align:center; width: 150px">
                              <b>
                                Ordenação
                              </b>
                            </td>
                            <td style="text-align:center; width: 150px">
                              <b>
                                Pagamento
                              </b>
                            </td>
                            <td style="text-align:center; width: 150px">
                              <b>
                                Situação
                                <br>
                                Cliente
                              </b>
                            </td>
                            <td style="text-align:center; width: 150px">
                              <b>
                                Situação
                                <br>
                                Cliente/Repres.
                              </b>
                            </td>
                          </tr>
                          <tr>
                            <td style="text-align:center;">
                              <html:select property="ordenacao" styleClass="baseField" size="1">
                                <html:option styleClass="baseOption" value="C">
                                  Cidade
                                </html:option>
                                <html:option styleClass="baseOption" value="E">
                                  Estado/Cidade
                                </html:option>
                                <html:option styleClass="baseOption" value="R">
                                  Razão Social
                                </html:option>
                                <html:option styleClass="baseOption" value="G">
                                  Grupo Econômico/Cidade
                                </html:option>
                              </html:select>
                            </td>

                            <td style="text-align:center;">
                              <html:select property="pagamento" styleClass="baseField" size="1">
                                <html:option styleClass="baseOption" value="T">
                                  Todos
                                </html:option>
                                <html:option styleClass="baseOption" value="N">
                                  Tabela Normal
                                </html:option>
                                <html:option styleClass="baseOption" value="V">
                                  Tabela Vendor
                                </html:option>
                              </html:select>
                            </td>

                            <td style="text-align:center;">
                              <html:select property="situacao" styleClass="baseField" size="1">
                                <html:option styleClass="baseOption" value="A">
                                  Ativos
                                </html:option>
                                <html:option styleClass="baseOption" value="I">
                                  Inativos
                                </html:option>
                                <html:option styleClass="baseOption" value="null">
                                  Todos
                                </html:option>
                              </html:select>
                            </td>

                            <td style="text-align:center;">
                              <html:select property="situacao_cliente_representante" styleClass="baseField" size="1">
                                <html:option styleClass="baseOption" value="A">
                                  Ativos
                                </html:option>
                                <html:option styleClass="baseOption" value="I">
                                  Inativos
                                </html:option>
                                <html:option styleClass="baseOption" value="null">
                                  Todos
                                </html:option>


                              </html:select>
                            </td>

                          </tr>
                        </table>
                      </td>
                    </tr>

                  </table>



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



                  <%
                  if(request.getAttribute("arquivo_xls")!=null){
                    %>
                    <table style=width:100%;margin-top:10;>
                      <tr>
                        <td class=columHeader style="text-align:center;">
                          <a href="<%= (String)request.getAttribute("arquivo_xls") %>" target="_blank">
                            <bean:message key="report.downloadxls"/>
                          </a>
                        </td>
                      </tr>
                    </table>
                    <%
                  }
                  %>






                  <table class="itemTable" style='width:100%;'>
                  </table>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button accesskey="p" styleClass="baseButton" property="select1_action" onclick="bloqueia();resetfull1_action.disabled=true;this.disabled=true;document.forms[0].select_action.click();">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:button>

                        <html:button accesskey="l" onclick="document.forms[0].reset();resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:button>

                        <html:submit styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>

                        <html:submit accesskey="r" styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>

                      </td>
                    </tr>
                  </table>
                </html:form>
                <script type="text/javascript" language="JavaScript">
                  <!--
                  var focusControl = document.forms[0].elements["ecl_cdad"];
                  if (focusControl.type != "hidden") {
                    focusControl.focus();
                  }
                // -->
                </script>

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







          </td>
        </tr>
      </table>

    </body>
  </center>
</html>
