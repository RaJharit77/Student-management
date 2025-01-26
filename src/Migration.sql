CREATE DATABASE course_management;

\c course_management;

-- Table Students --
CREATE TABLE  IF NOT EXISTS "Students" (
    id_student VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F')) NOT NULL,
    birth_date DATE NOT NULL,
    id_group INT,
    FOREIGN KEY (id_group) REFERENCES "Groups"(id_group)
);

-- Table Group --
CREATE TABLE  IF NOT EXISTS "Groups" (
    id_group INT PRIMARY KEY,
    group_name varchar(100) NOT NULL,
    group_year varchar(100) NOT NULL,
    promotion varchar(100) NOT NULL
);
