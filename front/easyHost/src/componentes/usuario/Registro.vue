<template>
    <div class="w-100 h-100 d-flex">
        <section class="my-4 mx-auto contenedor-formulario">
            <div class="contenedor-imagen d-flex">
                <img class="mx-auto" width="15%" src="src\assets\img\EasyHost.png">
            </div>
            <b-form
            class="row p-3"
            @submit.prevent="validar"
            action="https://vuejs.org/"
            method="post"
            >
                <b-form-group
                class="col-12 col-sm-6"
                id="nombre-group"
                label="Nombre"
                label-for="nombre"
                >
                    <b-form-input
                    placeholder="Ej. Mario"
                    id="nombre"
                    v-model.trim="v$.nombre.$model"
                    type="text"
                    name="nombre"
                    :state="campoEstado(v$.nombre.$invalid, v$.nombre.$dirty)"
                    >
                    </b-form-input>
                    <div v-if="campoEstado(v$.nombre.$invalid, v$.nombre.$dirty) == false"
                    class="mensaje-error"
                    >El nombre es requerido y debe tener máximo 30 caracteres </div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="apellidos-group"
                label="Apellidos"
                label-for="apellidos"
                >
                <b-form-input
                placeholder="Ej. Cabrera Gutierres"
                id="apellidos"
                v-model.trim="v$.apellidos.$model"
                :state="campoEstado(v$.apellidos.$invalid, v$.apellidos.$dirty)"
                >
                </b-form-input>
                <div v-if="campoEstado(v$.apellidos.$invalid, v$.apellidos.$dirty) == false"
                    class="mensaje-error"
                    >Los apellidos son requeridos y deben tener máximo 50 caracteres</div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="correo-group"
                label="Correo electrónico"
                label-for="correo"
                >
                <b-form-input
                placeholder="Ej. mario_cabrera@email.com"
                id="correo"
                v-model.trim="v$.correo.$model"
                :state="campoEstado(v$.correo.$invalid, v$.correo.$dirty)"
                >
                </b-form-input>
                <div v-if="campoEstado(v$.correo.$invalid, v$.correo.$dirty) == false"
                    class="mensaje-error"
                    >Correo inválido</div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="telefono-group"
                label="Telefono"
                label-for="telefono"
                >
                <b-form-input
                placeholder="Ej. 558524671595"
                id="telefono"
                v-model.trim="v$.telefono.$model"
                :state="campoEstado(v$.telefono.$invalid, v$.telefono.$dirty)"
                >
                </b-form-input>
                <div v-if="campoEstado(v$.telefono.$invalid, v$.telefono.$dirty) == false"
                    class="mensaje-error"
                    >El teléfono es requerido y debe tener 10 caracteres numéricos</div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="contrasenia-group"
                label="Nueva contraseña"
                label-for="contrasenia"
                >
                <div class="d-flex contrasenia-container">
                    <b-form-input
                    placeholder="*******"
                    id="contrasenia"
                    v-model.trim="v$.contrasenia.$model"
                    :state="campoEstado(v$.contrasenia.$invalid, v$.contrasenia.$dirty)"
                    :type="this.mostrarC ? 'text' : 'password'"
                    >
                    </b-form-input>
                    <div class="my-auto mx-2">
                        <b-icon v-if="!this.mostrarC" class="cursor-pointer" icon="eye-slash" @click="cambiarMostrarC"></b-icon>
                        <b-icon v-if="this.mostrarC" class="cursor-pointer" icon="eye" @click="cambiarMostrarC"></b-icon>
                    </div>
                </div>
                <div v-if="(this.contrasenia == '' || contrasenia == null) && v$.contrasenia.$dirty"
                    class="mensaje-error"
                    >La contraseña es requerida
                </div>
                <div class="mensaje-error" v-if="campoEstado(v$.contrasenia.$invalid, v$.contrasenia.$dirty) == false">
                    Las contraseñas no coinciden
                </div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="confirmaContrasenia-group"
                label="Confirmar contraseña"
                label-for="confrimaContrasenia"
                >
                <div class="d-flex contrasenia-container">
                    <b-form-input
                    placeholder="*******"
                    id="confirmaContrasenia"
                    v-model.trim="v$.confirmaContrasenia.$model"
                    :state="campoEstado(v$.confirmaContrasenia.$invalid, v$.confirmaContrasenia.$dirty)"
                    :type="this.mostrarCC ? 'text' : 'password'"
                    >
                </b-form-input>
                <div class="my-auto mx-2">
                        <b-icon v-if="!this.mostrarCC" class="cursor-pointer" icon="eye-slash" @click="cambiarMostrarCC"></b-icon>
                        <b-icon v-if="this.mostrarCC" class="cursor-pointer" icon="eye" @click="cambiarMostrarCC"></b-icon>
                </div>
                </div>
                <div v-if="(this.confirmaContrasenia == '' || confirmaContrasenia == null) && v$.confirmaContrasenia.$dirty"
                    class="mensaje-error"
                    >Es necesario repetir la contraseña
                </div>
                <div class="mensaje-error" v-if="campoEstado(v$.confirmaContrasenia.$invalid, v$.confirmaContrasenia.$dirty) == false">
                    Las contraseñas no coinciden
                </div>
                </b-form-group>
                <b-form-group                
                class="col-12"
                id="direccion-group"
                label="Dirección"
                label-for="direccion"
                >
                <b-form-input
                placeholder="Ej. Avenida Miramimontes #10, col Anahua, San Blas Nayarit"
                id="direccion"
                v-model.trim="v$.direccion.$model"
                :state="campoEstado(v$.direccion.$invalid, v$.direccion.$dirty)"
                >
                </b-form-input>
                <div v-if="campoEstado(v$.direccion.$invalid, v$.direccion.$dirty) == false"
                    class="mensaje-error"
                    >La dirección es requerida</div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="f-nac-group"
                label="Fecha de nacimiento"
                label-for="f-nac"
                >
                <b-form-input
                id="f-nac"
                v-model.trim="v$.fechaNacimiento.$model"
                :state="campoEstado(v$.fechaNacimiento.$invalid, v$.fechaNacimiento.$dirty)"
                type="date"
                >
                </b-form-input>
                <div v-if="campoEstado(v$.fechaNacimiento.$invalid, v$.fechaNacimiento.$dirty) == false"
                    class="mensaje-error"
                    >La fecha de nacimiento es requerida y no debe ser mayor a la actual</div>
                </b-form-group>
                <b-form-group
                class="col-12 col-sm-6"
                id="genero-group"
                label="Género"
                label-for="genero"
                >
                <b-form-select
                class="form-control custom-select"
                id="genero"
                v-model.trim="v$.genero.$model"
                :options="generoOpciones"
                :state="campoEstado(v$.genero.$invalid, v$.genero.$dirty)"
                >
                <b-form-select-option
                value=""
                >Selecciona una opción</b-form-select-option>
                </b-form-select>
                <div v-if="campoEstado(v$.genero.$invalid, v$.genero.$dirty) == false"
                    class="mensaje-error"
                    >El género es requerido</div>
                </b-form-group>
                <div class="col-12 mt-4 d-flex flex-column">
                    <div class="mx-auto">
                        <b-button variant="primary" type="submit" class="w-100" :disabled="this.v$.$invalid">Registrar</b-button>
                        <p class="fs-6">¿Ya tienes cuenta? <a href="#" class="text-decoration-none">Inicia sesión aquí</a></p>
                    </div>
                </div>
            </b-form>
        </section>
    </div>
</template>
<style scoped>
.contenedor-formulario {
    width: 80%;
    color:#000;
    box-sizing: border-box;
}
.mensaje-error {
    font-size: small;
    color: red;
}
.contrasenia-container {
    background-color: #dfdfdf;
    border-radius: .5rem;
}
</style>
<script>
import { required, maxLength, minLength, email, numeric, } from '@vuelidate/validators';
import { useVuelidate} from '@vuelidate/core';
import { recortarEspaciosEnBlanco } from '../../Utilidades';
import usuarioServicio from '../servicio/Usuario.js';
import Swal from 'sweetalert2';
function fechaPasada(valor) {
    const fecha = new Date(valor);
    return fecha < new Date();
}
export default {
    name: "Registro",
    setup() {
        return {v$: useVuelidate() };
    },
    data() {
        return {
            enviado: false,
            nombre: '',
            apellidos: '',
            correo: '',
            contrasenia: '',
            confirmaContrasenia: '',
            telefono: '',
            direccion: '',
            fechaNacimiento: '',
            genero: '',
            
            generoOpciones: [
                {
                    value: 'Hombre',
                    text: 'Hombre'
                },
                {
                    value: 'Mujer',
                    text: 'Mujer'
                }
            ],

            mostrarC: false,
            mostrarCC: false,
        }
    },
    validations() {
        return {
            nombre: {required, maxLength: maxLength(30)},
            apellidos: {required, maxLength: maxLength(50)},
            correo: {required, email},
            telefono: {required, numeric, minLength: minLength(10), maxLength: maxLength(10)},
            contrasenia: {required, coincideContrasenia: valor => this.contrasenia === this.confirmaContrasenia},
            confirmaContrasenia: {required, coincideContrasenia: valor => this.contrasenia === this.confirmaContrasenia},            
            direccion: {required},
            fechaNacimiento: {required, fechaPasada: valor => fechaPasada(valor)},
            genero: {required},
        }
    },
    methods: {
        campoEstado(invalid, dirty) {
            if (!dirty) {
                return null
            } else if (invalid){
                return false
            }
            return true;
        },        
        validar() {
            if (this.v$.$invalid) {
                return;
            }

            const carga = {
                nombre: recortarEspaciosEnBlanco(this.nombre),
                apellidos: recortarEspaciosEnBlanco(this.apellidos),
                correo: this.correo,
                telefono: this.telefono,
                contrasenia: this.contrasenia,
                direccion: recortarEspaciosEnBlanco(this.direccion),
                fechaNacimiento: this.fechaNacimiento,
                genero: this.genero
            }
            this.registrarUsuario(carga);
        },
        async registrarUsuario(carga) {
            try {
                const response = await usuarioServicio.registrarUsuario(carga);
                if (response == "Registro exitoso!") {
                    Swal.fire({
                        title:'Éxito',
                        text: 'Se ha registrado correctamente',
                        icon: 'success',
                        confirmButtonColor: "#0074d9",
                    }).then(()=> {
                        this.$router.push('/inicioSesion');
                    });
                }

            } catch(err) {
                console.error(err);
            }
        },
        cambiarMostrarC() {
            this.mostrarC = !this.mostrarC;
        },
        cambiarMostrarCC() {
            this.mostrarCC = !this.mostrarCC;
        }
    },
}
</script>