<%@tag description="Header Page template" pageEncoding="UTF-8" %>
<%@attribute name="active" required="true" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">iFood</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	  <span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item ${active == 'Dashboard' ? 'active' : ''}">
				<a class="nav-link" href="/ifood/">Dashboard</a>
			</li>
			<li class="nav-item ${active == 'Lojas' ? 'active' : ''}">
				<a class="nav-link" href="/ifood/lojas">Lojas</a>
			</li>
		</ul>
	</div>
</nav>