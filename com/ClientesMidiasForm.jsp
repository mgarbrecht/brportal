<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Listagem de Clientes - Entrega Mídias
    </title>
  </head>
  <center>
    <body onload="if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(156)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/ClientesMidiasForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo_marca"/>
                    <html:errors property="codigo_regional"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_midias"/>
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
                    <html:select property="codigo_marca" styleId="codigo_marca" styleClass="baseField" size="1">
                      <html:options property="codigo_marcaList" labelProperty="codigo_marcaLabelList" styleClass="baseOptions"/>
                    </html:select>
                  </td>
                </tr>

                <%
                String codigo_regional="";
                String tipo="";
                acesso.Sessao se = new acesso.Sessao(session);
                if(se.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  codigo_regional = se.getChave()+"";
                }

                if(codigo_regional.equals("")){
                  %>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Regional
                      </span>
                    </td>
                    <td class="formField">
                      <html:select property="codigo_regional" styleId="codigo_regional" styleClass="baseField" size="1">
                        <html:options property="codigo_regionalList" labelProperty="codigo_regionalLabelList" styleClass="baseOptions"/>
                      </html:select>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="codigo_regional" value="<%=codigo_regional%>" />
                  <%
                }
                %>
                <tr class="itemTr">
                  <td class="formLabel">
                    <span class="spamFormLabel">
                      Abre o Relatório Automaticamente
                    </span>
                  </td>
                  <td class="formField">
                    <html:checkbox property="abre_automaticamente" styleId="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                    <span class="spamFormLabel">
                    </span>
                    <html:text property="mensagem" styleId="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;text-align:start;" styleClass="baseField" readonly="true" size="80"/>
                  </td>
                </tr>

              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:submit accesskey="p" value="Gerar Planilha" onclick="bloqueia();" styleClass="baseButton" property="select_action">
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
              java.util.Vector res_Jw_clientes_midias = (java.util.Vector)session.getAttribute("res_Jw_clientes_midias");
              util.consultas.Parametros parametros = new util.consultas.Parametros();
              %>

              <form  name="bl_report_Jw_clientes_midias" id="bl_report_Jw_clientes_midias" class="baseForm" method="post" >

                <%
                if (res_Jw_clientes_midias!=null && res_Jw_clientes_midias.size()>0) {
                  String real_path = com.egen.util.servlet.Context.getRealPath(getServletContext(), "/index.html");
                  real_path = real_path.substring(0,real_path.lastIndexOf("index.html"));
                  String separator_path = real_path.substring(real_path.length()-1);
                  String random = com.egen.util.text.FormatNumber.format(Math.random()*1000,"0");
                  org.apache.poi.hssf.usermodel.HSSFWorkbook wb = new org.apache.poi.hssf.usermodel.HSSFWorkbook();
                  org.apache.poi.hssf.usermodel.HSSFSheet sheet = wb.createSheet("Clientes Midias");
                  org.apache.poi.hssf.usermodel.HSSFCellStyle style;
                  org.apache.poi.hssf.usermodel.HSSFDataFormat format = wb.createDataFormat();
                  org.apache.poi.hssf.usermodel.HSSFRow row;
                  org.apache.poi.hssf.usermodel.HSSFCell cell;
                  int rowCount = 0;
                  int cellCount = 0;
                  java.lang.String marca =  null;
                  java.lang.String regional =  null;
                  java.lang.String cliente =  null;
                  java.lang.String cnpj =  null;
                  java.lang.String inscricao_estadual =  null;
                  java.lang.String fone =  null;
                  java.lang.String endereco =  null;
                  java.lang.String ecl_cep =  null;
                  java.lang.String bairro_cidade_estado =  null;
                  row = sheet.createRow((short)rowCount++);
                  cellCount = 0;
                  String marca_label = "";
                  marca_label = "marca";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(marca_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String regional_label = "";
                  regional_label = "regional";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(regional_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String cliente_label = "";
                  cliente_label = "cliente";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(cliente_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String cnpj_label = "";
                  cnpj_label = "cnpj";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(cnpj_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String inscricao_estadual_label = "";
                  inscricao_estadual_label = "inscricao_estadual";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(inscricao_estadual_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String fone_label = "";
                  fone_label = "fone";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(fone_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String endereco_label = "";
                  endereco_label = "endereco";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(endereco_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String ecl_cep_label = "";
                  ecl_cep_label = "ecl_cep";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(ecl_cep_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  String bairro_cidade_estado_label = "";
                  bairro_cidade_estado_label = "bairro_cidade_estado";
                  cell = row.createCell((short)cellCount++);
                  cell.setCellValue(bairro_cidade_estado_label);
                  style = wb.createCellStyle();
                  style.setFillForegroundColor(org.apache.poi.hssf.util.HSSFColor.GREY_25_PERCENT.index);
                  style.setFillPattern(org.apache.poi.hssf.usermodel.HSSFCellStyle.SOLID_FOREGROUND);
                  style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                  cell.setCellStyle(style);
                  int i_bl_report_Jw_clientes_midias = 0;
                  while (i_bl_report_Jw_clientes_midias<res_Jw_clientes_midias.size()) {
                    portalbr.dbobj.view.Jw_clientes_midias t_jw_clientes_midias = (portalbr.dbobj.view.Jw_clientes_midias)res_Jw_clientes_midias.elementAt(i_bl_report_Jw_clientes_midias);
                    marca = t_jw_clientes_midias.getMarca()==null?"":t_jw_clientes_midias.getMarca();
                    regional = t_jw_clientes_midias.getRegional()==null?"":t_jw_clientes_midias.getRegional();
                    cliente = t_jw_clientes_midias.getCliente()==null?"":t_jw_clientes_midias.getCliente();
                    cnpj = t_jw_clientes_midias.getCnpj()==null?"":t_jw_clientes_midias.getCnpj();
                    inscricao_estadual = t_jw_clientes_midias.getInscricao_estadual()==null?"":t_jw_clientes_midias.getInscricao_estadual();
                    fone = t_jw_clientes_midias.getFone()==null?"":t_jw_clientes_midias.getFone();
                    endereco = t_jw_clientes_midias.getEndereco()==null?"":t_jw_clientes_midias.getEndereco();
                    ecl_cep = t_jw_clientes_midias.getEcl_cep()==null?"":t_jw_clientes_midias.getEcl_cep();
                    bairro_cidade_estado = t_jw_clientes_midias.getBairro_cidade_estado()==null?"":t_jw_clientes_midias.getBairro_cidade_estado();
                    row = sheet.createRow((short)rowCount++);
                    cellCount = 0;
                    String marca_value = marca;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(marca_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String regional_value = regional;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(regional_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String cliente_value = cliente;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(cliente_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String cnpj_value = cnpj;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(cnpj_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String inscricao_estadual_value = inscricao_estadual;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(inscricao_estadual_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String fone_value = fone;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(fone_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String endereco_value = endereco;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(endereco_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String ecl_cep_value = ecl_cep;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(ecl_cep_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    String bairro_cidade_estado_value = bairro_cidade_estado;
                    cell = row.createCell((short)cellCount++);
                    cell.setCellValue(bairro_cidade_estado_value);
                    style = wb.createCellStyle();
                    style.setAlignment(org.apache.poi.hssf.usermodel.HSSFCellStyle.ALIGN_LEFT);
                    cell.setCellStyle(style);
                    i_bl_report_Jw_clientes_midias++;
                    if (i_bl_report_Jw_clientes_midias<res_Jw_clientes_midias.size()) {
                      t_jw_clientes_midias = (portalbr.dbobj.view.Jw_clientes_midias)res_Jw_clientes_midias.elementAt(i_bl_report_Jw_clientes_midias);
                      marca = t_jw_clientes_midias.getMarca()==null?"":t_jw_clientes_midias.getMarca();
                      regional = t_jw_clientes_midias.getRegional()==null?"":t_jw_clientes_midias.getRegional();
                      cliente = t_jw_clientes_midias.getCliente()==null?"":t_jw_clientes_midias.getCliente();
                      cnpj = t_jw_clientes_midias.getCnpj()==null?"":t_jw_clientes_midias.getCnpj();
                      inscricao_estadual = t_jw_clientes_midias.getInscricao_estadual()==null?"":t_jw_clientes_midias.getInscricao_estadual();
                      fone = t_jw_clientes_midias.getFone()==null?"":t_jw_clientes_midias.getFone();
                      endereco = t_jw_clientes_midias.getEndereco()==null?"":t_jw_clientes_midias.getEndereco();
                      ecl_cep = t_jw_clientes_midias.getEcl_cep()==null?"":t_jw_clientes_midias.getEcl_cep();
                      bairro_cidade_estado = t_jw_clientes_midias.getBairro_cidade_estado()==null?"":t_jw_clientes_midias.getBairro_cidade_estado();
                    } else {
                    }
                  }

                  //-----------------------
                  acesso.Usuario u = new acesso.Usuario();
                  u = (acesso.Usuario)session.getAttribute("User");
                  //----- randômico ------
                  Random rand = new Random();
                  String palavra = "";
                  for(int y=0;y<10;y++){
                    int num=0;
                    num=rand.nextInt(255);
                    if((num>=65 && num<=90)||(num>=97 && num<=122)){
                      palavra+=(char)num;
                    }else {
                      palavra+=num;
                    }
                  }
                  String arquivo= "mid"+palavra+((Integer)u.getId()).toString()+".xls";
                  //-----------------------
                  String file = parametros.retornaParametro("diretorio_pdf") + arquivo;
                  String report_link = parametros.retornaParametro("diretorio_link_pdf") + arquivo;
                  java.io.FileOutputStream fileOut = new java.io.FileOutputStream(file);
                  wb.write(fileOut);
                  fileOut.close();
                  session.removeAttribute("res_Jw_clientes_midias");
                  %>

                  <%
                  if((String)request.getAttribute("abre_automaticamente_xls")=="N"){
                    %>
                    <table style=width:100%;margin-top:10;>
                      <tr>
                        <td class=columHeader style="text-align:center;">
                          <a href="<%= report_link %>" target="_blank">
                            <bean:message key="report.downloadxls"/>
                          </a>
                        </td>
                      </tr>
                    </table>
                    <%
                  } else {
                    %>

                    <table style=width:100%;margin-top:10;>
                      <tr>
                        <td style="text-align:center;">
                          <script>
                            window.open('<%= report_link %>','_blank');
                          </script>
                        </td>
                      </tr>
                    </table>
                    <%
                  }
                  %>



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
