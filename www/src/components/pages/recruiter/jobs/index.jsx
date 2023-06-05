import React, { useState, useEffect } from "react";
import JobItem from "./JobItem";
import JobDescription from "./JobDescription";
import JobSearch from "./JobSearch";
import NewJob from "./NewJob";
import { useRecruiter } from "../../../../contexts/RecruiterContext";

const Jobs = () => {
  const { myJobs } = useRecruiter();
  const [selectedJob, setSelectedJob] = useState(null);
  const [selectedFilter, setSelectedFilter] = useState("all");

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

            {myJobs.map((job) => (
              <JobItem
                key={job.post_ID}
                job={job}
                isSelected={selectedJob && selectedJob.post_ID === job.post_ID}
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
