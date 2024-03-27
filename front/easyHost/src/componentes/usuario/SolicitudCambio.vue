<template>
    <b-container fluid class="margin-container">
        <div class="container mt-5 mb-5">
            <h2 class="text-center mt-5 mb-4">Solicitar ser anfitrión</h2>
            <hr class="w-100">
            <div class="alert alert-warning mt-3 mb-4 alert-dismissible fade show" role="alert">
                <strong>NOTA:</strong> Al enviar la solicitud de cambio, deberá esperar a que el administrador revise y
                valide sus datos.
            </div>
            <b-form @submit.prevent="validar()" @reset="onReset" class="col-md-12">
                <b-row>
                    <b-form-group id="input-group-1" label="CURP:" label-for="input-1"
                        description="Nunca compartiremos su CURP con nadie más." class="mb-3 col-md-6">
                        <b-form-input id="input-1" v-model="curp_anfitrion" type="text" placeholder="Ingrese su CURP"
                            required v-model.trim="v$.curp_anfitrion.$model"
                            :state="campoEstado(v$.curp_anfitrion.$invalid, v$.curp_anfitrion.$dirty)"></b-form-input>
                        <div v-if="campoEstado(v$.curp_anfitrion.$invalid, v$.curp_anfitrion.$dirty) == false"
                            class="mensaje-error">El
                            curp es requerido, sin caracteres especiales y longitud de 18 caracteres</div>
                    </b-form-group>
                    <b-form-group id="input-group-2" label="RFC:" label-for="input-2" class="mb-5 col-md-6">
                        <b-form-input id="input-2" v-model="rfc_anfitrion" placeholder="Ingrese su RFC" required
                            v-model.trim="v$.rfc_anfitrion.$model"
                            :state="campoEstado(v$.rfc_anfitrion.$invalid, v$.rfc_anfitrion.$dirty)"></b-form-input>
                        <div v-if="campoEstado(v$.rfc_anfitrion.$invalid, v$.rfc_anfitrion.$dirty) == false"
                            class="mensaje-error">El
                            rfc es requerido, sin caracteres especiales y longitud de 12 a 13 caracteres</div>
                    </b-form-group>
                </b-row>

                <!-- Imagen de la identificación-->
                <b-row class="mb-5">
                    <b-form-group id="input-group-3" label="Imagen de identificación oficial:" label-for="input-3"
                        class="col-md-3">
                        <b-form-file v-model="url_imagen_identificacion_anfitrion" @change="previewImage" type="file"
                            accept="image/*" required></b-form-file>
                        <img v-if="imageUrl" :src="imageUrl" alt="Vista previa de la imagen"
                            style="max-width: 100%; margin-top: 10px;">
                    </b-form-group>
                    <b-icon icon="arrow-bar-up" class="col-md-2"></b-icon>
                </b-row>


                <b-row class="justify-content-center">
                    <b-col cols="auto" class="mb-3">
                        <b-button type="reset" variant="warning" href="inicioPrincipalUsuario">Cancelar</b-button>
                    </b-col>
                    <b-col cols="auto" class="mb-3">
                        <b-button type="reset" variant="danger">Limpiar</b-button>
                    </b-col>
                    <b-col cols="auto" class="mb-3">
                        <b-button type="submit" variant="primary">Enviar</b-button>
                    </b-col>
                </b-row>
            </b-form>
        </div>
        <b-modal id="modal-AvisoPrivacidad" title="AVISO DE PRIVACIDAD" modal-ok-title="Aceptar" @ok="enviar()"
            size="lg" hide-header-close>
            <p class="my-3" style="text-align: justify;">Te informamos que al registrarte como anfitrión en nuestra
                aplicación, necesitamos recopilar cierta información personal para validar y aprobar tu solicitud. Este
                proceso es crucial para garantizar la seguridad y la calidad de la plataforma.<br> <br>

                Consentimiento: Al solicitar ser anfitrión y proporcionar la información requerida, aceptas expresamente
                los términos y condiciones de este aviso de privacidad.<br><br>

                Acceso y Modificación: Tienes derecho a acceder, rectificar y cancelar tus datos personales. Puedes
                realizar estas acciones a través de la sección correspondiente en tu perfil de usuario.<br><br>

                Agradecemos tu comprensión y colaboración para garantizar la integridad y la confianza en nuestra
                comunidad de anfitriones y huéspedes.</p>
        </b-modal>
    </b-container>
</template>

<script>
import { useVuelidate } from '@vuelidate/core';
import Swal from 'sweetalert2';
import { required, minLength, maxLength, helpers } from '@vuelidate/validators';
import { recortarEspaciosEnBlanco } from '../../Utilidades';
import { sonSoloLetras, alfanumerico } from '../../Utilidades';
export default {
    setup() {
        return { v$: useVuelidate() };
    },
    data() {
        return {
            curp_anfitrion: '',
            rfc_anfitrion: '',
            url_imagen_identificacion_anfitrion: null,
            imageUrl: null
        }
    },
    validations() {
        return {
            curp_anfitrion: {
                required, minLength: minLength(18), maxLength: maxLength(18),
                alfanumerico: valor => alfanumerico(valor)
            },
            rfc_anfitrion: {
                required, minLength: minLength(12), maxLength: maxLength(13),
                alfanumerico: valor => alfanumerico(valor)
            },
            url_imagen_identificacion_anfitrion: { required }
        }
    },
    mounted() {
        this.v$.$reset();
    },
    methods: {
        onReset(evt) {
            evt.preventDefault();
            this.curp_anfitrion = '';
            this.rfc_anfitrion = '';
            this.url_imagen_identificacion_anfitrion = null;
            this.imageUrl = null;

            this.$nextTick(() => {
                this.$refs['form'].reset();
            });
        },
        previewImage(event) {
            const file = event.target.files[0];
            if (file) {
                this.imageUrl = URL.createObjectURL(file);
            }
        },
        enviar() {
            Swal.fire({
                title: 'Éxito',
                text: 'Se ha enviado la solicitud correctamente',
                icon: 'success',
                confirmButtonColor: "#0074d9",
            }).then(() => {
                this.$router.push({ name: 'InicioPrincipalUsuario' });
            });
        },
        validar(evt) {
            if (this.v$.$invalid) {
                return;
            }
            const carga = {
                curp_anfitrion: this.curp_anfitrion,
                rfc_anfitrion: this.rfc_anfitrion,
                url_imagen_identificacion_anfitrion: this.url_imagen_identificacion_anfitrion
            }
            //Mostrar el modal modal-AvisoPrivacidad 
            this.$bvModal.show('modal-AvisoPrivacidad');
        },

        campoEstado(invalid, dirty) {
            if (!dirty) {
                return null
            } else if (invalid) {
                return false
            }
            return true;
        }
    }
}
</script>

<style></style>