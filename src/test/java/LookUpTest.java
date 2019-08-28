import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.Matchers.equalTo;

class LookUpTest {
    private static final String URL_KEY = "https://dictionary.yandex.net/api/v1/dicservice.json";
    private static final String API_KEY = "dict.1.1.20190814T194542Z.2789c1a336e17666.e257f9e8c86927a36c22c305b5a5573a093321ee";

    private static final String LANG_PAIR = "en-uk";
    private static final String WORD = "unicorn";
    private static final String EXPECTED_TRANSLATION = "єдиноріг";


    @Test
    void SearchForWordInDictionary() {
        RestAssured.baseURI = URL_KEY;
        RestAssured.useRelaxedHTTPSValidation();

        given()
                .when()
                .get(String.format("%s/lookup?key=%s&lang=%s&text=%s", URL_KEY, API_KEY, LANG_PAIR, WORD))
                .then()
                .statusCode(HTTP_OK)
                .body("def[0].text", equalTo(WORD))
                .body("def[0].tr[0].text", equalTo(EXPECTED_TRANSLATION));

    }
}
