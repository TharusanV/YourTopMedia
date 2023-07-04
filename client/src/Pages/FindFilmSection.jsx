import { useNavigate } from "react-router-dom";

const FindFilmSection = () => {
  let navigate = useNavigate();

  const router = (route) => {
    let path = "/" + route;
    navigate(path);
  };

  return (
    <div>FindFilmSection</div>
  )
}

export default FindFilmSection