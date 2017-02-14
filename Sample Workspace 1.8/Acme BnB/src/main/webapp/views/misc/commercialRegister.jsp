<%--
 * index.jsp
 *
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<font size=5><spring:message code="commercialRegister.company" /></font><br/>
<spring:message code="commercialRegister.name" /><br/>
<spring:message code="commercialRegister.domicilio" /><br/>
<spring:message code="commercialRegister.cif" /><br/>
<spring:message code="commercialRegister.phone" /><br/>
<spring:message code="commercialRegister.email" /><br/>
