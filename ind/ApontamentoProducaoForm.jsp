<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/ApontamentoProducaoActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = ApontamentoProducaoActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("setor","Setor");
    hashMapLabel.set("p_codigo_barra","Código de Barras");
    hashMapLabel.set("p_rem_nro","Remessa");
    hashMapLabel.set("p_set_cdgo","Setor");
    hashMapLabel.set("p_tal_nro","Talão");
    hashMapLabel.set("p_app_seq","");
    hashMapLabel.set("p_mini_fab","Mini Fab.");
    hashMapLabel.set("f_mensagem_i","");
    hashMapLabel.set("p_mensagem","");
    hashMapLabel.set("f_mensagem_f","");
    hashMapLabel.set("lido","");
    hashMapLabel.set("p_rem_nro_apagar","");
    hashMapLabel.set("p_tal_nro_apagar","");
    hashMapLabel.set("p_set_cdgo_apagar","");
    hashMapLabel.set("p_app_seq_apagar","");
    hashMapLabel.set("p_app_observ1_apagar","");
    hashMapLabel.set("index","");
    var reportColumns = new Array(new Array("rem_nro","tal_nro","set_cdgo","app_seq","app_minfab","app_data","app_parbom","app_parrej","app_tempo","app_observ","app_observ1","usuario_inclusao","dtrh_corrente","excluir"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Apontamento de Produção
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("codigobarra") %>' != 'null'){document.forms[0].p_codigo_barra.focus();}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(33)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="ind/ApontamentoProducaoForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <bean:message key="div.campos*"/>
                    <html:errors property="setor"/>
                    <html:errors property="p_codigo_barra"/>
                    <html:errors property="p_mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Prc_processa_cod_barra"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Setor
                    </span>
                  </td>
                  <td class="formField">
                    <html:select property="setor" styleId="setor" styleClass="baseField" size="1">
                      <html:options property="setorList" labelProperty="setorLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Código de Barras
                    </span>
                    <bean:message key="jsp.fieldnotnull"/>
                  </td>
                  <td class="formField">
                    <html:text property="p_codigo_barra" styleId="p_codigo_barra" onblur="if(this.value!=''){execute_action.click();}" styleClass="baseField" size="20" maxlength="20"/>
                  </td>
                </tr>

                <html:hidden property="p_rem_nro"/>
                <html:hidden property="p_set_cdgo"/>
                <html:hidden property="p_tal_nro"/>
                <html:hidden property="p_app_seq"/>
                <html:hidden property="p_mini_fab"/>
                <%
                if(request.getAttribute("mensagem")!=null){
                  %>
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel" style="  background-color:OrangeRed; color:OrangeRed; ">
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="p_mensagem" styleId="p_mensagem" styleClass="baseField" style="color:white; font-weight: bold; text-align: center; background-color:red" tabindex="-1" readonly="true" size="120" maxlength="2000"/>
                    </td>
                  </tr>

                  <%
                } else {
                  %>

                  <html:hidden property="p_mensagem"/>

                  <%
                }
                %>
                <html:hidden property="lido"/>
                <html:hidden property="p_rem_nro_apagar"/>
                <html:hidden property="p_tal_nro_apagar"/>
                <html:hidden property="p_set_cdgo_apagar"/>
                <html:hidden property="p_app_seq_apagar"/>
                <html:hidden property="p_app_observ1_apagar"/>
                <html:hidden property="index"/>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="e" styleClass="baseButton" property="execute_action">
                      <bean:message bundle="ApplicationResources" key="jsp.execute"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:button accesskey="l" onclick="resetfull_action.click();" styleClass="baseButton" property="resetfull1_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:button>
                    <html:submit value="delete" styleClass="myhidden" property="delete_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

              <script type="text/javascript">
                <% if(request.getAttribute("codigobarra")!=null) { %>

                jQuery('#p_codigo_barra').focus();

                <% } else { %>

                jQuery('#p_filial').focus();

                <% } %>
              </script>
            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["p_codigo_barra"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Apont_prod = (java.util.Vector)session.getAttribute("res_Apont_prod");
              %>

              <form  name="bl_report_Apont_prod" id="bl_report_Apont_prod" class="baseForm" method="post" >
                <%
                if (res_Apont_prod!=null && res_Apont_prod.size()>0) {
                  %>

                  <table id="TRbl_report_Apont_prod"  class="reportTable"   style="width:99%; "  border="1" >
                    <%
                    java.lang.Integer rem_nro =  null;
                    java.lang.Integer tal_nro =  null;
                    java.lang.String set_cdgo =  null;
                    java.lang.Integer app_seq =  null;
                    java.lang.String app_minfab =  null;
                    java.sql.Timestamp app_data =  null;
                    java.lang.Integer app_parbom =  null;
                    java.lang.Integer app_parrej =  null;
                    java.lang.Integer app_tempo =  null;
                    java.lang.String app_observ =  null;
                    java.lang.String app_observ1 =  null;
                    java.lang.String usuario_inclusao =  null;
                    java.sql.Timestamp dtrh_corrente =  null;
                    java.lang.String excluir =  null;
                    int index = 0;
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:right;" >
                        Remessa
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Talão
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Setor
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Seq.
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Mini Fab.
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <!--
                        <td class="columnTdHeader" style="text-align:center;" > Excluir </td>
                      -->

                    </tr>

                    <%
                    int i_bl_report_Apont_prod = res_Apont_prod.size();
                    for(int x=i_bl_report_Apont_prod; x>0; x--){
                      portalbr.dbobj.table.Apont_prod t_apont_prod = (portalbr.dbobj.table.Apont_prod)res_Apont_prod.elementAt(i_bl_report_Apont_prod-1);
                      rem_nro = t_apont_prod.getRem_nro();
                      tal_nro = t_apont_prod.getTal_nro();
                      set_cdgo = t_apont_prod.getSet_cdgo()==null?"":t_apont_prod.getSet_cdgo();
                      app_seq = t_apont_prod.getApp_seq();
                      app_minfab = t_apont_prod.getApp_minfab()==null?"":t_apont_prod.getApp_minfab();
                      app_data = (java.sql.Timestamp)t_apont_prod.getApp_data();
                      app_parbom = t_apont_prod.getApp_parbom();
                      app_parrej = t_apont_prod.getApp_parrej();
                      app_tempo = t_apont_prod.getApp_tempo();
                      app_observ = t_apont_prod.getApp_observ()==null?"":t_apont_prod.getApp_observ();
                      app_observ1 = t_apont_prod.getApp_observ1()==null?"":t_apont_prod.getApp_observ1();
                      usuario_inclusao = t_apont_prod.getUsuario_inclusao()==null?"":t_apont_prod.getUsuario_inclusao();
                      dtrh_corrente = (java.sql.Timestamp)t_apont_prod.getDtrh_corrente();
                      String style_bl_report_Apont_prod="";
                      if (!((i_bl_report_Apont_prod%2)!=0)) {
                        style_bl_report_Apont_prod="rowColor";
                      } else {
                        style_bl_report_Apont_prod="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Apont_prod %>' id="TRbl_report_Apont_prod<%=i_bl_report_Apont_prod%>" >
                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((rem_nro!=null)?rem_nro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((tal_nro!=null)?tal_nro.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= set_cdgo %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((app_seq!=null)?app_seq.toString():"") %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= app_minfab %>
                        </td>

                        <td class="reportColumn" style="text-align:center;" >
                          <%= com.egen.util.text.FormatDate.format(app_data, "dd/MM/yyyy") %>
                        </td>

                        <td class="reportColumn" style="text-align:right;" >
                          <%= ((app_parbom!=null)?app_parbom.toString():"") %>
                        </td>

                        <!--
                          <td class="reportColumn" style="text-align:left; width:1%" > <a href="../ind/ApontamentoProducaoForm.do?delete_action=&p_rem_nro_apagar=<%= rem_nro %>&p_tal_nro_apagar=<%= tal_nro %>&p_set_cdgo_apagar=<%= set_cdgo %>&p_app_seq_apagar=<%= app_seq %>&p_app_observ1_apagar=<%= app_observ1 %>&index=<%= i_bl_report_Apont_prod-1 %>" style="cursor:hand"> <button type="button"> Excluir </button> </a> </td>
                        -->

                      </tr>

                      <%
                      i_bl_report_Apont_prod--;
                      if (res_Apont_prod.size()<i_bl_report_Apont_prod) {
                        t_apont_prod = (portalbr.dbobj.table.Apont_prod)res_Apont_prod.elementAt(i_bl_report_Apont_prod-1);
                        rem_nro = t_apont_prod.getRem_nro();
                        tal_nro = t_apont_prod.getTal_nro();
                        set_cdgo = t_apont_prod.getSet_cdgo()==null?"":t_apont_prod.getSet_cdgo();
                        app_seq = t_apont_prod.getApp_seq();
                        app_minfab = t_apont_prod.getApp_minfab()==null?"":t_apont_prod.getApp_minfab();
                        app_data = (java.sql.Timestamp)t_apont_prod.getApp_data();
                        app_parbom = t_apont_prod.getApp_parbom();
                        app_parrej = t_apont_prod.getApp_parrej();
                        app_tempo = t_apont_prod.getApp_tempo();
                        app_observ = t_apont_prod.getApp_observ()==null?"":t_apont_prod.getApp_observ();
                        app_observ1 = t_apont_prod.getApp_observ1()==null?"":t_apont_prod.getApp_observ1();
                        usuario_inclusao = t_apont_prod.getUsuario_inclusao()==null?"":t_apont_prod.getUsuario_inclusao();
                        dtrh_corrente = (java.sql.Timestamp)t_apont_prod.getDtrh_corrente();
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
