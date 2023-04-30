import React from "react";
import InterestItem from "./interestItem";
import NewInterest from "./NewInterest";

const Interests = ({ interests }) => {
  return (
    <div className="mt-4 shadow p-6 rounded-2xl">
      <div className="flex justify-between">
        <h1 className="text-2xl font-bold">Interests</h1>
        <NewInterest />
      </div>
      <div className="grid grid-cols-2 gap-4 mt-2">
        {interests.map((interest, index) => (
          <InterestItem key={index} interest={interest} />
        ))}
      </div>
    </div>
  );
};

export default Interests;
