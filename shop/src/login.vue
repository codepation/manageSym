<template>
  <div style="margin: 20px" />
  <el-form
    :label-position="labelPosition"
    label-width="auto"
    :model="formLabelAlign"
    style="max-width: 600px"
  >
    <el-form-item label="账号">
      <el-input v-model="formLabelAlign.name" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="formLabelAlign.region" />
    </el-form-item>
  </el-form>
  <el-button type="primary" @click="login">登录</el-button>
</template>
<script lang="ts" setup>
import { reactive, ref } from "vue";
import axios from 'axios'
import type { FormProps } from "element-plus";
import { useRouter } from "vue-router";
import { de } from "element-plus/es/locale";


const labelPosition = ref<FormProps["labelPosition"]>("right");

const router = useRouter()

const formLabelAlign = reactive({
  name: "",
  region: "",
});
function login(){
    axios({
        url:'http://localhost:8080/login',
        method:'get',
        params:{
            username:formLabelAlign.name,
            password:formLabelAlign.region
        }
    }).then(res => {
        console.log(res.data)
        router.push('hello')
        var userInfo = res.data
        console.log(userInfo)
        localStorage.setItem('token',userInfo)
        
    }),err =>{
        console.log(err)
    }
}

</script>