<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main title="Atualizar Loja">
    <jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js">
		<script src="assets/js/cep.js"></script>
	</jsp:attribute>

    <jsp:body>
    	<div class="row">
       		<h1 class="display-4">Atualizar Loja</h1>
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
        		<input type="hidden" value="update" name="action">
        		<input type="hidden" value="${loja.id_loja}" name="id_loja">
        		<input type="hidden" value="${loja.categoria_loja.id_categoria}" name="id_categoria">
        		<input type="hidden" value="${loja.endereco_loja.id_endereco}" name="id_endereco">
        		<input type="hidden" value="${loja.responsavel_loja.id_responsavel}" name="id_responsavel">

				<!-- Loja -->
        		<t:card width="100%" title="Loja" subtitle="Informações da loja" classes="">
	        		<div class="form-group">
		                <label class="control-label" for="nr_cnpj">CNPJ</label>
		                <input class="form-control" id="nr_cnpj" data-inputmask="'greedy': 'false', 'mask': ['99.999.999/9999-99'], 'placeholder': ''" pattern="^\d{2}\.\d{3}\.\d{3}\/\d{4}-\d{2}$" name="nr_cnpj" required type="text" value="${loja.nr_cnpj}" />
		            </div>
		            
		            <div class="form-group">
		                <label class="control-label" for="nm_razao_social">Razão Social</label>
		                <input class="form-control" id="nm_razao_social" name="nm_razao_social" required type="text" value="${loja.nm_razao_social}" />
		            </div>
		
		            <div class="form-group">
		                <label class="control-label" for="nm_loja">Nome</label>
		                <input class="form-control" id="nm_loja" name="nm_loja" required type="text" value="${loja.nm_loja}" />
		            </div>
		
		            <div class="form-group">
		                <label class="control-label" for="nr_telefone">Telefone</label>
		                <input class="form-control" id="nr_telefone" data-inputmask="'greedy': 'false', 'mask': ['(99) 9999-9999', '(99) 99999-9999'], 'placeholder': ''" pattern="^\(\d\d\) (\d{1})?(\d{4}-\d{4})$" name="nr_telefone" required type="text" value="${loja.nr_telefone}" />
		            </div>
		
		            <div class="form-group">
		                <label class="control-label" for="ds_email">E-mail</label>
		                <input class="form-control" id="ds_email" name="ds_email" autocomplete="off" required type="email" value="${loja.ds_email}" />
		            </div>
		            
		            <div class="form-group">
		                <label class="control-label" for="categoria_loja">Categoria</label>
		                <select class="form-control" id="categoria_loja" name="categoria_loja">
		                	<option>Selecione</option>
		                	<c:forEach items="${categorias}" var="categoria">
								<option ${loja.categoria_loja.id_categoria == categoria.id_categoria ? 'selected="selected"' : ''} value="${categoria.id_categoria}">${categoria.nm_categoria}</option>
		                	</c:forEach>
		                </select>
		            </div>
	           	</t:card>
	           	
	           	<!-- Responsável -->
	            <t:card width="100%" title="Responsável" subtitle="Informações do responsável da loja" classes="mt-5">
        			<jsp:body>
        				<div class="form-group">
			                <label class="control-label" for="nm_responsavel">Nome</label>
			                <input class="form-control" id="nm_responsavel" name="nm_responsavel" required type="text" value="${loja.responsavel_loja.nm_responsavel}" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_cpf">CPF</label>
			                <input class="form-control" id="nr_cpf" data-inputmask="'greedy': 'false', 'mask': ['999.999.999-99'], 'placeholder': ''" pattern="^\d{3}\.\d{3}\.\d{3}-\d{2}$" name="nr_cpf" required type="text" value="${loja.responsavel_loja.nr_cpf}" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_rg">RG</label>
			                <input class="form-control" id="nr_rg" name="nr_rg" maxlength="12" required type="text" value="${loja.responsavel_loja.nr_rg}" />
			            </div>
	           		</jsp:body>
	            </t:card>
		            
	            <!-- Endereço -->
	            <t:card width="100%" title="Endereço" subtitle="Informações do endereço da loja" classes="mt-5">
        			<jsp:body>
		        		<div class="form-group">
			                <label class="control-label" for="nr_cep">CEP</label>
			                <input class="form-control cep" id="nr_cep" data-inputmask="'greedy': 'false', 'mask': ['99999-999'], 'placeholder': ''" pattern="^\d{5}-\d{3}$" name="nr_cep" required type="text" value="${loja.endereco_loja.nr_cep}" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="cd_uf">UF</label>
			                <select class="form-control uf" id="cd_uf" disabled name="cd_uf">
			                	<option ${loja.endereco_loja.cd_uf == 'AC' ? 'selected="selected"' : '' } value="AC">AC</option>
			                	<option ${loja.endereco_loja.cd_uf == 'AL' ? 'selected="selected"' : '' } value="AL">AL</option>
			                	<option ${loja.endereco_loja.cd_uf == 'AP' ? 'selected="selected"' : '' } value="AP">AP</option>
			                	<option ${loja.endereco_loja.cd_uf == 'AM' ? 'selected="selected"' : '' } value="AM">AM</option>
			                	<option ${loja.endereco_loja.cd_uf == 'BA' ? 'selected="selected"' : '' } value="BA">BA</option>
			                	<option ${loja.endereco_loja.cd_uf == 'CE' ? 'selected="selected"' : '' } value="CE">CE</option>
			                	<option ${loja.endereco_loja.cd_uf == 'DF' ? 'selected="selected"' : '' } value="DF">DF</option>
			                	<option ${loja.endereco_loja.cd_uf == 'ES' ? 'selected="selected"' : '' } value="ES">ES</option>
			                	<option ${loja.endereco_loja.cd_uf == 'GO' ? 'selected="selected"' : '' } value="GO">GO</option>
			                	<option ${loja.endereco_loja.cd_uf == 'MA' ? 'selected="selected"' : '' } value="MA">MA</option>
			                	<option ${loja.endereco_loja.cd_uf == 'MT' ? 'selected="selected"' : '' } value="MT">MT</option>
			                	<option ${loja.endereco_loja.cd_uf == 'MS' ? 'selected="selected"' : '' } value="MS">MS</option>
			                	<option ${loja.endereco_loja.cd_uf == 'MG' ? 'selected="selected"' : '' } value="MG">MG</option>
			                	<option ${loja.endereco_loja.cd_uf == 'PA' ? 'selected="selected"' : '' } value="PA">PA</option>
			                	<option ${loja.endereco_loja.cd_uf == 'PB' ? 'selected="selected"' : '' } value="PB">PB</option>
			                	<option ${loja.endereco_loja.cd_uf == 'PR' ? 'selected="selected"' : '' } value="PR">PR</option>
			                	<option ${loja.endereco_loja.cd_uf == 'PE' ? 'selected="selected"' : '' } value="PE">PE</option>
			                	<option ${loja.endereco_loja.cd_uf == 'PI' ? 'selected="selected"' : '' } value="PI">PI</option>
			                	<option ${loja.endereco_loja.cd_uf == 'RJ' ? 'selected="selected"' : '' } value="RJ">RJ</option>
			                	<option ${loja.endereco_loja.cd_uf == 'RN' ? 'selected="selected"' : '' } value="RN">RN</option>
			                	<option ${loja.endereco_loja.cd_uf == 'RS' ? 'selected="selected"' : '' } value="RS">RS</option>
			                	<option ${loja.endereco_loja.cd_uf == 'RO' ? 'selected="selected"' : '' } value="RO">RO</option>
			                	<option ${loja.endereco_loja.cd_uf == 'RR' ? 'selected="selected"' : '' } value="RR">RR</option>
			                	<option ${loja.endereco_loja.cd_uf == 'SC' ? 'selected="selected"' : '' } value="SC">SC</option>
			                	<option ${loja.endereco_loja.cd_uf == 'SP' ? 'selected="selected"' : '' } value="SP">SP</option>
			                	<option ${loja.endereco_loja.cd_uf == 'SE' ? 'selected="selected"' : '' } value="SE">SE</option>
			                	<option ${loja.endereco_loja.cd_uf == 'TO' ? 'selected="selected"' : '' } value="TO">TO</option>
			                </select>
			                <input type="hidden" class="uf" value="${loja.endereco_loja.cd_uf}" maxlength="2" name="cd_uf" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_cidade">Cidade</label>
			                <input class="form-control cidade" id="nm_cidade" readonly="readonly" name="nm_cidade" maxlength="50" required type="text" value="${loja.endereco_loja.nm_cidade}" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_bairro">Bairro</label>
			                <input class="form-control bairro" id="nm_bairro" name="nm_bairro" maxlength="75" required type="text" value="${loja.endereco_loja.nm_bairro}" />
			            </div>
			
			            <div class="form-group">
			                <label class="control-label" for="nm_endereco">Endereço</label>
			                <input class="form-control logradouro" id="nm_endereco" name="nm_endereco" maxlength="100" autocomplete="off" required type="text" value="${loja.endereco_loja.nm_endereco}" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="nr_numero">Número</label>
			                <input class="form-control" id="nr_numero" name="nr_numero" autocomplete="off" required type="text" value="${loja.endereco_loja.nr_numero}" />
			            </div>
			            
			            <div class="form-group">
			                <label class="control-label" for="ds_complemento">Complemento</label>
			                <input class="form-control" id="ds_complemento" name="ds_complemento" maxlength="50" autocomplete="off" type="text" value="${loja.endereco_loja.ds_complemento}" />
			            </div>
	           		</jsp:body>
	            </t:card>

				<div class="pull-right">
					<input class="btn btn-info btn-block centralize-horizontal" type="submit" value="Atualizar" />
				</div>
     	   </form>
    	</div>
    </jsp:body>
</t:main>