import Vue from 'vue'
import VueRouter from 'vue-router'
import InicioSesion from '../componentes/usuario/InicioSesion.vue';
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
    }
  ]
})

export default router
