import { useState } from 'react';

function Viewer() {
    console.log('Viewer 렌더링');
    return <div>고정값</div>;
}

function PlusMinus() {
    console.log('PlusMinus 렌더링');
    const [number, setNumber] = useState(0);
    const onIncrease = () => {
        setNumber(number + 1);
    };
    const onDecrease = () => {
        setNumber(number - 1);
    };
    return (
        <div>
            <h2>{number}</h2>
            <Viewer number={number} />
            <div>
                <button onClick={onDecrease}>-</button>
                <button onClick={onIncrease}>+</button>
            </div>
        </div>
    );
}
export default PlusMinus;
