import Vue from 'vue';
import VueRouter from 'vue-router';
import Registro from '../componentes/usuario/Registro.vue';
import InicioSesion from '../componentes/usuario/InicioSesion.vue';
import InicioPrincipalUsuario from '../componentes/espacios/InicioPrincipalUsuario.vue';
import Ejemplo from '../componentes/espacios/Ejemplo.vue';
import Login from '../views/Login.vue';

import SolicitudCambio from '../componentes/usuario/SolicitudCambio.vue';
import Inicio from '../components/admin/Inicio.vue';
import ListarUsuarios from '../components/admin/ListarUsuarios.vue';
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
      path: '/registro',
      name: 'Registro',
      component: Registro
    },
    {
      path: '/admin',
      component: Inicio,
      children: [
        {
          path: '/usuarios',
          name: 'ListarUsuarios',
          component: ListarUsuarios
        }
      ]
    },
    {
      path: '/user',
      component: InicioPrincipalUsuario,
      children: [
        {
          path: '/ejemplo',
          name: 'Ejemplo',
          component: Ejemplo
        },
        {
          path: '/solicitudCambio',
          name: 'SolicitudCambio',
          component: SolicitudCambio
        }
      ]
    },

  ]
})

export default router
