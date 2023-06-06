import React from "react";
import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

const AuthContext = React.createContext();

export const useAuth = () => {
  return React.useContext(AuthContext);
};

const AuthProvider = ({ children }) => {
  const [user, setUser] = React.useState(null); // null: loading, undefined: not logged in
  const [loading, setLoading] = React.useState(false);
  const [role, setRole] = React.useState(undefined);
  const [token, setToken] = React.useState(() => {
    const token = localStorage.getItem("auth");
    console.log(token);
    return token ? token : undefined;
  });

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
        setToken(() => result);
        fetchUser().then(() => {
          if (user?.role === "ROLE_ADMIN") {
            navigate("/admin");
          } else {
            navigate("/feed");
          }
        });
        setLoading((loading) => !loading);
      })
      .catch((error) => {
        console.log("error", error);
        setLoading((loading) => !loading);
      });
  };

  const logout = () => {
    setLoading((loading) => true);
    localStorage.removeItem("auth");
    setToken(() => null);
    setUser(() => null);
    setLoading((loading) => false);
    navigate("/");
  };

  const signup = async (form) => {
    if (loading)
      return console.log("Already loading, please wait for a few seconds");
    setLoading((loading) => true);
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = JSON.stringify(form);

    console.log(raw);

    var requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: raw,
      redirect: "follow",
    };

    console.log(requestOptions);

    fetch(API + "/api/v1/auth/register", requestOptions)
      .then((response) => {
        if (!response.ok) {
          console.log(response);
          throw new Error("Register failed");
        } else {
          return response.text();
        }
      })
      .then((result) => {
        console.log(result);
        localStorage.setItem("auth", result);
        setToken(() => result);
        navigate("/feed");
      })
      .catch((error) => {
        console.log("error", error);
      });

    setLoading((loading) => false);
  };

  const fetchUser = async () => {
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    myHeaders.append("Authorization", "Bearer " + token);

    var requestOptions = {
      method: "GET",
      headers: myHeaders,
      redirect: "follow",
    };

    fetch(API + "/profile", requestOptions)
      .then((response) => {
        if (!response.ok) {
          throw new Error("Authentication failed");
        } else {
          return response.text();
        }
      })
      .then((result) => {
        const curUser = JSON.parse(result);
        setUser(() => curUser);
        console.log(curUser);
      })
      .catch((error) => {
        console.log("error", error);
      });
  };

  React.useEffect(() => {
    if (token && token.length > 0 && user === null) {
      fetchUser();
    }
  }, [token, user]);

  const value = { user, login, logout, signup, loading, token, fetchUser };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export { AuthProvider };
