<template>
  <div>
    <el-container>
      <el-header>
        <img class="logo" :src="logoUrl" alt="" />
      </el-header>
      <el-main>
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="ruleForm"
          label-width="100px"
          class="demo-ruleForm"
        >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')"
              >登陆</el-button
            >
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Login",
  components: {},
  data() {
    return {
      logoUrl: require("../assets/logo.png"),
      ruleForm: {
        username: "test",
        password: "123",
      },
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          {
            min: 3,
            max: 15,
            message: "长度在 3 到 15 个字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
        ],
      },
    };
  },
  methods: {
    submitForm(formName) {
      const this_ = this;
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.$axios.post("/login", this.ruleForm).then((res) => {
            // 获取token与用户信息
            const jwt = res.headers["authorization"];
            const userInfo = res.data.data;
            this_.$store.commit("SET_TOKEN", jwt);
            this_.$store.commit("SET_USERINFO", userInfo);
            //   登陆成功后进入bolgs页面
            if (res.data.code == 200) {
              this_.$router.push("/blogs");
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>
 <<style scoped>
 .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }
  
  .el-main {
    /* background-color: #E9EEF3; */
    color: #333;
    text-align: center;
    line-height: 160px;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .logo{
      height:60%;
      margin-top:10px 
  }
  .demo-ruleForm{
      max-width:500px;
      margin: 0 auto;
  }
 </style>