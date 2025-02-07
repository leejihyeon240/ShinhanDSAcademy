import React from 'react';

// 클래스 컴포넌트

class Test extends React.Component {
    render() {
        const s = { backgroundColor: 'red' };
        return (
            <>
                <div style={s}>테스트</div>
            </>
        );
    }
}
export default Test;
