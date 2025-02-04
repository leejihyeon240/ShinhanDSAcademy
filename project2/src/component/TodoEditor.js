import "./TodoEditor.css";
import { useState, useRef } from "react";

// props
// {} 쓰면 : 구조분해할당 --> 매개 변수명과 객체의 속성명이 일치하는 값 대입
// 안 쓰면 : 객체 --> onCreate = {onCreate:함수}

const TodoEditor = ({ onCreate }) => {
    const inputRef = useRef();
    const [content, setContent] = useState('');
    const onChangeContent = (e) => {
        setContent(e.target.value);
    };

    const submit = () => {
        if (!content) { // 입력하지 않으면
            inputRef.current.focus();
            return;
        }
        onCreate(content); // 항목 추가가
        setContent(""); // content state에 '' 대입 => input 값 초기화화
    };

    const onKeyDown = (e) => {
        if (e.keyCode === 13) {
            submit();
        }
    };

    return (
        <div className="TodoEditor">
            <h4>새로운 Todo 작성하기✏️</h4>
            <div className="editor_wrapper">
                <input ref={inputRef} placeholder="새로운 Todo..." value={content} onChange={onChangeContent}
                    onKeyDown={onKeyDown} />
                <button onClick={submit}
                >
                    추가
                </button>
            </div>
        </div>
    );
};

export default TodoEditor;