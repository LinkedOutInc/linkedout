import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";
import JobSearch from "./JobSearch";
import NewJob from "./NewJob";

const Jobs = () => {
  const [jobs, setJobs] = useState([]);
  const [selectedJob, setSelectedJob] = useState(null);
  const [selectedFilter, setSelectedFilter] = useState("all");

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
          type: "On-site",
        },
        {
          id: 2,
          title: "Product Manager",
          company: "XYZ Inc",
          location: "San Francisco, CA",
          description: "This is a Product Manager job description.",
          type: "Remote",
        },
        {
          id: 3,
          title: "Data Scientist",
          company: "Data Co",
          location: "Seattle, WA",
          description: "This is a Data Scientist job description.",
          type: "Hybrid",
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
      <div className="shadow rounded-2xl shadow-linkedout p-4 gap-4 flex flex-col">
        <div className="grid grid-cols-2 gap-6">
          <div className="space-y-6">
            <h2 className="text-2xl p-1 font-semibold">My Jobs</h2>
            <div className="flex">
              <NewJob />
              <select
                value={selectedFilter}
                onChange={handleFilter}
                className="border ml-auto border-gray-300 rounded-2xl p-2"
              >
                <option value="latest">Latest</option>
                <option value="oldest">Oldest</option>
              </select>
            </div>

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
