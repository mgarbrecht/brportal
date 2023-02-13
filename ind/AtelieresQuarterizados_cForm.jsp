<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/AtelieresQuarterizados_cActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = AtelieresQuarterizados_cActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_atelieri","");
    hashMapLabel.set("fo_codigo","Atelier");
    hashMapLabel.set("fo_razsoc","");
    hashMapLabel.set("f_atelierf","");
    hashMapLabel.set("atelier","");
    hashMapLabel.set("tipo","Tipo de Leitura");
    hashMapLabel.set("fornecedor","Fornecedor/Seq.");
    hashMapLabel.set("seq","");
    hashMapLabel.set("fornecedor_desc","");
    hashMapLabel.set("pro_codigo","Processo");
    hashMapLabel.set("pro_nome","");
    hashMapLabel.set("f_i","");
    hashMapLabel.set("codigo_barra","Código de Barras");
    hashMapLabel.set("lido","");
    hashMapLabel.set("f_f","");
    hashMapLabel.set("fornecedor_codigo","fornecedor_codigo");
    hashMapLabel.set("fornecedor_codigo_quarterizado","fornecedor_codigo_quarterizado");
    hashMapLabel.set("fen_seq_quarterizado","fen_seq_quarterizado");
    hashMapLabel.set("pro_numero","pro_numero");
    hashMapLabel.set("rem_nro","rem_nro");
    hashMapLabel.set("tal_nro","tal_nro");
    hashMapLabel.set("usuario","");
    var reportColumns = new Array(new Array("fornecedor_codigo","fornecedor_codigo_quarterizado","fen_seq_quarterizado","fornecedor_razsoc","pro_numero","pro_nome","data_envio","data_retorno","rem_nro","tal_nro","status","status_descricao","usuario_inclusao","usuario_alteracao","excluir"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Envio/Retorno Talões - Atelier Interno
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
                    //  response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/AtelieresQuarterizados_cForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="fo_codigo"/>
                    <html:errors property="fo_razsoc"/>
                    <html:errors property="tipo"/>
                    <html:errors property="fornecedor"/>
                    <html:errors property="seq"/>
                    <html:errors property="fornecedor_desc"/>
                    <html:errors property="pro_codigo"/>
                    <html:errors property="pro_nome"/>
                    <html:errors property="codigo_barra"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String atelier = null;
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                  atelier = sessao.getChave();
                }
                %>
                <%
                if(atelier == null) {
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Atelier
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="fo_codigo" styleId="fo_codigo" onblur="fillFields(0,new Array('fo_codigo'),'AtelieresQuarterizados_cActionForm.getFo_razsoc_Ajax',new Array('fo_razsoc'));" styleClass="baseField" size="9"/>
                      <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_fo_codigo()"  >
                      <script type="text/javascript">
                        function lov_open_fo_codigo() {
                          window.open('..//lov/LvAtelierLov.do?resetfull_action=&returnBlock=0&return0=fo_codigo&return1=fo_razsoc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                        }
                      </script>
                      <span class="spamFormLabel">
                      </span>
                      <html:text property="fo_razsoc" styleId="fo_razsoc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="fo_codigo" value="<%= atelier %>" />
                  <html:hidden property="fo_razsoc " value="" />

                  <%
                }
                %>
                <html:hidden property="atelier" value="<%= atelier %>"/>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Tipo de Leitura
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:select property="tipo" styleId="tipo" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="E">
                        Envio
                      </html:option>
                      <html:option styleClass="baseOption" value="R">
                        Retorno
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Fornecedor/Seq.
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="fornecedor" onblur="fillFields(0,new Array('fornecedor'),'AtelieresQuarterizados_cActionForm.getFornecedor_desc_Ajax',new Array('fornecedor_desc'));" styleClass="baseField" size="10" maxlength="9"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="seq" styleId="seq" onblur="fillFields(0,new Array('fornecedor','seq','atelier'),'AtelieresQuarterizados_cActionForm.getFornecedor_desc_Ajax',new Array('fornecedor_desc'));" styleClass="baseField" size="3"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_seq()"  >
                    <script type="text/javascript">
                      function lov_open_seq() {
                        window.open('..//lov/LvFornecedorQuarterizadoLov.do?resetfull_action=&returnBlock=0&return0=fornecedor&return1=seq&return2=fornecedor_desc','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="fornecedor_desc" styleId="fornecedor_desc" styleClass="disabled" tabindex="-1" readonly="true" size="45" maxlength="40"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Processo
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="pro_codigo" styleId="pro_codigo" onblur="fillFields(0,new Array('pro_codigo'),'AtelieresQuarterizados_cActionForm.getPro_nome_Ajax',new Array('pro_nome'));" styleClass="baseField" size="3" maxlength="3"/>
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
              </table>
              <table class="itemTable" style='width:99%;'>
                <html:hidden property="fornecedor_codigo"/>
                <html:hidden property="fornecedor_codigo_quarterizado"/>
                <html:hidden property="fen_seq_quarterizado"/>
                <html:hidden property="pro_numero"/>
                <html:hidden property="rem_nro"/>
                <html:hidden property="tal_nro"/>
                <html:hidden property="usuario" value="<%= sessao.getUsuario() %>"/>
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
                      </SCRIPT><html:button accesskey="l" value="Limpar Talões Lidos" onclick="resetfull_talao_action.click();" styleClass="myhidden" property="resetfull_talao1_action"></html:button>
                      <html:submit styleClass="myhidden" property="resetfull2_action"><bean:message bundle="ApplicationResources" key="jsp.reset"/></html:submit>
                      <html:submit accesskey="a" styleClass="myhidden" property="delete_action"><bean:message bundle="ApplicationResources" key="jsp.delete"/></html:submit>
                      </td>
                      </tr>
                      </table>

                      </html:form><script type="text/javascript">
                      var focusControl = document.forms[0].elements["fornecedor"];
                      if (focusControl.type != "hidden"){
                        focusControl.focus();
                      }
                    </script>

                    <%
                    {
                      %>

                      <%
                      String fornecedor = null;
                      acesso.Sessao sessao = new acesso.Sessao(session);
                      if(sessao.getTipoEntidadeNegocio().equals("ATELIER")){
                        fornecedor = sessao.getChave();
                      } else {
                        fornecedor = "-1";
                      }
                      java.util.Vector res_Jw_atelier_pre_envio_quarterizado = null;
                      com.egen.util.jdbc.JdbcUtil j = null;
                      try {
                        j = new com.egen.util.jdbc.JdbcUtil();
                        portalbr.dbobj.view.Jw_atelier_pre_envio_quarterizado t_jw_atelier_pre_envio_quarterizado = new portalbr.dbobj.view.Jw_atelier_pre_envio_quarterizado();
                        String[][] select = {{"fornecedor_codigo",null},{"fornecedor_codigo_quarterizado",null},{"fen_seq_quarterizado",null},{"fornecedor_razsoc",null},{"pro_numero",null},{"pro_nome",null},{"data_envio",null},{"data_retorno",null},{"rem_nro",null},{"tal_nro",null},{"status",null},{"status_descricao",null},{"usuario_inclusao",null},{"usuario_alteracao",null},};
                        Object[][] where = {{"fornecedor_codigo","=", fornecedor}};
                        String[] groupby =  null;
                        String[] having =  null;
                        String[] order = {"data_ordenacao desc"};
                        res_Jw_atelier_pre_envio_quarterizado = j.select(t_jw_atelier_pre_envio_quarterizado,select,where,groupby,having,order);
                      } catch (Exception e){
                        session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                        %>
                        <jsp:forward page="/system/ErrorPage.jsp"/>
                        <%
                      } finally {
                      if(j!=null){j.close();}
                    }
                    %>

                    <form  name="bl_report_Jw_atelier_pre_envio_quarterizado" id="bl_report_Jw_atelier_pre_envio_quarterizado" class="baseForm" method="post" >
                      <%
                      if (res_Jw_atelier_pre_envio_quarterizado!=null && res_Jw_atelier_pre_envio_quarterizado.size()>0) {
                        %>

                        <table id="TRbl_report_Jw_atelier_pre_envio_quarterizado"  class="reportTable"   style="width:99%; "  border="1" >
                          <%
                          java.lang.Integer fornecedor_codigo =  null;
                          java.lang.Integer fornecedor_codigo_quarterizado =  null;
                          java.lang.Integer fen_seq_quarterizado =  null;
                          java.lang.String fornecedor_razsoc =  null;
                          java.lang.Integer pro_numero =  null;
                          java.lang.String pro_nome =  null;
                          java.sql.Timestamp data_envio =  null;
                          java.sql.Timestamp data_retorno =  null;
                          java.lang.Integer rem_nro =  null;
                          java.lang.Integer tal_nro =  null;
                          java.lang.String status =  null;
                          java.lang.String status_descricao =  null;
                          java.lang.String usuario_inclusao =  null;
                          java.lang.String usuario_alteracao =  null;
                          java.lang.String excluir =  null;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:right;" >
                              Fornecedor
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Seq.
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Razão Social
                            </td>

                            <td class="columnTdHeader" style="text-align:left;" >
                              Nome
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Envio
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Retorno
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Remessa
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Talão
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Status
                            </td>

                            <td class="columnTdHeader" style="text-align:center;"  onclick="return confirmSubmit('');" >
                              Excluir
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Jw_atelier_pre_envio_quarterizado = 0;
                          while (i_bl_report_Jw_atelier_pre_envio_quarterizado<res_Jw_atelier_pre_envio_quarterizado.size()) {
                            portalbr.dbobj.view.Jw_atelier_pre_envio_quarterizado t_jw_atelier_pre_envio_quarterizado = (portalbr.dbobj.view.Jw_atelier_pre_envio_quarterizado)res_Jw_atelier_pre_envio_quarterizado.elementAt(i_bl_report_Jw_atelier_pre_envio_quarterizado);
                            fornecedor_codigo = t_jw_atelier_pre_envio_quarterizado.getFornecedor_codigo();
                            fornecedor_codigo_quarterizado = t_jw_atelier_pre_envio_quarterizado.getFornecedor_codigo_quarterizado();
                            fen_seq_quarterizado = t_jw_atelier_pre_envio_quarterizado.getFen_seq_quarterizado();
                            fornecedor_razsoc = t_jw_atelier_pre_envio_quarterizado.getFornecedor_razsoc()==null?"":t_jw_atelier_pre_envio_quarterizado.getFornecedor_razsoc();
                            pro_numero = t_jw_atelier_pre_envio_quarterizado.getPro_numero();
                            pro_nome = t_jw_atelier_pre_envio_quarterizado.getPro_nome()==null?"":t_jw_atelier_pre_envio_quarterizado.getPro_nome();
                            data_envio = (java.sql.Timestamp)t_jw_atelier_pre_envio_quarterizado.getData_envio();
                            data_retorno = (java.sql.Timestamp)t_jw_atelier_pre_envio_quarterizado.getData_retorno();
                            rem_nro = t_jw_atelier_pre_envio_quarterizado.getRem_nro();
                            tal_nro = t_jw_atelier_pre_envio_quarterizado.getTal_nro();
                            status = t_jw_atelier_pre_envio_quarterizado.getStatus()==null?"":t_jw_atelier_pre_envio_quarterizado.getStatus();
                            status_descricao = t_jw_atelier_pre_envio_quarterizado.getStatus_descricao()==null?"":t_jw_atelier_pre_envio_quarterizado.getStatus_descricao();
                            usuario_inclusao = t_jw_atelier_pre_envio_quarterizado.getUsuario_inclusao()==null?"":t_jw_atelier_pre_envio_quarterizado.getUsuario_inclusao();
                            usuario_alteracao = t_jw_atelier_pre_envio_quarterizado.getUsuario_alteracao()==null?"":t_jw_atelier_pre_envio_quarterizado.getUsuario_alteracao();
                            String style_bl_report_Jw_atelier_pre_envio_quarterizado="";
                            if (!((i_bl_report_Jw_atelier_pre_envio_quarterizado%2)!=0)) {
                              style_bl_report_Jw_atelier_pre_envio_quarterizado="rowColor";
                            } else {
                              style_bl_report_Jw_atelier_pre_envio_quarterizado="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Jw_atelier_pre_envio_quarterizado %>' id="TRbl_report_Jw_atelier_pre_envio_quarterizado<%=i_bl_report_Jw_atelier_pre_envio_quarterizado%>" >
                              <td class="reportColumn" style="text-align:right;" >
                                <%= ((fornecedor_codigo_quarterizado!=null)?fornecedor_codigo_quarterizado.toString():"") %>
                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= ((fen_seq_quarterizado!=null)?fen_seq_quarterizado.toString():"") %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <%= fornecedor_razsoc %>
                              </td>

                              <td class="reportColumn" style="text-align:left;" >
                                <%= pro_nome %>
                              </td>

                              <td class="reportColumn" style="text-align:center;" >
                                <%= com.egen.util.text.FormatDate.format(data_envio, "dd/MM/yyyy HH:mm:ss") %>
                              </td>

                              <td class="reportColumn" style="text-align:center;" >
                                <%= com.egen.util.text.FormatDate.format(data_retorno, "dd/MM/yyyy HH:mm:ss") %>
                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= ((rem_nro!=null)?rem_nro.toString():"") %>
                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= ((tal_nro!=null)?tal_nro.toString():"") %>
                              </td>

                              <td class="reportColumn" style="text-align:center;" >
                                <%= status_descricao %>
                              </td>

                              <td class="reportColumn" style="text-align:center;" onclick="return confirmSubmit('');" >
                                <a href="../ind/AtelieresQuarterizados_cForm.do?delete_action=&fornecedor_codigo=<%= fornecedor_codigo %>&fornecedor_codigo_quarterizado=<%= fornecedor_codigo_quarterizado %>&fen_seq_quarterizado=<%= fen_seq_quarterizado %>&pro_numero=<%= pro_numero %>&rem_nro=<%= rem_nro %>&tal_nro=<%= tal_nro %>" style="cursor:hand">
                                  Excluir
                                </a>
                              </td>

                            </tr>

                            <%
                            i_bl_report_Jw_atelier_pre_envio_quarterizado++;
                            if (i_bl_report_Jw_atelier_pre_envio_quarterizado<res_Jw_atelier_pre_envio_quarterizado.size()) {
                              t_jw_atelier_pre_envio_quarterizado = (portalbr.dbobj.view.Jw_atelier_pre_envio_quarterizado)res_Jw_atelier_pre_envio_quarterizado.elementAt(i_bl_report_Jw_atelier_pre_envio_quarterizado);
                              fornecedor_codigo = t_jw_atelier_pre_envio_quarterizado.getFornecedor_codigo();
                              fornecedor_codigo_quarterizado = t_jw_atelier_pre_envio_quarterizado.getFornecedor_codigo_quarterizado();
                              fen_seq_quarterizado = t_jw_atelier_pre_envio_quarterizado.getFen_seq_quarterizado();
                              fornecedor_razsoc = t_jw_atelier_pre_envio_quarterizado.getFornecedor_razsoc()==null?"":t_jw_atelier_pre_envio_quarterizado.getFornecedor_razsoc();
                              pro_numero = t_jw_atelier_pre_envio_quarterizado.getPro_numero();
                              pro_nome = t_jw_atelier_pre_envio_quarterizado.getPro_nome()==null?"":t_jw_atelier_pre_envio_quarterizado.getPro_nome();
                              data_envio = (java.sql.Timestamp)t_jw_atelier_pre_envio_quarterizado.getData_envio();
                              data_retorno = (java.sql.Timestamp)t_jw_atelier_pre_envio_quarterizado.getData_retorno();
                              rem_nro = t_jw_atelier_pre_envio_quarterizado.getRem_nro();
                              tal_nro = t_jw_atelier_pre_envio_quarterizado.getTal_nro();
                              status = t_jw_atelier_pre_envio_quarterizado.getStatus()==null?"":t_jw_atelier_pre_envio_quarterizado.getStatus();
                              status_descricao = t_jw_atelier_pre_envio_quarterizado.getStatus_descricao()==null?"":t_jw_atelier_pre_envio_quarterizado.getStatus_descricao();
                              usuario_inclusao = t_jw_atelier_pre_envio_quarterizado.getUsuario_inclusao()==null?"":t_jw_atelier_pre_envio_quarterizado.getUsuario_inclusao();
                              usuario_alteracao = t_jw_atelier_pre_envio_quarterizado.getUsuario_alteracao()==null?"":t_jw_atelier_pre_envio_quarterizado.getUsuario_alteracao();
                            } else {
                            }
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
        </center>
      </html>
