import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const AdminContext = React.createContext();

export const useAdmin = () => {
  return React.useContext(AdminContext);
};

const AdminProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [roleCountReport, setRoleCountReport] = useState({});
  const [hiringReport, setHiringReport] = useState({});
  const [stats, setStats] = useState(null);
  const navigate = useNavigate();

  const generateRoleCountReport = async () => {
    setLoading(true);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/admin/generateRoleCountReport`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          setRoleCountReport(() => JSON.parse(result));
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  const generateHiringReport = async () => {
    setLoading(true);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/admin/generateHiringReport`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          setHiringReport(() => JSON.parse(result));
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  const fetchStats = async () => {
    setLoading(true);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/admin/getCounts`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          setStats(() => JSON.parse(result));
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
    setLoading(false);
  };

  useEffect(() => {
    if (user && user.role === "ROLE_ADMIN") {
      fetchStats();
    }
  }, [token]);

  const value = {
    user,
    loading,
    hiringReport,
    roleCountReport,
    generateRoleCountReport,
    generateHiringReport,
    stats,
  };

  return (
    <AdminContext.Provider value={value}>{children}</AdminContext.Provider>
  );
};

export { AdminProvider };
