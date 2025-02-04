import { useState } from 'react';

export default () => {
    const [state, setState] = useState({
        name: '',
        gender: '',
        birth: '',
        bio: '',
    });
    const handleOnChange = (e) => {
        setState({
            ...state,
            [e.target.name]: e.target.value,
        });
        // setState({
        //     name: '',
        //     gender: '',
        //     birth: '',
        //     bio: '',
        //     ['name']: '홍길동',
        // });
        //state['name'] = '홍길동';
    };
    const onSubmit = () => {
        console.log(state);
    };
    return (
        <>
            <div>
                <input
                    name="name"
                    value={state.name}
                    onChange={handleOnChange}
                    placeholder="이름"
                />
            </div>
            <div>
                <select
                    name="gender"
                    value={state.gender}
                    onChange={handleOnChange}
                >
                    <option key={1}></option>
                    <option key={2}>남성</option>
                    <option key={3}>여성</option>
                </select>
            </div>
            <div>
                <input
                    name="birth"
                    type="date"
                    value={state.birth}
                    onChange={handleOnChange}
                />
            </div>
            <div>
                <textarea
                    name="bio"
                    value={state.bio}
                    onChange={handleOnChange}
                />
            </div>
            <button onClick={onSubmit}>전송</button>
        </>
    );
};
