import React from "react";

const EducationItem = ({ education }) => {
  const { institution, degree, fieldOfStudy, duration } = education;

  return (
    <div className="pt-2">
      <h2 className="text-xl font-semibold">
        {degree}, {fieldOfStudy}
      </h2>
      <h3 className="text-gray-500">{institution}</h3>
      <h4 className="text-gray-400 mt-2">{duration}</h4>
    </div>
  );
};

export default EducationItem;
