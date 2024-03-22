<template>
    <div class="h-100">
        <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark h-100" style="width: 280px;">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <span class="fs-4">Sidebar</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
      <li class="nav-item">
        <a href="#" class="nav-link active" aria-current="page">
          <b-icon icon="house"></b-icon>
          Inicio
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <b-icon icon="file-earmark-medical"></b-icon>
          Solicitudes
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <b-icon icon="emoji-angry"></b-icon>
          Quejas
        </a>
      </li>
      <li>
        <a href="#" class="nav-link text-white">
          <b-icon icon="person-circle"></b-icon>
          Usuarios
        </a>
      </li>
      <li>        
        <a href="#" class="nav-link text-white"
        @click="historialesVisibles = !historialesVisibles"
        >
            <b-icon v-if="!historialesVisibles"icon="chevron-down"></b-icon>
            <b-icon v-if="historialesVisibles"icon="chevron-up"></b-icon>
            Historiales
        </a>
        <div class="ms-4">
            <b-collapse id="collapse-1" v-model="historialesVisibles"class="mt-2">
                <ul class="nav nav-pills flex-column mb-auto">
                    <li>
                        <a href="#" class="nav-link text-white">
                            <b-icon icon="file-earmark-person"></b-icon>
                            Historial de verificación de usuario
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link text-white">
                            <b-icon icon="coin"></b-icon>
                            Historial de pagos y devoluciónes
                        </a>
                    </li>
                </ul>   
            </b-collapse>
        </div>
      </li>
    </ul>
    <hr>
    <div class="dropdown">
      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
        <strong>Perfil</strong>
      </a>
      <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1" style="">
        <li><a class="dropdown-item" href="#">New project...</a></li>
        <li><a class="dropdown-item" href="#">Settings</a></li>
        <li><a class="dropdown-item" href="#">Profile</a></li>
        <li><hr class="dropdown-divider"></li>
        <li><a class="dropdown-item" href="#">Sign out</a></li>
      </ul>
    </div>
  </div>
    </div>
</template>

<style scoped>
.barraLateral-contenedor {
    width: 20%;
    position: fixed;
    left: 0;
}
</style>
<script>
export default {
    name: "BarraLateral",
    data() {
        return {
            historialesVisibles: false,
        }
    },
    methods: {

    }
}
</script>