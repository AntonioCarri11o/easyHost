<template>
  <div>
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
              <b-form-input v-model="email" placeholder="Correo" autocomplete="off"
                :state="enviado ? !v$.email.$invalid : null"></b-form-input>
              <b-form-invalid-feedback>
                <span v-if="v$.email.required.$invalid">El correo es obligatorio</span>
                <span v-else-if="v$.email.$invalid">El correo no es válido</span>
              </b-form-invalid-feedback>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-form-input v-model="contrasenia" placeholder="Contraseña" type="password"
                :state="enviado ? !v$.contrasenia.$invalid : null"></b-form-input>
              <b-form-invalid-feedback>
                <span v-if="v$.contrasenia.required.$invalid">La contraseña es obligatoria</span>
                <span v-else-if="v$.contrasenia.minLength.$invalid">La contraseña debe tener al menos 6
                  caracteres</span>
              </b-form-invalid-feedback>
            </b-col>
          </b-row>
          <b-row>
            <b-col class="text-end">
              <b-button variant="link" v-b-modal.modal-recuperar>Olvidé la contraseña</b-button>
            </b-col>
          </b-row>
          <b-row>
            <b-col>
              <b-button class="w-100" variant="primary" type="submit">Iniciar Sesión</b-button>
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

    <div>

      <b-modal id="modal-recuperar" centered title="Recuperar Contraseña" hide-footer no-stacking>
        <form>
          <label class="mb-2">Ingresa tu número telefonico (10 digitos)</label>
          <b-form-input class="input-modal"></b-form-input>
          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-recuperar')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" v-b-modal.modal-codigo>Continuar</b-button>
        </form>
      </b-modal>
    </div>

    <div>

      <b-modal id="modal-codigo" centered title="Recuperar Contraseña" hide-footer no-stacking>
        <form>
          <label class="mb-2">Ingresa el código de verificación (5 digitos)</label>
          <b-form-input autocomplete="off" class="input-modal"></b-form-input>
          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-codigo')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" v-b-modal.modal-codigo>Continuar</b-button>
        </form>
      </b-modal>
    </div>



  </div>
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

<style>
.btn-modal {
  width: 49%;
}

.input-modal {
  text-align: center;
  font-size: 25px;
  font-weight: bold;
}
</style>
