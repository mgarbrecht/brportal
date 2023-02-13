package acesso.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import acesso.EntidadeNegocioAPI;
import acesso.TipoEntidadeNegocioAPI;
import acesso.UsuarioAPI;

public class TreeAcessoBean implements java.io.Serializable {
  
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private String contextPath;
	private StringBuilder out;
	private ArrayList<TipoEntidadeNegocioAPI> tiens;
	  
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public void setContextPath(String context) {
		this.contextPath = context;
	}

	private void showUsuarioNode(UsuarioAPI usua, int parent) {
		this.out.append("d.add(").append(usua.getId()).append(", ").append(parent).append(", '");
		this.out.append(usua.getUsuario()).append(" - ").append(usua.getNome()).append("', '").append(this.contextPath);
		this.out.append("/acesso/AutorizacaoForm.do?tipo=usuario&usua_id=").append(usua.getId());
		this.out.append("', null, null, '").append(this.contextPath).append("/img/usuario.png', '");
		this.out.append(this.contextPath).append("/img/usuario.png');");
	}

	private void showEntidadeNegocioNode(EntidadeNegocioAPI enne, int parent)
			throws SQLException {
		this.out.append("d.add(").append(enne.getId()).append(", ").append(parent).append(", '");
		this.out.append(enne.getDescricao()).append("', '").append(this.contextPath);
		this.out.append("/acesso/AutorizacaoForm.do?tipo=entidade&enne_id=").append(enne.getId());
		this.out.append("', null, null, '").append(this.contextPath).append("/img/folder.gif', '");
		this.out.append(this.contextPath).append("/img/folderopen.gif');");
		for (UsuarioAPI usua : enne.getUsuarios()){
			showUsuarioNode(usua, enne.getId());
		}
			
	}

	private void showTipoEntidadeNegocioNode(TipoEntidadeNegocioAPI tien, int parent) throws SQLException {
		this.out.append("d.add(").append(tien.getId()).append(", 0, '").append(tien.getTipo());
		this.out.append("', '").append(this.contextPath);
		this.out.append("/acesso/AutorizacaoForm.do?tipo=tipo_entidade&tien_id=");
		this.out.append(tien.getId()).append("', null, null, '").append(this.contextPath);
		this.out.append("/img/folder.gif', '").append(this.contextPath).append("/img/folderopen.gif');");
    
		for (EntidadeNegocioAPI enne : tien.getEntidadesNegocio()){
			showEntidadeNegocioNode(enne, tien.getId());
		}
	}
  
	public void refresh() {
		if (this.tiens != null) {
			this.tiens.clear();
			this.tiens = null;
		}
	}
  
	public String getOut() {
		return (out == null ? toString() : out.toString());
	}
  
	public String toString() {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			this.out = new StringBuilder();
			this.out.append("<link rel=\"StyleSheet\" href=\"").append(this.contextPath);
			this.out.append("/css/dtree.css\" type=\"text/css\" />");
			this.out.append("<script type=\"text/javascript\" src=\"");
			this.out.append(this.contextPath).append("/script/dtree.js\"></script>");
			this.out.append("<div id=\"tree_acesso\" class=\"dtree\">");
			this.out.append("<p><a href=\"javascript:d.openAll();\">Expandir tudo</a> | <a href=\"javascript:d.closeAll();\">Fechar tudo</a> | <a href=\"../acesso/AutorizacaoForm.do?atualiza_arvore_action=\">Atualizar Árvore</a></p>");
			this.out.append("<script type=\"text/javascript\">");
			this.out.append("d = new dTree('d');");
			this.out.append("d.add(0, -1, 'BR Portal');");
			if (this.conn == null) {
				throw new SQLException("A conexão com o banco não foi passada.");
			}
			if (this.tiens == null) {
				this.tiens = new ArrayList<TipoEntidadeNegocioAPI>();
				pstm = this.conn.prepareStatement("select tien_id from tipos_entidade_negocio ");// where tien_id = 17");
				rset = pstm.executeQuery();
				while (rset.next()){
					tiens.add(new TipoEntidadeNegocioAPI(this.conn, rset.getInt(1)));
				}
				rset.close(); 
				pstm.close();
			}
			for (TipoEntidadeNegocioAPI tien : this.tiens){
				showTipoEntidadeNegocioNode(tien, 0);
			}
			pstm = this.conn.prepareStatement(
					new StringBuilder(" SELECT /*+ all_rows */ usua_id ")
							  .append("   FROM usuarios ")
							  .append("  WHERE usua_enne_id is null").toString());
			rset = pstm.executeQuery();
			while (rset.next()){
				showUsuarioNode(new UsuarioAPI(this.conn, rset.getInt(1)), 0);
			}

			this.out.append("document.write(d);");
			this.out.append("</script>");
			this.out.append("</div>");
		} catch (SQLException e) { 
			e.printStackTrace();
			this.out.append(e.getMessage());
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return out.toString();
	}
}

