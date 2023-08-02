CREATE TABLE courses (
	course_name VARCHAR(50),
	id VARCHAR(8) primary key,
	description VARCHAR(200),
	start_date date,
	end_date date,
	last_updated timestamp
);

create table student(
	student_name VARCHAR(50),
	id VARCHAR(8) primary key,
	address VARCHAR(100),
	date_of_birth date,
	description VARCHAR(200),
	enrolled_date date,
	last_updated timestamp
);

create table registered_courses(
	course_id VARCHAR(8),
	student_id VARCHAR(8),
	startDate date,
	endDate date,
	grade VARCHAR(1),
	status VARCHAR(8), -- status = enrolled/withdrawn/completed
	notes VARCHAR(200),
	last_modified timestamp
);

insert into courses (course_name, id, description, start_date, end_date) values('Computer Science A','CSA001','Computer Sciece with Java','2023-08-01','2024-01-31');
insert into courses (course_name, id, description, start_date, end_date) values('Computer Science Principles','CSP001','Computer Science Principles is the basic course to purse before taking any course','2023-08-01','2024-01-31');
insert into courses (course_name, id, description, start_date, end_date) values('Language Arts','LA001','Language Arts Course for 9th Grade','2023-08-01','2024-01-31');

insert into student (student_name, id, address, date_of_birth, enrolled_date) values('Sandilya Parimi','PARSAN25','23231 SE 50th ST Issaquah, WA-98029','12/27/2006','2023-07-01');
insert into student (student_name, id, address, date_of_birth, enrolled_date) values('Achyut Parimi','PARACH25','23231 SE 50th ST Issaquah, WA-98029','07/31/1978','2023-07-01');
insert into student (student_name, id, address, date_of_birth, enrolled_date) values('Jyothsna Parimi','PARJYO25','23231 SE 50th ST Issaquah, WA-98029','07/07/1981','2023-07-01');

insert into registered_courses 
(course_id, student_id, startdate, enddate, grade, status, notes) values
('CSA001','PARSAN25','2023-08-01','2024-01-31','A','Complete', 'Congratulations');

alter table courses alter column last_updated type timestamp;
alter table courses alter column last_updated set default current_timestamp;
-- update table courses set description to "Computer Science Principles is the basic course to purse before taking any course" 
update  courses set description ='Language Arts Course for 9th Grade.'
where id='LA001'

alter table student alter column last_updated set default current_timestamp;
alter table student drop column description

alter table registered_courses add column id serial primary key;
alter table registered_courses alter column last_modified set default current_timestamp;

SELECT rc.course_id, rc.student_id, rc.startdate, rc.enddate, rc.grade, rc.Notes, std.student_name, crs.course_name" +
                        "                        FROM registered_courses rc" +
                        "                        JOIN student std ON rc.student_id=std.id" +
                        "                        JOIN courses crs ON rc.course_id = crs.id" +
                        "                        WHERE rc.student_id=:id"
                        
SELECT rc.course_id, rc.student_id, rc.startDate, rc.endDate, rc.grade, rc.Notes, crs.course_name, std.student_name" + 
						"							FROM registered_courses rc" +
						"							JOIN student std ON rc.student_id=std.id" +
						"							JOIN courses crs ON rc.course_id = crs.id" +
						"							WHERE rc.course_id=:crs_id" +
						"							AND rc.student_id=:id"
													
													
													
