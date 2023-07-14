import './App.css';
// component 폴더의 Exam.js를 가져와서 사용
// 사용할 때 이름을 Ex1으로 저장
// import Ex1 from './components/Exam1';
// import Ex2 from './components/Exam2';
// import PropsEx from './components/R01_props';
import State1 from './components/R02_state1';
import State2 from './components/R03_state2';
import State3 from './components/R04_state3';
import Todolist1 from './components/R05_todolist1';
import ContextApi from './components/R06_context_api';

function App() {
  
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다
  // 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어준다 
  return (
    <>
      <h2>신기한데
        반응도 빨라서 
        <br></br>
        너무 좋구여 
      </h2>

      <h1>hello React</h1>
      <div>와 리액트다</div>
      {/* <Ex1 />
      <Ex2 /> */}
      {/* <PropsEx name={'홍길동'} /> */}
      {/* <PropsEx name={'김길동'} /> */}

      {/* <State1 />
      <State2 init={100}/>
      <hr/>
      <State3></State3> */}
    {/* <Todolist1/> */}

      <ContextApi/>

    </>
    
    
  );
}

export default App;

