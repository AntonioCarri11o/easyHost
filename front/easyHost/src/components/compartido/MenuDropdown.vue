<template>
  <div class="menu-dropdown">
    <ul>
      <li><b-icon icon="person" class="mr-2"></b-icon> Historial de reservas</li>
      <li><b-icon icon="clock-history" class="mr-2"></b-icon> Perfil</li>
      <li @click="solicitarAnfitrion"><b-icon icon="person-check-fill" class="mr-2"></b-icon> Solicitar ser anfitrión
      </li>
      <li><b-icon icon="box-arrow-left" class="mr-2"></b-icon> Cerrar sesión</li>
    </ul>
  </div>
</template>

<script>
  export default {
    methods: {
      solicitarAnfitrion() {
        this.$router.push({ name: 'SolicitudCambio' });
      }
    }
  }
</script>


<style scoped>
  .menu-dropdown {
    z-index: 1000;
    position: absolute;
    top: 100%;
    right: 0;
    background-color: #fff;
    border: 1px solid #ccc;
    border-radius: 15px;
    padding: 5px;
    box-shadow: 0 0 5px #ccc;
    height: auto;
    width: 200px;
  }

  .menu-dropdown ul {
    list-style: none;
    padding: 0;
    margin: 0;
  }

  .menu-dropdown li {
    padding: 10px;
    cursor: pointer;
  }

  .menu-dropdown li:hover {
    background-color: #f0f0f0;
  }
</style>