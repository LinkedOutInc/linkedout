import React from "react";
import gavin from "../../../../assets/gavin.jpg";
import richard from "../../../../assets/richard.jpg";
import jian from "../../../../assets/jian.jpg";

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
                alt="Gavin Belson"
                src={gavin}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">Gavin Belson</p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              As Gavin Belson, the unparalleled genius and CEO of Hooli, the
              world's most innovative technology company, I've been making waves
              in Silicon Valley for years. And it's no secret that LinkedOut has
              been a key player in my quest for professional domination.
              LinkedOut is the perfect platform for moguls like myself and the
              company that has revolutionized the world, Hooli.
            </p>
          </blockquote>

          <blockquote class="rounded-lg bg-gray-100 p-8">
            <div class="flex items-center gap-4">
              <img
                alt="Richard Hendricks"
                src={richard}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">
                Richard Hendricks
              </p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              As the founder of Pied Piper, I've gotta hand it to LinkedOut for
              being a real game changer in the professional realm. It's like the
              HTTP of networking, connecting us tech aficionados in a web of
              career opportunities and industry insights. I've scored some
              genius teammates (Dinesh, Gilfoyle, you know who you are) and
              stayed ahead of Hooli's shenanigans. Sure, it's got its quirks -
              but let's face it, so do we all! Bottom line, LinkedOut is the
              binary code of career success, so hop on and let's optimize our
              professional lives together!
            </p>
          </blockquote>

          <blockquote class="rounded-lg bg-gray-100 p-8">
            <div class="flex items-center gap-4">
              <img
                alt="Jian Yang"
                src={jian}
                class="h-16 w-16 rounded-full object-cover"
              />
              <p class="mt-1 text-lg font-medium text-gray-700">Jian Yang</p>
            </div>

            <p class="line-clamp-2 sm:line-clamp-none mt-4 text-gray-500">
              I like LinkedOut for making good professional friend and find job
              chance. But, I cannot no see Erich Blachman there, always talk too
              much about self and make noise. He make LinkedOut not so good
              sometimes. But I try hard to not look at him, think more of good
              things in LinkedOut. I use strong tool, meet smart people, and
              learn many things. So, even with Erich trouble, LinkedOut still
              can give good things to me for work and connection.
            </p>
          </blockquote>
        </div>
      </div>
    </section>
  );
}

export default Testimonial;
