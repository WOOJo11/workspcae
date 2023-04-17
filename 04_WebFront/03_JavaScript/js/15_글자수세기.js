
document.getElementById("content").addEventListener("input",()=>{
    const contentLength = document.getElementById("content").value.length;
    document.getElementById("count").innerText = contentLength;

    if(contentLength > 100) {
    
        document.getElementById("count").classList.add("error");


    }else
    document.getElementById("count").classList.remove("error");


    // 요소.classList.toggle("클래스명")
    // - 요소에 클래스가 없으면 추가 (true 반환)
    // - 요소에 클래스가 있으면 제거 (false 반환)


})

