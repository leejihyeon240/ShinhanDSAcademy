import "./TodoEditor.css";
import { useState } from "react";

// props
// {} 쓰면 : 구조분해할당 --> 매개 변수명과 객체의 속성명이 일치하는 값 대입
// 안 쓰면 : 객체 --> onCreate = {onCreate:함수}

const TodoEditor = ({onCreate}) => {
    const [content, setContent] = useState('');
    const onChangeContent = (e) => {
        setContent(e.target.value);
    };

    return ( 
    <div className="TodoEditor">
        <h4>새로운 Todo 작성하기✏️</h4>
        <div className="editor_wrapper">
            <input placeholder="새로운 Todo..." value={content} onChange={onChangeContent}/>
            <button onClick={() => onCreate(content)}>추가</button>
        </div>
    </div>
    );
};

export default TodoEditor;