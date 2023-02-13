function Favorit(id, href, text) {
  this.id = id;
  this.href = href;
  this.text = text;
  
  
  this.toString = function() {
    out = '<a href="' + this.href + '">' + this.text + '</a>&nbsp;&nbsp;'
        + '<a href="javascript:<favoritList>.delFavorit(' + this.id + ')">'
        + '<img src="<imgPath>/del_favoritos.gif" height="16" border="0"'
        + ' title="'+delfavoritos+'"></a>';
       
    return out;
  }
} 



function FavoritList(instanceName, imgPath, labelfavoritos, removerfavoritos){
  this.name = instanceName;
  this.favorits = [];
  this.imgPath = imgPath;
  this.content = null;
  this.operation = "N";
  this.length = 0;
  this.addURL = null;
  this.delURL = null;
  this.exeURL = null;
  lbfavoritos = labelfavoritos;
  delfavoritos = removerfavoritos;
  
  this.setContent = function(elm) {
    this.content = elm;
  }
  
  this.updateContent = function() {
	if (this.content){
		this.content.innerHTML = this.contentHTML();
	}
  }

  this.addFavorit = function (id, href, text) {
    this.length++;
    this.favorits[this.favorits.length] = new Favorit(id, href, text);
    if (this.addURL){
	 this.exeURL = this.addURL.replace(/<id>/i, '' + id);
	}
     
    this.updateContent();
  }
  
  this.delFavorit = function(id) {
    for (i = 0; i < this.favorits.length; i++)
      if (this.favorits[i] && this.favorits[i].id == id) {
        this.favorits[i] = null;
        this.length--;
        if (this.delURL)
          this.exeURL = this.delURL.replace(/<id>/i, '' + id);
      }
    this.updateContent();
  }
  
  this.setOperation = function(select) {
    i = select.selectedIndex;
    this.operation = select.options[i].value;
  }
  
  this.setAddURL = function(URL) {
    this.addURL = URL;
  }

  this.setDelURL = function(URL) {
    this.delURL = URL;
  }
  
  this.contentHTML = function() {
    if (this.length == 0 && this.operation == "R")
      this.operation = "N";
    out = '<table><tr><th valign="middle"><img border="0" '+
          'src="' + this.imgPath + '/list_favoritos.gif"></th><td><big><b>'+ lbfavoritos+
          '</b></big></td></tr>';
    for (i = 0; i < this.favorits.length; i++)
      if (this.favorits[i])
        out += ('<tr><td colspan="2" valign="middle">'+
                this.favorits[i].toString().replace(/<favoritList>/i,
                  this.name).replace(/<imgPath>/i, this.imgPath) +
                '</td></tr>');
    out += '</table>';
    if (this.exeURL) 
       out += '<iframe class="myhidden" src="' + this.exeURL + '"></iframe>';
    return out;
  }
  
  this.toString = function() {
    out = '<div id="favoritList">' + this.contentHTML() + '</div>' +
          '<script>' + this.name +
          '.setContent(document.getElementById("favoritList"));</script>';
    return out;
  }
}