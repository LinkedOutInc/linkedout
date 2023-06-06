import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";
import { useJob } from "../../../../contexts/JobContext";

const AppliedJobs = () => {
  const [selectedJob, setSelectedJob] = useState(null);
  const { appliedJobs } = useJob();

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
            {appliedJobs.length > 0 ? (
              appliedJobs.map((job) => (
                <JobItem
                  key={job.post_ID}
                  job={job}
                  isSelected={
                    selectedJob && selectedJob.post_ID === job.post_ID
                  }
                  onSelect={setSelectedJob}
                />
              ))
            ) : (
              <p className="text-center">
                You have not applied to any jobs yet.
              </p>
            )}
          </div>
          {appliedJobs.length > 0 && <JobDescription job={selectedJob} />}
        </div>
      </div>
    </div>
  );
};

export default AppliedJobs;
