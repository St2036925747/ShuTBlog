package self.projects.shutblog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import self.projects.shutblog.entity.BlogEntity;

import java.util.List;

@Mapper
public interface BlogMapper {
    //调用insert方法后，对blogEntity使用getBlogId可以得到插入行的自增主键——blogId
    void insert(@Param("blogEntity") BlogEntity blogEntity);
    int bindingAuthor(@Param("blogId") int blogId, @Param("userId")int userId);
    int deleteBlogById(@Param("blogId") int blogId);
    int updateWholeObject(@Param("blogEntity") BlogEntity blogEntity);
    List<BlogEntity> getAllBlogs();
    List<BlogEntity> getOnesAllBlogs(@Param("userId") int userId);

    //批量删除
    int batchDelete(List<BlogEntity> blogs);
    //单纯修改博客的可见性
    int updatePublicity();
}
