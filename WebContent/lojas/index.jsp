<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="../WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:main title="Index">
	<jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<!-- <script src="assets/js/delete.js"></script>  -->
    </jsp:attribute>
	
    <jsp:body>
	    <div class="wrapper"> 
	        <div class="header header-filter"></div>
	
	        <main class="main main-raised" role="main">
				<div class="content">
					<div class="centralize-horizontal container-fluid">
	                	<h2 class="text-center">Index</h2>
	                    <hr />
	                    
						<div class="table-responsive">
							<c:if test="${empty lojas}">
								<div class="alert alert-danger"><strong>Atenção!</strong> Nenhum registro foi encontrado</div>
							</c:if>
							<c:if test="${not empty lojas}">
								<table class="table table-condensed table-hover table-striped">
									<thead class="">
										<td>Name</td>
										<td>CPF</td>
										<td>Office</td>
										<td>Company</td>
										<td>E-mail</td>
										<td></td>
									</thead>
									<tbody>
										<t:forEach items="${lojas}" var="emp">
											<tr>
												<td>${emp.name}</td>
												<td>${emp.cpf}</td>
												<td>${emp.office}</td>
												<td>${emp.company}</td>
												<td>${emp.email}</td>
												<td>
													<a href="/iFood/lojas?action=update&id=${emp.id}">
														<span class="glyphicon glyphicon-pencil" data-placement="top" data-toggle="tooltip" title="Atualizar">
													</a> 
													&nbsp;
													<a class="delete" href="/iFood/loja?action=delete&id=${emp.id}">
														<span class="glyphicon glyphicon-remove" data-placement="top" data-toggle="tooltip" title="Remover">
													</a>
												</td>
											</tr>
										</t:forEach>
									</tbody>
								</table>
							</c:if>
						</div>
	
						<a class="btn btn-sm btn-success" href="/iFood/lojas?action=new">
							<span class="glyphicon glyphicon-plus-sign"></span> &nbsp; <b>Novo Registro</b>
						</a>
	                </div>
				</div>
	        </main>
		</div>
    </jsp:body>
</t:main>