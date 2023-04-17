// 인라인 이벤트 모델 확인하기
function test1(el){ //el == element == 전달 받은 요소

    el.style.background = 'black';
    el.style.color = 'white';


}

// 고전 이벤트 모델 확인하기

// 아이디가 test2a 인 요소를 얻어오기
console.log(document.getElementById('test2a').onclick);
// -> null 출력(아직 click 했을 때 동작할 함수(이벤트 핸들러)가 없음)

document.getElementById('test2a').onclick = function(){

    // function (){} : 익명 함수 (이름이 없는 함수)
    //                  재사용 목적이 아닌
    //                  특정 이벤트에 대한 기능을 만들 때 주로 사용
    alert("고전 이벤트 모델로 출력된 내용입니다");
}

// test2a의 클릭 이벤트 동작을 제거(이벤트 제거)

document.getElementById('test2b').onclick = function(){

    document.getElementById('test2a').onclick =null;
    alert("이벤트를 제거하였습니다");
}


// 고전 이벤트 모델의 단점
// -> 한 요소에 여러 이벤트 핸들러를 연결할 수 없음!
//    왜? 마지막으로 작성한 핸들러가 앞서 작성된 핸들러를 덮어 씌움

const c = document.getElementById('test2c'); // 버튼 요소를 얻어오고 c라고 명칭

c.onclick = function(){

    c.style.backgroundColor = 'pink'; // 배경색 핑크
    
}
// 위에꺼 복사
c.onclick = function(){

    c.style.fontSize = '40px'; // 배경색 핑크

}

// 표준 이벤트 모델 확인하기 
/* 
    [표준 이벤트 모델 작성 방법]

    요소.addEventListener(감지할 이벤트, 이벤트 핸들러);

    ex)
    test3.addEventListener("click",funtion(){})
*/

const test3 = document.getElementById("test3");

// #test 클릭시 width를 20px 만큼 증가
test3.addEventListener("click",function(){

    // 요소.clientWidth : 요소의 너비(CSS로 지정된 값도 읽어옴, readonly)
    // 요소.clientHeight : 요소의 높이(CSS로 지정된 값도 읽어옴 , readonly)



test3.style.width = test3.clientWidth + 20 + "px";

});

// 중간에 2만줄 .........

test3.addEventListener("click",function(){

    // this : 이벤트가 발생한 요소(#test3를 의미)

    this.style.height = this.clientHeight+20+"px";



});


test3.addEventListener("click",function(e){

    // 이벤트 핸들러의 매개변수 e 또는 event 하나를 사용 
    // -> 현재 발생한 이벤트에 대한 모든 정보를 담고있는 객체
    // == 이벤트 객체 

    // e.target : 이벤트가 발생한 현재 요소 (==this)

// console.log(e);

    const currentWidth = e.target.clientWidth;

    
    // 현재 너비가 500px을 초과하면 너비 높이를 200 px로 초기화 

    if(currentWidth>500){
        e.target.style.width = "200px";
        e.target.style.height = "200px";
    }


});

// 간이 계산기 

/* const plus = document.getElementById("plus");

plus.addEventListener("click",function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("result");
    result.innerText = Number(num1)+Number(num2);


});

const minus = document.getElementById("minus");

minus.addEventListener("click",function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("result");
    result.innerText = Number(num1)-Number(num2);


});

const multi = document.getElementById("multi");

multi.addEventListener("click",function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("result");
    result.innerText = Number(num1)*Number(num2);


});

const divide = document.getElementById("divide");

divide.addEventListener("click",function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("result");
    result.innerText = Number(num1)/Number(num2);


});

const share = document.getElementById("share");

share.addEventListener("click",function(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var result = document.getElementById("result");
    result.innerText = Number(num1)%Number(num2);


}); */

const num1 = document.getElementById("num1");
const num2 = document.getElementById("num2");
const result = document.getElementById("result");

// 클래스가 op 인 요소를 모두 찾아 배열로 반환
const opList =document.getElementsByClassName("op");

for(let op of opList){
    // console.log(opList[i]);

    // 배열의 각 요소 == 각각의 버튼에 click 되었을 때의 동작을 추가

    // for ofr 구문(향상된 for문)
    // -> 배열(Array) , 유사배열(HTMLCollection,NodelList)
    //  위와 같이 배열 형태의 요소를 순차 접근하는 용도의 반복문

    op.addEventListener('click',function(e){
        result.innerText 
        = new Function("return " + Number(num1.value) 
                                + e.target.innerText 
                                + Number(num2.value))();
    });
}



const boxList = document.getElementsByClassName("box");
const colorList = document.getElementsByClassName("color");


/* for(let i = 0; i<boxList.length; i++){

colorList[i].addEventListener('keyup',function(){

    boxList[i].style.backgroundColor = colorList[i].value;

});

} */

for(let color of colorList){
    color.addEventListener("keyup",function(e){
        e.target.previousElementSibling.style.backgroundColor = e.target.value;
    });
}
    

// a 태그 기본 이벤트 제거

document.getElementById("moveGoogle").addEventListener("click",function(e){

    // e : 이벤트 객체
    e.preventDefault();

});

// form 태그 기본 이벤트 제거1
// -> submit 버튼을 없애고
// 일반 button이 클릭 되었을 때 조건이 맞으면 submit 하게 만들기

/* document.getElementById("btn").addEventListener("click",function(){

    // 작성된 아이디, 비밀번호 얻어오기
    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;
    
    if(id=='user01' && pw=='pass01'){
        // 아이디, 비밀번호가 일치할 때 form 태그제출

        document.testForm.submit();
    }

}); */

// form 태그 기본 이벤트 제거 방법2 (인라인 이벤트 모델)
function fnCheck(){

    const id = document.querySelector("[name='id']").value;
    const pw = document.querySelector("[name='pw']").value;
    
    if(id=='user01' && pw=='pass01'){
        // 아이디, 비밀번호가 일치할 때 form 태그제출

        return true; // true를 반환해서 제출 수행
    }
        return false; // false를 반환해서 제출을 막음


} 


// form 태그 기본 이벤트 제거 방법2 (표준 이벤트 모델)
// -> name이 testFrom인 form태그에서 submit 이벤트가 발생 했을 때

document.testForm.addEventListener("submit",function(e){

    // e : 이벤트 객체

    e.preventDefault();// 기본 이벤트 막기

});


















