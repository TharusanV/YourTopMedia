import React, { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import hamburgerIcon from '../Assets/Hamburger_icon.svg'

const Navbar = ({ onSearch }) => {

  const [searchValue, setSearchValue] = useState('');

  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };


  const handleChange = (event) => {
    setSearchValue(event.target.value);
  };


  const handleKeyPress = (event) => {
    if (event.key === 'Enter') {
      if (window.location.pathname !== '/Search') {
        router("Search");
      }

      onSearch(searchValue);
    }
  };

  return (
    <>
      <div className='navbar-container'>
        <div className='navbar-section'>
          <img className='navbar-hamburger-menu' src={hamburgerIcon} alt="Hamburger Menu Icon"/>
          <p className='navbar-title'>Title</p>
          <p className='navbar-secondary-title'>Home</p>
        </div>

        <div className='navbar-section'>
          <div className="navbar-search-bar">
            <input type="text" placeholder="Search" value={searchValue} onChange={handleChange} onKeyDown={handleKeyPress} />
          </div>
        </div>

        <div className='navbar-section'>
    
        </div>
      </div>
    </>
  )
}

export default Navbar