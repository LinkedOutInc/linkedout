import React from "react";

const InterestItem = ({ interest }) => {
  const { name, area, logoUrl } = interest;

  return (
    <div className="bg-white p-6 shadow rounded flex items-center space-x-4">
      <img src={logoUrl} alt={name} className="w-12 h-12" />
      <div className="flex flex-col">
        <div className="flex justify-between">
          <h2 className="text-xl font-semibold">{name}</h2>
          <button className="bg-linkedout text-white font-semibold px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
            {" "}
            -
          </button>
        </div>
        <p className="font-light">{area}</p>
      </div>
    </div>
  );
};

export default InterestItem;
