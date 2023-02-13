package com.beirario.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.beirario.leitor.Linha;

public class ArquivoExcel {

	private java.io.File arquivo;

	public java.io.File getArquivo() {
		return arquivo;
	}

	public void setArquivo(java.io.File arquivo) {
		this.arquivo = arquivo;
	}

	private String caminhoArquivo;
	private List<Linha> linhas;

	public ArquivoExcel(String caminhoExcel) {
		this.arquivo = new java.io.File(caminhoExcel);
		this.caminhoArquivo = caminhoExcel;
	}

	public ArquivoExcel(java.io.File arquivo) {
		this.arquivo = arquivo;
		this.caminhoArquivo = arquivo.getAbsolutePath();
	}

	public String getCaminhoExcel() {
		return caminhoArquivo;
	}

	public void setCaminhoExcel(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public void setDadosExcel(String tipoArquivo) {
		this.linhas = new ArrayList<Linha>();
		if (tipoArquivo.equalsIgnoreCase("xls")) {
			try {
				FileInputStream fileInputStream = new FileInputStream(this.caminhoArquivo);
				HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
				HSSFSheet worksheet = workbook.getSheetAt(0);
				Iterator<Row> rows = worksheet.rowIterator();
				int contador = 0;
				while (rows.hasNext()) {
					HSSFRow myRow = (HSSFRow) rows.next();
					if (contador > 0) {
						int index = 0;
						HSSFCell cellQtde = myRow.getCell(index++);
						double qtde = cellQtde.getNumericCellValue();
						HSSFCell cellMaterial = myRow.getCell(index++);
						Double material = cellMaterial.getNumericCellValue();
						HSSFCell cellEan = myRow.getCell(index++);
						Double ean = cellEan.getNumericCellValue();
						HSSFCell cellTextoBreve = myRow.getCell(index++);
						String textoBreve = cellTextoBreve.getStringCellValue();
						HSSFCell cellCor = myRow.getCell(index++);
						String cor = cellCor.getStringCellValue();
						HSSFCell cellTamanho = myRow.getCell(index++);
						double tamanho = cellTamanho.getNumericCellValue();
						HSSFCell cellMatFornecedor = myRow.getCell(index++);
						double matFornecedor = cellMatFornecedor.getNumericCellValue();
						HSSFCell cellRazaoSocial = myRow.getCell(index++);
						String razaoSocial = cellRazaoSocial.getStringCellValue();
						HSSFCell cellFornecedor = myRow.getCell(index++);
						double fornecedor = cellFornecedor.getNumericCellValue();
						HSSFCell cellCorFornecedor = myRow.getCell(index++);
						String corFornecedor = cellCorFornecedor.getStringCellValue();
						HSSFCell cellPrecoLiquido = myRow.getCell(index++);
						double precoLiquido = cellPrecoLiquido.getNumericCellValue();
						HSSFCell cellPor = myRow.getCell(index++);
						double por = cellPor.getNumericCellValue();
						Linha ln = new Linha();
						ln.setMaterial(String.valueOf(material.longValue()));
						ln.setEan(String.valueOf(ean.longValue()));
						this.linhas.add(ln);
					}
					contador++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (tipoArquivo.equalsIgnoreCase("xlsx")) {
			try {
				FileInputStream fileInputStream = new FileInputStream(this.caminhoArquivo);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				XSSFSheet worksheet = workbook.getSheetAt(0);
				Iterator<Row> rows = worksheet.rowIterator();
				int contador = 0;
				while (rows.hasNext()) {
					XSSFRow myRow = (XSSFRow) rows.next();
					if (contador > 0) {
						int index = 0;
						XSSFCell cellQtde = myRow.getCell(index++);
						Double qtde = cellQtde.getNumericCellValue();
						XSSFCell cellMaterial = myRow.getCell(index++);
						Double material = cellMaterial.getNumericCellValue();
						XSSFCell cellEan = myRow.getCell(index++);
						Double ean = cellEan.getNumericCellValue();
						XSSFCell cellTextoBreve = myRow.getCell(index++);
						String textoBreve = cellTextoBreve.getStringCellValue();
						XSSFCell cellCor = myRow.getCell(index++);
						String cor = cellCor.getStringCellValue();
						XSSFCell cellTamanho = myRow.getCell(index++);
						Double tamanho = cellTamanho.getNumericCellValue();
						XSSFCell cellMatFornecedor = myRow.getCell(index++);
						Double matFornecedor = cellMatFornecedor.getNumericCellValue();
						XSSFCell cellRazaoSocial = myRow.getCell(index++);
						String razaoSocial = cellRazaoSocial.getStringCellValue();
						XSSFCell cellFornecedor = myRow.getCell(index++);
						Double fornecedor = cellFornecedor.getNumericCellValue();
						XSSFCell cellCorFornecedor = myRow.getCell(index++);
						String corFornecedor = cellCorFornecedor.getStringCellValue();
						XSSFCell cellPrecoLiquido = myRow.getCell(index++);
						double precoLiquido = cellPrecoLiquido.getNumericCellValue();
						XSSFCell cellPor = myRow.getCell(index++);
						double por = cellPor.getNumericCellValue();
						Linha ln = new Linha();
						ln.setMaterial(String.valueOf(material.longValue()));
						ln.setEan(String.valueOf(ean.longValue()));
						this.linhas.add(ln);
					}
					contador++;
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setDados(List<String[]> dados) throws Exception {
		this.linhas = new ArrayList<Linha>();
		int reg = 0;
		Long lg;
		try {
			for (int i = 0; i <= dados.size() - 1; i++) {
				if (!dados.get(i)[0].equals("")) {
					Linha ln = new Linha();
					lg = Double.valueOf(dados.get(i)[1]).longValue();
					ln.setMaterial(String.valueOf(lg));
					lg = Double.valueOf(dados.get(i)[2]).longValue();
					ln.setEan(String.valueOf(lg));
					this.linhas.add(ln);
				}
				reg = i;
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			throw new Exception("(ArquivoExcel.setDados) Erro registro " + reg + ", erro: " + ex.getMessage());
		}
	}

	public List<Linha> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}
}
