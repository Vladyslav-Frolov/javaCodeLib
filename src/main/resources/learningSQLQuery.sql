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

SELECT VERSION(),
       USER(),
       DATABASE();

SELECT emp_id,
       'ACTIVE'         status,
       emp_id * 3.14159 empid_x_pi,
       UPPER(lname)     last_name_upper
FROM employee;

SELECT DISTINCT cust_id
FROM account;

CREATE VIEW employee_vw AS
SELECT emp_id,
       fname,
       lname,
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
FROM product p
         INNER JOIN account a
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
WHERE title = 'Teller'
   OR title = 'Head Teller';

SELECT INSERT('goodbye world', 9, 0, 'cruel ') string;

SELECT SUBSTRING('goodbye cruel world', 9, 5);

SELECT POSITION('characters' IN vchar_fld)
FROM string_tbl
WHERE vchar_fld LIKE '%28%';

SELECT (37 * 59) / (78 - (8 * 6)) result;

SELECT MOD(10, 4);

SELECT MOD(22.75, 5);

SELECT POW(2, 8);

SELECT CEIL(72.445), FLOOR(72.445);

SELECT ROUND(72.49999), ROUND(72.5), ROUND(72.50001);

SELECT ROUND(72.0909, 1), ROUND(72.0909, 2), ROUND(72.0909, 3);

SELECT TRUNCATE(72.0909, 1),
       TRUNCATE(72.0909, 2),
       TRUNCATE(72.0909, 3);

SELECT account_id, SIGN(avail_balance), ABS(avail_balance)
FROM account;

SELECT @@global.time_zone, @@session.time_zone;

SET time_zone = 'Europe/Kiev';

SELECT @@global.time_zone, @@session.time_zone;

use mysql;

SELECT name
FROM time_zone_name;

SELECT CAST('2005-03-27 15:30:00' AS DATETIME);

SELECT CAST('2005-03-27' AS DATE) date_field,
       CAST('18:17:57' AS TIME)   time_field;

SELECT CURRENT_DATE(), CURRENT_TIME(), CURRENT_TIMESTAMP();

SELECT DATE_ADD(CURRENT_DATE(), INTERVAL 5 DAY);

SELECT LAST_DAY('2020-02-25');

SELECT CURRENT_TIMESTAMP()                                  current_est,
       CONVERT_TZ(CURRENT_TIMESTAMP(), 'US/Eastern', 'UTC') current_utc;

SELECT DAYNAME('2020-05-05');

SELECT EXTRACT(SECOND FROM '2005-03-22 22:19:05');

SELECT DATEDIFF('2005-09-05', '2005-06-22');

SELECT DATEDIFF('2005-09-05 23:59:59', '2005-06-22 00:00:01');

SELECT DATEDIFF('2005-06-22', '2005-09-05');

SELECT CAST('1456328' AS SIGNED INTEGER);

SELECT CAST('999ABC111' AS UNSIGNED INTEGER);

SELECT SUBSTRING('Please find the substring in this string', 17, 9);

SELECT ABS(-25.76823), SIGN(-25.76823);

SELECT ROUND(-25.76823, 2);

SELECT EXTRACT(MONTH FROM CURRENT_DATE);

use bank;

SELECT open_emp_id
FROM account;

SELECT open_emp_id
FROM account
GROUP BY open_emp_id;

SELECT open_emp_id, COUNT(*) how_many
FROM account
GROUP BY open_emp_id;

# Invalid use of group function
SELECT open_emp_id, COUNT(*) how_many
FROM account
WHERE COUNT(*) > 4
GROUP BY open_emp_id, product_cd;

SELECT open_emp_id, COUNT(*) how_many
FROM account
GROUP BY open_emp_id
HAVING COUNT(*) > 4;

SELECT MAX(avail_balance) max_balance,
MIN(avail_balance) min_balance,
AVG(avail_balance) avg_balance,
SUM(avail_balance) tot_balance,
COUNT(*)           num_accounts
FROM account
WHERE product_cd = 'CHK';

# ошибку не выдаст, но выдаст несопоставимые (ирреливантные) данные
SELECT product_cd,
MAX(avail_balance) max_balance,
MIN(avail_balance) min_balance,
AVG(avail_balance) avg_balance,
SUM(avail_balance) tot_balance,
COUNT(*)           num_accounts
FROM account;

SELECT product_cd,
MAX(avail_balance) max_balance,
MIN(avail_balance) min_balance,
AVG(avail_balance) avg_balance,
SUM(avail_balance) tot_balance,
COUNT(*)           num_accts
FROM account
GROUP BY product_cd;

SELECT account_id, open_emp_id
FROM account
ORDER BY open_emp_id;

SELECT COUNT(open_emp_id)
FROM account;

SELECT COUNT(DISTINCT open_emp_id)
FROM account;

SELECT DISTINCT open_emp_id
FROM account;

SELECT MAX(pending_balance - avail_balance) max_uncleared
FROM account;

SELECT pending_balance - avail_balance max_uncleared
FROM account;

CREATE TABLE number_tbl
(
val SMALLINT
);
INSERT INTO number_tbl
VALUES (1);
INSERT INTO number_tbl
VALUES (3);
INSERT INTO number_tbl
VALUES (5);

SELECT COUNT(*)   num_rows,
COUNT(val) num_vals,
SUM(val)   total,
MAX(val)   max_val,
AVG(val)   avg_val
FROM number_tbl;

SELECT COUNT(*)        num_rows,
COUNT(val)      num_vals,
SUM(val)        total,
MAX(val)        max_val,
ROUND(AVG(val)) avg_val
FROM number_tbl;

INSERT INTO number_tbl
VALUES (NULL);

SELECT product_cd, SUM(avail_balance) prod_balance
FROM account
GROUP BY product_cd;

SELECT product_cd,
open_branch_id,
SUM(avail_balance) tot_balance
FROM account
GROUP BY product_cd, open_branch_id;

SELECT EXTRACT(YEAR FROM start_date) year,
COUNT(*)                      how_many
FROM employee
GROUP BY EXTRACT(YEAR FROM start_date);

SELECT product_cd,
open_branch_id,
SUM(avail_balance) tot_balance
FROM account
GROUP BY product_cd, open_branch_id
WITH ROLLUP;

SELECT product_cd,
open_branch_id,
SUM(avail_balance) tot_balance
FROM account
GROUP BY product_cd, open_branch_id
ORDER BY tot_balance DESC
limit 1;

SELECT product_cd,
open_branch_id,
SUM(avail_balance) tot_balance
FROM account
GROUP BY product_cd, open_branch_id
WITH ROLLUP;

# WITH CUBE не работает на MySQL
SELECT product_cd,
open_branch_id,
SUM(avail_balance) tot_balance
FROM account
GROUP BY product_cd, open_branch_id
WITH CUBE;

SELECT product_cd, SUM(avail_balance) prod_balance
FROM account
WHERE status = 'ACTIVE'
GROUP BY product_cd
HAVING SUM(avail_balance) >= 10000;

# Invalid use of group function
SELECT product_cd, SUM(avail_balance) prod_balance
FROM account
WHERE status = 'ACTIVE'
AND SUM(avail_balance) > 10000
GROUP BY product_cd;

SELECT product_cd, SUM(avail_balance) prod_balance
FROM account
WHERE status = 'ACTIVE'
GROUP BY product_cd
HAVING MIN(avail_balance) >= 1000
AND MAX(avail_balance) <= 10000;

SELECT COUNT(*)
FROM account;

SELECT cust_id, COUNT(cust_id) amount_of_account
FROM account
GROUP BY cust_id;

SELECT cust_id, COUNT(cust_id) amount_of_account
FROM account
GROUP BY cust_id
HAVING COUNT(*) >= 2;

SELECT product_cd, open_branch_id, SUM(avail_balance)
FROM account
GROUP BY product_cd, open_branch_id
HAVING COUNT(*) > 1
Order by 3 DESC;

SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE account_id = (SELECT MAX(account_id) FROM account);

SELECT MAX(account_id)
FROM account;

DESC account;

SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE open_emp_id <> (SELECT e.emp_id
FROM employee e
INNER JOIN branch b
  ON e.assigned_branch_id = b.branch_id
WHERE e.title = 'Head Teller'
AND b.city = 'Woburn');

# Subquery returns more than 1 row
SELECT account_id, product_cd, cust_id, avail_balance
FROM account
WHERE open_emp_id <> (SELECT e.emp_id
FROM employee e
INNER JOIN branch b
  ON e.assigned_branch_id = b.branch_id
WHERE e.title = 'Teller'
AND b.city = 'Woburn');

SELECT branch_id, name, city
FROM branch
WHERE name IN ('Headquarters', 'Quincy Branch');

SELECT branch_id, name, city
FROM branch
WHERE name = 'Headquarters'
OR name = 'Quincy Branch'

SELECT emp_id, fname, lname, title
FROM employee
WHERE emp_id IN (SELECT superior_emp_id
FROM employee);


SELECT emp_id, fname, lname, title
FROM employee
WHERE emp_id NOT IN (SELECT superior_emp_id
FROM employee
WHERE superior_emp_id IS NOT NULL);

SELECT emp_id, fname, lname, title
FROM employee
WHERE emp_id <> ALL (SELECT superior_emp_id
FROM employee
WHERE superior_emp_id IS NOT NULL);

# возвратиться пустой набор
SELECT emp_id, fname, lname, title
FROM employee
WHERE emp_id NOT IN (1, 2, NULL);

SELECT account_id, cust_id, product_cd, avail_balance
FROM account
WHERE avail_balance < ALL (SELECT a.avail_balance
FROM account a
INNER JOIN individual i
  ON a.cust_id = i.cust_id
WHERE i.fname = 'Frank'
AND i.lname = 'Tucker');

SELECT account_id, cust_id, product_cd, avail_balance
FROM account
WHERE avail_balance > ANY (SELECT a.avail_balance
FROM account a
INNER JOIN individual i
  ON a.cust_id = i.cust_id
WHERE i.fname = 'Frank'
AND i.lname = 'Tucker');

SELECT account_id, product_cd, cust_id
FROM account
WHERE open_branch_id = (SELECT branch_id
FROM branch
WHERE name = 'Woburn Branch')
AND open_emp_id IN (SELECT emp_id
FROM employee
WHERE title = 'Teller'
OR title = 'Head Teller');

SELECT account_id, product_cd, cust_id
FROM account
WHERE (open_branch_id, open_emp_id) IN
(SELECT b.branch_id, e.emp_id
FROM branch b
INNER JOIN employee e
  ON b.branch_id = e.assigned_branch_id
WHERE b.name = 'Woburn Branch'
AND (e.title = 'Teller' OR e.title = 'Head Teller'));

SELECT 'ALERT! : Account #1 Has Incorrect Balance!'
FROM account
WHERE (avail_balance, pending_balance) <>
(SELECT SUM( < expression to generate available balance>), SUM(
<expression to generate pending balance
>
)
FROM transaction
WHERE account_id = 1
)
AND
account_id
=
1;

SELECT c.cust_id, c.cust_type_cd, c.city
FROM customer c
WHERE 2 = (SELECT COUNT(*)
FROM account a
WHERE a.cust_id = c.cust_id
group by c.cust_id); # без этого блока груп бай, код тоже выполнется корректно

SELECT COUNT(*)
FROM account a,
customer c
WHERE a.cust_id = c.cust_id
group by c.cust_id;

SELECT c.cust_id, c.cust_type_cd, c.city
FROM customer c
WHERE (SELECT SUM(a.avail_balance)
FROM account a
WHERE a.cust_id = c.cust_id)
BETWEEN 5000 AND 10000;

SELECT account_id, 2*5 ds, product_cd, cust_id
FROM account;

CASE
WHEN employee.title = 'Head Teller'
THEN 'Head Teller'
WHEN employee.title = 'Teller'
AND YEAR(employee.start_date) > 2004
THEN 'Teller Trainee'
WHEN employee.title = 'Teller'
AND YEAR(employee.start_date) < 2003
THEN 'Experienced Teller'
WHEN employee.title = 'Teller'
THEN 'Teller'
ELSE 'NonTeller'
END

SELECT c.cust_id, c.fed_id,
CASE
WHEN c.cust_type_cd = 'I' THEN
(SELECT CONCAT(i.fname, ' ', i.lname)
FROM individual i
WHERE i.cust_id = c.cust_id)
WHEN c.cust_type_cd = 'B' THEN
(SELECT b.name
FROM business b
WHERE b.cust_id = c.cust_id)
ELSE 'Unknown'
END name
FROM customer c;