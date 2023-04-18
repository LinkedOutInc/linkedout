import React from "react";
import EditExperience from "./EditExperience";

const ExperienceItem = ({ experience }) => {
  const { company, title, duration, description } = experience;

  return (
    <div className="pt-2">
      <div className="flex justify-between">
        <h2 className="text-xl font-semibold">{title}</h2>
        <EditExperience
          title={title}
          company={company}
          duration={duration}
          description={description}
        />
      </div>
      <h3 className="text-gray-500">{company}</h3>
      <h4 className="text-gray-400 mt-1">{duration}</h4>
      <p className="mt-2">{description}</p>
    </div>
  );
};

export default ExperienceItem;
