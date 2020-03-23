package it.latispa.usermonitor.mvc;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
 import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
 import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
 import com.liferay.util.bridges.mvc.MVCPortlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.laitspa.usermonitor.model.user_monitor;
import it.laitspa.usermonitor.service.user_monitorLocalServiceUtil;
import it.laitspa.usermonitor.service.impl.user_monitorLocalServiceImpl;


public class UserMonitorMVC extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		

		
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	  

		
		try {
		    String dobDateString = ParamUtil.getString(actionRequest, "dobDate");
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    Date dobDate = sdf.parse(dobDateString);

		    System.out.println("Method 2: " + dobDate);
		}
		
		catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		super.processAction(actionRequest, actionResponse);
	}

	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		super.render(request, response);
	}



	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse,HttpServletRequest request, 
            HttpServletResponse response)
			throws IOException, PortletException {
	 
		     user_monitorLocalServiceImpl.getCountByDATE(resourceRequest, resourceResponse);
		   
		 super.serveResource(resourceRequest, resourceResponse);
	}

	
	
	
}
