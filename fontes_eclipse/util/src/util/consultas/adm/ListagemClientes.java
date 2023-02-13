package util.consultas.adm;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import util.rand.Palavra;

public class ListagemClientes {

   public String geraExcel(@SuppressWarnings("rawtypes") Vector listagem){
	   
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet testsheet = wb.createSheet("Listagem de Clientes");
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			nomeArquivo.append("listagemclientes").append(Palavra.geraPalavra()).append(".xls");
			@SuppressWarnings("unused")
			HSSFSheet sheet = wb.getSheet("Listagem de Clientes");
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf")+ nomeArquivo.toString());
			HSSFRow trow = testsheet.createRow(rowcount);
			HSSFCell tcell = trow.createCell(0);
			tcell.setCellValue("Código");
			tcell = trow.createCell(1);
			tcell.setCellValue("Razão Social");
			tcell = trow.createCell(2);
			tcell.setCellValue("Nome");
			tcell = trow.createCell(3);
			tcell.setCellValue("CNPJ");
			tcell = trow.createCell(4);
			tcell.setCellValue("Endereço");
			tcell = trow.createCell(5);
			tcell.setCellValue("UF");
			tcell = trow.createCell(6);            
			tcell.setCellValue("Bairro");
			tcell = trow.createCell(7);
			tcell.setCellValue("CEP");
			tcell = trow.createCell(8);
			tcell.setCellValue("Insc. Est.");
			tcell = trow.createCell(9);
			tcell.setCellValue("Situação");
			tcell = trow.createCell(10);
			tcell.setCellValue("Segmento");
			tcell = trow.createCell(11);
			tcell.setCellValue("Grupo");
			tcell = trow.createCell(12);
			tcell.setCellValue("Limite Crédito");
			tcell = trow.createCell(13);
			tcell.setCellValue("Saldo Disponível");
			tcell = trow.createCell(14);
			tcell.setCellValue("Pendência");			
			tcell = trow.createCell(15);
			tcell.setCellValue("Email");
			tcell = trow.createCell(16);
			tcell.setCellValue("Fone");
			tcell = trow.createCell(17);
			tcell.setCellValue("Contatos");
			tcell = trow.createCell(18);
			tcell.setCellValue("Classificação");
			tcell = trow.createCell(19);
			tcell.setCellValue("Cx. Postal");
			tcell = trow.createCell(20);
			tcell.setCellValue("Zona");
			tcell = trow.createCell(21);
			tcell.setCellValue("Consignatário");
			tcell = trow.createCell(22);
			tcell.setCellValue("Transportadora");
			tcell = trow.createCell(23);
			tcell.setCellValue("Data Última Compra");
			tcell = trow.createCell(24);
			tcell.setCellValue("Valor Última Compra");
			portalbr.dbobj.view.Jw_clientes t_jw_clientes = new portalbr.dbobj.view.Jw_clientes();
			int i_Jw_clientes = 0; 
				for(int x=0; x<listagem.size(); x++){
				rowcount++;
  			    t_jw_clientes = (portalbr.dbobj.view.Jw_clientes)listagem.elementAt(i_Jw_clientes);
				trow = testsheet.createRow(rowcount);
				tcell = trow.createCell(0);
				tcell.setCellValue(t_jw_clientes.getCodigo());
				tcell = trow.createCell(1);
				tcell.setCellValue(t_jw_clientes.getCli_rzao());
				tcell = trow.createCell(2);
				tcell.setCellValue(t_jw_clientes.getCli_nome());
				tcell = trow.createCell(3);
				tcell.setCellValue(t_jw_clientes.getCnpj());
				tcell = trow.createCell(4);
				tcell.setCellValue(t_jw_clientes.getEndereco());
				tcell = trow.createCell(5);
				tcell.setCellValue(t_jw_clientes.getUf());
				tcell = trow.createCell(6);
				tcell.setCellValue(t_jw_clientes.getBairro());
				tcell = trow.createCell(7);
				tcell.setCellValue(t_jw_clientes.getCep());
				tcell = trow.createCell(8);
				tcell.setCellValue(t_jw_clientes.getInscr());
				tcell = trow.createCell(9);
				tcell.setCellValue(t_jw_clientes.getSituacao());
				tcell = trow.createCell(10);
				tcell.setCellValue(t_jw_clientes.getSegmento());
				tcell = trow.createCell(11);
				tcell.setCellValue(t_jw_clientes.getGrupo());
				tcell = trow.createCell(12);
				tcell.setCellValue("R$ ".concat(com.egen.util.text.FormatNumber.format(t_jw_clientes.getCredito(), "##,##0.00")));
				tcell = trow.createCell(13);
				tcell.setCellValue("R$ ".concat(com.egen.util.text.FormatNumber.format(t_jw_clientes.getSaldo_disponivel(), "##,##0.00")));
				tcell = trow.createCell(14);
				tcell.setCellValue("R$ ".concat(com.egen.util.text.FormatNumber.format(t_jw_clientes.getPendencia(), "##,##0.00")));				
				tcell = trow.createCell(15);
				tcell.setCellValue(t_jw_clientes.getEmail());
				tcell = trow.createCell(16);
				tcell.setCellValue(t_jw_clientes.getFones());
				tcell = trow.createCell(17);
				tcell.setCellValue(t_jw_clientes.getContatos());
				tcell = trow.createCell(18);
				tcell.setCellValue(t_jw_clientes.getClassificacao());
				tcell = trow.createCell(19);
				tcell.setCellValue(t_jw_clientes.getEcl_cxpo());
				tcell = trow.createCell(20);
				tcell.setCellValue(t_jw_clientes.getEcl_zona());
				tcell = trow.createCell(21);
				tcell.setCellValue(t_jw_clientes.getConsignatario());
				tcell = trow.createCell(22);
				tcell.setCellValue(t_jw_clientes.getTra_nome());
				tcell = trow.createCell(23);
				tcell.setCellValue(t_jw_clientes.getData_ultima_compra());
				tcell = trow.createCell(24);
				tcell.setCellValue("R$ ".concat(com.egen.util.text.FormatNumber.format(t_jw_clientes.getValor_ultima_compra(), "##,##0.00")));
				i_Jw_clientes++;
				gerou = true;
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		if (gerou)
			try {
				retorno = parametros.retornaParametro("diretorio_link_pdf")+ nomeArquivo.toString();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else {
			retorno = "";
		}
		return retorno;
	}
}
