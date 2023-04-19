import React from "react";

function TalentItem({ userImage, userName, userTitle }) {
  return (
    <div className="bg-white shadow-md p-4 rounded-md flex justify-between">
      <div className="flex items-center space-x-3">
        <img className="w-12 h-12 rounded-full" src={userImage} alt="User" />
        <div>
          <h3 className="font-semibold text-sm">{userName}</h3>
          <p className="text-xs text-gray-500">{userTitle}</p>
        </div>
      </div>
    </div>
  );
}

export default TalentItem;
