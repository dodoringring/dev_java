select emp_name, emp_no, dept_CODE, SALARY  
from employee
where dept_code='D9' and dept_code='D6' --문제1
            and salary>=3000000--문제 2
            and email like '%___#_%' escape '#'--문제3
            and bonus is not null--문제4
           and emp_no like '%-1%' ;--문제5
           --남자...​
           
select * from emp

select *
        from emp
        where deptno=20 or deptno=30 
        
select empno from emp--pk라서 인덱스가있다.

select ename from emp

create index i_ename
on emp (ename asc)

select ename from emp
where ename is not null --index를 넣었더니 order by안넣어도 정렬됨

--unique index는 어떤 조건이 와도 해당 컬럼에 함수를 사용하든 무조건 
--인덱스를 사용한 실행계획으로 처리한다.

select empno from emp
where nvl(empno,0)>0

select empno from emp
where decode(empno,0,null,empno) > 0

select empno from emp
where empno is not null

select ename from emp

select ename from emp--정렬 된다
where ename is not null

select ename from emp
where nvl(ename,'') !=' '

select ename from emp
where nvl(ename,' ') is not null
--의미 없는 조건줘도 옵티마이저가 인덱스에 의한 검색을 할까?
--인덱스 안씀...

--PK는 오라클에서 기본적으로 인덱스를 제공한다.
--거기다가 유니크인덱스다.
--어떠한 가공을 하더라도 실행계획에서 인덱스를 사용한 조회가 이루어진다.

--사용자 정의 인덱스는 중복값이 허용되는 인덱스이다.
--해당 컬럼을 가공하면 실행계획에서 인덱스 사용이 불가하다.

--인덱스가 있으면 order by 를 사용하지 않고 정렬이 된다.
--디폴트는 오름차순이다.

select ename from emp
where ename is not null

select ename from emp
order by ename asc

select /*+ index_desc(emp i_ename)*/ ename
    from emp
    where ename is not null
    --멍청조건... 무조건 널 아님 
    --조건이 있으면 힌트문 쓰인다.
    --인덱스가 존재하더라도 조건절에 사용되지 않으면 옵티마이저는 실행계획에 반영하지 않는다.
    
    

우편번호 검색기 구현

사용자로부터 입력받는값-zdo정보 받아오는 경우 고려함 , 동이름을 입력받는다.
검색속도를 높이려면 and를 사용하자

select 
            zipcode, address
        from zipcode_t
     where 1=1
     and zdo=:zdo
     and dong like :x || '%'