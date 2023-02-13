<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Movimentações do dia
    </title>
  </head>
  <center>
    <body onload="JavaScript:timedRefresh(15000);">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(192)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <script type="text/JavaScript">
              <!--
              function timedRefresh(timeoutPeriod) {
                //	setTimeout("top.location= '../com/KanBanClientesNovosForm.jsp';",timeoutPeriod);
              }
              //   -->
            </script>

            <%
            {
              %>

              <%
              java.util.Vector res_Jw_movimentacoes_dia = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_movimentacoes_dia t_jw_movimentacoes_dia = new portalbr.dbobj.view.Jw_movimentacoes_dia();
                StringBuilder sb = new StringBuilder();
                sb.append(" SELECT DISTINCT ped.pedido_ifv ped ");
                sb.append("                ,DECODE(NVL(ped.status_pedido, 0), 0, 'Nao Confirmado', 98, 'Importado', 3, 'Processando', ped.status_pedido) sts ");
                sb.append("                ,ped.tipo_pedido tp ");
                sb.append("                ,ped.codigo_cliente || ' - ' || ped.sequencial_cliente cliente ");
                sb.append("                ,cli.cli_nome nome ");
                sb.append("                ,ecl.est_unifed uf ");
                sb.append("                ,esc.esc_email email ");
                sb.append("                ,'(' || fone.ffs_ddd2 || ') ' || fone.ffs_nmro2 fone ");
                sb.append("                ,'' rep ");
                sb.append("                ,ped.livro_preco liv ");
                sb.append("                ,ped.codigo_cond_pagto cnd ");
                sb.append("                ,ite.codigo_marca marca ");
                sb.append("                ,ite.codigo_linha linha ");
                sb.append("                ,ite.codigo_referencia REF ");
                sb.append("                ,ite.codigo_cabedal cab ");
                sb.append("                ,ite.codigo_cor cor ");
                sb.append("                ,ite.quantidade_item qtd ");
                sb.append("                ,ite.valor_bruto vlr ");
                sb.append("                ,ped.data_emissao data ");
                sb.append("  FROM fax_fon2 fone  ");
                sb.append("      ,ecl  ");
                sb.append("      ,esc esc  ");
                sb.append("      ,cli cli  ");
                sb.append("      ,webstore.wt_item_carrinho@sadig ite  ");
                sb.append("      ,webstore.wt_carrinho@sadig ped ");
                sb.append("  WHERE 1 = 1 ");
                sb.append("    AND fone.esc_seqn = esc.esc_seqn ");
                sb.append("    AND fone.cli_cdgo = esc.cli_cdgo ");
                sb.append("    AND ecl.esc_seqn = esc.esc_seqn ");
                sb.append("    AND ecl.cli_cdgo = esc.cli_cdgo ");
                sb.append("    AND esc.esc_seqn = ped.sequencial_cliente ");
                sb.append("    AND esc.cli_cdgo = ped.codigo_cliente ");
                sb.append("    AND cli.cli_cdgo = ped.codigo_cliente ");
                sb.append("    AND ite.pedido_ifv = ped.pedido_ifv ");
                sb.append("    AND TRUNC(ped.data_emissao) >= TRUNC(SYSDATE) ");
                sb.append("    AND NVL(ped.status_pedido, 0) <> 98 ");
                sb.append("    AND ped.codigo_cliente NOT IN (99991, 99992, 75199) ");
                sb.append("    AND TO_CHAR(SYSDATE, 'D') <>  2 ");
                sb.append(" UNION ");
                sb.append(" SELECT DISTINCT ped.pedido_ifv ped ");
                sb.append("                ,DECODE(NVL(ped.status_pedido, 0), 0, 'Nao Confirmado', 98, 'Importado', 3, 'Processando', ped.status_pedido) sts ");
                sb.append("                ,ped.tipo_pedido tp ");
                sb.append("                ,ped.codigo_cliente || ' - ' || ped.sequencial_cliente cliente ");
                sb.append("                ,cli.cli_nome nome ");
                sb.append("                ,ecl.est_unifed uf ");
                sb.append("                ,esc.esc_email email ");
                sb.append("                ,'(' || fone.ffs_ddd2 || ') ' || fone.ffs_nmro2 fone ");
                sb.append("                ,'' rep ");
                sb.append("                ,ped.livro_preco liv ");
                sb.append("                ,ped.codigo_cond_pagto cnd ");
                sb.append("                ,ite.codigo_marca marca ");
                sb.append("                ,ite.codigo_linha linha ");
                sb.append("                ,ite.codigo_referencia REF ");
                sb.append("                ,ite.codigo_cabedal cab ");
                sb.append("                ,ite.codigo_cor cor ");
                sb.append("                ,ite.quantidade_item qtd ");
                sb.append("                ,ite.valor_bruto vlr ");
                sb.append("                ,ped.data_emissao data ");
                sb.append("  FROM fax_fon2 fone  ");
                sb.append("      ,ecl  ");
                sb.append("      ,esc esc  ");
                sb.append("      ,cli cli  ");
                sb.append("      ,webstore.wt_item_carrinho@sadig ite  ");
                sb.append("      ,webstore.wt_carrinho@sadig ped ");
                sb.append("  WHERE 1 = 1 ");
                sb.append("    AND fone.esc_seqn = esc.esc_seqn ");
                sb.append("    AND fone.cli_cdgo = esc.cli_cdgo ");
                sb.append("    AND ecl.esc_seqn = esc.esc_seqn ");
                sb.append("    AND ecl.cli_cdgo = esc.cli_cdgo ");
                sb.append("    AND esc.esc_seqn = ped.sequencial_cliente ");
                sb.append("    AND esc.cli_cdgo = ped.codigo_cliente ");
                sb.append("    AND cli.cli_cdgo = ped.codigo_cliente ");
                sb.append("    AND ite.pedido_ifv = ped.pedido_ifv ");
                sb.append("    AND TRUNC(ped.data_emissao) >= TRUNC(SYSDATE)-2 ");
                sb.append("    AND NVL(ped.status_pedido, 0) <> 98 ");
                sb.append("    AND ped.codigo_cliente NOT IN (99991, 99992, 75199) ");
                sb.append("    AND TO_CHAR(SYSDATE, 'D') = 2 ");

                res_Jw_movimentacoes_dia = j.select(t_jw_movimentacoes_dia, sb.toString(), null);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_movimentacoes_dia" id="bl_report_Jw_movimentacoes_dia" class="baseForm" method="post" >


              <%
              if (res_Jw_movimentacoes_dia!=null && res_Jw_movimentacoes_dia.size()>0) {
                %>

                <table id="TRbl_report_Jw_movimentacoes_dia"  class="reportTable"   style="width:99%;" border="1"   >
                  <%
                  java.lang.String ped =  null;
                  java.lang.String sts =  null;
                  java.lang.String tp =  null;
                  java.lang.String cliente =  null;
                  java.lang.String nome =  null;
                  java.lang.String uf =  null;
                  java.lang.String email =  null;
                  java.lang.String fone =  null;
                  java.lang.String rep =  null;
                  java.lang.String liv =  null;
                  java.lang.String cnd =  null;
                  java.lang.String marca =  null;
                  java.lang.String linha =  null;
                  java.lang.String ref =  null;
                  java.lang.String cab =  null;
                  java.lang.String cor =  null;
                  java.lang.Integer qtd =  null;
                  double vlr =  0;
                  java.sql.Timestamp datam =  null;
                  %>

                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:left;" >
                      Ped.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Status
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Tp.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cliente
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Nome
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      UF
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      eMail
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Fone
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Rep.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Liv.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cnd.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Marca
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Linha
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Ref.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cab.
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Cor
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Qtd.
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Vlr.
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Data
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Jw_movimentacoes_dia = 0;
                  while (i_bl_report_Jw_movimentacoes_dia<res_Jw_movimentacoes_dia.size()) {
                    portalbr.dbobj.view.Jw_movimentacoes_dia t_jw_movimentacoes_dia = (portalbr.dbobj.view.Jw_movimentacoes_dia)res_Jw_movimentacoes_dia.elementAt(i_bl_report_Jw_movimentacoes_dia);
                    ped = t_jw_movimentacoes_dia.getPed()==null?"":t_jw_movimentacoes_dia.getPed();
                    sts = t_jw_movimentacoes_dia.getSts()==null?"":t_jw_movimentacoes_dia.getSts();
                    tp = t_jw_movimentacoes_dia.getTp()==null?"":t_jw_movimentacoes_dia.getTp();
                    cliente = t_jw_movimentacoes_dia.getCliente()==null?"":t_jw_movimentacoes_dia.getCliente();
                    nome = t_jw_movimentacoes_dia.getNome()==null?"":t_jw_movimentacoes_dia.getNome();
                    uf = t_jw_movimentacoes_dia.getUf()==null?"":t_jw_movimentacoes_dia.getUf();
                    email = t_jw_movimentacoes_dia.getEmail()==null?"":t_jw_movimentacoes_dia.getEmail();
                    fone = t_jw_movimentacoes_dia.getFone()==null?"":t_jw_movimentacoes_dia.getFone();
                    rep = t_jw_movimentacoes_dia.getRep()==null?"":t_jw_movimentacoes_dia.getRep();
                    liv = t_jw_movimentacoes_dia.getLiv()==null?"":t_jw_movimentacoes_dia.getLiv();
                    cnd = t_jw_movimentacoes_dia.getCnd()==null?"":t_jw_movimentacoes_dia.getCnd();
                    marca = t_jw_movimentacoes_dia.getMarca()==null?"":t_jw_movimentacoes_dia.getMarca();
                    linha = t_jw_movimentacoes_dia.getLinha()==null?"":t_jw_movimentacoes_dia.getLinha();
                    ref = t_jw_movimentacoes_dia.getRef()==null?"":t_jw_movimentacoes_dia.getRef();
                    cab = t_jw_movimentacoes_dia.getCab()==null?"":t_jw_movimentacoes_dia.getCab();
                    cor = t_jw_movimentacoes_dia.getCor()==null?"":t_jw_movimentacoes_dia.getCor();
                    qtd = t_jw_movimentacoes_dia.getQtd();
                    vlr = t_jw_movimentacoes_dia.getVlr();
                    datam = (java.sql.Timestamp)t_jw_movimentacoes_dia.getData();
                    String style_bl_report_Jw_movimentacoes_dia="";
                    if (!((i_bl_report_Jw_movimentacoes_dia%2)!=0)) {
                      style_bl_report_Jw_movimentacoes_dia="rowColor";
                    } else {
                      style_bl_report_Jw_movimentacoes_dia="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Jw_movimentacoes_dia %>' id="TRbl_report_Jw_movimentacoes_dia<%=i_bl_report_Jw_movimentacoes_dia%>" >
                      <td class="reportColumn" style="text-align:left;" >
                        <%= ped %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= sts %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= tp %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cliente %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= nome %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= uf %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= email %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= fone %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= rep %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= liv %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cnd %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= marca %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= linha %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= ref %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cab %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= cor %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= ((qtd!=null)?qtd.toString():"") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" >
                        <%= com.egen.util.text.FormatNumber.format(vlr, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(datam, "dd/MM/yyyy HH:mm:ss") %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Jw_movimentacoes_dia++;
                    if (i_bl_report_Jw_movimentacoes_dia<res_Jw_movimentacoes_dia.size()) {
                      t_jw_movimentacoes_dia = (portalbr.dbobj.view.Jw_movimentacoes_dia)res_Jw_movimentacoes_dia.elementAt(i_bl_report_Jw_movimentacoes_dia);
                      ped = t_jw_movimentacoes_dia.getPed()==null?"":t_jw_movimentacoes_dia.getPed();
                      sts = t_jw_movimentacoes_dia.getSts()==null?"":t_jw_movimentacoes_dia.getSts();
                      tp = t_jw_movimentacoes_dia.getTp()==null?"":t_jw_movimentacoes_dia.getTp();
                      cliente = t_jw_movimentacoes_dia.getCliente()==null?"":t_jw_movimentacoes_dia.getCliente();
                      nome = t_jw_movimentacoes_dia.getNome()==null?"":t_jw_movimentacoes_dia.getNome();
                      uf = t_jw_movimentacoes_dia.getUf()==null?"":t_jw_movimentacoes_dia.getUf();
                      email = t_jw_movimentacoes_dia.getEmail()==null?"":t_jw_movimentacoes_dia.getEmail();
                      fone = t_jw_movimentacoes_dia.getFone()==null?"":t_jw_movimentacoes_dia.getFone();
                      rep = t_jw_movimentacoes_dia.getRep()==null?"":t_jw_movimentacoes_dia.getRep();
                      liv = t_jw_movimentacoes_dia.getLiv()==null?"":t_jw_movimentacoes_dia.getLiv();
                      cnd = t_jw_movimentacoes_dia.getCnd()==null?"":t_jw_movimentacoes_dia.getCnd();
                      marca = t_jw_movimentacoes_dia.getMarca()==null?"":t_jw_movimentacoes_dia.getMarca();
                      linha = t_jw_movimentacoes_dia.getLinha()==null?"":t_jw_movimentacoes_dia.getLinha();
                      ref = t_jw_movimentacoes_dia.getRef()==null?"":t_jw_movimentacoes_dia.getRef();
                      cab = t_jw_movimentacoes_dia.getCab()==null?"":t_jw_movimentacoes_dia.getCab();
                      cor = t_jw_movimentacoes_dia.getCor()==null?"":t_jw_movimentacoes_dia.getCor();
                      qtd = t_jw_movimentacoes_dia.getQtd();
                      vlr = t_jw_movimentacoes_dia.getVlr();
                      datam = (java.sql.Timestamp)t_jw_movimentacoes_dia.getData();
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
