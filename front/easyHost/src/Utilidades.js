export const API_URL = "http://localhost:8080/api";
export function recortarEspaciosEnBlanco(texto) {
  //Eliminar espacios en blanco al inicio y al final
  texto = texto.trim();

  //Retornar cadena sin más de un espacio en blanco entre palabras
  return texto.replace(/\s+/g, " ");
}

export function sonSoloLetras(texto) {
  return /^[a-zA-ZáéíóúüñÑ\s]+$/.test(texto);
}

//Validar que solo permita valores alfanumericos (letras y numeros)
export function alfanumerico(texto) {
  return /^[a-zA-Z0-9]+$/.test(texto);
}
