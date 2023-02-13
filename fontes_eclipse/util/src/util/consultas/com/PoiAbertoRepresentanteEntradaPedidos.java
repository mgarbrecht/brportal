package util.consultas.com;

public class PoiAbertoRepresentanteEntradaPedidos {

	public double retornaPercentual(double previsto, double realizado) {
		double percentual = 0;
		if (previsto > 0 && realizado == 0) {
			return -100;
		}
		if (previsto == 0 && realizado >= 0) {
			return 0;
		}
		if (previsto == 0) {
			previsto = 1;
		}
		percentual = ((realizado * 100d) / previsto) - 100d;
		return percentual;
	}
	
	public double retornaPercentualPos(double previsto, double realizado) {
		return retornaPercentual(previsto, realizado) + 100d;
	}
	
	public double retornaPercentual(int previsto, int realizado) {
		double percentual = 0;
		if (previsto > 0 && realizado == 0) {
			return -100;
		}
		if (previsto == 0 && realizado >= 0) {
			return 0;
		}
		if (previsto == 0) {
			previsto = 1;
		}
		percentual = ((realizado * 100d) / previsto) - 100d;
		return percentual;
	}

	public double retornaPercentualPos(int previsto, int realizado) {
		return retornaPercentual(previsto, realizado) + 100d;
	}

	public double retornaPercentualPreco(double precoPrevisto, double valorRealizado, double quantidadeRealizado) {
		double percentual = 0;
		if (precoPrevisto > 0 && valorRealizado == 0) {
			return -100;
		}
		if (precoPrevisto == 0 && valorRealizado >= 0) {
			return 0;
		}
		if (quantidadeRealizado == 0) {
			quantidadeRealizado = 1;
		}
		percentual = ((((valorRealizado * 100d) / quantidadeRealizado)) / precoPrevisto) - 100d;
		return percentual;
	}

	public double retornaPercentualPrecoPos(double precoPrevisto, double valorRealizado, double quantidadeRealizado) {
		return retornaPercentualPreco(precoPrevisto, valorRealizado, quantidadeRealizado) + 100d;
	}
	
	public double retornaPrecoMedio(double reais, int pares) {
		return reais / (pares==0?1:pares);	
	}

}