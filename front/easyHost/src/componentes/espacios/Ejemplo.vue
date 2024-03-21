<template>
    <div class="container-principal container-fluid">
        <div class="buscador fixed-top">
            <img src="../../assets/EasyHost.png" alt="lupa" width="60px">
            <b-input-group class="mb-2">
                <b-form-input class="search" type="search" v-model="busqueda"
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
        <div v-for="alojamiento in alojamientos" :key="alojamiento.id">
            <b-card :img-src="alojamiento.imagen" img-alt="Image" img-top tag="article" style="max-width: 20rem;"
                class="mb-2 cardD">
                <b-card-text>
                    {{alojamiento.titulo}} <br>
                    {{alojamiento.ubicacion}}<br>
                    <div class="calificación">
                        <span>{{alojamiento.calificacion}} </span> <b-icon icon="star-fill" variant="warning"
                            v-for="i in alojamiento.calificacion"></b-icon>
                    </div>
                    <div class="precio">
                        <span>${{alojamiento.precio}} MXN </span>
                        <span>noche</span>
                    </div>
                </b-card-text>
            </b-card>
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
                      titulo: "Dreamhouse",
                      ubicacion: "Barbieland, Estados Unidos",
                      calificacion: 5,
                      precio: 7500
                  },
                  {
                      id: 2,
                      imagen: img4,
                      titulo: "Casa lujosa",
                      ubicacion: "Minecraft, Estados Unidos",
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
                      titulo: "Casa de Peppa pig",
                      ubicacion: "Tejas, Estados Unidos",
                      calificacion: 3,
                      precio: 2000
                  },
                  {
                      id: 5,
                      imagen: img2,
                      titulo: "Cabaña de Eren y Mikasa",
                      ubicacion: "Tejas, Estados Unidos",
                      calificacion: 3,
                      precio: 1200
                  },
                  {
                      id: 6,
                      imagen: img2,
                      titulo: "Cabaña de Eren y Mikasa",
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
                  /* {
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
                  } */

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
<style>
  .container-principal {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-around;
      margin-top: 100px;
  }

</style>