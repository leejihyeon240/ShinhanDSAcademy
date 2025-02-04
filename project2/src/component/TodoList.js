import TodoItem from "./TodoItem";
import "./TodoList.css";
import { useState, useMemo } from "react";

const TodoList = ({ todo, onUpdate, onDelete }) => {
    const analyzeTodo = useMemo(() => {
        console.log('analyzeTodo 함수 호출');

        const totalCount = todo.length;
        const doneCount = todo.filter((it) => it.isDone).length;
        const notDoneCount = totalCount - doneCount;
        return { totalCount, doneCount, notDoneCount};
    }, [todo]);

    // 총 개수, 완료한 개수, 완료하지 못 한 개수
    const {totalCount, doneCount, notDoneCount} = analyzeTodo;

    const [search, serSerch] = useState('');
    const onChangeSearch = (e) => {
        serSerch(e.target.value);
    };

    const getSearchResult = () => {
        return search === ""
            ? todo
            : todo.filter(it => it.content.toLowerCase().includes(search.toLowerCase())
            );
    };

    return (
        <div className="TodoList">
            <h4>Todo List🌱</h4>
            <div>총 개수: {totalCount}</div>
            <div>완료된 할 일: {doneCount}</div>
            <div>아직 완료되지 못한 할 일: {notDoneCount}</div>

            <input
                className="searchbar"
                placeholder="검색어를 입력하세요"
                value={search}
                onChange={onChangeSearch}
            />
            <div className="list_wrapper">
                {getSearchResult().map((a) => (
                    // <div key={a.id}>{a.content}</div>
                    <TodoItem key={a.id} {...a} onUpdate={onUpdate} onDelete={onDelete} />
                ))}
            </div>
        </div>
    );
};

export default TodoList;