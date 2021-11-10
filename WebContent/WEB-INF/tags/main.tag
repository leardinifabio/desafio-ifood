<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
<%@attribute name="css" fragment="true" %>
<%@attribute name="js" fragment="true" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="pt-br" class="fontawesome-i2svg-active fontawesome-i2svg-complete">
    <head>
		<!-- TITLE -->
		<title>${title}</title>
	
		<!-- META TAGS -->
		<meta charset="utf-8" />
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-title" content="Full Screen">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui">
	
		<meta content="Chip Xavier" name="author" />
		<meta content="Chip Xavier. 2021" name="copyright" />
		<meta content="nofollow, noindex" name="robots" />
		
		<!-- CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="assets/plugins/fontawesome/fontawesome.min.css" type="text/css">
	    <link rel="stylesheet" href="assets/css/custom.css" type="text/css">
		<jsp:invoke fragment="css"/>
	</head>

    <body>  
    	<t:header active="${title}"></t:header>     	
        <main class="container-fluid" role="main">
        	<div class="mx-auto">
        		<jsp:doBody/>
        	</div>
        </main>
        <t:footer></t:footer>
       	
       	<!-- JS -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="assets/plugins/fontawesome/fontawesome.min.js"></script>
		<script src="assets/plugins/inputmask.bundle.min.js"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="assets/js/index.js"></script>
		<jsp:invoke fragment="js"/>	
    </body>
</html>