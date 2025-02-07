import { useParams, Navigate } from "react-router-dom";

const Profile = () => {
    const params = useParams();
    console.log(params);

    const isLogin = false;
    if (!isLogin) {
        return <Navigate to="/login" />;
    }
    
    return (
        <>
            <div>
                프로필
            </div>
            <div>아이디 : {params.id}</div>
        </>
    );
};

export default Profile;