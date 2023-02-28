import "./App.css";
import { Header, Landing, Footer } from "./components";

function App() {
  return (
    <div className="w-screen m-auto flex flex-col">
      <Header />
      <Landing />
      <Footer />
    </div>
  );
}

export default App;
