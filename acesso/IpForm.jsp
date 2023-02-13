<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
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
              </td>

            </tr>

          </table>

          <%
          {
            %>

            <%
            java.util.Vector res_Jw_log_acessos_usuarios = null;
            com.egen.util.jdbc.JdbcUtil j = null;
            try {
              j = new com.egen.util.jdbc.JdbcUtil();
              portalbr.dbobj.view.Jw_log_acessos_usuarios t_jw_log_acessos_usuarios = new portalbr.dbobj.view.Jw_log_acessos_usuarios();
              String[][] select = {{"TIEN_ID",null},{"TIEN_TIPO",null},{"ENNE_ID",null},{"ENNE_DESCRICAO",null},{"USUA_ID",null},{"USUA_USUARIO",null},{"USUA_NOME",null},{"SITUACAO",null},{"DATA_ACESSO",null},{"IP",null},};
              Object[][] where = null;
              String[] groupby =  null;
              String[] having =  null;
              String[] order = {"tien_tipo","data_acesso desc"};
              res_Jw_log_acessos_usuarios = j.select(t_jw_log_acessos_usuarios,select,where,groupby,having,order);
            } catch (Exception e){
              session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
              %>
              <jsp:forward page="/system/ErrorPage.jsp"/>
              <%
            } finally {
            if(j!=null){j.close();}
          }
          %>

          <form  name="bl_report_Jw_log_acessos_usuarios" id="bl_report_Jw_log_acessos_usuarios" class="baseForm" method="post" >
            <table class="bannerTable" style="width:99%;">
              <tr class="bannerTr">
                <td class="bannerTd">
                  Acessos
                </td>
              </tr>
            </table>

            <%
            if (res_Jw_log_acessos_usuarios!=null && res_Jw_log_acessos_usuarios.size()>0) {
              %>

              <table id="TRbl_report_Jw_log_acessos_usuarios"  class="reportTable"   style="width:99%; "  border="1" >
                <%
                int tIEN_ID =  0;
                java.lang.String tIEN_TIPO =  null;
                int eNNE_ID =  0;
                java.lang.String eNNE_DESCRICAO =  null;
                int uSUA_ID =  0;
                java.lang.String uSUA_USUARIO =  null;
                java.lang.String uSUA_NOME =  null;
                java.lang.String sITUACAO =  null;
                java.sql.Timestamp dATA_ACESSO =  null;
                java.lang.String iP =  null;
                java.lang.String localizacao =  null;
                String _b0_control = "__";
                int i_bl_report_Jw_log_acessos_usuarios = 0;
                while (i_bl_report_Jw_log_acessos_usuarios<res_Jw_log_acessos_usuarios.size()) {
                  portalbr.dbobj.view.Jw_log_acessos_usuarios t_jw_log_acessos_usuarios = (portalbr.dbobj.view.Jw_log_acessos_usuarios)res_Jw_log_acessos_usuarios.elementAt(i_bl_report_Jw_log_acessos_usuarios);
                  tIEN_ID = t_jw_log_acessos_usuarios.getTien_id();
                  tIEN_TIPO = t_jw_log_acessos_usuarios.getTien_tipo()==null?"":t_jw_log_acessos_usuarios.getTien_tipo();
                  eNNE_ID = t_jw_log_acessos_usuarios.getEnne_id();
                  eNNE_DESCRICAO = t_jw_log_acessos_usuarios.getEnne_descricao()==null?"":t_jw_log_acessos_usuarios.getEnne_descricao();
                  uSUA_ID = t_jw_log_acessos_usuarios.getUsua_id();
                  uSUA_USUARIO = t_jw_log_acessos_usuarios.getUsua_usuario()==null?"":t_jw_log_acessos_usuarios.getUsua_usuario();
                  uSUA_NOME = t_jw_log_acessos_usuarios.getUsua_nome()==null?"":t_jw_log_acessos_usuarios.getUsua_nome();
                  sITUACAO = t_jw_log_acessos_usuarios.getSituacao()==null?"":t_jw_log_acessos_usuarios.getSituacao();
                  dATA_ACESSO = (java.sql.Timestamp)t_jw_log_acessos_usuarios.getData_acesso();
                  iP = t_jw_log_acessos_usuarios.getIp()==null?"":t_jw_log_acessos_usuarios.getIp();
                  String _b0_value = com.egen.util.text.FormatNumber.format(tIEN_ID);
                  if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                    %>
                    <tr class="reportHeader">
                      <td colspan="9">
                        <span class="columnTdHeader" style="text-align:left;" >
                          Tipo
                        </span>
                        <span class="reportColumn" style="text-align:left;" >
                          <%= tIEN_TIPO %>
                        </span>
                      </td>
                    </tr>
                    <%
                    %>

                    <tr class="reportTr">
                      <td class="columnTdHeader" style="text-align:left;" >
                        Usuario
                      </td>

                      <td class="columnTdHeader" style="text-align:left;" >
                        Nome
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Situacao
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Data de Acesso
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        IP
                      </td>

                      <td class="columnTdHeader" style="text-align:center;" >
                        Localizacao
                      </td>

                    </tr>

                    <%
                  }
                  String style_bl_report_Jw_log_acessos_usuarios="";
                  if (!((i_bl_report_Jw_log_acessos_usuarios%2)!=0)) {
                    style_bl_report_Jw_log_acessos_usuarios="rowColor";
                  } else {
                    style_bl_report_Jw_log_acessos_usuarios="rowBlank";
                  }
                  %>

                  <tr class='<%= style_bl_report_Jw_log_acessos_usuarios %>' id="TRbl_report_Jw_log_acessos_usuarios<%=i_bl_report_Jw_log_acessos_usuarios%>" >
                    <td class="reportColumn" style="text-align:left;" >
                      <%= uSUA_USUARIO %>
                    </td>

                    <td class="reportColumn" style="text-align:left;" >
                      <%= uSUA_NOME %>
                    </td>

                    <td class="reportColumn" style="text-align:center;" >
                      <%= sITUACAO %>
                    </td>

                    <td class="reportColumn" style="text-align:center;" >
                      <%= com.egen.util.text.FormatDate.format(dATA_ACESSO, "dd/MM/yyyy HH:mm:ss") %>
                    </td>

                    <td class="reportColumn" style="text-align:center;width:1%;" >
                      <%= iP %>
                    </td>

                    <td class="reportColumn" style="text-align:center;width:1%" >
                      <img src="../img/viewmag.png" style="cursor:hand" name="imagem" onmouseover="this.src='../img/viewmag_s.png'" onmouseout="this.src='../img/viewmag.png'" onclick="wopen('../acesso/Ip2Form.do?select_action=&ip=<%= iP %>','_blank',640,300)">
                    </td>

                  </tr>

                  <%
                  _b0_control = _b0_value;
                  i_bl_report_Jw_log_acessos_usuarios++;
                  if (i_bl_report_Jw_log_acessos_usuarios<res_Jw_log_acessos_usuarios.size()) {
                    t_jw_log_acessos_usuarios = (portalbr.dbobj.view.Jw_log_acessos_usuarios)res_Jw_log_acessos_usuarios.elementAt(i_bl_report_Jw_log_acessos_usuarios);
                    tIEN_ID = t_jw_log_acessos_usuarios.getTien_id();
                    tIEN_TIPO = t_jw_log_acessos_usuarios.getTien_tipo()==null?"":t_jw_log_acessos_usuarios.getTien_tipo();
                    eNNE_ID = t_jw_log_acessos_usuarios.getEnne_id();
                    eNNE_DESCRICAO = t_jw_log_acessos_usuarios.getEnne_descricao()==null?"":t_jw_log_acessos_usuarios.getEnne_descricao();
                    uSUA_ID = t_jw_log_acessos_usuarios.getUsua_id();
                    uSUA_USUARIO = t_jw_log_acessos_usuarios.getUsua_usuario()==null?"":t_jw_log_acessos_usuarios.getUsua_usuario();
                    uSUA_NOME = t_jw_log_acessos_usuarios.getUsua_nome()==null?"":t_jw_log_acessos_usuarios.getUsua_nome();
                    sITUACAO = t_jw_log_acessos_usuarios.getSituacao()==null?"":t_jw_log_acessos_usuarios.getSituacao();
                    dATA_ACESSO = (java.sql.Timestamp)t_jw_log_acessos_usuarios.getData_acesso();
                    iP = t_jw_log_acessos_usuarios.getIp()==null?"":t_jw_log_acessos_usuarios.getIp();
                    _b0_value = com.egen.util.text.FormatNumber.format(tIEN_ID);
                  } else {
                    _b0_control = "__";
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
