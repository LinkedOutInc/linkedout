import "./App.css";
import { Route, Routes } from "react-router-dom";
import {
  Header,
  Landing,
  Footer,
  Login,
  Signup,
  CompleteSignup,
  CreateProfile,
} from "./components";

function App() {
  return (
    <div id="app_container" className="m-0 min-h-screen flex flex-col">
      <Header />
      <div id="app_content" className="my-0 flex flex-1 flex-col float-none">
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/signup/complete" element={<CompleteSignup />} />
          <Route path="/signup/createprofile" element={<CreateProfile />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
}

export default App;
