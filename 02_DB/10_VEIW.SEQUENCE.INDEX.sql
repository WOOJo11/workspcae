/*VIEW
 * 
 *  - 논리적 가상 테이블
 * 	- > 테이블 모양을 하고는 있지만 실제로 값을 저장하고 있진 않음
 * 
 *  - SELECT문의 실행결과(RESULT SET)를 저장하는 객체
 * 
 * 	** VIEW 사용 목적 **
 *  1) 복잡한 SELECT문을 쉽게 재사용하기 위해
 *  2) 테이블의 진짜 모습을 감출 수 있어 보안상 유리
 * 	
 *  ** VIEW 사용 시 주의 사항 ** 
 * 	1) 가상의 테이블이라 실체 존재X SO ALTER 구문 사용 불가
 *  2) VIEW를 이용한 DML(INSERT,UDAPTE,DELETE)이 가능한 경우도 있지만
 * 	   제약이 많이 따르기 때문에 조회(SELECT) 용도로 대부분 사용
 *  
 *  ** VIEW 작성법 ** 
 *  CREATE [OR REPLACE] [FORCE | NOFORCE]VIEW 
 *  AS 서브쿼리(SELECT문)
 * 	[WITH CHECK OPTION]	
 * 	[WITH READ ONLY]	
 * 
 * 	1) OR REPLACE 옵션 : 기존의 동일한 이름의 VIEW 가 존재하면 이를 변경
 * 						없으면 새로 생성
 * 
 * 	2) FOCE | NOFORCE 옵션 : 
 * 	FORCE  : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰 생성
 * 	NOFORCE : 서브쿼리에 사용된 테이블이 존재해야만 뷰 생성
 * 	 	
 * 	3) 컬럼 별칭 옵션 : 조회되는 VIEW의 컬럼명을 지정
 * 
 * 	4) WITH CHECK OPTION : 옵션을 지정한 컬럼의 값을 수정 불가능하게 함
 * 
 *  5) WITH READ ONLY : 뷰에 대해 SELECT만 가능하도록 지정
 * 
 */

-- EMPLOYEE 테이블에서 
-- 모든사원의 사번, 이름, 부서명, 직급명 조회
SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE e 
LEFT JOIN DEPARTMENT d ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);
-- VIEW 생성

CREATE VIEW V_EMP
AS SELECT EMP_ID,EMP_NAME,DEPT_TITLE,JOB_NAME
FROM EMPLOYEE e 
LEFT JOIN DEPARTMENT d ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);

--SYS 계정으로 접속
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
--> 각 계정에 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO kh_jwh;


-- 생성된 VIEW를 이용해서 조회
SELECT * FROM V_EMP;

-- V_EMP 뷰 수정하기 (OR REPLACE)
CREATE OR REPLACE VIEW V_EMP
AS SELECT EMP_ID AS 사번,EMP_NAME AS 이름,DEPT_TITLE AS 부서명,JOB_NAME AS 직급명
FROM EMPLOYEE e 
LEFT JOIN DEPARTMENT d ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);

SELECT * FROM V_EMP;

-- V_EMP에서 직급이 대리인 사원의 정보를 조회

SELECT * FROM V_EMP
WHERE 직급명 = '대리';
----------------------------------------------------------------

/* VIEW 를 이용한 DML */
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2에서
-- DEPT_ID LOCATION_ID 컬럼만 조회하는 
-- VIEW 생성

CREATE VIEW V_DCOPY2
AS SELECT DEPT_ID, LOCATION_ID
FROM DEPT_COPY2;

SELECT * FROM V_DCOPY2;

-- VIEW를 이용한 INSERT 
INSERT INTO V_DCOPY2
VALUES('D0','L3');

SELECT * FROM V_DCOPY2;
-- VIEW 는 값을 저장하지 않느다고 했는데
-- 저장된 것 처럼 보인다 
-- 실제 VIEW에 저장된것이 아니라
-- VIEW를 생성할 때 사용한 서브쿼리의 테이블에 
-- 값이 삽입되어있다
-- 사실확인을 해보자

SELECT * FROM DEPT_COPY2;
-- 원본 테이블에 삽입됨을 확인
-- INSERT 구문에 포함되지 않은 DEPT_TITLE 컬럼은 NULL 삽입되어있다
ROLLBACK;
SELECT * FROM V_DCOPY;

ALTER TABLE DEPT_COPY2 MODIFY DEPT_TITLE NOT NULL;
SELECT * FROM DEPT_COPY2;

-- 다시 VIEW를 이용해서 INSERT 해보자
INSERT INTO V_DCOPY2
VALUES('D0','L3');

-- > 원본 테이블 DEPT_ID, LOCATION 컬럼에 'D0', 'L3'삽입
-- > DEPT_TITLE 컬럼에는 NULL 삽입
-- > 하지만 NOT NULL 제약조건이 설정되있어 NULL 값 삽입 불가 

-- 데이터 무결성 : 중복 X NULL X -> 신뢰도 높은 디이터
-- 대부분의 컬럼에 NOT NULL 제약조건 추가되어 있음
-- NOT NULL이 설정된 테이블을 이용해서 VIEW를 만들면
-- INSERT 가 거의 불가능함
-- SO WHAT? VIEW를 가지고 DML 수행하는 행동을 지양해라

----------------------------------------------------------------

/* WITH READ ONLY 옵션 추가 */
-- 읽기 전용 X VIEW 생성
CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2;

INSERT INTO V_DCOPY2
VALUES('D0','기획팀','L3');

ROLLBACK;

CREATE OR REPLACE VIEW V_DCOPY2
AS SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID FROM DEPT_COPY2
WITH READ ONLY;

INSERT INTO V_DCOPY2
VALUES('D0','기획팀','L3');
--------------------------------------------------------------

/* SEQUENCE ( 순서,연속)
 * 
 *  - 순차적으로 일정한 간격의 숫자(번호)를 발생시키는 객체
 *  	(번호 생성기)
 *  왜 사용을 할까??
 * 	PRIMARY KEY (기본키) : 테이블 내 각 행을 구별하는 식별자
 * 						 NOT NULL + UNIQUE의 의미를 가짐
 * 
 *  PK가 지정된 컬럼에 삽입될 값을 생성할 때 SEQUENCE를 이용하면 좋다
 * 
 *   [작성법]
  CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트

-- 시퀀스의 캐시 메모리는 할당된 크기만큼 미리 다음 값들을 생성해 저장해둠
-- --> 시퀀스 호출 시 미리 저장되어진 값들을 가져와 반환하므로 
--     매번 시퀀스를 생성해서 반환하는 것보다 DB속도가 향상됨.
 * 
 *  ** 사용법 ** 
 * 
 *  1) 시퀀스명.NEXTVAL : 다음 시퀀스 번호를 얻어옴
 * 					   (INCREMENT BY 만큼 증가된 수)
 *						단, 생성 후 처음 호출된 시퀀스인 경우
 *						START WITH에 작성된 값이 반환됨.
 * 
 *  2) 시퀀스명.CURRVAL : 현재 시퀀스 번호를 얻어옴.
 * 						단, 시퀀스가 생성 되자마자 호출할 경우 오류발생
 * 						== 마지막으로 호출한 NEXTVAL 값을 반환
 * 
 */

-- 테이블 생성

CREATE TABLE TB_TEST(
	TEST_NO NUMBER PRIMARY KEY,
	TEST_NAME VARCHAR2(30) NOT NULL
);

-- 시퀀스 생성
CREATE SEQUENCE SEQ_TEST_NO
START WITH 100 -- 100번 부터 시작 
INCREMENT BY 5 -- 5씩 증가
MAXVALUE 150 --  최대값
NOMINVALUE -- 최소값 없음
NOCYCLE -- 싸이클 돌지않음
NOCACHE; -- 미리 만들어두는 숫자 없음

-- 시퀀스 생성 확인

SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 100

SELECT SEQ_TEST_NO.CURRVAL FROM DUAL; -- 처음으로 쓸수 없다 

SELECT SEQ_TEST_NO.NEXTVAL FROM DUAL; -- 105 실행할 수록 5씩 증가하나 150에 멈춤
--그러나 150을 초과했을떄 다시 사이클이 돌아가지 않음 

-- TB_TEST 값을 삽입

INSERT INTO TB_TEST 
VALUES (SEQ_TEST_NO.NEXTVAL,'홍길동' || SEQ_TEST_NO.CURRVAL );

SELECT * FROM TB_TEST;

-- INSERT 추가수행
INSERT INTO TB_TEST 
VALUES (SEQ_TEST_NO.NEXTVAL,'홍길동' || SEQ_TEST_NO.CURRVAL );

SELECT * FROM TB_TEST;


-- UPDATE 
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL, 
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
	WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);
  	
-- UPDATE 확인
SELECT * FROM TB_TEST;

-- UPDATE 추가확인
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL, 
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
	WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

SELECT * FROM TB_TEST;

-- 가장 마지막 TEXT_NO를 조회하는 SELECT 
SELECT MAX(TEST_NO) FROM TB_TEST;

---------------------------------------------------------
-- SEQUENCE 변경 (ALTER)

 /*CREATE SEQUENCE 시퀀스이름
  [STRAT WITH 숫자] -- 처음 발생시킬 시작값 지정, 생략하면 자동 1이 기본
  [INCREMENT BY 숫자] -- 다음 값에 대한 증가치, 생략하면 자동 1이 기본
  [MAXVALUE 숫자 | NOMAXVALUE] -- 발생시킬 최대값 지정 (10의 27승 -1)
  [MINVALUE 숫자 | NOMINVALUE] -- 최소값 지정 (-10의 26승)
  [CYCLE | NOCYCLE] -- 값 순환 여부 지정
  [CACHE 바이트크기 | NOCACHE] -- 캐쉬메모리 기본값은 20바이트, 최소값은 2바이트
*/

--SEQ_TEST_NO 의 증가값을 1, 최대값 155로 수정
ALTER SEQUENCE SEQ_TEST_NO
INCREMENT BY 1
MAXVALUE 155;
	
-- 업데이트 구문 다시 실행
UPDATE TB_TEST
SET TEST_NO = SEQ_TEST_NO.NEXTVAL, 
	TEST_NAME = '고길동' || SEQ_TEST_NO.CURRVAL
	WHERE TEST_NO = (SELECT MAX(TEST_NO) FROM TB_TEST);

SELECT * FROM TB_TEST;

---------------------------------------------------
--VIEW , SEQUENCE 삭제
DROP VIEW V_DCOPY2;
DROP SEQUENCE SEQ_TEST_NO;
SELECT * FROM V_DCOPY2;
-- 시퀀스는 START WITH 을 변경하고 싶다면 삭제 후 다시 생성해야함

----------------------------------------------------------------

/* INDEX(색인)
 * - SQL 구문 중 SELECT 처리 속도를 향상 시키기 위해
 * 	컬럼에 대하여 생성하는 객체
 * 
 *  - 인덱스 내부 구조는 B* 트리 형식으로 되어있음.
 * 
 * ** INDEX의 장점 ** 
 * - 이진 트리 형식으로 구성되어 자동 정령 및 검색 속도 증가.
 * - 조회 시 테이블의 전체 내용을 확인하며 조회하는 것이 아닌
 * 	 인덱스가 지정된 컬럼만을 이용해서 조회하기 때문에
 * 	 시스템의 부하가 낮아짐
 *
 * ** INDEX의 단점 **
 * - 데이터 변경 (INSERT ,UPDATE , DELETE) 작업시 
 *   이전 트리 구조에 변형이 일어남
 * 	 -> DML 작업이 빈번한 경우 시스템 부하가 늘어 성능이 저하됨
 * 
 *  - 인덱스도 하나의 객체이다 보니 별도 저장공간이 필요 (메모리 소비)
 *  
 *  -인덱스 생성 시간이 필요함
 * 
 * 	[작성법]
 * 	
 * 	CREATE INDEX 인덱스명
 * 	ON 테이블 명(컬럼명[,컬럼명 | 함수명]);
 * 
 * 	DROP INDEX 인덱스명;
 * 	
 *  	** 인덱스가 자동 생성되는 경우**
 *  - > PK 또는 UNIQUE 제약조건이 설정된 컬럼에 대해 
 * 		UNIQUE INDEX 가 자동 생성된다
 * 
 */

-- INDEX 사용 X 검색

SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0';

-- INDEX 사용 O 검색
--WHERE INDEX가 설정된 컬럼을 언급

SELECT * FROM EMPLOYEE
WHERE EMP_NAME != '0';
--> 데이터가 적어서 차이 식별 불가

-- 인덱스 확인용 테이블 생성
CREATE TABLE TB_INDEX_TEST(
	TEST_NO NUMBER PRIMARY KEY,
	TEST_ID VARCHAR(20) NOT NULL);

-- TB_INDEX_TEST 테이블에 샘플 데이터 100만개 삽입
-- (PL/SQL) 사용
BEGIN
	FOR I IN 1..1000000
	LOOP 
		INSERT INTO TB_INDEX_TEST VALUES(I,'TEST'|| I);
	END LOOP;
	COMMIT;
END;

-- INDEX 사용 X조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_ID= 'TEST500000';

-- INDEX 사용 O조회 
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_NO= 500000;

-- TEST_ID 컬럼에 대한 인덱스 생성
CREATE INDEX IDX_TEST_ID
ON TB_INDEX_TEST(TEST_ID);

-- INDEX 생성 후 조회
SELECT * FROM TB_INDEX_TEST 
WHERE TEST_ID= 'TEST500000';

-------------------------------------------
--INDEX 삭제
DROP INDEX IDX_TEST_ID;

DROP TABLE TB_INDEX_TEST ;


