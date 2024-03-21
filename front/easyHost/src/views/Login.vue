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
          <b-form-group id="fieldset-1" description="Ingresa tu número de 10 digitos" label="Número de Teléfono"
            label-for="input-phone" valid-feedback="Número válido" :invalid-feedback="phoneInvalidFeedback"
            :state="phoneState">
            <b-form-input id="input-phone" v-model="phoneNumber" :state="phoneState" @input="validatePhoneNumber"
              type="tel"></b-form-input>
          </b-form-group>
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
          <b-form-group id="fieldset-2" description="Enter the 5-digit verification code." label="Verification Code"
            label-for="input-code" valid-feedback="Thank you!" :invalid-feedback="codeInvalidFeedback"
            :state="codeState">
            <b-form-input id="input-code" v-model="verificationCode" :state="codeState"
              @input="validateVerificationCode"></b-form-input>
          </b-form-group>
          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-codigo')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary" v-b-modal.modal-contrasenias>Continuar</b-button>
        </form>
      </b-modal>
    </div>

    <div>
      <b-modal id="modal-contrasenias" centered title="Recuperar Contraseña" hide-footer no-stacking>
        <form>
          <label class="mb-2">Ingresa tu nueva contraseña</label>
          <b-form-input autocomplete="off"></b-form-input>
          <label class="mb-2 mt-4">Confirma tu nueva contraseña</label>
          <b-form-input autocomplete="off"></b-form-input>

          <!-- Input para la contraseña -->
          <b-form-group id="fieldset-3"
            description="Enter a password with at least 8 characters, one uppercase letter, one number, and one special character."
            label="Password" label-for="input-password" valid-feedback="Thank you!"
            :invalid-feedback="passwordInvalidFeedback" :state="passwordState">
            <b-form-input type="password" id="input-password" v-model="password" :state="passwordState"
              @input="validatePassword"></b-form-input>
          </b-form-group>

          <!-- Input para confirmar la contraseña -->
          <b-form-group id="fieldset-4" description="Confirm your password." label="Confirm Password"
            label-for="input-confirm-password" valid-feedback="Passwords match!"
            :invalid-feedback="confirmPasswordInvalidFeedback" :state="confirmPasswordState">
            <b-form-input type="password" id="input-confirm-password" v-model="confirmPassword"
              :state="confirmPasswordState" @input="validateConfirmPassword"></b-form-input>
          </b-form-group>
          <b-button class="btn-modal mt-4" @click="$bvModal.hide('modal-contrasenias')">Cancelar</b-button>
          <b-button class="btn-modal mt-4 ms-2" variant="primary">Confirmar</b-button>
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


      phoneNumber: '',
      verificationCode: '',
      password: '',
      confirmPassword: ''
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
  computed: {
    phoneState() {
      return /^\d{10}$/.test(this.phoneNumber)
    },
    phoneInvalidFeedback() {
      return this.phoneState ? '' : 'Por favor ingresa un número de 10 dígitos.'
    },
    codeState() {
      return /^\d{5}$/.test(this.verificationCode)
    },
    codeInvalidFeedback() {
      return this.codeState ? '' : 'Please enter a 5-digit verification code.'
    },
    passwordState() {
      return /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,}$/.test(this.password)
    },
    passwordInvalidFeedback() {
      return this.passwordState ? '' : 'Password must be at least 8 characters long and contain at least one uppercase letter, one number, and one special character.'
    },
    confirmPasswordState() {
      return this.confirmPassword === this.password
    },
    confirmPasswordInvalidFeedback() {
      return this.confirmPasswordState ? '' : 'Passwords do not match.'
    }
  },
  methods: {
    validar() {
      this.enviado = true;
      // Si los datos son válidos, se envían al servidor
    },
    validatePhoneNumber() {
      // Elimina caracteres no numéricos del número de teléfono
      this.phoneNumber = this.phoneNumber.replace(/\D/g, '').slice(0, 10);
    },
    validateVerificationCode() {
      // Elimina caracteres no numéricos del código de verificación
      this.verificationCode = this.verificationCode.replace(/\D/g, '').slice(0, 5);
    },
    validatePassword() {
      // No permitir espacios en blanco en la contraseña
      this.password = this.password.replace(/\s/g, '')
    },
    validateConfirmPassword() {
      // No permitir espacios en blanco en la confirmación de contraseña
      this.confirmPassword = this.confirmPassword.replace(/\s/g, '')
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
