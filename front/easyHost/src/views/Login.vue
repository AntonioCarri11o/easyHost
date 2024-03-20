<template>
  <b-container class="d-flex justify-content-center align-items-center vh-100">
    <b-col cols="3">
      <b-row>
        <b-col class="text-center">
          <h3>Inicia Sesión</h3>
        </b-col>
      </b-row>
      <b-form v-on:submit.prevent="validar">
        <b-row>
          <b-col>
            <b-form-input
              v-model="email"
              placeholder="Correo"
              autocomplete="off"
              :state="enviado ? !v$.email.$invalid : null"
            ></b-form-input>
            <b-form-invalid-feedback>
              <span v-if="v$.email.required.$invalid">El correo es obligatorio</span>
              <span v-else-if="v$.email.$invalid">El correo no es válido</span>
            </b-form-invalid-feedback>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-form-input
              v-model="contrasenia"
              placeholder="Contraseña"
              type="password"
              :state="enviado ? !v$.contrasenia.$invalid : null"
            ></b-form-input>
            <b-form-invalid-feedback>
              <span v-if="v$.contrasenia.required.$invalid">La contraseña es obligatoria</span>
              <span v-else-if="v$.contrasenia.minLength.$invalid"
                >La contraseña debe tener al menos 6 caracteres</span
              >
            </b-form-invalid-feedback>
          </b-col>
        </b-row>
        <b-row>
          <b-col class="text-end">
            <b-button variant="link">Olvidé la contraseña</b-button>
          </b-col>
        </b-row>
        <b-row>
          <b-col>
            <b-button class="w-100" variant="primary" type="submit"
              >Iniciar Sesión</b-button
            >
          </b-col>
        </b-row>
      </b-form>
      <b-row>
        <b-col class="text-center">
          ¿No tienes cuenta? <b-link>crea una aquí</b-link>.
        </b-col>
      </b-row>
    </b-col>
  </b-container>
</template>

<script>
import { useVuelidate } from "@vuelidate/core";
import {
  required,
  minLength,
  email,
  helpers,
} from "@vuelidate/validators";
const { withParams } = helpers;
export default {
  setup() {
    return { v$: useVuelidate() };
  },
  data() {
    return {
      email: "",
      contrasenia: "",
      enviado: false,
    };
  },
  validations() {
    return {
      email: { required: required, email },
      contrasenia: {
        required: required,
        minLength: withParams({ type: "minLength", min: 6 }, minLength(6)),
      },
    };
  },
  methods: {
    validar() {
      this.enviado = true;
      // Si los datos son válidos, se envían al servidor
    },
  },
};
</script>

<style></style>
