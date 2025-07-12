import React from "react";
import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { Avatar } from "@mui/material";
import { useNavigate } from "react-router-dom";
import ImageIcon from "@mui/icons-material/Image";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import TagFacesIcon from "@mui/icons-material/TagFaces";
import { useFormik } from "formik";
import { SpaRounded } from "@mui/icons-material";
import { useState } from "react";
import { Button } from "@mui/material";

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

const ReplyModal = ({handleClose, open}) => {
  const [uploadingImage, setUploadingImage] = useState(false);
  const [selectImage, setSelectedImage] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (values) => {
    console.log("handle submit", values);
  };

  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
      twitId: 4,
    },
    onSubmit: handleSubmit,
  });

  const handleSelectImage = (event) => {
    setUploadingImage(true);

    const imgUrl = event.target.files[0];
    formik.setFieldValue("image", imgUrl);
    setSelectedImage(imgUrl);
    setUploadingImage(false);
  };
  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
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
                </div>
              </div>
            </div>
          </div>

          <section className={`py-10`}>
            <div className="flex space-x-5">
              <Avatar alt="username" src="" />
              <div className="w-full">
                <form onSubmit={formik.handleSubmit}>
                  <div>
                    <input
                      type="text"
                      name="content"
                      placeholder="What is happening "
                      className={`border-none outline-none text-xl bg-transparent`}
                      {...formik.getFieldProps("content")}
                    />
                    {formik.errors.content && formik.touched.content && (
                      <span className="text-red-500">
                        {formik.errors.content}
                      </span>
                    )}
                  </div>
                  <div>
                    <img src="" alt="" />
                  </div>
                  <div className="flex justify-between items-center mt-5">
                    <div className="flex space-x-5 items-center">
                      <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                        <ImageIcon className="text-[#1d9bf0]" />
                        <input
                          type="file"
                          name="imageFile"
                          className="hidden"
                          onChange={handleSelectImage}
                        />
                      </label>
                      <FmdGoodIcon className="text-[#1d9bf0]" />
                      <TagFacesIcon className="text-[#1d9bf0]" />
                    </div>
                    <div>
                      <Button
                        variant="contained"
                        type="submit"
                        sx={{
                          width: "w-full",
                          borderRadius: "29px",
                          paddingY: "8px",
                          paddingX: "20px",
                          bgcolor: "#1e88e5",
                        }}
                      >
                        Tweet
                      </Button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </section>
        </Box>
      </Modal>
    </div>
  );
};

export default ReplyModal;
