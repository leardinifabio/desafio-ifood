<%@tag description="Card template" pageEncoding="UTF-8" %>
<%@attribute name="width" required="true" %>
<%@attribute name="classes" required="true" %>
<%@attribute name="title" required="true" %>
<%@attribute name="subtitle" required="true" %>

<div class="card ${classes}" style="width: ${width};">
	<div class="card-body">
		<h5 class="card-title">${title}</h5>
		<h6 class="card-subtitle mb-2 text-muted">${subtitle}</h6>
		<jsp:doBody/>
	</div>
</div>