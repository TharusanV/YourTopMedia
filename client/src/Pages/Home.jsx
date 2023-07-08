import React from 'react'
import Navbar from '../Components/Navbar'
import filmBG from '../Assets/filmbg.jpg'
import showBG from '../Assets/tvbg.jpg'
import animeBG from '../Assets/animebg.jpg'
import {Row, Col,Container, Card} from 'react-bootstrap';
import { useNavigate } from "react-router-dom";


const Home = () => {
  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };
  
  return (
    <>
    <div className='home-container'>
      <div className='media-header-section'>
        <div className='media-card'>
          <img src={showBG} alt="Card image" />
          <div className='media-card-overlay'>
            <div className='media-card-overlay-title'>TV Shows</div>
            <div className='media-card-overlay-description'>View your watched TV Shows</div>  
          </div>
        </div>

        <div className='media-card'>
          <img src={filmBG} alt="Card image" />
          <div className='media-card-overlay'>
            <div className='media-card-overlay-title'>Films</div>
            <div className='media-card-overlay-description'>View your watched Films</div>  
          </div>
        </div>

        <div className='media-card'>
          <img src={animeBG} alt="Card image" />
          <div className='media-card-overlay'>
            <div className='media-card-overlay-title'>Animation</div>
            <div className='media-card-overlay-description'>View your watched Animations</div>  
          </div>
        </div>
      </div>

      <div className='top-media-section'>
        <Container className='top-tvshow-section'>
          <hr className='title-line'/>
          <div className='top-media-section-header'>
            <h2>Your Top 5 TV Shows</h2> 
          </div>
          <Row>
            <Col>
              <Card>
                <Card.Img src={showBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>
          </Row>
        </Container>

        <Container className='top-film-section'>
          <hr className='title-line'/>
          <div className='top-media-section-header'>
            <h2>Your Top 5 Films</h2> 
          </div>
          <Row>
            <Col>
              <Card>
                <Card.Img src={showBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>
          </Row>
        </Container>

        <Container className='top-Anime-section'>
          <hr className='title-line'/>
          <div className='top-media-section-header'>
            <h2>Your Top 5 Animation</h2> 
          </div>
          <Row>
            <Col>
              <Card>
                <Card.Img src={showBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={filmBG} alt="Card image" />
              </Card>
            </Col>

            <Col>
              <Card>
                <Card.Img src={animeBG} alt="Card image" />
              </Card>
            </Col>
          </Row>
        </Container>
      </div>
    </div>
    </>
  )
}

export default Home