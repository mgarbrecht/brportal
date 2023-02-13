<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Listagem de Clientes
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
                </td>

              </tr>

            </table>

            <%
            String cidade= (String)request.getParameter("ecl_cdad")+"";
            String nome_fantasia = (String)request.getParameter("nome_fantasia")+"";
            String outro = cidade.replace("|","%");
            %>
            <table border=1 width="99%">
              <tr align="center" width="99%">
                <td align="left">

                  <font color="">
                    <b>
                      Cidade:
                    </b>
                  </font>
                  <font color="#C40000" size=1>
                    <b>
                      <%
                      if(((String)request.getParameter("ecl_cdad")+"").equals("null")) {
                        %>
                        Todas
                        <%
                      }else{
                        %>
                        <%= outro %>
                        <%
                      }
                      %>
                    </b>
                  </font>

                  <%
                  if((!(nome_fantasia.equals("null") || nome_fantasia.equals("")))) {
                    %>
                    <br>
                    <font color="">
                      <b>
                        Nome Fantasia:
                      </b>
                    </font>
                    <font color="#C40000" size=1>
                      <b>
                        <%= nome_fantasia.replace("|","%") %>
                      </b>
                    </font>
                    <%
                  }
                  %>


                  <%
                  if((!(((String)request.getParameter("representante")+"").equals("null")))){
                    %>
                    <font color="">
                      <br>
                      <b>
                        Representante:
                      </b>
                    </font>
                    <font color="#C40000" size=1>
                      <b>
                        <%
                        if(((String)request.getParameter("representante")+"").equals("")) {
                          %>
                          Todos
                          <%
                        }else{
                          %>
                          <%= (String)request.getParameter("representante") %>
                          <%
                        }
                        %>
                      </b>
                    </font>
                    <%
                  }
                  %>
                  <%
                  if((!(((String)request.getParameter("p1")+"").equals("null")))){
                    %>
                    <font color="">
                      <br>
                      <b>
                        Regional:
                      </b>
                    </font>
                    <font color="#C40000" size=1>
                      <b>
                        <%
                        if(((String)request.getParameter("p1")+"").equals("")) {
                          %>
                          Todas
                          <%
                        }else{
                          %>
                          <%= (String)request.getParameter("p1") %>
                          <%
                        }
                        %>
                      </b>
                    </font>
                    <%
                  }
                  %>
                  <font color="">
                    <br>
                    <b>
                      Grupo:
                    </b>
                  </font>
                  <font color="#C40000" size=1>
                    <b>
                      <%
                      if(((String)request.getParameter("grupo")+"").equals("")) {
                        %>
                        Todos
                        <%
                      }else{
                        %>
                        <%= (String)request.getParameter("grupo") %>
                        <%
                      }
                      %>
                    </b>
                  </font>

                </td>
              </tr>
            </table>
            <table id="TRbl_report_Jw_clientes" class="reportTable" style=width:99%;>
              <%
              int counterbl_report_Jw_clientes=0;
              portalbr.dbobj.view.Jw_clientes_fones t_jw_clientes_fones = new portalbr.dbobj.view.Jw_clientes_fones();
              portalbr.dbobj.view.Jw_clientes_contatos t_jw_clientes_contatos = new portalbr.dbobj.view.Jw_clientes_contatos();
              java.util.Vector res_Jw_clientes_fones = null;
              java.util.Vector res_Jw_clientes_contatos = null;
              java.lang.String fones = "";
              int ativos = 0;
              int inativos = 0;
              int total_clientes =0;
              java.lang.String contatos = "";

              portalbr.dbobj.view.Jw_clientes t_jw_clientes = new portalbr.dbobj.view.Jw_clientes();
              java.util.Vector res_Jw_clientes = (java.util.Vector)session.getAttribute("res_Jw_clientes");
              if (res_Jw_clientes!=null && res_Jw_clientes.size()>0) {
                java.lang.String codigo       =  null;
                java.lang.String cli_rzao     =  null;
                java.lang.String cli_nome     =  null;
                java.lang.String endereco     =  null;
                java.lang.String fone         =  null;
                java.lang.String uf           =  null;
                java.lang.String bairro       =  null;
                java.lang.String cnpj         =  null;
                java.lang.String inscr        =  null;
                java.lang.String cep          =  null;
                double credito                =  0;
                double pendencia              =  0;
                double saldo_disponivel       =  0;
                java.lang.String email        =  null;
                java.lang.String situacao     =  null;
                java.lang.String segmento     =  null;
                java.lang.String grupo        =  null;
                java.lang.String qt_contatos  =  null;
                java.lang.String qt_telefones =  null;
                java.lang.String classificacao = null;
                java.lang.String representantes = null;
                java.lang.String ecl_cxpo = null;
                java.lang.String ecl_zona = null;
                java.lang.Integer tra_consig = null;
                java.lang.String consignatario = null;
                java.lang.Integer tra_cdgo = null;
                java.lang.String tra_nome = null;
                java.lang.String data_ultima_compra = null;
                double valor_ultima_compra = 0;

                int i_bl_report_Jw_clientes = 0;

                t_jw_clientes = (portalbr.dbobj.view.Jw_clientes)res_Jw_clientes.elementAt(i_bl_report_Jw_clientes);
                codigo        = t_jw_clientes.getCodigo()==null?"":t_jw_clientes.getCodigo();
                cli_rzao      = t_jw_clientes.getCli_rzao()==null?"":t_jw_clientes.getCli_rzao();
                cli_nome      = t_jw_clientes.getCli_nome()==null?"":t_jw_clientes.getCli_nome();
                endereco      = t_jw_clientes.getEndereco()==null?"":t_jw_clientes.getEndereco();
                fone          = t_jw_clientes.getFone()==null?"":t_jw_clientes.getFone();
                uf            = t_jw_clientes.getUf()==null?"":t_jw_clientes.getUf();
                bairro        = t_jw_clientes.getBairro()==null?"":t_jw_clientes.getBairro();
                cnpj          = t_jw_clientes.getCnpj()==null?"":t_jw_clientes.getCnpj();
                inscr         = t_jw_clientes.getInscr()==null?"":t_jw_clientes.getInscr();
                cep           = t_jw_clientes.getCep()==null?"":t_jw_clientes.getCep();
                credito       = t_jw_clientes.getCredito();
                pendencia     = t_jw_clientes.getPendencia();
                saldo_disponivel = t_jw_clientes.getSaldo_disponivel();
                email         = t_jw_clientes.getEmail()==null?"":t_jw_clientes.getEmail();
                classificacao = t_jw_clientes.getClassificacao()==null?"":t_jw_clientes.getClassificacao();
                situacao      = t_jw_clientes.getSituacao()==null?"":t_jw_clientes.getSituacao();
                segmento      = t_jw_clientes.getSegmento()==null?"":t_jw_clientes.getSegmento();
                grupo         = t_jw_clientes.getGrupo()==null?"":t_jw_clientes.getGrupo();
                contatos      = t_jw_clientes.getContatos()==null?"":t_jw_clientes.getContatos();
                fones         = t_jw_clientes.getFones()==null?"":t_jw_clientes.getFones();
                qt_contatos   = t_jw_clientes.getQt_contatos();
                qt_telefones  = t_jw_clientes.getQt_telefones();
                representantes = t_jw_clientes.getRepresentantes();
                ecl_cxpo      = t_jw_clientes.getEcl_cxpo()==null?"":t_jw_clientes.getEcl_cxpo();
                ecl_zona      = t_jw_clientes.getEcl_zona()==null?"":t_jw_clientes.getEcl_zona();
                tra_consig    = t_jw_clientes.getTra_consig();
                consignatario = t_jw_clientes.getConsignatario()==null?"":t_jw_clientes.getConsignatario();
                tra_cdgo      = t_jw_clientes.getTra_cdgo();
                tra_nome      = t_jw_clientes.getTra_nome()==null?"":t_jw_clientes.getTra_nome();
                data_ultima_compra = t_jw_clientes.getData_ultima_compra()==null?"":t_jw_clientes.getData_ultima_compra();
                valor_ultima_compra = t_jw_clientes.getValor_ultima_compra();
              if(situacao.equals("Ativo")){ ativos+=1;} else{ inativos +=1;}
              total_clientes+=1;
              %>
              <tr class="reportHeader" >
                <td class="columnTdHeader" style="text-align:left;">
                  Código
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Razão Social
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Nome
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  CNPJ
                </td>
              </tr>
              <tr>
                <td>
                </td>
              </tr>
              <tr class="reportHeader" >
                <td class="columnTdHeader" style="text-align:left;" >
                  Endereço
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Cidade - UF
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Bairro
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  CEP
                </td>
              </tr>
              <tr>
                <td>
                </td>
              </tr>
              <tr class="reportHeader" border=1; >
                <td class="columnTdHeader" style="text-align:left;">
                  Insc. Est.
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Situação
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Segmento
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Grupo
                </td>
              </tr>
              <tr>
                <td>
                </td>
              </tr>
              <tr class="reportHeader">
                <td class="columnTdHeader" style="text-align:left;">
                  Limite Crédito R$
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Pendência
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Saldo Disponível
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Contatos
                </td>
              </tr>
              <tr>
                <td>
                </td>
              </tr>
              <tr class="reportHeader">
                <td class="columnTdHeader" style="text-align:left;">
                  Classificação
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Cx. Postal
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Zona
                </td>
                <td class="columnTdHeader" style="text-align:left;">
                  Consig.
                </td>
              </tr>
              <tr>
                <td>
                </td>
              </tr>



              <tr class="reportHeader">
                <td class="columnTdHeader" style="text-align:left;">
                  Transportadora
                </td>

                <td class="columnTdHeader" style="text-align:left;">
                  E-Mail
                </td>

                <td class="columnTdHeader" style="text-align:left;">
                  Fone
                </td>

                <td class="columnTdHeader" style="text-align:left;">
                  Data Última Compra
                </td>
              </tr>

              <tr>
                <td>
                </td>
              </tr>

              <tr class="reportHeader">
                <td class="columnTdHeader" style="text-align:left;" colspan="4">
                  Valor Última Compra
                </td>
              </tr>

              <tr>
                <td colspan="100%" style=border-color:gray;border-top-style:solid;border-top-width:3;padding-top:5;font-size:11px;>
                </td>
              </tr>
              <%
              while (i_bl_report_Jw_clientes<res_Jw_clientes.size()){
                counterbl_report_Jw_clientes++;
                String style="";
                if (!((i_bl_report_Jw_clientes%2)!=0)) {
                  style="class=rowColor";
                } else {
                  style="class=rowBlank";
                }
                %>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= codigo %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= cli_rzao %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= cli_nome %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= cnpj %>
                  </td>
                </tr>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= endereco %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= uf %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= bairro %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= cep %>
                  </td>
                </tr>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= inscr %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= situacao %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= segmento %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= grupo %>
                  </td>
                </tr>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' valign="top">
                  <td class="reportColumn" style="text-align:left;">
                    R$
                    <%= com.egen.util.text.FormatNumber.format(credito, "##,##0.00") %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%
                    if(pendencia>0) {
                      %>
                      R$
                      <%= com.egen.util.text.FormatNumber.format(pendencia, "##,##0.00") %>
                      <%
                    }
                    %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    R$
                    <%= com.egen.util.text.FormatNumber.format(saldo_disponivel, "##,##0.00") %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= contatos %>
                  </td>
                </tr>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= classificacao %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= ecl_cxpo %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= ecl_zona %>
                  </td>
                  <td class="reportColumn" style="text-align:left;" >
                    <%
                    if(tra_consig != null) {
                      %>
                      <%= tra_consig %>
                      -
                      <%= consignatario %>
                      <%
                    }
                    %>
                  </td>
                </tr>
                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;">
                    <%= tra_cdgo %>
                    -
                    <%= tra_nome %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= email %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= fones %>
                  </td>
                  <td class="reportColumn" style="text-align:left;">
                    <%= data_ultima_compra %>
                  </td>
                </tr>

                <tr <%= style %> id='TRbl_report_Jw_clientes<%=counterbl_report_Jw_clientes%>' >
                  <td class="reportColumn" style="text-align:left;" colspan="4">
                    R$
                    <%= com.egen.util.text.FormatNumber.format(valor_ultima_compra, "##,##0.00") %>
                  </td>
                </tr>

                <tr>
                  <td colspan="100%" style=border-color:black;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;>
                  </td>
                </tr>
                <%
                if(((String)session.getAttribute("mostrar_representantes")).equals("s")){
                  %>
                  <tr class="reportHeader2">
                    <td class="columnTdHeader" style="text-align:left;" colspan=4>
                      Representantes
                    </td>
                  </tr>
                  <td>
                    <%= representantes %>
                  </td>
                </tr>
                <tr>
                  <td colspan="100%" style=border-color:black;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;>
                  </td>
                </tr>
                <%
              }
              %>
              <tr>
                <td>
                </td>
              </tr>
              <%
              if (++i_bl_report_Jw_clientes >= res_Jw_clientes.size()) {
                break;
              }
              t_jw_clientes = (portalbr.dbobj.view.Jw_clientes)res_Jw_clientes.elementAt(i_bl_report_Jw_clientes);
              codigo        = t_jw_clientes.getCodigo()==null?"":t_jw_clientes.getCodigo();
              cli_rzao      = t_jw_clientes.getCli_rzao()==null?"":t_jw_clientes.getCli_rzao();
              cli_nome      = t_jw_clientes.getCli_nome()==null?"":t_jw_clientes.getCli_nome();
              endereco      = t_jw_clientes.getEndereco()==null?"":t_jw_clientes.getEndereco();
              fone          = t_jw_clientes.getFone()==null?"":t_jw_clientes.getFone();
              uf            = t_jw_clientes.getUf()==null?"":t_jw_clientes.getUf();
              bairro        = t_jw_clientes.getBairro()==null?"":t_jw_clientes.getBairro();
              cnpj          = t_jw_clientes.getCnpj()==null?"":t_jw_clientes.getCnpj();
              inscr         = t_jw_clientes.getInscr()==null?"":t_jw_clientes.getInscr();
              cep           = t_jw_clientes.getCep()==null?"":t_jw_clientes.getCep();
              credito       = t_jw_clientes.getCredito();
              pendencia     = t_jw_clientes.getPendencia();
              saldo_disponivel = t_jw_clientes.getSaldo_disponivel();
              email         = t_jw_clientes.getEmail()==null?"":t_jw_clientes.getEmail();
              classificacao = t_jw_clientes.getClassificacao()==null?"":t_jw_clientes.getClassificacao();
              situacao      = t_jw_clientes.getSituacao()==null?"":t_jw_clientes.getSituacao();
              segmento      = t_jw_clientes.getSegmento()==null?"":t_jw_clientes.getSegmento();
              grupo         = t_jw_clientes.getGrupo()==null?"":t_jw_clientes.getGrupo();
              contatos      = t_jw_clientes.getContatos()==null?"":t_jw_clientes.getContatos();
              fones         = t_jw_clientes.getFones()==null?"":t_jw_clientes.getFones();
              qt_contatos   = t_jw_clientes.getQt_contatos();
              qt_telefones  = t_jw_clientes.getQt_telefones();
              representantes = t_jw_clientes.getRepresentantes();
              ecl_cxpo      = t_jw_clientes.getEcl_cxpo()==null?"":t_jw_clientes.getEcl_cxpo();
              ecl_zona      = t_jw_clientes.getEcl_zona()==null?"":t_jw_clientes.getEcl_zona();
              tra_consig    = t_jw_clientes.getTra_consig();
              consignatario = t_jw_clientes.getConsignatario()==null?"":t_jw_clientes.getConsignatario();
              tra_cdgo      = t_jw_clientes.getTra_cdgo();
              tra_nome      = t_jw_clientes.getTra_nome()==null?"":t_jw_clientes.getTra_nome();
              data_ultima_compra = t_jw_clientes.getData_ultima_compra()==null?"":t_jw_clientes.getData_ultima_compra();
              valor_ultima_compra = t_jw_clientes.getValor_ultima_compra();
            if(situacao.equals("Ativo")){ativos+=1;}else{inativos +=1;}
            total_clientes+=1;
          }
        }
        %>
      </table>
      <table id="TRbl_report_Jw_clientes" class="reportTable" border =1; style=width:99%;>
        <tr class="reportHeader" >
          <td>
            Clientes Ativos :
            <%= ativos %>
          </td>
        </tr>
        <tr class="reportHeader" >
          <td>
            Clientes Inativos :
            <%= inativos %>
          </td>
        </tr>
        <tr class="reportHeader" >
          <td>
            Total de Clientes :
            <%= total_clientes %>
          </td>
        </tr>

      </table>
      <html:form action="adm/Clientes_rForm.do" method="post" styleClass="baseForm">
        <table class="messageTable" style='width:99%;'>
          <tr class="messageTr" >
            <td class="messageTd">
            </td>
          </tr>
        </table>

        <table class="itemTable"  style="width:99%;">
          <html:hidden property="ecl_cdad"/>
          <html:hidden property="representante"/>
          <html:hidden property="p1"/>
          <html:hidden property="grupo"/>
        </table>

        <table class="buttonTable" style='width:99%;'>
          <tr class="buttonTr">
            <td class="buttonTd">
              <html:button accesskey="b" onclick="history.go(-1);" styleClass="baseButton" property="back_action">
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
