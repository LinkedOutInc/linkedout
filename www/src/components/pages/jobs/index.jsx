import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";

const Jobs = () => {
  const [jobs, setJobs] = useState([]);
  const [selectedJob, setSelectedJob] = useState(null);

  // Fetch jobs data from an API or any other data source
  useEffect(() => {
    const fetchJobs = async () => {
      const newJobs = [
        {
          id: 1,
          title: "Software Engineer",
          company: "ABC Corp",
          location: "New York, NY",
          description: "This is a Software Engineer job description.",
        },
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

  return (
    <div className="p-4 max-w-screen-lg w-screen mx-auto shadow rounded-2xl shadow-linkedout">
      <div className="container mx-auto">
        <h2 className="text-2xl p-1 font-semibold mb-6">Jobs</h2>
        <div className="grid grid-cols-1 gap-6 md:grid-cols-2">
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

export default Jobs;
