import React from "react";

const Logo = ({ className }) => {
  return (
    <div
      class={
        className +
        " font-extrabold background-animate select-none mx-0 w-auto text-xl bg-clip-text text-linkedout  ..."
      }
    >
      LinkedOut
    </div>
  );
};

export default Logo;
