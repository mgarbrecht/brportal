<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html>
<head>
<title>
Manual</title>
<meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'>
<LINK REL='stylesheet' TYPE='text/css' HREF='style.css'>
</head>
<body class="bodyIndex">
<div class="homeLink" ><a href='pages.jsp' target='pagesframe'>Inicial</a>&nbsp;&nbsp;<a href='topic.jsp' target='_self'>Tópico</a></div><br>
<div class="homeContents" >Conteúdos</div>
<table style=width:150;margin-top:10;>
<tr><td>
<link rel="StyleSheet" href="../css/dtree.css" type="text/css" />
<script type="text/javascript" src="../script/dtree.js"></script>
<div class="dtree">
<div class="menuHeader"><a href="javascript: dmenu.openAll();">Abrir Todos</a> | <a href="javascript: dmenu.closeAll();">Fechar Todos</a></div><br>
<script type="text/javascript">
dmenu = new dTree('dmenu');
dmenu.add(0,-1,'e-Gen');

dmenu.add(1,0,'Acessos dos Clientes','temp/UltimoAcessoForm.jsp','','pagesframe','');
dmenu.add(2,0,'Acessos dos Representantes','temp/UltimoAcessoRepForm.jsp','','pagesframe','');
dmenu.add(3,0,'Administrador de Pedidos - Previsto / Realizado','com/AdministradorPedidosForm.jsp','','pagesframe','');
dmenu.add(4,0,'Agenda de Visitas','com/AgendaVisitasForm.jsp','','pagesframe','');
dmenu.add(5,0,'Cadastro de Clientes','com/CadastroClientesForm.jsp','','pagesframe','');
dmenu.add(6,0,'Cheques em CLD','com/ChequesCLDForm.jsp','','pagesframe','');
dmenu.add(7,0,'Clientes Atendidos','adm/Clientes_atendidosForm.jsp','','pagesframe','');
dmenu.add(8,0,'Clientes Atendidos por Regional e Linha','com/Sbr073Form.jsp','','pagesframe','');
dmenu.add(9,0,'Clientes Atendidos por Representante e Linha','com/Sbr074Form.jsp','','pagesframe','');
dmenu.add(10,0,'Cobrança de Clientes por Rep.','com/CobrancaClientesRepresentantesForm.jsp','','pagesframe','');
dmenu.add(11,0,'Consulta de Clientes','com/ClientesForm.jsp','','pagesframe','');
dmenu.add(12,0,'Consulta de Código de Barras Único - EAN13','com/CodigoBarraUnicoForm.jsp','','pagesframe','');
dmenu.add(13,0,'Consulta de Notas Fiscais','com/ConsultaNotaFiscalForm.jsp','','pagesframe','');
dmenu.add(14,0,'Consulta de Pedidos','com/ConsultaPedidosForm.jsp','','pagesframe','');
dmenu.add(15,0,'Consulta de Títulos','com/TitulosForm.jsp','','pagesframe','');
dmenu.add(16,0,'Fotos por Linha','ind/FotosLinhaForm.jsp','','pagesframe','');
dmenu.add(17,0,'Fotos por Linha Cliente','ind/FotosLinhaClienteForm.jsp','','pagesframe','');
dmenu.add(18,0,'Limite de Crédito','temp/LimiteCreditoForm.jsp','','pagesframe','');
dmenu.add(19,0,'Limite de Crédito Disponível','temp/LimiteCreditoDisponivelForm.jsp','','pagesframe','');
dmenu.add(20,0,'Linhas mais Vendidas por Regional','com/Sbr060Form.jsp','','pagesframe','');
dmenu.add(21,0,'Linhas mais Vendidas por Representante','com/Sbr061Form.jsp','','pagesframe','');
dmenu.add(22,0,'Maiores Clientes Vencidos','com/MaioresClientesVencidosForm.jsp','','pagesframe','');
dmenu.add(23,0,'Normas de Venda','com/NormasVendaForm.jsp','','pagesframe','');
dmenu.add(24,0,'Pedidos Bloqueados','com/PedidosBloqueadosForm.jsp','','pagesframe','');
dmenu.add(25,0,'PLUS Clientes','com/PlusClientesForm.jsp','','pagesframe','');
dmenu.add(26,0,'PLUS Produtos','com/PlusProdutosForm.jsp','','pagesframe','');
dmenu.add(27,0,'POI - Aberto por Representante','com/PoiAbertoRepresentanteForm.jsp','','pagesframe','');
dmenu.add(28,0,'POI - Regional por Marcas','com/PoiRegionalMarcasForm.jsp','','pagesframe','');
dmenu.add(29,0,'Relatório de Cadastramento de Clientes','com/Sbr080Form.jsp','','pagesframe','');
dmenu.add(30,0,'Relatório de Códigos de Barra','com/CodigoBarraForm.jsp','','pagesframe','');
dmenu.add(31,0,'Relatório de Códigos de Barra DUN14','com/CodigoBarraDun14Form.jsp','','pagesframe','');
dmenu.add(32,0,'Saldo em Estoque por Grade','ind/Saldo_estoque_gradesForm.jsp','','pagesframe','');
dmenu.add(33,0,'Últimos Acessos dos Analistas de Mercado','temp/UltimoAcessoAnalistaForm.jsp','','pagesframe','');
dmenu.add(34,0,'Vendas Principais Clientes','com/VendasPrincipaisForm.jsp','','pagesframe','');
document.write(dmenu);
</script>
</div>
</td></tr>
</table>
</body>
</html>
