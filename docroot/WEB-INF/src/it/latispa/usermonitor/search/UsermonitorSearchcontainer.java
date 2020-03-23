package it.latispa.usermonitor.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import it.laitspa.usermonitor.model.user_monitor;


public class UsermonitorSearchcontainer extends SearchContainer <user_monitor> {
	
	// usermonitor search container set properties like empty result message and default records per page(DELTA)
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int DEFAULT_DELTA = 5;
	static List<String>	headerNames	= new ArrayList<String>();
	static {
		headerNames.add("recordId");
		headerNames.add("userName");
		headerNames.add("emailAddress");
		headerNames.add("dataLogin");
		headerNames.add("userRealName");
	    headerNames.add("userSurname");
		
	}

	public UsermonitorSearchcontainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		    super(portletRequest, new UsermonitorDisplayterms(portletRequest), new UsermonitorDisplayterms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
					headerNames, EMPTY_RESULTS_MESSAGE);
			UsermonitorDisplayterms displayTerms = (UsermonitorDisplayterms) getDisplayTerms();
			iteratorURL.setParameter("recordId", ""+displayTerms.getrecordId());
			iteratorURL.setParameter("userName", displayTerms.getuserName());
			iteratorURL.setParameter("emailAddress", displayTerms.getemail());
			iteratorURL.setParameter("dataLogin", displayTerms.getdataLogin());
			iteratorURL.setParameter("remoteIp", displayTerms.getuserRealName());
			iteratorURL.setParameter("userSurname", displayTerms.getuserRealName());
		}

}
