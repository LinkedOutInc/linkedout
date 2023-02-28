import React from "react";
import { Logo } from "../../";

function Footer() {
  return (
    <footer aria-label="Site Footer" class="bg-gray-50">
      <div class="mx-auto max-w-screen-xl px-4 py-8 sm:px-6 lg:px-8">
        <div class="sm:flex sm:items-center sm:justify-between">
          <Logo />
          <p class="mt-4 text-center text-sm text-gray-500 lg:mt-0 lg:text-right">
            LinkedOut Inc. &copy; 2023. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
