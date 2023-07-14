import React ,{useState} from "react";

const InputPrint = () => {
    const [inputValue, setInputValue] = useState('');

    const change = (e) => {
    setInputValue(e.target.value);
    };

    const send = () => {
    const h2 = document.querySelector('.result');
    h2.innerText = inputValue;
    };

    return (
        <>
        <input type="text" onChange={change} />
        <button onClick={send}>보내기</button>
        
        <div className="resultBox">
        <div className="result">
        <h2></h2>
        </div>
        </div>
        </>
    );
};

export default InputPrint;