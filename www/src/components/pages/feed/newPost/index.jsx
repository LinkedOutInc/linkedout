import React, { useState } from "react";

const NewPost = ({ userPhoto }) => {
  const [postContent, setPostContent] = useState("");
  const [postImage, setPostImage] = useState(null);
  const [textareaHeight, setTextareaHeight] = useState("3rem");

  const handlePostContentChange = (event) => {
    setPostContent(event.target.value);
    const target = event.target;
    const newHeight =
      target.scrollHeight > parseInt(textareaHeight)
        ? `${target.scrollHeight}px`
        : textareaHeight;

    setTextareaHeight(newHeight);
  };

  const handleImageUpload = (event) => {
    setPostImage(event.target.files[0]);
  };

  const handleSubmitPost = () => {
    if (!postContent.trim()) {
      alert("Please write something in your post.");
      return;
    }

    // Submit the post content and image (if any) to the API or backend
    console.log("Post content:", postContent);
    console.log("Post image:", postImage);

    // Clear the input fields
    setPostContent("");
    setPostImage(null);
  };

  return (
    <div className="flex items-center space-x-4 bg-white rounded-md p-4 shadow-md w-full">
      <form className="flex-1">
        <div className="flex gap-4">
          <img
            className="h-12 w-12 rounded-full"
            src={userPhoto ? userPhoto : "https://via.placeholder.com/150"}
            alt="Profile Image"
          />
          <textarea
            value={postContent}
            onChange={handlePostContentChange}
            className="w-full p-2 border border-gray-300 rounded resize-none overflow-y-hidden focus:outline-none focus:ring focus:ring-linkedout"
            placeholder="What's on your mind?"
            style={{ height: textareaHeight }}
          />
        </div>

        <div className="flex justify-between items-center mt-4">
          <label className="flex space-x-2 cursor-pointer ml-14">
            <input
              type="file"
              id="postImage"
              accept="image/*"
              onChange={handleImageUpload}
              className="hidden"
            />
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              strokeWidth={1.5}
              stroke="currentColor"
              className="w-6 h-6 text-linkedout"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                d="M2.25 15.75l5.159-5.159a2.25 2.25 0 013.182 0l5.159 5.159m-1.5-1.5l1.409-1.409a2.25 2.25 0 013.182 0l2.909 2.909m-18 3.75h16.5a1.5 1.5 0 001.5-1.5V6a1.5 1.5 0 00-1.5-1.5H3.75A1.5 1.5 0 002.25 6v12a1.5 1.5 0 001.5 1.5zm10.5-11.25h.008v.008h-.008V8.25zm.375 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z"
              />
            </svg>

            <span>{postImage ? postImage.name : "Photo"}</span>
          </label>
          <button
            className="rounded-2xl px-5 py-2.5 text-md font-medium text-linkedout border border-linkedout hover:bg-orange-50 cursor-pointer select-none"
            onSubmit={handleSubmitPost}
            onClick={handleSubmitPost}
          >
            Post
          </button>
        </div>
      </form>
    </div>
  );
};

export default NewPost;
