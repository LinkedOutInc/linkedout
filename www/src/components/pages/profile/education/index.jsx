import React from "react";
import EducationItem from "./educationItem";

const Education = ({ educationItems }) => {
  return (
    <div className="col-span-2 bg-white p-6 rounded-2xl shadow">
      <h1 className="text-2xl font-bold">Education</h1>
      <div id="ExperienceList" className="flex flex-col gap-4 divide-y">
        {educationItems.map((education, index) => (
          <EducationItem key={index} education={education} />
        ))}
      </div>
    </div>
  );
};

export default Education;
