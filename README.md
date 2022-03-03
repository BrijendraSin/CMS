# CMS

Created 5 Controller 
- College
- Course
- Professor
- Student
- Grade
In these you can add their Respective data.

I have added the Postgres Connection in Application properties

Then I have created Repository for All the 5 main things to contact with Postgres Database for simple save() and FindAll() JPA method.
Then I have create NativeRepostiy for native query for Function calling in that from the DB.

DB Queries to create Table in Postgres 

For creating Student Table
create table student(
id bigserial primary key,
first_name varchar,
middle_name varchar,
last_name varchar,
college_id  bigint ,
constraint fk_college_id foreign key(college_id)
references college(id)
);

For creating College Table

create table college(
id bigserial primary key,
name varchar,
session varchar
);

For creating CourseTable

create table course(
id bigserial primary key,
course_name varchar,
student_id bigint,
semester int,
constraint fk_student_course_id foreign key(student_id)
references student(id));

For creating GradeTable

create table grade(
id bigserial primary key,
course_id bigint,
student_id bigint,
grade varchar,
constraint fk_grade_course_id foreign key(course_id)
references course(id),
constraint fk_grade_student_id foreign key(student_id)
references student(id));


Function for calling Native Query for Professor details with student name,school name, courses which student has taken and their grades.

drop function public.fn_get_student_course_grade(bigint,bigint);
create function public.fn_get_student_course_grade(
var_professor_id bigint ,  
var_college_id bigint)
returns table
(
id bigint,
student_name varchar,
professor_name varchar,
course_name varchar,
college_name varchar,
grade varchar)
language plpgsql
as $$
begin 
	return query 
	select row_number() over(partition by c.id)as id, concat_ws('',s.first_name,s.last_name)::varchar student_name,concat_ws('',p.first_name,p.last_name)::varchar professor_name,c.course_name,cg.name,g.grade
	from college cg
	left join professor p on p.college_id = cg.id 
	left join student s on s.college_id = cg.id 
	left join course c on c.student_id = s.id 
	left join grade g on g.course_id = c.id and g.student_id = s.id
where cg.id = var_college_id and p.id = var_professor_id  ;
end;
$$;

For Calling above Function  here is it's query 
select * from public.fn_get_student_course_grade(1,1)
