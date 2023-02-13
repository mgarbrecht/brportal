package carga;	
import java.sql.*;

import util.rdb.ConnectionJDBC;
 
public class CarregaLojaVirtual {
	
    private Connection conn_oracle = null;
    private Connection conn_mysql  = null;
 
	public void carregar() throws Exception {

    try {
//--- Abre conexões
		openDBConnections();
//--- Limpa tabelas do banco MySQL
		truncateTables();
//--- Carrega Cor, Cabedal, Manufacturers e Ref_cor
		insereCor();
		insereCabedal(); 
		insereManufacturers();
        insereRef_cor();

//--- Rotina Attributos Prod
		insereProductsOptionsValuesCabedal();
		insereProductsOptionsValuesCor();
		insereProductsOptionsValuesQtd();

//--- Rotina Categorias Produtos
		insereCategoriesCatDescription();

//--- Rotina Produtos Cabedal
		rotinaProdutosCabedal();

//--- Rotina Produtos Estoque
		rotinaProdutosEstoque();

    } catch (Exception e) {
    	e.printStackTrace();
    } finally {  
    	conn_oracle.close();
    	conn_mysql.close();
    	}
	}

	private void openDBConnections() throws Exception {
		this.conn_oracle = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
		// loja  = banco de produção
		// loja2 = banco de teste
		this.conn_mysql  = ConnectionJDBC.get("loja", "root", "web80br");
	}

	private void truncateTables() throws SQLException {
		PreparedStatement pstm_mysql = conn_mysql.prepareStatement("");
    	pstm_mysql.addBatch(" DELETE FROM cor ");
   	    pstm_mysql.addBatch(" DELETE FROM ref_cor ");
    	pstm_mysql.addBatch(" DELETE FROM cabedal ");
    	pstm_mysql.addBatch(" DELETE FROM categories ");
    	pstm_mysql.addBatch(" DELETE FROM categories_description ");
    	pstm_mysql.addBatch(" DELETE FROM manufacturers ");
    	pstm_mysql.addBatch(" DELETE FROM products ");
    	pstm_mysql.addBatch(" DELETE FROM products_description ");
    	pstm_mysql.addBatch(" DELETE FROM products_attributes ");
    	pstm_mysql.addBatch(" DELETE FROM products_estoque ");
    	pstm_mysql.addBatch(" DELETE FROM products_to_categories ");
    	pstm_mysql.addBatch(" DELETE FROM products_options_values ");
    	pstm_mysql.addBatch(" DELETE FROM products_options_values_to_products_options ");
    	pstm_mysql.executeBatch();
    	pstm_mysql.close();
	}

	private void insereCor() throws SQLException {
		StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("        cor_desc ");
        sb.append("      , cor_cdgo ");
        sb.append("   FROM cor ");
        sb.append("  WHERE EXISTS (SELECT DISTINCT ");
        sb.append("                       dlie.cor_cdgo ");
        sb.append("                  FROM dom_local_item_estoque dlie ");
        sb.append("                     , dom_item_estoque    	 die ");
        sb.append("                 WHERE dlie.ies_codigo		 = die.codigo ");
        sb.append("                   AND dlie.cor_cdgo    		 = cor.cor_cdgo ");
        sb.append("                   AND dlie.qtde_atual  		 > 0 ");
        sb.append("                   AND dlie.tes_codigo  		 = 49 ");
      //sb.append("                   AND dlie.les_codigo  		 IN (17,32)) ");
        sb.append("                   AND dlie.les_codigo        IN (19) ");
        sb.append("                   AND dlie.fil_filial        = '17' ");
        sb.append("                   AND dlie.tco_codigo        = 1 ) ");
        sb.append("  ORDER BY cor_desc ");

        PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());
        ResultSet rset = pstm_oracle.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(
			   " INSERT INTO cor values (?,?) ");
        	pstm_mysql.setInt(1, rset.getInt(2));
        	pstm_mysql.setString(2, rset.getString(1));
        	pstm_mysql.executeUpdate();
        	pstm_mysql.close();
        }
        rset.close();
        pstm_oracle.close();
	}

	private void insereCabedal() throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("  SELECT DISTINCT ");
		sb.append("         cab_desc ");
		sb.append("       , cab_cdgo ");
		sb.append("    FROM cabedal ");
		sb.append("   WHERE EXISTS (SELECT DISTINCT ");
		sb.append("                        die.cab_cdgo "); 
        sb.append("                   FROM dom_local_item_estoque 	dlie "); 
        sb.append("                      , dom_item_estoque 		die ");
        sb.append("                  WHERE dlie.ies_codigo  = die.codigo "); 
        sb.append("                    AND cabedal.cab_cdgo = die.cab_cdgo ");
        sb.append("                    AND dlie.qtde_atual  > 0 ");
        sb.append("                    AND dlie.tes_codigo  = 49 ");
//      sb.append("                    AND dlie.les_codigo  IN (17,32)) ");
        sb.append("                    AND dlie.les_codigo  IN (19) ");
        sb.append("                    AND dlie.fil_filial  = '17' ");
        sb.append("                    AND dlie.tco_codigo  = 1 ) ");        
        sb.append("   ORDER BY cab_desc ");
		
        PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());
        ResultSet rset = pstm_oracle.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(
        	   " INSERT INTO cabedal values (?,?) ");
        	pstm_mysql.setInt(1, rset.getInt(2));
        	pstm_mysql.setString(2, rset.getString(1));
        	pstm_mysql.executeUpdate();
        	pstm_mysql.close();
        }
        pstm_oracle.close();
	}

	private void insereManufacturers() throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("        descricao_marca ");
        sb.append("   FROM ref ");
        sb.append("      , grupo_posicao_fabrica  gpf ");
        sb.append("      , marcas_produtos        mar ");
        sb.append("      , dom_local_item_estoque dlie ");
        sb.append("      , dom_item_estoque       die ");
        sb.append("  WHERE mar.codigo_marca     = ref.codigo_marca ");
        sb.append("    AND dlie.ies_codigo      = die.codigo ");
        sb.append("    AND gpf.codigo_grupo     = ref.ref_grupo_posicao_fab ");
        sb.append("    AND ref.lin_cdgo         = die.lin_cdgo ");
        sb.append("    AND ref.ref_cdgo         = die.ref_cdgo ");
        sb.append("    AND dlie.qtde_atual      > 0 ");
        sb.append("    AND dlie.tes_codigo      = 49 ");
//      sb.append("    AND dlie.les_codigo      IN (17,32) ");
        sb.append("    AND dlie.les_codigo      IN (19) ");
        sb.append("    AND dlie.fil_filial      = '17' ");
        sb.append("    AND dlie.tco_codigo      = 1 ");
        sb.append("  ORDER BY descricao_marca ");
		PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());
            
        ResultSet rset = pstm_oracle.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(
           	   " INSERT INTO manufacturers VALUES ('',?,'','','') ");
        	pstm_mysql.setString(1, rset.getString(1));
        	pstm_mysql.executeUpdate();
        	pstm_mysql.close();
        }
        pstm_oracle.close();
	}

	private void insereRef_cor() throws SQLException {
		StringBuilder sb = new StringBuilder();
        sb.append(" SELECT lin_cdgo || lpad(ref_cdgo,3,0) modelo ");        		
        sb.append("      , cab_cdgo ");
        sb.append("      , cor_cdgo ");
        sb.append("   FROM ref_cor rf ");        		
		
        PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());
        ResultSet rset = pstm_oracle.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(
        		" INSERT INTO ref_cor values (?,?,?) ");
        	pstm_mysql.setInt(1, rset.getInt(1));
        	pstm_mysql.setInt(2, rset.getInt(2));
        	pstm_mysql.setInt(3, rset.getInt(3));
        	pstm_mysql.executeUpdate();
        	pstm_mysql.close();
        }
        rset.close();
        pstm_oracle.close();
	}
	
	
	private void insereProductsOptionsValuesCabedal() throws SQLException {
		PreparedStatement pstm_mysql = conn_mysql.prepareStatement(		
 		   new StringBuilder(" SELECT DISTINCT ")
 		             .append("        cab_desc ")
 		             .append("   FROM cabedal ")
 		             .append("  ORDER BY 1 asc ").toString());
        ResultSet rset = pstm_mysql.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm = conn_mysql.prepareStatement(
        	   " INSERT INTO products_options_values VALUES('','4',?)");
        	pstm.setString(1, rset.getString(1));
        	pstm.executeUpdate();
        	pstm.close();

        	pstm = conn_mysql.prepareStatement(
        	   new StringBuilder(" SELECT products_options_values_id ")
        	             .append("   FROM products_options_values ")
        	             .append("  ORDER BY 1 desc ")
        	             .append("  LIMIT 1 ").toString());

            ResultSet rset_mysql = pstm.executeQuery();
        	if(rset_mysql.next()) {
        		pstm_mysql = conn_mysql.prepareStatement(
        		   " INSERT INTO products_options_values_to_products_options VALUES('',?,'1')");
        		pstm_mysql.setInt(1, rset_mysql.getInt(1));
        		pstm_mysql.executeUpdate();
        		pstm_mysql.close();
        	}
        	pstm.close();
        }
        pstm_mysql.close();
	}

	private void insereProductsOptionsValuesCor() throws SQLException {
        PreparedStatement pstm_mysql = conn_mysql.prepareStatement(		
 			new StringBuilder(" SELECT DISTINCT ")
 			          .append("        cor_desc ")
 			          .append("   FROM cor ")
 			          .append("  ORDER BY cor_desc asc ").toString());
        ResultSet rset = pstm_mysql.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm = conn_mysql.prepareStatement(
               " INSERT INTO products_options_values VALUES('','4',?)");
        	pstm.setString(1, rset.getString(1));
        	pstm.executeUpdate();
        	pstm.close();

        	PreparedStatement pstm_id = conn_mysql.prepareStatement(
        		new StringBuilder(" SELECT products_options_values_id ")
        		          .append("   FROM products_options_values ")
        		          .append("  ORDER BY products_options_values_id DESC ")
        		          .append("  LIMIT 1 ").toString());
        	ResultSet rset_mysql = pstm_id.executeQuery();
        	if(rset_mysql.next()){
        		PreparedStatement pstm_prod = conn_mysql.prepareStatement(
        	       " INSERT INTO products_options_values_to_products_options VALUES('',?,'2')");
        		pstm_prod.setInt(1, rset_mysql.getInt(1));
        		pstm_prod.executeUpdate();
        		pstm_prod.close();
        	}
        	pstm_id.close();
        }
        pstm_mysql.close();
	}

	private void insereProductsOptionsValuesQtd() throws SQLException {
		PreparedStatement pstm_mysql = conn_oracle.prepareStatement(
		   new StringBuilder(" SELECT DISTINCT ")
		             .append("        qtd_nume ")
		             .append("   FROM qtd ")
		             .append("  ORDER BY qtd_nume ").toString());
		ResultSet rset = pstm_mysql.executeQuery();
		while(rset.next()) {
			PreparedStatement pstm_op = conn_mysql.prepareStatement(
			   " INSERT INTO products_options_values VALUES('','4',?)");
			pstm_op.setString(1, rset.getString(1));
			pstm_op.executeUpdate();
			pstm_op.close();

			PreparedStatement pstm_id = conn_mysql.prepareStatement(
			   new StringBuilder(" SELECT products_options_values_id ")
			             .append("   FROM products_options_values ")
			             .append("  ORDER BY 1 DESC ")
			             .append("  LIMIT 1 ").toString());

			ResultSet rset_mysql = pstm_id.executeQuery();
			if(rset_mysql.next()) {
				PreparedStatement pstm_prod = conn_mysql.prepareStatement(
  				   " INSERT INTO products_options_values_to_products_options VALUES('',?,'3')");
				pstm_prod.setInt(1, rset_mysql.getInt(1));
				pstm_prod.executeUpdate();
				pstm_prod.close();
			}
			pstm_id.close();
		}
		pstm_mysql.close();
	}

	private void insereCategoriesCatDescription() throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT ");
        sb.append("        descricao_grupo ");
        sb.append("   FROM ref ");
        sb.append("      , grupo_posicao_fabrica  gpf ");
        sb.append("      , marcas_produtos        mar ");
        sb.append("      , dom_local_item_estoque dlie ");
        sb.append("      , dom_item_estoque       die ");
        sb.append("  WHERE mar.codigo_marca     = ref.codigo_marca ");
        sb.append("    AND dlie.ies_codigo      = die.codigo ");
        sb.append("    AND gpf.codigo_grupo     = ref.ref_grupo_posicao_fab ");
        sb.append("    AND ref.lin_cdgo         = die.lin_cdgo ");
        sb.append("    AND ref.ref_cdgo         = die.ref_cdgo ");
        sb.append("    AND dlie.qtde_atual      > 0 ");
        sb.append("    AND dlie.tes_codigo      = 49 ");
//      sb.append("    AND dlie.les_codigo      IN(17,32) ");
        sb.append("    AND dlie.les_codigo      IN (19) ");
        sb.append("    AND dlie.fil_filial      = '17' ");
        sb.append("    AND dlie.tco_codigo      = 1 ");        
        sb.append("  ORDER BY descricao_grupo ");
		PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());        

        ResultSet rset = pstm_oracle.executeQuery();
        while(rset.next()) {
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(
        	   " INSERT INTO categories VALUES('','','','0','','','1') ");
        	pstm_mysql.executeUpdate();
        	pstm_mysql.close();

        	pstm_mysql = conn_mysql.prepareStatement(
        	   new StringBuilder(" SELECT categories_id ")
        	             .append("   FROM categories ")
        	             .append("  ORDER BY categories_id desc ")
        	             .append("  LIMIT 1 ").toString());
            ResultSet rset_mysql = pstm_mysql.executeQuery();
        	if(rset_mysql.next()) {
        		PreparedStatement pstm_cat = conn_mysql.prepareStatement(
        		   " INSERT INTO categories_description VALUES(?,'4',?) ");
        		pstm_cat.setInt(1, rset_mysql.getInt(1));
        		pstm_cat.setString(2, rset.getString(1));
        		pstm_cat.executeUpdate();
            	pstm_cat.close();
        	}
        	pstm_mysql.close();
        }
        pstm_oracle.close();
	}

	private void rotinaProdutosCabedal() throws SQLException {
        int products_id = 0;
        int categories_id = 0;
        int products_options_values = 0;
        StringBuilder query = new StringBuilder();
		query.append(" SELECT die.lin_cdgo ");
		query.append("      , lpad(die.ref_cdgo,3,0) ref_cdgo ");
		query.append("      , nvl(tabela.preco,'0.00') preco ");
		query.append("      , ref.ref_desc ");
		query.append("      , gpf.descricao_grupo,'img_pequena/' || die.lin_cdgo || '-' || lpad(die.ref_cdgo,3,'0') || '.jpg' ");
		query.append("      , mar.descricao_marca ");
		query.append("   FROM ref                       ref ");
		query.append("      , grupo_posicao_fabrica 	gpf "); 
		query.append("      , marcas_produtos 			mar ");
		query.append("      , dom_local_item_estoque 	dlie "); 
		query.append("      , dom_item_estoque 			die ");
		query.append("      , ( SELECT substr(min(preco_mercado_interno) * 100,1,length(min(preco_mercado_interno) * 100) - 2) || '.' || ");
		query.append("                 substr(min(preco_mercado_interno) * 100,length(min(preco_mercado_interno) * 100) - 1, 2) preco, ");
		query.append("                 t.lin_cdgo, ");
		query.append("                 t.ref_cdgo ");
		query.append("            FROM tabela_precos t ");
		query.append("           WHERE t.liv_codigo = 28 ");
		query.append("           GROUP BY ");
		query.append("                 t.lin_cdgo, ");
		query.append("                 t.ref_cdgo ) tabela ");
		query.append("   WHERE mar.codigo_marca    = ref.codigo_marca ");
		query.append("     AND dlie.ies_codigo     = die.codigo ");
		query.append("     AND gpf.codigo_grupo    = ref.ref_grupo_posicao_fab "); 
		query.append("     AND tabela.lin_cdgo (+) = die.lin_cdgo ");
		query.append("     AND tabela.ref_cdgo (+) = die.ref_cdgo ");
		query.append("     AND ref.lin_cdgo        = die.lin_cdgo ");
		query.append("     AND ref.ref_cdgo        = die.ref_cdgo ");
		query.append("     AND dlie.qtde_atual     > 0 ");
		query.append("     AND dlie.tes_codigo     = 49 ");
      //query.append("     AND dlie.les_codigo     IN(17,32) ");
        query.append("     AND dlie.les_codigo     IN (19) ");
        query.append("     AND dlie.fil_filial     = '17' ");
        query.append("     AND dlie.tco_codigo     = 1 ");		
		query.append("   GROUP BY die.lin_cdgo ");
		query.append("          , lpad(die.ref_cdgo,3,0) ");
		query.append("          , ref.ref_desc ");
		query.append("          , gpf.descricao_grupo ");
		query.append("          , 'img_pequena/' || die.lin_cdgo || '-' || lpad(die.ref_cdgo,3,0) || '.jpg' ");  
	    query.append("          , mar.descricao_marca ");
	    query.append("          , tabela.preco "); 
	    query.append("   ORDER BY die.lin_cdgo ");
	    query.append("          , lpad(die.ref_cdgo,3,0) ");        		
        
        PreparedStatement pstm_oracle_geral = conn_oracle.prepareStatement(query.toString());
        
        ResultSet rset = pstm_oracle_geral.executeQuery();
        while(rset.next()) {
        	StringBuilder sbi = new StringBuilder();
			sbi.append(" SELECT manufacturers_id ");
			sbi.append("   FROM manufacturers ");
			sbi.append("  WHERE manufacturers_name = ? ");
			sbi.append("  ORDER BY manufacturers_id DESC ");
			sbi.append("  LIMIT 1 ");
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(sbi.toString());
      	  	pstm_mysql.setString(1, rset.getString(7));
      	  	ResultSet rset_cab = pstm_mysql.executeQuery();

            if(rset_cab.next()) {
            	PreparedStatement pstm_mysql_cab = conn_mysql.prepareStatement(
            	   " INSERT INTO products VALUES ('','0',?,?,?,'','','',0.00,'1','0',?) ");
            	pstm_mysql_cab.setString(1, rset.getString(1)+rset.getString(2));
            	pstm_mysql_cab.setString(2, rset.getString(6));
            	pstm_mysql_cab.setString(3, rset.getString(3));
            	pstm_mysql_cab.setInt(4, rset_cab.getInt(1));
            	pstm_mysql_cab.executeUpdate();
            	pstm_mysql_cab.close();
            	pstm_mysql_cab = conn_mysql.prepareStatement(
            	   " INSERT INTO products_description VALUES ('', '4',?,'','','') ");
            	pstm_mysql_cab.setString(1,rset.getString(1)+rset.getString(2)+"-"+rset.getString(4));
            	pstm_mysql_cab.executeUpdate();
            	pstm_mysql_cab.close();
            	pstm_mysql_cab = conn_mysql.prepareStatement(
                   new StringBuilder(" SELECT products_id ")
                             .append("   FROM products ")
                             .append("  ORDER BY products_id DESC ")
                             .append("  LIMIT 1 ").toString());
            	ResultSet rset_products_id = pstm_mysql_cab.executeQuery();

            	if(rset_products_id.next()) {
            		products_id = rset_products_id.getInt(1);
            	}

            	pstm_mysql_cab.close();
            	pstm_mysql_cab = conn_mysql.prepareStatement(
              	   new StringBuilder(" SELECT categories_id ")
              	             .append("   FROM categories_description ")
              	             .append("  WHERE categories_name = '").append(rset.getString(5)).append("'").toString());
            	ResultSet rset_categories_id = pstm_mysql_cab.executeQuery();

            	if(rset_categories_id.next()) {
            		categories_id = rset_categories_id.getInt(1);
            	}

            	pstm_mysql_cab.close();
 	           	PreparedStatement pstm_prod_cat = conn_mysql.prepareStatement(
                   " INSERT INTO products_to_categories VALUES (?,?) ");
            	pstm_prod_cat.setInt(1, products_id);
            	pstm_prod_cat.setInt(2, categories_id);
            	pstm_prod_cat.executeUpdate();
            	pstm_prod_cat.close();
            	StringBuilder sb_cab = new StringBuilder();
            	sb_cab.append(" SELECT DISTINCT ");
            	sb_cab.append("        cab_desc ");
            	sb_cab.append("   FROM cabedal ");
                sb_cab.append("  WHERE EXISTS (SELECT DISTINCT ");
               	sb_cab.append("                       die.cab_cdgo ");
               	sb_cab.append("                  FROM dom_local_item_estoque	dlie ");
               	sb_cab.append("                     , dom_item_estoque 			die ");
               	sb_cab.append("                 WHERE dlie.ies_codigo  = die.codigo ");
                sb_cab.append("                   AND cabedal.cab_cdgo = die.cab_cdgo ");
                sb_cab.append("                   AND dlie.qtde_atual  > 0 ");
                sb_cab.append("                   AND dlie.tes_codigo  = 49 ");
              //sb_cab.append("                   AND dlie.les_codigo  IN(17,32) ");
                sb_cab.append("                   AND dlie.les_codigo  IN (19) ");
                sb_cab.append("                   AND dlie.fil_filial  = '17' ");
                sb_cab.append("                   AND dlie.tco_codigo  = 1 ");                
                sb_cab.append("                   AND die.lin_cdgo     = ? ");
                sb_cab.append("                   AND die.ref_cdgo     = ? ) ");
       	       	PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb_cab.toString());
                pstm_oracle.setString(1, rset.getString(1));
                pstm_oracle.setString(2, rset.getString(2));
                ResultSet rset_cabedal = pstm_oracle.executeQuery();

                while(rset_cabedal.next()) {
                	   PreparedStatement pstm_products  = conn_mysql.prepareStatement(
                       		new StringBuilder(" SELECT products_options_values_id ")
                       		          .append("   FROM products_options_values ")
                       		          .append("  WHERE products_options_values_name = ? ")
                       		          .append("  ORDER BY 1 DESC ")
                       		          .append("  LIMIT 1").toString());
                	   pstm_products.setString(1, rset_cabedal.getString(1));

                	   ResultSet rset_products_options_id = pstm_products.executeQuery();
                	   if(rset_products_options_id.next()) {
                		  products_options_values = rset_products_options_id.getInt(1);
                	   }
                	   pstm_products.close();

                	   PreparedStatement pstm_products_attributes = conn_mysql.prepareStatement(
                	      " INSERT INTO products_attributes values ('',?,'1',?, '','' ) ");
                	   pstm_products_attributes.setInt(1, products_id);
                	   pstm_products_attributes.setInt(2, products_options_values);
                	   pstm_products_attributes.executeUpdate();
                	   pstm_products_attributes.close();
                 }
                 pstm_oracle.close();
            }
            pstm_mysql.close();

//--- PROCESSO COR -------------------------------------------------------------
            StringBuilder sbc = new StringBuilder();
    		sbc.append("  SELECT DISTINCT ");
    		sbc.append("         cor_desc ");
    		sbc.append("    FROM cor ");
    		sbc.append("   WHERE EXISTS (SELECT DISTINCT ");
    		sbc.append("                        cor_cdgo ");
    		sbc.append("                   FROM dom_local_item_estoque dlie ");
    		sbc.append("                      , dom_item_estoque die");
    		sbc.append("                  WHERE dlie.ies_codigo = die.codigo ");
    		sbc.append("                    AND dlie.qtde_atual  > 0 ");
    		sbc.append("                    AND dlie.tes_codigo  = 49 ");
    	  //sbc.append("                    AND dlie.les_codigo  IN(17,32) ");
            sbc.append("                    AND dlie.les_codigo  IN (19) ");
            sbc.append("                    AND dlie.fil_filial  = '17' ");
            sbc.append("                    AND dlie.tco_codigo  = 1 ");    		
    		sbc.append("                    AND die.lin_cdgo     = ? ");
    		sbc.append("                    AND die.ref_cdgo     = ? ");
    		sbc.append("                    AND cor.cor_cdgo     = dlie.cor_cdgo) ");            
            PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sbc.toString());
          		pstm_oracle.setString(1, rset.getString(1));
          		pstm_oracle.setString(2, rset.getString(2));
          		ResultSet rset_cor = pstm_oracle.executeQuery();

                while(rset_cor.next()) {
                	  PreparedStatement pstm_mysql_cor = conn_mysql.prepareStatement(
                			  new StringBuilder(" SELECT products_options_values_id ")
                			            .append("   FROM products_options_values ")
                			            .append("  WHERE products_options_values_name = ? ")
                			            .append("  ORDER BY products_options_values_id desc ")
                			            .append("  LIMIT 1").toString());
                	  pstm_mysql_cor.setString(1, rset_cor.getString(1));

                	  ResultSet rset_cabedal = pstm_mysql_cor.executeQuery();
                	  if(rset_cabedal.next()) {
                		  products_options_values = rset_cabedal.getInt(1);
                	  }
                	  pstm_mysql_cor.close();

                	  PreparedStatement pstm_attributes = conn_mysql.prepareStatement(
                	     " INSERT INTO products_attributes VALUES ('',?,'2',?, '','' ) ");
                	  pstm_attributes.setInt(1, products_id);
                	  pstm_attributes.setInt(2, products_options_values);
                	  pstm_attributes.executeUpdate();
                	  pstm_attributes.close();
                }   

                pstm_oracle.close();
//---- PROCESSO TAMANHO --------------------------------------------------------
                StringBuilder sbt = new StringBuilder();
      		    sbt.append(" SELECT DISTINCT ");
      		    sbt.append("        tai_codigo ");
      		    sbt.append("   FROM dom_local_item_estoque 	dlie ");
      		    sbt.append("      , dom_item_estoque 		die ");
      		    sbt.append("  WHERE dlie.ies_codigo = die.codigo ");
      		    sbt.append("    AND dlie.qtde_atual > 0 ");
      		    sbt.append("    AND dlie.tes_codigo = 49 ");
      		  //sbt.append("    AND les_codigo      in(17,32) ");
      	        sbt.append("    AND les_codigo      IN (19) ");
      	        sbt.append("    AND dlie.fil_filial = '17' ");
      	        sbt.append("    AND dlie.tco_codigo = 1 ");      		    
      		    sbt.append("    AND die.lin_cdgo    = ? ");
      		    sbt.append("    AND die.ref_cdgo    = ? ");                
                PreparedStatement pstm_tai = conn_oracle.prepareStatement(sbt.toString());
                pstm_tai.setString(1, rset.getString(1));
                pstm_tai.setString(2, rset.getString(2));
     			ResultSet rset_tai = pstm_tai.executeQuery();

     			while(rset_tai.next()) {
     				PreparedStatement pstm_mysql_cor = conn_mysql.prepareStatement(
     					  new StringBuilder(" SELECT products_options_values_id ")
     					            .append("   FROM products_options_values ")
     					            .append("  WHERE products_options_values_name = ? ")
     					            .append("  ORDER BY products_options_values_id DESC ")
     					            .append("  LIMIT 1").toString());
     				pstm_mysql_cor.setString(1,rset_tai.getString(1));
     				ResultSet rset_cabedal = pstm_mysql_cor.executeQuery();
     				if(rset_cabedal.next()) {
     					products_options_values = rset_cabedal.getInt(1);
     				}
           	  		pstm_mysql_cor.close();

           	  		pstm_mysql_cor = conn_mysql.prepareStatement(
           	  		   " INSERT INTO products_attributes VALUES ('',?,'3',?, '','' ) ");
           	  		pstm_mysql_cor.setInt(1, products_id);
           	  		pstm_mysql_cor.setInt(2, products_options_values);
           	  		pstm_mysql_cor.executeUpdate();
           	  		pstm_mysql_cor.close();
     			}  
     			pstm_tai.close();
        }
        pstm_oracle_geral.close();
	}

	private void rotinaProdutosEstoque() throws SQLException {
		StringBuilder sb = new StringBuilder();
    	sb.append(" SELECT die.lin_cdgo ");
    	sb.append("      , lpad(die.ref_cdgo,3,0) ref_cdgo ");
    	sb.append(" 	 , cab.cab_desc ");
    	sb.append("      , cor.cor_desc ");
    	sb.append("      , dlie.tai_codigo ");
    	sb.append("      , sum(dlie.qtde_atual) ");
    	sb.append("      , cab.cab_cdgo ");
    	sb.append("   FROM dom_local_item_estoque dlie "); 
    	sb.append("      , dom_item_estoque       die ");
    	sb.append("      , cabedal                cab ");
    	sb.append("      , cor ");
        sb.append("  WHERE dlie.ies_codigo  = die.codigo ");
        sb.append("    AND cab.cab_cdgo     = die.cab_cdgo ");
        sb.append("    AND cor.cor_cdgo     = dlie.cor_cdgo ");
        sb.append("    AND dlie.qtde_atual  > 0 ");
        sb.append("    AND dlie.tes_codigo  = 49 ");
      //sb.append("    AND dlie.les_codigo  in(17,32) ");
        sb.append("    AND dlie.les_codigo  IN (19) ");
        sb.append("    AND dlie.fil_filial  = '17' ");
        sb.append("    AND dlie.tco_codigo  = 1 ");        
        sb.append("  GROUP BY die.lin_cdgo ");
        sb.append("         , lpad(die.ref_cdgo,3,0) ");
        sb.append("         , cab.cab_desc ");
        sb.append("         , cor.cor_desc ");
        sb.append("         , dlie.tai_codigo ");
        sb.append("         , cab.cab_cdgo ");				
		
		PreparedStatement pstm_oracle = conn_oracle.prepareStatement(sb.toString());
    	ResultSet rset = pstm_oracle.executeQuery();
    	
    	while(rset.next()) {
    		StringBuilder sbi = new StringBuilder();
			sbi.append(" SELECT products.products_id ");
			sbi.append("      , cab.products_options_values_id ");
			sbi.append("      , cor.products_options_values_id ");
			sbi.append("      , gra.products_options_values_id  ");
			sbi.append("   FROM products ");
			sbi.append("      , products_options_values cab ");
			sbi.append("      , products_options_values cor ");
			sbi.append("      , products_options_values gra ");
			sbi.append("  WHERE products.products_model = ? ");
			sbi.append("    AND cab.products_options_values_name = ? ");
			sbi.append("    AND cor.products_options_values_name = ? ");
			sbi.append("    AND gra.products_options_values_name = ? ");
			sbi.append("  ORDER BY products.products_id DESC ");
			sbi.append("  LIMIT 1 ");
        	PreparedStatement pstm_mysql = conn_mysql.prepareStatement(sbi.toString());
        	pstm_mysql.setString(1, rset.getString(1)+rset.getString(2));
        	pstm_mysql.setString(2, rset.getString(3));
        	pstm_mysql.setString(3, rset.getString(4));
        	pstm_mysql.setString(4, rset.getString(5));
        	ResultSet rset_mysql = pstm_mysql.executeQuery();
        	
        	if(rset_mysql.next()) {
        		PreparedStatement pstm_prod = conn_mysql.prepareStatement(
        		   " INSERT INTO products_estoque VALUES (?,?,?,?,?,?) ");
        		pstm_prod.setInt(1, rset_mysql.getInt(1));
        		pstm_prod.setInt(2, rset_mysql.getInt(2));
        		pstm_prod.setInt(3, rset_mysql.getInt(3));
        		pstm_prod.setInt(4, rset_mysql.getInt(4));
        		pstm_prod.setInt(5, rset.getInt(6));
        		pstm_prod.setInt(6, rset.getInt(6));
        		pstm_prod.executeUpdate();
        		pstm_prod.close();
        	} 
        	pstm_mysql.close();
    	}
    	pstm_oracle.close();
    	
	}
}
