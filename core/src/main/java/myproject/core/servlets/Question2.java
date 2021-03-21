package myproject.core.servlets;

import myproject.core.servlets.pojo.Blogs;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "myproject/components/Blogs",
        methods = {"GET"},
        extensions="html",
        selectors = "hello"
)

public class Question2 extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        response.setContentType("text/plain");

        //String resourcePath="/content/myproject/us/en/jcr:content/root/container/container/Blogs";
        //ResourceResolver resourceResolver =request.getResourceResolver();
        Resource resource = request.getResource();

        Iterable<Resource> resourceChildrens = resource.getChildren();
//        HashMap<String, String> hashMap=new HashMap<String,String>();
        List<Blogs> blogsList = new ArrayList<>();
        String title = "";
        String date = "";
        for (Resource children : resourceChildrens) {
            Node node = children.adaptTo(Node.class);
            try {

                title = node.getProperty("Title").getValue().toString();
                date = node.getProperty("Date").getValue().toString();
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
            blogsList.add(new Blogs(title, date));
        }
        response.getWriter().println(" Ascending order :");
        blogsList.sort(new Comparator<Blogs>() {
            @Override
            public int compare(Blogs o1, Blogs o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });



        response.getWriter().println(blogsList);
        response.getWriter().println("Descending");
        blogsList.sort(new Comparator<Blogs>() {
            @Override
            public int compare(Blogs o1, Blogs o2) {
                return -o1.getDate().compareTo(o2.getDate());
            }
        });
        response.getWriter().println(blogsList);

    }

}