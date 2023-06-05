import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";
import JobSearch from "./JobSearch";
import { useJob } from "../../../../contexts/JobContext";

const FindJobs = () => {
  const { jobs } = useJob();
  const [selectedJob, setSelectedJob] = useState(null);

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
      <div className="p-4 ring-1 rounded-2xl ring-orange-200">
        <JobSearch onSearch={handleSearch} onFilter={handleFilter} />
      </div>
      <div className="mt-4 shadow rounded-2xl shadow-linkedout p-4">
        <div className="grid grid-cols-2 gap-6">
          <div className="space-y-6">
            {jobs.length > 0 ? (
              jobs.map((job) => (
                <JobItem
                  key={job.post_ID}
                  job={job}
                  isSelected={selectedJob && selectedJob.id === job.post_ID}
                  onSelect={setSelectedJob}
                />
              ))
            ) : (
              <div className="flex justify-center">
                There are no jobs available
              </div>
            )}
          </div>
          {jobs.length > 0 && <JobDescription job={selectedJob} />}
        </div>
      </div>
    </div>
  );
};

export default FindJobs;
