<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Acompanhamento da prospecção de novos clientes.
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
                  if(!user.isSuperUsuario() && !user.isAutorizado(195)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <%
            String regional = "";
            acesso.Sessao sessao = new acesso.Sessao(session);
            if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
              regional = sessao.getChave();
            }
            %>



            <%
            {
              %>

              <%
              java.util.Vector res_Jw_kanban_clientes_novos = null;
              com.egen.util.jdbc.JdbcUtil j = null;
              try {
                j = new com.egen.util.jdbc.JdbcUtil();
                portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = new portalbr.dbobj.view.Jw_kanban_clientes_novos();
                String[][] select = {{"cnpj",null},{"codigo_regional",null},{"sigla_regional",null},{"situacao",null},};
                Object[][] where = null;
                where = new Object[][]{{"situacao","=","VERDE"},{"codigo_regional","=",regional}};
                String[] groupby =  null;
                String[] having =  null;
                String[] order =  null;
                res_Jw_kanban_clientes_novos = j.select(t_jw_kanban_clientes_novos,select,where,groupby,having,order);
              } catch (Exception e){
                session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                %>
                <jsp:forward page="/system/ErrorPage.jsp"/>
                <%
              } finally {
              if(j!=null){j.close();}
            }
            %>

            <form  name="bl_report_Jw_kanban_clientes_novos" id="bl_report_Jw_kanban_clientes_novos" class="baseForm" method="post" >
              <table class="positionTable"  width="100%"  >
                <tr class="positionTr">
                  <td class="positionTd">
                    <%
                    if (res_Jw_kanban_clientes_novos!=null && res_Jw_kanban_clientes_novos.size()>0) {
                      %>

                      <table id="TRbl_report_Jw_kanban_clientes_novos"  style="background-color:green"  width="100%"  >
                        <%
                        java.lang.String cnpj =  null;
                        java.lang.Integer codigo_regional =  null;
                        java.lang.String sigla_regional =  null;
                        java.lang.String situacao =  null;
                        %>

                        <tr>
                          <td style="text-align:center">
                            <b>
                              Total de Clientes:
                              <%= res_Jw_kanban_clientes_novos.size() %>
                            </b>
                          </td>


                          <!--
                            <td style="text-align:center"> <center> <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; "> <div style="font-family: Comic Sans MS;font-weight:bold;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; "> <br>CNPJ: 12345678901234 <br>Regional: 1 </div> </div> </center> </td>
                          -->

                        </tr>

                        <%
                        int i_bl_report_Jw_kanban_clientes_novos = 0;
                        while (i_bl_report_Jw_kanban_clientes_novos<res_Jw_kanban_clientes_novos.size()) {
                          portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos);
                          cnpj = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                          codigo_regional = t_jw_kanban_clientes_novos.getCodigo_regional();
                          sigla_regional = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                          situacao = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
                          String style_bl_report_Jw_kanban_clientes_novos="";
                          if (!((i_bl_report_Jw_kanban_clientes_novos%2)!=0)) {
                            style_bl_report_Jw_kanban_clientes_novos="rowColor";
                          } else {
                            style_bl_report_Jw_kanban_clientes_novos="rowBlank";
                          }
                          %>

                          <tr >

                            <td style="text-align:center">
                              <center>
                                <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; ">
                                  <div style="font-family: Comic Sans MS;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; ">
                                    <big>
                                      <br>
                                      CNPJ:
                                      <%= cnpj %>
                                      <br>
                                      Regional:
                                      <%= sigla_regional %>
                                    </big>
                                  </div>
                                </div>
                              </center>
                            </td>


                          </tr>

                          <%
                          i_bl_report_Jw_kanban_clientes_novos++;
                          if (i_bl_report_Jw_kanban_clientes_novos<res_Jw_kanban_clientes_novos.size()) {
                            t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos);
                            cnpj = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                            codigo_regional = t_jw_kanban_clientes_novos.getCodigo_regional();
                            sigla_regional = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                            situacao = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
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

                <script type="text/JavaScript">
                  <!--
                  function timedRefresh(timeoutPeriod) {
                    //	setTimeout("top.location= '../com/MovimentacoesDiaForm.jsp';",timeoutPeriod);

                  }
                  //   -->
                </script>
                <%
                {
                  %>

                  <%
                  java.util.Vector res_Jw_kanban_clientes_novos = null;
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = new portalbr.dbobj.view.Jw_kanban_clientes_novos();
                    String[][] select = {{"cnpj",null},{"codigo_regional",null},{"sigla_regional",null},{"situacao",null},};
                    Object[][] where = null;
                    where = new Object[][]{{"situacao","=","AMARELO"},{"codigo_regional","=",regional}};
                    String[] groupby =  null;
                    String[] having =  null;
                    String[] order =  null;
                    res_Jw_kanban_clientes_novos = j.select(t_jw_kanban_clientes_novos,select,where,groupby,having,order);
                  } catch (Exception e){
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                    %>
                    <jsp:forward page="/system/ErrorPage.jsp"/>
                    <%
                  } finally {
                  if(j!=null){j.close();}
                }
                %>

                <form  name="bl_report_Jw_kanban_clientes_novos_1" id="bl_report_Jw_kanban_clientes_novos_1" class="baseForm" method="post" >
                </td>
                <td class="positionTd">
                  <%
                  if (res_Jw_kanban_clientes_novos!=null && res_Jw_kanban_clientes_novos.size()>0) {
                    %>

                    <table id="TRbl_report_Jw_kanban_clientes_novos_1"  style="background-color:yellow"  width="100%"  >
                      <%
                      java.lang.String cnpj1 =  null;
                      java.lang.Integer codigo_regional1 =  null;
                      java.lang.String sigla_regional1 =  null;
                      java.lang.String situacao1 =  null;
                      %>

                      <tr>
                        <td style="text-align:center">
                          <b>
                            Total de Clientes:
                            <%= res_Jw_kanban_clientes_novos.size() %>
                          </b>
                        </td>

                        <!--
                          <td style="text-align:center"> <center> <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; "> <div style="font-family: Comic Sans MS;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; "> <br>CNPJ: <%= cnpj1 %> <br>Regional: <%= sigla_regional1 %> </div> </div> </center> </td>
                        -->

                      </tr>

                      <%
                      int i_bl_report_Jw_kanban_clientes_novos_1 = 0;
                      while (i_bl_report_Jw_kanban_clientes_novos_1<res_Jw_kanban_clientes_novos.size()) {
                        portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos_1);
                        cnpj1 = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                        codigo_regional1 = t_jw_kanban_clientes_novos.getCodigo_regional();
                        sigla_regional1 = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                        situacao1 = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
                        String style_bl_report_Jw_kanban_clientes_novos_1="";
                        if (!((i_bl_report_Jw_kanban_clientes_novos_1%2)!=0)) {
                          style_bl_report_Jw_kanban_clientes_novos_1="rowColor";
                        } else {
                          style_bl_report_Jw_kanban_clientes_novos_1="rowBlank";
                        }
                        %>

                        <tr  >

                          <td style="text-align:center">
                            <center>
                              <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; ">
                                <div style="font-family: Comic Sans MS;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; ">
                                  <big>
                                    <br>
                                    CNPJ:
                                    <%= cnpj1 %>
                                    <br>
                                    Regional:
                                    <%= sigla_regional1 %>
                                  </big>
                                </div>
                              </div>
                            </center>
                          </td>

                        </tr>

                        <%
                        i_bl_report_Jw_kanban_clientes_novos_1++;
                        if (i_bl_report_Jw_kanban_clientes_novos_1<res_Jw_kanban_clientes_novos.size()) {
                          t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos_1);
                          cnpj1 = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                          codigo_regional1 = t_jw_kanban_clientes_novos.getCodigo_regional();
                          sigla_regional1 = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                          situacao1 = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
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
              {
                %>

                <%
                java.util.Vector res_Jw_kanban_clientes_novos = null;
                com.egen.util.jdbc.JdbcUtil j = null;
                try {
                  j = new com.egen.util.jdbc.JdbcUtil();
                  portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = new portalbr.dbobj.view.Jw_kanban_clientes_novos();
                  String[][] select = {{"cnpj",null},{"codigo_regional",null},{"sigla_regional",null},{"situacao",null},};
                  Object[][] where = null;
                  where = new Object[][]{{"situacao","=","VERMELHO"},{"codigo_regional","=",regional}};
                  String[] groupby =  null;
                  String[] having =  null;
                  String[] order =  null;
                  res_Jw_kanban_clientes_novos = j.select(t_jw_kanban_clientes_novos,select,where,groupby,having,order);
                } catch (Exception e){
                  session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                  %>
                  <jsp:forward page="/system/ErrorPage.jsp"/>
                  <%
                } finally {
                if(j!=null){j.close();}
              }
              %>

              <form  name="bl_report_Jw_kanban_clientes_novos_2" id="bl_report_Jw_kanban_clientes_novos_2" class="baseForm" method="post" >
              </td>
              <td class="positionTd">
                <%
                if (res_Jw_kanban_clientes_novos!=null && res_Jw_kanban_clientes_novos.size()>0) {
                  %>

                  <table id="TRbl_report_Jw_kanban_clientes_novos_2"  style="background-color:red"  width="100%" >
                    <%
                    java.lang.String cnpj2 =  null;
                    java.lang.Integer codigo_regional2 =  null;
                    java.lang.String sigla_regional2 =  null;
                    java.lang.String situacao2 =  null;
                    %>

                    <tr >
                      <td style="text-align:center">
                        <b>
                          Total de Clientes:
                          <%= res_Jw_kanban_clientes_novos.size() %>
                        </b>
                      </td>

                      <!--
                        <td style="text-align:center"> <center> <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; "> <div style="font-family: Comic Sans MS;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; "> <br>CNPJ: <%= cnpj2 %> <br>Regional: <%= sigla_regional2 %> </div> </div> </center> </td>
                      -->

                    </tr>

                    <%
                    int i_bl_report_Jw_kanban_clientes_novos_2 = 0;
                    while (i_bl_report_Jw_kanban_clientes_novos_2<res_Jw_kanban_clientes_novos.size()) {
                      portalbr.dbobj.view.Jw_kanban_clientes_novos t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos_2);
                      cnpj2 = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                      codigo_regional2 = t_jw_kanban_clientes_novos.getCodigo_regional();
                      sigla_regional2 = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                      situacao2 = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
                      String style_bl_report_Jw_kanban_clientes_novos_2="";
                      if (!((i_bl_report_Jw_kanban_clientes_novos_2%2)!=0)) {
                        style_bl_report_Jw_kanban_clientes_novos_2="rowColor";
                      } else {
                        style_bl_report_Jw_kanban_clientes_novos_2="rowBlank";
                      }
                      %>

                      <tr  >

                        <td style="text-align:center">
                          <center>
                            <div style="background-image: url(../img/sticky.png); height: 90px; width: 200px; border: 0px solid black; ">
                              <div style="font-family: Comic Sans MS;height: 80px; width: 190px; border: 0px solid black; margin-left:10px; margin-right:10px; margin-top:10px; ">
                                <big>
                                  <br>
                                  CNPJ:
                                  <%= cnpj2 %>
                                  <br>
                                  Regional:
                                  <%= sigla_regional2 %>
                                </big>
                              </div>
                            </div>
                          </center>
                        </td>

                      </tr>

                      <%
                      i_bl_report_Jw_kanban_clientes_novos_2++;
                      if (i_bl_report_Jw_kanban_clientes_novos_2<res_Jw_kanban_clientes_novos.size()) {
                        t_jw_kanban_clientes_novos = (portalbr.dbobj.view.Jw_kanban_clientes_novos)res_Jw_kanban_clientes_novos.elementAt(i_bl_report_Jw_kanban_clientes_novos_2);
                        cnpj2 = t_jw_kanban_clientes_novos.getCnpj()==null?"":t_jw_kanban_clientes_novos.getCnpj();
                        codigo_regional2 = t_jw_kanban_clientes_novos.getCodigo_regional();
                        sigla_regional2 = t_jw_kanban_clientes_novos.getSigla_regional()==null?"":t_jw_kanban_clientes_novos.getSigla_regional();
                        situacao2 = t_jw_kanban_clientes_novos.getSituacao()==null?"":t_jw_kanban_clientes_novos.getSituacao();
                      } else {
                      }
                    }
                    %>

                  </table>

                  <%
                }
                %>

              </td>

            </tr>

          </table>

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
