import React from "react";
import RequestItem from "./RequestItem";

// Too lazy to create a mock db for this so I'll just hardcode the data
// delete later and create a mock db
import gavin from "../../../../assets/gavin.jpg";
import richard from "../../../../assets/richard.jpg";
import jian from "../../../../assets/jian.jpg";

const requestData = [
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

function ConnectionRequest() {
  const requests = requestData.map((request) => {
    return (
      <div className="mt-2">
        <RequestItem
          userImage={request.userImage}
          userName={request.userName}
          userTitle={request.userTitle}
        />
      </div>
    );
  });

  return <div>{requests}</div>;
}

export default ConnectionRequest;
