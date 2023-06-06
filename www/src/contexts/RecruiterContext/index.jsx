import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const RecruiterContext = React.createContext();

export const useRecruiter = () => {
  return React.useContext(RecruiterContext);
};

const RecruiterProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [myJobs, setMyJobs] = useState([]);
  const navigate = useNavigate();

  const fetchMyJobs = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobposts/getMine`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch jobs");
          }
          return response.text();
        })
        .then((result) => {
          setMyJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const addJob = async ({
    date,
    content,
    job_title,
    company_ID,
    workplace,
    position,
    profession,
  }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Authorization", `Bearer ${token}`);

      var raw = JSON.stringify({
        post_ID: 2,
        date: date,
        content: content,
        job_title: job_title,
        company_ID: company_ID,
        workplace: workplace,
        position: position,
        profession: profession,
      });

      console.log("ADD JOB: ", raw);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobposts`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const deleteJob = async (jobId) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobs/${jobId}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete job");
          }
          return response.text();
        })
        .then((result) => {
          setMyJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
          navigate("/jobs");
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const updateJob = async (jobId, job) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify(job);

      var requestOptions = {
        method: "PUT",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobs/${jobId}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't update job");
          }
          return response.text();
        })
        .then((result) => {
          setMyJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
          navigate("/jobs");
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  // Applicant stuff
  const fetchApplicants = async (jobId) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobs/applicants${jobId}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch applicants");
          }
          return response.text();
        })
        .then((result) => {
          const res = JSON.parse(result);
          setLoading((loading) => !loading);
          return res;
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {}, [token]);

  const value = {
    myJobs,
    loading,
    addJob,
    fetchMyJobs,
    deleteJob,
    updateJob,
    fetchApplicants,
  };

  return (
    <RecruiterContext.Provider value={value}>
      {children}
    </RecruiterContext.Provider>
  );
};

export { RecruiterProvider };
