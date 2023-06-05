import React from "react";
import EditInterest from "./EditInterest";

const InterestItem = ({ interest }) => {
  const { id, title, area, logoUrl } = interest;

  return (
    <div className="bg-white p-6 shadow rounded flex items-center space-x-4">
      <img
        src={logoUrl ? logoUrl : "https://via.placeholder.com/150"}
        alt={title}
        className="w-12 h-12"
      />
      <div className="flex flex-col">
        <div className="flex justify-between">
          <h2 className="text-xl font-semibold">{title}</h2>
          <EditInterest id={id} title={title} area={area} />
        </div>
        <p className="font-light">{area}</p>
      </div>
    </div>
  );
};

export default InterestItem;
