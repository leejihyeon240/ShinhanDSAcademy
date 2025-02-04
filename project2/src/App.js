import './App.css';
import Header from './component/Header';
import TodoEditor from './component/TodoEditor';
import TodoList from './component/TodoList';
import { useRef, useReducer, useCallback } from 'react';
import TestComp from './component/TestComp';

const mockTodo = [
  {
    id: 0,
    isDone: false,
    content: "React 공부하기",
    createDate: new Date().getTime(),
  },
  {
    id: 1,
    isDone: false,
    content: "빨래 널기기",
    createDate: new Date().getTime(),
  },
  {
    id: 2,
    isDone: false,
    content: "노래 연습하하기",
    createDate: new Date().getTime(),
  },
];

function reducer(state, action) {
  switch (action.type) {
    case "CREATE": {
      return [action.newItem, ...state]; // 새로운 객체가 앞에 들어오는 형태로 배열을 다시 만들어서 return
    }
    case "UPDATE": {
      return state.map((it) =>
        it.id === action.targetId
          ? {
            ...it,
            isDone: !it.isDone, // true는 false, false는 true
          }
          : it
      );
    }
    case "DELETE": {
      return state.filter((it) => it.id !== action.targetId); 
    }
    default:
      return state;
  }
}

function App() {
  const idRef = useRef(3);

  const [todo, dispatch] = useReducer(reducer, mockTodo);

  const onCreate = (content) => {
    dispatch({
      type: "CREATE",
      newItem: {
        id: idRef.current,
        content,
        isDone: false,
        createDate: new Date().getTime(),
      },
    });
    idRef.current += 1;
  };

  const onUpdate = useCallback((targetId) => {
    dispatch({
      type: "UPDATE",
      targetId,
    });
  }, []);

  const onDelete = useCallback((targetId) => {
    dispatch({
      type: "DELETE",
      targetId,
    });
  }, []);

  return (
    <div className="App">
      <TestComp />
      <Header />
      <TodoEditor onCreate={onCreate} />
      <TodoList todo={todo} onUpdate={onUpdate} onDelete={onDelete} />
    </div>
  );
}

export default App;
