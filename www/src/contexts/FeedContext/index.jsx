import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const Feedontext = React.createContext();

export const useJob = () => {
  return React.useContext(Feedontext);
};

const JobProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  value = {
    jobs,
    loading,
  };

  return <Feedontext.Provider value={value}>{children}</Feedontext.Provider>;
};

export { JobProvider };
