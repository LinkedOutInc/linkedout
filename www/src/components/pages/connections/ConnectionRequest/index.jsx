import React from "react";
import RequestItem from "./RequestItem";
import { useConnection } from "../../../../contexts/ConnectionContext";

function ConnectionRequest() {
  const { connectionRequests } = useConnection();
  const requests = connectionRequests.map((request) => {
    return (
      <div className="mt-2">
        <RequestItem
          id={request.user_ID}
          userImage={request.userImage}
          userName={request.userName}
          userTitle={request.userTitle}
        />
      </div>
    );
  });

  return connectionRequests.length > 0 ? (
    requests
  ) : (
    <div className="text-center">No pending requests</div>
  );
}

export default ConnectionRequest;
