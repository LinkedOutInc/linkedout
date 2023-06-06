import React from "react";

function JobCard({ job, isSelected, onSelect }) {
  return (
    <div
      onClick={() => onSelect(job)}
      className={`cursor-pointer select-none p-4 bg-white rounded-2xl shadow w-full ${
        isSelected ? "bg-orange-50" : ""
      }`}
    >
      <h3 className="text-lg font-semibold mb-2">{job.job_title}</h3>
      <p className="text-sm text-gray-600 mb-2">
        {"Company ID " + job.company_ID}
      </p>
      <p className="text-sm text-gray-500 mb-2">{job.location}</p>
      <p className="text-sm text-gray-500">{job.profession}</p>
    </div>
  );
}

export default JobCard;
