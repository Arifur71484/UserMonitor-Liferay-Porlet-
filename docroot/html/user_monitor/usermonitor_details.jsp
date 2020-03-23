<%@ include file="/html/init/init.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@page
	import="it.laitspa.usermonitor.service.user_monitorLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="com.liferay.portal.model.User"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="it.laitspa.usermonitor.service.user_monitorLocalServiceUtil"%>
<%@page import="it.laitspa.usermonitor.model.user_monitor"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>


<%
	Calendar today = Calendar.getInstance();
	//today.set(Calendar.YEAR, 1997);
	String redirect = ParamUtil.getString(request, "backURL");
	long recordId = ParamUtil.getLong(request, "recordId");
	String userName = ParamUtil.getString(request, "userName");
	// Date startdate = ParamUtil.getDate( request ,  "dobDateS" ) ;
	user_monitor user_monitor = user_monitorLocalServiceUtil.getuser_monitor(recordId);
	request.setAttribute("user_monitor", user_monitor);
	int loginTimes = user_monitorLocalServiceUtil.getCountByTypeAccess("LOGIN",
			Long.toString(user_monitor.getUserMonitorId()));
	int logoutTimes = user_monitorLocalServiceUtil.getCountByTypeAccess("LOGOUT",
			Long.toString(user_monitor.getUserMonitorId()));
%>

<button style="float: right;" onclick="location.href='<%=redirect%>'"
	type="button">Back</button>
	
	 <portlet:resourceURL var="updateURL"  id="updateURL" >
	      <portlet:param name="totallastday" value="totallastday"/>
	      <portlet:param name="totalstartday" value="totalstartday"/>
     </portlet:resourceURL> 
     
	
	  <!--  dateFunction() for calculating total login and logout    -->   
  
  
 <script type="test/javascript">

    function dateFunction() {
     
	var totallastday = document.getElementById("'<portlet:namespace/>'dobDateS")  ;
	var totalstartday = document.getElementById("'<portlet:namespace/>'dobDateL");
     
        AUI().use('aui-io-request', function(A){
        A.io.request('${updateURL}', {
    dataType: 'json',
    method: 'POST',
    data: {
        <portlet:namespace/>totallastday: totallastday,
        <portlet:namespace/>totalstartday: totalstartday,
     
    },
    on: {
         success: function() { 

            var data=this.get('responseData');
                // Actions to be performed on success
                var dataReceivedSuccess = data.dataReceivedMessage;
                var totallogin = data.totallogin;
                var totallogout = data.totallogout;
          }
        }

        });
      }
	}
  
</script>
            

	<liferay-ui:tabs names="DETTAGLI UTENTE, STATISTICHE" refresh="false"
		tabsValues="DETTAGLI UTENTE,STATISTICHE">
		<!--  this tab1 is for user details info   -->
		
	
       <aui:row>	
	        
	  		<liferay-ui:section>

		      <aui:container>
			     <aui:row>
				   <aui:col span="12">
					<h2 style="text-align: center;">  Informazioni sul client Monitor utente  </h2>
					<aui:input label="Client ID:" name="recordId" type="text"
						readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.userName}" type="text" readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.userSurname}" type="text" readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.remoteIp}" type="text" readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.dataLogin}" type="text" readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.typeAccess}" type="text" readonly="true" />
					<aui:input label="Client userName:" name=" userName"
						value="${user_monitor.userRealName}" type="text" readonly="true" />
				  </aui:col>
		      	</aui:row>
		     </aui:container>

			</liferay-ui:section>
	 
       
	    	<liferay-ui:section>
         
		   <aui:container>
			  <aui:row>
				<aui:col span="6">
				  	<aui:row>
				  	 
				  	<!--   Row For pie chart -->
						<h3>Pie Chart</h3>
						<h5> TOTALE Accessi : <%=loginTimes%> </h5>
						<h5> TOTALE Disconnessioni : <%=logoutTimes%>  </h5>
					</aui:row>
					<aui:row>
			    
                    <button class="btn btn-outline-primary"  onclick="pdf()">Salva come PDF</button>
                    <button  class="btn btn-outline-primary" onclick="jpg()">Salva come JPG</button>
                    
                    <!-- PIE CHART For USER ACTIVITY  -->
              
                   <div id="chart5" style="width: 450px; height: 450px  ; float:left"></div>

                    <script type="text/javascript">
                    
                    var chart = c3.generate({
                    	  bindto: '#chart5',
                    	  
                    	    data: {
                    	        columns: [
                    	            ['Login', <%=loginTimes%>],
                    	            ['Logout', <%=logoutTimes%>],
                    	        ],
                    	        type : 'donut'
                    	    },
                    	    donut: {
                    	        title: "ATTIVITÀ DELL'UTENTE",
                    	    }
                    	});
                     
                     </script>
                           
  	                 </aui:row>
  	                 
				     </aui:col>
				      <aui:col span="6">
					<aui:row>
						<h3>Line Chart</h3>
						<h5> TOTALE Accessi : <%=loginTimes%> </h5>
						<h5> TOTALE Disconnessioni : <%=logoutTimes%>  </h5>
					</aui:row>
					<aui:row>
						<aui:row>
							<aui:form action="#" onSubmit="javascript:dateFunction()">
								<aui:row>
									<aui:col span="2">
										<h4>Dal:</h4>
									</aui:col>
									<aui:col span="4">
									  <liferay-ui:input-date name="dobDateS"
								 
											dayValue="<%= today.get(Calendar.DAY_OF_MONTH) %>"
											dayParam="dobDayS"
											monthValue="<%= today.get(Calendar.MONTH) %>"
											monthParam="dobMonthS"
											yearValue="<%= today.get(Calendar.YEAR) %>"
											yearParam="dobYearS" />
							  		</aui:col>
									<aui:col span="2">
										<h4>al:</h4>
									</aui:col>
									<aui:col span="4">
					-                  <liferay-ui:input-date name="dobDateL"
											dayValue="<%= today.get( Calendar.DAY_OF_MONTH) %>"
											dayParam="dobDayL"
											monthValue="<%= today.get(Calendar.MONTH) %>"
											monthParam="dobMonthL"
											yearValue="<%= today.get(Calendar.YEAR) %>"
											yearParam="dobYearL" />
						 	 
									</aui:col>
								</aui:row>
								<aui:button type="submit" primary="true" name="filtra"  onclick="dateFunction()"
									value="Filtra">
									
								</aui:button> 
						 
							</aui:form>
						</aui:row>
						<aui:row>
						
						<!-- LINE CHART For USER ACTIVITY  -->
						
						  <div id="chart1" style="height: 370px; width: 100%;"></div>
		                
		              <script>
 						 var chart = c3.generate({
		                  bindto: '#chart1',
		                  data: {
		                      columns: [
		                       
		                          ['ATTIVITÀ DEL CLIENTE DELL UTENTE', <%=loginTimes%>, <%=logoutTimes%>, 140, 200, 150, 50]
		                      ],
		                    
		                  },
		                  
		                  axis: {
		                    x: {
		              type: 'category',
		              categories:["mar-2019" , "April-2019","May-2019","June-2019","July-2019","August-2019","September-2019","October-2019"],
		                tick: {
		                  rotate: 30,
		                  format: '%b%Y'
		                }
		              }
		            }
		              });
                      </script>
                      
                     </aui:row>
					</aui:row>
 		
				</aui:col>
			</aui:row>
			 
		
			
			<aui:row>
			
			 <aui:col span="2" cssClass="">
			    
			</aui:col>
			
			<aui:col span="2">
			 
			</aui:col>
			
			<aui:col span="2">
		 
			</aui:col>
				 <aui:col span="2">
			   <aui:row>
			   
			    			<!-- SMALL LINE CHART For USER ACTIVITY  -->
			   
			    <div class="chart2"  id="chart2" style="display: inline-block;"></div>
    
               <script>
               var chart = c3.generate({
	                  bindto: '#chart2',
	                  data: {
	                      columns: [
	                   
	                          ['LOGIN', 130, 100, <%=loginTimes%>, 200, 150, 50]
	                      ],
	                      types: {
	               
	                          LOGIN: 'area'
	                      },
	                       colors: {
	                     
	                         LOGIN: 'red'
	                       }
	                  }
	              });
    	     </script>
           </aui:row>
			</aui:col>
			 <aui:col span="2" >
			   <aui:row>
			   
			   <!-- SMALL LINE CHART For USER ACTIVITY  -->
			   
			   <div class="chart3" id="chart3" style=" display: inline-block;"></div>
                <script>
           
                
                var chart = c3.generate({
	                  bindto: '#chart3',
	                  data: {
	                      columns: [
	                   
	                          ['LOGOUT', 130, 100, <%=logoutTimes%>, 200, 150, 50]
	                      ],
	                      types: {
	               
	                          LOGOUT: 'area'
	                      },
	                       colors: {
	                     
	                         LOGOUT: 'Maroon'
	                       }
	                  }
	              });
    
             </script>
			   </aui:row>
			   
			 </aui:col>
		   <aui:col span="2">
		   
		   	  	   <aui:row>
			   
			   <!-- SMALL LINE CHART For USER ACTIVITY  -->
			   
			   <div class="chart6" id="chart6" style=" display: inline-block;"></div>
                <script>
           
                
                var chart = c3.generate({
	                  bindto: '#chart6',
	                  data: {
	                      columns: [
	                   
	                          ['OTHERS', 130, 100, 140, 200, 150, 50]
	                      ],
	                      types: {
	               
	                    	  OTHERS: 'area'
	                      },
	                       colors: {
	                     
	                    	   OTHERS: 'yellow'
	                       }
	                  }
	              });
    
             </script>
			   </aui:row>
			</aui:col>
		   
			</aui:row>	
								
        	</aui:container>

			</liferay-ui:section>	
		 
			
			</aui:row>	
	   
	</liferay-ui:tabs>
	







