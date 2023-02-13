<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <title>
      <bean:message key="page.title"/>
    </title>

    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
    <bean:message key="page.scriptcalendar"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:500;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable">
              <tr class="headerTr">
                <td class="headerTd">
                  <bean:message key="page.title"/>
                </td>
              </td>
            </tr>
          </table>

          <html:form action="lov/FichatecnicaLov.do" method="post" styleClass="baseForm">
            <table class="bannerTable" style="width:500;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  ficha
                </td>
              </tr>
            </table>

            <table class="messageTable" style='width:500;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <bean:message key="div.campos*"/>
                  <html:errors property="id_nro"/>
                  <html:errors property="data"/>
                  <html:errors property="projeto_cdgo"/>
                  <html:errors property="fma_cdgo"/>
                  <html:errors property="base"/>
                  <html:errors property="codigo_colecao"/>
                  <html:errors property="gde_cdgo"/>
                  <html:errors property="lin_cdgo"/>
                  <html:errors property="projeto_desc"/>
                  <html:errors property="forma_desc"/>
                  <html:errors property="grade_desc"/>
                  <html:errors property="linha_desc"/>
                  <html:errors property="ref_cdgo"/>
                  <html:errors property="ref_desc"/>
                  <html:errors property="padrao"/>
                  <html:errors property="codigo_desc"/>
                  <html:errors property="cod_mini_fab"/>
                  <html:errors property="cod_mini_fab_desc"/>
                  <html:errors property="tecnico_resp"/>
                  <html:errors property="tecnico_pre"/>
                  <html:errors property="data_entrega_amostra"/>
                  <html:errors property="status"/>
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Ficha_tec_instrutiva"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:500;">
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Id_nro
                  </span>
                  <bean:message key="jsp.fieldnotnull"/>
                </td>
                <td class="formField">
                  <html:text property="id_nro" styleId="id_nro" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Data
                  </span>
                </td>
                <td class="formField">
                  <html:text property="data" styleId="data" styleClass="baseField" size="10" maxlength="10"/>
                  &nbsp;
                  <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data']); cal1.year_scroll = true; cal1.popup();">
                    <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                  </a>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Projeto_cdgo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="projeto_cdgo" styleId="projeto_cdgo" styleClass="baseField" size="15" maxlength="15"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Fma_cdgo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="fma_cdgo" styleId="fma_cdgo" styleClass="baseField" size="10" maxlength="10"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Base
                  </span>
                </td>
                <td class="formField">
                  <html:text property="base" styleId="base" styleClass="baseField" size="20" maxlength="20"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Codigo_colecao
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo_colecao" styleId="codigo_colecao" styleClass="baseField" size="2" maxlength="2"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Gde_cdgo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="gde_cdgo" styleId="gde_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Lin_cdgo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="lin_cdgo" styleId="lin_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Projeto_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="projeto_desc" styleId="projeto_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Forma_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="forma_desc" styleId="forma_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Grade_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="grade_desc" styleId="grade_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Linha_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="linha_desc" styleId="linha_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Ref_cdgo
                  </span>
                </td>
                <td class="formField">
                  <html:text property="ref_cdgo" styleId="ref_cdgo" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Ref_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="ref_desc" styleId="ref_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Padrao
                  </span>
                </td>
                <td class="formField">
                  <html:text property="padrao" styleId="padrao" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Codigo_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="codigo_desc" styleId="codigo_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cod_mini_fab
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cod_mini_fab" styleId="cod_mini_fab" styleClass="baseField" size="22" maxlength="22"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Cod_mini_fab_desc
                  </span>
                </td>
                <td class="formField">
                  <html:text property="cod_mini_fab_desc" styleId="cod_mini_fab_desc" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Tecnico_resp
                  </span>
                </td>
                <td class="formField">
                  <html:text property="tecnico_resp" styleId="tecnico_resp" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Tecnico_pre
                  </span>
                </td>
                <td class="formField">
                  <html:text property="tecnico_pre" styleId="tecnico_pre" styleClass="baseField" size="100" maxlength="100"/>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Data_entrega_amostra
                  </span>
                </td>
                <td class="formField">
                  <html:text property="data_entrega_amostra" styleId="data_entrega_amostra" styleClass="baseField" size="10" maxlength="10"/>
                  &nbsp;
                  <a tabindex="-1" href="javascript:var cal1 = new calendar1(document.forms['0'].elements['data_entrega_amostra']); cal1.year_scroll = true; cal1.popup();">
                    <img src="../img/calendar.gif" tabindex="9999" width="16" height="16" border="0" />
                  </a>
                </td>
              </tr>

              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Status
                  </span>
                </td>
                <td class="formField">
                  <html:text property="status" styleId="status" styleClass="baseField" size="1" maxlength="1"/>
                </td>
              </tr>

            </table>

            <table class="buttonTable" style='width:500;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:submit accesskey="p" styleClass="baseButton" property="select_action">
                    <bean:message bundle="ApplicationResources" key="jsp.select"/>
                  </html:submit>
                  <html:submit accesskey="i" styleClass="baseButton" property="insert_action">
                    <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                  </html:submit>
                  <html:submit accesskey="a" styleClass="baseButton" property="update_action">
                    <bean:message bundle="ApplicationResources" key="jsp.update"/>
                  </html:submit>
                  <html:submit accesskey="a" styleClass="baseButton" property="delete_action">
                    <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                  </html:submit>
                  <html:submit accesskey="l" styleClass="baseButton" property="resetfull_action">
                    <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                  </html:submit>
                </td>
              </tr>
            </table>

          </html:form>
          <%
          {
            %>

            <%
            java.util.Vector res_Ficha_tec_instrutiva = (java.util.Vector)session.getAttribute("res_Ficha_tec_instrutiva");
            %>

            <form  name="bl_report_Ficha_tec_instrutiva" id="bl_report_Ficha_tec_instrutiva" class="baseForm" method="post" >
              <table class="bannerTable" style="width:500;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    teste
                  </td>
                </tr>
              </table>

              <%
              if (res_Ficha_tec_instrutiva!=null && res_Ficha_tec_instrutiva.size()>0) {
                %>

                <table id="TRbl_report_Ficha_tec_instrutiva"  class="reportTable"   style="width:500; "  >
                  <%
                  java.lang.Double id_nro =  null;
                  java.sql.Date data =  null;
                  java.lang.String projeto_cdgo =  null;
                  java.lang.String fma_cdgo =  null;
                  java.lang.String base =  null;
                  java.lang.Integer codigo_colecao =  null;
                  java.lang.Double gde_cdgo =  null;
                  java.lang.Double lin_cdgo =  null;
                  java.lang.String projeto_desc =  null;
                  java.lang.String forma_desc =  null;
                  java.lang.String grade_desc =  null;
                  java.lang.String linha_desc =  null;
                  java.lang.Double ref_cdgo =  null;
                  java.lang.String ref_desc =  null;
                  java.lang.String padrao =  null;
                  java.lang.String codigo_desc =  null;
                  java.lang.Double cod_mini_fab =  null;
                  java.lang.String cod_mini_fab_desc =  null;
                  java.lang.String tecnico_resp =  null;
                  java.lang.String tecnico_pre =  null;
                  java.sql.Date data_entrega_amostra =  null;
                  java.sql.Date dthr_inclusao =  null;
                  java.sql.Date dthr_alteracao =  null;
                  java.lang.String usuario_inclusao =  null;
                  java.lang.String usuario_alteracao =  null;
                  java.lang.String status =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      Id_nro
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Projeto_cdgo
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Fma_cdgo
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Base
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Codigo_colecao
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Gde_cdgo
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Lin_cdgo
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Projeto_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Forma_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Grade_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Linha_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Ref_cdgo
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Ref_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Padrao
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Codigo_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Cod_mini_fab
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cod_mini_fab_desc
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Tecnico_resp
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Tecnico_pre
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data_entrega_amostra
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Dthr_inclusao
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Dthr_alteracao
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Usuario_inclusao
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Usuario_alteracao
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Status
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Ficha_tec_instrutiva = 0;
                  while (i_bl_report_Ficha_tec_instrutiva<res_Ficha_tec_instrutiva.size()) {
                    portalbr.dbobj.table.Ficha_tec_instrutiva t_ficha_tec_instrutiva = (portalbr.dbobj.table.Ficha_tec_instrutiva)res_Ficha_tec_instrutiva.elementAt(i_bl_report_Ficha_tec_instrutiva);
                    id_nro = t_ficha_tec_instrutiva.getId_nro();
                    data = (java.sql.Date)t_ficha_tec_instrutiva.getData();
                    projeto_cdgo = t_ficha_tec_instrutiva.getProjeto_cdgo()==null?"":t_ficha_tec_instrutiva.getProjeto_cdgo();
                    fma_cdgo = t_ficha_tec_instrutiva.getFma_cdgo()==null?"":t_ficha_tec_instrutiva.getFma_cdgo();
                    base = t_ficha_tec_instrutiva.getBase()==null?"":t_ficha_tec_instrutiva.getBase();
                    codigo_colecao = t_ficha_tec_instrutiva.getCodigo_colecao();
                    gde_cdgo = t_ficha_tec_instrutiva.getGde_cdgo();
                    lin_cdgo = t_ficha_tec_instrutiva.getLin_cdgo();
                    projeto_desc = t_ficha_tec_instrutiva.getProjeto_desc()==null?"":t_ficha_tec_instrutiva.getProjeto_desc();
                    forma_desc = t_ficha_tec_instrutiva.getForma_desc()==null?"":t_ficha_tec_instrutiva.getForma_desc();
                    grade_desc = t_ficha_tec_instrutiva.getGrade_desc()==null?"":t_ficha_tec_instrutiva.getGrade_desc();
                    linha_desc = t_ficha_tec_instrutiva.getLinha_desc()==null?"":t_ficha_tec_instrutiva.getLinha_desc();
                    ref_cdgo = t_ficha_tec_instrutiva.getRef_cdgo();
                    ref_desc = t_ficha_tec_instrutiva.getRef_desc()==null?"":t_ficha_tec_instrutiva.getRef_desc();
                    padrao = t_ficha_tec_instrutiva.getPadrao()==null?"":t_ficha_tec_instrutiva.getPadrao();
                    codigo_desc = t_ficha_tec_instrutiva.getCodigo_desc()==null?"":t_ficha_tec_instrutiva.getCodigo_desc();
                    cod_mini_fab = t_ficha_tec_instrutiva.getCod_mini_fab();
                    cod_mini_fab_desc = t_ficha_tec_instrutiva.getCod_mini_fab_desc()==null?"":t_ficha_tec_instrutiva.getCod_mini_fab_desc();
                    tecnico_resp = t_ficha_tec_instrutiva.getTecnico_resp()==null?"":t_ficha_tec_instrutiva.getTecnico_resp();
                    tecnico_pre = t_ficha_tec_instrutiva.getTecnico_pre()==null?"":t_ficha_tec_instrutiva.getTecnico_pre();
                    data_entrega_amostra = (java.sql.Date)t_ficha_tec_instrutiva.getData_entrega_amostra();
                    dthr_inclusao = (java.sql.Date)t_ficha_tec_instrutiva.getDthr_inclusao();
                    dthr_alteracao = (java.sql.Date)t_ficha_tec_instrutiva.getDthr_alteracao();
                    usuario_inclusao = t_ficha_tec_instrutiva.getUsuario_inclusao()==null?"":t_ficha_tec_instrutiva.getUsuario_inclusao();
                    usuario_alteracao = t_ficha_tec_instrutiva.getUsuario_alteracao()==null?"":t_ficha_tec_instrutiva.getUsuario_alteracao();
                    status = t_ficha_tec_instrutiva.getStatus()==null?"":t_ficha_tec_instrutiva.getStatus();
                    String style_bl_report_Ficha_tec_instrutiva="";
                    if (!((i_bl_report_Ficha_tec_instrutiva%2)!=0)) {
                      style_bl_report_Ficha_tec_instrutiva="rowColor";
                    } else {
                      style_bl_report_Ficha_tec_instrutiva="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Ficha_tec_instrutiva %>' id="TRbl_report_Ficha_tec_instrutiva<%=i_bl_report_Ficha_tec_instrutiva%>" >
                      <td class="reportColumn" style="text-align:right;" >
                        <a href="javascript:setLov('<%= id_nro %>')" style="cursor:hand">
                          <%= com.egen.util.text.FormatNumber.format(id_nro, "0") %>
                        </a>

                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= projeto_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= fma_cdgo %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= base %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((codigo_colecao!=null)?codigo_colecao.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(gde_cdgo, "0") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(lin_cdgo, "0") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= projeto_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= forma_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= grade_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= linha_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(ref_cdgo, "0") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ref_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= padrao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= codigo_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(cod_mini_fab, "0") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cod_mini_fab_desc %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= tecnico_resp %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= tecnico_pre %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_entrega_amostra, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(dthr_inclusao, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(dthr_alteracao, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario_inclusao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario_alteracao %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= status %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Ficha_tec_instrutiva++;
                    if (i_bl_report_Ficha_tec_instrutiva<res_Ficha_tec_instrutiva.size()) {
                      t_ficha_tec_instrutiva = (portalbr.dbobj.table.Ficha_tec_instrutiva)res_Ficha_tec_instrutiva.elementAt(i_bl_report_Ficha_tec_instrutiva);
                      id_nro = t_ficha_tec_instrutiva.getId_nro();
                      data = (java.sql.Date)t_ficha_tec_instrutiva.getData();
                      projeto_cdgo = t_ficha_tec_instrutiva.getProjeto_cdgo()==null?"":t_ficha_tec_instrutiva.getProjeto_cdgo();
                      fma_cdgo = t_ficha_tec_instrutiva.getFma_cdgo()==null?"":t_ficha_tec_instrutiva.getFma_cdgo();
                      base = t_ficha_tec_instrutiva.getBase()==null?"":t_ficha_tec_instrutiva.getBase();
                      codigo_colecao = t_ficha_tec_instrutiva.getCodigo_colecao();
                      gde_cdgo = t_ficha_tec_instrutiva.getGde_cdgo();
                      lin_cdgo = t_ficha_tec_instrutiva.getLin_cdgo();
                      projeto_desc = t_ficha_tec_instrutiva.getProjeto_desc()==null?"":t_ficha_tec_instrutiva.getProjeto_desc();
                      forma_desc = t_ficha_tec_instrutiva.getForma_desc()==null?"":t_ficha_tec_instrutiva.getForma_desc();
                      grade_desc = t_ficha_tec_instrutiva.getGrade_desc()==null?"":t_ficha_tec_instrutiva.getGrade_desc();
                      linha_desc = t_ficha_tec_instrutiva.getLinha_desc()==null?"":t_ficha_tec_instrutiva.getLinha_desc();
                      ref_cdgo = t_ficha_tec_instrutiva.getRef_cdgo();
                      ref_desc = t_ficha_tec_instrutiva.getRef_desc()==null?"":t_ficha_tec_instrutiva.getRef_desc();
                      padrao = t_ficha_tec_instrutiva.getPadrao()==null?"":t_ficha_tec_instrutiva.getPadrao();
                      codigo_desc = t_ficha_tec_instrutiva.getCodigo_desc()==null?"":t_ficha_tec_instrutiva.getCodigo_desc();
                      cod_mini_fab = t_ficha_tec_instrutiva.getCod_mini_fab();
                      cod_mini_fab_desc = t_ficha_tec_instrutiva.getCod_mini_fab_desc()==null?"":t_ficha_tec_instrutiva.getCod_mini_fab_desc();
                      tecnico_resp = t_ficha_tec_instrutiva.getTecnico_resp()==null?"":t_ficha_tec_instrutiva.getTecnico_resp();
                      tecnico_pre = t_ficha_tec_instrutiva.getTecnico_pre()==null?"":t_ficha_tec_instrutiva.getTecnico_pre();
                      data_entrega_amostra = (java.sql.Date)t_ficha_tec_instrutiva.getData_entrega_amostra();
                      dthr_inclusao = (java.sql.Date)t_ficha_tec_instrutiva.getDthr_inclusao();
                      dthr_alteracao = (java.sql.Date)t_ficha_tec_instrutiva.getDthr_alteracao();
                      usuario_inclusao = t_ficha_tec_instrutiva.getUsuario_inclusao()==null?"":t_ficha_tec_instrutiva.getUsuario_inclusao();
                      usuario_alteracao = t_ficha_tec_instrutiva.getUsuario_alteracao()==null?"":t_ficha_tec_instrutiva.getUsuario_alteracao();
                      status = t_ficha_tec_instrutiva.getStatus()==null?"":t_ficha_tec_instrutiva.getStatus();
                    } else {
                    }
                  }
                  %>

                </table>

                <%
              }
              %>

              <script type="text/javascript">
                function setLov(ID_NRO) {
                  <% {
                    String returnBlock = "0";
                    String return0 = null;
                    if (request.getParameter("returnBlock")!=null) {
                      returnBlock = request.getParameter("returnBlock");
                      session.setAttribute("returnBlock",returnBlock);
                      return0 = ((request.getParameter("return0")!=null)?request.getParameter("return0"):null);
                      session.setAttribute("return0",return0);
                      session.setAttribute("ge_LovPage", "FichatecnicaLov");
                    } else if (session.getAttribute("ge_LovPage")!=null && ((String)session.getAttribute("ge_LovPage")).equals("FichatecnicaLov")) {
                      returnBlock = ((session.getAttribute("returnBlock")!=null)?(String)session.getAttribute("returnBlock"):"0");
                      return0 = ((session.getAttribute("return0")!=null)?(String)session.getAttribute("return0"):null);
                    }
                    %>
                    returnBlock = <%= returnBlock %>;
                    <% if (return0!=null && return0.length()>0) {%>
                    if (opener.document.forms[returnBlock].<%= return0%>!=null) { opener.document.forms[returnBlock].<%= return0 %>.value=ID_NRO; };
                    <%}%>
                    window.close();
                  }
                  <% } %>
                </script>

              </form>
              <%
            }
            %>

            <table class="footerTable">
              <tr class="footerTr">
                <td class="footerTd">
                  <bean:message key="div.print"/>
                </td>
              </tr>

            </table>

          </td>
        </tr>
      </table>

    </body>
  </center>
</html>
