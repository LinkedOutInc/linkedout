import React from "react";
import { useState, useRef } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../contexts/AuthContext";
import Init from "./init";
import Complete from "./complete";

function Signup() {
  const [formStep, setFormStep] = useState(0);
  const [signUpForm, setSignUpForm] = useState({
    name: "",
    surname: "",
    email: "",
    password: "",
    job_title: "",
    location: "",
    role: "ROLE_USER",
  });

  const steps = [
    <Init
      formStep={formStep}
      setFormStep={setFormStep}
      signUpForm={signUpForm}
      setSignUpForm={setSignUpForm}
    />,
    <Complete
      formStep={formStep}
      setFormStep={setFormStep}
      signUpForm={signUpForm}
      setSignUpForm={setSignUpForm}
    />,
  ];

  return steps[formStep];
}

export default Signup;
