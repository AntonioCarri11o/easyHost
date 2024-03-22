<template>
    <b-container fluid class="margin-container">
        <div>
            <h2 class="text-center mt-5 mb-4">Solicitar ser anfitrión</h2>
            <hr class="w-100">
            <div class="alert alert-warning mt-3 mb-4 alert-dismissible fade show" role="alert">
                <strong>NOTA:</strong> Al enviar la solicitud de cambio, deberá esperar a que el administrador revise y
                valide sus datos.
            </div>
            <b-form @submit="onSubmit" @reset="onReset" class="col-md-12">
                    <b-row>
                            <b-form-group id="input-group-1" label="CURP:" label-for="input-1"
                                description="Nunca compartiremos su CURP con nadie más." class="mb-3 col-md-6">
                                <b-form-input id="input-1" v-model="form.curp_anfitrion" type="curp"
                                    placeholder="Ingrese su CURP" required></b-form-input>
                            </b-form-group>
                            <b-form-group id="input-group-2" label="RFC:" label-for="input-2" class="mb-3 col-md-6">
                                <b-form-input id="input-2" v-model="form.rfc_anfitrion" placeholder="Ingrese su RFC"
                                    required></b-form-input>
                            </b-form-group>
                    </b-row>
                    
                <!-- Imagen de la identificación-->
                <b-row class="mb-3">
                    <b-form-group id="input-group-3" label="Imagen de identificación oficial:" label-for="input-3" class="col-md-3">
                        <b-form-file v-model="form.url_imagen_identificacion_anfitrion" @change="previewImage" type="file"
                            accept="image/*" required></b-form-file>
                        <img v-if="imageUrl" :src="imageUrl" alt="Vista previa de la imagen"
                            style="max-width: 100%; margin-top: 10px;">
                    </b-form-group>
                    <b-icon icon="arrow-bar-up" class="col-md-2"></b-icon>
                </b-row>
                

                <b-row class="justify-content-center">
                    <b-col cols="auto" class="mb-3">
                        <b-button type="reset" variant="warning" href="ejemplo">Cancelar</b-button>
                    </b-col>
                    <b-col cols="auto" class="mb-3">
                        <b-button type="reset" variant="danger">Limpiar</b-button>
                    </b-col>
                    <b-col cols="auto" class="mb-3">
                        <b-button type="submit" variant="primary" v-b-modal.modal-AvisoPrivacidad>Enviar</b-button>
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
    export default {
        data() {
            return {
                form: {
                    curp_anfitrion: '',
                    rfc_anfitrion: '',
                    url_imagen_identificacion_anfitrion: null
                },
                imageUrl: null
            }
        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault();
                alert(JSON.stringify(this.form));
            },
            onReset(evt) {
                evt.preventDefault();
                this.form.curp_anfitrion = '';
                this.form.rfc_anfitrion = '';
                this.form.url_imagen_identificacion_anfitrion = null;
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
                alert('Solicitud enviada');
                this.$router.push({ name: 'Ejemplo' });
            }
        }
    }
</script>

<style>

</style>