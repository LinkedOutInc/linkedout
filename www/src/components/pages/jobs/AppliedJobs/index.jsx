import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";

const AppliedJobs = () => {
  const [jobs, setJobs] = useState([]);
  const [selectedJob, setSelectedJob] = useState(null);

  // Fetch jobs data from an API or any other data source
  useEffect(() => {
    const fetchJobs = async () => {
      const newJobs = [
        {
          id: 2,
          title: "Product Manager",
          company: "XYZ Inc",
          location: "San Francisco, CA",
          description: "This is a Product Manager job description.",
        },
        {
          id: 3,
          title: "Data Scientist",
          company: "Data Co",
          location: "Seattle, WA",
          description: "This is a Data Scientist job description.",
        },
      ];
      setJobs(newJobs);
    };

    fetchJobs();
  }, []);

  const handleSearch = (searchTerm) => {
    // Implement search logic here
    console.log("Searching for:", searchTerm);
  };

  const handleFilter = (filter) => {
    // Implement filter logic here
    console.log("Filtering by:", filter);
  };

  return (
    <div className="max-w-screen-lg w-screen mx-auto px-2">
      <div className="mt-4 shadow rounded-2xl shadow-linkedout p-4">
        <div className="grid grid-cols-2 gap-6">
          <div className="space-y-6">
            {jobs.map((job) => (
              <JobItem
                key={job.id}
                job={job}
                isSelected={selectedJob && selectedJob.id === job.id}
                onSelect={setSelectedJob}
              />
            ))}
          </div>
          <JobDescription job={selectedJob} />
        </div>
      </div>
    </div>
  );
};

export default AppliedJobs;
