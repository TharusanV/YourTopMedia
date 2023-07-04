import { useNavigate } from "react-router-dom";

const FindTVShowsSection = () => {
  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };

  return (
    <div>FindTVShowsSection</div>
  )
}

export default FindTVShowsSection