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
        setUser({
          ...curUser,
          image:
            "https://media.licdn.com/dms/image/D4E03AQGlM3HJ4eX9oA/profile-displayphoto-shrink_800_800/0/1667050655479?e=1691625600&v=beta&t=n048tKit2SdDB5cuikTf6H6L8-o_q6Tk3RF-34vDj_o",
        });
        if (curUser.role === "ROLE_ADMIN") {
          navigate("/admin");
        } else {
          navigate("/feed");
        }
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

  const value = { user, login, logout, signup, loading, token };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export { AuthProvider };
