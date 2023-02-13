package util.ws.boa_vista;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.beirario.brportal.util.DateUtil;

import util.consultas.Query;

public class WebServiceBoaVista {

	private final String USUARIO = "01282260";
	private final String SENHA = "8JY60U";
	private Document doc;
	private Connection conexao;
	private ScpcClientes scpcClientes; 
	private ScpcTelefones scpcTelefones;
	private Long cnpj;
	private Long cnpjBase;

	public static void main(String args[]) {
		WebServiceBoaVista ws = new WebServiceBoaVista();
		try {
			ws.processar("13441423001756");
			//ws.processar("2728707000144");
			//System.out.println(String.format("%014d", Long.parseLong("123456789")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void retornaCnpjs(String cnpjProcessar) {
		Query query = new Query();
		try {
			StringBuilder sbTipo = new StringBuilder();
			sbTipo.append(" SELECT c.cli_tipo ");
			sbTipo.append("   FROM esc e ");
			sbTipo.append("      , cli c ");
			sbTipo.append("  WHERE e.esc_cgc = " + cnpjProcessar);
			sbTipo.append("    AND c.cli_cdgo = e.cli_cdgo ");
			sbTipo.append("    AND e.esc_situacao = 'A' ");
			String tipoPessoa = query.retorna(this.conexao, sbTipo.toString());
			if(tipoPessoa.equalsIgnoreCase("J")){
				this.cnpj = Long.parseLong(cnpjProcessar);
				String base = String.format("%014d", Long.parseLong(cnpjProcessar));
				this.cnpjBase = Long.parseLong(base.substring(0, 8));
			} else {
				this.cnpjBase = Long.parseLong(cnpjProcessar);
				this.cnpj = Long.parseLong(cnpjProcessar);
			}
		} catch (Exception e) {
		}
	}
	
	public void processar(String cnpjParametro) throws IOException {
		
		//PreparedStatement pstm = null;
		//ResultSet rset = null;
		boolean executaWebService = true;
		// com.egen.util.jdbc.JdbcUtil j = null;
		try {
			inicializarConexoes();
			if (conexoesValidas()) {
				// j = new com.egen.util.jdbc.JdbcUtil();
				// StringBuilder sbXmlResposta = new StringBuilder();
				retornaCnpjs(cnpjParametro);
				if (executaWebService) {
					URL url = new URL("https://commercial.bvsnet.com.br/EmpresarialXmlBv/bvs/empresarial/gold/4.0?usuario="+ this.USUARIO + "&senha=" + this.SENHA + "&cnpj=" + cnpjParametro);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.connect();
					java.io.InputStream is = connection.getInputStream();
					
					java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(is));
					String line;
					List<String> res = new ArrayList<String>();
					while ((line = rd.readLine()) != null) {
						//sbXmlResposta.append(line).append("\n");
						System.out.println(line);
						res.add(line);
					}
					rd.close();
					
					//processaScpcClientes(is);
					//processaScpcTelefones(is);
					//connection.disconnect();
				} else {
					//processaScpcClientes(null);
					//processaScpcTelefones(null);
				}
				
				
				// processaXml(null);
				//
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			finalizarConexoes();
			// if(j!=null){
			// j.close();
			// }
		}

	}

	private void processaXml(java.io.InputStream is) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			// this.doc = dBuilder.parse(is);
			this.doc = dBuilder.parse(new File("c:/boa_vista/teste.xml"));
			this.doc.getDocumentElement().normalize();
			NodeList nListVol = this.doc.getElementsByTagName("prot:protesto");
			for (int x = 0; x < nListVol.getLength(); x++) {
				Node nNode = nListVol.item(x);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					// this.tmpNfImportacao.setQtdVolumes(Integer.parseInt(eElement.getElementsByTagName("qVol").item(0).getTextContent()));
					// this.tmpNfImportacao.setEspVolumes(eElement.getElementsByTagName("esp").item(0).getTextContent());
					// this.tmpNfImportacao.setPesoLiquido(Double.parseDouble(eElement.getElementsByTagName("pesoL").item(0).getTextContent()));
					// this.tmpNfImportacao.setPesoBruto(Double.parseDouble(eElement.getElementsByTagName("pesoB").item(0).getTextContent()));
					System.out.println("processou");
				}
			}
		} catch (Exception e) {

		}
	}

	private void processaScpcClientes(java.io.InputStream is) {
		System.out.println("passo1");
		Query query = new Query();
		this.scpcClientes = new ScpcClientes();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			if (is != null) {
				this.doc = dBuilder.parse(is);
				System.out.println("ws");
			} else {
				this.doc = dBuilder.parse(new File("c:/boa_vista/teste.xml"));
			}
			this.doc.getDocumentElement().normalize();
			System.out.println("passo2");
			// ---------- Processar iden:identificacao -----------------------------------
			NodeList nListVol = this.doc.getElementsByTagName("iden:identificacao");
			System.out.println("passo2.1");
			for (int x = 0; x < nListVol.getLength(); x++) {
				System.out.println("passo3");
				Node nNode = nListVol.item(x);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					for (int xDi = 0; xDi < eElement.getChildNodes().getLength(); xDi++) {
						Node nNodeDI = eElement.getChildNodes().item(xDi);
						// CNPJ e o sequencial da consulta
						if (nNodeDI.getNodeName().equals("iden:cnpj")) {
							try {
								this.scpcClientes.setCnpjCpfBase(this.cnpjBase);
								this.scpcClientes.setCnpjCpf(this.cnpj);
								this.scpcClientes.setSeqConsulta(Integer.parseInt(query.retorna(this.conexao, "SELECT nvl(max(seq_consulta)+1,1) FROM brconrec.scpc_clientes WHERE cnpj_cpf_base = "	+ this.scpcClientes.getCnpjCpfBase())));
							} catch (Exception e) {
							}
						}
						try {
							int quantidadeConsultas = Integer.parseInt(query.retorna(this.conexao, "SELECT count(*) quantidade FROM brconrec.scpc_clientes WHERE cnpj_cpf_base = " + this.scpcClientes.getCnpjCpfBase()));
							if (quantidadeConsultas == 3) {
								StringBuilder sbd = new StringBuilder();
								sbd.append(" DELETE brconrec.scpc_clientes ");
								sbd.append("  WHERE cnpj_cpf_base = ").append(this.scpcClientes.getCnpjCpfBase());
								sbd.append("    AND seq_consulta = (SELECT MIN(seq_consulta) ");
								sbd.append("                          FROM brconrec.scpc_clientes ");
								sbd.append("                         WHERE cnpj_cpf_base = ").append(this.scpcClientes.getCnpjCpfBase());
								sbd.append("                           AND seq_consulta <> 1) ");
								query.execute(this.conexao, sbd.toString());
							}
						} catch (Exception e) {
						}
						// Razão social
						if (nNodeDI.getNodeName().equals("iden:razao_social")) {
							try {
								System.out.println(nNodeDI.getTextContent());
								scpcClientes.setRazaoSocial(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Razão social Anterior
						if (nNodeDI.getNodeName().equals("iden:razao_social_anterior")) {
							try {
								scpcClientes.setRazaoSocialAnterior(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Data de alteração da razão anterior
						if (nNodeDI.getNodeName().equals("iden:data_razao_anterior")) {
							try {
								scpcClientes.setDataRazaoAnterior(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Nome Fantasia
						if (nNodeDI.getNodeName().equals("iden:nome_fantasia")) {
							try {
								scpcClientes.setNomeFantasia(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Data da Fundação
						if (nNodeDI.getNodeName().equals("iden:data_fundacao")) {
							try {
								scpcClientes.setDataFundacao(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Situação do Cnpj
						if (nNodeDI.getNodeName().equals("iden:situacao_cnpj")) {
							try {
								scpcClientes.setSituacaoCnpj(nNodeDI.getTextContent().substring(0, 1).toUpperCase());
							} catch (Exception e) {
							}
						}
						// Data da situação do Cnpj
						if (nNodeDI.getNodeName().equals("iden:data_situacao_cnpj")) {
							try {
								scpcClientes.setDataSituacaoCnpj(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Data da consulta do Cnpj
						if (nNodeDI.getNodeName().equals("iden:data_consulta_cnpj")) {
							try {
								scpcClientes.setDataConsultaCnpj(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Sintegra
						if (nNodeDI.getNodeName().equals("iden:sintegra")) {
							Element eElementSintegra = (Element) nNodeDI;
							// Sintegra Situação
							try {
								scpcClientes.setSituacao(eElementSintegra.getElementsByTagName("iden:situacao").item(0)
										.getTextContent());
							} catch (Exception e) {
							}
							// Data Sintegra
							try {
								scpcClientes.setDataSintegra(
										eElementSintegra.getElementsByTagName("iden:data").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Data Consulta
							try {
								scpcClientes.setDataConsulta(eElementSintegra.getElementsByTagName("iden:data_consulta")
										.item(0).getTextContent());
							} catch (Exception e) {
							}
						}
						// Inscrição Estadual
						if (nNodeDI.getNodeName().equals("iden:inscricao_estadual")) {
							Element eElementInscricaoEstadual = (Element) nNodeDI;
							// Inscrição Estadual UF
							try {
								scpcClientes.setUf(eElementInscricaoEstadual.getElementsByTagName("iden:uf").item(0)
										.getTextContent());
							} catch (Exception e) {
							}
							// Data Sintegra
							try {
								scpcClientes.setCadastro(eElementInscricaoEstadual.getElementsByTagName("iden:cadastro")
										.item(0).getTextContent());
							} catch (Exception e) {
							}
						}
						// Faixa Funcionários
						if (nNodeDI.getNodeName().equals("iden:faixa_funcionarios")) {
							try {
								scpcClientes.setFaixaFuncionarios(nNodeDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Filiais
						if (nNodeDI.getNodeName().equals("iden:filiais")) {
							Element eElementFiliais = (Element) nNodeDI;
							// Quantidade
							try {
								scpcClientes.setQuantidade(Integer.parseInt(eElementFiliais
										.getElementsByTagName("iden:quantidade").item(0).getTextContent()));
							} catch (Exception e) {
							}
							// Cidades
							try {
								scpcClientes.setCidades(
										eElementFiliais.getElementsByTagName("iden:cidades").item(0).getTextContent());
							} catch (Exception e) {
							}
						}
						// Nire
						if (nNodeDI.getNodeName().equals("iden:nire")) {
							Element eElementNire = (Element) nNodeDI;
							// Número
							try {
								scpcClientes.setNumero(
										eElementNire.getElementsByTagName("iden:numero").item(0).getTextContent());
							} catch (Exception e) {
							}
							// UF
							try {
								scpcClientes.setEstadoNire(
										eElementNire.getElementsByTagName("iden:uf").item(0).getTextContent());
							} catch (Exception e) {
							}
						}
						// Ramo Atividade
						if (nNodeDI.getNodeName().equals("iden:ramo_atividade")) {
							Element eElementRamoAtividade = (Element) nNodeDI;
							// Atividade
							try {
								scpcClientes.setAtividade(eElementRamoAtividade.getElementsByTagName("iden:atividade")
										.item(0).getTextContent());
							} catch (Exception e) {
							}
							// Cnae
							try {
								scpcClientes.setCnae(eElementRamoAtividade.getElementsByTagName("iden:cnae").item(0)
										.getTextContent());
							} catch (Exception e) {
							}
						}
						// Ramo Atividade Secundário
						if (nNodeDI.getNodeName().equals("iden:ramo_atividade_secundario")) {
							Element eElementRamoAtividadeSecundario = (Element) nNodeDI;
							// Atividade
							try {
								scpcClientes.setAtividadeSec(eElementRamoAtividadeSecundario
										.getElementsByTagName("iden:atividade").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Cnae
							try {
								scpcClientes.setCnaeSec(eElementRamoAtividadeSecundario
										.getElementsByTagName("iden:cnae").item(0).getTextContent());
							} catch (Exception e) {
							}
						}
					}
				}
			}
			System.out.println("depois");

			// ---------- Processar loc:localizacao  --------------
			NodeList nListLocalizacao = this.doc.getElementsByTagName("loc:localizacao");
			System.out.println("depois2");
			for (int x = 0; x < nListLocalizacao.getLength(); x++) {
				System.out.println("depois2.3");
				Node nNodeLocalizacao = nListLocalizacao.item(x);
				if (nNodeLocalizacao.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("depois2.4");
					Element eElement = (Element) nNodeLocalizacao;
					for (int xDi = 0; xDi < eElement.getChildNodes().getLength(); xDi++) {
						Node nNodeLocalizacaoDI = eElement.getChildNodes().item(xDi);
						// Endereço
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:endereco")) {
							try {
								scpcClientes.setEndereco(nNodeLocalizacaoDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Bairro
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:bairro")) {
							try {
								scpcClientes.setBairro(nNodeLocalizacaoDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Cidade
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:cidade")) {
							try {
								scpcClientes.setCidade(nNodeLocalizacaoDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Estado
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:uf")) {
							try {
								scpcClientes.setEstado(nNodeLocalizacaoDI.getTextContent());
							} catch (Exception e) {
							}
						}
						// Cep
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:cep")) {
							try {
								scpcClientes.setCep(nNodeLocalizacaoDI.getTextContent());
							} catch (Exception e) {
							}
						}

						// Matriz
						if (nNodeLocalizacaoDI.getNodeName().equals("loc:matriz")) {
							Element eElementMatriz = (Element) nNodeLocalizacaoDI;
							// Endereço Matriz
							try {
								scpcClientes.setEnderecoMatriz(eElementMatriz.getElementsByTagName("loc:endereco").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Bairro Matriz
							try {
								scpcClientes.setBairroMatriz(eElementMatriz.getElementsByTagName("loc:bairro").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Cidade Matriz
							try {
								scpcClientes.setCidadeMatriz(eElementMatriz.getElementsByTagName("loc:cidade").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Estado Matriz
							try {
								scpcClientes.setEstadoMatriz(eElementMatriz.getElementsByTagName("loc:uf").item(0).getTextContent());
							} catch (Exception e) {
							}
							// Cep Matriz
							try {
								scpcClientes.setCepMatriz(eElementMatriz.getElementsByTagName("loc:cep").item(0).getTextContent());
							} catch (Exception e) {
							}
						}
					}
				}
			}
			// --- Fim processar loc:localizacao
			StringBuilder sbi = new StringBuilder();
			sbi.append(" INSERT INTO brconrec.scpc_clientes ");
			sbi.append(" VALUES ");
			sbi.append("   ( " + this.scpcClientes.getCnpjCpfBase());
			sbi.append("   , " + (this.scpcClientes.getTipoPessoa() != null ?  "'"+this.scpcClientes.getTipoPessoa()+"'" : "null"));
			sbi.append("   , " + this.scpcClientes.getCnpjCpf());
			sbi.append("   , " + this.scpcClientes.getSeqConsulta());
			sbi.append("   , " + (this.scpcClientes.getRazaoSocial() != null ? "'" + this.scpcClientes.getRazaoSocial() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getRazaoSocialAnterior() != null ? "'" + this.scpcClientes.getRazaoSocialAnterior() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataRazaoAnterior() != null ? "to_date('" + this.scpcClientes.getDataRazaoAnterior() + "','ddmmyyyy')" : "null"));
			sbi.append("   , " + (this.scpcClientes.getNomeFantasia() != null ? "'" + this.scpcClientes.getNomeFantasia() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataFundacao() != null ? "'" + this.scpcClientes.getDataFundacao() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getSituacaoCnpj() != null ? "'" + this.scpcClientes.getSituacaoCnpj() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataSituacaoCnpj() != null ? "to_date('" + this.scpcClientes.getDataSituacaoCnpj() + "','ddmmyyyy')" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataConsultaCnpj() != null ? "to_date('" + this.scpcClientes.getDataConsultaCnpj() + "','ddmmyyyy')" : "null"));
			sbi.append("   , " + (this.scpcClientes.getSituacao() != null ? "'" + scpcClientes.getSituacao() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataSintegra() != null ? "to_date('" + this.scpcClientes.getDataSintegra() + "','ddmmyyyy')" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataConsulta() != null ? "to_date('" + this.scpcClientes.getDataConsulta() + "','ddmmyyyy')" : "null"));
			sbi.append("   , " + (this.scpcClientes.getUf() != null ? "'" + this.scpcClientes.getUf() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCadastro() != null ? "'" + this.scpcClientes.getCadastro() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getFaixaFuncionarios() != null ? "'" + this.scpcClientes.getFaixaFuncionarios() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getQuantidade() != null ? this.scpcClientes.getQuantidade() : "null"));
			sbi.append("   , " + (this.scpcClientes.getCidades() != null ? "'" + this.scpcClientes.getCidades() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getNumero() != null ? "'" + this.scpcClientes.getNumero() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getEstadoNire() != null ? "'" + this.scpcClientes.getEstadoNire() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getAtividade() != null ? "'" + this.scpcClientes.getAtividade() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCnae() != null ? "'" + this.scpcClientes.getCnae() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getAtividadeSec() != null ? "'" + this.scpcClientes.getAtividadeSec() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCnaeSec() != null ? "'" + this.scpcClientes.getCnaeSec() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getEndereco() != null ? "'" + this.scpcClientes.getEndereco() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getBairro() != null ? "'" + this.scpcClientes.getBairro() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCidade() != null ? "'" + this.scpcClientes.getCidade() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getEstado() != null ? "'" + this.scpcClientes.getEstado() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCep() != null ? "'" + this.scpcClientes.getCep() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getEnderecoMatriz() != null ? "'" + this.scpcClientes.getEnderecoMatriz() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getBairroMatriz() != null ? "'" + this.scpcClientes.getBairroMatriz() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCidadeMatriz() != null ? "'" + this.scpcClientes.getCidadeMatriz() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getEstadoMatriz() != null ? "'" + this.scpcClientes.getEstadoMatriz() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getCepMatriz() != null ? "'" + this.scpcClientes.getCepMatriz() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getDataEncerramento() != null ? "'" + this.scpcClientes.getDataEncerramento() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getNaturezaJuridica() != null ? "'" + this.scpcClientes.getNaturezaJuridica() + "'" : "null"));
			sbi.append("   , " + (this.scpcClientes.getMensagem() != null ? "'" + this.scpcClientes.getMensagem() + "'" : "null"));
			sbi.append("   ) ");
			query.execute(this.conexao, sbi.toString());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private void processaScpcTelefones(java.io.InputStream is) {
		Query query = new Query();
		this.scpcTelefones = new ScpcTelefones();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			if (is != null) {
				this.doc = dBuilder.parse(is);
			} else {
				this.doc = dBuilder.parse(new File("c:/boa_vista/teste.xml"));
			}
			this.doc.getDocumentElement().normalize();

			// ---------- Processar loc:telefones -----------------------------------
			NodeList nListVol = this.doc.getElementsByTagName("loc:telefones");
			for (int x = 0; x < nListVol.getLength(); x++) {
				Node nNode = nListVol.item(x);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					for (int xDi = 0; xDi < eElement.getChildNodes().getLength(); xDi++) {
						Node nNodeDI = eElement.getChildNodes().item(xDi);
						// Telefone
						if (nNodeDI.getNodeName().equals("loc:telefone")) {
							try {
								this.scpcTelefones.setCnpjCpfBase(this.scpcClientes.getCnpjCpfBase());
								this.scpcTelefones.setSeqConsulta(this.scpcClientes.getSeqConsulta());
								this.scpcTelefones.getListaTelefones().add(nNodeDI.getTextContent());
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
						try {
							StringBuilder sbQtd = new StringBuilder();
							sbQtd.append(" SELECT count(distinct seq_consulta) quantidade ");
							sbQtd.append("   FROM brconrec.scpc_telefones ");
							sbQtd.append("  WHERE cnpj_cpf_base = " + this.scpcClientes.getCnpjCpfBase());
							int quantidadeConsultas = Integer.parseInt(query.retorna(this.conexao, sbQtd.toString()));
							if (quantidadeConsultas == 3) {
								StringBuilder sbd = new StringBuilder();
								sbd.append(" DELETE brconrec.scpc_telefones ");
								sbd.append("  WHERE cnpj_cpf_base = ").append(this.scpcClientes.getCnpjCpfBase());
								sbd.append("    AND seq_consulta = (SELECT MIN(seq_consulta) ");
								sbd.append("                          FROM brconrec.scpc_telefones ");
								sbd.append("                         WHERE cnpj_cpf_base = ").append(this.scpcTelefones.getCnpjCpfBase());
								sbd.append("                           AND seq_consulta <> 1) ");
								query.execute(this.conexao, sbd.toString());
							}
						} catch (Exception e) {
							e.printStackTrace(System.err);
						}
					}
				}
			}
			int seqFone = 1;
			for(String telefone : this.scpcTelefones.getListaTelefones()){
				StringBuilder sbi = new StringBuilder();
				sbi.append(" INSERT INTO brconrec.scpc_telefones ");
				sbi.append(" VALUES ");
				sbi.append("   ( " + this.scpcTelefones.getCnpjCpfBase());
				sbi.append("   , " + this.scpcTelefones.getSeqConsulta());
				sbi.append("   , " + seqFone++ );
				sbi.append("   , " + ("'" + telefone + "'"));
				sbi.append("   ) ");
				query.execute(this.conexao, sbi.toString());
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}	

	private void inicializarConexoes() {
		Connection connOracle = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connOracle = DriverManager.getConnection("jdbc:oracle:thin:@orabrio-scan:1521/orabrio", "wbrio", "wbrio");
			connOracle = DriverManager.getConnection("jdbc:oracle:thin:@odabrio0.beirario.intranet:1521:oradsv", "wbrio", "wbrio");
			this.conexao = connOracle;
		} catch (Exception e) {
		}
	}

	private void finalizarConexoes() {
		if (this.conexao != null) {
			try {
				if (!this.conexao.isClosed()) {
					this.conexao.close();
				}
			} catch (Exception e) {
			}
		}
	}

	private boolean conexoesValidas() {
		boolean conexoesValidas = true;
		try {
			if (this.conexao == null || this.conexao.isClosed()) {
				conexoesValidas = false;
			}
		} catch (Exception e) {
			conexoesValidas = false;
		}
		return conexoesValidas;
	}
}
