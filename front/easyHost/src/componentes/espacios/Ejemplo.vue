<template>
    <div class="container" resize="resize">
        <div class="buscador fixed-top">
            <img src="../../assets/EasyHost.png" alt="lupa" width="60px">
            <b-input-group class="mb-2">
                <b-form-input type="search" v-model="busqueda" placeholder="Buscar alojamiento"></b-form-input>
                <b-input-group-prepend is-text>
                    <b-icon icon="search"></b-icon>
                </b-input-group-prepend>
            </b-input-group>
            <!--             <input class="search-input" type="text" placeholder="Buscar alojamiento" v-model="busqueda">
 --> <!-- Input de búsqueda con un icono de lupa -->
            <div class="input-container">
                <div class="perfil" @click="toggleMenu">
                    <b-icon class="h5" icon="list"></b-icon>
                    <b-icon class="h2" icon="person-circle"></b-icon>
                </div>
                <MenuDropdown v-show="isOpen" />
            </div>

        </div>
        <!--         <hr style="width: 100%; margin: 0px 20px 0px 20px;"> -->

        <div class="alojamientos">
            <div class="alojamiento" v-for="alojamiento in alojamientos" :key="alojamiento.id">
                <b-card :img-src="alojamiento.imagen" img-alt="Image" img-top tag="article" class="card mb-2">
                    <b-card-text>
                        {{alojamiento.titulo}} <br>
                        {{alojamiento.ubicacion}}
                        <div class="calificación">
                            <span>{{alojamiento.calificacion}} </span> <b-icon icon="star-fill" variant="warning"
                                v-for="i in alojamiento.calificacion" :key="alojamiento.id"></b-icon>
                        </div>

                        <div class="precio">
                            <span>${{alojamiento.precio}} MXN</span>
                            <span> noche</span>
                        </div>
                    </b-card-text>
                    <!-- <b-button href="#" variant="primary">Go somewhere</b-button> -->
                </b-card>
            </div>
        </div>
    </div>
</template>
<script>
    import MenuDropdown from "../usuario/MenuDropdown.vue";
    import img from "../../assets/567694.jpg";
    import img2 from "../../assets/eren-mikasa-cabana.jpg";
    import img3 from "../../assets/dreamhouse.jpg";
    import img4 from "../../assets/minecraft.jpg";
    import img5 from "../../assets/peppa.jpg";
    export default {
        components: {
            MenuDropdown
        },
        data() {
            return {
                busqueda: "",
                isOpen: false,
                alojamientos: [
                    {
                        id: 1,
                        imagen: img3,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 2000
                    },
                    {
                        id: 2,
                        imagen: img4,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 4,
                        precio: 2000
                    },
                    {
                        id: 3,
                        imagen: img3,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 2,
                        precio: 2000
                    },
                    {
                        id: 4,
                        imagen: img5,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 5,
                        precio: 2000
                    },
                    {
                        id: 5,
                        imagen: img2,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 6,
                        imagen: img2,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 7,
                        imagen: img4,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 5,
                        precio: 2000
                    },
                    {
                        id: 8,
                        imagen: img2,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 9,
                        imagen: img4,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 10,
                        imagen: img4,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 11,
                        imagen: img5,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 12,
                        imagen: img5,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 13,
                        imagen: img4,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 14,
                        imagen: img5,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    },
                    {
                        id: 15,
                        imagen: img5,
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 3,
                        precio: 1200
                    }

                ]
            }
        },
        methods: {
            toggleMenu() {
                this.isOpen = !this.isOpen;
                console.log("click");
            }
        }
    }
</script>
<!-- <style>
    .container {
        display:grid;
        flex-direction: column;
        justify-content: center;
        background-color: aqua;
    }

    .buscador {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        gap: 190px;
        padding: 20px;
        margin: 0px 20px 20px 10px;
    }

    .fixed-top {
        width: 100%;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .buscador input {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 800px;
    }

    .input-container {
        position: relative;
        display: inline-block;
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
        align-items: center;
        padding: 5px;
        border-radius: 10px;
        border: #c5b8b8 solid 1px;
        gap: 10px;
    }

    .alojamientos {
        align-self: center;
        position: relative;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        margin-left: 50px;
        margin-right: 50px;
        margin-top: 250px;
    }

    .alojamiento {
        margin-bottom: 20px;
    }

    .card {
        min-width: 30rem;
        max-width: 30rem;
        min-height: 20rem;
        max-height: 20rem;
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
    }
</style> -->