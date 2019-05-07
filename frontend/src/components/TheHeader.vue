<template>
  <b-navbar class="navbar-outer" toggleable="lg" type="dark" variant="info">
    <b-navbar-brand class="navbar-list" v-for="(item, linkIndex) in items" :key="linkIndex" :to="`${item.link}`">
      <i class="icons" v-for="(icon, iconIndex) in item.icons" :key="iconIndex" :class="`${icon}`"></i>
    </b-navbar-brand>
  </b-navbar>
</template>

<script>

export default {
  name: 'TheHeader',
  data () {
    return {
      items: [
        {
          name: 'Autók',
          link: '/cars',
          icons: ['fa fa-car']
        },
        {
          name: 'Keresés',
          link: '/search',
          icons: ['fa fa-search']
        },
        {
          name: 'Hozzáad',
          link: '/add-car',
          icons: ['fa fa-plus', 'fa fa-car']
        },
      ]
    }
  }
  // mounted: function () {
  //   this.$router.push({ name: 'Cars' })
  //   this.$refs.sidebar.setActiveByName('cars')
  // }
}
</script>

<style>
.navbar-list {
  margin-left: 20px;
}
.icons {
  margin-left: 5px;
}
.navbar-outer {
  padding-left: 50px;
}
</style>
