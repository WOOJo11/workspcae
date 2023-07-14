import logo from './logo.svg';
import './App.css';
import { createContext, useState } from 'react';
import SignupContainer from './Signup';
import Login from './Login';
import TodoList from './TodoList';

export const TodoListContext = createContext(); // 전역변수 생성

function App() {
    const [signupView,setSignupView] = useState(false);

    // 로그인한 회원 정보 저장
    const [loginMember,setLoginMember] = useState(null);

    // 로그인한 회원의 todo-List 저장
    const [todoList,setTodoList] = useState([]); 

  return (
    <TodoListContext.Provider value={{setTodoList,setLoginMember,loginMember,todoList}}>

      <button onClick={() => {setSignupView(!signupView)}}>
        {signupView ? ('회원 가입 닫기'):('회원 가입 열기')}
      </button>
    
      <div className='signup-wrapper'>
        {/* signupView가 true인 경우에만 회원 가입 컴포넌트 렌더딩 */}
        {/* 조건식 && true인 경우 */}
        {signupView === true && (<SignupContainer/>) }
    
      </div>
      <h1>Todo list</h1>
      <Login/>
      <hr/>
      
      {/* 로그인이 되어 있을 떄만 Todo-List 출력  */}
      {loginMember && (<TodoList/>)}

    </TodoListContext.Provider>
  );
}

export default App;
