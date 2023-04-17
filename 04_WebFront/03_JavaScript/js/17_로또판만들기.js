const createBtn = document.getElementById("createBtn");
const lottoBoard =document.getElementById("lottoBoard");

createBtn.addEventListener("click", ()=> {
lottoBoard.innerHTML = ""; // 이전에 생성된 내용을 모두 삭제
                            // 클릭할 때 마다 계속 번호가 생성되는걸 방지

for(let i=1; i<=45; i++){ // 1~45까지 증가
    
    // 로또판에 들어가 div요서 생성
    const innerDiv = document.createElement("div");

    // div 요소에 i(1~45) 값 
    innerDiv.innerText=i;

    // innerDiv에 number 클래스 추가 
    innerDiv.classList.add("number");

    // innerDiv가 클릭 되었을 때 배경색 변경 / 제거
    innerDiv.addEventListener("click",e=>{
        if(e.target.classList.contains("active")){
            e.target.classList.remove("active");
        }else{
            // active 클래스가 없으면 추가
            e.target.classList.add("active");
        }
        // active 클래스를 가진 요소가 6개 이상인 경우
        if(document.getElementsByClassName("active").length>6)
        alert("6개 까지만 선택할 수 있습니다");
        return;
        

    });
    // 로또판에 div 추가
    lottoBoard.append(innerDiv);

}

});