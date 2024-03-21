<template>
    <div class="w-100 h-100 d-flex">
        <BarraLateral></BarraLateral>
        <div class="principal">
            <div class="w-100 h-100">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<style>
.principal {
    width: 80%;
    box-sizing: border-box;
}
</style> 
<script setup>
import BarraLateral from '../compartido/barraLateral.vue';
</script>