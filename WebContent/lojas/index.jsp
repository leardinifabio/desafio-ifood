<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main title="Lojas">
	<jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<script src="assets/js/delete.js"></script>
    </jsp:attribute>
	
    <jsp:body> 
        <div class="row">
       		<h1 class="display-4">Lojas</h1>
       		<hr/>
       	</div>
	
        <div class="row">
        	<div class="centralize-horizontal container-fluid">
	        	<c:if test="${not empty error}">
					<div class="alert alert-danger"><strong>Atenção!</strong> Ocorreu um erro inesperado ao listar as lojas</div>
				</c:if>
				<c:if test="${empty lojas}">
					<div class="alert alert-info"><strong>Atenção!</strong> Nenhum registro foi encontrado</div>
				</c:if>
			</div>
			<c:if test="${not empty lojas}">
				<table class="table table-condensed table-hover table-striped">
					<thead>
						<td>CNPJ</td>
						<td>Razão Social</td>
						<td>Loja</td>
						<td>Telefone</td>
						<td>E-mail</td>
						<td>Categoria</td>
						<td></td>
					</thead>
					<tbody>
						<c:forEach items="${lojas}" var="loja">
							<tr>
								<td>${loja.nr_cnpj}</td>
								<td>${loja.nm_razao_social}</td>
								<td>${loja.nm_loja}</td>
								<td>${loja.nr_telefone}</td>
								<td>${loja.ds_email}</td>
								<td>${loja.categoria_loja.nm_categoria}</td>
								<td>
									<a href="/ifood/lojas?action=update&id=${loja.id_loja}">
										<span class="fal fa-pencil-alt" data-placement="top" data-toggle="tooltip" title="Atualizar"></span>
									</a> 
									&nbsp;
									<a href="/ifood/lojas?action=delete&id=${loja.id_loja}" class="delete">
										<span class="fal fa-trash-alt" data-placement="top" data-toggle="tooltip" title="Remover"></span>
									</a>
									&nbsp;
									<a href="/ifood/cardapios?loja_id=${loja.id_loja}">
										<span class="fal fa-utensils-alt" data-placement="top" data-toggle="tooltip" title="Cardápio"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
        </div>
    
    	<div class="row float-right">
	        <a class="btn btn-sm btn-success" href="/ifood/lojas?action=new">
				<span class="fas fa-plus"></span> &nbsp; <b>Novo Registro</b>
			</a>
		</div>
    </jsp:body>
</t:main>