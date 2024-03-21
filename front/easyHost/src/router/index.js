import Vue from 'vue';
import VueRouter from 'vue-router';
import Registro from '../componentes/usuario/Registro.vue';
import InicioSesion from '../componentes/usuario/InicioSesion.vue';
import Inicio from '../components/admin/Inicio.vue';
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
    },
    {
      path: '/admin',
      component: Inicio,
      children: [

      ]
    }

  ]
})

export default router
