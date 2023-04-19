import React, { useState } from "react";
import FindJobs from "./FindJobs";
import AppliedJobs from "./AppliedJobs";

function Jobs() {
  localStorage.setItem("auth", 1); // Remove later
  const [activeTab, setActiveTab] = useState("findjobs");

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };

  return (
    <div className="w-screen max-w-screen-lg mx-auto">
      <div className="gap-4 flex flex-col">
        <ul class="flex border-b border-gray-100 w-screen max-w-screen-lg mx-auto">
          <li class="flex-1">
            <div
              class="relative block p-4 cursor-pointer"
              onClick={() => handleTabClick("findjobs")}
            >
              <span
                class={
                  "absolute inset-x-0 w-full bg-linkedout" +
                  (activeTab === "findjobs" ? " -bottom-px h-px" : "")
                }
              ></span>

              <div class="flex items-center justify-center gap-4">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-5 h-5"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M20.893 13.393l-1.135-1.135a2.252 2.252 0 01-.421-.585l-1.08-2.16a.414.414 0 00-.663-.107.827.827 0 01-.812.21l-1.273-.363a.89.89 0 00-.738 1.595l.587.39c.59.395.674 1.23.172 1.732l-.2.2c-.212.212-.33.498-.33.796v.41c0 .409-.11.809-.32 1.158l-1.315 2.191a2.11 2.11 0 01-1.81 1.025 1.055 1.055 0 01-1.055-1.055v-1.172c0-.92-.56-1.747-1.414-2.089l-.655-.261a2.25 2.25 0 01-1.383-2.46l.007-.042a2.25 2.25 0 01.29-.787l.09-.15a2.25 2.25 0 012.37-1.048l1.178.236a1.125 1.125 0 001.302-.795l.208-.73a1.125 1.125 0 00-.578-1.315l-.665-.332-.091.091a2.25 2.25 0 01-1.591.659h-.18c-.249 0-.487.1-.662.274a.931.931 0 01-1.458-1.137l1.411-2.353a2.25 2.25 0 00.286-.76m11.928 9.869A9 9 0 008.965 3.525m11.928 9.868A9 9 0 118.965 3.525"
                  />
                </svg>

                <span class="text-sm font-medium text-gray-900">
                  {" "}
                  Find Jobs{" "}
                </span>
              </div>
            </div>
          </li>

          <li class="flex-1">
            <div
              class="relative block p-4 cursor-pointer"
              onClick={() => handleTabClick("requests")}
            >
              <span
                class={
                  "absolute inset-x-0 w-full bg-linkedout" +
                  (activeTab === "requests" ? " -bottom-px h-px" : "")
                }
              ></span>
              <div class="flex items-center justify-center gap-4">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-5 h-5"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M19 7.5v3m0 0v3m0-3h3m-3 0h-3m-2.25-4.125a3.375 3.375 0 11-6.75 0 3.375 3.375 0 016.75 0zM4 19.235v-.11a6.375 6.375 0 0112.75 0v.109A12.318 12.318 0 0110.374 21c-2.331 0-4.512-.645-6.374-1.766z"
                  />
                </svg>

                <span class="text-sm font-medium text-gray-900">
                  {" "}
                  Past Applications{" "}
                </span>
              </div>
            </div>
          </li>
        </ul>
        {activeTab === "findjobs" ? <FindJobs /> : <AppliedJobs />}
      </div>
    </div>
  );
}

export default Jobs;
