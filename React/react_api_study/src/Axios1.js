import { useState } from "react";
import axios from "axios";

const Axios1 = () => {
    const [data, setData] = useState(null);

    const getData = () => {
        axios.get('https://jsonplaceholder.typicode.com/posts').then(res => {
            console.log(res);
            setData(res.data);
        });
    };

    return (
        <>
            <button onClick={getData}>데이터 가져오기</button>
            <div><ul>{data && data.map((e, i) => <li>{e.title}</li>)}</ul></div>
        </>
    );
};

export default Axios1;