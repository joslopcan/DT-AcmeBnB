<%--
* action-1.jsp
*
* Copyright (C) 2013 Universidad de Sevilla
* 
* The use of this project is hereby constrained to the conditions of the 
* TDG Licence, a copy of which you may download from 
* http://www.tdg-seville.info/License.html
--%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="tenant/edit.do" modelAttribute="tenantRegisterForm">

	<acme:textbox code="tenant.userName" path="userName" />
	<acme:password code="tenant.password" path="password" />
	<acme:textbox code="tenant.name" path="name" />
	<acme:textbox code="tenant.surname" path="surname" />
	<acme:textbox code="tenant.email" path="email" />
	<acme:textbox code="tenant.phone" path="phone" />
	<acme:textbox code="tenant.picture" path="picture" />
	<br/><br/>
	<spring:message code="tenant.finderInformation" />
	<acme:textbox code="tenant.finder.destinationCity" path="destinationCity" />
	<acme:textbox code="tenant.finder.minimumPrice" path="minimumPrice" />
	<acme:textbox code="tenant.finder.maximumPrice" path="maximumPrice" />
	<acme:textbox code="tenant.finder.keyword" path="keyword" />
	
	
	<div>
        <input type="checkbox" name="check id="check"> <label for="check">Acepto los terminos y condiciones</label>
    </div>	
	<jstl:if test="${tenantRegisterForm.userName == null}">
		<input type="submit" name="save"
			value="<spring:message code="tenant.create" />"
			onclick="return confirm('<spring:message code="tenant.confirm.create" />')" />&nbsp;
</jstl:if>
	<jstl:if test="${tenantRegisterForm.userName != null}">
			<input type="submit" name="save"
				value="<spring:message code="tenant.save" />" />
			<input type="submit" name="delete"
			value="<spring:message code="tenant.delete" />"
			onclick="return confirm('<spring:message code="tenant.confirm.delete" />')" />&nbsp;
	</jstl:if>
<script>
    var checkboxes = $("input[type='checkbox']"),
    submitButt = $("input[type='submit']");

checkboxes.click(function() {
    submitButt.attr("disabled", !checkboxes.is(":checked"));
});
</script>
	
</form:form>