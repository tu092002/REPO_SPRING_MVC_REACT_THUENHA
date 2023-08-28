import { Fragment, createContext } from "react";
import Header from "./layout/header";
import Footer from "./layout/footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';

import { Route, Routes, BrowserRouter } from "react-router-dom";
import MyPage from "./components/MyPage";
import Login from "./components/login";
import { useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";




export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);

  return (
    <MyUserContext.Provider value={[user, dispatch]}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/MyPage" element={<MyPage />} />
          <Route path="/login" element={<Login />} />


        </Routes>
        <Footer />

      </BrowserRouter>
    </MyUserContext.Provider>



  )
}

export default App;