import React from "react";

function Reports() {
  return (
    <div className="p-6 flex gap-4">
      <button className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
        Generate General Report
      </button>
      <button className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
        Generate User Report
      </button>
      <button className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
        Generate Job Report
      </button>
      <button className="bg-linkedout text-white px-4 py-2 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
        Generate Post Report
      </button>
    </div>
  );
}

export default Reports;
