import com.flare.Application;
import com.flare.utils.HttpUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class HttpTest {
    @Autowired
    HttpUtils httpUtils;
    @Test
    public void httpGetTest(){
        String url ="http://www.artivr.com/cn/frame/social";
        String result = httpUtils.doGet(url,null);
        System.out.println(result);
    }
}
