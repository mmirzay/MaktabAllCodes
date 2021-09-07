-- query 1
SELECT 
	max(SALARY) AS maximum,
	min(SALARY) AS minimum,
	sum(SALARY) AS sum_of_salaries,
	avg(SALARY) AS average
FROM 
	employees;
	

-- query 2
SELECT
	JOB_ID ,
	count(*) AS number_of_employees
FROM
	employees e
GROUP BY
	JOB_ID ;
	
-- query 3

SELECT
	e2.FIRST_NAME ,
	e2.LAST_NAME,
	e2.SALARY,
	(
	SELECT
		max(e.SALARY) - min(e.SALARY)
	FROM
		employees e ) AS difference
FROM
	employees e2
WHERE
	SALARY = (
	SELECT
		max(SALARY)
	FROM
		employees)
	OR SALARY = (
	SELECT
		min(SALARY)
	FROM
		employees) ;

-- query 4

SELECT
	d.DEPARTMENT_NAME ,
	count(*) AS number_of_employees
FROM
	employees e ,
	departments d
WHERE
	e.DEPARTMENT_ID = d.DEPARTMENT_ID
GROUP BY
	d.DEPARTMENT_NAME ;
	

-- query 5
SELECT
	e.FIRST_NAME ,
	e.LAST_NAME
FROM
	employees e
WHERE
	e.HIRE_DATE > (
	SELECT
		e2.HIRE_DATE
	FROM
		employees e2
	WHERE
		e2.LAST_NAME = 'Jones');


-- 	query 6
SELECT
	d.DEPARTMENT_NAME ,
	e.FIRST_NAME ,
	e.LAST_NAME
FROM
	departments d ,
	employees e
WHERE
	d.MANAGER_ID = e.EMPLOYEE_ID ;