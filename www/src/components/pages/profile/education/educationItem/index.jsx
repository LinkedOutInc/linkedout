import React from "react";
import EditEducation from "./EditEducation";

const EducationItem = ({ education }) => {
  const { institution, degree, fieldOfStudy, duration, description } =
    education;

  return (
    <div className="pt-2">
      <div className="flex justify-between">
        <h2 className="text-xl font-semibold">
          {degree}, {fieldOfStudy}
        </h2>
        <EditEducation
          title={degree}
          institution={institution}
          startDate={duration}
          endDate={duration}
          description={description}
        />
      </div>
      <h3 className="text-gray-500">{institution}</h3>
      <h4 className="text-gray-400 mt-2">{duration}</h4>
      <p className="mt-2">{description}</p>
    </div>
  );
};

export default EducationItem;
