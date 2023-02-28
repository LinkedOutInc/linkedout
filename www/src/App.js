import "./App.css";
import { Header, Landing, Footer } from "./components";

function App() {
  return (
    <div id="app_container" className="m-0 min-h-screen flex flex-col">
      <Header />
      <div
        id="app_content"
        className="mx-auto my-0 flex flex-1 flex-col float-none justify-center"
      >
        <Landing />
      </div>
      <Footer />
    </div>
  );
}

export default App;
