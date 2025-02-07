import { useLocation, useSearchParams } from "react-router-dom";

const Profile2 = () => {
    const params = useLocation();
    console.log(params);

    // 자바스크립트 내장함수 사용
    const param = new URLSearchParams(params.search);
    console.log("a: ", param.get("a"));
    console.log("b: ", param.get("b"));

    // 리액트훅 사용
    const [parameter] = useSearchParams();
    console.log("a: ", parameter.get("a"));
    console.log("b: ", parameter.get("b"));

    return (
        <>
            <div>
                프로필
            </div>
            <div>쿼리스트링 : {params.search}</div>
        </>
    );
};

export default Profile2;