import { useState } from 'react'
import Navbar from './Components/Navbar'
import Home from './Pages/Home'
import FindFilmSection from './Pages/FindFilmSection'
import FindTVShowsSection from './Pages/FindTVShowsSection'
import FindAnimeSection from './Pages/FindAnimeSection'
import SearchSection from './Pages/SearchSection';

import { BrowserRouter, Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';

//npm run dev

function App() {

  const [searchQuery, setSearchQuery] = useState('');

  const handleSearch = (query) => {
    setSearchQuery(query);
  };

  return (
    <>
      <BrowserRouter>
        <Navbar onSearch={handleSearch} />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/YourMovies" element={<FindFilmSection />} />
          <Route path="/YourTVShows" element={<FindTVShowsSection />} />
          <Route path="/YourAnimations" element={<FindAnimeSection />} />
          <Route path="/Search" element={<SearchSection searchQuery={searchQuery}/>} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
