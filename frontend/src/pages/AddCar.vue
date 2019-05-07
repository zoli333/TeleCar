<template>
  <div>
    <b-row class="car-information">
      <b-col class="text-right" cols="2">
        <label for="driver">Sofőr neve</label>
        <label for="free-places">Szabad helyek száma</label>
      </b-col>
      <b-col cols="4">
        <b-form-input id="driver"></b-form-input>
        <b-form-input type="number" id="free-places"></b-form-input>
      </b-col>
    </b-row>
    <b-row class="route-information">
      <b-col cols="2" class="text-right">
        <label for="stops">Állomások</label>
      </b-col>
      <b-col cols="5" class="justify-content-center">
        <b-row id="stops" v-for="index in numberOfStops" :key="index">
          <b-form-input></b-form-input><span v-if="index !== numberOfStops"> - </span>
        </b-row>
        <b-row>
          <b-button @click="incrementMinStops"><i class="fa fa-plus"></i></b-button>
          <b-button @click="resetToDefault"><i class="fa fa-times"></i></b-button>
          <b-button @click="save" variant="info" class="align-self-right">Mentés</b-button>
        </b-row>
      </b-col>
    </b-row>
  </div>
</template>

<script>
  export default {
    name: 'AddCar',
    data () {
      return {
        minStopsDefault: 4,
        minStops: null
      }
    },
    computed: {
      numberOfStops: function () {
        return this.minStops
      }
    },
    methods: {
      incrementMinStops: function () {
        this.minStops += 1;
      },
      resetToDefault: function () {
        this.minStops = this.minStopsDefault
      },
      save: function () {

      }
    },
    created: function () {
      this.minStops = this.minStopsDefault
    }
  }
</script>

<style scoped>
.car-information {
  padding-top: 20px;
}
.car-information-labels {
  margin-bottom: 15px;
}
.route-information {
  margin-top: 20px;
}
</style>
