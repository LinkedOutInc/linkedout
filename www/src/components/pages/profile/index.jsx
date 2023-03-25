import React from "react";
import ProfileBanner from "./banner";
import ExperienceList from "./experience";

const experiences = [
  {
    company: "Company 1",
    title: "Software Engineer",
    duration: "Jan 2020 - Present",
    description:
      "Developing web applications and collaborating with team members.",
  },
  {
    company: "Company 2",
    title: "Junior Developer",
    duration: "Jun 2018 - Dec 2019",
    description:
      "Worked on front-end development and contributed to team projects.",
  },
];

function Profile() {
  return (
    <div className="max-w-screen-lg p-4 md:p-8 w-screen mx-auto flex flex-col gap-4">
      <ProfileBanner />
      <ExperienceList experiences={experiences} />
    </div>
  );
}

export default Profile;
