select * from employees

ad_vp 10%
it_prog 15%
st_man 20%

나머지는 5% 인상

이름 job_id 현재급여 인상적용된 급여

select first_name, salary,
          case when job_id='AD_VP' then salary*(1.1)
                     when  job_id='IT_PROG' then salary*(1.15)
                     when  job_id='AD_VP' then salary*(1.2)
                     else salary*(1.05)
                     end as "인상연봉"
from employees

select first_name || last_name
            ,job_id, salary,
            case
                    when job_id='AD_VP' then salary*1.1
                    when  job_id='IT_PROG' then salary*1.15
                     when  job_id='AD_VP' then salary*1.2
                     else salary*1.05
                     end as 인상연봉
      from employees