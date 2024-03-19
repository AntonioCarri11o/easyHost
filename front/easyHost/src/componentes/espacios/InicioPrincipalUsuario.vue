<template>
    <div class="container">
        <div class="buscador">
            <img src="../../assets/EasyHost.png" alt="lupa" width="60px">
            <input type="text" placeholder="Buscar espacio">
            <!-- Icono de usuario -->
            <div class="perfil"><b-icon class="h5" icon="list"></b-icon><b-icon class="h2" icon="person-circle"></b-icon></div>
        </div>

        <div class="alojamientos">
            <div class="alojamiento" v-for="alojamiento in alojamientos" :key="alojamiento.id">
                <b-card img-src="https://picsum.photos/600/300/?image=25" img-alt="Image" img-top tag="article"
                    style="max-width: 18rem;" class="mb-2">
                    <b-card-text>
                        {{alojamiento.titulo}}
                    </b-card-text>
                    <b-card-text>
                        {{alojamiento.ubicacion}}
                    </b-card-text>
                    <b-card-text>
                        <div class="calificación">
                            <span>Calificación:</span><i class="fas fa-star"></i><i class="fas fa-star"></i><i
                                class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
                        </div>
                    </b-card-text>
                    <b-card-text>
                        <div class="precio">
                            <span>${{alojamiento.precio}}</span>
                        </div>
                    </b-card-text>

                    <!-- <b-button href="#" variant="primary">Go somewhere</b-button> -->
                </b-card>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                alojamientos: [
                    {
                        id: 1,
                        imagen: "../../assets/567694.jpg",
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 6,
                        precio: 2000
                    },
                    {
                        id: 2,
                        imagen: "../../assets/567694.jpg",
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 6,
                        precio: 2000
                    },
                    {
                        id: 3,
                        imagen: "../../assets/567694.jpg",
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 6,
                        precio: 2000
                    },
                    {
                        id: 4,
                        imagen: "../../assets/567694.jpg",
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 6,
                        precio: 2000
                    },
                    {
                        id: 5,
                        imagen: "../../assets/567694.jpg",
                        titulo: "Cabaña McAllen",
                        ubicacion: "Tejas, Estados Unidos",
                        calificacion: 6,
                        precio: 2000
                    }

                ]
            }
        },
    }
</script>
<style>
    .container {
        display: grid;
        place-items: center;
        min-height: 100vh;
        min-width: 100vw;
    }

    .buscador {
        margin-top: 50px;
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        align-items: center;
        gap: 150px;
        padding: 20px;
    }

    .buscador input {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 800px;
    }

    .perfil {
        border-radius: 10px;
        border: #c5b8b8 solid 1px;
        padding: 5px;
        flex-direction: row;
        display:flex;
        align-items: center;
        justify-content: space-around;
        gap: 10px;
    }

    .perfil :hover {
        background-color: #c5b8b8;
        cursor: pointer;
    }

    .alojamientos {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
        padding-left: 50px;
        padding-right: 50px;
    }

    .alojamiento {
        margin-bottom: 20px;
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
</style>