<%@ include file="../system/HeaderStrutsForm.jsp"%>

<%@ page extends='acesso.web.HttpJspSessao' import='com.egen.util.text.FormatNumber,portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<%  boolean possuiMercadoExterno = false; %>
<%  boolean bloqGiro = false; %>
<%  boolean bloqCli = false; %>
<%  String espPrimNivel = "col-20p"; %>
<%  String estiloBotoes = ""; %>
<%  if(session.getAttribute("giroProducao")!= null) { 
       estiloBotoes = "overlay";
    }
  acesso.Sessao ses= new acesso.Sessao(session);
                  if(ses.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                     ||ses.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                    bloqCli = true;
                  }
     
%>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.scriptclean"/>
  <head>
    <title>
      Entrada Atual de Pedidos
    </title>
  </head>

<style>
* {
  box-sizing: border-box;
}

  .overlay {
      width: 100vw;
      float: left;
  }
 
.row::after {
  content: "";
  clear: both;
  display: block;
}

[class*="col-"] {
  float: left;
  padding: 3px;
}

.col-1 {width: 8.33%;}
.col-2 {width: 16.66%;}
.col-3 {width: 25%;}
.col-4 {width: 33.33%;}
.col-5 {width: 41.66%;}
.col-6 {width: 50%;}
.col-7 {width: 58.33%;}
.col-8 {width: 66.66%;}
.col-9 {width: 75%;}
.col-10 {width: 83.33%;}
.col-11 {width: 91.66%;}
.col-12 {width: 100%;}
.col-20p {width: 20%;}

</style>


  <center>
    <body>
      <table class="mainTable" style='width:99%'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(36)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="com/EntradaAtualPedidosForm.do" method="post" styleClass="baseForm">

              <script src="../script/jquery-1.7.2.min.js">
              </script>
              <script src="../script/jquery.blockUI.js">
              </script>

              <table class="itemTable"  style="width:99%;">
                <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form_Entrada_pedidos_atual_datas_vw"/>
              </table>

                  <div id="question" style="display:none; cursor: default; color: #8D0000; font-size: 14px;">
                    <img src="../img/loading.gif" />
                    <br>
                    <b>Por favor, aguarde...</b>
                  </div>

                  <%
                  boolean bloqFat = false;

                  try {
                    util.bloqueio.BloqueioUtil bloqueio = new util.bloqueio.BloqueioUtil(36, request);
                    if(bloqueio.tipoBloqueio("FATURAMENTO").equals("E")){
                       bloqFat = true;
                    }
                    if(bloqueio.tipoBloqueio("GIRO_PRODUCAO").equals("E")){
                       if(!bloqueio.possuiExcecaoByTipo("GIRO_PRODUCAO", "E")) {
                          bloqGiro = true;
                       }
                    }
                    espPrimNivel = "col-20p";

                  } catch (Exception e){
                  }

                  String tp = session.getAttribute("tipoSelecionado")!=null?(String)session.getAttribute("tipoSelecionado"):"atual";
                  String tpGiroProducao = session.getAttribute("periodoGiroProducao")!=null?(String)session.getAttribute("periodoGiroProducao"):"atual";
                  String tipoQuebra = session.getAttribute("tipoQuebra")!=null?(String)session.getAttribute("tipoQuebra"):"regional";
                  String mercado = session.getAttribute("mercado")!=null?(String)session.getAttribute("mercado"):"todos";
                  String representanteComSemVenda = session.getAttribute("entrada_pedidos_representantes_vendas_mostrar_segmentos")!=null?(String)session.getAttribute("entrada_pedidos_representantes_vendas_mostrar_segmentos"):"N";
                  %>

<center>
		  
<div class="<%= estiloBotoes %>">
<div class="row">

    <div class="<%= espPrimNivel %>">

                        <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>

                        
                          <% if(tipoQuebra.equalsIgnoreCase("marca")){
                          %>
                          <html:select property="marca_select" styleId="marca_select" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select4_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Marcas Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="MI">
                              Marcas Mercado Interno
                            </html:option>
                            <html:option styleClass="baseOption" value="ME">
                              Marcas Mercado Externo
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Marca"  property="select4_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Marca" property="select4_action"/>
                          <%
                        }
                        %>
						
		
</div>

  <div class="<%= espPrimNivel %>">

                 
                       <% if(tipoQuebra.equalsIgnoreCase("regional")){
                          %>
                          <html:select property="marca_regional" styleId="marca_regional" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select5_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Regionais Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Regionais Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Regionais Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Regionais Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Regionais Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Regionais Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Regionais Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Regionais Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Regionais Br Sport
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Regional"  property="select5_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Regional" property="select5_action"/>
                          <%
                        }
                        %>
</div>

  <div class="<%= espPrimNivel %>">

                        <%
                        if(tipoQuebra.equalsIgnoreCase("representante")){
                          %>
						  
						

                          <html:select property="representantes_vendas" styleId="representantes_vendas" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select6_action.click();">
                            <html:option styleClass="baseOption" value="S">
                              Representantes com pedidos
                            </html:option>
                            <html:option styleClass="baseOption" value="N">
                              Representantes sem pedidos
                            </html:option>
                          </html:select>

<% if(true) { %>
   <html:select property="representantes_vendas_segmentos" styleId="representantes_vendas_segmentos" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select6_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Todos Segmentos
                            </html:option>
                            <html:option styleClass="baseOption" value="C">
                              Calçados
                            </html:option>
                            <html:option styleClass="baseOption" value="B">
                              Bolsas
                            </html:option>
                            <html:option styleClass="baseOption" value="M">
                              Meias
                            </html:option>
                          </html:select>
<% } else { %>
<% } %>



                          <html:submit accesskey="p" styleClass="myhidden" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Representante"  property="select6_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Representante"  property="select6_action"/>
                          <%
                        }
                        %>

</div>
  <div class="<%= espPrimNivel %>">

                        <% if(tipoQuebra.equalsIgnoreCase("cliente") || tipoQuebra.equalsIgnoreCase("regionalCliente")){ %>
						  
                          <html:select property="marca_cliente" styleId="marca_cliente" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select7_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Clientes Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Clientes Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Clientes Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Clientes Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Clientes Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Clientes Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Clientes Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Clientes Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Clientes Br Sport
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Cliente"  property="select7_action"/>

                          <%
                        } else {
                          %>
                         <% if(bloqCli) { %>
                          <html:submit accesskey="p" disabled="<%= bloqCli %>" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="opacity: 0.5;background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Cliente"  property="select7_action" />
                         <% } else { %>
                          <html:submit accesskey="p" disabled="<%= bloqCli %>" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="opacity: <%= opacity %>; background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Cliente"  property="select7_action" />
                         <% } %>
                          <%
                        }
                        %>

                      <html:submit styleClass="myhidden" property="select12_action">
                         <bean:message bundle="ApplicationResources" key="jsp.select"/>
                      </html:submit>
                      
                          <%
                            if(tipoQuebra.equalsIgnoreCase("cliente") || tipoQuebra.equalsIgnoreCase("regionalCliente")){
                            %>
                            <html:select property="mercado" styleId="mercado" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select12_action.click();">
                            <html:option styleClass="baseOption" value="todos">
                              Todos os Mercados
                            </html:option>
                            <html:option styleClass="baseOption" value="MI">
                             Mercado Interno
                            </html:option>
                            <html:option styleClass="baseOption" value="ME">
                             Mercado Externo
                            </html:option>
                           </html:select>


                           <html:select property="regional_cliente" styleId="regional_cliente" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select_regional_cliente_action.click();">
                           <html:option styleClass="baseOption" value="T">
                              Todas as Regionais
                            </html:option>

<%
    java.util.Vector res_Me = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw_me_select");
    java.util.Vector res_Mi = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw_mi_select");

   if (res_Mi !=null && res_Mi.size()>0) { 
      int iMi = 0;
      while (iMi < res_Mi.size()) {
         portalbr.dbobj.table.Entrada_pedidos_atual_vw tMi = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Mi.elementAt(iMi);
         %>

                           <html:option styleClass="baseOption" value="<%= tMi.getCodigo_regional()+"" %>">
                              <%= tMi.getSigla_regional() %>
                            </html:option>
        <%
        iMi++;
      }
   }

   if (res_Me !=null && res_Me.size()>0) { 
      int iMe = 0;
      while (iMe < res_Me.size()) {
         portalbr.dbobj.table.Entrada_pedidos_atual_vw tMe = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Me.elementAt(iMe);
         %>

                           <html:option styleClass="baseOption" value="<%= tMe.getCodigo_regional()+"" %>">
                              <%= tMe.getSigla_regional() %>
                            </html:option>
        <%
         iMe++;
      }
   }
%>

            </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Regional"  property="select_regional_cliente_action"/>
                          <%
                          }
                          %>

</div>

<div class="<%= espPrimNivel %>">

<% if(!bloqGiro) { %>


                        <%
                        if(tipoQuebra.equalsIgnoreCase("giro_producao")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%" value="Giro" property="select_giro_producao_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%" value="Giro" property="select_giro_producao_action"/>
                          <%
                        }
                        %>

<% } else { %>

                          <html:submit accesskey="p" disabled="true" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; opacity: 0.5" value="Giro" property="select_giro_producao_action"/>

<% } %>
</div>


</div>



<div class="row">

  <div class="col-20p">


                        <%
                        if(tipoQuebra.equalsIgnoreCase("grupo")){
                          %>
                          <html:select property="marca_grupo" styleId="marca_cliente" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select9_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Grupos Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Grupos Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Grupos Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Grupos Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Grupos Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Grupos Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Grupos Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Grupos Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Grupos Br Sport
                            </html:option> 
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Grupo"  property="select9_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Grupo"  property="select9_action"/>
                          <%
                        }
                        %>
</div>

  <div class="col-20p">


                        <%
                        if(tipoQuebra.equalsIgnoreCase("estilo")){
                          %>
                           <html:select property="estilos" styleId="estilos" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select_estilos_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Estilos Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Estilos Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Estilos Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Estilos Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Estilos Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Estilos Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Estilos Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Estilos Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Estilos Br Sport
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Estilo" property="select_estilos_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Estilo"  property="select_estilos_action"/>
                          <%
                        }
                        %>	

</div>

  <div class="col-20p">


                        <%
                        if(tipoQuebra.equalsIgnoreCase("unidade")){
                          %>
                           <html:select property="unidade" styleId="unidade" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select_unidades_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Unidade de Negócio Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Unidade de Negócio Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Unidade de Negócio Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Unidade de Negócio Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Unidade de Negócio Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Unidade de Negócio Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Unidade de Negócio Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Unidade de Negócio Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Unidade de Negócio Br Sport
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Unidade" property="select_unidades_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Unidade" property="select_unidades_action"/>
                          <%
                        }
                        %>	
</div>


  <div class="col-20p">


                        <%
                        if(tipoQuebra.equalsIgnoreCase("tipoProduto")){
                          %>
                           <html:select property="tipo_produto" styleId="tipo_produto" style="font-family:verdana; font-weight: bold;background-color: #C40000; color: white; font-size:16px; height: 40px; width: 100%; text-align: center" styleClass="baseField" size="1" onchange="$.blockUI({ message: $('#question'), css: { width: '275px' } });select_tipo_produto_action.click();">
                            <html:option styleClass="baseOption" value="T">
                              Tipo de Produto Geral
                            </html:option>
                            <html:option styleClass="baseOption" value="3">
                              Tipo de Produto Beira Rio
                            </html:option>
                            <html:option styleClass="baseOption" value="1">
                              Tipo de Produto Vizzano
                            </html:option>
                            <html:option styleClass="baseOption" value="16">
                              Tipo de Produto Moleca
                            </html:option>
                            <html:option styleClass="baseOption" value="17">
                              Tipo de Produto Molekinha
                            </html:option>
                            <html:option styleClass="baseOption" value="19">
                              Tipo de Produto Molekinho
                            </html:option>
                            <html:option styleClass="baseOption" value="9">
                              Tipo de Produto Modare
                            </html:option>
                            <html:option styleClass="baseOption" value="20">
                              Tipo de Produto Actvitta
                            </html:option>
                            <html:option styleClass="baseOption" value="18">
                              Tipo de Produto Br Sport
                            </html:option>
                          </html:select>

                          <html:submit accesskey="p" styleClass="myhidden" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 160px" value="Tipo de Produto" property="select_tipo_produto_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Tipo de Produto" property="select_tipo_produto_action"/>
                          <%
                        }
                        %>	
</div>




  <div class="col-20p">

                        <%
                        if(!bloqFat) {
                          %>
                          <%
                          if(tipoQuebra.equalsIgnoreCase("faturamento")){
                            %>
                            <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Faturamento"  property="select8_action"/>
                            <%
                          } else {
                            %>
                            <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Faturamento"  property="select8_action"/>
                            <%
                          }
                          %>
                          <%
                        } else {

%>
                            <html:submit accesskey="p" disabled="true" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="opacity: 0.5; background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Faturamento"  property="select8_action"/>
<%


}
                        %>

                      </div></div>

<div class="row">


<% if(tipoQuebra.equalsIgnoreCase("giro_producao")) { %>


  <div class="col-6">

                        <%
                        if(tpGiroProducao.equalsIgnoreCase("anterior")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês Anterior" property="select_giro_producao_anterior_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês Anterior"  property="select_giro_producao_anterior_action"/>
                          <%
                        }
                        %>
                        
</div>

  <div class="col-6">

                        <%
                        if(tpGiroProducao.equalsIgnoreCase("atual")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês Atual" property="select_giro_producao_atual_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês Atual"  property="select_giro_producao_atual_action"/>
                          <%
                        }
                        %>
                        
</div>


<% } else { %>

  <div class="col-3">
                        <html:submit accesskey="p" styleClass="myhidden" property="select_action">
                          <bean:message bundle="ApplicationResources" key="jsp.select"/>
                        </html:submit>
                        <%
                        if(tp.equalsIgnoreCase("anterior")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Dia Anterior"  property="select1_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Dia Anterior"  property="select1_action"/>
                          <%
                        }
                        %>

</div>

  <div class="col-3">

                        <%
                        if(tp.equalsIgnoreCase("atual")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Dia Atual" property="select2_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Dia Atual" property="select2_action"/>
                          <%
                        }
                        %>
</div>
  <div class="col-3">

                        <%
                        if(tp.equalsIgnoreCase("semana_atual")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Semana Atual" property="select_semana_atual_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Semana Atual"  property="select_semana_atual_action"/>
                          <%
                        }
                        %>
</div>
  <div class="col-3">

                        <%
                        if(tp.equalsIgnoreCase("mes")){
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: #C40000; color: white;font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês/Ano" property="select3_action"/>
                          <%
                        } else {
                          %>
                          <html:submit accesskey="p" onclick="$.blockUI({ message: $('#question'), css: { width: '275px' } });" style="background-color: gray; color: white; font-family:verdana;font-size:16px; border-color: black;font-weight: bold; height:40px; width: 100%; text-align: center" value="Mês/Ano"  property="select3_action"/>
                          <%
                        }
                        %>
                        
</div>
<% } %>

</div>
</div>
                  
				  </center>
                  <br>

                </html:form>

                <%
                boolean mostrarGeral = true;
                if(session.getAttribute("tipoQuebra")!=null && (!((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("faturamento"))
&& (!((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("giro_producao"))
 ){
                  boolean quebraMes = false;
                  if(session.getAttribute("dataSelecionada")!=null){
                    if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                      quebraMes = true;
                    }
                  }
               
                  String geral = null;
                  String regional = null;
                  String representante = null;
                  String analista = null;
                  Usuario u = new Usuario();
                  geral = "GERAL";
                  u = (Usuario)session.getAttribute("User");
                  acesso.Sessao sessao = new acesso.Sessao(session);
                  if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                     ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                    geral = null;
                    representante = sessao.getChave();
                    bloqCli = true;
                  }


                  if(sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")){
                    mostrarGeral = false;
                    geral = null;
                    analista = sessao.getChave();
                  }
                  if(sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")){
                    mostrarGeral = false;
                    geral = null;
                    regional = sessao.getChave();
                  }
                  if(sessao.getTipoEntidadeNegocio().equals("AREAS")){
                    geral = "GERAL";
                  }
                  if(u.isSuperUsuario()){
                    geral = "GERAL";
                  }

                  String filtroSegmento = "";
                  java.util.Vector res_Entrada_pedidos_atual_vw = null;
                  com.egen.util.jdbc.JdbcUtil j = null;
                  try {
                    j = new com.egen.util.jdbc.JdbcUtil();
                    util.consultas.Query queryDia = new util.consultas.Query();
                    String diaAtual = queryDia.retorna(j, "SELECT to_char(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END, 'dd/mm/yyyy') dia_atual FROM dual ");
                    portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = new portalbr.dbobj.table.Entrada_pedidos_atual_vw();
                    String[][] select = null;
                    String marcaSelecionada = (String)session.getAttribute("entrada_pedidos_marca_selecionada");
                    if(marcaSelecionada.equalsIgnoreCase("T")){
                      marcaSelecionada = null;
                    }
                    if(session.getAttribute("res_Jw_entrada_atual_pedidos_filtro_segmento") != null) {
                       filtroSegmento = (String)session.getAttribute("res_Jw_entrada_atual_pedidos_filtro_segmento");
                    }

                    StringBuilder sgc = new StringBuilder();
                    String filtroRepresentante = "";
                    String filtroRepresentanteTotal = "";
                    if(sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")
                       ||sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")){
                       filtroRepresentante = " AND ctl.codigo_representante = '"+sessao.getChave()+"'";
                       filtroRepresentanteTotal = " AND codigo_representante = '"+sessao.getChave()+"'";
                    }


    
                    String mercado = (String)session.getAttribute("mercado") != null ? (String)session.getAttribute("mercado") : "todos";
                    String codigoRegional = session.getAttribute("entrada_pedidos_regional_cliente_selecionada") != null ? ((String)session.getAttribute("entrada_pedidos_regional_cliente_selecionada")) : null;
                    sgc.append(" select * from ( ");
                    sgc.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
                    sgc.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
                    sgc.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
                    sgc.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
                    sgc.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
                    sgc.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
                    sgc.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
                    sgc.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
                    sgc.append("      , 'GERAL' tipo ");
                    sgc.append("      , NULL codigo_gerente ");
                    sgc.append("      , NULL codigo_regional ");
                    sgc.append("      , '' rep_cdgo ");
                    sgc.append("      , NULL rep_rzao ");
                    sgc.append("      , NULL sigla_regional ");
                    sgc.append("      , NULL codigo_marca ");
                    sgc.append("      , NULL descricao_marca ");
                    sgc.append("      , COUNT(DISTINCT cli_cdgo) clientes ");
                    sgc.append("      , 0 total_pares_ano ");
                    sgc.append("      , 0.0 total_valor_ano ");
                    sgc.append("      , 0 clientes_atendidos_ano ");
                    sgc.append("   FROM tmp_mapa_automatico_resumo ctl ");
                    if(codigoRegional != null) {
                       sgc.append("      , regionais_vendas reg ");
                       sgc.append("      , rep rep ");
                    }
                    sgc.append("  WHERE empresa = '01' ");
                    sgc.append(filtroSegmento);
                    sgc.append(filtroRepresentante);
                    if(codigoRegional != null) {
                       sgc.append(" AND reg.codigo_regional = " + codigoRegional);
	               sgc.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
                       sgc.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
                    }
                    if(marcaSelecionada!=null){
                      sgc.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
                    }
                    if(!mercado.equalsIgnoreCase("todos") && mercado != null){
                      sgc.append(" AND ctl.tipo_de_mercado = '"+mercado+"'");
                    }
                    sgc.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
                    sgc.append("    AND data = NVL((SELECT sem.data_mapa ");
                    sgc.append("                     FROM semanas sem ");
                    sgc.append("                    WHERE data = (SELECT sem.data_mapa ");
                    sgc.append("                                    FROM semanas sem ");
                    sgc.append("                                   WHERE data = to_date('"+diaAtual+"','dd/mm/yyyy')) - 1), to_date('"+diaAtual+"','dd/mm/yyyy') - 1) ");
                    sgc.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
                    sgc.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
                    sgc.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
                    sgc.append("          ,TO_CHAR(data, 'DD/MM/YYYY') ");
                    sgc.append(" UNION ");
                    sgc.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
                    sgc.append("      , TO_CHAR(data, 'DD/MM/YYYY') datam ");
                    sgc.append("      , SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
                    sgc.append("      , SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
                    sgc.append("      , (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
                    sgc.append("      , ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
                    sgc.append("      , (SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
                    sgc.append("      , ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
                    sgc.append("      , 'GERAL' tipo ");
                    sgc.append("      , NULL codigo_gerente ");
                    sgc.append("      , NULL codigo_regional ");
                    sgc.append("      , '' rep_cdgo ");
                    sgc.append("      , '' rep_rzao ");
                    sgc.append("      , NULL sigla_regional ");
                    sgc.append("      , NULL codigo_marca ");
                    sgc.append("      , NULL descricao_marca ");
                    sgc.append("      , COUNT(DISTINCT cli_cdgo) clientes ");
                    sgc.append("      , 0 total_pares_ano ");
                    sgc.append("      , 0.0 total_valor_ano ");
                    sgc.append("      , 0 clientes_atendidos_ano ");
                    sgc.append("   FROM tmp_mapa_automatico_resumo ctl ");
                    if(codigoRegional != null) {
                       sgc.append("      , regionais_vendas reg ");
                       sgc.append("      , rep rep ");
                    }
                    sgc.append("  WHERE empresa = '01' ");
                    sgc.append(filtroRepresentante);
                    sgc.append(filtroSegmento);
                    if(codigoRegional != null) {
                       sgc.append("    AND reg.codigo_regional = " + codigoRegional);
	               sgc.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
                       sgc.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
                    }
                    if(marcaSelecionada!=null){
                      sgc.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
                    }
                    if(!mercado.equalsIgnoreCase("todos") && mercado != null){
                      sgc.append(" AND ctl.tipo_de_mercado = '"+mercado+"'");
                    }
                    sgc.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
                    sgc.append("    AND data = NVL((SELECT sem.data_mapa ");
                    sgc.append("                     FROM semanas sem ");
                    sgc.append("                    WHERE data = to_date('"+diaAtual+"','dd/mm/yyyy')), to_date('"+diaAtual+"','dd/mm/yyyy')) ");
                    sgc.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
                    sgc.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
                    sgc.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
                    sgc.append("          ,TO_CHAR(data, 'DD/MM/YYYY') ");
                    sgc.append(" UNION ");
                    sgc.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
                    sgc.append("       ,'MÊS' datam ");
                    sgc.append("       ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
                    sgc.append("       ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
                    sgc.append("       ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");


                    sgc.append("       ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
                    sgc.append("       ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
                    sgc.append("       ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
                    sgc.append("       ,'GERAL' tipo ");
                    sgc.append("       ,NULL codigo_gerente ");
                    sgc.append("       ,NULL codigo_regional ");
                    sgc.append("       ,'' rep_cdgo ");
                    sgc.append("       ,'' rep_rzao ");
                    sgc.append("       ,NULL sigla_regional ");
                    sgc.append("       ,NULL codigo_marca ");
                    sgc.append("       ,NULL descricao_marca ");
                    sgc.append("       ,COUNT(DISTINCT cli_cdgo) clientes ");
                    if(marcaSelecionada!=null) {
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where codigo_marca = "+marcaSelecionada + filtroRepresentanteTotal+" ) total_pares_ano ");
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) +  NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo where codigo_marca = "+marcaSelecionada + filtroRepresentanteTotal +") total_valor_ano  ");
                      sgc.append("       ,(SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc where cc.codigo_marca = "+marcaSelecionada+ filtroRepresentanteTotal +" UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca WHERE cca.codigo_marca = "+marcaSelecionada + filtroRepresentanteTotal +")) clientes_atendidos_ano ");
                    } else if(codigoRegional != null) {
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) + NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo t, regionais_vendas rv, rep r WHERE NVL(to_char(t.codigo_representante), NULL) = NVL(r.rep_cdgo, NULL) AND NVL(r.codigo_regional, NULL) = rv.codigo_regional AND rv.codigo_regional = "+codigoRegional + filtroRepresentanteTotal +") total_pares_ano ");
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo t, regionais_vendas rv, rep r WHERE NVL(to_char(t.codigo_representante), NULL) = NVL(r.rep_cdgo, NULL) AND NVL(r.codigo_regional, NULL) = rv.codigo_regional AND rv.codigo_regional = "+codigoRegional + filtroRepresentanteTotal +") total_valor_ano ");
                      sgc.append("       ,(SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc, regionais_vendas rv, rep r WHERE NVL(to_char(cc.codigo_representante), NULL) = NVL(r.rep_cdgo, NULL) AND NVL(r.codigo_regional, NULL) = rv.codigo_regional AND rv.codigo_regional = "+codigoRegional + filtroRepresentanteTotal +" UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca, regionais_vendas rv, rep r  WHERE NVL(to_char(cca.codigo_representante), NULL) = NVL(r.rep_cdgo, NULL) AND NVL(r.codigo_regional, NULL) = rv.codigo_regional AND rv.codigo_regional = "+codigoRegional + filtroRepresentanteTotal +")) clientes_atendidos_ano ");
                    } else {
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_pares, 0) + NVL(entped_pg_pares, 0) + NVL(entped_rr_pares, 0) +  NVL(entped_nomes_geral_pares, 0)) FROM tmp_mapa_automatico_resumo where 1=1 "+filtroRepresentanteTotal +" ) total_pares_ano ");
                      sgc.append("       ,(SELECT SUM(NVL(entped_pp_vlr, 0) + NVL(entped_pg_vlr, 0) + NVL(entped_rr_vlr, 0) + NVL(entped_nomes_geral_vlr, 0)) FROM tmp_mapa_automatico_resumo where 1=1 "+filtroRepresentanteTotal +" ) total_valor_ano  ");
                      sgc.append("       ,(SELECT COUNT(DISTINCT cli_cdgo) FROM (SELECT cc.cli_cdgo FROM tmp_mapa_automatico_resumo cc where 1=1 "+filtroRepresentanteTotal+" UNION SELECT cca.cli_cdgo_ano cli_cdgo FROM ubiratan.tmp_mapa_res_acumulado1 cca where 1=1 "+filtroRepresentanteTotal +")) clientes_atendidos_ano ");     					  
                    }
                    sgc.append("   FROM tmp_mapa_automatico_resumo ctl ");
                    if(codigoRegional != null) {
                       sgc.append("      , regionais_vendas reg ");
                       sgc.append("      , rep rep ");
                    }
                    sgc.append("  WHERE empresa = '01' ");
                    sgc.append(filtroRepresentante);
                    sgc.append(filtroSegmento);
                    if(codigoRegional != null) {
                       sgc.append("    AND reg.codigo_regional = " + codigoRegional);
	               sgc.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
                       sgc.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
                    }
                    if(marcaSelecionada!=null){
                      sgc.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
                    }
                    if(!mercado.equalsIgnoreCase("todos") && mercado != null){
                      sgc.append(" AND ctl.tipo_de_mercado = '"+mercado+"'");
                    }
                    sgc.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
                    sgc.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
                    sgc.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
                    sgc.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
                    sgc.append("          ,'MÊS' ");
                    sgc.append("  UNION ");
                    sgc.append(" SELECT TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') atualizacao ");
                    sgc.append("       ,'SEMANA ATUAL' datam ");
                    sgc.append("       ,SUM(NVL(ctl.entped_pp_pares, 0)) pr_pp ");
                    sgc.append("       ,SUM(NVL(ctl.entped_pp_vlr, 0)) vlr_pp ");
                    sgc.append("       ,(SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0))) pr_pg ");
                    sgc.append("       ,ROUND(SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0)), 2) vlr_pg ");
                    sgc.append("       ,(SUM(NVL(ctl.entped_pp_pares, 0)) + (SUM(NVL(ctl.entped_pg_pares, 0)) + SUM(NVL(ctl.entped_rr_pares, 0)))) tot_pares ");
                    sgc.append("       ,ROUND(SUM(NVL(ctl.entped_pp_vlr, 0)) + (SUM(NVL(ctl.entped_pg_vlr, 0)) + SUM(NVL(ctl.entped_rr_vlr, 0))), 2) tot_vlr ");
                    sgc.append("       ,'GERAL' tipo ");
                    sgc.append("       ,NULL codigo_gerente ");
                    sgc.append("       ,NULL codigo_regional ");
                    sgc.append("       ,'' rep_cdgo ");
                    sgc.append("       ,NULL rep_rzao ");
                    sgc.append("       ,NULL sigla_regional ");
                    sgc.append("       ,NULL codigo_marca ");
                    sgc.append("       ,NULL descricao_marca ");
                    sgc.append("       ,COUNT(DISTINCT cli_cdgo) clientes ");
                    sgc.append("       ,0 total_pares_ano ");
                    sgc.append("       ,0.0 total_valor_ano ");
                    sgc.append("       ,0 clientes_atendidos_ano ");
                    sgc.append("   FROM tmp_mapa_automatico_resumo ctl ");
                    if(codigoRegional != null) {
                       sgc.append("      , regionais_vendas reg ");
                       sgc.append("      , rep rep ");
                    }
                    sgc.append("  WHERE empresa = '01' ");
                    sgc.append(filtroRepresentante);
                    sgc.append(filtroSegmento);
                    if(codigoRegional != null) {
                       sgc.append("    AND reg.codigo_regional = " + codigoRegional);
	                sgc.append("    AND NVL(reg.codigo_regional, NULL) = rep.codigo_regional ");
                       sgc.append("    AND NVL(ctl.codigo_representante, NULL) = rep.rep_cdgo ");
                    }
                    if(marcaSelecionada!=null){
                      sgc.append(" AND nvl(ctl.codigo_marca,null) = ").append(marcaSelecionada);
                    }
                    if(!mercado.equalsIgnoreCase("todos") && mercado != null){
                      sgc.append(" AND ctl.tipo_de_mercado = '"+mercado+"'");
                    }
                    sgc.append("    AND filial NOT IN ('GER', 'TOC', 'MOL', 'BEI', 'VIZ', 'MOD', 'MLK') ");
                    sgc.append("    AND NVL(ctl.semana_mapa,NULL) IN (SELECT sem.semana ");
                    sgc.append("                                        FROM semanas sem ");
                    sgc.append("                                        WHERE data = TRUNC(CASE WHEN (EXTRACT(DAY FROM SYSDATE) = 1 AND EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP))<8) THEN trunc(SYSDATE)-1 ELSE trunc(SYSDATE) END)) ");
                    sgc.append("    AND (NVL(ctl.entped_pp_pares, 0) + NVL(ctl.entped_pg_pares, 0) + NVL(ctl.entped_rr_pares, 0) + NVL(ctl.entped_nomes_geral_pares, 0)) > 0 ");
                    sgc.append("    AND (NVL(ctl.entped_pp_vlr, 0) + NVL(ctl.entped_pg_vlr, 0) + NVL(ctl.entped_rr_vlr, 0) + NVL(ctl.entped_nomes_geral_vlr, 0)) > 0 ");
                    sgc.append("  GROUP BY TO_CHAR(ctl.data_atualizacao, 'DD/MM/YYYY HH24:MI') ");
                    sgc.append("          ,'SEMANA ATUAL' ");

                    sgc.append(" ) where datam = '"+(String)session.getAttribute("dataSelecionada")+"' ");

       


                    if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("cliente") || ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("grupo") || ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("regional")  || ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("tipoProduto") || ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("unidade")  || ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("estilo")){
                      if(mostrarGeral) {
                         res_Entrada_pedidos_atual_vw = j.select(t_ent_ped_vw, sgc.toString(), null);
                       }
                    } else {
                      if(mostrarGeral){
                         util.consultas.com.EntradaAtualPedidos entradaAtualPedidos = new util.consultas.com.EntradaAtualPedidos();
                         res_Entrada_pedidos_atual_vw = j.select(t_ent_ped_vw, entradaAtualPedidos.retornaQueryDadosGeral(geral, regional, representante, analista, (String)session.getAttribute("dataSelecionada"), filtroSegmento).toString(), null);
        
                      }
                    }
                  } catch (Exception e){
                    e.printStackTrace();
                    session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
                  } finally {
                  if(j!=null){j.close();}
                }
                %>

                <form  name="bl_report_ent_ped_vw" id="bl_report_ent_ped_vw" class="baseForm" method="post" >

                  <%
                  if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {

                    %>

                    <table id="TRbl_report_ent_ped_vw" class="reportTable" style="width: 99%" border="1" >
                      <%
                      String atualizacao =  null;
                      String datam =  null;
                      Double pr_pp =  null;
                      Double vlr_pp =  null;
                      Double pr_pg =  null;
                      Double vlr_pg =  null;
                      Double tot_pares =  null;
                      Double tot_vlr =  null;
                      String tipo =  null;
                      Integer codigo_gerente =  null;
                      Integer codigo_regional =  null;
                      String rep_cdgo =  null;
                      Integer clientes =  null;
                      Integer clientes_calcados =  null;
                      Integer clientes_botas =  null;
                      Integer clientes_meias =  null;
                      Integer total_pares_ano =  null;
                      Double total_valor_ano =  null;
                      Integer cli_atend_ano =  null;
                      String perc8 = "8%";
                      String perc10 = "10%";
                      String perc4 = "14%";
                      String perc6 = "16%";
                      if(quebraMes){
                        perc8 = "8%";
                        perc10 = "10%";
                        perc4 = "10%";
                        perc6 = "12%";
                      }

                      String _b0_control = "__";
                      int i_bl_report_ent_ped_vw = 0;
                      while (i_bl_report_ent_ped_vw<res_Entrada_pedidos_atual_vw.size()) {

                        portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_bl_report_ent_ped_vw);
                        atualizacao = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                        datam = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                        pr_pp = t_ent_ped_vw.getPr_pp();
                        vlr_pp = t_ent_ped_vw.getVlr_pp();
                        pr_pg = t_ent_ped_vw.getPr_pg();
                        vlr_pg = t_ent_ped_vw.getVlr_pg();
                        tot_pares = t_ent_ped_vw.getTot_pares();
                        tot_vlr = t_ent_ped_vw.getTot_vlr();
                        tipo = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                        codigo_gerente = t_ent_ped_vw.getCodigo_gerente();
                        codigo_regional = t_ent_ped_vw.getCodigo_regional();
                        rep_cdgo = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                        clientes = t_ent_ped_vw.getClientes();
                        clientes_calcados = t_ent_ped_vw.getClientes_calcados();
                        clientes_botas = t_ent_ped_vw.getClientes_botas();
                        clientes_meias = t_ent_ped_vw.getClientes_meias();
                        total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                        total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                        cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
                        session.setAttribute("cli_atd", clientes);
                        session.setAttribute("cli_atd_calcados", clientes_calcados);
                        session.setAttribute("cli_atd_botas", clientes_botas);
                        session.setAttribute("cli_atd_meias", clientes_meias);

                        String _b0_value = (atualizacao==null?"":atualizacao);
                        if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                          if(session.getAttribute("tipoQuebra")!=null && !((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("marca")){
                            %>
                            <tr class="reportHeader2">
                              <%
                              if(quebraMes){
                                %>
                                <td colspan="11" style="text-align: left">
                                  <%
                                } else {
                                  %>
                                  <td colspan="8" style="text-align: left">
                                    <%
                                  }
                                  %>

                                  <div style="float: left">
                                    <big>
                                      Atualização:
                                    </big>
                                    <big>
                                      <%= atualizacao %>
                                    </big>
                                  </div>
                                  <div style="float: right">

                                    <%
                                    String msg = "";
                                    if(session.getAttribute("mensagem_dois_bilhoes")!=null){
                                      String m = (String)session.getAttribute("mensagem_dois_bilhoes");
                                      String[] valor = m.split("#");
                                      msg = (valor[0]).replace("?",FormatNumber.format(Double.parseDouble(valor[1].replace(",","")), "#,##0.##"));
                                    }
                                    %>
                                    <big>
                                      <%= msg %> 
                                    </big>
                                  </div>
                                </td>
                              </tr>
                              <%
                              %>

                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:left;" >
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                  Compra Rápida
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                  PG/EX
                                </td>
                                <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                                  <%
                                  if(quebraMes){
                                    %>
                                    Total Mês
                                    <%
                                  } else {
                                    %>
                                    Total
                                    <%
                                  }
                                  %>
                                </td>
                                <%
                                if(quebraMes){
                                  %>
                                  <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                    Total Ano
                                  </td>
                                  <%
                                }
                                %>
                              </tr>
                              <tr class="reportTr">
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Dia
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Pares
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Valor
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Pares
                                </td>
                                <td class="columnTdHeader" style="text-align:center;" >
                                  Valor
                                </td>
                                <td class="totalColumn" style="color: black; text-align:center;" >
                                  Cli. Atd.
                                </td>
                                <td class="totalColumn" style="color:black; text-align:center;" >
                                  Pares
                                </td>
                                <td class="totalColumn" style="color:black; text-align:center;" >
                                  Valor
                                </td>
                                <%
                                if(quebraMes){
                                  %>
                                  <td style="color:black; text-align:center; background-color:#bfefff" >
                                    Cli. Atd.
                                  </td>
                                  <td style="color:black; text-align:center; background-color:#bfefff" >
                                    Pares
                                  </td>
                                  <td style="color:black; text-align:center; background-color:#bfefff" >
                                    Valor
                                  </td>
                                  <%
                                }
                                %>

                              </tr>

                              <%
                            } }
                            String style_bl_report_ent_ped_vw="";
                            if (!((i_bl_report_ent_ped_vw%2)!=0)) {
                              style_bl_report_ent_ped_vw="rowColor";
                            } else {
                              style_bl_report_ent_ped_vw="rowBlank";
                            }

                            if(session.getAttribute("tipoQuebra")!=null && !((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("marca")){
                              %>


                              <tr class='<%= style_bl_report_ent_ped_vw %>' id="TRbl_report_ent_ped_vw<%=i_bl_report_ent_ped_vw%>" >


                                <td class="reportColumn" style="text-align: center; width: <%= perc6 %>" >
                                  <%= datam %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pp, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pp, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pg, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pg, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                  <%= FormatNumber.format(clientes, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_pares, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_vlr, "##,##0.00") %>
                                </td>

                                <%
                                if(quebraMes){
                                  %>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                  </td>
                                  <%
                                }
                                %>


                              </tr>

                              <%
                            }
                            _b0_control = _b0_value;
                            i_bl_report_ent_ped_vw++;
                            if (i_bl_report_ent_ped_vw<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_bl_report_ent_ped_vw);
                              atualizacao = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              datam = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp = t_ent_ped_vw.getPr_pp();
                              vlr_pp = t_ent_ped_vw.getVlr_pp();
                              pr_pg = t_ent_ped_vw.getPr_pg();
                              vlr_pg = t_ent_ped_vw.getVlr_pg();
                              tot_pares = t_ent_ped_vw.getTot_pares();
                              tot_vlr = t_ent_ped_vw.getTot_vlr();
                              tipo = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              codigo_gerente = t_ent_ped_vw.getCodigo_gerente();
                              codigo_regional = t_ent_ped_vw.getCodigo_regional();
                              rep_cdgo = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              clientes = t_ent_ped_vw.getClientes();
                              clientes_calcados = t_ent_ped_vw.getClientes_calcados();
                              clientes_botas = t_ent_ped_vw.getClientes_botas();
                              clientes_meias = t_ent_ped_vw.getClientes_meias();
                              cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
                              total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                              total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                              session.setAttribute("cli_atd", clientes);
                              session.setAttribute("cli_atd_calcados", clientes_calcados);
                              session.setAttribute("cli_atd_botas", clientes_botas);
                              session.setAttribute("cli_atd_meias", clientes_meias);
                              _b0_value = (atualizacao==null?"":atualizacao);
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
                  <%
                  if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("regional")){

                    boolean quebraMes = false;
                    if(session.getAttribute("dataSelecionada")!=null){
                      if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                        quebraMes = true;
                      }
                    }
		    int total_pares_pp = 0;
		    double total_valor_pp = 0.0;
		    int total_pares_pg = 0;
	            double total_valor_pg = 0.0;
		    int total_clientes_mes = 0;
		    int total_pares_mes = 0;
		    double total_valor_mes  = 0.0;
		    int total_total_pares_ano = 0;
		    double total_total_valor_ano = 0.0;					
		    int total_clientes_atendidos_ano = 0;
					
                    String perc8 = "8%";
                    String perc10 = "10%";
                    String perc4 = "14%";
                    String perc6 = "16%";
                    if(quebraMes){
                      perc8 = "8%";
                      perc10 = "10%";
                      perc4 = "10%";
                      perc6 = "12%";
                    }

                    java.util.Vector res_Entrada_pedidos_atual_vw = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw_mi");
                    %>

                    <form  name="bl_report_ent_ped_vw_1" id="bl_report_ent_ped_vw_1" class="baseForm" method="post" >


                      <%
                      if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {
                        %>

                        <br>
                        <br>

                        <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width: 99%" border="1" >

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:center;" >
                              Mercado Interno
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              Compra Rápida
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              PG/EX
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                              <%
                              if(quebraMes){
                                %>
                                Total Mês
                                <%
                              } else {
                                %>
                                Total
                                <%
                              }
                              %>
                            </td>

                            <%
                            if(quebraMes){
                              %>
                              <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                Total Ano
                              </td>
                              <%
                            }
                            %>

                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align:center;" width="1%" >
                              Regional
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="totalColumn" style="color:black; text-align:center;" >
                              Cli. Atd.
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Pares
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Valor
                            </td>

                            <%
                            if(quebraMes){
                              %>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Cli. Atd.
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Pares
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Valor
                              </td>

                              <%
                            }
                            %>
                          </tr>

                          <%
                          java.lang.String atualizacao1 =  null;
                          java.lang.Integer codigo_regional1 =  null;
                          java.lang.String datam1 =  null;
                          java.lang.Double pr_pp1 =  null;
                          java.lang.Double vlr_pp1 =  null;
                          java.lang.Double pr_pg1 =  null;
                          java.lang.Double vlr_pg1 =  null;
                          java.lang.Double tot_pares1 =  null;
                          java.lang.Double tot_vlr1 =  null;
                          java.lang.String tipo1 =  null;
                          java.lang.String sigla_regional =  null;
                          java.lang.Integer codigo_gerente1 =  null;
                          java.lang.Integer clientes =  null;
                          java.lang.Integer total_pares_ano = null;
                          java.lang.Double total_valor_ano = null;
                          Integer cli_atend_ano = null;
                          java.lang.String rep_cdgo1 =  null;
                          String _b0_control = "__";
                          String _b1_control = "__";
                          int i_ent_atu_1 = 0;
                          while (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                            portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                            atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                            codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                            datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                            pr_pp1 = t_ent_ped_vw.getPr_pp();
                            vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                            pr_pg1 = t_ent_ped_vw.getPr_pg();
                            vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                            tot_pares1 = t_ent_ped_vw.getTot_pares();
                            tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                            tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                            sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                            codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                            rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                            clientes = t_ent_ped_vw.getClientes();
                            total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                            total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                            cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
							
                            String _b0_value = (atualizacao1==null?"":atualizacao1);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>
                              <%
                            }
                            String _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            if (_b1_control != null && !_b1_control.equals(_b1_value)) {

                            }
                            String st_bl_rep_Ent_ped_at_vw_1="";
                            if (!((i_ent_atu_1%2)!=0)) {
                              st_bl_rep_Ent_ped_at_vw_1="rowColor";
                            } else {
                              st_bl_rep_Ent_ped_at_vw_1="rowBlank";
                            }
                            %>

                            <tr class='<%= st_bl_rep_Ent_ped_at_vw_1 %>' id="TRbl_report_ent_ped_vw_1<%=i_ent_atu_1%>" >

                              <td class="reportColumn" style="text-align: center; width: <%= perc6 %>" >
                                <%= sigla_regional %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pp1, "#,##0.##") %>
                                <% total_pares_pp += pr_pp1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pp1, "##,##0.00") %>
                                <% total_valor_pp += vlr_pp1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pg1, "#,##0.##") %>
                                <% total_pares_pg += pr_pg1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pg1, "##,##0.00") %>
                                <% total_valor_pg += vlr_pg1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                <%= FormatNumber.format(clientes, "#,##0.##") %>
                                <% total_clientes_mes += clientes; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_pares1, "#,##0.##") %>
                                <% total_pares_mes += tot_pares1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_vlr1, "##,##0.00") %>
                                <% total_valor_mes  += tot_vlr1; %>
                              </td>

                              <%
                              if(quebraMes){
                                %>
                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                  <% total_clientes_atendidos_ano += cli_atend_ano; %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                  <% total_total_pares_ano += total_pares_ano; %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                  <% total_total_valor_ano += total_valor_ano; %>
                                </td>
                                <%
                              }
                              %>


                            </tr>

                            <%
                            _b0_control = _b0_value;
                            _b1_control = _b1_value;
                            i_ent_atu_1++;
                            if (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                              atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                              datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp1 = t_ent_ped_vw.getPr_pp();
                              vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                              pr_pg1 = t_ent_ped_vw.getPr_pg();
                              vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                              tot_pares1 = t_ent_ped_vw.getTot_pares();
                              tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                              tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                              codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                              rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              clientes = t_ent_ped_vw.getClientes();
                              total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                              total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                              cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
                              _b0_value = (atualizacao1==null?"":atualizacao1);
                              _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            } else {
                              _b0_control = "__";
                              _b1_control = "__";
                            }
                          }
                          %>
						  
			<tr>
			  <td class="totalColumn" style="text-align: right">
			    <b>Total</b>
 			  </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_pp, "#,##0.##") %></b>
                          </td>
                          <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_pp, "##,##0.00") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_pg, "#,##0.##") %></b>
                          </td>
                          <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_pg, "##,##0.00") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format((Integer)session.getAttribute("clientes_mercado_interno"), "#,##0.##") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_mes, "#,##0.##") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_mes, "##,##0.00") %></b>
                          </td>
<% if(quebraMes){ %>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                            <b><%= FormatNumber.format(total_clientes_atendidos_ano , "#,##0.##") %></b>
                          </td>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                            <b><%= FormatNumber.format(total_total_pares_ano , "#,##0.##") %></b>
                          </td>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                            <b><%= FormatNumber.format(total_total_valor_ano, "##,##0.00") %></b>
                          </td>
<% } %>
			</tr>

                        </table>

                        <%
                      }
                      %>

                    </form>
                    <%
                  }
                  %>








 <%
                  if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("regional")){

                    boolean quebraMes = false;
                    if(session.getAttribute("dataSelecionada")!=null){
                      if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                        quebraMes = true;
                      }
                    }
		    int total_pares_pp = 0;
		    double total_valor_pp = 0.0;
		    int total_pares_pg = 0;
		    double total_valor_pg = 0.0;
		    int total_clientes_mes = 0;
	    	    int total_pares_mes = 0;
		    double total_valor_mes  = 0.0;
		    int total_total_pares_ano = 0;
	   	    double total_total_valor_ano = 0.0;
		    int total_clientes_atendidos_ano = 0;
                    String perc8 = "8%";
                    String perc10 = "10%";
                    String perc4 = "14%";
                    String perc6 = "16%";
                    if(quebraMes){
                      perc8 = "8%";
                      perc10 = "10%";
                      perc4 = "10%";
                      perc6 = "12%";
                    }

                    java.util.Vector res_Entrada_pedidos_atual_vw = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw_me");
                    %>

                    <form  name="bl_report_ent_ped_vw_1" id="bl_report_ent_ped_vw_1" class="baseForm" method="post" >

                      <%
                      if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {
                        %>

                        <br>
                        <br>

                        <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width:99%"  border="1" >

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:center;" >
                              Mercado Externo
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              Compra Rápida
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              PG/EX
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                              <%
                              if(quebraMes){
                                %>
                                Total Mês
                                <%
                              } else {
                                %>
                                Total
                                <%
                              }
                              %>
                            </td>

                            <%
                            if(quebraMes){
                              %>
                              <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                Total Ano
                              </td>
                              <%
                            }
                            %>

                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align:center;" width="1%" >
                              Regional
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="totalColumn" style="color:black; text-align:center;" >
                              Cli. Atd.
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Pares
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Valor
                            </td>

                            <%
                            if(quebraMes){
                              %>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Cli. Atd.
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Pares
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Valor
                              </td>

                              <%
                            }
                            %>
                          </tr>

                          <%
                          java.lang.String atualizacao1 =  null;
                          java.lang.Integer codigo_regional1 =  null;
                          java.lang.String datam1 =  null;
                          java.lang.Double pr_pp1 =  null;
                          java.lang.Double vlr_pp1 =  null;
                          java.lang.Double pr_pg1 =  null;
                          java.lang.Double vlr_pg1 =  null;
                          java.lang.Double tot_pares1 =  null;
                          java.lang.Double tot_vlr1 =  null;
                          java.lang.String tipo1 =  null;
                          java.lang.String sigla_regional =  null;
                          java.lang.Integer codigo_gerente1 =  null;
                          java.lang.Integer clientes =  null;
                          java.lang.Integer total_pares_ano = null;
                          java.lang.Double total_valor_ano = null;
                          java.lang.Integer cli_atend_ano = null;
                          java.lang.String rep_cdgo1 =  null;
                          String _b0_control = "__";
                          String _b1_control = "__";
                          int i_ent_atu_1 = 0;
                          while (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                            portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                            atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                            codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                            datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                            pr_pp1 = t_ent_ped_vw.getPr_pp();
                            vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                            pr_pg1 = t_ent_ped_vw.getPr_pg();
                            vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                            tot_pares1 = t_ent_ped_vw.getTot_pares();
                            tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                            tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                            sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                            codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                            rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                            clientes = t_ent_ped_vw.getClientes();
                            total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                            total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                            cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();

                            String _b0_value = (atualizacao1==null?"":atualizacao1);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>
                              <%
                            }
                            String _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            if (_b1_control != null && !_b1_control.equals(_b1_value)) {

                            }
                            String st_bl_rep_Ent_ped_at_vw_1="";
                            if (!((i_ent_atu_1%2)!=0)) {
                              st_bl_rep_Ent_ped_at_vw_1="rowColor";
                            } else {
                              st_bl_rep_Ent_ped_at_vw_1="rowBlank";
                            }
                            %>

                            <tr class='<%= st_bl_rep_Ent_ped_at_vw_1 %>' id="TRbl_report_ent_ped_vw_1<%=i_ent_atu_1%>" >

                              <td class="reportColumn" style="text-align: center; width: <%= perc6 %>" >
                                <%= sigla_regional %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pp1, "#,##0.##") %>
                                <% total_pares_pp += pr_pp1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pp1, "##,##0.00") %>
                                <% total_valor_pp += vlr_pp1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pg1, "#,##0.##") %>
                                <% total_pares_pg += pr_pg1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pg1, "##,##0.00") %>
                                <% total_valor_pg += vlr_pg1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                <%= FormatNumber.format(clientes, "#,##0.##") %>
                                <% total_clientes_mes += clientes; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_pares1, "#,##0.##") %>
                                <% total_pares_mes += tot_pares1; %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_vlr1, "##,##0.00") %>
                                <% total_valor_mes  += tot_vlr1; %>
                              </td>

                              <%
                              if(quebraMes){
                                %>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                  <%  total_clientes_atendidos_ano += cli_atend_ano; %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                  <%  total_total_pares_ano += total_pares_ano; %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                  <% total_total_valor_ano += total_valor_ano; %>
                                </td>
                                <%
                              }
                              %>


                            </tr>

                            <%
                            _b0_control = _b0_value;
                            _b1_control = _b1_value;
                            i_ent_atu_1++;
                            if (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                              atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                              datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp1 = t_ent_ped_vw.getPr_pp();
                              vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                              pr_pg1 = t_ent_ped_vw.getPr_pg();
                              vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                              tot_pares1 = t_ent_ped_vw.getTot_pares();
                              tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                              tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                              codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                              rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              clientes = t_ent_ped_vw.getClientes();
                              total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                              total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                              cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
						  							  
                              _b0_value = (atualizacao1==null?"":atualizacao1);
                              _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            } else {
                              _b0_control = "__";
                              _b1_control = "__";
                            }
                          }
                          %>

                         <tr>
			  <td class="totalColumn" style="text-align: right">
			    <b>Total</b>
 			  </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_pp, "#,##0.##") %></b>
                          </td>
                          <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_pp, "##,##0.00") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_pg, "#,##0.##") %></b>
                          </td>
                          <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_pg, "##,##0.00") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format((Integer)session.getAttribute("clientes_mercado_externo"), "#,##0.##") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_pares_mes, "#,##0.##") %></b>
                          </td>
			  <td class="totalColumn" style="text-align:right;">
                            <b><%= FormatNumber.format(total_valor_mes, "##,##0.00") %></b>
                          </td>
<% if(quebraMes){ %>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                             <b><%= FormatNumber.format(total_clientes_atendidos_ano , "#,##0.##") %></b>
                          </td>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                            <b><%= FormatNumber.format(total_total_pares_ano , "#,##0.##") %></b>
                          </td>
                          <td style="color:black; text-align:right; background-color:#bfefff" >
                            <b><%= FormatNumber.format(total_total_valor_ano, "##,##0.00") %></b>
                          </td>
<% } %>
			</tr>

                        </table>

                        <%
                      }
                      %>

                    </form>
                    <%
                  }
                  %>




























                  <%
                  if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("marca")){

                    java.util.Vector res_Entrada_pedidos_atual_vw = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw");
                    %>

                    <form  name="bl_report_ent_ped_vw_1" id="bl_report_ent_ped_vw_1" class="baseForm" method="post" >


                      <%
                      if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {
                        %>

                        <br>
                        <br>

                        <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width:99%"  border="1" >

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                            </td>


                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              Compra Rápida
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              PG/EX
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                              Total
                            </td>

                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align:center;" width="1%" >
                              Marca
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Cli. Atd.
                            </td>

                            <td class="totalColumn" style="color:black; text-align:center;" >
                              Pares
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Valor
                            </td>

                          </tr>

                          <%
                          java.lang.String atualizacao1 =  null;
                          java.lang.Integer codigo_regional1 =  null;
                          java.lang.String datam1 =  null;
                          java.lang.Double pr_pp1 =  null;
                          java.lang.Double vlr_pp1 =  null;
                          java.lang.Double pr_pg1 =  null;
                          java.lang.Double vlr_pg1 =  null;
                          java.lang.Double tot_pares1 =  null;
                          java.lang.Double tot_vlr1 =  null;
                          java.lang.String tipo1 =  null;
                          java.lang.String sigla_regional =  null;
                          java.lang.Integer codigo_gerente1 =  null;
                          java.lang.String rep_cdgo1 =  null;
                          java.lang.Integer codigo_marca1 =  null;
                          java.lang.String descricao_marca1 =  null;
                          java.lang.Integer clientes1 =  null;
                          String _b0_control = "__";
                          String _b1_control = "__";
                          int i_ent_atu_1 = 0;
                          while (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                            portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                            atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                            codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                            datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                            pr_pp1 = t_ent_ped_vw.getPr_pp();
                            vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                            pr_pg1 = t_ent_ped_vw.getPr_pg();
                            vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                            tot_pares1 = t_ent_ped_vw.getTot_pares();
                            clientes1 = t_ent_ped_vw.getClientes();
                            tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                            tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                            sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                            codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                            rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                            codigo_marca1 = t_ent_ped_vw.getCodigo_marca();
                            descricao_marca1 = t_ent_ped_vw.getDescricao_marca()==null?"":t_ent_ped_vw.getDescricao_marca();
                            String _b0_value = (atualizacao1==null?"":atualizacao1);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>
                              <%
                            }
                            String _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                              %>

                              <%
                              if (false) {
                                %>
                                <tr class="reportHeader">
                                  <td colspan="10">
                                    <span class="columnTdHeader" style="text-align:right;" >
                                      Regional
                                      <%= sigla_regional %>
                                    </span>
                                  </td>
                                </tr>

                                <%
                              }
                              %>
                              <%
                              %>

                              <%
                            }
                            String st_bl_rep_Ent_ped_at_vw_1="";
                            if (!((i_ent_atu_1%2)!=0)) {
                              st_bl_rep_Ent_ped_at_vw_1="rowColor";
                            } else {
                              st_bl_rep_Ent_ped_at_vw_1="rowBlank";
                            }
                            %>

                            <tr class='<%= st_bl_rep_Ent_ped_at_vw_1 %>' id="TRbl_report_ent_ped_vw_1<%=i_ent_atu_1%>" >

                              <td class="reportColumn" style="text-align: center; width: 16%" >
                                <%= descricao_marca1 %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(pr_pp1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(vlr_pp1, "##,##0.00") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(pr_pg1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(vlr_pg1, "##,##0.00") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 8%" >
                                <%= FormatNumber.format(clientes1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 10%" >
                                <%= FormatNumber.format(tot_pares1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 10%" >
                                <%= FormatNumber.format(tot_vlr1, "##,##0.00") %>
                              </td>



                            </tr>

                            <%
                            _b0_control = _b0_value;
                            _b1_control = _b1_value;
                            i_ent_atu_1++;
                            if (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                              atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                              datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp1 = t_ent_ped_vw.getPr_pp();
                              vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                              pr_pg1 = t_ent_ped_vw.getPr_pg();
                              vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                              tot_pares1 = t_ent_ped_vw.getTot_pares();
                              tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                              clientes1 = t_ent_ped_vw.getClientes();
                              tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                              codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                              rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              codigo_marca1 = t_ent_ped_vw.getCodigo_marca();
                              descricao_marca1 = t_ent_ped_vw.getDescricao_marca()==null?"":t_ent_ped_vw.getDescricao_marca();
                              _b0_value = (atualizacao1==null?"":atualizacao1);
                              _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            } else {
                              _b0_control = "__";
                              _b1_control = "__";
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
                  if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("marca")){

                    java.util.Vector res_Entrada_pedidos_atual_vw = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw");
                    %>

                    <form  name="bl_report_ent_ped_vw_1" id="bl_report_ent_ped_vw_1" class="baseForm" method="post" >


                      <%
                      if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {
                        %>

                        <br>
                        <br>

                        <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width:99%"  border="1" >

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                            </td>


                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              Compra Rápida
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              PG/EX
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                              Total
                            </td>

                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align:center;" width="1%" >
                              Marca
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Cli. Atd.
                            </td>

                            <td class="totalColumn" style="color:black; text-align:center;" >
                              Pares
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Valor
                            </td>

                          </tr>

                          <%
                          java.lang.String atualizacao1 =  null;
                          java.lang.Integer codigo_regional1 =  null;
                          java.lang.String datam1 =  null;
                          java.lang.Double pr_pp1 =  null;
                          java.lang.Double vlr_pp1 =  null;
                          java.lang.Double pr_pg1 =  null;
                          java.lang.Double vlr_pg1 =  null;
                          java.lang.Double tot_pares1 =  null;
                          java.lang.Double tot_vlr1 =  null;
                          java.lang.String tipo1 =  null;
                          java.lang.String sigla_regional =  null;
                          java.lang.Integer codigo_gerente1 =  null;
                          java.lang.String rep_cdgo1 =  null;
                          java.lang.Integer codigo_marca1 =  null;
                          java.lang.String descricao_marca1 =  null;
                          java.lang.Integer clientes1 =  null;
                          String _b0_control = "__";
                          String _b1_control = "__";
                          int i_ent_atu_1 = 0;
                          while (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                            portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                            atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                            codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                            datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                            pr_pp1 = t_ent_ped_vw.getPr_pp();
                            vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                            pr_pg1 = t_ent_ped_vw.getPr_pg();
                            vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                            tot_pares1 = t_ent_ped_vw.getTot_pares();
                            clientes1 = t_ent_ped_vw.getClientes();
                            tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                            tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                            sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                            codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                            rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                            codigo_marca1 = t_ent_ped_vw.getCodigo_marca();
                            descricao_marca1 = t_ent_ped_vw.getDescricao_marca()==null?"":t_ent_ped_vw.getDescricao_marca();
                            String _b0_value = (atualizacao1==null?"":atualizacao1);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>
                              <%
                            }
                            String _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                              %>

                              <%
                              if (false) {
                                %>
                                <tr class="reportHeader">
                                  <td colspan="10">
                                    <span class="columnTdHeader" style="text-align:right;" >
                                      Regional
                                      <%= sigla_regional %>
                                    </span>
                                  </td>
                                </tr>

                                <%
                              }
                              %>
                              <%
                              %>

                              <%
                            }
                            String st_bl_rep_Ent_ped_at_vw_1="";
                            if (!((i_ent_atu_1%2)!=0)) {
                              st_bl_rep_Ent_ped_at_vw_1="rowColor";
                            } else {
                              st_bl_rep_Ent_ped_at_vw_1="rowBlank";
                            }
                            %>

                            <tr class='<%= st_bl_rep_Ent_ped_at_vw_1 %>' id="TRbl_report_ent_ped_vw_1<%=i_ent_atu_1%>" >

                              <td class="reportColumn" style="text-align: center; width: 16%" >
                                <%= descricao_marca1 %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(pr_pp1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(vlr_pp1, "##,##0.00") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(pr_pg1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 14%" >
                                <%= FormatNumber.format(vlr_pg1, "##,##0.00") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 8%" >
                                <%= FormatNumber.format(clientes1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 10%" >
                                <%= FormatNumber.format(tot_pares1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: 10%" >
                                <%= FormatNumber.format(tot_vlr1, "##,##0.00") %>
                              </td>



                            </tr>

                            <%
                            _b0_control = _b0_value;
                            _b1_control = _b1_value;
                            i_ent_atu_1++;
                            if (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                              atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                              datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp1 = t_ent_ped_vw.getPr_pp();
                              vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                              pr_pg1 = t_ent_ped_vw.getPr_pg();
                              vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                              tot_pares1 = t_ent_ped_vw.getTot_pares();
                              tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                              clientes1 = t_ent_ped_vw.getClientes();
                              tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                              codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                              rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              codigo_marca1 = t_ent_ped_vw.getCodigo_marca();
                              descricao_marca1 = t_ent_ped_vw.getDescricao_marca()==null?"":t_ent_ped_vw.getDescricao_marca();
                              _b0_value = (atualizacao1==null?"":atualizacao1);
                              _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            } else {
                              _b0_control = "__";
                              _b1_control = "__";
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
                  if(session.getAttribute("tipoQuebra") != null && ((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("representante")
&& (!((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("giro_producao"))

){

                    boolean quebraMes = false;
                    if(session.getAttribute("dataSelecionada")!=null){
                      if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                        quebraMes = true;
                      }
                    }

                    String perc8 = "8%";
                    String perc10 = "10%";
                    String perc4 = "14%";
                    String perc6 = "16%";
                    if(quebraMes){
                      perc8 = "8%";
                      perc10 = "10%";
                      perc4 = "10%";
                      perc6 = "12%";
                    }

                    java.util.Vector res_Entrada_pedidos_atual_vw = (java.util.Vector)session.getAttribute("res_Entrada_pedidos_atual_vw");
                    %>

                    <form  name="bl_report_ent_ped_vw_1" id="bl_report_ent_ped_vw_1" class="baseForm" method="post" >


                      <%
                      if (res_Entrada_pedidos_atual_vw!=null && res_Entrada_pedidos_atual_vw.size()>0) {
                        %>

                        <br>
                        <br>

                        <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width:99%"  border="1" >

                          <tr class="reportTr">
                            <td class="columnTdHeader" style="text-align:left;" >
                            </td>


                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              Compra Rápida
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                              PG/EX
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                              <%
                              if(quebraMes){
                                %>
                                Total M&#281;s
                                <%
                              } else {
                                %>
                                Total
                                <%
                              }
                              %>
                            </td>

                            <%
                            if(quebraMes){
                              %>
                              <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                Total Ano
                              </td>
                              <%
                            }
                            %>

                          </tr>


                          <tr class="reportTr">

                            <td class="columnTdHeader" style="text-align: left;" width="1%" >
                              Representante
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Pares
                            </td>

                            <td class="columnTdHeader" style="text-align:center;" >
                              Valor
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Cli. Atd.
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Pares
                            </td>

                            <td class="totalColumn" style="color: black; text-align:center;" >
                              Valor
                            </td>

                            <%
                            if(quebraMes){
                              %>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Cli. Atd.
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Pares
                              </td>

                              <td style="color: black; text-align:center; background-color:#bfefff" >
                                Valor
                              </td>
                              <%
                            }
                            %>


                          </tr>

                          <%
                          String atualizacao1 =  null;
                          Integer codigo_regional1 =  null;
                          String datam1 =  null;
                          Double pr_pp1 =  null;
                          Double vlr_pp1 =  null;
                          Double pr_pg1 =  null;
                          Double vlr_pg1 =  null;
                          Double tot_pares1 =  null;
                          Double tot_vlr1 =  null;
                          String tipo1 =  null;
                          String sigla_regional =  null;
                          Integer codigo_gerente1 =  null;
                          Integer clientesr =  null;
                          String rep_cdgo1 =  null;
                          String rep_rzao1 =  null;
                          Integer total_pares_ano =  null;
                          Double total_valor_ano =  null;
                          Integer cli_atend_ano =  null;


                          String _b0_control = "__";
                          String _b1_control = "__";
                          int i_ent_atu_1 = 0;
                          while (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                            portalbr.dbobj.table.Entrada_pedidos_atual_vw t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                            atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                            codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                            datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                            pr_pp1 = t_ent_ped_vw.getPr_pp();
                            vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                            pr_pg1 = t_ent_ped_vw.getPr_pg();
                            vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                            tot_pares1 = t_ent_ped_vw.getTot_pares();
                            tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                            clientesr = t_ent_ped_vw.getClientes();
                            tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                            sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                            codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                            rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                            rep_rzao1 = t_ent_ped_vw.getRep_rzao()==null?"":t_ent_ped_vw.getRep_rzao();
                            total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                            total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                            cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
                            String _b0_value = (atualizacao1==null?"":atualizacao1);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>
                              <%
                            }
                            String _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            if (_b1_control != null && !_b1_control.equals(_b1_value)) {
                              %>

                              <%
                              if (false) {
                                %>
                                <tr class="reportHeader">
                                  <td colspan="10">
                                    <span class="columnTdHeader" style="text-align:right;" >
                                      Regional
                                      <%= sigla_regional %>
                                    </span>
                                  </td>
                                </tr>

                                <%
                              }
                              %>
                              <%
                              %>

                              <%
                            }
                            String st_bl_rep_Ent_ped_at_vw_1="";
                            if (!((i_ent_atu_1%2)!=0)) {
                              st_bl_rep_Ent_ped_at_vw_1="rowColor";
                            } else {
                              st_bl_rep_Ent_ped_at_vw_1="rowBlank";
                            }
                            %>

                            <tr class='<%= st_bl_rep_Ent_ped_at_vw_1 %>' id="TRbl_report_ent_ped_vw_1<%=i_ent_atu_1%>" >

                              <td class="reportColumn" style="text-align: left; width: <%= perc6 %>" >
                                <%= sigla_regional %>
                                -
                                <%= rep_cdgo1 %>
                                -
                                <%= rep_rzao1 %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pp1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pp1, "##,##0.00") %>
                              </td>



                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(pr_pg1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                <%= FormatNumber.format(vlr_pg1, "##,##0.00") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                <%= FormatNumber.format(clientesr, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_pares1, "#,##0.##") %>
                              </td>

                              <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                <%= FormatNumber.format(tot_vlr1, "##,##0.00") %>
                              </td>

                              <%
                              if(quebraMes){
                                %>
                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                   <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                </td>
                                <%
                              }
                              %>



                            </tr>

                            <%
                            _b0_control = _b0_value;
                            _b1_control = _b1_value;
                            i_ent_atu_1++;
                            if (i_ent_atu_1<res_Entrada_pedidos_atual_vw.size()) {
                              t_ent_ped_vw = (portalbr.dbobj.table.Entrada_pedidos_atual_vw)res_Entrada_pedidos_atual_vw.elementAt(i_ent_atu_1);
                              atualizacao1 = t_ent_ped_vw.getAtualizacao()==null?"":t_ent_ped_vw.getAtualizacao();
                              codigo_regional1 = t_ent_ped_vw.getCodigo_regional();
                              datam1 = t_ent_ped_vw.getDatam()==null?"":t_ent_ped_vw.getDatam();
                              pr_pp1 = t_ent_ped_vw.getPr_pp();
                              vlr_pp1 = t_ent_ped_vw.getVlr_pp();
                              pr_pg1 = t_ent_ped_vw.getPr_pg();
                              vlr_pg1 = t_ent_ped_vw.getVlr_pg();
                              tot_pares1 = t_ent_ped_vw.getTot_pares();
                              tot_vlr1 = t_ent_ped_vw.getTot_vlr();
                              clientesr = t_ent_ped_vw.getClientes();
                              tipo1 = t_ent_ped_vw.getTipo()==null?"":t_ent_ped_vw.getTipo();
                              sigla_regional = t_ent_ped_vw.getSigla_regional()==null?"":t_ent_ped_vw.getSigla_regional();
                              codigo_gerente1 = t_ent_ped_vw.getCodigo_gerente();
                              rep_cdgo1 = t_ent_ped_vw.getRep_cdgo()==null?"":t_ent_ped_vw.getRep_cdgo();
                              rep_rzao1 = t_ent_ped_vw.getRep_rzao()==null?"":t_ent_ped_vw.getRep_rzao();
                              total_pares_ano = t_ent_ped_vw.getTotal_pares_ano();
                              total_valor_ano = t_ent_ped_vw.getTotal_valor_ano();
                              cli_atend_ano = t_ent_ped_vw.getClientes_atendidos_ano();
                              _b0_value = (atualizacao1==null?"":atualizacao1);
                              _b1_value = (atualizacao1==null?"":atualizacao1) + "_" + FormatNumber.format(codigo_regional1);
                            } else {
                              _b0_control = "__";
                              _b1_control = "__";
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
                    java.util.Vector res_Jw_entrada_atual_pedidos_resumo_marcas = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_resumo_marcas");
                    boolean quebraMes = false;
                    if(session.getAttribute("dataSelecionada")!=null){
                      if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                        quebraMes = true;
                      }
                    }
                    %>

                    <form  name="bl_report_Jw_entrada_atual_pedidos_resumo_marcas" id="bl_report_Jw_entrada_atual_pedidos_resumo_marcas" class="baseForm" method="post" >


                      <%
                      if (res_Jw_entrada_atual_pedidos_resumo_marcas!=null && res_Jw_entrada_atual_pedidos_resumo_marcas.size()>0) {
                        %>

                        <table id="TRbl_report_Jw_entrada_atual_pedidos_resumo_marcas"  class="reportTable"   style="width:99%"  border="1" >
                          <%
                          java.lang.String atualizacao4 =  null;
                          java.lang.String datam4 =  null;
                          java.lang.Integer codigo_marca =  null;
                          java.lang.String descricao_marca =  null;
                          java.lang.String mes =  null;
                          java.lang.Integer pr_mes =  null;
                          java.lang.Double vlr_mes =  null;
                          java.lang.String mes1 =  null;
                          java.lang.Integer pr_mes1 =  null;
                          java.lang.Double vlr_mes1 =  null;
                          java.lang.String mes2 =  null;
                          java.lang.Integer pr_mes2 =  null;
                          java.lang.Double vlr_mes2 =  null;
                          java.lang.String mesn =  null;
                          java.lang.Integer pr_mesn =  null;
                          java.lang.Double vlr_mesn =  null;
                          java.lang.Integer total_pares =  null;
                          java.lang.Integer clientesm =  null;
                          java.lang.Double total_valor =  null;


                          java.lang.Integer total_pr_mes = 0;
                          java.lang.Double total_vlr_mes = 0.0;
                          java.lang.Integer total_pr_mes1 = 0;
                          java.lang.Double total_vlr_mes1 = 0.0;
                          java.lang.Integer total_pr_mes2 = 0;
                          java.lang.Double total_vlr_mes2 = 0.0;
                          java.lang.Integer total_pr_mesn = 0;
                          java.lang.Double total_vlr_mesn = 0.0;
                          java.lang.Integer total_total_pares = 0;
                          java.lang.Double total_total_valor = 0.0;
                          java.lang.Integer total_pares_ano = 0;
                          Integer cli_atend_ano = 0;
                          Integer clientes_mes1 = 0;
                          Integer clientes = 0;
                          Integer clientes_mes2 = 0;
                          Integer clientes_mesn = 0;
                          Integer tclientes_mes1 = 0;
                          Integer tclientes = 0;
                          Integer tclientes_mes2 = 0;
                          Integer tclientes_mesn = 0;
                          Double total_valor_ano = 0.0;
                          Integer sum_total_pares_ano = 0;
                          Double sum_total_valor_ano = 0.0;
                          Integer sum_clientes_atendidos_ano = 0;
                          Integer clientes_atendidos_geral_ano = 0;


                          String _b0_control = "__";
                          int i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas = 0;
                          while (i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas<res_Jw_entrada_atual_pedidos_resumo_marcas.size()) {
                            portalbr.dbobj.view.Jw_entrada_atual_pedidos_resumo_marcas t_ent_marcas = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_resumo_marcas)res_Jw_entrada_atual_pedidos_resumo_marcas.elementAt(i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas);
                            atualizacao4 = t_ent_marcas.getAtualizacao()==null?"":t_ent_marcas.getAtualizacao();
                            datam4 = t_ent_marcas.getDatam()==null?"":t_ent_marcas.getDatam();
                            codigo_marca = t_ent_marcas.getCodigo_marca();
                            descricao_marca = t_ent_marcas.getDescricao_marca()==null?"":t_ent_marcas.getDescricao_marca();
                            mes = t_ent_marcas.getMes()==null?"":t_ent_marcas.getMes();
                            pr_mes = t_ent_marcas.getPr_mes();
                            vlr_mes = t_ent_marcas.getVlr_mes();
                            clientesm = t_ent_marcas.getClientes();
                            mes1 = t_ent_marcas.getMes1()==null?"":t_ent_marcas.getMes1();
                            pr_mes1 = t_ent_marcas.getPr_mes1();
                            vlr_mes1 = t_ent_marcas.getVlr_mes1();
                            mes2 = t_ent_marcas.getMes2()==null?"":t_ent_marcas.getMes2();
                            pr_mes2 = t_ent_marcas.getPr_mes2();
                            vlr_mes2 = t_ent_marcas.getVlr_mes2();
                            mesn = t_ent_marcas.getMesn()==null?"":t_ent_marcas.getMesn();
                            pr_mesn = t_ent_marcas.getPr_mesn();
                            vlr_mesn = t_ent_marcas.getVlr_mesn();
                            total_pares = t_ent_marcas.getTotal_pares();
                            total_valor = t_ent_marcas.getTotal_valor();
                            total_pares = t_ent_marcas.getTotal_pares();
                            total_valor = t_ent_marcas.getTotal_valor();
                            total_pares_ano = t_ent_marcas.getTotal_pares_ano();
                            total_valor_ano = t_ent_marcas.getTotal_valor_ano();
                            cli_atend_ano = t_ent_marcas.getClientes_atendidos_ano();
                            clientes = t_ent_marcas.getClientes();
                            clientes_mes1 = t_ent_marcas.getClientes_mes1();
                            clientes_mes2 = t_ent_marcas.getClientes_mes2();
                            clientes_mesn = t_ent_marcas.getClientes_mesn();
                            clientes_atendidos_geral_ano = t_ent_marcas.getClientes_atendidos_geral_ano();
 
                            String _b0_value = (atualizacao4==null?"":atualizacao4);
                            if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                              %>

                              <tr class="reportHeader2">
                                <%
                                if(quebraMes){
                                  %>
                                  <td colspan="18">
                                    <%
                                  } else {
                                    %>
                                    <td colspan="15">
                                      <%
                                    }
                                    %>
                                    <div style="float: left">
                                      <span class="reportColumn" style="text-align:left;" >
                                        <big>
                                          Atualização:
                                        </big>
                                      </span>
                                      <span class="reportColumn" style="text-align:left;" >
                                        <big>
                                          <%= atualizacao4 %>
                                        </big>
                                      </span>
                                    </div>

                                    <%
                                    String msg = "";
                                    if(session.getAttribute("mensagem_dois_bilhoes")!=null){
                                      String m = (String)session.getAttribute("mensagem_dois_bilhoes");
                                      String[] valor = m.split("#");
                                      msg = (valor[0]).replace("?",FormatNumber.format(Double.parseDouble(valor[1].replace(",","")), "#,##0.##"));
                                    }
                                    %>
                                    <div style="float: right">
                                      <big>
                                        <%= msg %>
                                      </big>
                                    </div>

                                  </td>
                                </tr>

                                <%
                                %>

                                <tr class="reportTr">

                                  <td class="columnTdHeader" style="text-align:left;" >
                                  </td>

                                  <td class="columnTdHeader" style="text-align: center;" colspan="2" >
                                    <%= mes %>
                                  </td>

                                  <td class="columnTdHeader" style="text-align: center;" colspan="3">
                                    <%= mes1 %>
                                  </td>

                                  <td class="columnTdHeader" style="text-align: center;" colspan="3" >
                                    <%= mes2 %>
                                  </td>

                                  <td class="columnTdHeader" style="text-align: center;" colspan="3">
                                    <%= mesn %>
                                  </td>

                                  <td class="totalColumn" style="color: black; text-align: center;" colspan="3" >
                                    <%
                                    if(!quebraMes){
                                      %>
                                      Total (Calçados + Meias + Bolsas)
                        

                                      <%
                                    } else {
                                      %>
                                      Total Mês (Calçados + Meias + Bolsas)
                                      <%
                                    }
                                    %>
                                  </td>

                                  <%
                                  if(quebraMes){
                                    %>
                                    <td style="color: black; text-align: center; background-color:#bfefff" colspan="3" >
                                      Total Ano (Calçados + Meias + Bolsas)
                                    </td>
                                    <%
                                  }
                                  %>

                                </tr>

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

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Cli. Atd.
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Pares
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Valor
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Cli. Atd.
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Unid.
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Valor
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Cli. Atd.
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Kits
                                  </td>

                                  <td class="columnTdHeader" style="text-align:right;" >
                                    Valor
                                  </td>

                                  <td class="totalColumn" style="color: black; text-align:right;" >
                                    Cli. Atd.
                                  </td>

                                  <td class="totalColumn" style="color: black; text-align:right;" >
                                    Quantidade
                                  </td>

                                  <td class="totalColumn" style="color: black; text-align:right;" >
                                    Valor
                                  </td>

 

                                  <%
                                  if(quebraMes){
                                    %>

                                    <td style="color: black; text-align:right; background-color:#bfefff" >
                                      Cli. Atd.
                                    </td>

                                    <td style="color: black; text-align:right; background-color:#bfefff" >
                                      Quantidade
                                    </td>

                                    <td style="color: black; text-align:right; background-color:#bfefff" >
                                      Valor
                                    </td>
                                    <%
                                  }
                                  %>
                                </tr>
                                <%
                              }
                              String stl_bl_rep_rm="";
                              if (!((i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas%2)!=0)) {
                                stl_bl_rep_rm="rowColor";
                              } else {
                                stl_bl_rep_rm="rowBlank";
                              }
                              %>

                              <tr class='<%= stl_bl_rep_rm %>' id="TRbl_report_Jw_entrada_atual_pedidos_resumo_marcas<%=i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas%>" >

                                <td class="reportColumn" style="text-align:left;" >
                                  <%= descricao_marca %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(pr_mes, "#,##0.##") %>
                                  <%
                                  total_pr_mes += pr_mes;
                                  %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(vlr_mes, "##,##0.00") %>
                                  <%
                                  total_vlr_mes += vlr_mes;
                                  %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(clientes_mes1, "#,##0.##") %>
                                  <% tclientes_mes1 += clientes_mes1; %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(pr_mes1, "#,##0.##") %>
                                  <%
                                  total_pr_mes1 += pr_mes1;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(vlr_mes1, "##,##0.00") %>
                                  <%
                                  total_vlr_mes1 += vlr_mes1;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(clientes_mes2, "#,##0.##") %>
                                  <% tclientes_mes2 += clientes_mes2; %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(pr_mes2, "#,##0.##") %>
                                  <%
                                  total_pr_mes2 += pr_mes2;
                                  %>
                                </td>

                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(vlr_mes2, "##,##0.00") %>
                                  <%
                                  total_vlr_mes2 += vlr_mes2;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(clientes_mesn, "#,##0.##") %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(pr_mesn, "#,##0.##") %>
                                  <%
                                  total_pr_mesn += pr_mesn;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(vlr_mesn, "##,##0.00") %>
                                  <%
                                  total_vlr_mesn += vlr_mesn;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(clientesm, "#,##0.##") %>
                                  <% tclientes_mesn += clientes_mesn; %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(total_pares, "#,##0.##") %>
                                  <%
                                  total_total_pares += total_pares;
                                  %>
                                </td>
                                <td class="reportColumn" style="text-align:right;" >
                                  <%= FormatNumber.format(total_valor, "##,##0.00") %>
                                  <%
                                  total_total_valor += total_valor;
                                  %>
                                </td>

                                <%
                                if(quebraMes){
                                  %>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                    <% sum_clientes_atendidos_ano += cli_atend_ano; %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                    <%
                                    sum_total_pares_ano += total_pares_ano;
                                    %>
                                  </td>
                                  <td class="reportColumn" style="text-align:right;" >
                                    <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                    <%
                                    sum_total_valor_ano += total_valor_ano;
                                    %>
                                  </td>
                                  <%
                                }
                                %>

                              </tr>

                              <%
                              _b0_control = _b0_value;
                              i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas++;
                              if (i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas<res_Jw_entrada_atual_pedidos_resumo_marcas.size()) {
                                t_ent_marcas = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_resumo_marcas)res_Jw_entrada_atual_pedidos_resumo_marcas.elementAt(i_bl_report_Jw_entrada_atual_pedidos_resumo_marcas);
                                atualizacao4 = t_ent_marcas.getAtualizacao()==null?"":t_ent_marcas.getAtualizacao();
                                datam4 = t_ent_marcas.getDatam()==null?"":t_ent_marcas.getDatam();
                                codigo_marca = t_ent_marcas.getCodigo_marca();
                                descricao_marca = t_ent_marcas.getDescricao_marca()==null?"":t_ent_marcas.getDescricao_marca();
                                mes = t_ent_marcas.getMes()==null?"":t_ent_marcas.getMes();
                                pr_mes = t_ent_marcas.getPr_mes();
                                vlr_mes = t_ent_marcas.getVlr_mes();
                                clientesm = t_ent_marcas.getClientes();
                                mes1 = t_ent_marcas.getMes1()==null?"":t_ent_marcas.getMes1();
                                pr_mes1 = t_ent_marcas.getPr_mes1();
                                vlr_mes1 = t_ent_marcas.getVlr_mes1();
                                mes2 = t_ent_marcas.getMes2()==null?"":t_ent_marcas.getMes2();
                                pr_mes2 = t_ent_marcas.getPr_mes2();
                                vlr_mes2 = t_ent_marcas.getVlr_mes2();
                                mesn = t_ent_marcas.getMesn()==null?"":t_ent_marcas.getMesn();
                                pr_mesn = t_ent_marcas.getPr_mesn();
                                vlr_mesn = t_ent_marcas.getVlr_mesn();
                                total_pares = t_ent_marcas.getTotal_pares();
                                total_valor = t_ent_marcas.getTotal_valor();
                                total_pares_ano = t_ent_marcas.getTotal_pares_ano();
                                total_valor_ano = t_ent_marcas.getTotal_valor_ano();
                                cli_atend_ano = t_ent_marcas.getClientes_atendidos_ano();
                                clientes = t_ent_marcas.getClientes();
                                clientes_mes1 = t_ent_marcas.getClientes_mes1();
                                clientes_mes2 = t_ent_marcas.getClientes_mes2();
                                clientes_mesn = t_ent_marcas.getClientes_mesn();
                                clientes_atendidos_geral_ano = t_ent_marcas.getClientes_atendidos_geral_ano();
                                _b0_value = (atualizacao4==null?"":atualizacao4);
                              } else {
                                _b0_control = "__";
                              }
                            }
                            %>


                            <tr class="totalColumn">
                              <td class="totalTdColumn" style="text-align:right; font-weight: bold;" >
                                Total
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_pr_mes, "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_vlr_mes, "##,##0.00") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format((Integer)session.getAttribute("cli_atd_calcados"), "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_pr_mes1, "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_vlr_mes1, "##,##0.00") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format((Integer)session.getAttribute("cli_atd_botas"), "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_pr_mes2, "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_vlr_mes2, "##,##0.00") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format((Integer)session.getAttribute("cli_atd_meias"), "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_pr_mesn, "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_vlr_mesn, "##,##0.00") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format((Integer)session.getAttribute("cli_atd"), "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_total_pares, "#,##0.##") %>
                              </td>
                              <td style="text-align:right; font-weight: bold;">
                                <%= FormatNumber.format(total_total_valor, "##,##0.00") %>
                              </td>
                              <%
                              if(quebraMes){
                                %>
                                <td style="text-align:right; font-weight: bold; background-color:#bfefff">
                                  <%= FormatNumber.format(clientes_atendidos_geral_ano, "#,##0.##") %>
                                </td>
                                <td style="text-align:right; font-weight: bold; background-color:#bfefff">
                                  <%= FormatNumber.format(sum_total_pares_ano, "#,##0.##") %>
                                </td>
                                <td style="text-align:right; font-weight: bold; background-color:#bfefff">
                                  <%= FormatNumber.format(sum_total_valor_ano, "##,##0.00") %>
                                </td>
                                <%
                              }
                              %>
                            </tr>
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
                      java.util.Vector res_Jw_entrada_atual_pedidos_clientes = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_clientes");
                      boolean quebraMes = false;
                      if(session.getAttribute("dataSelecionada")!=null){
                        if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                          quebraMes = true;
                        }
                      }
                      String perc8 = "8%";
                      String perc10 = "10%";
                      String perc4 = "14%";
                      String perc6 = "16%";
                      if(quebraMes){
                        perc8 = "8%";
                        perc10 = "10%";
                        perc4 = "10%";
                        perc6 = "12%";
                      }
                      %>

                      <form  name="bl_report_Jw_entrada_atual_pedidos_clientes" id="bl_report_Jw_entrada_atual_pedidos_clientes" class="baseForm" method="post" >

                        <br>
                        <br>
                        <%
                        if (res_Jw_entrada_atual_pedidos_clientes!=null && res_Jw_entrada_atual_pedidos_clientes.size()>0) {
                          %>

                          <table id="TRbl_report_ent_ped_vw_1"  class="reportTable"   style="width:99%"  border="1" >
                            <%
                            String atualizacao5 =  null;
                            String datam5 =  null;
                            Integer pr_pp4 =  null;
                            Double vlr_pp4 =  null;
                            Integer pr_pg4 =  null;
                            Double vlr_pg4 =  null;
                            Integer tot_pares4 =  null;
                            Double tot_vlr4 =  null;
                            Integer cli_cdgo =  null;
                            String cli_rzao =  null;
                            Integer clientes4 = null;
                            Integer total_pares_ano =  null;
                            Double total_valor_ano =  null;
                            Integer cli_atend_ano =  null;
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                Compra Rápida
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                PG/EX
                              </td>
                              <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                                <%
                                if(quebraMes) {
                                  %>
                                  Total Mês
                                  <%
                                } else {
                                  %>
                                  Total
                                  <%
                                }
                                %>
                              </td>

                              <%
                              if(quebraMes) {
                                %>
                                <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                  Total Ano
                                </td>
                                <%
                              }
                              %>

                            </tr>
                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align: left;" width="1%" >
                                Cliente
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" >
                                Pares
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" >
                                Valor
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" >
                                Pares
                              </td>
                              <td class="columnTdHeader" style="text-align:center;" >
                                Valor
                              </td>
                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Cli. Atd.
                              </td>
                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Pares
                              </td>
                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Valor
                              </td>

                              <%
                              if(quebraMes){
                                %>
                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Cli. Atd.
                                </td>
                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Pares
                                </td>
                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Valor
                                </td>
                                <%
                              }
                              %>
                            </tr>

                            <%
                            int i_bl_report_Jw_entrada_atual_pedidos_clientes = 0;
                            while (i_bl_report_Jw_entrada_atual_pedidos_clientes<res_Jw_entrada_atual_pedidos_clientes.size()) {
                              portalbr.dbobj.view.Jw_entrada_atual_pedidos_clientes t_ent_cli = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_clientes)res_Jw_entrada_atual_pedidos_clientes.elementAt(i_bl_report_Jw_entrada_atual_pedidos_clientes);
                              atualizacao5 = t_ent_cli.getAtualizacao()==null?"":t_ent_cli.getAtualizacao();
                              datam5 = t_ent_cli.getDatam()==null?"":t_ent_cli.getDatam();
                              pr_pp4 = t_ent_cli.getPr_pp();
                              vlr_pp4 = t_ent_cli.getVlr_pp();
                              pr_pg4 = t_ent_cli.getPr_pg();
                              vlr_pg4 = t_ent_cli.getVlr_pg();
                              tot_pares4 = t_ent_cli.getTot_pares();
                              clientes4 = t_ent_cli.getClientes();
                              tot_vlr4 = t_ent_cli.getTot_vlr();
                              cli_cdgo = t_ent_cli.getCli_cdgo();
                              cli_rzao = t_ent_cli.getCli_rzao()==null?"":t_ent_cli.getCli_rzao();
                              total_pares_ano = t_ent_cli.getTotal_pares_ano();
                              total_valor_ano = t_ent_cli.getTotal_valor_ano();
                              cli_atend_ano = t_ent_cli.getClientes_atendidos_ano();
                              String style_bl_report_Jw_entrada_atual_pedidos_clientes="";
                              if (!((i_bl_report_Jw_entrada_atual_pedidos_clientes%2)!=0)) {
                                style_bl_report_Jw_entrada_atual_pedidos_clientes="rowColor";
                              } else {
                                style_bl_report_Jw_entrada_atual_pedidos_clientes="rowBlank";
                              }
                              %>

                              <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_clientes %>' id="TRbl_report_Jw_entrada_atual_pedidos_clientes<%=i_bl_report_Jw_entrada_atual_pedidos_clientes%>" >


                                <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
                                  <%= ((cli_cdgo!=null)?cli_cdgo.toString():"") %>
                                  -
                                  <%= cli_rzao %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pp4, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pp4, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pg4, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pg4, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                  <%= FormatNumber.format(clientes4, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_pares4, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_vlr4, "##,##0.00") %>
                                </td>

                                <%
                                if(quebraMes){
                                  %>
                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                     <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                  </td>
                                  <%
                                }
                                %>

                              </tr>

                              <%
                              i_bl_report_Jw_entrada_atual_pedidos_clientes++;
                              if (i_bl_report_Jw_entrada_atual_pedidos_clientes<res_Jw_entrada_atual_pedidos_clientes.size()) {
                                t_ent_cli = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_clientes)res_Jw_entrada_atual_pedidos_clientes.elementAt(i_bl_report_Jw_entrada_atual_pedidos_clientes);
                                atualizacao5 = t_ent_cli.getAtualizacao()==null?"":t_ent_cli.getAtualizacao();
                                datam5 = t_ent_cli.getDatam()==null?"":t_ent_cli.getDatam();
                                pr_pp4 = t_ent_cli.getPr_pp();
                                vlr_pp4 = t_ent_cli.getVlr_pp();
                                pr_pg4 = t_ent_cli.getPr_pg();
                                vlr_pg4 = t_ent_cli.getVlr_pg();
                                tot_pares4 = t_ent_cli.getTot_pares();
                                clientes4 = t_ent_cli.getClientes();
                                tot_vlr4 = t_ent_cli.getTot_vlr();
                                cli_cdgo = t_ent_cli.getCli_cdgo();
                                cli_rzao = t_ent_cli.getCli_rzao()==null?"":t_ent_cli.getCli_rzao();
                                total_pares_ano = t_ent_cli.getTotal_pares_ano();
                                total_valor_ano = t_ent_cli.getTotal_valor_ano();
                                cli_atend_ano = t_ent_cli.getClientes_atendidos_ano();
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
                    if(((String)session.getAttribute("tipoQuebra")).equalsIgnoreCase("faturamento")){
                      java.util.Vector res_Jw_entrada_atual_pedidos_faturamento = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_faturamento");
                      java.util.Vector res_Jw_entrada_atual_pedidos_faturamento_regionais = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_faturamento_regional");
                      %>

                      <form  name="bl_report_Jw_entrada_atual_pedidos_faturamento" id="bl_report_Jw_entrada_atual_pedidos_faturamento" class="baseForm" method="post" >

                        <%
                        if (res_Jw_entrada_atual_pedidos_faturamento!=null && res_Jw_entrada_atual_pedidos_faturamento.size()>0) {
                          %>

                          <center>
                            <table id="TRbl_report_Jw_entrada_atual_pedidos_faturamento"  class="reportTable" style="width: 99%; margin-top: -20px" border="1" >
                              <%
                              java.lang.String atualizacao6 =  null;
                              java.lang.String datam6 =  null;
                              java.lang.Integer pares_pp =  null;
                              java.lang.Integer pares_pg =  null;
                              java.lang.Double valor_pp =  null;
                              java.lang.Double valor_pg =  null;
                              java.lang.Integer pares_total = null;
                              java.lang.Double valor_total = null;
                              java.lang.Integer pares_ano = null;
                              java.lang.Double valor_ano = null;
                              java.lang.Integer totalParesFaturamento = 0;
                              java.lang.Double totalValorFaturamento = 0d;
                              java.lang.String tipo4 =  null;
                              java.lang.String pedTipo =  null;
                              java.lang.String tipoMercado =  null;
                              boolean consultaAno = false;
                              boolean quebraMes = false;
                              if(session.getAttribute("dataSelecionada")!=null){
                                 if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                                    quebraMes = true;
                                 }
                              }
                              String perc8 = "8%";
                              String perc10 = "10%";
                              String perc11 = "11%";
                              String perc12 = "12%";
                              String perc4 = "14%";
                              String percentual15 = "15%";
                              String perc6 = "16%";
                              if(quebraMes){
                                 perc8 = "8%";
                                 perc10 = "10%";
                                 perc4 = "10%";
                                 perc6 = "12%";
                              }
                              String _b0_control = "__";
                              int i_bl_report_Jw_entrada_atual_pedidos_faturamento = 0;
                              while (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento.size()) {
                                portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                String _b0_value = (atualizacao6==null?"":atualizacao6);
                                if (_b0_control != null && !_b0_control.equals(_b0_value)) {
                                  %>
                                  <tr class="reportHeader2">
                                    <% if(quebraMes) { %>
                                    <td colspan="9"> 
                                    <% } else { %>
                                    <td colspan="7"> 
                                    <% } %>
                                      <span class="reportColumn" style="text-align:left;" >
                                        <big>
                                          Atualização:
                                        </big>
                                      </span>
                                      <span class="reportColumn" style="text-align:left;" >
                                        <big>
                                          <%= atualizacao6 %>
                                        </big>
                                      </span>
                                    </td>
                                  </tr>
                                  <%
                                  %>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader">
                                    </td>

                                    <td class="columnTdHeader" style="text-align:center;" colspan="2">
                                      Compra Rápida
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center" colspan="2">
                                      PG/EX
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black" colspan="2">
                                      <% if(quebraMes) { %>
                                         Total Mês
                                      <% } else { %>
                                         Total
                                      <% } %>
                                    </td>

                                    <% if(quebraMes) { %>
                                       <td style="color: black; text-align:center; background-color:#bfefff" colspan="2">
                                         Total Ano
                                       </td>
                                    <% } %>

                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align: center">
                                      Dia
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Valor
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center;">
                                      Valor
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Pares
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Valor
                                    </td>

                                    <% if(quebraMes) { %>

                                       <td style="color: black; text-align:center; background-color:#bfefff">
                                         Pares
                                       </td>

                                       <td style="color: black; text-align:center; background-color:#bfefff">
                                         Valor
                                       </td>

                                    <% } %>

                                  </tr>

                                  <%
                                }
                                String stl_ent_ped_fat="";
                                if (!((i_bl_report_Jw_entrada_atual_pedidos_faturamento%2)!=0)) {
                                  stl_ent_ped_fat="rowColor";
                                } else {
                                  stl_ent_ped_fat="rowBlank";
                                }
                                if(datam6.equalsIgnoreCase("ano")){
                                  stl_ent_ped_fat="totalColumn";
                                }
                                %>

                                <tr class='<%= stl_ent_ped_fat %>' id="TRbl_report_Jw_entrada_atual_pedidos_faturamento<%=i_bl_report_Jw_entrada_atual_pedidos_faturamento%>" >

                                  <%
                                  if(quebraMes){
                                    consultaAno = true;
                                    %>
                                    
                                   <%  if(!datam6.equalsIgnoreCase("ano")) { %>
                                        
                                    <td class="reportColumn" style="text-align: center; width: <%= perc12 %>" >
                                      <b><%= datam6 %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(pares_pp, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(valor_pp, "##,##0.00") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(pares_pg, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(valor_pg, "##,##0.00") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(pares_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(valor_total, "##,##0.00") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(pares_ano, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(valor_ano, "##,##0.00") %></b>
                                    </td>

                                    <% } %>
                                    <%
                                  } else {
                                    %>
                                    <td class="reportColumn" style="text-align: center; width: <%= perc10 %>" >
                                        <%= datam6 %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pp, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pp, "##,##0.00") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pg, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pg, "##,##0.00") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total, "##,##0.00") %></b>
                                    </td>

                                    <%
                                  }
                                  %>

                                </tr>

                                <%
                                _b0_control = _b0_value;
                                i_bl_report_Jw_entrada_atual_pedidos_faturamento++;
                                if (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento.size()) {
                                  t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                  atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                  datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                  pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                  pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                  valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                  valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                  pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                  valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                  pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                  valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                  tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                  pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                  tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                  _b0_value = (atualizacao6==null?"":atualizacao6);
                                } else {
                                  _b0_control = "__";
                                }
                              }
                              %>

                            </table>




</table>
  <% } %>
  
  
  

  
  
  
                          <%
						  {
                        if (res_Jw_entrada_atual_pedidos_faturamento_regionais !=null && res_Jw_entrada_atual_pedidos_faturamento_regionais.size()>0) {
                          %>
<br><br>
                          <center>
                            <table id="TRbl_report_Jw_entrada_atual_pedidos_faturamento2" class="reportTable" style="width:99%" border="1" >
                              <%
                              java.lang.String atualizacao6 =  null;
                              java.lang.String datam6 =  null;
                              java.lang.Integer pares_pp =  null;
                              java.lang.Integer pares_pg =  null;
                              java.lang.Double valor_pp =  null;
                              java.lang.Double valor_pg =  null;
                              java.lang.Integer pares_total =  null;
                              java.lang.Double valor_total =  null;
                              java.lang.Integer pares_pp_total = 0;
                              java.lang.Integer pares_pg_total = 0;
                              java.lang.Double valor_pp_total = 0d;
                              java.lang.Double valor_pg_total = 0d;
                              java.lang.Integer pares_total_total = 0;
                              java.lang.Double valor_total_total = 0d;
                              java.lang.Integer valor_total_ano = 0;
                              java.lang.Double pares_total_ano = 0d;
                              java.lang.Integer pares_ano = 0;
                              java.lang.Double valor_ano = 0d;
                              java.lang.Integer totalParesFaturamento = 0;
                              java.lang.Double totalValorFaturamento = 0d;
                              java.lang.String tipo4 = null;
                              java.lang.String pedTipo = null;
                              java.lang.String regional = null;
                              java.lang.String tipoMercado = null;
                              boolean consultaAno = false;
                              boolean quebraMes = false;
                              if(session.getAttribute("dataSelecionada")!=null){
                                 if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                                    quebraMes = true;
                                 }
                              }
                              String perc8 = "8%";
                              String perc10 = "10%";
                              String perc11 = "11%";
                              String perc12 = "12%";
                              String perc4 = "14%";
                              String percentual15 = "15%";
                              String perc6 = "16%";
                              if(quebraMes){
                                 perc8 = "8%";
                                 perc10 = "10%";
                                 perc4 = "10%";
                                 perc6 = "12%";
                              }

%>
                                  <tr class="reportTr">
                                    <td class="columnTdHeader">
                                      Mercado Interno
                                    </td>

                                    <td class="columnTdHeader" style="text-align:center;" colspan="2">
                                      Compra Rápida
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center" colspan="2">
                                      PG/EX
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black" colspan="2">
                                      <% if(quebraMes) { %>
                                         Total Mês
                                      <% } else { %>
                                      Total
                                      <% } %>
                                    </td>

                                    <% if(quebraMes){ %>
                                      <td style="color: black; text-align:center; background-color:#bfefff" colspan="2" >
                                        Total Ano
                                      </td>
                                    <% } %>

                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align: center">
                                      Regional
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Valor
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center;">
                                      Valor
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Pares
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Valor
                                    </td>

                                    <% if(quebraMes){ %>
                                      <td style="color: black; text-align:center; background-color:#bfefff" >
                                        Pares
                                      </td>

                                      <td style="color: black; text-align:center; background-color:#bfefff" >
                                        Valor
                                      </td>
                                   <% } %>


                                  </tr>
<%

                              String _b0_control = "__";
                              int i_bl_report_Jw_entrada_atual_pedidos_faturamento = 0;
                              while (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento_regionais.size()) {
                                portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento_regionais.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                regional = t_jw_entrada_atual_pedidos_faturamento.getRegional()==null?"":t_jw_entrada_atual_pedidos_faturamento.getRegional();
                                String _b0_value = (atualizacao6==null?"":atualizacao6);
                               
                                if(tipoMercado.equals("ME")){
                                   possuiMercadoExterno = true;
                                }

                                if(tipoMercado.equals("MI")){

                                String stl_ent_ped_fat="";
                                if (!((i_bl_report_Jw_entrada_atual_pedidos_faturamento%2)!=0)) {
                                  stl_ent_ped_fat="rowColor";
                                } else {
                                  stl_ent_ped_fat="rowBlank";
                                }
                                if(datam6.equalsIgnoreCase("ano")){
                                  stl_ent_ped_fat="totalColumn";
                                }
                                %>

                                <tr class='<%= stl_ent_ped_fat %>' id="TRbl_report_Jw_entrada_atual_pedidos_faturamento<%=i_bl_report_Jw_entrada_atual_pedidos_faturamento%>" >

                                  <%
                                  if(datam6.equalsIgnoreCase("ano") || datam6.equalsIgnoreCase("mes")){
                                    consultaAno = true;
                                    %>
                                    
                                   <%  if(!datam6.equalsIgnoreCase("ano")) { %>
                                        
                                    <td class="reportColumn" style="text-align: center; width: <%= perc10 %>" >
                                      <b>
                                        <%= regional %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(pares_pp, "#,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(valor_pp, "##,##0.00") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(pares_pg, "#,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(valor_pg, "##,##0.00") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(pares_total, "#,##0.##") %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= percentual15 %>" >
                                      <b>
                                        <%= FormatNumber.format(valor_total, "##,##0.00") %>
                                      </b>
                                    </td>

                                    <% if(quebraMes) { %>
                                    <td class="reportColumn" style="text-align: right; width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(pares_ano, "#,##0.##") %></b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: width: <%= perc11 %>" >
                                      <b><%= FormatNumber.format(valor_ano, "##,##0.00") %></b>
                                    </td>
                                    <% } %>


                                    <% } %>
                                    <%
                                  } else {
                                    %>
                                    <td class="reportColumn" style="text-align: center; width: <%= quebraMes?perc12:perc10 %>" >
                                        <%= regional %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pp, "#,##0.##") %></b>
                                      <% pares_pp_total += pares_pp; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pp, "##,##0.00") %></b>
                                      <% valor_pp_total += valor_pp; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pg, "#,##0.##") %></b>
                                      <% pares_pg_total += pares_pg; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pg, "##,##0.00") %></b>
                                      <% valor_pg_total += valor_pg; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total, "#,##0.##") %></b>
                                      <% pares_total_total += pares_total; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total, "##,##0.00") %></b>
                                      <% valor_total_total += valor_total; %>
                                    </td>

                                    <% if(quebraMes) { %>
                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_ano, "#,##0.##") %></b>
                                      <% pares_total_ano += pares_ano; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_ano, "##,##0.00") %></b>
                                      <% valor_total_ano += valor_ano; %>
                                    </td>
                                    <% } %>

                                    <%
                                  }
                                  %>

                                </tr>
                                <% } %>

                              


                                <%
                                _b0_control = _b0_value;
                                i_bl_report_Jw_entrada_atual_pedidos_faturamento++;
                                if (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento.size()) {
                                  t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                  atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                  datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                  pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                  pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                  valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                  valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                  pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                  valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                  pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                  valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                  tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                  pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                  tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                  regional = t_jw_entrada_atual_pedidos_faturamento.getRegional()==null?"":t_jw_entrada_atual_pedidos_faturamento.getRegional();
                                  _b0_value = (atualizacao6==null?"":atualizacao6);
                                } else {
                                  _b0_control = "__";
                                }
                              }
                              %>

                                <tr>
                                    <td class="totalColumn" style="text-align: center; width: <%= quebraMes?perc12:perc10 %>" >
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pp_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pp_total, "##,##0.00") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pg_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pg_total, "##,##0.00") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total_total, "##,##0.00") %></b>
                                    </td>

                                    <% if(quebraMes) { %>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total_ano, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total_ano, "##,##0.00") %></b>
                                    </td>

                                    <% } %>
                                </tr>




                            </table>
</table>
  <% } %>
						  <% } %>
  
  
  
  
  
  
  



  
                          <%
						  {
                        if (res_Jw_entrada_atual_pedidos_faturamento_regionais !=null && res_Jw_entrada_atual_pedidos_faturamento_regionais.size()>0 && possuiMercadoExterno) {
                          %>

<br><br>
                          <center>
                            <table id="TRbl_report_Jw_entrada_atual_pedidos_faturamento2"  class="reportTable" style="width:99%" border="1" >
                              <%
                              java.lang.String atualizacao6 =  null;
                              java.lang.String datam6 =  null;
                              java.lang.Integer pares_pp =  null;
                              java.lang.Integer pares_pg =  null;
                              java.lang.Double valor_pp =  null;
                              java.lang.Double valor_pg =  null;
                              java.lang.Integer pares_total =  null;
                              java.lang.Double valor_total =  null;
                              java.lang.Integer pares_pp_total = 0;
                              java.lang.Integer pares_pg_total = 0;
                              java.lang.Double valor_pp_total = 0d;
                              java.lang.Double valor_pg_total = 0d;
                              java.lang.Integer pares_total_total = 0;
                              java.lang.Double valor_total_total = 0d;
                              java.lang.Integer valor_total_ano = 0;
                              java.lang.Double pares_total_ano = 0d;
                              java.lang.Integer pares_ano = 0;
                              java.lang.Double valor_ano = 0d;
                              java.lang.Integer totalParesFaturamento = 0;
                              java.lang.Double totalValorFaturamento = 0d;
                              java.lang.String tipo4 = null;
                              java.lang.String pedTipo = null;
                              java.lang.String tipoMercado = null;
                              java.lang.String regional = null;
                              boolean consultaAno = false;
                              boolean quebraMes = false;
                              if(session.getAttribute("dataSelecionada")!=null){
                                 if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                                    quebraMes = true;
                                 }
                              }
                              String perc8 = "8%";
                              String perc10 = "10%";
                              String perc11 = "11%";
                              String perc12 = "12%";
                              String perc4 = "14%";
                              String percentual15 = "15%";
                              String perc6 = "16%";
                              if(quebraMes){
                                 perc8 = "8%";
                                 perc10 = "10%";
                                 perc4 = "10%";
                                 perc6 = "12%";
                              }

%>
                                  <tr class="reportTr">
                                    <td class="columnTdHeader">
                                      Mercado Externo
                                    </td>

                                    <td class="columnTdHeader" style="text-align:center;" colspan="2">
                                      Compra Rápida
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center" colspan="2">
                                      PG/EX
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black" colspan="2">
                                      <% if(quebraMes) { %>
                                         Total Mês
                                      <% } else { %>
                                      Total
                                      <% } %>
                                    </td>

                                    <% if(quebraMes){ %>
                                      <td style="color: black; text-align:center; background-color:#bfefff" colspan="2" >
                                        Total Ano
                                      </td>
                                    <% } %>

                                  </tr>

                                  <tr class="reportTr">
                                    <td class="columnTdHeader" style="text-align: center">
                                      Regional
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Valor
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center">
                                      Pares
                                    </td>

                                    <td class="columnTdHeader" style="text-align: center;">
                                      Valor
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Pares
                                    </td>

                                    <td class="totalColumn" style="text-align: center; color: black">
                                      Valor
                                    </td>

        <% if(quebraMes){ %>
                                      <td style="color: black; text-align:center; background-color:#bfefff" >
                                        Pares
                                      </td>

                                      <td style="color: black; text-align:center; background-color:#bfefff" >
                                        Valor
                                      </td>
                                   <% } %>

                                  </tr>
<%

                              String _b0_control = "__";
                              int i_bl_report_Jw_entrada_atual_pedidos_faturamento = 0;
                              while (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento_regionais.size()) {
                                portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento_regionais.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                regional = t_jw_entrada_atual_pedidos_faturamento.getRegional()==null?"":t_jw_entrada_atual_pedidos_faturamento.getRegional();
                                String _b0_value = (atualizacao6==null?"":atualizacao6);
                               
                                if(tipoMercado.equals("ME")){

                                String stl_ent_ped_fat="";
                                if (!((i_bl_report_Jw_entrada_atual_pedidos_faturamento%2)!=0)) {
                                  stl_ent_ped_fat="rowColor";
                                } else {
                                  stl_ent_ped_fat="rowBlank";
                                }
                                if(datam6.equalsIgnoreCase("ano")){
                                  stl_ent_ped_fat="totalColumn";
                                }
                                %>

                                <tr class='<%= stl_ent_ped_fat %>' id="TRbl_report_Jw_entrada_atual_pedidos_faturamento<%=i_bl_report_Jw_entrada_atual_pedidos_faturamento%>" >

                                  <%
                                  if(datam6.equalsIgnoreCase("ano") || datam6.equalsIgnoreCase("mes")){
                                    consultaAno = true;
                                    %>
                                    
                                   <%  if(!datam6.equalsIgnoreCase("ano")) { %>
                                        
                                    <td class="reportColumn" style="text-align:left;" >
                                      <b>
                                        <%= regional %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(pares_pp, "#,##0.##") %>
                                        <% pares_pp_total += pares_pp; %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(valor_pp, "##,##0.00") %>
                                        <% valor_pp_total += valor_pp; %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(pares_pg, "#,##0.##") %>
                                        <% pares_pg_total += pares_pg; %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(valor_pg, "##,##0.00") %>
                                        <% valor_pg_total += valor_pg; %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(pares_total, "#,##0.##") %>
                                        <% pares_total_total += pares_total; %>
                                      </b>
                                    </td>

                                    <td class="reportColumn" style="text-align: right;" >
                                      <b>
                                        <%= FormatNumber.format(valor_total, "##,##0.00") %>
                                        <% valor_total_total += valor_total; %>
                                      </b>
                                    </td>

                                    <% } %>
                                    <%
                                  } else {
                                    %>
                                    <td class="reportColumn" style="text-align: center; width: <%= quebraMes?perc12:perc10 %>" >
                                        <%= regional %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pp, "#,##0.##") %></b>
                                        <% pares_pp_total += pares_pp; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pp, "##,##0.00") %></b>
                                        <% valor_pp_total += valor_pp; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pg, "#,##0.##") %></b>
                                        <% pares_pg_total += pares_pg; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pg, "##,##0.00") %></b>
                                        <% valor_pg_total += valor_pg; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total, "#,##0.##") %></b>
                                        <% pares_total_total += pares_total; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total, "##,##0.00") %></b>
                                        <% valor_total_total += valor_total; %>
                                    </td>

                                    <% if(quebraMes) { %>
                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_ano, "#,##0.##") %></b>
                                      <% pares_total_ano += pares_ano; %>
                                    </td>

                                    <td class="reportColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_ano, "##,##0.00") %></b>
                                      <% valor_total_ano += valor_ano; %>
                                    </td>
                                    <% } %>


                                    <%
                                  }
                                  %>

                                </tr>
                                <% } %>

                                <%
                                _b0_control = _b0_value;
                                i_bl_report_Jw_entrada_atual_pedidos_faturamento++;
                                if (i_bl_report_Jw_entrada_atual_pedidos_faturamento<res_Jw_entrada_atual_pedidos_faturamento.size()) {
                                  t_jw_entrada_atual_pedidos_faturamento = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_faturamento)res_Jw_entrada_atual_pedidos_faturamento.elementAt(i_bl_report_Jw_entrada_atual_pedidos_faturamento);
                                  atualizacao6 = t_jw_entrada_atual_pedidos_faturamento.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_faturamento.getAtualizacao();
                                  datam6 = t_jw_entrada_atual_pedidos_faturamento.getDatam()==null?"":t_jw_entrada_atual_pedidos_faturamento.getDatam();
                                  pares_pp = t_jw_entrada_atual_pedidos_faturamento.getPares_pp();
                                  pares_pg = t_jw_entrada_atual_pedidos_faturamento.getPares_pg();
                                  valor_pp = t_jw_entrada_atual_pedidos_faturamento.getValor_pp();
                                  valor_pg = t_jw_entrada_atual_pedidos_faturamento.getValor_pg();
                                  pares_total = t_jw_entrada_atual_pedidos_faturamento.getPares_total();
                                  valor_total = t_jw_entrada_atual_pedidos_faturamento.getValor_total();
                                  pares_ano = t_jw_entrada_atual_pedidos_faturamento.getPares_ano();
                                  valor_ano = t_jw_entrada_atual_pedidos_faturamento.getValor_ano();
                                  tipo4 = t_jw_entrada_atual_pedidos_faturamento.getTipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo();
                                  pedTipo = t_jw_entrada_atual_pedidos_faturamento.getPed_tipo()==null?"":t_jw_entrada_atual_pedidos_faturamento.getPed_tipo();
                                  tipoMercado = t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado()==null?"":t_jw_entrada_atual_pedidos_faturamento.getTipo_mercado();
                                  regional = t_jw_entrada_atual_pedidos_faturamento.getRegional()==null?"":t_jw_entrada_atual_pedidos_faturamento.getRegional();
                                  _b0_value = (atualizacao6==null?"":atualizacao6);
                                } else {
                                  _b0_control = "__";
                                }
                              }
                              %>
  <tr>
                                    <td class="totalColumn" style="text-align: center; width: <%= quebraMes?perc12:perc10 %>" >
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pp_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pp_total, "##,##0.00") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_pg_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_pg_total, "##,##0.00") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total_total, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total_total, "##,##0.00") %></b>
                                    </td>

                                      <% if(quebraMes) { %>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(pares_total_ano, "#,##0.##") %></b>
                                    </td>

                                    <td class="totalColumn" style="text-align: right; width: <%= quebraMes?perc11:percentual15 %>" >
                                      <b><%= FormatNumber.format(valor_total_ano, "##,##0.00") %></b>
                                    </td>

                                    <% } %>
                                </tr>




                            </table>
</table>
<br><br>
  <% } %>
						  <% } %>
  
  
  











  
  
  
  
  

                          </center>

            




<% } %>




                      </form>
					  
                    
                    <%
                    {
                      %>

                      <%
                      java.util.Vector res_Jw_entrada_atual_pedidos_grupos = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_grupos");
                      boolean quebraMes = false;
                      if(session.getAttribute("dataSelecionada")!=null){
                        if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
                          quebraMes = true;
                        }
                      }

                      String perc8 = "8%";
                      String perc10 = "10%";
                      String perc4 = "14%";
                      String perc6 = "16%";
                      if(quebraMes){
                        perc8 = "8%";
                        perc10 = "10%";
                        perc4 = "10%";
                        perc6 = "12%";
                      }
                      %>

                      <form  name="bl_report_Jw_entrada_atual_pedidos_grupos" id="bl_report_Jw_entrada_atual_pedidos_grupos" class="baseForm" method="post" >

                        <%
                        if (res_Jw_entrada_atual_pedidos_grupos!=null && res_Jw_entrada_atual_pedidos_grupos.size()>0) {
                          %>

                          <table id="TRbl_report_Jw_entrada_atual_pedidos_grupos"  class="reportTable" style="width:99%" border="1" >
                            <%
                            String atualizacao7 =  null;
                            String datam7 =  null;
                            double pr_pp5 =  0;
                            double vlr_pp5 =  0;
                            double pr_pg5 =  0;
                            double vlr_pg5 =  0;
                            double tot_pares5 =  0;
                            double tot_vlr5 =  0;
                            Integer clientes5 = null;
                            Integer total_pares_ano = null;
                            Double total_valor_ano = null;
                            String gre_descricao =  null;
                            Integer cli_atend_ano = null;
                            %>

                            <tr class="reportTr">
                              <td class="columnTdHeader" style="text-align:left;" >
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                Compra Rápida
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" colspan="2" >
                                PG/EX
                              </td>

                              <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
                                <%
                                if(quebraMes){
                                  %>
                                  Total Mês
                                  <%
                                } else {
                                  %>
                                  Total
                                  <%
                                }
                                %>
                              </td>

                              <%
                              if(quebraMes){
                                %>
                                <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
                                  Total Ano
                                </td>
                                <%
                              }
                              %>

                            </tr>



                            <tr class="reportTr">

                              <td class="columnTdHeader" style="text-align: left;" width="1%" >
                                Grupo
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Valor
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Pares
                              </td>

                              <td class="columnTdHeader" style="text-align:center;" >
                                Valor
                              </td>

                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Cli. Atd.
                              </td>

                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Pares
                              </td>

                              <td class="totalColumn" style="color: black; text-align:center;" >
                                Valor
                              </td>

                              <%
                              if(quebraMes){
                                %>

                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Cli. Atd.
                                </td>

                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Pares
                                </td>

                                <td style="color: black; text-align:center; background-color:#bfefff" >
                                  Valor
                                </td>
                                <%
                              }
                              %>

                            </tr>

                            <%
                            int i_bl_report_Jw_entrada_atual_pedidos_grupos = 0;
                            while (i_bl_report_Jw_entrada_atual_pedidos_grupos<res_Jw_entrada_atual_pedidos_grupos.size()) {
                              portalbr.dbobj.view.Jw_entrada_atual_pedidos_grupos t_jw_entrada_atual_pedidos_grupos = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_grupos)res_Jw_entrada_atual_pedidos_grupos.elementAt(i_bl_report_Jw_entrada_atual_pedidos_grupos);
                              atualizacao7 = t_jw_entrada_atual_pedidos_grupos.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_grupos.getAtualizacao();
                              datam7 = t_jw_entrada_atual_pedidos_grupos.getDatam()==null?"":t_jw_entrada_atual_pedidos_grupos.getDatam();
                              pr_pp5 = t_jw_entrada_atual_pedidos_grupos.getPr_pp();
                              vlr_pp5 = t_jw_entrada_atual_pedidos_grupos.getVlr_pp();
                              pr_pg5 = t_jw_entrada_atual_pedidos_grupos.getPr_pg();
                              vlr_pg5 = t_jw_entrada_atual_pedidos_grupos.getVlr_pg();
                              tot_pares5 = t_jw_entrada_atual_pedidos_grupos.getTot_pares();
                              tot_vlr5 = t_jw_entrada_atual_pedidos_grupos.getTot_vlr();
                              clientes5 = t_jw_entrada_atual_pedidos_grupos.getClientes();
                              gre_descricao = t_jw_entrada_atual_pedidos_grupos.getGre_descricao()==null?"":t_jw_entrada_atual_pedidos_grupos.getGre_descricao();
                              total_pares_ano = t_jw_entrada_atual_pedidos_grupos.getTotal_pares_ano();
                              total_valor_ano = t_jw_entrada_atual_pedidos_grupos.getTotal_valor_ano();
                              cli_atend_ano = t_jw_entrada_atual_pedidos_grupos.getClientes_atendidos_ano();
                              String style_bl_report_Jw_entrada_atual_pedidos_grupos="";
                              if (!((i_bl_report_Jw_entrada_atual_pedidos_grupos%2)!=0)) {
                                style_bl_report_Jw_entrada_atual_pedidos_grupos="rowColor";
                              } else {
                                style_bl_report_Jw_entrada_atual_pedidos_grupos="rowBlank";
                              }
                              %>

                              <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_grupos %>' id="TRbl_report_Jw_entrada_atual_pedidos_grupos<%=i_bl_report_Jw_entrada_atual_pedidos_grupos%>" >


                                <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
                                  <%= gre_descricao %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pp5, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pp5, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(pr_pg5, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
                                  <%= FormatNumber.format(vlr_pg5, "##,##0.00") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
                                  <%= FormatNumber.format(clientes5, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_pares5, "#,##0.##") %>
                                </td>

                                <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                  <%= FormatNumber.format(tot_vlr5, "##,##0.00") %>
                                </td>

                                <%
                                if(quebraMes){
                                  %>
                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                     <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
                                  </td>

                                  <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
                                    <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
                                  </td>
                                  <%
                                }
                                %>




                              </tr>

                              <%
                              i_bl_report_Jw_entrada_atual_pedidos_grupos++;
                              if (i_bl_report_Jw_entrada_atual_pedidos_grupos<res_Jw_entrada_atual_pedidos_grupos.size()) {
                                t_jw_entrada_atual_pedidos_grupos = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_grupos)res_Jw_entrada_atual_pedidos_grupos.elementAt(i_bl_report_Jw_entrada_atual_pedidos_grupos);
                                atualizacao7 = t_jw_entrada_atual_pedidos_grupos.getAtualizacao()==null?"":t_jw_entrada_atual_pedidos_grupos.getAtualizacao();
                                datam7 = t_jw_entrada_atual_pedidos_grupos.getDatam()==null?"":t_jw_entrada_atual_pedidos_grupos.getDatam();
                                pr_pp5 = t_jw_entrada_atual_pedidos_grupos.getPr_pp();
                                vlr_pp5 = t_jw_entrada_atual_pedidos_grupos.getVlr_pp();
                                pr_pg5 = t_jw_entrada_atual_pedidos_grupos.getPr_pg();
                                vlr_pg5 = t_jw_entrada_atual_pedidos_grupos.getVlr_pg();
                                tot_pares5 = t_jw_entrada_atual_pedidos_grupos.getTot_pares();
                                tot_vlr5 = t_jw_entrada_atual_pedidos_grupos.getTot_vlr();
                                clientes5 = t_jw_entrada_atual_pedidos_grupos.getClientes();
                                gre_descricao = t_jw_entrada_atual_pedidos_grupos.getGre_descricao()==null?"":t_jw_entrada_atual_pedidos_grupos.getGre_descricao();
                                total_pares_ano = t_jw_entrada_atual_pedidos_grupos.getTotal_pares_ano();
                                total_valor_ano = t_jw_entrada_atual_pedidos_grupos.getTotal_valor_ano();
                                cli_atend_ano = t_jw_entrada_atual_pedidos_grupos.getClientes_atendidos_ano();
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
  java.util.Vector res_Jw_entrada_atual_pedidos_estilos = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_estilos");
  boolean quebraMes = false;
  if(session.getAttribute("dataSelecionada")!=null){
     if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
        quebraMes = true;
     }
  }
  
  String perc8 = "8%";
  String perc10 = "10%";
  String perc4 = "14%";
  String perc6 = "16%";
  if(quebraMes){
     perc8 = "8%";
     perc10 = "10%";
     perc4 = "10%";
     perc6 = "12%";
  }
  %>

  <form  name="bl_report_Jw_entrada_atual_pedidos_estilos" id="bl_report_Jw_entrada_atual_pedidos_estilos" class="baseForm" method="post" >

    <%
    if (res_Jw_entrada_atual_pedidos_estilos !=null && res_Jw_entrada_atual_pedidos_estilos.size()>0) {
      %>

      <table id="TRbl_report_Jw_entrada_atual_pedidos_estilos"  class="reportTable" style="width:99%" border="1" >
        <%
        String atualizacao7 =  null;
        String datam7 =  null;
        double pr_pp5 =  0;
        double vlr_pp5 =  0;
        double pr_pg5 =  0;
        double vlr_pg5 =  0;
        double tot_pares5 =  0;
        double tot_vlr5 =  0;
        Integer clientes5 = null;
        Integer total_pares_ano = null;
        Integer cli_atend_ano = null;
        Double total_valor_ano = null;
        String descricao_estilos =  null;
        %>

          <tr class="reportTr">
            <td class="columnTdHeader" style="text-align:left;" >
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              Compra Rápida
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              PG/EX
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
            <% if(quebraMes){ %>
              Total Mês
            <% } else { %>
              Total
            <% } %> 
            </td>

            <% if(quebraMes){ %>
            <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
              Total Ano
            </td>
            <% } %>

          </tr>



        <tr class="reportTr">

         <td class="columnTdHeader" style="text-align: left;" width="1%" >
              Estilo
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Cli. Atd.
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Pares
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Valor
            </td>

            <% if(quebraMes){ %>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Cli. Atd.
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Pares
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Valor
            </td>
            <% } %>

        </tr>

        <%
        int i_bl_report_Jw_entrada_atual_pedidos_estilos = 0;
        while (i_bl_report_Jw_entrada_atual_pedidos_estilos<res_Jw_entrada_atual_pedidos_estilos.size()) {
          portalbr.dbobj.view.Jw_entrada_atual_pedidos_estilos t_Jw_entrada_atual_pedidos_estilos = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_estilos)res_Jw_entrada_atual_pedidos_estilos.elementAt(i_bl_report_Jw_entrada_atual_pedidos_estilos);
          atualizacao7 = t_Jw_entrada_atual_pedidos_estilos.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_estilos.getAtualizacao();
          datam7 = t_Jw_entrada_atual_pedidos_estilos.getDatam()==null?"":t_Jw_entrada_atual_pedidos_estilos.getDatam();
          pr_pp5 = t_Jw_entrada_atual_pedidos_estilos.getPr_pp();
          vlr_pp5 = t_Jw_entrada_atual_pedidos_estilos.getVlr_pp();
          pr_pg5 = t_Jw_entrada_atual_pedidos_estilos.getPr_pg();
          vlr_pg5 = t_Jw_entrada_atual_pedidos_estilos.getVlr_pg();
          tot_pares5 = t_Jw_entrada_atual_pedidos_estilos.getTot_pares();
          tot_vlr5 = t_Jw_entrada_atual_pedidos_estilos.getTot_vlr();
          clientes5 = t_Jw_entrada_atual_pedidos_estilos.getClientes();
          descricao_estilos = t_Jw_entrada_atual_pedidos_estilos.getDescricao_estilos()==null?"":t_Jw_entrada_atual_pedidos_estilos.getDescricao_estilos();
          total_pares_ano = t_Jw_entrada_atual_pedidos_estilos.getTotal_pares_ano();
  	      total_valor_ano = t_Jw_entrada_atual_pedidos_estilos.getTotal_valor_ano();
  	      cli_atend_ano = t_Jw_entrada_atual_pedidos_estilos.getClientes_atendidos_ano();
          String style_bl_report_Jw_entrada_atual_pedidos_estilos="";
          if (!((i_bl_report_Jw_entrada_atual_pedidos_estilos%2)!=0)) {
            style_bl_report_Jw_entrada_atual_pedidos_estilos="rowColor";
          } else {
            style_bl_report_Jw_entrada_atual_pedidos_estilos="rowBlank";
          }
          %>

          <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_estilos %>' id="TRbl_report_Jw_entrada_atual_pedidos_estilos<%=i_bl_report_Jw_entrada_atual_pedidos_estilos%>" >


            <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
              <%= descricao_estilos %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pp5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pp5, "##,##0.00") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pg5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pg5, "##,##0.00") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
              <%= FormatNumber.format(clientes5, "#,##0.##") %>
            </td>	

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_pares5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_vlr5, "##,##0.00") %>
            </td>

            <% if(quebraMes){ %>
            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
               <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
            </td>
            <% } %>




          </tr>

          <%
          i_bl_report_Jw_entrada_atual_pedidos_estilos++;
          if (i_bl_report_Jw_entrada_atual_pedidos_estilos<res_Jw_entrada_atual_pedidos_estilos.size()) {
            t_Jw_entrada_atual_pedidos_estilos = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_estilos)res_Jw_entrada_atual_pedidos_estilos.elementAt(i_bl_report_Jw_entrada_atual_pedidos_estilos);
            atualizacao7 = t_Jw_entrada_atual_pedidos_estilos.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_estilos.getAtualizacao();
            datam7 = t_Jw_entrada_atual_pedidos_estilos.getDatam()==null?"":t_Jw_entrada_atual_pedidos_estilos.getDatam();
            pr_pp5 = t_Jw_entrada_atual_pedidos_estilos.getPr_pp();
            vlr_pp5 = t_Jw_entrada_atual_pedidos_estilos.getVlr_pp();
            pr_pg5 = t_Jw_entrada_atual_pedidos_estilos.getPr_pg();
            vlr_pg5 = t_Jw_entrada_atual_pedidos_estilos.getVlr_pg();
            tot_pares5 = t_Jw_entrada_atual_pedidos_estilos.getTot_pares();
            tot_vlr5 = t_Jw_entrada_atual_pedidos_estilos.getTot_vlr();
   	        clientes5 = t_Jw_entrada_atual_pedidos_estilos.getClientes();
            descricao_estilos = t_Jw_entrada_atual_pedidos_estilos.getDescricao_estilos()==null?"":t_Jw_entrada_atual_pedidos_estilos.getDescricao_estilos();
    	    total_pares_ano = t_Jw_entrada_atual_pedidos_estilos.getTotal_pares_ano();
      	    total_valor_ano = t_Jw_entrada_atual_pedidos_estilos.getTotal_valor_ano();
    	    cli_atend_ano = t_Jw_entrada_atual_pedidos_estilos.getClientes_atendidos_ano();
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
  java.util.Vector res_Jw_entrada_atual_pedidos_unidades = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_unidades");
  boolean quebraMes = false;
  if(session.getAttribute("dataSelecionada")!=null){
     if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
        quebraMes = true;
     }
  }
  
  String perc8 = "8%";
  String perc10 = "10%";
  String perc4 = "14%";
  String perc6 = "16%";
  if(quebraMes){
     perc8 = "8%";
     perc10 = "10%";
     perc4 = "10%";
     perc6 = "12%";
  }
  %>

  <form  name="bl_report_Jw_entrada_atual_pedidos_unidades" id="bl_report_Jw_entrada_atual_pedidos_unidades" class="baseForm" method="post" >

    <%
    if (res_Jw_entrada_atual_pedidos_unidades !=null && res_Jw_entrada_atual_pedidos_unidades.size()>0) {
      %>

      <table id="TRbl_report_Jw_entrada_atual_pedidos_unidades"  class="reportTable" style="width:99%" border="1" >
        <%
        java.lang.String atualizacao7 =  null;
        java.lang.String datam7 =  null;
        double pr_pp5 =  0;
		double pr_pp5_total =  0;
        double vlr_pp5 =  0;
		double vlr_pp5_total =  0;
        double pr_pg5 =  0;
		double pr_pg5_total =  0;
        double vlr_pg5 =  0;
		double vlr_pg5_total =  0;
        double tot_pares5 =  0;
		double tot_pares5_total =  0;
        double tot_vlr5 =  0;
		double tot_vlr5_total =  0;
        Integer clientes5 = null;
		Integer clientes5_total = 0;
        Integer total_pares_ano = null;
		Integer total_pares_ano_total = 0;
        Integer cli_atend_ano = null;
		Integer clientes_atendidos_ano_total = 0;
        Double total_valor_ano = null;
		Double total_valor_ano_total = 0d;
        String unn_descri =  null;
        %>

          <tr class="reportTr">
            <td class="columnTdHeader" style="text-align:center;" >
              Mercado Interno
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              Compra Rápida
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              PG/EX
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
            <% if(quebraMes){ %>
              Total Mês
            <% } else { %>
              Total
            <% } %> 
            </td>

            <% if(quebraMes){ %>
            <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
              Total Ano
            </td>
            <% } %>

          </tr>



        <tr class="reportTr">

         <td class="columnTdHeader" style="text-align: left;" width="1%" >
              Unidade Negócio
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Cli. Atd.
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Pares
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Valor
            </td>

            <% if(quebraMes){ %>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Cli. Atd.
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Pares
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Valor
            </td>
            <% } %>

        </tr>

        <%
        int i_bl_report_Jw_entrada_atual_pedidos_unidades = 0;
        while (i_bl_report_Jw_entrada_atual_pedidos_unidades < res_Jw_entrada_atual_pedidos_unidades.size()) {
          portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades t_Jw_entrada_atual_pedidos_unidades = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades)res_Jw_entrada_atual_pedidos_unidades.elementAt(i_bl_report_Jw_entrada_atual_pedidos_unidades);
          atualizacao7 = t_Jw_entrada_atual_pedidos_unidades.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_unidades.getAtualizacao();
          datam7 = t_Jw_entrada_atual_pedidos_unidades.getDatam()==null?"":t_Jw_entrada_atual_pedidos_unidades.getDatam();
          pr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pp();
          vlr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pp();
          pr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pg();
          vlr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pg();
          tot_pares5 = t_Jw_entrada_atual_pedidos_unidades.getTot_pares();
          tot_vlr5 = t_Jw_entrada_atual_pedidos_unidades.getTot_vlr();
          clientes5 = t_Jw_entrada_atual_pedidos_unidades.getClientes();
          unn_descri = t_Jw_entrada_atual_pedidos_unidades.getUnn_descri()==null?"":t_Jw_entrada_atual_pedidos_unidades.getUnn_descri();
	      total_pares_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_pares_ano();
  	      total_valor_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_valor_ano();
	      cli_atend_ano = t_Jw_entrada_atual_pedidos_unidades.getClientes_atendidos_ano();
          String style_bl_report_Jw_entrada_atual_pedidos_unidades="";
          if (!((i_bl_report_Jw_entrada_atual_pedidos_unidades%2)!=0)) {
            style_bl_report_Jw_entrada_atual_pedidos_unidades="rowColor";
          } else {
            style_bl_report_Jw_entrada_atual_pedidos_unidades="rowBlank";
          }
          %>

          <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_unidades %>' id="TRbl_report_Jw_entrada_atual_pedidos_unidades<%=i_bl_report_Jw_entrada_atual_pedidos_unidades%>" >


            <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
              <%= unn_descri %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pp5, "#,##0.##") %>
			  <% pr_pp5_total += pr_pp5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pp5, "##,##0.00") %>
			  <% vlr_pp5_total += vlr_pp5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pg5, "#,##0.##") %>
			  <% pr_pg5_total += pr_pg5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pg5, "##,##0.00") %>
			  <% vlr_pg5_total += vlr_pg5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
              <%= FormatNumber.format(clientes5, "#,##0.##") %>
			  <% clientes5_total += clientes5; %>
            </td>	

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_pares5, "#,##0.##") %>
			  <% tot_pares5_total += tot_pares5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_vlr5, "##,##0.00") %>
			  <% tot_vlr5_total += tot_vlr5; %>
            </td>

            <% if(quebraMes){ %>
            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
               <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
			   <% clientes_atendidos_ano_total += cli_atend_ano; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
			  <% total_pares_ano_total += (total_pares_ano != null ? total_pares_ano : 0d); %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
			  <% total_valor_ano_total += (total_valor_ano != null ? total_valor_ano : 0d); %>
            </td>
            <% } %>


          </tr>

          <%
          i_bl_report_Jw_entrada_atual_pedidos_unidades++;
          if (i_bl_report_Jw_entrada_atual_pedidos_unidades<res_Jw_entrada_atual_pedidos_unidades.size()) {
            t_Jw_entrada_atual_pedidos_unidades = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades)res_Jw_entrada_atual_pedidos_unidades.elementAt(i_bl_report_Jw_entrada_atual_pedidos_unidades);
            atualizacao7 = t_Jw_entrada_atual_pedidos_unidades.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_unidades.getAtualizacao();
            datam7 = t_Jw_entrada_atual_pedidos_unidades.getDatam()==null?"":t_Jw_entrada_atual_pedidos_unidades.getDatam();
            pr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pp();
            vlr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pp();
            pr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pg();
            vlr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pg();
            tot_pares5 = t_Jw_entrada_atual_pedidos_unidades.getTot_pares();
            tot_vlr5 = t_Jw_entrada_atual_pedidos_unidades.getTot_vlr();
            clientes5 = t_Jw_entrada_atual_pedidos_unidades.getClientes();
            unn_descri = t_Jw_entrada_atual_pedidos_unidades.getUnn_descri()==null?"":t_Jw_entrada_atual_pedidos_unidades.getUnn_descri();
    	    total_pares_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_pares_ano();
      	    total_valor_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_valor_ano();
    	    cli_atend_ano = t_Jw_entrada_atual_pedidos_unidades.getClientes_atendidos_ano();
          } else {
          }
        }
        %>


<tr class="reportTr">

<td class="totalColumn" style="text-align: right; color: black;">
<b>Total</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(pr_pp5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(vlr_pp5_total, "##,##0.00") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(pr_pg5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(vlr_pg5_total, "##,##0.00") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(clientes5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(tot_pares5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(tot_vlr5_total, "##,##0.00") %>
</b>
</td>

    <% if(quebraMes){ %>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(clientes_atendidos_ano_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(total_pares_ano_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(total_valor_ano_total, "##,##0.00") %>
</b>
</td>

    <% } %>


</tr>


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

                        <br>
                        <br>
  <%
  java.util.Vector res_Jw_entrada_atual_pedidos_unidades_me = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_unidades_me");
  boolean quebraMes = false;
  if(session.getAttribute("dataSelecionada")!=null){
     if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
        quebraMes = true;
     }
  }
  
  String perc8 = "8%";
  String perc10 = "10%";
  String perc4 = "14%";
  String perc6 = "16%";
  if(quebraMes){
     perc8 = "8%";
     perc10 = "10%";
     perc4 = "10%";
     perc6 = "12%";
  }
  %>

  <form  name="bl_report_Jw_entrada_atual_pedidos_unidades" id="bl_report_Jw_entrada_atual_pedidos_unidades" class="baseForm" method="post" >

    <%
    if (res_Jw_entrada_atual_pedidos_unidades_me !=null && res_Jw_entrada_atual_pedidos_unidades_me.size()>0) {
      %>

      <table id="TRbl_report_Jw_entrada_atual_pedidos_unidades"  class="reportTable" style="width:99%" border="1" >
        <%
        java.lang.String atualizacao7 =  null;
        java.lang.String datam7 =  null;
        double pr_pp5 =  0;
        double pr_pp5_total =  0;		
        double vlr_pp5 =  0;
		double vlr_pp5_total =  0;
        double pr_pg5 =  0;
		double pr_pg5_total =  0;
        double vlr_pg5 =  0;
		double vlr_pg5_total =  0;
        double tot_pares5 =  0;
		double tot_pares5_total =  0;
        double tot_vlr5 =  0;
		double tot_vlr5_total =  0;
        java.lang.Integer clientes5 = null;
		java.lang.Integer clientes5_total = 0;
        java.lang.Integer total_pares_ano = null;
		java.lang.Integer total_pares_ano_total = 0;
        java.lang.Integer cli_atend_ano = null;
		java.lang.Integer clientes_atendidos_ano_total = 0;
        java.lang.Double total_valor_ano = null;
		java.lang.Double total_valor_ano_total = 0d;
        java.lang.String unn_descri =  null;
        %>

          <tr class="reportTr">
            <td class="columnTdHeader" style="text-align:center;" >
              Mercado Externo
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              Compra Rápida
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              PG/EX
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
            <% if(quebraMes){ %>
              Total Mês
            <% } else { %>
              Total
            <% } %> 
            </td>

            <% if(quebraMes){ %>
            <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
              Total Ano
            </td>
            <% } %>

          </tr>



        <tr class="reportTr">

         <td class="columnTdHeader" style="text-align: left;" width="1%" >
              Unidade Negócio
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Cli. Atd.
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Pares
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Valor
            </td>

            <% if(quebraMes){ %>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Cli. Atd.
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Pares
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Valor
            </td>
            <% } %>

        </tr>

        <%
        int i_bl_report_Jw_entrada_atual_pedidos_unidades = 0;
        while (i_bl_report_Jw_entrada_atual_pedidos_unidades < res_Jw_entrada_atual_pedidos_unidades_me.size()) {
          portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades t_Jw_entrada_atual_pedidos_unidades = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades)res_Jw_entrada_atual_pedidos_unidades_me.elementAt(i_bl_report_Jw_entrada_atual_pedidos_unidades);
          atualizacao7 = t_Jw_entrada_atual_pedidos_unidades.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_unidades.getAtualizacao();
          datam7 = t_Jw_entrada_atual_pedidos_unidades.getDatam()==null?"":t_Jw_entrada_atual_pedidos_unidades.getDatam();
          pr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pp();
          vlr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pp();
          pr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pg();
          vlr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pg();
          tot_pares5 = t_Jw_entrada_atual_pedidos_unidades.getTot_pares();
          tot_vlr5 = t_Jw_entrada_atual_pedidos_unidades.getTot_vlr();
          clientes5 = t_Jw_entrada_atual_pedidos_unidades.getClientes();
          unn_descri = t_Jw_entrada_atual_pedidos_unidades.getUnn_descri()==null?"":t_Jw_entrada_atual_pedidos_unidades.getUnn_descri();
	      total_pares_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_pares_ano();
  	      total_valor_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_valor_ano();
	      cli_atend_ano = t_Jw_entrada_atual_pedidos_unidades.getClientes_atendidos_ano();
          String style_bl_report_Jw_entrada_atual_pedidos_unidades="";
          if (!((i_bl_report_Jw_entrada_atual_pedidos_unidades%2)!=0)) {
            style_bl_report_Jw_entrada_atual_pedidos_unidades="rowColor";
          } else {
            style_bl_report_Jw_entrada_atual_pedidos_unidades="rowBlank";
          }
          %>

          <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_unidades %>' id="TRbl_report_Jw_entrada_atual_pedidos_unidades<%=i_bl_report_Jw_entrada_atual_pedidos_unidades%>" >


 <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
              <%= unn_descri %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pp5, "#,##0.##") %>
			  <% pr_pp5_total += pr_pp5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pp5, "##,##0.00") %>
			  <% vlr_pp5_total += vlr_pp5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pg5, "#,##0.##") %>
			  <% pr_pg5_total += pr_pg5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pg5, "##,##0.00") %>
			  <% vlr_pg5_total += vlr_pg5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
              <%= FormatNumber.format(clientes5, "#,##0.##") %>
			  <% clientes5_total += clientes5; %>
            </td>	

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_pares5, "#,##0.##") %>
			  <% tot_pares5_total += tot_pares5; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_vlr5, "##,##0.00") %>
			  <% tot_vlr5_total += tot_vlr5; %>
            </td>

            <% if(quebraMes){ %>
            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
               <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
			   <% clientes_atendidos_ano_total += cli_atend_ano; %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
			  <% total_pares_ano_total += (total_pares_ano != null ? total_pares_ano : 0d); %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
			  <% total_valor_ano_total += (total_valor_ano != null ? total_valor_ano : 0d); %>
            </td>
            <% } %>


          </tr>

          <%
          i_bl_report_Jw_entrada_atual_pedidos_unidades++;
          if (i_bl_report_Jw_entrada_atual_pedidos_unidades<res_Jw_entrada_atual_pedidos_unidades_me.size()) {
            t_Jw_entrada_atual_pedidos_unidades = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_unidades)res_Jw_entrada_atual_pedidos_unidades_me.elementAt(i_bl_report_Jw_entrada_atual_pedidos_unidades);
            atualizacao7 = t_Jw_entrada_atual_pedidos_unidades.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_unidades.getAtualizacao();
            datam7 = t_Jw_entrada_atual_pedidos_unidades.getDatam()==null?"":t_Jw_entrada_atual_pedidos_unidades.getDatam();
            pr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pp();
            vlr_pp5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pp();
            pr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getPr_pg();
            vlr_pg5 = t_Jw_entrada_atual_pedidos_unidades.getVlr_pg();
            tot_pares5 = t_Jw_entrada_atual_pedidos_unidades.getTot_pares();
            tot_vlr5 = t_Jw_entrada_atual_pedidos_unidades.getTot_vlr();
            clientes5 = t_Jw_entrada_atual_pedidos_unidades.getClientes();
            unn_descri = t_Jw_entrada_atual_pedidos_unidades.getUnn_descri()==null?"":t_Jw_entrada_atual_pedidos_unidades.getUnn_descri();
    	    total_pares_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_pares_ano();
      	    total_valor_ano = t_Jw_entrada_atual_pedidos_unidades.getTotal_valor_ano();
    	    cli_atend_ano = t_Jw_entrada_atual_pedidos_unidades.getClientes_atendidos_ano();
          } else {
          }
        }
        %>
<tr class="reportTr">

<td class="totalColumn" style="text-align: right; color: black;">
<b>Total</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(pr_pp5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(vlr_pp5_total, "##,##0.00") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(pr_pg5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(vlr_pg5_total, "##,##0.00") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(clientes5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(tot_pares5_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(tot_vlr5_total, "##,##0.00") %>
</b>
</td>

    <% if(quebraMes){ %>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(clientes_atendidos_ano_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(total_pares_ano_total, "#,##0.##") %>
</b>
</td>

<td class="totalColumn" style="text-align: right; color: black;">
<b>
<%= FormatNumber.format(total_valor_ano_total, "##,##0.00") %>
</b>
</td>

    <% } %>


</tr>

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
  java.util.Vector res_Jw_entrada_atual_pedidos_tipo_produto = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_tipo_produto");
  boolean quebraMes = false;
  if(session.getAttribute("dataSelecionada")!=null){
     if(((String)session.getAttribute("dataSelecionada")).equalsIgnoreCase("MÊS")){
        quebraMes = true;
     }
  }
  
  String perc8 = "8%";
  String perc10 = "10%";
  String perc4 = "14%";
  String perc6 = "16%";
  if(quebraMes){
     perc8 = "8%";
     perc10 = "10%";
     perc4 = "10%";
     perc6 = "12%";
  }
  %>

  <form  name="bl_report_Jw_entrada_atual_pedidos_tipo_produto" id="bl_report_Jw_entrada_atual_pedidos_tipo_produto" class="baseForm" method="post" >

    <%
    if (res_Jw_entrada_atual_pedidos_tipo_produto !=null && res_Jw_entrada_atual_pedidos_tipo_produto.size()>0) {
      %>

      <table id="TRbl_report_Jw_entrada_atual_pedidos_tipo_produto" class="reportTable" style="width:99%" border="1" >
        <%
        java.lang.String atualizacao7 =  null;
        java.lang.String datam7 =  null;
        double pr_pp5 =  0;
        double vlr_pp5 =  0;
        double pr_pg5 =  0;
        double vlr_pg5 =  0;
        double tot_pares5 =  0;
        double tot_vlr5 =  0;
        java.lang.Integer clientes5 = null;
        java.lang.Integer total_pares_ano = null;
        java.lang.Integer cli_atend_ano = null;
        java.lang.Double total_valor_ano = null;
        java.lang.String tipo_produto =  null;
        %>

          <tr class="reportTr">
            <td class="columnTdHeader" style="text-align:left;" >
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              Compra Rápida
            </td>

            <td class="columnTdHeader" style="text-align:center;" colspan="2" >
              PG/EX
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" colspan="3" >
            <% if(quebraMes){ %>
              Total Mês
            <% } else { %>
              Total
            <% } %> 
            </td>

            <% if(quebraMes){ %>
            <td style="color: black; text-align:center; background-color:#bfefff" colspan="3" >
              Total Ano
            </td>
            <% } %>

          </tr>



        <tr class="reportTr">

         <td class="columnTdHeader" style="text-align: left;" width="1%" >
              Tipo Produto
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Pares
            </td>

            <td class="columnTdHeader" style="text-align:center;" >
              Valor
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Cli. Atd.
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Pares
            </td>

            <td class="totalColumn" style="color: black; text-align:center;" >
              Valor
            </td>

            <% if(quebraMes){ %>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Cli. Atd.
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Pares
            </td>

            <td style="color: black; text-align:center; background-color:#bfefff" >
              Valor
            </td>
            <% } %>

        </tr>

        <%
        int i_bl_report_Jw_entrada_atual_pedidos_tipo_produto = 0;
        while (i_bl_report_Jw_entrada_atual_pedidos_tipo_produto < res_Jw_entrada_atual_pedidos_tipo_produto.size()) {
          portalbr.dbobj.view.Jw_entrada_atual_pedidos_tipo_produto t_Jw_entrada_atual_pedidos_tipo_produto = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_tipo_produto)res_Jw_entrada_atual_pedidos_tipo_produto.elementAt(i_bl_report_Jw_entrada_atual_pedidos_tipo_produto);
          atualizacao7 = t_Jw_entrada_atual_pedidos_tipo_produto.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getAtualizacao();
          datam7 = t_Jw_entrada_atual_pedidos_tipo_produto.getDatam()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getDatam();
          pr_pp5 = t_Jw_entrada_atual_pedidos_tipo_produto.getPr_pp();
          vlr_pp5 = t_Jw_entrada_atual_pedidos_tipo_produto.getVlr_pp();
          pr_pg5 = t_Jw_entrada_atual_pedidos_tipo_produto.getPr_pg();
          vlr_pg5 = t_Jw_entrada_atual_pedidos_tipo_produto.getVlr_pg();
          tot_pares5 = t_Jw_entrada_atual_pedidos_tipo_produto.getTot_pares();
          tot_vlr5 = t_Jw_entrada_atual_pedidos_tipo_produto.getTot_vlr();
          clientes5 = t_Jw_entrada_atual_pedidos_tipo_produto.getClientes();
          tipo_produto = t_Jw_entrada_atual_pedidos_tipo_produto.getTipo_produto()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getTipo_produto();
	      total_pares_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getTotal_pares_ano();
      	  total_valor_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getTotal_valor_ano();
	      cli_atend_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getClientes_atendidos_ano();
          String style_bl_report_Jw_entrada_atual_pedidos_tipo_produto="";
          if (!((i_bl_report_Jw_entrada_atual_pedidos_tipo_produto%2)!=0)) {
            style_bl_report_Jw_entrada_atual_pedidos_tipo_produto="rowColor";
          } else {
            style_bl_report_Jw_entrada_atual_pedidos_tipo_produto="rowBlank";
          }
          %>

          <tr class='<%= style_bl_report_Jw_entrada_atual_pedidos_tipo_produto %>' id="TRbl_report_Jw_entrada_atual_pedidos_tipo_produto<%=i_bl_report_Jw_entrada_atual_pedidos_tipo_produto%>" >


            <td class="reportColumn" style="text-align:left; width: <%= perc6 %>" >
              <%= tipo_produto %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pp5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pp5, "##,##0.00") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(pr_pg5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc4 %>" >
              <%= FormatNumber.format(vlr_pg5, "##,##0.00") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc8 %>" >
              <%= FormatNumber.format(clientes5, "#,##0.##") %>
            </td>	

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_pares5, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(tot_vlr5, "##,##0.00") %>
            </td>

            <% if(quebraMes){ %>
            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
               <%= FormatNumber.format(cli_atend_ano, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_pares_ano, "#,##0.##") %>
            </td>

            <td class="reportColumn" style="text-align:right; width: <%= perc10 %>" >
              <%= FormatNumber.format(total_valor_ano, "##,##0.00") %>
            </td>
            <% } %>


          </tr>

          <%
          i_bl_report_Jw_entrada_atual_pedidos_tipo_produto++;
          if (i_bl_report_Jw_entrada_atual_pedidos_tipo_produto < res_Jw_entrada_atual_pedidos_tipo_produto.size()) {
            t_Jw_entrada_atual_pedidos_tipo_produto = (portalbr.dbobj.view.Jw_entrada_atual_pedidos_tipo_produto)res_Jw_entrada_atual_pedidos_tipo_produto.elementAt(i_bl_report_Jw_entrada_atual_pedidos_tipo_produto);
            atualizacao7 = t_Jw_entrada_atual_pedidos_tipo_produto.getAtualizacao()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getAtualizacao();
            datam7 = t_Jw_entrada_atual_pedidos_tipo_produto.getDatam()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getDatam();
            pr_pp5 = t_Jw_entrada_atual_pedidos_tipo_produto.getPr_pp();
            vlr_pp5 = t_Jw_entrada_atual_pedidos_tipo_produto.getVlr_pp();
            pr_pg5 = t_Jw_entrada_atual_pedidos_tipo_produto.getPr_pg();
            vlr_pg5 = t_Jw_entrada_atual_pedidos_tipo_produto.getVlr_pg();
            tot_pares5 = t_Jw_entrada_atual_pedidos_tipo_produto.getTot_pares();
            tot_vlr5 = t_Jw_entrada_atual_pedidos_tipo_produto.getTot_vlr();
            clientes5 = t_Jw_entrada_atual_pedidos_tipo_produto.getClientes();
            tipo_produto = t_Jw_entrada_atual_pedidos_tipo_produto.getTipo_produto()==null?"":t_Jw_entrada_atual_pedidos_tipo_produto.getTipo_produto();
    	    total_pares_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getTotal_pares_ano();
      	    total_valor_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getTotal_valor_ano();
    	    cli_atend_ano = t_Jw_entrada_atual_pedidos_tipo_produto.getClientes_atendidos_ano();
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
if(session.getAttribute("giroProducao")!= null){
  
  java.util.Vector res_Jw_entrada_atual_pedidos_tipo_produto = (java.util.Vector)session.getAttribute("res_Jw_entrada_atual_pedidos_tipo_produto");
  List<util.consultas.com.EntradaAtualPedidos.GiroProducao> listaGiroProducao = (List<util.consultas.com.EntradaAtualPedidos.GiroProducao>)session.getAttribute("giroProducao");
  List<util.consultas.com.EntradaAtualPedidos.Datas> listaDatas = (List<util.consultas.com.EntradaAtualPedidos.Datas>)session.getAttribute("EntradaAtualPedidosDatasGiroProducao");
  util.consultas.com.EntradaAtualPedidos entradaAtualPedidos = new util.consultas.com.EntradaAtualPedidos(listaGiroProducao);

  String perc8 = "8%";
  String perc10 = "10%";
  String perc4 = "14%";
  String perc6 = "16%";
  String semana = null;
  String data_anterior = null;
  String data_atual = null;

  List<String> listaFiliais = new ArrayList();
  for(util.consultas.com.EntradaAtualPedidos.GiroProducao giro : listaGiroProducao) { 
     if(!listaFiliais.contains(giro.getFilial())) {
        if(!giro.getFilial().equalsIgnoreCase("Geral")) {
           listaFiliais.add(giro.getFilial());
        }
     }
  }
  java.util.Collections.sort(listaFiliais);
  listaFiliais.add("Geral");

  %>

  <form  name="bl_report_Jw_entrada_atual_pedidos_tipo_produto" id="bl_report_Jw_entrada_atual_pedidos_tipo_produto" class="baseForm" method="post" >

    <%
    if (true) {
      %>

<br><br><br><br><br><br><br>
      <table id="TRbl_report_Jw_entrada_atual_pedidos_tipo_produto" class="reportTable" style="width:99%" border="1" >

      
  <tr class="reportTr">
    <td class="columnTdHeader" style="text-align: center;">
    </td>
<%
      String style_filial = null;
      int contador_filial = 0;

%>
<% for(String fl : listaFiliais) { %>

<% 

 if (!((contador_filial %2)!=0)) {
          style_filial ="background-color:#284659; color: white; text-align:center;";
       } else {
          style_filial ="background-color:#402000; color: white; text-align:center;";
       }
       if(fl.equalsIgnoreCase("geral")) {
          style_filial = "background-color:#bfefff; color: black; text-align:center;";
       }

%>

<% if(fl.equalsIgnoreCase("geral")) { %>
    <td style="background-color:#bfefff; color: black; text-align:center;" colspan="5" >
       <%= fl %>
    </td>
<% } else { %>
    <td class="columnTdHeader" style="<%= style_filial %>" colspan="5">
       Filial - <%= fl %>
    </td>
<% 
 contador_filial++;
}
 %>
<% } %>
</tr>

  <tr class="reportTr">
    <td class="columnTdHeader" style="padding-left: 5px; padding-right: 5px;text-align: center;">
       <b>Data</b>
    </td>
<%
 contador_filial = 0;
 for(String fl : listaFiliais) { 
 if (!((contador_filial %2)!=0)) {
          style_filial ="background-color:#284659; color: white; text-align:center;";
       } else {
          style_filial ="background-color:#402000; color: white; text-align:center;";
       }
       if(fl.equalsIgnoreCase("geral")) {
          style_filial = "background-color:#bfefff; color: black; text-align:center;";
       }

%>

    <td class="columnTdHeader" style="<%= style_filial %>">
       Prs.Produz.</br>
       Corte
    </td>
    <td class="columnTdHeader" style="<%= style_filial %>">
       Prs.Produz.</br>
       Costura
    </td>
    <td class="columnTdHeader" style="<%= style_filial %>">
       Prs.Produz.</br>
       Atelier
    </td>
    <td class="columnTdHeader" style="<%= style_filial %>">
       Prs.Produz.</br>
       Total<br/>
       Costura
    </td>
    <td class="columnTdHeader" style="<%= style_filial %>">
       Prs.Produz.</br>
       Montagem
    </td>


<% 
contador_filial++;
} %>
  </tr>
<%    
    int i_contador = 0;
    String style_giro ="";

    for(util.consultas.com.EntradaAtualPedidos.Datas datas : listaDatas) { 

       if (!((i_contador %2)!=0)) {
          style_giro ="rowColor";
       } else {
          style_giro ="rowBlank";
       }
   

 if(semana == null){
     semana = datas.getSemana();
     data_anterior = datas.getData();
  }
  if(semana != null && !semana.equals(datas.getSemana())) {

%>
<tr class='<%= style_giro %>'>
<td class="totalColumn" style="color: black; text-align:center;" >
</td>
<%
 for(String fls : listaFiliais) {
  boolean enFilial = false;
 for(util.consultas.com.EntradaAtualPedidos.GiroProducao giro : listaGiroProducao) { 
      if(giro.getSemana().equalsIgnoreCase(semana) && data_anterior.equals(giro.getData()) && (giro.getFilial().equalsIgnoreCase(fls))) {
         enFilial = true; 
%>
<% if(fls.equalsIgnoreCase("geral")){ %>

<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorCorteBySemana(semana), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorCosturaBySemana(semana), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorAtelierBySemana(semana), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorTotalCosturaBySemana(semana), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorMontagemBySemana(semana), "#,##0.##") %></b>
</td>
<% } else { %>

<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(giro.getDados().get(0).getValor_corte_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(giro.getDados().get(0).getValor_costura_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_atelier_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_total_costura_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_montagem_filial_semana(), "#,##0.##") %></b>
</td>
<% } %>
<%

  }
}

if(!enFilial) {
%>
<td class="totalColumn" style="text-align: center">
<b><%= FormatNumber.format(entradaAtualPedidos.getValorCorteBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
<b><%= FormatNumber.format(entradaAtualPedidos.getValorCosturaBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorAtelierBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorTotalCosturaBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorMontagemBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<%
}



}
%></tr><%

}
%>

<tr class='<%= style_giro %>'>
<td style="padding-left: 5px; padding-right: 5px;">
<b><%= datas.getData() %></b>
<% data_atual = datas.getData(); %>
</td>
<%
 i_contador++;
 contador_filial = 0;
 for(String fl : listaFiliais) { 


 if (!((contador_filial %2)!=0)) {
          style_filial = "text-align: center";//background-color:#284659; color: white; text-align:center;";
       } else {
	 if(style_giro.equalsIgnoreCase("rowColor")) {
		style_filial ="background-color:#B3A699; color: black; text-align:center;";
	 } else {
		style_filial ="background-color:#CAC1B9; color: black; text-align:center;";
	 }
       }
   
   boolean enFilial = false;
 %>
<% for(util.consultas.com.EntradaAtualPedidos.GiroProducao giro : listaGiroProducao) { %>
<% if(giro.getData().equalsIgnoreCase(datas.getData())
    && (giro.getFilial().equalsIgnoreCase(fl))
) { 
  enFilial = true;

 %>

<td style="<%= style_filial %>">
  <%= FormatNumber.format((fl.equalsIgnoreCase("geral")?giro.getDados().get(0).getValor_corte_dia():giro.getDados().get(0).getValor_corte()), "#,##0.##") %>
</td>
<td style="<%= style_filial %>">
  <%= FormatNumber.format((fl.equalsIgnoreCase("geral")?giro.getDados().get(0).getValor_costura_dia():giro.getDados().get(0).getValor_costura()), "#,##0.##") %>
</td>
<td style="<%= style_filial %>">
  <%= FormatNumber.format((fl.equalsIgnoreCase("geral")?giro.getDados().get(0).getValor_atelier_dia():giro.getDados().get(0).getValor_atelier()), "#,##0.##") %>
</td>
<td style="<%= style_filial %>">
   <%= FormatNumber.format((fl.equalsIgnoreCase("geral")?giro.getDados().get(0).getValor_total_costura_dia():giro.getDados().get(0).getValor_total_costura()), "#,##0.##") %>
</td>
<td style="<%= style_filial %>">
   <%= FormatNumber.format((fl.equalsIgnoreCase("geral")?giro.getDados().get(0).getValor_montagem_dia():giro.getDados().get(0).getValor_montagem()), "#,##0.##") %>
</td>

<% 
  data_anterior = giro.getData(); 
} 
     semana = datas.getSemana();
%>
<% } %>

<% 
if(!enFilial) {
%>
<td style="<%= style_filial %>">
   0
</td>
<td style="<%= style_filial %>">
   0
</td>
<td style="<%= style_filial %>">
   0
</td>
<td style="<%= style_filial %>">
   0
</td>
<td style="<%= style_filial %>">
   0
</td>
<%
}
contador_filial++;
} 
%>

</tr>

<% }  %>

   

<tr class='<%= style_giro %>'>
<td class="totalColumn" style="color: black; text-align:center;" >
</td>
<%
 for(String fls : listaFiliais) {
   boolean enFilial = false;
 for(util.consultas.com.EntradaAtualPedidos.GiroProducao giro : listaGiroProducao) { 
      if(giro.getData().equalsIgnoreCase(data_atual) && (giro.getFilial().equalsIgnoreCase(fls))) { 
         enFilial = true;
%>

<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(giro.getDados().get(0).getValor_corte_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_costura_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_atelier_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_total_costura_filial_semana(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_montagem_filial_semana(), "#,##0.##") %></b>
</td>

<%

  }}
  
  if(!enFilial) {
	  %>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorCorteBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorCosturaBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorAtelierBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorTotalCosturaBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="text-align: center">
 <b><%= FormatNumber.format(entradaAtualPedidos.getValorMontagemBySemanaFilial(semana, fls), "#,##0.##") %></b>
</td>

<%  } 
  }
%></tr>


<tr>
<td class="totalColumn" style="color: black; text-align:center;" >
<b>Total: </b>
</td>

<% 
 String dBa = null;
for(String fl : listaFiliais) {
   boolean enFilial = false;
 %>
<% for(util.consultas.com.EntradaAtualPedidos.GiroProducao giro : listaGiroProducao) { %>
<%
  if(dBa == null) {
     dBa = giro.getData();
  }

 if(giro.getData().equalsIgnoreCase(dBa) && (giro.getFilial().equalsIgnoreCase(fl))
) { 
  enFilial = true;

%>

<% if(fl.equalsIgnoreCase("geral")) { %>


<td class="totalColumn" style="color: black; text-align:center;" >
<b><%= FormatNumber.format(giro.getDados().get(0).getValor_corte_geral(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_costura_geral(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_atelier_geral(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_total_costura_geral(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_montagem_geral(), "#,##0.##") %></b>
</td>


<% } else { %>

<td class="totalColumn" style="color: black; text-align:center;" >
 <b><%= FormatNumber.format(giro.getDados().get(0).getValor_corte_filial(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_costura_filial(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_atelier_filial(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_total_costura_filial(), "#,##0.##") %></b>
</td>
<td class="totalColumn" style="color: black; text-align:center;" >
  <b><%= FormatNumber.format(giro.getDados().get(0).getValor_montagem_filial(), "#,##0.##") %></b>
</td>
<% } %>
<% 
   
} %>
<% } %>

<% 
if(!enFilial) {
%>
<td class="reportColumn" style="text-align: center">
   <b>0</b>
</td>
<td class="reportColumn" style="text-align: center">
   <b>0</b>
</td>
<td class="reportColumn" style="text-align: center">
   <b>0</b>
</td>
<td class="reportColumn" style="text-align: center">
   <b>0</b>
</td>
<td class="reportColumn" style="text-align: center">
   <b>0</b>
</td>
<%
}
} 
%>

</tr>

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
	