import './Body.css';
import Test from './Test';
import { useState } from 'react';

// p = {name:'홍길동', age:20}
const Body = ({ name, age, favorList, children }) => {
    let [count, setCount] = useState(0);
    //const { name, age } = p;
    console.log('렌더링');
    const number = 0;
    const element = <h1>안녕하세요</h1>;
    //const s = { backgroundColor: 'red', color: 'blue' };
    // 이벤트 핸들러
    function handleOnClick(e) {
        console.log(e);
        console.log(e.target.name);
    }
    const onIncrease = () => {
        setCount(count + 1);
        //count += 1;
    };
    return (
        <>
            <div className="body">
                <h2>
                    {count} <button onClick={onIncrease}>+</button>
                </h2>
                <h1>
                    이름:{name} 나이:{age} <br />
                    {favorList.length}개의 음식을 좋아합니다.
                </h1>
                <h2>{number % 2 == 0 ? '짝수' : '홀수'}</h2>
                {
                    // 주석
                    /*
                  d
                  d
                  d
                  */
                }
            </div>
            <div>안녕</div>
            <Test />
            {children}
            <button name="A버튼" onClick={handleOnClick}>
                A 버튼
            </button>
            <button name="B버튼" onClick={handleOnClick}>
                B 버튼
            </button>
        </>
    );
};
Body.defaultProps = {
    favorList: [],
};
export default Body;
