import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import CloseIcon from "@mui/icons-material/Close";
import { useFormik } from "formik";
import { Avatar, IconButton, TextField } from "@mui/material";
import Modal from "@mui/material/Modal"; 

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  p: 4,
  outline: "none",
};

const ProfileModal = ({open,handleClose}) => {
 // const [open, setOpen] = React.useState(false);
  const [uploading, setUploading] = React.useState(false);

  const handleSubmit = (values) => {
    console.log("handle submit", values);
  };

  const formik = useFormik({
    initialValues: {
      fullName: "",
      website: "",
      location: "",
      bio: "",
      backgroundImage: "",
      image: "",
    },
    onSubmit: handleSubmit,
  });

  const handleImageChange = (event) => {
    setUploading(true);
    const { name } = event.target;
    const file = event.target.files[0];
    formik.setFieldValue(name, file);
    setUploading(false);
  };

  return (
    <div>
      return (
      <div>
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <Box sx={style}>
            <form onSubmit={formik.handleSubmit} action="">
              <div className="flex items-center justify-between">
                <div className="flex items-center space-x-3">
                  <IconButton onClick={handleClose} aria-label="delete">
                    <CloseIcon />
                  </IconButton>
                  <p className="">Edit Profile</p>
                </div>
                <Button type="submit">Save</Button>
              </div>

              <div className=" hideScrollBar overflow-y-scroll overflow-x-hidden h-[80vh]">
                <React.Fragment>
                  <div className="w-full">
                    <div className="relative">
                      <img
                        className="w-full h-[12rem] object-cover object-center"
                        src="https://www.offsoho.com/images/NYC_000021208828-2100-980.jpg"
                        alt=""
                      />
                      <input
                        className="absolute top-0 left-0 w-full h-full opacity-0 cursor-pointer"
                        onChange={handleImageChange}
                        name="backgroundImage"
                        type="file"
                      />
                    </div>
                  </div>
                  <div className="w-full transform -translate-y-20 ml-4 h-[6rem]">
                    <div className="relative">
                      <Avatar
                        sx={{
                          width: "10rem",
                          height: "10rem",
                          border: "4px solid white",
                        }}
                      ></Avatar>
                      <input
                        className="absolute top-0 left-0 w-[10rem] h-full opacity-0 cursor-pointer"
                        onChange={handleImageChange}
                        type="file"
                      />
                    </div>
                  </div>
                </React.Fragment>
                <div className="space-y-3">
                  <TextField
                    fullWidth
                    id="fullName"
                    name="fullName"
                    label="Full Name"
                    value={formik.values.fullName}
                    onChange={formik.handleChange}
                    error={
                      formik.touched.fullName && Boolean(formik.errors.fullName)
                    }
                    helperText={
                      formik.touched.fullName && formik.errors.fullName
                    }
                  />

                  <TextField
                    fullWidth
                    id="bio"
                    name="bio"
                    label="Bio"
                    rows={4}
                    value={formik.values.bio}
                    onChange={formik.handleChange}
                    error={formik.touched.bio && Boolean(formik.errors.bio)}
                    helperText={formik.touched.bio && formik.errors.bio}
                  />

                  <TextField
                    fullWidth
                    id="website"
                    name="website"
                    label="Website"
                    rows={4}
                    value={formik.values.website}
                    onChange={formik.handleChange}
                    error={
                      formik.touched.website && Boolean(formik.errors.website)
                    }
                    helperText={formik.touched.website && formik.errors.website}
                  />

                  <TextField
                    fullWidth
                    id="location"
                    name="location"
                    label="Location"
                    rows={4}
                    value={formik.values.location}
                    onChange={formik.handleChange}
                    error={
                      formik.touched.location && Boolean(formik.errors.location)
                    }
                    helperText={
                      formik.touched.location && formik.errors.location
                    }
                  />

                  <div className="my-3">
                    <p className="text-lg">Birth day . Edit</p>
                    <p className="text-2xl">October 26,1999</p>
                  </div>
                  <p className="py-3 text-lg">Edit Professional Profile</p>
                </div>
              </div>
            </form>
          </Box>
        </Modal>
      </div>
      );
    </div>
  );
};

export default ProfileModal;
