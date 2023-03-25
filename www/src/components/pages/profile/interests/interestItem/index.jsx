import React from "react";

const InterestItem = ({ interest }) => {
  const { name, logoUrl } = interest;

  return (
    <div className="bg-white p-6 shadow rounded flex items-center space-x-4">
      <img src={logoUrl} alt={name} className="w-12 h-12" />
      <h2 className="text-xl font-semibold">{name}</h2>
    </div>
  );
};

export default InterestItem;
