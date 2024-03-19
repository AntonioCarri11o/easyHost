import Vue from 'vue'
import VueRouter from 'vue-router'
import CrearEspacio from '../views/CrearEspacio.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'crear-espacio',
      component: CrearEspacio
    },
    
  ]
})

export default router
