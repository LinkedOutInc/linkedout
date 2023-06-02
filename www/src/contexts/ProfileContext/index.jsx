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

  const fetchEducation = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences/educations`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch education");
          }
          return response.text();
        })
        .then((result) => {
          setEducation(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const addEducation = async ({
    title,
    description,
    start_date,
    end_date,
    institutionName,
  }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var raw = JSON.stringify({
        experience: {
          exp_ID: -1, // Doesn't matter
          user_ID: -1, // Doesn't matter
          title: title,
          description: description,
          type: "EDUCATION",
          start_date: start_date,
          end_date: end_date,
        },
        institutionName: institutionName,
      });

      console.log(raw);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences/educations`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't add education");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchEducation();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const value = {
    user,
    loading,
    experience,
    setExperience,
    education,
    setEducation,
    interests,
    setInterests,
    fetchEducation,
    addEducation,
  };

  return (
    <ProfileContext.Provider value={value}>{children}</ProfileContext.Provider>
  );
};

export { ProfileProvider };
