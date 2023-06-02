import React from "react";
import { useNavigate } from "react-router-dom";

const AuthContext = React.createContext();

export const useAuth = () => {
  return React.useContext(AuthContext);
};

const AuthProvider = ({ children }) => {
  const [user, setUser] = React.useState(null); // null: loading, undefined: not logged in
  const [loading, setLoading] = React.useState(false);
  const [role, setRole] = React.useState(undefined);
  const navigate = useNavigate();
  const API = process.env.REACT_APP_API_URL;

  const login = (email, password) => {
    if (loading)
      return console.log("Already loading, please wait for a few seconds");
    setLoading((loading) => !loading);
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify({
      email: email,
      password: password,
    });

    var requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: raw,
      redirect: "follow",
    };

    fetch(API + "/api/v1/auth/authenticate", requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Authentication failed");
        } else {
          return response.text();
        }
      })
      .then((result) => {
        console.log(result);
        localStorage.setItem("auth", result);
        setUser(result);
        setLoading((loading) => !loading);
        navigate("/feed");
      })
      .catch((error) => {
        console.log("error", error);
        setLoading((loading) => !loading);
      });
  };

  const logout = async () => {
    localStorage.removeItem("auth");
    setUser(() => undefined);
    navigate("/");
  };

  const signup = async (form) => {
    if (loading)
      return console.log("Already loading, please wait for a few seconds");
    setLoading((loading) => !loading);
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify(form);

    var requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: raw,
      redirect: "follow",
    };

    fetch(API + "/api/v1/auth/register", requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Register failed");
        } else {
          return response.text();
        }
      })
      .then((result) => {
        console.log(result);
        localStorage.setItem("auth", result);
        setUser(result);
        setLoading((loading) => !loading);
        navigate("/feed");
      })
      .catch((error) => {
        console.log("error", error);
        setLoading((loading) => !loading);
      });
  };

  const value = { user, login, logout, signup, loading };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export { AuthProvider };
