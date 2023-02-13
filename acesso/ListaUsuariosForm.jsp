<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Usuários
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
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(39)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            int counterbl_report_Jw_usuarios=0;
            {
              portalbr.dbobj.view.Jw_usuarios t_jw_usuarios = new portalbr.dbobj.view.Jw_usuarios();
              java.util.Vector res_Jw_usuarios = (java.util.Vector)session.getAttribute("res_Jw_usuarios");
              if (res_Jw_usuarios!=null && res_Jw_usuarios.size()>0) {
                java.lang.String usua_usuario   =  null;
                java.lang.String usua_nome      =  null;
                java.lang.String usua_email     =  null;
                java.lang.Integer usua_enne_id  =  null;
                java.lang.String tien_tipo      =  null;
                java.lang.String usua_super     =  null;
                java.lang.String super_usuario  =  null;
                java.lang.Integer usua_id       =  null;
                java.lang.String enne_descricao =  null;
                java.lang.String chamador       =  null;
                java.lang.String situacao       =  null;
                java.lang.String parametro_dia  =  null;
                java.lang.Integer dias_consulta_retroativa  =  null;
                java.lang.String usua_expira_senha = null;
                java.sql.Timestamp dthr_inclusao =  null;
                java.sql.Timestamp dthr_alteracao =  null;
                java.lang.String usuario_inclusao =  null;
                java.lang.String usuario_alteracao =  null;

                int i_bl_report_Jw_usuarios     = 0;
                t_jw_usuarios  = (portalbr.dbobj.view.Jw_usuarios)res_Jw_usuarios.elementAt(i_bl_report_Jw_usuarios);
                usua_usuario   = t_jw_usuarios.getUsua_usuario()==null?"":t_jw_usuarios.getUsua_usuario();
                usua_nome      = t_jw_usuarios.getUsua_nome()==null?"":t_jw_usuarios.getUsua_nome();
                usua_email     = t_jw_usuarios.getUsua_email()==null?"":t_jw_usuarios.getUsua_email();
                usua_enne_id   = t_jw_usuarios.getUsua_enne_id();
                tien_tipo      = t_jw_usuarios.getTien_tipo()==null?"":t_jw_usuarios.getTien_tipo();
                usua_super     = t_jw_usuarios.getUsua_super()==null?"":t_jw_usuarios.getUsua_super();
                usua_id        = t_jw_usuarios.getUsua_id();
                dias_consulta_retroativa = t_jw_usuarios.getDias_consulta_retroativa();
                enne_descricao = t_jw_usuarios.getEnne_descricao()==null?"":t_jw_usuarios.getEnne_descricao();
                situacao       = t_jw_usuarios.getSituacao()==null?"":t_jw_usuarios.getSituacao();
                usua_expira_senha = t_jw_usuarios.getUsua_expira_senha()==null?"":t_jw_usuarios.getUsua_expira_senha();
                dthr_inclusao = (java.sql.Timestamp)t_jw_usuarios.getDthr_inclusao();
                dthr_alteracao = (java.sql.Timestamp)t_jw_usuarios.getDthr_alteracao();
                usuario_inclusao = t_jw_usuarios.getUsuario_inclusao()==null?"":t_jw_usuarios.getUsuario_inclusao();
                usuario_alteracao = t_jw_usuarios.getUsuario_alteracao()==null?"":t_jw_usuarios.getUsuario_alteracao();
                super_usuario  = "";
                if(dias_consulta_retroativa==null){
                  parametro_dia = "";
                }else {
                  parametro_dia = dias_consulta_retroativa+"";
                }
                if(usua_super.equals("S")){
                  super_usuario="<img border=0 src=../img/cancel.gif>";
                  };

                  chamador = ""; chamador="/acesso/ListaUsuariosForm.jsp";;
                  java.lang.String b0_tien_tipo =  null;
                  while (i_bl_report_Jw_usuarios<res_Jw_usuarios.size()){
                    counterbl_report_Jw_usuarios++;
                    %>
                    <table id="TRbl_report_Jw_usuarios" class="reportTable" style=width:99%;  border=1  frame=box>
                      <tr class="reportHeader2">
                        <td colspan=3>
                          <big>
                            Tipo :
                            <%= tien_tipo %>
                          </big>
                        </td>
                      </tr>
                      <%
                      b0_tien_tipo = tien_tipo;
                      %>
                      <tr class="reportHeader" >
                        <td class="columnTdHeader" style="text-align:left;" width="20%">
                          Usuários
                        </td>
                        <td class="columnTdHeader" style="text-align:left;" width="65%">
                          Nome
                        </td>
                        <td class="columnTdHeader" style="text-align:center;" width="15%">
                          Super
                        </td>
                      </tr>
                      <%
                      while (i_bl_report_Jw_usuarios<res_Jw_usuarios.size() &&  (b0_tien_tipo==null?"":b0_tien_tipo).equals((tien_tipo==null?"":tien_tipo))){
                        counterbl_report_Jw_usuarios++;
                        String style="";
                        if (!((i_bl_report_Jw_usuarios%2)!=0)) {
                          style="rowColor";
                        } else {
                          style="rowBlank";
                        }
                        %>
                        <tr class='<%= style %>' id='TRbl_report_Jw_usuarios<%=counterbl_report_Jw_usuarios%>' >
                          <td class="reportColumn" style="text-align:left;" width="20%">
                            <a href="../acesso/Usuarios_aForm.do?pop_action=&pos=<%=i_bl_report_Jw_usuarios %>&usua_usuario=<%= usua_usuario %>&usua_nome=<%= usua_nome %>&usua_enne_id=<%= usua_enne_id %>&usua_super=<%= usua_super %>&usua_id=<%= usua_id %>&enne_descricao=<%= enne_descricao %>&chamador=<%= chamador %>&situacao=<%= situacao %>&dias_consulta_retroativa=<%= parametro_dia %>&usua_expira_senha=<%= usua_expira_senha %>&usua_email=<%= usua_email %>&usuario_inclusao=<%= usuario_inclusao%>&usuario_alteracao=<%= usuario_alteracao%>&dthr_inclusao=<%= com.egen.util.text.FormatDate.format(dthr_inclusao, "dd/MM/yyyy HH:mm:ss") %>&dthr_alteracao=<%= com.egen.util.text.FormatDate.format(dthr_alteracao, "dd/MM/yyyy HH:mm:ss") %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                              <%= usua_usuario %>
                            </a>
                          </td>
                          <td class="reportColumn" style="text-align:left;" width="65%">
                            <%= usua_nome %>
                          </td>
                          <td class="reportColumn" style="text-align:center;" width="15%">
                            <%= super_usuario %>
                          </td>
                        </tr>
                        <%
                        if (++i_bl_report_Jw_usuarios >= res_Jw_usuarios.size()) {
                          break;
                        }
                        t_jw_usuarios  = (portalbr.dbobj.view.Jw_usuarios)res_Jw_usuarios.elementAt(i_bl_report_Jw_usuarios);
                        usua_usuario   = t_jw_usuarios.getUsua_usuario()==null?"":t_jw_usuarios.getUsua_usuario();
                        usua_nome      = t_jw_usuarios.getUsua_nome()==null?"":t_jw_usuarios.getUsua_nome();
                        usua_email     = t_jw_usuarios.getUsua_email()==null?"":t_jw_usuarios.getUsua_email();
                        usua_enne_id   = t_jw_usuarios.getUsua_enne_id();
                        tien_tipo      = t_jw_usuarios.getTien_tipo()==null?"":t_jw_usuarios.getTien_tipo();
                        usua_super     = t_jw_usuarios.getUsua_super()==null?"":t_jw_usuarios.getUsua_super();
                        usua_id        = t_jw_usuarios.getUsua_id();
                        dias_consulta_retroativa = t_jw_usuarios.getDias_consulta_retroativa();
                        situacao       = t_jw_usuarios.getSituacao()==null?"":t_jw_usuarios.getSituacao();
                        enne_descricao = t_jw_usuarios.getEnne_descricao()==null?"":t_jw_usuarios.getEnne_descricao();
                        usua_expira_senha = t_jw_usuarios.getUsua_expira_senha()==null?"":t_jw_usuarios.getUsua_expira_senha();
                        dthr_inclusao = (java.sql.Timestamp)t_jw_usuarios.getDthr_inclusao();
                        dthr_alteracao = (java.sql.Timestamp)t_jw_usuarios.getDthr_alteracao();
                        usuario_inclusao = t_jw_usuarios.getUsuario_inclusao()==null?"":t_jw_usuarios.getUsuario_inclusao();
                        usuario_alteracao = t_jw_usuarios.getUsuario_alteracao()==null?"":t_jw_usuarios.getUsuario_alteracao();
                        super_usuario  = "";
                        if(dias_consulta_retroativa==null){
                          parametro_dia = "";
                        }else {
                          parametro_dia = dias_consulta_retroativa+"";
                        }
                        if(usua_super.equals("S")){
                          super_usuario="<img border=0 src=../img/cancel.gif>";
                          };
                          chamador = ""; chamador="/acesso/ListaUsuariosForm.jsp";;
                        }
                        %>
                      </table>
                      <br>
                      <%
                    }
                  }
                }
                %>
              </table>
              <html:form action="acesso/ListaUsuariosForm.do" method="post" styleClass="baseForm">
                <table class="buttonTable" style='width:;'>
                  <tr class="buttonTr">
                    <td class="buttonTd">
                      <html:submit accesskey="b" styleClass="baseButton" property="back_action">
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
