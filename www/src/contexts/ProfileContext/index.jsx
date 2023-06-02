import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const ProfileContext = React.createContext();

export const useProfile = () => {
  return React.useContext(ProfileContext);
};

const ProfileProvider = ({ children }) => {
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [experience, setExperience] = useState([]);
  const [education, setEducation] = useState([]);
  const [interests, setInterests] = useState([]);

  const navigate = useNavigate();

  const API = process.env.REACT_APP_API_URL;

  // useEffect(() => {
  //     if (user && token) {
  //         setLoading(true);
  //         var myHeaders = new Headers();
  //         myHeaders.append("Authorization", "Bearer " + token);

  //         var requestOptions = {
  //             method: "GET",
  //             headers: myHeaders,
  //             redirect: "follow",
  //         };

  const value = {
    user,
    loading,
    experience,
    setExperience,
    education,
    setEducation,
    interests,
    setInterests,
  };

  return (
    <ProfileContext.Provider value={value}>{children}</ProfileContext.Provider>
  );
};

export { ProfileProvider };
