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