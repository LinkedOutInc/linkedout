import React, { useState } from "react";
import { useAdmin } from "../../../../contexts/AdminContext";

function Reports() {
  const {
    roleCountReport,
    hiringReport,
    generateHiringReport,
    generateRoleCountReport,
  } = useAdmin();

  const handleRoleCountReport = async () => {
    generateRoleCountReport();
  };

  const handleHiringReport = async () => {
    generateHiringReport();
  };

  return (
    <div className="p-6 flex flex-col gap-4">
      <button
        className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout"
        onClick={handleRoleCountReport}
      >
        Generate Role Count Report
      </button>
      {roleCountReport && <div>{JSON.stringify(roleCountReport)}</div>}
      <button
        className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout"
        onClick={handleHiringReport}
      >
        Generate Hiring Report
      </button>
      {hiringReport && <div>{JSON.stringify(hiringReport)}</div>}
    </div>
  );
}

export default Reports;
