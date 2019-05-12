<template>
  <div>
    <car-table ref="cartable"></car-table>
  </div>
</template>

<script>
import CarTable from '@/components/tables/CarTable.vue'

export default {
  name: 'Cars',
  components: {
    CarTable
  },
  mounted () {
    this.$refs.cartable.getCars()
  }
}
</script>
