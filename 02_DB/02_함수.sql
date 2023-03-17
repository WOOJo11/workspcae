-- 함수 : 컬럼의 값을 읽어서 연산 결과를 반환

-- 단일행 함수 : N개의 행의 값을 전달하여 N개의 결과를 반환 

-- 그룹 함수 : N개의 행의 값을 하나의 그룹으로 묶어
--			그룹 수 만큼의 켤과를 반환

-- 함수는 SELECT절,WHERE절, ORDER BY절 GROUP BY절 HAVING절 사용 가능

/******************** 단일행 함수 ***********************/

--<문자열 관련 함수>

-- LENGTH (문자열 또는 컬럼명)
SELECT 'HELLO WORLD', LENGTH('HELLO WORLD') FROM DUAL;

-- EMPLOYEE 테이블에서 이메일이 12글자인 사원의
-- 이름 이메일 조회
SELECT EMP_NAME,EMAIL FROM EMPLOYEE e  WHERE LENGTH(EMAIL)=12;

-- EMPLOYEE 테이블에서 이메일 길이 오름차순으로 조회
SELECT EMP_NAME,EMAIL,LENGTH(EMAIL) FROM EMPLOYEE e 
ORDER BY LENGTH(EMAIL);

---------------------------------------------------------------

-- INSTR (문자열 |컬럼명, '찾을 문자열' [,])
-- 찾을 시작 위치부터 지정된 순번 째에 찾을 문자열의 시작 위치(인덱스) 반환

-- 문자열에서 맨앞에 있는 B의 위치 조회
SELECT 'AABAACAABBAA' ,INSTR('AABAACABBAA','C') FROM DUAL;
-- 문자열을 5번째부터 검색하여 찾는 B의 위치
SELECT 'AABAACAABBAA' ,INSTR('AABAACAABBAA','B',5) FROM DUAL;
-- 문자열을 5번째부터 검색하여 두번째로 찾는 B의 위치
SELECT 'AABAACABBAA' ,INSTR('AABAACAABBAA','B',5,2) FROM DUAL;

--EMPLOYEE 테이블에서
-- 사원명 이메일 이메일 중 '@' 위치 조회
SELECT EMP_NAME,EMAIL, INSTR(EMAIL,'@') FROM EMPLOYEE e ;

SELECT EMP_NAME, INSTR(EMP_NAME,'재') FROM EMPLOYEE e ;

---------------------------------------------------

-- SUBSTR(문자열 | 컬럼명, 시작위치 [,길이])
-- 문자열을 시작 위치부터 지정된 길이 만큼 잘라내서 반환
-- 길이 미작성 시 시작위치부터 끝까지 잘라내서 반환

SELECT SUBSTR('ABCDEF',5) FROM DUAL;

--EMPLOYEE 테이블에서 사원명과 사원의 이메일 아이디만 조회
-- 아이디 오름차순
SELECT EMP_NAME ,SUBSTR(EMAIL,1, INSTR(EMAIL,'@')-1) AS 아이디
FROM EMPLOYEE e ORDER BY 아이디;

--------------------------------------------------------------------

-- TRIM ([[옵션]문자열 | 컬럼명 FROM] 문자열 | 컬럼명)
-- 주어진 문자열의 앞쪽 OR 뒤쪽 OR 양쪽에 존재하는 지정된 문자열을 제거

-- 옵션 : LEADING(앞쪽) , TRAILING(뒤쪽), BOTH (양쪽, 기본값) 

SELECT  '#####K H#####',
TRIM(LEADING '#' FROM '     K H     '),
TRIM(TRAILING '#' FROM '     K H     '),
TRIM(BOTH '#' FROM '     K H     ')
FROM DUAL;

-- 문자열 앞뒤 공백 제거(해당 용도로 가장 많이 사용됨)
SELECT  TRIM('     K H     ') FROM DUAL;

---------------------------------------------------------------------
-- REPLACE(문자열 | 컬럼명 , 찾을 문자열 바꿀 문자열)
-- 찾을 문자열을 바꿀 문자열로 변경하여 문자열 반환
SELECT * FROM NATIONAL;
SELECT REPLACE (NATIONAL_NAME,'한국', '대한민국') FROM "NATIONAL" n  ; 

-----------------------------------------------------------
-----------------------------------------------------------

-- <숫자 관련 함수>

-- MOD(숫자 : 컬럼명 , 숫자 |컬럼명) 나머지 값 반환
SELECT EMP_NAME, MOD(SALARY , 1000000)
FROM EMPLOYEE e ;


-- ABS(숫자| 컬럼명) :절대값
SELECT ABS(10), ABS(-10) FROM DUAL; 

-- CEIL (숫자 | 컬럼명) : 올림
-- FLOOR (숫자 | 컬럼명) : 내림
--> 둘 다 소수점 첫째 자리에서 처리 -> 정수 결과 반환

SELECT 123.5, CEIL(123.5), FLOOR(123.5) FROM DUAL; 

---------------------------------------------------------

--ROUND (숫자 | 컬럼명 [,소수점 위치]) : 반올림
--소수점 위치 지정 X : 첫째 자리에서 반올림 -> 정수 반환
-- 소수점 위치지정 0 : 2가지 
-- 1) 양수 : 지정된 위치의 소수점 까지 표현
-- 2) 음수 : 지정된 위치의 정수 자리수 까지 표현

SELECT 123.456, 
ROUND(123.456), -- 소수점 첫째 자리에서 반올림 
ROUND(123.456, 1) , -- 소수점 첫째 자리까지 표현
ROUND(123.456, 2),  -- 소수점 둘째 자리까지 표현
ROUND(123.456, 0) , -- 그냥 반올림 - > 
ROUND(123.456, -1) , -- 소수점 -1째 자리까지 표현 -> 정수 1의 자리에서 반올림
ROUND(123.456, -2) -- 소수점 -2째 자리까지 표현 -> 정수 10의 자리에서 반올림
FROM DUAL; 

------------------------------------------------------------- 

-- TRUNK (숫자 | 컬럼명 , [,소수점 위치]) : 잘라내기 , 버림

SELECT 123.456, 
TRUNC(123.456,1), 
TRUNC(123.456,2) ,
TRUNC(123.456,0) ,
TRUNC(123.456,-1),
TRUNC(123.456,-2) 
FROM DUAL;

SELECT FLOOR(123.5), TRUNC(123.5)
FROM DUAL;

SELECT EMP_NAME , TRUNC(SALARY,-6) || '원이상' 급여
FROM EMPLOYEE e ;

----------------------------------------------------------------

-- <날짜 관련 함수>
--SYSDATE : 시스템의 현재 시간 (년 월 일 시 분 초 ) 
--SYSTIMESTAMP : SYSDATE 반환값 + MS 단위 추가

SELECT SYSDATE,SYSTIMESTAMP FROM DUAL;

------------------------------------------------------------------

--MONTH_BETWEN(날짜,날짜)

SELECT '약' ||
ROUND( MONTHS_BETWEEN('2023/07/14','2023/02/06')) ||
'개월' 훈련기간
FROM DUAL; 

-- EMPLOYEE 테이블에서
-- 사원의 이름 , 입사일 근무 N년차 근속 개월수 

SELECT EMP_NAME, HIRE_DATE,
CEIL(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12) "근무 N년차"
,FLOOR(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)) 
"근속 개월 수"
FROM EMPLOYEE e ;

---------------------------------------------------------------

--ADD_MONTHS (날짜, 숫자) : 날짜에 숫자만큼의 개월 수를 더함
SELECT ADD_MONTHS(SYSDATE,-1), SYSDATE ,ADD_MONTHS(SYSDATE,1)
FROM DUAL;

--LAST_DAY (날짜) : 해당 월의 마지막 날짜를 반환
SELECT LAST_DAY('2023/04/01')+1
FROM DUAL;


-----------------------------------------------

-- EXTRACT (YEAR | MONTH | DAY FROM 날짜)
-- 날짜에서 년 | 월 | 일을 추출하여 정수로 반환

-- EMPLOYEE 테이블에서
-- 각 사원의 이름, 입사 년 월 일 조회

SELECT EMP_NAME AS이름,
  EXTRACT (YEAR FROM HIRE_DATE)AS 년,
  EXTRACT (MONTH FROM HIRE_DATE)AS 월,
  EXTRACT (DAY FROM HIRE_DATE)AS 일
  FROM EMPLOYEE WHERE EXTRACT (YEAR FROM HIRE_DATE) >= 2000
  ORDER BY 년;
 ---------------------------------------------------------------
 
 --<형변환 함수>
 
 -- 문자열(CHAR) <-> 숫자(NUMBER) 
 -- 문자열(CHAR) <-> 날짜(DATE) 

 -- 숫자(NUMBER) -> 날짜(DATE) 

 /* TO_CHAR(날짜 | 숫자[,포맷]) : 문자열로 변환
  * 
  * 숫자 -> 문자열
  * 포맷
  * 1) 9 : 숫자 한칸을 의미 오른쪽으로 정렬 
  * 2) 0 : 숫자 한칸을 의미 오른쪽으로 정렬 + 빈칸에 0을 추가한다  
  * 3) L : 현재 시스템이나 DB에 설정된 나라의 화폐 기호
  * 4) , : 숫자의 자릿수 구분
  */
 
 SELECT 1234,
 TO_CHAR(1234,'99999'),  
 TO_CHAR(1234,'00000') 
 FROM DUAL; 
 
SELECT 1000000,
TO_CHAR(1000000, 'L9999999'),
TO_CHAR(1000000, '$9999999'),
TO_CHAR(1000000, '$9,999,999')
 FROM DUAL;
 
-- EMPLOYEEE 테이블에서
-- 사번 이름 연봉

SELECT EMP_ID,EMP_NAME, TO_CHAR(SALARY *12,'L99,999,999')AS 연봉
FROM EMPLOYEE e ;

/* 날짜 -> 문자열
 * YY :년도 (짧게) EX) 23
 * YYYY :년도 (길게) EX) 2023
 * RR : 년도 (짧게) EX) 23 YY와 유사하나 쓰임이 다르다
 * RRRR : 년도 (길게) EX) 2023
 * MM : 월
 * DD : 일
 * 
 * AM / PM : 오전 / 오후
 * 
 * HH : 12시간
 * HH24 : 24시간
 * MI : 분
 * SS : 초
 * 
 * DAY : 요일
 */


SELECT SYSDATE,TO_CHAR(SYSDATE ,'YY "년" MM"월" DD"일" PM-HH-MI DY')
FROM DUAL;
-- * 포맷에 포함되지 않는 글자는 "" 내부에 작성* 위에 예시

SELECT EMP_NAME,TO_CHAR(HIRE_DATE,'RRRR"년" MM"월" DD"일" (DY)')

FROM EMPLOYEE e ;

-----------------------------------------------------------------------

-- TO_DATE(문자열,숫자[,포맷]) 
-- 문자열이나 숫자를 지정된 포맷의 날짜 형식으로 해석하여 DATE 타입으로 반환

SELECT TO_DATE('2023년 03월 07일','YYYY"년" MM"월" DD"일"') FROM DUAL;

-- 숫자 -> 날짜

SELECT 20230308 ,TO_DATE(20230308) FROM DUAL;

/* 날짜 패턴 Y와 R의 차이점  */
-- 50미만 : Y,R 둘 다 년도를 짧게 해석하는 경우 앞부분 현제 세기 적용
-- 50이상 : Y는 현재세기 R은 과거를 나타냄 

-- 1949 - 01 - 15
-- 1950 - 01 - 15
SELECT TO_DATE('490115','YYMMDD'),
	TO_DATE('490115','RRMMDD'),
	TO_DATE('500115','YYMMDD'),
	TO_DATE('500115','RRMMDD')
FROM DUAL;

-------------------------------------------------------------

--TO_NUMBER (문자열[,포맷]) : 문자열 -> 숫자로 바꿈

SELECT TO_NUMBER('$1,500','$0,000')
FROM DUAL;

-----------------------------------------

-- <NULL 처리 함수>

--NVL(컬럼명, 컬럼값이 NULL 일 경우 바꿀 값)
-- 컬럼 값이 NULL일 경우 지정된 값으로 변경

--EMPLOYEE 테이블에서 이름 급여 보너스
/* DB에서 NULL 과 연산하는 경우 모든 결과는 NULL*/
SELECT EMP_NAME,SALARY, NVL(BONUS, 0.4) , SALARY*NVL(BONUS, 0.4)
 
FROM EMPLOYEE e ;




--NVL2(컬럼명 , NULL X인 경우 값, NULL 0 인경우값)

--EMPLOYEE 테이블에서  
-- 기존에 보너스를 받지 못했던 사원은 0.3으로 변경 
-- 기존에 보너스를 받았던 사원은 기존 보너스 +0.3으로 변경
SELECT EMP_NAME,SALARY, 
NVL2(BONUS,BONUS+0.2 ,0.3) , SALARY*NVL2(BONUS,BONUS +0.2, 0.4)
 
FROM EMPLOYEE e ;

-------------------------------------------------------

-- <선택 함수>
-- 여러가지 경우에 따라 알맞은 결과를 선택하는 함수
-- (if,switch문과 비슷)

-- DECODE (계산식 | 컬럼명, 조건1,결과1,조건2,결과2..) [,일치하는 것이 없을 때]
-- 비교하는 식 또는 컬럼의 값이 일치하는 조건이 있으면 
-- 해당 조건의 결과를 반환
-- 만약 일치하는 경우가 없다면 제일 끝 값 반환 
-- 자바의 SWITCH문과 유사함

-- EMPLOYEE테이블에서 모든 사원 사번 이름 성별 조회하기
SELECT EMP_ID,EMP_NAME AS 이름, 
DECODE(SUBSTR(EMP_NO ,8,1), '1', '남자','2','여자') AS 성별
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 직급코드가 'J7'인 직원은 급여 + 급여의 10%
-- 직급코드가 'J6'인 직원은 급여 + 급여의 15%
-- 직급코드가 'J5'인 직원은 급여 + 급여의 20%
-- 나머지 직급코드의 직원은 급여 + 급여의 5%
-- 사원명, 직급코드, 급여, 지급급여

SELECT EMP_NAME,JOB_CODE,SALARY AS 기존급여,
DECODE(JOB_CODE,'J7',SALARY+(SALARY*0.1), 
'J6',SALARY+(SALARY*1.15),
'J5',SALARY*1.2,SALARY*1.5)AS 지급급여

FROM EMPLOYEE e ;

--------------------------------------------------

-- CASE

-- WHEN 조건1 THEN 결과1 
-- WHEN 조건2 THEN 결과2 
-- WHEN 조건3 THEN 결과3 
-- ELSE 결과
-- END

-- DECODE는 계산식| 컬럼 값이 딱 떨어지는 경우에만 사용가능.
-- CASE 는  계산식| 컬럼 값을 범위로 지정할 수 있다

-- 성별 CASE 버전
-- (SUBSTR(EMP_NO ,8,1), '1', '남자','2','여자')
SELECT EMP_ID,EMP_NAME AS 이름, 
CASE 
WHEN SUBSTR(EMP_NO ,8,1) = '1' THEN '남자'
WHEN SUBSTR(EMP_NO ,8,1) = '2' THEN '여자'
END AS 성별
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사번, 이름 , 급여, 구분을 조회
-- 구분은 받는 급여에 따라 초급 중급 고급으로 출력
-- 급여 500만 이상 = 고급 
-- 300만 이상 500만 이하일 때 = 중급 
-- 300만 미만일 때 = 초급

-- 단 부서코드가 D6인 사원만 직급코드 오름차순으로 조회

SELECT EMP_ID,EMP_NAME,SALARY,
CASE 
	WHEN SALARY >= 5000000 THEN '고급'
	WHEN SALARY >= 3000000 THEN '중급'
	ELSE '초급'
	END 
FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D6'
ORDER BY JOB_CODE ;

--------------------------------------------------------------------------
--------------------------------------------------------------------------

/************************** 그룹 함수 ******************************/

-- SUM(숫자가 기록된 컬럼명) : 합계
-- 모든 사원의 급여 합
SELECT SUM(SALARY) FROM EMPLOYEE e ;

-- 부서코드가 'D9'인 사원들의 급여합
SELECT SUM(SALARY) FROM EMPLOYEE e WHERE DEPT_CODE ='D9';

-- AVG
-- 모든 사원의 급여 평균 조회
SELECT ROUND(AVG(SALARY),1) FROM EMPLOYEE e ;

-- 모든 사원의 급여 합과 평균 조회
SELECT SUM(SALARY) AS 합계, ROUND(AVG(SALARY),1) AS 평균
FROM EMPLOYEE e ;

-- MAX(컬럼명) : 해당 컬럼의 최대 값
-- MIN(컬럼명) : 해당 컬럼의 최소 값

SELECT MAX(SALARY*12), MIN(SALARY*12) ,
MIN(EMP_NAME), MAX(EMP_NAME),
MIN(HIRE_DATE),MAX(HIRE_DATE)
FROM EMPLOYEE e ;


-- COUNT (* | 컬럼명) : 조회된 행의 개수를 반환
-- COUNT(*) : NULL을 포함한 모든 행의 개수를 반환
-- COUNT(컬럼명) : 지정된 컬럼의 값이 NULL인 경우를 제외한 행의 개수를 봔환
-- COUNT(DISTINCT 컬럼명) : 지정된 컬럼에서 중복된 값을 제외한 행의 개수를 반환

-- EMPLOYEE 테이블에 존재하는 모든 사원의 수
SELECT * FROM EMPLOYEE e ;

-- EMPLOYEE 테이블에서 부서코드가 있는 사원의 수
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE e ;

SELECT COUNT(*)FROM EMPLOYEE e 
WHERE DEPT_CODE IS NOT NULL;

-- EMPLOYEE 테이블에서 존재하는 직급코드의 개수
SELECT COUNT(DISTINCT JOB_CODE) FROM EMPLOYEE e; 

-- EMPLOYEE 테이블에서 남자 사원 수 여자 사원 수 조회

SELECT COUNT(DECODE(SUBSTR(EMP_NO,8,1),'1',1,NULL))AS 남자,
 COUNT(DECODE(SUBSTR(EMP_NO,8,1),'2',1,NULL)) AS 여자
FROM EMPLOYEE e ;

SELECT SUM(DECODE(SUBSTR(EMP_NO,8,1),'1',1,0))AS 남자,
 SUM(DECODE(SUBSTR(EMP_NO,8,1),'2',1,0)) AS 여자
FROM EMPLOYEE e ;

---* 서브 쿼리를 이용한 방법 * 
SELECT 
(SELECT COUNT(*) FROM EMPLOYEE e 
WHERE SUBSTR(EMP_NO,8,1)='1'),
(SELECT COUNT(*) FROM EMPLOYEE e 
WHERE SUBSTR(EMP_NO,8,1)='2')
FROM DUAL;