<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Consulta de Duplicatas
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(83)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/Titulos_rForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="codigo"/>
                    <html:errors property="nome"/>
                    <html:errors property="bairro"/>
                    <html:errors property="cidade_uf"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>


              <%
              if(request.getAttribute("esconderCabecalho") == null) {
                %>

                <table class="itemTable"  style="width:99%;">
                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Código
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="codigo" styleClass="disabled" tabindex="-1" readonly="true"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Nome
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="nome" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Bairro
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="bairro" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>

                  <tr class="itemTr">
                    <td class="formLabel">
                      <span class="spamFormLabel">
                        Cidade-UF
                      </span>
                    </td>
                    <td class="formField">
                      <html:text property="cidade_uf" styleClass="disabled" tabindex="-1" readonly="true" size="60"/>
                    </td>
                  </tr>
                  <%
                } else {
                  %>
                  <html:hidden property="codigo"/>
                  <html:hidden property="nome"/>
                  <html:hidden property="bairro"/>
                  <html:hidden property="cidade_uf"/>
                  <%
                }
                %>

                <html:hidden property="emp_empresa"/>
              </table>

            </html:form>
            <%
            portalbr.adm.Titulos_rActionForm Titulos_rActionForm = (portalbr.adm.Titulos_rActionForm)session.getAttribute("Titulos_rActionForm");
            String cliente="";
            String tipo="";
            acesso.Usuario u = new acesso.Usuario();
            u = (acesso.Usuario)session.getAttribute("User");
            acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
            acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

            if(!(u.getEntidadeNegocio()==null)){
              ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
              tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
              tipo = tipoent.getTipo()+"";
              if(tipo.equals("CLIENTE MERCADO INTERNO")){
                cliente = "MI";
              }
            }
            %>

            <table id="TRbl_report_Jw_t_titulos_lista" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_t_titulos_lista=0;
              {
                portalbr.dbobj.view.Jw_t_titulos_lista t_jw_t_titulos_lista = new portalbr.dbobj.view.Jw_t_titulos_lista();
                java.util.Vector res_Jw_t_titulos_lista = (java.util.Vector)session.getAttribute("res_Jw_t_titulos_lista");
                if (res_Jw_t_titulos_lista!=null && res_Jw_t_titulos_lista.size()>0) {
                  java.lang.String link        =  null;
                  java.util.Date tit_datven3   =  null;
                  java.lang.String tit_codigo  =  null;
                  java.lang.String tit_numbco  =  null;
                  java.lang.String tit_status  =  null;
                  java.lang.String esc_cgc     =  null;//(String)session.getAttribute("cnpj_do_cliente");
                  java.lang.String rep_codigo  =  null;
                  java.lang.String ncc         =  null;
                  java.lang.String pedido      =  null;
                  java.lang.String existe      =  null;
                  java.lang.String nota        =  null;
                  java.lang.String serie       =  null;
                  java.lang.String desc_sit    =  null;
                  java.lang.String tip_codigo  =  null;
                  java.lang.String ped_nmro    =  null;
                  java.util.Date tit_datvenc   =  null;
                  java.util.Date tit_datrec    =  null;
                  java.util.Date tit_datemi    =  null;
                  java.util.Date data_atual    =  null;
                  double tit_dspont            =  0;
                  double tit_dsante            =  0;
                  double tit_vlrec             =  0;
                  double tit_valor             =  0;
                  java.lang.String emp_empresa =  null;
                  java.lang.String fil_filial  =  null;
                  double taxa_juro             =  0;
                  java.lang.String trn_codigo  =  null;
                  java.util.Date mov_data      =  null;
                  java.util.Date datvenc       =  null;
                  java.lang.String cobjur      =  null;
                  java.lang.String tit_abatim  =  null;
                  java.lang.String vnc_cartor  =  null;
                  java.lang.String dif         =  null;
                  java.lang.String condes      =  null;
                  java.lang.String prt_codigo  =  null;
                  java.lang.String prt_descri  =  null;
                  int i_bl_report_Jw_t_titulos_lista = 0;
                  java.lang.String w_liq       = null;
                  java.lang.String w_saldo_tot = null;
                  java.lang.String w_valor_tot = null;
                  java.lang.String vendor = null;
                  java.lang.String cnpj = null;
                  java.lang.String razaoSocialSacado = null;
                  java.lang.String cnpj_sem_formato = null;


                  t_jw_t_titulos_lista = (portalbr.dbobj.view.Jw_t_titulos_lista)res_Jw_t_titulos_lista.elementAt(i_bl_report_Jw_t_titulos_lista);
                  tit_datven3 = (java.util.Date)t_jw_t_titulos_lista.getTit_datven3();
                  tit_codigo  = t_jw_t_titulos_lista.getTit_codigo()==null?"":t_jw_t_titulos_lista.getTit_codigo();
                  tit_numbco  = t_jw_t_titulos_lista.getTit_numbco()==null?"":t_jw_t_titulos_lista.getTit_numbco();
                  tit_status  = t_jw_t_titulos_lista.getTit_status()==null?"":t_jw_t_titulos_lista.getTit_status();
                  ncc         = t_jw_t_titulos_lista.getNcc()==null?"":t_jw_t_titulos_lista.getNcc();
                  nota        = t_jw_t_titulos_lista.getNota()==null?"":t_jw_t_titulos_lista.getNota();
                  serie       = t_jw_t_titulos_lista.getSerie()==null?"":t_jw_t_titulos_lista.getSerie();
                  desc_sit    = t_jw_t_titulos_lista.getDesc_sit()==null?"":t_jw_t_titulos_lista.getDesc_sit();
                  tip_codigo  = t_jw_t_titulos_lista.getTip_codigo()==null?"":t_jw_t_titulos_lista.getTip_codigo();
                  rep_codigo  = t_jw_t_titulos_lista.getRep_codigo()==null?"":t_jw_t_titulos_lista.getRep_codigo();
                  ped_nmro    = t_jw_t_titulos_lista.getPed_nmro()==null?"":t_jw_t_titulos_lista.getPed_nmro();
                  pedido      = t_jw_t_titulos_lista.getPedido()==null?"":t_jw_t_titulos_lista.getPedido();
                  tit_datvenc = (java.util.Date)t_jw_t_titulos_lista.getTit_datvenc();
                  tit_datrec  = (java.util.Date)t_jw_t_titulos_lista.getTit_datrec();
                  data_atual  = (java.util.Date)t_jw_t_titulos_lista.getData_atual();
                  tit_datemi  = (java.util.Date)t_jw_t_titulos_lista.getTit_datemi();
                  tit_dspont  = t_jw_t_titulos_lista.getTit_dspont();
                  tit_dsante  = t_jw_t_titulos_lista.getTit_dsante();
                  tit_vlrec   = t_jw_t_titulos_lista.getTit_vlrec();
                  tit_valor   = t_jw_t_titulos_lista.getTit_valor();
                  w_liq       = t_jw_t_titulos_lista.getW_liq();
                  w_saldo_tot = t_jw_t_titulos_lista.getW_saldo_tot();
                  w_valor_tot = t_jw_t_titulos_lista.getW_valor_tot();
                  emp_empresa = t_jw_t_titulos_lista.getEmp_empresa()==null?"":t_jw_t_titulos_lista.getEmp_empresa();
                  fil_filial  = t_jw_t_titulos_lista.getFil_filial()==null?"":t_jw_t_titulos_lista.getFil_filial();
                  taxa_juro   = t_jw_t_titulos_lista.getTaxa_juro();
                  trn_codigo  = t_jw_t_titulos_lista.getTrn_codigo()==null?"":t_jw_t_titulos_lista.getTrn_codigo();
                  mov_data    = (java.util.Date)t_jw_t_titulos_lista.getMov_data();
                  datvenc     = (java.util.Date)t_jw_t_titulos_lista.getDatvenc();
                  cobjur      = t_jw_t_titulos_lista.getCobjur()==null?"":t_jw_t_titulos_lista.getCobjur();
                  tit_abatim  = t_jw_t_titulos_lista.getTit_abatim()==null?"":t_jw_t_titulos_lista.getTit_abatim();
                  vnc_cartor  = t_jw_t_titulos_lista.getVnc_cartor()==null?"":t_jw_t_titulos_lista.getVnc_cartor();
                  dif         = t_jw_t_titulos_lista.getDif()==null?"":t_jw_t_titulos_lista.getDif();
                  condes      = t_jw_t_titulos_lista.getCondes()==null?"":t_jw_t_titulos_lista.getCondes();
                  prt_codigo  = t_jw_t_titulos_lista.getPrt_codigo()==null?"":t_jw_t_titulos_lista.getPrt_codigo();
                  prt_descri  = t_jw_t_titulos_lista.getPrt_descri()==null?"":t_jw_t_titulos_lista.getPrt_descri();
                  vendor      = t_jw_t_titulos_lista.getVendor()==null?"":t_jw_t_titulos_lista.getVendor();
                  cnpj        = t_jw_t_titulos_lista.getCnpj()==null?"":t_jw_t_titulos_lista.getCnpj();
                  razaoSocialSacado = t_jw_t_titulos_lista.getCli_rzao()==null?"":t_jw_t_titulos_lista.getCli_rzao();
                  cnpj_sem_formato = t_jw_t_titulos_lista.getCnpj_sem_formato()==null?"":t_jw_t_titulos_lista.getCnpj_sem_formato();
                if(tit_vlrec==0){tit_vlrec=tit_valor;}
              if(pedido.equals("0")){ existe = "0";}else{ existe="1";}

              if(prt_codigo.equals("237")){ // BANCO BRADESCO S.A.
              if(vendor.equals("N")){
                tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
              }
              if(emp_empresa.equals("01")){
                link = "https://www.ne.bradesco.com.br/NESegundaViaBoletoInstitucional/CPFCNPJNossoNumero.do?&cpfCnpjSacado="+cnpj_sem_formato+"&cpfCnpjCedente=88379771000182&nossoNumero="+tit_numbco;
              } else {
                link = "https://www.ne.bradesco.com.br/NESegundaViaBoletoInstitucional/CPFCNPJNossoNumero.do?&cpfCnpjSacado="+cnpj_sem_formato+"&cpfCnpjCedente=00153470000195&nossoNumero="+tit_numbco;
              }
              } else if(prt_codigo.equals("001")){ // BANCO DO BRASIL S/A
              tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
              link = "http://www21.bb.com.br/portalbb/boletoCobranca/HC21,2,10343.bbx";
              } else if(prt_codigo.equals("041")){ // BANRISUL
              //         tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
              link = "https://www.banrisul.com.br/bbl/link/bblp44phw.asp?CodCedente=0290047883022&Valor=&SeuNumero=&DiaVcto=&MesVcto=&AnoVcto=&NomeSacado=&Endereco=&Cidade=&UF=&CEP=&Instrucoes=&SegundaVia=1&NossoNumero="+tit_numbco+"&Matricula=";
              } else if(prt_codigo.equals("033")){ // BANCO SANTANDER SA
              //         tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
              tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length());
              link = "http://www.santander.com.br/portal/gsb/script/templates/GCMRequest.do?page=2048&entryID=472";
            } else {
              tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
              link = "";
            }
            %>
            <tr class="reportHeader" >
              <td class="columnTdHeader" style="text-align:center;">
                Título
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Empresa
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Cedente
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Sacado
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Razão Social Cliente
              </td>
              <%
              if((!(cliente.equals("MI")))) {
                %>
                <td class="columnTdHeader" style="text-align:center;">
                  Status
                </td>
                <td class="columnTdHeader" style="text-align:center;">
                  NCC
                </td>
                <%
              }
              %>
              <td class="columnTdHeader" style="text-align:center;">
                N.F.
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Situação
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Tipo
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Vencto.
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Nr. do Banco
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Liquid.
              </td>
              <td class="columnTdHeader" style="text-align:right;">
                Saldo
              </td>
              <td class="columnTdHeader" style="text-align:right;">
                Valor
              </td>
              <td class="columnTdHeader" style="text-align:center;">
                Portador
              </td>
            </tr>
            <%
            while (i_bl_report_Jw_t_titulos_lista<res_Jw_t_titulos_lista.size()){
              counterbl_report_Jw_t_titulos_lista++;
              String style="";
              if (!((i_bl_report_Jw_t_titulos_lista%2)!=0)) {
                style="rowColor";
              } else {
                style="rowBlank";
              }
              Date d1 = com.egen.util.text.FormatDate.parse(com.egen.util.text.FormatDate.format(tit_datvenc, "dd/MM/yyyy"));
              Date d2 = com.egen.util.text.FormatDate.parse(com.egen.util.text.FormatDate.format(data_atual, "dd/MM/yyyy"));
              %>
              <tr class=<%= style %> id='TRbl_report_Jw_t_titulos_lista<%=counterbl_report_Jw_t_titulos_lista%>'  >
                <td class="reportColumn" style="text-align:center;" title="Consulta Duplicata: <%= tit_codigo %>">
                  <%
                  if(false){
                    //  if((tit_status.equals("Aberto")) && (d2.after(d1))){
                      %>
                      <a href="#" onclick="wopen('../adm/Titulos_nForm.do?titulo=<%= tit_codigo %>','_blank',640,300)" STYLE="cursor:hand">
                        <font color="green">
                          <b>
                            |Abrir Negociação|
                            <b>
                            </font>
                          </a>
                          <%
                        }
                        %>
                        <%
                        if((!(request.getParameter("excel")+"").equals("true"))&&(!(cliente.equals("MI"))) ){
                          %>
                          <a href="../com/ConsultaDuplicataForm.do?select_action=&titulo=<%= tit_codigo %>&nf=<%= nota %>&serie=<%= serie %>&rep=<%= rep_codigo %>&duplicata=<%= tit_codigo %>&cliente=<%= Titulos_rActionForm.getCodigo()%>-<%= Titulos_rActionForm.getNome() %>&pedido=<%= ped_nmro %>&existe=<%= existe %>&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&tip=<%= tip_codigo %>" target="_self" STYLE="cursor:hand">
                            <%= tit_codigo %>
                          </a>
                          <%
                        } else {
                          %>
                          <%= tit_codigo %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= emp_empresa %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%
                        if(emp_empresa.equals("01")){
                          %>
                          88.379.771/0001-82
                          <%
                        } else {
                          %>
                          00.153.470/0001-95
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= cnpj  %>
                      </td>

                      <td class="reportColumn" style="text-align:center;">
                        <%= razaoSocialSacado %>
                      </td>

                      <%
                      if((!(cliente.equals("MI")))) {
                        %>
                        <td class="reportColumn" style="text-align:center;">
                          <%= tit_status %>
                        </td>
                        <td class="reportColumn" style="text-align:center;">
                          <%= ncc %>
                        </td>
                        <%
                      }
                      %>
                      <td class="reportColumn" style="text-align:center;" title="Consulta Nota Fiscal: <%= nota %>-<%= serie %>">
                        <%
                        if(nota!="") {
                          %>
                          <%
                          if((!(request.getParameter("excel")+"").equals("true"))){
                            %>
                            <a href="../com/NotaFiscalForm.do?select_action=&emp_empresa=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&nf_nmro=<%= nota %>&nf_serie=<%= serie %>" target="_self" STYLE="cursor:hand">
                              <%= nota %>
                              -
                              <%= serie %>
                            </a>
                            <%
                          } else {
                            %>
                            <%= nota %>
                            -
                            <%= serie %>
                            <%
                          }
                          %>
                          <%
                        }
                        %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= desc_sit %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= tip_codigo %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%= com.egen.util.text.FormatDate.format(tit_datvenc, "dd/MM/yyyy") %>
                      </td>
                      <td class="reportColumn" style="text-align:center;">
                        <%
                        if(!tit_numbco.equals("")){
                          %>
                          <%
                          if(link.equals("")){
                            %>
                            <%= tit_numbco %>
                            <%
                          } else {
                            %>

                            <%
                            //if(!tipo.equals("REPRESENTANTE COMERCIAL") && !tipo.equals("REPRESENTANTE EXPORTACAO")){
                              if(prt_codigo.equals("041")){
                                %>
                                <a href="<%= link %>" target="_blank" onclick="jQuery.post('Titulos_rForm.do?insert_action=&emp_empresa1=<%= emp_empresa %>&fil_filial=<%= fil_filial %>&tip_codigo=<%= tip_codigo %>&tit_codigo=<%= tit_codigo %>&valor=<%= tit_valor %>&prt_codigo=<%= prt_codigo %>&tit_datvenc=<%= com.egen.util.text.FormatDate.format(tit_datvenc, "dd/MM/yyyy") %>');">
                                  <%= tit_numbco %>
                                </a>
                                <%
                              } else {
                                %>
                                <%= tit_numbco %>
                                <%
                              }
                              %>
                              <%
                            }
                            %>
                            <%
                          }
                          %>
                        </td>
                        <td class="reportColumn" style="text-align:center;">
                          <%= com.egen.util.text.FormatDate.format(tit_datrec, "dd/MM/yyyy") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;">
                          <%= com.egen.util.text.FormatNumber.format(tit_vlrec, "##,##0.00") %>
                        </td>
                        <td class="reportColumn" style="text-align:right;">
                          <%= com.egen.util.text.FormatNumber.format(tit_valor, "##,##0.00") %>
                        </td>
                        <td class="reportColumn" style="text-align:center;">
                          <%= prt_descri %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_t_titulos_lista >= res_Jw_t_titulos_lista.size()) {
                        break;
                      }
                      t_jw_t_titulos_lista = (portalbr.dbobj.view.Jw_t_titulos_lista)res_Jw_t_titulos_lista.elementAt(i_bl_report_Jw_t_titulos_lista);
                      tit_datven3 = (java.util.Date)t_jw_t_titulos_lista.getTit_datven3();
                      tit_codigo  = t_jw_t_titulos_lista.getTit_codigo()==null?"":t_jw_t_titulos_lista.getTit_codigo();
                      tit_numbco  = t_jw_t_titulos_lista.getTit_numbco()==null?"":t_jw_t_titulos_lista.getTit_numbco();
                      tit_status  = t_jw_t_titulos_lista.getTit_status()==null?"":t_jw_t_titulos_lista.getTit_status();
                      ncc         = t_jw_t_titulos_lista.getNcc()==null?"":t_jw_t_titulos_lista.getNcc();
                      nota        = t_jw_t_titulos_lista.getNota()==null?"":t_jw_t_titulos_lista.getNota();
                      serie       = t_jw_t_titulos_lista.getSerie()==null?"":t_jw_t_titulos_lista.getSerie();
                      desc_sit    = t_jw_t_titulos_lista.getDesc_sit()==null?"":t_jw_t_titulos_lista.getDesc_sit();
                      tip_codigo  = t_jw_t_titulos_lista.getTip_codigo()==null?"":t_jw_t_titulos_lista.getTip_codigo();
                      rep_codigo  = t_jw_t_titulos_lista.getRep_codigo()==null?"":t_jw_t_titulos_lista.getRep_codigo();
                      pedido      = t_jw_t_titulos_lista.getPedido()==null?"":t_jw_t_titulos_lista.getPedido();
                      tit_datvenc = (java.util.Date)t_jw_t_titulos_lista.getTit_datvenc();
                      tit_datrec  = (java.util.Date)t_jw_t_titulos_lista.getTit_datrec();
                      tit_datemi  = (java.util.Date)t_jw_t_titulos_lista.getTit_datemi();
                      data_atual  = (java.util.Date)t_jw_t_titulos_lista.getData_atual();
                      tit_dspont  = t_jw_t_titulos_lista.getTit_dspont();
                      tit_dsante  = t_jw_t_titulos_lista.getTit_dsante();
                      tit_vlrec   = t_jw_t_titulos_lista.getTit_vlrec();
                      tit_valor   = t_jw_t_titulos_lista.getTit_valor();
                      emp_empresa = t_jw_t_titulos_lista.getEmp_empresa()==null?"":t_jw_t_titulos_lista.getEmp_empresa();
                      ped_nmro    = t_jw_t_titulos_lista.getPed_nmro()==null?"":t_jw_t_titulos_lista.getPed_nmro();
                      fil_filial  = t_jw_t_titulos_lista.getFil_filial()==null?"":t_jw_t_titulos_lista.getFil_filial();
                      taxa_juro   = t_jw_t_titulos_lista.getTaxa_juro();
                      trn_codigo  = t_jw_t_titulos_lista.getTrn_codigo()==null?"":t_jw_t_titulos_lista.getTrn_codigo();
                      mov_data    = (java.util.Date)t_jw_t_titulos_lista.getMov_data();
                      datvenc     = (java.util.Date)t_jw_t_titulos_lista.getDatvenc();
                      cobjur      = t_jw_t_titulos_lista.getCobjur()==null?"":t_jw_t_titulos_lista.getCobjur();
                      tit_abatim  = t_jw_t_titulos_lista.getTit_abatim()==null?"":t_jw_t_titulos_lista.getTit_abatim();
                      vnc_cartor  = t_jw_t_titulos_lista.getVnc_cartor()==null?"":t_jw_t_titulos_lista.getVnc_cartor();
                      dif         = t_jw_t_titulos_lista.getDif()==null?"":t_jw_t_titulos_lista.getDif();
                      condes      = t_jw_t_titulos_lista.getCondes()==null?"":t_jw_t_titulos_lista.getCondes();
                      prt_codigo  = t_jw_t_titulos_lista.getPrt_codigo()==null?"":t_jw_t_titulos_lista.getPrt_codigo();
                      prt_descri  = t_jw_t_titulos_lista.getPrt_descri()==null?"":t_jw_t_titulos_lista.getPrt_descri();
                      vendor      = t_jw_t_titulos_lista.getVendor()==null?"":t_jw_t_titulos_lista.getVendor();
                      cnpj        = t_jw_t_titulos_lista.getCnpj()==null?"":t_jw_t_titulos_lista.getCnpj();
                      razaoSocialSacado = t_jw_t_titulos_lista.getCli_rzao()==null?"":t_jw_t_titulos_lista.getCli_rzao();
                      cnpj_sem_formato = t_jw_t_titulos_lista.getCnpj_sem_formato()==null?"":t_jw_t_titulos_lista.getCnpj_sem_formato();
                    if(tit_vlrec==0){tit_vlrec=tit_valor;}
                    if(pedido.equals("0")){
                      existe = "0";
                    } else {
                      existe="1";
                    }

                    if(prt_codigo.equals("237")){ // BANCO BRADESCO S.A.
                    if(vendor.equals("N")){
                      tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
                    }
                    if(emp_empresa.equals("01")){
                      link = "https://www.ne.bradesco.com.br/NESegundaViaBoletoInstitucional/CPFCNPJNossoNumero.do?&cpfCnpjSacado="+cnpj_sem_formato+"&cpfCnpjCedente=88379771000182&nossoNumero="+tit_numbco;
                    } else {
                      link = "https://www.ne.bradesco.com.br/NESegundaViaBoletoInstitucional/CPFCNPJNossoNumero.do?&cpfCnpjSacado="+cnpj_sem_formato+"&cpfCnpjCedente=00153470000195&nossoNumero="+tit_numbco;
                    }
                    } else if(prt_codigo.equals("001")){ // BANCO DO BRASIL S/A
                    tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
                    link = "http://www21.bb.com.br/portalbb/boletoCobranca/HC21,2,10343.bbx";
                    } else if(prt_codigo.equals("041")){ // BANRISUL
                    link = "https://www.banrisul.com.br/bbl/link/bblp44phw.asp?CodCedente=0290047883022&Valor=&SeuNumero=&DiaVcto=&MesVcto=&AnoVcto=&NomeSacado=&Endereco=&Cidade=&UF=&CEP=&Instrucoes=&SegundaVia=1&NossoNumero="+tit_numbco+"&Matricula=";
                    } else if(prt_codigo.equals("033")){ // BANCO SANTANDER SA
                    tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length());
                    link = "http://www.santander.com.br/portal/gsb/script/templates/GCMRequest.do?page=2048&entryID=472";
                  } else {
                    tit_numbco = tit_numbco.substring(0,tit_numbco.equals("")?0:tit_numbco.length()-1);
                    link = "";
                  }

                }
                %>
                <table id="TRbl_report_Jw_consulta_titulos_registros" class="reportTable" style=width:99%; border=0 frame=box>
                  <tr>
                    <td align="right" width="85%">
                      <big>
                        <b>
                          Total Pago :
                        </b>
                      </big>
                    </td>
                    <td align="right">
                      <big>
                        <%= w_liq %>
                      </big>
                    </td>
                  </tr>
                  <tr>
                    <td align="right" width="85%">
                      <big>
                        <b>
                          Total Saldo a Pagar :
                        </b>
                      </big>
                    </td>
                    <td align="right">
                      <big>
                        <%= w_saldo_tot %>
                      </big>
                    </td>
                  </tr>
                  <tr>
                    <td align="right" width="85%">
                      <big>
                        <b>
                          Total Valor Original :
                        </b>
                      </big>
                    </td>
                    <td align="right">
                      <big>
                        <%= w_valor_tot %>
                      </big>
                    </td>
                  </tr>
                </table>
                <%
              }
            }
            %>
          </table>
          <html:form action="adm/Titulos_rForm.do" method="post" styleClass="baseForm">
            <table class="messageTable" style='width:99%;'>
              <tr class="messageTr" >
                <td class="messageTd">
                  <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_titulos_registros"/>
                </td>
              </tr>
            </table>

            <table class="itemTable"  style="width:99%;">
              <html:hidden property="esc_seqn"/>
              <html:hidden property="situacao"/>
              <html:hidden property="dt_venc"/>
              <html:hidden property="cli_cdgo"/>
              <html:hidden property="w_liq"/>
              <html:hidden property="w_saldo_tot"/>
              <html:hidden property="w_valor_tot"/>
              <html:hidden property="emp_empresa1"/>
              <html:hidden property="fil_filial"/>
              <html:hidden property="tip_codigo"/>
              <html:hidden property="tit_codigo"/>
              <html:hidden property="valor"/>
              <html:hidden property="prt_codigo"/>
              <html:hidden property="tit_datvenc"/>
            </table>

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
                    <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
                      <bean:message bundle="ApplicationResources" key="jsp.back"/>
                    </html:button>
                    <%
                  }
                  %>
                  <html:submit accesskey="i" styleClass="myhidden" property="insert_action">
                    <bean:message bundle="ApplicationResources" key="jsp.insert"/>
                  </html:submit>
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
