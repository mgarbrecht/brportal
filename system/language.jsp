<%@ include file="../system/HeaderStrutsForm.jsp"%>
<%@ page  extends='acesso.web.HttpJspSessao' %>
<html>
<head>
<title>Acesso BR Portal</title>
<link rel='stylesheet' href='../css/style.css' charset='ISO-8859-1' type='text/css'>
</head>
<body>
<table border='0' align='center'>
<tr><td>
</table>
<table border='0' align='center' width='100%' style='background-color:white' >
</td></tr>
<tr><td align='center'><br><br><br><br><br><br><br><br>
     <fieldset style='width:700'>
     <legend><img src='../img/logo_login.jpg' border='0'></legend>
      <form name=frmMain action=login method=post>
      <table border='0' style='width:700'cellpadding='0' cellspacing='0'>
        <tr><td><center>
          <table style=width:640;margin-top:0;>
            <tr>
              <td class='colorBannerFont' background='../img/screen_bar_beirario.png'; align="center">
              <font color="gray" size="3">Selecione a Linguagem / Select the Language / Seleccione la lengua</font>
              </td>
            </tr>
            <html:errors/>
          </table>
          <table style=width:400;margin-top:10; border=0;>
         <tr>
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=pt_BR"><img src='../img/brasil.gif' onmouseover="this.src='../img/brasil_c.gif'" onmouseout="this.src='../img/brasil.gif'" border='0' height="25" width="46"></a>
         </td>
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=en_US"><img src='../img/eua.gif' onmouseover="this.src='../img/eua_c.gif'" onmouseout="this.src='../img/eua.gif'" border='0' height="25" width="46"></a>
         </td>
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=es_ES"><img src='../img/espanha.JPG' onmouseover="this.src='../img/espanha_c.JPG'" onmouseout="this.src='../img/espanha.JPG'" border='0' height="25" width="46"></a>
         </td>                  
         </tr>
         <tr>
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=pt_BR">Português</a>
         </td>         
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=en_US">English</a>
         </td>
         <td align="center">
         <a href="../system/MainMenu.do?select_action=&language=es_ES">Español</a>
         </td>
         </tr>

         <!--<td class=formLabel style=width:250;>Idioma/Language</td><td><select name=\"language\" size=\"1\"><option value=\"pt_BR\">Português</option><option value=\"en_US\">English</option><tr>-->
         </tr>
          </table>
          <table style=width:640;>
            <tr>
              <!-- <td style=border-color:black;border-top-style:solid;border-top-width:1;padding-top:5;font-size:11px;>-->
              <!--  <button value='' onclick="top.location='/brportal'" type=button><font color=#00000 style='font-family:Arial,Verdana; font-size:12px' > Voltar</font></button> -->	
              <!--</td>-->
            </tr>
          </table>
          </form>
        </center></td></tr>
      </table>
      </form>
</table>
</body>
</html>  