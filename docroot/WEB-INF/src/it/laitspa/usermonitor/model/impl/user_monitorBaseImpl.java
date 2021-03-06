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

import com.liferay.portal.kernel.exception.SystemException;

import it.laitspa.usermonitor.model.user_monitor;
import it.laitspa.usermonitor.service.user_monitorLocalServiceUtil;

/**
 * The extended model base implementation for the user_monitor service. Represents a row in the &quot;user_monitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link user_monitorImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see user_monitorImpl
 * @see it.laitspa.usermonitor.model.user_monitor
 * @generated
 */
public abstract class user_monitorBaseImpl extends user_monitorModelImpl
	implements user_monitor {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user_monitor model instance should use the {@link user_monitor} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			user_monitorLocalServiceUtil.adduser_monitor(this);
		}
		else {
			user_monitorLocalServiceUtil.updateuser_monitor(this);
		}
	}
}