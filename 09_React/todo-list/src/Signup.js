import React , {useState} from "react";

const SignupContainer = () =>{

    const [id,setId] = useState('');
    const [pw,setPw] = useState('');
    const [pwCheck,setPwCheck] = useState('');
    const [name,setName] = useState('');
    const [result,setResult] = useState('');

    const [idValidation,setIdValidation] = useState(false);
    // false -> 사용 불가
    // true -> 사용 가능



    // 아이디 중복 검사
    const idCheck = (inputId) => {
        // inputId 입력한 아이디
        setId(inputId)

        // 4글자 미만 검사 X
        if(inputId.trim().length < 4){
            setIdValidation(false);
            return;
        }

        fetch("/idCheck?id=" + inputId)
        .then(resp=>resp.text())
        .then(result => {
            console.log(`result : ${result}` );

            if(Number(result) === 0){ // 중복 X -> 사용 가능
                setIdValidation(true);
            }else{ // 중복 O -> 사용 불가능
                setIdValidation(false);
            }

        })
        .catch(e => console.log(e));
    
    }



    const signup = () => {

        if(!idValidation){
            alert('아이디를 다시 입력해주세요!');
            return;
        }

        if(pw !== pwCheck){
            alert('비밀번호가 일치하지 않습니다')
            return;
        }


        fetch("/signup",{
            method : "post",
            headers : {
                "Content-type" : "application/json"
            },
            body : JSON.stringify({
                id : id,
                pw : pw,
                name : name
            })
        })
        .then(resp=>resp.text())
        .then(result =>{
            if(result > 0){
                setResult("회원 가입 성공");
                setId("");
                setPw("");
                setPwCheck("");
                setName("");
                
            }else{
                setResult("회원 가입 실패..");
            }

        })
        .catch(e=>console.log(e));

    }


    return(
        <div className="signup-container">
            <label>
            ID : 
            <input type="text"
                onChange={e=>{
                    //setId(e.target.value)
                    idCheck(e.target.value)
                }}
                value={id}
                className={idValidation ? '' : 'id-error' }
                />
            </label>
            
            <label>
            PW : 
            <input type="password"
                onChange={e=>{setPw(e.target.value)}}
                value={pw}
                />
            </label>
            
            <label>
            PW Check : 
            <input type="password"
                onChange={e=>{setPwCheck(e.target.value)}}
                value={pwCheck}
                />
            </label>

            <label>
            Name : 
            <input type="text"
                onChange={e=>{setName(e.target.value)}}
                value={name}
                />
            </label>


            <button onClick={signup}>가입하기</button>
            <hr/>

            <h3>{result}</h3>

        </div>

    );

} 




export default SignupContainer;