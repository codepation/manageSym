<template>
<div class="common-layout">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">

            <el-radio-group v-model="isCollapse" style="margin-bottom: 20px">
            <el-radio-button :value="false">expand</el-radio-button>
            <el-radio-button :value="true">collapse</el-radio-button>
                </el-radio-group>

                <el-menu
                    default-active="2"
                    class="el-menu-vertical-demo"
                    :collapse="isCollapse"
                    @open="handleOpen"
                    @close="handleClose"
                >
                    <el-menu-item index="2">
                    <el-icon><icon-menu /></el-icon>
                    <template #title><router-link to="/page/1">page1</router-link></template>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                    <el-icon><document /></el-icon>
                    <template #title><router-link to="/page/2">page2</router-link></template>
                    </el-menu-item>
                    <el-menu-item index="4">
                    <el-icon><setting /></el-icon>
                    <template #title><router-link to="/page/3">page3</router-link></template>
                    </el-menu-item>
        </el-menu>
        </el-aside>
        <el-main>
             <el-button type="primary" @click="logout">logout</el-button>
             <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
  
 

</template>
<script>
import router from '../router'
  export default {
    name:'App',
    components:{

    }
  }
const  logout = ()=>{
    localStorage.removeItem('token')
    router.push('login')
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>
