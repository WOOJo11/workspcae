const insertBtn = document.querySelector("#insertBtn");


// 글쓰기 버튼 클릭시
insertBtn.addEventListener("click",()=>{
    // JS BOM 객체 중 loaction 
    
    // location.href = "주소"
    // 해당 주소 요청 (Get 방식)

    location.href= `/board2/${location.pathname.split("/")[2]}/insert`;
                    // /board2/1/insert
});
