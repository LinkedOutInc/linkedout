import React from "react";

function InfoCard({ title, amount, icon }) {
  return (
    <div>
      <article class="flex items-end justify-between rounded-lg border border-gray-100 bg-white p-6">
        <div class="flex items-center gap-4">
          <span class="hidden rounded-full bg-gray-100 p-2 text-gray-600 sm:block">
            {icon}
          </span>

          <div>
            <p class="text-sm text-gray-500">{title}</p>
            <p class="text-2xl font-medium text-gray-900">{amount}</p>
          </div>
        </div>
      </article>
    </div>
  );
}

export default InfoCard;
