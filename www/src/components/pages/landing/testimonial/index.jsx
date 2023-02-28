import React from "react";
import ben from "../../../../assets/ben.jpg";
import elisa from "../../../../assets/elisa.jpg";
import ahmet from "../../../../assets/ahmet.jpg";

function Testimonial() {
  return (
    <section class="bg-white">
      <div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 sm:py-24 lg:px-8">
        <h2 class="text-center text-4xl font-bold tracking-tight sm:text-5xl">
          Still Hesitating?
        </h2>

        <div class="mt-12 grid grid-cols-1 gap-4 md:grid-cols-3 md:gap-8">
          <blockquote class="rounded-lg bg-gray-100 p-8">
            <div class="flex items-center gap-4">
              <img
                alt="Ben"
                src={ben}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">
                Ben Fankman-Bried
              </p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              As an avid user of LinkedOut, I can confidently say that it is the
              most powerful professional networking tool available. With its
              vast user base, it provides an excellent platform to connect with
              like-minded professionals, expand your network, and explore new
              career opportunities.
            </p>
          </blockquote>

          <blockquote class="rounded-lg bg-gray-100 p-8">
            <div class="flex items-center gap-4">
              <img
                alt="Elisa"
                src={elisa}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">Elisa Homles</p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              One of the features that I love about LinkedOut is its
              user-friendly interface. It is easy to navigate and provides a lot
              of options to customize your profile, including adding a profile
              picture, creating a personalized headline, and adding relevant
              work experience and skills. This allows you to showcase your
              professional expertise and make a strong impression on potential
              employers or business partners.
            </p>
          </blockquote>

          <blockquote class="rounded-lg bg-gray-100 p-8">
            <div class="flex items-center gap-4">
              <img
                alt="Ahmet"
                src={ahmet}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">
                Ahmet Denizli
              </p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              One excellent feature of LinkedOut is its job search
              functionality. You can easily search for job openings by location,
              industry, and job title. Additionally, you can set up job alerts
              to receive notifications when new opportunities become available
              that match your search criteria. This makes the job search process
              more efficient and effective.
            </p>
          </blockquote>
        </div>
      </div>
    </section>
  );
}

export default Testimonial;
