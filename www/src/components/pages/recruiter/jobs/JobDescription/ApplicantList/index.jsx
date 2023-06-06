import React, { useState, useEffect, useRef } from "react";
import ApplicantItem from "./ApplicantItem";
import { useRecruiter } from "../../../../../../contexts/RecruiterContext";

const ApplicantList = () => {
  const [isOpen, setIsOpen] = useState(false);
  const popupRef = useRef(null);
  const { applicants, fetchApplicants } = useRecruiter();

  const applications = applicants.map((application) => {
    fetchApplicants(application.post_ID);
    return (
      <div className="mt-2">
        <ApplicantItem
          userImage={application.image}
          userName={application.name}
          userTitle={application.job_title}
        />
      </div>
    );
  });

  const handleOpen = () => {
    setIsOpen(true);
  };

  const handleClose = () => {
    setIsOpen(false);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (popupRef.current && !popupRef.current.contains(event.target)) {
        handleClose();
      }
    };

    if (isOpen) {
      document.addEventListener("mousedown", handleOutsideClick);
    }

    return () => {
      document.removeEventListener("mousedown", handleOutsideClick);
    };
  }, [isOpen]);

  return (
    <div className="relative">
      <button
        className="bg-linkedout text-white font-semibold py-2 px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout"
        onClick={handleOpen}
      >
        {" "}
        Applicant List
      </button>

      {isOpen && (
        <div className="fixed top-0 left-0 h-full w-full bg-black bg-opacity-50 flex justify-center items-center">
          <div ref={popupRef} className="bg-white w-96 p-6 rounded-2xl">
            <div className="flex justify-between">
              <h2 className="text-2xl font-bold mb-4">Applicants</h2>
              <div className="cursor-pointer" onClick={handleClose}>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-6 h-6"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M6 18L18 6M6 6l12 12"
                  />
                </svg>
              </div>
            </div>
            {/* Form content goes here */}
            {applications}
            <button
              className="absolute top-2 right-2 text-gray-500 hover:text-gray-700"
              onClick={handleClose}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-6 w-6"
                viewBox="0 0 20 20"
                fill="currentColor"
              >
                <path
                  fillRule="evenodd"
                  d="M12.72 7.469l-5.469 5.469a.75.75 0 11-1.061-1.061l5.469-5.469a.75.75 0 111.061 1.061zM7.469 12.72L12.72 7.47a.75.75 0 111.061 1.061l-5.469 5.469a.75.75 0 11-1.061-1.06l5.469-5.47-5.469 5.47a.75.75 0 01-1.061 0z"
                  clipRule="evenodd"
                />
              </svg>
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default ApplicantList;
