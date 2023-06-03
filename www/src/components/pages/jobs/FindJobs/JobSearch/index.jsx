import React, { useState } from "react";

const JobSearch = ({ onSearch, onFilter }) => {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedFilter, setSelectedFilter] = useState("all");

  const handleSearch = () => {
    onSearch(searchTerm);
  };

  const handleFilter = (event) => {
    setSelectedFilter(event.target.value);
    onFilter(event.target.value);
  };

  return (
    <div className="flex sm:flex-row flex-col sm:space-x-4 space-y-2 sm:space-y-0">
      <input
        type="text"
        placeholder="Search jobs..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        onSubmit={() => handleSearch()}
        className="p-2 border border-gray-300 rounded-xl flex-grow focus-within:border-transparent focus-within:ring-1 focus-within:ring-linkedout outline-none"
      />
      <select
        value={selectedFilter}
        onChange={handleFilter}
        className="border border-gray-300 rounded-2xl p-2"
      >
        <option value="all">All Jobs</option>
        <option value="software">Software</option>
        <option value="product">Product</option>
        <option value="data">Data</option>
      </select>
      <select
        value={selectedFilter}
        onChange={handleFilter}
        className="border border-gray-300 rounded-2xl p-2"
      >
        <option value="all">All Types</option>
        <option value="onsite">On-site</option>
        <option value="remote">Remote</option>
        <option value="hybrid">Hybrid</option>
      </select>
      <select
        value={selectedFilter}
        onChange={handleFilter}
        className="border border-gray-300 rounded-2xl p-2"
      >
        <option value="all">All Locations</option>
        <option value="istanbul">Istanbul</option>
        <option value="ankara">Ankara</option>
        <option value="izmir">Izmir</option>
      </select>
      <button
        onClick={handleSearch}
        className="bg-white ring-1 ring-inset ring-linkedout hover:text-white font-semibold py-2 px-4 rounded-2xl hover:bg-linkedout text-linkedout"
      >
        Search
      </button>
    </div>
  );
};

export default JobSearch;
