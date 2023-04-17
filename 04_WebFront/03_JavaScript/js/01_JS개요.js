// 이 파일 자체가 script 태그라고 생각

function btnClick2(){
    alert("그만 누르라니까 !!!!");
}




// 다크
function darkMode(){
const body = document.querySelector("body");
// ** JS는 카멜 표기법
body.style.backgroundColor = 'black';
body.style.color = 'white';
}

// 
function lightMode(){
const body = document.querySelector("body");
// ** JS는 카멜 표기법
body.style.backgroundColor = 'white';
body.style.color = 'black';
}
