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

package it.laitspa.usermonitor.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for user_monitor. This utility wraps
 * {@link it.laitspa.usermonitor.service.impl.user_monitorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see user_monitorLocalService
 * @see it.laitspa.usermonitor.service.base.user_monitorLocalServiceBaseImpl
 * @see it.laitspa.usermonitor.service.impl.user_monitorLocalServiceImpl
 * @generated
 */
public class user_monitorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.laitspa.usermonitor.service.impl.user_monitorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user_monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param user_monitor the user_monitor
	* @return the user_monitor that was added
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor adduser_monitor(
		it.laitspa.usermonitor.model.user_monitor user_monitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().adduser_monitor(user_monitor);
	}

	/**
	* Creates a new user_monitor with the primary key. Does not add the user_monitor to the database.
	*
	* @param recordId the primary key for the new user_monitor
	* @return the new user_monitor
	*/
	public static it.laitspa.usermonitor.model.user_monitor createuser_monitor(
		long recordId) {
		return getService().createuser_monitor(recordId);
	}

	/**
	* Deletes the user_monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the user_monitor
	* @return the user_monitor that was removed
	* @throws PortalException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor deleteuser_monitor(
		long recordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteuser_monitor(recordId);
	}

	/**
	* Deletes the user_monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param user_monitor the user_monitor
	* @return the user_monitor that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor deleteuser_monitor(
		it.laitspa.usermonitor.model.user_monitor user_monitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteuser_monitor(user_monitor);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.laitspa.usermonitor.model.user_monitor fetchuser_monitor(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchuser_monitor(recordId);
	}

	/**
	* Returns the user_monitor with the primary key.
	*
	* @param recordId the primary key of the user_monitor
	* @return the user_monitor
	* @throws PortalException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor getuser_monitor(
		long recordId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getuser_monitor(recordId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user_monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @return the range of user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> getuser_monitors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getuser_monitors(start, end);
	}

	/**
	* Returns the number of user_monitors.
	*
	* @return the number of user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static int getuser_monitorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getuser_monitorsCount();
	}

	/**
	* Updates the user_monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param user_monitor the user_monitor
	* @return the user_monitor that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor updateuser_monitor(
		it.laitspa.usermonitor.model.user_monitor user_monitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateuser_monitor(user_monitor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int getCountByTypeAccess(java.lang.String typeAccess,
		java.lang.String userID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountByTypeAccess(typeAccess, userID);
	}

	public static void timeIntervalQuery(
		javax.portlet.ActionRequest actionRequest,
		javax.portlet.ActionResponse actionResponset) {
		getService().timeIntervalQuery(actionRequest, actionResponset);
	}

	public static void clearService() {
		_service = null;
	}

	public static user_monitorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					user_monitorLocalService.class.getName());

			if (invokableLocalService instanceof user_monitorLocalService) {
				_service = (user_monitorLocalService)invokableLocalService;
			}
			else {
				_service = new user_monitorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(user_monitorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(user_monitorLocalService service) {
	}

	private static user_monitorLocalService _service;
}