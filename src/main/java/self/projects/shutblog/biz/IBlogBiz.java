package self.projects.shutblog.biz;

import self.projects.shutblog.entity.BlogEntity;

import java.util.List;

public interface IBlogBiz {
    int newBlog(BlogEntity blogEntity);
    int deleteBlogById(int blogId);
    int updateWholeObject(BlogEntity blogEntity);
    List<BlogEntity> getAllPublicBlogs();
    List<BlogEntity> getOnesAllBlogs(int userId);
}
