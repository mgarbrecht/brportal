package util.ws;

public class CancelaTransacao {
	public static void main(String args[]) {
		Teste3 t = new Teste3("10321413500000004C1A");
		System.out.println(t.cancelar());
	}
} 

/*
CANCELAMENTO : 
<?xml version="1.0" encoding="ISO-8859-1"?>
<erro xmlns="http://ecommerce.cbmp.com.br"><codigo>041</codigo><mensagem>Transação Tid [10069930690648FD1001] já está em cancelamento.</mensagem></erro>
*/