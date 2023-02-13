<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<!DOCTYPE HTML PUBLIC ' - //W3C//DTD HTML 3.2//EN'>
<html>

<head>

<META NAME='GENERATOR' CONTENT='e-Gen Developer'>
<title>
Manual</title>

<LINK REL='stylesheet' TYPE='text/css' HREF='../style.css'>

<BODY class="bodyManual">
<p>
Conteúdos
Comentários
</p>
<p style='text-align:justify'>Consulta de Saldo de Estoque por Grade</p><br>
<h3>Campo:</h3></p>
<table class="tableItem" cellpadding='0' cellspacing='0' border='1'>

<tr class="trItem"><td class="tdItemName"><b>Nome</b></td><td class="tdItemType" width=70 align=center><b>Tipo</b></td><td class="tdItemNotNull" width=70 align=center><b>Obrigatório</b></td><td class="tdItemLov" width=70 align=center><b>LOV</b></td><td class="tdItemRole" width=70 align=center><b>Papel</b></td></tr>
<tr class="trItemHeader"><td class="tdItemName">Linha</td><td class="tdItemType"  width=70 align=center>Texto</td><td class="tdItemNotNull" width=70 align=center><img src='../../img/mark.jpg' border='0'></td><td class="tdItemLov" width=70 align=center><img src='../../img/mark.jpg' border='0'></td><td class="tdItemRole" width=70 align=center><img src='../../img/editdelete.png' border='0'></td></tr><tr class="trItemComment"><td class="tdItemComment" colspan='5' >
<h3>Comentários</h3>
<p>Informe o código da linha. Máximo de 3 caracteres.</p><br>
</td></tr>
<tr class="trItemHeader"><td class="tdItemName">Referência</td><td class="tdItemType"  width=70 align=center>Texto</td><td class="tdItemNotNull" width=70 align=center><img src='../../img/editdelete.png' border='0'></td><td class="tdItemLov" width=70 align=center><img src='../../img/mark.jpg' border='0'></td><td class="tdItemRole" width=70 align=center><img src='../../img/editdelete.png' border='0'></td></tr><tr class="trItemComment"><td class="tdItemComment" colspan='5' >
<h3>Comentários</h3>
<p>Informe o código da referência. Máximo de 3 caracteres.</p><br>
</td></tr>
<tr class="trItemHeader"><td class="tdItemName">Cabedal</td><td class="tdItemType"  width=70 align=center>Texto</td><td class="tdItemNotNull" width=70 align=center><img src='../../img/editdelete.png' border='0'></td><td class="tdItemLov" width=70 align=center><img src='../../img/mark.jpg' border='0'></td><td class="tdItemRole" width=70 align=center><img src='../../img/editdelete.png' border='0'></td></tr><tr class="trItemComment"><td class="tdItemComment" colspan='5' >
<h3>Comentários</h3>
<p>Informe o código do cabedal. Máximo de 3 caracteres.</p><br>
</td></tr>
<tr class="trItemHeader"><td class="tdItemName">Compr.</td><td class="tdItemType"  width=70 align=center>Selecionar</td><td class="tdItemNotNull" width=70 align=center><img src='../../img/editdelete.png' border='0'></td><td class="tdItemLov" width=70 align=center><img src='../../img/editdelete.png' border='0'></td><td class="tdItemRole" width=70 align=center><img src='../../img/editdelete.png' border='0'></td></tr><tr class="trItemComment"><td class="tdItemComment" colspan='5' >
<h3>Comentários</h3>
<p>Informe o comprometimento.</p><br>
</td></tr>
</table>

<br><h3>Botão:</h3></p>
<table class="tableItem" cellpadding='0' cellspacing='0' border='1'>

<tr class="trItem"><td class="tdItemName" width=130><b>Nome</b></td><td class="tdButtonComment"><b>Comentários</b></td></tr><tr class="trItemHeader"><td class="tdItemName"><bean:message bundle="ApplicationResources" key="jsp.select"/></td><td class="tdButtonComment"><p>Executa a consulta, e mostra os registros encontrados.</p></td></tr><tr class="trItemHeader"><td class="tdItemName"><bean:message bundle="ApplicationResources" key="jsp.reset"/></td><td class="tdButtonComment"><p>Limpa os campos da tela.</p></td></tr></table>

</body>

</html>

