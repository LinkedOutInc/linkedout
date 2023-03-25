import React from "react";
import InterestItem from "./interestItem";

const Interests = ({ interests }) => {
  return (
    <div className="mt-4 shadow p-6 rounded-2xl">
      <h1 className="text-2xl font-bold mb-4">Interests</h1>
      <div className="grid grid-cols-2 gap-4">
        {interests.map((interest, index) => (
          <InterestItem key={index} interest={interest} />
        ))}
      </div>
    </div>
  );
};

export default Interests;
