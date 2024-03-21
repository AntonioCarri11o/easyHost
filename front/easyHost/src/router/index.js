import Vue from 'vue'
import VueRouter from 'vue-router'
import InicioSesion from '../componentes/usuario/InicioSesion.vue';
import Registro from '../componentes/usuario/Registro.vue';
Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/inicioSesion'
    },
    {
      path: '/inicioSesion',
      name: 'InicioSesion',
      component: InicioSesion
    },
    {
      path: '/registro',
      name: 'Registro',
      component: Registro
    }
  ]
})

export default router
