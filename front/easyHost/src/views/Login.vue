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
        <b-form v-on:submit.prevent="validarTelefono">
          <label class="mb-2">Ingresa tu número telefonico (10 digitos)</label>
          <b-form-input autocomplete="off" maxlength="10" class="input-modal" v-model="numeroTelefono"
            placeholder="Número de Teléfono" :state="enviado ? !v$.numeroTelefono.$invalid : null"
            :formatter="formatoTelefono"></b-form-input>

          <b-form-invalid-feedback>
            <span v-if="v$.numeroTelefono.required.$invalid">La número de telefono es obligatorio</span>
            <span v-else-if="v$.numeroTelefono.minLength.$invalid || v$.numeroTelefono.maxLength.$invalid">El número de
              teléfono debe tener 10 caracteres</span>
          </b-form-invalid-feedback>

          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-recuperar')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" type="submit">Continuar</b-button>
        </b-form>
      </b-modal>
    </div>

    <div>
      <b-modal id="modal-codigo" centered title="Recuperar Contraseña" hide-footer no-stacking>
        <b-form v-on:submit.prevent="validarCodigo">
          <label class="mb-2">Ingresa el código de verificación (5 digitos)</label>
          <b-form-input maxlength="5" autocomplete="off" class="input-modal" :formatter="formatoCodigo"
            :state="enviado ? !v$.codigoVerificacion.$invalid : null"></b-form-input>

          <b-form-invalid-feedback>
            <span v-if="v$.codigoVerificacion.required.$invalid">El código de verificación es obligatorio</span>
            <span v-else-if="v$.codigoVerificacion.minLength.$invalid || v$.codigoVerificacion.maxLength.$invalid">El
              código de verificación debe tener 5 caracteres</span>
          </b-form-invalid-feedback>

          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-codigo')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" type="submit">Continuar</b-button>
        </b-form>
      </b-modal>
    </div>

    <div>
      <b-modal id="modal-contrasenias" centered title="Recuperar Contraseña" hide-footer no-stacking>
        <b-form>
          <label class="mb-2">Ingresa tu nueva contraseña</label>
          <b-form-input autocomplete="off" type="password"></b-form-input>
          <label class="mb-2 mt-4">Confirma tu nueva contraseña</label>
          <b-form-input autocomplete="off" type="password"></b-form-input>

          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-contrasenias')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" type="submit">Confirmar</b-button>
        </b-form>
      </b-modal>
    </div>



  </div>
</template>

<script>
import { useVuelidate } from "@vuelidate/core";
import {
  required,
  minLength,
  maxLength,
  email,
  helpers,
  sameAs
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

      numeroTelefono: "",
      codigoVerificacion: ""
    };
  },
  validations() {
    return {
      email: { required: required, email },
      contrasenia: {
        required: required,
        minLength: withParams({ type: "minLength", min: 6 }, minLength(6)),
      },
      numeroTelefono: {
        required: required,
        minLength: withParams({ type: "minLength", min: 10 }, minLength(10)),
        maxLength: withParams({ type: "maxLength", min: 10 }, maxLength(10)),
      },
      codigoVerificacion: {
        required: required,
        minLength: withParams({ type: "minLength", min: 5 }, minLength(5)),
        maxLength: withParams({ type: "maxLength", max: 5 }, maxLength(5)),
      },
      nuevaContrasenia: {
        required: required,
        minLength: withParams({ type: "minLength", min: 6 }, minLength(6)),
      },
      confirmarContrasenia: {
        required: required,
        sameAsNuevaContrasenia: withParams({ type: "sameAs", field: "nuevaContrasenia" }, sameAs("nuevaContrasenia")),
      },

    };
  },
  methods: {
    validar() {
      this.enviado = true;
      // Si los datos son válidos, se envían al servidor
    },
    formatoTelefono(value) {
      // Elimina todos los caracteres que no sean dígitos
      const digits = value.replace(/\D/g, '');
      // Aplica el formato deseado al número de teléfono
      const formattedValue = digits.replace(/(\d{3})(\d{3})(\d{4})/, '$1$2$3');
      return formattedValue;
    },
    formatoCodigo(value) {
      // Elimina todos los caracteres que no sean dígitos
      const digits = value.replace(/\D/g, '');
      // Retorna los primeros 5 dígitos para asegurar que solo se ingresen 5 cifras
      return digits.slice(0, 5);
    },
    validarTelefono() {
      this.enviado = true;
      if (!this.v$.numeroTelefono.$invalid) {
        // Si el número de teléfono es válido, se envía al servidor
        console.log('Número de teléfono válido:', this.numeroTelefono);
        // Se muestra el modal para ingresar el código de verificación
        this.$bvModal.show('modal-codigo');
      }
    },
    validarCodigo() {
      this.enviado = true;
      console.log('Código de verificación válido:', this.codigoVerificacion);
      if (!this.v$.codigoVerificacion.$invalid) {
        // Si el código de verificación es válido, se envía al servidor
        console.log('Código de verificación válido:', this.codigoVerificacion);
        // Se muestra el modal para ingresar la nueva contraseña
        this.$bvModal.show('modal-contrasenias');
      }

    },
    cambiarContrasenia() {
      this.enviado = true;

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
