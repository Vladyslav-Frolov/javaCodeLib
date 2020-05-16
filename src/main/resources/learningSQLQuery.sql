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

SELECT account_id, 2 * 5 ds, product_cd, cust_id
FROM account;

SELECT account_id, account_id * cust_id ds, product_cd, cust_id
FROM account;

SELECT a.account_id, a.product_cd, a.cust_id, a.avail_balance
FROM account a
WHERE EXISTS(SELECT 1
FROM transaction t
WHERE t.account_id = a.account_id
AND t.txn_date = '2000-01-15');

SELECT t.txn_id
FROM account a,
transaction t
WHERE t.account_id = a.account_id
AND t.txn_date = '2000-01-15';

SELECT a.account_id, a.product_cd, a.cust_id, a.avail_balance
FROM account a
WHERE EXISTS(SELECT t.txn_id, 'hello', 3.1415927
FROM transaction t
WHERE t.account_id = a.account_id
AND t.txn_date = '2000-01-15');

SELECT t.txn_id, 'hello', 3.1415927
FROM account a,
transaction t
WHERE t.account_id = a.account_id
AND t.txn_date = '2000-01-15';

SELECT a.account_id, a.product_cd, a.cust_id
FROM account a
WHERE NOT EXISTS(SELECT 1
FROM business b
WHERE b.cust_id = a.cust_id);

SELECT a.account_id, a.product_cd, a.cust_id
FROM account a;

UPDATE account a
SET a.last_activity_date =
(SELECT MAX(t.txn_date)
FROM transaction t
WHERE t.account_id = a.account_id);

SELECT a.last_activity_date
FROM account a;

UPDATE account a
SET a.last_activity_date =
(SELECT MAX(t.txn_date)
FROM transaction t
WHERE t.account_id = a.account_id)
WHERE EXISTS(SELECT 1
FROM transaction t
WHERE t.account_id = a.account_id);

DELETE
FROM department
WHERE NOT EXISTS(SELECT 1
FROM employee
WHERE employee.dept_id = department.dept_id);

SELECT employee.emp_id
FROM employee,
department
WHERE employee.dept_id = department.dept_id;

SELECT d.dept_id, d.name, e_cnt.how_many num_employees
FROM department d
INNER JOIN
(SELECT dept_id, COUNT(*) how_many
FROM employee
GROUP BY dept_id) e_cnt
  ON d.dept_id = e_cnt.dept_id;

SELECT dept_id, COUNT(*) how_many
FROM employee
GROUP BY dept_id;

# преобразование внутреннего соединения в во внутреннее соединение без блока JOIN
SELECT d.dept_id, d.name, e_cnt.how_many num_employees
FROM department d,
(SELECT dept_id, COUNT(*) how_many
FROM employee
GROUP BY dept_id) e_cnt
WHERE d.dept_id = e_cnt.dept_id;

SELECT 'Small Fry' name, 0 low_limit, 4999.99 high_limit
UNION ALL
SELECT 'Average Joes' name, 5000 low_limit, 9999.99 high_limit
UNION ALL
SELECT 'Heavy Hitters' name, 10000 low_limit, 9999999.99 high_limit;

SELECT groupss.name, COUNT(*) num_customers
FROM (SELECT SUM(a.avail_balance) cust_balance
FROM account a
INNER JOIN product p
  ON a.product_cd = p.product_cd
WHERE p.product_type_cd = 'ACCOUNT'
GROUP BY a.cust_id) cust_rollup
INNER JOIN
(SELECT 'Small Fry' name, 0 low_limit, 4999.99 high_limit
UNION ALL
SELECT 'Average Joes' name,
5000           low_limit,
9999.99        high_limit
UNION ALL
SELECT 'Heavy Hitters' name,
10000           low_limit,
9999999.99      high_limit) groupss
  ON cust_rollup.cust_balance
BETWEEN groupss.low_limit AND groupss.high_limit
GROUP BY groupss.name;

SELECT SUM(a.avail_balance) cust_balance
FROM account a
INNER JOIN product p
  ON a.product_cd = p.product_cd
WHERE p.product_type_cd = 'ACCOUNT'
GROUP BY a.cust_id;

SELECT p.name                        product,
b.name                        branch,
CONCAT(e.fname, ' ', e.lname) name,
SUM(a.avail_balance)          tot_deposits
FROM account a
INNER JOIN employee e
  ON a.open_emp_id = e.emp_id
INNER JOIN branch b
  ON a.open_branch_id = b.branch_id
INNER JOIN product p
  ON a.product_cd = p.product_cd
WHERE p.product_type_cd = 'ACCOUNT'
GROUP BY p.name, b.name, e.fname, e.lname;

SELECT product_cd,
open_branch_id     branch_id,
open_emp_id        emp_id,
SUM(avail_balance) tot_deposits
FROM account
GROUP BY product_cd, open_branch_id, open_emp_id;

SELECT p.name                        product,
b.name                        branch,
CONCAT(e.fname, ' ', e.lname) name,
account_groups.tot_deposits
FROM (SELECT product_cd,
open_branch_id     branch_id,
open_emp_id        emp_id,
SUM(avail_balance) tot_deposits
FROM account
GROUP BY product_cd, open_branch_id, open_emp_id) account_groups
INNER JOIN employee e ON e.emp_id = account_groups.emp_id
INNER JOIN branch b ON b.branch_id = account_groups.branch_id
INNER JOIN product p ON p.product_cd = account_groups.product_cd
WHERE p.product_type_cd = 'ACCOUNT';

SELECT open_emp_id, COUNT(*) how_many
FROM account
GROUP BY open_emp_id
HAVING COUNT(*) = (SELECT MAX(emp_cnt.how_many)
FROM (SELECT COUNT(*) how_many
FROM account
GROUP BY open_emp_id) emp_cnt);

SELECT (SELECT p.name
FROM product p
WHERE p.product_cd = a.product_cd
AND p.product_type_cd = 'ACCOUNT')  product,
(SELECT b.name
FROM branch b
WHERE b.branch_id = a.open_branch_id) branch,
(SELECT CONCAT(e.fname, ' ', e.lname)
FROM employee e
WHERE e.emp_id = a.open_emp_id)       name,
SUM(a.avail_balance)                   tot_deposits
FROM account a
GROUP BY a.product_cd, a.open_branch_id, a.open_emp_id;

SELECT all_prods.product,
all_prods.branch,
all_prods.name,
all_prods.tot_deposits
FROM (SELECT (SELECT p.name
FROM product p
WHERE p.product_cd = a.product_cd
AND p.product_type_cd = 'ACCOUNT')  product,
(SELECT b.name
FROM branch b
WHERE b.branch_id = a.open_branch_id) branch,
(SELECT CONCAT(e.fname, ' ', e.lname)
FROM employee e
WHERE e.emp_id = a.open_emp_id)       name,
SUM(a.avail_balance)                   tot_deposits
FROM account a
GROUP BY a.product_cd, a.open_branch_id, a.open_emp_id) all_prods
WHERE all_prods.product IS NOT NULL;

SELECT emp.emp_id,
CONCAT(emp.fname, ' ', emp.lname)         emp_name,
(SELECT CONCAT(boss.fname, ' ', boss.lname)
FROM employee boss
WHERE boss.emp_id = emp.superior_emp_id) boss_name
FROM employee emp
WHERE emp.superior_emp_id IS NOT NULL
ORDER BY (SELECT boss.lname
FROM employee boss
WHERE boss.emp_id = emp.superior_emp_id), emp.lname;

INSERT INTO account
(account_id, product_cd, cust_id, open_date, last_activity_date,
status, open_branch_id, open_emp_id, avail_balance, pending_balance)
VALUES (NULL,
(SELECT product_cd FROM product WHERE name = 'savings account'),
(SELECT cust_id FROM customer WHERE fed_id = '555-55-5555'),
'2005-01-25', '2005-01-25', 'ACTIVE',
(SELECT branch_id FROM branch WHERE name = 'Quincy Branch'),
(SELECT emp_id FROM employee WHERE lname = 'Portman' AND fname = 'Frank'),
0, 0);

SELECT account_id, cust_id
FROM account;

SELECT cust_id
FROM customer;

SELECT a.account_id, c.cust_id
FROM account a
INNER JOIN customer c
  ON a.cust_id = c.cust_id;

SELECT a.account_id, b.cust_id, b.name
FROM account a
INNER JOIN business b
  ON a.cust_id = b.cust_id;

SELECT cust_id, name
FROM business;

SELECT a.account_id, a.cust_id, b.name
FROM account a
LEFT OUTER JOIN business b
  ON a.cust_id = b.cust_id;

SELECT a.account_id, a.cust_id, i.fname, i.lname
FROM account a
LEFT OUTER JOIN individual i
  ON a.cust_id = i.cust_id;

SELECT c.cust_id, b.name
FROM customer c
LEFT OUTER JOIN business b
  ON c.cust_id = b.cust_id;

SELECT c.cust_id, b.name
FROM customer c
RIGHT OUTER JOIN business b
  ON c.cust_id = b.cust_id;

SELECT a.account_id,
a.product_cd,
CONCAT(i.fname, ' ', i.lname) person_name,
b.name                        business_name
FROM account a
LEFT OUTER JOIN individual i
  ON a.cust_id = i.cust_id
LEFT OUTER JOIN business b
  ON a.cust_id = b.cust_id;

SELECT account_ind.account_id,
account_ind.product_cd,
account_ind.person_name,
b.name business_name
FROM (SELECT a.account_id,
a.product_cd,
a.cust_id,
CONCAT(i.fname, ' ', i.lname) person_name
FROM account a
LEFT OUTER JOIN individual i
  ON a.cust_id = i.cust_id) account_ind
LEFT OUTER JOIN business b
  ON account_ind.cust_id = b.cust_id;

SELECT e.fname,
e.lname,
e_mgr.fname mgr_fname,
e_mgr.lname mgr_lname
FROM employee e
INNER JOIN employee e_mgr
  ON e.superior_emp_id = e_mgr.emp_id;

SELECT e.fname,
e.lname,
e_mgr.fname mgr_fname,
e_mgr.lname mgr_lname
FROM employee e
LEFT OUTER JOIN employee e_mgr
  ON e.superior_emp_id = e_mgr.emp_id;

SELECT e.fname,
e.lname,
e_mgr.fname mgr_fname,
e_mgr.lname mgr_lname
FROM employee e
RIGHT OUTER JOIN employee e_mgr
  ON e.superior_emp_id = e_mgr.emp_id;

SELECT pt.name, p.product_cd, p.name
FROM product p
CROSS JOIN product_type pt;

SELECT ones.num + tens.num + hundreds.num
FROM (SELECT 0 num
UNION ALL
SELECT 1 num
UNION ALL
SELECT 2 num
UNION ALL
SELECT 3 num
UNION ALL
SELECT 4 num
UNION ALL
SELECT 5 num
UNION ALL
SELECT 6 num
UNION ALL
SELECT 7 num
UNION ALL
SELECT 8 num
UNION ALL
SELECT 9 num) ones
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 10 num
UNION ALL
SELECT 20 num
UNION ALL
SELECT 30 num
UNION ALL
SELECT 40 num
UNION ALL
SELECT 50 num
UNION ALL
SELECT 60 num
UNION ALL
SELECT 70 num
UNION ALL
SELECT 80 num
UNION ALL
SELECT 90 num) tens
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 100 num
UNION ALL
SELECT 200 num
UNION ALL
SELECT 300 num) hundreds;

SELECT DATE_ADD('2004-01-01',
INTERVAL (ones.num + tens.num + hundreds.num) DAY) dt
FROM (SELECT 0 num
UNION ALL
SELECT 1 num
UNION ALL
SELECT 2 num
UNION ALL
SELECT 3 num
UNION ALL
SELECT 4 num
UNION ALL
SELECT 5 num
UNION ALL
SELECT 6 num
UNION ALL
SELECT 7 num
UNION ALL
SELECT 8 num
UNION ALL
SELECT 9 num) ones
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 10 num
UNION ALL
SELECT 20 num
UNION ALL
SELECT 30 num
UNION ALL
SELECT 40 num
UNION ALL
SELECT 50 num
UNION ALL
SELECT 60 num
UNION ALL
SELECT 70 num
UNION ALL
SELECT 80 num
UNION ALL
SELECT 90 num) tens
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 100 num
UNION ALL
SELECT 200 num
UNION ALL
SELECT 300 num) hundreds
WHERE DATE_ADD('2004-01-01',
INTERVAL (ones.num + tens.num + hundreds.num) DAY) < '2005-01-01'
ORDER BY dt;

SELECT days.dt, COUNT(a.account_id)
FROM account a
RIGHT OUTER JOIN
(SELECT DATE_ADD('2004-01-01',
INTERVAL (ones.num + tens.num + hundreds.num) DAY) dt
FROM (SELECT 0 num
UNION ALL
SELECT 1 num
UNION ALL
SELECT 2 num
UNION ALL
SELECT 3 num
UNION ALL
SELECT 4 num
UNION ALL
SELECT 5 num
UNION ALL
SELECT 6 num
UNION ALL
SELECT 7 num
UNION ALL
SELECT 8 num
UNION ALL
SELECT 9 num) ones
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 10 num
UNION ALL
SELECT 20 num
UNION ALL
SELECT 30 num
UNION ALL
SELECT 40 num
UNION ALL
SELECT 50 num
UNION ALL
SELECT 60 num
UNION ALL
SELECT 70 num
UNION ALL
SELECT 80 num
UNION ALL
SELECT 90 num) tens
CROSS JOIN
(SELECT 0 num
UNION ALL
SELECT 100 num
UNION ALL
SELECT 200 num
UNION ALL
SELECT 300 num) hundreds
WHERE DATE_ADD('2004-01-01',
INTERVAL (ones.num + tens.num + hundreds.num) DAY) <
'2005-01-01') days
  ON days.dt = a.open_date
GROUP BY days.dt;

SELECT a.account_id, a.cust_id, c.cust_type_cd, c.fed_id
FROM account a
NATURAL JOIN customer c;

SELECT a.account_id, a.cust_id, a.open_branch_id,
FROM account a
NATURAL JOIN branch b;

SELECT c.cust_id,
c.fed_id,
c.cust_type_cd,
CONCAT(i.fname, ' ', i.lname) indiv_name,
b.name                        business_name
FROM customer c
LEFT OUTER JOIN individual i
  ON c.cust_id = i.cust_id
LEFT OUTER JOIN business b
  ON c.cust_id = b.cust_id;

SELECT c.cust_id,
c.fed_id,
CASE
WHEN c.cust_type_cd = 'I'
THEN CONCAT(i.fname, ' ', i.lname)
WHEN c.cust_type_cd = 'B'
THEN b.name
ELSE 'Unknown'
END
FROM customer c
LEFT OUTER JOIN individual i
  ON c.cust_id = i.cust_id
LEFT OUTER JOIN business b
  ON c.cust_id = b.cust_id;

SELECT c.cust_id,
c.fed_id,
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

SELECT YEAR(open_date) year, COUNT(*) how_many
FROM account
WHERE open_date > '1999-12-31'
GROUP BY YEAR(open_date);

SELECT SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2000 THEN 1
ELSE 0
END)        year_2000,
SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2001 THEN 1
ELSE 0
END) year_2001,
SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2002 THEN 1
ELSE 0
END) year_2002,
SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2003 THEN 1
ELSE 0
END) year_2003,
SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2004 THEN 1
ELSE 0
END) year_2004,
SUM(CASE
WHEN EXTRACT(YEAR FROM open_date) = 2005 THEN 1
ELSE 0
END) year_2005
FROM account
WHERE open_date > '1999-12-31';

SELECT c.cust_id,
c.fed_id,
c.cust_type_cd,
CASE
WHEN EXISTS(SELECT 1
FROM account a
WHERE a.cust_id = c.cust_id
AND a.product_cd = 'CHK') THEN 'Y'
ELSE 'N'
END has_current_account,
CASE
WHEN EXISTS(SELECT 1
FROM account a
WHERE a.cust_id = c.cust_id
AND a.product_cd = 'SAV') THEN 'Y'
ELSE 'N'
END has_savings
FROM customer c;

SELECT c.cust_id,
c.fed_id,
c.cust_type_cd,
CASE (SELECT COUNT(*)
FROM account a
WHERE a.cust_id = c.cust_id)
WHEN 0 THEN 'None'
WHEN 1 THEN '1'
WHEN 2 THEN '2'
ELSE '3+'
END num_accounts
FROM customer c;

SELECT 100 / 0;

SELECT a.cust_id,
a.product_cd,
a.avail_balance /
CASE
WHEN prod_tots.tot_balance = 0 THEN 12
ELSE prod_tots.tot_balance
END percent_of_total
#        a.avail_balance,
#        tot_balance
FROM account a
INNER JOIN
(SELECT a.product_cd, SUM(a.avail_balance) tot_balance
FROM account a
GROUP BY a.product_cd) prod_tots
  ON a.product_cd = prod_tots.product_cd
ORDER BY cust_id;

UPDATE account
SET last_activity_date = CURRENT_TIMESTAMP(),
pending_balance    = pending_balance +
(SELECT t.amount *
CASE t.txn_type_cd WHEN 'DBT' THEN -1 ELSE 1 END
FROM transaction t
WHERE t.txn_id = 999),
avail_balance      = avail_balance +
(SELECT CASE
WHEN t.funds_avail_date > CURRENT_TIMESTAMP() THEN 0
ELSE t.amount *
CASE t.txn_type_cd WHEN 'DBT' THEN -1 ELSE 1 END
END
FROM transaction t
WHERE t.txn_id = 999)
WHERE account.account_id =
(SELECT t.account_id
FROM transaction t
WHERE t.txn_id = 999);

SELECT a.last_activity_date,
a.pending_balance,
a.avail_balance,
a.account_id,
t.txn_id,
t.funds_avail_date,
t.amount
FROM account a
JOIN transaction t
  ON a.account_id = t.account_id;

SELECT txn_id, funds_avail_date, amount
FROM transaction;

SELECT emp_id,
fname,
lname,
CASE
WHEN title IS NULL THEN 'Unknown'
ELSE title
END title
FROM employee;

SELECT (7 * 5) / ((3 + 14) * null);

SET AUTOCOMMIT = 0;

SHOW TABLE STATUS LIKE 'transaction';

START TRANSACTION;
UPDATE product
SET date_retired = CURRENT_TIMESTAMP()
WHERE product_cd = 'SBL';
SAVEPOINT before_close_accounts;
UPDATE account
SET status             = 'CLOSED',
close_date         = CURRENT_TIMESTAMP(),
last_activity_date = CURRENT_TIMESTAMP()
WHERE product_cd = 'SBL';
# ROLLBACK TO SAVEPOINT before_close_accounts;
COMMIT;

SELECT dept_id, name
FROM department
WHERE name LIKE 'A%';

ALTER TABLE department
ADD INDEX dept_name_idx (name);

SHOW INDEX FROM department;

DROP INDEX dept_name_idx ON department;

ALTER TABLE department
ADD UNIQUE dept_name_idx2 (name);

INSERT INTO department (dept_id, name)
VALUES (999, 'Operations');

ALTER TABLE employee
ADD INDEX emp_names_idx (lname, fname);

SELECT emp_id, fname, lname
FROM employee
WHERE emp_id IN (1, 3, 9, 15, 22);

SELECT cust_id, SUM(avail_balance) tot_bal
FROM account
WHERE cust_id IN (1, 5, 9, 11)
GROUP BY cust_id;

EXPLAIN SELECT cust_id, SUM(avail_balance) tot_bal
FROM account
WHERE cust_id IN (1, 5, 9, 11)
GROUP BY cust_id;