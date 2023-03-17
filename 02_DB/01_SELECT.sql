/*SELECT (조회, DQL 또는 DML) 검색
 * 
 *  - 데이터를 조회하면 조건에 맞는 행들이 조회됨
 *  -> 조회된 행들의 집합을 "RESULT SET"이라고 한다
 * 
 *  - RESULT SET은 0개 이상의 행이 포함될 수 있다
 *  -> 왜 0개 이상?? 조건에 맞는 행이 없을 수 있기때문에
 * 
 *  [작성법] 
 * 
 *  SELECT 컬럼명 | *(모든 컬럼)
 *  FROM 테이블 명 
 *  WHERE 조건식; -- 조건에 맞는 행만 조회
 */
-- EMPLOYEE 테이블에서 모든 컬럼을 조회
-- (WHERE절 없음 == 모든행)
-- '*' : ALL , 모두, 전부를 뜻함
 SELECT * FROM EMPLOYEE;
	
 SELECT EMP_NAME FROM EMPLOYEE;
 	
 SELECT	EMP_ID,EMP_NAME, PHONE FROM EMPLOYEE;

 SELECT * FROM DEPARTMENT;

 SELECT DEPT_TITLE FROM DEPARTMENT;

---------------------------------------------------------------

-- <컬럼 값 산술 연산>

-- 컬럼 값 : 행과 열이 교차되는 테이블의 한 칸 (== 한셀)에 작성된 값(DATA)

--SELECT 문 작성시 컬럼명에 산술 연산을 작성하면 
-- 조회되는 결과 컬럼 값에 산술 연산이 반영된다 

-- EMPLOYEE 테이블에서 모든 사원의 사번 , 이름, 급여 , 급여 + 100만을 조회

 SELECT EMP_ID,EMP_NAME, SALARY,SALARY + 1000000 FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 모든 사원의 사번, 연봉(급여 * 12)

SELECT EMP_ID, EMP_NAME, SALARY * 12 FROM EMPLOYEE;

------------------------------------------------------------------

-- (중요!!) <오늘 날짜 조회>

SELECT  SYSDATE FROM DUAL;
-- SYSDATE : 시스템상의 현재 날짜 (시간)

-- DUAL(DUMMY TABLE ) 약어 : 가짜 테이블 (실제 테이블이 아닌 임시 테이블 용도)
SELECT 100*20+30 FROM DUAL;

-- 어제, 오늘, 내일 조회
--> DATE타입에 +,- 연산 가능 (일 단위)
SELECT SYSDATE-1, SYSDATE, SYSDATE + 1 FROM DUAL;

-- 30분 후 조회
SELECT SYSDATE +(1/24/60*30)   FROM DUAL; 

-- EMPLOYEE 테이블에서 이름, 입사일, 오늘 까지 근무한 날짜
-- 시간 끼리 연산 가능 (미래로 갈수록 큰 수)
-- 연산 결과는 일 단위로 조회 
SELECT EMP_NAME , HIRE_DATE, (SYSDATE -HIRE_DATE) / 365  FROM EMPLOYEE e;


------------------------------------------------------------------------------------------

-- <컬럼 별칭 지정>

-- 별칭 지정방법
-- 1) 컬럼명 AS 별칭 : 문자 가능 하지만 띄어쓰기X 특수문자 X 
-- 2) 컬럼병 AS "별칭" :문자 띄어쓰기 특수문자 가능
-- 3) 컬럼명 별칭 : 문자 가능 띄어쓰기 X 특수문자 X
-- 4) 컬럼명 "별칭" : 문자 띄어쓰기 특수문자 가능

-- EMPLOYEE 테이블에서 이름 , 연봉 조회
SELECT EMP_NAME  "사원 이름", SALARY * 12  "연봉(월급*12)" FROM EMPLOYEE e ;
-- AS 가 없어도 가능하지만 가독성을 위해 AS를 붙여서 씀 

-- 리터럴 :  표현되는 값 자체
-- DB에서 리터럴 : 임의로 지정한 값을 기존 테이블에 존재하는 값 처럼 사용
--> 리터럴 표기법 : ''(홑따옴표, 기본적으로 문자열 의미)


SELECT EMP_NAME, SALARY, '원' AS 단위 FROM EMPLOYEE ;

--------------------------------------------------------------------------

-- <DISTINCT>
--> 조회 시 지정된 컬럼에 중복 값을 한 번만 표시할 때 사용

SELECT DISTINCT DEPT_CODE  FROM EMPLOYEE e ;


-----------------------------------------------------------------------------


-- <WHERE 절 >
-- 테이블에서 조건을 충족하는 컬럼 값을 가진 행만 조회할 때 사용

-- WHERE 절에는 조건식(TRUE/FALSE)을 작성

-- 비교 연산자 : >, >=, <,<=, = (같다) != , <>(같지않다)  
-- 논리 연산자 : AND OR NOT 

-- EMPLOYEE 테이블엣 급여가 3백만원 초과인 사원의 
-- 사번, 이름, 급여, 부서코드 조회
/*해석순서
 * 1 FROM
 * 2 WHERE
 * 3 SELECT
 */
SELECT EMP_ID, EMP_NAME,SALARY, DEPT_CODE  FROM EMPLOYEE e WHERE(SALARY > 3000000) ;

-- EMPLOYEE 테이블에서
-- 연봉이 5천만원 이하인 사원의 사번, 이름조회

SELECT EMP_ID ,EMP_NAME FROM EMPLOYEE e WHERE SALARY *12 <= 50000000 AND DEPT_CODE != 'D9';

-- EMPLOYEE 테이블에서 부서코드가 D9이 아닌 사원의 
-- 사번 이름 부서코드 전화번호 조회

SELECT EMP_ID,EMP_NAME,DEPT_CODE,PHONE FROM EMPLOYEE WHERE DEPT_CODE !='D9';

-- EMPLOYEE 테이블에서 부서코드가 'D6' 
-- 급여가 200만 이상인 사원의 
-- 이름 급여 부서코드 조회

SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE = 'D6' AND SALARY >3000000;
SELECT EMP_NAME, SALARY, DEPT_CODE FROM EMPLOYEE WHERE DEPT_CODE = 'D6' AND BONUS IS NULL;


-- EMPLOYEE 테이블에서
-- 급여가 300만 이상 500만 이하인 직원의 모든 컬럼 조회
-- 그리고 보너스가 없는 사람 
SELECT * FROM EMPLOYEE  WHERE  SALARY >=3000000 AND SALARY <+5000000 AND BONUS IS NULL;


-- 컬럼명 BETWEEN A AND B : 컬럼 값이 A이상 B이하인경우 TRUE 

SELECT * FROM EMPLOYEE e WHERE SALARY BETWEEN 3000000 AND 5000000 AND BONUS IS  NULL; 

-- EMPLOYEE 테이블에서
-- 급여가 300만 이상 500만 이하가 아닌 직원의 모든 컬럼 조회
-- == 300만 미만, 500만 초과
SELECT * FROM EMPLOYEE e WHERE SALARY < 3000000 OR SALARY >5000000;

-- NOT BETWEEN A AND B : 
-- 컬럼 값이 A이상 B 이하가 아닌경우
-- == A 미만 , B 초과

SELECT * FROM EMPLOYEE e WHERE SALARY NOT BETWEEN  3000000 AND 5000000;
SELECT * FROM EMPLOYEE e WHERE SALARY IS NOT NULL;


-- EMPLOYEE 테이블에서
-- 부서코드가 'D5'또는 'D6' 또는 'D9'인 사원의 
-- 사번 이름 부서코드 조회

SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE e 
WHERE DEPT_CODE = 'D5' OR DEPT_CODE ='D6' OR DEPT_CODE =  'D9';

-- 컬럼명 IN (값1,값2,값3,,,,,,,,,,,,) : 컬럼 값에 () 안의 값이 포함된 행은 TRUE

SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE e 
WHERE DEPT_CODE IN ('D5','D6','D9');

SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE e 
WHERE DEPT_CODE NOT IN ('D5','D6','D9');


SELECT EMP_ID,EMP_NAME,DEPT_CODE FROM EMPLOYEE e 
WHERE DEPT_CODE IS NULL OR DEPT_CODE IN('D5','D6','D9');

--------------------------------------------------------------------------

--< NULL 처리 연산 >

-- JAVA에서 NULL : 참조하는 객체가 없다
-- DB에서 NULL : 컬럼 값이 없다

-- IS NULL : 컬럼 값이 NULL인 경우 TRUE
-- IS NOT NULL : 컬럼 값이 NULL인 아닌 경우 TRUE

-- EMPLOYEE 테이블에서 부서가 없는 사원 모든 정보 조회
SELECT * FROM EMPLOYEE e WHERE DEPT_CODE IS NULL;

SELECT * FROM EMPLOYEE e WHERE DEPT_CODE IS NOT NULL;

------------------------------------------------------------------------------

-- 연결 연산자 (||) 
-- 여러 값을 하나의 컬럼 값으로 연결하는 연산자
-- (== 자바의 문자열 이어쓰기 )

-- 000의 급여는 000원 입니다.

SELECT EMP_NAME ||'의 급여는 ' ||  SALARY || ' 원 입니다' AS "급여 내용" FROM EMPLOYEE e ;

SELECT * FROM EMPLOYEE e WHERE EMP_NAME NOT LIKE '김';













