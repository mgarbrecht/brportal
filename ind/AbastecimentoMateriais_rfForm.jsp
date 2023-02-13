<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <head>
    <bean:message key="page.css"/>
    <bean:message key="page.script"/>
  </head>
  <center>
    <body>
      <table class="mainTable" style='width:100%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <html:form action="ind/AbastecimentoMateriais_rfForm.do" method="post" styleClass="baseForm">
              <!--
                <table class="buttonTable" style='width:100%;'> <tr class="buttonTd" style="border-top: none"> <td style="text-align: right"> <html:submit accesskey="i" value="+ Adicionar" styleClass="baseButton" property="insert_action"> </html:submit> </td> </tr> </table>
              -->
            </html:form>
            <link type="text/css" href="../css/jquery-ui-1.7.1.custom.css" rel="Stylesheet" />
            <script type="text/javascript" src="../script/jquery-ui-1.7.1.custom.min.js">
            </script>

            <style type="text/css">






              .fg-button { outline: 0; margin:0 4px 0 0; padding: .4em 1em; text-decoration:none !important; cursor:pointer; position: relative; text-align: center; zoom: 1; } .fg-button .ui-icon { position: absolute; top: 50%; margin-top: -8px; left: 50%; margin-left: -8px; } a.fg-button { float:left; } /* remove extra button width in IE */ button.fg-button { width:auto; overflow:visible; } .fg-button-icon-left { padding-left: 2.1em; } .fg-button-icon-right { padding-right: 2.1em; } .fg-button-icon-left .ui-icon { right: auto; left: .2em; margin-left: 0; } .fg-button-icon-right .ui-icon { left: auto; right: .2em; margin-left: 0; } .fg-button-icon-solo { display:block; width:8px; text-indent: -9999px; } /* solo icon buttons must have block properties for the text-indent to work */ .fg-buttonset { float:left; } .fg-buttonset .fg-button { float: left; } .fg-buttonset-single .fg-button, .fg-buttonset-multi .fg-button { margin-right: -1px;} .fg-toolbar { padding: .5em; margin: 0; } .fg-toolbar .fg-buttonset { margin-right:1.5em; padding-left: 1px; } .fg-toolbar .fg-button { font-size: 1em; } /*demo page css*/ h2 { clear: both; padding-top:1.5em; margin-top:0; } .strike { text-decoration: line-through; }
            </style>



            <%
            {
              Double saldo = 0.0;
              String fornecedor_codigo1 = null;
              String fen_seq1 = null;
              String ies_codigo1 = null;
              String cor_cdgo1 = null;
              %>

              <%
              java.util.Vector res_Req_sdo_abastecimento_fornec = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                saldo = Double.parseDouble((String)request.getParameter("saldo"));
                fornecedor_codigo1 = (String)request.getParameter("fornecedor_codigo");
                fen_seq1 = (String)request.getParameter("fen_seq");
                ies_codigo1 = (String)request.getParameter("codigo");
                cor_cdgo1 = (String)request.getParameter("cor_cdgo");
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.table.Req_sdo_abastecimento_fornec t_req_sdo_abastecimento_fornec = new portalbr.dbobj.table.Req_sdo_abastecimento_fornec();
                String[][] select = {{"ies_codigo",null},{"cor_cdgo",null},{"tai_codigo",null},{"cod_min_fabr",null},{"for_codigo",null},{"fen_seq",null},{"quantidade_transito",null},{"quantidade_produzida",null},{"quantidade_atraso",null},{"data_entrega",null},{"sdo_req",null},{"data_atualizacao",null},{"id",null},};
                Object[][] where = null;
                where = new Object[][]{{"for_codigo","=", fornecedor_codigo1},
                {"fen_seq","=", fen_seq1},
                {"ies_codigo","=", ies_codigo1},
                {"cor_cdgo","=", cor_cdgo1},};
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;

                res_Req_sdo_abastecimento_fornec = j.select(t_req_sdo_abastecimento_fornec,select,where,groupby,having,order);
              } catch (Exception e){
                e.printStackTrace(System.out);
              } finally {
              if(j!=null){j.close();}
            }
            %>


            <form  name="bl_report_Req_sdo_abastecimento_fornec" id="bl_report_Req_sdo_abastecimento_fornec" class="baseForm" method="post" >
              <a href="#" onclick="wopen('../ind/AbastecimentoMateriais_aForm.do?pop_action=&id=&fornecedor_codigo=<%= fornecedor_codigo1 %>&fen_seq=<%= fen_seq1 %>&ies_codigo=<%= ies_codigo1 %>&cor_cdgo=<%= cor_cdgo1 %>&tai_codigo=&cod_min_fabr=&quantidade_transito=&quantidade_produzida=&quantidade_atraso=&data_entrega=&sdo_req=<%= saldo %>&data_atualizacao=','_blank',400,200)" class="fg-button ui-state-default fg-button-icon-left ui-corner-all">
                <span class="ui-icon ui-icon-circle-plus">
                </span>
                Adicionar
              </a>
              <%
              if (res_Req_sdo_abastecimento_fornec!=null && res_Req_sdo_abastecimento_fornec.size()>0) {
                %>
                <table id="TRbl_report_Req_sdo_abastecimento_fornec"  class="reportTable"  style="width: 500px; border-color: gray" border="1" >
                  <%
                  java.lang.Long ies_codigo =  null;
                  java.lang.Integer cor_cdgo =  null;
                  java.lang.String tai_codigo =  null;
                  java.lang.Integer cod_min_fabr =  null;
                  java.lang.Long for_codigo =  null;
                  java.lang.Integer fen_seq =  null;
                  java.lang.Double quantidade_transito =  null;
                  java.lang.Double quantidade_produzida =  null;
                  java.lang.Double quantidade_atraso =  null;
                  java.sql.Date data_entrega =  null;
                  java.lang.Double sdo_req =  null;
                  java.sql.Timestamp data_atualizacao =  null;
                  java.lang.Integer id =  null;
                  java.lang.String excluir =  null;
                  %>



                  <tr class="reportTr">
                    <td class="columnTdHeader" style="text-align:right;" >
                      Qtde. Trânsito
                    </td>

                    <td class="columnTdHeader" style="text-align:right;" >
                      Qtde. Atraso
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                      Dt. Entrega
                    </td>

                    <td class="columnTdHeader" style="text-align:center;" >
                    </td>

                  </tr>



                  <%
                  int i_bl_report_Req_sdo_abastecimento_fornec = 0;
                  while (i_bl_report_Req_sdo_abastecimento_fornec<res_Req_sdo_abastecimento_fornec.size()) {
                    portalbr.dbobj.table.Req_sdo_abastecimento_fornec t_req_sdo_abastecimento_fornec = (portalbr.dbobj.table.Req_sdo_abastecimento_fornec)res_Req_sdo_abastecimento_fornec.elementAt(i_bl_report_Req_sdo_abastecimento_fornec);
                    ies_codigo = t_req_sdo_abastecimento_fornec.getIes_codigo();
                    cor_cdgo = t_req_sdo_abastecimento_fornec.getCor_cdgo();
                    tai_codigo = t_req_sdo_abastecimento_fornec.getTai_codigo()==null?"":t_req_sdo_abastecimento_fornec.getTai_codigo();
                    cod_min_fabr = t_req_sdo_abastecimento_fornec.getCod_min_fabr();
                    for_codigo = t_req_sdo_abastecimento_fornec.getFor_codigo();
                    fen_seq = t_req_sdo_abastecimento_fornec.getFen_seq();
                    quantidade_transito = t_req_sdo_abastecimento_fornec.getQuantidade_transito();
                    quantidade_produzida = t_req_sdo_abastecimento_fornec.getQuantidade_produzida();
                    quantidade_atraso = t_req_sdo_abastecimento_fornec.getQuantidade_atraso();
                    data_entrega = (java.sql.Date)t_req_sdo_abastecimento_fornec.getData_entrega();
                    sdo_req = t_req_sdo_abastecimento_fornec.getSdo_req();
                    data_atualizacao = (java.sql.Timestamp)t_req_sdo_abastecimento_fornec.getData_atualizacao();
                    id = t_req_sdo_abastecimento_fornec.getId();
                    String style_bl_report_Req_sdo_abastecimento_fornec="";
                    if (!((i_bl_report_Req_sdo_abastecimento_fornec%2)!=0)) {
                      style_bl_report_Req_sdo_abastecimento_fornec="rowColor";
                    } else {
                      style_bl_report_Req_sdo_abastecimento_fornec="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Req_sdo_abastecimento_fornec %>' id="TRbl_report_Req_sdo_abastecimento_fornec<%=i_bl_report_Req_sdo_abastecimento_fornec%>" >
                      <td class="reportColumn" style="text-align:right;" width="100px" >
                        <%= com.egen.util.text.FormatNumber.format(quantidade_transito, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:right;" width="100px" >
                        <%= com.egen.util.text.FormatNumber.format(quantidade_atraso, "##,##0.00") %>
                      </td>

                      <td class="reportColumn" style="text-align:center;"width="100px" >
                        <%= com.egen.util.text.FormatDate.format(data_entrega, "dd/MM/yyyy") %>
                      </td>

                      <td class="reportColumn" style="text-align: center;" width="200px">
                        <center>
                          <a href="#" onclick="if(confirm('Confirma a exclusão?')){jQuery.post('../ind/AbastecimentoMateriais_rForm.do?delete_action=&id=<%= id %>',function(){wopen('../ind/AbastecimentoMateriais_rForm.jsp?ok=true','_self');});}" class="fg-button ui-state-default fg-button-icon-left ui-corner-all">
                            <span class="ui-icon ui-icon-trash">
                            </span>
                            Excluir
                          </a>
                          <a href="#" onclick="wopen('../ind/AbastecimentoMateriais_aForm.do?select_action=&id=<%= id %>&sdo_req=<%= saldo %>','_blank',400,200)" class="fg-button ui-state-default fg-button-icon-left ui-corner-all">
                            <span class="ui-icon ui-icon-pencil">
                            </span>
                            Alterar
                          </a>
                        </center>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Req_sdo_abastecimento_fornec++;
                    if (i_bl_report_Req_sdo_abastecimento_fornec<res_Req_sdo_abastecimento_fornec.size()) {
                      t_req_sdo_abastecimento_fornec = (portalbr.dbobj.table.Req_sdo_abastecimento_fornec)res_Req_sdo_abastecimento_fornec.elementAt(i_bl_report_Req_sdo_abastecimento_fornec);
                      ies_codigo = t_req_sdo_abastecimento_fornec.getIes_codigo();
                      cor_cdgo = t_req_sdo_abastecimento_fornec.getCor_cdgo();
                      tai_codigo = t_req_sdo_abastecimento_fornec.getTai_codigo()==null?"":t_req_sdo_abastecimento_fornec.getTai_codigo();
                      cod_min_fabr = t_req_sdo_abastecimento_fornec.getCod_min_fabr();
                      for_codigo = t_req_sdo_abastecimento_fornec.getFor_codigo();
                      fen_seq = t_req_sdo_abastecimento_fornec.getFen_seq();
                      quantidade_transito = t_req_sdo_abastecimento_fornec.getQuantidade_transito();
                      quantidade_produzida = t_req_sdo_abastecimento_fornec.getQuantidade_produzida();
                      quantidade_atraso = t_req_sdo_abastecimento_fornec.getQuantidade_atraso();
                      data_entrega = (java.sql.Date)t_req_sdo_abastecimento_fornec.getData_entrega();
                      sdo_req = t_req_sdo_abastecimento_fornec.getSdo_req();
                      data_atualizacao = (java.sql.Timestamp)t_req_sdo_abastecimento_fornec.getData_atualizacao();
                      id = t_req_sdo_abastecimento_fornec.getId();
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
