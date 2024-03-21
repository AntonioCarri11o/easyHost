import axios from "axios";
import { API_URL } from "../../Utilidades";

const listarUsuarios = async() => {
    const respuesta = await axios.get(`${API_URL}/usuario`);
    return respuesta.data;
}


const registrarUsuario = async(carga) => {
    const respuesta = await axios.post(`${API_URL}/usuario/registro`, carga);
    return respuesta.data;
}
export default {
    listarUsuarios,
    registrarUsuario,
}