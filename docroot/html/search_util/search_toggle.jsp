
<%@page import="it.latispa.usermonitor.search.UsermonitorSearchcontainer" %>
<%@page import="it.latispa.usermonitor.search.UsermonitorDisplayterms" %>
 
<%@ include file="/html/init/init.jsp"%>
<!--  the search button is initialize here  -->
<%
UsermonitorSearchcontainer searchContainer = (UsermonitorSearchcontainer)request.getAttribute("liferay-ui:search:searchContainer");
UsermonitorDisplayterms displayTerms = (UsermonitorDisplayterms)searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle buttonLabel="Cerca" displayTerms="<%= displayTerms %>" id="toggle_id_user_monitor_search">
<aui:input label="EmailAddress" name="emailAddress" value="<%=displayTerms.getemail()%>" />

<aui:input type="radio" name="user-search-radio" value="emailAddress" label="emailAddress" checked="true" />
<aui:input type="radio" name="user-search-radio" value="NomeUtenti" label="NomeUtenti" />
<aui:input type="radio" name="user-search-radio" value="tutti" label="tutti" />
</liferay-ui:search-toggle>