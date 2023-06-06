import React from "react";
import EditEducation from "./EditEducation";

const EducationItem = ({ education }) => {
  const { name, title, fieldOfStudy, start_date, end_date, description } =
    education;

  console.log(JSON.stringify(education));

  return (
    <div className="pt-2">
      <div className="flex justify-between">
        <h2 className="text-xl font-semibold">
          {title} {fieldOfStudy}
        </h2>
        <EditEducation
          id={education.exp_ID}
          title={title}
          institution={name}
          startDate={start_date}
          endDate={end_date}
          description={description}
        />
      </div>
      <h3 className="text-gray-500">{name}</h3>
      <h4 className="text-gray-400 mt-2">
        {(start_date ? start_date + " - " : "") +
          (end_date ? end_date : " current")}
      </h4>
      <p className="mt-2">{description}</p>
    </div>
  );
};

export default EducationItem;
