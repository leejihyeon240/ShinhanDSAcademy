import { Link, useNavigate } from "react-router-dom";

const Main = () => {
    const navigate = useNavigate();

    const move = () => {
        // 처리...
        navigate('/intro');
    };

    return (
        <>
            <div>
                <h1>
                    Main
                </h1>
                <a href="/intro">소개</a>
                <Link to="/intro">소개</Link>
                <br />
                <Link to="/profile/hong">홍길동</Link>
                <Link to="/profile/lee">이순신</Link>
                <h4>쿼리스트링 방식</h4>
                <Link to="/profile2?a=1&b=2">쿼리스트링</Link>
                <h4>이벤트 처리 후 이동</h4>
                <button onClick={move}>페이지 이동</button>
            </div>
        </>
    );
};

export default Main;