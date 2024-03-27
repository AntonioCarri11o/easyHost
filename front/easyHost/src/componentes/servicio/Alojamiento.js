import axios from "axios";
import { API_URL } from "../../Utilidades";

const listarAlojamientos = async () => {
  const respuesta = await axios.get(`${API_URL}/alojamiento`);
  return respuesta.data;
};

export default {
  listarAlojamientos,
};
