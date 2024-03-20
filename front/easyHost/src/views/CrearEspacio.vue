<template>
    <div class="container">
        <h1>Nuevo Espacio</h1>
        <br>

        <b-form @submit.prevent="submitForm" v-if="showForm">
            <div class="image-thumbnails">
                <div v-for="(image, index) in form.images" :key="index" class="thumbnail-container">
                    <img :src="getImageUrl(image)" class="thumbnail">
                </div>

            </div>
            <div>{{ form.images.length }} imágenes seleccionadas</div>
            <b-form-group id="input-group-images" 
                label-for="input-images" v-bind:state="imagesState" :invalid-feedback="imagesFeedback">
                <b-form-file id="input-images" :value="imageUrls" accept="image/*" multiple required
                     @change="processImages"></b-form-file>
            </b-form-group>

            <b-form-group id="input-group-name" label="Nombre:" label-for="input-name" v-bind:state="nameState"
                :invalid-feedback="nameFeedback">
                <b-form-input id="input-name" v-model="form.name" type="text" required
                    @input="validateName"></b-form-input>
            </b-form-group>

            <b-row>
                <b-col cols="6">
                    <b-form-group id="input-group-location" label="Ubicación:" label-for="input-location"
                        v-bind:state="locationState" :invalid-feedback="locationFeedback">
                        <b-form-input id="input-location" v-model="form.ubicacion_alojamiento" type="text" required
                            @input="validateLocation"></b-form-input>
                    </b-form-group>
                </b-col>
                <b-col cols="4">
                    <b-form-group id="input-group-price" label="Precio por Noche:" label-for="input-price"
                        v-bind:state="priceState" :invalid-feedback="priceFeedback">
                        <b-form-input id="input-price" v-model="form.precio_alojamiento" type="number" min="0" required
                            @input="validatePrice"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>

            <b-row>
                <b-col>
                    <b-form-group id="input-group-guests" label="Número de Huéspedes (máx. 7):" label-for="input-guests"
                        v-bind:state="guestsState" :invalid-feedback="guestsFeedback">
                        <b-form-input id="input-guests" v-model="form.n_huespedes_alojamiento" type="number" min="1" max="7" required
                            @input="validateGuests"></b-form-input>
                    </b-form-group>
                </b-col>
                <b-col>
                    <b-form-group id="input-group-beds" label="Número de Camas:" label-for="input-beds"
                        v-bind:state="bedsState" :invalid-feedback="bedsFeedback">
                        <b-form-input id="input-beds" v-model="form.n_camas_alojamiento" type="number" min="1" required
                            @input="validateBeds"></b-form-input>
                    </b-form-group>
                </b-col>
                <b-col>
                    <b-form-group id="input-group-checkin" label="Hora de Recepción:" label-for="input-checkin"
                        v-bind:state="checkinState" :invalid-feedback="checkinFeedback">
                        <b-form-input id="input-checkin" v-model="form.h_recepcion_alojamiento" type="time" required
                            @input="validateCheckin"></b-form-input>
                    </b-form-group>
                </b-col>
                <b-col>
                    <b-form-group id="input-group-checkout" label="Hora de Salida:" label-for="input-checkout"
                        v-bind:state="checkoutState" :invalid-feedback="checkoutFeedback">
                        <b-form-input id="input-checkout" v-model="form.h_salida_alojamiento" type="time" required
                            @input="validateCheckout"></b-form-input>
                    </b-form-group>
                </b-col>
            </b-row>
            <br>
            <b-row>
                <b-col>
                    <b-form-group id="input-group-description" label="Descripción:" label-for="input-description"
                        v-bind:state="descriptionState" :invalid-feedback="descriptionFeedback">
                        <b-form-textarea id="input-description" v-model="form.descripcion_alojamiento" required rows="3"
                            @input="validateDescription"></b-form-textarea>
                    </b-form-group>
                </b-col>
                <b-col>
                    <b-form-group id="input-group-category" label="Categoría:" label-for="input-category"
                        v-bind:state="categoryState" :invalid-feedback="categoryFeedback">
                        <b-form-select id="input-category" v-model="form.fk_categoria" :options="categories" required
                            @change="validateCategory"></b-form-select>
                    </b-form-group>
                </b-col>
            </b-row>
            <br>
            <div class="extras-container">
                <div class="extras-column">
                    <h4>Extras Disponibles</h4>
                    <draggable v-model="defaultExtras" group="extras" class="extras-list">
                        <div v-for="(extra, index) in defaultExtras" :key="index" class="extra-item"
                            @click="addToSelected(extra)">
                            {{ extra }}
                        </div>
                    </draggable>
                </div>

                <div class="extras-column">
                    <h4>Extras Seleccionados</h4>
                    <draggable v-model="selectedExtras" group="extras" class="extras-list">
                        <div v-for="(extra, index) in selectedExtras" :key="index" class="extra-item"
                            @click="removeFromSelected(extra)">
                            {{ extra }}
                        </div>
                    </draggable>
                </div>
            </div>

            <br><br>
            <template>
                <div class="d-flex justify-content-center">
                    <b-button type="submit" variant="primary" style="width: 800px;">Guardar Espacio</b-button>
                </div>
            </template>

        </b-form>
    </div>
</template>

<script>
import draggable from 'vuedraggable';
import axios from 'axios';
export default {
    components: {
        draggable
    },
    data() {
    return {
        form: {
            name: "",
            descripcion_alojamiento: "",
            ubicacion_alojamiento: "",
            n_huespedes_alojamiento: 1,
            n_camas_alojamiento: 1,
            h_recepcion_alojamiento: "",
            h_salida_alojamiento: "",
            precio_alojamiento: 0,
            fk_categoria: "",
            images: [],
            extras: []            
        },
        defaultExtras: ['Piscina', 'Wifi', 'Estacionamiento', 'Desayuno'],
        selectedExtras: [],
        nameState: null,
        nameFeedback: "El nombre debe tener al menos 3 caracteres.",
        descriptionState: null,
        descriptionFeedback: "La descripción debe tener al menos 10 caracteres.",
        locationState: null,
        locationFeedback: "La ubicación debe ser válida.",
        guestsState: null,
        guestsFeedback: "El número de huéspedes debe ser mayor a 0 y máximo 7.",
        bedsState: null,
        bedsFeedback: "El número de camas debe ser mayor a 0.",
        checkinState: null,
        checkinFeedback: "La hora de recepción es requerida.",
        checkoutState: null,
        checkoutFeedback: "La hora de salida es requerida.",
        priceState: null,
        priceFeedback: "El precio debe ser mayor a 0.",
        categoryState: null,
        categoryFeedback: "La categoría es requerida.",
        imagesState: null,
        extrasState: null,
        extrasFeedback: "", 
        showForm: true 
    };
},

    computed: {
        categories() {
            return ["Cabaña 1", "Cabaña 2", "Cabaña 3", "Cabaña 4", "Hotel", "Otra Categoría 1", "Otra Categoría 2"];
        },
        allImages() {
            return this.form.images.concat(this.form.images);
        },
        imageUrls() {
        return this.form.images.map(image => image.url);
    }
    },
    methods: {
        async submitForm() {
            try {
                const response = await axios.post('http://localhost:3306/api/alojamientos', this.form);
                console.log('Alojamiento creado:', response.data);
                // Aquí podrías realizar alguna acción adicional después de crear el alojamiento, como redirigir a otra página o mostrar un mensaje de éxito
            } catch (error) {
                console.error('Error al crear el alojamiento:', error);
                // Aquí podrías mostrar un mensaje de error al usuario o manejar el error de otra manera
            }
        },
        processImages(event) {
            const files = event.target.files;

            for (let i = 0; i < files.length; i++) {
                const imageUrl = URL.createObjectURL(files[i]);
                this.form.images.push({ url: imageUrl, file: files[i] });
            }

            console.log('Imágenes agregadas:', this.form.images);
            this.validateImages();
        },
        getImageUrl(image) {
            return image.url;
        },
        
        addToSelected(extra) {
            this.selectedExtras.push(extra);
            const index = this.defaultExtras.indexOf(extra);
            if (index !== -1) {
                this.defaultExtras.splice(index, 1);
            }
        },
        removeFromSelected(extra) {
            const index = this.selectedExtras.indexOf(extra);
            if (index !== -1) {
                this.selectedExtras.splice(index, 1);
                this.defaultExtras.push(extra);
            }
        },

        
        validateName() {
            this.nameState = this.form.name.length >= 3 ? true : false;
        },
        validateDescription() {
            this.descriptionState = this.form.descripcion_alojamiento.length >= 10 ? true : false;
        },
        validateLocation() {
            
            this.locationState = true;
        },
        validateGuests() {
            this.guestsState = this.form.n_huespedes_alojamiento > 0 && this.form.n_huespedes_alojamiento <= 7 ? true : false;
        },
        validateBeds() {
            this.bedsState = this.form.n_camas_alojamiento > 0 ? true : false;
        },
        validateCheckin() {
            this.checkinState = this.form.h_recepcion_alojamiento !== "" ? true : false;
        },
        validateCheckout() {
            this.checkoutState = this.form.h_salida_alojamiento !== "" ? true : false;
        },
        validatePrice() {
            this.priceState = this.form.precio_alojamiento > 0 ? true : false;
        },
        validateCategory() {
            this.categoryState = this.form.fk_categoria !== "" ? true : false;
        },
        
       
    }
};
</script>

<style>
.extras-container {
    display: flex;
    justify-content: space-between;
}

.extras-column {
    width: 45%;
    background-color: #F3F3F3;
    border-radius: 10px;
    padding: 15px;
}

.extras-list {
    list-style-type: none;
    padding: 0;
}

.extra-item {
    background-color: #f4f4f4;
    border: 1px solid #ddd;
    border-radius: 4px;
    margin-bottom: 5px;
    padding: 10px;
    cursor: pointer;
}

.image-thumbnails {
    display: flex;
    flex-wrap: wrap;
    gap: 10px;
}

.thumbnail-container {
    width: 200px;
    height: 200px;
    overflow: hidden;
    border: 1px solid #ddd;
}

.thumbnail {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>