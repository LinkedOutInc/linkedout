import React from "react";
import { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../../contexts/AuthContext";

function Init({ formStep, setFormStep, signUpForm, setSignUpForm }) {
  const email = useRef();
  const password = useRef();
  const [emailVal, setEmailVal] = useState("");
  const { loading } = useAuth();
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  const next = (e) => {
    e.preventDefault();
    setFormStep((formStep) => (formStep += 1));
  };

  return (
    <div className="m-auto max-w-screen-xl md:min-w-[768px] min-w-fit min-[380px]:min-w-[360px] px-4 py-16 sm:px-6 lg:px-8">
      <div className="mx-auto max-w-lg">
        <h1 className="text-center text-2xl font-bold text-black sm:text-3xl">
          Connect to professionals
        </h1>

        <form
          onSubmit="return false;"
          className="mt-6 mb-0 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8"
        >
          <label
            htmlFor="UserEmail"
            class="relative block overflow-hidden rounded-md border border-gray-200 px-3 pt-4 shadow-sm focus-within:border-linkedout focus-within:ring-1 focus-within:ring-linkedout"
          >
            <input
              type="email"
              id="UserEmail"
              placeholder="Email"
              ref={email}
              value={signUpForm.email}
              onChange={(e) =>
                setSignUpForm({
                  ...signUpForm,
                  email: e.target.value,
                })
              }
              required
              pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
              className="peer h-10 w-full border-none bg-transparent p-0 placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 sm:text-sm"
            />

            <span className="absolute left-3 top-4 -translate-y-1/2 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-4 peer-focus:text-xs">
              Email
            </span>
            <span className="absolute inset-y-0 right-0 grid place-content-center px-4">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-4 w-4 text-gray-400"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  strokeLinecap="round"
                  strokeLinejoin="round"
                  strokeWidth={2}
                  d="M16 12a4 4 0 10-8 0 4 4 0 008 0zm0 0v1.5a2.5 2.5 0 005 0V12a9 9 0 10-9 9m4.5-1.206a8.959 8.959 0 01-4.5 1.207"
                />
              </svg>
            </span>
          </label>

          <label
            htmlFor="UserPassword"
            class="relative block overflow-hidden rounded-md border border-gray-200 px-3 pt-4 shadow-sm focus-within:border-linkedout focus-within:ring-1 focus-within:ring-linkedout"
          >
            <input
              type={showPassword ? "text" : "password"}
              id="UserPassword"
              placeholder="Password"
              value={signUpForm.password}
              onChange={(e) =>
                setSignUpForm({
                  ...signUpForm,
                  password: e.target.value,
                })
              }
              ref={password}
              required
              class="peer h-10 w-full border-none bg-transparent p-0 placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 sm:text-sm"
            />

            <span class="absolute left-3 top-4 -translate-y-1/2 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-4 peer-focus:text-xs">
              Password
            </span>
            <span
              className="absolute inset-y-0 right-0 grid place-content-center px-4 cursor-pointer"
              onClick={() => setShowPassword(!showPassword)}
            >
              {showPassword ? (
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-4 h-4 text-gray-400"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M3.98 8.223A10.477 10.477 0 001.934 12C3.226 16.338 7.244 19.5 12 19.5c.993 0 1.953-.138 2.863-.395M6.228 6.228A10.45 10.45 0 0112 4.5c4.756 0 8.773 3.162 10.065 7.498a10.523 10.523 0 01-4.293 5.774M6.228 6.228L3 3m3.228 3.228l3.65 3.65m7.894 7.894L21 21m-3.228-3.228l-3.65-3.65m0 0a3 3 0 10-4.243-4.243m4.242 4.242L9.88 9.88"
                  />
                </svg>
              ) : (
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={2}
                  stroke="currentColor"
                  className="w-4 h-4 text-gray-400"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M2.036 12.322a1.012 1.012 0 010-.639C3.423 7.51 7.36 4.5 12 4.5c4.638 0 8.573 3.007 9.963 7.178.07.207.07.431 0 .639C20.577 16.49 16.64 19.5 12 19.5c-4.638 0-8.573-3.007-9.963-7.178z"
                  />
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"
                  />
                </svg>
              )}
            </span>
          </label>

          <p className="text-center select-none text-sm text-gray-500">
            By creating an account, you agree to our terms and conditions and
            privacy policy.
          </p>
          <button
            type="submit"
            className="block select-none w-full rounded-lg bg-linkedout px-5 py-3 text-sm font-medium text-white"
            onClick={(e) => {
              next(e);
            }}
          >
            "Agree & Continue"
          </button>
        </form>
        <div className="text-center select-none text-sm text-gray-500 mt-4">
          Already know your way around?{" "}
          <span
            className="underline cursor-pointer"
            onClick={() => navigate("/login")}
          >
            Sign in
          </span>
        </div>
      </div>
    </div>
  );
}

export default Init;
