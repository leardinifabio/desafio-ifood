<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" %>
<%@attribute name="css" fragment="true" %>
<%@attribute name="js" fragment="true" %>

<html lang="en" class="fontawesome-i2svg-active fontawesome-i2svg-complete">
    <head>
		<!-- TITLE -->
		<title>${title}</title>
	
		<!-- META TAGS -->
		<meta charset="utf-8" />
	
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-title" content="Full Screen">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, minimal-ui">
	
		<meta content="Chip Xavier" name="author" />
		<meta content="Chip Xavier. 2021" name="copyright" />
		<meta content="nofollow, noindex" name="robots" />
	
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta charset="ISO-8859-1">
		
		<!-- CSS -->
		<link rel="stylesheet" href="assets/plugins/fontawesome/fontawesome.min.css">
		<link rel="stylesheet" href="assets/css/normalize.css">
	    <link rel="stylesheet" href="assets/css/style.css">
	    <link rel="preconnect" href="https://fonts.googleapis.com">
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;500&display=swap" rel="stylesheet">		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<jsp:invoke fragment="css"/>
	</head>
    <body class="main-page">
		<span class="loading">Loading...</span>
		
        <div id="pageheader">
            <t:header></t:header>
        </div>
        <div id="body">
            <jsp:doBody/>
        </div>
        <div id="pagefooter">
            <t:footer></t:footer>
        </div>
    </body>
</html>

<!-- JS -->
<script src="assets/plugins/fontawesome/fontawesome.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js" integrity="sha512-AA1Bzp5Q0K1KanKKmvN/4d3IRKVlv9PYgwFPvm32nPO6QS8yH1HO7LbgB1pgiOxPtfeg5zEn2ba64MUcqJx6CA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="assets/plugins/notify.min.js"></script>
<script src="assets/js/index.js"></script>
<jsp:invoke fragment="js"/>