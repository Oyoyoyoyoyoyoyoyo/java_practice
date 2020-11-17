<template>
  <div>
    <Header></Header>

    <div class="block">
      <el-timeline>
        <el-timeline-item
          :timestamp="blog.created"
          placement="top"
          v-for="blog in blogs"
          :key="index"
        >
          <el-card>
            <h4>
              <router-link
                :to="{ name: 'BlogDetail', params: { blogId: blog.id } }"
              >
                {{ blog.title }}
              </router-link>
            </h4>
            <p>{{ blog.description }}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>

      <el-pagination
        class="mpage"
        background
        layout="prev, pager, next"
        :current-page="currentPage"
        :page-size="pageSize"
        :total="total"
        @current-change="page"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Header from "../components/Header";
export default {
  name: "Blogs",
  components: {
    Header,
  },
  data() {
    return {
      blogs: {},
      currentPage: 1,
      total: 0,
      pageSize: 5,
    };
  },
  methods: {
    page(currentPage) {
      const this_ = this;
      this_.$axios.get("/blogs?currentPage=" + currentPage).then((res) => {
        console.log(res);
        this_.blogs = res.data.data.records;
        this_.currentPage = res.data.data.current;
        this_.total = res.data.data.total;
        this_.pageSize = res.data.data.size;
      });
    },
  },
  created() {
    this.page(1);
  },
};
</script>
<style scoped>
.mpage {
  margin: 0 auto;
  text-align: center;
}
</style>