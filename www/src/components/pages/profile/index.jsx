import React from "react";
import { useState } from "react";
import ProfileBanner from "./banner";
import Experience from "./experience";
import Education from "./education";
import Interests from "./interests";

import { useProfile } from "../../../contexts/ProfileContext";

function Profile() {
  const { profile } = useProfile();
  const { user } = useProfile();
  const { loading } = useProfile();
  const { experience } = useProfile();
  const { education } = useProfile();
  const { interests } = useProfile();

  return (
    <div className="max-w-screen-lg p-4 md:p-0 w-screen mx-auto flex flex-col gap-4">
      <ProfileBanner data={user} />
      <Experience experiences={experience} />
      <Education educationItems={education} />
      <Interests interests={interests} />
    </div>
  );
}

export default Profile;
