create database recruitmentSystem;

create schema recruitment_system;

create table employee(
employee_id serial primary key,
username varchar(255) unique not null,
password varchar(255) not null,
active boolean,
role varchar(20)
);
create table candidate(
candidate_id serial primary key,
first_name varchar(255) not null,
last_name varchar(255) not null,
ssn varchar(55) unique not null
);
create table application(
application_id serial primary key,
creation_date date not null,
recruiter_comment varchar(500),
fk_candidate int not null,
fk_recruiter int not null,
foreign key (fk_candidate) references candidate(candidate_id),
foreign key (fk_recruiter) references employee(employee_id)
);
create table form(
form_id serial primary key,
name varchar(255) not null,
average_grade float,
interviewer_comment varchar(500),
fk_application int not null,
fk_interviewer int not null,
foreign key (fk_application) references application(application_id),
foreign key (fk_interviewer) references employee(employee_id)
);
create table skill_group(
skill_group_id serial primary key,
skill_name varchar(55) not null,
average_grade float,
fk_form int not null,
foreign key (fk_form) references form(form_id)
);
create table topic(
topic_id serial primary key,
topic_name varchar(255) not null,
grade int,
comment varchar(500),
mandatory boolean not null,
fk_skill_group int not null,
foreign key(fk_skill_group) references skill_group(skill_group_id)
);
create table form_template(
template_id serial primary key,
template_name varchar(255) unique not null
);
create table skill_group_template(
skill_group_template_id serial primary key,
skill_group_name varchar(255) unique not null
);
create table form_skill_group_template(
form_skill_group_template_id serial primary key,
fk_form_template int,
fk_skill_group_template int,
foreign key (fk_form_template) references form_template(template_id),
foreign key (fk_skill_group_template) references skill_group_template(skill_group_template_id)
);
create table topic_template(
topic_template_id serial primary key,
topic_name varchar(255) unique not null,
fk_skill_group_template int not null,
foreign key (fk_skill_group_template) references skill_group_template(skill_group_template_id)
);

