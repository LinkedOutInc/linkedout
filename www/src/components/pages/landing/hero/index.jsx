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
            <label
              htmlFor="UserEmail"
              class="relative flex-1 block overflow-hidden rounded-md border border-gray-200 px-3 pt-4 shadow-sm focus-within:border-linkedout focus-within:ring-1 focus-within:ring-linkedout"
            >
              <input
                type="email"
                id="UserEmail"
                placeholder="Email"
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
