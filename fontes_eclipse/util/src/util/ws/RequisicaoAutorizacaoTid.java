package util.ws;

public class RequisicaoAutorizacaoTid {
	public static void main(String args[]) {
		Teste5RequisicaoAutorizacaoTid t = new Teste5RequisicaoAutorizacaoTid("103633476400002D1001");
		t.cancelar();
	}
}

/*
CANCELAMENTO : 
<?xml version="1.0" encoding="ISO-8859-1"?>
<erro xmlns="http://ecommerce.cbmp.com.br"><codigo>041</codigo><mensagem>Transação Tid [10069930690648FD1001] já está em cancelamento.</mensagem></erro>
*/