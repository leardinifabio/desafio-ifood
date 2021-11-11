<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="pt_BR" scope="session" />

<t:main title="Cardápios">
	<jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<script src="assets/js/delete.js"></script>
    </jsp:attribute>
	
    <jsp:body> 
        <div class="row">
       		<h1 class="display-4">Cardápios da loja: <span class="text-danger">${loja.nm_loja}</span></h1>
       		<hr/>
       	</div>
	
        <div class="row">
        	<div class="centralize-horizontal container-fluid">
	        	<c:if test="${not empty error}">
					<div class="alert alert-danger"><strong>Atenção!</strong> Ocorreu um erro inesperado ao listar as lojas</div>
				</c:if>
				<c:if test="${empty cardapio}">
					<div class="alert alert-info"><strong>Atenção!</strong> Nenhum registro foi encontrado</div>
				</c:if>
			</div>
			<c:if test="${not empty cardapio}">
				<table class="table table-condensed table-hover table-striped">
					<thead>
						<td>Prato</td>
						<td style="width: 50%">Descrição</td>
						<td>Preço</td>
						<td>Categoria</td>
						<td></td>
					</thead>
					<tbody>
						<c:forEach items="${cardapio}" var="item">
							<tr>
								<td>${item.nm_item}</td>
								<td>${item.ds_item}</td>
								<td><fmt:formatNumber value="${item.vl_preco}" type="currency" currencySymbol="R$" /></td>
								<td>${item.item_categoria.nm_categoria_item}</td>
								<td>
									<a href="/ifood/cardapios?action=update&loja_id=${loja.id_loja}&id=${item.id_item}">
										<span class="fal fa-pencil-alt" data-placement="top" data-toggle="tooltip" title="Atualizar"></span>
									</a> 
									&nbsp;
									<a href="/ifood/cardapios?action=delete&loja_id=${loja.id_loja}&id=${item.id_item}" class="delete">
										<span class="fal fa-trash-alt" data-placement="top" data-toggle="tooltip" title="Remover"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
        </div>
    
    	<div class="row float-right">
	        <a class="btn btn-sm btn-success" href="/ifood/cardapios?action=new&loja_id=${loja.id_loja}">
				<span class="fas fa-plus"></span> &nbsp; <b>Novo Registro</b>
			</a>
		</div>
    </jsp:body>
</t:main>