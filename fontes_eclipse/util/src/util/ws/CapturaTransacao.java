package util.ws;

public class CapturaTransacao {
	public static void main(String args[]) {
		Teste4Captura t = new Teste4Captura("103633476400002D1001");
		t.cancelar();
	}
}

/*
CANCELAMENTO : 
<?xml version="1.0" encoding="ISO-8859-1"?>
<erro xmlns="http://ecommerce.cbmp.com.br"><codigo>041</codigo><mensagem>Transa��o Tid [10069930690648FD1001] j� est� em cancelamento.</mensagem></erro>
*/