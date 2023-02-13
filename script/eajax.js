var preloader = document.createElement("div");
var hasPreloader = false;
var ERROR_CONTAINER = "messageTable";
var ERROR_MESSAGE_DEFAULT = "<br />Entre em contato com o setor de informática para solucionar o problema.";
var MANDATORY_MESSAGE = "O(s) seguinte(s) campo(s) é(são) obrigatório(s):";

function fillOptions(selectId,metodo,params) {
   var selectElement = document.getElementById(selectId);
   var form = new Object();
   form[params[0]] = document.getElementById(params[0]).value;
   eval(metodo + '(form,{callback:function(list) {updateOptionAction(list, selectElement);}});');
   selectElement.focus();
}


function updateOptionAction(list, secondOptionElement) {
	if(secondOptionElement != null && secondOptionElement != undefined) {
		var o = null;
        var t = null;
        resetOption(secondOptionElement);
		for(var i=0;i<list.length;i++) {
            o = document.createElement("option");
			o.setAttribute("value",list[i][0]);
            t = document.createTextNode(list[i][1]);
			o.appendChild(t);
			secondOptionElement.appendChild(o);
		}
    } else {
      errorHandle("Erro na chamada da função. "+ERROR_MESSAGE_DEFAULT);
    }
}


function resetOption(obj) {
  obj.innerHTML='';
}

	
function fillFields(formIndex,params,method,results,mensagem) {
    var actionForm = new Object();
    if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
		DWRUtil.setValue(params[i], (DWRUtil.getValue(params[i])).trim());
        actionForm[params[i]] = (DWRUtil.getValue(params[i])).trim();
	  }
	}
    eval(method + '(actionForm,{callback:function(list) {updateFormAction(formIndex,list,params,results,mensagem);}});');
}	

function fillFieldsBlank(formIndex,params,method,results,mensagem) {
    var actionForm = new Object();
    if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
        actionForm[params[i]] = DWRUtil.getValue(params[i]);
	  }
	}
    eval(method + '(actionForm,{callback:function(list) {updateFormActionBlank(formIndex,list,params,results,mensagem);}});');
}	


function fillFieldsGrid(objeto, formIndex,params,method,results,mensagem) {
	for(var i=0;i<results.length;i++) { 
	    retorno = objeto.name.replace(params[0],results[i]);
		document.forms[formIndex].elements[retorno].value = '';
        document.forms[formIndex].elements[retorno].className='disabled';
	}	
	var parametro = '';
	var actionForm = new Object();
	if(params != null && params.length>0) {
		for(var i=0;i<params.length;i++) {
			if(objeto.name.indexOf(params[i])>0){
				parametro = objeto.value;
				if(parametro==''){return false;}
			} else {
				parametro = (document.forms[formIndex].elements[objeto.name.replace(params[0],params[i])].value);
			}
			actionForm[params[i]] = parametro;
		}
	}
	eval(method + '(actionForm,{callback:function(list) {updateFormGridAction(objeto,formIndex,list,params,results,mensagem);}});');
}	


function updateFormAction(formIndex,list,params,results,mensagem) {
	for(var i=0;i<results.length;i++) {
	  document.forms[formIndex].elements[results[i]].className='disabled';
      document.forms[formIndex].elements[results[i]].value='';
	}
    if(list != null && list.length>0) {
	  for(var i=0;i<list.length;i++) {
	     document.forms[formIndex].elements[list[i][0]].className='disabled';
		 document.forms[formIndex].elements[list[i][0]].value='';
	  }
	  for(var i=0;i<list.length;i++) {
	    if(list[i][1]==''){
		   document.forms[formIndex].elements[list[i][0]].className='error';
		   DWRUtil.setValue(list[i][0],'REGISTRO INVÁLIDO!');
		} else {
		   document.forms[formIndex].elements[list[i][0]].className='disabled';
		   DWRUtil.setValue(list[i][0],list[i][1]);
	    }
	  }
    } else {
      errorHandle("Erro na chamada da função que trata o relacionamento dos campo. "+ERROR_MESSAGE_DEFAULT);
    }
    hidePreloader();
}


function updateFormActionBlank(formIndex,list,params,results,mensagem) {
	for(var i=0;i<results.length;i++) {
	  //document.forms[formIndex].elements[results[i]].className='disabled';
      document.forms[formIndex].elements[results[i]].value='';
	}
    if(list != null && list.length>0) {
	  for(var i=0;i<list.length;i++) {
	     //document.forms[formIndex].elements[list[i][0]].className='disabled';
		 document.forms[formIndex].elements[list[i][0]].value='';
	  }
	  for(var i=0;i<list.length;i++) {
	    if(list[i][1]==''){
		   //document.forms[formIndex].elements[list[i][0]].className='error';
		   //DWRUtil.setValue(list[i][0],'REGISTRO INVÁLIDO!');
		} else {
		   //document.forms[formIndex].elements[list[i][0]].className='disabled';
		   DWRUtil.setValue(list[i][0],list[i][1]);
	    }
	  }
    } else {
      errorHandle("Erro na chamada da função que trata o relacionamento dos campo. "+ERROR_MESSAGE_DEFAULT);
    }
    hidePreloader();
}
 

function updateFormGridAction(objeto, formIndex, list,params,results, mensagem) {
	for(var i=0;i<results.length;i++) {
	  document.forms[formIndex].elements[results[i]].className='disabled';
      document.forms[formIndex].elements[results[i]].value='';
	}	
	var retorno = '';
    if(list != null && list.length>0) {
	  for(var i=0;i<list.length;i++) { 
	    retorno = objeto.name.replace(params[0],results[i]);
	    if(list[i][1]=='' || list[i][1]=='null'){
		   document.forms[formIndex].elements[retorno].className='error';
		   document.forms[formIndex].elements[retorno].value = 'REGISTRO INVÁLIDO!';
		} else {
		   document.forms[formIndex].elements[retorno].className='disabled';
		   document.forms[formIndex].elements[retorno].value = list[i][1];
	    }
	  }
    } else {
      errorHandle("Erro na chamada da função que trata o relacionamento dos campo. "+ERROR_MESSAGE_DEFAULT);
    }
    hidePreloader();
}


function fillForms(row, params, returns, formIndex, pos) {
	for(var i=0;i<params.length;i++) {
		DWRUtil.setValue(params[i],row[returns[i]]);
	}
	if(pos != null && pos != undefined) {
		DWRUtil.setValue("navigation_pos"+formIndex,pos);
	}
	hidePreloader();
}


function selectEvent(formIndex,method,params,returns) {
	showPreloader();
	var actionForm = new Object();
	if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
      	if( document.forms[formIndex].elements[params[i]].type != undefined &&
      	    document.forms[formIndex].elements[params[i]].type != null &&
      	    document.forms[formIndex].elements[params[i]].type.indexOf("select") != -1) {
      		if(document.forms[formIndex].elements[params[i]].value=="" ||
      			document.forms[formIndex].elements[params[i]].value==null) {
      			actionForm[params[i]]="";
      		}
      	} else {
      		if(isGroupedElement(document.forms[formIndex].elements[params[i]])) {
      			var isChecked = false;
      			for(var k=0;k<document.forms[formIndex].elements[params[i]].length;k++) {
      				if(k>0) {
	      				if(document.forms[formIndex].elements[params[i]][k].type != document.forms[formIndex].elements[params[i]][k-1].type) {
	      					errorHandle("Erro: O grupo "+params[i]+" possui elementos com tipos diferentes.");
	      					return;
	      				}
      				}
      				if(document.forms[formIndex].elements[params[i]][k].type == "radio" &&
      				   document.forms[formIndex].elements[params[i]][k].checked) {
      					isChecked = true;
      				}
      			}
      			if(isChecked) {
      				actionForm[params[i]] = DWRUtil.getValue(params[i]);
      			} else {
      				actionForm[params[i]] = "";
      			}
      		} else {
           		actionForm[params[i]] = DWRUtil.getValue(params[i]);
      		}
      	}
	  }
	}
	eval('ActionClass.'+method+'(actionForm,{callback:function(list) {selectAction(list,params,returns,formIndex);}});');
}


function selectAction(list,params,returns,formIndex) {
	if(list != null && list.length > 0) {
		fillForms(list[0],params,returns,null,null);
		if(document.forms[formIndex].elements["navigation_pos"+formIndex] != null &&
		   document.forms[formIndex].elements["navigation_pos"+formIndex] != undefined) {
			document.forms[formIndex].elements["navigation_pos"+formIndex].value = "1";
			document.forms[formIndex].elements["navigation_max"+formIndex].value = list.length;
		}
	} else {
		errorHandle("Nenhum registro retornado");
	}
	hidePreloader();
}


function insertEvent(formIndex,method,params,mandatoryFields) {
	showPreloader();
	var actionForm = new Object();
	var mandatoryArray = hasEmptyMandatoryFields(formIndex,mandatoryFields);
	if(mandatoryArray.length > 0) {
		makeErrorString(mandatoryArray);
		return;
	}
	if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
      	actionForm[params[i]] = DWRUtil.getValue(params[i]);
	  }
	}
	eval('ActionClass.'+method+'(actionForm,{callback:function(list) {insertAction(list,formIndex);}});');
}


function insertAction(list,formIndex) {
	if(list != null && list.length > 0) {
		document.forms[formIndex].reset();
	} else {
		errorHandle("Erro na inserção do registro");
	}
	hidePreloader();
}


function updateEvent(formIndex,method,params,mandatoryFields) {
	showPreloader();
	var actionForm = new Object();
	var mandatoryArray = hasEmptyMandatoryFields(formIndex,mandatoryFields);
	if(mandatoryArray.length > 0) {
		makeErrorString(mandatoryArray);
		return;
	}
	if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
      	actionForm[params[i]] = DWRUtil.getValue(params[i]);
	  }
	}
	if(document.forms[formIndex].elements["navigation_pos"+formIndex] != null && document.forms[formIndex].elements["navigation_pos"+formIndex] != undefined) {
		var posTemp = parseInt(document.forms[formIndex].elements["navigation_pos"+formIndex].value);
		if(typeof posTemp == "number") {
			eval('ActionClass.'+method+'(actionForm,' + (posTemp-1) + ',{callback:function(list) {updateAction(list,formIndex);}});');			
		} else {
			errorHandle(document.forms[formIndex].elements["navigation_pos"+formIndex].value+" não é um valor válido");
		}
	} else {
		eval('ActionClass.'+method+'(actionForm,{callback:function(list) {updateAction(list,formIndex);}});');	
	}
}


function updateAction(list,formIndex) {
	if(list != null && list.length > 0) {
	} else {
		errorHandle("Erro na atualização do registro");
	}
	hidePreloader();
}


function deleteEvent(formIndex, method, params, returns, mandatoryFields) {
	showPreloader();
	var actionForm = new Object();
	var mandatoryArray = hasEmptyMandatoryFields(formIndex,mandatoryFields);
	if(mandatoryArray.length > 0) {
		makeErrorString(mandatoryArray);
		return;
	}
	if(params != null && params.length>0) {
      for(var i=0;i<params.length;i++) {
      	actionForm[params[i]] = DWRUtil.getValue(params[i]);
	  }
	}
	if(document.forms[formIndex].elements["navigation_pos"+formIndex] != null && document.forms[formIndex].elements["navigation_pos"+formIndex] != undefined) {
		var posTemp = parseInt(document.forms[formIndex].elements["navigation_pos"+formIndex].value);
		if(typeof posTemp == "number") {
			posTemp--;
			eval('ActionClass.'+method+'(actionForm,' + posTemp + ',{callback:function(list) {deleteAction(list,formIndex,params,returns,posTemp);}});');			
		} else {
			errorHandle(document.forms[formIndex].elements["navigation_pos"+formIndex].value+" não é um valor válido");
		}
	} else {
		eval('ActionClass.'+method+'(actionForm,{callback:function(list) {deleteAction(list,formIndex,null,null,null);}});');	
	}
}


function deleteAction(list,formIndex,params,returns,pos) {
	if(list != null && list.length > 0) {
		if(document.forms[formIndex].elements["navigation_max"+formIndex] != null && 
		   document.forms[formIndex].elements["navigation_max"+formIndex] != undefined &&
		   pos != null && list[0] != "0") {
			if(params != null && params.length > 0) {
				if(parseInt(document.forms[formIndex].elements["navigation_pos"+formIndex].value) < parseInt(document.forms[formIndex].elements["navigation_max"+formIndex].value)) {
					fillForms(list[0],params,returns,formIndex,null);
					DWRUtil.setValue("navigation_max"+formIndex,parseInt(document.forms[formIndex].elements["navigation_max"+formIndex].value)-1);
				} else {
					if(parseInt(document.forms[formIndex].elements["navigation_pos"+formIndex].value) == parseInt(document.forms[formIndex].elements["navigation_max"+formIndex].value)) {
						fillForms(list[0],params,returns,formIndex,pos);
						DWRUtil.setValue("navigation_max"+formIndex,parseInt(document.forms[formIndex].elements["navigation_max"+formIndex].value)-1);
					}
				}
			} else {
				errorHandle("Erro: Os parâmetros de retorno não foram passados.")
			}
		} else {
			document.forms[formIndex].reset();
		}
	} else {
		errorHandle("Erro na deleção do registro");
	}
	hidePreloader();
}


function resetFullEvent(formIndex,method) {
	showPreloader();
	eval('ActionClass.'+method+'({callback:function() {resetFullAction(formIndex);}});');
}


function resetFullAction(formIndex) {
	document.forms[formIndex].reset();
	hidePreloader();
}


function hasEmptyMandatoryFields(formIndex,params) {
	var mandatoryFieldsArray = new Array();
	var fieldTemp = null;
	for(var i=0;i<params.length;i++) {
		fieldTemp = document.forms[formIndex].elements[params[i]];
		if(fieldTemp != null && fieldTemp != undefined) {
		    if(isGroupedElement(fieldTemp))	{
		    	var flag = false;
		    	for(var k=0;k<fieldTemp.length;k++) {
		    		if(fieldTemp[k].checked) {
		    			flag = true;
		    		}
		    	}
		    	if(!flag) {
		    		mandatoryFieldsArray.push(params[i]);
		    	}
		    } else {
				if(fieldTemp.value == null || fieldTemp.value.length == 0) {
					mandatoryFieldsArray.push(params[i]);
				}
			}
		} else {
			errorHandle("Não existe nenhum elemento com o ID: "+params[i]);
			return;
		}
	}
	return mandatoryFieldsArray;
}


function showPreloader() {
	hideErrors();
	mandatoryFieldsArray = new Array();
	preloader.style.width = "220px";
	preloader.style.height = "auto";
	preloader.style.color = "#fff";
	preloader.style.backgroundColor = "#ff0000";
	preloader.style.position = "absolute";
	preloader.style.top = "0px";
	preloader.style.left = "0px";
	preloader.style.padding = "1px 1px 1px 4px";
	preloader.style.verticalAlign = "middle";
	preloader.innerHTML = "Loading...";
	document.body.appendChild(preloader);
	hasPreloader = true;
}


function hidePreloader() {
	if(hasPreloader) {
		document.body.removeChild(preloader);
		hasPreloader = false;
	}		
}


function isGroupedElement(obj) {
	if(obj.length > 0 && obj[0] != null && obj[0] != undefined) {
		return true;
	}
	return false;
}


function makeErrorString(mandatoryFieldsArray) {
	if(mandatoryFieldsArray != null && mandatoryFieldsArray.length > 0) {
		var strErr = MANDATORY_MESSAGE+"<br />";
		strErr += "<ul class=\"mandatoryFields\">";
		for(var i=0;i<mandatoryFieldsArray.length;i++) {
			strErr += "<li>" + hashMapLabel.get(mandatoryFieldsArray[i]) + "</li>";
		}
		strErr += "</ul>";
		errorHandle(strErr);
	}
}


function errorHandle(msg) {
	var tables = document.getElementsByTagName("table");
	for(var i=0;i<tables.length;i++) {
		/*
		if(tables[i].className==ERROR_CONTAINER) {
			var tdContainer = tables[i].getElementsByTagName("tr")[0].getElementsByTagName("td")[0];
			tdContainer.innerHTML += "<span style=\"color:red\">"+msg+"</span>";
			break;
		}
		*/
	}
	hidePreloader();
}


function hideErrors() {
	var tables = document.getElementsByTagName("table");
	for(var i=0;i<tables.length;i++) {
		/*
		if(tables[i].className==ERROR_CONTAINER) {
			var tdContainer = tables[i].getElementsByTagName("tr")[0].getElementsByTagName("td")[0];
			spanArray = tdContainer.getElementsByTagName("span");
			for(var i=spanArray.length-1;i>=0;i--) {
				tdContainer.removeChild(spanArray[i]);
			}
			break;
		}
		*/
	}
}

DWREngine.setErrorHandler(errorHandle);