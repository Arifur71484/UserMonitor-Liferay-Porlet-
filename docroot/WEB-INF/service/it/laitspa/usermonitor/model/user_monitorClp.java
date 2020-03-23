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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import it.laitspa.usermonitor.service.ClpSerializer;
import it.laitspa.usermonitor.service.user_monitorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class user_monitorClp extends BaseModelImpl<user_monitor>
	implements user_monitor {
	public user_monitorClp() {
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
	public long getPrimaryKey() {
		return _recordId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecordId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recordId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getRecordId() {
		return _recordId;
	}

	@Override
	public void setRecordId(long recordId) {
		_recordId = recordId;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setRecordId", long.class);

				method.invoke(_user_monitorRemoteModel, recordId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_user_monitorRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserSurname() {
		return _userSurname;
	}

	@Override
	public void setUserSurname(String userSurname) {
		_userSurname = userSurname;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSurname", String.class);

				method.invoke(_user_monitorRemoteModel, userSurname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserRealName() {
		return _userRealName;
	}

	@Override
	public void setUserRealName(String userRealName) {
		_userRealName = userRealName;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserRealName", String.class);

				method.invoke(_user_monitorRemoteModel, userRealName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_user_monitorRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemoteIp() {
		return _remoteIp;
	}

	@Override
	public void setRemoteIp(String remoteIp) {
		_remoteIp = remoteIp;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoteIp", String.class);

				method.invoke(_user_monitorRemoteModel, remoteIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataLogin() {
		return _dataLogin;
	}

	@Override
	public void setDataLogin(String dataLogin) {
		_dataLogin = dataLogin;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setDataLogin", String.class);

				method.invoke(_user_monitorRemoteModel, dataLogin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTypeAccess() {
		return _typeAccess;
	}

	@Override
	public void setTypeAccess(String typeAccess) {
		_typeAccess = typeAccess;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setTypeAccess", String.class);

				method.invoke(_user_monitorRemoteModel, typeAccess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserMonitorId() {
		return _UserMonitorId;
	}

	@Override
	public void setUserMonitorId(long UserMonitorId) {
		_UserMonitorId = UserMonitorId;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setUserMonitorId", long.class);

				method.invoke(_user_monitorRemoteModel, UserMonitorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDATE() {
		return _DATE;
	}

	@Override
	public void setDATE(Date DATE) {
		_DATE = DATE;

		if (_user_monitorRemoteModel != null) {
			try {
				Class<?> clazz = _user_monitorRemoteModel.getClass();

				Method method = clazz.getMethod("setDATE", Date.class);

				method.invoke(_user_monitorRemoteModel, DATE);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getuser_monitorRemoteModel() {
		return _user_monitorRemoteModel;
	}

	public void setuser_monitorRemoteModel(BaseModel<?> user_monitorRemoteModel) {
		_user_monitorRemoteModel = user_monitorRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _user_monitorRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_user_monitorRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			user_monitorLocalServiceUtil.adduser_monitor(this);
		}
		else {
			user_monitorLocalServiceUtil.updateuser_monitor(this);
		}
	}

	@Override
	public user_monitor toEscapedModel() {
		return (user_monitor)ProxyUtil.newProxyInstance(user_monitor.class.getClassLoader(),
			new Class[] { user_monitor.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		user_monitorClp clone = new user_monitorClp();

		clone.setRecordId(getRecordId());
		clone.setUserName(getUserName());
		clone.setUserSurname(getUserSurname());
		clone.setUserRealName(getUserRealName());
		clone.setEmailAddress(getEmailAddress());
		clone.setRemoteIp(getRemoteIp());
		clone.setDataLogin(getDataLogin());
		clone.setTypeAccess(getTypeAccess());
		clone.setUserMonitorId(getUserMonitorId());
		clone.setDATE(getDATE());

		return clone;
	}

	@Override
	public int compareTo(user_monitor user_monitor) {
		long primaryKey = user_monitor.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof user_monitorClp)) {
			return false;
		}

		user_monitorClp user_monitor = (user_monitorClp)obj;

		long primaryKey = user_monitor.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{recordId=");
		sb.append(getRecordId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", userSurname=");
		sb.append(getUserSurname());
		sb.append(", userRealName=");
		sb.append(getUserRealName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", remoteIp=");
		sb.append(getRemoteIp());
		sb.append(", dataLogin=");
		sb.append(getDataLogin());
		sb.append(", typeAccess=");
		sb.append(getTypeAccess());
		sb.append(", UserMonitorId=");
		sb.append(getUserMonitorId());
		sb.append(", DATE=");
		sb.append(getDATE());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("it.laitspa.usermonitor.model.user_monitor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recordId</column-name><column-value><![CDATA[");
		sb.append(getRecordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userSurname</column-name><column-value><![CDATA[");
		sb.append(getUserSurname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userRealName</column-name><column-value><![CDATA[");
		sb.append(getUserRealName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remoteIp</column-name><column-value><![CDATA[");
		sb.append(getRemoteIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataLogin</column-name><column-value><![CDATA[");
		sb.append(getDataLogin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeAccess</column-name><column-value><![CDATA[");
		sb.append(getTypeAccess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UserMonitorId</column-name><column-value><![CDATA[");
		sb.append(getUserMonitorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DATE</column-name><column-value><![CDATA[");
		sb.append(getDATE());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recordId;
	private String _userName;
	private String _userSurname;
	private String _userRealName;
	private String _emailAddress;
	private String _remoteIp;
	private String _dataLogin;
	private String _typeAccess;
	private long _UserMonitorId;
	private Date _DATE;
	private BaseModel<?> _user_monitorRemoteModel;
	private Class<?> _clpSerializerClass = it.laitspa.usermonitor.service.ClpSerializer.class;
}