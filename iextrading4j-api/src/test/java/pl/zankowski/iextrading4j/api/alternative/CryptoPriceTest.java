package pl.zankowski.iextrading4j.api.alternative;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoPriceTest {

    private final JFixture fixture = new JFixture();

    @Test
    public void constructor() {
        final BigDecimal price = fixture.create(BigDecimal.class);
        final String symbol = fixture.create(String.class);

        final CryptoPrice cryptoPrice = new CryptoPrice(price, symbol);

        assertThat(cryptoPrice.getPrice()).isEqualTo(price);
        assertThat(cryptoPrice.getSymbol()).isEqualTo(symbol);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(CryptoPrice.class)
                .usingGetClass()
                .verify();
    }

    @Test
    public void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CryptoPrice.class))
                .verify();
    }

}
