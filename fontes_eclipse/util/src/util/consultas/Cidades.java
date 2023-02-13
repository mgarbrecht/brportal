package util.consultas;

import java.util.Vector;

public class Cidades {

	private com.egen.util.jdbc.JdbcUtil j;
	private String email;
	private String fones;
	
	public Cidades() {
	}
	
	public Cidades(com.egen.util.jdbc.JdbcUtil j) {
		this.j = j;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFones() {
		return fones;
	}

	public void setFones(String fones) {
		this.fones = fones;
	}

	public String retornaCidades(String cli_cdgo) throws Exception {
		if(this.j == null) {
			return getCidades(cli_cdgo);
		} else {
			return getCidadesByQuery(cli_cdgo);
		}
	}
	
	public String getCidades(String cli_cdgo) throws Exception {
		StringBuilder cidades = new StringBuilder();
		StringBuilder emails = new StringBuilder();
		StringBuilder fones = new StringBuilder();
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			j = new com.egen.util.jdbc.JdbcUtil();
			portalbr.dbobj.view.Cidades table = new portalbr.dbobj.view.Cidades();
			String[][] select = null;
			String[] order = { "cidade" };
			Object[][] where = { { "cli_cdgo", "=", cli_cdgo } };
			Vector<?> res_Cidades = j.select(table, select, where, null, null, order);
			if (res_Cidades != null && res_Cidades.size() > 0) {
				portalbr.dbobj.view.Cidades r = (portalbr.dbobj.view.Cidades) res_Cidades.elementAt(0);
				for (int x = 0; x < res_Cidades.size(); x++) {
					r = (portalbr.dbobj.view.Cidades) res_Cidades.elementAt(x);
					cidades.append((r.getCidade() + "<br>"));
					emails.append((r.getEsc_email() + "<br>"));
					fones.append((r.getFones() + "<br>"));
				}
				setEmail(emails.toString());
				setFones(fones.toString());
			}
		} finally {
			if (j != null) {
				j.close();
				j = null;
			}
		}
		return cidades.toString();
	}
	
	public String getCidadesByQuery(String cli_cdgo) throws Exception {
		StringBuilder cidades = new StringBuilder();
		StringBuilder emails = new StringBuilder();
		StringBuilder fones = new StringBuilder();
		try {
			portalbr.dbobj.view.Cidades table = new portalbr.dbobj.view.Cidades();
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ ");
			sb.append("        DISTINCT ecl.cli_cdgo ");
			sb.append("      , ecl.ecl_cdad || ' - ' || ecl.est_unifed cidade ");
			sb.append("      , NVL(esc.esc_email, '-') esc_email ");
			sb.append("      , NVL(rowtocol('SELECT ffs_ddd2 || '' - '' || ffs_nmro2 fone FROM fax_fon2 WHERE cli_cdgo = ' || ");
			sb.append("                       ecl.cli_cdgo || '  AND esc_seqn = ' || ecl.esc_seqn || ");
			sb.append("                       '  AND ned_cdgo = ''' || ecl.ned_cdgo || '''  '), '-') fones ");
			sb.append("   FROM ecl ");
			sb.append("      , esc ");
			sb.append("  WHERE ecl.ned_cdgo IN ('ENT', 'UNI') ");
			sb.append("    AND esc.cli_cdgo = ecl.cli_cdgo ");
			sb.append("    AND esc.esc_seqn = ecl.esc_seqn ");
			sb.append("    AND esc.esc_situacao = 'A' ");
			sb.append("    AND esc.cli_cdgo = ").append(cli_cdgo);
			sb.append("  ORDER BY cidade ");
			Vector<?> res_Cidades = j.select(table, sb.toString(), null);
			if (res_Cidades != null && res_Cidades.size() > 0) {
				portalbr.dbobj.view.Cidades r = (portalbr.dbobj.view.Cidades) res_Cidades.elementAt(0);
				for (int x = 0; x < res_Cidades.size(); x++) {
					r = (portalbr.dbobj.view.Cidades) res_Cidades.elementAt(x);
					cidades.append((r.getCidade() + "<br>"));
					emails.append((r.getEsc_email() + "<br>"));
					fones.append((r.getFones() + "<br>"));
				}
				setEmail(emails.toString());
				setFones(fones.toString());
			}
		} finally {
		}
		return cidades.toString();
	}	
	
	public String retornaEmails() throws Exception {
		return this.email;
	}
	
	public String retornaFones() throws Exception {
		return this.fones;
	}	
}
