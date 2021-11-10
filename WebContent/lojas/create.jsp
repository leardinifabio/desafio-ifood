<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main title="Cadastrar Loja">
    <jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js"></jsp:attribute>

    <jsp:body>
        <main class="main main-raised" role="main">
			<div class="content">
				<div class="centralize-horizontal container-fluid">
                	<h2 class="text-center">Create</h2>
                    <hr />

                    <form action="/Soften/emp" method="post">
                        <div class="form-group label-floating is-empty">
                            <label class="control-label" for="name">Name</label>
                            <input class="form-control" id="name" name="name" required type="text" />
                        </div>

                        <div class="form-group label-floating is-empty">
                            <label class="control-label" for="cpf">CPF</label>
                            <input class="form-control" id="cpf" data-inputmask="'greedy': 'false', 'mask': ['999.999.999-99'], 'placeholder': ''" pattern="^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$" name="cpf" required type="text" />
                        </div>

                        <div class="form-group label-floating is-empty">
                            <label class="control-label" for="office">Office</label>
                            <input class="form-control" id="office" name="office" required type="text" />
                        </div>

                        <div class="form-group label-floating is-empty">
                            <label class="control-label" for="company">Company</label>
                            <input class="form-control" id="company" name="company" required type="text" />
                        </div>

                        <div class="form-group label-floating is-empty">
                            <label class="control-label" for="email">E-mail</label>
                            <input class="form-control" id="email" name="email" autocomplete="off" required type="email" />
                        </div>

                        <input type="hidden" value="new" name="action">		
    
    					<div class="pull-right">
							<input class="btn btn-info btn-block centralize-horizontal" type="submit" value="Criar" />
						</div>
                    </form>
                </div>
			</div>
        </main>
    </jsp:body>
</t:main>