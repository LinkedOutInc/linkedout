import React from "react";
import { default as NewPost } from "./newPost";
import { default as Post } from "./post";

// Too lazy to create a mock db for this so I'll just hardcode the data
// delete later and create a mock db
import gavin from "../../../assets/ben.jpg";
import richard from "../../../assets/elisa.jpg";
import jian from "../../../assets/ahmet.jpg";
const feedData = [
  {
    userImage: gavin,
    userName: "Ben Leonardo",
    userTitle: "CEO",
    postTime: "Wed, 12 May 2021 12:00:00 GMT",
    postContent:
      "As an avid user of LinkedOut, I can confidently say that it is the most powerful professional networking tool available. With its vast user base, it provides an excellent platform to connect with like-minded professionals, expand your network, and explore new career opportunities.",
  },
  {
    userImage: jian,
    userName: "Ahmet Aydogan",
    userTitle: "HR Manager",
    postTime: "Mon, 10 May 2021 12:00:00 GMT",
    postContent:
      "One excellent feature of LinkedOut is its job search functionality. You can easily search for job openings by location, industry, and job title. Additionally, you can set up job alerts to receive notifications when new opportunities become available that match your search criteria. This makes the job search process more efficient and effective.",
  },
];

const Feed = () => {
  const posts = feedData.map((post) => {
    return (
      <Post
        userImage={post.userImage}
        userName={post.userName}
        userTitle={post.userTitle}
        postTime={post.postTime}
        postContent={post.postContent}
      />
    );
  });

  return (
    <div className="flex flex-col gap-4 max-w-screen-sm w-screen">
      <NewPost userPhoto={richard} />
      <div id="Feed" className="gap-4 flex flex-col">
        {posts}
      </div>
    </div>
  );
};

export default Feed;
