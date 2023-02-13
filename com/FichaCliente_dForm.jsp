<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <bean:message key="page.dwrscripts"/>
  <script type="text/javascript" src="../dwr/interface/FichaCliente_dActionForm.js">
  </script>
  <script type="text/javascript">
    var ActionFormClass = FichaCliente_dActionForm;
    var hashMapLabel = new HashMap();
    hashMapLabel.set("cli_cdgo","cli_cdgo");
    hashMapLabel.set("esc_seqn","Esc_seqn");
    hashMapLabel.set("gre_grupo","gre_grupo");
    hashMapLabel.set("valor_utilizado","Valor Utilizado");
    hashMapLabel.set("valor_disponivel","Valor Disponível");
    var reportColumns = new Array(new Array("cliente_desde","ultima_compra","codigo_regional","nome_regional","codigo_representante","rep_rzao","rep_nome"),new Array("nome","email","tipo","data_nascimento"),new Array("data_informacao","usuario","informacoes"),new Array("marca","pares","valor"),new Array("codigo_marca","descricao_marca","imagem1","linha1","pares3","valor3"),new Array("linha2","pares4","valor4","imagem2"),new Array("imagem","linha","pares2","valor2"),new Array("ordem","data_cad","nfs_nmro","pares5","valor5"));
  </script>
  <bean:message key="page.ajaxscript"/>
  <head>
    <title>
      Ficha do Cliente
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(5)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            {
              java.util.Vector res_Jw_representantes_clientes_ficha_cliente = (java.util.Vector)session.getAttribute("res_Jw_representantes_clientes_ficha_cliente");
              %>

              <form  name="bl_report_Jw_representantes_clientes_ficha_cliente" id="bl_report_Jw_representantes_clientes_ficha_cliente" class="baseForm" method="post" >
                <%
                if (res_Jw_representantes_clientes_ficha_cliente!=null && res_Jw_representantes_clientes_ficha_cliente.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_representantes_clientes_ficha_cliente"  class="reportTable"   style="width:99%;" border="1" >
                    <%
                    java.lang.String cliente_desde =  null;
                    java.lang.String ultima_compra =  null;
                    java.lang.Integer codigo_regional =  null;
                    java.lang.String nome_regional =  null;
                    java.lang.String codigo_representante =  null;
                    java.lang.String rep_rzao =  null;
                    java.lang.String rep_nome =  null;
                    java.lang.String email_cliente =  null;
                    java.lang.String fone_cliente =  null;
                    java.lang.String gre_grupo =  null;
                    java.lang.String gre_descricao =  null;
                    java.lang.String codigo_cliente = null;
                    java.lang.String cli_rzao = null;
                    java.lang.String cli_nome = null;
                    java.lang.String esc_seqn = null;
                    java.lang.String marcas_representante = null;

                    String _b0_control = "__";
                    String _b1_control = "__";
                    int i_bl_report_Jw_representantes_clientes_ficha_cliente = 0;
                    while (i_bl_report_Jw_representantes_clientes_ficha_cliente<res_Jw_representantes_clientes_ficha_cliente.size()) {
                      portalbr.dbobj.view.Jw_representantes_clientes_ficha_cliente t_jw_representantes_clientes_ficha_cliente = (portalbr.dbobj.view.Jw_representantes_clientes_ficha_cliente)res_Jw_representantes_clientes_ficha_cliente.elementAt(i_bl_report_Jw_representantes_clientes_ficha_cliente);
                      cliente_desde = t_jw_representantes_clientes_ficha_cliente.getCliente_desde()==null?"":t_jw_representantes_clientes_ficha_cliente.getCliente_desde();
                      ultima_compra = t_jw_representantes_clientes_ficha_cliente.getUltima_compra()==null?"":t_jw_representantes_clientes_ficha_cliente.getUltima_compra();
                      codigo_regional = t_jw_representantes_clientes_ficha_cliente.getCodigo_regional();
                      nome_regional = t_jw_representantes_clientes_ficha_cliente.getNome_regional()==null?"":t_jw_representantes_clientes_ficha_cliente.getNome_regional();
                      codigo_representante = t_jw_representantes_clientes_ficha_cliente.getCodigo_representante()==null?"":t_jw_representantes_clientes_ficha_cliente.getCodigo_representante();
                      rep_rzao = t_jw_representantes_clientes_ficha_cliente.getRep_rzao()==null?"":t_jw_representantes_clientes_ficha_cliente.getRep_rzao();
                      rep_nome = t_jw_representantes_clientes_ficha_cliente.getRep_nome()==null?"":t_jw_representantes_clientes_ficha_cliente.getRep_nome();

                      email_cliente = t_jw_representantes_clientes_ficha_cliente.getEmail_cliente();
                      fone_cliente = t_jw_representantes_clientes_ficha_cliente.getFone_cliente();
                      gre_grupo = t_jw_representantes_clientes_ficha_cliente.getGre_grupo();
                      gre_descricao = t_jw_representantes_clientes_ficha_cliente.getGre_descricao();
                      codigo_cliente = t_jw_representantes_clientes_ficha_cliente.getCodigo_cliente();
                      cli_rzao = t_jw_representantes_clientes_ficha_cliente.getCli_rzao();
                      cli_nome = t_jw_representantes_clientes_ficha_cliente.getCli_nome();
                      esc_seqn = t_jw_representantes_clientes_ficha_cliente.getEsc_seqn();
                      marcas_representante = t_jw_representantes_clientes_ficha_cliente.getMarcas_representante();

                      String _b0_value = (cliente_desde==null?"":cliente_desde);
                      if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="3">
                            <span style="text-align:right;" >

                              <%
                              if(session.getAttribute("cli_cdgo")!=null){
                                %>
                                Cliente:
                                <%= codigo_cliente %>
                                -
                                <%= esc_seqn %>
                                -
                                <%= cli_rzao %>
                                <br>
                                Email:
                                <%= email_cliente %>
                                <br>
                                Fone:
                                <%= fone_cliente %>
                                <br>
                                Cliente cadastrado desde:
                                <%= cliente_desde %>
                                <%
                              } else {
                                %>
                                Grupo:
                                <%= gre_grupo %>
                                -
                                <%= gre_descricao %>
                                <br>
                                Grupo desde:
                                <%= cliente_desde %>

                                <%
                              }
                              %>



                              <br>
                              Último Faturamento:
                              <%= ultima_compra %>
                            </span>
                          </td>
                        </tr>
                        <%
                      }
                      String _b1_value = (cliente_desde==null?"":cliente_desde) + "_" + com.egen.util.text.FormatNumber.format(codigo_regional);
                      if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                        %>
                        <tr class="reportHeader2">
                          <td colspan="3">
                            <span style="text-align:right;" >
                              Regional:
                              <%= ((codigo_regional!=null)?codigo_regional.toString():"") %>
                              -
                              <%= nome_regional %>
                            </span>
                          </td>
                        </tr>
                        <%
                        %>

                        <tr class="reportTr">
                          <td class="columnTdHeader" style="text-align:left;" >
                            Empresa de Representação Comercial
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Nome
                          </td>

                          <td class="columnTdHeader" style="text-align:left;" >
                            Marcas
                          </td>

                        </tr>

                        <%
                      }
                      String style_bl_report_Jw_representantes_clientes_ficha_cliente="";
                      if (!((i_bl_report_Jw_representantes_clientes_ficha_cliente%2)!=0)) {
                        style_bl_report_Jw_representantes_clientes_ficha_cliente="rowColor";
                      } else {
                        style_bl_report_Jw_representantes_clientes_ficha_cliente="rowBlank";
                      }
                      %>

                      <tr class='<%= style_bl_report_Jw_representantes_clientes_ficha_cliente %>' id="TRbl_report_Jw_representantes_clientes_ficha_cliente<%=i_bl_report_Jw_representantes_clientes_ficha_cliente%>" >
                        <td class="reportColumn" style="text-align:left;" >
                          <%= codigo_representante %>
                          -
                          <%= rep_rzao %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= rep_nome %>
                        </td>

                        <td class="reportColumn" style="text-align:left;" >
                          <%= marcas_representante %>
                        </td>

                      </tr>

                      <%
                      _b0_control = _b0_value;
                      _b1_control = _b1_value;
                      i_bl_report_Jw_representantes_clientes_ficha_cliente++;
                      if (i_bl_report_Jw_representantes_clientes_ficha_cliente<res_Jw_representantes_clientes_ficha_cliente.size()) {
                        t_jw_representantes_clientes_ficha_cliente = (portalbr.dbobj.view.Jw_representantes_clientes_ficha_cliente)res_Jw_representantes_clientes_ficha_cliente.elementAt(i_bl_report_Jw_representantes_clientes_ficha_cliente);
                        cliente_desde = t_jw_representantes_clientes_ficha_cliente.getCliente_desde()==null?"":t_jw_representantes_clientes_ficha_cliente.getCliente_desde();
                        ultima_compra = t_jw_representantes_clientes_ficha_cliente.getUltima_compra()==null?"":t_jw_representantes_clientes_ficha_cliente.getUltima_compra();
                        codigo_regional = t_jw_representantes_clientes_ficha_cliente.getCodigo_regional();
                        nome_regional = t_jw_representantes_clientes_ficha_cliente.getNome_regional()==null?"":t_jw_representantes_clientes_ficha_cliente.getNome_regional();
                        codigo_representante = t_jw_representantes_clientes_ficha_cliente.getCodigo_representante()==null?"":t_jw_representantes_clientes_ficha_cliente.getCodigo_representante();
                        rep_rzao = t_jw_representantes_clientes_ficha_cliente.getRep_rzao()==null?"":t_jw_representantes_clientes_ficha_cliente.getRep_rzao();
                        rep_nome = t_jw_representantes_clientes_ficha_cliente.getRep_nome()==null?"":t_jw_representantes_clientes_ficha_cliente.getRep_nome();
                        email_cliente = t_jw_representantes_clientes_ficha_cliente.getEmail_cliente();
                        fone_cliente = t_jw_representantes_clientes_ficha_cliente.getFone_cliente();
                        gre_grupo = t_jw_representantes_clientes_ficha_cliente.getGre_grupo();
                        gre_descricao = t_jw_representantes_clientes_ficha_cliente.getGre_descricao();
                        codigo_cliente = t_jw_representantes_clientes_ficha_cliente.getCodigo_cliente();
                        cli_rzao = t_jw_representantes_clientes_ficha_cliente.getCli_rzao();
                        cli_nome = t_jw_representantes_clientes_ficha_cliente.getCli_nome();
                        esc_seqn = t_jw_representantes_clientes_ficha_cliente.getEsc_seqn();
                        marcas_representante = t_jw_representantes_clientes_ficha_cliente.getMarcas_representante();
                        _b0_value = (cliente_desde==null?"":cliente_desde);
                        _b1_value = (cliente_desde==null?"":cliente_desde) + "_" + com.egen.util.text.FormatNumber.format(codigo_regional);
                      } else {
                        _b0_control = "__";
                        _b1_control = "__";
                      }
                    }
                    %>

                  </table>

                  <%
                } else {
                  %>
                  <script>
                    top.location='../com/FichaClienteForm.jsp';
                  </script>

                  <%
                }
                %>

              </form>
              <%
            }
            %>
            <%
            if(false){
              %>

              <%
              {
                %>

                <%
                java.util.Vector res_Jw_ficha_cliente_contatos = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_contatos");
                %>

                <form  name="bl_report_Jw_ficha_cliente_contatos" id="bl_report_Jw_ficha_cliente_contatos" class="baseForm" method="post" >
                  <table class="bannerTable" style="width:99%;">
                    <tr class="bannerTr">
                      <td class="bannerTd">
                        Contatos
                      </td>
                    </tr>
                  </table>

                  <%
                  if (res_Jw_ficha_cliente_contatos!=null && res_Jw_ficha_cliente_contatos.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_ficha_cliente_contatos"  class="reportTable"   style="width:99%; "  border="1" >
                      <%
                      java.lang.String nome =  null;
                      java.lang.String email =  null;
                      java.lang.String tipo =  null;
                      java.sql.Date data_nascimento =  null;
                      %>

                      <tr class="reportTr">
                        <td class="columnTdHeader" style="text-align:left;" >
                          Nome
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          e-Mail
                        </td>

                        <td class="columnTdHeader" style="text-align:left;" >
                          Tipo
                        </td>

                        <td class="columnTdHeader" style="text-align:center;" >
                          Data Nascimento
                        </td>

                      </tr>

                      <%
                      int i_bl_report_Jw_ficha_cliente_contatos = 0;
                      while (i_bl_report_Jw_ficha_cliente_contatos<res_Jw_ficha_cliente_contatos.size()) {
                        portalbr.dbobj.view.Jw_ficha_cliente_contatos t_jw_ficha_cliente_contatos = (portalbr.dbobj.view.Jw_ficha_cliente_contatos)res_Jw_ficha_cliente_contatos.elementAt(i_bl_report_Jw_ficha_cliente_contatos);
                        nome = t_jw_ficha_cliente_contatos.getNome()==null?"":t_jw_ficha_cliente_contatos.getNome();
                        email = t_jw_ficha_cliente_contatos.getEmail()==null?"":t_jw_ficha_cliente_contatos.getEmail();
                        tipo = t_jw_ficha_cliente_contatos.getTipo()==null?"":t_jw_ficha_cliente_contatos.getTipo();
                        data_nascimento = (java.sql.Date)t_jw_ficha_cliente_contatos.getData_nascimento();
                        String style_bl_report_Jw_ficha_cliente_contatos="";
                        if (!((i_bl_report_Jw_ficha_cliente_contatos%2)!=0)) {
                          style_bl_report_Jw_ficha_cliente_contatos="rowColor";
                        } else {
                          style_bl_report_Jw_ficha_cliente_contatos="rowBlank";
                        }
                        %>

                        <tr class='<%= style_bl_report_Jw_ficha_cliente_contatos %>' id="TRbl_report_Jw_ficha_cliente_contatos<%=i_bl_report_Jw_ficha_cliente_contatos%>" >
                          <td class="reportColumn" style="text-align:left;" >
                            <%= nome %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= email %>
                          </td>

                          <td class="reportColumn" style="text-align:left;" >
                            <%= tipo %>
                          </td>

                          <td class="reportColumn" style="text-align:center;" >
                            <%= com.egen.util.text.FormatDate.format(data_nascimento, "dd/MM/yyyy") %>
                          </td>

                        </tr>

                        <%
                        i_bl_report_Jw_ficha_cliente_contatos++;
                        if (i_bl_report_Jw_ficha_cliente_contatos<res_Jw_ficha_cliente_contatos.size()) {
                          t_jw_ficha_cliente_contatos = (portalbr.dbobj.view.Jw_ficha_cliente_contatos)res_Jw_ficha_cliente_contatos.elementAt(i_bl_report_Jw_ficha_cliente_contatos);
                          nome = t_jw_ficha_cliente_contatos.getNome()==null?"":t_jw_ficha_cliente_contatos.getNome();
                          email = t_jw_ficha_cliente_contatos.getEmail()==null?"":t_jw_ficha_cliente_contatos.getEmail();
                          tipo = t_jw_ficha_cliente_contatos.getTipo()==null?"":t_jw_ficha_cliente_contatos.getTipo();
                          data_nascimento = (java.sql.Date)t_jw_ficha_cliente_contatos.getData_nascimento();
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

              <%
            }
            %>
            <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                  </td>
                </tr>
              </table>

              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button value="Contatos" onclick="wopen('../com/FichaCliente_cForm.jsp','_blank',600,150)" styleClass="baseButton" property="contatos_action">
                    </html:button>
                  </td>
                </tr>
              </table>

            </html:form>
            <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">

              <table style="width:99%;">
                <html:hidden property="cli_cdgo"/>
                <html:hidden property="esc_seqn"/>
                <html:hidden property="gre_grupo"/>
              </table>

              <table>
                <tr>
                  <td>
                    <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                      <bean:message bundle="ApplicationResources" key="jsp.select"/>
                    </html:submit>
                    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
                      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
                    </html:submit>
                  </td>
                </tr>
              </table>

            </html:form>
            <br>

            <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">
              <table class="bannerTable" style="width:99%;">
                <tr class="bannerTr">
                  <td class="bannerTd">
                    Relacionamento
                  </td>
                </tr>
              </table>


              <table class="buttonTable" style='width:99%;'>
                <tr class="buttonTr">
                  <td class="buttonTd">
                    <html:button value="Incluir" styleClass="baseButton" property="next_action" onclick="wopen('../com/FichaCliente_icForm.jsp','_blank',700,200)">
                    </html:button>
                  </td>
                </tr>
              </table>


            </html:form>
            <%
            {
              java.util.Vector res_Informacoes_cliente = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                j.setMaxRows(5);
                portalbr.dbobj.table.Informacoes_cliente t_informacoes_cliente = new portalbr.dbobj.table.Informacoes_cliente();
                String cli_cdgo = "null";
                String esc_seqn = "null";
                String gre_grupo = "null";
                if(session.getAttribute("cli_cdgo")!=null){
                  cli_cdgo = (String)session.getAttribute("cli_cdgo");
                  esc_seqn = (String)session.getAttribute("esc_seqn");
                } else {
                  gre_grupo = (String)session.getAttribute("gre_grupo");
                }

                StringBuilder sb = new StringBuilder();
                sb.append(" SELECT sequencia ");
                sb.append("      ,data_informacao ");
                sb.append("      ,usuario ");
                sb.append("      ,cli_cdgo ");
                sb.append("      ,esc_seqn ");
                sb.append("      ,informacoes ");
                sb.append("  FROM informacoes_cliente ic ");
                sb.append(" WHERE ("+gre_grupo+" IS NOT NULL AND ((ic.gre_cdgo = "+gre_grupo+") )) ");
                sb.append("    OR ("+cli_cdgo+" IS NOT NULL AND (ic.cli_cdgo = "+cli_cdgo+" OR (pck_cliente.get_grupo_economico("+cli_cdgo+") = ic.gre_cdgo))) ");
                sb.append(" ORDER BY data_informacao desc ");

                res_Informacoes_cliente = j.select(t_informacoes_cliente, sb.toString(), null);
              } catch (Exception e){
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Informacoes_cliente" id="bl_report_Informacoes_cliente" method="post" >
              <%
              if (res_Informacoes_cliente!=null && res_Informacoes_cliente.size()>0) {
                %>

                <table id="TRbl_report_Informacoes_cliente"  class="reportTable"   style="width:99%; " border="1"  >
                  <%
                  int sequencia =  0;
                  java.sql.Timestamp data_informacao =  null;
                  java.lang.String usuario =  null;
                  java.lang.Integer cli_cdgo =  null;
                  java.lang.Integer esc_seqn =  null;
                  java.lang.String informacoes =  null;
                  %>

                  <tr class="reportTr">

                    <td class="columnTdHeader" style="text-align:center;" width="180px" >
                      Data
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" width="180px">
                      Usuário
                    </td>

                    <td class="columnTdHeader" style="text-align:left;" >
                      Informação
                    </td>

                  </tr>

                  <%
                  int i_bl_report_Informacoes_cliente = 0;
                  while (i_bl_report_Informacoes_cliente<res_Informacoes_cliente.size()) {
                    portalbr.dbobj.table.Informacoes_cliente t_informacoes_cliente = (portalbr.dbobj.table.Informacoes_cliente)res_Informacoes_cliente.elementAt(i_bl_report_Informacoes_cliente);
                    sequencia = t_informacoes_cliente.getSequencia();
                    data_informacao = (java.sql.Timestamp)t_informacoes_cliente.getData_informacao();
                    usuario = t_informacoes_cliente.getUsuario()==null?"":t_informacoes_cliente.getUsuario();
                    cli_cdgo = t_informacoes_cliente.getCli_cdgo();
                    esc_seqn = t_informacoes_cliente.getEsc_seqn();
                    informacoes = t_informacoes_cliente.getInformacoes()==null?"":t_informacoes_cliente.getInformacoes();
                    String style_bl_report_Informacoes_cliente="";
                    if (!((i_bl_report_Informacoes_cliente%2)!=0)) {
                      style_bl_report_Informacoes_cliente="rowColor";
                    } else {
                      style_bl_report_Informacoes_cliente="rowBlank";
                    }
                    %>

                    <tr class='<%= style_bl_report_Informacoes_cliente %>' id="TRbl_report_Informacoes_cliente<%=i_bl_report_Informacoes_cliente%>" >

                      <td class="reportColumn" style="text-align:center;" >
                        <%= com.egen.util.text.FormatDate.format(data_informacao, "dd/MM/yyyy HH:mm:ss") %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= usuario %>
                      </td>

                      <td class="reportColumn" style="text-align:left;" >
                        <%= informacoes %>
                      </td>

                    </tr>

                    <%
                    i_bl_report_Informacoes_cliente++;
                    if (i_bl_report_Informacoes_cliente<res_Informacoes_cliente.size()) {
                      t_informacoes_cliente = (portalbr.dbobj.table.Informacoes_cliente)res_Informacoes_cliente.elementAt(i_bl_report_Informacoes_cliente);
                      sequencia = t_informacoes_cliente.getSequencia();
                      data_informacao = (java.sql.Timestamp)t_informacoes_cliente.getData_informacao();
                      usuario = t_informacoes_cliente.getUsuario()==null?"":t_informacoes_cliente.getUsuario();
                      cli_cdgo = t_informacoes_cliente.getCli_cdgo();
                      esc_seqn = t_informacoes_cliente.getEsc_seqn();
                      informacoes = t_informacoes_cliente.getInformacoes()==null?"":t_informacoes_cliente.getInformacoes();
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
          <table class="bannerTable" style="width:100%;">
            <tr class="bannerTr">
              <td class="bannerTd">
                Atendimentos
              </td>
            </tr>
          </table>

          <%
          com.egen.util.jdbc.JdbcUtil j = null;
          int somaPares = 0;
          double somaValor = 0;
          int somaPares3meses = 0;
          double somaValor3meses = 0;
          try
          {

            java.util.Vector res_Jw_ficha_cliente_vendas_mes = null;
            try {
              acesso.Sessao sessao = new acesso.Sessao(session);
              boolean temRestricao = false;
              StringBuilder parametros = new StringBuilder();

              if((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) ||
              (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) ||
              (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) ||
              (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))){
                temRestricao= true;
              }

              if(temRestricao){
                parametros.append("  AND EXISTS (SELECT 1 ");
                parametros.append("                FROM rep r ");
                parametros.append("                   , cliente_representante cr ");
                parametros.append("                   , analistas_regionais a ");
                parametros.append("               WHERE rep_situ = 'A' ");
                parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
                parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");

                if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                  parametros.append("              AND r.codigo_regional = " + sessao.getChave());
                  parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                }
                if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))){
                  parametros.append("              AND r.rep_cdgo = '"+sessao.getChave()+"' ");
                  parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                }
                if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                  parametros.append("              AND a.codigo_gerente = '"+sessao.getChave()+"' ");
                  parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                }
                parametros.append("                 AND cr.codigo_cliente = f.cli_cdgo ");
                parametros.append("                 AND cr.codigo_sequencial = f.esc_seqn) ");
              }

              j = new com.egen.util.jdbc.JdbcUtil();
              portalbr.dbobj.view.Jw_ficha_cliente_vendas_mes t_jw_ficha_cliente_vendas_mes = new portalbr.dbobj.view.Jw_ficha_cliente_vendas_mes();
              StringBuilder sb = new StringBuilder();
              sb.append(" SELECT pck_marcas_produtos.get_nome(f.marca) marca ");
              sb.append("      , sum(f.pares) pares ");
              sb.append("      , ROUND(SUM(f.valor_item)) valor ");
              sb.append("   FROM fc_venda_ultimos_tres_meses_vm f ");
              sb.append("  WHERE f.ped_dadg >= TRUNC(SYSDATE,'mm') ");
              if(session.getAttribute("cli_cdgo")!=null){
                sb.append("    AND f.cli_cdgo = " + (String)session.getAttribute("cli_cdgo"));
                sb.append("    AND f.esc_seqn = " + (String)session.getAttribute("esc_seqn"));
              } else {
                sb.append("    AND f.gre_grupo = " + (String)session.getAttribute("gre_grupo"));
              }
              sb.append(parametros.toString());
              sb.append("  GROUP BY f.marca ");


              res_Jw_ficha_cliente_vendas_mes = j.select(t_jw_ficha_cliente_vendas_mes,sb.toString(),null);
            } catch (Exception e){
            }
            %>

            <form  name="bl_report_Jw_ficha_cliente_vendas_mes" id="bl_report_Jw_ficha_cliente_vendas_mes" class="baseForm" method="post" >
              <table class="bannerTable" style="width:100%;">
                <tr valign="top" >
                  <td style="width:50%">


                    <center>
                      <table id="TRbl_report_Jw_ficha_cliente_vendas_mes"  class="reportTable"   style="width:99%; " border="1"  >

                        <tr class="reportHeader3">
                          <td colspan="3">
                            Vendas Mês
                          </td>
                        </tr>

                        <%
                        if (res_Jw_ficha_cliente_vendas_mes!=null && res_Jw_ficha_cliente_vendas_mes.size()>0) {
                          %>

                          <%
                          java.lang.String marca =  null;
                          int pares =  0;
                          double valor =  0;
                          %>

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                              Marca
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:right;" >
                              Valor
                            </td>

                          </tr>

                          <%
                          int i_bl_report_Jw_ficha_cliente_vendas_mes = 0;
                          while (i_bl_report_Jw_ficha_cliente_vendas_mes<res_Jw_ficha_cliente_vendas_mes.size()) {
                            portalbr.dbobj.view.Jw_ficha_cliente_vendas_mes t_jw_ficha_cliente_vendas_mes = (portalbr.dbobj.view.Jw_ficha_cliente_vendas_mes)res_Jw_ficha_cliente_vendas_mes.elementAt(i_bl_report_Jw_ficha_cliente_vendas_mes);
                            marca = t_jw_ficha_cliente_vendas_mes.getMarca()==null?"":t_jw_ficha_cliente_vendas_mes.getMarca();
                            pares = t_jw_ficha_cliente_vendas_mes.getPares();
                            valor = t_jw_ficha_cliente_vendas_mes.getValor();
                            //        somaPares += pares;
                            //        somaValor += valor;
                            String style_bl_report_Jw_ficha_cliente_vendas_mes="";
                            if (!((i_bl_report_Jw_ficha_cliente_vendas_mes%2)!=0)) {
                              style_bl_report_Jw_ficha_cliente_vendas_mes="rowColor";
                            } else {
                              style_bl_report_Jw_ficha_cliente_vendas_mes="rowBlank";
                            }
                            %>

                            <tr class='<%= style_bl_report_Jw_ficha_cliente_vendas_mes %>' id="TRbl_report_Jw_ficha_cliente_vendas_mes<%=i_bl_report_Jw_ficha_cliente_vendas_mes%>" >
                              <td class="reportColumn" style="text-align:left;" >
                                <%= marca %>
                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= com.egen.util.text.FormatNumber.format(pares , "##,##0") %>
                                <%
                                somaPares += pares;
                                %>


                              </td>

                              <td class="reportColumn" style="text-align:right;" >
                                <%= com.egen.util.text.FormatNumber.format(valor, "##,##0.00") %>
                                <%
                                somaValor += valor;
                                %>
                              </td>

                            </tr>

                            <%
                            i_bl_report_Jw_ficha_cliente_vendas_mes++;
                            if (i_bl_report_Jw_ficha_cliente_vendas_mes<res_Jw_ficha_cliente_vendas_mes.size()) {
                              t_jw_ficha_cliente_vendas_mes = (portalbr.dbobj.view.Jw_ficha_cliente_vendas_mes)res_Jw_ficha_cliente_vendas_mes.elementAt(i_bl_report_Jw_ficha_cliente_vendas_mes);
                              marca = t_jw_ficha_cliente_vendas_mes.getMarca()==null?"":t_jw_ficha_cliente_vendas_mes.getMarca();
                              pares = t_jw_ficha_cliente_vendas_mes.getPares();
                              valor = t_jw_ficha_cliente_vendas_mes.getValor();

                            } else {
                            }
                          }
                          %>



                          <%
                        }
                        %>


                        <tr class="totalColumn">
                          <td colspan="2" class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                            Total:
                            <%= com.egen.util.text.FormatNumber.format(somaPares, "##,##0") %>
                          </td>
                          <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                            Total:
                            <%= com.egen.util.text.FormatNumber.format(somaValor, "##,##0.00") %>
                          </td>
                        </tr>



                      </table>
                    </center>

                  </td>


                  <td style="width:50%">

                    <%
                    {
                      %>

                      <%
                      java.util.Vector res_Jw_ficha_cliente_vendas_tres_meses = null;
                      try {
                        acesso.Sessao sessao = new acesso.Sessao(session);
                        boolean temRestricao = false;
                        StringBuilder parametros = new StringBuilder();

                        if((sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) ||
                        (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) ||
                        (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) ||
                        (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL"))){
                          temRestricao= true;
                        }

                        if(temRestricao){
                          parametros.append("  AND EXISTS (SELECT 1 ");
                          parametros.append("                FROM rep r ");
                          parametros.append("                   , cliente_representante cr ");
                          parametros.append("                   , analistas_regionais a ");
                          parametros.append("               WHERE rep_situ = 'A' ");
                          parametros.append("                 AND cr.situacao = 'A' ");
                          parametros.append("                 AND a.codigo_regional = r.codigo_regional ");
                          parametros.append("                 AND r.rep_cdgo = cr.codigo_representante ");

                          if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                            parametros.append("              AND r.codigo_regional = " + sessao.getChave());
                            parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                          }
                          if((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                            parametros.append("              AND r.rep_cdgo = '"+sessao.getChave()+"' ");
                            parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                          }
                          if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                            parametros.append("              AND a.codigo_gerente = '"+sessao.getChave()+"' ");
                            parametros.append("              AND r.rep_cdgo = f.rep_cdgo ");
                          }
                          parametros.append("                 AND cr.codigo_cliente = f.cli_cdgo ");
                          parametros.append("                 AND cr.codigo_sequencial = f.esc_seqn) ");
                        }

                        portalbr.dbobj.view.Jw_ficha_cliente_vendas_tres_meses t_jw_ficha_cliente_vendas_tres_meses = new portalbr.dbobj.view.Jw_ficha_cliente_vendas_tres_meses();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(" SELECT pck_marcas_produtos.get_nome(f.marca) marca ");
                        sb2.append("      , sum(f.pares) pares ");
                        sb2.append("      , ROUND(SUM(f.valor_item)) valor ");
                        sb2.append("   FROM fc_venda_ultimos_tres_meses_vm f ");
                        if(session.getAttribute("cli_cdgo")!=null){
                          sb2.append("    WHERE f.cli_cdgo = " + (String)session.getAttribute("cli_cdgo"));
                          sb2.append("      AND f.esc_seqn = " + (String)session.getAttribute("esc_seqn"));
                        } else {
                          sb2.append("  WHERE f.gre_grupo = " + (String)session.getAttribute("gre_grupo"));
                        }
                        sb2.append(parametros.toString());
                        sb2.append("  GROUP BY f.marca ");

                        res_Jw_ficha_cliente_vendas_tres_meses = j.select(t_jw_ficha_cliente_vendas_tres_meses,sb2.toString(),null);
                      } catch (Exception e){
                      }
                      %>

                      <form  name="bl_report_Jw_ficha_cliente_vendas_tres_meses" id="bl_report_Jw_ficha_cliente_vendas_tres_meses" class="baseForm" method="post" >

                        <center>
                          <table id="TRbl_report_Jw_ficha_cliente_vendas_tres_meses"  class="reportTable"   style="width:99%;" border="1"  >
                            <tr class="reportHeader3">
                              <td colspan="3">
                                Vendas Últimos três meses
                              </td>
                            </tr>
                            <%
                            if (res_Jw_ficha_cliente_vendas_tres_meses!=null && res_Jw_ficha_cliente_vendas_tres_meses.size()>0) {
                              %>



                              <%
                              java.lang.String marca1 =  null;
                              int pares1 =  0;
                              double valor1 =  0;
                              %>




                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:left;" >
                                  Marca
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Pares
                                </td>

                                <td class="columnTdHeader" style="text-align:right;" >
                                  Valor
                                </td>

                              </tr>

                              <%
                              int i_bl_report_Jw_ficha_cliente_vendas_tres_meses = 0;
                              while (i_bl_report_Jw_ficha_cliente_vendas_tres_meses<res_Jw_ficha_cliente_vendas_tres_meses.size()) {
                                portalbr.dbobj.view.Jw_ficha_cliente_vendas_tres_meses t_jw_ficha_cliente_vendas_tres_meses = (portalbr.dbobj.view.Jw_ficha_cliente_vendas_tres_meses)res_Jw_ficha_cliente_vendas_tres_meses.elementAt(i_bl_report_Jw_ficha_cliente_vendas_tres_meses);
                                marca1 = t_jw_ficha_cliente_vendas_tres_meses.getMarca()==null?"":t_jw_ficha_cliente_vendas_tres_meses.getMarca();
                                pares1 = t_jw_ficha_cliente_vendas_tres_meses.getPares();
                                valor1 = t_jw_ficha_cliente_vendas_tres_meses.getValor();
                                String style_bl_report_Jw_ficha_cliente_vendas_tres_meses="";
                                if (!((i_bl_report_Jw_ficha_cliente_vendas_tres_meses%2)!=0)) {
                                  style_bl_report_Jw_ficha_cliente_vendas_tres_meses="rowColor";
                                } else {
                                  style_bl_report_Jw_ficha_cliente_vendas_tres_meses="rowBlank";
                                }
                                %>

                                <tr class='<%= style_bl_report_Jw_ficha_cliente_vendas_tres_meses %>' id="TRbl_report_Jw_ficha_cliente_vendas_tres_meses<%=i_bl_report_Jw_ficha_cliente_vendas_tres_meses%>" >
                                  <td class="reportColumn" style="text-align:left;" >
                                    <%= marca1 %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(pares1 , "##,##0") %>
                                    <%
                                    somaPares3meses += pares1;
                                    %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= com.egen.util.text.FormatNumber.format(valor1, "##,##0.00") %>
                                    <%
                                    somaValor3meses += valor1;
                                    %>
                                  </td>

                                </tr>

                                <%
                                i_bl_report_Jw_ficha_cliente_vendas_tres_meses++;
                                if (i_bl_report_Jw_ficha_cliente_vendas_tres_meses<res_Jw_ficha_cliente_vendas_tres_meses.size()) {
                                  t_jw_ficha_cliente_vendas_tres_meses = (portalbr.dbobj.view.Jw_ficha_cliente_vendas_tres_meses)res_Jw_ficha_cliente_vendas_tres_meses.elementAt(i_bl_report_Jw_ficha_cliente_vendas_tres_meses);
                                  marca1 = t_jw_ficha_cliente_vendas_tres_meses.getMarca()==null?"":t_jw_ficha_cliente_vendas_tres_meses.getMarca();
                                  pares1 = t_jw_ficha_cliente_vendas_tres_meses.getPares();
                                  valor1 = t_jw_ficha_cliente_vendas_tres_meses.getValor();
                                } else {
                                }
                              }
                              %>



                              <%
                            }
                            %>


                            <tr class="totalColumn">
                              <td colspan="2" class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                                Total:
                                <%= com.egen.util.text.FormatNumber.format(somaPares3meses, "##,##0") %>
                              </td>
                              <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                                Total:
                                <%= com.egen.util.text.FormatNumber.format(somaValor3meses, "##,##0.00") %>
                              </td>
                            </tr>

                          </table>
                        </center>

                      </form>
                      <%
                    }
                    %>



                  </td>




                </tr>
              </table>

            </form>
            <%
          } finally {
          if(j!=null){j.close();}
        }
        %>
        <%
        {
          util.consultas.Parametros parametros = new util.consultas.Parametros();
          String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
          %>

          <%
          java.util.Vector res_Jw_ficha_cliente_maiores_vendas_pais = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_maiores_vendas_pais");
          %>

          <form  name="bl_report_Jw_ficha_cliente_maiores_vendas_1" id="bl_report_Jw_ficha_cliente_maiores_vendas_1" class="baseForm" method="post" >
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Modelos mais vendidos no país nos últimos 15 dias
                </td>
              </tr>
            </table>

            <%
            if (res_Jw_ficha_cliente_maiores_vendas_pais!=null && res_Jw_ficha_cliente_maiores_vendas_pais.size()>0) {
              %>

              <table id="TRbl_report_Jw_ficha_cliente_maiores_vendas_1"  class="reportTable"   style="width:99%; "  border="1" >
                <%
                java.lang.Integer codigo_marca =  null;
                java.lang.String descricao_marca =  null;
                java.lang.String imagem1 =  null;
                java.lang.String modelo1 =  null;
                java.lang.Integer pares3 =  null;
                java.lang.Double valor3 =  null;
                java.lang.Integer lin_cdgo3 =  null;
                java.lang.Integer ref_cdgo3 =  null;
                String _b0_control = "__";
                int sum_pares3_0 = 0;
                int sum_pares3_1 = 0;
                double sum_valor3_0 = 0;
                double sum_valor3_1 = 0;
                int i_bl_report_Jw_ficha_cliente_maiores_vendas_1 = 0;
                while (i_bl_report_Jw_ficha_cliente_maiores_vendas_1<res_Jw_ficha_cliente_maiores_vendas_pais.size()) {
                  portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_pais.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas_1);
                  codigo_marca = t_jw_ficha_cliente_maiores_vendas.getCodigo_marca();
                  descricao_marca = t_jw_ficha_cliente_maiores_vendas.getDescricao_marca()==null?"":t_jw_ficha_cliente_maiores_vendas.getDescricao_marca();
                  imagem1 = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                  modelo1 = t_jw_ficha_cliente_maiores_vendas.getModelo();
                  lin_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                  ref_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                  pares3 = t_jw_ficha_cliente_maiores_vendas.getPares();
                  valor3 = t_jw_ficha_cliente_maiores_vendas.getValor();
                  sum_pares3_0 += ((pares3!=null)?pares3.intValue():0);
                  sum_pares3_1 += ((pares3!=null)?pares3.intValue():0);
                  sum_valor3_0 += ((valor3!=null)?valor3.doubleValue():0);
                  sum_valor3_1 += ((valor3!=null)?valor3.doubleValue():0);
                  String _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                  if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                    %>
                    <tr class="reportHeader">
                      <td colspan="4">
                        <span class="columnTdHeader" style="text-align:right;" >
                          Marca:
                          <%= ((codigo_marca!=null)?codigo_marca.toString():"") %>
                          -
                          <%= descricao_marca %>
                        </span>
                      </td>
                    </tr>
                    <%
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Imagem
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Modelo
                      </td>

                      <td class="columnTdHeader" style="text-align:right;" >
                        Pares
                      </td>

                      <!--
                        <td class="columnTdHeader" style="text-align:right;" > Valor </td>
                      -->

                    </tr>

                    <%
                  }
                  String style_bl_report_Jw_ficha_cliente_maiores_vendas_1="";
                  if (!((i_bl_report_Jw_ficha_cliente_maiores_vendas_1%2)!=0)) {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas_1="rowColor";
                  } else {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas_1="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_ficha_cliente_maiores_vendas_1 %>' id="TRbl_report_Jw_ficha_cliente_maiores_vendas_1<%=i_bl_report_Jw_ficha_cliente_maiores_vendas_1%>" >
                    <td class="reportColumn" style="text-align:center;" width="1%" >
                      <img src="<%= diretorio_imagem+imagem1 %>" width="67" height="37" onclick="wopen('../com/FichaCliente_imgForm.do?select_action=&linha=<%= lin_cdgo3 %>&referencia=<%= ref_cdgo3 %>','_blank',640,300)" STYLE="cursor:hand">
                    </td>
                    <td class="reportColumn" style="text-align:right;" >
                      <%= modelo1 %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(pares3, "##,##0") %>
                    </td>

                    <!--
                      <td class="reportColumn" style="text-align:right;" > <%= com.egen.util.text.FormatNumber.format(valor3, "##,##0.00") %> </td>
                    -->

                  </tr>

                  <%
                  _b0_control = _b0_value;
                  i_bl_report_Jw_ficha_cliente_maiores_vendas_1++;
                  if (i_bl_report_Jw_ficha_cliente_maiores_vendas_1<res_Jw_ficha_cliente_maiores_vendas_pais.size()) {
                    t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_pais.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas_1);
                    codigo_marca = t_jw_ficha_cliente_maiores_vendas.getCodigo_marca();
                    descricao_marca = t_jw_ficha_cliente_maiores_vendas.getDescricao_marca()==null?"":t_jw_ficha_cliente_maiores_vendas.getDescricao_marca();
                    imagem1 = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                    modelo1 = t_jw_ficha_cliente_maiores_vendas.getModelo();
                    lin_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                    ref_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                    pares3 = t_jw_ficha_cliente_maiores_vendas.getPares();
                    valor3 = t_jw_ficha_cliente_maiores_vendas.getValor();
                    _b0_value = com.egen.util.text.FormatNumber.format(codigo_marca);
                  } else {
                    _b0_control = "__";
                  }
                  if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                    %>

                    <tr class="totalColumn">
                      <td>
                         
                      </td>
                      <td>
                         
                      </td>
                      <td class="totalTdColumn"  style="text-align:right;" >
                        <b>
                          Total:
                        </b>
                        <b>
                          <%= com.egen.util.text.FormatNumber.format(sum_pares3_1, "##,##0") %>
                        </b>
                      </td>

                      <!--
                        <td class="totalTdColumn" style="text-align:right;" > <b>Total:</b> <b><%= com.egen.util.text.FormatNumber.format(sum_valor3_1, "##,##0.00") %></b> </td>
                      -->

                    </tr>

                    <%
                    sum_pares3_1 = 0;
                    sum_valor3_1 = 0;
                  }
                }
                %>

                <tr class="totalColumn">
                  <td>
                     
                  </td>
                  <td>
                     
                  </td>
                  <td class="totalTdColumn"  style="text-align:right;" >
                    <b>
                      Total:
                    </b>
                    <b>
                      <%= com.egen.util.text.FormatNumber.format(sum_pares3_0, "##,##0") %>
                    </b>
                  </td>

                  <!--
                    <td class="totalTdColumn" style="text-align:right;" > <b>Total:</b> <b><%= com.egen.util.text.FormatNumber.format(sum_valor3_0, "##,##0.00") %></b> </td>
                  -->

                </tr>

                <%
                %>

              </table>

              <%
            }
            %>

          </form>
          <%
        }
        %>
        <%
        {
          util.consultas.Parametros parametros = new util.consultas.Parametros();
          String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
          java.util.Vector res_Jw_ficha_cliente_maiores_vendas_pais = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_maiores_vendas_cliente");
          %>


          <form  name="bl_report_Jw_ficha_cliente_maiores_vendas_1" id="bl_report_Jw_ficha_cliente_maiores_vendas_1" class="baseForm" method="post" >

            <%
            if (res_Jw_ficha_cliente_maiores_vendas_pais!=null && res_Jw_ficha_cliente_maiores_vendas_pais.size()>0) {
              %>
              <table class="bannerTable" style="width:99%;">
                <tr class="bannerTr">
                  <td class="bannerTd">

                    <%
                    if(session.getAttribute("cli_cdgo")!=null){
                      %>
                      Modelos mais vendidos no Cliente no mês corrente
                      <%
                    } else {
                      %>
                      Modelos mais vendidos no Grupo Econômico no mês corrente
                      <%
                    }
                    %>


                  </td>
                </tr>
              </table>
              <%
            }
            %>

            <%
            if (res_Jw_ficha_cliente_maiores_vendas_pais!=null && res_Jw_ficha_cliente_maiores_vendas_pais.size()>0) {
              %>

              <table id="TRbl_report_Jw_ficha_cliente_maiores_vendas_1"  class="reportTable"   style="width:99%; "  border="1" >
                <%
                java.lang.String imagem1 =  null;
                java.lang.String modelo1 =  null;
                java.lang.Integer lin_cdgo3 =  null;
                java.lang.Integer ref_cdgo3 =  null;
                java.lang.Integer pares3 =  null;
                java.lang.Double valor3 =  null;
                int sum_pares3_0 = 0;
                double sum_valor3_0 = 0;
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:center;" >
                    Imagem
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Modelo
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Pares
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Valor
                  </td>

                </tr>

                <%
                int i_bl_report_Jw_ficha_cliente_maiores_vendas_1 = 0;
                while (i_bl_report_Jw_ficha_cliente_maiores_vendas_1<res_Jw_ficha_cliente_maiores_vendas_pais.size()) {
                  portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_pais.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas_1);
                  imagem1 = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                  modelo1 = t_jw_ficha_cliente_maiores_vendas.getModelo();
                  lin_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                  ref_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                  pares3 = t_jw_ficha_cliente_maiores_vendas.getPares();
                  valor3 = t_jw_ficha_cliente_maiores_vendas.getValor();
                  sum_pares3_0 += ((pares3!=null)?pares3.intValue():0);
                  sum_valor3_0 += ((valor3!=null)?valor3.doubleValue():0);
                  String style_bl_report_Jw_ficha_cliente_maiores_vendas_1="";
                  if (!((i_bl_report_Jw_ficha_cliente_maiores_vendas_1%2)!=0)) {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas_1="rowColor";
                  } else {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas_1="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_ficha_cliente_maiores_vendas_1 %>' id="TRbl_report_Jw_ficha_cliente_maiores_vendas_1<%=i_bl_report_Jw_ficha_cliente_maiores_vendas_1%>" >
                    <td class="reportColumn" style="text-align:center;" width="1%" >
                      <img src="<%= diretorio_imagem+imagem1 %>" width="67" height="37" onclick="wopen('../com/FichaCliente_imgForm.do?select_action=&linha=<%= lin_cdgo3 %>&referencia=<%= ref_cdgo3 %>','_blank',640,300)" STYLE="cursor:hand">
                    </td>
                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((modelo1!=null)?modelo1.toString():"") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(pares3, "##,##0") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(valor3, "##,##0.00") %>
                    </td>

                  </tr>

                  <%
                  i_bl_report_Jw_ficha_cliente_maiores_vendas_1++;
                  if (i_bl_report_Jw_ficha_cliente_maiores_vendas_1<res_Jw_ficha_cliente_maiores_vendas_pais.size()) {
                    t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_pais.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas_1);
                    imagem1 = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                    modelo1 = t_jw_ficha_cliente_maiores_vendas.getModelo();
                    lin_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                    ref_cdgo3 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                    pares3 = t_jw_ficha_cliente_maiores_vendas.getPares();
                    valor3 = t_jw_ficha_cliente_maiores_vendas.getValor();
                  } else {
                  }
                }
                %>

                <tr class="totalColumn">
                  <td>
                     
                  </td>
                  <td>
                     
                  </td>
                  <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                    Total:
                    <%= com.egen.util.text.FormatNumber.format(sum_pares3_0, "##,##0") %>
                  </td>
                  <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                    Total:
                    <%= com.egen.util.text.FormatNumber.format(sum_valor3_0, "##,##0.00") %>
                  </td>
                </tr>

                <%
                %>

              </table>

              <%
            } else {
              %>


              <%
            }
            %>

          </form>
          <%
        }
        %>


        <%
        java.util.Vector res_Jw_ficha_cliente_maiores_vendas_pais2 = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_maiores_vendas_cliente");
        %>
        <%
        if (res_Jw_ficha_cliente_maiores_vendas_pais2!=null && res_Jw_ficha_cliente_maiores_vendas_pais2.size()==0) {
          %>
          <table class="bannerTable" style="width:99%;">
            <tr class="bannerTr">
              <td class="bannerTd">

                <%
                if(session.getAttribute("cli_cdgo")!=null){
                  %>
                  Linhas mais vendidas do Cliente no mês corrente
                  <%
                } else {
                  %>
                  Linhas mais vendidas do Grupo Econômico no mês corrente
                  <%
                }
                %>


              </td>
            </tr>
          </table>

          <table class="reportTable"   style="width:99%; "  border="1" >
            <tr class="reportTr">
              <td class="columnTdHeader" style="text-align:center;" >
                Imagem
              </td>

              <td class="columnTdHeader" style="text-align:right;" >
                Linha
              </td>

              <td class="columnTdHeader" style="text-align:right;" >
                Pares
              </td>

              <td class="columnTdHeader" style="text-align:right;" >
                Valor
              </td>

            </tr>
            <tr class="totalColumn">
              <td>
                 
              </td>
              <td>
                 
              </td>
              <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                Total:
                <%= com.egen.util.text.FormatNumber.format(0, "##,##0") %>
              </td>
              <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                Total:
                <%= com.egen.util.text.FormatNumber.format(0, "##,##0.00") %>
              </td>
            </tr>

          </table>


          <%
        }
        %>
        <%
        {
          util.consultas.Parametros parametros = new util.consultas.Parametros();
          String diretorio_imagem = parametros.retornaParametro("diretorio_imagens_ranking");
          %>

          <%
          java.util.Vector res_Jw_ficha_cliente_maiores_vendas_regional = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_maiores_vendas_regional");
          %>

          <form  name="bl_report_Jw_ficha_cliente_maiores_vendas" id="bl_report_Jw_ficha_cliente_maiores_vendas" class="baseForm" method="post" >
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Modelos mais vendidos na Regional no mês corrente
                </td>
              </tr>
            </table>

            <%
            if (res_Jw_ficha_cliente_maiores_vendas_regional!=null && res_Jw_ficha_cliente_maiores_vendas_regional.size()>0) {
              %>

              <table id="TRbl_report_Jw_ficha_cliente_maiores_vendas"  class="reportTable"   style="width:99%; "  border="1" >
                <%
                java.lang.String imagem =  null;
                java.lang.String modelo =  null;
                java.lang.Integer lin_cdgo2 =  null;
                java.lang.Integer ref_cdgo2 =  null;
                java.lang.Integer pares2 =  null;
                java.lang.Double valor2 =  null;
                int sum_pares2_0 = 0;
                double sum_valor2_0 = 0;
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:center;" >
                    Imagem
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Modelo
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Pares
                  </td>

                  <!--
                    <td class="columnTdHeader" style="text-align:right;" > Valor </td>
                  -->

                </tr>

                <%
                int i_bl_report_Jw_ficha_cliente_maiores_vendas = 0;
                while (i_bl_report_Jw_ficha_cliente_maiores_vendas<res_Jw_ficha_cliente_maiores_vendas_regional.size()) {
                  portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_regional.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas);
                  imagem = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                  modelo = t_jw_ficha_cliente_maiores_vendas.getModelo();
                  lin_cdgo2 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                  ref_cdgo2 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                  pares2 = t_jw_ficha_cliente_maiores_vendas.getPares();
                  valor2 = t_jw_ficha_cliente_maiores_vendas.getValor();
                  sum_pares2_0 += ((pares2!=null)?pares2.intValue():0);
                  sum_valor2_0 += ((valor2!=null)?valor2.doubleValue():0);
                  String style_bl_report_Jw_ficha_cliente_maiores_vendas="";
                  if (!((i_bl_report_Jw_ficha_cliente_maiores_vendas%2)!=0)) {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas="rowColor";
                  } else {
                    style_bl_report_Jw_ficha_cliente_maiores_vendas="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_ficha_cliente_maiores_vendas %>' id="TRbl_report_Jw_ficha_cliente_maiores_vendas<%=i_bl_report_Jw_ficha_cliente_maiores_vendas%>" >
                    <td class="reportColumn" style="text-align:center;" width="1%" >
                      <img src="<%= diretorio_imagem+imagem %>" width="67" height="37" onclick="wopen('../com/FichaCliente_imgForm.do?select_action=&linha=<%= lin_cdgo2 %>&referencia=<%= ref_cdgo2 %>','_blank',640,300)" STYLE="cursor:hand">
                    </td>
                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((modelo!=null)?modelo.toString():"") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(pares2, "##,##0") %>
                    </td>

                    <!--
                      <td class="reportColumn" style="text-align:right;" > <%= com.egen.util.text.FormatNumber.format(valor2, "##,##0.00") %> </td>
                    -->

                  </tr>

                  <%
                  i_bl_report_Jw_ficha_cliente_maiores_vendas++;
                  if (i_bl_report_Jw_ficha_cliente_maiores_vendas<res_Jw_ficha_cliente_maiores_vendas_regional.size()) {
                    t_jw_ficha_cliente_maiores_vendas = (portalbr.dbobj.view.Jw_ficha_cliente_maiores_vendas)res_Jw_ficha_cliente_maiores_vendas_regional.elementAt(i_bl_report_Jw_ficha_cliente_maiores_vendas);
                    imagem = t_jw_ficha_cliente_maiores_vendas.getImagem()==null?"":t_jw_ficha_cliente_maiores_vendas.getImagem();
                    modelo = t_jw_ficha_cliente_maiores_vendas.getModelo();
                    lin_cdgo2 = t_jw_ficha_cliente_maiores_vendas.getLin_cdgo();
                    ref_cdgo2 = t_jw_ficha_cliente_maiores_vendas.getRef_cdgo();
                    pares2 = t_jw_ficha_cliente_maiores_vendas.getPares();
                    valor2 = t_jw_ficha_cliente_maiores_vendas.getValor();
                  } else {
                  }
                }
                %>

                <tr class="totalColumn">
                  <td>
                     
                  </td>
                  <td>
                     
                  </td>
                  <td class="totalTdColumn"  style="text-align:right; font-weight:bold;" >
                    Total:
                    <%= com.egen.util.text.FormatNumber.format(sum_pares2_0, "##,##0") %>
                  </td>

                  <!--
                    <td class="totalTdColumn" style="text-align:right; font-weight:bold;" > Total: <%= com.egen.util.text.FormatNumber.format(sum_valor2_0, "##,##0.00") %> </td>
                  -->

                </tr>

                <%
                %>

              </table>

              <%
            }
            %>

          </form>
          <%
        }
        %>
        <%
        {
          %>

          <%
          java.util.Vector res_Jw_ficha_cliente_devolucoes = (java.util.Vector)session.getAttribute("res_Jw_ficha_cliente_devolucoes");
          %>

          <form  name="bl_report_Jw_ficha_cliente_devolucoes" id="bl_report_Jw_ficha_cliente_devolucoes" class="baseForm" method="post" >
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Devoluções
                </td>
              </tr>
            </table>

            <%
            if (res_Jw_ficha_cliente_devolucoes!=null && res_Jw_ficha_cliente_devolucoes.size()>0) {
              %>

              <table id="TRbl_report_Jw_ficha_cliente_devolucoes"  class="reportTable"   style="width:99%; "  border="1" >
                <tr class="reportHeader3">
                  <td colspan="4">
                    Devoluções no mês corrente
                  </td>
                </tr>
                <%
                int tamanho = 0;
                int sum_pares_0 = 0;
                double sum_valor_0 = 0;
                java.lang.Integer ordem =  null;
                java.sql.Timestamp data_cad =  null;
                java.lang.Integer nfs_nmro =  null;
                java.lang.Integer pares5 =  null;
                java.lang.Double valor5 =  null;

                if(res_Jw_ficha_cliente_devolucoes.size()>5){
                  tamanho = 5;
                } else {
                  tamanho = res_Jw_ficha_cliente_devolucoes.size();
                }
                %>

                <tr class="reportTr">
                  <td class="columnTdHeader" style="text-align:center;" >
                    Data
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Nota Fiscal
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Pares
                  </td>

                  <td class="columnTdHeader" style="text-align:right;" >
                    Valor
                  </td>

                </tr>

                <%
                int i_bl_report_Jw_ficha_cliente_devolucoes = 0;
                while (i_bl_report_Jw_ficha_cliente_devolucoes<tamanho) {
                  portalbr.dbobj.view.Jw_ficha_cliente_devolucoes t_jw_ficha_cliente_devolucoes = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes)res_Jw_ficha_cliente_devolucoes.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes);
                  ordem = t_jw_ficha_cliente_devolucoes.getOrdem();
                  data_cad = (java.sql.Timestamp)t_jw_ficha_cliente_devolucoes.getData_cad();
                  nfs_nmro = t_jw_ficha_cliente_devolucoes.getNfs_nmro();
                  pares5 = t_jw_ficha_cliente_devolucoes.getPares();
                  valor5 = t_jw_ficha_cliente_devolucoes.getValor();
                  String style_bl_report_Jw_ficha_cliente_devolucoes="";
                  if (!((i_bl_report_Jw_ficha_cliente_devolucoes%2)!=0)) {
                    style_bl_report_Jw_ficha_cliente_devolucoes="rowColor";
                  } else {
                    style_bl_report_Jw_ficha_cliente_devolucoes="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_ficha_cliente_devolucoes %>' id="TRbl_report_Jw_ficha_cliente_devolucoes<%=i_bl_report_Jw_ficha_cliente_devolucoes%>" >
                    <td class="reportColumn" style="text-align:center;" >
                      <%= com.egen.util.text.FormatDate.format(data_cad, "dd/MM/yyyy") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((nfs_nmro!=null)?nfs_nmro.toString():"") %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= ((pares5!=null)?pares5.toString():"") %>
                      <%
                      sum_pares_0 += ((pares5!=null)?pares5.intValue():0);
                      %>
                    </td>

                    <td class="reportColumn" style="text-align:right;" >
                      <%= com.egen.util.text.FormatNumber.format(valor5, "##,##0.00") %>
                      <%
                      sum_valor_0 += ((valor5!=null)?valor5.doubleValue():0);
                      %>
                    </td>

                  </tr>

                  <%
                  i_bl_report_Jw_ficha_cliente_devolucoes++;
                  if (i_bl_report_Jw_ficha_cliente_devolucoes<tamanho) {
                    t_jw_ficha_cliente_devolucoes = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes)res_Jw_ficha_cliente_devolucoes.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes);
                    ordem = t_jw_ficha_cliente_devolucoes.getOrdem();
                    data_cad = (java.sql.Timestamp)t_jw_ficha_cliente_devolucoes.getData_cad();
                    nfs_nmro = t_jw_ficha_cliente_devolucoes.getNfs_nmro();
                    pares5 = t_jw_ficha_cliente_devolucoes.getPares();
                    valor5 = t_jw_ficha_cliente_devolucoes.getValor();
                  } else {
                  }
                }
                %>

                <tr class="totalColumn">
                  <td>
                     
                  </td>
                  <td>
                     
                  </td>
                  <td class="totalTdColumn"  style="text-align:right;" >
                    <b>
                      Total:
                      <%= com.egen.util.text.FormatNumber.format(sum_pares_0, "##,##0") %>
                    </b>
                  </td>
                  <td class="totalTdColumn"  style="text-align:right;" >
                    <b>
                      Total:
                      <%= com.egen.util.text.FormatNumber.format(sum_valor_0, "##,##0.00") %>
                    </b>
                  </td>
                </tr>


                <tr class="totalColumn">
                  <td colspan="4"  style="text-align:right;">
                    Mostrando
                    <%= tamanho %>
                    de
                    <%= res_Jw_ficha_cliente_devolucoes.size() %>
                    notas
                  </td>
                </tr>

              </table>

              <%
            }
            %>

          </form>
          <%
        }
        %>



        <!--
          Devoluções Transportadoras
        -->
        <%
        {
          %>

          <%
          java.util.Vector res_Jw_ficha_cliente_devolucoes_transportadoras = null;
          com.egen.util.jdbc.JdbcUtil jd = null;
          try {
            jd = new com.egen.util.jdbc.JdbcUtil();
            portalbr.dbobj.view.Jw_ficha_cliente_devolucoes_transportadoras t_jw_ficha_cliente_devolucoes_transportadoras = new portalbr.dbobj.view.Jw_ficha_cliente_devolucoes_transportadoras();
            String[][] select = {{"gre_grupo",null},{"cli_cdgo",null},{"esc_seqn",null},{"pares",null},{"valor",null},};
            Object[][] where = {
              {"cli_cdgo","=",session.getAttribute("cli_cdgo")!=null?((String)session.getAttribute("cli_cdgo")):null},
              {"esc_seqn","=",session.getAttribute("esc_seqn")!=null?((String)session.getAttribute("esc_seqn")):null},
            {"gre_grupo","=",session.getAttribute("gre_grupo")!=null?((String)session.getAttribute("gre_grupo")):null}
            };

            String[] groupby =  null;
            String[] having =  null;
            String[] order =  null;
            res_Jw_ficha_cliente_devolucoes_transportadoras = jd.select(t_jw_ficha_cliente_devolucoes_transportadoras,select,where,groupby,having,order);
          } catch (Exception e){
          } finally {
          if(jd!=null){jd.close();}
        }
        %>

        <form  name="bl_report_Jw_ficha_cliente_devolucoes_transportadoras" id="bl_report_Jw_ficha_cliente_devolucoes_transportadoras" class="baseForm" method="post" >

          <%
          if (res_Jw_ficha_cliente_devolucoes_transportadoras!=null && res_Jw_ficha_cliente_devolucoes_transportadoras.size()>0) {
            %>

            <%
          }
          %>

          <%
          if (res_Jw_ficha_cliente_devolucoes_transportadoras!=null && res_Jw_ficha_cliente_devolucoes_transportadoras.size()>0) {
            %>

            <br>
            <table id="TRbl_report_Jw_ficha_cliente_devolucoes_transportadoras"  class="reportTable"   style="width:99%; "  border="1" >
              <tr class="reportHeader3">
                <td colspan="3">
                  Devoluções Transportadoras
                </td>
              </tr>

              <%
              java.lang.Integer gre_grupo =  null;
              java.lang.Integer cli_cdgo =  null;
              java.lang.Integer esc_seqn =  null;
              int sum_pares_1 = 0;
              double sum_valor_1 = 0;
              int pares1 =  0;
              double valor1 =  0;
              %>

              <!--
                <tr class="reportTr"> <td class="columnTdHeader" style="text-align:right;" > Pares </td> <td class="columnTdHeader" style="text-align:right;" > Valor </td> </tr>
              -->

              <%
              int i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras = 0;
              while (i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras<res_Jw_ficha_cliente_devolucoes_transportadoras.size()) {
                portalbr.dbobj.view.Jw_ficha_cliente_devolucoes_transportadoras t_jw_ficha_cliente_devolucoes_transportadoras = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes_transportadoras)res_Jw_ficha_cliente_devolucoes_transportadoras.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras);
                gre_grupo = t_jw_ficha_cliente_devolucoes_transportadoras.getGre_grupo();
                cli_cdgo = t_jw_ficha_cliente_devolucoes_transportadoras.getCli_cdgo();
                esc_seqn = t_jw_ficha_cliente_devolucoes_transportadoras.getEsc_seqn();
                pares1 = t_jw_ficha_cliente_devolucoes_transportadoras.getPares();
                valor1 = t_jw_ficha_cliente_devolucoes_transportadoras.getValor();
                String style_bl_report_Jw_ficha_cliente_devolucoes_transportadoras="";
                if (!((i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras%2)!=0)) {
                  style_bl_report_Jw_ficha_cliente_devolucoes_transportadoras="rowColor";
                } else {
                  style_bl_report_Jw_ficha_cliente_devolucoes_transportadoras="rowBlank";
                }
                %>

                <%
                sum_pares_1 += pares1;
                %>
                <%
                sum_valor_1 += valor1;
                %>

                <!--
                  <tr class='<%= style_bl_report_Jw_ficha_cliente_devolucoes_transportadoras %>' id="TRbl_report_Jw_ficha_cliente_devolucoes_transportadoras<%=i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras%>" >
                -->

                <!--
                  <td class="reportColumn" style="text-align:right;" > <%= pares1 %> </td>
                -->



                <!--
                  <td class="reportColumn" style="text-align:right;" > <%= com.egen.util.text.FormatNumber.format(valor1, "##,##0.00") %> </td>
                -->

              </tr>

              <%
              i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras++;
              if (i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras<res_Jw_ficha_cliente_devolucoes_transportadoras.size()) {
                t_jw_ficha_cliente_devolucoes_transportadoras = (portalbr.dbobj.view.Jw_ficha_cliente_devolucoes_transportadoras)res_Jw_ficha_cliente_devolucoes_transportadoras.elementAt(i_bl_report_Jw_ficha_cliente_devolucoes_transportadoras);
                gre_grupo = t_jw_ficha_cliente_devolucoes_transportadoras.getGre_grupo();
                cli_cdgo = t_jw_ficha_cliente_devolucoes_transportadoras.getCli_cdgo();
                esc_seqn = t_jw_ficha_cliente_devolucoes_transportadoras.getEsc_seqn();
                pares1 = t_jw_ficha_cliente_devolucoes_transportadoras.getPares();
                valor1 = t_jw_ficha_cliente_devolucoes_transportadoras.getValor();
              } else {
              }
            }
            %>

            <tr class="totalColumn">

              <td class="totalTdColumn"  style="text-align:right;" >
                <b>
                  Total de Pares:
                  <%= com.egen.util.text.FormatNumber.format(sum_pares_1, "##,##0") %>
                </b>
              </td>
              <td class="totalTdColumn"  style="text-align:right;" >
                <b>
                  Valor Total:
                  <%= com.egen.util.text.FormatNumber.format(sum_valor_1, "##,##0.00") %>
                </b>
              </td>
            </tr>

          </table>

          <%
        }
        %>

      </form>
      <%
    }
    %>
    <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">
      <table class="messageTable" style='width:99%;'>
        <tr class="messageTr" >
          <td class="messageTd">
            <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_5"/>
          </td>
        </tr>
      </table>

      <table class="buttonTable" style='width:99%;'>
        <tr class="buttonTr">
          <td class="buttonTd">
            <html:button value="Devoluções no ano corrente" onclick="wopen('../com/FichaCliente_devForm.do?select_action=','_blank',1000,500)" styleClass="baseButton" property="devolucao_ano_corrente_action">
            </html:button>
            <html:button value="Devoluções no ano anterior" onclick="wopen('../com/FichaCliente_devForm.do?select1_action=','_blank',1000,500)" styleClass="baseButton" property="devolucao_ano_anterior_action">
            </html:button>
          </td>
        </tr>
      </table>

    </html:form>
    <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">
      <table class="bannerTable" style="width:99%;">
        <tr class="bannerTr">
          <td class="bannerTd">
            Financeiras
          </td>
        </tr>
      </table>

      <table class="buttonTable" style='width:99%;'>
        <tr class="buttonTr">
          <td class="buttonTd">
            <html:button value="Informações Financeiras" onclick="wopen('../com/FichaCliente_ifForm.do?execute_action=','_blank',600,150)" styleClass="baseButton" property="informacoes_financeiras_action">
            </html:button>
          </td>
        </tr>
      </table>

    </html:form>
    <!--
      Comentado somente para desabilitar os valores
    -->

    <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">
      <table class="bannerTable" style="width:99%;">
        <tr class="bannerTr">
          <td class="bannerTd">
            Marketing
          </td>
        </tr>
      </table>

      <table class="messageTable" style='width:99%;'>
        <tr class="messageTr" >
          <td class="messageTd">
            <html:errors property="valor_utilizado"/>
            <html:errors property="valor_disponivel"/>
            <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Acao_marketing"/>
          </td>
        </tr>
      </table>

      <!--
        <table class="itemTable" style="width:99%;" > <tr class="itemTr"> <td class="formLabel"> <span class="spamFormLabel"> Valor Utilizado </span> </td> <td class="formField"> <html:text property="valor_utilizado" styleId="valor_utilizado" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("valor_utilizado_marketing") %>"/> </td> </tr> <tr class="itemTr"> <td class="formLabel"> <span class="spamFormLabel"> Valor Disponível </span> </td> <td class="formField"> <html:text property="valor_disponivel" styleId="valor_disponivel" style="text-align:right;" styleClass="disabled" tabindex="-1" readonly="true" value="<%= (String)session.getAttribute("valor_disponivel_marketing") %>"/> </td> </tr> </table>
      -->

      <table class="buttonTable" style='width:99%;'>
        <tr class="buttonTr">
          <td class="buttonTd">
            <html:button accesskey="p" value="Ações cooperadas no período informado" onclick="wopen('../com/FichaCliente_imForm.jsp','_blank',1000,600)" styleClass="baseButton" property="ver_acoes_action">
            </html:button>
          </td>
        </tr>
      </table>

    </html:form>
    <html:form action="com/FichaCliente_dForm.do" method="post" styleClass="baseForm">

      <!--
        <table class="messageTable" style='width:99%;'> <tr class="messageTr" > <td class="messageTd"> <div style=font-size:11px;font-weight:normal;> </div> <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_2"/> </td> </tr> </table>
      -->

      <table class="buttonTable" style='width:99%;'>
        <tr class="buttonTr">
          <td class="buttonTd">
            <html:submit accesskey="a" styleClass="baseButton" property="back_action">
              <bean:message bundle="ApplicationResources" key="jsp.back"/>
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
