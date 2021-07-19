package self.projects.shutblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import self.projects.shutblog.biz.IBlogBiz;
import self.projects.shutblog.entity.BlogEntity;
import self.projects.shutblog.util.Result;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogBiz blogBiz;

    @RequestMapping(value = "/newBlog", method = RequestMethod.POST)
    public @ResponseBody Result newBlog(@RequestBody BlogEntity blogEntity) {
        int res = blogBiz.newBlog(blogEntity);
        if (1 == res) return Result.ok("新建博客成功");
        else return Result.error("新建博客失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/deleteBlog", method = RequestMethod.DELETE)
    public @ResponseBody Result deleteBlogById(@RequestParam int blogId) {
        int res = blogBiz.deleteBlogById(blogId);
        if (1 == res) return Result.ok("删除博客成功");
        else return Result.error("删除博客失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/updateBlog", method = RequestMethod.PUT)
    public @ResponseBody Result updateBlog(@RequestBody BlogEntity blogEntity) {
        int res = blogBiz.updateWholeObject(blogEntity);
        if (1 == res) return Result.ok("修改成功");
        else return Result.error("修改失败，请重试或者联系客服人员");
    }

    @RequestMapping(value = "/getAllBlogs", method = RequestMethod.GET)
    public @ResponseBody List<BlogEntity> getAllBlogs() {
        return blogBiz.getAllPublicBlogs();
    }

    @RequestMapping(value = "/getOnesAllBlogs", method = RequestMethod.GET)
    public @ResponseBody List<BlogEntity> getOnesAllBlogs(int userId) {
        return blogBiz.getOnesAllBlogs(userId);
    }
}
