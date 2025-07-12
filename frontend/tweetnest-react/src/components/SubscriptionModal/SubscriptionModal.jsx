import * as React from "react";
import Backdrop from "@mui/material/Backdrop";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import Fade from "@mui/material/Fade";
import Button from "@mui/material/Button";
import { IconButton } from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import FiberManualRecordIcon from "@mui/icons-material/FiberManualRecord";
import Typography from "@mui/material/Typography";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  outline: "none",
  borderRadius: 4,
  boxShadow: 24,
  p: 4,
};

const features = ["Basic Features: Post tweets, reply, like, and retweet.",
    "Video Limits: Can upload short videos (up to 2 min 20 sec).",
    "Verification: No blue checkmark (unless legacy verified)",
    "Support: Basic customer support."];

export default function SubscriptionModal({handleClose,open}) {

  const [plan, setPlan] = React.useState("Annually");
  return (
    <div>
      <Button onClick={open}>Open modal</Button>
      <Modal
        aria-labelledby="transition-modal-title"
        aria-describedby="transition-modal-description"
        open={open}
        onClose={handleClose}
        closeAfterTransition
        slots={{ backdrop: Backdrop }}
        slotProps={{
          backdrop: {
            timeout: 500,
          },
        }}
      >
        <Box sx={style}>
          <div className="flex items-center space-x-3">
            <IconButton onClick={handleClose} aria-label="delete">
              <CloseIcon />
            </IconButton>
          </div>

          <div className="flex justify-center py-10">
            <div className="w-[80%] space-y-10 ">
              <div className="p-5 rounded-md flex items-center justify-between bg-slate-400 shadow-lg">
                <h1 className="text-md pr-5">
            Tweetnest Subscription Plans 
                </h1>
                <img
                  className="w-10 h-10"
                  src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Twitter_Verified_Badge.svg/1024px-Twitter_Verified_Badge.svg.png?20230807021642"
                  alt=""
                />
              </div>

              <div className="flex justify-between border rounded-full px-5 py-5 bg-white-700  border-black">
                <div>
                  <span
                    onClick={() => setPlan("Annually")}
                    className={`${
                      plan === "Annually" ? "text-black" : "text-gray-400"
                    } cursor-pointer`}
                  >
                    Annually
                  </span>
                  <span className="text-green-500 text-sm ml-5">SAVE 12%</span>
                </div>

                <p
                  onClick={() => setPlan("monthly")}
                  className={`${
                    plan === "monthly" ? "text-black" : "text-gray-400"
                  } cursor-pointer`}
                >
                  Monthly
                </p>
              </div>

              <div className="space-y-3">
                {features.map((item) => (
                  <div className="flex items-center space-x-5">
                    <FiberManualRecordIcon
                      sx={{ width: "7px", height: "7px" }}
                    />
                    <p className="text-sm">
                     {item}
                    </p>
                  </div>
                ))}
              </div>

              <div className="cursor-pointer flex justify-center bg-gray-900 text-white rounded-full px-5 py-3">
                <span className="line-through italic">€ 25</span>
                <span className="px-5 ">€ 20/month</span>

              </div>
            </div>
          </div>
        </Box>
      </Modal>
    </div>
  );
}
