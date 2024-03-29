import React from "react";
import UserSearch from "./UserSearch";
import TalentItem from "./TalentItem";

// Too lazy to create a mock db for this so I'll just hardcode the data
// delete later and create a mock db
import gavin from "../../../../assets/gavin.jpg";
import richard from "../../../../assets/richard.jpg";
import jian from "../../../../assets/jian.jpg";

const searchData = [
  // And suggestions if search is empty
  {
    userImage: gavin,
    userName: "Gavin Belson",
    userTitle: "CEO, Hooli",
  },
  {
    userImage: jian,
    userName: "Jian Yang",
    userTitle: "Software Engineer",
  },
];

function TalentList() {
  const connections = searchData.map((connection) => {
    return (
      <div className="mt-2">
        <TalentItem
          userImage={connection.userImage}
          userName={connection.userName}
          userTitle={connection.userTitle}
        />
      </div>
    );
  });

  return (
    <div className="max-w-screen-lg w-screen mx-auto px-2">
      <div className="flex flex-col">
        <UserSearch />
        <div className="mt-4">{connections}</div>
      </div>
    </div>
  );
}

export default TalentList;
