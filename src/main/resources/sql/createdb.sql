/* Create database and tables */
create database studyunsw;

use studyunsw;

create table UserLogin (
	userId integer not null primary key auto_increment,
	username varchar(32) not null unique key,
	password char(40) not null,
	createAt date not null,
	lastLoginAt date default null
) default charset=utf8;

create table Course (
	courseCode char(8) not null primary key,
	courseName varchar(128) not null,
	courseAuthority varchar(128) not null,
	semester tinyint(1) not null,
	teachingPeriod tinyint(1) not null,
	lecturerName varchar(64) default null,
	description text default null,
	createAt date not null
) default charset=utf8;

create table TimeLine (
	timeLineId integer not null primary key auto_increment,
	timeLineName varchar(128) default null,
	userId integer not null,
	createAt date not null,
	foreign key (userId) references UserLogin(userId)
) default charset=utf8;

create table Assignment (
	assignmentId integer not null primary key auto_increment,
	course char(8) not null,
	description text default null,
	startDate date default null,
	endDate date not null,
	url varchar(256) default null,
	nth integer default 0,
	foreign key (course) references Course(courseCode)
) default charset=utf8;

create table Exam (
	examId integer not null primary key auto_increment,
	course char(8) not null,
	materials varchar(128) default null,
	startDate date default null,
	examLocation varchar(256) default null,
	examType tinyint(1) default 0,
	foreign key (course) references Course(courseCode)
) default charset=utf8;

/*
 * TimeLineItem is extended to fit in 3 type of items:
 * 1. assignments (assignment id not null, exam 0)
 * 2. exams (assignment id 0, exam id not null)
 * 3. others (assignment id 0, exam id 0)
 * Because MySQL does not support "check constraint" at present, 
 * the constraints above should be checked before updated or 
 * inserted any time in the services.

create table TimeLineItem (
	itemId integer not null primary key auto_increment,
	timeLine integer not null references TimeLine(timeLineId),
	course char(8) default null references Course(courseCode), 
	assignment integer references Assignment(assignmentId), 
	exam integer references Exam(examId), 
	description varchar(256) default null, 
	createAt date not null,
	dueDate date not null
) default charset=utf8;
 */

create table AsgtItem (
	itemId integer not null primary key auto_increment,
	timeLine integer not null,
	description text default null,
	course char(8) not null,
	assignment integer not null,
	createAt date default null,
	dueDate date not null,
	foreign key (timeLine) references TimeLine(timeLineId),
	foreign key (course) references Course(courseCode),
	foreign key (assignment) references Assignment(assignmentId)
) default charset=utf8;

create table ExamItem (
	itemId integer not null primary key auto_increment,
	timeLine integer not null,
	description text default null,
	course char(8) not null,
	exam integer not null,
	createAt date default null,
	dueDate date not null,
	foreign key (timeLine) references TimeLine(timeLineId),
	foreign key (course) references Course(courseCode),
	foreign key (exam) references Exam(examId)
) default charset=utf8;

create table UserItem (
	itemId integer not null primary key auto_increment,
	timeLine integer not null,
	description text default null,
	createAt date default null,
	dueDate date not null,
	foreign key (timeLine) references TimeLine(timeLineId)
) default charset=utf8;

create table UserCourse (
	user integer not null,
	course char(8) not null,
	primary key (user, course),
	foreign key (user) references UserLogin(userId),
	foreign key (course) references Course(courseCode)
) default charset=utf8;

/* Indexes */