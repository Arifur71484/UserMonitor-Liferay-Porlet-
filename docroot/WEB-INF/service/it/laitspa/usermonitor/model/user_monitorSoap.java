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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class user_monitorSoap implements Serializable {
	public static user_monitorSoap toSoapModel(user_monitor model) {
		user_monitorSoap soapModel = new user_monitorSoap();

		soapModel.setRecordId(model.getRecordId());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserSurname(model.getUserSurname());
		soapModel.setUserRealName(model.getUserRealName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setRemoteIp(model.getRemoteIp());
		soapModel.setDataLogin(model.getDataLogin());
		soapModel.setTypeAccess(model.getTypeAccess());
		soapModel.setUserMonitorId(model.getUserMonitorId());
		soapModel.setDATE(model.getDATE());

		return soapModel;
	}

	public static user_monitorSoap[] toSoapModels(user_monitor[] models) {
		user_monitorSoap[] soapModels = new user_monitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static user_monitorSoap[][] toSoapModels(user_monitor[][] models) {
		user_monitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new user_monitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new user_monitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static user_monitorSoap[] toSoapModels(List<user_monitor> models) {
		List<user_monitorSoap> soapModels = new ArrayList<user_monitorSoap>(models.size());

		for (user_monitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new user_monitorSoap[soapModels.size()]);
	}

	public user_monitorSoap() {
	}

	public long getPrimaryKey() {
		return _recordId;
	}

	public void setPrimaryKey(long pk) {
		setRecordId(pk);
	}

	public long getRecordId() {
		return _recordId;
	}

	public void setRecordId(long recordId) {
		_recordId = recordId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getUserSurname() {
		return _userSurname;
	}

	public void setUserSurname(String userSurname) {
		_userSurname = userSurname;
	}

	public String getUserRealName() {
		return _userRealName;
	}

	public void setUserRealName(String userRealName) {
		_userRealName = userRealName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getRemoteIp() {
		return _remoteIp;
	}

	public void setRemoteIp(String remoteIp) {
		_remoteIp = remoteIp;
	}

	public String getDataLogin() {
		return _dataLogin;
	}

	public void setDataLogin(String dataLogin) {
		_dataLogin = dataLogin;
	}

	public String getTypeAccess() {
		return _typeAccess;
	}

	public void setTypeAccess(String typeAccess) {
		_typeAccess = typeAccess;
	}

	public long getUserMonitorId() {
		return _UserMonitorId;
	}

	public void setUserMonitorId(long UserMonitorId) {
		_UserMonitorId = UserMonitorId;
	}

	public Date getDATE() {
		return _DATE;
	}

	public void setDATE(Date DATE) {
		_DATE = DATE;
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
}