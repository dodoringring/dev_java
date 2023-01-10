SELECT * FROM EMP

SELECT ENAME
                ,HIREDATE
                ,MONTHS_BETWEEN(SYSDATE, HIREDATE)
        FROM EMP
        
CREATE TABLE TEST(
    id NUMBER(5) CONSTRAINT pk_id PRIMARY KEY,
    name VARCHAR(20),
    title VARCHAR(30)
);

.    직원의 급여를 인상하고자 한다
직급코드가 J7인 직원은 급여의 8%를 인상하고,
직급코드가 J6인 직원은 급여의 7%를 인상하고,
직급코드가 J5인 직원은 급여의 5%를 인상한다.
그 외 직급의 직원은 3%만 인상한다.

직원 테이블(EMP)에서 직원명(EMPNAME), 직급코드(JOBCODE), 급여(SALARY), 인상급여(위 조건)을
조회하세요(단, DECODE를 이용해서 출력하시오.) 

SELECT EMPNAME, JOBCODE, SALARY,
                DECODE(JOBCODE,'J7',SALARY*1.08,'J6',SALARY*1.07,'J5',SALARY*1.05,SALARY*1.03) AS "인상급여"
                FROM EMP
                
                                    
SELECT EMPNAME, JOBCODE, SALARY,
                CASE WHEN JOBCODE='J7' THEN SALARY*1.08
                            WHEN JOBCODE='J6' THEN SALARY*1.07
                            WHEN JOBCODE='J5' THEN SALARY*1.05
                            ELSE SALARY*1.03
                            END
                            AS "인상급여"
          FROM EMP
          
select * from t_giftmem

select * from t_giftpoint

회원과 상품의 관계는 n:n이다.

select point_nu as "상품포인트"
from t_giftpoint
where name_vc = '영화티켓'

select nvl(colum,0) from emp

사원번호가pk이다
사원번호가 중복되면 안된다.
사원번호 중에서 가장 최대값을더해서 1더해라.
사원번호 채번규칙은 최댓값에 1을 더한값으로 한다.
사원번호를 채번하는 쿼리문을 작성하시오.

select * from emp

select  max(empno)+1
        from emp
      
select empno
    from emp
    where rownum =1
    
SELECT empno FROM emp
​
SELECT
       /*+index_desc(emp pk_emp) */ empno
  FROM emp
 
​
SELECT
       /*+index_desc(emp pk_emp) */ empno
  FROM emp
WHERE rownum =1
​
SELECT
       /*+index_desc(emp pk_emp) */ empno
      ,(empno+1)
  FROM emp
WHERE rownum =1
​
SELECT
       empno
  FROM emp
ORDER BY empno desc
​
​
SELECT
       empno
  FROM (
        SELECT
               empno
          FROM emp
        ORDER BY empno desc  
       )
WHERE rownum = 1
 
SELECT
       empno+1
  FROM (
        SELECT
               empno
          FROM emp
        ORDER BY empno desc  
       )
WHERE rownum = 1
    
select empno from emp

select /*+ all_row*/
                empno, ename, dname
        from emp, dept
        where emp.deptno=dept.deptno
        
--숙제풀이
select * from t_giftmem

select * from t_giftpoint

select point_nu from t_giftpoint
    where name_vc='영화티켓'
    
 where 회원집합.point_nu >= 상품집합.point_nu
 
 select mem.name_vc as "회원명",
                mem.point_nu as "회원보유포인트"
    from(
                    select point_nu from t_giftpoint
                    where name_vc='영화티켓'
               )poi, t_giftmem mem
               where mem.point_nu >= poi.point_nu
                
              
 select mem.name_vc as "회원명"
               , mem.point_nu as "회원보유포인트"
               , to_char(mem.point_nu-poi.point_nu,'999,999')||'점' as "잔여포인트"
    from(
                    select point_nu from t_giftpoint
                    where name_vc='영화티켓'
               )poi, t_giftmem mem
               where mem.point_nu >= poi.point_nu
               
 select mem.name_vc as "회원명"
               , mem.point_nu as "회원보유포인트"
               , to_char(mem.point_nu-poi.point_nu,'999,999')||'점' as "잔여포인트"
    from(
                    select point_nu from t_giftpoint
                    where name_vc='영화티켓'
               )poi, t_giftmem mem
               where mem.point_nu >= poi.point_nu
               and poi.name_vc = '영화티켓'
               
2. 문제풀이

select '한과세트', '김유신' from dual

select
            poi.name_vc, mem.name_vc
        from t_giftpoint poi, t_giftmem mem
        --카타시안의 곱이다. 일어날수 있는 모든 경우의 수를 다 검토한다.
        where mem.name_vc = '김유신'
        and poi.point_nu <= mem.point_nu
        
select ename, max(sal) from emp

select max(ename), min(ename), max(sal) from emp
        
select
            poi.name_vc, mem.name_vc
        from t_giftpoint poi, t_giftmem mem
        where mem.name_vc = '김유신'
        and poi.point_nu <= mem.point_nu
        
select name_vc, point_nu
        from t_giftpoint
      where point_nu = 50000
      
select name_vc, point_nu
        from t_giftpoint
      where point_nu = (
                                            select
                                                    max(poi.point_nu)
                                                from t_giftpoint poi, t_giftmem mem
                                                where mem.name_vc = : uname
                                                and poi.point_nu <= mem.point_nu
                                           )