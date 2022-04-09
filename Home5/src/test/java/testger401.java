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

public class testger401 extends BaseClass{

    @Test(dataProvider = "endpoints")
    public static void return_base_url_401(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BASE_URL + endpoint);
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(get);
        int actualStatus = response.getStatusLine().getStatusCode();
        assertEquals(401, actualStatus);
    }

    @DataProvider
    private Object[][] endpoints() {
        return new Object[][]{
                {"/gists/starred"},
                {"/gists/starred/followers"},
                {"/notifications"}
        };
    }
}

