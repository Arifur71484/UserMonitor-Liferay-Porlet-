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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import it.laitspa.usermonitor.NoSuchuser_monitorException;
import it.laitspa.usermonitor.model.impl.user_monitorImpl;
import it.laitspa.usermonitor.model.impl.user_monitorModelImpl;
import it.laitspa.usermonitor.model.user_monitor;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the user_monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see user_monitorPersistence
 * @see user_monitorUtil
 * @generated
 */
public class user_monitorPersistenceImpl extends BasePersistenceImpl<user_monitor>
	implements user_monitorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link user_monitorUtil} to access the user_monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = user_monitorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTYPEACCESS =
		new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBytypeAccess",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPEACCESS =
		new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBytypeAccess",
			new String[] { String.class.getName() },
			user_monitorModelImpl.TYPEACCESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYTYPEACCESS = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBytypeAccess",
			new String[] { String.class.getName() });

	/**
	 * Returns all the user_monitors where typeAccess = &#63;.
	 *
	 * @param typeAccess the type access
	 * @return the matching user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<user_monitor> findByBytypeAccess(String typeAccess)
		throws SystemException {
		return findByBytypeAccess(typeAccess, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<user_monitor> findByBytypeAccess(String typeAccess, int start,
		int end) throws SystemException {
		return findByBytypeAccess(typeAccess, start, end, null);
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
	@Override
	public List<user_monitor> findByBytypeAccess(String typeAccess, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPEACCESS;
			finderArgs = new Object[] { typeAccess };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYTYPEACCESS;
			finderArgs = new Object[] { typeAccess, start, end, orderByComparator };
		}

		List<user_monitor> list = (List<user_monitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (user_monitor user_monitor : list) {
				if (!Validator.equals(typeAccess, user_monitor.getTypeAccess())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USER_MONITOR_WHERE);

			boolean bindTypeAccess = false;

			if (typeAccess == null) {
				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_1);
			}
			else if (typeAccess.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_3);
			}
			else {
				bindTypeAccess = true;

				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(user_monitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTypeAccess) {
					qPos.add(typeAccess);
				}

				if (!pagination) {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<user_monitor>(list);
				}
				else {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public user_monitor findByBytypeAccess_First(String typeAccess,
		OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = fetchByBytypeAccess_First(typeAccess,
				orderByComparator);

		if (user_monitor != null) {
			return user_monitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeAccess=");
		msg.append(typeAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchuser_monitorException(msg.toString());
	}

	/**
	 * Returns the first user_monitor in the ordered set where typeAccess = &#63;.
	 *
	 * @param typeAccess the type access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByBytypeAccess_First(String typeAccess,
		OrderByComparator orderByComparator) throws SystemException {
		List<user_monitor> list = findByBytypeAccess(typeAccess, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public user_monitor findByBytypeAccess_Last(String typeAccess,
		OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = fetchByBytypeAccess_Last(typeAccess,
				orderByComparator);

		if (user_monitor != null) {
			return user_monitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeAccess=");
		msg.append(typeAccess);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchuser_monitorException(msg.toString());
	}

	/**
	 * Returns the last user_monitor in the ordered set where typeAccess = &#63;.
	 *
	 * @param typeAccess the type access
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByBytypeAccess_Last(String typeAccess,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBytypeAccess(typeAccess);

		if (count == 0) {
			return null;
		}

		List<user_monitor> list = findByBytypeAccess(typeAccess, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public user_monitor[] findByBytypeAccess_PrevAndNext(long recordId,
		String typeAccess, OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			user_monitor[] array = new user_monitorImpl[3];

			array[0] = getByBytypeAccess_PrevAndNext(session, user_monitor,
					typeAccess, orderByComparator, true);

			array[1] = user_monitor;

			array[2] = getByBytypeAccess_PrevAndNext(session, user_monitor,
					typeAccess, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected user_monitor getByBytypeAccess_PrevAndNext(Session session,
		user_monitor user_monitor, String typeAccess,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USER_MONITOR_WHERE);

		boolean bindTypeAccess = false;

		if (typeAccess == null) {
			query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_1);
		}
		else if (typeAccess.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_3);
		}
		else {
			bindTypeAccess = true;

			query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(user_monitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTypeAccess) {
			qPos.add(typeAccess);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(user_monitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<user_monitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user_monitors where typeAccess = &#63; from the database.
	 *
	 * @param typeAccess the type access
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBytypeAccess(String typeAccess)
		throws SystemException {
		for (user_monitor user_monitor : findByBytypeAccess(typeAccess,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(user_monitor);
		}
	}

	/**
	 * Returns the number of user_monitors where typeAccess = &#63;.
	 *
	 * @param typeAccess the type access
	 * @return the number of matching user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBytypeAccess(String typeAccess) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYTYPEACCESS;

		Object[] finderArgs = new Object[] { typeAccess };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USER_MONITOR_WHERE);

			boolean bindTypeAccess = false;

			if (typeAccess == null) {
				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_1);
			}
			else if (typeAccess.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_3);
			}
			else {
				bindTypeAccess = true;

				query.append(_FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTypeAccess) {
					qPos.add(typeAccess);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_1 = "user_monitor.typeAccess IS NULL";
	private static final String _FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_2 = "user_monitor.typeAccess = ?";
	private static final String _FINDER_COLUMN_BYTYPEACCESS_TYPEACCESS_3 = "(user_monitor.typeAccess IS NULL OR user_monitor.typeAccess = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDATE = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByDATE",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDATE =
		new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, user_monitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByDATE",
			new String[] { Date.class.getName() },
			user_monitorModelImpl.DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYDATE = new FinderPath(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByDATE",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the user_monitors where DATE = &#63;.
	 *
	 * @param DATE the d a t e
	 * @return the matching user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<user_monitor> findByByDATE(Date DATE) throws SystemException {
		return findByByDATE(DATE, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<user_monitor> findByByDATE(Date DATE, int start, int end)
		throws SystemException {
		return findByByDATE(DATE, start, end, null);
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
	@Override
	public List<user_monitor> findByByDATE(Date DATE, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDATE;
			finderArgs = new Object[] { DATE };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BYDATE;
			finderArgs = new Object[] { DATE, start, end, orderByComparator };
		}

		List<user_monitor> list = (List<user_monitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (user_monitor user_monitor : list) {
				if (!Validator.equals(DATE, user_monitor.getDATE())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_USER_MONITOR_WHERE);

			boolean bindDATE = false;

			if (DATE == null) {
				query.append(_FINDER_COLUMN_BYDATE_DATE_1);
			}
			else {
				bindDATE = true;

				query.append(_FINDER_COLUMN_BYDATE_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(user_monitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATE) {
					qPos.add(CalendarUtil.getTimestamp(DATE));
				}

				if (!pagination) {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<user_monitor>(list);
				}
				else {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public user_monitor findByByDATE_First(Date DATE,
		OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = fetchByByDATE_First(DATE, orderByComparator);

		if (user_monitor != null) {
			return user_monitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATE=");
		msg.append(DATE);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchuser_monitorException(msg.toString());
	}

	/**
	 * Returns the first user_monitor in the ordered set where DATE = &#63;.
	 *
	 * @param DATE the d a t e
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByByDATE_First(Date DATE,
		OrderByComparator orderByComparator) throws SystemException {
		List<user_monitor> list = findByByDATE(DATE, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public user_monitor findByByDATE_Last(Date DATE,
		OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = fetchByByDATE_Last(DATE, orderByComparator);

		if (user_monitor != null) {
			return user_monitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("DATE=");
		msg.append(DATE);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchuser_monitorException(msg.toString());
	}

	/**
	 * Returns the last user_monitor in the ordered set where DATE = &#63;.
	 *
	 * @param DATE the d a t e
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user_monitor, or <code>null</code> if a matching user_monitor could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByByDATE_Last(Date DATE,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByByDATE(DATE);

		if (count == 0) {
			return null;
		}

		List<user_monitor> list = findByByDATE(DATE, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public user_monitor[] findByByDATE_PrevAndNext(long recordId, Date DATE,
		OrderByComparator orderByComparator)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = findByPrimaryKey(recordId);

		Session session = null;

		try {
			session = openSession();

			user_monitor[] array = new user_monitorImpl[3];

			array[0] = getByByDATE_PrevAndNext(session, user_monitor, DATE,
					orderByComparator, true);

			array[1] = user_monitor;

			array[2] = getByByDATE_PrevAndNext(session, user_monitor, DATE,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected user_monitor getByByDATE_PrevAndNext(Session session,
		user_monitor user_monitor, Date DATE,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USER_MONITOR_WHERE);

		boolean bindDATE = false;

		if (DATE == null) {
			query.append(_FINDER_COLUMN_BYDATE_DATE_1);
		}
		else {
			bindDATE = true;

			query.append(_FINDER_COLUMN_BYDATE_DATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(user_monitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDATE) {
			qPos.add(CalendarUtil.getTimestamp(DATE));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(user_monitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<user_monitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user_monitors where DATE = &#63; from the database.
	 *
	 * @param DATE the d a t e
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByByDATE(Date DATE) throws SystemException {
		for (user_monitor user_monitor : findByByDATE(DATE, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(user_monitor);
		}
	}

	/**
	 * Returns the number of user_monitors where DATE = &#63;.
	 *
	 * @param DATE the d a t e
	 * @return the number of matching user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByByDATE(Date DATE) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYDATE;

		Object[] finderArgs = new Object[] { DATE };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USER_MONITOR_WHERE);

			boolean bindDATE = false;

			if (DATE == null) {
				query.append(_FINDER_COLUMN_BYDATE_DATE_1);
			}
			else {
				bindDATE = true;

				query.append(_FINDER_COLUMN_BYDATE_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDATE) {
					qPos.add(CalendarUtil.getTimestamp(DATE));
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYDATE_DATE_1 = "user_monitor.DATE IS NULL";
	private static final String _FINDER_COLUMN_BYDATE_DATE_2 = "user_monitor.DATE = ?";

	public user_monitorPersistenceImpl() {
		setModelClass(user_monitor.class);
	}

	/**
	 * Caches the user_monitor in the entity cache if it is enabled.
	 *
	 * @param user_monitor the user_monitor
	 */
	@Override
	public void cacheResult(user_monitor user_monitor) {
		EntityCacheUtil.putResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorImpl.class, user_monitor.getPrimaryKey(), user_monitor);

		user_monitor.resetOriginalValues();
	}

	/**
	 * Caches the user_monitors in the entity cache if it is enabled.
	 *
	 * @param user_monitors the user_monitors
	 */
	@Override
	public void cacheResult(List<user_monitor> user_monitors) {
		for (user_monitor user_monitor : user_monitors) {
			if (EntityCacheUtil.getResult(
						user_monitorModelImpl.ENTITY_CACHE_ENABLED,
						user_monitorImpl.class, user_monitor.getPrimaryKey()) == null) {
				cacheResult(user_monitor);
			}
			else {
				user_monitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user_monitors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(user_monitorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(user_monitorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user_monitor.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(user_monitor user_monitor) {
		EntityCacheUtil.removeResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorImpl.class, user_monitor.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<user_monitor> user_monitors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (user_monitor user_monitor : user_monitors) {
			EntityCacheUtil.removeResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
				user_monitorImpl.class, user_monitor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user_monitor with the primary key. Does not add the user_monitor to the database.
	 *
	 * @param recordId the primary key for the new user_monitor
	 * @return the new user_monitor
	 */
	@Override
	public user_monitor create(long recordId) {
		user_monitor user_monitor = new user_monitorImpl();

		user_monitor.setNew(true);
		user_monitor.setPrimaryKey(recordId);

		return user_monitor;
	}

	/**
	 * Removes the user_monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recordId the primary key of the user_monitor
	 * @return the user_monitor that was removed
	 * @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor remove(long recordId)
		throws NoSuchuser_monitorException, SystemException {
		return remove((Serializable)recordId);
	}

	/**
	 * Removes the user_monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user_monitor
	 * @return the user_monitor that was removed
	 * @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor remove(Serializable primaryKey)
		throws NoSuchuser_monitorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			user_monitor user_monitor = (user_monitor)session.get(user_monitorImpl.class,
					primaryKey);

			if (user_monitor == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchuser_monitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(user_monitor);
		}
		catch (NoSuchuser_monitorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected user_monitor removeImpl(user_monitor user_monitor)
		throws SystemException {
		user_monitor = toUnwrappedModel(user_monitor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(user_monitor)) {
				user_monitor = (user_monitor)session.get(user_monitorImpl.class,
						user_monitor.getPrimaryKeyObj());
			}

			if (user_monitor != null) {
				session.delete(user_monitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (user_monitor != null) {
			clearCache(user_monitor);
		}

		return user_monitor;
	}

	@Override
	public user_monitor updateImpl(
		it.laitspa.usermonitor.model.user_monitor user_monitor)
		throws SystemException {
		user_monitor = toUnwrappedModel(user_monitor);

		boolean isNew = user_monitor.isNew();

		user_monitorModelImpl user_monitorModelImpl = (user_monitorModelImpl)user_monitor;

		Session session = null;

		try {
			session = openSession();

			if (user_monitor.isNew()) {
				session.save(user_monitor);

				user_monitor.setNew(false);
			}
			else {
				session.merge(user_monitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !user_monitorModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((user_monitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPEACCESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						user_monitorModelImpl.getOriginalTypeAccess()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTYPEACCESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPEACCESS,
					args);

				args = new Object[] { user_monitorModelImpl.getTypeAccess() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYTYPEACCESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYTYPEACCESS,
					args);
			}

			if ((user_monitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						user_monitorModelImpl.getOriginalDATE()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDATE,
					args);

				args = new Object[] { user_monitorModelImpl.getDATE() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYDATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BYDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
			user_monitorImpl.class, user_monitor.getPrimaryKey(), user_monitor);

		return user_monitor;
	}

	protected user_monitor toUnwrappedModel(user_monitor user_monitor) {
		if (user_monitor instanceof user_monitorImpl) {
			return user_monitor;
		}

		user_monitorImpl user_monitorImpl = new user_monitorImpl();

		user_monitorImpl.setNew(user_monitor.isNew());
		user_monitorImpl.setPrimaryKey(user_monitor.getPrimaryKey());

		user_monitorImpl.setRecordId(user_monitor.getRecordId());
		user_monitorImpl.setUserName(user_monitor.getUserName());
		user_monitorImpl.setUserSurname(user_monitor.getUserSurname());
		user_monitorImpl.setUserRealName(user_monitor.getUserRealName());
		user_monitorImpl.setEmailAddress(user_monitor.getEmailAddress());
		user_monitorImpl.setRemoteIp(user_monitor.getRemoteIp());
		user_monitorImpl.setDataLogin(user_monitor.getDataLogin());
		user_monitorImpl.setTypeAccess(user_monitor.getTypeAccess());
		user_monitorImpl.setUserMonitorId(user_monitor.getUserMonitorId());
		user_monitorImpl.setDATE(user_monitor.getDATE());

		return user_monitorImpl;
	}

	/**
	 * Returns the user_monitor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_monitor
	 * @return the user_monitor
	 * @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchuser_monitorException, SystemException {
		user_monitor user_monitor = fetchByPrimaryKey(primaryKey);

		if (user_monitor == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchuser_monitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return user_monitor;
	}

	/**
	 * Returns the user_monitor with the primary key or throws a {@link it.laitspa.usermonitor.NoSuchuser_monitorException} if it could not be found.
	 *
	 * @param recordId the primary key of the user_monitor
	 * @return the user_monitor
	 * @throws it.laitspa.usermonitor.NoSuchuser_monitorException if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor findByPrimaryKey(long recordId)
		throws NoSuchuser_monitorException, SystemException {
		return findByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns the user_monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user_monitor
	 * @return the user_monitor, or <code>null</code> if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		user_monitor user_monitor = (user_monitor)EntityCacheUtil.getResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
				user_monitorImpl.class, primaryKey);

		if (user_monitor == _nulluser_monitor) {
			return null;
		}

		if (user_monitor == null) {
			Session session = null;

			try {
				session = openSession();

				user_monitor = (user_monitor)session.get(user_monitorImpl.class,
						primaryKey);

				if (user_monitor != null) {
					cacheResult(user_monitor);
				}
				else {
					EntityCacheUtil.putResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
						user_monitorImpl.class, primaryKey, _nulluser_monitor);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(user_monitorModelImpl.ENTITY_CACHE_ENABLED,
					user_monitorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return user_monitor;
	}

	/**
	 * Returns the user_monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recordId the primary key of the user_monitor
	 * @return the user_monitor, or <code>null</code> if a user_monitor with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public user_monitor fetchByPrimaryKey(long recordId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)recordId);
	}

	/**
	 * Returns all the user_monitors.
	 *
	 * @return the user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<user_monitor> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<user_monitor> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<user_monitor> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<user_monitor> list = (List<user_monitor>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USER_MONITOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USER_MONITOR;

				if (pagination) {
					sql = sql.concat(user_monitorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<user_monitor>(list);
				}
				else {
					list = (List<user_monitor>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user_monitors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (user_monitor user_monitor : findAll()) {
			remove(user_monitor);
		}
	}

	/**
	 * Returns the number of user_monitors.
	 *
	 * @return the number of user_monitors
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USER_MONITOR);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the user_monitor persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.it.laitspa.usermonitor.model.user_monitor")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<user_monitor>> listenersList = new ArrayList<ModelListener<user_monitor>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<user_monitor>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(user_monitorImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USER_MONITOR = "SELECT user_monitor FROM user_monitor user_monitor";
	private static final String _SQL_SELECT_USER_MONITOR_WHERE = "SELECT user_monitor FROM user_monitor user_monitor WHERE ";
	private static final String _SQL_COUNT_USER_MONITOR = "SELECT COUNT(user_monitor) FROM user_monitor user_monitor";
	private static final String _SQL_COUNT_USER_MONITOR_WHERE = "SELECT COUNT(user_monitor) FROM user_monitor user_monitor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "user_monitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No user_monitor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No user_monitor exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(user_monitorPersistenceImpl.class);
	private static user_monitor _nulluser_monitor = new user_monitorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<user_monitor> toCacheModel() {
				return _nulluser_monitorCacheModel;
			}
		};

	private static CacheModel<user_monitor> _nulluser_monitorCacheModel = new CacheModel<user_monitor>() {
			@Override
			public user_monitor toEntityModel() {
				return _nulluser_monitor;
			}
		};
}