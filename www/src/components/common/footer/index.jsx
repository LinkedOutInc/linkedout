import React from "react";
import { Logo } from "../../";

function Footer() {
  return (
    <footer aria-label="Site Footer" class="bg-gray-50 w-full min-h-[72px]">
      <div class="mx-auto max-w-screen-xl px-4 py-8 sm:px-6 lg:px-8">
        <div class="flex-col md:flex-row flex items-center md:items-stretch md:justify-between">
          <Logo />
          <nav aria-label="Site Nav" class="block md:hidden py-6 md:py-0">
            <ul class="flex items-center gap-12 md:gap-6 text-sm">
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
          <p class="mt-4 text-center text-sm text-gray-500 md:mt-0 md:text-right">
            LinkedOut Inc. &copy; 2023. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
