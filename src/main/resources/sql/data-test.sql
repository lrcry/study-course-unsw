use studyunsw;

/* User */
insert into UserLogin values (1, 'test', 'testest', date(now()), '');
insert into UserLogin values (2, 'admin', 'admin', date(now()), '');

/* Course */
insert into Course values ('COMP9021', 'Principles of Programming', 'CSE', 2, 1, 'Eric Martin', 'U can hardly pass this unless u work hard.', date(now()));
insert into Course values ('COMP9311', 'Database Systems', 'CSE', 2, 1, 'A. Wong', 'U can easily pass but u still need to work hard because we are double pass.', date(now()));
insert into Course values ('COMP9032', 'Microprocessor and Interfaces', 'CSE', 2, 1, 'Ma\'am Lin', 'I may make u all bored because I am tired.', date(now()));
insert into Course values ('COMP9020', 'Foundation of Computer Science', 'CSE', 2, 1, 'Kai Engelhardt', 'I\'m from Deutschland.', date(now()));
insert into Course values ('COMP9511', 'Human Computer Interactions', 'CSE', 2, 1, 'Nadian Marcus', 'Lots of fresh lecturers and tutors here. $2.49\/kg', date(now()));
insert into Course values ('COMP9024', 'Data Structures and Algorithms', 'CSE', 2, 1, 'A.B.BB', 'U\'d better have an exemption of this course because I won\'t teach u anything new.', date(now()));
insert into Course values ('COMP9319', 'Database System Implementation', 'CSE', 2, 1, 'A. Wong', 'Did not have fun in COMP9311? Still there is a chance for u to understand me and feel better.', date(now()));

/* User-Course */
insert into UserCourse values (1, 'COMP9020');
insert into UserCourse values (1, 'COMP9024');
insert into UserCourse values (1, 'COMP9021');
insert into UserCourse values (1, 'COMP9511');
insert into UserCourse values (2, 'COMP9311');
insert into UserCourse values (2, 'COMP9021');
insert into UserCourse values (2, 'COMP9032');
insert into UserCourse values (2, 'COMP9319');

/* Asgts */
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9021', 'Asgt 1 for basic C', date(now()), '2015-1-6', 'http:\/\/test.com', 1);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9021', 'Asgt 2 for arrays, chars and pointers', '2015-1-16', '2015-1-28', 'http:\/\/test.com', 2);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9021', 'Asgt 3 for integrated training', '2015-2-6', '2015-2-21', 'http:\/\/test.com', 3);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9311', 'Asgt 1 for DDL creating tables', '2015-1-1', '2015-1-20', 'http:\/\/9311.com', 1);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9311', 'Asgt 2 for queries', '2015-1-30', '2015-2-14', 'http:\/\/9311.com', 2);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9511', 'Analysing interfaces by design principles', '2014-12-29', '2015-1-12', 'http:\/\/9511.com', 1);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9024', 'asgt 1', '2015-1-2', '2015-1-18', 'http:\/\/exemption.com', 1);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9024', 'asgt 2', '2015-1-27', '2015-2-15', 'http:\/\/exemption.com', 2);
insert into Assignment (course, description, startDate, endDate, url, nth) 
values ('COMP9032', 'The only assignment for this course', '2015-1-5', '2015-2-28', 'http:\/\/noworries.com', 1);

/* Exams */
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9021', 'No material allowed', '2015-2-18', 'Drum Lab, CSE Building K17', 1
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9021', 'No material allowed', '2015-4-2', 'Drum Lab, CSE Building K17', 2
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9020', 'Notes as specified in lectures', '2015-3-30', '392 Law Building', 2
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9024', 'No material allowed', '2015-2-22', '', 3
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9032', 'No material allowed', '2015-3-27', 'Scientia Lab, G17', 2
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9311', 'No material allowed', '2015-3-16', 'Doncaster Rm, Rndwck R\'Course', 2
);
insert into Exam (course, materials, startDate, examLocation, examType) values (
	'COMP9511', 'No material allowed', '2015-4-17', 'Grandview Rm, RndWck R\'Course', 2
);