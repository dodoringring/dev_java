

--카타시안의 곱은 나올수있는 모든 경우의 수가 출력-쓰레기값이 포함


select empno, ename, dept.deptno, dname
from emp, dept

select empno, ename, dept.deptno, dname
from emp, dept
where emp.deptno=dept.deptno

select/*+rule*/ empno, ename, dept.deptno, dname
from emp, dept
where emp.deptno=dept.deptno

select empno from emp

select empno, ename, dname, deptno
from emp natural join dept

select문 처리 순서
1. 파싱(parsing)- 문법 맞는지 여부
2. DBMS 가 실행계획을 세움
3. 실행계획을 옵티마이저에게 넘김
4. open...cursor를 이동 해당하는 곳에 데이터가 있으면 트루반환 아니면 폴스
    fetch....close로 위변조 방지
    
같은 셀렉트문을 두번 연속하여 요청하면 1단계와 2단계는 생략하고 3단계 진행됨 - 속도가 빠름

select ename from emp
order by ename asc

실제로 데이터를 찾는것은 옵티마이저가 한다.
일하는 기준(순서)이 있다.
2개 이상의 테이블이 오는 경우 - 조인
어떤 집합을 먼저 드라이브하는가에 따라서 검색 속도가 달라질 수 있다.
3초 안에 조회 결과가 나와야한다. 그렇지 않으면 에러로 취급이 된다.
속도문제-순서와 관계가 있고 실행계획을 통해서 확인이 가능하다.
all_rows라는 컨셉으로 실행계획을 세웠다.
 Hash join방식으로 데이터를 검색하였다.
 테이블을 각각 먼저 따로 스캔하고 조건을 따지면서 결과를 출력내보냄
 옵티마이저에게 rule base 옵티마이저 모드로 실행계획을 세워라
 
 DBMS가 실행계획을 세우고 검색하는 컨셉을 조건을 수렴하는 
 모든 로우의 값을 가장 빨리 찾아낼 수 있는 방법으로 실행계획을 세워줄래?
 
 
select rowid rno from emp

select ename from emp
where rowid = 'aaare8aaeaaaacwaab' --???

select empno, ename from emp
where empno = 7499

select * from salgrade

select e.ename, e.sal, s.grade
    from emp e, salgrade s
where e.sal
between s.losal
    and s.hisal
    
    연습문제 - non-equal조인
temp와 emp_level을 이용해 emp_level의 과장 직급의 연봉 상한/하한 범위 내에
드는 직원의 사번과, 성명, 직급, salary를 읽어보자.

select emp_id, emp_name, lev, salary from temp

select from_sal, to_sal, from emp_level
where lev='과장'

select emp_id, emp_name, emp_level.lev, salary
from temp, emp_level--카타시안의 곱-쓰레기값 포함

select emp_id, emp_name, emp_level.lev, salary
from temp, emp_level--카타시안의 곱-쓰레기값 포함
where emp_level.lev='과장'
--lev가 양 테이블에 다있다.

select emp_id, emp_name, emp_level.lev, salary
from temp, emp_level
where emp_level.lev='과장' 
and salary between from_sal and to_sal 

tcom의 work_year = '2001'인 자료와 temp를 사번으로 연결해서 join한 후
comm을 받는 직원의 성명, salary + COMM을 조회해 보시오.

-- 어떤 테이블에서 읽어오는가에 따라 다른 의미가 되기도 한다.
select 
            emp_id, emp_name, salary
    from temp
    
select work_year, emp_id, from tcom

tcom의 work_year = '2001'인 자료와 temp를 사번으로 연결해서 join한 후
comm을 받는 직원의 성명, salary + COMM을 조회해 보시오.

SELECT emp_name, salary + comm
  FROM temp, tcom
 WHERE tcom.emp_id = temp.emp_id
   AND tcom.work_year = '2001'
   
SELECT emp_name, salary + comm
  FROM temp NATURAL JOIN tcom
 WHERE tcom.work_year = '2001'
 
 select empno, ename, dept.deptno, dname
 from emp inner join dept
 on emp.deptno=dept.deptno
 
 테이블이 관리하는 데이터가 어떤 상태일때 Outer  Join이 필요한가?
 
select septno from dept
 minus
 select deptno from emp
 
select septno from emp
 minus
 select deptno from dept
 
select empno, ename, dept.deptno, dname
from emp, dept
where emp.deptno=dept.deptno
--양쪽에 존재하는 값만 나온다.
--이너조인

--40번 부서번호와 부서명도 같이 출력해달라고 요구한다면?

select count (deptno) from emp

select distinct(deptno) from emp

select d.deptno, ename
    from dept d, emp e
    where d.deptno=e.deptno
    --d에서 가져오는것이 빠르다.인덱스가 있으니까.
    --e에서 가져오는것 느리다. 외래키는 중복가능하다. 인덱스가 없다.
    
select d.deptno, ename
    from dept d, emp e
    where d.deptno=e.deptno(+)--??
    
    Outer Join연습문제
각 사번의 성명, 이름, salary, 연봉하한금액, 연봉상한금액을 보고자 한다.
temp와 emp_level을 조인하여 결과를 보여주되, 연봉의 상하한이 등록되어 있지 않은
'수습' 사원은 성명, 이름, salary 까지만이라도 나올 수 있도록 쿼리를 작성하시오.

select * from temp

select * from emp_level

select emp_name as "사원명", salary, t.lev, from_sal, to_sal
    from temp t , emp_level e
    where t.lev=e.lev(+)
    
select emp_name, salary from temp

select from_sal, to_sal from emp_level

select emp_name, salary, from_sal, to_sal from temp

select emp_name, salary, from_sal, to_sal
from temp, emp_level--카타시안의 곱. 그래서 조인을 걸어야한다.



    
Outer Join연습문제2
C:\오라클_수업\오라클실습소스\SQL\04장  t_worktime을 실행하시오
이들 데이터의 작업시간이 짧게 걸리는 시간 순서대로 1부터 15까지의 순위를
매겨서 출력하시오.
SELECT * FROM t_worktime
rank()라는 분석용 함수를 사용할 경우
SELECT
       workcd_vc
      ,time_nu
      ,rank() over(order by time_nu) rnk
  FROM t_worktime
  
  아우터조인을 사용해라
  
select *from t_worktime
  
select rownum rno, deptno from dept
--순차적으로 번호를 붙여주는 애가 있다. :rownum

select rownum rno, ename from emp
  
select *from t_worktime
where rownum<4
--위에서 3개만 나온다

select  seq_vc, workcd_vc, time_nu
from t_worktime
where rownum<4

--카타시안의 곱을 이용해서 데이터를 3배수로 만든다.  ??????
--3배수 중에서 나를 기준으로 작업시간이 빠른 값을 남긴다.
--남겨진 빠른 작업시간 값을 센다
--위에 1을 더한 숫자가 나의 순위이다.

  
select *
    from(
                select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4               
                )a,
                (
                    select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4
                )b
    where a.time_nu> b.time_nu
    
select *
    from(
                select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4               
                )a,
                (
                    select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4
                )b
    where a.time_nu> b.time_nu(+)
    
select a.workcd_vc, a.time_nu
    from(
                select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4               
                )a,
                (
                    select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4
                )b
    where a.time_nu>= b.time_nu(+)
    group by a.workcd_vc, a.time_nu--그룹바이는 뽑으려는 컬럼다와야한다.
    
select a.workcd_vc, a.time_nu, count(b.time_nu) as "rank"
    from(
                select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4               
                )a,
                (
                    select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4
                )b
    where a.time_nu>= b.time_nu(+)
    group by a.workcd_vc, a.time_nu
    
    select a.workcd_vc, a.time_nu, count(b.time_nu) as "rank"
    from(
                select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4               
                )a,
                (
                    select  seq_vc, workcd_vc, time_nu
                        from t_worktime
                        where rownum<4
                )b
    where a.time_nu>= b.time_nu(+)
    group by a.workcd_vc, a.time_nu
    order by count(b.time_nu) asc
    
rownum에 대한 연습문제
각 행에 1학년 부터 4학년 까지를 분리해서 한 행에 하나의 학년만 나오도록
하고자 한다. 현재 12행이 있으니 총 48행의 결과가 대학별/학과별로 인원수가
나와야 한다.

select * from test11

select rownum rno from emp 

select * from test11, (select rownum rno from emp where rownum <5)
--emp는 아무 테이블이나 가져온거다. 갯수만 

decode(rno,1, '1학년' , 2, '2학년' , 3, '3학년', 4, '4학년')

    ,decode(rno,1, '1학년' , 2, '2학년' , 3, '3학년', 4, '4학년')
    from test11, (select rownum rno from emp where rownum <5)
    order by dept asc, decode(rno,1, '1학년' , 2, '2학년' , 3, '3학년', 4, '4학년')
컬럼에벨에 값을 로우 레벨로 옮겨 출력하기 - 빈도높음

select 1,2,3 from dual

select 1 from dual
union all
select 2 from dual
union  all
select 3 from dual

select dept
                    ,decode(rno,1, '1학년' , 2, '2학년' , 3, '3학년', 4, '4학년')
                    ,decode(rno, 1, fre, 2, sup, 3, jun, 4, sen)
from  test11, (select rownum rno from emp where rownum <5)
order by dept asc , decode(rno,1, '1학년' , 2, '2학년' , 3, '3학년', 4, '4학년') asc

rownum연습문제 버전 2
test11의 자료를 이용하여 1,2학년과 3,4학년의 인원수가 각각 같은 줄에 나오도록
query를 작성해 보라.
2:09
연습문제 버전 3
temp자료를 이용해 한 행에 3명의 사번과 성명을 보여주는 쿼리를 작성하시오.

select * from temp

select emp_id, emp_name 
            from temp, (select rownum rno from temp where rownum<2 )
            union all
selecet emp_id, emp_name
            from temp, (select rownum rno from temp where rownum<3 )

select * from sam_tab02 

select rownum rno, gubun from sam_tab02

select rno, gubun
    from ( select rownum rno, gubun from sam_tab02
    )

select     
            cell(rno/4) con, rno, gubun from sam_tab02
    from (
        select rownum rno, gubun from sam_tab01
        )
        
select     
            ceil(rno/4) con,mod( rno,4) mno
            ,decode(mod(rno, 4),1,gubun) c1 
            ,decode(mod(rno, 4),2,gubun) c2
            ,decode(mod(rno, 4),3,gubun) c3 
            ,decode(mod(rno, 4),0,gubun) c4 
    from (
        select rownum rno, gubun from sam_tab02
        )
        
select 
            ceil(rno/3) cno
            ,max(decode(mod(rno,3),1,emp_id)) c1
            ,max(decode(mod(rno,3),2,emp_id)) c2
            ,max(decode(mod(rno,3),0,emp_id)) c3
        from (
                        select rownum rno, emp_id, emp_name from temp
                        )
       group by ceil(rno/3)
       order by ceil(rno/3)
       
row레벨의 값을 컬럼레벨에 올려 출력하기

select * from emp

select * from dept

select dname from dept


select dname, 
            , decode( job, 'CLERK', sal, 
            , 'MANAGER'
            , ect
            ,dept_sal
      from emp e, dept d
                , (
                      select rownum rno
                )
   where e.dname = d.dname

select  deptno
            ,sum(decode(job, 'CLERK', sal, null))
            ,sum(decode(job, 'MANAGER', sal, null))
            ,sum(decode(job, 'CLERK',NULL, 'MANAGER', null, sal))
            ,sum(sal)
    from emp
    group by deptno
    
select sum(decode(job, 'CLERK', sal, null))   from emp
            
select 1 rno from dual
union all
select 3 from dual

select *
        from (
                      select  deptno
                                    ,sum(decode(job, 'CLERK', sal, null))
                                    ,sum(decode(job, 'MANAGER', sal, null))
                                    ,sum(decode(job, 'CLERK',NULL, 'MANAGER', null, sal))
                                    ,sum(sal)
                            from emp
                            group by deptno
                    )a,
                    (
                        select 1 rno from dual
                        union all
                        select 2 from dual
                    )b
                    
select  decode(rno , 1, dname, 2, '총계')
        from (
                      select  dname
                                    ,sum(decode(job, 'CLERK', sal, null)) clerk_sal
                                    ,sum(decode(job, 'MANAGER', sal, null)) manager_sal
                                    ,sum(decode(job, 'CLERK',NULL, 'MANAGER', null, sal)) ect_sal
                                    ,sum(sal)
                            from emp, dept
                            where emp.deptno = dept.deptno
                            group by dname
                    )a,
                    (
                        select 1 rno from dual
                        union all
                        select 2 from dual
                    )b                    
   group by decode(rno, 1, dname, 2, '총계')                 
   order by decode (rno, 1, dname, 2, '총계')
   

select  
       decode(rno , 1, dname, 2, '총계')
      ,sum(clerk_sal)
      ,sum(manager_sal)
      ,sum(ect_sal)
        from (
                      select  dname
                                    ,sum(decode(job, 'CLERK', sal, null)) clerk_sal
                                    ,sum(decode(job, 'MANAGER', sal, null)) manager_sal
                                    ,sum(decode(job, 'CLERK',NULL, 'MANAGER', null, sal)) ect_sal
                                    ,sum(sal)
                            from emp, dept
                            where emp.deptno = dept.deptno
                            group by dname
                    )a,
                    (
                        select 1 rno from dual --두번 돌리기 위해서 내가 표를  만든거다
                        union all
                        select 2 from dual
                    )b                    
   group by decode(rno, 1, dname, 2, '총계')                 
   order by decode (rno, 1, dname, 2, '총계') asc
   
select * from tdept

self join

관계형태중에서 n:n은 조언을 걸지 않는다.
왜냐면 쓰레기값이 포함되어있음
업무에 대한 정의가 덜 되어있다.
학생과 교과목, 회원과 상품, 회원과 책-> n:n인 관계형태를 갖음 -> 교차엔티티(행위 엔티티)
1:1, 1:n 고려대상

select * from tdept
--카타시안의 곱 10*10 = 100가지의 경우의 수가 출력된다.
select *
        from tdept a, tdept b
        where a.dept_code = b.parent_dept

select 
            b.dept_code as "부서코드"
            ,b.dept_name as "부서명"
            ,a.dept_code as "상위부서코드"
            ,a.dept_name as "상위부서명"
        from tdept a, tdept b
        where a.dept_code = b.parent_dept
        