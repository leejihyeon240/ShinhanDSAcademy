import './App.css';
import Viewer from './component/Viewer';
import Controller from './component/Controller';
import Even from './component/Even';
import { useEffect, useState, useRef } from 'react';

function App() {
  const [count, setCount] = useState(0); // state 선언 -> Viewer로 전달
  const [text, setText] = useState('');
  const didMountRef = useRef(false);

  const handleSetCount = (value) => { // 함수 -> Controller로 전달
    setCount(count + value);
  };

  const handleChangeText = (e) => {
    setText(e.target.value);
  };

  useEffect(() => {
    if (!didMountRef.current) {
      didMountRef.current = true;
      return;
    } else {
    console.log("컴포넌트 업데이트!");
    }
  }, []);

  useEffect(() => {
    console.log("컴포넌트 마운트");
  }, []);

  useEffect(() => {
    setInterval(() => {
      console.log("깜빡");
    }, 1000);
  });

  return <div className="App">
    <h1>Simple Counter</h1>
    <section>
      <input value={text} onChange={handleChangeText} />
    </section>
    <section>
      <Viewer count = {count} />
      {count % 2 === 0 && <Even />}
    </section>
    <section>
      <Controller handleSetCount = {handleSetCount} />
    </section>
  </div>;
}

export default App;
