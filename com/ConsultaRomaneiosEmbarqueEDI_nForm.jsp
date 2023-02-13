<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta Romaneios Embarque / EDI - Notas Fiscais
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
                  <%@ include file="../system/header_excel.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(133)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_consulta_romaneios" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_consulta_romaneios=0;
              {
                portalbr.dbobj.view.Jw_consulta_romaneios t_jw_consulta_romaneios = new portalbr.dbobj.view.Jw_consulta_romaneios();
                java.util.Vector res_Jw_consulta_romaneios = (java.util.Vector)session.getAttribute("res_Jw_consulta_romaneios");
                if (res_Jw_consulta_romaneios!=null && res_Jw_consulta_romaneios.size()>0) {
                  double            nro_romaneio_embarque =  0;
                  double            nfs_nmro =  0;
                  java.lang.String  nfs_serie = null;
                  java.lang.String  fil_filial = null;
                  java.lang.String  cliente = null;
                  java.lang.String  cidade = null;
                  java.lang.String  uf = null;
                  java.sql.Date     nfs_dtemis = null;
                  double            nfs_vltot = 0;
                  java.lang.String  nota_serie =  null;
                  int               i_bl_report_Jw_consulta_romaneios = 0;
                  java.lang.String[] conhecimentos =  null;
                  java.lang.String conhecimento    =  "";
                  java.lang.String peso = "";
                  java.lang.String valor_frete = "";
                  java.lang.Integer total_pares = null;
                  java.lang.String ped_nmro = "";

                  t_jw_consulta_romaneios = (portalbr.dbobj.view.Jw_consulta_romaneios)res_Jw_consulta_romaneios.elementAt(i_bl_report_Jw_consulta_romaneios);
                  nro_romaneio_embarque = t_jw_consulta_romaneios.getNro_romaneio_embarque();
                  nfs_nmro = t_jw_consulta_romaneios.getNfs_nmro();
                  nfs_serie = t_jw_consulta_romaneios.getNfs_serie()==null?"":t_jw_consulta_romaneios.getNfs_serie();
                  fil_filial = t_jw_consulta_romaneios.getFil_filial()==null?"":t_jw_consulta_romaneios.getFil_filial();
                  cliente = t_jw_consulta_romaneios.getCliente()==null?"":t_jw_consulta_romaneios.getCliente();
                  cidade = t_jw_consulta_romaneios.getCidade()==null?"":t_jw_consulta_romaneios.getCidade();
                  uf = t_jw_consulta_romaneios.getUf()==null?"":t_jw_consulta_romaneios.getUf();
                  nfs_dtemis = (java.sql.Date)t_jw_consulta_romaneios.getNfs_dtemis();
                  nfs_vltot = t_jw_consulta_romaneios.getNfs_vltot();
                  total_pares = t_jw_consulta_romaneios.getNfs_total_pares();//==null?"":t_jw_consulta_romaneios.getNfs_total_pares();
                  nota_serie = com.egen.util.text.FormatNumber.format(nfs_nmro, "0") + " - " + nfs_serie;
                  conhecimentos   = t_jw_consulta_romaneios.getConhecimentos()==null?null:t_jw_consulta_romaneios.getConhecimentos().split("#");
                  ped_nmro = t_jw_consulta_romaneios.getPed_nmro()==null?"":t_jw_consulta_romaneios.getPed_nmro();

                  if(conhecimentos != null){
                    peso         = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[1].replace(",",".")),"0.00");
                    valor_frete  = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[2].replace(",",".")),"#0.00");
                  }else{
                    peso         = " ";
                    valor_frete  = " ";
                  }
                  %>

                  <tr class="reportHeader" >
                    <td class="columnTdHeader" style="text-align:left;">
                      Nro. Romaneio
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Nota / Série
                    </td>
                    <td class="columnTdHeader" style="text-align:center;" width="1%">
                      Filial
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Nro. Pedido
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cliente
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      Cidade
                    </td>
                    <td class="columnTdHeader" style="text-align:left;">
                      UF
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Peso
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Vlr. Frete
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Total Pares
                    </td>
                    <td class="columnTdHeader" style="text-align:center;">
                      Data
                    </td>
                    <td class="columnTdHeader" style="text-align:right;">
                      Valor
                    </td>
                  </tr>

                  <%
                  while (i_bl_report_Jw_consulta_romaneios<res_Jw_consulta_romaneios.size()){
                    counterbl_report_Jw_consulta_romaneios++;
                    String style="";
                    if (!((i_bl_report_Jw_consulta_romaneios%2)!=0)) {
                      style="class=rowColor";
                    } else {
                      style="class=rowBlank";
                    }
                    %>

                    <tr <%= style %> id='TRbl_report_Jw_consulta_romaneios<%=counterbl_report_Jw_consulta_romaneios%>' >
                      <td class="reportColumn" style="text-align:left;">
                        <%= com.egen.util.text.FormatNumber.format(nro_romaneio_embarque, "0") %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= nota_serie %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= fil_filial %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= ped_nmro %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cliente %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= cidade %>
                      </td>
                      <td class="reportColumn" style="text-align:left;">
                        <%= uf %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= peso %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= valor_frete %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= total_pares %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(nfs_dtemis, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:right;">
                        <%= com.egen.util.text.FormatNumber.format(nfs_vltot, "##,##0.00") %>
                      </td>
                    </tr>

                    <%
                    if (++i_bl_report_Jw_consulta_romaneios >= res_Jw_consulta_romaneios.size()) {
                      break;
                    }
                    t_jw_consulta_romaneios = (portalbr.dbobj.view.Jw_consulta_romaneios)res_Jw_consulta_romaneios.elementAt(i_bl_report_Jw_consulta_romaneios);
                    nro_romaneio_embarque = t_jw_consulta_romaneios.getNro_romaneio_embarque();
                    nfs_nmro = t_jw_consulta_romaneios.getNfs_nmro();
                    nfs_serie = t_jw_consulta_romaneios.getNfs_serie()==null?"":t_jw_consulta_romaneios.getNfs_serie();
                    fil_filial = t_jw_consulta_romaneios.getFil_filial()==null?"":t_jw_consulta_romaneios.getFil_filial();
                    cliente = t_jw_consulta_romaneios.getCliente()==null?"":t_jw_consulta_romaneios.getCliente();
                    cidade = t_jw_consulta_romaneios.getCidade()==null?"":t_jw_consulta_romaneios.getCidade();
                    uf = t_jw_consulta_romaneios.getUf()==null?"":t_jw_consulta_romaneios.getUf();
                    nfs_dtemis = (java.sql.Date)t_jw_consulta_romaneios.getNfs_dtemis();
                    nfs_vltot = t_jw_consulta_romaneios.getNfs_vltot();
                    total_pares = t_jw_consulta_romaneios.getNfs_total_pares();//==null?"":t_jw_consulta_romaneios.getNfs_total_pares();
                    nota_serie = com.egen.util.text.FormatNumber.format(nfs_nmro, "0") + " - " + nfs_serie;
                    conhecimentos   = t_jw_consulta_romaneios.getConhecimentos()==null?null:t_jw_consulta_romaneios.getConhecimentos().split("#");
                    ped_nmro = t_jw_consulta_romaneios.getPed_nmro()==null?"":t_jw_consulta_romaneios.getPed_nmro();

                    if(conhecimentos != null){
                      peso         = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[1].replace(",",".")),"0.00");
                      valor_frete  = com.egen.util.text.FormatNumber.format(Double.parseDouble(conhecimentos[2].replace(",",".")),"#0.00");
                    }else{
                      peso         = " ";
                      valor_frete  = " ";
                    }


                  }
                }
              }
              %>
            </table>
            <html:form action="com/ConsultaRomaneiosEmbarqueEDI_nForm.do" method="post" styleClass="baseForm">
              <table class="itemTable"  style=" width:;">
                <html:hidden property="nro_romaneio_embarque"/>
                <table class="buttonTable" style='width:99%;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:submit styleClass="myhidden" property="resetfull_action">
                          <bean:message bundle="ApplicationResources" key="jsp.reset"/>
                        </html:submit>
                        <%
                      }
                      %>
                      <%
                      if(!(request.getParameter("excel")+"").equals("true")){
                        %>
                        <html:button accesskey="a" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                          <bean:message bundle="ApplicationResources" key="jsp.back"/>
                        </html:button>
                        <%
                      }
                      %>
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
