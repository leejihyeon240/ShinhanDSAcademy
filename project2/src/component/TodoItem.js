import "./TodoItem.css"
import React from "react";

const TodoItem = ({ id, content, isDone, createDate, onUpdate, onDelete }) => {
    const onChangeCheckbox = () => {
        onUpdate(id);
    };

    const onClickDelete = () => {
        onDelete(id);
    };

    console.log(`${id} TodoItem update`);

    return (
        <>
            <div className="TodoItem">
                <div className="checkbox_col">
                    <input onChange={onChangeCheckbox} type="checkbox" checked={isDone} />
                </div>
                <div className="title_col">{content}</div>
                <div className="date_col">
                    {new Date(createDate).toLocaleDateString()}
                </div>
                <div className="btn_col">
                    <button onClick={onClickDelete}>삭제</button>
                </div>
            </div>
        </>
    );
    
};

export default React.memo(TodoItem);