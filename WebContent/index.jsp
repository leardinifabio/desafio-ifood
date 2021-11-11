<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main title="Dashboard">
	<jsp:attribute name="css"></jsp:attribute>
	<jsp:attribute name="js"></jsp:attribute>
	
    <jsp:body>
    	<div class="row">
       		<h1 class="display-4">Dashboard</h1>
       		<hr/>
       	</div>
    	
    	<div class="row mb-3">
            <div class="col-xl-3 col-sm-6 py-2">
                <div class="card bg-success text-white h-100 card-info">
                    <div class="card-body bg-success">
                        <div class="rotate">
                            <i class="fa fa-home-heart fa-4x"></i>
                        </div>
                        <h6 class="text-uppercase">Restaurantes com licença</h6>
                        <h1 class="display-4">3</h1>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 py-2">
                <div class="card text-white bg-danger h-100 card-info">
                    <div class="card-body bg-danger">
                        <div class="rotate">
                            <i class="fa fa-clock fa-4x"></i>
                        </div>
                        <h6 class="text-uppercase">Tempo médio de preparo</h6>
                        <h1 class="display-4">45min</h1>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 py-2">
                <div class="card text-white bg-info h-100 card-info">
                    <div class="card-body bg-info">
                        <div class="rotate">
                            <i class="fa fa-money-bill-wave fa-4x"></i>
                        </div>
                        <h6 class="text-uppercase">Média de preço da região</h6>
                        <h1 class="display-4">R$50,00</h1>
                    </div>
                </div>
            </div>
            <div class="col-xl-3 col-sm-6 py-2">
                <div class="card text-white bg-warning h-100 card-info">
                    <div class="card-body">
                        <div class="rotate">
                            <i class="fa fa-stars fa-4x"></i>
                        </div>
                        <h6 class="text-uppercase">Média de avaliação</h6>
                        <h1 class="display-4">4,2</h1>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:main>