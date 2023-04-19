import React from "react";
import Authenticated from "./Authenticated";
import Guest from "./Guest";

function Header() {
  return localStorage.getItem("auth") == 1 ? <Authenticated /> : <Guest />;
}

export default Header;
