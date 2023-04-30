// components/ProfileBanner.js
import React from "react";
import Resume from "./Resume";
import EditProfile from "./EditProfile";

const data = {
  name: "John Doe",
  headline: "Software Engineer",
  location: "San Francisco, CA",
  connectionCount: "500+",
  picture: "https://via.placeholder.com/150",
};

const ProfileBanner = () => {
  return (
    <div className="flex flex-col md:flex-row shadow p-4 justify-between rounded-2xl">
      {/* <div className="bg-blue-600 h-48">
        <img
          src="https://via.placeholder.com/1080x480"
          alt="Banner"
          className="w-full h-full object-cover"
        />
      </div> */}
      <div className="flex items-center">
        <div>
          <img
            src="https://via.placeholder.com/150"
            alt={data.name}
            className="w-32 h-32 border-4 border-white rounded-full"
          />
          <div className="p-4">
            <div className="flex gap-4">
              <h1 className="text-2xl font-bold">{data.name}</h1>
              <EditProfile />
            </div>
            <h2 className="font-semibold">{data.headline}</h2>
            <div className="">LinkedOut</div>
            <div className="flex space-x-4 mt-2">
              <div>{data.location}</div>
              <div>{data.connectionCount} connections</div>
            </div>
          </div>
        </div>
      </div>
      <div className="flex flex-col items-end gap-4">
        <Resume />
      </div>
    </div>
  );
};

export default ProfileBanner;
