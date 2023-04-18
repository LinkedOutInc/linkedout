import React from "react";

const ExperienceItem = ({ experience }) => {
  const { company, title, duration, description } = experience;

  return (
    <div className="pt-2">
      <div className="flex justify-between">
        <h2 className="text-xl font-semibold">{title}</h2>
        <button className="bg-linkedout text-white font-semibold py-2 px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
          {" "}
          -
        </button>
      </div>
      <h3 className="text-gray-500">{company}</h3>
      <h4 className="text-gray-400 mt-1">{duration}</h4>
      <p className="mt-2">{description}</p>
    </div>
  );
};

export default ExperienceItem;
