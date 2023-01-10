select  *
     from emp, dept
     where emp.deptno=dept.deptno --emp : 외래키 FK, dept : PK, 고유키
     
    emp집합을 먼저 읽고 dept
    dept 집합 먼저 읽고 emp
    
    외래키는 인덱스가 없다.
    
   --outer join
select *
    from emp, dept
    where emp.deptno(+) =dept.deptno --10,20,30,40
    --없는 쪽에 + 를 붙인다.
   
select *
        from temp
   
select *
    from tdept
    --부모 코드가 주는 쪽이고 그냥 부서코드가 받는쪽이다.
    --부모코드가 상위이다.
    
select 
            b.dept_name as "상위부서명"
    from tdept a, tdept b
    where a.parent_dept = b.dept_code
    --부모코드랑 부서코드가 같을때의 부서명이 상위부서명이다.
    
        
        
 select deptno from emp
 union 
 select deptno from dept
 
 select deptno from emp
 union 
 select dname from dept
 
 select * from dept
 
 select * from emp
 
 select deptno 
    from emp
   group by deptno
union all
select '총계' from dual

 select dname 
    from emp, dept
    where emp.deptno =dept.deptno
   group by dname
union all
select '총계' from dual

select deptno, dname from emp--제 3정규화 위배
--emp에 dname없어

select deptno, dname from dept

union all
:두집합 그대로 합친다.
순서를 따지지 않고 합치는 것이다.
같은 타입끼리만 가능함. union도 마찬가지.
union
:중복을 제거함 - 두집합을 비교한다음 합침. 속도 차이가 발생함.
순서를 따지게됨 - 왜냐면 두 집합을 스캔해서 값을 비교한다는 의미이니까
union all 을 사용한 경우와 결과가 같을 수 있지만 정렬 순서는 다를 수 있다.
왜냐하면 두 집합을 각각 스캔하고 비교한 후 결과값을 출력하니까.

select 1 rno, 2 from dual, dept

select 
            sum(decode(job, 'CLERK', SAL, NULL))
            ,sum(decode(job, 'MANAGER', SAL, NULL))
            ,sum(decode(job, 'CLERK', NULL, 'MANAGER' ,NULL,SAL))
            ,sum(SAL)
            FROM emp
            
select dname
            sum(decode(job, 'CLERK', SAL, NULL))
            ,sum(decode(job, 'MANAGER', SAL, NULL))
            ,sum(decode(job, 'CLERK', NULL, 'MANAGER' ,NULL,SAL))
            ,sum(SAL)
            FROM emp, dept
      where emp.deptno = dept.deptno
            
select 
            decode(b.ron, '1', dname, '총계')
            ,sum(clerk) clerk_sum
            ,sum(manager) managet_sum
            ,sum(dept_sal) dept_sal
    from(
                select
                            dept.dname, a.clerk, a.manager, a.ect
                      from (
                                    select deptno
                      
                                                sum(decode(job, 'CLERK', SAL, NULL))
                                               ,sum(decode(job, 'MANAGER', SAL, NULL))
                                            ,sum(decode(job, 'CLERK', NULL, 'MANAGER' ,NULL,SAL))
                                            ,sum(SAL)
            FROM emp
            group by deptno
                      
                )a,
                (select 1 rno from dual
                    union all
                    select 2 rno from dual
                
                )b
            
            
소계와 총계 연습문제 1
다음 t_orderbasket 테이블에서 분석용 함수를 사용하지 않고 각 날짜별로
총 몇개의 물건이 얼마만큼 팔렸으며 매출액은 어떻게 되는지 알고 싶다.
어떻게 소계와 합계를 구할 것인가?

select * from t_orderbasket

select name_vc, qty_nu
            from(
                         )
     group by name_vc, qty_nu
     
select indate_vc,sum(qty_nu) -- 그룹함수는 그룹바이에 없어도 된다.
             from t_orderbasket
             group by indate_vc
             
select   indate_vc, name_vc
                                from t_orderbasket
                                group by  name_vc
                                
select (qty_nu*price_nu)
            from t_orderbasket
            
select  indate_vc, sum(qty_nu*price_nu)
            from t_orderbasket
            group by indate_vc
            
select indate_vc,sum(qty_nu), sum(qty_nu*price_nu)
             from t_orderbasket
             group by indate_vc
             
select 1 from dual
union all
select 2 from dual

select *
            from(
                         select indate_vc,sum(qty_nu), sum(qty_nu*price_nu)
                         from t_orderbasket
                         group by indate_vc
                    )a,
                    (
                    select 1 from dual
                    union all
                    select 2 from dual
                    )b

select 
            indate_vc,  sum(qty_nu*price_nu)
            from t_orderbasket
            group by rollup(indate_vc)
            
select 
            indate_vc, gubun_vc, sum(qty_nu*price_nu)
            from t_orderbasket
            group by rollup(indate_vc, gubun_vc)
            
SELECT decode(b.dm,1,a.indate_vc,2,'총계') as "판매날짜"
         ,sum(a.qty_nu)||' 개' as "판매개수"
         ,sum(a.qty_nu*a.price_nu)||' 원' as "판매가격"
 FROM t_orderbasket a
        ,(SELECT rownum dm FROM emp WHERE rownum < 3) b
GROUP BY decode(b.dm,1,a.indate_vc,2,'총계')
ORDER BY "판매날짜"

SELECT decode(b.dm,1,a.indate_vc,2,'총계') as "판매날짜"
         ,sum(a.qty_nu)||' 개' as "판매개수"
         ,sum(a.qty_nu*a.price_nu)||' 원' as "판매가격"
 FROM t_orderbasket a
        ,(SELECT rownum dm FROM dept WHERE rownum < 3) b
GROUP BY decode(b.dm,1,a.indate_vc,2,'총계')
ORDER BY "판매날짜"
            
1.판매날짜별로 판매가격 계산-price_nu가 2번 필요하다.

2.카타시안의 곱을 사용하여 데이터를 2배수로 복제함

3. 더미테이블 생성하기 - rownum사용

select rownum rno, ename
    from emp
    where deptno = 30
    group by deptno
    --그룹바이는 select 컬럼자리에 온것과 같이 적어줘야한다,
    --단, 그룹함수는 예외이다.
    
select rownum rno, ename
        from emp
        group by deptno
        
select 
            rownum rno, deptno
            from(
                            select deptno
                                from emp
                                group by deptno
                       )
                   
select  empno, ename
            from emp
       order by  ename asc
       
select  rownum rno, empno, ename
            from emp
       order by  ename asc
       --이러면 rownum뒤죽박죽이다.
       
select rownum rno, empno, ename
        from (
                        select  empno, ename
                            from emp
                       order by  ename asc
                    )
                    
select rownum rno, empno
        from emp
        where rno <3
        
select rno, empno
            from(
                        select rownum rno, empno
                            from emp
                    )
               where rno<3
               
select rno, empno
        from (
                    select rownum rno, empno
                    from emp
                    )
           where rno >=3
           
select rno, empno
        from (
                    select rownum rno, empno
                    from emp
                    )
           where rno =3
           
select empno, ename
    from emp
    where rownum<3--됨
    
select empno, ename
    from emp
    where rownum>2--안됨
    
select empno, ename
    from emp
    where rownum<=3--됨
    
select empno, ename
    from emp
    where rownum>=3 --안됨

select empno, ename
    from emp
    where rownum=3 --안됨
    
select * from emp

select decode(b.dm,1,a.indate_vc,2,'총계') as "판매날짜"
            ,sum(a.qty_vc)
            
select decode(b.dm,1,a.indate_vc,2,'총계')
    from t_orderbasket a, (select rownum dm from emp where rownum < 3) b
    group by decode(b.dm,1,a.indate_vc,2,'총계')
   order by decode(b.dm,1,a.indate_vc,2,'총계')
   
SELECT decode(b.dm,1,a.indate_vc,2,'총계') as "판매날짜"
         ,sum(a.qty_nu)||' 개' as "판매개수"
         ,sum(a.qty_nu*a.price_nu)||' 원' as "판매가격"
 FROM t_orderbasket a
        ,(SELECT rownum dm FROM emp WHERE rownum < 3) b
GROUP BY decode(b.dm,1,a.indate_vc,2,'총계')
ORDER BY "판매날짜"
    
select  count(qty_nu), sum(qty_nu)
     from t_orderbasket
     --count는 로우의 갯수 sum은 총합
      
select * 
      from t_orderbasket
     
     날짜와 판매물품의
구분을 같이 출력하되 마지막에 판매 물품에 대한 구분을 넣어서 각각의
소계와 합계를 출력해 본다.

select distinct(gubun_vc) || '계'
        from t_orderbasket

select distinct(gubun_vc) || '계'
        from t_orderbasket
        group by gubun_vc
        
select distinct(deptno) from emp

select deptno from emp
group by deptno

select *
    from t_orderbasket a, (select rownum dm from emp where rownum < 4)b
--row3개인 더미테이블을 곱해준다.    

select  
            decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
       from t_orderbasket a, (select rownum dm from emp where rownum < 4)b
       
select  
            decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
            ,decode(b.dm,1,a.gubun_vc, 3, a.gubun_vc || '계')
       from t_orderbasket a, (select rownum dm from emp where rownum < 4)b
       
select  
            decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
            ,decode(b.dm,1,a.gubun_vc, 3, a.gubun_vc || '계')
       from t_orderbasket a, (select rownum dm from emp where rownum < 4)b
       group by decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
                        ,(b.dm,1,a.gubun_vc, 3, a.gubun_vc || '계')
       order by decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
       
select  
            decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
            ,decode(b.dm,1,a.gubun_vc, 3, a.gubun_vc || '계')
            ,sum(qty_nu) || '개' "판매갯수"
            ,sum(qty_nu*price_nu)||'원' "판매가격"
       from t_orderbasket a, (select rownum dm from emp where rownum < 4)b
       group by decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
                        ,decode(b.dm,1,a.gubun_vc, 3, a.gubun_vc || '계')
       order by decode(b.dm,1,a.indate_vc,2,'총계',3,'소계')
       
select max(salary) from temp

select emp_id, emp_name
    from temp
    where salary = (select max(salary) from temp)
    
    인라인뷰에서 사용한 컬럼명은 메인쿼리에서 사용가능하다.
    서브쿼리에서 사용한 컬럼명은 메인쿼리에서 사용 불가함
    서브쿼리는 간접적인 조건을 주고 검색할 때 사용 가능함.
    
select emp_id, emp_name, max_sal
        from temp
        where salary =(select max(salary) "max_sal" from temp)
        
2.temp의 자료를 이용하여 salary의 평균을 구하고 이보다 큰 금액을 salary로
받는 직원의 사번과 성명, 연봉을 보여주시오.

select emp_id, emp_name, salary
    from temp
    where salary>(select avg(salary) from temp)
    
select emp_id

select * from temp

select * from tdept

3.temp의 직원 중 인천에 근무하는 직원의 사번과 성명을 읽어오는 SQL을 서브
쿼리를 이용해 만들어보시오.

select ename, deptno
from emp
where deptno in(10,30)


select emp_id, emp_name 
    from temp e,tdept d
         where e.dept_code=d.dept_code
         and(d.parent_dept='BA0001')
         
select emp_id, emp_name 
    from temp
    where dept_code in(select dept_code from tdept where area ='인천')
    
    4.tcom에 연봉 외에 커미션을 받는 직원의 사번이 보관되어 있다.
이 정보를 서브쿼리로 select하여 부서 명칭별로 커미션을 받는
인원수를 세는 문장을 만들어 보시오.

select count(empno), count(*), count(comm)
        from emp
        
select emp_id from tcom

select * from tcom

select * from temp

select dept_name
        from temp, tdept
        where temp.dept_code = tdept.dept_code
      group by dept_name
      
      
select dept_name
        from temp, tdept
        where temp.dept_code = tdept.dept_code
        and emp_id in(select emp_id from tcom)
        --in 안에값이 emp_id랑 같은경우
        
select dept_name
        from temp, tdept
        where temp.dept_code = tdept.dept_code
        and emp_id in(select emp_id from tcom)
     group by dept_name
     
select dept_name, count(*)--null값이 있어도 로우갯수를  세주겠다
        from temp, tdept
        where temp.dept_code = tdept.dept_code
        and emp_id in(select emp_id from tcom)
     group by dept_name
     
심화문제
tdept에서 부서코드와 boss_id를 읽어서 이 두개 컬럼이 temp의 부서코드와
사번에 일치하는 사람의 사번과 성명을 읽어오는 쿼리를 만들어보자.

select* from temp

select * from tdept

select 
             emp_id, emp_name
        from temp, tdept 
     where temp.dept_code = tdept.dept_code
     and temp.emp_id=TDEPT.BOSS_ID
     
SELECT emp_id, emp_name
  FROM temp
 WHERE (dept_code, emp_id) IN
      (SELECT dept_code, boss_id FROM tdept)
      
select emp_id, emp_name
        from temp
        where (dept_code, emp_id) in
            (select dept_code, boss_id, area from tdept)
            
select
            emp.empno, emp.ename, dept.dname
        from emp, dept
        where emp.deptno = dept.deptno
        
        commit
        