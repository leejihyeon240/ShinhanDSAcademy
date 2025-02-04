import './App.css';
import Header from './component/Header';
import Form from './component/Form';
import PlusMinus from './component/PlusMinus';
import Footer from './component/Footer';

function ChildComp() {
    return <div>child component</div>;
}

function App() {
    // const name = '홍길동';
    // const age = 20;
    const BodyProps = {
        name: '홍길동',
        age: 20,
        favorList: ['파스타', '빵', '떡볶이'],
    };
    return (
        <div className="App">
            <Header />
            <Form />
            <PlusMinus />
            <Footer />
        </div>
    );
}

export default App;
