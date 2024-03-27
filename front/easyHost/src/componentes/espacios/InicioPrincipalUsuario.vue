<template>
    <b-container class="container-fluid container-principal d-flex flex-wrap">
        <div class="buscador fixed-top">
            <img src="../../assets/EasyHost.png" alt="lupa" width="60px">
            <b-input-group class="mb-2">
                <b-form-input class="search" type="search" v-model="busqueda" @input="filtrarAlojamientos"
                    placeholder="Buscar alojamiento"></b-form-input>
                <b-input-group-prepend is-text>
                    <b-icon style="width: 25px; height: 30px; color: #7952b3;" icon="search"></b-icon>
                </b-input-group-prepend>
            </b-input-group>
            <div class="input-container">
                <div class="perfil" @click="toggleMenu">
                    <b-icon class="h5" icon="list"></b-icon>
                    <b-icon class="h2" icon="person-circle" style="color: #7952b3;"></b-icon>
                </div>
                <MenuDropdown v-show="isOpen" />
            </div>
        </div>
        <div v-for="alojamiento in filteredAlojamientos" :key="alojamiento.id" class="alojamientos">
            <b-card :img-src="alojamiento.imagen" img-alt="Image" img-top tag="article"
                style="max-width: 20rem; max-height: 20rem;" class="mb-4 cardD">
                <b-card-text>
                    {{ alojamiento.descripcion }} <br>
                    {{ alojamiento.ubicacion }}<br>
                    <div class="calificación">
                        <span>{{ alojamiento.calificacion }} </span> <b-icon icon="star-fill" variant="warning"
                            v-for="i in alojamiento.calificacion"></b-icon>
                    </div>
                    <div class="precio">
                        <span>${{ alojamiento.precio }}MXN </span>
                        <span>noche</span>
                    </div>
                </b-card-text>
            </b-card>
        </div>
    </b-container>
</template>

<script>
import MenuDropdown from "../../components/compartido/MenuDropdown.vue";
import img3 from "../../assets/dreamhouse.jpg";
import AlojamientoServicio from '../../componentes/servicio/Alojamiento.js';
export default {
    components: {
        MenuDropdown
    },
    data() {
        return {
            busqueda: "",
            isOpen: false,
            alojamientos: [],
            filteredAlojamientos: []
        }
    },
    methods: {
        toggleMenu() {
            this.isOpen = !this.isOpen;
        },
        async listarAlojamientos() {
            try {
                const respuesta = await AlojamientoServicio.listarAlojamientos();
                this.alojamientos = respuesta;
                this.alojamientos.map(alojamiento => {
                    //alojamiento.imagen = `data:image/jpeg;base64,${alojamiento.imagen}`;
                    // Sustituir la imagenn por una imagen de prueba
                    alojamiento.imagen = img3;
                    alojamiento.calificacion = 3;
                });
                this.filteredAlojamientos = this.alojamientos;
            } catch (err) {
                throw (err);
            }
        },
        filtrarAlojamientos() {
            this.filteredAlojamientos = this.alojamientos;
            if (this.busqueda.trim() === "" || this.busqueda === null) {
                this.filteredAlojamientos = this.alojamientos;
            } else {
                this.filteredAlojamientos = this.alojamientos.filter(alojamiento => {
                    return alojamiento.descripcion.toLowerCase().includes(this.busqueda.toLowerCase()) ||
                        alojamiento.ubicacion.toLowerCase().includes(this.busqueda.toLowerCase());
                });
            }
        }
    },
    mounted() {
        this.listarAlojamientos();
    }
}
</script>

<style>
.container-principal {
    margin-top: 100px;
    justify-content: space-between;
}

.buscador {
    display: flex;
    justify-content: space-between;
    align-items: center;
    gap: 190px;
    padding: 20px;
    margin-bottom: 1000px;
}

.fixed-top {
    width: 100%;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.input-container input[type="text"] {
    padding-right: 40px;
}

.input-container:hover .perfil {
    box-shadow: #c5b8b8 0px 0px 5px;
    cursor: pointer;
}

.search-input {
    width: 100%;
}

.perfil {
    display: flex;
    padding: 6px 5px 0px 5px;
    border-radius: 20px;
    border: #c5b8b8 solid 1px;
    gap: 10px;
    align-items: center;
}

.alojamientos {
    padding-left: 5px;
    padding-right: 5px;
}

.alojamiento {
    margin-bottom: 20px;
}

.card-grid {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    grid-gap: 1rem;
}

.card {
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-weight: bold;
    min-width: 30rem;
    max-width: 30rem;
    min-height: 20rem;
    max-height: 20rem;
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
}

.card:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    transform: scale(1.02);
    transition: box-shadow 0.3s, transform 0.3s;
}

.card img {
    min-height: 10rem;
    max-height: 10rem;
    min-width: 15rem;
    max-width: 15rem;
}

.calificación {
    display: flex;
    align-items: center;
    margin-top: 10px;
    font-size: 16px;
}

.calificación span:first-child {
    font-weight: bold;
}

.calificación i {
    color: #FFD700;
}

.precio {
    display: flex;
    align-items: center;
    margin-top: 10px;
    font-size: 16px;
}

.precio span:first-child {
    font-weight: bold;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
</style>