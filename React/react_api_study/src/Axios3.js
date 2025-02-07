import axios from "axios";
import { useState } from "react";

const Axios3 = () => {

    const [data, setData] = useState({
        email: "",
        pwd: "",
    });

    const onChangeHandler = (e) => {
        setData({
            ...data,
            [e.target.name]: e.target.value
        });
    };

    // 로그인 버튼 클릭하면 실행되는 함수수
    const submit = () => {
        axios.post('http://localhost:8090/api/member/login', data).then(res => {
            console.log(res);
            if (res.data.result === 'success') {
                window.sessionStorage.setItem('email', res.data.member.email);
            }
        });
    }

    return <>
        이메일: <input value={data.email} name="email" onChange={onChangeHandler} /> <br />
        비밀번호: <input type="password" value={data.pwd} name="pwd" onChange={onChangeHandler} /> <br />
        <button onClick={submit}>로그인</button><br />
        {window.sessionStorage.getItem("name") ? "님 안녕하세요" : "로그인을 해주세요"}
    </>
}

export default Axios3;