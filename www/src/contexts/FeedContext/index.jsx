import React from "react";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";

const FeedContext = React.createContext();

export const useFeed = () => {
  return React.useContext(FeedContext);
};

const FeedProvider = ({ children }) => {
  const API = process.env.REACT_APP_API_URL;
  const { user } = useAuth();
  const { token } = useAuth();
  const [feedPosts, setFeedPosts] = useState([]);
  const [feedOffset, setFeedOffset] = useState(0);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  // Feed stuff
  const fetchFeedPosts = async () => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/feed?offset=${feedOffset}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't fetch feed posts");
          }
          return response.text();
        })
        .then((result) => {
          setFeedPosts(() => JSON.parse(result));
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const newPost = async ({ title, content, image, type }) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        title: title,
        content: content,
        image: image,
        type: type,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/new`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't create post");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
          fetchFeedPosts();
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const deletePost = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete post");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const fetchComments = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}/comments`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }
  };

  const newComment = async (id, content) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        content: content,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}/comments/new`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't create comment");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const deleteComment = async (postId, commentId) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(
        `${API}/api/v1/posts/${postId}/comments/${commentId}`,
        requestOptions
      )
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't delete comment");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const react = async (id, type) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var raw = JSON.stringify({
        type: type,
      });

      var requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}/reactions/currentUser`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't react");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const fetchReactions = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);

      var requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}/reactions/counts`, requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  const removeReaction = async (id) => {
    setLoading((loading) => !loading);
    try {
      var myHeaders = new Headers();
      myHeaders.append("Authorization", `Bearer ${token}`);
      myHeaders.append("Content-Type", "application/json");

      var requestOptions = {
        method: "DELETE",
        headers: myHeaders,
        redirect: "follow",
      };

      fetch(`${API}/api/v1/posts/${id}/reactions/currentUser`, requestOptions)
        .then((response) => {
          if (!response.ok) {
            throw new Error("Couldn't remove reaction");
          }
          return response.text();
        })
        .then((result) => {
          console.log(result);
        })
        .catch((error) => console.log("error", error));
    } catch (error) {
      console.log(error);
    }

    setLoading((loading) => !loading);
  };

  useEffect(() => {
    fetchFeedPosts();
  }, [token]);

  const value = {
    feedPosts,
    loading,
    newPost,
  };

  return <FeedContext.Provider value={value}>{children}</FeedContext.Provider>;
};

export { FeedProvider };
