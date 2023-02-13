package util.consultas.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

@SuppressWarnings("rawtypes")
public class EmbarqueExportacao {

	private Vector res_Jw_embarque_exportacao ;
	
	public Vector getRes_Jw_planilha_importacao_calcenter() {
		return res_Jw_embarque_exportacao ;
	}

	public void setRes_Jw_planilha_importacao_calcenter(Vector res_Jw_embarque_exportacao ) {
		this.res_Jw_embarque_exportacao  = res_Jw_embarque_exportacao ;
	}

	public EmbarqueExportacao(java.util.Vector res_Jw_embarque_exportacao) {
		super();
		this.res_Jw_embarque_exportacao  = res_Jw_embarque_exportacao ;
	}

	public String geraExcel() throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		org.apache.poi.hssf.usermodel.HSSFRow trow;
		org.apache.poi.hssf.usermodel.HSSFCell tcell;
		org.apache.poi.hssf.usermodel.HSSFCellStyle style;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenterborda;
		org.apache.poi.hssf.usermodel.HSSFCellStyle stylecenter;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleright;
		org.apache.poi.hssf.usermodel.HSSFCellStyle styleGrade;
		StringBuilder nomeArquivo = new StringBuilder();
		int rowcount = 0;
		String retorno = "";
		int planilha = 0;
		boolean gerou = false;
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		try {
			HSSFSheet testsheet = null;
			nomeArquivo.append("embarque").append(util.rand.Palavra.geraPalavra()).append(".xls");
			style = wb.createCellStyle();
			stylecenter = wb.createCellStyle();
			styleright = wb.createCellStyle();
			stylecenterborda = wb.createCellStyle();
			styleGrade = wb.createCellStyle();
			styleGrade.setBorderLeft((short) 1);
			styleGrade.setBorderRight((short) 1);
			styleGrade.setBorderTop((short) 1);
			styleGrade.setBorderBottom((short) 1);
			styleGrade.setAlignment((short) 2);
			style.setBorderBottom((short) 1);
			style.setAlignment((short) 1);
			stylecenterborda.setBorderBottom((short) 1);
			stylecenterborda.setAlignment((short) 2);
			stylecenter.setAlignment((short) 2);
			styleright.setAlignment((short) 4);
			FileOutputStream fos = new FileOutputStream(parametros.retornaParametro("diretorio_pdf") + nomeArquivo.toString());
			int indice = 0;
			int indiceCell = 0;
			// --------- Cabecalho ------------------------
			testsheet = wb.createSheet("importacao" + ++planilha);
			trow = testsheet.createRow(rowcount);
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Remessa");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Pedido");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Invoice");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Seqn.");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Linha");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Referência");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cabedal");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cor");
			tcell.setCellStyle(stylecenterborda);
			
			//tcell = trow.createCell(indiceCell++);
			//tcell.setCellValue("Numeração Interna");
			//tcell.setCellStyle(stylecenterborda);
			
			//tcell = trow.createCell(indiceCell++);
			//tcell.setCellValue("Numeração Externa");
			//tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Pares");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Loja Cliente");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Caixa");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Total Rótulos Ped");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Total Rótulos");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Seq. Rótulo");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Seq. Rótulo Fatura");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Total Rótulos Fatura");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Cod. Barra");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Nfs. Nmro");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Nfs. Série");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Req.Nf. Número");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Nfs. Qtd. Vol.");
			tcell.setCellStyle(stylecenterborda);
			
			tcell = trow.createCell(indiceCell++);
			tcell.setCellValue("Filial");
			tcell.setCellStyle(stylecenterborda);
			

			while (indice < this.res_Jw_embarque_exportacao.size()) {portalbr.dbobj.view.Jw_embarque_exportacao t_jw_embarque_exportacao = (portalbr.dbobj.view.Jw_embarque_exportacao) this.res_Jw_embarque_exportacao.elementAt(indice);
				gerou = true;
				indiceCell = 0;
				// --------------------------------------------
				trow = testsheet.createRow(++rowcount);
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getRem_nro()!= null ? t_jw_embarque_exportacao.getRem_nro()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getPed_nmro()!= null ? t_jw_embarque_exportacao.getPed_nmro()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getPed_invoice()!= null ? t_jw_embarque_exportacao.getPed_invoice()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getIte_seqn()+"");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getLin_cdgo()!= null ? t_jw_embarque_exportacao.getLin_cdgo()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getRef_cdgo()!= null ? t_jw_embarque_exportacao.getRef_cdgo()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getCab_cdgo()!= null ? t_jw_embarque_exportacao.getCab_cdgo()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getCor_cdgo()!= null ? t_jw_embarque_exportacao.getCor_cdgo()+"" : "");
				//tcell = trow.createCell(indiceCell++);
				//tcell.setCellValue(t_jw_embarque_exportacao.getNumeracao_interna()!= null ? t_jw_embarque_exportacao.getNumeracao_interna() : "");
				//tcell = trow.createCell(indiceCell++);
				//tcell.setCellValue(t_jw_embarque_exportacao.getNumeracao_externa()!= null ? t_jw_embarque_exportacao.getNumeracao_externa() : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getPares()+"");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getLoja_cliente()!= null ? t_jw_embarque_exportacao.getLoja_cliente()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getCaixa()!= null ? t_jw_embarque_exportacao.getCaixa()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getTotal_rotulos_ped() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getTotal_rotulos() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getSeq_rotulo() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getSeq_rotulo_fatura() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getTotal_rotulos_fatura() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getBar()!= null ? t_jw_embarque_exportacao.getBar()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getNfs_nmro() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getNfs_serie()!= null ? t_jw_embarque_exportacao.getNfs_serie()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getReqnf_numero()!= null ? t_jw_embarque_exportacao.getReqnf_numero()+"" : "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getNfs_qtdvol() + "");
				tcell = trow.createCell(indiceCell++);
				tcell.setCellValue(t_jw_embarque_exportacao.getFil_filial()!= null ? t_jw_embarque_exportacao.getFil_filial()+"" : "");
				indice++;
			}
			wb.write(fos);
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace(System.err);
		} finally {
		}
		if (gerou) {
			retorno = parametros.retornaParametro("diretorio_link_pdf") + nomeArquivo.toString();
		} else {
			retorno = "";
		}
		return retorno;
	}

	
}
