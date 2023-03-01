import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter as Router, useLocation } from "react-router-dom";
import { useLayoutEffect } from "react";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";

// Scroll to top on navigation wrapper
function Wrapper({ children }) {
  const location = useLocation();
  useLayoutEffect(() => {
    document.documentElement.scrollTo(0, 0);
  }, [location.pathname]);
  return children;
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <Router>
    <Wrapper>
      <App />
    </Wrapper>
  </Router>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
