import React, { useState } from "react";
import Jobs from "./jobs";
import TalentList from "./TalentList";

function Recruiter() {
  localStorage.setItem("auth", true); // Remove later
  const [activeTab, setActiveTab] = useState("jobs");

  const handleTabClick = (tab) => {
    setActiveTab(tab);
  };

  return (
    <div className="gap-4 flex flex-col">
      <ul class="flex border-b border-gray-100 w-screen max-w-screen-lg mx-auto">
        <li class="flex-1">
          <div
            class="relative block p-4 cursor-pointer"
            onClick={() => handleTabClick("jobs")}
          >
            <span
              class={
                "absolute inset-x-0 w-full bg-linkedout" +
                (activeTab === "jobs" ? " -bottom-px h-px" : "")
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
                  d="M20.25 14.15v4.25c0 1.094-.787 2.036-1.872 2.18-2.087.277-4.216.42-6.378.42s-4.291-.143-6.378-.42c-1.085-.144-1.872-1.086-1.872-2.18v-4.25m16.5 0a2.18 2.18 0 00.75-1.661V8.706c0-1.081-.768-2.015-1.837-2.175a48.114 48.114 0 00-3.413-.387m4.5 8.006c-.194.165-.42.295-.673.38A23.978 23.978 0 0112 15.75c-2.648 0-5.195-.429-7.577-1.22a2.016 2.016 0 01-.673-.38m0 0A2.18 2.18 0 013 12.489V8.706c0-1.081.768-2.015 1.837-2.175a48.111 48.111 0 013.413-.387m7.5 0V5.25A2.25 2.25 0 0013.5 3h-3a2.25 2.25 0 00-2.25 2.25v.894m7.5 0a48.667 48.667 0 00-7.5 0M12 12.75h.008v.008H12v-.008z"
                />
              </svg>

              <span class="text-sm font-medium text-gray-900"> Jobs </span>
            </div>
          </div>
        </li>

        <li class="flex-1">
          <div
            class="relative block p-4 cursor-pointer"
            onClick={() => handleTabClick("talent")}
          >
            <span
              class={
                "absolute inset-x-0 w-full bg-linkedout" +
                (activeTab === "talent" ? " -bottom-px h-px" : "")
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
                  d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                />
              </svg>

              <span class="text-sm font-medium text-gray-900">
                {" "}
                Talent List{" "}
              </span>
            </div>
          </div>
        </li>
      </ul>
      {activeTab === "jobs" ? <Jobs /> : <TalentList />}
    </div>
  );
}

export default Recruiter;
