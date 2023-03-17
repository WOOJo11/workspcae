
SELECT EMP_NAME, FLOOR(ABS(HIRE_DATE-SYSDATE))AS 근무일수1,
FLOOR(ABS(SYSDATE-HIRE_DATE))AS 금무일수2
FROM EMPLOYEE e ORDER BY HIRE_DATE ASC;

-----------------------
SELECT EMP_ID,EMP_NAME,EMAIL,PHONE
FROM EMPLOYEE e 
WHERE MOD(EMP_ID,2) != 0;

---------------------------------------------------------------

SELECT *
FROM EMPLOYEE  
WHERE CEIL(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12) >= 20;    

------------------------------------------------------------------
SELECT EMP_NAME,
 REPLACE(EMP_NO, SUBSTR(EMP_NO ,'9'), '******')

FROM EMPLOYEE e ;


----------------------------------------------------------------------

SELECT EMP_NAME,JOB_CODE,(SALARY+(SALARY*NVL(BONUS,0)))*12 AS"연봉(원)"
FROM EMPLOYEE e ;

--------------------------------------------------------------------------

SELECT EMP_ID,EMP_NAME,DEPT_CODE,HIRE_DATE
FROM EMPLOYEE e 
WHERE DEPT_CODE IN('D5','D9') AND
EXTRACT(YEAR FROM HIRE_DATE) = 2004;

---------------------------------------------------------------------------

SELECT EMP_NAME,HIRE_DATE,(LAST_DAY(HIRE_DATE)-HIRE_DATE+1) AS "입사한 달의 근무 일수"
FROM EMPLOYEE e ;

------------------------------------------------------------------------

SELECT EMP_NAME, DEPT_CODE,EMP_NO,
TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1)),'YY"년" MM"월" DD"일'),
FLOOR(FLOOR(SYSDATE-TO_DATE(SUBSTR(EMP_NO,1,INSTR(EMP_NO,'-')-1)))/365)
FROM EMPLOYEE e ;



