<template>
    <b-container fluid class="d-block min-vh-100 flex-column align-items-center">
        <div style="max-width: 1200px; width: 100%;">
            <h2 class="text-center mt-5 mb-4">Solicitar ser anfitrión</h2>
            <hr class="w-100">
            <div class="alert alert-warning mt-3 mb-4 alert-dismissible fade show" role="alert">
                <strong>NOTA:</strong> Al enviar la solicitud de cambio, deberá esperar a que el administrador revise y
                valide sus datos.
            </div>
            <b-form @submit="onSubmit" @reset="onReset" class="col-md-6">
                <b-form-group id="input-group-1" label="CURP:" label-for="input-1"
                    description="Nunca compartiremos su CURP con nadie más." class="mb-3">
                    <b-form-input id="input-1" v-model="form.curp_anfitrion" type="curp" placeholder="Ingrese su CURP"
                        required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="RFC:" label-for="input-2" class="mb-3">
                    <b-form-input id="input-2" v-model="form.rfc_anfitrion" placeholder="Ingrese su RFC"
                        required></b-form-input>
                </b-form-group>
                <!-- Imagen de la identificación-->
                <b-form-group id="input-group-3" label="Identificación oficial:" label-for="input-3" class="mb-3">
                    <b-form-file v-model="form.url_imagen_identificacion_anfitrion" type="file" accept="image/*"
                        placeholder="Seleccione una imagen" required></b-form-file>
                    
                </b-form-group>

                <b-row class="justify-content-center">
                    <b-col cols="auto" class="mb-3">
                        <b-button type="reset" variant="warning" href="ejemplo">Cancelar</b-button>
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
                }
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
                this.$nextTick(() => {
                    this.$refs['form'].reset();
                });
            }
        }
    }
</script>

<style>

</style>