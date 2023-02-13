<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page extends='acesso.web.HttpJspSessao' import='portalbr.dbobj.table.*,portalbr.dbobj.view.*,portalbr.dbobj.procedure.*' %>
<html>
  <bean:message key="page.css"/>
  <bean:message key="page.script"/>
  <head>
    <title>
      Busca de arquivos de Cobrança de Representantes
    </title>
  </head>
  <center>
    <body onload="if(document.forms[0].rep.value=='x'){document.forms[0].receber_arquivo_action.disabled=1;}if('<%= (String)request.getAttribute("arquivo") %>' == 'null'){document.forms[0].abre_automaticamente.checked=false;document.forms[0].mensagem.value='';}if(document.forms[0].abre_automaticamente.checked==true){if('<%= (String)request.getAttribute("arquivo") %>' != 'null'){window.open('<%= (String)request.getAttribute("arquivo") %>','_blank');}}">
      <table class="mainTable" style='width:99%;'>
        <tr class="mainTr">
          <td class="mainTd">
            <table class="headerTable" style="width:99%" >
              <tr>

                <td class="td10">
                  <%@ include file="../system/header.jsp" %>
                  <%
                  if(!user.isSuperUsuario() && !user.isAutorizado(66)){
                    response.sendRedirect("../system/Error.jsp");
                  }
                  %>
                </td>

              </tr>

            </table>

            <html:form action="adm/CobrancaClientesRepresentantesForm.do" method="post" styleClass="baseForm">
              <table class="messageTable" style='width:99%;'>
                <tr class="messageTr" >
                  <td class="messageTd">
                    <html:errors property="arquivo"/>
                    <html:errors property="abre_automaticamente"/>
                    <html:errors property="mensagem"/>
                    <html:errors property="ActionErrors.GLOBAL_ERROR_bl_form"/>
                  </td>
                </tr>
              </table>

              <table class="itemTable"  style="width:99%;">
                <%
                util.bloqueio.BloqueioUtil bloqueio = new util.bloqueio.BloqueioUtil(66, request);
                boolean bloqueiaComissoes = false;
                boolean bloqueiaImpostosDepositos = false;
                if(bloqueio.tipoBloqueio("IMPOSTOS_E_DEPOSITOS").equals("E")){
                  bloqueiaImpostosDepositos = true;
                }
                if(bloqueio.tipoBloqueio("COMISSOES").equals("E")){
                  bloqueiaComissoes = true;
                }

                String representante_exportacao = "N";
                String codigo_regional="";
                String codigo_representante="";
                String tipo="";
                String codigo_novo="";
                String rep = "";
                acesso.Usuario u = new acesso.Usuario();
                u = (acesso.Usuario)session.getAttribute("User");
                acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
                acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();

                if(!(u.getEntidadeNegocio()==null)){
                  ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
                  tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
                  tipo = tipoent.getTipo()+"";
                  if(tipo.equals("REGIONAL DE VENDA")){
                    codigo_regional = ent.getChave()+"";
                  }
                  if(tipo.equals("REPRESENTANTE EXPORTACAO")){
                    representante_exportacao = "S";
                  }
                  if((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))){
                    codigo_representante = ent.getChave()+"";
                    rep = codigo_representante;
                    if(codigo_representante.length()==2){
                      codigo_representante= "0"+codigo_representante;
                    }
                    if(codigo_representante.length()==1){
                      codigo_representante= "00"+codigo_representante;
                    }

                    com.egen.util.jdbc.JdbcUtil j = null;
                    java.sql.ResultSet rset = null;
                    java.sql.PreparedStatement pstm = null;
                    try {
                      j = new com.egen.util.jdbc.JdbcUtil();
                      pstm = j.getConn().prepareStatement(
                      " select utl_encode.base64_encode(?||?) from dual "
                      );
                      pstm.setString(1, codigo_representante);
                      pstm.setString(2, codigo_representante);
                      rset = pstm.executeQuery();
                      while (rset.next()) {
                        codigo_novo = rset.getString(1);
                      }
                    } finally {
                      if (rset != null){
                        rset.close();
                      }
                      if (pstm != null){
                        pstm.close();
                      }
                      if(j!=null){
                        j.close();
                        j = null;
                      }
                    }

                  }
                }


              if(codigo_representante.equals("")){codigo_representante="x";}
              %>
              <tr>
                <td class="formLabel">
                  <span class="spamFormLabel" >
                    Arquivo
                  </span>
                </td>
                <td class="formField">
                  <html:select property="arquivo" onchange="refresh_action.click();" styleClass="baseField" size="1">
                    <%
                    if(representante_exportacao.equalsIgnoreCase("S")) {
                      %>
                      <html:option styleClass="baseOption" value="CMS0170">
                        Demonstrativo de conta corrente
                      </html:option>
                      <%
                      if(!bloqueiaImpostosDepositos ){
                        %>
                        <html:option styleClass="baseOption" value="CMS0210">
                          Valor de IRRF e depósito
                        </html:option>
                        <%
                      }
                      %>
                      <html:option styleClass="baseOption" value="CMS5025">
                        Recibo
                      </html:option>
                      <%
                      if(!bloqueiaComissoes){
                        %>
                        <html:option styleClass="baseOption" value="CMS5030">
                          Comissão sobre liquidação
                        </html:option>
                        <%
                      }
                      %>
                      <%
                    } else {
                      %>
                      <html:option styleClass="baseOption" value="CMS0170">
                        Demonstrativo de conta corrente
                      </html:option>
                      <%
                      if(!bloqueiaImpostosDepositos ){
                        %>
                        <html:option styleClass="baseOption" value="CMS0210">
                          Valor de IRRF e depósito
                        </html:option>
                        <%
                      }
                      %>
                      <html:option styleClass="baseOption" value="CMS5002">
                        Adiantamento de comissão s/ faturamento
                      </html:option>
                      <%
                      if(!bloqueiaComissoes){
                        %>
                        <html:option styleClass="baseOption" value="CMS5020">
                          Comissões sobre liquidação
                        </html:option>
                        <%
                      }
                      %>
                      <html:option styleClass="baseOption" value="CMS5005">
                        Estorno de comissão indevida
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5006">
                        Estorno de adiant. de comissão s/ merc. devolv.
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5007">
                        Adiantamento de créd. refat. devoluções
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5013">
                        Estorno de adiant comissão por in
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5015">
                        Adiantamento de comissão s/ faturamento vendor
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5016">
                        Amostras
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5011">
                        Previsão Comissões s/Liquidação
                      </html:option>
                      <html:option styleClass="baseOption" value="CMS5025">
                        Recibo
                      </html:option>
                      <%
                    }
                    %>
                  </html:select>
                </td>
              </tr>
              <html:hidden property="rep" value="<%= codigo_representante %>"/>
              <html:hidden property="codigo_novo" value="<%= codigo_novo %>"/>
              <tr class="itemTr">
                <td class="formLabel">
                  <span class="spamFormLabel">
                    Abre o Relatório Automaticamente
                  </span>
                </td>
                <td class="formField">
                  <html:checkbox property="abre_automaticamente" onclick="if(this.checked==true){mensagem.value='Obs.: Uma nova janela será aberta para a visualização do relatório.';}else{mensagem.value='';}" styleClass="baseField" value="checked"/>
                  <span class="spamFormLabel">
                  </span>
                  <html:text property="mensagem" style="background-color:transparent; border-style:none; color:red; background-color:transparent; border-style:none; cursor:default; text-align:start;" styleClass="baseField" tabindex="-1" readonly="true" size="70" maxlength="70"/>
                </td>
              </tr>

              <%
              if((String)request.getAttribute("abre_automaticamente")=="N"){
                %>
                <table style=width:100%;margin-top:10;>
                  <tr>
                    <td class=columHeader style="text-align:center;">
                      <a href="<%= (String)request.getAttribute("arquivo") %>" target="_blank">
                        <bean:message key="report.downloadpdf"/>
                      </a>
                    </td>
                  </tr>
                </table>
                <%
              }
              %>
              <tr>
                <td>
                  <br>
                </td>
              </tr>
              <html:hidden property="rep_cdgo" value="<%= rep %>"/>
            </table>

            <table class="buttonTable" style='width:99%;'>
              <tr class="buttonTr">
                <td class="buttonTd">
                  <html:button accesskey="p" value="Receber Arquivo" onclick="teste(this);" styleClass="baseButton" property="receber_arquivo_action">
                  </html:button>
                  <script>
                    function getKeySite(keyStroke) {
                      isNetscape=(document.layers);
                      eventChooser = (isNetscape) ? keyStroke.which : event.keyCode;
                      which = String.fromCharCode(eventChooser).toLowerCase();
                      keyBuffer = which;
                      if(eventChooser == 13){
                      if(document.forms[0].receber_arquivo_action.disabled==true){return false;}
                      document.forms[0].receber_arquivo_action.disabled=true;
                      bloqueia();
                      document.forms[0].receber_action.click();
                    }
                  }
                  function  teste(btReceberArquivo){
                    formZero = document.forms[0];
                    <% 		Calendar calendar = Calendar.getInstance();
                    if(14 > calendar.get(Calendar.HOUR_OF_DAY)){
                      out.println("alerta = true;");
                    }else{
                      out.println("alerta = false;");
                    }
                    %>
                    if( !(formZero.arquivo.value == 'CTR5023') || (!alerta) ) {
                      btReceberArquivo.disabled=true;
                      bloqueia();
                      formZero.receber_action.click();
                    }else{
                      alert('Procedimento disponível diariamente a partir das 14:00Hrs devido ao processamento do retorno bancário.');
                    }

                  }
                </script>
                <SCRIPT>
      document.onkeypress = getKeySite;
    </SCRIPT>
    <html:submit value="receber" styleClass="myhidden" property="receber_action">
    </html:submit>
    <html:submit accesskey="l" styleClass="myhidden" property="refresh_action">
      <bean:message bundle="ApplicationResources" key="jsp.refresh"/>
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
