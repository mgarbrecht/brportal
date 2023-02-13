<%@ include file="../system/HeaderStrutsForm.jsp" %>
<html><head><title><bean:message key="page.title"/></title><bean:message key="page.css"/><bean:message key="page.script"/></head>
<body style=margin-top:0px;margin-left:0px;margin-right:0px;margin-bottom:0px;>
<table style=width:320; cellpadding='0' cellspacing='0'><tr><td align="center" style="width:95%;background-color:#afc4d9;height:30;font-weight:bold;font-size:16px;">
<bean:message key="jsp.help"/>
</td><td style="background-color:#afc4d9;height:30;">
<img src="../img/close.png" align=right onclick="javascript:window.close()" title="<bean:message key="jsp.close"/>">
</td></tr></table>
<table style="width:320;margin-top:10" cellpadding='0' cellspacing='0' border=1><tr><td class='tdHelp'>
<big><% String sh = request.getParameter("help"); %><%= ((sh!=null)?sh:"") %></big>
</td></tr></table>
</body></html>