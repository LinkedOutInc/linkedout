import React from "react";
import { default as NewPost } from "./newPost";

const Feed = () => {
  return (
    <div className="flex max-w-screen-md">
      <NewPost />
    </div>
  );
};

export default Feed;
