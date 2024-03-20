import axios from "axios";
import { API_URL } from "../../Utilidades";

const registrarUsuario = async(carga) => {
    const respuesta = await axios.post(`${API_URL}/usuario/registro`, carga);
    return respuesta.data;
}

export default {
    registrarUsuario,
}