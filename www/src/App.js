import "./App.css";
import { Route, Routes } from "react-router-dom";
import { Header, Landing, Footer, Login } from "./components";

function App() {
  return (
    <div id="app_container" className="m-0 min-h-screen flex flex-col">
      <Header />
      <div
        id="app_content"
        className="mx-auto my-0 flex flex-1 flex-col float-none justify-center"
      >
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
      <Footer />
    </div>
  );
}

export default App;
