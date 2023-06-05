import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const ProfileContext = React.createContext();

export const useProfile = () => {
  return React.useContext(ProfileContext);
};

const ProfileProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [experience, setExperience] = useState([]);
  const [education, setEducation] = useState([]);
  const [interests, setInterests] = useState([]);
  const navigate = useNavigate();

  // Education stuff
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

  const editEducation = async ({
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
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences/educations`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't edit education");
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

  const deleteEducation = async (exp_ID) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences/educations/${exp_ID}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete education");
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

  // Experience stuff
  const fetchExperience = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch experience");
          }
          return response.text();
        })
        .then((result) => {
          setExperience(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const addExperience = async ({
    title,
    description,
    start_date,
    end_date,
    companyName,
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
          type: "EXPERIENCE",
          start_date: start_date,
          end_date: end_date,
        },
        companyName: companyName,
      });

      console.log(raw);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't add experience");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchExperience();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const editExperience = async ({
    title,
    description,
    start_date,
    end_date,
    companyName,
  }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var raw = JSON.stringify({
        experience: {
          exp_ID: -1, // DOES MATTER
          user_ID: -1, // Doesn't matter
          title: title,
          description: description,
          type: "EXPERIENCE",
          start_date: start_date,
          end_date: end_date,
        },
        companyName: companyName,
      });

      console.log(raw);

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't edit experience");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchExperience();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const deleteExperience = async (exp_ID) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/experiences/${exp_ID}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete experience");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchExperience();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  // Interests stuff
  const fetchInterests = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/profile/interests`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch interests");
          }
          return response.text();
        })
        .then((result) => {
          setInterests(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const addInterest = async ({ title, area }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var raw = JSON.stringify({
        title: title,
        area: area,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/profile/interests/add`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't add interest");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchInterests();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const editInterest = async ({ title, area }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var raw = JSON.stringify({
        title: title,
        area: area,
      });

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/profile/interests/edit`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't edit interest");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchInterests();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const deleteInterest = async (interest_ID) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/profile/interests/delete/${interest_ID}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete interest");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchInterests();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  // Fetch all data
  useEffect(() => {
    fetchEducation();
    fetchExperience();
  }, [token]);

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
    editEducation,
    deleteEducation,
    fetchExperience,
    addExperience,
    editExperience,
    deleteExperience,
    fetchInterests,
    addInterest,
    editInterest,
    deleteInterest,
  };

  return (
    <ProfileContext.Provider value={value}>{children}</ProfileContext.Provider>
  );
};

export { ProfileProvider };
