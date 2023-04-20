import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Complete() {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedFilter, setSelectedFilter] = useState("all");

  const handleFilter = (event) => {
    setSelectedFilter(event.target.value);
  };

  const handleComplete = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      await new Promise((r) => setTimeout(r, 2000));
    } catch (err) {}
    setLoading(false);
  };

  return (
    <div className="m-auto max-w-screen-xl md:min-w-[768px] min-w-fit min-[380px]:min-w-[360px] px-4 py-16 sm:px-6 lg:px-8">
      <div className="mx-auto max-w-lg">
        <span className="flex flex-row">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            fill="none"
            viewBox="0 0 24 24"
            strokeWidth={1.5}
            stroke="currentColor"
            className="w-6 h-6 mr-auto cursor-pointer"
            onClick={() => navigate(-1)}
          >
            <path
              strokeLinecap="round"
              strokeLinejoin="round"
              d="M9 15L3 9m0 0l6-6M3 9h12a6 6 0 010 12h-3"
            />
          </svg>

          <h1 className="text-center text-2xl font-bold mr-auto text-black sm:text-3xl">
            One more step
          </h1>
        </span>

        <form
          action=""
          className="mt-6 mb-0 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8"
        >
          <label
            htmlFor="UserFirst"
            class="relative block overflow-hidden rounded-md border border-gray-200 px-3 pt-4 shadow-sm focus-within:border-linkedout focus-within:ring-1 focus-within:ring-linkedout"
          >
            <input
              type="text"
              id="UserFirst"
              placeholder="First name"
              required
              className="peer h-10 w-full border-none bg-transparent p-0 placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 sm:text-sm"
            />

            <span className="absolute left-3 top-4 -translate-y-1/2 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-4 peer-focus:text-xs">
              First name
            </span>
            <span className="absolute inset-y-0 right-0 grid place-content-center px-4">
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
                  d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                />
              </svg>
            </span>
          </label>

          <label
            htmlFor="UserLastName"
            class="relative block overflow-hidden rounded-md border border-gray-200 px-3 pt-4 shadow-sm focus-within:border-linkedout focus-within:ring-1 focus-within:ring-linkedout"
          >
            <input
              type="text"
              id="UserLast"
              placeholder="Last name"
              required
              class="peer h-10 w-full border-none bg-transparent p-0 placeholder-transparent focus:border-transparent focus:outline-none focus:ring-0 sm:text-sm"
            />

            <span class="absolute left-3 top-4 -translate-y-1/2 text-xs text-gray-700 transition-all peer-placeholder-shown:top-1/2 peer-placeholder-shown:text-sm peer-focus:top-4 peer-focus:text-xs">
              Last name
            </span>
            <span className="absolute inset-y-0 right-0 grid place-content-center px-4">
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
                  d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                />
              </svg>
            </span>
          </label>

          <select
            value={selectedFilter}
            onChange={handleFilter}
            className="border border-linkedout rounded-2xl p-2"
          >
            <option value="default">Select Account Type</option>
            <option value="user">User</option>
            <option value="recruiter">Recruiter</option>
            <option value="cexpert">Career Expert</option>
          </select>

          <button
            type="submit"
            className="block select-none w-full rounded-lg bg-linkedout px-5 py-3 text-sm font-medium text-white"
            onClick={(e) => handleComplete(e)}
          >
            {loading ? (
              <svg
                role="status"
                className="inline mr-3 w-4 h-4 text-white animate-spin"
                viewBox="0 0 100 101"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <path
                  d="M100 50.5908C100 78.2051 77.6142 100.591 50 100.591C22.3858 100.591 0 78.2051 0 50.5908C0 22.9766 22.3858 0.59082 50 0.59082C77.6142 0.59082 100 22.9766 100 50.5908ZM9.08144 50.5908C9.08144 73.1895 27.4013 91.5094 50 91.5094C72.5987 91.5094 90.9186 73.1895 90.9186 50.5908C90.9186 27.9921 72.5987 9.67226 50 9.67226C27.4013 9.67226 9.08144 27.9921 9.08144 50.5908Z"
                  fill="#E5E7EB"
                />
                <path
                  d="M93.9676 39.0409C96.393 38.4038 97.8624 35.9116 97.0079 33.5539C95.2932 28.8227 92.871 24.3692 89.8167 20.348C85.8452 15.1192 80.8826 10.7238 75.2124 7.41289C69.5422 4.10194 63.2754 1.94025 56.7698 1.05124C51.7666 0.367541 46.6976 0.446843 41.7345 1.27873C39.2613 1.69328 37.813 4.19778 38.4501 6.62326C39.0873 9.04874 41.5694 10.4717 44.0505 10.1071C47.8511 9.54855 51.7191 9.52689 55.5402 10.0491C60.8642 10.7766 65.9928 12.5457 70.6331 15.2552C75.2735 17.9648 79.3347 21.5619 82.5849 25.841C84.9175 28.9121 86.7997 32.2913 88.1811 35.8758C89.083 38.2158 91.5421 39.6781 93.9676 39.0409Z"
                  fill="currentColor"
                />
              </svg>
            ) : (
              "Complete signup"
            )}
          </button>
        </form>
      </div>
    </div>
  );
}

export default Complete;
