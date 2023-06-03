import React from "react";
import { useNavigate } from "react-router-dom";
import { Logo } from "../../../../components";

function Guest() {
  const navigate = useNavigate();

  const home = () => {
    navigate("/");
  };

  const login = () => {
    navigate("/login");
  };

  const signup = () => {
    navigate("/signup");
  };

  return (
    <header aria-label="Site Header" className="bg-white">
      <div className="mx-auto max-w-screen-lg my-4 px-4 sm:px-6 lg:px-8">
        <div className="flex h-16 items-center justify-between">
          <div
            className="flex-1 md:flex md:items-center md:gap-12"
            onClick={home}
          >
            <Logo className={"cursor-pointer"} />
          </div>

          <div className="flex items-center gap-4">
            <div className="flex gap-x-1 justify-end min-w-[100px] flex-nowrap flex-shrink-0 flex-1">
              <a
                className="ml-6 px-5 py-2.5 text-md font-medium text-gray-600 cursor-pointer select-none hover:bg-gray-50 hover:rounded-2xl"
                onClick={signup}
              >
                Join Now
              </a>

              <a
                className="rounded-2xl px-5 py-2.5 text-md font-medium text-linkedout border border-linkedout hover:bg-orange-50 cursor-pointer select-none"
                onClick={login}
              >
                Sign in
              </a>
            </div>
          </div>
        </div>
      </div>
    </header>
  );
}

export default Guest;
