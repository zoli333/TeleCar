<template>
  <b-row class="outer-box col-md-8" align-h="center">
    <b-row class="car-information">
      <b-col class="text-right" cols="4">
        <label for="free-places">Szabad helyek száma</label>
        <label for="is-electric-car">Elektromos autó?</label>
        <label for="route-description">Útvonal leírása</label>
      </b-col>
      <b-col cols="6">
        <b-form-input v-model="maxPlaces" type="number" id="free-places"></b-form-input>
        <b-form-radio-group id="is-electric-car" v-model="isElectric" :options="options"></b-form-radio-group>
        <b-form-textarea id="route-description" v-model="description" rows=3 max-rows=6 type="text"/>
      </b-col>
    </b-row>
    <b-row class="route-information">
      <b-col cols="4" class="text-right">
        <label for="stops">Állomások</label>
      </b-col>
      <b-col cols="6" class="justify-content-center">
        <b-col>
        </b-col>
          <b-row id="stops" v-for="(station, index) in stations" :key="index">
            <b-col>
              <b-form-input v-model="station.value"></b-form-input>
              <span v-if="index !== stations.length - 1"> - </span>
            </b-col>
          </b-row>
          <b-row>
        </b-row>
        <b-button @click="addNewStation"><i class="fa fa-plus"></i></b-button>
        <b-button @click="resetToDefault"><i class="fa fa-times"></i></b-button>
      </b-col>
    </b-row>
    <b-row align-h="end">
      <b-button @click="save" variant="info">Mentés</b-button>
    </b-row>
  </b-row>
</template>

<script>
export default {
  name: 'AddCar',
  data () {
    return {
      stations: [],
      maxPlaces: null,
      isElectric: false,
      options: [
        {text: 'Igen', value: true},
        {text: 'Nem', value: false}
      ],
      description: null
    }
  },
  methods: {
    resetToDefault: function () {
      this.stations = []
      this.addNewStation()
    },
    addNewStation: function () {
      this.stations.push({value: ''})
    },
    save: function () {
      if (this.validateStations()) {
        this.axios.post('/cars/' + this.$store.getters.user.id + '/add', {
          driverId: this.$store.getters.user.id,
          maxPlaces: this.maxPlaces,
          routes: this.stations,
          routeDescription: this.description,
          isElectric: this.isElectric
        })
          .then(function (response){
            console.log(response)
          }.bind(this))
      }

    },
    validateStations: function () {
      for (let i = this.stations.length - 1; i >= 0; i--) {
        if (this.stations[i].value === '') this.stations.splice(i, 1)
      }
      if (this.stations.length < 2) {
        this.addNewStation()
        return false
      }
      return true
    }
  },
  created () {
    this.addNewStation()
  }
}
</script>

<style scoped>
.outer-box {
  width: 100%;
  margin: 0 auto;
}
.car-information {
  padding-top: 20px;
}
.car-information-labels {
  margin-bottom: 15px;
}
.route-information {
  padding-top: 40px;
}
</style>
