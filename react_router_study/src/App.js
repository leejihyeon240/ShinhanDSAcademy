import Intro from "./Intro";
import Main from "./Main";
import Profile from "./Profile";
import Profile2 from "./Profile2";
import Layout from "./Layout";
import NotFound from "./NotFound";
import Login from "./Login";

import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route element={<Layout />} >
          <Route path='/' element={<Main />} />
          <Route path='/intro' element={<Intro />} />
          <Route path='/profile/:id' element={<Profile />} />
          <Route path='/profile2' element={<Profile2 />} />
          <Route path='/login' element={<Login />} />

        </Route>

        {/* 맨 밑에 작성, 존재하지 않는 경로 페이지 */}
        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  );
}

export default App;
