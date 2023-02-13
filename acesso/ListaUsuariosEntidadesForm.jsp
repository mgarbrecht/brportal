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
                  if(!user.isSuperUsuario()){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <table id="TRbl_report_Jw_usuarios" class="reportTable" style=width:99%;  border=1  frame=box>
              <%
              int counterbl_report_Jw_usuarios=0;
              {
                portalbr.dbobj.view.Jw_usuarios t_jw_usuarios = new portalbr.dbobj.view.Jw_usuarios();
                java.util.Vector res_Jw_usuarios = (java.util.Vector)session.getAttribute("res_Jw_usuarios");
                if (res_Jw_usuarios!=null && res_Jw_usuarios.size()>0) {
                  java.lang.Integer usua_id       =  null;
                  java.lang.String usua_usuario   =  null;
                  java.lang.String usua_nome      =  null;
                  java.lang.String tien_tipo      =  null;
                  java.lang.Integer usua_enne_id  =  null;
                  java.lang.Integer dias_consulta_retroativa =  null;
                  java.lang.String situacao       =  null;
                  java.lang.String usua_super     =  null;
                  java.lang.String enne_descricao =  null;
                  java.lang.String super_usuario  =  null;
                  java.lang.String chamador       =  null;
                  java.lang.String parametro_dia  =  null;
                  int i_bl_report_Jw_usuarios = 0;

                  t_jw_usuarios  = (portalbr.dbobj.view.Jw_usuarios)res_Jw_usuarios.elementAt(i_bl_report_Jw_usuarios);
                  usua_id        = t_jw_usuarios.getUsua_id();
                  usua_usuario   = t_jw_usuarios.getUsua_usuario()==null?"":t_jw_usuarios.getUsua_usuario();
                  usua_nome      = t_jw_usuarios.getUsua_nome()==null?"":t_jw_usuarios.getUsua_nome();
                  tien_tipo      = t_jw_usuarios.getTien_tipo()==null?"":t_jw_usuarios.getTien_tipo();
                  usua_enne_id   = t_jw_usuarios.getUsua_enne_id();
                  dias_consulta_retroativa = t_jw_usuarios.getDias_consulta_retroativa();
                  usua_super     = t_jw_usuarios.getUsua_super()==null?"":t_jw_usuarios.getUsua_super();
                  situacao       = t_jw_usuarios.getSituacao()==null?"":t_jw_usuarios.getSituacao();
                  enne_descricao = t_jw_usuarios.getEnne_descricao()==null?"":t_jw_usuarios.getEnne_descricao();
                  super_usuario  = "";
                  if(dias_consulta_retroativa==null){
                    parametro_dia = "";
                  }else {
                    parametro_dia = dias_consulta_retroativa+"";
                  }

                  if(usua_super.equals("S")){
                    super_usuario="<img border=0 src=../img/cancel.gif>";
                    };
                    chamador = ""; chamador="/acesso/ListaUsuariosEntidadesForm.jsp";;
                    %>
                    <tr class="reportHeader" >
                      <td class="columnTdHeader" style="text-align:left;">
                        Usuário
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        Nome
                      </td>
                      <td class="columnTdHeader" style="text-align:left;">
                        Tipo
                      </td>
                      <td class="columnTdHeader" style="text-align:center;">
                        Super
                      </td>
                    </tr>
                    <%
                    while (i_bl_report_Jw_usuarios<res_Jw_usuarios.size()){
                      counterbl_report_Jw_usuarios++;
                      String style="";
                      if (!((i_bl_report_Jw_usuarios%2)!=0)) {
                        style="rowColor";
                      } else {
                        style="rowBlank";
                      }
                      %>
                      <tr class=<%= style %> id='TRbl_report_Jw_usuarios<%=counterbl_report_Jw_usuarios%>' >
                        <td class="reportColumn" style="text-align:left;">
                          <a href="../acesso/Usuarios_aForm.do?pop_action=&pos=<%=i_bl_report_Jw_usuarios %>&usua_id=<%= usua_id %>&usua_usuario=<%= usua_usuario %>&usua_nome=<%= usua_nome %>&usua_enne_id=<%= usua_enne_id %>&usua_super=<%= usua_super %>&enne_descricao=<%= enne_descricao %>&chamador=<%= chamador %>&dias_consulta_retroativa=<%= parametro_dia %>&situacao=<%= situacao %>" target="_self" STYLE="cursor:hand" onclick="bloqueia();">
                            <%= usua_usuario %>
                          </a>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= usua_nome %>
                        </td>
                        <td class="reportColumn" style="text-align:left;">
                          <%= tien_tipo %>
                        </td>
                        <td class="reportColumn" style="text-align:center;">
                          <%= super_usuario %>
                        </td>
                      </tr>
                      <%
                      if (++i_bl_report_Jw_usuarios >= res_Jw_usuarios.size()) {
                        break;
                      }
                      t_jw_usuarios  = (portalbr.dbobj.view.Jw_usuarios)res_Jw_usuarios.elementAt(i_bl_report_Jw_usuarios);
                      usua_id        = t_jw_usuarios.getUsua_id();
                      usua_usuario   = t_jw_usuarios.getUsua_usuario()==null?"":t_jw_usuarios.getUsua_usuario();
                      usua_nome      = t_jw_usuarios.getUsua_nome()==null?"":t_jw_usuarios.getUsua_nome();
                      tien_tipo      = t_jw_usuarios.getTien_tipo()==null?"":t_jw_usuarios.getTien_tipo();
                      usua_enne_id   = t_jw_usuarios.getUsua_enne_id();
                      situacao       = t_jw_usuarios.getSituacao()==null?"":t_jw_usuarios.getSituacao();
                      dias_consulta_retroativa = t_jw_usuarios.getDias_consulta_retroativa();
                      usua_super     = t_jw_usuarios.getUsua_super()==null?"":t_jw_usuarios.getUsua_super();
                      enne_descricao = t_jw_usuarios.getEnne_descricao()==null?"":t_jw_usuarios.getEnne_descricao();
                      super_usuario  = "";
                      if(dias_consulta_retroativa==null){
                        parametro_dia = "";
                      }else {
                        parametro_dia = dias_consulta_retroativa+"";
                      }
                      if(usua_super.equals("S")){
                        super_usuario="<img border=0 src=../img/cancel.gif>";
                        };
                        chamador = ""; chamador="/acesso/ListaUsuariosEntidadesForm.jsp";;
                      }
                    }
                  }
                  %>
                </table>
                <html:form action="acesso/ListaUsuariosEntidadesForm.do" method="post" styleClass="baseForm">
                  <table class="itemTable"  style=" width:;">
                    <html:hidden property="usua_enne_id"/>
                    <html:hidden property="enne_id"/>
                    <table class="buttonTable" style='width:99%;'>
                      <tr class="buttonTr">
                        <td class="buttonTd">
                          <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                            <bean:message bundle="ApplicationResources" key="jsp.select"/>
                          </html:submit>
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
