import React, { useState, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import hamburgerIcon from '../Assets/Hamburger_icon.svg'


const Navbar = () => {
  const [searchValue, setSearchValue] = useState('');
  const [searchData, setSearchData] = useState([]);

  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    //navigate(path, { state: data });
    navigate(path);
  };

  const handleKeyPress = (event) => {
    if (event.key === 'Enter') {
      //fetchData(searchValue);
      //router('Search', searchData);
      router('Search');
    }
  };

  const fetchData = (searchValue) => {
    fetch(`https://online-movie-database.p.rapidapi.com/title/v2/find?title=+${searchValue}`, {
      "method": "GET",
      "headers": {
        'X-RapidAPI-Key': process.env.REACT_APP_API_KEY,
        'X-RapidAPI-Host': process.env.REACT_APP_HOST,
      }
    })
      .then(response => {
        return response.json();
      })
      .then(data => {
        setSearchData(data.d);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handleChange = (event) => {
    setSearchValue(event.target.value);
  };


  return (
    <div className='navbar-container'>
      <div className='navbar-section'>
        <img className='navbar-hamburger-menu' src={hamburgerIcon} alt="Hamburger Menu Icon"/>
        <p className='navbar-title'>Title</p>
        <p className='navbar-secondary-title'>Home</p>
      </div>

      <div className='navbar-section'>
        <div className="navbar-search-bar">
          <input type="text" placeholder="Search" value={searchValue} onChange={handleChange} onKeyDown={handleKeyPress}/>
        </div>
      </div>

      <div className='navbar-section'>

      </div>
    </div>
  )
}

export default Navbar