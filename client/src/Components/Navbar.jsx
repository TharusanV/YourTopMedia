import React, { useState, useEffect } from 'react';

import hamburgerIcon from '../Assets/Hamburger_icon.svg'


const Navbar = () => {
  
  return (
    <div className='navbar-container'>
      <div className='navbar-section'>
        <img className='navbar-hamburger-menu' src={hamburgerIcon} alt="Hamburger Menu Icon"/>
        <p className='navbar-title'>Title</p>
        <p className='navbar-secondary-title'>Home</p>
      </div>

      <div className='navbar-section'>
        <div className="navbar-search-bar">
          <input type="text" placeholder="Search" />
        </div>
      </div>

      <div className='navbar-section'>

      </div>
    </div>
  )
}

export default Navbar