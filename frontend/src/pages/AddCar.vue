<template>
  <div class="outer-box col-md-5" align-h="center">
    <b-row class="car-information">
      <b-col class="col-md-4 p-0">
        <label for="free-places">Szabad helyek száma</label>
      </b-col>
      <b-col class="col-md-8 pr-0">
        <b-form-input v-model="maxPlaces" @change="validateMaxPlaces" type="number" id="free-places"></b-form-input>
      </b-col>
    </b-row>
    <b-row class="car-information">
      <b-col class="col-md-4 p-0">
        <label for="departure-date">Indulás dátuma</label>
      </b-col>
      <b-col class="col-md-8 pr-0">
        <date-picker id="departure-date" class="datetimepicker" v-model="departureDate" :config="datePickerOptions"></date-picker>
      </b-col>
    </b-row>
    <b-row class="car-information">
      <b-col class="col-md-4 p-0">
        <label for="departure-time">Indulás időpontja</label>
      </b-col>
      <b-col class="col-md-8 pr-0">
        <b-form-input type="time" v-model="departureTime"></b-form-input>
      </b-col>
    </b-row>
    <b-row class="car-information">
      <b-col class="col-md-4 p-0">
        <label for="is-electric-car">Elektromos autó</label>
      </b-col>
      <b-col class="col-md-8 pr-0">
        <b-form-radio-group id="is-electric-car" v-model="isElectric" :options="options"></b-form-radio-group>
      </b-col>
    </b-row>
    <b-row class="car-information">
      <label for="route-description">Útvonal leírása</label>
      <b-form-textarea id="route-description" v-model="description" rows=3 max-rows=6 type="text"/>
    </b-row>
    <b-row class="route-information" align-h="center">
      <label for="stops">Állomások</label>
      <b-col class="route-information-column">
        <b-row id="stops" v-for="(station, index) in stations" :key="index">
          <b-col>
            <b-form-input v-model="station.value"></b-form-input>
            <span v-if="index !== stations.length - 1"> - </span>
          </b-col>
        </b-row>
        <b-button @click="addNewStation" variant="info"><i class="fa fa-plus"></i></b-button>
        <b-button @click="resetToDefault" variant="info"><i class="fa fa-times"></i></b-button>
      </b-col>
    </b-row>
    <b-row align-h="end">
      <b-button @click="save" variant="info">Mentés</b-button>
    </b-row>
  </div>
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
      description: null,
      departureDate: null,
      departureTime: null
    }
  },
  computed: {
    datePickerOptions: function () {
      return {
        format: 'YYYY. MM. DD.',
        showClear: true,
        showClose: true
      }
    }
  },
  methods: {
    validateMaxPlaces: function () {
      if (this.maxPlaces < 1) this.maxPlaces = 1
    },
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
          routes: this.stations.map(function (x) { return x.value }),
          routeDescription: this.description,
          isElectric: this.isElectric,
          departureDate: this.departureDate,
          departureTime: this.departureTime
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
.form-control {
  font-size: 20px;
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
#is-electric-car {
  padding-left: 20px;
}
#route-description {
  padding-left: 10;
  line-height: normal;
  min-height: 150px;
}
.route-information-column {
  padding-left: 35px;
  padding-right: 0;
}
label {
  margin-bottom: 0;
}
</style>
