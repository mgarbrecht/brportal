var TCR = new Tcalculator();

function Tcalculator() {
	this.oper_old =
	this.oper_old_old =
	this.slag_1 =
	this.slag_2 =
	this.slag_1_old =
	this.out_val =
	this.p_out = '';
	this.t_load = false;
	this.TCRisNumber = TCRisNumber;
	this.TCRisPoint = TCRisPoint;
	this.TCRPopup = TCRPopup;
	this.TCRrezult = TCRrezult;
	this.TCRmntr = TCRmntr;
	// preloading images
	var a_img = [], i, j;
	for (i = 0; i < 19; i ++) {
		a_img[i] = [];
		for (j = 0; j < 3; j ++) {
			a_img[i][j] = new Image();
			a_img[i][j].src = 'img/' + i + '_' + j + '.gif'
		} 
	}
}

function TCRisPoint(tmp,n) {
	var flag = 0;
	if (tmp == '.') {
		var tmp2 = window.win_ch.document.forms[0].elements[0].value;
		for (var i = 0; i < tmp2.length; i ++) {
			thischar = tmp2.substring(i,i + 1);
			if (thischar == '.') flag = 1;
		}
	}
	if (flag == 0) eval('this.slag_' + n + '+=tmp;');
}

function TCRisNumber(data){
	var numStr = "0123456789", thischar, counter = p_counter = err_cod = popr = 0, len=data.length, i;
	for (i = 0; i < len; i ++) {
		thischar = data.substring(i,i + 1);
		if (numStr.indexOf(thischar)!= -1) counter ++;
		if (thischar == '-'){
			if (i != 0) {err_cod = 1; break;}
			else popr ++;
		}
		if (thischar == '.') {
			if ((i == 0 || i == len - 1) || (i == 1 && data.substring(i - 1, i) == '-')) {
				err_cod = 1;
				break;
			}
			else {
				p_counter ++;
				if (p_counter > 1) {
					err_cod = 1;
					break;
				}
				else popr ++;
			}
		}
	}
	if (err_cod != 1 && counter == len - popr) return true;
	else return false;
}

function TCRrezult (slag_1, slag_2, oper) {
	slag_1 = parseFloat(slag_1);
	slag_2 = parseFloat(slag_2);
	eval('out=(' + slag_1 + ')' + oper + '(' + slag_2 + ')');
	return out;
}


function TCRPopup(obj_control) {
	var w = 186, h = 122;
	var ua = navigator.userAgent.toLowerCase();
	var v = navigator.appVersion.substring(0,1);
	var n = navigator.appName.toLowerCase();
	if (!obj_control)
		return alert("Form element specified can't be found in the document.");
	this.control_obj = obj_control;
	if (!this.TCRisNumber(this.control_obj.value)) alert('wrong data');
	else {
		if (ua.indexOf("opera") > 0) {w = 176; h = 135;}
		else if (ua.indexOf("netscape") < 0 && ua.indexOf("msie") < 0 
			&& v >= 5 && ua.indexOf("mac") > 0) {
			w = 212; h = 122;
		}
		else if (n == 'netscape') {
			if (v == 4) { w = 216; h = 128;}
			if (v >= 5) { w = 185; h = 126;}
		}
		
		if (screen) {
			n_left = (screen.width - w) >> 1;
			n_top = (screen.height - h) >> 1;
		}
		win_ch = window.open("../lov/calculator.html","win_ch", "width=" + w + ",height=" + h + ",help=no,status=no,scrollbars=no,resizable=no,top=" + n_top + ",left=" + n_left + ",dependent=yes,alwaysRaised=yes", true);
		win_ch.focus();
	}
}

function TCRmntr(num) {
	var flag = 0;
	if (this.t_load) tmp = window.win_ch.document.forms[0].elements[0].value;
	if (num == 'C') {
		this.out_val = '0';
		this.oper_old = this.oper_old_old = this.slag_1 = this.slag_2 = '';
	}
	else if (tmp != 'NaN' && tmp != 'Infinity')
		switch (num) {
			case '-':
			case '+':
			case '/':
			case '*':
				if (this.slag_1 != '' && this.slag_2 != '') {
					this.out_val = this.slag_1 = this.TCRrezult(this.slag_1, this.slag_2, this.oper_old);
					this.slag_2 = '';
				}
				else if(this.slag_1 == '' && this.slag_2 == '') this.out_val = this.slag_1 = tmp;
				this.oper_old = num;
				break;
			case 'sqr':
				this.slag_1 = tmp;
				this.slag_2 = '';
				this.slag_1 = parseFloat(this.slag_1);
				this.slag_1 = Math.sqrt(this.slag_1);
				this.oper_old =this.oper_old_old ='';
				this.out_val = this.slag_1;
				this.control_obj.value = this.out_val;
				break;
			case '=':
				if (this.oper_old != '') {
					if (this.slag_1 != '' && this.slag_2 != '') {
						this.out_val = this.TCRrezult(this.slag_1, this.slag_2, this.oper_old);
						this.slag_1 = this.slag_1_old = this.slag_2;
					}
					else if (this.slag_1 != '' && this.slag_2 == '') {
						this.out_val = this.TCRrezult(this.slag_1,this.slag_1,this.oper_old);
						this.slag_1_old = this.slag_1;
					}
					this.oper_old_old = this.oper_old;
					this.slag_2 = '';
					this.slag_1 = '';
					this.oper_old = '';
				}
				else if(this.oper_old_old != ''){
					this.slag_2_old = tmp;
					this.out_val = this.TCRrezult(this.slag_2_old, this.slag_1_old, this.oper_old_old);
				}
				else if (this.slag_1 == '' && this.slag_2 == '') this.out_val = '0';
				else this.out_val = this.slag_1;
				this.control_obj.value = this.out_val;
				break;
			case 'z':
				tmp = parseFloat(tmp);
				this.out_val = tmp * -1;
				if (this.slag_1 != '' && this.slag_2 == '') this.slag_1 = this.out_val;
				else if (this.slag_2 != '') this.slag_2 = this.out_val;
				break;
			default:
				if (this.oper_old == '') {
					if (num == '0' && tmp == '0') this.slag_1 = tmp;
					else if (num == '.' && tmp == '0') this.slag_1 = tmp + num;
					else if(num == '.' && this.slag_1 == '') this.slag_1 = '0' + num;
					else if (num == '.' || this.slag_1 != '') this.TCRisPoint(num, '1');
					else this.slag_1 = num;
					this.out_val = this.slag_1;
				}
				else {
					if (num == '0' && tmp == '0') this.slag_2 = tmp;
					else if(num == '.' && this.slag_2 == '') this.slag_2 = '0' + num;
					else if (num == '.' || this.slag_2 != '') this.TCRisPoint(num,'2');
					else this.slag_2 = num;
					this.out_val = this.slag_2;
				}
	}
	if (this.t_load) window.win_ch.document.forms[0].elements[0].value = this.out_val;
}