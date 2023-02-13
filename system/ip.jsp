<script>


var xmlHttp;
var retorno='';
try
  {
  xmlHttp=new XMLHttpRequest();
  }
catch (e)
  { 
  try
    { 
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	}
  catch (e)
    { 
    try
      {
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
    catch (e)
      { 
      alert("Your browser does not support AJAX!");
      }
    }
  }

   
 
 var url = 'bundle.jsp?&arquivo='+'ApplicationResources'+'&chave='+'jsp.print';

	  

xmlHttp.onreadystatechange=function()
{
if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
  {
  retorno = xmlHttp.responseText;
  }
}
xmlHttp.open("GET",url,false);
xmlHttp.send(null);

alert(retorno);


</script>

