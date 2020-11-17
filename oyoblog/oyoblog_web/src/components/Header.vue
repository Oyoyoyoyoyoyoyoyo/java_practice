<template>
  <div class="m-content">
    <h3>欢迎来到Oyoyoyoyoyoyo的博客</h3>
    <!-- 头像 -->
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
    </div>
    <div>{{ user.username }}</div>
    <div class="maction">
      <span> <el-link href="/blogs">主页</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span><el-link type="success" href="/blog/add">发表博客</el-link></span>
      <el-divider direction="vertical"></el-divider>
      <span v-show="!isLogin"
        ><el-link type="primary" href="/login">登录</el-link></span
      >
      <span v-show="isLogin"
        ><el-link type="danger" @click="logout">退出</el-link></span
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  components: {},
  data() {
    return {
      user: {
        username: "请先登录",
        avatar: "",
      },
      isLogin: false,
    };
  },
  methods: {
    logout() {
      const this_ = this;
      this_.$axios
        .get("/logout", {
          headers: {
            Authorization: localStorage.getItem("token"),
          },
        })
        .then((res) => {
          // 退出后跳转到登录页面
          this_.$store.commit("REMOVE_INFO");
          this_.$router.push("/login");
        });
    },
  },
  created() {
    if (this.$store.getters.getUser.username) {
      this.user.username = this.$store.getters.getUser.username;
      this.user.avatar = require("../assets/logo.png");
      this.isLogin = true;
    }
  },
};
</script>
<style scoped>
.m-content {
  margin: 0 auto;
  max-width: 960px;
  text-align: center;
}
.maction {
  margin: 10px 0;
}
</style>
