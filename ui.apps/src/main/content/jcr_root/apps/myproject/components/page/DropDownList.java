package apps.myproject.components.page;


import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;


import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.script.Bindings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DropDownList extends WCMUsePojo{
    private Map<String,String> dropdownMap=new HashMap<>();
    public static final String PATH="/content/my-options";
    @Override
    public void activate() throws Exception {

        dropdownMap= getData();

    }

    private Map<String,String> getData(){
        Map<String,String> map =new HashMap<>();

        Resource pageResource=getResourceResolver().getResource(PATH);
        if(pageResource !=null)
        {
            Iterable<Resource> resourceChildrens=  pageResource.getChildren();
            String text="";
            String value="";
            for(Resource children : resourceChildrens)
            {
                Node node=children.adaptTo(Node.class);
                try {
                    text=node.getProperty("text").getValue().toString();
                    value=node.getProperty("value").getValue().toString();
                } catch (RepositoryException e) {
                    e.printStackTrace();
                }

                map.put(value,text);

            }

        }
        return map;
    }

    public Map<String, String> getDropdownMap() {
        return dropdownMap;
    }
}

