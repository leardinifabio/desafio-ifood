<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main title="Cadastrar Item">
    <jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<script src="assets/js/cep.js"></script>
	</jsp:attribute>

    <jsp:body>
    	<div class="row">
       		<h1 class="display-4">Cadastrar Item</h1>
       		<hr/>
       	</div>
       	
       	<div class="centralize-horizontal container-fluid">
	   		<c:if test="${not empty success}">
				<div class="alert alert-success">${success}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>

        	<form action="/ifood/cardapios" method="post">
        		<input type="hidden" value="create" name="action" />
        		<input type="hidden" value="${loja.id_loja}" name="loja_id" />

				<!-- Item -->
	            <t:card width="100%" title="Item" subtitle="Informações do item do cardápio" classes="mt-5">
        			<jsp:body>
        				<div class="form-group">
			                <label class="control-label" for="nm_item">Nome</label>
			                <input class="form-control" id="nm_item" name="nm_item" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="ds_item">Descrição</label>
			                <textarea class="form-control" id="ds_item" name="ds_item" required maxlength="250"></textarea>
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="vl_preco">Preço</label>
			                <input class="form-control" id="vl_preco" data-inputmask="'alias': 'currency', 'groupSeparator': '.', 'autoGroup': true, 'digits': '2', 'greedy': 'false', 'placeholder': '0,00', 'radixPoint': ','" pattern="^\s*(?:[1-9]\d{0,2}(?:\.\d{3})*|0)(?:,\d{1,2})?$" name="vl_preco" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="item_categoria">Categoria</label>
			                <select class="form-control" id="item_categoria" name="item_categoria">
			                	<option>Selecione</option>
			                	<c:forEach items="${categorias}" var="categoria">
									<option value="${categoria.id_categoria_item}">${categoria.nm_categoria_item}</option>
			                	</c:forEach>
			                </select>
			            </div>
	           		</jsp:body>
	            </t:card>

				<div class="mt-4">
					<input class="btn btn-info btn-block centralize-horizontal" type="submit" value="Criar" />
				</div>
     	   </form>
    	</div>
    </jsp:body>
</t:main>