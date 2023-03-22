import React from "react";
import { default as NewPost } from "./newPost";
import { default as Post } from "./post";

// Too lazy to create a mock db for this so I'll just hardcode the data
// delete later and create a mock db
import gavin from "../../../assets/gavin.jpg";
import richard from "../../../assets/richard.jpg";
import jian from "../../../assets/jian.jpg";
const feedData = [
  {
    userImage: gavin,
    userName: "Gavin Belson",
    userTitle: "CEO, Hooli",
    postTime: "Wed, 12 May 2021 12:00:00 GMT",
    postContent:
      "I am thrilled to announce that Hooli has just launched our latest product, Hooli Chat. This innovative messaging platform will revolutionize the way we communicate in the workplace, making it faster, more efficient, and more secure than ever before. As you all know, Hooli has always been at the forefront of technological innovation. We have consistently pushed the boundaries of what is possible, and with Hooli Chat, we are doing it again. By leveraging cutting-edge AI and machine learning algorithms, we have created a messaging platform that is not only intuitive and user-friendly but also highly intelligent and customizable. Hooli Chat is the result of years of research and development by our talented team of engineers and designers. We have listened carefully to the feedback of our users and have incorporated their needs and desires into every aspect of the platform. We believe that Hooli Chat will transform the way we collaborate and communicate with our colleagues, clients, and partners. I am extremely proud of what our team has accomplished, and I am confident that Hooli Chat will be a game-changer in the tech industry. Thank you all for your continued support and for being a part of the Hooli community.",
  },
  {
    userImage: jian,
    userName: "Jian Yang",
    userTitle: "Software Engineer",
    postTime: "Mon, 10 May 2021 12:00:00 GMT",
    postContent:
      'Hello everybody! Me Jian Yang! Me post today because me want tell you all something important. Me just finish read new book "How to Be Successful in Silicon Valley" and me want tell you all that it very good book! Me learn many things about how to make big success in tech industry. Me also want say that me very happy to be part of Silicon Valley community. Me meet many smart people who help me to grow my company and me very grateful for that. If you want to be successful like me, me recommend you read this book too! It have many good advice that can help you make big success in tech industry. Thank you for reading my post! Me wish you all big success in your career!',
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
    <div className="flex flex-col gap-4 max-w-screen-sm w-screen mx-auto">
      <NewPost userPhoto={richard} />
      <div id="Feed" className="gap-4 flex flex-col">
        {posts}
      </div>
    </div>
  );
};

export default Feed;
