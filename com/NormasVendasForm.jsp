<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/NormasVendasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = NormasVendasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("free","");
    hashMapLabel.set("f_marcai","");
    hashMapLabel.set("codigo_marca","default.label.marca");
    hashMapLabel.set("f_marcaf","");
    hashMapLabel.set("f_modarei","");
    hashMapLabel.set("modare","default.label.marca");
    hashMapLabel.set("f_modaref","");
    hashMapLabel.set("lin_cdgo","default.label.linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("f_publicadas_i","");
    hashMapLabel.set("publicadas","Publicadas");
    hashMapLabel.set("f_publicadas_f","");
    hashMapLabel.set("resumo_linhas","Resumo de Linhas");
    hashMapLabel.set("mix_exportacao","Mix Exportação");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array(new Array("lidi_titulo","lidi_caminho"),new Array("lidi_titulo1","lidi_caminho1"),new Array("lidi_id","lidi_titulo2","lidi_descricao","lidi_caminho2","lidi_marca","lidi_tipo"),new Array("lidi_titulo3","lidi_caminho3"),new Array("lidi_titulo4","lidi_caminho4"),new Array("lidi_id1","lidi_titulo5","lidi_descricao1","lidi_caminho5","lidi_marca1","lidi_tipo1"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      <bean:message bundle="ComercialResources" key="NormasVendas.titulo"/>
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(166)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/NormasVendasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo_marca"/>
                    <html:errors property="modare"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="publicadas"/>
                    <html:errors property="resumo_linhas"/>
                    <html:errors property="mix_exportacao"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                String bloqueia = "";
                String modare = "";
                acesso.Sessao sessao = new acesso.Sessao(session);
                if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                ||sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")
                ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")
                ){
                  bloqueia = "s";
                }



                if(sessao.getUsuario().equals("151563") ||
                sessao.getUsuario().equals("151489") ||
                sessao.getUsuario().equals("151169") ||
                sessao.getUsuario().equals("151882") ||
                sessao.getUsuario().equals("VANDERLEI") ||
                sessao.getUsuario().equals("MARIBEL") ||
                sessao.getUsuario().equals("151315") ||
                sessao.getUsuario().equals("151643") ||
                sessao.getUsuario().equals("151803") ||
                sessao.getUsuario().equals("151542") ||
                sessao.getUsuario().equals("151889") ||
                user.isSuperUsuario()){
                  modare = "S";
                } else {
                }

                modare = "S"; // Liberado para todos em 20/05/2013
                %>
                <%
                if(!modare.equals("S")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        <bean:message bundle="ComercialResources" key="default.label.marca"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="codigo_marca" styleId="codigo_marca" onblur="if(this.value!=''){fillFields(0,new Array('codigo_marca'),'NormasVendasActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));}else{descricao_marca.value='';}" styleClass="baseField" size="1">
                        <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="codigo_marca"/>
                  <%
                }
                %>
                <%
                if(modare.equals("S")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        <bean:message bundle="ComercialResources" key="default.label.marca"/>
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="modare" styleId="modare" styleClass="baseField" size="1">
                        <html:options property="modareList" labelProperty="modareLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="modare"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      <bean:message bundle="ComercialResources" key="default.label.linha"/>
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo'),'NormasVendasActionForm.getLin_nome_Ajax',new Array('lin_nome'));}else{lin_nome.value='';}" styleClass="baseField" size="6"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_lin_cdgo()"  >
                    <script type="text/javascript">
                      function lov_open_lin_cdgo() {
                        window.open('..//lov/LvLinhaLov.do?resetfull_action=&returnBlock=0&return0=lin_cdgo&return1=lin_nome','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="lin_nome" styleId="lin_nome" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="25"/>
                  </td>
                </tr>

                <%
                if(bloqueia.equals("")){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Publicadas
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="publicadas" styleId="publicadas" styleClass="baseField" size="1">
                        <html:option styleClass="baseOption" value="S">
                          <bean:message bundle='ComercialResources' key='default.value.sim'/>
                        </html:option>
                        <html:option styleClass="baseOption" value="N">
                          <bean:message bundle='ComercialResources' key='default.value.nao'/>
                        </html:option>
                      </html:select>
                    </td>
                  </tr>

                  <%
                } else {
                  %>
                  <html:hidden property="publicadas" value="S"/>
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Resumo de Linhas
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="resumo_linhas" styleId="resumo_linhas" styleClass="baseField" size="1">
                      <html:option styleClass="baseOption" value="N">
                        <bean:message bundle='ComercialResources' key='default.value.nao'/>
                      </html:option>
                      <html:option styleClass="baseOption" value="S">
                        <bean:message bundle='ComercialResources' key='default.value.sim'/>
                      </html:option>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Mix Exportação
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="mix_exportacao" styleId="mix_exportacao" styleClass="baseField" size="1">
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

                <%
                if(session.getAttribute("retrato") != null){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)session.getAttribute("retrato") %>" target="_blank">
                          <bean:message key="report.downloadpdf"/>
                        </a>
                      </td>
                    </tr>
                  </table>
                  <%
                }
                %>
                <%
                if(session.getAttribute("paisagem") != null){
                  %>
                  <table style=width:100%;margin-top:10;>
                    <tr>
                      <td class=columHeader style="text-align:center;">
                        <a href="<%= (String)session.getAttribute("paisagem") %>" target="_blank">
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
                    <html:button accesskey="p" onclick="resetfull1_action.disabled=true;bloqueia();this.disabled=true;document.forms[0].select_action.click();" styleClass="baseButton" property="select1_action">
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
                    </td>
                    </tr>
                    </table>

                    </html:form><script type="text/javascript">
                    var focusControl = document.forms[0].elements["codigo_marca"];
                    if (focusControl.type != "hidden"){
                      focusControl.focus();
                    }
                  </script>

                  <%
                  acesso.Sessao sessao = new acesso.Sessao(session);
                  if(!sessao.getTipoEntidadeNegocio().equals("CLIENTE MERCADO EXTERNO")){
                    %>


                    <table border="0" style="width:100%">
                      <tr valign="top">
                        <td>

                          <%
                          util.consultas.UsuarioMarca usuario = new util.consultas.UsuarioMarca(request);

                          if(usuario.atende("1")){
                            %>

                            <%
                            java.util.Vector res_Links_dinamicos = null;
                            com.egen.util.jdbc.JdbcUtil j = null;
                            try {
                              j = new com.egen.util.jdbc.JdbcUtil();
                              portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                              String[][] select = {{"lidi_titulo",null},{"lidi_caminho",null},};
                              Object[][] where = null;
                              where = new Object[][]{{"lidi_tipo","=","N"},
                              {"lidi_marca","=","1"},};
                              String[] groupby =  null;
                              String[] having =  null;
                              String[] order = {"lidi_titulo"};
                              res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
                            } catch (Exception e){
                              session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                              %>
                              <jsp:forward page="/system/ErrorPage.jsp"/>
                              <%
                            } finally {
                            if(j!=null){j.close();}
                          }
                          %>

                          <form  name="bl_report_Links_dinamicos" id="bl_report_Links_dinamicos" class="baseForm" method="post" >
                            <%
                            if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                              %>

                              <table id="TRbl_report_Links_dinamicos"  class="reportTable"   style="width:100%; "  >
                                <%
                                java.lang.String lidi_titulo =  null;
                                java.lang.String lidi_caminho =  null;
                                %>

                                <tr class="reportTr">
                                  <td class="columnTdHeader" style="text-align:center;" >
                                    Vizzano
                                  </td>

                                </tr>

                                <%
                                int i_bl_report_Links_dinamicos = 0;
                                while (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                                  portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                                  lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                                  lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                                  String style_bl_report_Links_dinamicos="";
                                  if (!((i_bl_report_Links_dinamicos%2)!=0)) {
                                    style_bl_report_Links_dinamicos="rowColor";
                                  } else {
                                    style_bl_report_Links_dinamicos="rowBlank";
                                  }
                                  %>

                                  <tr class='<%= style_bl_report_Links_dinamicos %>' id="TRbl_report_Links_dinamicos<%=i_bl_report_Links_dinamicos%>" >

                                    <td class="reportColumn" style="text-align:center;" >
                                      <a href="../arquivos/norma_venda/<%= lidi_caminho %>" target="_blank" STYLE="cursor:hand">
                                        <%= lidi_titulo %>
                                      </a>
                                    </td>

                                  </tr>

                                  <%
                                  i_bl_report_Links_dinamicos++;
                                  if (i_bl_report_Links_dinamicos<res_Links_dinamicos.size()) {
                                    t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos);
                                    lidi_titulo = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                                    lidi_caminho = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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
                      <td>


                        <%
                        if(usuario.atende("3")){
                          %>

                          <%
                          java.util.Vector res_Links_dinamicos = null;
                          com.egen.util.jdbc.JdbcUtil j = null;
                          try {
                            j = new com.egen.util.jdbc.JdbcUtil();
                            portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                            String[][] select = {{"lidi_titulo",null},{"lidi_caminho",null},};
                            Object[][] where = null;
                            where = new Object[][]{{"lidi_tipo","=","N"},
                            {"lidi_marca","=","3"},};
                            String[] groupby =  null;
                            String[] having =  null;
                            String[] order = {"lidi_titulo"};
                            res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
                          } catch (Exception e){
                            session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                            %>
                            <jsp:forward page="/system/ErrorPage.jsp"/>
                            <%
                          } finally {
                          if(j!=null){j.close();}
                        }
                        %>

                        <form  name="bl_report_Links_dinamicos_1" id="bl_report_Links_dinamicos_1" class="baseForm" method="post" >
                          <%
                          if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                            %>

                            <table id="TRbl_report_Links_dinamicos_1"  class="reportTable"   style="width:100%; "  >
                              <%
                              java.lang.String lidi_titulo1 =  null;
                              java.lang.String lidi_caminho1 =  null;
                              %>

                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Beira Rio
                                </td>


                              </tr>

                              <%
                              int i_bl_report_Links_dinamicos_1 = 0;
                              while (i_bl_report_Links_dinamicos_1<res_Links_dinamicos.size()) {
                                portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_1);
                                lidi_titulo1 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                                lidi_caminho1 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                                String style_bl_report_Links_dinamicos_1="";
                                if (!((i_bl_report_Links_dinamicos_1%2)!=0)) {
                                  style_bl_report_Links_dinamicos_1="rowColor";
                                } else {
                                  style_bl_report_Links_dinamicos_1="rowBlank";
                                }
                                %>

                                <tr class='<%= style_bl_report_Links_dinamicos_1 %>' id="TRbl_report_Links_dinamicos_1<%=i_bl_report_Links_dinamicos_1%>" >

                                  <td class="reportColumn" style="text-align:center;" >
                                    <a href="../arquivos/norma_venda/<%= lidi_caminho1 %>" target="_blank" STYLE="cursor:hand">
                                      <%= lidi_titulo1 %>
                                    </a>
                                  </td>

                                </tr>

                                <%
                                i_bl_report_Links_dinamicos_1++;
                                if (i_bl_report_Links_dinamicos_1<res_Links_dinamicos.size()) {
                                  t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_1);
                                  lidi_titulo1 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                                  lidi_caminho1 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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
                    <td>

                      <%
                      if(usuario.atende("16")){
                        %>

                        <%
                        java.util.Vector res_Links_dinamicos = null;
                        com.egen.util.jdbc.JdbcUtil j = null;
                        try {
                          j = new com.egen.util.jdbc.JdbcUtil();
                          portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                          String[][] select = {{"lidi_id",null},{"lidi_titulo",null},{"lidi_descricao",null},{"lidi_caminho",null},{"lidi_marca",null},{"lidi_tipo",null},};
                          Object[][] where = null;
                          where = new Object[][]{{"lidi_tipo","=","N"},
                        {"lidi_marca","=","16"}
                        ,};
                        String[] groupby =  null;
                        String[] having =  null;
                        String[] order = {"lidi_titulo"};
                        res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
                      } catch (Exception e){
                        session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                        %>
                        <jsp:forward page="/system/ErrorPage.jsp"/>
                        <%
                      } finally {
                      if(j!=null){j.close();}
                    }
                    %>

                    <form  name="bl_report_Links_dinamicos_2" id="bl_report_Links_dinamicos_2" class="baseForm" method="post" >
                      <%
                      if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                        %>

                        <table id="TRbl_report_Links_dinamicos_2"  class="reportTable"   style="width:100%; "  >
                          <%
                          int lidi_id =  0;
                          java.lang.String lidi_titulo2 =  null;
                          java.lang.String lidi_descricao =  null;
                          java.lang.String lidi_caminho2 =  null;
                          int lidi_marca =  0;
                          java.lang.String lidi_tipo =  null;
                          %>

                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align:center;" >
                              Moleca
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Links_dinamicos_2 = 0;
                          while (i_bl_report_Links_dinamicos_2<res_Links_dinamicos.size()) {
                            portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_2);
                            lidi_id = t_links_dinamicos.getLidi_id();
                            lidi_titulo2 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                            lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                            lidi_caminho2 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                            lidi_marca = t_links_dinamicos.getLidi_marca();
                            lidi_tipo = t_links_dinamicos.getLidi_tipo()==null?"":t_links_dinamicos.getLidi_tipo();
                            String style_bl_report_Links_dinamicos_2="";
                            if (!((i_bl_report_Links_dinamicos_2%2)!=0)) {
                              style_bl_report_Links_dinamicos_2="rowColor";
                            } else {
                              style_bl_report_Links_dinamicos_2="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Links_dinamicos_2 %>' id="TRbl_report_Links_dinamicos_2<%=i_bl_report_Links_dinamicos_2%>" >

                              <td class="reportColumn" style="text-align:center;" >
                                <a href="../arquivos/norma_venda/<%= lidi_caminho2 %>" target="_blank" STYLE="cursor:hand">
                                  <%= lidi_titulo2 %>
                                </a>
                              </td>

                            </tr>

                            <%
                            i_bl_report_Links_dinamicos_2++;
                            if (i_bl_report_Links_dinamicos_2<res_Links_dinamicos.size()) {
                              t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_2);
                              lidi_id = t_links_dinamicos.getLidi_id();
                              lidi_titulo2 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                              lidi_descricao = t_links_dinamicos.getLidi_descricao()==null?"":t_links_dinamicos.getLidi_descricao();
                              lidi_caminho2 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                              lidi_marca = t_links_dinamicos.getLidi_marca();
                              lidi_tipo = t_links_dinamicos.getLidi_tipo()==null?"":t_links_dinamicos.getLidi_tipo();
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
            <table border="0" style="width:100%">
              <tr>
                <td colspan="2">
                  <br>
                </td>
              </tr>

              <tr valign="top">
                <td>

                  <%
                  if(usuario.atende("17")){
                    %>

                    <%
                    java.util.Vector res_Links_dinamicos = null;
                    com.egen.util.jdbc.JdbcUtil j = null;
                    try {
                      j = new com.egen.util.jdbc.JdbcUtil();
                      portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                      String[][] select = {{"lidi_titulo",null},{"lidi_caminho",null},};
                      Object[][] where = null;
                      where = new Object[][]{{"lidi_tipo","=","N"},
                      {"lidi_marca","=","17"},};
                      String[] groupby =  null;
                      String[] having =  null;
                      String[] order = {"lidi_titulo"};
                      res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
                    } catch (Exception e){
                      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                      %>
                      <jsp:forward page="/system/ErrorPage.jsp"/>
                      <%
                    } finally {
                    if(j!=null){j.close();}
                  }
                  %>

                  <form  name="bl_report_Links_dinamicos_3" id="bl_report_Links_dinamicos_3" class="baseForm" method="post" >
                    <%
                    if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                      %>

                      <table id="TRbl_report_Links_dinamicos_3"  class="reportTable"   style="width:100%; "  >
                        <%
                        java.lang.String lidi_titulo3 =  null;
                        java.lang.String lidi_caminho3 =  null;
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:center;" >
                            Molekinha
                          </td>

                        </tr>

                        <%
                        int i_bl_report_Links_dinamicos_3 = 0;
                        while (i_bl_report_Links_dinamicos_3<res_Links_dinamicos.size()) {
                          portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_3);
                          lidi_titulo3 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                          lidi_caminho3 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                          String style_bl_report_Links_dinamicos_3="";
                          if (!((i_bl_report_Links_dinamicos_3%2)!=0)) {
                            style_bl_report_Links_dinamicos_3="rowColor";
                          } else {
                            style_bl_report_Links_dinamicos_3="rowBlank";
                          }
                          %>

                          <tr class='<%= style_bl_report_Links_dinamicos_3 %>' id="TRbl_report_Links_dinamicos_3<%=i_bl_report_Links_dinamicos_3%>" >

                            <td class="reportColumn" style="text-align:center;" >
                              <a href="../arquivos/norma_venda/<%= lidi_caminho3 %>" target="_blank" STYLE="cursor:hand">
                                <%= lidi_titulo3 %>
                              </a>
                            </td>

                          </tr>

                          <%
                          i_bl_report_Links_dinamicos_3++;
                          if (i_bl_report_Links_dinamicos_3<res_Links_dinamicos.size()) {
                            t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_3);
                            lidi_titulo3 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                            lidi_caminho3 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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
              <td>

                <%
                if(usuario.atende("18")){
                  %>

                  <%
                  java.util.Vector res_Links_dinamicos = null;
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
                    String[][] select = {{"lidi_titulo",null},{"lidi_caminho",null},};
                    Object[][] where = null;
                    where = new Object[][]{{"lidi_tipo","=","N"},
                    {"lidi_marca","=","18"},};
                    String[] groupby =  null;
                    String[] having =  null;
                    String[] order = {"lidi_titulo"};
                    res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
                  } catch (Exception e){
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    %>
                    <jsp:forward page="/system/ErrorPage.jsp"/>
                    <%
                  } finally {
                  if(j!=null){j.close();}
                }
                %>

                <form  name="bl_report_Links_dinamicos_4" id="bl_report_Links_dinamicos_4" class="baseForm" method="post" >
                  <%
                  if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
                    %>

                    <table id="TRbl_report_Links_dinamicos_4"  class="reportTable"   style="width:100%; "  >
                      <%
                      java.lang.String lidi_titulo4 =  null;
                      java.lang.String lidi_caminho4 =  null;
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:center;" >
                          BR Sport
                        </td>

                      </tr>

                      <%
                      int i_bl_report_Links_dinamicos_4 = 0;
                      while (i_bl_report_Links_dinamicos_4<res_Links_dinamicos.size()) {
                        portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_4);
                        lidi_titulo4 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                        lidi_caminho4 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                        String style_bl_report_Links_dinamicos_4="";
                        if (!((i_bl_report_Links_dinamicos_4%2)!=0)) {
                          style_bl_report_Links_dinamicos_4="rowColor";
                        } else {
                          style_bl_report_Links_dinamicos_4="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Links_dinamicos_4 %>' id="TRbl_report_Links_dinamicos_4<%=i_bl_report_Links_dinamicos_4%>" >

                          <td class="reportColumn" style="text-align:center;" >
                            <a href="../arquivos/norma_venda/<%= lidi_caminho4 %>" target="_blank" STYLE="cursor:hand">
                              <%= lidi_titulo4 %>
                            </a>
                          </td>

                        </tr>

                        <%
                        i_bl_report_Links_dinamicos_4++;
                        if (i_bl_report_Links_dinamicos_4<res_Links_dinamicos.size()) {
                          t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_4);
                          lidi_titulo4 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                          lidi_caminho4 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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

        <%
      }
      %>
      <tr>
        <td>

          <%
          if(
          true
          ){
            %>

            <%
            java.util.Vector res_Links_dinamicos = null;
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = new portalbr.dbobj.table.Links_dinamicos();
              String[][] select = {{"lidi_titulo",null},{"lidi_caminho",null},};
              Object[][] where = null;
              where = new Object[][]{{"lidi_tipo","=","N"},
              {"lidi_marca","=","9"},};
              String[] groupby =  null;
              String[] having =  null;
              String[] order = {"lidi_titulo"};
              res_Links_dinamicos = j.select(t_links_dinamicos,select,where,groupby,having,order);
            } catch (Exception e){
              session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              %>
              <jsp:forward page="/system/ErrorPage.jsp"/>
              <%
            } finally {
            if(j!=null){j.close();}
          }
          %>

          <form  name="bl_report_Links_dinamicos_4" id="bl_report_Links_dinamicos_4" class="baseForm" method="post" >
            <%
            if (res_Links_dinamicos!=null && res_Links_dinamicos.size()>0) {
              %>

              <table id="TRbl_report_Links_dinamicos_4"  class="reportTable"   style="width:100%; "  >
                <%
                java.lang.String lidi_titulo4 =  null;
                java.lang.String lidi_caminho4 =  null;
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:center;" >
                    Modare
                  </td>

                </tr>

                <%
                int i_bl_report_Links_dinamicos_4 = 0;
                while (i_bl_report_Links_dinamicos_4<res_Links_dinamicos.size()) {
                  portalbr.dbobj.table.Links_dinamicos t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_4);
                  lidi_titulo4 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                  lidi_caminho4 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
                  String style_bl_report_Links_dinamicos_4="";
                  if (!((i_bl_report_Links_dinamicos_4%2)!=0)) {
                    style_bl_report_Links_dinamicos_4="rowColor";
                  } else {
                    style_bl_report_Links_dinamicos_4="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Links_dinamicos_4 %>' id="TRbl_report_Links_dinamicos_4<%=i_bl_report_Links_dinamicos_4%>" >

                    <td class="reportColumn" style="text-align:center;" >
                      <a href="../arquivos/norma_venda/<%= lidi_caminho4 %>" target="_blank" STYLE="cursor:hand">
                        <%= lidi_titulo4 %>
                      </a>
                    </td>

                  </tr>

                  <%
                  i_bl_report_Links_dinamicos_4++;
                  if (i_bl_report_Links_dinamicos_4<res_Links_dinamicos.size()) {
                    t_links_dinamicos = (portalbr.dbobj.table.Links_dinamicos)res_Links_dinamicos.elementAt(i_bl_report_Links_dinamicos_4);
                    lidi_titulo4 = t_links_dinamicos.getLidi_titulo()==null?"":t_links_dinamicos.getLidi_titulo();
                    lidi_caminho4 = t_links_dinamicos.getLidi_caminho()==null?"":t_links_dinamicos.getLidi_caminho();
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
</td>
</tr>
</table>

</body>
</center>
</html>
