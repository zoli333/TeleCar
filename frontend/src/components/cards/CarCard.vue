<template>
  <b-card v-if="car !== null">
    <b-card-text class="driver-text"><b>{{car.driver.fullName + ' útja'}}</b></b-card-text>
    <b-card-text class="departure-time-text">{{car.departureDateTime }}</b-card-text>
    <b-card-text class="route-text">{{formatRoutes(car.routes)}}</b-card-text>
    <b-card-body class="text-center">
      <div v-for="placeIndex in car.maxPlaces" :key="placeIndex">
        <b-row v-if="(placeIndex - 1) % maxIconsPerRow === 0">
          <template v-for="colIndex in maxIconsPerRow">
            <b-col class="car-column" v-if="((placeIndex - 1) + (colIndex - 1)) < car.maxPlaces">
              <div class="btn btn-warn" v-if="car.passengers[(placeIndex - 1 ) + (colIndex - 1)]">
                <i class="fa fa-times"></i>
              </div>
              <button class="btn btn-success" @click="subscribe(car.id)" v-else="">
                <i class="fa fa-check"></i>
              </button>
            </b-col>
          </template>
        </b-row>
      </div>
    </b-card-body>
  </b-card>
</template>

<script>

export default {
  name: 'CarCard',
  props: {
    car: {
      default: null,
      type: Object
    },
    maxIconsPerRow: {
      default: 0,
      type: Number
    },
  },
  methods: {
    subscribe: function (carId) {
      console.log(carId)
    },
    formatRoutes: function(routes) {
      let routeString = ''
      for(let i = 0; i < routes.length - 1; i++) {
        routeString += routes[i].name + ' - '
      }
      routeString += routes[routes.length - 1].name
      return routeString
    }
  }
}
</script>

<style scoped>
/* Style buttons */
.btn-warn {
  background-color: red;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}

.btn-success {
  background-color: green;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
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
