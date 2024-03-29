<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/EtiquetasNormasActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = EtiquetasNormasActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("codigo_marca","Marca");
    hashMapLabel.set("descricao_marca","");
    hashMapLabel.set("lin_cdgo","Linha");
    hashMapLabel.set("lin_nome","");
    hashMapLabel.set("insert_norma","");
    hashMapLabel.set("insert_item","");
    hashMapLabel.set("insert_linha","");
    hashMapLabel.set("insert_referencia","");
    hashMapLabel.set("insert_cabedal","");
    hashMapLabel.set("insert_cor","");
    hashMapLabel.set("f_pdf","");
    var reportColumns = new Array(new Array("id_norma_venda","codigo_marca","descricao_marca","submarca_cdgo","lin_cdgo","item_id","desc_item","id_material","material"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Etiquetas Normas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(177)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>

                </td>

              </tr>

            </table>

            <html:form action="com/EtiquetasNormasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo_marca"/>
                    <html:errors property="descricao_marca"/>
                    <html:errors property="lin_cdgo"/>
                    <html:errors property="lin_nome"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_nv_norma"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Marca
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="codigo_marca" styleId="codigo_marca" onblur="if(this.value!=''){fillFields(0,new Array('codigo_marca'),'EtiquetasNormasActionForm.getDescricao_marca_Ajax',new Array('descricao_marca'));}else{descricao_marca.value='';}" styleClass="baseField" size="3" maxlength="4"/>
                    <input type="button" class="lovButton" tabindex="-1" value="..."  onclick="javascript:lov_open_codigo_marca()"  >
                    <script type="text/javascript">
                      function lov_open_codigo_marca() {
                        window.open('..//lov/LvMarcaLov.do?resetfull_action=&returnBlock=0&return0=codigo_marca&return1=descricao_marca','','scrollbars=yes,height=510,width=600,top=0,left=0,');
                      }
                    </script>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="descricao_marca" styleId="descricao_marca" styleClass="disabled" tabindex="-1" readonly="true" size="30" maxlength="30"/>
                  </td>
                </tr>

                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Linha
                    </span>
                  </td>
                  <td class="formField">
                    <html:text property="lin_cdgo" styleId="lin_cdgo" onblur="if(this.value!=''){fillFields(0,new Array('lin_cdgo'),'EtiquetasNormasActionForm.getLin_nome_Ajax',new Array('lin_nome'));}else{lin_nome.value='';}" styleClass="baseField" size="7" maxlength="22"/>
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

                <html:hidden property="insert_norma"/>
                <html:hidden property="insert_item"/>
                <html:hidden property="insert_linha"/>
                <html:hidden property="insert_referencia"/>
                <html:hidden property="insert_cabedal"/>
                <html:hidden property="insert_cor"/>
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
                    <html:submit accesskey="s" onclick="bloqueia();" styleClass="baseButton" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="r" styleClass="baseButton" property="resetfull_action">
                      <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="insert_item_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="insert_cor_action">
                      <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="delete_item_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:submit styleClass="myhidden" property="delete_cor_action">
                      <bean:message bundle="ApplicationResources" key="jsp.delete"/>
                    </html:submit>
                    <html:submit value="Gerar PDF" onclick="bloqueia();" styleClass="baseButton" property="pdf_action">
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <script type="text/javascript">
              var focusControl = document.forms[0].elements["codigo_marca"];
              if (focusControl.type != "hidden"){
                focusControl.focus();
              }
            </script>

            <%
            com.egen.util.jdbc.JdbcUtil j = null;
            util.consultas.Query query = new util.consultas.Query();
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              java.util.Vector res_Jw_nv_norma = (java.util.Vector)session.getAttribute("res_Jw_nv_norma");
              %>

              <form  name="bl_report_Jw_nv_norma" id="bl_report_Jw_nv_norma" class="baseForm" method="post" >

                <%
                if (res_Jw_nv_norma!=null && res_Jw_nv_norma.size()>0) {
                  %>

                  <%
                  java.lang.Integer id_norma_venda =  null;
                  java.lang.Integer codigo_marca =  null;
                  java.lang.String descricao_marca =  null;
                  java.lang.String submarca_cdgo =  null;
                  java.lang.Integer lin_cdgo =  null;
                  int contador = 0;

                  int quantidade_linhas_material = 0;
                  int contador_material = 0;

                  java.lang.String linha = null;
                  java.lang.String referencia = null;
                  java.lang.String cabedal = null;
                  java.lang.String cor = null;


                  java.lang.String style = "rowColor";
                  java.lang.Integer item_id =  null;
                  java.lang.String desc_item =  null;
                  java.lang.Integer id_material =  null;
                  java.lang.String material =  null;
                  int contador_linhas = 0;
                  int quantidade_total_linhas = 0;
                  int qtde_comp = 0;
                  int qtde_comp_mat = 0;
                  String _b0_control = "__";
                  String _b1_control = "__";
                  int i_bl_report_Jw_nv_norma = 0;
                  while (i_bl_report_Jw_nv_norma<res_Jw_nv_norma.size()) {
                    portalbr.dbobj.view.Jw_nv_norma t_jw_nv_norma = (portalbr.dbobj.view.Jw_nv_norma)res_Jw_nv_norma.elementAt(i_bl_report_Jw_nv_norma);
                    id_norma_venda = t_jw_nv_norma.getId_norma_venda();
                    codigo_marca = t_jw_nv_norma.getCodigo_marca();
                    descricao_marca = t_jw_nv_norma.getDescricao_marca()==null?"":t_jw_nv_norma.getDescricao_marca();
                    submarca_cdgo = t_jw_nv_norma.getSubmarca_cdgo()==null?"":t_jw_nv_norma.getSubmarca_cdgo();
                    lin_cdgo = t_jw_nv_norma.getLin_cdgo();
                    item_id = t_jw_nv_norma.getItem_id();
                    desc_item = t_jw_nv_norma.getDesc_item()==null?"":t_jw_nv_norma.getDesc_item();
                    id_material = t_jw_nv_norma.getId_material();
                    material = t_jw_nv_norma.getMaterial()==null?"":t_jw_nv_norma.getMaterial();
                    String _b0_value = com.egen.util.text.FormatNumber.format(id_norma_venda);
                    if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                      if(contador>0){
                        %>
                        <table border=0>
                          <tr>
                            <td>
                              <br>
                            </td>
                          </tr>
                        </table>
                        <%
                      }
                      contador ++;
                      qtde_comp = Integer.parseInt(query.retorna(j,"SELECT COUNT(DISTINCT c.descricao) FROM nv_linha_materiais_publicada lm,nv_colunas c,nv_norma_venda n WHERE c.id_coluna = lm.id_coluna AND n.id_norma_venda = lm.id_norma_venda   AND n.lin_cdgo = "+lin_cdgo));
                      %>
                      <table id="TRbl_report_Jw_nv_norma"  class="reportTable" width="100%"   border="1"; >
                        <tr>
                          <td colspan="<%= qtde_comp +2 %>">
                            <%
                            if(contador==1){
                              %>
                              <font size="3">
                                <big>
                                  <b>
                                    <%= descricao_marca %>
                                  </b>
                                </big>
                              </font>
                              <br>
                              <%
                            }
                            %>
                            <%
                            if(!submarca_cdgo.equals("")) {
                              %>
                              <big>
                                <%= submarca_cdgo %>
                              </big>
                              <br>
                              <%
                            }
                            %>
                            <big>
                              <b>
                                Linha :
                                <%= ((lin_cdgo!=null)?lin_cdgo.toString():"") %>
                              </b>
                            </big>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = com.egen.util.text.FormatNumber.format(id_norma_venda) + "_" + com.egen.util.text.FormatNumber.format(item_id);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader">
                          <td colspan="<%= qtde_comp+2 %>" >
                            NV:
                            <%= id_norma_venda%>
                            -
                            <%= desc_item %>
                          </td>
                        </tr>
                        <tr class="reportHeader">

                          <td  align="right" colspan="<%= qtde_comp+2 %>">

                            <%
                            String imagens[] = query.retorna(j,"SELECT rowtocol('SELECT nv.lin_cdgo||''.''||lpad(rinv.ref_cdgo,3,0)||''#''||(SELECT fit_imagem FROM ficha_tec WHERE lin_cdgo = nv.lin_cdgo AND ref_cdgo = rinv.ref_cdgo AND ROWNUM = 1)  FROM nv_ref_item_norma_venda rinv      ,nv_norma_venda nv WHERE nv.id_norma_venda = rinv.id_norma_venda   AND nv.id_norma_venda = "+id_norma_venda+"   AND rinv.item_id = "+item_id+" ') FROM dual").split(",");
                            %>
                            <table border=0>
                              <tr>
                                <%
                                for(String imag: imagens){
                                  %>
                                  <td align="center">
                                    <%
                                    linha = imag.substring(0,imag.indexOf("#")).substring(0,imag.substring(0,imag.indexOf("#")).indexOf("."));
                                    referencia = imag.substring(0,imag.indexOf("#")).substring(imag.substring(0,imag.indexOf("#")).indexOf(".")+1,imag.substring(0,imag.indexOf("#")).length());
                                    cabedal = id_material+"";
                                    %>
                                    <%= imag.substring(0,imag.indexOf("#")) %>
                                    <br>
                                    <img style="border:2px solid black" src="../com/ranking_img/<%= imag.substring(imag.indexOf("#")+1,imag.length())%>" onclick="if(this.style.border=='2px solid red'){this.style.border='2px solid black';jQuery.post('EtiquetasNormasForm.do?delete_item_action=&insert_norma=<%= id_norma_venda %>&insert_item=<%= item_id %>&insert_linha=<%= linha %>&insert_referencia=<%= referencia %>&insert_cabedal=<%= id_material %>');}else{this.style.border='2px solid red';jQuery.post('EtiquetasNormasForm.do?insert_item_action=&insert_norma=<%= id_norma_venda %>&insert_item=<%= item_id %>&insert_linha=<%= linha %>&insert_referencia=<%= referencia %>&insert_cabedal=<%= id_material %>');}">
                                    <br>
                                  </td>
                                  <%
                                }
                                %>
                              </tr>
                            </table>




                          </td>
                        </tr>
                        <%
                        qtde_comp_mat = Integer.parseInt(query.retorna(j,"SELECT count(DISTINCT c.descricao) FROM nv_linha_materiais_publicada lm, nv_colunas c WHERE lm.id_norma_venda = "+id_norma_venda+" AND lm.item_id = "+item_id+" AND c.id_coluna = lm.id_coluna   AND lm.id_material = "+id_material));
                        %>
                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:center;" colspan="<%= qtde_comp - qtde_comp_mat+1 %>"  width="10%">
                            Materiais
                          </td>

                          <%
                          String comp[] = query.retorna(j,"SELECT rowtocol('SELECT DISTINCT c.descricao FROM nv_linha_materiais_publicada lm, nv_colunas c WHERE lm.id_norma_venda = "+id_norma_venda+" AND lm.item_id = "+item_id+" AND c.id_coluna = lm.id_coluna   AND lm.id_material = "+id_material+"') FROM dual").split(",");
                          for(String c: comp){
                            %>
                            <td align="center">
                              <%= c %>
                            </td>
                            <%
                          }
                          %>

                          <td class="columnTdHeader" style="text-align:center;" width="1%" >
                            Selecionar
                          </td>

                          <%
                          contador_linhas = 0;
                          %>
                        </tr>

                        <%
                        StringBuilder sbl = new StringBuilder();
                        sbl.append(" SELECT count(distinct lm.row_id||mnv.id_material)  ");
                        sbl.append("   FROM nv_norma_venda           nv ");
                        sbl.append("      , nv_item_norma_venda      inv ");
                        sbl.append("      , nv_materiais_norma_venda mnv ");
                        sbl.append("      , nv_linha_materiais       lm ");
                        sbl.append("  WHERE mnv.id_norma_venda = lm.id_norma_venda ");
                        sbl.append("    AND mnv.item_id        = lm.item_id ");
                        sbl.append("    AND mnv.id_material    = lm.id_material ");
                        sbl.append("    AND inv.id_norma_venda = mnv.id_norma_venda ");
                        sbl.append("    AND inv.item_id        = mnv.item_id ");
                        sbl.append("    AND nv.id_norma_venda  = inv.id_norma_venda ");
                        sbl.append("    AND nv.id_norma_venda  = "+id_norma_venda);
                        sbl.append("    AND inv.item_id        = "+item_id);
                        sbl.append("  ORDER BY id_coluna ");

                        quantidade_total_linhas = Integer.parseInt(query.retorna(j,sbl.toString()));
                        %>

                        <%
                      }
                      String style_bl_report_Jw_nv_norma="";
                      if (!((i_bl_report_Jw_nv_norma%2)!=0)) {
                        style_bl_report_Jw_nv_norma="rowColor";
                      } else {
                        style_bl_report_Jw_nv_norma="rowBlank";
                      }
                      %>

                      <tr>

                        <%
                        StringBuilder sb = new StringBuilder();
                        sb.append(" SELECT count(distinct lm.row_id)  ");
                        sb.append("   FROM nv_norma_venda               nv ");
                        sb.append("      , nv_item_norma_venda          inv ");
                        sb.append("      , nv_materiais_norma_venda     mnv ");
                        sb.append("      , nv_linha_materiais_publicada lm ");
                        sb.append("  WHERE mnv.id_norma_venda = lm.id_norma_venda ");
                        sb.append("    AND mnv.item_id        = lm.item_id ");
                        sb.append("    AND mnv.id_material    = lm.id_material ");
                        sb.append("    AND inv.id_norma_venda = mnv.id_norma_venda ");
                        sb.append("    AND inv.item_id        = mnv.item_id ");
                        sb.append("    AND nv.id_norma_venda  = inv.id_norma_venda ");
                        sb.append("    AND nv.id_norma_venda  = "+id_norma_venda);
                        sb.append("    and lm.id_material     = "+id_material);
                        sb.append("    AND inv.item_id =      "+item_id);
                        sb.append("  ORDER BY id_coluna ");

                        int quantidade_linhas = Integer.parseInt(query.retorna(j,sb.toString()));
                        %>
                        <th rowspan="<%= quantidade_linhas %>" colspan="<%= qtde_comp - qtde_comp_mat+1 %>" class="<%= style_bl_report_Jw_nv_norma %>" >
                          <small>
                            Item:
                            <%= item_id %>
                            -
                            <%= material %>
                          </small>
                        </th>

                        <%
                        for(int x=1; x<=quantidade_linhas; x++) {

                          if(x>1){
                            %>
                            <tr>
                              <%
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" SELECT rowtocol('select decode(cl.cod_cor,''S'',''*'','''')||DECODE(lm.id_coluna, 2, TO_CHAR(lm.id_linha), DECODE(pck_cor.get_nome(lm.id_linha), ''SEM COR'', ''N�O DISPON�VEL'', pck_cor.get_nome(lm.id_linha))) id_linha ");
                            sb2.append("   FROM nv_norma_venda           nv ");
                            sb2.append("      , nv_item_norma_venda      inv ");
                            sb2.append("      , nv_materiais_norma_venda mnv ");
                            sb2.append("      , nv_linha_materiais       lm ");
                            sb2.append("      , nv_colunas               cl ");
                            sb2.append("  WHERE mnv.id_norma_venda = lm.id_norma_venda ");
                            sb2.append("    AND mnv.item_id        = lm.item_id ");
                            sb2.append("    AND mnv.id_material    = lm.id_material ");
                            sb2.append("    AND inv.id_norma_venda = mnv.id_norma_venda ");
                            sb2.append("    AND inv.item_id        = mnv.item_id ");
                            sb2.append("    AND nv.id_norma_venda  = inv.id_norma_venda ");
                            sb2.append("    AND cl.id_coluna       = lm.id_coluna ");
                            sb2.append("    AND nv.id_norma_venda  = "+id_norma_venda);
                            sb2.append("    and lm.id_material     = "+id_material);
                            sb2.append("    AND inv.item_id        = "+item_id);
                            sb2.append("    AND lm.row_id          = "+x);
                            sb2.append("  ORDER BY lm.id_coluna ') FROM dual ");

                            String comp[] = query.retorna(j,sb2.toString()).split(",");
                            for(String c: comp){
                              %>
                              <td align="center" class='<%= style_bl_report_Jw_nv_norma %>' >
                                <%= c.replace("*","") %>
                                <%
                              if(c.indexOf("*")==0){ cor = c.replace("*","");}
                              %>
                            </td>
                            <%
                          }
                          contador_linhas++;
                          %>
                          <td align="center" width="1%" class='<%= style_bl_report_Jw_nv_norma %>' >
                            <input type="hidden" id="cb_<%= id_norma_venda %>_<%= id_material %>_<%= item_id %>_<%= x %>" value="N">
                            <img src="../img/cb_unchecked.png" title="<%= material %> - <%= id_material%>" STYLE="cursor:hand" onclick="if(document.getElementById('cb_<%= id_norma_venda %>_<%= id_material %>_<%= item_id %>_<%= x %>').value=='N'){this.src='../img/cb_checked.png';document.getElementById('cb_<%= id_norma_venda %>_<%= id_material %>_<%= item_id %>_<%= x %>').value='S';jQuery.post('EtiquetasNormasForm.do?insert_cor_action=&insert_norma=<%= id_norma_venda %>&insert_item=<%= item_id %>&insert_linha=<%= linha %>&insert_referencia=<%= referencia %>&insert_cabedal=<%= id_material %>&insert_cor=<%= cor %>');} else {this.src='../img/cb_unchecked.png';document.getElementById('cb_<%= id_norma_venda %>_<%= id_material %>_<%= item_id %>_<%= x %>').value='N';jQuery.post('EtiquetasNormasForm.do?delete_cor_action=&insert_norma=<%= id_norma_venda %>&insert_item=<%= item_id %>&insert_linha=<%= linha %>&insert_referencia=<%= referencia %>&insert_cabedal=<%= id_material %>&insert_cor=<%= cor %>');}">
                            <br>
                            <!--
                              l:<%= linha %><br> r:<%= referencia %><br> c:<%= cabedal %><br> m:<%= id_material %><br>
                            -->

                          </td>
                        </tr>

                        <%
                      }
                      %>

                    </tr>

                    <%
                    _b0_control = _b0_value;
                    _b1_control = _b1_value;
                    i_bl_report_Jw_nv_norma++;
                    if (i_bl_report_Jw_nv_norma<res_Jw_nv_norma.size()) {
                      t_jw_nv_norma = (portalbr.dbobj.view.Jw_nv_norma)res_Jw_nv_norma.elementAt(i_bl_report_Jw_nv_norma);
                      id_norma_venda = t_jw_nv_norma.getId_norma_venda();
                      codigo_marca = t_jw_nv_norma.getCodigo_marca();
                      descricao_marca = t_jw_nv_norma.getDescricao_marca()==null?"":t_jw_nv_norma.getDescricao_marca();
                      submarca_cdgo = t_jw_nv_norma.getSubmarca_cdgo()==null?"":t_jw_nv_norma.getSubmarca_cdgo();
                      lin_cdgo = t_jw_nv_norma.getLin_cdgo();
                      item_id = t_jw_nv_norma.getItem_id();
                      desc_item = t_jw_nv_norma.getDesc_item()==null?"":t_jw_nv_norma.getDesc_item();
                      id_material = t_jw_nv_norma.getId_material();
                      material = t_jw_nv_norma.getMaterial()==null?"":t_jw_nv_norma.getMaterial();
                      _b0_value = com.egen.util.text.FormatNumber.format(id_norma_venda);
                      _b1_value = com.egen.util.text.FormatNumber.format(id_norma_venda) + "_" + com.egen.util.text.FormatNumber.format(item_id);
                    } else {
                      _b0_control = "__";
                      _b1_control = "__";
                    }
                  }
                }
                %>

              </table>


            </form>

            <%
          } finally {
            if(j!=null){
              j.close();
            }
          }
          %>
        </td>
      </tr>
    </table>

  </body>
</center>
</html>
