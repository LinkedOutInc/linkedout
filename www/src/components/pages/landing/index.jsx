import React from "react";
import { Hero, Testimonial } from "../../../components";

function Index() {
  localStorage.setItem("auth", 0);
  return (
    <div>
      <Hero />
      <Testimonial />
    </div>
  );
}

export default Index;
