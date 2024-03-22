<template>
    <div class="w-100 h-100">
        <section class="shadow-sm p-3 mb-5 bg-body rounded w-100 d-flex">
            <div class="default-margen">
                <h4 class="m-2">Usuarios</h4>
            </div>
        </section>
        <section class="default-margen">
            <b-table :fields="campos" :items="usuarios">
                <template #cell(nombre)="row">
                    {{ row.item.nombre + ' ' + row.item.apellidos}}
                </template>
                <template #cell(acciones)="row">
                    <div class="w-100">
                        <b-button variant="primary" class="mt-1 me-4"><b-icon icon="info-circle"></b-icon></b-button>
                        <b-button variant="danger" class="my-1"><b-icon icon="trash"></b-icon></b-button>
                    </div>
                </template>
            </b-table>
        </section>
    </div>
</template>

<style></style>
<script>
import usuarioServicio from '../../componentes/servicio/Usuario.js';

export default{
    name: 'ListarUsuarios',
    data() {
        return {
            campos: [
                {
                    key: 'id',
                    label: '#'
                },
                {
                    key: 'nombre',
                    label: 'Nombre completo'
                },
                {
                    key: 'apellidos',
                    label: 'Apellidos'
                },
                {
                    key: 'correo',
                    label: 'Correo',                    
                },
                {
                    key: 'rol.nombre',
                    label: 'Rol'
                },
                'acciones'
            ],
            usuarios: [],
        }
    },
    methods: {
        async listarUsuarios() {
            try {
                const respuesta =  await usuarioServicio.listarUsuarios();
                this.usuarios = respuesta;
            } catch(err) {
                throw(err);
            }
        }
        
    },
    mounted() {
        this.listarUsuarios();
    }
}
</script>