import React from "react";

const EducationItem = ({ education }) => {
  const { institution, degree, fieldOfStudy, duration } = education;

  return (
    <div className="pt-2">
      <div className="flex justify-between">
        <h2 className="text-xl font-semibold">
          {degree}, {fieldOfStudy}
        </h2>
        <button className="bg-linkedout text-white font-semibold py-2 px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
          {" "}
          -
        </button>
      </div>
      <h3 className="text-gray-500">{institution}</h3>
      <h4 className="text-gray-400 mt-2">{duration}</h4>
    </div>
  );
};

export default EducationItem;
