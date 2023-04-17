// innerText로 내용 읽어오기

function getBoxText(){
    
    // HTML 웹 문서 내에서 
    // id 속성 값이 "test1"인 요소를 얻어와
    // test1 변수에 대입

    // var :  variable 변수 
    // var test1 은 test1로 변수 선언 자료형 선언은  x
    // JS는 대입되는 값에 따라 변수 자료형이 정해진다
    var test1 = document.getElementById("test1");

    // test1에 저장된 요소의 내용을 얻어와 
    // console 창에 출력 

    console.log(test1.innerText); // 콘솔창 출력
}

// innerText로 내용 변경하기
function setBoxText(){
    var test1 = document.getElementById("test1");

    test1.innerText= "<b>이거 좋아 <br> 진짜좋아</b>";
}

// innerHTML로 읽어오기
function getBoxElement(){

    // 문서 내에서 아이디가 test2인 요소를 얻어와 temp 변수에 저장
    var temp = document.getElementById("test2");
    console.log(temp.innerHTML);

    //참고 (감싸고 있는 요소 전체 얻어오기)
    console.log(temp.outerHTML)
}

function setBoxElement(){
    var temp = document.getElementById("test2");

    temp.innerHTML= "<b>이거 좋아 <br> 진짜좋아</b>";


}

// innnerHTML 응용하기

function add(){
    
    // 1) 아이디가 area1인 요소를 얻어와 변수에 저장

    var add = document.getElementById("area1");
    
    // 2) #area1 요소의 이전 내용에
    //      새로운 내용(요소)를 추가
    // -> 이전 내용 + 새로운 내용 (누적)
    
    console.log(add.outerHTML);
    
    add.innerHTML += '<div class="box2"></div>';
}

function fnConfirm(){
    var check = confirm("배경을 바꾸시겠습니까?");

    if(check){
        document.querySelector("body").style.backgroundColor = "pink";
    }else {
        document.querySelector("body").style.backgroundColor = "white";
    }
}

function fnPrompt(){
    var yn = prompt("이름이 뭐고?");
    
    var result;
    if(yn == null){
        result = "BoBjo";
    } else{
        result = yn + "환영해요";
    }
    
    alert(result);
}

