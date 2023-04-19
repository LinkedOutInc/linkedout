import React from "react";

function ConnectionItem({ userImage, userName, userTitle }) {
  return (
    <div className="bg-white shadow-md p-4 rounded-md flex justify-between">
      <div className="flex items-center space-x-3">
        <img className="w-12 h-12 rounded-full" src={userImage} alt="User" />
        <div>
          <h3 className="font-semibold text-sm">{userName}</h3>
          <p className="text-xs text-gray-500">{userTitle}</p>
        </div>
      </div>
      <button className="bg-linkedout text-white px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout">
        + Connect
      </button>
    </div>
  );
}

export default ConnectionItem;
