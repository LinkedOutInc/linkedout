import React, { useState, useEffect, useRef } from "react";
import { useProfile } from "../../../../../contexts/ProfileContext";

const EditProfile = () => {
  const { user } = useProfile();
  const [isOpen, setIsOpen] = useState(false);
  const popupRef = useRef(null);
  const [first, setFirst] = useState(user?.name);
  const [last, setLast] = useState(user?.surname);
  const [job_title, setJob_title] = useState(user?.job_title);
  const [location, setLocation] = useState(user?.location);
  const [image, setImage] = useState(user?.image);
  const { editProfile } = useProfile();

  const handleOpen = () => {
    setIsOpen(true);
  };

  const handleClose = () => {
    setIsOpen(false);
  };

  useEffect(() => {
    const handleOutsideClick = (event) => {
      if (popupRef.current && !popupRef.current.contains(event.target)) {
        handleClose();
      }
    };

    if (isOpen) {
      document.addEventListener("mousedown", handleOutsideClick);
    }

    return () => {
      document.removeEventListener("mousedown", handleOutsideClick);
    };
  }, [isOpen]);

  const handleSubmit = (e) => {
    e.preventDefault();
    editProfile({
      name: first,
      surname: last,
      title: job_title,
      location: location,
      image: image,
      resume: user.resume,
    });
    handleClose();
  };

  return (
    <div className="">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        fill="none"
        viewBox="0 0 24 24"
        strokeWidth={1.5}
        stroke="currentColor"
        className="w-5 h-5 cursor-pointer mt-1"
        onClick={handleOpen}
      >
        <path
          strokeLinecap="round"
          strokeLinejoin="round"
          d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L6.832 19.82a4.5 4.5 0 01-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 011.13-1.897L16.863 4.487zm0 0L19.5 7.125"
        />
      </svg>

      {isOpen && (
        <div className="fixed top-0 left-0 h-full w-full bg-black bg-opacity-50 flex justify-center items-center">
          <div ref={popupRef} className="bg-white w-96 p-6 rounded-2xl">
            <div className="flex justify-between">
              <h2 className="text-2xl font-bold mb-4">Edit Profile</h2>
              <div className="cursor-pointer" onClick={handleClose}>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-6 h-6"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M6 18L18 6M6 6l12 12"
                  />
                </svg>
              </div>
            </div>
            {/* Form content goes here */}
            <form className="flex flex-col gap-6">
              <div>
                <h2 className="text-lg font-bold">First Name</h2>
                <input
                  className="border rounded-lg p-1 mt-1"
                  value={first}
                  onChange={(e) => setFirst(e.target.value)}
                />
              </div>
              <div>
                <h2 className="text-lg font-bold">Last Name</h2>
                <input
                  className="border rounded-lg p-1 mt-1"
                  value={last}
                  onChange={(e) => setLast(e.target.value)}
                />
              </div>
              <div>
                <h2 className="text-lg font-bold">Title</h2>
                <input
                  className="border rounded-lg p-1 mt-1"
                  value={job_title}
                  onChange={(e) => setJob_title(e.target.value)}
                />
              </div>
              <div>
                <h2 className="text-lg font-bold">Location</h2>
                <input
                  className="border rounded-lg p-1 mt-1"
                  value={location}
                  onChange={(e) => setLocation(e.target.value)}
                />
              </div>
              <div>
                <h2 className="text-lg font-bold">Profile Photo</h2>
                <input
                  className="border rounded-lg p-1 mt-1"
                  value={image}
                  onChange={(e) => setImage(e.target.value)}
                />
              </div>
              <div className="flex justify-end">
                <button
                  type="submit"
                  onClick={handleSubmit}
                  className="bg-linkedout text-white font-semibold py-2 px-4 rounded-2xl hover:bg-white hover:text-linkedout hover:ring-1 ring-inset hover:ring-linkedout"
                >
                  Save
                </button>
              </div>
            </form>
            <button
              className="absolute top-2 right-2 text-gray-500 hover:text-gray-700"
              onClick={handleClose}
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                className="h-6 w-6"
                viewBox="0 0 20 20"
                fill="currentColor"
              >
                <path
                  fillRule="evenodd"
                  d="M12.72 7.469l-5.469 5.469a.75.75 0 11-1.061-1.061l5.469-5.469a.75.75 0 111.061 1.061zM7.469 12.72L12.72 7.47a.75.75 0 111.061 1.061l-5.469 5.469a.75.75 0 11-1.061-1.06l5.469-5.47-5.469 5.47a.75.75 0 01-1.061 0z"
                  clipRule="evenodd"
                />
              </svg>
            </button>
          </div>
        </div>
      )}
    </div>
  );
};

export default EditProfile;
