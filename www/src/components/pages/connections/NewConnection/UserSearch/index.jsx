import React, { useState } from "react";

const UserSearch = ({ onSearch, onFilter }) => {
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
    <div className="flex flex-row space-x-4">
      <input
        type="text"
        placeholder="Search users..."
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        onSubmit={() => handleSearch()}
        className="p-2 border border-gray-300 rounded-xl flex-grow focus:border-linkedout"
      />
      <select
        value={selectedFilter}
        onChange={handleFilter}
        className="border border-gray-300 rounded-2xl p-2"
      >
        <option value="all">All Users</option>
        <option value="recruiters">Recruiters</option>
        <option value="cexpert">Career Experts</option>
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

export default UserSearch;
