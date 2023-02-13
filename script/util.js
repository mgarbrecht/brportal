function HashMap() {
	this.set = function(index,value) {
		this[index] = value;
	};
	this.get = function(index) {
		return this[index];
	};
}

  var regras = new Array();
  function Regra(CAMPO,VALOR,CONDICAO){ 
    this.campo = CAMPO 
    this.valor = VALOR 
    this.condicao = CONDICAO 
  } 
  function validate(ARRAY) {
    var erro = '';
    for (i=0; i<ARRAY.length; i++) {
      if (ARRAY[i].valor==ARRAY[i].condicao) {
         erro += '   ' + ARRAY[i].campo + ' \n';
      }
    }
    regras = new Array();
    if (erro.length>0) {
      alert('Error: \n' + erro + '. Fill in the fields.');
      return false;
    } else {
      return true;
    }
  }
  function toLowerCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.toLowerCase();
  }
  function toUpperCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.toUpperCase();
  }
  function toJavaCase(ELEMENTS) {
    ELEMENTS.value = ELEMENTS.value.substring(0,1).toUpperCase() + ELEMENTS.value.substring(1);
  }
  function toDouble(ELEMENTS) {
    var original = ELEMENTS.value;
    if (ELEMENTS.value.indexOf(',')!=-1) {
      ELEMENTS.value = (ELEMENTS.value).replace(".","");
    }
    ELEMENTS.value = (ELEMENTS.value).replace(",",".");
  }
  function today(ELEMENTS) {
    var today = new Date()
    ELEMENTS.value= today.getDate() + '/' + (today.getMonth()+1) + '/' + today.getYear();
  }
  function show(ID) {
    m = document.getElementById(ID).style;
    if (m.display=='none') {
      m.display='block'; 
    } else {
      m.display='none'; 
    }
  }
  function verificaCpf(x, y) { 
    var numero = x.value;
    var digito = y.value;
    if (numero==null ||
        numero=='' ||
        digito==null || 
        digito=='' || 
        numero==111111111 || 
        numero==222222222 || 
        numero==333333333 || 
        numero==444444444 || 
        numero==555555555 || 
        numero==666666666 || 
        numero==777777777 || 
        numero==888888888 || 
        numero==999999999) { 
      numero="";
      digito="";
      x.focus();
      alert('Digite Corretamente o Cpf do Cliente');
      return false;
    } else { 
      Div_Ini = 100000000;
      Mult_Ini = 10;
      Num_Ini = x.value;
      Acum = 0;
      Acum_Aux = 0; 
      Div_Calc = 0;
      Mult_Calc = 0;  
      V_Digito = 0;
      Resultado = 0;
      for (i = 0; i < 2; i++) { 
        Mult_Calc = Mult_Ini+i;
        Div_Calc  = Div_Ini * ( 9*i+1 );
        Acum_Aux = Num_Ini * ( 9*i+1 )+Acum;
        Acum = 0;
        while (Div_Calc > 0 ) { 
          V_Digito = (Acum_Aux - ( Acum_Aux % Div_Calc ))/Div_Calc;
          Acum = Acum + V_Digito * Mult_Calc;
          Acum_Aux  = Acum_Aux - ( V_Digito * Div_Calc );
          Mult_Calc = Mult_Calc-1;
          if (Mult_Calc < 2) {  
            Mult_Calc = 9;
          }  
          Div_Calc  = Div_Calc / 10;
        }  
        Acum = 11 - (Acum % 11);
        if (Acum > 9) {  
          Acum = 0;
        }  
        Resultado = Resultado + Acum * ( 9*( 1-i ) + 1 );
      }  
      if (Resultado != y.value) { 
        alert('Dï¿½gito CPF incorreto. Verifique CPF do cliente');
        x.focus();  
        return false;
      }  
    } 
    return true;
  } 
function FormatDate(campo,teclapres) {
 var tecla = teclapres.keyCode;
 vr = campo.value;
 vr = vr.replace( ".", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 tam = vr.length + 1;
 if ( tecla != 9 && tecla != 8 ){
  if ( tam > 2 && tam < 5 )
   campo.value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
  if ( tam >= 5 && tam <= 10 )
   campo.value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 ); 
 }
}
function FormatNumber(campo,tammax,teclapres) {
    var tecla = teclapres.keyCode;
    var vl = String.fromCharCode(teclapres.keyCode);
    vr = campo.value;
    if (vl!='0' && vl!='1' && vl!='2' &&  vl!='3' && vl!='4' && vl!='5' && vl!='6' && vl!='7' && vl!='8' && vl!='9' && vl!='.' && vl!=',') {
      vr = vr.replace(vl, "");
      campo.value = vr;
      return;
    }
}
function FormatValue(campo,tammax,teclapres) {
 var tecla = teclapres.keyCode;
 var vl = String.fromCharCode(teclapres.keyCode);
 vr = campo.value;
        if (vl!='0' && vl!='1' && vl!='2' &&  vl!='3' && vl!='4' && vl!='5' && vl!='6' && vl!='7' && vl!='8' && vl!='9' && vl!='.' && vl!=',') {
          vr = vr.replace(vl, "");
          campo.value = vr;
          return;
        }
        vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ",", "" );
 tam = vr.length;

 if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

 if (tecla == 8 ){ tam = tam - 1 ; }
  
 if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
  if ( tam <= 2 ){ 
    campo.value = vr ; }
   if ( (tam > 2) && (tam <= 5) ){
    campo.value = vr.substr( 0, tam - 2 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 6) && (tam <= 8) ){
    campo.value = vr.substr( 0, tam - 5 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 9) && (tam <= 11) ){
    campo.value = vr.substr( 0, tam - 8 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 12) && (tam <= 14) ){
    campo.value = vr.substr( 0, tam - 11 ) + ',' + vr.substr( tam - 11, 3 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 15) && (tam <= 17) ){
    campo.value = vr.substr( 0, tam - 14 ) + ',' + vr.substr( tam - 14, 3 ) + ',' + vr.substr( tam - 11, 3 ) + ',' + vr.substr( tam - 8, 3 ) + ',' + vr.substr( tam - 5, 3 ) + '.' + vr.substr( tam - 2, tam ) ;}
 }
}
function isNumber(inputValue) {
  inputStr = inputValue.toString();
  for (var i = 0; i < inputStr.length; i++) {
    var oneChar = inputStr.charAt(i);
    if (i == 0 && oneChar == "-") {
      continue;
    }
    if (oneChar == "." && !oneDecimal) {
      oneDecimal = true;
      continue;
    }
    if (oneChar == "," && !oneDecimal) {
      oneDecimal = true;
      continue;
    }
    if (oneChar < "0" || oneChar > "9") {
      return false;
    }
  }
  return true;
}
function parseNumber(field) {
  oneDecimal = false;
  var inputValue = field.value;
  if (!isNumber(inputValue)) {
    alert('Not a number!');
    field.value = '';
    field.focus();      
    return false;
  }
  return true;
}
function parseDate(field) {
  var DATE = field.value;
  if (DATE==null || DATE=='' || DATE.length==0) {
    return true;
  }
  var begin = DATE.indexOf('/');
  var last = DATE.lastIndexOf('/');
  var dia = DATE.substr(0,begin);
  var mes = DATE.substr((begin+1),((last-begin)-1));
  var ano = DATE.substr((last+1));
  if (!isNumber(dia) || !isNumber(mes) || !isNumber(ano) ) {
    alert('Correct date format: dd/mm/aaaa!');
    field.focus();
    return false;
  }
  if (ano<1 || ano>9999) {
    alert('Invalid Date - check year!');
    field.focus();
    return false;
  } 
  if (mes<1 || mes>12) {
    alert('Invalid Date - check month!');
    field.focus();
    return false;
  } 
  if (mes=='1' || mes=='01' || 
      mes=='5' || mes=='05' || 
      mes=='7' || mes=='07' || 
      mes=='8' || mes=='08' || 
      mes=='10' || 
      mes=='12') {
    if (dia<1 || dia>31) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  } else if (mes==2 || mes==02) {
    if (dia<1 || dia>29) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  } else if (
      mes=='1' || mes=='01' || 
      mes=='3' || mes=='03' || 
      mes=='4' || mes=='04' || 
      mes=='9' || mes=='09' || 
      mes=='11') {
    if (dia<1 || dia>30) {
      alert('Invalid Date - check day!');
      field.focus();
      return false;
    }
  }
}
function corrige_ponto(X) {
  var original = X.value;
  if (X.value.indexOf(',')!=-1) {
    X.value = (X.value).replace(".","");
  }
  X.value = (X.value).replace(",",".");
}

function FormataData(campo,teclapres) {
 var tecla = teclapres.keyCode;
 vr = campo.value;
 vr = vr.replace( ".", "" );
 vr = vr.replace( "-", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 tam = vr.length + 1;
 if ( tecla != 9 && tecla != 8 ){
  if ( tam > 2 && tam < 5 )
   campo.value = vr.substr( 0, tam - 2  ) + '/' + vr.substr( tam - 2, tam );
  if ( tam >= 5 && tam <= 10 )
   campo.value = vr.substr( 0, 2 ) + '/' + vr.substr( 2, 2 ) + '/' + vr.substr( 4, 4 ); 
 }
}
function FormatValue(campo,tammax,teclapres) {
 var tecla = teclapres.keyCode;
 //vr = document.form[campo].value;
 vr = campo.value;
 vr = vr.replace( "/", "" );
 vr = vr.replace( "/", "" );
 vr = vr.replace( ",", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 vr = vr.replace( ".", "" );
 tam = vr.length;

 if (tam < tammax && tecla != 8){ tam = vr.length + 1 ; }

 if (tecla == 8 ){ tam = tam - 1 ; }
  
 if ( tecla == 8 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 ){
  if ( tam <= 2 ){ 
    document.form[campo].value = vr ; }
   if ( (tam > 2) && (tam <= 5) ){
    document.form[campo].value = vr.substr( 0, tam - 2 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 6) && (tam <= 8) ){
    document.form[campo].value = vr.substr( 0, tam - 5 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 9) && (tam <= 11) ){
    document.form[campo].value = vr.substr( 0, tam - 8 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 12) && (tam <= 14) ){
    document.form[campo].value = vr.substr( 0, tam - 11 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ; }
   if ( (tam >= 15) && (tam <= 17) ){
    document.form[campo].value = vr.substr( 0, tam - 14 ) + '.' + vr.substr( tam - 14, 3 ) + '.' + vr.substr( tam - 11, 3 ) + '.' + vr.substr( tam - 8, 3 ) + '.' + vr.substr( tam - 5, 3 ) + ',' + vr.substr( tam - 2, tam ) ;}
 }
  
 for (var ct = 0; ct < document.form.elements.length; ct++) {
  if (document.form.elements[ct].name == document.form.elements[campo].name) {
   if ( !teclapres.shiftKey && tecla == 9 && document.form[ct+1].name == "senhaConta" && document.applets['tclJava'] ){
    document.applets['tclJava'].setFocus();
   } 
  }
 }
}

function switchOn(tab,contents,topblock,cell) {

  topRow = document.getElementById(topblock);
  tabArray = topRow.childNodes;
  for (var i=0; i<tabArray.length; i++) {
    if (tabArray[i].className != 'tabspacer') {
      tabArray[i].className = 'tab';
    }
  }
  contentsCell = document.getElementById(cell);
  contentsArray = contentsCell.childNodes;
  for (var j=0; j<contentsArray.length; j++) {
    contentsArray[j].className = 'contents';
  }
  document.getElementById(tab).className = 'selectedtab';
  document.getElementById(contents).className = 'selectedcontents';
}

function confirmSubmit(text) {
  if (text==null || text=='') {
    var agree=confirm("Confirma esta Operação?");
  } else {
    var agree=confirm(text);
  }
  if (agree) {
   return true ;
  } else {
   return false ;
 }
}

function confirmSubmit(text, ok, cancel) {
  if (text==null || text=='') {
    text = 'Confirma esta Operação?';
  }  
  if (ok==null || ok=='') {
    ok = 'Ok';
  }  
  if (cancel==null || cancel=='') {
    cancel = 'Cancel';
  }  
  var agree=confirm(text, ok, cancel);
  if (agree) {
   return true ;
  } else {
   return false ;
 }
}

var state = 'hidden';
function showhide(layer_ref) {
  if (state == 'visible') {
    state = 'hidden';
  } else {
    state = 'visible';
  }
  if (document.all) { 
    eval( "document.all." + layer_ref + ".style.visibility = state");
  }
  if (document.layers) { 
    document.layers[layer_ref].visibility = state;
  }
  if (document.getElementById && !document.all) {
    maxwell_smart = document.getElementById(layer_ref);
    maxwell_smart.style.visibility = state;
  }
}

function abremenu(x){
 if (IE) {
 document.all.divinfos[x-1].style.visibility="hidden";
 document.all.divinfos[x-1].style.display='';
 document.all.divinfos[x-1].style.filter="blendTrans(duration=.5)";
 document.all.divinfos[x-1].filters.blendTrans.Apply();
 document.all.divinfos[x-1].style.visibility="visible";
 document.all.divinfos[x-1].filters.blendTrans.Play();
 }
}

function fechamenu(x){
 if (IE) {
 document.all.divinfos[x-1].style.visibility="hidden";
 document.all.divinfos[x-1].style.display='none';
 }
}

var display_url=0
function showmenuie5(e){
  if (navigator.appName.indexOf("Microsoft") < 0) {
    document.getElementById("ie5menu").style.left=e.pageX;
    document.getElementById("ie5menu").style.top=e.pageY; 
  } else {
    document.getElementById("ie5menu").style.left=event.clientX
    document.getElementById("ie5menu").style.top=event.clientY

  }
  document.getElementById("ie5menu").style.visibility="visible"
  return false
}

function hidemenuie5(){
  document.getElementById("ie5menu").style.visibility="hidden"
}

function setCheckField(field, gridCheckFieldName) {
  fields = document.getElementsByName(field.id);
  checkFields = document.getElementsByName(gridCheckFieldName);
  for (i=0;i<fields.length;++ i) {
    if (fields[i]==field) {
      checkFields[i].checked=true;
      break;
    }
  }
}


function abreRelatorioPDF(arquivo){
  if(arquivo != 'null'){
	window.open(arquivo,'_blank');
	}	
}


function wopen(url, name, w, h) {
     w += 32;
     h += 96;
     wleft = (screen.width - w) / 2;
     wtop = (screen.height - h) / 2;
     var win = window.open(url, name, 'width=' + w + ', height=' + h + ', ' + 'left=' + wleft + ', top=' + wtop + ',location=no, menubar=no, status=no, toolbar=no, scrollbars=yes, resizable=no');
     // Just in case width and height are ignored
     //win.resizeTo(w, h);
     // Just in case left and top are ignored
//     win.moveTo(wleft, wtop);
     win.focus();
}



function soNumeros(v){
    return v.replace(/\D/g,"")
}

function mascara(o,f){
    v_obj=o
    v_fun=f
    setTimeout("execmascara()",1)
}
 
function execmascara(){
    v_obj.value=v_fun(v_obj.value)
}







function posicionaItem(campo, event){
 
 
 	if(event.ctrlKey || event.shitfKey || event.altKey || event.metaKey){ return;}
 
	var e = '';
	var new_index = '';
	if (event.keyCode) { 
		e = event.keyCode;  
		
	}  
    else if (event.which) { 
		e = event.which;  
	}   
   	if(e == 38 || e == 40){
		var indice = campo.substring(campo.indexOf('[')+1,campo.indexOf(']'));
		if(e == 38){
			new_index = eval(indice)-eval(1);
			if(new_index <0){new_index = 0;}
		} else {
			new_index = eval(indice)+eval(1);		  
			//if(new_index > max){new_index = max;}
		}
	 
		var novo = campo.replace('['+indice+']','['+new_index+']');
			var focusControl = document.forms[1].elements[novo];
		if ( focusControl != undefined){
			focusControl.focus();
		}
	}
	return;
}  





function controlaPk()
{
    var achou = false;
	for(i=0; i<document.forms[arguments[0]].elements.length; i++){
		if(arguments.length > 0){ 
			for(a=0;a<arguments.length;a++){
				if(document.forms[arguments[0]].elements[i].id==arguments[a] 
				&& document.forms[arguments[0]].elements[i].value!=''
				&& document.forms[arguments[0]].elements[i].id!=''
				&&
				document.getElementsByName(document.forms[arguments[0]].elements[i].name.substring(0,document.forms[arguments[0]].elements[i].name.indexOf('.'))+'.banco')[arguments[0]].value=='S'
				&& a!= arguments.length-1
				
				){
					document.forms[arguments[0]].elements[i].readOnly=true;
					document.forms[arguments[0]].elements[i].className='disabled'; 
					achou = true;
				}
			}
		}
	}
	if(achou==true){
		var focusControl = document.forms[arguments[0]].elements[arguments[arguments.length-1]][0];
		if (focusControl.type != "hidden"){
			focusControl.focus();
		}
	}
}


 
function setarAlterado(campo, index, event, indexCampo){

 if(indexCampo == undefined){indexCampo = '';};
 	if(event.ctrlKey || event.shitfKey || event.altKey || event.metaKey){ return;}
 
 
 	var e = '';
	var new_index = '';
	if (event.keyCode) { 
		e = event.keyCode;  
		
	}  
    else if (event.which) { 
		e = event.which;  
	}  
   


	
	if (e == 37 	|| e == 38 	|| e == 39 	|| e == 40 	||  e == 9 	 || e == 32  || e == 13  ||
        e == 145 	|| e == 20 	|| e == 144 || e == 19  ||  e == 45  || e == 36  || e == 35  ||
		e == 33     || e == 34  || e == 112 || e == 113 ||  e == 114 || e == 115 || e == 116 ||
        e == 117    || e == 118 || e == 119 || e == 120 ||  e == 121 || e == 122 || e == 123 ||
		e == 16     || e == 17  || e == 18  || e == 20  ||  e == 27

		){
		if(e == 38 || e == 40){
			var indice = campo.substring(campo.indexOf('[')+1,campo.indexOf(']'));
			if(e == 38){
				new_index = eval(indice)-eval(1);
				if(new_index <0){new_index = 0;}
			} else {
				new_index = eval(indice)+eval(1);		  
				if(new_index > 9){new_index = 9;}
			}
	  
			var novo = campo.replace('['+indice+']','['+new_index+']');

			var focusControl = document.forms[index].elements[novo];
			if (focusControl.type != "hidden"){
				focusControl.focus();
			}
   
		}
		return;
   }
   
   var indice = '';
   if(index!='0'){
     indice = index;
   }



   

document.forms[index].elements[campo.replace(campo.substring(campo.indexOf('.')+1,campo.length),'alterado'+indexCampo)].value='S';

//return;



   if(document.forms[index].bloqueia_navegador.value==''){
      if(document.forms[index].elements[campo.replace(campo.substring(campo.indexOf('.')+1,campo.length),'banco'+indexCampo)].value!='S'
	  && campo.indexOf('excluir'+indexCampo)==-1
	   ){
     document.forms[index].bloqueia_navegador.value='S';	
     document.forms[index].elements['insert'+indice+'_action'].disabled=false;	   
     document.forms[index].elements['delete'+indice+'_action'].disabled=true;
     document.forms[index].elements['update'+indice+'_action'].disabled=true; 	 
   } else if (campo.indexOf('excluir'+indexCampo)==-1) {
     document.forms[index].bloqueia_navegador.value='S';	   
     document.forms[index].elements['update'+indice+'_action'].disabled=false;
     document.forms[index].elements['insert'+indice+'_action'].disabled=true;
     document.forms[index].elements['delete'+indice+'_action'].disabled=true;


   } else {
	    document.forms[index].bloqueia_navegador.value='S';	   
           document.forms[index].elements['update'+indice+'_action'].disabled=true;
           document.forms[index].elements['insert'+indice+'_action'].disabled=true;
           document.forms[index].elements['delete'+indice+'_action'].disabled=false;
   }
   }
}   




function testPassword(passwd)
{
		var intScore   = 0 
		var strObservacao = "";
		var strVerdict = "Fraca"
		
		// PASSWORD LENGTH
		if (passwd.length<5) {                         // length 4 or less
			intScore = (intScore+3)
		}
		else if (passwd.length>4 && passwd.length<8) { // length between 5 and 7
			intScore = (intScore+6)
		}
		else if (passwd.length>7 && passwd.length<16) { // length between 8 and 15
			intScore = (intScore+12)
		}
		else if (passwd.length>15) {                   // length 16 or more
			intScore = (intScore+18)
		}
		
		// LETTERS (Not exactly implemented as dictacted above because of my limited understanding of Regex)
		if (passwd.match(/[a-z]/)) {                              // [verified] at least one lower case letter
			intScore = (intScore+1)
		}
		
		if (passwd.match(/[A-Z]/)) {                              // [verified] at least one upper case letter
			intScore = (intScore+5)
		}
		
		// NUMBERS
		if (passwd.match(/\d+/)) {
			intScore = (intScore+5)
		}
		
		// at least three numbers
		if (passwd.match(/(.*[0-9].*[0-9].*[0-9])/)) {
			intScore = (intScore+5)
		}
		
		// SPECIAL CHAR
		if (passwd.match(/.[!,@,#,$,%,^,&,*,?,_,~]/)) {
			intScore = (intScore+5)
		}
		
		 // [verified] at least two special characters
		if (passwd.match(/(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])/)) {
			intScore = (intScore+5)
		}
		
		// COMBOS
		if (passwd.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) {
			intScore = (intScore+2)
		}
		if (passwd.match(/([a-zA-Z])/) && passwd.match(/([0-9])/)) {
			intScore = (intScore+2)
		}
		if (passwd.match(/moleca|beirario|molekinha|vizzano|modare/i)) {
  		   intScore = (intScore-10)
		}
		//---------------------------------------------------------------------------------------------------------------
		// [verified] letters, numbers, and special characters
		if (passwd.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/)) {
			intScore = (intScore+2)
		}
	
		if(intScore < 16) {
		   strVerdict = "Muito Fraca"
		   strObservacao = "Tente deixar a sua senha maior, adicionando letras maiúsculas, minúsculas e caracteres especiais.";
		   document.forms[0].forcasenha.style.color='red';
		}
		else if (intScore > 15 && intScore < 25) {
		   strVerdict = "Fraca"
		   strObservacao = "Tente deixar a sua senha maior, adicionando letras maiúsculas, minúsculas e caracteres especiais.";
		   document.forms[0].forcasenha.style.color='red';
		}
		else if (intScore > 24 && intScore < 35) {
		   strVerdict = "Média"
		   strObservacao = "";
		   document.forms[0].forcasenha.style.color='blue';
		}
		else if (intScore > 34 && intScore < 45) {
		   strVerdict = "Forte"
		   strObservacao = "";
		   document.forms[0].forcasenha.style.color='blue';
		} 
		else {
		   strVerdict = "Muito Forte"
		   strObservacao = "";
		   document.forms[0].forcasenha.style.color='green';
		}
	
	document.forms[0].forcasenha.value = (strVerdict);
	document.forms[0].observacao.value = (strObservacao);
}



function valueChanged(campo){
	var txt = campo;
	//On IE
	if(txt.fireEvent){
		txt.fireEvent('onchange');
	}

	if(document.createEvent) {
		var evt = document.createEvent('HTMLEvents');
		if(evt.initEvent){
			evt.initEvent('change', true, true);
		}
		if(txt.dispatchEvent){
			txt.dispatchEvent(evt);
		}
	}
}



  function isMobile(){
            var isMobile = {
                OperaMini: function() {
                    return navigator.userAgent.match(/Opera Mini/i) ? true : false;
                },
                Android: function() {
                    return navigator.userAgent.match(/Android/i) ? true : false;
                },
                BlackBerry: function() {
                    return navigator.userAgent.match(/BlackBerry/i) ? true : false;
                },
                iOS: function() {
                    return navigator.userAgent.match(/iPhone|iPad|iPod/i) ? true : false;
                },
                Windows: function() {
                    return navigator.userAgent.match(/IEMobile/i) ? true : false;
                },
                any: function() {
                    return (isMobile.OperaMini() || isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Windows());
                }
            };
			
			return isMobile.any();
}

/* 

valueChanged(opener.document.forms[returnBlock].<%= return0 %>);	
*/

