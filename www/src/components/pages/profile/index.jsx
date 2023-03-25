import React from "react";
import ProfileBanner from "./banner";
import Experience from "./experience";
import Education from "./education";
import Interests from "./interests";

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

const education = [
  {
    institution: "University 1",
    degree: "Bachelor of Science",
    fieldOfStudy: "Computer Science",
    duration: "2015 - 2019",
  },
  {
    institution: "University 2",
    degree: "Master of Science",
    fieldOfStudy: "Software Engineering",
    duration: "2019 - 2021",
  },
];

const interests = [
  {
    name: "Interest 1",
    logoUrl: "https://via.placeholder.com/50",
  },
  {
    name: "Interest 2",
    logoUrl: "https://via.placeholder.com/50",
  },
  // Add more interests...
];

function Profile() {
  return (
    <div className="max-w-screen-lg p-4 md:p-8 w-screen mx-auto flex flex-col gap-4">
      <ProfileBanner />
      <Experience experiences={experiences} />
      <Education educationItems={education} />
      <Interests interests={interests} />
    </div>
  );
}

export default Profile;
