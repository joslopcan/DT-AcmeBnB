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

<form:form action="lessor/edit.do" modelAttribute="lessorRegisterForm">

	<acme:textbox code="lessor.userName" path="userName" />
	<acme:password code="lessor.password" path="password" />
	<acme:textbox code="lessor.name" path="name" />
	<acme:textbox code="lessor.surname" path="surname" />
	<acme:textbox code="lessor.email" path="email" />
	<acme:textbox code="lessor.phone" path="phone" />
	<acme:textbox code="lessor.picture" path="picture" />
	
	
	<div>
        <input type="checkbox" name="check id="check"> <label for="check">Acepto los terminos y condiciones</label>
    </div>	
	<jstl:if test="${lessorRegisterForm.userName == null}">
		<input type="submit" name="save"
			value="<spring:message code="lessor.create" />"
			onclick="return confirm('<spring:message code="lessor.confirm.create" />')" />&nbsp;
</jstl:if>
	<jstl:if test="${lessorRegisterForm.userName != null}">
			<input type="submit" name="save"
				value="<spring:message code="lessor.save" />" />
			<input type="submit" name="delete"
			value="<spring:message code="lessor.delete" />"
			onclick="return confirm('<spring:message code="lessor.confirm.delete" />')" />&nbsp;
	</jstl:if>
<script>
    var checkboxes = $("input[type='checkbox']"),
    submitButt = $("input[type='submit']");

checkboxes.click(function() {
    submitButt.attr("disabled", !checkboxes.is(":checked"));
});
</script>
	
</form:form>