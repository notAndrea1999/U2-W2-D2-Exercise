package andreademasi.services;

import andreademasi.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogList = new ArrayList<>();

    //GET authors
    public List<Blog> getAllBlogs() {
        return this.blogList;
    }

    //POST crea un nuovo blog
    public Blog save(Blog blog) {
        Random rndm = new Random();
        blog.setId(rndm.nextInt(1, 100));
        this.blogList.add(blog);
        return blog;
    }

    //GET blog by id

    public Blog findBlogById(long id) {
        Blog foundBlog = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) {
                foundBlog = blog;
            }
        }
        return foundBlog;
    }

    //PUT modifica dello specifico blog
    public Blog findByIdAndUpdate(long id, Blog blog) {
        Blog foundBlog = this.findBlogById(id);
        foundBlog.setId(id);
        foundBlog.setCategory(blog.getCategory());
        foundBlog.setTitle(blog.getTitle());
        foundBlog.setCover(blog.getCover());
        foundBlog.setContenuto(blog.getContenuto());
        foundBlog.setReadingTime(blog.getReadingTime());
        return foundBlog;
    }

    //DELETE del blog
    public void findByIdAndDelete(long id) {
        ListIterator<Blog> iterator = this.blogList.listIterator();

        while (iterator.hasNext()) {
            Blog current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
    }
}
