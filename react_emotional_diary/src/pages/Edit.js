import { useParams } from "react-router-dom";

const Edit = () => {
    const params = useParams();
    console.log(params);
    
    return <div>Edit 페이지입니다</div>;
};

export default Edit;