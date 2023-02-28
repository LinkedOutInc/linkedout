import React from "react";
import { Logo } from "../../../components";

function Index() {
  return (
    <header aria-label="Site Header" class="bg-white">
      <div class="mx-auto max-w-screen-xl my-4 px-4 sm:px-6 lg:px-8">
        <div class="flex h-16 items-center justify-between">
          <div class="flex-1 md:flex md:items-center md:gap-12">
            <Logo />
          </div>

          <div class="md:flex md:items-center md:gap-12 divide-x-[1.5px]">
            <nav aria-label="Site Nav" class="hidden md:block">
              <ul class="flex items-center gap-6 text-sm">
                <li>
                  <a
                    class="text-gray-500 transition hover:text-gray-500/75"
                    href="/"
                  >
                    About
                  </a>
                </li>

                <li>
                  <a
                    class="text-gray-500 transition hover:text-gray-500/75"
                    href="/"
                  >
                    Careers
                  </a>
                </li>

                <li>
                  <a
                    class="text-gray-500 transition hover:text-gray-500/75"
                    href="/"
                  >
                    Blog
                  </a>
                </li>
              </ul>
            </nav>

            <div class="flex items-center gap-4">
              <div class="sm:flex sm:gap-4">
                <a class="ml-6 px-5 py-2.5 text-md font-medium text-gray-600 cursor-pointer select-none hover:bg-gray-50 hover:rounded-2xl">
                  Join Now
                </a>

                <div class="hidden sm:flex">
                  <a class="rounded-2xl px-5 py-2.5 text-md font-medium text-linkedout border border-linkedout hover:bg-orange-50 cursor-pointer select-none">
                    Sign in
                  </a>
                </div>
              </div>

              <div class="block md:hidden">
                <button class="rounded bg-gray-100 p-2 text-gray-600 transition hover:text-gray-600/75">
                  <svg
                    xmlns="http://www.w3.org/2000/svg"
                    class="h-5 w-5"
                    fill="none"
                    viewBox="0 0 24 24"
                    stroke="currentColor"
                    stroke-width="2"
                  >
                    <path
                      stroke-linecap="round"
                      stroke-linejoin="round"
                      d="M4 6h16M4 12h16M4 18h16"
                    />
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </header>
  );
}

export default Index;
