import Vue from 'vue'
import VueRouter from 'vue-router'
import InicioSesion from '../componentes/usuario/InicioSesion.vue';
import InicioPrincipalUsuario from '../componentes/espacios/InicioPrincipalUsuario.vue';
import Ejemplo from '../componentes/espacios/Ejemplo.vue';
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/inicioPrincipalUsuario'
    },
    {
      path: '/inicioSesion',
      name: 'InicioSesion',
      component: InicioSesion
    },
    {
      path: '/inicioPrincipalUsuario',
      name: 'InicioPrincipalUsuario',
      component: InicioPrincipalUsuario
    },
    {
      path: '/ejemplo',
      name: 'Ejemplo',
      component: Ejemplo
    },
  ]
})

export default router
