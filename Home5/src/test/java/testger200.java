import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.io.IOException;
import entities.BaseClass;

public class testger200 extends BaseClass {


    @Test(dataProvider = "endpoints")
    public static void return_base_url_200(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BASE_URL + endpoint);
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(200, actualStatus);
    }

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {"/rate_limit"},
                {"/rate_limit/followers"},
                {"/notifications"}
        };
    }
}


