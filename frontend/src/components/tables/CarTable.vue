<template>
  <div class="base-table">

    <!-- table -->
    <b-card-group deck>
      <b-card class="col-md-3 text-center" v-for="(car, index) in cars" :key="index">
        <b-card-text class="driver-text"><b>{{car.driver.fullName + ' útja'}}</b></b-card-text>
        <b-card-text class="departure-time-text">{{car.departureDateTime }}</b-card-text>
        <b-card-text class="route-text">{{formatRoutes(car.routes)}}</b-card-text>
        <b-card-body>
          <div v-for="placeIndex in car.maxPlaces" :key="placeIndex">
            <b-row v-if="(placeIndex - 1) % maxIconsPerRow === 0">
              <b-col v-for="colIndex in maxIconsPerRow" :key="colIndex">
                <div v-if="((placeIndex - 1) + (colIndex - 1)) < car.maxPlaces">
                  <div class="btn btn-warn" v-if="car.passengers[(placeIndex - 1 ) + (colIndex - 1)]">
                    <i class="fa fa-times"></i>
                  </div>
                  <div class="btn btn-success" v-else="">
                    <i class="fa fa-check"></i>
                  </div>
                </div>
              </b-col>
            </b-row>
          </div>
        </b-card-body>
      </b-card>
    </b-card-group>
  </div>
</template>

<script>

export default {
  name: 'CarTable',
  props: {
    maxIconsPerRow: {
      default: 4,
      type: Number
    },
    serverEndpoint: String
  },
  methods: {
    formatRoutes: function(routes) {
      let routeString = ''
      for(let i = 0; i < routes.length - 1; i++) {
        routeString += routes[i].name + ' - '
      }
      routeString += routes[routes.length - 1].name
      return routeString
    },
    getCars: function () {
      this.axios.get('/cars')
        .then(function (response){
          this.cars = response.data
          console.log(this.cars)
        }.bind(this))
    }
  },
  data () {
    return {
      cars: {}
    }
  }
}
</script>

<style scoped>
/* Style buttons */
.btn-warn {
  background-color: red; /* Blue background */
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 12px 16px; /* Some padding */
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
}

.btn-success {
  background-color: green; /* Blue background */
  border: none; /* Remove borders */
  color: white; /* White text */
  padding: 12px 16px; /* Some padding */
  font-size: 16px; /* Set a font size */
  cursor: pointer; /* Mouse pointer on hover */
}
.driver-text {
  margin-bottom: 0;
}
.departure-time-text {
  margin-bottom: 0;
  font-size: 15px;
}
.route-text {
  font-size: 15px;
}
</style>
