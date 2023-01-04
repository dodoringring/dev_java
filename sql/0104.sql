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