<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
            <section>
                <!-- 클릭시 메인 페이지로 이동하는 로고 -->
                <a href="#">
                    <img src="/resources/images/logo.jpg" alt="로고" id="homeLogo">
                </a>
            </section>


            <section>
                <!-- 검색어를 입력할 수 있는 요소 배치 -->
                <article class="search-area">
                <!--    action : 내부 input에 작성된 값을 제출할 경로/주소 
                        method : 어떤 방식으로 제출할지 지정
                        - get : input 태그 값을 주소에 담아서 제출(주소에 보임)
                        - post : input 태그 값을 주소에 담아서 제출(주소에 안보임)
                                -> HTTP Body에 담아서 제출
                        -->
                    <form action="#" method="get">
                        <fieldset> <!-- form태그 내 영역 구분 -->
                            <!-- 
                                input의 name 속성 == 제출 시 key
                                iuput의 입력된 내용 ==  제출시 value
                            -->
                            <input type="search" name="query" id="query" 
                            placeholder="검색어를 입력해 주세요." autocomplete="off"> 
                    <!--검색 버튼  -->
                    <button id="searchBtn" class="fa-solid fa-magnifying-glass"></button>

                        </fieldset>


                    </form>
                </article>
            </section>
            <section></section>
        </header>

        <nav>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">자유게시판</a></li>
                <li><a href="#">질문게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li>
            </ul>
        </nav>