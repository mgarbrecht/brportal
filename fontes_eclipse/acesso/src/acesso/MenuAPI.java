package acesso;

import java.sql.*;
import java.util.*;

public class MenuAPI extends Menu {

	private Connection conn;
	private Menu old;
	private Usuario usuario;
	private ArrayList<MenuAPI> subMenus;
	private ArrayList<ItemMenuAPI> itens;
  	  
	public MenuAPI(Connection conn) {
		super();
		this.conn = conn;
	}
  
	public MenuAPI(Connection conn, int id) throws SQLException {
		this(conn);
		select(id);
	}

	public ArrayList<ItemMenuAPI> getItens() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (this.itens == null || this.usuario != null) {
				this.usuario = null;
				this.itens = new ArrayList<ItemMenuAPI>();
				pstm = this.conn.prepareStatement(
						new StringBuilder(" SELECT /*+ all_rows */ itme_id ")
								  .append("   FROM itens_menus ")
								  .append("  WHERE itme_menu_id = ? ")
								  .append("    AND itme_menu_codigo_sistema = 'BRNET' ")
								  .append("  ORDER BY itme_texto ").toString()
				);
				pstm.setInt(1, this.id);
				rset = pstm.executeQuery();
				while (rset.next()) {
					this.itens.add(new ItemMenuAPI(this.conn, rset.getInt(1)));
				}
			}
		} finally {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
		}
		return this.itens;
	}

	public ArrayList<ItemMenuAPI> getItens(Usuario usuario) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (this.usuario == null || this.usuario.getId() != usuario.getId()) {
				this.usuario = usuario;
				this.itens = new ArrayList<ItemMenuAPI>();
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT /*+ all_rows */ itme_id ");
				sb.append("   FROM itens_menus ");
				sb.append("  WHERE itme_menu_id = ? ");
				sb.append("    AND (itme_doin_id is null ");
				sb.append("    AND itme_menu_codigo_sistema = 'BRNET' ");
				sb.append("     OR EXISTS (SELECT 1 ");
				sb.append("                  FROM acessos_documentos_interfaces ");
				sb.append("                 WHERE acdi_doin_id = itme_doin_id ");
				sb.append("                   AND acdi_usua_id = ?))"); 
				sb.append("  ORDER BY itme_texto ");      
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(1, id);
				pstm.setInt(2, this.usuario.getId());
				rset = pstm.executeQuery();
				while (rset.next()){
					this.itens.add(new ItemMenuAPI(this.conn, rset.getInt(1)));    	  
				}
			}
			return this.itens;			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();			
			}
		}
	}

	
	public ArrayList<MenuAPI> getSubMenus() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (this.subMenus == null) {
				this.subMenus = new ArrayList<MenuAPI>();
				StringBuilder sb = new StringBuilder();
				sb.append(" SELECT /*+ all_rows */ menu_id ");
				sb.append("   FROM menus ");
				sb.append("  WHERE menu_pai_menu_id = ? ");
				sb.append("    AND menu_codigo_sistema = 'BRNET' ");
				sb.append("  ORDER BY menu_texto ");      
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setInt(1, id);
				rset = pstm.executeQuery();
				while (rset.next()){
					this.subMenus.add(new MenuAPI(this.conn, rset.getInt(1)));    	  
				}
			}
			return this.subMenus;			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();			
			}
		}
	}

	
	public void setNome(String nome) {
		super.setNome(nome.trim().toUpperCase());
	}

	
	public void validate() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder emsg = new StringBuilder();
			if (this.nome == null || this.nome.equals("")){
				emsg.append("O nome deve ser informado.");
			} else {
				pstm = this.conn.prepareStatement("SELECT /*+ all_rows */ menu_id FROM menus WHERE menu_nome = ? ");
				pstm.setString(1, this.nome);
				rset = pstm.executeQuery();
				if (rset.next()){
					emsg.append("Menu já cadastrado.\n");    	  
				}
			}
			if (this.texto == null || this.texto.equals("")){
				emsg.append("O texto do menu deve ser informado");				
			}
			if (this.menuPai != null && this.menuPai.getId() == 0){
				emsg.append("Menu pai não cadastrado.");
			}
			if (emsg.length() > 0){
				throw new SQLException(emsg.toString());				
			}
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	public void insert() throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			if (this.id == 0) {
				int newId;
				validate();
				pstm = this.conn.prepareStatement("SELECT nvl(max(menu_id)+1,1) FROM menus");
				rset = pstm.executeQuery();
				rset.next();
				newId = rset.getInt(1);
				//newId = sequence.nextValue("menus", "menu_id");
				rset.close();
				pstm.close();
				StringBuilder sb = new StringBuilder();
				sb.append(" INSERT INTO menus ");
				sb.append("        ( menu_id ");
				sb.append("        , menu_nome ");
				sb.append("        , menu_texto ");
				sb.append("        , menu_pai_menu_id  ");
				sb.append("        , menu_codigo_sistema ) ");
				sb.append(" VALUES (?, ?, ?, ?, 'BRNET')");      
				pstm = conn.prepareStatement(sb.toString());
				pstm.setInt(1, newId);
				pstm.setString(2, this.nome);
				pstm.setString(3, this.texto);
				if (this.menuPai == null){
					pstm.setString(4, "");
				} else {
					pstm.setInt(4, this.menuPai.getId());				
				}
				pstm.executeUpdate();
				pstm.close();
				select(newId);
			} else {
				throw new SQLException("Menu já cadastrado.");			
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	public void select(int id) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT /*+ all_rows */ menu_nome ");
			sb.append("      , menu_texto  ");
			sb.append("      , menu_pai_menu_id ");
			sb.append("   FROM menus ");
			sb.append("  WHERE menu_id = ? ");
			sb.append("    AND menu_codigo_sistema = 'BRNET' ");
			pstm = this.conn.prepareStatement(sb.toString());
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			if (rset.next()) {
				this.nome = rset.getString(1);
				this.texto = rset.getString(2);
				int menuPaiID = rset.getInt(3);
				if (menuPaiID == 0)
					this.menuPai = null;
				else {
					MenuAPI menupai = new MenuAPI(this.conn);
					menupai.select(menuPaiID);
					this.menuPai = (Menu) menupai;
				}
				this.id = id;
				if (this.itens != null)
					this.itens.clear();
				if (this.subMenus != null)
					this.subMenus.clear();
				this.old = (Menu) this;
			}
			else {
				throw new SQLException("Menu não cadastrado.");
			}			
		} finally {
			if(rset!=null){
				rset.close();
			}
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	
	public void update() throws SQLException {
		PreparedStatement pstm = null;
		try {
			if (this.old != null && this.id == this.old.id) {
				StringBuilder sb = new StringBuilder();
				sb.append(" UPDATE menus ");
				sb.append("    SET menu_nome = ? ");
				sb.append("      , menu_texto = ? ");
				sb.append("      , menu_pai_menu_id = ? ");
				sb.append("  WHERE menu_id = ?");      
				pstm = this.conn.prepareStatement(sb.toString());
				pstm.setString(1, this.nome);
				pstm.setString(2, this.texto);
				if (this.menuPai == null){
					pstm.setString(3, "");
				} else {
					pstm.setInt(3,this.menuPai.getId());
				}
				pstm.setInt(4, this.id);
				pstm.executeUpdate();
				select(this.id);
			}
			else {
				throw new SQLException("Menu não cadastrado.");			
			}			
		} finally {
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	
	public void delete() throws SQLException {
		PreparedStatement pstm = null;
		try {
			if (this.old != null && this.id == this.old.id) {
				pstm = conn.prepareStatement(
						new StringBuilder(" DELETE menus ")
								  .append("  WHERE menu_id = ?").toString());
				pstm.setInt(1, this.id);
				pstm.executeUpdate();
				this.id = 0;
			}
			else {
				throw new SQLException("Menu não cadastrado.");			
			}			
		} finally {
			if(pstm!=null){
				pstm.close();
			}
		}
	}

	
}