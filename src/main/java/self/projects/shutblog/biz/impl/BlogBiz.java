package self.projects.shutblog.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.projects.shutblog.biz.IBlogBiz;
import self.projects.shutblog.entity.BlogEntity;
import self.projects.shutblog.mapper.BlogMapper;

import java.util.List;

@Service
public class BlogBiz implements IBlogBiz {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int newBlog(BlogEntity blogEntity) {
        try {
            blogMapper.insert(blogEntity);
            return blogMapper.bindingAuthor(blogEntity.getBlogId(), blogEntity.getUserId());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int deleteBlogById(int blogId) {
        try {
            return blogMapper.deleteBlogById(blogId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int updateWholeObject(BlogEntity blogEntity) {
        try {
            return blogMapper.updateWholeObject(blogEntity);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<BlogEntity> getAllPublicBlogs() {
        try {
            return blogMapper.getAllBlogs();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<BlogEntity> getOnesAllBlogs(int userId) {
        try {
            return blogMapper.getOnesAllBlogs(userId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
