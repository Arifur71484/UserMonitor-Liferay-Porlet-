 <%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="it.laitspa.usermonitor.model.user_monitor"%>
<%@page import="it.latispa.usermonitor.search.UsermonitorSearchcontainer" %>
<%@page import="it.latispa.usermonitor.search.UsermonitorDisplayterms" %>
<%@ include file="/html/init/init.jsp"%>
<%@page import="it.latispa.usermonitor.search.UsermonitorHelper" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ActionRequest" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@page import="it.laitspa.usermonitor.service.user_monitorLocalServiceUtil"%>

<!--  main view for the table which brings the data from database table -->

<%
     String currentURL = PortalUtil.getCurrentURL(request);
	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	UsermonitorSearchcontainer UsermonitorSearchcontainer = new UsermonitorSearchcontainer(renderRequest, portletURL);
	UsermonitorDisplayterms displayTerms = (UsermonitorDisplayterms)UsermonitorSearchcontainer.getDisplayTerms();
	List<user_monitor> list =user_monitorLocalServiceUtil.getuser_monitors(0, user_monitorLocalServiceUtil.getuser_monitorsCount());
	String redirect = ParamUtil.getString(request, "backURL");
	
%>

<button style="float : right ;" onclick="location.href='<%= redirect %>'" type="button">
         Reload </button>
         
<aui:form action="<%= portletURLString %>" method="post" name="fm">

<liferay-ui:search-container  searchContainer="<%= UsermonitorSearchcontainer %>">

<liferay-ui:search-form page="/html/search_util/search_toggle.jsp" servletContext="<%= application %>" />
	
	<liferay-ui:search-container-results
	     results="<%= UsermonitorHelper.getUser_monitors(displayTerms,UsermonitorSearchcontainer.getStart(), UsermonitorSearchcontainer.getEnd()) %>" 
         total="<%= UsermonitorHelper.getTotalusermonitorCount(displayTerms,UsermonitorSearchcontainer.getStart(), UsermonitorSearchcontainer.getEnd()) %>"
	   />

 <liferay-ui:search-container-row
		className="it.laitspa.usermonitor.model.user_monitor"
		modelVar="auser_monitor"
		>
                
       <portlet:renderURL var="searchURL">
           <portlet:param name="recordId"  value="${auser_monitor.recordId}" />
           <portlet:param name="backURL" value="<%=currentURL%>"/>
           <portlet:param name="mvcPath" value="/html/user_monitor/usermonitor_details.jsp" />
        </portlet:renderURL>
          
             <portlet:renderURL var="searchURLS">
           <portlet:param name="recordId"  value="${auser_monitor.recordId}" />
           <portlet:param name="mvcPath" value="/html/user_monitor/Statistiche.jsp" />
        </portlet:renderURL>
        
           <portlet:renderURL var="searchURLD">
           <portlet:param name="recordId"  value="${auser_monitor.recordId}" />
           <portlet:param name="mvcPath" value="/html/user_monitor/Dettagliutente.jsp" />
        </portlet:renderURL>
          
        <liferay-ui:search-container-column-text property="emailAddress" />

		<liferay-ui:search-container-column-text property="dataLogin" />

		<liferay-ui:search-container-column-text property="userSurname" />

		<liferay-ui:search-container-column-text property="userRealName" />

		<liferay-ui:search-container-column-text property="userName" />

		<liferay-ui:search-container-column-text property="typeAccess" />

		<liferay-ui:search-container-column-text property="remoteIp" />

		<liferay-ui:search-container-column-text property="recordId" />
		
       <liferay-ui:search-container-column-text  name ="Details" value ="Click Here" href="${searchURL}"/>
       
       <liferay-ui:search-container-column-text property="UserMonitorId"/>
       
      <liferay-ui:search-container-column-text property="DATE" />
      
  </liferay-ui:search-container-row>

<liferay-ui:search-iterator />
</liferay-ui:search-container>
</aui:form>