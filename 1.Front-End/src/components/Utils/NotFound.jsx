import React from "react";
import "./not-found.css";

function NotFound() {
  return (
    <div className="container">
      <div className="not-container">
        <div className="img-container">
          <img src="sapling.png" alt="sapling"/>
        </div>
        <h2>Not Found</h2>
      </div>
    </div>
  );
}

export default NotFound;
