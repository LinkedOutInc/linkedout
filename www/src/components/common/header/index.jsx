import React from "react";
import Authenticated from "./Authenticated";
import Guest from "./Guest";
import { useAuth } from "../../../contexts/AuthContext";

function Header() {
  const { user } = useAuth();
  return user ? <Authenticated /> : <Guest />;
}

export default Header;
