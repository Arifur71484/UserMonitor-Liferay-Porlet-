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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import it.laitspa.usermonitor.model.user_monitor;

import java.util.List;

/**
 * The persistence utility for the user_monitor service. This utility wraps {@link user_monitorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see user_monitorPersistence
 * @see user_monitorPersistenceImpl
 * @generated
 */
public class user_monitorUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(user_monitor user_monitor) {
		getPersistence().clearCache(user_monitor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<user_monitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<user_monitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<user_monitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static user_monitor update(user_monitor user_monitor)
		throws SystemException {
		return getPersistence().update(user_monitor);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static user_monitor update(user_monitor user_monitor,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(user_monitor, serviceContext);
	}

	/**
	* Returns all the user_monitors where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @return the matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByBytypeAccess(
		java.lang.String typeAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBytypeAccess(typeAccess);
	}

	/**
	* Returns a range of all the user_monitors where typeAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeAccess the type access
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @return the range of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByBytypeAccess(
		java.lang.String typeAccess, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBytypeAccess(typeAccess, start, end);
	}

	/**
	* Returns an ordered range of all the user_monitors where typeAccess = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeAccess the type access
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByBytypeAccess(
		java.lang.String typeAccess, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBytypeAccess(typeAccess, start, end, orderByComparator);
	}

	/**
	* Returns the first user_monitor in the ordered set where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor findByBytypeAccess_First(
		java.lang.String typeAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence()
				   .findByBytypeAccess_First(typeAccess, orderByComparator);
	}

	/**
	* Returns the first user_monitor in the ordered set where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor fetchByBytypeAccess_First(
		java.lang.String typeAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBytypeAccess_First(typeAccess, orderByComparator);
	}

	/**
	* Returns the last user_monitor in the ordered set where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor findByBytypeAccess_Last(
		java.lang.String typeAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence()
				   .findByBytypeAccess_Last(typeAccess, orderByComparator);
	}

	/**
	* Returns the last user_monitor in the ordered set where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor fetchByBytypeAccess_Last(
		java.lang.String typeAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBytypeAccess_Last(typeAccess, orderByComparator);
	}

	/**
	* Returns the user_monitors before and after the current user_monitor in the ordered set where typeAccess = &#63;.
	*
	* @param recordId the primary key of the current user_monitor
	* @param typeAccess the type access
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor[] findByBytypeAccess_PrevAndNext(
		long recordId, java.lang.String typeAccess,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence()
				   .findByBytypeAccess_PrevAndNext(recordId, typeAccess,
			orderByComparator);
	}

	/**
	* Removes all the user_monitors where typeAccess = &#63; from the database.
	*
	* @param typeAccess the type access
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBytypeAccess(java.lang.String typeAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBytypeAccess(typeAccess);
	}

	/**
	* Returns the number of user_monitors where typeAccess = &#63;.
	*
	* @param typeAccess the type access
	* @return the number of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBytypeAccess(java.lang.String typeAccess)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBytypeAccess(typeAccess);
	}

	/**
	* Returns all the user_monitors where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @return the matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByByDATE(
		java.util.Date DATE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByDATE(DATE);
	}

	/**
	* Returns a range of all the user_monitors where DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DATE the d a t e
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @return the range of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByByDATE(
		java.util.Date DATE, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByDATE(DATE, start, end);
	}

	/**
	* Returns an ordered range of all the user_monitors where DATE = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param DATE the d a t e
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findByByDATE(
		java.util.Date DATE, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByDATE(DATE, start, end, orderByComparator);
	}

	/**
	* Returns the first user_monitor in the ordered set where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor findByByDATE_First(
		java.util.Date DATE,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence().findByByDATE_First(DATE, orderByComparator);
	}

	/**
	* Returns the first user_monitor in the ordered set where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor fetchByByDATE_First(
		java.util.Date DATE,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByDATE_First(DATE, orderByComparator);
	}

	/**
	* Returns the last user_monitor in the ordered set where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor findByByDATE_Last(
		java.util.Date DATE,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence().findByByDATE_Last(DATE, orderByComparator);
	}

	/**
	* Returns the last user_monitor in the ordered set where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor fetchByByDATE_Last(
		java.util.Date DATE,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByDATE_Last(DATE, orderByComparator);
	}

	/**
	* Returns the user_monitors before and after the current user_monitor in the ordered set where DATE = &#63;.
	*
	* @param recordId the primary key of the current user_monitor
	* @param DATE the d a t e
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor[] findByByDATE_PrevAndNext(
		long recordId, java.util.Date DATE,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence()
				   .findByByDATE_PrevAndNext(recordId, DATE, orderByComparator);
	}

	/**
	* Removes all the user_monitors where DATE = &#63; from the database.
	*
	* @param DATE the d a t e
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByDATE(java.util.Date DATE)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByDATE(DATE);
	}

	/**
	* Returns the number of user_monitors where DATE = &#63;.
	*
	* @param DATE the d a t e
	* @return the number of matching user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByDATE(java.util.Date DATE)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByDATE(DATE);
	}

	/**
	* Caches the user_monitor in the entity cache if it is enabled.
	*
	* @param user_monitor the user_monitor
	*/
	public static void cacheResult(
		it.laitspa.usermonitor.model.user_monitor user_monitor) {
		getPersistence().cacheResult(user_monitor);
	}

	/**
	* Caches the user_monitors in the entity cache if it is enabled.
	*
	* @param user_monitors the user_monitors
	*/
	public static void cacheResult(
		java.util.List<it.laitspa.usermonitor.model.user_monitor> user_monitors) {
		getPersistence().cacheResult(user_monitors);
	}

	/**
	* Creates a new user_monitor with the primary key. Does not add the user_monitor to the database.
	*
	* @param recordId the primary key for the new user_monitor
	* @return the new user_monitor
	*/
	public static it.laitspa.usermonitor.model.user_monitor create(
		long recordId) {
		return getPersistence().create(recordId);
	}

	/**
	* Removes the user_monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recordId the primary key of the user_monitor
	* @return the user_monitor that was removed
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor remove(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence().remove(recordId);
	}

	public static it.laitspa.usermonitor.model.user_monitor updateImpl(
		it.laitspa.usermonitor.model.user_monitor user_monitor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(user_monitor);
	}

	/**
	* Returns the user_monitor with the primary key or throws a {@link it.laitspa.usermonitor.NoSuchuser_monitorException} if it could not be found.
	*
	* @param recordId the primary key of the user_monitor
	* @return the user_monitor
	* @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor findByPrimaryKey(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException,
			it.laitspa.usermonitor.NoSuchuser_monitorException {
		return getPersistence().findByPrimaryKey(recordId);
	}

	/**
	* Returns the user_monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recordId the primary key of the user_monitor
	* @return the user_monitor, or <code>null</code> if a user_monitor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static it.laitspa.usermonitor.model.user_monitor fetchByPrimaryKey(
		long recordId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recordId);
	}

	/**
	* Returns all the user_monitors.
	*
	* @return the user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user_monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.laitspa.usermonitor.model.impl.user_monitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user_monitors
	* @param end the upper bound of the range of user_monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<it.laitspa.usermonitor.model.user_monitor> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user_monitors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user_monitors.
	*
	* @return the number of user_monitors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static user_monitorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (user_monitorPersistence)PortletBeanLocatorUtil.locate(it.laitspa.usermonitor.service.ClpSerializer.getServletContextName(),
					user_monitorPersistence.class.getName());

			ReferenceRegistry.registerReference(user_monitorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(user_monitorPersistence persistence) {
	}

	private static user_monitorPersistence _persistence;
}