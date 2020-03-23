create table UserMonitor_user_monitor (
	ID INTEGER not null primary key,
	NAME VARCHAR(75) null,
	USERNAME VARCHAR(75) null,
	EMAILADDRESS VARCHAR(75) null,
	REMOTEIPADDRESS VARCHAR(75) null,
	DATALOGIN_LOGOUT VARCHAR(75) null,
	TYPE_ACCESS VARCHAR(75) null,
	SURNAME VARCHAR(75) null
);

create table user_monitor (
	recordId LONG not null primary key,
	userName VARCHAR(75) null,
	userSurname VARCHAR(75) null,
	userRealName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	remoteIp VARCHAR(75) null,
	dataLogin VARCHAR(75) null,
	typeAccess VARCHAR(75) null,
	UserMonitorId LONG,
	DATE DATE null
);