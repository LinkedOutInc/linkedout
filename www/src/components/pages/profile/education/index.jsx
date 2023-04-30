import React from "react";
import EducationItem from "./educationItem";
import NewEducation from "./NewEducation";

const Education = ({ educationItems }) => {
  return (
    <div className="col-span-2 bg-white p-6 rounded-2xl shadow">
      <div className="flex justify-between">
        <h1 className="text-2xl font-bold">Education</h1>
        <NewEducation />
      </div>
      <div id="ExperienceList" className="flex flex-col gap-4 divide-y">
        {educationItems.map((education, index) => (
          <EducationItem key={index} education={education} />
        ))}
      </div>
    </div>
  );
};

export default Education;
