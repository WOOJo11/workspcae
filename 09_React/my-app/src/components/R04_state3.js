import React,{useState} from "react";

const Id = ({handler}) => {
   
    console.log(handler);

    return(
        <>
            <div className="wrapper">
                <label htmlFor="id">ID : </label>
                <input type="text" id="id" onChange={handler} />
            </div>
        </>


    );


};
const Pw = ({handler}) => {

    return(
        <>
            <div className="wrapper">
                <label htmlFor="pw">PW : </label>
                <input type="password" id="pw" onChange={handler} />
            </div>
        </>


    );


};
// 상태 끌어올리기
const StateLiftingUp = () =>{

    const [id,setId] = useState('');
    const [pw,setPw] = useState('');

    console.log("id : " + id);
    console.log("pw : " + pw);
    
    const idHandler = (e) => {
        setId(e.target.value);
    }
    const pwHandler = (e) => {
        setPw(e.target.value);
    }

    return(
        <>
            <Id handler={idHandler}/>
            <Pw handler={pwHandler}/>
            <div className="wrapper">
                <button disabled={id.length ===0 ||pw.length ===0}>Login</button>
            </div>
        </>


    );
}


export default StateLiftingUp;