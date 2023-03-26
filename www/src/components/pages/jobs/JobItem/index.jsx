import React from "react";

function JobCard({ job, isSelected, onSelect }) {
  return (
    <div
      onClick={() => onSelect(job)}
      className={`cursor-pointer select-none p-4 bg-white rounded shadow w-full ${
        isSelected ? "bg-orange-50" : ""
      }`}
    >
      <h3 className="text-lg font-semibold mb-2">{job.title}</h3>
      <p className="text-sm text-gray-600 mb-2">{job.company}</p>
      <p className="text-sm text-gray-500">{job.location}</p>
    </div>
  );
}

export default JobCard;
