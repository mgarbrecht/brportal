package util.consultas;

public class DiasUteis {

	public String buscar(int dias) {
		String novaData = null;
		String feriado = null;
		int diasUteis = 0;
		int contador = 0;
		util.consultas.Query query = new util.consultas.Query();
		StringBuilder sb = new StringBuilder();
		try {
			while (diasUteis < dias) {
				contador++;
				sb = new StringBuilder();
				sb.append(" SELECT fct_dia_util('01','16',sysdate+").append(contador).append(") ");
				sb.append("   FROM dual ");
				feriado = query.retorna(sb.toString());
				if(feriado.equalsIgnoreCase("S")){
					diasUteis ++;
				} 
			}
			sb = new StringBuilder();
			sb.append(" SELECT to_char(sysdate+").append(contador).append(",'dd/mm/yyyy hh24:mi:ss') ");
			sb.append("   FROM dual ");
			novaData = query.retorna(sb.toString());
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
		}
		return novaData;
	}

}
