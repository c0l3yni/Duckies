package data.product;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductProvider;
import com.tekgs.nextgen.duckies.data.product.request.ProductRequest;
import com.tekgs.nextgen.duckies.data.product.request.ProductResponse;
import com.tekgs.nextgen.duckies.data.product.request.ProductResponseCalibrator;
import com.tekgs.nextgen.duckies.data.product.request.ProductResponseExpected;
import org.softwareonpurpose.gauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.DATA, GauntletTest.Endpoint.PRODUCT})
public class ProductResponseTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        Product product = ProductProvider.getInstance().get();
        given(product);
        ProductResponseExpected expected = ProductResponseExpected.getInstance(product);
        when();
        ProductResponse actual = ProductRequest.getInstance(product).get();
        then(ProductResponseCalibrator.getInstance(expected, actual));
    }
}
