import React from "react";
import { useNavigate } from "react-router-dom";

const Logo = ({ className }) => {
  const navigate = useNavigate();
  return (
    <div
      onClick={() => {
        navigate("/");
      }}
      className={
        className +
        " font-extrabold background-animate cursor-pointer select-none mx-0 w-auto text-xl bg-clip-text text-linkedout  ..."
      }
    >
      LinkedOut
    </div>
  );
};

export default Logo;
