import React from "react";
import SideMenu from "./SideMenu";

function Admin() {
  return (
    <div className="w-sceen max-w-screen-lg mx-auto flex items-start justify-start">
      <SideMenu />
      <button>Generate</button>
    </div>
  );
}

export default Admin;
