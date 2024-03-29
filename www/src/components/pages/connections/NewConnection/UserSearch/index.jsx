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
    <div className="flex sm:flex-row flex-col sm:space-x-4 space-y-2 sm:space-y-0">
      <input
        type="text"
        placeholder="Search users..."
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
        <option value="all">All Users</option>
        <option value="recruiters">Recruiters</option>
        <option value="cexpert">Career Experts</option>
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
      <select
        value={selectedFilter}
        onChange={handleFilter}
        className="border border-gray-300 rounded-2xl p-2"
      >
        <option value="all">All Companies</option>
        <option value="fb">Facebook</option>
        <option value="amzn">Amazon</option>
        <option value="aapl">Apple</option>
        <option value="nflx">Netflix</option>
        <option value="googl">Google</option>
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
