import React from "react";
import ApplyJob from "./ApplyJob";

function JobDescription({ job }) {
  if (!job) {
    return (
      <div className="p-4 bg-white rounded shadow-md">
        Select a job to view details.
      </div>
    );
  }

  return (
    <div className="flex flex-col h-full p-4 bg-white rounded shadow-md">
      <div>
        <h3 className="text-lg font-semibold mb-2">{job.title}</h3>
        <p className="text-sm text-gray-600 mb-2">{job.company}</p>
        <p className="text-sm text-gray-500 mb-2">{job.location}</p>
        <p className="text-sm text-gray-500 mb-4">{job.type}</p>
        <h4 className="text-md font-semibold mb-2">About the job</h4>
        <p className="text-sm text-gray-700">{job.description}</p>
      </div>
      <div className="mt-auto ml-auto">
        <ApplyJob />
      </div>
    </div>
  );
}

export default JobDescription;
