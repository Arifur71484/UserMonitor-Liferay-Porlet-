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

package it.laitspa.usermonitor.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import it.laitspa.usermonitor.model.user_monitor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing user_monitor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see user_monitor
 * @generated
 */
public class user_monitorCacheModel implements CacheModel<user_monitor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{recordId=");
		sb.append(recordId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userSurname=");
		sb.append(userSurname);
		sb.append(", userRealName=");
		sb.append(userRealName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", remoteIp=");
		sb.append(remoteIp);
		sb.append(", dataLogin=");
		sb.append(dataLogin);
		sb.append(", typeAccess=");
		sb.append(typeAccess);
		sb.append(", UserMonitorId=");
		sb.append(UserMonitorId);
		sb.append(", DATE=");
		sb.append(DATE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public user_monitor toEntityModel() {
		user_monitorImpl user_monitorImpl = new user_monitorImpl();

		user_monitorImpl.setRecordId(recordId);

		if (userName == null) {
			user_monitorImpl.setUserName(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setUserName(userName);
		}

		if (userSurname == null) {
			user_monitorImpl.setUserSurname(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setUserSurname(userSurname);
		}

		if (userRealName == null) {
			user_monitorImpl.setUserRealName(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setUserRealName(userRealName);
		}

		if (emailAddress == null) {
			user_monitorImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setEmailAddress(emailAddress);
		}

		if (remoteIp == null) {
			user_monitorImpl.setRemoteIp(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setRemoteIp(remoteIp);
		}

		if (dataLogin == null) {
			user_monitorImpl.setDataLogin(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setDataLogin(dataLogin);
		}

		if (typeAccess == null) {
			user_monitorImpl.setTypeAccess(StringPool.BLANK);
		}
		else {
			user_monitorImpl.setTypeAccess(typeAccess);
		}

		user_monitorImpl.setUserMonitorId(UserMonitorId);

		if (DATE == Long.MIN_VALUE) {
			user_monitorImpl.setDATE(null);
		}
		else {
			user_monitorImpl.setDATE(new Date(DATE));
		}

		user_monitorImpl.resetOriginalValues();

		return user_monitorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recordId = objectInput.readLong();
		userName = objectInput.readUTF();
		userSurname = objectInput.readUTF();
		userRealName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		remoteIp = objectInput.readUTF();
		dataLogin = objectInput.readUTF();
		typeAccess = objectInput.readUTF();
		UserMonitorId = objectInput.readLong();
		DATE = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recordId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (userSurname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userSurname);
		}

		if (userRealName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userRealName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (remoteIp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remoteIp);
		}

		if (dataLogin == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataLogin);
		}

		if (typeAccess == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeAccess);
		}

		objectOutput.writeLong(UserMonitorId);
		objectOutput.writeLong(DATE);
	}

	public long recordId;
	public String userName;
	public String userSurname;
	public String userRealName;
	public String emailAddress;
	public String remoteIp;
	public String dataLogin;
	public String typeAccess;
	public long UserMonitorId;
	public long DATE;
}