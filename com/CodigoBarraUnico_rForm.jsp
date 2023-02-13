<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Código de Barras Único - EAN13
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
                  <%@ include file="../system/header_sem_ajuda.jsp" %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Ref_cor" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Ref_cor=0;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.com.CodigoBarraUnico_rActionForm CodigoBarraUnico_rActionForm = (portalbr.com.CodigoBarraUnico_rActionForm)session.getAttribute("CodigoBarraUnico_rActionForm");
                portalbr.dbobj.table.Ref_cor t_ref_cor = new portalbr.dbobj.table.Ref_cor();
                java.util.Vector res_Ref_cor = (java.util.Vector)session.getAttribute("res_Ref_cor");
                if (res_Ref_cor!=null && res_Ref_cor.size()>0) {
                  int lin_cdgo =  0;
                  int ref_cdgo =  0;
                  int ref_old  =  0;
                  int cab_cdgo =  0;
                  int cor_cdgo =  0;
                  int contador =  0;
                  java.lang.String ean13 =  null;
                  java.lang.String parametros = "";
                  int i_bl_report_Ref_cor = 0;
                  t_ref_cor = (portalbr.dbobj.table.Ref_cor)res_Ref_cor.elementAt(i_bl_report_Ref_cor);
                  lin_cdgo = t_ref_cor.getLin_cdgo();
                  ref_cdgo = t_ref_cor.getRef_cdgo();
                  ref_old  = t_ref_cor.getRef_cdgo();
                  cab_cdgo = t_ref_cor.getCab_cdgo();
                  cor_cdgo = t_ref_cor.getCor_cdgo();
                  ean13 = "0";
                  //----MONTA PARAMETROS-----------------------------------
                  if(CodigoBarraUnico_rActionForm.getConsulta().equals("1")){
                    parametros = " and ref_cdgo = "+ref_cdgo+
                    " and cab_cdgo = "+cab_cdgo+
                    " and cor_cdgo = "+cor_cdgo;
                  }

                  if(CodigoBarraUnico_rActionForm.getConsulta().equals("2")){
                    parametros = " and ref_cdgo = "+ref_cdgo+
                    " and cab_cdgo = "+cab_cdgo;
                  }

                  if(CodigoBarraUnico_rActionForm.getConsulta().equals("3")){
                    parametros = " and ref_cdgo = "+ref_cdgo;
                  }
                  //-------------------------------------------------------
                  {
                    portalbr.dbobj.view.Jw_retorna_ean13 cr_db_object = new portalbr.dbobj.view.Jw_retorna_ean13();
                    StringBuilder sb = new StringBuilder();
                    sb.append(" SELECT fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13 ");
                    sb.append("   FROM ref_bar ");
                    sb.append("  WHERE nvl(ativo,null) is null ");
                    sb.append("    AND rfb_numero      <> '0' ");
                    sb.append("    AND lin_cdgo        = "+lin_cdgo);
                    sb.append(parametros);
                    sb.append("    order by data_criacao,rfb_numero ");

                    java.util.Vector results = j.select(cr_db_object,
                    sb.toString(),
                    null);

                    if (results != null && results.size() > 0) {
                      portalbr.dbobj.view.Jw_retorna_ean13 r = (portalbr.dbobj.view.Jw_retorna_ean13) results.elementAt(0);
                      ean13 = r.getEan13()+"";
                    }

                    };
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:right;">
                        Linha
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Referência
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Cabedal
                      </td>
                      <td class="columnTdHeader" style="text-align:right;">
                        Cor
                      </td>
                      <td class="columnTdHeader" style="text-align:center;" width="20%">
                        EAN13
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Ref_cor<res_Ref_cor.size()){
                      counterbl_report_Ref_cor++;
                      String style="";
                      if (!((i_bl_report_Ref_cor%2)!=0)) {
                        style="class=rowColor";
                      } else {
                        style="class=rowBlank";
                      }
                      %>
                      <tr <%= style %> id='TRbl_report_Ref_cor<%=counterbl_report_Ref_cor%>' >
                        <td class="reportColumn" style="text-align:right;">
                          <%= lin_cdgo %>
                        </td>
                        <td class="reportColumn" style="text-align:right;">
                          <%= ref_cdgo %>
                        </td>
                        <td class="reportColumn" style="text-align:right;">
                          <%= cab_cdgo %>
                        </td>
                        <td class="reportColumn" style="text-align:right;">
                          <%= cor_cdgo %>
                        </td>
                        <td class="reportColumn" style="text-align:center;" width="20%">
                          <%= ean13 %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Ref_cor >= res_Ref_cor.size()) {
                        break;
                      }
                      t_ref_cor = (portalbr.dbobj.table.Ref_cor)res_Ref_cor.elementAt(i_bl_report_Ref_cor);
                      lin_cdgo = t_ref_cor.getLin_cdgo();
                      ref_cdgo = t_ref_cor.getRef_cdgo();
                      cab_cdgo = t_ref_cor.getCab_cdgo();
                      cor_cdgo = t_ref_cor.getCor_cdgo();
                      //----MONTA PARAMETROS-----------------------------------
                      if(CodigoBarraUnico_rActionForm.getConsulta().equals("1")){
                        parametros = " and ref_cdgo = "+ref_cdgo+
                        " and cab_cdgo = "+cab_cdgo+
                        " and cor_cdgo = "+cor_cdgo;
                      }

                      if(CodigoBarraUnico_rActionForm.getConsulta().equals("2")){
                        parametros = " and ref_cdgo = "+ref_cdgo+
                        " and cab_cdgo = "+cab_cdgo;
                      }

                      if(CodigoBarraUnico_rActionForm.getConsulta().equals("3")){
                        parametros = " and ref_cdgo = "+ref_cdgo;
                      }
                      //-------------------------------------------------------
                      if(!(CodigoBarraUnico_rActionForm.getConsulta().equals("4")))
                      {
                        if(CodigoBarraUnico_rActionForm.getConsulta().equals("3")){
                          if(ref_cdgo!=ref_old){
                          ref_old=ref_cdgo;}

                          if(contador>100){
                            contador = 0;
                            //j.close();
                            //j = new com.egen.util.jdbc.JdbcUtil();
                            portalbr.dbobj.view.Jw_retorna_ean13 cr_db_object = new portalbr.dbobj.view.Jw_retorna_ean13();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" SELECT fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13 ");
                            sb2.append("   FROM ref_bar ");
                            sb2.append("  WHERE nvl(ativo,null) is null ");
                            sb2.append("    AND rfb_numero      <> '0' ");
                            sb2.append("    AND lin_cdgo        = "+lin_cdgo);
                            sb2.append(parametros);
                            sb2.append("   ORDER BY data_criacao ");
                            sb2.append("          , rfb_numero ");


                            java.util.Vector results = j.select(cr_db_object,
                            sb2.toString(),
                            null);
                            contador++;
                            if (results != null && results.size() > 0) {
                              portalbr.dbobj.view.Jw_retorna_ean13 r = (portalbr.dbobj.view.Jw_retorna_ean13) results.elementAt(0);
                              ean13 = r.getEan13()+"";
                            } else {
                              ean13 = "0";
                            }

                          }
                        }else{
                          if(contador>100){
                            contador = 0;
                            //j.close();
                            //j = new com.egen.util.jdbc.JdbcUtil();
                          }

                          portalbr.dbobj.view.Jw_retorna_ean13 cr_db_object = new portalbr.dbobj.view.Jw_retorna_ean13();
                          StringBuilder sb3 = new StringBuilder();
                          sb3.append(" SELECT fct_retorna_cod_barra(ref_bar.lin_cdgo, ref_bar.ref_cdgo, ref_bar.cab_cdgo, ref_bar.cor_cdgo, rfb_numero) ean13 ");
                          sb3.append("   FROM ref_bar ");
                          sb3.append("  WHERE nvl(ativo,null) is null ");
                          sb3.append("    AND rfb_numero      <> '0' ");
                          sb3.append("    AND lin_cdgo        = ").append(lin_cdgo);
                          sb3.append(parametros);
                          sb3.append("    order by data_criacao,rfb_numero ");

                          java.util.Vector results = j.select(cr_db_object,
                          sb3.toString(),
                          null);
                          contador++;
                          if (results != null && results.size() > 0) {
                            portalbr.dbobj.view.Jw_retorna_ean13 r = (portalbr.dbobj.view.Jw_retorna_ean13) results.elementAt(0);
                            ean13 = r.getEan13()+"";
                          }else{
                            ean13 = "0";
                          }

                        }
                      }

                    }
                  }
                } catch (Exception e) {
                } finally {
                  if(j!=null) {
                    j.close();
                    j = null;
                  }
                }
                %>
              </table>
              <html:form action="com/CodigoBarraUnico_rForm.do" method="post" styleClass="baseForm">
                <table class="itemTable"  style=" width:;">
                  <html:hidden property="consulta"/>
                  <table class="buttonTable" style='width:99%;'>
                    <tr class="buttonTr">
                      <td class="buttonTd">
                        <html:button onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:button>
                      </td>
                    </tr>
                  </table>

                </html:form>
              </td>
            </tr>
          </table>

        </body>
      </center>
    </html>
