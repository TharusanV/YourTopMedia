import { useNavigate, useLocation } from "react-router-dom";
import showBG from '../Assets/tvbg.jpg'
import LikeIcon from '../Assets/Like_Icon.svg';
import {Row, Col,Container, Card} from 'react-bootstrap';
import { useState } from "react";


const SearchSection = () => {
  const [isHovered, setIsHovered] = useState(false);

 // const location = useLocation();
 // const searchValue = location.state;

  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };

  return (
    <div className="search-container">
      <Container className='search-section'>
          <hr className='title-line'/>
          <div className='top-media-section-header'>
            <h2>Search</h2> 
          </div>
          <Row style={{paddingTop: "10px"}}>
            <Col sm={6} md={4} lg={3}>
              <Card onMouseEnter={() => setIsHovered(true)} onMouseLeave={() => setIsHovered(false)}>
                <Card.Img src={showBG} alt="Card image" />
                {isHovered && (
                  <Card.ImgOverlay className="search-card-overlay" >
                    <Card.Img src={LikeIcon} alt="Like image" />
                  </Card.ImgOverlay>
                )}
              </Card>
              <Card.Title className="search-card-title">Title</Card.Title>
            </Col>
          
          </Row>
        </Container>
    </div>
  )
}

export default SearchSection