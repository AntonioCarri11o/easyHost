import Vue from 'vue'
import VueRouter from 'vue-router'
import ReservarEspacio from '../views/CrearEspacio.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: import.meta.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'reservar-espacio',
      component: ReservarEspacio
    },
    
  ]
})

export default router
