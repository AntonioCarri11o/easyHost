<template>
    <b-container class="bv-example-row">
        <b-row>
            <b-col>
                <div style=" padding: 10px;">
                    <b-carousel id="carousel-1" v-model="slide" :interval="4000" controls indicators
                        background="#ababab" img-width="1024" img-height="480" style="text-shadow: 1px 1px 2px #333;"
                        @sliding-start="onSlideStart" @sliding-end="onSlideEnd">
                        <b-carousel-slide caption="First slide"
                            text="Nulla vitae elit libero, a pharetra augue mollis interdum."
                            img-src="https://picsum.photos/1024/480/?image=52"></b-carousel-slide>

                        <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=54">
                        </b-carousel-slide>

                        <b-carousel-slide img-src="https://picsum.photos/1024/480/?image=58"></b-carousel-slide>

                        <b-carousel-slide>
                            <template #img>
                                <img class="d-block img-fluid w-100" width="1024" height="480"
                                    src="https://picsum.photos/1024/480/?image=55" alt="image slot">
                            </template>
                        </b-carousel-slide>

                        <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">

                        </b-carousel-slide>
                    </b-carousel>
                    <div>
                        <br>
                        <b-form-rating v-model="value" readonly show-value precision="2"
                            style="width: 180px;"></b-form-rating>
                        <br>
                        <b>Anfitrion: Ulises Delgado</b>
                        <div style="display: flex;">
                            <div style="flex: 1; padding-top: 70px;">
                                <h5>Servicios:</h5>
                                <b-list-group>
                                    <b-list-group-item>Alberca</b-list-group-item>
                                    <b-list-group-item>Vigilancia</b-list-group-item>
                                    <b-list-group-item>Roof garden</b-list-group-item>
                                    <b-list-group-item>Tv</b-list-group-item>
                                
                                
                                    <b-list-group-item>Aire acondicionado</b-list-group-item>
                                    <b-list-group-item>Lavadora</b-list-group-item>
                                    <b-list-group-item>Wifi</b-list-group-item>
                                </b-list-group>
                            </div>
                        </div>
                    </div>
                </div>
            </b-col>
            <b-col>
                <div
                    style="padding: 40px; background-color: #f8f9fa; text-align: center; display: flex; flex-direction: column; align-items: center;">
                    <b-row>
                        <b-form-timepicker placeholder="Llegada"
                            style="width: 170px; height: 55px; background-color: #28A745; margin-bottom: 10px;"
                            locale="en"></b-form-timepicker>
                        <b-form-timepicker placeholder="Salida"
                            style="width: 170px; background-color: #28A745; margin-bottom: 10px;"
                            locale="en"></b-form-timepicker>
                    </b-row>

                    <b-form-select v-model="selected" :options="options" class="mb-3" value-field="item"
                        text-field="name" disabled-field="notEnabled"
                        style="width: 150px; height: 55px; margin-bottom: 10px; border-radius: 10px"></b-form-select>
                    <b-button style="width: 170px; height: 55px; background-color: #28A745;">Reservar</b-button>
                </div>

                <br>
                <p>Descripción: Lorem ipsum, dolor sit amet consectetur adipisicing elit. Eaque debitis ex et quas nisi
                    laboriosam dolorem, deserunt modi natus aspernatur exercitationem beatae porro iusto blanditiis
                    vitae aut
                    sed magnam dolores.</p>
                    <br>
                    <br>
                <div style=" padding: 40px; background-color: #f8f9fa;">
                    <h5>Reseñas:</h5>
                    <div v-for="(review, index) in staticReviews" :key="index" style="margin-bottom: 20px;">
                        <b-row align-v="center">
                            <b-col cols="auto">
                                <b-avatar size="30" variant="succes">{{ review.userName.substring(0, 1).toUpperCase()
                                    }}</b-avatar>
                            </b-col>
                            <b-col>
                                <b-form-rating v-model="review.rating" readonly show-value precision="1"
                                    style="margin-left: 10px; width: 180px;"></b-form-rating>
                            </b-col>
                        </b-row>
                        <b-row>
                            <b-col>
                                <p style="margin-top: 10px; ">{{ review.comment.substring(0, 100) }}</p>
                                <b-button style="background-color: #28A745;"v-if="review.comment.length > 100" @click="openModal(review.comment)">Ver
                                    más</b-button>
                            </b-col>
                        </b-row>
                    </div>
                </div>
            </b-col>
        </b-row>
    </b-container>
</template>

<script>
export default {
    data() {
        return {
            slide: 0,
            sliding: null,
            value: 4,
            selected: null,
            options: [
                { item: null, name: 'Huespedes', disabled: true },
                { item: '1', name: '1' },
                { item: '2', name: '2' },
            ],
            staticReviews: [
                {
                    id: 1,
                    userName: 'Usuario1',
                    rating: 4,
                    comment: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vel fermentum est. Nulla facilisi. Vivamus auctor, justo vel fermentum lacinia, metus lectus malesuada velit, sit amet rhoncus purus ipsum vel nulla.'
                },
                {
                    id: 2,
                    userName: 'Usuario2',
                    rating: 5,
                    comment: 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.'
                },
                {
                    id: 3,
                    userName: 'Usuario3',
                    rating: 3.5,
                    comment: 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.'
                }
            ]
        };
    },
    methods: {
        onSlideStart(slide) {
            this.sliding = true
        },
        onSlideEnd(slide) {
            this.sliding = false
        },
        openModal(comment) {
            // Aquí deberías implementar la lógica para abrir el modal y mostrar el comentario completo
            console.log('Abrir modal para comentario:', comment);
        }
    }
}
</script>