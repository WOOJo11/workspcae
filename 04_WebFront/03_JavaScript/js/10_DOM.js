// Node 확인하기

document.getElementById("btn1").addEventListener("click", ()=>{

    // #test의 모든 자식 노드를 얻어오기
    // - 요소.childNodes : 요소의 자식 노드를 모두 반환

    const list = document.getElementById("test").childNodes;

    console.log(list);
    

    // #li의 부모 노드 탐색 : parentNode
    const li1 = document.getElementById("li1");
    console.log(li1.parentNode);

    li1.parentNode.style.backgroundColor = "tomato";

    // #li1의 부모 노드의 마지막 자식으로 새로운 노드 추가
    // append(노드) : 마지막 자식

    li1.parentElement.append("ABCD");

    // test의 첫번째 자식 노드 탐색 : firstChild
    console.log(document.getElementById("test").firstChild);

    // test의 자미가 자식 노드 탐색 : lastChild
    console.log(document.getElementById("test").lastChild)

    // 중간에 존재하는 자식 노드 탐색 : childNodes[인덱스]
    // -> 위에 #test의 자식노드를 저장한 list가 존재함 
    console.log(list[11]);
    list[11].append("9876");

    // 이전 형제 노드 탐색 : previousSibling
    console.log(list[8].previousSibling);

    // 다음 형제 노드 탐색 : nextSibling

    console.log(list[8].nextSibling);

    // 탐색 구문은 연달아서 작성 가능
    console.log(list[11].firstChild.nextSibling);
})

// Elemnet 탐색 확인하기

document.getElementById("btn2").addEventListener("click",()=>{

    const test = document.getElementById("test");

    const list =test.children;
    console.log(list);

    // 첫 번째 자식 요소 : firstElementChild

    test.firstElementChild.style.backgroundColor = 'red';

    // 마지막 자식 요소 : lastElementChild

    test.lastElementChild.style.backgroundColor='green'

    // 2번 째 요소 선택: 요소[인덱스]
    list[1].style.backgroundColor="skyblue";

    // 이전 형제 요소 선택 : previousElemnetSibling
    // #test의 마지막 요소의 이전 형제요소
    // 클릭 시 alret()출력되는  이벤트 추가 

    test.lastElementChild.previousElementSibling.addEventListener("click",()=>{
        alert("하위");
    });

    // 다음 형제 요소 선택 : nextElemnetSibling
// #test의 마지막 요소의 이전 형제요소
    // 클릭 시 alret()가 출력되는 이벤트 추가 
    test.firstElementChild.nextElementSibling.addEventListener("click",()=>{
        alert("하위");
    });

})

// innerHTMl을 이용하여 요소 추가하기
const btn3 = document.getElementById("btn3");
const area1 = document.getElementById("area1");
let count1 = 1;


btn3.addEventListener("click",()=>{

        area1.innerHTML +=`<div>${count1}</div>`;
        count1++;

});


// createElement 이용하기
const btn4 = document.querySelector("#btn4");
const area2 = document.querySelector("#area2");
let count2 = 1;

btn4.addEventListener("click",()=>{

    // 1) div 요소 만들기 -> 아직 화면에 추가는 되지않음
    const child = document.createElement("div");

    // 2) #area2의 마지막 자식을 추가하기 

    area2.append(child);
    
    // 3) child에 내용 추가하기(count2)
    // -> child를 화면에 추가를 했다고 해서 해당 코드에서
    //    주적을 못하는 것이 아닌 child 변수를 이용해서 계속 접근 가능
    
    child.innerText= count2++;


});
