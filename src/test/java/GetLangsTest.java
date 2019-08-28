import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.hasItems;

class GetLangsTest {
    private static final String URL_KEY = "https://dictionary.yandex.net/api/v1/dicservice.json";
    private static final String API_KEY = "dict.1.1.20190814T194542Z.2789c1a336e17666.e257f9e8c86927a36c22c305b5a5573a093321ee";

    private static final String[] EXPECTED_RESPONSE = {"be-be", "be-ru", "bg-ru", "cs-cs", "cs-en", "cs-ru", "da-en", "da-ru", "de-de", "de-en", "de-ru", "de-tr",
            "el-en", "el-ru", "en-cs", "en-da", "en-de", "en-el", "en-en", "en-es", "en-et", "en-fi", "en-fr", "en-it",
            "en-lt", "en-lv", "en-nl", "en-no", "en-pt", "en-ru", "en-sk", "en-sv", "en-tr", "en-uk", "es-en", "es-es",
            "es-ru", "et-en", "et-ru", "fi-en", "fi-ru", "fi-fi", "fr-fr", "fr-en", "fr-ru", "hu-hu", "hu-ru", "it-en",
            "it-it", "it-ru", "lt-en", "lt-lt", "lt-ru", "lv-en", "lv-ru", "mhr-ru", "mrj-ru", "nl-en", "nl-ru", "no-en",
            "no-ru", "pl-ru", "pt-en", "pt-ru", "ru-be", "ru-bg", "ru-cs", "ru-da", "ru-de", "ru-el", "ru-en", "ru-es",
            "ru-et", "ru-fi", "ru-fr", "ru-hu", "ru-it", "ru-lt", "ru-lv", "ru-mhr", "ru-mrj", "ru-nl", "ru-no", "ru-pl",
            "ru-pt", "ru-ru", "ru-sk", "ru-sv", "ru-tr", "ru-tt", "ru-uk", "sk-en", "sk-ru", "sv-en", "sv-ru", "tr-de",
            "tr-en", "tr-ru", "tt-ru", "uk-en", "uk-ru", "uk-uk"};

    @Test
    void getLangsValidRequestTest() {
        RestAssured.baseURI = URL_KEY;
        RestAssured.useRelaxedHTTPSValidation();

        given()
                .when()
                .get(String.format("%s/getLangs?key=%s", URL_KEY, API_KEY))
                .then()
                .statusCode(HTTP_OK)
                .body("$", hasItems(EXPECTED_RESPONSE));
    }

}
