import { useState } from 'react'
import Navbar from './Components/Navbar'
import Home from './Pages/Home'
import FindFilmSection from './Pages/FindFilmSection'
import FindTVShowsSection from './Pages/FindTVShowsSection'
import FindAnimeSection from './Pages/FindAnimeSection'
import Favourites from './Pages/Favourites'


import { BrowserRouter, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';


//npm run dev

function App() {

  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/FindMovies" element={<FindFilmSection />} />
          <Route path="/FindTVShows" element={<FindTVShowsSection />} />
          <Route path="/FindAnimation" element={<FindAnimeSection />} />
          <Route path="/Favourites" element={<Favourites />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
