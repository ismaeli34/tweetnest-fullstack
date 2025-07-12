import React from "react";
import RepeatIcon from "@mui/icons-material/Repeat";
import { useNavigate } from "react-router-dom";
import { Avatar } from "@mui/material";
import { Button } from "@mui/material";
import Menu from "@mui/material/Menu";
import MenuItem from "@mui/material/MenuItem";
import MoreHorizIcon from "@mui/icons-material/MoreHoriz";
import ChatBubbleIcon from "@mui/icons-material/ChatBubble";
import FavoriteBorderIcon from "@mui/icons-material/FavoriteBorder";
import FileUploadIcon from "@mui/icons-material/FileUpload";
import BarChartIcon from "@mui/icons-material/BarChart";
import FavoriteIcon from "@mui/icons-material/Favorite";
import { FavoriteOutlined } from "@mui/icons-material";
import { useState } from "react";
import ReplyModal from "./ReplyModal";

const TweetCard = () => {
  const navigate = useNavigate();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const [openReplyModal, setOpenReplyModal] = useState(false);
  const handleOpenReplyModal = () => {
    console.log("reply modal clicked");
    
    setOpenReplyModal(true)
};
  const handleCloseReplyModal = () => setOpenReplyModal(false);




  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleDeleteTweet = () => {
    console.log("delete tweet");
    handleClose();
  };

  const handleEditTweet = () => {};

  const handleLikeTweet = () => {};

  const handleCreateRetweet = () => {
    console.log("handle create retweet");
  };

  return (
    <React.Fragment>
      {/* <div className='flex items-center font-semibold text-gray-700 py-2'>
                <RepeatIcon />
            </div> */}

      <div className="flex space-x-5">
        <Avatar
          onClick={() => navigate(`/profile/${6}`)}
          className="cursor-pointer"
          alt="username"
          src="https://images.pexels.com/photos/30811033/pexels-photo-30811033.jpeg?_gl=1*1qk7kof*_ga*MTY3NDA4MzE2Ny4xNzUxMDEzMDQ5*_ga_8JE65Q40S6*czE3NTEwMTMwNDkkbzEkZzEkdDE3NTEwMTMwOTMkajE2JGwwJGgw"
        />

        <div className="w-90">
          <div className="flex justify-between items-center">
            <div className="flex cursor-pointer items-center space-x-2">
              <span className="font-semibold">Learn with Ronney </span>
              <span className="text-gray-600">@ronneyismael . 2m</span>
              <img
                className="ml-2 w-5 h-5"
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/1024px-Twitter_Verified_Badge.svg.png?20230807021642"
                alt=""
              />
            </div>

            <div>
              <Button
                id="basic-button"
                aria-controls={open ? "basic-menu" : undefined}
                aria-haspopup="true"
                aria-expanded={open ? "true" : undefined}
                onClick={handleClick}
              >
                <MoreHorizIcon />
              </Button>
              <Menu
                id="basic-menu"
                anchorEl={anchorEl}
                open={open}
                onClose={handleClose}
                slotProps={{
                  list: {
                    "aria-labelledby": "basic-button",
                  },
                }}
              >
                <MenuItem onClick={handleDeleteTweet}>Delete</MenuItem>
                <MenuItem onClick={handleEditTweet}>Edit</MenuItem>
              </Menu>
            </div>
          </div>

          <div className="mt-2">
            <div
              onClick={() => navigate(`/tweet/${3}`)}
              className="cursor-pointer"
            >
              <p className="mb-2 p-0">
                {" "}
                Tweet Nest Full Stack Project with Springboot and react
              </p>
              <img
                src="https://images.pexels.com/photos/1181467/pexels-photo-1181467.jpeg?_gl=1*18ojy7x*_ga*MTY3NDA4MzE2Ny4xNzUxMDEzMDQ5*_ga_8JE65Q40S6*czE3NTExMDcyNDgkbzIkZzEkdDE3NTExMDcyODQkajI0JGwwJGgw"
                className="w-[28rem] border border-gray-400 p-5 rounded-md"
                alt=""
              />
            </div>

            <div className="py-5 flex flex-wrap justify-between items-center">
              <div className="space-x-3 flex items-center text-gray-600">
                <ChatBubbleIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModal}
                />
                <p>43</p>
              </div>

              <div
                className={`${
                  true ? "text-pink-600" : "text-gray-600"
                } space-x-3 flex items-center`}
              >
                {true ? (
                  <FavoriteIcon onClick={handleCreateRetweet} />
                ) : (
                  <FavoriteOutlined
                    onClick={handleLikeTweet}
                    className="cursor-pointer"
                  />
                )}
                <p>54</p>
              </div>
              <div className="space-x-3 flex items-center text-gray-600">
                <BarChartIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModal}
                />
                <p>42</p>
              </div>

              <div className="space-x-3 flex items-center text-gray-600">
                <FileUploadIcon
                  className="cursor-pointer"
                  onClick={handleOpenReplyModal}
                />
                <p>41</p>
              </div>
            </div>
          </div>
        </div>
      </div>

      <section>
        <ReplyModal open={openReplyModal} handleClose={handleCloseReplyModal} />
      </section>
    </React.Fragment>
  );
};

export default TweetCard;
