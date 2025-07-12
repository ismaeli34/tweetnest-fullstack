import React from 'react'
import { navigationMenu } from './NavigationMenu'
import { useNavigate } from 'react-router-dom'
import { Button } from '@mui/material'
import { Avatar } from '@mui/material'
import MoreHorizIcon from '@mui/icons-material/MoreHoriz';

import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';


const Navigation = () => {

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);
    const handleClick = (event) => {
        setAnchorEl(event.currentTarget);
    };
    const handleClose = () => {
        setAnchorEl(null);
    };
    const navigate = useNavigate();
    const handleLogout = () =>{
        console.log("logout");
        handleClose();
    }
    return (
        <div className='h-screen sticky top-0'>
            <div >
                <div className='py-5'>
                    <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="30" height="30" viewBox="0 0 24 24">
                        <path d="M 2.8671875 3 L 9.7363281 12.818359 L 2.734375 21 L 5.3808594 21 L 10.919922 14.509766 L 15.460938 21 L 21.371094 21 L 14.173828 10.697266 L 20.744141 3 L 18.138672 3 L 12.996094 9.0097656 L 8.7988281 3 L 2.8671875 3 z"></path>
                    </svg>
                </div>
                <div className='space-y-6'>
                    {navigationMenu.map((item) => <div className='cursor-pointer flex space-x-3 items-center'
                        onClick={() => item.title === "Profile" ? navigate(`/profile/${5}`) : navigate(item.path)}>
                        {item.icon}
                        <p className='text-xl'>{item.title}</p>
                    </div>
                    )}
                </div>

                <div className='py-10'>
                    <Button variant='contained' sx={{ width: "100%", borderRadius: "29px", py: "15px", bgcolor: "#1e88e5" }}>
                        Tweet
                    </Button>

                </div>

                <div className='flex items-center justify-between'>
                    <div className='flex items-center space-x-3'>

                        <Avatar alt='username' src='' />

                        <div>
                            <span>Ronney Ismael</span>
                            <br />
                            <span className='opacity-70'> @ronneyismael</span>
                        </div>

                        <MoreHorizIcon />

                        <Button
                            id="basic-button"
                            aria-controls={open ? 'basic-menu' : undefined}
                            aria-haspopup="true"
                            aria-expanded={open ? 'true' : undefined}
                            onClick={handleClick}
                        >
                            More
                        </Button>
                        <Menu
                            id="basic-menu"
                            anchorEl={anchorEl}
                            open={open}
                            onClose={handleClose}
                            slotProps={{
                                list: {
                                    'aria-labelledby': 'basic-button',
                                },
                            }}
                        >
                            <MenuItem onClick={handleLogout}>Logout</MenuItem>
                      
                        </Menu>

                    </div>

                </div>
            </div>
        </div>
    )
}

export default Navigation