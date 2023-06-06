import React from "react";

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
        <h3 className="text-lg font-semibold mb-2">{job.job_title}</h3>
        <p className="text-sm text-gray-600 mb-2">
          {"Company ID " + job.company_ID}
        </p>
        <p className="text-sm text-gray-500 mb-2">{job.location}</p>
        <p className="text-sm text-gray-500 mb-4">{job.profession}</p>
        <p className="text-sm text-gray-500 mb-4">{job.position}</p>
        <p className="text-sm text-gray-500 mb-4">{job.workplace}</p>
        <p className="text-sm text-gray-500 mb-4">{job.date}</p>
        <h4 className="text-md font-semibold mb-2">About the job</h4>
        <p className="text-sm text-gray-700">{job.content}</p>
      </div>
    </div>
  );
}

export default JobDescription;
