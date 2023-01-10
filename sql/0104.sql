CREATE TABLE LECTURE (LEC_ID VARCHAR2(05),LEC_TIME NUMBER,LEC_POINT NUMBER);
INSERT INTO LECTURE VALUES('L0001',3,3);
INSERT INTO LECTURE VALUES('L0002',3,2);
INSERT INTO LECTURE VALUES('L0003',2,3);
INSERT INTO LECTURE VALUES('L0004',2,2);
INSERT INTO LECTURE VALUES('L0005',3,1);
COMMIT;

주당 강의 시간과 ???
같을때는 일반과목 생략하면 널....

decode(lec_time, lec_point, '일반과목') = decode(lec_time, lec_point, '일반과목', null)

decode (lec_time, lec_point, '일반과목', '특별과목')

select
            decode (lec_time, lec_point, '일반과목')
from lecture

select
            decode (lec_time, lec_point, '일반과목',null)
from lecture

select
            decode (lec_time, lec_point, '일반과목', '특별과목')
from lecture

주당강의시간과 학점이 같은 강의의 숫자는?
select 
            count(decode (lec_time, lec_point, '어쩌라고;;'))--카운트는 로우를 센다
        from lecture
        
문제 강의시간과 학점이 같으면 1을 반환한다.

select 
            lec_time, lec_point
                from lecture
                
--null은 모른다. 결정되지 않았다.
--sum할 수 있나? count 도 마찬가지
select 
            decode(lec_time, lec_point,1)
         from lecture

select 
           count(decode( lec_time, lec_point, 1))
       from lecture
       
select 
            decode(job, 'CLERK', sal)
            from emp
            
select 
            sum(decode(job, 'CLERK', sal)) as "계산원 월급합계"
            ,count (decode(job, 'CLERK', sal)) as "명수"
            from emp

select count (*) from lecture

select 1 from lecture--?????
    where lec_time = lec_point

select count(1) from lecture
    where lec_time = lec_point
    
select 1 from dual
union all
select 2 from dual

 
        
Q.타임이 크면 실험과목
time이 point보다 같으면 일반과목
포인트가 크면 기타과목
        
select lec_time, lec_point,
            decode (sign(lec_time-lec_point),0, '일반과목'
                                                                         ,1, '실험과목'
                                                                         , -1, '기타과목')
       from lecture
         

select 1, 2, 3 from dual --1,2,3,하면 늘어난다..?


select 120-10, (10-120), 0-0
        from dual
            
select sign(120-10), sign(10-120), 0-0, 500-500
                    ,sign(10-25), sign(1+6)
        from dual
        
--sign함수는 양의정수이면 1반환 음의정수이면 -1반환 0이면 0반환

문제 하나 더 : 월요일엔 해당일자에 01을 붙여서 4자리 암호를 만들고,
화요일엔 11, 수요일엔 21, 목요일엔, 31, 금요일엔 41, 토요일엔 51,
일요일엔 61을 붙여서 4자리 암호를 만든다고 할 때
암호를 SELECT하는 SQL을 만들어 보시오.
select sysdate
    from dual
    
select to_char(sysdate, 'dd')--date
from dual

select to_char(sysdate,'day') --요일은 day
    from dual

select '04' || '21' from dual--문자열 붙이기

select 
    to_char(sysdate, 'dd') ||
            decode(to_char(sysdate, 'day'), '월요일', '01'
                                                                    , '화요일', '11'
                                                                    ,'수요일', '21'
                                                                    ,'목요일', '31'
                                                                    ,'금요일', '41'
                                                                    ,'토요일', '51'
                                                                    ,'일요일', '61') as "비밀번호"
    from dual
1.영어가사만 나오기

select seq_vc, words_vc
        from t_letitbe
        
select
            mod(seq_vc,2), seq_vc, words_vc
        from t_letitbe
 
select
            mod(seq_vc,2), seq_vc --mod는 첫번째를 두번째로 나눈 나머지
            , decode(mod(seq_vc,2), 1, words_vc, null)
        from t_letitbe 
 
 
                
--t_letitbe안에 있는 컬럼만 사용할 수 있다. 그런데 우리는 0과1만 비교하고싶다??
select
            mod(seq_vc,2), seq_vc --mod는 첫번째를 두번째로 나눈 나머지
            , decode(mod(seq_vc,2), 0, words_vc, null)
        from t_letitbe 
        where num=1 --이렇게는 안된다.
        --num은 별칭이지 t_letitbe에 존재하는 컬럼이 아니다.
        --문제를 해결하는 방법이 있다.
        --인라인뷰를 사용하면 가능하다.
        --인라인뷰를 사용해서 원래있는 집합을 가공(컬럼, 로우-where절)할 수 있다.
        
 
select
            decode(mod(seq_vc,2), 1,words_vc, null)
        from t_letitbe
        where mod(seq_vc, 2) =1
        
2. 한글 가사만
select
            mod(seq_vc,2), seq_vc --mod는 첫번째를 두번째로 나눈 나머지
            , decode(mod(seq_vc,2), 0, words_vc, null)
        from t_letitbe

select
            decode(mod(seq_vc,2), 0, words_vc, null)
        from t_letitbe
        where mod(seq_vc, 2) =0
        
3. 영문 한글가사 모두 나오게하기

select 
             words_vc
            from t_letitbe
            
--t_letitbe안에 있는 컬럼만 사용할 수 있다. 그런데 우리는 0과1만 비교하고싶다??
select
            mod(seq_vc,2), seq_vc --mod는 첫번째를 두번째로 나눈 나머지
            , decode(mod(seq_vc,2), 0, words_vc, null)
        from t_letitbe 
        where num=1 --이렇게는 안된다.
        --num은 별칭이지 t_letitbe에 존재하는 컬럼이 아니다.
        --문제를 해결하는 방법이 있다.
        --인라인뷰를 사용하면 가능하다.
        --인라인뷰를 사용해서 원래있는 집합을 가공(컬럼, 로우-where절)할 수 있다.
        
select * from emp
where sal>3000

--인라인뷰는 from절 뒤에 오는 select문을 말한다.
select*
        from(
                     select
                        mod(seq_vc,2) num,  seq_vc 
                        , decode(mod(seq_vc,2), 1, words_vc, null)
                      from t_letitbe
                   ) a--????
        where a.num=1
--인라인뷰에서 사용된 컬럼명은 where절에서 사용 가능하다,
--그 컬럼명이 테이블에 존재하는 컬럼이 아니어도 된다.

3. 영문 한글 모두 나오게 하기
select 
            seq_vc
            , decode (mod(seq_vc, 2),1, words_vc) A --as "A"
            from t_letitbe
union all
select 
            seq_vc
            , decode (mod(seq_vc, 2),0, words_vc) A
            from t_letitbe
            
select seq_vc, min(A)--A에 사용되는 그룹함수는 null과 비교되니까 값은 오직 하나뿐
    from (
              select 
                    seq_vc
                    , decode (mod(seq_vc, 2),1, words_vc) A --as "A"
                    from t_letitbe
            union all
            select 
                        seq_vc
                        , decode (mod(seq_vc, 2),0, words_vc) A
                        from t_letitbe
                )
group by seq_vc -- 근데 정렬 이상하다.
order by to_number(seq_vc) asc

select seq_vc from t_letitbe
order by to_number(seq_vc) asc

select seq_vc, max(words_vc)
    from (
                    select 
                    seq_vc
                    , decode (mod(seq_vc, 2),1, words_vc) A --as "A"
                    from t_letitbe
            union all
            select 
                        seq_vc
                        , decode (mod(seq_vc, 2),0, words_vc) A
                        from t_letitbe
                )
order by to_number(seq_vc) asc

select deptno, ename
        from emp
     group by deptno 
     --이렇게 안된다. 그룹바이 안에 있는 컬럼만 뽑을 수 있다.

--아래 오류는 그룹바이에 대한 문법적 오류는 해결되었지만
--그룹 바이 사용한 효과가 전혀 없는 경우
select deptno, ename
        from emp
     group by deptno, ename
     
select 
            max(ename), deptno
            from emp
            group by deptno




3번 문제의 경우 select * from t_letitbe는 답이 아닙니다.

SELECT  ename, comm
        from emp
        
SELECT  ename, comm
        from emp
        order by comm asc
        
SELECT  ename, comm
        from emp
        order by comm desc       
        
select empno 사원번호,--as 생략가능
            empno as "사원번호",
            empno "사원번호",
            empno "사원 번호" --중간에 띄어쓰기 있으면 무조건 ""써라
      from emp

case when 구문 연습
아이디가 존재하는지 먼저 체크해보고
만일 존재하면 비번을 체크한다.
존재하지 않는 경우라면 -1 을 리턴한다
아이디는 존재하지만 비번이 틀리면 0을 리턴한다.

if (result==1) system.out.print("로그인 성공하였습니다.")
else if (result==0) System.out.print("비번 틀립니다.")
else if (result==-1) System.out.print("아이디가 존재하지 않습니다.")

select result
        from (
                        select case when mem_id=:id then 
                                    case when mem_pw=:pw then 1
                                    else 0
                                    end
                                  else -1
                                  end as result
                           from member
                           order by result desc
                    )
      where rownum = 1
      
도전문제
tmep의 자료를 salary로 분류하여 30,000,000이하는 'D',
30,000,000 초과 50,000,000이하는 'C'
50,000,000 초과 70,000,000이하는 'B'
70,000,000 초과는 'A'라고 등급을 분류하여 등급별 인원수를
알고 싶다.
어떡하지?

select 
            case when salary <= 30000000 then 'D'
                     when salary between 30000001 and 50000000 then 'C'
                     when salary between 50000001 and 70000000 then 'B'
                     when salary > 70000000 then 'A'
            end
            as "월급레벨"
            
        from temp
        
select 
            case when salary <= 30000000 then 'D'
                     when salary between 30000001 and 50000000 then 'C'
                     when salary between 50000001 and 70000000 then 'B'
                     when salary > 70000000 then 'A'
            end
            ,count(salary)--안된다...?
        from temp
 
select count(salary)
    from temp
    
select emp_id, count(salary)
    from temp--단일 그룹의 함수가 아닙니다...
    
select deptno, count(empno)
    from temp
  group by deptno
  
select 
            case when salary <= 30000000 then 'D'
                     when salary between 30000001 and 50000000 then 'C'
                     when salary between 50000001 and 70000000 then 'B'
                     when salary > 70000000 then 'A'
            end
            , count(salary)
        from temp
group by  case when salary <= 30000000 then 'D'
                     when salary between 30000001 and 50000000 then 'C'
                     when salary between 50000001 and 70000000 then 'B'
                     when salary > 70000000 then 'A'
            end
            --그룹바이에 전체 케이스 조건문을 넣을 수 있다. 
           --a에대한 그룹바이 b에 대한 그룹바이...

select 
            case when salary <= 30000000 then 'D'
                     when salary between 30000001 and 50000000 then 'C'
                     when salary between 50000001 and 70000000 then 'B'
                     when salary > 70000000 then 'A'
            end
        from temp
        
select 
            count(case when salary <=30000000 then 'D' end ) as "D",
            count(case when salary between 30000001 and 50000000 then 'C' end) as "C",
            count(case when salary between 50000001 and 70000000 then 'C' end) as "C",
            count(case when salary > 70000000 then 'A' end) as "A"
            from temp
            
select * from t_giftpoint

select * from t_giftmem

문제1
영화 티켓을 받을 수 있는 사람의 명단과 현재 가지고 있는 포인트, 영화 티켓의 포인트
그리고 그 티켓을 사용한 후 남은 예상 포인트를 출력하시오.
문제2
김유신씨가 보유하고 있는 마일리지 포인트로 얻을 수 있는 상품 중 가장 포인트가 높은 것은
무엇인가? 

문제1
select  m.name_vc,
                  m.point_nu as "회원이 보유한 포인트"
 
         from t_giftmem m, t_giftpoint g
         where (m.point_nu-15000) > 0 
            
            
select
              m.point_nu as "회원이 보유한 포인트"
              ,g.point_nu as "상품의 포인트"
              ,m.point_nu-g.point_nu as "잔여포인트"
    from t_giftmem m, t_giftpoint g
    where g.name_vc='영화티켓'
    
--카타시안의 곱에 빠진다.

select
              m.point_nu as "회원이 보유한 포인트"
              ,g.point_nu as "상품의 포인트"
              ,m.point_nu-g.point_nu as "잔여포인트" >0 
    from t_giftmem m, t_giftpoint g
    where g.name_vc='영화티켓'

문제2

--우편번호 검색기
select*from zipcode_t

대분류 -도분류
select zipcode, zdo  
    from zipcode_t
    group by zdo, zipcode


중분류-시정보

소분류-동정보

select distinct (zdo) zdo
        from zipcode_t
    order by zdo asc

select '전체' from dual
union all
select distinct(zdo) zdo
    from zipcode_t
    order by zdo asc
    
select '전체' zdo from dual
union all
select  zdo
    from (
                    select distinct(zdo) zdo
                    from zipcode_t
                        order by zdo asc
                )
                
select '경기' from dual
union all
select '인천' from dual

select distinct (sigu) sigu
    from zipcode_t
    where zdo =:zdo
    order by sigu asc

select distinct (dong) dong
    from zipcode_t
    where sigu=:sigu and zdo=:zdo
    order by dong
    
select '전체' dong from dual
union all
select  dong
    from (
                    select distinct (dong) dong
                    from zipcode_t
                    where sigu=:sigu and zdo=:zdo
                    order by dong
                )
                
select '전체' sigu from dual
union all
select  sigu
    from (
                    select distinct (sigu) sigu
                    from zipcode_t
                    where zdo=:zdo
                    order by sigu asc
                )