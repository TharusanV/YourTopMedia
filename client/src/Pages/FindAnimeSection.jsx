import { useNavigate } from "react-router-dom";

const FindAnimeSection = () => {
  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };

  return (
    <div>FindAnimeSection</div>
  )
}

export default FindAnimeSection