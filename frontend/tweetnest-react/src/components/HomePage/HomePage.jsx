import React from "react";
import { Grid } from "@mui/material";
import Navigation from "../Navigation/Navigation";
import HomeSection from "../HomeSection/HomeSection";
import RightPart from "../RightPart/RightPart";
import Profile from "../Profile/Profile";
import { Route, Routes } from "react-router-dom";
import TweetDetails from "../TweetDetails/TweetDetails";

const HomePage = () => {
  return (
    <div className="w-full">
      {/* <Grid container spacing={0} className="px-5 lg:px-36 ">
                <Grid item xs={0} lg={3} className="hidden lg:block relative">
                    <Navigation />
                </Grid>

                <Grid item xs={12} lg={6} className="relative  w-full max-w-2xl">
                    <HomeSection />
                </Grid>

                <Grid item xs={0} lg={3} className="hidden lg:block  relative">
                    <RightPart />
                </Grid>
            </Grid> */}

      <div className="flex justify-between w-full max-w-[1200px] mx-auto px-4">
        {/* Left Navigation */}

        <div className="w-[20%]">
          <Navigation />
        </div>
        {/* Center Content */}

        <div className="w-[50%] px-5 lg:px-9">
          <Routes>
            <Route path="/" element={<HomeSection />}></Route>
            <Route path="/home" element={<HomeSection />}></Route>
            <Route path="/profile/:id" element={<Profile />}></Route>
            <Route path="/tweet/:id" element={<TweetDetails />}></Route>

          </Routes>
          <HomeSection />
        </div>

        {/* Right Part */}

        <div className="w-[25%] hidden lg:block">
          <RightPart />
        </div>
      </div>
    </div>
  );
};
export default HomePage;
