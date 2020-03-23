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

package it.laitspa.usermonitor.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class user_monitorPK implements Comparable<user_monitorPK>, Serializable {
	public long recordId;
	public int UserId;

	public user_monitorPK() {
	}

	public user_monitorPK(long recordId, int UserId) {
		this.recordId = recordId;
		this.UserId = UserId;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}

	@Override
	public int compareTo(user_monitorPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (recordId < pk.recordId) {
			value = -1;
		}
		else if (recordId > pk.recordId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (UserId < pk.UserId) {
			value = -1;
		}
		else if (UserId > pk.UserId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof user_monitorPK)) {
			return false;
		}

		user_monitorPK pk = (user_monitorPK)obj;

		if ((recordId == pk.recordId) && (UserId == pk.UserId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(recordId) + String.valueOf(UserId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("recordId");
		sb.append(StringPool.EQUAL);
		sb.append(recordId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("UserId");
		sb.append(StringPool.EQUAL);
		sb.append(UserId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}