const loginForm = document.getElementById("loginForm");
const memberEmail = document.querySelector("#loginForm input[name=memberEmail]");
const memberPw = document.querySelector("#loginForm input[name=memberPw]");

// 로그인 시도를 할때
loginForm.addEventListener("submit",e=>{

// form태그 기본 이벤트 제거
//e.preventDefault();

// 이메일이 입력되지 않은 경우
// 문자열.trim() : 문자열 좌우 공백 제거
if(memberEmail.value.trim().length==0){
    alert("이메일을 입력해주세요");
    
    memberEmail.value="";   //  잘못입력된 값 제거
    memberEmail.focus(); // 이메일 input태그에 초점을 맞춤

    e.preventDefault();
    return;
}

// 비밀번호가 입력되지 않은 경우
if(memberPw.value.trim().length==0){
    alert("비밀번호를 입력해주세요");

    memberPw.value="";
    memberPw.focus();
    e.preventDefault();
    return;
}


});