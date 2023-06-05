import React from "react";
import { default as NewPost } from "./newPost";
import { default as Post } from "./post";
import { useFeed } from "../../../contexts/FeedContext";

const Feed = () => {
  const { feedPosts } = useFeed();
  const posts = feedPosts.map((post) => {
    return (
      <Post
        userImage={post.image}
        userName={post.name + " " + post.surname}
        userTitle={post.job_title}
        postTime={post.date}
        postTitle={post.title}
        postContent={post.content}
      />
    );
  });

  return (
    <div className="flex flex-col gap-4 max-w-screen-sm w-screen mx-auto">
      <NewPost />
      <div id="Feed" className="gap-4 flex flex-col mb-4">
        {posts}
      </div>
    </div>
  );
};

export default Feed;
