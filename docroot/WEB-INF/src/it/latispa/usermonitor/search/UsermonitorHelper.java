package it.latispa.usermonitor.search;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collections;
import java.util.List;

import it.laitspa.usermonitor.model.user_monitor;
import it.laitspa.usermonitor.service.ClpSerializer;
import it.laitspa.usermonitor.service.user_monitorLocalServiceUtil;

public class UsermonitorHelper {

	// helper class for dynamic and normal query 
	public static List<user_monitor>getUser_monitors(UsermonitorDisplayterms displayTerms,int start,int end) throws SystemException{
        List<user_monitor> user_monitorList = getuser_monitordata(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getrecordId(), displayTerms.getuserName(),displayTerms.getemail(),displayTerms.getuserRealName(),displayTerms.getdataLogin(),displayTerms.getuserSurname(), displayTerms.getKeywords());
        return ListUtil.subList(user_monitorList, start , end) ;
	}
 
	public static int getTotalusermonitorCount(UsermonitorDisplayterms displayTerms,int start,int end) throws SystemException{
	       return getuser_monitordata(displayTerms.isAdvancedSearch(), displayTerms.isAndOperator(), displayTerms.getrecordId(), displayTerms.getuserName(),displayTerms.getemail(),displayTerms.getuserRealName(),displayTerms.getdataLogin(),displayTerms.getuserSurname(), displayTerms.getKeywords()).size();
		}
	
    @SuppressWarnings("unchecked")
	public static List<user_monitor> getuser_monitordata(boolean isAdvancedSearch,boolean isAndOperator,long recordId,String userName,String emailAddress,String dataLogin,String userRealName,String userSurname,String keywords) throws SystemException {
		@SuppressWarnings("unchecked")
		List<user_monitor> user_monitorList = Collections.EMPTY_LIST;
      
		if((Validator.isBlank(keywords)) && (!isAdvancedSearch)){// No search
			user_monitorList = user_monitorLocalServiceUtil.getuser_monitors(0, user_monitorLocalServiceUtil.getuser_monitorsCount());
		}
		else{
			ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),"portletClassLoader");
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(user_monitor.class, "usrm", classLoader);
			Junction junction = null;
			 if(isAdvancedSearch){
				 // Advance Search
				  if(isAndOperator){
					  System.out.println("All means And");
					  junction = RestrictionsFactoryUtil.conjunction();
				  }else{
					  System.out.println("Any means OR");
					  junction = RestrictionsFactoryUtil.disjunction();
				  }
				  if(Validator.isDigit(recordId+"") || recordId>0){
					  junction.add(PropertyFactoryUtil.forName("usrm.recordId").eq(Long.valueOf(recordId)));
				  }
				  
				  if(!Validator.isBlank(emailAddress)){
					  junction.add(PropertyFactoryUtil.forName("usrm.emailAddress").like("%"+emailAddress+"%"));
				 }
				  if(!Validator.isBlank(userName)){
					  junction.add(PropertyFactoryUtil.forName("usrm.userName").like("%"+userName+"%"));
				 }
				  
				
				  
			  }else {
				  // Normal Search
				  junction = RestrictionsFactoryUtil.disjunction();
				  if(Validator.isDigit(keywords)){
					  junction.add(PropertyFactoryUtil.forName("usrm.recordId").eq(Long.valueOf(keywords)));
				  }
				  if(Validator.isBlank(userName))
				   {
				  junction.add(PropertyFactoryUtil.forName("usrm.userName").like("%"+keywords+"%"));
				  }
				  if(Validator.isBlank(emailAddress))
				  {
				  junction.add(PropertyFactoryUtil.forName("usrm.emailAddress").like("%"+keywords+"%"));
				  
			      }
				  if(Validator.isBlank(dataLogin))
				  {
			      junction.add(PropertyFactoryUtil.forName("usrm.dataLogin").like("%"+keywords+"%"));
				  }  
				  if(Validator.isBlank(userRealName)) {
				  junction.add(PropertyFactoryUtil.forName("usrm.userRealName").like("%"+keywords+"%"));
				  }
				  junction.add(PropertyFactoryUtil.forName("usrm.userSurname").like("%"+keywords+"%"));
			  }
              dynamicQuery.add(junction);
              user_monitorList =  user_monitorLocalServiceUtil.dynamicQuery(dynamicQuery);
		}
          return user_monitorList;
	}
	
	
}
