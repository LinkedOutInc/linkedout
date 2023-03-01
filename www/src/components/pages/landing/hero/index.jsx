import React from "react";

function Hero() {
  return (
    <section class="bg-gray-50">
      <div class="p-8 md:p-12 lg:px-16 lg:py-24">
        <div class="mx-auto max-w-lg text-center">
          <h2 class="text-2xl font-bold text-gray-900 md:text-3xl">
            Let's connect!
          </h2>

          <p class="hidden text-gray-500 sm:mt-4 sm:block">
            As a new member, you have the opportunity to connect with
            like-minded individuals, expand your network, and stay up-to-date on
            industry news and trends. Share your expertise, engage in
            discussions, and explore new opportunities.
          </p>
        </div>

        <div class="mx-auto mt-8 max-w-xl">
          <form action="#" class="sm:flex sm:gap-4">
            <div class="sm:flex-1">
              <label for="email" class="sr-only">
                Email
              </label>

              <input
                type="email"
                placeholder="Email address"
                class="w-full rounded-md border-gray-200 bg-white p-3 text-gray-700 shadow-sm transition focus:border-white focus:outline-none focus:ring-1 focus:ring-linkedout"
              />
            </div>

            <button
              type="submit"
              class="group mt-4 flex w-full items-center justify-center gap-2 rounded-md bg-linkedout px-5 py-3 text-white transition focus:outline-none focus:ring focus:ring-linkedout sm:mt-0 sm:w-auto"
            >
              <span class="text-sm font-medium"> Join Now </span>

              <svg
                class="h-5 w-5"
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M17 8l4 4m0 0l-4 4m4-4H3"
                />
              </svg>
            </button>
          </form>
        </div>
      </div>
    </section>
  );
}

export default Hero;
