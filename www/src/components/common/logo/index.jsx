import React from "react";

const Logo = ({ className }) => {
  return (
    <div
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
