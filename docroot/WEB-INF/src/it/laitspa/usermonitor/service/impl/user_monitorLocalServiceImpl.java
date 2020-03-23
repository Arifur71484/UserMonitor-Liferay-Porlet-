/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.laitspa.usermonitor.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.RequestDispatcher;

import it.laitspa.usermonitor.model.user_monitor;
import it.laitspa.usermonitor.service.user_monitorLocalServiceUtil;
import it.laitspa.usermonitor.service.base.user_monitorLocalServiceBaseImpl;
import it.laitspa.usermonitor.service.persistence.user_monitorUtil;
import java.util.logging.Logger;

/**
 * The implementation of the user_monitor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.laitspa.usermonitor.service.user_monitorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.laitspa.usermonitor.service.base.user_monitorLocalServiceBaseImpl
 * @see it.laitspa.usermonitor.service.user_monitorLocalServiceUtil
 */
public class user_monitorLocalServiceImpl
	extends user_monitorLocalServiceBaseImpl {


   public int getCountByTypeAccess(String typeAccess,String userID) throws SystemException {
	   List<user_monitor> user = user_monitorUtil.findByBytypeAccess(typeAccess);
	   int currentUserOperationByType = 0;
	   for(user_monitor u : user) {
		   if(u.getUserMonitorId() == Long.parseLong(userID)) {
			   currentUserOperationByType ++;
		   }
	   }
	   return currentUserOperationByType;
   }
   
 
   
   @SuppressWarnings("unchecked")
public static int getCountByDATE(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
	   
       String totallastday =  resourceRequest.getParameter("totallastday");
	   String totalstartday = resourceRequest.getParameter("totalstartday");
	   
	   int totallogin = 0 ;
	   int totallogout = 0;
	   
	   DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(user_monitor.class, user_monitor.class.getClassLoader());
       Property startDateProperty = PropertyFactoryUtil.forName("totalstartday");
       Property endDateProperty = PropertyFactoryUtil.forName("totallastday");
       dynamicQuery.add(startDateProperty.ge(totalstartday));
       dynamicQuery.add(endDateProperty.le(totallastday));
       
       try {
			List<user_monitor> user_M = user_monitorLocalServiceUtil.dynamicQuery(dynamicQuery);
			for(user_monitor user_Mini:user_M){
			   
				if(user_Mini.getTypeAccess()== "LOGIN") {
					totallogin++;
					
	       	   	}else if(user_Mini.getTypeAccess()== "LOGOUT") {
				
					totallogout++ ;		
				}
				resourceRequest.setAttribute("data",totallogin );
				resourceRequest.setAttribute("data", totallogout);
				PrintWriter writer = resourceResponse.getWriter();
				
				JSONObject jsonobj =  JSONFactoryUtil.createJSONObject();
				jsonobj.put("totallogin", totallogin);
				jsonobj.put("totallogout", totallogout);
				writer.println(jsonobj);
		}
       }
			
			 catch (SystemException e) {

			e.printStackTrace();
		}
	    
	   return 0;
	    
	   } 
	   
	  
   
    public void timeIntervalQuery   ( ActionRequest actionRequest , ActionResponse actionResponset  )   {
		// We can fetch the date either by separate Day, Month and Year parameter.
		int dobDayS = ParamUtil.getInteger(actionRequest, "dobDayS");
		int dobMonthS = ParamUtil.getInteger(actionRequest, "dobMonthS");
		int dobYearS = ParamUtil.getInteger(actionRequest, "dobYearS");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dobDayS);
		calendar.set(Calendar.MONTH, dobMonthS);
		calendar.set(Calendar.YEAR, dobYearS);
		System.out.println("Method 1: " + calendar.getTime());
  	
   }

}