package it.latispa.usermonitor.search;

import javax.portlet.PortletRequest;


import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class UsermonitorDisplayterms extends DisplayTerms {
	
	private long recordId;
	private String userName;
	private String emailAddress ;
	private String dataLogin;
	private String userRealName ;
	private String userSurname;
	
	//  create getter and setter  for advance and normal search 

	public UsermonitorDisplayterms(PortletRequest request) {
		 
		super(request);
		recordId = ParamUtil.getInteger(request, "recordId");
		userName = ParamUtil.getString(request, "userName");
		emailAddress = ParamUtil.getString(request, "emailAddress");
		dataLogin = ParamUtil.getString(request, "dataLogin");
		userRealName = ParamUtil.getString(request, "userRealName");
		userSurname = ParamUtil.getString(request, "userSurname");
	}
	
	public long getrecordId() {
		return recordId;
	}
   public void setrecordId(long recordId) {
		this.recordId = recordId;
	}
	public String getuserName() {
		return userName;
	}
	public void setuserName(String userName) {
		this.userName = userName;
	}
	
	public String getemail() {
		return emailAddress;
	}
	public void setemail(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getdataLogin () {
		return dataLogin;
	}
	public void setdataLogin(String dataLogin) {
		this.dataLogin = dataLogin;
	}
	
	public String getuserRealName () {
		return userRealName;
	}
	public void setremoteIp(String userRealName) {
		this.userRealName = userRealName;
	}
	
	public String getuserSurname () {
		return userSurname;
	}
	public void setuserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	
	
}
