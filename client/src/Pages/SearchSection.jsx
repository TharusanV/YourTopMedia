import { useNavigate} from "react-router-dom";
import LikeIcon from '../Assets/Like_Icon.svg';
import {Row, Col,Container, Card} from 'react-bootstrap';
import { useState, useEffect } from "react";
import axios from "axios";


const SearchSection = ({ searchQuery}) => {
  const [hoveredColumn, setHoveredColumn] = useState(null);
  
  const [searchData, setSearchData] = useState([]);
  
  const [searchType, setSearchType] = useState('')

  const mediaTypes = [{name:"Film"}, {name:"Anime"}, {name:"TVShows"}];

  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };

  const addToFavMedia = (item) => {
    if(searchType==="Film"){
      axios
      .post("/ratedFilms", {
        ratedFilmCustomID: item.id,
        ratedFilmName: item.title,
        ratedFilmImage: item.image.url,
        ratedFilmRating: 0,
        ratedFilmDescription: "",
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
    }
    else if(searchType==="Anime"){
      axios
      .post("/ratedAnimes", {
        ratedAnimeCustomID: item.id,
        ratedAnimeName: item.title,
        ratedAnimeImage: item.image.url,
        ratedAnimeRating: 0,
        ratedAnimeDescription: "",
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
    }
    else{
      axios
      .post("/ratedTVShows", {
        ratedTVShowCustomID: item.id,
        ratedTVShowName: item.title,
        ratedTVShowImage: item.image.url,
        ratedTVShowRating: 0,
        ratedTVShowDescription: "",
      })
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
    }
  }

  const fetchData_All = (searchValue) => {
    fetch(`https://online-movie-database.p.rapidapi.com/title/v2/find?title=${encodeURIComponent(searchValue)}&limit=8&sortArg=moviemeter,asc`, {
      "method": "GET",
      "headers": {
        'X-RapidAPI-Key': `ddd`,
        'X-RapidAPI-Host': `online-movie-database.p.rapidapi.com`,
      }
    })
      .then(response => {
        return response.json();
      })
      .then(data => {
        console.log(data);
        setSearchData([]);
        setSearchData(data.results);
      })
      .catch(error => {
        console.error(error);
      });
  };


  const fetchData_Film = (searchValue) => {
    fetch(`https://online-movie-database.p.rapidapi.com/title/v2/find?title=${encodeURIComponent(searchValue)}&titleType=movie&limit=8&sortArg=moviemeter,asc`, {
      "method": "GET",
      "headers": {
        'X-RapidAPI-Key': `ddd`,
        'X-RapidAPI-Host': `online-movie-database.p.rapidapi.com`,
      }
    })
      .then(response => {
        return response.json();
      })
      .then(data => {
        console.log(data);
        setSearchData([]);
        setSearchData(data.results);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const fetchData_Anime = (searchValue) => {
    fetch(`https://online-movie-database.p.rapidapi.com/title/v2/find?title=${encodeURIComponent(searchValue)}&titleType=tvSeries&limit=8&sortArg=moviemeter%2Casc&genre=animation`, {
      "method": "GET",
      "headers": {
        'X-RapidAPI-Key': `ddd`,
        'X-RapidAPI-Host': `online-movie-database.p.rapidapi.com`,
      }
    })
      .then(response => {
        return response.json();
      })
      .then(data => {
        console.log(data);
        setSearchData([]);
        setSearchData(data.results);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const fetchData_TVShow = (searchValue) => {
    fetch(`https://online-movie-database.p.rapidapi.com/title/v2/find?title=${encodeURIComponent(searchValue)}&titleType=tvSeries&limit=8&sortArg=moviemeter,asc`, {
      "method": "GET",
      "headers": {
        'X-RapidAPI-Key': `ax`,
        'X-RapidAPI-Host': `online-movie-database.p.rapidapi.com`,
      }
    })
      .then(response => {
        return response.json();
      })
      .then(data => {
        console.log(data);
        setSearchData([]);
        setSearchData(data.results);
      })
      .catch(error => {
        console.error(error);
      });
  };

  const settingTopic = () => {
    var select = document.getElementById("mediaList");
    var value = select.options[select.selectedIndex].value;
    console.log(searchType);
    setSearchType(value);
    console.log(searchType);
  };

  useEffect(() => {
    if(searchType==="All"){
      fetchData_All(searchQuery);
    }
    else if(searchType==="Film"){
      fetchData_Film(searchQuery);
    }
    else if(searchType==="Anime"){
      fetchData_Anime(searchQuery);
    }
    else if(searchType==="TVShows"){
      fetchData_TVShow(searchQuery);
    }
    else{
      fetchData_All(searchQuery);
    }
  }, [searchQuery]);

  useEffect(() => {
    /*
    if(searchType==="All"){
      fetchData_All(searchQuery);
    }
    */
    if(searchType==="Film"){
      fetchData_Film(searchQuery);
    }
    else if(searchType==="Anime"){
      fetchData_Anime(searchQuery);
    }
    else if(searchType==="TVShows"){
      fetchData_TVShow(searchQuery);
    }
    else{
      fetchData_All(searchQuery);
    }
  }, [searchType]);

  return (
    <>
      <div className="search-container">
        <Container className='search-section'>
          <hr className='title-line'/>
          <div className='top-media-section-header'>
            <h2>Search</h2> 
          </div>
          <select id="mediaList" onChange={() => settingTopic()}>
            {mediaTypes.map((topics) => (
              <option value={topics.name} key={topics.name}>
                {topics.name}
              </option>
            ))}
          </select>
          <Row style={{paddingTop: "10px"}}>
            {searchData.map((item, index) => {
              const isColumnHovered = hoveredColumn === index;

              return(
                <Col key={index} sm={6} md={4} lg={3} style={{paddingBottom: "10px"}}>
                  <Card
                    onMouseEnter={() => setHoveredColumn(index)}
                    onMouseLeave={() => setHoveredColumn(null)}
                  >
                    {item.image && item.image.url && (
                      <Card.Img src={item.image.url} alt="Card image" />
                    )}
                    {isColumnHovered && (
                      <Card.ImgOverlay className="search-card-overlay">
                        <Card.Img src={LikeIcon} alt="Like image" onClick={() => addToFavMedia(item)}/>
                      </Card.ImgOverlay>
                    )}
                  </Card>
                  <Card.Title className="search-card-title">{item.title}</Card.Title>
                </Col>
              )
            })}
          </Row>
        </Container>
      </div>
    </>
  )
}

export default SearchSection

