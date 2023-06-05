import React from "react";
import UserSearch from "./UserSearch";
import ConnectionItem from "./ConnectionItem";
import { useConnection } from "../../../../contexts/ConnectionContext";

function NewConnection() {
  const { connectionSuggestions } = useConnection();
  const connections = connectionSuggestions.map((connection) => {
    return (
      <div className="mt-2">
        <ConnectionItem
          id={connection.user_ID}
          userImage={connection.image}
          userName={connection.name + " " + connection.surname}
          userTitle={connection.job_title}
        />
      </div>
    );
  });

  return (
    <div className="max-w-screen-lg w-screen mx-auto px-2">
      <div className="p-4 ring-1 rounded-2xl ring-orange-200">
        <UserSearch />
      </div>
      <div className="mt-4">{connections}</div>
    </div>
  );
}

export default NewConnection;
