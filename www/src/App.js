import "./App.css";
import { Route, Routes } from "react-router-dom";
import { Header, Landing, Footer } from "./components";

function App() {
  return (
    <div className="w-screen m-auto flex flex-col">
      <Header />
      <Routes>
        <Route path="/" element={<Landing />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
