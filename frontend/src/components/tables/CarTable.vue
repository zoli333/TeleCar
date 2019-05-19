<template>
  <div class="content">
    <!-- table -->
    <table class="table">
      <template>
        <tr v-for="rowIndex in maxRowsInTable" :key="rowIndex">
          <td v-for="colIndex in maxColsInTableRow" :key="colIndex">

            <!-- car card -->
            <car-card :car="getSingleCar(rowIndex, colIndex)" :maxIconsPerRow="4"></car-card>
          </td>
        </tr>
      </template>
    </table>

    <b-row align-h="end">
      <b-pagination align-h="end"
        v-model="currentPage"
        :total-rows="this.cars.length"
        :per-page="perPage"
        ></b-pagination>
    </b-row>
    <!-- <p class="mt-3">Current Page: {{ currentPage }}</p> -->
  </div>
</template>

<script>
import CarCard from '@/components/cards/CarCard.vue'
export default {
  name: 'CarTable',
  components: {
    CarCard
  },
  props: {
    serverEndpoint: String
  },
  data () {
    return {
      cars: {},
      car: null,
      currentPage: 1,
      perPage: 6,
      maxRowsInTable: 2,
      maxColsInTableRow: 3,
      rowTableIndices: [],
      colTableIndices: []
    }
  },
  computed: {
    start () {
      return parseInt((this.currentPage - 1) * this.perPage)
    },
    end () {
      return parseInt(this.currentPage * this.perPage)
    },
    carsOnPage() {
      let actualCars = []
      for (let i = this.start; i < this.end; i++) {
        if (this.cars[i]) {
          actualCars.push(this.cars[i])
        }
      }
      return actualCars
    }
  },
  methods: {
    getSingleCar: function (rowIndex, colIndex) {
      return this.carsOnPage[(rowIndex - 1)*this.maxColsInTableRow + (colIndex - 1)]
    },
    getCars: function () {
      this.axios.get('/cars')
        .then(function (response){
          this.cars = response.data
          console.log(this.cars)
        }.bind(this))
    }
  }
}
</script>

<style scoped>
  td {
    border: 0 !important;
  }
  .table {
    padding-left: 20px !important;
    padding-right: 20px !important;
  }
</style>
