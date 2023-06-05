import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const JobContext = React.createContext();

export const useJob = () => {
  return React.useContext(JobContext);
};

const JobProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [loading, setLoading] = useState(false);
  const [jobs, setJobs] = useState([]);
  const [appliedJobs, setAppliedJobs] = useState([]);
  const [applicantList, setApplicantList] = useState([]);
  const navigate = useNavigate();

  // Job stuff
  const fetchJobs = async () => {
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

      fetch(`${API}/api/v1/jobposts`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch jobs");
          }
          return response.text();
        })
        .then((result) => {
          setJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const fetchAppliedJobs = async () => {
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

      fetch(`${API}/api/v1/jobposts/applied/${user.id}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch jobs");
          }
          return response.text();
        })
        .then((result) => {
          setAppliedJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const applyJob = async (jobId) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobs/${jobId}/apply`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't apply to job");
          }
          return response.text();
        })
        .then((result) => {
          setAppliedJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const createJob = async (job) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify(job);

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/jobs`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't create job");
          }
          return response.text();
        })
        .then((result) => {
          setJobs(() => JSON.parse(result));
          setLoading((loading) => !loading);
          navigate("/jobs");
        })
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
          setJobs(() => JSON.parse(result));
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
          setJobs(() => JSON.parse(result));
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
          setApplicantList(() => JSON.parse(result));
          setLoading((loading) => !loading);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchJobs();
    fetchAppliedJobs();
  }, [token]);

  const value = {
    jobs,
    loading,
    fetchJobs,
    fetchAppliedJobs,
    applyJob,
    createJob,
    deleteJob,
    updateJob,
    applicantList,
    fetchApplicants,
    appliedJobs,
  };

  return <JobContext.Provider value={value}>{children}</JobContext.Provider>;
};

export { JobProvider };
