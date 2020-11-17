<template>
  <div>
    <Header></Header>
    <div class="mblog">
      <h2>
        {{ blog.title }}
      </h2>
      <el-link icon="dl-icon-edit" v-if="ownBlog">
        <router-link :to="{ name: 'BlogEdit', params: { blogId: blog.id } }"
          >编辑</router-link
        >
      </el-link>
      <el-divider></el-divider>
      <div class="markdown-body" v-html="blog.content"></div>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header";
import "github-markdown-css/github-markdown.css";
export default {
  name: "BlogDetail",
  components: { Header },
  data() {
    return {
      blog: {
        id: "",
        title: "",
        content: "",
      },
      ownBlog: false,
    };
  },
  created() {
    // 博客读取，编辑
    const blogId = this.$route.params.blogId;
    const this_ = this;
    if (blogId) {
      this.$axios.get("/blogs/" + blogId).then((res) => {
        const blog = res.data.data;
        this_.blog.id = blog.id;
        this_.blog.title = blog.title;
        this_.blog.description = blog.description;
        // 内容安装md格式解析渲染
        const MardownIt = require("markdown-it");
        const md = new MardownIt();
        const result = md.render(blog.content);
        this_.blog.content = result;
        this_.ownBlog = blog.userId === this_.$store.getter.getUser.id;
      });
    }
  },
};
</script>
<style scoped>
.mblog {
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 100%;
  min-height: 700px;
  padding: 20px 15px;
}
</style>