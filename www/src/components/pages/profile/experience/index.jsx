import React from "react";
import ExperienceItem from "./experienceItem";

const ExperienceList = ({ experiences }) => {
  return (
    <div className="col-span-2 bg-white p-6 rounded-2xl shadow">
      <h1 className="text-2xl font-bold">Experience</h1>
      <div id="ExperienceList" className="flex flex-col gap-4 divide-y">
        {experiences.map((experience, index) => (
          <ExperienceItem key={index} experience={experience} />
        ))}
      </div>
    </div>
  );
};

export default ExperienceList;
