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

package it.laitspa.usermonitor.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link user_monitor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see user_monitor
 * @generated
 */
public class user_monitorWrapper implements user_monitor,
	ModelWrapper<user_monitor> {
	public user_monitorWrapper(user_monitor user_monitor) {
		_user_monitor = user_monitor;
	}

	@Override
	public Class<?> getModelClass() {
		return user_monitor.class;
	}

	@Override
	public String getModelClassName() {
		return user_monitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recordId", getRecordId());
		attributes.put("userName", getUserName());
		attributes.put("userSurname", getUserSurname());
		attributes.put("userRealName", getUserRealName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("remoteIp", getRemoteIp());
		attributes.put("dataLogin", getDataLogin());
		attributes.put("typeAccess", getTypeAccess());
		attributes.put("UserMonitorId", getUserMonitorId());
		attributes.put("DATE", getDATE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recordId = (Long)attributes.get("recordId");

		if (recordId != null) {
			setRecordId(recordId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String userSurname = (String)attributes.get("userSurname");

		if (userSurname != null) {
			setUserSurname(userSurname);
		}

		String userRealName = (String)attributes.get("userRealName");

		if (userRealName != null) {
			setUserRealName(userRealName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String remoteIp = (String)attributes.get("remoteIp");

		if (remoteIp != null) {
			setRemoteIp(remoteIp);
		}

		String dataLogin = (String)attributes.get("dataLogin");

		if (dataLogin != null) {
			setDataLogin(dataLogin);
		}

		String typeAccess = (String)attributes.get("typeAccess");

		if (typeAccess != null) {
			setTypeAccess(typeAccess);
		}

		Long UserMonitorId = (Long)attributes.get("UserMonitorId");

		if (UserMonitorId != null) {
			setUserMonitorId(UserMonitorId);
		}

		Date DATE = (Date)attributes.get("DATE");

		if (DATE != null) {
			setDATE(DATE);
		}
	}

	/**
	* Returns the primary key of this user_monitor.
	*
	* @return the primary key of this user_monitor
	*/
	@Override
	public long getPrimaryKey() {
		return _user_monitor.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user_monitor.
	*
	* @param primaryKey the primary key of this user_monitor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_user_monitor.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the record ID of this user_monitor.
	*
	* @return the record ID of this user_monitor
	*/
	@Override
	public long getRecordId() {
		return _user_monitor.getRecordId();
	}

	/**
	* Sets the record ID of this user_monitor.
	*
	* @param recordId the record ID of this user_monitor
	*/
	@Override
	public void setRecordId(long recordId) {
		_user_monitor.setRecordId(recordId);
	}

	/**
	* Returns the user name of this user_monitor.
	*
	* @return the user name of this user_monitor
	*/
	@Override
	public java.lang.String getUserName() {
		return _user_monitor.getUserName();
	}

	/**
	* Sets the user name of this user_monitor.
	*
	* @param userName the user name of this user_monitor
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_user_monitor.setUserName(userName);
	}

	/**
	* Returns the user surname of this user_monitor.
	*
	* @return the user surname of this user_monitor
	*/
	@Override
	public java.lang.String getUserSurname() {
		return _user_monitor.getUserSurname();
	}

	/**
	* Sets the user surname of this user_monitor.
	*
	* @param userSurname the user surname of this user_monitor
	*/
	@Override
	public void setUserSurname(java.lang.String userSurname) {
		_user_monitor.setUserSurname(userSurname);
	}

	/**
	* Returns the user real name of this user_monitor.
	*
	* @return the user real name of this user_monitor
	*/
	@Override
	public java.lang.String getUserRealName() {
		return _user_monitor.getUserRealName();
	}

	/**
	* Sets the user real name of this user_monitor.
	*
	* @param userRealName the user real name of this user_monitor
	*/
	@Override
	public void setUserRealName(java.lang.String userRealName) {
		_user_monitor.setUserRealName(userRealName);
	}

	/**
	* Returns the email address of this user_monitor.
	*
	* @return the email address of this user_monitor
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _user_monitor.getEmailAddress();
	}

	/**
	* Sets the email address of this user_monitor.
	*
	* @param emailAddress the email address of this user_monitor
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_user_monitor.setEmailAddress(emailAddress);
	}

	/**
	* Returns the remote ip of this user_monitor.
	*
	* @return the remote ip of this user_monitor
	*/
	@Override
	public java.lang.String getRemoteIp() {
		return _user_monitor.getRemoteIp();
	}

	/**
	* Sets the remote ip of this user_monitor.
	*
	* @param remoteIp the remote ip of this user_monitor
	*/
	@Override
	public void setRemoteIp(java.lang.String remoteIp) {
		_user_monitor.setRemoteIp(remoteIp);
	}

	/**
	* Returns the data login of this user_monitor.
	*
	* @return the data login of this user_monitor
	*/
	@Override
	public java.lang.String getDataLogin() {
		return _user_monitor.getDataLogin();
	}

	/**
	* Sets the data login of this user_monitor.
	*
	* @param dataLogin the data login of this user_monitor
	*/
	@Override
	public void setDataLogin(java.lang.String dataLogin) {
		_user_monitor.setDataLogin(dataLogin);
	}

	/**
	* Returns the type access of this user_monitor.
	*
	* @return the type access of this user_monitor
	*/
	@Override
	public java.lang.String getTypeAccess() {
		return _user_monitor.getTypeAccess();
	}

	/**
	* Sets the type access of this user_monitor.
	*
	* @param typeAccess the type access of this user_monitor
	*/
	@Override
	public void setTypeAccess(java.lang.String typeAccess) {
		_user_monitor.setTypeAccess(typeAccess);
	}

	/**
	* Returns the user monitor ID of this user_monitor.
	*
	* @return the user monitor ID of this user_monitor
	*/
	@Override
	public long getUserMonitorId() {
		return _user_monitor.getUserMonitorId();
	}

	/**
	* Sets the user monitor ID of this user_monitor.
	*
	* @param UserMonitorId the user monitor ID of this user_monitor
	*/
	@Override
	public void setUserMonitorId(long UserMonitorId) {
		_user_monitor.setUserMonitorId(UserMonitorId);
	}

	/**
	* Returns the d a t e of this user_monitor.
	*
	* @return the d a t e of this user_monitor
	*/
	@Override
	public java.util.Date getDATE() {
		return _user_monitor.getDATE();
	}

	/**
	* Sets the d a t e of this user_monitor.
	*
	* @param DATE the d a t e of this user_monitor
	*/
	@Override
	public void setDATE(java.util.Date DATE) {
		_user_monitor.setDATE(DATE);
	}

	@Override
	public boolean isNew() {
		return _user_monitor.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_user_monitor.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _user_monitor.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_user_monitor.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _user_monitor.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _user_monitor.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_user_monitor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _user_monitor.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_user_monitor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_user_monitor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_user_monitor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new user_monitorWrapper((user_monitor)_user_monitor.clone());
	}

	@Override
	public int compareTo(it.laitspa.usermonitor.model.user_monitor user_monitor) {
		return _user_monitor.compareTo(user_monitor);
	}

	@Override
	public int hashCode() {
		return _user_monitor.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<it.laitspa.usermonitor.model.user_monitor> toCacheModel() {
		return _user_monitor.toCacheModel();
	}

	@Override
	public it.laitspa.usermonitor.model.user_monitor toEscapedModel() {
		return new user_monitorWrapper(_user_monitor.toEscapedModel());
	}

	@Override
	public it.laitspa.usermonitor.model.user_monitor toUnescapedModel() {
		return new user_monitorWrapper(_user_monitor.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _user_monitor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _user_monitor.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_user_monitor.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof user_monitorWrapper)) {
			return false;
		}

		user_monitorWrapper user_monitorWrapper = (user_monitorWrapper)obj;

		if (Validator.equals(_user_monitor, user_monitorWrapper._user_monitor)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public user_monitor getWrappeduser_monitor() {
		return _user_monitor;
	}

	@Override
	public user_monitor getWrappedModel() {
		return _user_monitor;
	}

	@Override
	public void resetOriginalValues() {
		_user_monitor.resetOriginalValues();
	}

	private user_monitor _user_monitor;
}