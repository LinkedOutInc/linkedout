import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const ConnectionContext = React.createContext();

export const useConnection = () => {
  return React.useContext(ConnectionContext);
};

const ConnectionProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [connections, setConnections] = useState([]);
  const [connectionSuggestions, setConnectionSuggestions] = useState([]);
  const [suggestionOffset, setSuggestionOffset] = useState(0);
  const [connectionRequests, setConnectionRequests] = useState([]);
  const navigate = useNavigate();

  // Connection stuff
  const fetchConnections = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/network?offset=0`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch connections");
          }
          return response.text();
        })
        .then((result) => {
          setConnections(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const fetchConnectionSuggestions = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(
        `${API}/api/v1/connections/suggestions-alternative?offset=0`,
        requestOptions
      )
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch connection suggestions");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          setConnectionSuggestions(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const fetchConnectionRequests = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/requests?offset=0`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch connection requests");
          }
          return response.text();
        })
        .then((result) => {
          setConnectionRequests(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const addConnection = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/${id}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't add connection");
          }
          return response.text();
        })
        .then((result) => {
          setLoading((loading) => !loading);
          fetchConnectionSuggestions();
          fetchConnectionRequests();
          fetchConnections();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const acceptConnection = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/${id}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't accept connection");
          }
          return response.text();
        })
        .then((result) => {
          setLoading((loading) => !loading);
          fetchConnectionSuggestions();
          fetchConnectionRequests();
          fetchConnections();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const deleteConnection = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/${id}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete connection");
          }
          return response.text();
        })
        .then((result) => {
          setLoading((loading) => !loading);
          fetchConnectionSuggestions();
          fetchConnectionRequests();
          fetchConnections();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const declineConnection = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/connections/${id}/decline`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    if (user) {
      fetchConnections();
      fetchConnectionSuggestions();
      fetchConnectionRequests();
    }
  }, [user]);

  const value = {
    loading,
    connections,
    connectionSuggestions,
    connectionRequests,
    addConnection,
    acceptConnection,
    deleteConnection,
    declineConnection,
  };

  return (
    <ConnectionContext.Provider value={value}>
      {children}
    </ConnectionContext.Provider>
  );
};

export { ConnectionProvider };
