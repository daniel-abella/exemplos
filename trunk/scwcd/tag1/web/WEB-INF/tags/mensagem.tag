<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="formato"%>
<%@ tag body-content="scriptless"%>

<%-- any content can be specified here e.g.: --%>
<h1>Mensagem</h1>

<c:choose>
<c:when test="${formato == 'italico'}">
    <i><jsp:doBody/></i>
</c:when>
<c:when test="${formato == 'negrito'}">
    <b><jsp:doBody/></b>
</c:when>
<c:otherwise>
    <jsp:doBody/>
</c:otherwise>
</c:choose>
