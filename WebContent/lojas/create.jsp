<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main title="Cadastrar Loja">
    <jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<script src="assets/js/cep.js"></script>
	</jsp:attribute>

    <jsp:body>
    	<div class="row">
       		<h1 class="display-4">Cadastrar Lojas</h1>
       		<hr/>
       	</div>
       	
       	<div class="centralize-horizontal container-fluid">
	   		<c:if test="${not empty success}">
				<div class="alert alert-success">${success}</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>

        	<form action="/ifood/lojas" method="post">
        		<input type="hidden" value="create" name="action" />

				<!-- Loja -->
        		<t:card width="100%" title="Loja" subtitle="Informações da loja" classes="">
        			<jsp:body>
		        		<div class="form-group">
			                <label class="control-label" for="nr_cnpj">CNPJ</label>
			                <input class="form-control" id="nr_cnpj" data-inputmask="'greedy': 'false', 'mask': ['99.999.999/9999-99'], 'placeholder': ''" pattern="^\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}$" name="nr_cnpj" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nm_razao_social">Razão Social</label>
			                <input class="form-control" id="nm_razao_social" name="nm_razao_social" required type="text" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_loja">Nome</label>
			                <input class="form-control" id="nm_loja" name="nm_loja" required type="text" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nr_telefone">Telefone</label>
			                <input class="form-control" id="nr_telefone" data-inputmask="'greedy': 'false', 'mask': ['(99) 9999-9999', '(99) 99999-9999'], 'placeholder': ''" pattern="^\(\d\d\) (\d{1})?(\d{4}-\d{4})$" name="nr_telefone" required type="text" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="ds_email">E-mail</label>
			                <input class="form-control" id="ds_email" name="ds_email" autocomplete="off" required type="email" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="categoria_loja">Categoria</label>
			                <select class="form-control" id="categoria_loja" name="categoria_loja">
			                	<option>Selecione</option>
			                	<c:forEach items="${categorias}" var="categoria">
									<option value="${categoria.id_categoria}">${categoria.nm_categoria}</option>
			                	</c:forEach>
			                </select>
			            </div>
	           		</jsp:body>
	            </t:card>
	            
	            <!-- Responsável -->
	            <t:card width="100%" title="Responsável" subtitle="Informações do responsável da loja" classes="mt-5">
        			<jsp:body>
        				<div class="form-group">
			                <label class="control-label" for="nm_responsavel">Nome</label>
			                <input class="form-control" id="nm_responsavel" name="nm_responsavel" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_cpf">CPF</label>
			                <input class="form-control" id="nr_cpf" data-inputmask="'greedy': 'false', 'mask': ['999.999.999-99'], 'placeholder': ''" pattern="^\d{3}\.\d{3}\.\d{3}-\d{2}$" name="nr_cpf" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_rg">RG</label>
			                <input class="form-control" id="nr_rg" name="nr_rg" maxlength="12" required type="text" />
			            </div>
	           		</jsp:body>
	            </t:card>
		            
	            <!-- Endereço -->
	            <t:card width="100%" title="Endereço" subtitle="Informações do endereço da loja" classes="mt-5">
        			<jsp:body>
		        		<div class="form-group">
			                <label class="control-label" for="nr_cep">CEP</label>
			                <input class="form-control cep" id="nr_cep" data-inputmask="'greedy': 'false', 'mask': ['99999-999'], 'placeholder': ''" pattern="^\d{5}-\d{3}$" name="nr_cep" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="cd_uf">UF</label>
			                <select class="form-control uf" id="cd_uf" disabled name="cd_uf">
			                	<option value="AC">AC</option>
			                	<option value="AL">AL</option>
			                	<option value="AP">AP</option>
			                	<option value="AM">AM</option>
			                	<option value="BA">BA</option>
			                	<option value="CE">CE</option>
			                	<option value="DF">DF</option>
			                	<option value="ES">ES</option>
			                	<option value="GO">GO</option>
			                	<option value="MA">MA</option>
			                	<option value="MT">MT</option>
			                	<option value="MS">MS</option>
			                	<option value="MG">MG</option>
			                	<option value="PA">PA</option>
			                	<option value="PB">PB</option>
			                	<option value="PR">PR</option>
			                	<option value="PE">PE</option>
			                	<option value="PI">PI</option>
			                	<option value="RJ">RJ</option>
			                	<option value="RN">RN</option>
			                	<option value="RS">RS</option>
			                	<option value="RO">RO</option>
			                	<option value="RR">RR</option>
			                	<option value="SC">SC</option>
			                	<option value="SP">SP</option>
			                	<option value="SE">SE</option>
			                	<option value="TO">TO</option>
			                </select>
			                <input type="hidden" class="uf" value="" maxlength="2" name="cd_uf" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_cidade">Cidade</label>
			                <input class="form-control cidade" id="nm_cidade" readonly="readonly" name="nm_cidade" maxlength="50" required type="text" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_bairro">Bairro</label>
			                <input class="form-control bairro" id="nm_bairro" name="nm_bairro" maxlength="75" required type="text" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_endereco">Endereço</label>
			                <input class="form-control logradouro" id="nm_endereco" name="nm_endereco" maxlength="100" autocomplete="off" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_numero">Número</label>
			                <input class="form-control" id="nr_numero" name="nr_numero" autocomplete="off" required type="text" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="ds_complemento">Complemento</label>
			                <input class="form-control" id="ds_complemento" name="ds_complemento" maxlength="50" autocomplete="off" type="text" />
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