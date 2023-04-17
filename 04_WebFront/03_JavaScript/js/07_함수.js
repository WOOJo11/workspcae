// 기본함수 
function clickCount(btn){
    // 클릭할 때 마다 1씩 증가
    // 단, 20을 초과하면 다시 0으로 초기화

    let add = Number(btn.innerText);

    if(add>=20){
        add =-1;
    }    
    add += 1;
    btn.innerText= add;
    
}

// 익명 함수
const t2 = document.getElementById("target2");
const b2 = document.getElementById("btn2");

const colorList= ["red","orange","yellow","green","blue"];
let index = -1;

b2.addEventListener("click",function(){

    t2.style.color = colorList[++index];

    if(index == 4) index = -1; // 다시 처음부터 

});

//------------------------------------------------------

// 즉시 실행 함수

// 1) 속도적 우위
function testFn(){
console.log("일반함수")

}
testFn();

// 즉시 실행 함수는 정의가 끝나면 바로 실행

(function(){console.log("즉시 실행 함수")})();

// 2) 변수명 중복 문제 해결

const str = "전역변수";

(function(){
    const str = "지역 변수";
    console.log(str); // 지역 변수
})();

console.log(str); // 전역 변수



// --------------------------------

// 화살표 함수

// 1. 기본형태
// 익명 함수 : furction(){}
// 화살표 함수 : () => {}

document.querySelector("#button1").addEventListener("click", () => {
    alert("화살표 함수의 기본 형태 입니다.");
});

// document.querySelector("#button2").addEventListener("click", function(e){

// e.target.style.backgroundColor="pink"

// });

// 2. 매개변수 1개 
// 익명함수는 function(e){} 였다면
// 화살표 함수 : (e) =>{}
//               e =>{} ()소괄호 생략 가능
//              매개 변수가 2개 이상 또는 0개라면 괄호 생략이 불가능하다
document.querySelector("#button2").addEventListener("click",e => {
                                                    
    e.target.style.backgroundColor="pink"
});


// 4. {}, return 생략 하기

document.querySelector("#button4").addEventListener("click", () => {
    // 익명 함수 
    printConsole(function(num){return num * 10;});
    
    // 화살표 함수
    // printConsole((num)=>{return num * 100;})
    
    // 매개변수 1개 -> ()생략
    // printConsole(num=>{return num * 100;})
    
    // 함수 정의 부분에 return 만 작성 ->{} retrun 생략
    printConsole(num=> num * 100);

    // 함수 정의 부분에 return 구문만 있지만 자료형 object인 경우
    const temp={"price":100,"name":"사탕"}; // js객체

    console.log(temp);
    console.log(typeof temp);

    // object를 변수에 저장해서 리턴하는건 가능
    printConsole(num => temp)

    // return,{} 생략 상태에서 object 를 직접 작성하면 오류발생
    // -> js객체의 {}를 함수 정의 부분의 {}로 인식해서 구문오류 발생


});

function printConsole(fn){
    // 매개변수로 함수를 받아와 수행 결과를 콘솔에 출력
    console.log("-------------------")
    console.log(fn(2));
    console.log("-------------------")
}




// 화살표 함수 this 문제점

const button6= document.querySelector("#button6");

// 클릭된 요소의 배경색을 검정색으로 변경
button6.addEventListener("click",function(e){
    e.target.style.backgroundColor="black";
});

// 클릭된 요소의 글자색을 흰색으로 변경
button6.addEventListener("click", e=>{
    e.target.style.color = "white";
    
})

//클릭된 요소의 폰트 크기를 25px로 증가(익명,e사용x this 사용 o)

button6.addEventListener("click",function(){

    console.log(this)
    this.style.fontSize="25px"
});

// 클릭된 요소의 폰트 크기를 3px 신선 pink로 변경

button6.addEventListener("click",()=>{
    console.log(this);
    // 화살표 함수에 this를 작성하면
    // 이벤트가 발생한 요소가 아닌
    // 창 자체를 나타내는 window 객체가 반환된다
    this.style.border = "3px solid pink";

});
