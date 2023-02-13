package util.consultas;
import javax.servlet.http.HttpSession;

public class TotaisClientesAtendidos {
	
	private int totalGruposAtivos         = 0;
	private int totalGruposAtendidos      = 0;
	private int totalGruposNaoAtendidos   = 0;
	private int totalClientesAtivos       = 0;
	private int totalClientesAtendidos    = 0;
	private int totalClientesNaoAtendidos = 0;
	private int totalCidadesAtivas        = 0;
	private int totalCidadesAtendidas     = 0;
	private int totalCidadesNaoAtendidas  = 0;

	public TotaisClientesAtendidos(HttpSession se,String marca,String regional) {
		
		portalbr.dbobj.view.Jw_totais table = new portalbr.dbobj.view.Jw_totais();
	    com.egen.util.jdbc.JdbcUtil conexao = null; 
		java.util.Vector<?> res_Jw_totais = null;
		String consulta_cidades = null;
		String consulta_grupos = null;
		String consulta_clientes = null;
		String representante = null;
		
		if (se.getAttribute("codigo_representante") != null
				&& (!((String) se.getAttribute("codigo_representante")).equals("null"))) {
			representante = "'".concat((String) se.getAttribute("codigo_representante")).concat("'");
		} else {
			representante = "null";
		}
		if (se.getAttribute("ca_consulta_cidades") == "S") {
			consulta_cidades = "'S'";
		} else {
			consulta_cidades = "'N'";
		}
		if (se.getAttribute("ca_consulta_grupos") == "S") {
			consulta_grupos = "'S'";
		} else {
			consulta_grupos = "'N'";
		}
		if (se.getAttribute("ca_consulta_clientes") == "S") {
			consulta_clientes = "'S'";
		} else {
			consulta_clientes = "'N'";
		}

		try { 
     		conexao = new com.egen.util.jdbc.JdbcUtil();
           	StringBuilder query = new StringBuilder();
           	query.append(" SELECT /*+ all_rows */ grupos_ativos.qtde total_grupos_ativos ");
           	query.append("      , grupos_atendidos.qtde total_grupos_atendidos ");
           	query.append("      , grupos_ativos.qtde - grupos_atendidos.qtde total_grupos_nao_atendidos ");		
           	query.append("      , clientes_ativos.qtde total_clientes_ativos ");
           	query.append("      , clientes_atendidos.qtde total_clientes_atendidos ");
           	query.append("      , 0 total_clientes_atendidosr ");           
           	query.append("      , clientes_ativos.qtde - clientes_atendidos.qtde total_clientes_nao_atendidos ");
           	query.append("      , cidades_ativas.qtde total_cidades_ativas ");
           	query.append("      , cidades_atendidas.qtde total_cidades_atendidas ");
           	query.append("      , cidades_ativas.qtde - cidades_atendidas.qtde total_cidades_nao_atendidas ");
           	query.append("   FROM ( ");
//----- GRUPOS ATIVOS --------------------
           	query.append("         SELECT count(distinct(grec.gre_grupo)) qtde ");
           	query.append("           FROM cliente_representante clre ");
           	query.append("              , grupo_economico       grec "); 
           	query.append("              , representante_marca   rema "); 
           	query.append("              , rep                   repr "); 
           	query.append("              , regionais_vendas      reve "); 
           	query.append("              , marcas_produtos       mapr "); 
           	query.append("          WHERE clre.codigo_representante = repr.rep_cdgo ");
           	query.append("            AND 'S'                       = ").append(consulta_grupos);
           	query.append("            AND grec.cli_cdgo             = clre.codigo_cliente "); 
           	query.append("            AND rema.codigo_representante = repr.rep_cdgo "); 
           	query.append("            AND reve.codigo_regional      = repr.codigo_regional "); 
           	query.append("            AND mapr.codigo_marca         = rema.marca_produto ");
			if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
				query.append("        AND repr.rep_situ             = ")
						.append(se.getAttribute("situacao_representante"));
			}
			if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
				query.append("        AND clre.situacao             = ").append(se.getAttribute("situacao_cliente_representante"));
			}
			if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
				query.append("        AND rema.situacao             = ").append(se.getAttribute("situacao_representante_marca"));
			}
			if (!marca.equalsIgnoreCase("null")) {
				query.append("        AND mapr.codigo_marca         = ").append(marca);
			}
			if (!regional.equalsIgnoreCase("null")) {
				query.append("        AND reve.codigo_regional      = ").append(regional);
			}
			if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
				query.append("        AND mapr.codigo_marca         = ").append(se.getAttribute("codigo_marca"));	
			}
			if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
				query.append("        AND reve.codigo_regional      = ").append(se.getAttribute("codigo_regional"));	
			}
			if (!representante.equalsIgnoreCase("null")) {
				query.append("        AND repr.rep_cdgo             = ").append(representante);	
			}
			query.append("        ) grupos_ativos, ");
//----- CLIENTES ATIVOS --------------------		
			query.append("        (SELECT count(distinct(cli.cli_cdgo)) qtde ");
			query.append("           FROM rep ");
			query.append("              , cliente_representante clr "); 
			query.append("              , cli ");
			query.append("              , representante_marca rm "); 
           	query.append("          WHERE clr.codigo_representante = rep.rep_cdgo ");
           	query.append("            AND 'S'                      = ").append(consulta_clientes);
           	query.append("            AND cli.cli_cdgo             = clr.codigo_cliente "); 
           	query.append("            AND rm.codigo_representante  = rep.rep_cdgo ");
           	query.append("            AND cli.cli_situ             = 'A' ");
           	query.append("            AND cli.seg_cdgo             not in (9, 153) ");
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append("        AND rep.rep_situ             = ").append(se.getAttribute("situacao_representante"));   
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append("        AND clr.situacao             = ").append(se.getAttribute("situacao_cliente_representante"));		
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append("        AND rm.situacao              = ").append(se.getAttribute("situacao_representante_marca"));		
           	}
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append("        AND rm.marca_produto         = ").append(marca);		
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append("        AND rep.codigo_regional      = ").append(regional);		
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append("        AND rm.marca_produto         = ").append(se.getAttribute("codigo_marca"));		
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append("        AND rep.codigo_regional      = ").append(se.getAttribute("codigo_regional"));		
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("        AND rep.rep_cdgo             = ").append(representante);	
           	}
           	query.append("            AND rep.codigo_regional      > 0 ");
           	query.append("        ) clientes_ativos, ");
//		------ GRUPOS ATENDIDOS --------------------		
           	query.append("        (SELECT count(distinct(gre_grupo)) qtde ");
           	query.append("           FROM  ( SELECT gre.gre_grupo ");
           	query.append("                     FROM resumo_ped res ");  
           	query.append("                        , cli ");  
           	query.append("                        , rep "); 
           	query.append("                        , cliente_representante clr ");  
           	query.append("                        , representante_marca rm ");
           	query.append("                        , grupo_economico gre ");
           	query.append("                    WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append("    				    AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	query.append(" 					    AND res.lin_cdgo             =  nvl(").append(se.getAttribute("lin_cdgo")).append(",res.lin_cdgo) ");
           	query.append("    				    AND res.codigo_regional      =  nvl(").append(se.getAttribute("codigo_regional")).append(", res.codigo_regional) ");
           	query.append("   				    AND res.codigo_marca         =  nvl(").append(se.getAttribute("codigo_marca")).append(",res.codigo_marca) ");
           	query.append("    				    AND gre.cli_cdgo             =  cli.cli_cdgo ");
           	query.append("                      AND 'S'                      = ").append(consulta_grupos);
           	query.append(" 					    AND cli.cli_cdgo             =  res.cli_cdgo "); 
           	query.append(" 					    AND rep.rep_cdgo             =  res.rep_cdgo ");      
           	query.append(" 					    AND clr.codigo_representante =  rep.rep_cdgo ");    
           	query.append("   				    AND cli.cli_cdgo             =  clr.codigo_cliente ");    
           	query.append(" 					    AND res.esc_seqn             =  clr.codigo_sequencial "); 
           	query.append(" 					    AND rm.marca_produto         =  res.codigo_marca "); 
           	query.append(" 					    AND rm.codigo_representante  =  rep.rep_cdgo ");   
           	query.append(" 					    AND res.codigo_marca         =  nvl(").append(marca).append(",res.codigo_marca) "); 
           	query.append(" 					    AND res.codigo_regional      =  nvl(").append(regional).append(",res.codigo_regional) ");  
           	query.append(" 					    AND cli.cli_situ             =  nvl('A',cli.cli_situ) ");
           	query.append("                      AND cli.seg_cdgo             not in (9, 153) ");
           	query.append(" 					    AND rep.rep_situ             =  nvl(").append(se.getAttribute("situacao_representante")).append(",rep.rep_situ) ");
           	query.append(" 					    AND clr.situacao             =  nvl(").append(se.getAttribute("situacao_cliente_representante")).append(",clr.situacao) ");
           	query.append(" 					    AND rm.situacao              =  nvl(").append(se.getAttribute("situacao_representante_marca")).append(",rm.situacao) ");
           	query.append("                      AND rep.rep_cdgo             =  nvl(").append(representante).append(", rep.rep_cdgo) ");
           	query.append("				      UNION ALL ");
           	query.append(" 				 	 SELECT gre.gre_grupo ");  
           	query.append(" 					   FROM resumo_pedidos res ");  
           	query.append("   					  , cli ");
           	query.append(" 					      , rep ");   
           	query.append("   				      , cliente_representante clr ");   
           	query.append("					      , representante_marca rm ");
           	query.append(" 					      , grupo_economico gre ");
           	query.append(" 					  WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append(" 					    AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	if (!se.getAttribute("lin_cdgo").toString().equalsIgnoreCase("null")) {
           		query.append(" 				    AND res.lin_cdgo             =  ").append(se.getAttribute("lin_cdgo"));	
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append(" 			        AND res.codigo_regional      =  ").append(se.getAttribute("codigo_regional"));	
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 			        AND res.codigo_marca         =  ").append(se.getAttribute("codigo_marca"));	
           	}
           	query.append(" 					    AND gre.cli_cdgo             =  cli.cli_cdgo ");	
           	query.append("                      AND 'S'                      = ").append(consulta_grupos);
           	query.append("  	    		    AND cli.cli_cdgo             =  res.cli_cdgo ");  
           	query.append(" 					    AND rep.rep_cdgo             =  res.rep_cdgo ");  
           	query.append(" 					    AND res.esc_seqn             =  clr.codigo_sequencial "); 
           	query.append(" 					    AND rm.marca_produto         =  res.codigo_marca "); 
           	query.append(" 					    AND clr.codigo_representante =  rep.rep_cdgo ");    
           	query.append(" 					    AND cli.cli_cdgo             =  clr.codigo_cliente ");    
           	query.append(" 					    AND rm.codigo_representante  =  rep.rep_cdgo ");     
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append(" 					AND res.codigo_marca         =  ").append(marca);	
           	}
           	if (!regional.equalsIgnoreCase("null")) { 
           		query.append(" 			 	    AND res.codigo_regional      =  ").append(regional);
           	}
           	query.append(" 					    AND cli.cli_situ             =  'A' ");
           	query.append("                      AND cli.seg_cdgo             NOT IN (9, 153) ");
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 				    AND rep.rep_situ             =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 					AND clr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 		            AND rm.situacao              =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("                  AND rep.rep_cdgo             =  ").append(representante);
           	}
           	query.append("   	  )) grupos_atendidos, ");
//----- CLIENTES ATENDIDOS --------------------		
           	query.append("         (SELECT count(distinct(cli_cdgo)) qtde ");
           	query.append("            FROM ( SELECT cli.cli_cdgo ");
           	query.append("         				 , cli.cli_nome ");
           	query.append("					     , cli.cli_rzao ");
           	query.append(" 					     , cli.cli_dult ");
           	query.append("  			         , res.pares pares ");  
           	query.append("   				     , res.valor valor ");  
           	query.append("				 	  FROM resumo_ped res ");  
           	query.append(" 					     , cli ");  
           	query.append("  			         , rep "); 
           	query.append("  			         , cliente_representante clr ");  
           	query.append("  			         , representante_marca rm ");  
           	query.append("					 WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append(" 					   AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	if (!se.getAttribute("lin_cdgo").toString().equalsIgnoreCase("null")) {
           		query.append(" 			       AND res.lin_cdgo             =  ").append(se.getAttribute("lin_cdgo"));
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append("  			   AND res.codigo_regional      =  ").append(se.getAttribute("codigo_regional"));
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_marca         =  ").append(se.getAttribute("codigo_marca"));
           	}
           	query.append(" 					   AND cli.cli_cdgo             =  res.cli_cdgo "); 
           	query.append("                     AND 'S'                      = ").append(consulta_clientes);           
           	query.append(" 					   AND rep.rep_cdgo             =  res.rep_cdgo ");      
           	query.append(" 					   AND clr.codigo_representante =  rep.rep_cdgo ");    
           	query.append(" 					   AND cli.cli_cdgo             =  clr.codigo_cliente ");    
           	query.append("  			       AND res.esc_seqn             =  clr.codigo_sequencial "); 
           	query.append(" 					   AND rm.marca_produto         =  res.codigo_marca "); 
           	query.append(" 					   AND rm.codigo_representante  =  rep.rep_cdgo ");
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_marca         =  ").append(marca);		
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_regional      =  ").append(regional);           		
           	}
           	query.append(" 					   AND cli.cli_situ             =  'A' ");
           	query.append("                     AND cli.seg_cdgo             NOT IN (9, 153) ");	
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND rep.rep_situ             =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND clr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append("  			   AND rm.situacao              =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("                 AND rep.rep_cdgo             =  ").append(representante);	
           	}
           	query.append(" 					 UNION ALL ");
           	query.append(" 					SELECT cli.cli_cdgo ");  
           	query.append(" 					     , cli.cli_nome ");  
           	query.append(" 					     , cli.cli_rzao ");  
           	query.append(" 					     , cli.cli_dult ");  
           	query.append(" 					     , res.pares pares ");  
           	query.append(" 					     , res.valor valor ");
           	query.append(" 					  FROM resumo_pedidos res ");  
           	query.append(" 					     , cli ");
           	query.append(" 					     , rep ");   
           	query.append(" 					     , cliente_representante clr ");   
           	query.append(" 					     , representante_marca rm ");  
           	query.append(" 					 WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append(" 					   AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	if (!se.getAttribute("lin_cdgo").toString().equalsIgnoreCase("null")) {
           		query.append(" 			       AND res.lin_cdgo             =  ").append(se.getAttribute("lin_cdgo"));	
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_regional      =  ").append(se.getAttribute("codigo_regional"));
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append("  	   		   AND res.codigo_marca         =  ").append(se.getAttribute("codigo_marca"));
           	}
           	query.append("                     AND 'S'                      = ").append(consulta_clientes);
           	query.append(" 					   AND cli.cli_cdgo             =  res.cli_cdgo ");  
           	query.append(" 					   AND rep.rep_cdgo             =  res.rep_cdgo ");  
           	query.append(" 					   AND res.esc_seqn             =  clr.codigo_sequencial "); 
           	query.append(" 					   AND rm.marca_produto         =  res.codigo_marca "); 
           	query.append(" 					   AND clr.codigo_representante =  rep.rep_cdgo ");    
           	query.append(" 					   AND cli.cli_cdgo             =  clr.codigo_cliente ");    
           	query.append(" 					   AND rm.codigo_representante  =  rep.rep_cdgo ");     
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_marca         =  ").append(marca);
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_regional      =  ").append(regional);
           	}
           	query.append(" 					   AND cli.cli_situ             =  'A' ");
           	query.append("                     AND cli.seg_cdgo             NOT IN (9, 153) ");
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 	 			   AND rep.rep_situ             =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append("				   AND clr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND rm.situacao              =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("                 AND rep.rep_cdgo             =  ").append(representante);
           	}
           	query.append("   	  )) clientes_atendidos, ");
//----- CIDADES ATIVAS --------------------		
           	query.append("		  (SELECT count(distinct ecl.ecl_cdad||' - '||ecl.est_unifed) qtde "); 
           	query.append("            FROM ecl ");
           	query.append(" 			    , cliente_representante cr "); 
           	query.append("		        , rep r "); 
           	query.append("		        , representante_marca rm ");       
           	query.append("		        , cli c "); 
           	query.append("		    WHERE ecl.ned_cdgo            in ('COB', 'UNI') ");
           	query.append("			  AND ecl.cli_cdgo            =  cr.codigo_cliente ");
           	query.append(" 			  AND cr.codigo_representante =  r.rep_cdgo ");
           	query.append(" 			  AND r.rep_cdgo              =  rm.codigo_representante ");
           	query.append(" 			  AND c.cli_cdgo              =  cr.codigo_cliente ");
           	query.append("    		  AND cr.codigo_sequencial    =  ecl.esc_seqn ");
           	query.append("   		  AND c.cli_situ              =  'A' ");
           	query.append("            AND c.seg_cdgo              not in (9, 153) ");	
           	query.append("            AND 'S'                     = ").append(consulta_cidades);
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append("  	  AND r.rep_situ              =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append("   	  AND cr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append("   	  AND rm.situacao             =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append("   	  AND r.codigo_regional       =  ").append(se.getAttribute("codigo_regional"));
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append("   	  AND rm.marca_produto        =  ").append(se.getAttribute("codigo_marca"));
           	}
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append("  	  AND rm.marca_produto        =  ").append(marca);
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append("    	  AND r.codigo_regional       =  ").append(regional);
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("        AND r.rep_cdgo              =  ").append(representante);
           	}
           	query.append("       ) cidades_ativas, ");
//----- CIDADES ATENDIDAS --------------------		
           	query.append("        (SELECT count(distinct cidade) qtde ");
           	query.append("           FROM ( SELECT distinct(ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade ");
           	query.append("   				  FROM resumo_ped res ");
           	query.append("                       , ecl ");
           	query.append("         				 , cli ");
           	query.append("         				 , rep ");
           	query.append("        				 , cliente_representante clr ");
           	query.append("       				 , representante_marca rm ");
           	query.append(" 					 WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append(" 					   AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	if (!se.getAttribute("lin_cdgo").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.lin_cdgo             =  ").append(se.getAttribute("lin_cdgo"));
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append("   			   AND res.codigo_regional      =  ").append(se.getAttribute("codigo_regional"));
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append("   			   AND res.codigo_marca         =  ").append(se.getAttribute("codigo_marca"));
           	}
           	query.append("   				   AND ecl.cli_cdgo             =  res.cli_cdgo ");  
           	query.append("                     AND 'S'                      = ").append(consulta_cidades);           
           	query.append("				       AND cli.cli_cdgo             =  res.cli_cdgo "); 
           	query.append(" 					   AND rep.rep_cdgo             =  res.rep_cdgo "); 
           	query.append("				       AND clr.codigo_cliente       =  cli.cli_cdgo "); 
           	query.append(" 				       AND rm.codigo_representante  =  rep.rep_cdgo "); 
           	query.append(" 				       AND clr.codigo_representante =  rep.rep_cdgo ");
           	query.append(" 					   AND clr.codigo_sequencial    =  res.esc_seqn ");  
           	query.append(" 			 	       AND rm.marca_produto         =  res.codigo_marca ");
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append(" 	   	    	   AND rm.marca_produto         =  ").append(marca);
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_regional      =  ").append(regional);
           	}
           	query.append(" 		     		   AND ecl.ned_cdgo             IN ('COB', 'UNI') ");  
           	query.append(" 				       AND ecl.esc_seqn             =  res.esc_seqn ");
           	query.append(" 			     	   AND cli.cli_situ             =  'A' ");
           	query.append("                     AND cli.seg_cdgo             NOT IN (9, 153) ");		
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append("   			   AND rep.rep_situ             =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 	    	       AND clr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append("   			   AND rm.situacao              =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("                 AND rep.rep_cdgo             =  ").append(representante);
           	}
           	query.append(" 			    	 UNION ALL "); 
           	query.append(" 				    SELECT distinct(ecl.ecl_cdad || ' - ' || ecl.est_unifed) cidade ");  
           	query.append("   				  FROM resumo_pedidos res ");
           	query.append("                       , ecl "); 
           	query.append(" 					     , cli "); 
           	query.append("    				     , rep "); 
           	query.append("   				     , cliente_representante clr "); 
           	query.append(" 					     , representante_marca rm ");
           	query.append(" 				     WHERE res.data_dig             >= to_date('").append(se.getAttribute("dt_inicial")).append("','dd/MM/yyyy') ");
           	query.append(" 					   AND res.data_dig             <  to_date('").append(se.getAttribute("dt_final")).append("','dd/MM/yyyy')+1 ");
           	if (!se.getAttribute("lin_cdgo").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.lin_cdgo             =  ").append(se.getAttribute("lin_cdgo"));
           	}
           	if (!se.getAttribute("codigo_regional").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_regional      =  ").append(se.getAttribute("codigo_regional"));
           	}
           	if (!se.getAttribute("codigo_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND res.codigo_marca         =  ").append(se.getAttribute("codigo_marca"));
           	}
           	query.append("                     AND 'S'                      = ").append(consulta_cidades);           
           	query.append(" 		     		   AND ecl.cli_cdgo             =  res.cli_cdgo ");
           	query.append(" 					   AND cli.cli_cdgo             =  res.cli_cdgo "); 
           	query.append(" 					   AND rep.rep_cdgo             =  res.rep_cdgo ");
           	query.append(" 					   AND clr.codigo_cliente       =  cli.cli_cdgo ");
           	query.append(" 					   AND clr.codigo_representante =  rep.rep_cdgo ");
           	query.append(" 					   AND clr.codigo_sequencial    =  res.esc_seqn ");
           	query.append(" 					   AND rm.codigo_representante  =  rep.rep_cdgo ");
           	query.append(" 					   AND ecl.ned_cdgo             in ('COB', 'UNI') ");  
           	query.append(" 					   AND ecl.esc_seqn             =  res.esc_seqn ");
           	query.append(" 					   AND rm.marca_produto         =  res.codigo_marca ");  
           	if (!marca.equalsIgnoreCase("null")) {
           		query.append(" 				   AND rm.marca_produto         =  ").append(marca);
           	}
           	if (!regional.equalsIgnoreCase("null")) {
           		query.append("   			   AND res.codigo_regional      =  ").append(regional);
           	}
           	query.append(" 	    			   AND cli.cli_situ             =  'A' ");
           	query.append("                     AND cli.seg_cdgo             NOT IN (9, 153) ");
           	if (!se.getAttribute("situacao_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND rep.rep_situ             =  ").append(se.getAttribute("situacao_representante"));
           	}
           	if (!se.getAttribute("situacao_cliente_representante").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND clr.situacao             =  ").append(se.getAttribute("situacao_cliente_representante"));
           	}
           	if (!se.getAttribute("situacao_representante_marca").toString().equalsIgnoreCase("null")) {
           		query.append(" 				   AND rm.situacao              =  ").append(se.getAttribute("situacao_representante_marca"));
           	}
           	if (!representante.equalsIgnoreCase("null")) {
           		query.append("                 AND rep.rep_cdgo             =  ").append(representante);
           	}
           	query.append("        )) cidades_atendidas ");
           	
			res_Jw_totais = conexao.select(table, query.toString(), null);
			if (res_Jw_totais != null && res_Jw_totais.size() > 0) {
				portalbr.dbobj.view.Jw_totais r = (portalbr.dbobj.view.Jw_totais) res_Jw_totais.elementAt(0);
				if (r.getTotal_grupos_ativos() < 0) {
					setTotalGruposAtivos(0);
				} else {
					setTotalGruposAtivos(r.getTotal_grupos_ativos());
				}

				if (r.getTotal_grupos_atendidos() < 0) {
					setTotalGruposAtendidos(0);
				} else {
					setTotalGruposAtendidos(r.getTotal_grupos_atendidos());
				}

				if (r.getTotal_grupos_nao_atendidos() < 0) {
					setTotalGruposNaoAtendidos(0);
				} else {
					setTotalGruposNaoAtendidos(r.getTotal_grupos_nao_atendidos());
				}

				if (r.getTotal_clientes_ativos() < 0) {
					setTotalClientesAtivos(0);
				} else {
					setTotalClientesAtivos(r.getTotal_clientes_ativos());
				}

				if (r.getTotal_clientes_atendidos() < 0) {
					setTotalClientesAtendidos(0);
				} else {
					setTotalClientesAtendidos(r.getTotal_clientes_atendidos());
				}

				if (r.getTotal_clientes_nao_atendidos() < 0) {
					setTotalClientesNaoAtendidos(0);
				} else {
					setTotalClientesNaoAtendidos(r.getTotal_clientes_nao_atendidos());
				}

				if (r.getTotal_cidades_ativas() < 0) {
					setTotalCidadesAtivas(0);
				} else {
					setTotalCidadesAtivas(r.getTotal_cidades_ativas());
				}

				if (r.getTotal_cidades_atendidas() < 0) {
					setTotalCidadesAtendidas(0);
				} else {
					setTotalCidadesAtendidas(r.getTotal_cidades_atendidas());
				}

				if (r.getTotal_cidades_nao_atendidas() < 0) {
					setTotalCidadesNaoAtendidas(0);
				} else {
					setTotalCidadesNaoAtendidas(r.getTotal_cidades_nao_atendidas());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (conexao != null) {
				conexao.close();
				conexao = null;
			}
		}
	}

	public int getTotalCidadesAtendidas() {
		return totalCidadesAtendidas;
	}

	public void setTotalCidadesAtendidas(int cidadesAtendidas) {
		totalCidadesAtendidas = cidadesAtendidas;
	}

	public int getTotalCidadesAtivas() {
		return totalCidadesAtivas;
	}

	public void setTotalCidadesAtivas(int cidadesAtivas) {
		totalCidadesAtivas = cidadesAtivas;
	}

	public int getTotalCidadesNaoAtendidas() {
		return totalCidadesNaoAtendidas;
	}

	public void setTotalCidadesNaoAtendidas(int cidadesNaoAtendidas) {
		totalCidadesNaoAtendidas = cidadesNaoAtendidas;
	}

	public int getTotalClientesAtendidos() {
		return totalClientesAtendidos;
	}

	public void setTotalClientesAtendidos(int clientesAtendidos) {
		totalClientesAtendidos = clientesAtendidos;
	}

	public int getTotalClientesAtivos() {
		return totalClientesAtivos;
	}

	public void setTotalClientesAtivos(int clientesAtivos) {
		totalClientesAtivos = clientesAtivos;
	}

	public int getTotalClientesNaoAtendidos() {
		return totalClientesNaoAtendidos;
	}

	public void setTotalClientesNaoAtendidos(int clientesNaoAtendidos) {
		totalClientesNaoAtendidos = clientesNaoAtendidos;
	}

	public int getTotalGruposAtivos() {
		return totalGruposAtivos;
	}

	public int getTotalGruposAtendidos() {
		return totalGruposAtendidos;
	}

	public int getTotalGruposNaoAtendidos() {
		return totalGruposNaoAtendidos;
	}

	public void setTotalGruposAtivos(int gruposAtivos) {
		totalGruposAtivos = gruposAtivos;
	}

	public void setTotalGruposAtendidos(int gruposAtendidos) {
		totalGruposAtendidos = gruposAtendidos;
	}

	public void setTotalGruposNaoAtendidos(int gruposNaoAtendidos) {
		totalGruposNaoAtendidos = gruposNaoAtendidos;
	}
}
