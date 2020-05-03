use bank;

select account_id, product_cd
FROM account;

SELECT *
FROM department;

SELECT emp_id,
       'ACTIVE',
       emp_id * 3.14159,
       UPPER(lname)
FROM employee;

SELECT VERSION( ),
       USER( ),
DATABASE( );

SELECT emp_id,
       'ACTIVE' status,
       emp_id * 3.14159 empid_x_pi,
       UPPER(lname) last_name_upper
FROM employee;

SELECT DISTINCT cust_id
FROM account;

CREATE VIEW employee_vw AS
  SELECT emp_id, fname, lname,
         YEAR(start_date) start_year
  FROM employee;

SELECT emp_id, start_year
FROM employee_vw;

SELECT employee.emp_id,
       employee.fname,
       employee.lname,
       department.name dept_name
FROM employee
INNER JOIN department
  ON employee.dept_id = department.dept_id;

SELECT emp_id, fname, lname, start_date, title
FROM employee
WHERE (title = 'Head Teller' AND start_date > '2002-01-01')
OR (title = 'Teller' AND start_date > '2003-01-01');

SELECT account_id, product_cd, open_date, avail_balance
FROM account
ORDER BY avail_balance DESC;

SELECT cust_id, cust_type_cd, city, state, fed_id
FROM customer
ORDER BY RIGHT(fed_id, 3);

SELECT emp_id, title, start_date, fname, lname
FROM employee
ORDER BY 2, 5;

SELECT emp_id, fname, lname
FROM employee
order by lname, fname;

SELECT account_id, cust_id, avail_balance
FROM account
WHERE status = 'ACTIVE'
AND avail_balance > 2500;

SELECT distinct open_emp_id
FROM account;

SELECT p.product_cd, a.cust_id, a.avail_balance
FROM product p INNER JOIN account a
  ON p.product_cd = a.product_cd
WHERE p.product_type_cd = 'ACCOUNT'

SELECT emp_id, fname, lname, start_date
FROM employee
WHERE start_date < '2003-01-01'
AND start_date >= '2001-01-01';

SELECT emp_id, fname, lname, start_date
FROM employee
WHERE start_date BETWEEN '2001-01-01' AND '2003-01-01';

SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE product_cd IN ('CHK', 'SAV', 'CD', 'MM');

SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE product_cd IN (SELECT product_cd
                     FROM product
                     WHERE product_type_cd = 'ACCOUNT')
ORDER BY account_id;

SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE product_cd NOT IN ('CHK', 'SAV', 'CD', 'MM');

SELECT emp_id, fname, lname
FROM employee
WHERE LEFT(lname, 1) = 'T';

SELECT lname
FROM employee
WHERE lname = 'Barker';

SELECT cust_id, fed_id
FROM customer
WHERE fed_id LIKE '___-__-____';

SELECT emp_id, fname, lname
FROM employee
WHERE lname REGEXP '^[FG]';

SELECT emp_id, fname, lname, superior_emp_id
FROM employee
WHERE superior_emp_id IS NULL;

SELECT emp_id, fname, lname, superior_emp_id
FROM employee
WHERE superior_emp_id = NULL;

SELECT emp_id, fname, lname, superior_emp_id
FROM employee
WHERE superior_emp_id IS NOT NULL;

SELECT emp_id, fname, lname, superior_emp_id
FROM employee
WHERE superior_emp_id != 6
OR superior_emp_id IS NULL;

SELECT account_id, open_date
FROM account
WHERE open_date BETWEEN '2002-01-01' AND '2002-12-31';

SELECT account_id, open_date
FROM account
WHERE YEAR(open_date) = 2002;

SELECT e.fname, e.lname, d.name
FROM employee e
  INNER JOIN department d
    ON e.dept_id = d.dept_id;

SELECT e.fname, e.lname, d.name
FROM employee e
  INNER JOIN department d
  USING (dept_id);

SELECT e.fname, e.lname, d.name
FROM employee e,
department d
WHERE e.dept_id = d.dept_id;

SELECT a.account_id, c.fed_id, e.fname, e.lname
FROM account a
  INNER JOIN customer c
    ON a.cust_id = c.cust_id
  INNER JOIN employee e
    ON a.open_emp_id = e.emp_id
WHERE c.cust_type_cd = 'B';

SELECT a.account_id, a.cust_id, a.open_date, a.product_cd, b.branch_id, a.open_emp_id
FROM account a
  INNER JOIN
  (SELECT emp_id, assigned_branch_id
   FROM employee
   WHERE start_date <= '2003-01-01'
   AND (title = 'Teller' OR title = 'Head Teller')) e
    ON a.open_emp_id = e.emp_id
  INNER JOIN
  (SELECT branch_id
   FROM branch
   WHERE name = 'Woburn Branch') b
    ON e.assigned_branch_id = b.branch_id;

SELECT emp_id, assigned_branch_id
FROM employee
WHERE start_date <= '2003-01-01'
AND (title = 'Teller' OR title = 'Head Teller');

SELECT branch_id
FROM branch
WHERE name = 'Woburn Branch';

SELECT a.account_id,
       e.emp_id,
       b_a.name open_branch,
       b_e.name emp_branch
FROM account a
  INNER JOIN branch b_a
    ON a.open_branch_id = b_a.branch_id
  INNER JOIN employee e
    ON a.open_emp_id = e.emp_id
  INNER JOIN branch b_e
    ON e.assigned_branch_id = b_e.branch_id
WHERE a.product_cd = 'CHK'
ORDER BY open_branch;

SELECT e.fname,
       e.lname,
       e_mgr.fname mgr_fname,
       e_mgr.lname mgr_lname
FROM employee e
  INNER JOIN employee e_mgr
    ON e.superior_emp_id = e_mgr.emp_id;

SELECT e.emp_id, e.fname, e.lname, e.start_date
FROM employee e
  INNER JOIN product p
    ON e.start_date >= p.date_offered
  AND e.start_date <= p.date_retired
WHERE p.name = 'nofee checking';

SELECT e1.fname, e1.lname, 'VS' vs, e2.fname, e2.lname
FROM employee e1
  INNER JOIN employee e2
    ON e1.emp_id > e2.emp_id
WHERE e1.title = 'Teller'
AND e2.title = 'Teller';

SELECT e.emp_id, e.fname, e.lname, b.name
FROM employee e
  INNER JOIN branch b
    ON e.assigned_branch_id = b.branch_id;

SELECT a.account_id, c.fed_id, p.name
FROM account a
  INNER JOIN customer c ON a.cust_id = c.cust_id
  INNER JOIN product p ON a.product_cd = p.product_cd
WHERE c.cust_type_cd = 'I';

SELECT e1.emp_id, e1.fname, e1.lname
FROM employee e1
  INNER JOIN employee e2 ON e1.superior_emp_id = e2.emp_id
WHERE e1.dept_id != e2.dept_id;

SELECT 1 num, 'abc' str
UNION
SELECT 9 num, 'xyz' str;

SELECT cust_id, lname name
FROM individual
UNION ALL
SELECT cust_id, name
FROM business;

SELECT cust_id, lname name
FROM individual
UNION ALL
SELECT cust_id, name
FROM business
UNION ALL
SELECT cust_id, name
FROM business;

SELECT emp_id, fname, lname
FROM employee INTERSECT
SELECT cust_id, fname, lname
FROM individual;

SELECT cust_id
FROM account
WHERE product_cd IN ('SAV', 'MM')
UNION ALL
SELECT a.cust_id
FROM account a
  INNER JOIN branch b
    ON a.open_branch_id = b.branch_id
WHERE b.name = 'Woburn Branch'
UNION
SELECT cust_id
FROM account
WHERE avail_balance BETWEEN 500 AND 2500;

SELECT fname, lname
FROM individual
UNION
SELECT fname, lname
FROM employee
order by lname;

USE bank;

SELECT u.name,
       CASE
       WHEN u.open_to_public = 'y' THEN 'Welcome!'
       WHEN u.open_to_public = 'n' THEN 'Go Away!'
       WHEN u.open_to_public IS NULL THEN 'Null!'
       ELSE 'Bad code!'
       END AS column_alias
FROM upfall u;

CREATE TABLE string_tbl
(
    char_fld  CHAR(30),
    vchar_fld VARCHAR(30),
text_fld  TEXT
);

INSERT INTO string_tbl (char_fld, vchar_fld, text_fld)
VALUES ('This is char data',
'This is varchar data',
'This is text data');

UPDATE string_tbl
SET vchar_fld = 'This is a piece of extremely long varchar data'
WHERE vchar_fld LIKE 'This is ';

show warnings;

UPDATE string_tbl
SET text_fld ='This string didn\'t work, but it does now'
WHERE text_fld = 'This is text data';

SELECT text_fld
FROM string_tbl;

SELECT QUOTE(text_fld)
FROM string_tbl;

SELECT 'abcdefg', CHAR(97, 98, 99, 100, 101, 102, 103);

SELECT 'abcdefg', CHAR(128, 129, 130, 131, 132, 133, 134, 135, 136, 137);

SELECT CHAR(138, 139, 140, 141, 142, 143, 144, 145, 146, 147);

SELECT CHAR(148, 149, 150, 151, 152, 153, 154, 155, 156, 157);

SELECT CONCAT('danke sch', CHAR(148), 'n');

SELECT ASCII('ö');

DELETE
FROM string_tbl;

INSERT INTO string_tbl (char_fld, vchar_fld, text_fld)
VALUES ('This string is 28 characters',
'This string is 28 characters',
'This string is 28 characters');

SELECT LENGTH(char_fld)  char_length,
       LENGTH(vchar_fld) varchar_length,
       LENGTH(text_fld)  text_length
FROM string_tbl;

desc string_tbl;

SELECT POSITION('characters' IN vchar_fld)
FROM string_tbl;

SELECT LOCATE('is', vchar_fld, 5)
FROM string_tbl;

SELECT STRCMP('12345', '12345')   12345_12345,
       STRCMP('abcd', 'xyz')      abcd_xyz,
       STRCMP('abcd', 'QRSTUV')   abcd_QRSTUV,
       STRCMP('qrstuv', 'QRSTUV') qrstuv_QRSTUV,
       STRCMP('12345', 'xyz')     12345_xyz,
       STRCMP('xyz', 'qrstuv')    xyz_qrst;

SELECT name, name LIKE '%ns' ends_in_ns
FROM department;

SELECT cust_id,
       cust_type_cd,
       fed_id,
       fed_id REGEXP '.{3}.{2}.{4}' is_ss_no_format
FROM customer;

UPDATE string_tbl
SET text_fld = CONCAT(text_fld, ', but now it is longer');

SELECT CONCAT(fname, ' ', lname, ' has been a ',
       title, ' since ', start_date) emp_narrative
FROM employee
WHERE title = 'Teller' OR title = 'Head Teller';

SELECT INSERT('goodbye world', 9, 0, 'cruel ') string;

SELECT SUBSTRING('goodbye cruel world', 9, 5);

SELECT POSITION('characters' IN vchar_fld)
FROM string_tbl
WHERE vchar_fld LIKE '%28%';

SELECT (37 * 59) / (78 - (8 * 6)) result;

SELECT MOD(10,4);

SELECT MOD(22.75, 5);

SELECT POW(2,8);

SELECT CEIL(72.445), FLOOR(72.445);

SELECT ROUND(72.49999), ROUND(72.5), ROUND(72.50001);

SELECT ROUND(72.0909, 1), ROUND(72.0909, 2), ROUND(72.0909, 3);

SELECT TRUNCATE(72.0909, 1), TRUNCATE(72.0909, 2),
       TRUNCATE(72.0909, 3);

SELECT account_id, SIGN(avail_balance), ABS(avail_balance)
FROM account;